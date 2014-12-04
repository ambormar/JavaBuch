/* TODO 12.3.4.   s.372, (IN) (ZeichenOrientierte Datenstreams)!!!!!!!!!!!!!!!
 * class FilterReader_Basics_Methoden_Konstruktor
 * 
 * EIGENEN VERSCHLUESSELTREADER VON DER BASISKLASSE ABLEITEN: 	SIEHE:		12.3.4.   VerschluesseltReader (extends FilterReader)	s.373 
 *  
 * KLASSE FILTERREADER:	
 * 
 * 			=> die klasse FilterReader ist analog zum FilterWriter angelegt.
 * 			=> ein FilterReader abreitet immer mit einem Reader-Objekt zusammen, welches den eigentlichen lesevorgang (z.b aus einer datei) übernimmt
 * 			=> vom Reader übernimmt der FilterReader [bzw. eine davon erbende klasse (z.b. VerschluesseltReader)] die unicode-zeichen, um sie zu bearbeiten / entschlüsseln
 * 			=> der Reader ist das einzige attribut der basisklasse FilterReader				(irgendeinen Reader, z.b. FileReader)
 * 			=> der einzige Konstruktor von FilterReader erwartet als Argument einen Reader (irgendeinen Reader, z.b. FileReader) mit dem er zusammen arbeiten soll
 * 
 * 	KONSTRUKTOR:  	protected FilterReader(Reader in) 	// protected => paket-sichtbarkeit erweitert: 	zugriff auf attribute & methoden für alle klassen aus
 * 																								 		demselben paket & AUCH für Unterklassen aus anderen paketen
 *
 * 	IMPORT:			java.io.FilterReader	&	java.io.Reader	&	java.io.IOException
 * 
 * 	METHODEN V. FILTERREADER:							// (überschreibbare) wichtige Methoden von superklasse FilterReader:)
 * 
 * 		- void close()									: schliesst den Stream
 * 		- void mark(int readAheadLimit)					: markiert die augenblickliche position im stream. wird danach reset() aufgerufen, wird wieder an die
 * 														  markierte position gesprungen. dadurch können die gleichen zeichen mehrfach gelesen werden. (wozu??)	
 * 														  der parameter gibt an, nach wievielen gelesenen bytes die markierungen verfallen. (mal maja fragen)
 * 		- boolean markSupported()						: liefert zurück ob die markierung unterstützt wird.
 * 		- int read()									: liest ein zeichen aus dem stream & liefert es als unicode-zeichen zurück. 
 * 														  wurde kein zeichen gelesen weil das straem-ende erreicht ist, wird -1 zurückgegeben.										
 * 		- void read(char[] c, int offset, int count)	: versucht count zeichen aus dem stream zu lesen & im char-array c abzulegen. wird kein zeichen gelesen,
 * 														  weil das stream-ende bereits erreicht war, wird -1 zurückgeliefert. ansonsten wird die anzahl gelesener zeichen zurückgegeben
 * 		- boolean ready()								: liefert zurück, ob zeichen zum lesen im stream bereit stehen.
 * 		- void reset()									: springt zur position des streams, die zuvor markiert wurde.
 * 		- long skip(long n)								: versucht n zeichen im Stream zu überspringen. 
 * 														  liefert die zahl der tatsächlich übersprungenen bytes zurück. 
 * 
 * 
 * 
 * 					AB HIER NOCH ÜBERARBEITEN & AUF FILTERREADER ANPASSEN S. 373 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * 
 * 
 * 
 * 	EIGENEN VERSCHLUESSELTREADER VON DER BASISKLASSE FILTERREADER ABLEITEN:
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
 * 	EXCEPTION-HANDLING DER METHODEN V. FILTERREADER:			
 *			
 *					=> throws IOException aller methoden von FilterReader (s.s. 373) : 
 * 						-> die signatur ist quasi von der superklasse aufgezwungen, irgendwo in der read-methode der superklasse wird ...
 * 						-> ... eine bedingung mit throw new IOException geworfen...
 * 						-> ...somit muss dies im methoden-kopf solang als signatur an die näxtaufrufende methode übernommen (weitergegeben werden)...
 * 						-> ...bis man an geeigneter stelle beim methodenaufruf einen try-catch-block einbaut zum abfangen der IOException
 */

package uebungen12;

public class FilterReader_Basics_Methoden_Konstruktor {

}
