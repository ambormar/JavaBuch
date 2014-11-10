/* 	TODO .8.1.6.   s.234
 *  Klasse String_Methoden_Angewandt
 *  
 *  STRING METHODEN BEISPIELE MIT: length(), charAt(), valueOf(), compareTo(), toUpperCase(), toLowerCase()
 *  
 *  SIEHE genauer:	- String_Methoden_ConcatLengthEqualsCompareTo	.8.1.2. (8.1.3.)   			ab s.227 (230)
 *  			&:	- String_Methoden2_CharAtToUppercaseValueOf		.8.1.4. (8.1.5 / 8.1.6)   	s.232
 *  
 *  STRING-METHODEN BSPe:	- a.concat(b)			zeichenkette a wird um zeichenkette b verlängert 
 * 																	(ursprüngliches a gelöscht, neues a an neuem speicherplatz erstellt)
 * 							- a.lenght() 			gibt anzahl zeichen der zeichenkette a aus
 * 							- a.equals(b)			vergleicht zeichenkette a auf absolute gleichheit des objekt-werts mit zeichenkette b
 * 							- a.compareTo(b)		vergleicht wieviele unicodezeichen der parameter-String vor oder nach dem objekt-String steht 
 * 																	(0 => gleiches zeichen; 2 => 2 zeichen nachher; -2 => 2 zeichen vorher) 
 * 
 * STRING-METHODEN BSPe 2:		- charAt(int index) 		liefert zeichen auf best. position/index der Stringkette, erwartet als argument ganze zahl
 * 	(genau siehe unten)			- toUppercase()				alle Buchstaben zu Grossbuchstaben, erzeugt neuen string, originalstring bleibt unverändert
 * 								- toLowercase()				alle Buchstaben zu Kleinbuchstaben, erzeugt neuen string, originalstring bleibt unverändert
 * 								- static String valueOf(int i),(long l),(double d),(float f)
 * 															zahlen in Strings umwandeln, macht das umgekehrte wie Double.parseDouble(string)
 * 												bsp:		String s = String.valueOf(34.5);	macht aus der kommazahl 34.5 den String s mit der zeichenkette "34.5"
 * 											static (!):		aufruf auch ohne existierende instanz über klassenname möglich
 */

package uebungen08;

import javax.swing.JOptionPane;

public class String_Methoden_Angewandt {

	public static void main(String[] args) {
		String vorname = JOptionPane.showInputDialog("Dein Vorname: ");
		String nachname = JOptionPane.showInputDialog("Dein Nachname: ");
		String altersangabe = JOptionPane.showInputDialog("Dein Alter: ");
		int alter = Integer.parseInt(altersangabe);
		String name = vorname + " " + nachname;
		
		System.out.println("du heisst: " + name);
		System.out.println("dein vorname besteht aus " + vorname.length() + " zeichen!");	// length()
		System.out.println("dein nachname beginnt mit " + nachname.charAt(0));				// charAt()

		if (alter >= 18){
			System.out.println("du bist seit " + String.valueOf(alter - 18) + " jahren volljährig!");	// valueOf()
		} else {
			System.out.println("du wirst in " + String.valueOf(18 - alter) + " jahren volljährig!");
		}
		
		if (vorname.compareTo(nachname) < 0){														// compareTo()
			System.out.println("dein vorname ist lexikalisch vor dem nachnamen einzusortieren!");
		} else if (vorname.compareTo(nachname) > 0){
			System.out.println("dein nachname ist lexikalisch vor dem vornamen einzusortieren!");
		} else if (vorname.compareTo(nachname) == 0){
			System.out.println("dein nachname ist identisch mit dem vornamen!");
		}
		
		System.out.println(name.toUpperCase());		// toUpperCase()
		System.out.println(name.toLowerCase());		// toLowerCase()
	}

}
