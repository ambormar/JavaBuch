/* TODO .7.4.   Aufgabe 4, s.223 
 * Klasse Bruch2 & Bruch2MitSeriennummer & Vererbung_ThisSuper_StaticFinal_Bruch2MitSeriennummerTest
 * 
 * Klassenvariable: 		anzahl erstellte objekte zählen mit klassenvariabel(static) 
 * Final:					und seriennummern pro objekte vergeben mit final variabeln.
 * vererbung(subklasse): 	mit this() statt super() objekterstellung auf anderen konstruktor der gleichen klasse umleiten
 */

package uebungen07Aufgaben;

public class Bruch2MitSeriennummer extends Bruch2 {
			// statische variable: 			pro klasse, aufruf über klassenname.statischeVariableName
			//								wert veränderbar von allen objekten aus für alle objekte
	static int anzahlBrueche = 0;
	
			// normale variablen dagegen: 	Pro Objekt, aufruf über objektname.variabelName
			//								wert veränderbar pro objekt für das jeweilige objekt
	
			// final variable: 				einen fixen wert pro objekt in dem es erzeugt wurde, aufruf über objektname.finalVariableName
			//								wertzuweisung pro objekt nur einmal möglich.
	private final int seriennummer;

	// konstruktor der subklasse mit super(param., param.) zugriff auf konstruktor Bruch2 der superklasse
	Bruch2MitSeriennummer(int z, int n) {
		super(z, n);
		anzahlBrueche++;				// pro erzeugten bruch wird automatisch um 1 erhöht für die ganze klasse
		seriennummer = anzahlBrueche;	// seriennummer wird pro bruch einmal gesetzt (dann unveränderlich)
	}
	
	public Bruch2MitSeriennummer() {
		this(0, 1);			// statt super(): this verweist auf dieses objekt, bzw. den konstruktor dieses objekts mit 2 parametern
	}						// => erspart das erneute schreiben der anweisungen (anzahlBrueche++, seriennumer) => keine redundanz
	
	Bruch2MitSeriennummer(int z) {
		this(z, 1);			// statt super(): this verweist auf dieses objekt, bzw. den konstruktor dieses objekts mit 2 parametern
	}						// => erspart das erneute schreiben der anweisungen (anzahlBrueche++, seriennumer) => keine redundanz
	
	public int getSeriennummer() {
		return seriennummer;
	}
	
	// statische methode / klassenmethode zur abfrage der anzahl brüche
	public static int getAnzahlBrueche() {
		return anzahlBrueche;
	}
}
