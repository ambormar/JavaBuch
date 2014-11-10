/* TODO .6.1.2.   s.179
 * Bruch2 & Methoden_MethodenAufrufAusMethoden_Bruch2
 * 
 * MEHRFACHMETHODEN (-AUFRUF):			class Bruch2 {				
 * 											void ausgeben(){...} 
 *											void kuerzen() {...} 					// (NB. m. While_Schleife_Struktogramm_GgtEuklidMa s.123); 
 * 											void gekuerztAusgeben() {
 * 												void ausgeben();
 * 												void kuerzen();
 * 											}
 * 										}
 * 	
 * AUFRUF:								b.gekuerztAusgeben();
 * 
 * mehrfacher aufruf von instanzmethoden
 * Methoden_MethodenAufrufAusMethoden_Bruch2 erstellt instanz von Bruch2 und gibt sie aus
 * 
 * [ NB: THIS: 	=> mit this.objektvariabel abgrenzen von lokalen gleichnamigen variabeln (in methoden/blöcken)
 * 
 * 				hier: 	int zaehler= 0:		lokale variabel(-deklaration) in der methode ausgeben()
 * 				und:	 this.zaehler		innerhalb anweisung derselben methode	 =>  selbstreferenz auf variable zaehler von objekt Bruch2	]
 */

package uebungen06;

public class Methoden_MethodenAufrufAusMethoden_Bruch2 {

	public static void main(String[] args) {
		Bruch2 b = new Bruch2();
		b.zaehler = 3;
		b.nenner = 12;
		b.ausgeben();
		System.out.println("\n Und nach dem Kürzen: ");
		b.gekuerztAusgeben(); // zusammenfassende methode für b.kuerzen(); & b.ausgeben(); 
	}
}