package uebungen02;

/* TODO .2.3.8,   s.85
 * class InOutAktuell_JOptionPane_Meldefenster_Kreisberechnung4
 * 
 * eben eigentlich nicht mit In Out gelöst, also titel leicht irreführend
 * EVA eingabe verarbeitung ausgabe aktuell mit meldefenster (benutzeroberfläche) mittels JOptionPane
 * 
 * aktuelle grafisch orientierte vorgensweise:
 * auf konsole ganz verzichten, eingabe und auch ausgabe per meldungsfenster machen
*/

import javax.swing.JOptionPane;

public class InOutAktuell_JOptionPane_Meldefenster_Kreisberechnung4 {
   public static void main(String[] args) {
	double radius, umfang, flaeche;
	String einheit, eingabe;

	eingabe = JOptionPane.showInputDialog("geben sie den kreisradius ein: ");
	radius = Double.parseDouble(eingabe);
	eingabe = JOptionPane.showInputDialog("geben sie die einheit ein: ");
	einheit = eingabe;
	
	umfang = 2.0 * 3.1415926 * radius;
	flaeche = 3.1415926 * radius * radius;

	JOptionPane.showMessageDialog(
		null,"umfang: "+ umfang +" "+ einheit +"\nflaeche: " + flaeche + "" + einheit + '\u00b2');
   }
}