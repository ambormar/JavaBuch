/* TODO .8.4.   Aufgabe 4.5, s.245 
 * Klasse StringBuffer_String_AusgabeRueckwaerts_ZeitVergleich
 * 
 * KLASSEN IM ZEITVERGLEICH:		String & Stringbuffer 
 * 
 * 									METHODEN:	- Stringbuffer:		append(Char ch); 	bzw. append(String str);
 * 						
 * 												- String:			charAt(int index);
 * 																	lenght();
 * 
 * ZEIT-STOPPEN: 	MIT KLASSE / METHODE: 		system.currentTimeMillis():							
 * 
 * 									BSP:		long zstVorher;
 * 												long zstNachher;
 * 												zstVorher = System.currentTimeMillis()
 * 												// DAZWISCHEN IRGENDEIN PROGRAMM-ABLAUF
 * 												zstNachher = System.currentTimeMillis()
 * 												System.out.println("gemessene Zeit: " + (zstNachher - zstVorher) + " Millisekunden");
 * 
 * 					ZEITUNTERSCHIED:			nenneswerter zeitunterschied ist erst ab relativ langen eingaben (mehrere undert zeichen) sichtbar.
 * 												bei kurzen eingaben steht sonst bei beiden messungen 0 milisekunden
 *  
 * PROGRAMM:	verwendet für die Rückwärtsausgabe einer eingabe/zeichenfolge einmal den Typ String und einmal den Typ StringBuffer.
 * 				Zum Performance-Vergleich wird die jeweils benötigte Zeit ausgegeben
 */

package uebungen08Aufgaben;

import javax.swing.JOptionPane;

public class StringBuffer_String_AusgabeRueckwaerts_ZeitVergleich {

	public static void main(String[] args) {
		String eingabe = JOptionPane.showInputDialog("Gib einen Text ein: ");
		// objekt stringbuffer (leer) eingabe2 nebst objekt string eingabe
		StringBuffer eingabe2 = new StringBuffer("");
		// variablen zeitstopp vorher und nachher
		long zstVorher;
		long zstNachher;
		
		// RÜCKWÄRTSAUSGABE MIT STRINGBUFFER
		//----------------------------------
		zstVorher = System.currentTimeMillis();			// zeit messen vorher: system.currentTimeMillis()	geil super einfach
		
		for (int i = eingabe.length()-1; i >= 0 ; i--) {
			eingabe2.append(eingabe.charAt(i));			// StringBuffer eingabe2 verlängern um String eingabe (im rueckwaertsgang)
		}
		zstNachher = System.currentTimeMillis();		// zeit messen nachher: system.currentTimeMillis()	geil super einfach
		JOptionPane.showMessageDialog(null, eingabe2);	// verlängerten StringBuffer ausgeben
		System.out.println("Benötigte Zeit mit StringBuffer: " + (zstNachher - zstVorher) + " Millisekunden."); // zeit vorher - nachher ! StringBuffer

		// RÜCKWÄRTSAUSGABE MIT STRING
		//----------------------------
		String eingabe3 = "";
		zstVorher = System.currentTimeMillis();
		
		for ( int i = eingabe.length()-1; i >= 0; i--) {
			eingabe3 += eingabe.charAt(i);				// string eingabe zeichen für zeichen rückwärts zu  string eingabe3 hinzufügen
		}
		zstNachher = System.currentTimeMillis();
		JOptionPane.showMessageDialog(null, eingabe3);
		System.out.println("Benötigte Zeit mit String: " + (zstNachher - zstVorher) + " Millisekunden."); // zeit String vorher - nachher !
		
	}

}
