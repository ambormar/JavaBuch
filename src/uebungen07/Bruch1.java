/* TODO .7.1.1.   s.202
 * statische attribute
 * Bruch1 & KlassenVariabeln_Static_StatischeAttribute_Bruch1
 * 
 * KLASSEN-VARIABLEN:	- (= statische attribute) ..geh�ren zur Klasse 
 * 
 * 						- ..sind n�tig wenn objekte einer klasse ein attribut teilen sollen, bsp:	-> ( instanz-z�hler von objekten einer klasse)
 * 																									-> static final double PI (final siehe 7.2.1.)
 * 
 * 						- ..existieren pro namen nur einmal in der klasse, unahbh�ngig von den objekten/instanzen
 * 
 * 						- modifier static  		siehe 7.1.1.	s.202																	
 * 
 * 				BSP:	class Bruch {																			class Bruch
 * 							int zaehler;						// instanzvariabeln												anzahlBrueche
 * 							int nenner;																				|
 * 							static int anzahlBrueche = 0;		// klassenvariable						Bruch a				Bruch b
 * 						}																				zaehler, nenner		zaehler, nenner
 * 																										anzahlBrueche++		anzahlBrueche++
 * 						&	anzahlBrueche++;		-> anweisung IN JEDEM KONSTRUKTOR 		
 * 													-> bei verkettung von konstruktoren beachten nur einmal den instanzz�hler zu erh�hen
 * 
 * 
 * 			Aufruf: 	- ..�ber die Klasse: 	BSP:	System.outprintln(	Bruch.anzahlBrueche	);			// klasse.klassenvariabel
 * 						
 * 						=> vor verwendung muss keine instanz der klasse erzeugt werden
 * 
 * 				
 * 
 * 
 * mit der statischen variabel anzahlBrueche werden die instanzierten objekte gez�hlt
 * die statische veriable geh�rt zur klasse Bruch1 und ist unabh�ngig von den instanzierten objekten (aufrufbar, ver�nderbar)
 */

package uebungen07;

public class Bruch1 {
	int zaehler;
	int nenner;
	// KlassenVariable die zur Klasse Bruch geh�rt & von ausserhalb auch so aufgerufen wird
	static int anzahlBrueche = 0; 
	// konstruktor
	Bruch1(int z, int n){
		zaehler = z;
		nenner = n;
		anzahlBrueche++;
	}
	void bruchAusgeben(){
		System.out.println(zaehler + "/" + nenner);
	}	
}
