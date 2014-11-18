/* TODO 12.3.3,   s.370 
 * class FilterWriter_Basics_Methoden_Konstruktor
 * 
 * EIGENEN FILTERWRITER VON DER BASISKLASSE ABLEITEN: 	SIEHE:		12.3.3.   FilterWriter_VerschluesseltWriter		s.370 uf
 *  
 * KLASSE FILTERWRITER:	
 * 
 * 			=> ein FilterWriter abreitet immer mit einem anderen Writer-Objekt zusammen, welcher den eigentlichen schreibvorgang (z.b in eine datei) �bernimmt
 * 			=> der FilterWriter MANIPULIERT zuvor die zu schreibenden unicode-zeichen
 * 			=> der Writer ist das einzige attribut der basisklasse FilterWriter
 * 			=> der einzige Konstruktor von FilterWriter erwartet als Argument den Writer (mit dem er zusammen arbeiten soll
 * 
 * 	KONSTRUKTOR:  	protected FilterWriter(Writer out) 	// protected => paket-sichtbarkeit erweitert: 	zugriff auf attribute & methoden f�r alle klassen aus
 * 																								 		demselben paket & AUCH f�r Unterklassen aus anderen paketen
 * 	IMPORT:			java.io.FilterWriter
 * 
 * 	METHODEN V. FILTERWRITER:							// (�berschreibbare) wichtige Methoden von superklasse FilterWriter:)
 * 
 * 		- void close()										: schliesst den Stream
 * 		- void flush()										: gepufferte daten werden geschrieben
 * 		- void write(int c)									: schreibt int c (= 2 niederwertige bytes in dezimaler schreibweise > s.77) als unicodezeichen in den stream 	
 * 		- void write(char[] c, int offset, int count)		: schreibt count zeichen des char[]-arrays c, ab index offset in den stream
 * 	 	- void write(String c, int offset, int count)		: schreibt count zeichen des strings s ab index offset in den stream  
 * 
 * 	EIGENEN FILTERWRITER VON DER BASISKLASSE ABLEITEN:
 * 
 * 		SIEHE EIGNTL.:		12.3.3.   FilterWriter_VerschluesseltWriter		s.370 uf
 * 
 * 		VORGEHEN:	=> einen eigenen FilterWriter_Verschluesselt von der basisklasse FilterWriter ableiten:
 * 					=> anstelle de �bergebenen zeichens wird das um eine stelle in der unicodetabelle nach hinten versetzte zeichen geschrieben
 *  				=> die drei unten aufgez�hlten write-methoden sind nach eigenen vorstellungen zu implementieren
 * 					=> verschl�sselung des zu schreibenden texts ist in der write-methode f�r einzelnes zeichen ( .write(int c)) abzulesen...
 * 						-> ...die anderen methoden greifen auf diese zur�ck  	=> 	write(char [] c, offset, count) 	& 		write(String s, offset, count)
 * 					=> die methoden:	 write(char [] c)	&	write(String s) 	ohne offset und count, k�nnen wie vererbt verwendet werden
 * 	  				
 * 	EXCEPTION-HANDLING DER METHODEN V. FILTERWRITER:			
 *			
 *					=> throws IOException aller methoden von FilterWriter (s.s. 371) : 
 * 						-> die signatur ist quasi von der superklasse aufgezwungen, irgendwo in der write-methode der superklasse wird ...
 * 						-> ... eine bedingung mit throw new IOException geworfen...
 * 						-> ...somit muss dies im methoden-kopf solang als signatur an die n�xtaufrufende methode �bernommen (weitergegeben werden)...
 * 						-> ...bis man an geeigneter stelle beim methodenaufruf einen try-catch-block einbaut zum abfangen der IOException
 */

package uebungen12;

public class FilterWriter_Basics_Methoden_Konstruktor {

}
