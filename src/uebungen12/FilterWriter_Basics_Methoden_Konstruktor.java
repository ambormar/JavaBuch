/*  (ZeichenOrientierte Datenstreams)
 * class FilterWriter_Basics_Methoden_Konstruktor
 * 
 * EIGENEN VERSCHLUESSELTWRITER VON DER BASISKLASSE ABLEITEN: 	SIEHE:		12.3.3.   VerschluesseltWriter (extends FilterWriter)	s.370 uf
 *  
 * KLASSE FILTERWRITER:	
 * 
 * 			=> ein FilterWriter abreitet immer mit einem anderen Writer-Objekt zusammen, welcher den eigentlichen schreibvorgang (z.b in eine datei) übernimmt
 * 			=> der FilterWriter [bzw. eine davon erbende klasse (z.b. VerschluesseltWriter)] MANIPULIERT zuvor die zu schreibenden unicode-zeichen
 * 			=> der Writer ist das einzige attribut der basisklasse FilterWriter				(irgendeinen Writer, z.b. FileWriter)
 * 			=> der einzige Konstruktor von FilterWriter erwartet als Argument einen Writer (irgendeinen Writer, z.b. FileWriter) mit dem er zusammen arbeiten soll.
 * 
 * 	KONSTRUKTOR:  	protected FilterWriter(Writer out) 	// protected => paket-sichtbarkeit erweitert: 	zugriff auf attribute & methoden für alle klassen aus
 * 																								 		demselben paket & AUCH für Unterklassen aus anderen paketen
 *
 * 	IMPORT:			java.io.FilterWriter	&	java.io.Writer	&	java.io.IOException
 * 
 * 	METHODEN V. FILTERWRITER:							// (überschreibbare) wichtige Methoden von superklasse FilterWriter:)
 * 
 * 		- void close()										: schliesst den Stream
 * 		- void flush()										: gepufferte daten werden geschrieben
 * 		- void write(int c)									: schreibt int c (= 2 niederwertige bytes in dezimaler schreibweise > s.77) als unicodezeichen in den stream 	
 * 		- void write(char[] c, int offset, int count)		: schreibt count zeichen des char[]-arrays c, ab index offset in den stream
 * 	 	- void write(String c, int offset, int count)		: schreibt count zeichen des strings s ab index offset in den stream  
 * 
 * 	EIGENEN VERSCHLUESSELTWRITER VON DER BASISKLASSE FILTERWRITER ABLEITEN:
 * 
 * 		SIEHE EIGNTL.:		12.3.3.   VerschluesseltWriter (extends FilterWriter)		s.370 uf
 * 
 * 		VORGEHEN:	=> einen eigenen VerschluesseltWriter von der basisklasse FilterWriter ableiten:		public class VerschluesseltWriter extends FilterWriter {
 * 					=> z.b. anstelle de übergebenen zeichens wird das um eine stelle in der unicodetabelle nach hinten versetzte zeichen geschrieben
 *  				=> DIE DREI unten aufgezählten WRITE-METHODEN sind NACH EIGENEN VORSTELLUNGEN zu IMPLEMENTIEREN
 * 					=> verschlüsselung des zu schreibenden texts ist in der write-methode für einzelnes zeichen ( .write(int c)) abzulesen...
 * 						-> ...die anderen methoden greifen auf diese zurück  	=> 	write(char [] c, offset, count) 	& 		write(String s, offset, count)
 * 					=> als zusätzliche methoden der klasse VerschlüesseltWriter:	 write(char [] c)	&	write(String s) 	ohne offset und count...
 * 							... wurden 2 methoden definiert die ein komplettes Char-Array bzw einen kompletten String schreiben. 
 * 								-> sie greifen zu auf => 	write(char [] c, offset, count) 	& 		write(String s, offset, count)
 * 	  				
 * 	EXCEPTION-HANDLING DER METHODEN V. FILTERWRITER:			
 *			
 *					=> throws IOException aller methoden von FilterReader (s.s. 371) : 
 * 						-> die signatur ist quasi von der superklasse aufgezwungen, irgendwo in der write-methode der superklasse wird ...
 * 						-> ... eine bedingung mit throw new IOException geworfen...
 * 						-> ...somit muss dies im methoden-kopf solang als signatur an die näxtaufrufende methode übernommen (weitergegeben werden)...
 * 						-> ...bis man an geeigneter stelle beim methodenaufruf einen try-catch-block einbaut zum abfangen der IOException
 */

package uebungen12;

public class FilterWriter_Basics_Methoden_Konstruktor {

}
