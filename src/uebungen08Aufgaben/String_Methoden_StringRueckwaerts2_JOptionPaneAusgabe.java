/* TODO .8.4.   aufgabe 4, s.244
 * Klasse String_Methoden_StringRueckwaerts2_JOptionPaneAusgabe
 * 
 * METHODEN:	charAt(int Index);
 * 				lenght();
 * 
 * Programm Stringrueckwaerts2 gibt eine eingegebene Textzeile Zeichen f�r Zeichen r�ckw�rts, DIESMAL in einem MessageDialog aus 
 */

package uebungen08Aufgaben;

import javax.swing.JOptionPane;

public class String_Methoden_StringRueckwaerts2_JOptionPaneAusgabe {

	public static void main(String[] args) {
		String eingabe = JOptionPane.showInputDialog("bitte text eingeben: ");
		String ausgabe = "";  // for-schleifen ausgabe text in einer zus�tzlichen variablen speichern f�r die sp�tere ausgabe
		
		for (int i = eingabe.length()-1; i >= 0; i--){ // index von charAt r�ckw�rts ausgebenlassen, index beginnen mit eingabe.length()-1 bis 0
			ausgabe += eingabe.charAt(i);					
		}
		JOptionPane.showMessageDialog(null, "die eingabe \"" + eingabe + "\" r�ckw�rts ausgegeben, lautet: \n" + ausgabe);
	}
}
