package uebungen03;

/* TODO .3.2.2.   aufgabe 3, s.112 
 * class If_MehrfachVerschachtelt_Schaltjahr
 * 
 * 		if (true) {
			anweisg;
		} else {
			if (true) {
				anweisg;
			} else {
				if (true) {
					anweisg;
				} else {
					anweisg;
				}
			}
		}
 * 
 * Nach der Eingabe einer Jahreszahl wird geprüft, ob es sich bei dem Jahr um ein Schaltjahr handelt.
 * Das Ergebnis wird in einem MessageDialog ausgegeben.

 * - ermitteln ob jahr schaltjahr ist. ausgabe ja nein in ausgabefenster.
 * - jahrzahl durch 4 teilbar = schaltjahr, ausser wenn durch 100 teilbar, 
 * - ausserausser wenn durch 400 teilbar. 
 * - schaltjahr mit modulo operator (%) teilen, rest null.
 */

import javax.swing.JOptionPane;

public class If_MehrfachVerschachtelt_Schaltjahr {

	public static void main(String[] args) {
		int jahr;

		jahr = Integer.parseInt(JOptionPane
				.showInputDialog("Geben Sie eine Jahreszahl ein:"));
		if ((jahr % 400) == 0) {
			JOptionPane.showMessageDialog(null, "Das Jahr " + jahr
					+ " ist ein Schaltjahr!");
		} else {
			if ((jahr % 100) == 0) {
				JOptionPane.showMessageDialog(null, "Das Jahr " + jahr
						+ " ist kein Schaltjahr!");
			} else {
				if ((jahr % 4) == 0) {
					JOptionPane.showMessageDialog(null, "Das Jahr " + jahr
							+ " ist ein Schaltjahr!");
				} else {
					JOptionPane.showMessageDialog(null, "Das Jahr " + jahr
							+ " ist kein Schaltjahr!");
				}
			}
		}
	}
}