// Osnovna klasa za sve proizvode (konkretna klasa)
public class EProizvodi {
    protected String opis;
    protected String sifra;
    protected double uvoznaCijena;
    
    // Konstruktor
    public EProizvodi(String opis, String sifra, double uvoznaCijena) {
        this.opis = opis;
        this.sifra = sifra;
        this.uvoznaCijena = uvoznaCijena;
    }
    
    // Getteri i setteri
    public String getOpis() {
        return opis;
    }
    
    public void setOpis(String opis) {
        this.opis = opis;
    }
    
    public String getSifra() {
        return sifra;
    }
    
    public void setSifra(String sifra) {
        this.sifra = sifra;
    }
    
    public double getUvoznaCijena() {
        return uvoznaCijena;
    }
    
    public void setUvoznaCijena(double uvoznaCijena) {
        this.uvoznaCijena = uvoznaCijena;
    }
    
    // Konkretna metoda za računanje maloprodajne cijene (osnovna)
    public double maloprodajnaCijena() {
        return uvoznaCijena * 1.05; // Samo osnovnih 5%
    }
    
    @Override
    public String toString() {
        return "Opis: " + opis + ", Šifra: " + sifra + ", Uvozna cijena: " + uvoznaCijena + ", Maloprodajna cijena: " + String.format("%.2f", maloprodajnaCijena());
    }
}