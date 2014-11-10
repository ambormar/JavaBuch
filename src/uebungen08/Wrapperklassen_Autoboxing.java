/* TODO .8.3.3.   s.242 
 * Klasse Wrapperklassen_Autoboxing
 * 
 * 		AUTOBOXING:		= Mit Wrapperklassen-/Objekten umgehen als wären es primitive Datentypen
 * 
 * 						= bzw.: in gemischten ausdrücken von primitiven Datentypen und Wrapperobjekten, beide behandeln wie die prim. datentypen
 * 
 * 				BSP:	siehe unten
 */

package uebungen08;

public class Wrapperklassen_Autoboxing {

	public static void main(String[] args) {
		int a = 5;
		Integer b = new Integer(3);
		
		// komplizierte & unnötige schreibweise:
		int x = a * b.intValue(); 	// wert von b muss gar nicht mit methode ausgelesen werden, autoboxing machts autom. im hintergrund
		System.out.println(x);
		
		// einfacher durch autoboxing 
		int y = a * b;				// wrapperobjekt-bezeichner b kann aufgerufen werden wie prim datentyp-bezeichner
		System.out.println(y);
	}

}
