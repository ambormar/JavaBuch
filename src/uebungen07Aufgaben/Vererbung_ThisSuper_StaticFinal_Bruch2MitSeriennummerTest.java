/* TODO .7.4.   Aufgabe 4, s.223 
 * Klasse Bruch2 & Bruch2MitSeriennummer & Vererbung_ThisSuper_StaticFinal_Bruch2MitSeriennummerTest
 * 
 * Klassenvariable: 		anzahl erstellte objekte zählen mit klassenvariabel(static) 
 * Final:					seriennummern pro objekte vergeben mit final variabeln.
 * vererbung(subklasse): 	mit this() statt super() objekterstellung auf anderen konstruktor der gleichen klasse umleiten
 */

package uebungen07Aufgaben;

public class Vererbung_ThisSuper_StaticFinal_Bruch2MitSeriennummerTest {

	public static void main(String[] args) {
		Bruch2MitSeriennummer a = new Bruch2MitSeriennummer(1, 2);
		Bruch2MitSeriennummer b = new Bruch2MitSeriennummer(2, 3);
		Bruch2MitSeriennummer c = new Bruch2MitSeriennummer(3, 4);
		Bruch2MitSeriennummer d = new Bruch2MitSeriennummer(4, 5);
		Bruch2MitSeriennummer e = new Bruch2MitSeriennummer(5, 6);
		// aufruf der final variabel mit objektbezeichner.methode
		System.out.println(	"Bruch a: " + a.bruchString() + ", Seriennummer: " + a.getSeriennummer() +
							"\nBruch b: " + b.bruchString() + ", Seriennummer: " + b.getSeriennummer() +
							"\nBruch c: " + c.bruchString() + ", Seriennummer: " + c.getSeriennummer() +
							"\nBruch d: " + d.bruchString() + ", Seriennummer: " + d.getSeriennummer() +
							"\nBruch e: " + e.bruchString() + ", Seriennummer: " + e.getSeriennummer());
		// aufruf der klassenvariabel mit klassenname.staticVariabelname
		System.out.println("Anzahl Brueche total: " + Bruch2MitSeriennummer.getAnzahlBrueche());
	}

}
