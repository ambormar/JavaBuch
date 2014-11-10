package uebungen03;

/* TODO .3.3.5.   Aufgabe 6, s.124 
 * class For_Schleife_GuthabenentwicklungMa 
 * 
 * prog. zur berechnung der guthabenentwicklung nach zehn jahre. guthaben und zinssatz einlesen. 
 * 
 * formel verzinsung eines jahres: G1 = G0 * (1 + Z/100)
 */

import javax.swing.JOptionPane;

public class For_Schleife_GuthabenentwicklungMa {
	public static void main(String[] args) {
		double guthaben;
		double zinssatz;
		guthaben = Double.parseDouble(JOptionPane
				.showInputDialog("Geben Sie das Startguthaben ein: "));
		zinssatz = Double.parseDouble(JOptionPane
				.showInputDialog("Geben Sie den Zinssatz ein: "));
		for (int j = 1; j <= 10; j++) {
			guthaben = guthaben * (1 + zinssatz / 100);
			System.out.println("Guthaben nach " + j + " Jahren: " + guthaben
					+ " Fr." + " bei Zinssatz: " + zinssatz);
		}
		JOptionPane.showMessageDialog(null,
				"Ihr Guthaben nach 10 Jahren beträgt: " + guthaben);
	}
}