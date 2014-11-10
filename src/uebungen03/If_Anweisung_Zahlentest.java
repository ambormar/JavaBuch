package uebungen03;

/* TODO .3.2.2.   aufgabe 1, s.112
 * class If_Anweisung_Zahlentest
 * 
 * Nach der Eingabe einer Zahl wird geprüft, ob die Zahl positiv oder negativ ist. Das Ergebnis wird in einem MessageDialog ausgegeben.
 * Hans-Peter Habelitz
 */

import javax.swing.JOptionPane;

public class If_Anweisung_Zahlentest{

    public static void main(String[] args) {
	double zahl;

	zahl = Double.parseDouble(JOptionPane
		.showInputDialog("Geben Sie eine Zahl ein:"));
	if (zahl < 0) {
	    JOptionPane.showMessageDialog(null, "Die Zahl ist negativ!");
	} else {
	    JOptionPane.showMessageDialog(null, "Die Zahl ist positiv!");
	}
    }

}