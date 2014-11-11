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
 * 		RELATIVEN, PLATTFORMUNABH�NGIGEN PFAD DER ZUM AKTUELLEN VERZEICHNIS F�HRT (verzeichnis in dem man bereits ist):
 * 
 *  		private String dateiname = "." + File.separator + "kontakte.dat";				=> "relativer pfad" besteht aus: "." (=aktuelles verzeichnis) + File.separator (= plattformunabh�ngiges trennzeichen) + dateiname.dat
 *																				
 *
 *		RELATIVEN, PLATTFORMUNABH�NGIGEN PFAD ZUM AKTUELLEN VERZEICHNIS & IM PACKAGE EXPLORER AUCH SICHTBAR:
 *
 *			private String dateiname = "./dokumente/" + File.separator + "kontakte.dat";	=>	statt "." -> "./dokumente/" & ein dokumentordner in JavaBuch, dann kann man auch im Package explorer die dateien sehen *
 *
 *
 *		RELATIVEN PFAD ZUM AKTUELLEN VERZEICHNIS, WINDOWS-SPEZIFISCH (NICHT BENUTZEN WEIL PLATTFORMABH�NGIG):
 *			
 *			private String dateiname = ".\\kontakte.dat";									=>  file-separator: 	\\	=> windows-spezifischer
 *
 *
 *		ABSOLUTER PFAD:		=> komplette jeweilige gew�nschte pfadanngabe 					=> 	nachteil: kompliziert & unn�tig
 *		
 *			
 */

package uebungen12;

public class Pfad_Relativ_ZuAktuellemVerzeichnis_IO {

}
