/* TODO .6.5.   Aufgabe 6, s.198 
 *  
 * klasse kreis1 & GetterSetter_Methoden_Konstruktoren_Kreis1Tabelle
 * 
 * - aufruf der Klasse Kreis1 aus Kreis1Tabelle 
 * - eine tabelle ausgeben mit radius, umfang, fl�che
 * - w�hrend 30 zeilen radius um eingabewert erh�hen  
 * - jeweils radius, umfang, fl�che ausgeben
 * - darstellung siehe consolenausgabe
 */

package uebungen06Aufgaben;

import javax.swing.JOptionPane;

public class GetterSetter_Methoden_Konstruktoren_Kreis1Tabelle {

	public static void main(String[] args) {
		String eingabe;
		double radius, radiusErh�hung;
		eingabe = JOptionPane.showInputDialog("Bitte geben sie Kreisradius ein: ");
		radius = Double.parseDouble(eingabe);
		eingabe = JOptionPane.showInputDialog("Bitte geben sie Radius-Erh�hung ein: ");
		radiusErh�hung = Double.parseDouble(eingabe);
		
		// custom konstruktor
		Kreis1 k = new Kreis1(radius);
		// anweisungen & instanzmethoden aufrufe
		System.out.println("Radius\t\tUmfang\t\t\t\tFl�che");			// \t = tab-abstand
		for (int i = 0; i < 30; i++){					// 30 durchl�ufe von i = 0 bis i = 29
			k.setRadius(radius + i * radiusErh�hung);	// siehe alternative mit eigener methode 2 zeilen unten
			System.out.println(k.getRadius() + "\t\t" + k.getUmfang()+ '\u0020' + "\t\t" + k.getFlaeche());
			// k.radiusVergroessern(radiusErhoehung);		als alternative L�sung
		}	
	}

}
