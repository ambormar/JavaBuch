/* TODO .6.4.1.   s.193
 * klasse Bruch9 & Konstruktor_MitParametern_CustomKonstruktor_Bruch9
 * 
 * KONSTRUKTOR OHNE PARAMETER:		siehe Konstruktor_Selbstdefiniert_Bruch8	s.191
 * 
 * KONSTRUKTOR MIT PARAMETERN:		- selbstdefinierter konstruktor mit parameter-übergabe		BSP:	Bruch(Parametertyp bezeichner){...}
 * 	= CUSTOM-KONSTRUKTOR				(default-(standard) konstruktor entspricht einem konstruktor mit leerer paramaetrliste BSP:  Bruch(){..}
 * 											 
 * 									- custom-konstruktor = spezieller konstruktor, mit beliebigen parametern
 * 
 * 						BSP:		public Bruch(int z, int n) {	// parameter-bezeichner beliebig: z, n müssen nur im konstruktor lokal stimmen
 * 										this.zaehler = z;			// in der klasse definierte zaehler/nenner via parameterübergabe beim aufruf auf.. 
 * 										this.nenner = n;			// .. einen erwünschten wert setzen 
 * 									}
 * 
 * 					AUFRUF:			- erfolgt aus der starterklasse (Main)
 * 
 * 						BSP:		Bruch b = new Bruch(4, 5);		// Objekt-datentyp bezeichner = new Konstruktor(wert, wert);
 * 
 * (Default-Konstruktor) & Custom-Konstruktor mit Parametern (und unterschiedlichem aufruf)
 * & überladener Custom-Konstruktor mit anderen/mehr Parametern
 * (unterschiedliche übergabe von string-elementen)
 */

package uebungen06;

public class Konstruktor_MitParametern_CustomKonstruktor_Bruch9 {

	public static void main(String[] args) {

		// aufruf default-konstruktor ohne parameter
		Bruch9 a = new Bruch9();
		a.ausgeben("a");

		// aufruf Custom-konstruktor mit Parameter
		Bruch9 b = new Bruch9(2, 3);
		b.ausgeben("b");

		// aufruf Custom-konstruktor mit anderen Parameter
		Bruch9 c = new Bruch9(4, 5);
		c.ausgeben("c");

		// aufruf überladener Custom-konstruktor mit mehr Parametern
		Bruch9 d = new Bruch9(6, 7, "d");
		d.ausgeben("");
	}
}
