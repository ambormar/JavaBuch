/* TODO 12.3.1.   eigene bemerkung 
 * class Pfad_Relativ_ZuAktuellemVerzeichnis_IO
 * 
 * 	RELATIVEN PFAD ZU AKTUELLEM VERZEICHNIS ERSTELLEN:	
 * 
 * 	& PFAD REGELN / ZEICHEN:	SIEHE AUCH:		12.3.1.	 Out_FileWriter_BufferedWriter_KontaktlisteMitSpeichern		s.364, (OUT) Daten aus programm in Datei ausschreiben
 *   											=>	abschnitt:		OUT (KERN-CODE):	DATEINAME ERZEUGEN MIT PFAD ZUM PROJEKTORDNER: )
 *   
 * 	BSPe  , ab S.366:
 * 
 * 		RELATIVEN, PLATTFORMUNABHÄNGIGEN PFAD DER ZUM AKTUELLEN VERZEICHNIS FÜHRT (verzeichnis in dem man bereits ist):
 * 
 *  		private String dateiname = "." + File.separator + "kontakte.dat";				=> "relativer pfad" besteht aus: "." (=aktuelles verzeichnis) + File.separator (= plattformunabhängiges trennzeichen) + dateiname.dat
 *																				
 *
 *		RELATIVEN, PLATTFORMUNABHÄNGIGEN PFAD ZUM AKTUELLEN VERZEICHNIS & IM PACKAGE EXPLORER AUCH SICHTBAR:
 *
 *			private String dateiname = "./dokumente/" + File.separator + "kontakte.dat";	=>	statt "." -> "./dokumente/" & ein dokumentordner in JavaBuch, dann kann man auch im Package explorer die dateien sehen *
 *
 *
 *		RELATIVEN PFAD ZUM AKTUELLEN VERZEICHNIS, WINDOWS-SPEZIFISCH (NICHT BENUTZEN WEIL PLATTFORMABHÄNGIG):
 *			
 *			private String dateiname = ".\\kontakte.dat";									=>  file-separator: 	\\	=> windows-spezifischer
 *
 *
 *		ABSOLUTER PFAD:		=> komplette jeweilige gewünschte pfadanngabe 					=> 	nachteil: kompliziert & unnötig
 *		
 *			
 */

package uebungen12;

public class Pfad_Relativ_ZuAktuellemVerzeichnis_IO {

}
