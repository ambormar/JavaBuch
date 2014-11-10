/* TODO .5.2.   s.167
 * class Objekt_Instanzierung_Bruchtest1 & Klasse_bruch
 * 
 * 	OBJEKTE: 	= ein objekt ist eine instanz/exemplar/variable, die nach dem bauplan einer klasse erstellt wird
 * 
 * 				= nach dem bauplan könne beliebig viele objekte/instanzen erzeugt werden
 * 
 * 				= erzeugung (s.169) nach dem schema:		Bruch b = new Bruch()
 * 
 * 											- Bruch b: 	referenzvariable b, verweist auf klasse Bruch
 * 											- new Bruch(): erst operator new & konstruktor erzeugen instanz und reservieren paltz dafür im hauptspeicher 	
 * 				
 * 				= zugriff auf attribute (s.170) über die referenzvariable b kann man (während programmlaufzeit) auf des objekt zugreifen
 * 						
 * 							- die Instanz einer Klasse enthält die in der Klassendefinition festgelegten attribute (hier: zaehler & nenner)
 * 							- die Attribute werden über den objektnamen angesprochen & werte zugewiesen:		b.zaehler = 3; 
 * 							- mit den attributen kann gleich operiert werden wie mit lokalen variabeln: bsp: 	if (b.nenner != 0)
 * 					
 * 
 * in der main-methode der testklasse ObjektInstanzierung_Bruchtest1 wird Klasse_bruch als objekt instanziert
 */

package uebungen05;


public class Objekt_Instanzierung_Bruchtest1 {		// testklasse

	public static void main(String[] args) {		// main-methode macht die klasse erst als programm ausführbar 
		// objektinstanzierung der class Klasse_bruch
		Klasse_Bruch b = new Klasse_Bruch();		// InstanzVariable b vom Typ Klasse_Bruch wird deklariert und via den konstruktor (new Klasse_Bruch()) erzeugt 
		b.zaehler = 3;								// über die instanzvariable (b.) können den attributen zaehler & nenner (von Klasse_bruch)..
		b.nenner = 4;								// .. werte zugewiesen werden (gültig innerhalb der ganzen klasse & solange objekt gültig ist)
													// = via Instanzvariable auf die klasse zugreifen
		System.out.println("Bruch b = " + b.zaehler + "/" + b.nenner);
	}
}
