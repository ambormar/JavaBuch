package uebungen03;

/* TODO .3.3.5.   Aufgabe 6, s.124 
 * class For_Schleife_Guthabenentwicklung
 * 
 * 
 * Nach der Eingabe eines Startguthabens und eines Zinssatzes wird die Wertentwicklung für 10 Jahre.Hans-Peter Habelitz
 * 
 * formel verzinsung eines jahres: G1 = G0 * (1 + Z/100)
 */

import javax.swing.JOptionPane;

public class For_Schleife_Guthabenentwicklung {

	public static void main(String[] args) {
		double guthaben;
		double zinssatz;

		guthaben = Double.parseDouble(JOptionPane.showInputDialog("Geben Sie das Startguthaben ein: "));
		zinssatz = Double.parseDouble(JOptionPane.showInputDialog("Geben Sie den Zinssatz ein: "));

		for (int i = 1; i <= 10; i++) {
			guthaben = guthaben * (1 + zinssatz / 100);
			System.out.println("Guthaben nach " + i + " Jahren: " + guthaben
					+ " €");
		}
	}

}