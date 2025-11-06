
public class Telefoni extends EProizvodi {
    private String operativniSistem;
    private double velicinaEkrana;
    
    public Telefoni(String opis, String sifra, double uvoznaCijena, String operativniSistem, double velicinaEkrana) {
        super(opis, sifra, uvoznaCijena);
        this.operativniSistem = operativniSistem;
        this.velicinaEkrana = velicinaEkrana;
    }
    
    // Getteri i setteri
    public String getOperativniSistem() {
        return operativniSistem;
    }
    
    public void setOperativniSistem(String operativniSistem) {
        this.operativniSistem = operativniSistem;
    }
    
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
        if (velicinaEkrana > 6) {
            cijena *= 1.03; // Dodatnih 3% ako je ekran veći od 6 inca
        }
        return cijena;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", OS: " + operativniSistem + ", Ekran: " + velicinaEkrana + "\"";
    }
}