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
 */

package uebungen06;

public class Bruch2 {
		int zaehler;
		int nenner;
		
		void ausgeben(){
			int zaehler = 0; 
			/* ACHTUNG: Namensgleiche lokale Variablen (hier sinnlos) aber zum zeigen
			 * dass kompiler keine fehlermeldung macht. 
			 * problem lösen durch selbstreferenz-variable: this. */
			System.out.println(this.zaehler+"/"+nenner); 
			//this.zaehler = selbstreferenz auf variable zaehler von objekt Bruch2
		}
		
		void kuerzen(){
			int z, n, r; // lokale variablen zäehler, nenner, rest
			z = zaehler;
			n = nenner;
			r = z % n;
			while (r > 0){
				z = n;
				n = r;
				r = z % n;
			}
			zaehler = zaehler / n; 	// in n steht jetzt der ggT !!! (siehe euklid-formel)
			nenner /= n;			// andere schreibweise für nenner = nenner / n
		}
		void gekuerztAusgeben(){
			kuerzen();
			ausgeben();
		}
}
