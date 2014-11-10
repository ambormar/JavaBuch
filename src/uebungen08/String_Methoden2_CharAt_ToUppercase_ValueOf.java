/* TODO .8.1.4. (8.1.5 / 8.1.6)   s.232
 * Klasse String_Methoden2_CharAt_ToUppercase_ValueOf
 * 
 * KLASSE STRING:	- f�r Zeichenketten mit wenig ver�nderung. (STRINGBUFFER: besser f�r zeichenketten mit viel ver�nderung)
 * 					  Bei jeder ver�nderung werden string-objekte neu im speicher angelegt. 	=> 		viel ab�nderung = performance-verlust.
 * 
 * 					- String-Schnittstellen siehe JavaDocs_Eclipse 4.2.2. (-String anklicken - javadocs-reiter �ffnen - browseransicht re seitlich)
 * 
 * 					- new-Operator wird implizit verwendet => datentyp sehr einfach verwendbar	
 * 
 * 						Bsp: 	String a = "zeichenkette";		Nicht n�tig:	String a = new String("text");
 * 
 * STRING-METHODEN BSPe 2:		- charAt(int index) 		liefert zeichen auf best. position/index der Stringkette, erwartet als argument ganze zahl
 * 	(genau siehe unten)			- toUppercase()				alle Buchstaben zu Grossbuchstaben, erzeugt neuen string, originalstring bleibt unver�ndert
 * 								- toLowercase()				alle Buchstaben zu Kleinbuchstaben, erzeugt neuen string, originalstring bleibt unver�ndert
 * 								- static String valueOf(int i),(long l),(double d),(float f)
 * 															zahlen in Strings umwandeln, macht das umgekehrte wie Double.parseDouble(string)
 * 												bsp:		String s = String.valueOf(34.5);	macht aus der kommazahl 34.5 den String s mit der zeichenkette "34.5"
 * 											static (!):		aufruf auch ohne existierende instanz �ber klassenname m�glich
 * 														
 */															

package uebungen08;

public class String_Methoden2_CharAt_ToUppercase_ValueOf {
	public static void main(String[] args){
		// 8.1.4 public char charAt(int index),	 liefert zeichen auf best. position/index der Stringkette, erwartet als argument ganze zahl
		String a = "hallo";
		System.out.println(a.charAt(0) + " (charAt index 0)");
		
		// 8.1.5 	String toUppercase(), alle Buchstaben zu Grossbuchstaben, erzeugt neuen string, originalstring bleibt unver�ndert
		//		 	String toLowerCase(), alle Buchstaben zu Kleinbuchstaben, erzeugt neuen string, originalstring bleibt unver�ndert
		String b = "hallo";
		String c = "HALLO";
		System.out.println(b.toUpperCase() + " (hallo toUpperCase)");
		System.out.println(c.toLowerCase() + " (HALLO toLowerCase)");
		
		// 8.1.6 public static String valueOf(int i),(long l),(double d),(float f)	Zahlen in strings umwandeln
		// macht das umgekehrte wie Double.parseDouble(string)
		// weil static, also klassenvariiabel, kann mans direkt �ber String. aufrufen und zu verwandelnden wert in klammer
		String d = String.valueOf(34.5);
		System.out.print(d + " (valueOf 34.5)"); 
	}
}
