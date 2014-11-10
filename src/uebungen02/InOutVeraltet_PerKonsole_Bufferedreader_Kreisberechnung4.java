package uebungen02;

/* TODO .2.3.8,   s.83
 * class InOutVeraltet_PerKonsole_Bufferedreader_Kreisberechnung4
 * 
 * EVA (=eingabe verarbeitung ausgabe) mittels In Out
 * primitive/veraltete vorgehensweise:
 * einlesen der benutzereingaben als konsolenanwendung mit BufferedReader (statt via benutzeroberfläche)
 * 
 * MERKE: EINFACHE FORM VON IN (hier konsoleneingabe):
 * 	
 * BufferedReader eingabepuffer = new BufferedReader(new InputStreamReader(System.in)
 * & 
 * eingabe = eingabepuffer.readLine();        
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InOutVeraltet_PerKonsole_Bufferedreader_Kreisberechnung4 {
	public static void main(String[] args) throws IOException{		// methode readLine() v. Kl. BufferedReader throws IOException
		double radius, umfang, flaeche;
		String einheit, eingabe;
		BufferedReader eingabepuffer = new BufferedReader(			// neues BufferedReader-objekt als zwischenspeicher bei tatstatureingaben , siehe auch K12 I.O.
								new InputStreamReader(System.in)); 	// Inputstreamreader & system.in  (normalerweise für tastatureingaben) (hier ab konsoleneingabe??!!)
		System.out.print("geben sie den kreisradius ein: ");
		eingabe = eingabepuffer.readLine();							// methode readLine() von klasse BufferedReader liefert zeichen/zeichenkette/string zurück..
		radius = Double.parseDouble(eingabe);						// ...string eingabe in double radius umwandeln
		System.out.print("geben sie die einheit ein: ");
		eingabe = eingabepuffer.readLine();
		einheit = eingabe;											// einheit bleibt string wie die eingabe
		umfang = 2.0 * 3.1415926 * radius;
		flaeche = 3.1415926 * radius * radius;
		System.out.println("umfang: " + umfang + einheit);
		System.out.println("flaeche: " + flaeche + einheit + '\u00b2');
	}
}