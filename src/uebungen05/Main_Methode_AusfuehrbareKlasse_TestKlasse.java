/* TODO .5.1.3.   s.166
 * class Main_Methode_Ausf�hrbareKlasse & Klasse_Bruch
 * 
 * - MAIN-METHODE:		= startpunkt eines jeden programms, via welches dann andere klassen aufgerufen werden k�nnen
 * 
 * 						= macht eine klasse zu einem ausf�hrbaren programm
 * 
 * 						= atomatisch generieren beim erstellen einer klasse in den method stubs (anh�keln)
 * 
 * - TESTKLASSE: 		= klasse (mit main-methode) um eine andere klasse auszuf�hren / zu testen
 * 
 * testklasse (Main_Methode_AusfuehrbareKlasse) startet mit main-methode das programm und ruft klasse (Klasse_Bruch) auf um Objekt 
 * der klasse zu instanzieren
 */

package uebungen05;


public class Main_Methode_AusfuehrbareKlasse_TestKlasse {		// testklasse mit main-methode damit die klasse ausf�hrbar wird

	public static void main(String[] args) {		// Main-methode = startpunkt eines jeden programms, via welches dann andere klassen aufgerufen werden k�nnen
		Klasse_Bruch b = new Klasse_Bruch();		// aufruf des konstruktors der class Klasse_Bruch
		b.zaehler = 3;
		b.nenner = 4;
		System.out.println("Bruch b = " + b.zaehler + "/" + b.nenner);
	}
}