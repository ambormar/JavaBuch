/* TODO .7.4.   Aufgabe 3, s.221 
 * Klasse Bruch1 & Methoden_ObjekteAlsParameter_AddiereSubtrahiereBrueche_Bruch1Test
 * erzeugen von objekten in methoden und objekte als parameterübergabe von methoden
 */

package uebungen07Aufgaben;

public class Methoden_ObjekteAlsParameter_AddiereSubtrahiereBrueche_Bruch1Test {
	public static void main(String[] args){
		Bruch1 a = new Bruch1(1, 2);
		Bruch1 b = new Bruch1(1, 4);	
		
		// Methode gibt Datentyp Bruch zurück und überschreibt Bruch1 a nicht, 
		// also muss eine neue Veriable/Bezeichner (hier Bruch summe) erzeugt werden um den returnwert Bruch zu speichern & weiterzuverwenden
		Bruch1 summe = a.addiereBruch(b);  	// new Bruch nicht nötig weil in der methode selber wird das neue objekt Bruch erzeugt
		summe.gekuerztAusgeben();
		
		// dasselbe mit methode subtraktion
		Bruch1 differenz = a.subtrahiereBruch(b);
		differenz.gekuerztAusgeben();
		
		// oder aufruf der methode und gleichzeitiges überschreiben von Bruch a
		a = a.subtrahiereBruch(b); // so ist der obere wert von a überschrieben
		
		// und ausgabe der methode dezimalwert
		System.out.println(a.dezimalwert());
	}
}
