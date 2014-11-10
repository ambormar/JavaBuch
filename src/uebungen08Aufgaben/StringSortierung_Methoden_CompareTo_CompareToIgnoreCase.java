/* TODO .8.4.   Aufgabe 5, s.245 
 * Klasse StringSortierung_Methoden_CompareTo_CompareToIgnoreCase
 * 
 * METHODEN:	Klasse String:		int compareTo(String str);
 * 									int compareToIgnoreCase("@")			// wie genau siehe unten
 * 
 * PROGRAMM:	liest 3 Texteingaben ein und gibt diese lexikalisch sortiert wieder aus.
 * 				Das Programm nutzt den Rückgabewert von String.compareTo (bzw. hier compareToIgnoreCase().
 */

package uebungen08Aufgaben;

import javax.swing.JOptionPane;

public class StringSortierung_Methoden_CompareTo_CompareToIgnoreCase {

	public static void main(String[] args) {
		String eingabe1 = JOptionPane.showInputDialog("bitte eingabe1 schreiben: ");
		String eingabe2 = JOptionPane.showInputDialog("bitte eingabe2 schreiben: ");
		String eingabe3 = JOptionPane.showInputDialog("bitte eingabe3 schreiben: ");
		
		String ausgabe = "";
		
		// int variabeln: anfangsbuchstaben mit @ (letzter buchstabe vor gross-a im unicode) vergleichen (compareTo()), 
		// je kleiner die zahl desto näher am anfang des alphabeths, bsp a.compareTo("@") = 32 & b.compareTo("@") = 33
		int v1 = eingabe1.compareToIgnoreCase("@");  // buchstabe zum vergleich: letztes zeichen der unicode-tabelle vor Gross-A ist @
		int v2 = eingabe2.compareToIgnoreCase("@");  // mit "a" oder "A" spinnt die Ausgabe je nach gross & kleinschreibung
		int v3 = eingabe3.compareToIgnoreCase("@");  // Nur mit compareToIgnoreCase("@")unterscheidets alles korrekt inkl. gross-kleinschreibg
		
		if (v1 < v2 && v2 < v3 && v3 > v1 ){			// eingabe:  a vor b vor c:
			ausgabe = eingabe1 + '\n' + eingabe2 + '\n' + eingabe3;
		} else if (v1 < v2 && v2 > v3 && v3 > v1 ) {	// a c b
			ausgabe = eingabe1 + '\n' + eingabe3 + '\n' + eingabe2;
		} else if (v1 > v2 && v2 < v3 && v3 > v1 ) {	// b a c 
			ausgabe = eingabe2 + '\n' + eingabe1 + '\n' + eingabe3;
		} else if (v1 < v2 && v2 > v3 && v3 < v1 ) {	// b c a
			ausgabe = eingabe3 + '\n' + eingabe1 + '\n' + eingabe2;
		} else if (v1 > v2 && v2 < v3 && v3 < v1 ) {	// c a b
			ausgabe = eingabe2 + '\n' + eingabe3 + '\n' + eingabe1;
		} else if (v1 > v2 && v2 > v3 && v3 < v1 ) {	// c b a
			ausgabe = eingabe3 + '\n' + eingabe2 + '\n' + eingabe1;
		}
		JOptionPane.showMessageDialog(null, "die lexikalisch sortierte ausgabe der 3 eingaben: \n\"" 					//	\"  => unicode für: "
										+ eingabe1 + ", " + eingabe2 + ", " + eingabe3 + "\" ist: \n" + ausgabe );
	}

}
