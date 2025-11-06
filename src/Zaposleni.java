public class Zaposleni {
    private String id;
    private String ime;
    private String prezime;
    private double plataPoSatu;
    private int ukupanBrojSati;

    //Konstruktor
    public Zaposleni(String id, String ime, String prezime, double plataPoSatu, int ukupanBrojSati) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.plataPoSatu = plataPoSatu;
        this.ukupanBrojSati = ukupanBrojSati;
    }

    // Racunanje plate
    public double obracunajPlatu() {
        return 4 * ukupanBrojSati * plataPoSatu;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public double getPlataPoSatu() {
        return plataPoSatu;
    }

    public void setPlataPoSatu(double plataPoSatu) {
        this.plataPoSatu = plataPoSatu;
    }

    public int getUkupanBrojSati() {
        return ukupanBrojSati;
    }

    public void setUkupanBrojSati(int ukupanBrojSati) {
        this.ukupanBrojSati = ukupanBrojSati;
    }

    @Override
    public String toString() {
        return ime + " " + prezime + " (ID: " + id + ") - Mjesečna plata: " + String.format("%.2f", obracunajPlatu()) + " eura";
    }

}
