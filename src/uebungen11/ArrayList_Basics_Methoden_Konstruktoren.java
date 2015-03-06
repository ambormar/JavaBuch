/* TODO 11.2.1.   s.333 uf
 * class ArrayList_Basics_Methoden_Konstruktoren
 * 
 * 11.2.1. ARRAYLIST:		- ArrayList ist sehr verwandt mit Array 
 * 							- zur ArrayList kann man JEDERZEIT ELEMENTE HINZUFÜGEN oder WEGNEHMEN	(entscheidender unterschied zu Array)
 * 							- erzeugt wird zunächst eine leere ArrayList, ohne grössenangaben
 * 																	->	elemente werden vorzu angehängt, mit soviel speicherplatz, wie gerade nötig 
 * 							- eine ArrayList kann NUR OBJEKTE aufnehmen: 	
 * 																	=> für primitive datentypen müssen die WRAPPER-KLASSEN verwendet werden
 * 							- in einer ArrayList können NUR OBJEKTE GLEICHEN OBJEKT-TYPS gespeichert werden
 * 							- die elemente von ArrayList werden über ganzzahlige indexwerte angesprochen (indexwerte: ab 0 aufsteigend )
 * 								
 * 
 * 		3 KONSTRUKTOREN VON ARRAYLIST:		
 * 
 * 			ACHTUNG:	import nicht vergessen:		import java.util.ArrayList;
 * 
 *  		1.	ArrayList()							erzeugt leere liste, mit anfangskapazität von 10 elementen
 * 			2.	ArrayList(Collection c)				erzeugt liste, die die elemente der übergebene collection enthält
 * 			3.	ArrayList(int initialCapacity)		erzeugt leere liste, mit der als int übergebenen anfangskapazität
 * 			
 * 
 * 		ERZEUGEN BSP:	ArrayList<Double> zahlen = new ArrayList<Double>();			// objekttyp in spitzen klammern, keine grössenangaben -> konstruktorabhängig
 * 
 * 	[	AUCH MÖGL.:		ArrayList zahlen = new Arraylist()							// ohne <datentyp> -angaben in spitzen klammern gibt eclipse eine warnung aus (kein fehler): ..
 * 																					// .. datentyp ist dann nicht festgelegt und bei jedem hinzufügen eines neuen elements gibts eine warnung:
 * 																					// .. (arraylist is a raw type. references to generic type ArrayList<E> should be parameterized) s. 416	]
 * 
 * 	[	AUCH MÖGL.:		ArrayList<? extends KlasseXY> xyName = new ArrayList<? extends KlasseXY>()	// => mit Generischen datentypen:	? = wildcard, <? extends KlasseXY> = irgendein .. 
 * 																									//	..objektdatentyp, der von KlasseXY abgeleitet ist  (maja fragen)					]
 * 
 * 		SCHEMA:			konstruktor<objekttyp>  bezeichner = new konstruktor<objekttyp>();	
 * 
 * 		[AUSGABEN:		mit for-schleifen oder foreach-schleifen die bearbeiteten daten ausgeben	] * 
 * 
 * 		METHODEN AUFRUFEN ÜBER:		bezeichner.methode(parameter)					// bsp:		zahlen.add(Double.parseDouble("5"));   (keine primitiven datentypen übergeben, nur wrapper-/objekte)
 * 
 * 		METHODEN (WICHTIGE) DER KLASSE ARRAYLIST:
 * 
 * 			boolean add(object o) 				=> fügt der Liste am ende das objekt o hinzu	// boolean weil: liefert true zurück wenn er objekt hinzugefügt hat
 *
 *			void add(int index, object o)		=> fügt der Liste an der position index das objekt o als neues element hinzu
 *
 *			Object get(int index)				=> liefert das element der position index zurück
 *
 *			int indexOf(Object e)				=> liefert index des übergebenen objekts e zurück, sofern es in liste vorhanden ist 
 *													-> befindet es sich mehrfach in der liste, wird der kleinste index zurückgeliefert (= erstes element)
 *	
 *			boolean isEmpty() 					=> liefert true zurück wenn die liste leer ist
 *			
 *			Object remove(int index)		 	=> entfernt das objekt an der position index aus der liste 
 *																(& gibt entfernetes objekt zurück, wenn man danach fragt => mit System.out.print() um den befehl)
 *
 * 			Object set(int index, object e)		=> ersetzt das element an position index durch das übergebene objekt 
 * 																(& gibt ersetztes objekt zurück, wenn man danach fragt => mit System.out.print() um den befehl) 
 *
 *	 		int size(): 						=> gibt anzahl der listenelemente zurück
 *
 * 
 * 			void clear(): 						=> löscht alle elemente aus der liste
 */

