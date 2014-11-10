/* TODO .7.1.1.   s.202
 * statische attribute
 * Bruch1 & KlassenVariabeln_Static_StatischeAttribute_Bruch1
 * 
 * KLASSEN-VARIABLEN:	- (= statische attribute) ..gehören zur Klasse 
 * 
 * 						- ..sind nötig wenn objekte einer klasse ein attribut teilen sollen, bsp:	-> ( instanz-zähler von objekten einer klasse)
 * 																									-> static final double PI (final siehe 7.2.1.)
 * 
 * 						- ..existieren pro namen nur einmal in der klasse, unahbhängig von den objekten/instanzen
 * 
 * 						- modifier static  		siehe 7.1.1.	s.202																	
 * 
 * 				BSP:	class Bruch {																			class Bruch
 * 							int zaehler;						// instanzvariabeln								anzahlBrueche
 * 							int nenner;																				|
 * 							static int anzahlBrueche = 0;		// klassenvariable						Bruch a				Bruch b
 * 						}																				zaehler, nenner		zaehler, nenner
 * 																										anzahlBrueche++		anzahlBrueche++
 * 
 * 						&	anzahlBrueche++;		-> anweisung IN JEDEM KONSTRUKTOR 		
 * 													-> bei verkettung von konstruktoren beachten nur einmal den instanzzähler zu erhöhen
 * 
 * 
 * 			Aufruf: 	- ..über die Klasse: 	BSP:	System.outprintln(	Bruch.anzahlBrueche	);			// klasse.klassenvariabel
 * 						
 * 						=> vor verwendung muss keine instanz der klasse erzeugt werden
 * 
 
 * mit der statischen variabel anzahlBrueche werden die instanzierten objekte gezählt
 * die statische veriable gehört zur klasse Bruch1 und ist unabhängig von den instanzierten objekten (aufrufbar, veränderbar)
 */

package uebungen07;

public class KlassenVariabeln_Static_StatischeAttribute_Bruch1 {

	public static void main(String[] args) {
		// aufruf der statischen variablen ohne erzeugung irgend eines objekts/instanz der klasse 
		System.out.println("Anzahl Brüche: " + Bruch1.anzahlBrueche);
		
		// instanzierung von Bruch1(arg, arg)
		Bruch1 a = new Bruch1(1,2);
		Bruch1 b = new Bruch1(3,4);
		Bruch1 c = new Bruch1(4,5);
		a.bruchAusgeben();
		b.bruchAusgeben();
		c.bruchAusgeben();
		
		// aufruf der statischen variablen: Klassenname.variablenname
		System.out.println("Anzahl Brüche: " + Bruch1.anzahlBrueche);
	}
}
