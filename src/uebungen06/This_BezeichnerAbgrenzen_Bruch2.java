/* TODO .6.1.3.   s.181
 * This_BezeichnerAbgrenzen_Bruch2 & Methoden_MehrfachInstanzMethodenAufruf_Bruch2
 * 
 * THIS: 	=> mit this.objektvariabel abgrenzen von lokalen gleichnamigen variabeln (in methoden/blöcken)
 * 
 * 			hier: 	int zaehler= 0:		lokale variabel(-deklaration) in der methode ausgeben()
 * 			und:	 this.zaehler		innerhalb anweisung derselben methode	 =>  selbstreferenz auf variable zaehler von objekt Bruch2
 * 
 * [NB: mehrfacher aufruf von instanzmethoden. Methoden_MehrfachInstanzMethodenAufruf_Bruch2 erstellt instanz von Bruch2 und gibt sie aus ]
 */

package uebungen06;

public class This_BezeichnerAbgrenzen_Bruch2 {
		int zaehler;
		int nenner;
		
		void ausgeben(){
			int zaehler = 0; 		// ACHTUNG: Namensgleiche lokale Variablen (hier sinnlos) aber zum zeigen dass kompiler keine fehlermeldung macht. 
			System.out.println(this.zaehler+"/"+nenner); 		// LÖSUNG DES PROBLEMS: durch selbstreferenz-variable: this.
																// this.zaehler = selbstreferenz auf variable zaehler von objekt Bruch2
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
