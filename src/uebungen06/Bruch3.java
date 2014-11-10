/* TODO .6.2.1.   s.183  
 * Bruch3 & Methode_MitParameter_Bruch3, 
 * 
 * METHODE MIT PARAMETERN:		void methodenName(typ1 param1, typ2 param2 ...){...}	// auch mehrere parameter m�glich!!!
 * 						
 * 					  BSP:		void erweitern(int a, String s) {	// name des parameters (a) spielt keine rolle, wird nur innerhalb der methode verwendet
 * 										zaehler *= a;
 * 										nenner *= a;
 * 								}
 * 
 * 					AUFRUF:		b.erweitern(4, "Hallo");			// objektbezeichner.methodenname(�bergabeargument)	
 * 								
 * 								- als argument k�nnen beliebige ausdr�cke stehen, die zu einem zum parametertyp passenden ergebnis f�hren :	
 * 								=> b.erweitern(6-2, "...")
 * 								
 * bruch erweitern
 * wert beim aufruf der klasse �bergeben, mit dem z�hler & nenner erweitert werden
 */

package uebungen06;

public class Bruch3 {
	int zaehler;
	int nenner;
	// instanz-methode:
	void ausgeben(){							
		System.out.println(zaehler+"/"+nenner); 
	}
	// bruch erweitern via die parameter (int a) mit �bergebenem argument (4) vom aufruf 
	// auch mehrere Parameter m�glich bsp: void erweitern(int a, string s, double d)
	void erweitern(int a, String s){												// string s an den haaren herbeigezogen aber zum zeigen
		zaehler *= a;  // remember: (zaehler = zaehler * a)
		nenner *= a;
		System.out.println(s);
	}
}
