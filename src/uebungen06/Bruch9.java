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
 * 						BSP:		public bruch(int z, int n) {	// parameter-bezeichner beliebig: z, n müssen nur im konstruktor lokal stimmen
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

public class Bruch9 {
	int zaehler;
	int nenner;
	String text = "Wert von ";

	// wenn der parameterlose defaultkonstruktor nicht mehr verfügbar ist, weil ein eigener konstruktor definiert 
	// wurde, braucht es einen parameterlosen konstruktor der die attribute initialisiert
	Bruch9(){
		zaehler = 0;
		nenner = 1;
		text += "Default-Konstruktor, Instanz ";
	}
	// Custom-Konstruktor = konstruktor mit Pparametern
	// mehrere konstruktoren mit unterschiedlichen Parameterlisten parallel möglich (wie bei methoden)
	Bruch9(int z, int n){
		zaehler = z;
		nenner = n;
		text += "Custom-Konstruktor, Instanz ";
	}
	// überladen von CustomKonstruktor (= gleicher konstruktorname mit anderer Parameterliste) -> siehe Methoden_UeberladenVonMethoden_Bruch5 
	Bruch9(int z, int n, String str){
		zaehler = z;
		nenner = n;
		text += "Überladener Custom-Konstruktor, Instanz " + str;
	}
	void ausgeben(String s){
		text += s + ": ";
		System.out.println(text + (double)zaehler/(double)nenner );
	}
}
