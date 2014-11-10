package uebungen09Starterklasse;
/* TODO .9.5.3.   STARTERKLASSE, Eigenes Bsp.
 * klasse startet aus seiner eigenen main-methode heraus durch konstruktoraufruf von sich selber:
 * 
 * K&K:	= klasse mit konstruktor, mainmethode, methode und variabeldeklaration
 * 		-> konstruktoraufruf in der mainmethode
 * 		-> aufruf der methode im konstruktor
 * 		-> variabel-initialisierung in der methode
 * 		   (methode könnte init() sein, entspricht der initGui() bei den GUI-Frames)
 * 
 * (Noch überarbeiten, oben kommentieren, maja?)
 */



public class StarterKlasse {

	private double [] zahlen;							// deklaration array

	public static void main(String[] args) {		// main-methode mit ...	
		StarterKlasse al = new StarterKlasse();		// ...konstruktoren-aufruf der eigenen klasse
	}
	
	public StarterKlasse(){							// konstruktor der klasse...
		arrayAusgeben();							// ...mit methoden-aufruf
	}
	
	public void arrayAusgeben(){					// methode, könnte z.b. init() heissen, entspricht der initGui() bei den GUI-frames
		zahlen = new double[] { 1.0, 2.5, Math.PI, 5.8};	// array-initialisierung
		for (double ae: zahlen) {							// foreach-schleife für ausgabe des arrays in der console
			System.out.print(ae + "  ");					// consolen-ausgabe von ae (= kopie des arrays), alle elemente werden ausgegeben
		}													
	}
}