package uebungen11;

import java.util.ArrayList;			// ACHTUNG import it vergessen

public class ArrayList_Basics_Methoden_Konstruktoren {
	
	public static void main(String[] args){
		// ArrayList deklarieren ohne parameter erzeugt leere liste mit anfangskapazität von 10 elementen
		ArrayList<Double> zahlen = new ArrayList<Double>();
		
		// methode: add(object o)			=> fügt der Liste am ende das objekt o hinzu
		zahlen.add(Double.parseDouble("5"));	// beachte: ...
		zahlen.add(Double.parseDouble("6"));	// ...Double.parseDouble("7"), weil arraylist nur wrapperobjekte erlaubt und keine primitiven datentypen
		zahlen.add(Double.parseDouble("7"));	
		System.out.println("objekt hinzugefügt: " + zahlen.add(Double.parseDouble("8")));	// (NB: methode liefert true zurück, wenn sie objekt hinzugefügt hat)
		//----------------------------------------------------------------------------------------
		
		// methode: add(int index, object o):	=> fügt der Liste an der position index das objekt o als neues element hinzu
		zahlen.add(0, Double.parseDouble("9"));
		//----------------------------------------------------------------------------------------
		
		// ausgeben von arrayList<Double> zahlen
		for (Double ae: zahlen){
			System.out.print(ae + "\t");
		}
		//----------------------------------------------------------------------------------------
		
		// methode:	get(int index)			=> liefert das objekt/element der position index zurück
		System.out.println("\n" + zahlen.get(2) + "  = objekt an stelle mit index 2 (= 3. objekt)");
		
		//----------------------------------------------------------------------------------------
		
		// methode:	indexOf(Object e)		=> liefert index des übergebenen objekts zurück sofern in liste vorhanden, wenn mehrfach vorhanden, dann erster index
			// hier speziell: kein eigentliches wrapper-objekt mit bezeichner vorhanden, desshalb frage ich nach Double mit wert 8
		System.out.println(zahlen.indexOf(Double.valueOf("8")) + "  = index von objekt mit dem wert 8");
		
		//----------------------------------------------------------------------------------------
		
		// methode:	isEmpty()				=> liefert true zurück wenn die liste leer ist
		System.out.println(zahlen.isEmpty() + " = antwort auf die frage, ob die liste leer ist");
		
		//----------------------------------------------------------------------------------------
		
		// methode:	remove(int index)		=> entfernt das objekt an der position index aus der liste 
		zahlen.remove(2);
		
		// ausgeben von arrayList<Double> zahlen
		for (Double ae: zahlen){
			System.out.print(ae + "\t");
		}
		System.out.println(" = liste nach entfernen von element mit index 2");
		
		//----------------------------------------------------------------------------------------
		
		// methode:	set(int index, object e) 	=> ersetzt das element an position index durch das übergebene objekt
		zahlen.set(2, Double.valueOf(19)); // mitgegebenes objekt Double ist wrapper durch autoboxing
		
		// ausgeben von arrayList<Double> zahlen
		for (Double ae: zahlen){
			System.out.print(ae + "\t");
		}
		System.out.println(" = liste nach ersetzen von element mit index 2 durch objekt mit wert 19");
		
		//----------------------------------------------------------------------------------------

		// methode:	size()			=> gibt anzahl der listenelemente zurück
		System.out.println(zahlen.size() + " = anzahl der elemente in ArrayList<Double> zahlen");
		
		//----------------------------------------------------------------------------------------
		
		// methode:	clear(): löscht alle elemente aus der liste
		zahlen.clear();
		
		// ausgeben von arrayList<Double> zahlen
		for (Double ae: zahlen){
			System.out.print(ae + "\t");
		}
		System.out.println("  = ausgabe der liste nach clear()");		
	}
}








