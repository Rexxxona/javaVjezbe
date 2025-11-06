public class Konobari extends Zaposleni {
    private int prekovremeniSati;

    // Konstruktor
    public Konobari(String id, String ime, String prezime, double plataPoSatu, int ukupanBrojSati, int prekovremeniSati) {
        super(id, ime, prezime, plataPoSatu, ukupanBrojSati);
        this.prekovremeniSati = prekovremeniSati;
    }

    // Implementacija obračuna plate za konobara
    @Override
    public double obracunajPlatu() {
        double osnovnaPlata = 4 * getUkupanBrojSati() * getPlataPoSatu();
        double prekovremenaPlata = 4 * prekovremeniSati * getPlataPoSatu() * 1.2;
        return osnovnaPlata + prekovremenaPlata;
    }

    public int getPrekovremeniSati() {
        return prekovremeniSati;
    }

    public void setPrekovremeniSati(int prekovremeniSati) {
        this.prekovremeniSati = prekovremeniSati;
    }

    @Override
    public String toString() {
        return "KONOBAR - " + super.toString() + " (Prekovremeni sati: " + prekovremeniSati + ")";
    }

}
