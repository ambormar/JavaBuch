/* TODO .6.2.1.   s.183  
 * Bruch3 & Methode_MitParameter_Bruch3, 
 * 
 * METHODE MIT PARAMETERN:		void methodenName(typ1 param1, typ2 param2 ...){...}	// auch mehrere parameter möglich!!!
 * 						
 * 					  BSP:		void erweitern(int a, String s) {	// name des parameters (a) spielt keine rolle, wird nur innerhalb der methode verwendet
 * 										zaehler *= a;
 * 										nenner *= a;
 * 								}
 * 
 * 					AUFRUF:		b.erweitern(4, "Hallo");			// objektbezeichner.methodenname(übergabeargument)	
 * 								
 * 								- als argument können beliebige ausdrücke stehen, die zu einem zum parametertyp passenden ergebnis führen :	
 * 								=> b.erweitern(6-2, "...")
 * 								
 * bruch erweitern
 * wert beim aufruf der klasse übergeben, mit dem zähler & nenner erweitert werden
 */

package uebungen06;

public class Methode_MitParameter_Bruch3 {

	public static void main(String[] args) {
		Bruch3 b = new Bruch3();
		b.zaehler = 3;
		b.nenner = 4;
		// instanzmethode:
		b.ausgeben();
		// bruch erweitern mit übergebenem argument: hier 4 & "string-inhalt"
		b.erweitern(4, "und nach dem erweitern: ");
		// erneuter aufruf der instanzmethode
		b.ausgeben();
	}

}
