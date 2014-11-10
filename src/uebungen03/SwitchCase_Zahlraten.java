package uebungen03;

/* TODO .3.2.4.   Aufgabe, s.117 
 * class SwitchCase_Zahlraten
 *  
 * switch ist eine form der selektion	
 * 
 * STRUKTOGRAMM bsp für switch siehe s.114
 * 
 * 	switch (ausdruck) {							// ERGEBNIS DES AUSDRUCKS NUR VOM TYP:  char, byte, short, int, enum oder String (kein double z.b.!!!!)
 * 		case konstante1: anweisung1; break;						// ENUM => datentyp für kategorieen, bsp: kleidergrössen s, m, l, xl
 * 		case konstante2: anweisung2; break;						// enum ist mix zw. klasse und datentyp: wenns im buch nicht kommt, nochmal maja fragen
 * 		case konstante3: anweisung3; break;
 * 		case konstante4: anweisung4; break;		// breaks wichtig für abbruch der abarbeitung wenn fall zutrifft
 * 		default: anweisung5;					// default wäre freiwillig 
 * 	}
 * 
 * zahl von 0-10 erfragen, 6: treffer. 4,5,7,8: knapp daneben. rest: daneben
 * switchcase verwenden & ausgabefenster
 */

import javax.swing.JOptionPane;

public class SwitchCase_Zahlraten{
   public static void main(String[] args){
	int eingabe = Integer.parseInt(JOptionPane.showInputDialog("Erraten Sie eine Zahl zwischen 0 und 10: "));
	switch (eingabe){
	    case 6:  JOptionPane.showMessageDialog(null, "Du bist der Champion"); break;
	    case 4:
	    case 5:
	    case 7:
	    case 8:
		JOptionPane.showMessageDialog(null, "knapp daneben, versuch s nochmal"); break;
	    default:
		JOptionPane.showMessageDialog(null, "das war daneben, geh auf's Unterdeck, geh auf's Unterdeck");
	}
   }
}