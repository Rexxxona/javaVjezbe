public class Menadzeri extends Zaposleni{
    private static double FIKSNA_OSNOVICA = 1300.0;
    private double bonus;

    // Konstruktor
    public Menadzeri(String id, String ime, String prezime, double plataPoSatu, int ukupanBrojSati, double bonus) {
        super(id, ime, prezime, plataPoSatu, ukupanBrojSati);
        this.bonus = bonus;
    }

    // Implementacija obračuna plate za menadžera
    @Override
    public double obracunajPlatu() {
        return FIKSNA_OSNOVICA + (4 * getUkupanBrojSati() * getPlataPoSatu()) + bonus;
    }
    // Getter za bonus
    public double getBonus() {
        return bonus;
    }
    // Setter za bonus (može se menjati tokom vremena)
    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
    public static double getFiksnaOsnovica() {
        return FIKSNA_OSNOVICA;
    }
    @Override
    public String toString() {
        return "MENADŽER - " + super.toString() + " (Fiksna osnovica: " + FIKSNA_OSNOVICA + " eura, Bonus: " + bonus + " eura)";
    }
}
