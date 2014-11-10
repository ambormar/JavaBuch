/* TODO .7.4.   Aufgabe 5, s.223, 
 * Klasse Bruch3 & Bruch3Anteil & ObjektdatentypAlsKlassenvariable_Bruch3AnteilTest
 * 
 * erweiterung von superklasse Bruch3: subklasse Bruch3Anteil hat konstruktor, der solange br�che erzeugen kann, 
 * bis ein gesamtanteil (hier klassenvariable: verteilt) von 1 (1/1tel) �berschritten wird. dann fehlermeldung.
 * objekt (verteilt) als klassenvariable zur zustandsspeicherung des gesamtanteils bruch der verteilt ist.
 * objekte als parameter �bergeben f�r bruch-addition/-subtraktion.
 * jeweilige br�che als string ausgebenund umrechnen auf einen (rest)anteil (verm�gens)betrag  
 */

package uebungen07Aufgaben;

public class ObjektdatentypAlsKlassenvariable_Bruch3AnteilTest {
	
	public static void main(String[] args) {
		int vermoegen = 200000;		// lokale variabel (kein modifier ausser final w�re erlaubt)
		Bruch3Anteil a1 = new Bruch3Anteil(1, 4);
		Bruch3Anteil a2 = new Bruch3Anteil(1, 2);
		System.out.println("Anteil a1: " + a1.bruchString());
		System.out.println("Betrag von a1: " + vermoegen * a1.dezimalwert()); // gesamtverm�gem * bruch als dezimalwert
		System.out.println("Anteil a2: " + a2.bruchString());
		System.out.println("Betrag von a2: " + vermoegen * a2.dezimalwert());
		System.out.println("verteilt: " + Bruch3Anteil.verteilt.bruchString()); // aufruf der klassenvariabel �ber klassenname (w�re auch �ber jeden anderen objektbezeichner wie z.b a1 m�glich)
		System.out.println("Rest:  " + a1.getRest().bruchString());				// aufruf hier nur �ber ein objektbezeichner (a1) m�glich,
		System.out.println("Restbetrag:  " + vermoegen * a1.getRest().dezimalwert()); 	// verm�gen * rest des Bruchs in dezimalwert
		}																				// objektname.methode().methode() : no problem

}
