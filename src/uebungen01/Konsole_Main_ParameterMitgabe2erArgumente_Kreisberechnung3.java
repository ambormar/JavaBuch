package uebungen01;

/* TODO .1.4,   aufgabe 4, s.56
 * class Konsole_Main_ParameterMitgabe2erArgumente_Kreisberechnung3
 * 
 * auf konsole ausgeführt:
 * für einen kreis werden der umfang und der flächeninhalt berechnet. der kreisradius wird beim programmstart als 1. parameter und die einheit 
 * als 2. parameter übergeben 
 *  
 * - Konsole öffnen
 * - ordnerpfad in der konsole eingeben (hier:):		(BESSER: ...>cd (abstand) & von offenem explorer den ordner, wo die datei drin ist einfach rüberziehen)
 * 			C:\Users\marco ambord>_cd Documents\Java\Programme\JavaUebungen01 		& enter		
 * 
 * 			C:...>javac ParameterMitgabe2erArgumente_Konsole_Kreisberechnung3.java 		& enter		(konsolen-eingaben leichter mit dir und cd siehe 1.3.3. Kompilieren_Konsole_HalloWelt)
 * 
 * 		 	& dann programmstart inklusive mitgabe des gewünschten Arguments (parameter) (mit dem argument RADIUS werden die programmberechnungen gemacht )  :
 * 			C:...>java ParameterMitgabe2erArgumente_Konsole_Kreisberechnung3 RADIUS EINHEIT		& enter
*/

public class Konsole_Main_ParameterMitgabe2erArgumente_Kreisberechnung3 {
   public static void main(String[] args) { // String[] args = eindimensionaler string array = beliebig viele argumente können beim programmstart mitgegeben werden
	double radius, umfang, inhalt;
	String einheit;
	radius = Double.parseDouble(args[0]);	// 1.er wert des stringarrays welcher beim programm-aufruf mitgegeben werden kann
	einheit = args[1];						// 2.er wert des stringarrays welcher beim programm-aufruf mitgegeben werden kann
	umfang = 2.0 * 3.1415926 * radius;
	inhalt = 3.1415926 * radius * radius;
	System.out.println("Umfang: " + umfang + " " + einheit);
	System.out.println("Flaeche: " + inhalt + " " + einheit + '\u00fd'); // '\u00fd' für ausgabe der hochzahlen, hier könnte auch 2 stehen 
   }
}