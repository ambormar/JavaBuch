/* TODO .7.4.   Aufgabe 2, s.219
 * Klasse Konto2 & GiroKonto2 & Vererbung_GiroKonto2Test
 * 
 * vererbung, konstruktoren, getter & settermethoden, 
 * mit super() im konstruktor der subklasse den zu erbenden konstruktor der superklasse aufrufen
 */

package uebungen07Aufgaben;

public class Vererbung_GiroKonto2Test {

	public static void main(String[] args) {
		GiroKonto2 gk = new GiroKonto2("0000000001", 10000.0, 1000.0);
		gk.ausgeben();
		gk.auszahlen(11000.0);
		gk.ausgeben();
		gk.einzahlen(11000.0);
		gk.auszahlen(11001.0);
		gk.ausgeben();
	}
}
