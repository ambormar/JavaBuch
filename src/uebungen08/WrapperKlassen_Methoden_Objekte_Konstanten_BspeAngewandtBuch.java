/* TODO .8.3.3.   s.243
 * Klasse WrapperKlassen_Methoden_Objekte_Konstanten_BspeAngewandtBuch
 * 
 * BEISPIELE AUS BUCH ZUM UMGANG MIT WRAPPERKLASSEN:		siehe unten
 * 
 * ÜBERBLICK WRAPPERKLASSEN (methoden etc.) SIEHE:	 		8.3. (8.3.1 / 8.3.2) Klasse WrapperKlassen_Objekte_Methoden    ab s.238
 *
 */

package uebungen08;

import javax.swing.JOptionPane;

public class WrapperKlassen_Methoden_Objekte_Konstanten_BspeAngewandtBuch {

	public static void main(String[] args) {
		String eingabe;
		eingabe = JOptionPane.showInputDialog("gib eine ganze zahl ein: ");
		Integer i = new Integer(eingabe);										// eingabe hier als string ohne explizit zu parsen
		System.out.println("eingegebene zahl: " + i);
		System.out.println("als dualzahl: " + Integer.toBinaryString(i));		// rückgabe von Integer als string in anderen zahlsystemen: 
		System.out.println("als oktalzahl: " + Integer.toOctalString(i));		// ..dual, octal und hexadezimale schreibweise
		System.out.println("als hexagonalzahl: " + Integer.toHexString(i));
		
		System.out.println("die obergrenze von int: " + Integer.MAX_VALUE);		// Konstanten um wertebereich abzufragen 
		System.out.println("die untergrenze von int: " + Integer.MIN_VALUE);
		
		eingabe = JOptionPane.showInputDialog("gib eine kommazahl ein: ");
		double d = Double.parseDouble(eingabe);									// eingabe als string der explizit geparsed wird
		System.out.println(i + " / " + d + " = " + (i / d));
		// unnötig komlizierte schreibweise (für i) von demselben (= zeile näxt oben) 
		System.out.println(i.intValue() + " / " + d + " = " + (i.intValue() / d));		// i rückgabe des wertes von wrapperklasse Integer an..
																						// ..basis-typ int mit der methode int intValue()
		Double wd = new Double(0.0);
		System.out.println(d + " / " + wd + " = " + (d / wd));			// ausgabe infinity ( pos. zahl / 0.0 )
		
		// ausnutzen von autoboxing 
		Double wd2 = 2.5;					// Autoboxing ausnutzen:	kein new Double() nötig, weil verhält sich wie primitiver Datentyp
		System.out.println(-wd2 + " / " + 0 + " = " + (-wd2 / 0.0));	// ausgabe -infinity ( neg. zahl / 0.0 )
		
		// NaN
		System.out.println(0.0 + " / " + 0.0 + " = " + (0.0 / 0.0));// ausgabe NaN ( 0.0 / 0.0 )
		
	}

}
