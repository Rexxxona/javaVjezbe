
class Kombi extends Vozilo {
	private int kapacitetPutnika;
	
	public Kombi(String proizvodjac, int godinaProizvodnje, int kubikaza, String boja, int kapacitetPutnika) {
		super(proizvodjac, godinaProizvodnje, kubikaza, boja);
		this.kapacitetPutnika = kapacitetPutnika;
	}
	
	// Geteri
	public int getKapacitetPutnika() {return kapacitetPutnika;}
	
	// Seteri
	public void setKapacitetPutnika(int kapacitetPutnika) {this.kapacitetPutnika = kapacitetPutnika;}
	
	 public double racunajCijenuRegistracije() {
	        double cijena = super.racunajCijenuRegistracije();
	        
	        // Ako kombi ima vise od 8 putnika, uvecaj za 50 EUR
	        if (kapacitetPutnika > 8) {
	            cijena += 50;
	        }
	        
	        return cijena;
	    }

}
