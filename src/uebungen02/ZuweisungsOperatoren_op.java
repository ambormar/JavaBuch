package uebungen02;

/* TODO .2.4.6,   s.99
 * class ZuweisungsOperatoren_op
 * 
 * 		zuweisungsoperator und kombinierte zuweisung bei nummerischen werten -> nummerische ergebnisse
 * 
 * 		ZUWEISUNGSOPERATOREN:	=		einfache zuweisung 		prio 13		
 * 								op=		kombinierte zuweisung	prio 13		op steht für *, /, %, +, -		bsp: zahl += 1	=>	zahl = zahl + 1	
 */
import javax.swing.JOptionPane;

public class ZuweisungsOperatoren_op {

	public static void main(String[] args) {
		int zahl = 5;
		JOptionPane.showMessageDialog(null, "zahl = " + zahl);
		zahl *= 3;
		JOptionPane.showMessageDialog(null, "zahl *= 3 (zahl = zahl * 3)  ergibt: " + zahl);
	}

}
