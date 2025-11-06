import java.time.LocalDate;

public class ObracunPlate {
    private int mjesec;
    private int godina;
    private Zaposleni zaposleni;
    private double obracunatIznos;
    private String napomene;
    private LocalDate datumObracuna;

    // Konstruktor
    public ObracunPlate(int mjesec, int godina, Zaposleni zaposleni, double obracunatIznos, String napomene) {
        this.mjesec = mjesec;
        this.godina = godina;
        this.zaposleni = zaposleni;
        this.obracunatIznos = obracunatIznos;
        this.napomene = napomene;
        this.datumObracuna = LocalDate.now();
    }

    // Konstruktor bez napomena
    public ObracunPlate(int mjesec, int godina, Zaposleni zaposleni, double obracunatIznos) {
        this(mjesec, godina, zaposleni, obracunatIznos, "");
    }

    // Kreiranje obračuna na osnovu trenutnog stanja zaposlenog
    public static ObracunPlate kreirajObracun(int mjesec, int godina, Zaposleni zaposleni) {
        double iznos = zaposleni.obracunajPlatu();
        String napomene = "";

        if (zaposleni instanceof Konobari) {
            Konobari k = (Konobari) zaposleni;
            if (k.getPrekovremeniSati() > 0) {
                napomene = "Uračunat prekovremeni rad: " + k.getPrekovremeniSati() + " sati";
            }
        } else if (zaposleni instanceof Kuvari) {
            napomene = "Fiksna osnovica: 1500 EUR";
        } else if (zaposleni instanceof Menadzeri) {
            Menadzeri m = (Menadzeri) zaposleni;
            if (m.getBonus() > 0) {
                napomene = "Bonus: " + String.format("%.2f", m.getBonus()) + " EUR";
            }
        }

        return new ObracunPlate(mjesec, godina, zaposleni, iznos, napomene);
    }

    // Getters
    public int getMjesec() {
        return mjesec;
    }

    public int getGodina() {
        return godina;
    }

    public Zaposleni getZaposleni() {
        return zaposleni;
    }

    public double getObracunatIznos() {
        return obracunatIznos;
    }

    public String getNapomene() {
        return napomene;
    }

    public LocalDate getDatumObracuna() {
        return datumObracuna;
    }

    // Setters
    public void setMjesec(int mjesec) {
        this.mjesec = mjesec;
    }

    public void setGodina(int godina) {
        this.godina = godina;
    }

    public void setZaposleni(Zaposleni zaposleni) {
        this.zaposleni = zaposleni;
    }

    public void setObracunatIznos(double obracunatIznos) {
        this.obracunatIznos = obracunatIznos;
    }

    public void setNapomene(String napomene) {
        this.napomene = napomene;
    }

    public void setDatumObracuna(LocalDate datumObracuna) {
        this.datumObracuna = datumObracuna;
    }

    @Override
    public String toString() {
        return String.format("Obračun plata %d/%d - %s %s (ID: %s) - %.2f EUR%s",
                           mjesec, godina, zaposleni.getIme(), zaposleni.getPrezime(),
                           zaposleni.getId(), obracunatIznos,
                           napomene.isEmpty() ? "" : " | " + napomene);
    }
}
