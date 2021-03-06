/* TODO .6.3.1.   s.188
 * Bruch6 & Return_Methode_MitErgebnisrueckgabe_Bruch6
 * 
 * METHODE MIT ERGEBNIS-R�CKGABE:	- Um information von der methode zur�ck an die aufrufende methode zu senden
 * 										(umgekehrt wird ja per parameter information in die methode gebracht , um zb. werte zu berechnen)
 * 										Bsp:	aus parametern berechneter wert an die aufrufende methode zur�ckliefern
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
 * 						AUFRUF:			- der name der methode kann nun �berall verwendet werden, wo ein entsprechender (hier: double) wert
 * 											stehen kann							
 * 						
 * 					BSP (aufruf):		System.out.print(xy.dezimalWert());
 * 
 * 							ODER:		if (xy.dezimalWert() < 3.5) {..}
 * 
 * [ MIT MEHREREN RETURN-ANWEISUNGEN:	- die zuerst erreichte return-anweisung entscheidet �ber den wert
 * 										-> mit erreichen des ersten returns geht der programmablauf zur aufrufenden Methode zur�ck
 * 
 * 										- methode muss in jedem fall ein return zur�ckgeben k�nnen, sonst fehler
 * 
 * 							Bsp:		- siehe sonst auch class Bruch7 & Returns_Methode_MitErgebnissrueckgabe_MehrereReturns_Bruch7
 * 
 *  						oder bsp: 		int signum () {
 *  										if (this.dezimalWert() == 0) {			// if - if - nix   hier m�gl. weil: return -> ausstieg ..
 *  											return 0;							// .. normal nur: if - else if - else
 *  										}
 *  										if (this.dezimalWert() > 0) {
 *  											return 1;
 *  										}			
 * 											return -1;
 * 										}														]
 * 
 * in der klasse Bruch6 wird methode (double dezimalwert()) erstellt, 
 * welche den wert des Bruchs als Dezimalzahl an den methoden-aufruf zur�ck gibt
 * 
 */

package uebungen06;

public class Bruch6 {
	int zaehler;
	int nenner;
	void ausgeben(){							
		System.out.println(zaehler+"/"+nenner); 
	}
	// methode mit ergebnisr�ckgabe (hier ergebnis von: return (double)zaehler/(double)nenner;)
	double dezimalWert(){
		return (double)zaehler/(double)nenner;
	}
}
