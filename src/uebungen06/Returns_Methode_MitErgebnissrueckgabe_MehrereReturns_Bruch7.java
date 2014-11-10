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

public class Returns_Methode_MitErgebnissrueckgabe_MehrereReturns_Bruch7 {

	public static void main(String[] args) {
		Bruch7 b = new Bruch7();
		b.zaehler = -3;
		b.nenner = 4;
		b.ausgeben();
		System.out.println("Der Dezimalwert ist: " + b.dezimalWert());
		System.out.println("Returnwert ist: " + b.returnWert());
	}
}
