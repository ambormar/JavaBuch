package uebungen01;

/* TODO .1.4,   aufgabe 3, s.55
 * class Konsole_Main_ParameterMitgabe_Kreisberechnung2
 * 
 * Für einen Kreis werden der Umfang und die Flächeninhalt berechnet. Der Radius des Kreises wird dem Programm als Parameter übergeben.
 * 
 * auf konsole ausgeführt:
 * bei Programmstart auf der konsole wird parameter für radius als argument mitgegeben
 * 
 * - Konsole öffnen
 * - ordnerpfad in der konsole eingeben (hier:):
 * 			C:\Users\marco ambord>_cd Documents\Java\Programme\JavaUebungen01 		& enter

 * 			C:...>javac ParameterMitgabe_Konsole_Kreisberechnung2.java 		& enter		(konsolen-eingaben leichter mit dir und cd siehe 1.3.3. Kompilieren_Konsole_HalloWelt)
 * 
 * 		 	& dann programmstart inklusive mitgabe des gewünschten Arguments (parameter) (mit dem argument RADIUS werden die programmberechnungen gemacht )  :
 * 			C:...>java ParameterMitgabe_Konsole_Kreisberechnung2 RADIUS		& enter
 * 
 */


public class Konsole_Main_ParameterMitgabe_Kreisberechnung2 {
  public static void main(String[] args) {	// (String[] args) oder (String args[]) möglich,  nicht aber: (String[] args[]) main-methode schluckt nur eindimensionale arrays
    double radius, umfang, inhalt;
    radius = Double.parseDouble(args[0]);	// Double.parse.double um string argument in double umzuwandeln
    umfang = 2.0 * 3.1415926 * radius;		
    inhalt = 3.1415926 * radius * radius;	
    System.out.print("Umfang: ");
    System.out.println(umfang);
    System.out.print("Flaeche: ");
    System.out.println(inhalt);
  }
}