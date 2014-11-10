/* TODO .7.4.   Aufgabe 5, s.223, 
 * Klasse Bruch3 & Bruch3Anteil & ObjektdatentypAlsKlassenvariable_Bruch3AnteilTest
 * 
 * erweiterung von superklasse Bruch3: subklasse Bruch3Anteil hat konstruktor, der solange brüche erzeugen kann, 
 * bis ein gesamtanteil (hier klassenvariable: verteilt) von 1 (1/1tel) überschritten wird. dann fehlermeldung.
 * objekt (verteilt) als klassenvariable zur zustandsspeicherung des gesamtanteils bruch der verteilt ist.
 * objekte als parameter übergeben für bruch-addition/-subtraktion.
 * jeweilige brüche als string ausgebenund umrechnen auf einen (rest)anteil (vermögens)betrag  
 */

package uebungen07Aufgaben;

public class ObjektdatentypAlsKlassenvariable_Bruch3AnteilTest {
	
	public static void main(String[] args) {
		int vermoegen = 200000;		// lokale variabel (kein modifier ausser final wäre erlaubt)
		Bruch3Anteil a1 = new Bruch3Anteil(1, 4);
		Bruch3Anteil a2 = new Bruch3Anteil(1, 2);
		System.out.println("Anteil a1: " + a1.bruchString());
		System.out.println("Betrag von a1: " + vermoegen * a1.dezimalwert()); // gesamtvermögem * bruch als dezimalwert
		System.out.println("Anteil a2: " + a2.bruchString());
		System.out.println("Betrag von a2: " + vermoegen * a2.dezimalwert());
		System.out.println("verteilt: " + Bruch3Anteil.verteilt.bruchString()); // aufruf der klassenvariabel über klassenname (wäre auch über jeden anderen objektbezeichner wie z.b a1 möglich)
		System.out.println("Rest:  " + a1.getRest().bruchString());				// aufruf hier nur über ein objektbezeichner (a1) möglich,
		System.out.println("Restbetrag:  " + vermoegen * a1.getRest().dezimalwert()); 	// vermögen * rest des Bruchs in dezimalwert
		}																				// objektname.methode().methode() : no problem

}
