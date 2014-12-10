/* TODO 12.3.4.   s.372, (IN) (ZeichenOrientierte Datenstreams)
 * class FilterReader_Basics_Methoden_Konstruktor
 * 
 * EIGENEN VERSCHLUESSELTREADER VON DER BASISKLASSE ABLEITEN: 	SIEHE:		12.3.4.   VerschluesseltReader (extends FilterReader)	s.373 
 *  
 * KLASSE FILTERREADER:	
 * 
 * 			=> die klasse FilterReader ist analog zum FilterWriter angelegt.
 * 			=> ein FilterReader abreitet immer mit einem Reader-Objekt zusammen, welches den eigentlichen lesevorgang (z.b aus einer datei) �bernimmt
 * 			=> vom Reader �bernimmt der FilterReader [bzw. eine davon erbende klasse (z.b. VerschluesseltReader)] die unicode-zeichen, um sie zu bearbeiten / entschl�sseln
 * 			=> der Reader ist das einzige attribut der basisklasse FilterReader				(irgendeinen Reader, z.b. FileReader)
 * 			=> der einzige Konstruktor von FilterReader erwartet als Argument einen Reader (irgendeinen Reader, z.b. FileReader) mit dem er zusammen arbeiten soll
 * 
 * 	KONSTRUKTOR:  	protected FilterReader(Reader in) 	// protected => paket-sichtbarkeit erweitert: 	zugriff auf attribute & methoden f�r alle klassen aus
 * 																								 		demselben paket & AUCH f�r Unterklassen aus anderen paketen
 *
 * 	IMPORT:			java.io.FilterReader	&	java.io.Reader	&	java.io.IOException
 * 
 * 	METHODEN V. FILTERREADER:							// (�berschreibbare) wichtige Methoden von superklasse FilterReader:)
 * 
 * 		- void close()									: schliesst den Stream
 * 		- void mark(int readAheadLimit)					: markiert die augenblickliche position im stream. wird danach reset() aufgerufen, wird wieder an die
 * 														  markierte position gesprungen. dadurch k�nnen die gleichen zeichen mehrfach gelesen werden. (wozu??)	
 * 														  der parameter gibt an, nach wievielen gelesenen bytes die markierungen verfallen. (mal maja fragen)
 * 		- boolean markSupported()						: liefert zur�ck ob die markierung unterst�tzt wird.
 * 		- int read()									: liest ein zeichen aus dem stream & liefert es als unicode-zeichen zur�ck. 
 * 														  wurde kein zeichen gelesen weil das straem-ende erreicht ist, wird -1 zur�ckgegeben.										
 * 		- int read(char[] c, int offset, int count)	: versucht count zeichen aus dem stream zu lesen & im char-array c abzulegen. wird kein zeichen gelesen,
 * 														  weil das stream-ende bereits erreicht war, wird -1 zur�ckgeliefert. ansonsten wird die anzahl gelesener zeichen zur�ckgegeben
 * 		- boolean ready()								: liefert zur�ck, ob zeichen zum lesen im stream bereit stehen.
 * 		- void reset()									: springt zur position des streams, die zuvor markiert wurde.
 * 		- long skip(long n)								: versucht n zeichen im Stream zu �berspringen. 
 * 														  liefert die zahl der tats�chlich �bersprungenen bytes zur�ck. 
 * 
 * 
 *[ EIGENEN VERSCHLUESSELTREADER VON DER BASISKLASSE FILTERREADER ABLEITEN:
 * 
 * 		SIEHE EIGNTL.:		12.3.3.   VerschluesseltReader (extends FilterReader)		12.3.4.   s.373 (IN)
 * 
 * 		VORGEHEN:	=> einen eigenen VerschluesseltReader von der basisklasse FilterReader ableiten:		public class VerschluesseltReader extends FilterReader {
 * 					=> z.b. beim lesen eines zeichens wird die verschiebung in der unicodetabelle um eins nach hinten wieder r�ckg�ngig gemacht
 *  				=> Die METHODEN ZUM LESEN NACH EIGENEN VORSTELLUNGEN IMPLEMENTIEREN (= ENTSPRECHEND DEM VERSCHL�SSELTWRITER), alle anderen methoden k�nnen wie vererbt verwendet werden 
 *  				=> entschl�sselung des einzulesenden texts wird gemacht durch �berschreiben.. :    
 *  						.. der read-methode f�r einzelnes zeichen 			int read() {..}		 													-> siehe code VerschluesseltReader	
 *  						&  der read-methode f�r char-arrays 				int read(char[] c, int offset, int count) { ..}	
 *  																			-> hier in 2 schritten:  1. originaldaten einlesen	&	2. dekodieren	-> siehe code VerschluesseltReader
 * 	  				
 * 		EXCEPTION-HANDLING DER METHODEN V. FILTERREADER:			
 *			
 *					=> throws IOException aller methoden von FilterReader (s.s. 373) : 
 * 						-> die signatur ist quasi von der superklasse aufgezwungen, irgendwo in der read-methode der superklasse wird ...
 * 						-> ... eine bedingung mit throw new IOException geworfen...
 * 						-> ...somit muss dies im methoden-kopf solang als signatur an die n�xtaufrufende methode �bernommen (weitergegeben werden)...
 * 						-> ...bis man an geeigneter stelle beim methodenaufruf einen try-catch-block einbaut zum abfangen der IOException					]
 */

package uebungen12;

public class FilterReader_Basics_Methoden_Konstruktor {

}
