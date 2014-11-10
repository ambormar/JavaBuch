/* TODO .7.1.2.   s.204
 * Bruch2 & KlassenMethoden_Static_StatischeAttribute_Bruch2
 * 
 * KLASSEN-METHODEN:	- ..(= statische methoden) gehören zur Klasse 
 * 
 * 						- ..sind nötig wenn objekte einer klasse eine methode teilen sollen, bsp:	-> static int getAnzahlBrueche() {return ..}
 * 
 * 						- ..existieren pro namen nur einmal in der klasse, existieren unahbhängig von den objekten/instanzen
 * 
 * 						- modifier static  		siehe 7.1.1.	s.202
 * 
 * 			BEACHTE:	bei verwendung statischer methoden:		- zugriff nur auf KLASSENVARIABELN
 * 																
 * 																- aufruf nur von KLASSENMETHODEN
 * 																	
 * 																- THIS nicht verwendbar weil es kein zugeordnetes objekt geben kann
 * 																
 * 
 * 				BSP:	class Bruch {																				class Bruch
 * 							int zaehler;						// instanzvariabeln									anzahlBrueche
 * 							int nenner;																				getAnzahlBrueche()
 * 							static int anzahlBrueche = 0;		// klassenvariable											|								
 * 							static int getAnzahlBrueche() {		// KLASSEN-METHODE										
 * 								return anzahlBrueche;			// returns int klassenvariabel					Bruch a				Bruch b
 * 						}																					zaehler, nenner		zaehler, nenner
 * 																											anzahlBrueche++		anzahlBrueche++
 * 
 * 
 * 			Aufruf: 	- ..über die Klasse: 	BSP:	Bruch.getAnzahlBrueche()			// klasse.klassenmethode
 * 						
 * 						=> VERWENDUNG VOR erzeugen einer instanz der klasse MÖGLICH
 * 
 *  WICHTIGES BSP:		- MAIN-METODE ist auch static:		=> unabhängigkeit von objekten wichtig für programm-start ..
															(-> .. weil noch keine objekte erzeugt worden sein können)
 * 
 * Bruch2 hier mit statischer methode getAnzahlBrueche() (zum aufruf von anzahlBrueche)
 * in KlassenMethoden_Static_StatischeAttribute_Bruch2 wir diese statische methode aufgerufen: Klassenname.methodenname()
 */

package uebungen07;

public class KlassenMethoden_Static_StatischeAttribute_Bruch2 {

	public static void main(String[] args) {
		// aufruf der klassenmethode ohne vorherige erzeugung von objekt/instanz der klasse 
		System.out.println("Anzahl Brüche: " + Bruch2.getAnzahlBrueche());				// aufruf mit Klasse.Klassenmethode

		// instanzierung von Bruch1(arg, arg) auch erst nach der verwendung der klassenmethode möglich
		Bruch2 a = new Bruch2(7, 8);
		Bruch2 b = new Bruch2(9, 10);
		Bruch2 c = new Bruch2(11, 13);
		a.bruchAusgeben();
		b.bruchAusgeben();
		c.bruchAusgeben();

		// aufruf der klassenmethode: Klassenname.methodenname
		System.out.println("Anzahl Brüche: " + Bruch2.getAnzahlBrueche());
	}
}
