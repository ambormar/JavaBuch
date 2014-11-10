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

public class Return_Bei_Void_Methoden_Bruch11 {

	public static void main(String[] args) {
		Bruch11 b = new Bruch11();
		b.zaehler = Integer.parseInt(JOptionPane.showInputDialog("gib einen wert für zähler ein"));
		b.nenner = Integer.parseInt(JOptionPane.showInputDialog("gib einen wert für nenner ein"));
		b.ausgeben();
		b.kuerzen();
		b.ausgeben();
		b.ausgebenGgt();
		
	}
}
