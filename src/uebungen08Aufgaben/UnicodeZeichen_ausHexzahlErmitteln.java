/* TODO .8.4.   Aufgabe 8b, s.246 exkurs 
 * klasse UnicodeZeichen_ausHexzahlErmitteln
 * 
 * SIEHE AUCH: 		CODE-BSP:		klasse Hexumrechner_Wrapper_valueOf_toHexString		8.4.   Aufgabe 8, s.246
 * 													
 * EXKURS UNICODE-ZEICHEN:			ermittlung von unicodezeichen anhand einer hexadezimal-zahl
 * 
 * 									BSP:	Integer zahl = Integer.valueOf(eingabe, 16);	
 * 											int z = zahl;								// für Integer zahl wieder ein basisdatentyp int z nötig..
 * 											char c = (char) z;							// ..damit ich z dann (char) aufzwingen/casten kann
 * 	
 */package uebungen08Aufgaben;

import javax.swing.JOptionPane;

public class UnicodeZeichen_ausHexzahlErmitteln {
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

	}
}
