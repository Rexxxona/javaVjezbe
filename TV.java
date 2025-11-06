public class TV extends EProizvodi {
    private double velicinaEkrana;
    
    public TV(String opis, String sifra, double uvoznaCijena, double velicinaEkrana) {
        super(opis, sifra, uvoznaCijena);
        this.velicinaEkrana = velicinaEkrana;
    }
    
    // Getteri i setteri
    public double getVelicinaEkrana() {
        return velicinaEkrana;
    }
    
    public void setVelicinaEkrana(double velicinaEkrana) {
        this.velicinaEkrana = velicinaEkrana;
    }
    
    // Override metode za specificno racunanje cijene
    @Override
    public double maloprodajnaCijena() {
        double cijena = uvoznaCijena * 1.05; // Osnovno uvecanje od 5%
        if (velicinaEkrana > 65) {
            cijena *= 1.10; // Dodatnih 10% ako je ekran veci od 65 inca
        }
        return cijena;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", Ekran: " + velicinaEkrana + "\"";
    }
}