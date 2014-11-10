package uebungen03;

/* TODO .3.2.2.   aufgabe 2, s.112
 * class If_Verschachtelt_LoesungenQuadratischeGleichung 
 * 
 * 	if (true) {
	    anweisung;
	} else {
	    if (true) {
			anweisung;
	    } else {
			anweisung;
	    }
	}
 * 
 * für die quadratische gleichung der form: ax^2 + bx +c = 0
 * Nach der Eingabe der drei Koeffizienten a, b und c wird bestimmt wie viele Lösungen die Gleichung hat.
 * dazu wird Diskriminante D berechnet mit:		
 * D = b * b - 4 * a * c
 * dabei gilt: D=0 -> eine lösung; D>0 -> 2 lösungen; D<0 -> keine lösungen
 * Das Ergebnis wird in einem MessageDialog ausgegeben.
 * Hans-Peter Habelitz
 */

import javax.swing.JOptionPane;

public class If_Verschachtelt_LoesungenQuadratischeGleichung {

    public static void main(String[] args) {
	double a, b, c, d;
	a = Double.parseDouble(JOptionPane.showInputDialog("ax" + '\u00b2'
		+ " + bx + c; Geben Sie den Koeffizienten a ein:"));
	b = Double.parseDouble(JOptionPane.showInputDialog("ax" + '\u00b2'
		+ " + bx + c; Geben Sie den Koeffizienten b ein:"));
	c = Double.parseDouble(JOptionPane.showInputDialog("ax" + '\u00b2'
		+ " + bx + c; Geben Sie den Koeffizienten c ein:"));
	d = b * b - 4 * a * c;
	if (d < 0) {
	    JOptionPane.showMessageDialog(null,
		    "Die Gleichung hat keine Lösung!");
	} else {
	    if (d > 0) {
		JOptionPane.showMessageDialog(null,
			"Die Gleichung hat zwei Lösungen!");
	    } else {
		JOptionPane.showMessageDialog(null,
			"Die Gleichung hat eine Lösung!");
	    }
	}
    }

}