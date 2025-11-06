public class Kuvari extends Zaposleni {
    private static final double FIKSNA_OSNOVICA = 1500.0;

    // Konstruktor
    public Kuvari(String id, String ime, String prezime, double plataPoSatu, int ukupanBrojSati) {
        super(id, ime, prezime, plataPoSatu, ukupanBrojSati);
    }

    // Implementacija obračuna plate za kuvara
    @Override
    public double obracunajPlatu() {
        // Formula: 1500 + 4 * ukupanBrojSati * plataPoSatu
        return FIKSNA_OSNOVICA + (4 * getUkupanBrojSati() * getPlataPoSatu());
    }
    public static double getFiksnaOsnovica() {
        return FIKSNA_OSNOVICA;
    }
    // Setter za fiksnu osnovicu nije dostupan jer je konstantna (final).



    @Override
    public String toString() {
        return "KUVAR - " + super.toString() +
               " (Fiksna osnovica: " + FIKSNA_OSNOVICA + " eura)";
    }

}
