/* TODO .8.4.   aufgabe 3, s.244 
 * Klasse String_Methoden_CharAt_Length_StringRueckwaerts
 * 
 * METHODEN:	charAt(int Index);
 * 				lenght();
 * 
 * Programm  gibt eine eingegebene Textzeile Zeichen f�r Zeichen r�ckw�rts in der Console aus
 */

package uebungen08Aufgaben;

import javax.swing.JOptionPane;

public class String_Methoden_CharAt_Length_StringRueckwaerts {

	public static void main(String[] args) {
		String eingabe = JOptionPane.showInputDialog("bitte text eingeben: ");
		
		System.out.println("die eingabe \"" + eingabe + "\" r�ckw�rts ausgegeben, lautet: ");
		
		for (int i = eingabe.length()-1; i >= 0; i--){ // index von charAt r�ckw�rts ausgebenlassen, beginnen mit eingabe.length()-1 bis 0
			System.out.print(eingabe.charAt(i));
		}
	}

}
