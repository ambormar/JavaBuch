/* TODO .6.5.   Aufgabe 1 (5&6), s.196 (198)			 
 * & Aufgabe 5, s.198		& Aufgabe 6, s.198  (mit Kreis1Tabelle)
 * 
 * class kreis1 & Konstruktoren_Methoden_GetterSetter_TestKreis1
 * 
 * aufg. 1: 2 kreiskonstruktoren : 	
 * - (der erste ohne parameterliste um kreisradius auf 0 zu setzen), 
 * - der zweite (designated) konstruktor mit einem parameter um Instanzobjekt aufrufen zu können.
 * - getter und setter methoden für radius, umfang(setter aufg 5), fläche(setter aufg. 5)
 * - aus testklasse aufrufen mit fenster-eingabe für radius, radius an konstruktor übergeben,
 * - radius, berechnete umfang und fläche mit der aufrufenden klasse auf konsole ausgeben
 * - aufg 5: klasse kreis erweitern um setUmfang(double u)& setFlaeche(double f): berechnen radius mit übergebenem umfang bzw. fläche
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
											"Die Kreisfläche ist: " + k.getFlaeche() + eingabeEinheit + '\u00B2');
	}
}
