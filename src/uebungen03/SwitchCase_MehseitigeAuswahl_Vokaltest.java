package uebungen03;

/* TODO .3.2.3.   s.116 (114) 
 * class SwitchCase_MehseitigeAuswahlstruktur_Vokaltest
 *  
 * switch ist eine form der selektion	
 * 
 * STRUKTOGRAMM bsp für switch siehe s.114
 * 
 * 	switch (ausdruck) {							// ERGEBNIS DES AUSDRUCKS NUR VOM TYP:  char, byte, short, int, enum oder String (kein double!!!!)
 * 		case konstante1: anweisung1; break;						// ENUM => datentyp für kategorieen, bsp: kleidergrössen s, m, l, xl
 * 		case konstante2: anweisung2; break;						// enum ist mix zw. klasse und datentyp: wenns im buch nicht kommt, nochmal maja fragen
 * 		case konstante3: anweisung3; break;
 * 		case konstante4: anweisung4; break;		// breaks wichtig für abbruch der abarbeitung wenn fall zutrifft
 * 		default: anweisung5;					// default wäre freiwillig 
 * 	}
 * 
 * nach der eingabe eines zeichens wird geprüft, ob es sich um einen vokal handelt. 
 * das ergebnis wird in einem message-dialog ausgegeben.
*/

import javax.swing.JOptionPane;

public class SwitchCase_MehseitigeAuswahl_Vokaltest {
   public static void main(String[] args) {
   	String eingabe;
	char c;
	eingabe = JOptionPane.showInputDialog("Geben Sie bitte einen Buchstaben ein: ");					
	c = eingabe.toLowerCase().charAt(0);			// stringvariable.toLowerCase() -> eigegebener string zu kleinbuchstaben 
	switch (c){										// stringvariable.charAt(0) -> erstes zeichen des Strings (pos 0)
	case 'a': 
	case 'e':
	case 'i':	
	case 'o':
	case 'u':
	case 'y':
	   JOptionPane.showMessageDialog(null, "Der Buchstabe " + eingabe + " ist ein Vokal!");
	   break;										// breaks nicht vergessen
	default: 
	   JOptionPane.showMessageDialog(null, "Der Buchstabe " + eingabe + " ist kein Vokal!");
	}
   }
}