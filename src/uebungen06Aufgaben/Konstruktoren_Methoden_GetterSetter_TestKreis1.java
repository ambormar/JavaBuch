/* TODO .6.5.   Aufgabe 1 (5&6), s.196 (198)			 
 * & Aufgabe 5, s.198		& Aufgabe 6, s.198  (mit Kreis1Tabelle)
 * 
 * class kreis1 & Konstruktoren_Methoden_GetterSetter_TestKreis1
 * 
 * aufg. 1: 2 kreiskonstruktoren : 	
 * - (der erste ohne parameterliste um kreisradius auf 0 zu setzen), 
 * - der zweite (designated) konstruktor mit einem parameter um Instanzobjekt aufrufen zu k�nnen.
 * - getter und setter methoden f�r radius, umfang(setter aufg 5), fl�che(setter aufg. 5)
 * - aus testklasse aufrufen mit fenster-eingabe f�r radius, radius an konstruktor �bergeben,
 * - radius, berechnete umfang und fl�che mit der aufrufenden klasse auf konsole ausgeben
 * - aufg 5: klasse kreis erweitern um setUmfang(double u)& setFlaeche(double f): berechnen radius mit �bergebenem umfang bzw. fl�che
 * 									
 */

package uebungen06Aufgaben;

import javax.swing.JOptionPane;

public class Konstruktoren_Methoden_GetterSetter_TestKreis1 {
	
	// aufg 5: setter werden gar nicht benutzt! tja ne
	public static void main(String[] args) {
		String eingabeEinheit, eingabeRadius;
		double rad;
		eingabeRadius = JOptionPane.showInputDialog("Bitte geben Sie einen Kreisradius ein: ");
		eingabeEinheit = JOptionPane.showInputDialog("Bitte geben sie eine Einheit ein: ");
		rad = Double.parseDouble(eingabeRadius);
		Kreis1 k = new Kreis1(rad);
		JOptionPane.showMessageDialog(null, "Der Kreisradius ist: " + k.getRadius() + eingabeEinheit + '\n' +
											"Der Kreisumfang ist: " + k.getUmfang() + eingabeEinheit + '\n' +
											"Die Kreisfl�che ist: " + k.getFlaeche() + eingabeEinheit + '\u00B2');
	}
}
