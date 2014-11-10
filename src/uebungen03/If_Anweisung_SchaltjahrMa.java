package uebungen03;

/* TODO .3.2.2.   aufgabe 3, s.112 
 * class If_Anweisung_SchaltjahrMa
 * 
 * hier lösung ohne mehrfachverschachtelung -> eigentlich nicht der witz der übung
 *
 * - ermitteln ob jahr schaltjahr ist. ausgabe ja nein in ausgabefenster.
 * - jahrzahl durch 4 teilbar = schaltjahr, ausser wenn durch 100 teilbar, 
 * - ausserausser wenn durch 400 teilbar. 
 * - schaltjahr mit modulo operator (%) teilen, rest null.
 */

import javax.swing.JOptionPane;


public class If_Anweisung_SchaltjahrMa {

	public static void main(String[] args) {
		int jahrzahl;
		jahrzahl = Integer.parseInt(JOptionPane
				.showInputDialog("Geben Sie bitte eine Jahrzahl ein!"));
		if (((jahrzahl % 4 == 0) & (jahrzahl % 100 != 0))
				| ((jahrzahl % 4 == 0) & (jahrzahl % 400 == 0))) {
			JOptionPane.showMessageDialog(null, "das Jahr " + jahrzahl
					+ " ist ein Schaltjahr!");
		} else {
			JOptionPane.showMessageDialog(null, "das Jahr " + jahrzahl
					+ " ist kein Schaltjahr!");
		}
	}

}