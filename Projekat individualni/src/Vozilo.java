public class Vozilo {
	
	// Atributi
	private String proizvodjac;
	private int godinaProizvodnje;
	private int kubikaza;
	private String boja;
	
	// Konstruktor
	public Vozilo(String proizvodjac, int godinaProizvodnje, int kubikaza, String boja) {
		this.proizvodjac = proizvodjac;
		this.godinaProizvodnje = godinaProizvodnje;
		this.kubikaza = kubikaza;
		this.boja = boja;
	}
	
	// Geteri
	public String getProizvodjac() {return proizvodjac;}
	public int getGodinaProizvodnje() {return godinaProizvodnje;}
	public int getKubikaza() {return kubikaza;}
	public String getBoja() {return boja;}
	
	// Seteri
	public void setProizvodjac(String proizvodjac) {this.proizvodjac = proizvodjac;}
	public void setGodinaProizvodnje(int godinaProizvodnje) {this.godinaProizvodnje = godinaProizvodnje;}
	public void setKubikaza(int kubikaza) {this.kubikaza = kubikaza;}
	public void setBoja(String boja) {this.boja = boja;}
	
	public double racunajCijenuRegistracije() {
	    double cijena = 100.0; // Osnovna cijena je 100 EUR
	    
	    // Dodaci na osnovnu cijenu:
	    if (godinaProizvodnje < 2010) {
	        cijena += 30;  // +30 EUR za stara vozila
	    }
	    
	    if (kubikaza > 2000) {
	        cijena += 50;  // +50 EUR za velika vozila
	    }
	    
	    return cijena;
	}
	
	// Metoda za prikaz informacija
    public void prikaziInformacije() {
        System.out.println("Proizvodjac: " + proizvodjac);
        System.out.println("Godina proizvodnje: " + godinaProizvodnje);
        System.out.println("Kubikaza: " + kubikaza + " ccm");
        System.out.println("Boja: " + boja);
    }
}