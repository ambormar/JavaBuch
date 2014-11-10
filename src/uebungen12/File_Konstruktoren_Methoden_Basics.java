/* TODO 12.1.   s.349
 * class File_Konstruktoren_Methoden_Basics
 * 
 * 	BASICS ZUR KLASSE FILE:
 * 		
 * 			=> import:		java.io.File
 * 
 * 			=> ACHTUNG:		objekt der Klasse File kann stehen f�r:		1. datei-name
 * 																		2. verzeichnis-name 
 * 
 * 			=> Verzeichnisstrukturen verschiedener Plattformen:		->	java funktioniert mit den jeweiligen plattform-abh�ngigen verzeichnisstrukturen
 * 				WINDOWS:	C:\		= an datentr�ger gebundener backslash							// vergl. linux.:		/		(= wurzelverzeichniss)
 * 							\		= trennzeichen zwischen verzeichnissnamen						// 		   linux:		/		(= trenzeichen)
 * 
 * 			=> Grunds�tzlich f�r das arbeiten mit File:		die objektinstanzen die man mit der Klasse File erstellt, sind nur ENTSPRECHUNGEN der realen 
 * 															dateien/verzeichnisse, mittels derer man z.b. Dateien / verzeichnisse miteinander vergleichen, 
 * 															bzw. beliebige methoden der Klasse File auf diese realen Dateien/verzeichnisse indirekt anwenden kann.
 * 															
 * 															=> die objektinstanzen von File SIND NICHT die dateien / verzeichnisse selbst
 * 
 *  		=> ACHTUNG: 	-> der name eines FileObjekts ist nur ein Variabelname, nicht etwa ein g�ltiger datei-oder verzeichnisname
 * 							-> der name einer gesuchten Datei/verzeichnises wird dem konstruktor beim erzeugen des FileObjekts als Parameter �bergeben.
 * 							-> man kann unabh�ngig vom dateisystem beliebige File-Objekte erstellen. diese k�nnen, m�ssen aber nicht unbedingt eine 
 * 							   entsprechung im dateisystem haben.
 * 
 *	3 KONSTRUKTOREN VON FILE:		
 * 
 *  	1.	File (String path)					path => datei oder verzeichnis-name mit pfad als string					 
 *  
 * 		2.	File (String dir, String name) 		dir => �bergeordnetes verzeichnis mit pfad als string; name => datei- oder verzeichnisname/restpfad als string		
 * 																		
 * 		3.	File (File dir, String name)		dir => �bergeordnetes verzeichnis mit pfad als File,; name => datei- oder verzeichnisname/restpfad als string			
 * 
 * 
 * 
 * 	METHODEN (WICHTIGE) VON FILE:
 * 
 *		public boolean canRead()			=> pr�ft auf leserecht
 *
 *		public boolean canWrite()			=> pr�ft auf schreibrecht
 *
 *		public boolean delete()				=> l�scht datei/verzeichnis, gibt true zur�ck falls l�schen erfolgreich war
 *
 *		public boolean exists()				=> gibt true zur�ck, wenn die datei im dateisystem existiert
 *
 *		public String getName()				=> gibt dateiname ohne pfad zur�ck
 *
 *		public String getParent()			=> gibt das �bergeordnete verzeichnis oder null zur�ck, falls es sich beim pfadanteil um hauptverzeichnis handelt
 *
 *		public String getPath()				=> gibt den pfad-anteil zur�ck (ohne dateiname?!)
 *
 *		public boolean isDirectory()		=> gibt true, falls es sich um verzeichnis handelt, sonst false
 *
 *		public boolean isFile()				=> gibt true, falls es sich um datei handelt, sont false
 *
 *		public long length()				=> liefert die dateigr�sse in bytes
 *
 *		public String[] list()				=> liefert ein string-array mit allen eintr�gen im betreffenden verzeichnis zur�ck
 *
 *		public boolean renameTo(File dest)	=> benennt die datei/verzeichnis in den namen des �bergebenen file-objekts um und gibt true wenn erfolgreich
 *
 * 
 */

package uebungen12;

public class File_Konstruktoren_Methoden_Basics {

}
