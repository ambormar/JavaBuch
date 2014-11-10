/* TODO .8.4.   Aufgabe 8, s.246 
 * klasse Hexumrechner_Wrapper_valueOf_toHexString 
 * 
 * toHexString():	SIEHE AUCH:			WrapperKlassen_Objekte_Methoden,		
 * 										8.3.2: RÜCKGABE (ALS STRING) DER WERTE VON INTEGER & LONG IN ANDERE ZAHLSYSTEME		s.241
 * 
 * Integer.valueOf("3F", 16):	SIEHE:	WrapperKlassen_Objekte_Methoden,
 * 										8.3.1: 	3. ERZEUGEN VON WRAPPER-OBJEKTEN mit valueOf(zahlencode als string, zahlenbasis)	s.239		
 * 
 * Methoden:		Klasse Integer (& Long):	Integer/Long.valueOf(String str, int basis)	// = ganzzahligerWrapper.valueOf(Zahl als string, zahlsystem)
 * 												Integer/Long.toBinaryString(int i)				// = static String toBinaryString(int i)
 * 												Integer/Long.toOctalString(int i)				// = static String toOctalString(int i)
 * 													
 * EXKURS UNICODE-ZEICHEN:			ermittlung von unicodezeichen anhand der hexzahl
 * 
 * 									BSP:	Integer zahl = Integer.valueOf(eingabe, 16);	
 * 												int z = zahl;								// für Integer zahl wieder ein basisdatentyp int z nötig..
 * 												char c = (char) z;							// ..damit ich z dann (char) aufzwingen/casten kann
 * 	
 * PROGRAMM:	zur Umrechnung einer Hexadezimalzahl in das Dezimal- und das Dualsystem.
 * & EXKURS: 	Unicode-zeichen ermitteln anhand der eingegebenen hex-zahl
 */

package uebungen08Aufgaben;

import javax.swing.JOptionPane;

public class Hexumrechner_Wrapper_valueOf_toHexString {

	public static void main(String[] args) {
		String eingabe = JOptionPane.showInputDialog("Hexadezimalzahl eingeben: ");
		
		Integer zahl = Integer.valueOf(eingabe, 16);		
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// EXKURS: nachträgliche erweiterung (ausserhalb des themas) zur ermittlung von unicodezeichen anhand der hexzahl
		// hat eigentlich nix mit wrapperklassen zu tun
		int z = zahl; 		// für Integer zahl wieder ein basisdatentyp int z nötig... 
		char c = (char) z;	// ...damit ich z dann (char) aufzwingen/casten kann
		// EXKURS ENDE //////////////////////////////////////////////////////////////////////////////////////////////////
		
		JOptionPane.showMessageDialog(null, "die hexzahl \"" + eingabe + "\" als..."
									+ "\n...dezimalZahl: " + zahl
									+ "\n...dualzahl: " + Integer.toBinaryString(zahl)
									+ "\n...oktalzahl: " + Integer.toOctalString(zahl)
									+ "\n...unicodezeichen: " + c ); // EXKURS dialogfensterteil
		
		// ODER VERSION BUCH: achtung ein zweites fenster poppt auf nach dem ersten
		String e = JOptionPane
				.showInputDialog("Geben Sie eine Hexadezimalzahl ein: ");
			JOptionPane.showMessageDialog(null, "Hexadezimalzahl: " + e + "\n"
				+ "Dezimalzahl: " + Long.valueOf(e, 16) + "\n" + "Dualzahl: "			// Long.valueOf(String str, int basis) 
				+ Long.toBinaryString(Long.valueOf(e, 16)));
	}

}
