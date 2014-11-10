/* TODO 11.1.4.   s.331 
 * class Arrays_MethodenDerKlasse
 * 
 * METHODEN DER KLASSE ARRAYS:		 	
 * 
 * 		IMPORT:			java.util.Arrays						// import nicht vergessen,		package java.util beinhaltet die klasse Arrays
 * 
 * !!!	AUFRUF ÜBER:	Arrays.methode(arrayname)				// die methoden der klasse Arrays funktionieren über Klasssenname.methode(arrayname)	!!!
 * 
 * 		SCHEMA:			double [] arrayname = new double[]{2.5, 3.4, Math.PI, 90};			// neuen array erzeugen
 * 
 * 						Arrays.methode(arrayname);				// via klassenname die gewünschte methode aufrufen & auf den zu bearbeitenden array (in klammern) anwenden
 * 
 * 		[AUSGABEN:		mit for-schleife oder foreach-schleife die bearbeiteten daten ausgeben	]
 * 
 * 		BSPE:			siehe code unten
 * 
 * 		STATISCHE METHODEN:		
 * 
 * 				static void fill(Type[] a, Typ w)						=> weist allen elementen des arrays a den wert w zu
 * 
 * 				static void fill(Type[] a, int von, int bis, Typ w)		=> weist allen elementen des array a, ab index von, bis index bis-1, den wert w zu 
 * 			
 * 				static void sort(Typ[] a)								=> sortiert die werte des arrays a in aufsteigender reihenfolge (alle prim. datentypen ausser boolean) 
 * 
 * 				static void binarySearch (Typ[] a, Typ w)				=> sofern array sortiert ist:	durchsucht das array a nach wert w, 
 * 																			liefert bei erfolg den index des wertes w zurück, bei nicht erfolg: -1 
 */

package uebungen11;

import java.util.Arrays;			// import NICHT vergessen

public class Arrays_MethodenDerKlasse {

	public static void main(String[] args) {
		
		// hier array-literale als voraussetzung, sonst auch beliebiger array mit beliebigen elementen / werten
		double [] bspArray = new double[]{2.5, 3.4, Math.PI, 90};		
		
		for (double ae: bspArray) {			// ausgabe von double[] bsp
			System.out.print(ae + "  "); 
		}
		System.out.println(""); 		// leerzeile
		//-----------------------------------------------------------------------------
		
		
		// methode sort(Typ[] a)	=> sortiert die werte des arrays a in aufsteigender reihenfolge (alle prim. datentypen ausser boolean) 
					// : aufruf durch Klasse.methode(arrayname)	
		Arrays.sort(bspArray);					// resultat siehe ausgabe console

		for (double ae: bspArray) {				// ausgabe von double[]
			System.out.print(ae + "  "); 
		}
		System.out.println(""); 			// leerzeile
		//------------------------------------------------------------------------------
		
		
		// methode binarySearch (Typ[] a, Typ w)	=> sofern array sortiert ist:	durchsucht das array a nach wert w, 
															//	=> liefert bei erfolg den index des wertes w zurück, bei nicht erfolg: -1 
					//: aufruf durch Klasse.methode(..)		
		System.out.println("Index des array-elements mit gesuchtem Wert: " +
				Arrays.binarySearch(bspArray, 90)); 				// resultat siehe ausgabe console
		//------------------------------------------------------------------------------
		
		
		// methode fill(Type[] a, Typ w)	=> weist allen elementen des arrays a den wert w zu		
					// : aufruf durch Klasse.methode(..)	
		Arrays.fill(bspArray, 0); 				// resultat siehe ausgabe console
		
		for (double ae: bspArray) {				// ausgabe von double[]
			System.out.print(ae + "  "); 
		}
		System.out.println(""); 			// leerzeile
		//------------------------------------------------------------------------------
		
		
		// methode fill(Type[] a, int von, int bis, Typ w)		=> weist allen elementen des array a, ab index von, bis index bis-1, den wert w zu
					// : aufruf durch Klasse.methode(..)	 		
		Arrays.fill(bspArray, 1, 3, 1.0); 		// resultat siehe ausgabe console

		for (double ae: bspArray) {				// ausgabe von double[]
			System.out.print(ae + "  "); 
		}
		System.out.println(""); 			// leerzeile

	}
}
