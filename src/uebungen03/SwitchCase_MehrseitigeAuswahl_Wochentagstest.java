package uebungen03;

/* TODO .3.2.3.   s.114
 * class SwitchCase_MehrseitigeAuswahl_Wochentagstest (selber geschrieben oder aufgabe???)
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
 * Wochentage testen mit switch-case. nach der eingabe eines wochentages wird geprüft, ob es sich um einen Arbeitstag handelt.
 * das ergebnis wird in einem message-dialog ausgegeben.
 * 
 * [  NB:
 * 			3.1.	sequenz		anweisungsfolge				anweisungen			s.103
 * 			3.2.	selektion	auswahlstruktur				if-else				s.107		verschachtelte if-else, switch-case, (sprunganweisungen)
 * 			3.3.	iteration	wiederholungsstruktur		while-schleife		s.118		do-schleife, for-schleife				]
*/

import javax.swing.JOptionPane;

public class SwitchCase_MehrseitigeAuswahl_Wochentagstest {
   public static void main(String[] args) {
   	String wochentag;
	wochentag = JOptionPane.showInputDialog("Geben Sie bitte einen Wochentag ein: ");
	switch (wochentag.toLowerCase()){				// stringvariable.toLowerCase() : methode von string um alle buchstaben klein auszuwerten							
	case "samstag": 
	case "sonntag":
	   JOptionPane.showMessageDialog(null, "Am " + wochentag + " ist Wochenende!");
	   break;			// break, weil abarbeitung abgebrochen werden kann, wenn der fall zutrifft
	case "montag": 
	case "dienstag": 
	case "mittwoch": 
	case "donnerstag": 
	case "freitag": 
	   JOptionPane.showMessageDialog(null, "Der " + wochentag + " ist ein Arbeitstag!");
	   break;			// break, weil abarbeitung abgebrochen werden kann, wenn der fall zutrifft
	default: 
	   JOptionPane.showMessageDialog(null, "Der " + wochentag + " kein korrekt geschriebener Wochentag!");
	}					// Kein break, weil abarbeitung sowieso abbricht mit ende klammer
   }
}