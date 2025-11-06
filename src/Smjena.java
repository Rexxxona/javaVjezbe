import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Smjena {
    private LocalDate datum;
    private LocalTime pocetak;
    private LocalTime kraj;
    private TipSmjene tipSmjene;
    private List<Zaposleni> zaposleniUSmjeni;

    // Enum za tip smjene
    public enum TipSmjene {
        JUTARNJA, POPODNEVNA, NOCNA
    }

    // Konstruktor
    public Smjena(LocalDate datum, LocalTime pocetak, LocalTime kraj, TipSmjene tipSmjene) {
        this.datum = datum;
        this.pocetak = pocetak;
        this.kraj = kraj;
        this.tipSmjene = tipSmjene;
        this.zaposleniUSmjeni = new ArrayList<>();
    }

    // Dodavanje zaposlenog u smjenu
    public void dodajZaposlenog(Zaposleni zaposleni) {
        if (!zaposleniUSmjeni.contains(zaposleni)) {
            zaposleniUSmjeni.add(zaposleni);
        }
    }

    // Uklanjanje zaposlenog iz smjene
    public boolean ukloniZaposlenog(Zaposleni zaposleni) {
        return zaposleniUSmjeni.remove(zaposleni);
    }

    // Izračunavanje trajanja smjene u satima
    public double izracunajTrajanjeSmjeneUSatima() {
        int satiPocetka = pocetak.getHour();
        int minutiPocetka = pocetak.getMinute();
        int satiKraja = kraj.getHour();
        int minutiKraja = kraj.getMinute();

        // Ako je kraj smjene sutradan (noćna smjena)
        if (satiKraja < satiPocetka || (satiKraja == satiPocetka && minutiKraja < minutiPocetka)) {
            satiKraja += 24;
        }

        double pocetakUMinutima = satiPocetka * 60 + minutiPocetka;
        double krajUMinutima = satiKraja * 60 + minutiKraja;

        return (krajUMinutima - pocetakUMinutima) / 60.0;
    }

    // Getters
    public LocalDate getDatum() {
        return datum;
    }

    public LocalTime getPocetak() {
        return pocetak;
    }

    public LocalTime getKraj() {
        return kraj;
    }

    public TipSmjene getTipSmjene() {
        return tipSmjene;
    }

    public List<Zaposleni> getZaposleniUSmjeni() {
        return new ArrayList<>(zaposleniUSmjeni);
    }

    // Setters
    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public void setPocetak(LocalTime pocetak) {
        this.pocetak = pocetak;
    }

    public void setKraj(LocalTime kraj) {
        this.kraj = kraj;
    }

    public void setTipSmjene(TipSmjene tipSmjene) {
        this.tipSmjene = tipSmjene;
    }

    @Override
    public String toString() {
        return String.format("Smjena %s - %s (%s - %s) | Zaposleni: %d",
                           datum, tipSmjene, pocetak, kraj, zaposleniUSmjeni.size());
    }
}
