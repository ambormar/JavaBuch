/* TODO .8.4.   Aufgabe 7, s.245 
 * klasse Wrapper_ToHexString_ToBinaryString_ToOctalString_Zahlensysteme
 * 
 * Methoden:		Klasse Integer (& Long):		Integer.toBinaryString(int i)			// = static String toBinaryString(int i)
 * 													Integer.toOctalString(int i)			// = static String toOctalString(int i)
 * 													Integer.toHexString(int i)				// = static String toHexString(int i)
 * 				
 * 					Klasse String: 					String toUpperCase()
 * 
 * SIEHE AUCH:		WrapperKlassen_Objekte_Methoden		8.3.2: RÜCKGABE (ALS STRING) DER WERTE VON INTEGER & LONG IN ANDERE ZAHLSYSTEME		s.241
 * 
 * PROGRAMM: zur Umwandlung einer eingegebenen Dezimalzahl ins Dual-, Oktal-, und ins Hexadezimalsystem. ausgabe als string.
 */

package uebungen08Aufgaben;

import javax.swing.JOptionPane;

public class Wrapper_ToHexString_ToBinaryString_ToOctalString_Zahlensysteme {

	public static void main(String[] args) {
		String eingabe = JOptionPane.showInputDialog("bitte zahl eingeben: ");
		Integer zahl = new Integer(eingabe);		// wrapper-objekt draus machen, weil nur für die wrapperklasse gibts methode toHexString() etc.
		
		JOptionPane.showMessageDialog(null, "die eingabe ausgegeben als..."
											+ "\n...dezimalzahl: " +  zahl 
											+ "\n...dualzahl: " + Integer.toBinaryString(zahl)
											+ "\n...octalzahl: " + Integer.toOctalString(zahl)
											+ "\n...hexadezimalzahl: " + Integer.toHexString(zahl).toUpperCase());
	}

}
