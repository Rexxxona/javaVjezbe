
public class Racunari extends EProizvodi {
    private String procesor;
    private String memorija;
    
    public Racunari(String opis, String sifra, double uvoznaCijena, String procesor, String memorija) {
        super(opis, sifra, uvoznaCijena);
        this.procesor = procesor;
        this.memorija = memorija;
    }
    
    // Getteri i setteri
    public String getProcesor() {
        return procesor;
    }
    
    public void setProcesor(String procesor) {
        this.procesor = procesor;
    }
    
    public String getMemorija() {
        return memorija;
    }
    
    public void setMemorija(String memorija) {
        this.memorija = memorija;
    }
    
    // Override metode za specifično računanje cijene
    @Override
    public double maloprodajnaCijena() {
        // Uvozna cijena + 5% + dodatnih 5% za računare
        return uvoznaCijena * 1.05 * 1.05;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", Procesor: " + procesor + ", Memorija: " + memorija;
    }
}