package uebungen01;

/* TODO .1.4,   Aufgabe 1, s.53,
 * class Konsole_Main_ArgsBeiProgrammstartMitgeben_Uebergabe
 * auf konsole ausgeführt:
 * 
 * Programm zum Testen einer Parameterübergabe bei programstart auf der konsole
 *
 * - Konsole öffnen
 * - ordnerpfad in der konsole eingeben (hier:):
 * 			C:\Users\marco ambord>_cd Documents\Java\Programme\JavaUebungen01 		& enter

 * 			
 * 		// normal kompilieren des quellcodes zu bytecode:    (konsolen-eingaben leichter mit dir und cd siehe 1.3.3. Kompilieren_Konsole_HalloWelt)
 * 			C:...>javac ArgsBeiProgrammstartMitgeben_Konsole_Uebergabe.java 		& enter		
 * 
 * 		// & dann programmstart inklusive mitgabe der gewünschten Argumente (parameters) (argumente werden dann bei der ausgabe mitausgespuckt)  :
 * 			C:...>java ArgsBeiProgrammstartMitgeben_Konsole_Uebergabe TESTARGUMENT TESTARGUMENT2	& enter	 	
 */

public class Konsole_Main_ArgsBeiProgrammstartMitgeben_Uebergabe {
    public static void main (String args[]) {			//  args[] ist arrayvariabel mit name args vom Typ String:  mehrere Parameter möglich!!
        System.out.println("Der Parameter war: " + args[0] + " " + args[1]);	// + args[0] -> macht, dass das mitgegebene argument println-mässig ausgespuckt wird
    }
}