import java.util.ArrayList;
import java.util.List;

public class Restoran {
    private String naziv;
    private String adresa;
    private String pib;
    private List<Zaposleni> zaposleni;

    // Konstruktor
    public Restoran(String naziv, String adresa, String pib) {
        this.naziv = naziv;
        this.adresa = adresa;
        this.pib = pib;
        this.zaposleni = new ArrayList<>();
    }

    // Dodavanje zaposlenog
    public void dodajZaposlenog(Zaposleni zaposleni) {
        this.zaposleni.add(zaposleni);
        System.out.println("Zaposleni " + zaposleni.getIme() + " " + zaposleni.getPrezime() + " je dodat u restoran.");
    }

    // Uklanjanje zaposlenog po ID-u
    public boolean ukloniZaposlenog(String id) {
        for (int i = 0; i < zaposleni.size(); i++) {
            if (zaposleni.get(i).getId().equals(id)) {
                Zaposleni uklonjen = zaposleni.remove(i);
                System.out.println("Zaposleni " + uklonjen.getIme() + " " + uklonjen.getPrezime() + " je uklonjen iz restorana.");
                return true;
            }
        }
        System.out.println("Zaposleni sa ID " + id + " nije pronađen.");
        return false;
    }

    // Pretraga zaposlenog po ID-u
    public Zaposleni pronadjiZaposlenog(String id) {
        for (Zaposleni z : zaposleni) {
            if (z.getId().equals(id)) {
                return z;
            }
        }
        return null;
    }

    // Generisanje mjesečnog obračuna plata
    public void generirajObracunPlata(int mjesec, int godina) {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("           MJESEČNI OBRAČUN PLATA - " + naziv.toUpperCase());
        System.out.println("           Mjesec: " + mjesec + "/" + godina);
        System.out.println("=".repeat(80));
        System.out.printf("%-5s %-15s %-15s %-12s %-8s %-15s %10s%n",
                         "ID", "IME", "PREZIME", "TIP", "SATI", "NAPOMENA", "PLATA (€)");
        System.out.println("-".repeat(80));

        double ukupanTrosak = 0;

        for (Zaposleni z : zaposleni) {
            String tip = "";
            String napomena = "";

            if (z instanceof Konobari) {
                tip = "KONOBAR";
                Konobari k = (Konobari) z;
                if (k.getPrekovremeniSati() > 0) {
                    napomena = "Prekov: " + k.getPrekovremeniSati() + "h";
                } else {
                    napomena = "-";
                }
            } else if (z instanceof Kuvari) {
                tip = "KUVAR";
                napomena = "Osnovica: 1500€";
            } else if (z instanceof Menadzeri) {
                tip = "MENADŽER";
                Menadzeri m = (Menadzeri) z;
                napomena = "Bonus: " + String.format("%.0f", m.getBonus()) + "€";
            } else {
                tip = "ZAPOSLENI";
                napomena = "-";
            }

            double plata = z.obracunajPlatu();
            ukupanTrosak += plata;

            System.out.printf("%-5s %-15s %-15s %-12s %-8d %-15s %10.2f%n",
                             z.getId(), z.getIme(), z.getPrezime(), tip,
                             z.getUkupanBrojSati(), napomena, plata);
        }

        System.out.println("-".repeat(80));
        System.out.printf("%-65s %10.2f%n", "UKUPAN TROŠAK PLATA:", ukupanTrosak);
        System.out.println("=".repeat(80));
    }

    // Izračunavanje ukupnog troška plata
    public double izracunajUkupanTrosakPlata() {
        double ukupno = 0;
        for (Zaposleni z : zaposleni) {
            ukupno += z.obracunajPlatu();
        }
        return ukupno;
    }

    // Getters
    public String getNaziv() {
        return naziv;
    }

    public String getAdresa() {
        return adresa;
    }

    public String getPib() {
        return pib;
    }

    public List<Zaposleni> getZaposleni() {
        return new ArrayList<>(zaposleni); // Vraćamo kopiju liste
    }

    // Setters
    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public void setPib(String pib) {
        this.pib = pib;
    }

    @Override
    public String toString() {
        return "Restoran: " + naziv + " | Adresa: " + adresa + " | PIB: " + pib +
               " | Broj zaposlenih: " + zaposleni.size();
    }
}
