package uebungen01;

/* TODO .1.3.3,   s. 45, 
 * class Konsole_Kompilieren_HalloWelt
 * Programm erstellen und mittels konsole kompilieren und aufrufen
 * 
 * - zuerst erstellen des Quellcodes (also dieses hier)
 * - dann Konsole öffnen: windowsbutton > programme > zubehör > Eingabeaufforderung (=konsole)
 * - BESSER: windowstaste/windowsbutton & cmd & enter
 * 
 * - dann eingaben um programm auf konsole laufen zu lassen:
 * 		// ordnerpfad in der konsole eingeben, bis zum ordner , in dem sich die zu kompilierenden quellcodedateien befinden (hier: HalloWelt.java)
 * 		// ordnerpfad anpassen mit folgenden regeln (fehlerlose angaben inkl. abstände gross- & kleinschreibung):
 * 
 * 			C:\Users\marco ambord>_cd Documents\Java\Programme\JavaUebungen01 		& abschliessen mit enter, cd = change directory (unterstrich nicht tippen)
 * 
 * 		NOCH BESSER: ...>cd (abstand) & von offenem explorer den ordner, wo die datei drin ist einfach rüberziehen
 * 
 * 		// weiteres KONSOLEN-HANDLING für pfadeingabe:
 * 			...>dir & enter	:			für liste des letzgenannten ordners im konsolenpfad (hier: Documents wäre dann nächster pfadschritt den wir suchen) etc.
 * 			...>cd d (anfangsbuchstabe) & mit tab durch obige liste steppen bis finden von ordner document & enter (geht nur mit ordnern nicht mit dateien)
 * 			oder: ...>javac d (anfangsbuchstabe) & mit tab durch obige liste steppen bis finden von datei & enter (zum kompilieren/programmstart von dateien)

 * 			...>cd.. & enter:			um einen ordner hoch
 * 			...>exit & enter:			konsole schliessen (soll man anscheinend immer machen. warum?)
 * 			
 * 		// kompilieren des quellcodes zu bytecode (= aufruf des javacompilers):  
 * 			C:...>_javac Kompilieren_Konsole_HalloWelt.java 		& enter		so wird die datei HalloWelt.class erzeugt 
 * 																	(die übrigens im gleichen ordner wie HalloWelt.java abgelegt wird)
 * 
 * 		// & dann programmstart durch aufruf des Java-Interpreter (= übergabe des Bytecodes (HalloWelt.class) an Java-Interpreter) :
 * 			C:...>_java Kompilieren_Konsole_HalloWelt		& enter
 */

public class Konsole_Kompilieren_HalloWelt{
   public static void main(String args[]){	 	// (String[] args) oder (String args[]) möglich,  nicht aber: (String[] args[]) main-methode schluckt nur eindimensionale arrays
      System.out.println("Hallo zurueck!");	
   }
}