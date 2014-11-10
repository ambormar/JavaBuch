/* TODO .8.4.   Aufgabe 6, s.245 
 * Klasse StringBuffer_Methoden_append_charAt_toLowerCase_Vokalloescher
 * 
 * METHODEN:	String:				lenght()			charAt(int index)	toLowerCase()
 * 				Stringbuffer:		append(String str)
 * 
 * PROGRAMM:	entfernt alle Vokale aus der eingegebenen Textzeile und gibt den Text in einem MessageDialog wieder aus.
 * 				(vorgehen: alle zeichen die keine vokale sind in neuen stringbuffer übertragen & diesen ausgeben) 
 */


package uebungen08Aufgaben;

import javax.swing.JOptionPane;

public class StringBuffer_Methoden_append_charAt_toLowerCase_Vokalloescher {
	public static void main(String[] args) {
		String eingabe1 = JOptionPane.showInputDialog("bitte text eingeben: ");
		StringBuffer ausgabe = new StringBuffer("");
		
		String eingabe2 = eingabe1.toLowerCase(); // alles kleinbuchstaben > weniger aufwand unten
		
		for (int i = 0 ; i < eingabe2.length(); i++){
			switch (eingabe2.charAt(i)){
				case 'a': case 'e': case 'i': case 'o': case 'u': 
				case 'y': case 'ä':	case 'ö': case 'ü':
					break;	// alle vokale überspringen ohne anweisung
				default: 
					ausgabe.append(eingabe1.charAt(i));	// alle restlichen buchstaben, einen nach dem anderen, anhängen
			}
		}
		JOptionPane.showMessageDialog(null, "die eingabe \"" + eingabe1 + "\" ohne vokale lautet:\n" + ausgabe);
	}
}
