/* TODO .6.3.2.   s.191
 * class Bruch11 & Return_Bei_Void_Methoden_Bruch11
 * 
 * RETURN BEI VOID-METHODEN:	- return ist grundsätzlich als geziehlter ausstieg aus void-methoden erlaubt
 * 						
								void kuerzen() {
		 							...
		 							while (ggt-bedingung){
			 							ggt-berechnung...
			 							if (ggt == 1){
				 							ausgabe: GGT = 1; 
				 							return;
			 							}
		 							}
								}	
 * 
 */
package uebungen06;

import javax.swing.JOptionPane;

public class Bruch11 {
	int zaehler;
	int nenner;
	
	void ausgeben() {
		JOptionPane.showMessageDialog(null, zaehler + "/" + nenner);
	}
	
	void kuerzen() {
		 int rest, z, n;
		 z = zaehler;
		 n = nenner;
		 rest = z % n;
		 while (rest > 0){
			 z = n;
			 n = rest;
			 rest = z % n;
			 if (n == 1){				// wenn ggt 1 ist gezielt aus der methode aussteigen mit return & vorher (mit extrakommentar) 
				 JOptionPane.showMessageDialog(null,"der bruch kann nicht gekürzt werden, sein GGT ist: 1");
				 return;					// ausstieg aus void-methode mit return bricht methode ab, auch ohne return-wert zurückzugeben;
			 } 								
		 }
		 zaehler /= n;
		 nenner /= n;
	}
	
	void ausgebenGgt(){
		JOptionPane.showMessageDialog(null, "der GGT ist: " +nenner);
	}
}
