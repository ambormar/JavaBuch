/* TODO .7.4.   Aufgabe 2, s.219
 * Klasse Konto2 & GiroKonto2 & Vererbung_GiroKonto2Test
 *
 * vererbung, konstruktoren, getter & settermethoden, 
 * mit super() im konstruktor der subklasse den zu erbenden konstruktor der superklasse aufrufen
 */

package uebungen07Aufgaben;

public class Konto2 {
	private String kontonummer;
	private double kontostand;
	
	public Konto2(){
		setKontonummer("");
		setKontostand(0);
	}
	
	public Konto2(String knr, double kst) {
		setKontonummer(knr);
		setKontostand(kst);
	}
	
	public double getKontostand() {
		return kontostand;
	}
	
	public String getKontonummer(){
		return kontonummer;
	}
	
	public void setKontonummer(String knr) {
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
