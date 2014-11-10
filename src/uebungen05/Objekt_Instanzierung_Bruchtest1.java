/* TODO .5.2.   s.167
 * class Objekt_Instanzierung_Bruchtest1 & Klasse_bruch
 * 
 * 	OBJEKTE: 	= ein objekt ist eine instanz/exemplar/variable, die nach dem bauplan einer klasse erstellt wird
 * 
 * 				= nach dem bauplan k�nne beliebig viele objekte/instanzen erzeugt werden
 * 
 * 				= erzeugung (s.169) nach dem schema:		Bruch b = new Bruch()
 * 
 * 											- Bruch b: 	referenzvariable b, verweist auf klasse Bruch
 * 											- new Bruch(): erst operator new & konstruktor erzeugen instanz und reservieren paltz daf�r im hauptspeicher 	
 * 				
 * 				= zugriff auf attribute (s.170) �ber die referenzvariable b kann man (w�hrend programmlaufzeit) auf des objekt zugreifen
 * 						
 * 							- die Instanz einer Klasse enth�lt die in der Klassendefinition festgelegten attribute (hier: zaehler & nenner)
 * 							- die Attribute werden �ber den objektnamen angesprochen & werte zugewiesen:		b.zaehler = 3; 
 * 							- mit den attributen kann gleich operiert werden wie mit lokalen variabeln: bsp: 	if (b.nenner != 0)
 * 					
 * 
 * in der main-methode der testklasse ObjektInstanzierung_Bruchtest1 wird Klasse_bruch als objekt instanziert
 */

package uebungen05;


public class Objekt_Instanzierung_Bruchtest1 {		// testklasse

	public static void main(String[] args) {		// main-methode macht die klasse erst als programm ausf�hrbar 
		// objektinstanzierung der class Klasse_bruch
		Klasse_Bruch b = new Klasse_Bruch();		// InstanzVariable b vom Typ Klasse_Bruch wird deklariert und via den konstruktor (new Klasse_Bruch()) erzeugt 
		b.zaehler = 3;								// �ber die instanzvariable (b.) k�nnen den attributen zaehler & nenner (von Klasse_bruch)..
		b.nenner = 4;								// .. werte zugewiesen werden (g�ltig innerhalb der ganzen klasse & solange objekt g�ltig ist)
													// = via Instanzvariable auf die klasse zugreifen
		System.out.println("Bruch b = " + b.zaehler + "/" + b.nenner);
	}
}
