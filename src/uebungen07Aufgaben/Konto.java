/* TODO .7.4.   Aufgabe 1, s.219
 * Klasse Konto & GetterSetter_Private_Konstruktoren_KontoTest
 * 
 */

package uebungen07Aufgaben;

public class Konto {
	private String kontonummer;		// private variabeln => zugriff via getter / setter
	private double kontostand;
	
	public Konto(){				// default-konstruktor mit initialisierungswerten
		setKontonummer("");
		setKontostand(0);
	}
	
	public Konto(String knr, double kst) {	// custom-konstruktor mit zwei parameterwerten
		setKontonummer(knr);
		setKontostand(kst);
	}
	
	public double getKontostand() {		// getter
		return kontostand;
	}
	
	public String getKontonummer(){		
		return kontonummer;
	}
	
	public void setKontonummer(String knr) {	// setter
		kontonummer = knr;
	}

	public void setKontostand(double kst) {
		kontostand = kst;
	}
	
	public void einzahlen(double einzahlung){
		kontostand += einzahlung;
		System.out.println("Kontonummer: " + kontonummer + "\t\t" + einzahlung + " € eingezahlt");
	}
	
	public void auszahlen(double abhebung){
		kontostand -= abhebung;
		System.out.println("Kontonummer: " + kontonummer + "\t\t" + abhebung + " € abgehoben");
	}
	
	public void ausgeben(){
		System.out.println("Kontonummer: " + getKontonummer() + "\t\tkontostand: " + getKontostand() + " €");
	}
}
