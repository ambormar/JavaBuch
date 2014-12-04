/* TODO 12.3.4.   s.373, (IN) (VerschluesseltReader extends FilterReader) !!!!!!!!!!!!!!!
 * class VerschluesseltReader extends FilterReader
 * 
 * FILTERREADER BASICS: 	SIEHE:		12.3.4.   FilterReader_Basics_Methoden_Konstruktor		s.372 
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
 * 		- void read(char[] c, int offset, int count)	: versucht count zeichen aus dem stream zu lesen & im char-array c abzulegen. wird kein zeichen gelesen,
 * 														  weil das stream-ende bereits erreicht war, wird -1 zur�ckgeliefert. ansonsten wird die anzahl gelesener zeichen zur�ckgegeben
 * 		- boolean ready()								: liefert zur�ck, ob zeichen zum lesen im stream bereit stehen.
 * 		- void reset()									: springt zur position des streams, die zuvor markiert wurde.
 * 		- long skip(long n)								: versucht n zeichen im Stream zu �berspringen. 
 * 														  liefert die zahl der tats�chlich �bersprungenen bytes (also zeichen x 2) zur�ck. 
 * 
 * 
 * 	EIGENEN VERSCHLUESSELTREADER VON DER BASISKLASSE FILTERREADER ABLEITEN:
 * 
 * 		VORGEHEN:	=> einen eigenen VerschluesseltReader von der basisklasse FilterReader ableiten:		public class VerschluesseltReader extends FilterReader {
 * 					=> z.b. beim lesen eines zeichens wird die verschiebung in der unicodetabelle um eins nach hinten wieder r�ckg�ngig gemacht
 *  				=> Die METHODEN ZUM LESEN NACH EIGENEN VORSTELLUNGEN IMPLEMENTIEREN, alle anderen methoden k�nnen wie vererbt verwendet werden 
 *  
 *  
 * 		!!!!!!!!!!!!!!!!!     AB HIER NOCH �BERARBEITEN & AUF FILTERREADER ANPASSEN S. 373 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * 
 * 
 * 					=> verschl�sselung des zu schreibenden texts ist in der write-methode f�r einzelnes zeichen ( .write(int c)) abzulesen...
 * 						-> ...die anderen methoden greifen auf diese zur�ck  	=> 	write(char [] c, offset, count) 	& 		write(String s, offset, count)
 * 					=> als zus�tzliche methoden der klasse Verschl�esseltWriter:	 write(char [] c)	&	write(String s) 	ohne offset und count...
 * 							... wurden 2 methoden definiert die ein komplettes Char-Array bzw einen kompletten String schreiben. 
 * 								-> sie greifen zu auf => 	write(char [] c, offset, count) 	& 		write(String s, offset, count)
 * 	  				
 * 	EXCEPTION-HANDLING DER METHODEN V. FILTERREADER:			
 *			
 *					=> throws IOException aller methoden von FilterReader (s.s. 373) : 
 * 						-> die signatur ist quasi von der superklasse aufgezwungen, irgendwo in der read-methode der superklasse wird ...
 * 						-> ... eine bedingung mit throw new IOException geworfen...
 * 						-> ...somit muss dies im methoden-kopf solang als signatur an die n�xtaufrufende methode �bernommen (weitergegeben werden)...
 * 						-> ...bis man an geeigneter stelle beim methodenaufruf einen try-catch-block einbaut zum abfangen der IOException
 * 
 * 		SCHEMA (schnell):		genau siehe CODE unten
 * 
 * 			public class VerschluesseltWriter extends FilterWriter {	// eigene klasse VerschluesseltWriter (um zeichen zu manipulieren) erbt von FilterWriter (der eigtl. selber glaub nichts verschl�sselt)
 *		
 *				protected VerschluesseltWriter(Writer out) { 			// konstruktor von Verschl�sseltWriter gibt mit super an konstruktor von FilterWriter weiter
 *					super(out);											// FilterWriter arbeitet immer mit Writer-Objekt zusammen, FilterWriter verschl�sselt, Writer �bernimmt schreibvorgang
 *				}
 * 
 *	 			public void write(int c) throws IOException {		// �berschreiben der methode write(int c) der superklasse,	wichtigste methode,
 *	-->				super.write(c + 1);  							// super nur hier n�tig, die folgenden methoden greifen auf hier zur�ck
 * 	|			}													// schreibt anstelle des zeichens c das um eine stelle im unicode nach hinten verschobene zeichen
 *	|	
 *	| 		->	public void write(char[] c, int offset, int count) throws IOException{ 	// �berschreibt write(char[] c, int offset, int count) der superklasse
 *	|		|		for (int i= 0; i< count; i++){ 										// ... greift aber auf write(int c) von oben zu, also ohne super.write(...)
 *	|--<	|	 		write(c [offset + i]); 											// ... genau siehe unten
 *	|		|		}						   
 *	|		|	} 
 *	|		|	
 *	|		|	public void write(char[] c) throws IOException { 	// zus�tzl. meth. v. VerschluesseltWriter zum schreiben eines kompletten char-arrays:	 write(char[] c) 	(ohne int offset, int count)
 *	|		|_		write(c, 0, c.length); 							// greift auf methode write(char[] c, int offset, int count) dieser klasse zu (also ohne super.)...
 *	|			}																
 *	|						
 *	|		->	public void write(String s, int offset, int count) throws IOException { // �berschreibt write(String c, int offset, int count) der superklasse
 *	|		|		for (int i= 0; i < count; i++) { 								 	// ... greift aber auf write(int c) von oben zu, also ohne super.write(...)
 *	|--<	|			write(s.charAt(offset + i));	 								// ... genau siehe unten
 *			|		}
 *			|	}
 *			|
 *			|	public void write(String s) throws IOException { 	// zus�tzl. meth. v. VerschluesseltWriter zum schreiben eines kompletten strings:  write(String s)	ohne int offset, int count
 *			|_		write(s, 0, s.length()); 						// greift auf methode write(String s, int offset, int count) dieser klasse zu (also ohne super.)...
 *				}													
 *			} 
 *
 */

package uebungen12;

import java.io.FilterReader;
// FilterReader arbeitet immer mit einem Reader-Objekt zusammen
import java.io.Reader;
import java.io.IOException; // in der FilterReaderklasse ist eine IOException implementiert, muss hier in der signatur der entsprechenden methoden �bernommen werden
					

public class VerschluesseltReader extends FilterReader {
	// d. konstruktor v. VerschluesseltReader ruft lediglich den konstruktor der basisklasse FilterReader auf, FilterReader erwartet als argument ein Reader-objekt, 
	protected VerschluesseltReader(Reader in) { // FilterReader arbeitet immer mit Reader-Objekt zusammen, FilterReader entschl�sselt, Reader �bernimmt lesevorgang
		super(in);								// 
	}
	
	
	
}
