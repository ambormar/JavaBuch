/* TODO .6.3.1.   s.189
 * Bruch7 & Returns_Methode_MitErgebnissrueckgabe_MehrereReturns_Bruch7

 * methode mit ergebnisrückgabe (1 return):		- siehe class Return_Methode_MitErgebnisrueckgabe_Bruch6 	 s.188
 * 
 * METHODE MIT MEHREREN
 * RETURN-ANWEISUNGEN:					- die zuerst erreichte return-anweisung entscheidet über den wert
 * 										-> mit erreichen des ersten returns geht der programmablauf zur aufrufenden Methode zurück
 * 
 * 										- methode muss in jedem fall ein return zurückgeben können, sonst fehler
 * 
 *  						oder bsp: 		int signum () {
 *  										if (this.dezimalWert() == 0) {			// if - if - nix   wenn bedingung: return -> ausstieg aus methode
 *  											return 0;						
 *  										}
 *  										if (this.dezimalWert() > 0) {
 *  											return 1;
 *  										}			
 * 											return -1;
 * 										}	
 * 
 * methode mit ergebnisrückgabe mit mehreren returns (mind. ein return muss immer 
 * zurückgegeben werden)
 */

package uebungen06;

public class Bruch7 {

	int zaehler;
	int nenner;

	void ausgeben() {
		System.out.println(zaehler + "/" + nenner);
	}
	
	double dezimalWert() {
		return (double) zaehler / (double) nenner;
	}
	
	// methode mit ergebnisrückgabe und mehreren returns, ergebnis muss immer returned werden
	String returnWert() {
		if (this.dezimalWert() == 0) {	// this. : ist sauberer, = von derselben klasse, geht aber auch ohne
			return "0";   // geht wegen return eh raus, desshalb die schreibweise : if, if, nix
		}
		if (this.dezimalWert() > 0) {
			return "negativ";
		} 
		return "positiv";	   	// if, else if, else wäre auch korrekt, aber nicht nötig, 
								// da es nach return eh abbricht (bisschen wie bei break)
	}
}

