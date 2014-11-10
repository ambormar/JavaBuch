/* TODO .8.4.   aufgabe 6, s.245
 * class StringBuffer_Methoden_append_charAt_toLowerCase_Vokalloescher_Buch
 * 
 * METHODEN:	String:				lenght()			charAt(int index)	
 * 				Stringbuffer:		append(String str)
 * 
 * PROGRAMM (lösung version buch):	entfernt alle Vokale aus der eingegebenen Textzeile und gibt den Text in einem MessageDialog wieder aus.
 * 									(vorgehen: alle zeichen die keine vokale sind in neuen stringbuffer übertragen & diesen ausgeben)
 */

package uebungen08Aufgaben;

import javax.swing.JOptionPane;

public class StringBuffer_Methoden_append_charAt_toLowerCase_Vokalloescher_Buch {
    public static void main(String args[]) {
	String e = JOptionPane.showInputDialog("Geben Sie einen Text ein: ");
	StringBuffer eohneV = new StringBuffer("");
	for (int i = 0; i < e.length(); i++) {
	    if ((e.charAt(i) != 'a') && (e.charAt(i) != 'e')
		    && (e.charAt(i) != 'i') && (e.charAt(i) != 'o')
		    && (e.charAt(i) != 'u') && (e.charAt(i) != 'A')
		    && (e.charAt(i) != 'E') && (e.charAt(i) != 'I')
		    && (e.charAt(i) != 'O') && (e.charAt(i) != 'U')) {
		eohneV.append(e.charAt(i));								// alle übrigen buchstaben dem stringbuffer anhängen
	    }
	}
	JOptionPane.showMessageDialog(null, eohneV);				// stringbuffer ausgeben
    }
}
