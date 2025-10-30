// Klasa Kamion nasledjuje od Vozilo
class Kamion extends Vozilo {
    private double kapacitetTereta;
    private boolean prikolica;
    
    public Kamion(String proizvodjac, int godinaProizvodnje, double kubikaza, String boja, 
                  double kapacitetTereta, boolean prikolica) {
        super(proizvodjac, godinaProizvodnje, kubikaza, boja);
        this.kapacitetTereta = kapacitetTereta;
        this.prikolica = prikolica;
    }
    
    // Getteri
    public double getKapacitetTereta() { return kapacitetTereta; }
    public boolean isPrikolica() { return prikolica; }
    
    // Setteri
    public void setKapacitetTereta(double kapacitetTereta) { this.kapacitetTereta = kapacitetTereta; }
    public void setPrikolica(boolean prikolica) { this.prikolica = prikolica; }
    
    public double racunajCijenuRegistracije() {
        double cijena = super.racunajCijenuRegistracije();
        
        // Ako kamion ima prikolicu, uvecaj za 50 EUR
        if (prikolica) {
            cijena += 50;
        }
        
        return cijena;
    }
    
    public void prikaziInformacije() {
        System.out.println("=== KAMION ===");
        super.prikaziInformacije();
        System.out.println("Kapacitet tereta: " + kapacitetTereta + " kg");
        System.out.println("Prikolica: " + (prikolica ? "DA" : "NE"));
        System.out.println("Cijena registracije: " + racunajCijenuRegistracije() + " EUR");
        System.out.println();
    }
}