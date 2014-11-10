/* TODO .5.1.3.   s.166
 * class Main_Methode_AusführbareKlasse & Klasse_Bruch
 * 
 * - MAIN-METHODE:		= startpunkt eines jeden programms, via welches dann andere klassen aufgerufen werden können
 * 
 * 						= macht eine klasse zu einem ausführbaren programm
 * 
 * 						= atomatisch generieren beim erstellen einer klasse in den method stubs (anhäkeln)
 * 
 * - TESTKLASSE: 		= klasse (mit main-methode) um eine andere klasse auszuführen / zu testen
 * 
 * testklasse (Main_Methode_AusfuehrbareKlasse) startet mit main-methode das programm und ruft klasse (Klasse_Bruch) auf um Objekt 
 * der klasse zu instanzieren
 */

package uebungen05;


public class Main_Methode_AusfuehrbareKlasse_TestKlasse {		// testklasse mit main-methode damit die klasse ausführbar wird

	public static void main(String[] args) {		// Main-methode = startpunkt eines jeden programms, via welches dann andere klassen aufgerufen werden können
		Klasse_Bruch b = new Klasse_Bruch();		// aufruf des konstruktors der class Klasse_Bruch
		b.zaehler = 3;
		b.nenner = 4;
		System.out.println("Bruch b = " + b.zaehler + "/" + b.nenner);
	}
}