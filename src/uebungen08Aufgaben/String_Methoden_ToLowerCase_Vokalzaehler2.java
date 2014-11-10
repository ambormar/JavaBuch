/* TODO .8.4.   Aufgabe 2, s.244 
 * Klasse StringMethoden_ToLowerCase_Vokalzaehler2
 * 
 * METHODEN:	toLowerCase();
 * 				charAt(int index);
 * 				length();
 * 
 * minimale Erweiterung von: 	String_Methoden_CharAt_Length_Vokalzaehler (String einlesen, anzahl vokale a,e,i,o,u des strings ermitteln und ausgeben.
 * HIER zusätzlich: 			auch Großbuchstaben berücksichtigen (gelöst mit eingabe.toLowerCase() 
 */

package uebungen08Aufgaben;

import javax.swing.JOptionPane;

public class String_Methoden_ToLowerCase_Vokalzaehler2 {
	
	public static void main(String[] args) {
		
		String eingabe; 
		int aZaehler = 0, eZaehler = 0 , iZaehler = 0, oZaehler = 0, uZaehler = 0;
		eingabe = JOptionPane.showInputDialog("bitte text eingeben: ");
		String eingabe2 = eingabe.toLowerCase();	// Kopie von eingabe & dieses komplett in kleinbuchstaben umwandeln 
													//=> einfachste variante um automatisch auch die grossbuchstaben mit zu testen 
		
		for (int i = 0; i < eingabe2.length(); i++){ // NICHT: for (int i= 1; i <= eingabe.length(); i++)  weil bsp: string.length() = 6,
			switch (eingabe2.charAt(i)){				// 										also charAt(0) bis charAt(5) sind 6 zeichen
				case 'a': aZaehler++; break;
				case 'e': eZaehler++; break;
				case 'i': iZaehler++; break;
				case 'o': oZaehler++; break;
				case 'u': uZaehler++; break; 
			}
		}
		//konsolenausgabe-variante
		System.out.println("die eingabe \"" + eingabe + "\" enthält:"); // ausgabe von eingabe in der original variante 
		System.out.println(aZaehler + " mal a");
		System.out.println(eZaehler + " mal e");
		System.out.println(iZaehler + " mal i");
		System.out.println(oZaehler + " mal o");
		System.out.println(uZaehler + " mal u");
		// fensterausgabe-variante
		JOptionPane.showMessageDialog(null, "die eingabe \"" + eingabe + "\" enthält:\n" 
																+ aZaehler + " mal a\n"		// umbruch: \n innerhalb vom string oder: + "\n" +
																+ eZaehler + " mal e\n"	
																+ iZaehler + " mal i\n"	
																+ oZaehler + " mal o\n"	
																+ uZaehler + " mal u\n");	
	}

}
