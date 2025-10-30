
class Automobil extends Vozilo {
	private int brojVrata;
	private String tipMotora;
	
	public Automobil(String proizvodjac, int godinaProizvodnje, int kubikaza, String boja, int brojVrata,
			String tipMotora) {
		super(proizvodjac, godinaProizvodnje, kubikaza, boja);
		this.brojVrata = brojVrata;
		this.tipMotora = tipMotora;
	}
	
	// Geteri
	public int getBrojVrata() {return brojVrata;}
	public String getTipMotora() {return tipMotora;}
	
	// Seteri
	public void setBrojVrata(int brojVrata) {this.brojVrata = brojVrata;}
	public void setTipMotora(String tipMotora) {this.tipMotora = tipMotora;}
	
	public double racunajCijenuRegistracije() {
        double cijena = super.racunajCijenuRegistracije();
        
        // Ako je automobil dizel, uvecaj za 20 EUR
        if (tipMotora.equalsIgnoreCase("dizel")) {
            cijena += 20;
        }
        
        return cijena;
    }

}
