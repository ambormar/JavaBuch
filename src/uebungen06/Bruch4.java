/* TODO .6.2.2.   s.185  
 * Bruch4 & Methoden_ReferenzDatentypAlsParameter_Bruch4
 * 
 * METHODE M. REFERENZTYP/OBJEKT 
 * ALS PARAMETER:					void multiplizieren (Bruch m){			// rückgabetyp methodenname (REFERENZ-DATENTYP bezeichner) **
 *											zaehler *= m.zaehler;  			// m.zaehler = zaehler des übergebenen Bruchs 
 *											nenner *= m.nenner;    			// m.nenner = nenner des übergebenen Bruchs
 *  								}
 *  
 *  					AUFRUF:		[	Bruch a = new Bruch;
 *  								 	Bruch b = new Bruch; ]
 *  								=>	a.multipliziere(b)		// **
 *  
 *  								- objekt-bezeichner b (aufruf) muss nicht mit parameter-bezeichner m (methode) übereinstimmen..
 *  									-> m wird nur innerhalb der methode benutzt und ist beliebig 
 * 										-> nur der referenzdatentyp (objekt) muss stimmen bei der übergabe als parameter-/typ, 
 * 
 * 						BEACHTE:	- bei verwendung von referenzvariablen als parameter wird keine kopie des objekts erstellt,
 * 									  sondern nur eine Kopie der Referenz (-> des bezeichners)
 * 
 * 								**	=> bezeichner m ist eine kopie des bezeichners b -> zeigt auf dasselbe Objekt (im Hauptspeicher)
 * 									
 * 										-> somit wird auf das original zugegriffen
 * 										-> in der methode schreibend auf die parameter zugreifen verändert den wert des originals:
 * 												=> 	m.zaehler = 34; (methode)	verändert wert von b.zaehler
 * 										
 *									- primitive datentypen dagegen werden NICHT als referenz übergeben sondern als echte kopieen
 *										=> somit wirken sich schreibzugriffe nicht auf die aufrufargumente aus
 * 
 * referenztyp als parameter
 * Referenztyp/Objekt (Bruch4 m) beim aufruf der klasse der Methode übergeben,
 * mit dem zähler & nenner (m.zaehler / m.nenner) erweitert werden
 */

package uebungen06;

public class Bruch4 {
	int zaehler;
	int nenner;
	void ausgeben(){							
		System.out.println(zaehler+"/"+nenner); 
	}
	// bruch multiplizieren mit referenztyp/ojekt (Bruch b) als Parameter
	void multiplizieren(Bruch4 m){
		zaehler *= m.zaehler;  // m.zaehler ist zaehler des per Parameter übergebenen Bruchs 
		nenner *= m.nenner;    // m.nenner ist nenner des per Parameter-übergebenen Bruchs
	}
}
