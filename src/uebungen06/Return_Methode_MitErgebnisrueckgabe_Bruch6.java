/* TODO .6.3.1.   s.188
 * Bruch6 & Return_Methode_MitErgebnisrueckgabe_Bruch6
 * 
 * METHODE MIT ERGEBNIS-RÜCKGABE:	- Um information von der methode zurück an die aufrufende methode zu senden
 * 										(umgekehrt wird ja per parameter information in die methode gebracht , um zb. werte zu berechnen)
 * 										Bsp:	aus parametern berechneter wert an die aufrufende methode zurückliefern
 * 	
 * 									- datentyp anstelle von void vor dem namen 		&		return-anweisung im rumpf
 * 									
 * 						SCHEMA: 		datentyp methodenname(..) {			
 * 											return ausdruck;
 * 										} 
 * 
 * 							BSP:		double dezimalwert() {
 * 											return (double)zaheler / (double)nenner			// hier mit expliziter typumwandlung wie im progr.beispiel
 * 
 * 						AUFRUF:			- der name der methode kann nun überall verwendet werden, wo ein entsprechender (hier: double) wert
 * 											stehen kann							
 * 						
 * 					BSP (aufruf):		System.out.print(xy.dezimalWert());
 * 
 * 							ODER:		if (xy.dezimalWert() < 3.5) {..}
 * 
 * [ MIT MEHREREN RETURN-ANWEISUNGEN:	- die zuerst erreichte return-anweisung entscheidet über den wert
 * 										-> mit erreichen des ersten returns geht der programmablauf zur aufrufenden Methode zurück
 * 
 * 										- methode muss in jedem fall ein return zurückgeben können, sonst fehler
 * 
 * 							Bsp:		- siehe sonst auch class Bruch7 & Returns_Methode_MitErgebnissrueckgabe_MehrereReturns_Bruch7
 * 
 *  						oder bsp: 		int signum () {
 *  										if (this.dezimalWert() == 0) {			// if - if - nix   hier mögl. weil: return -> ausstieg ..
 *  											return 0;							// .. normal nur: if - else if - else
 *  										}
 *  										if (this.dezimalWert() > 0) {
 *  											return 1;
 *  										}			
 * 											return -1;
 * 										}														]
 * 
 * in der klasse Bruch6 wird methode (double dezimalwert()) erstellt, 
 * welche den wert des Bruchs als Dezimalzahl an den methoden-aufruf zurück gibt
 */
package uebungen06;

public class Return_Methode_MitErgebnisrueckgabe_Bruch6 {

	public static void main(String[] args) {
		Bruch6 b = new Bruch6();
		b.zaehler = 3;
		b.nenner = 4;
		b.ausgeben();
		// aufruf von methode mit ergebnisrückgabe (hier: return (double)zaehler/(double)nenner;)
		b.dezimalWert();
		System.out.println("Bruch-Ausgabe als Dezimalwert: " + b.dezimalWert());
		// b.dezimalWert() in beliebigen Ausdrücken / Anweisungen verwendbar, wenn datentyp ok
		if (b.dezimalWert() >= 0.0){
			System.out.println("Der Dezimalwert ist positiv");
		} else {
			System.out.println("Der Dezimalwert ist negativ");
		}
	}
}
