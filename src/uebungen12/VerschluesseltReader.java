/* TODO 12.3.4.   s.373, (IN) (VerschluesseltReader extends FilterReader) 
 * class VerschluesseltReader extends FilterReader
 * 
 * FILTERREADER BASICS: 	SIEHE:		12.3.4.   FilterReader_Basics_Methoden_Konstruktor		s.372 
 *  
 *[ KLASSE FILTERREADER:	
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
 * 		- int read(char[] c, int offset, int count)		: versucht count zeichen aus dem stream zu lesen & im char-array c abzulegen. wird kein zeichen gelesen,
 * 														  weil das stream-ende bereits erreicht war, wird -1 zurückgeliefert. ansonsten wird die anzahl gelesener zeichen zurückgegeben
 * 		- boolean ready()								: liefert zurück, ob zeichen zum lesen im stream bereit stehen.
 * 		- void reset()									: springt zur position des streams, die zuvor markiert wurde.
 * 		- long skip(long n)								: versucht n zeichen im Stream zu überspringen. 
 * 														  liefert die zahl der tatsächlich übersprungenen bytes (also zeichen x 2) zurück. 				]
 * 
 * 
 * 	EIGENEN VERSCHLUESSELTREADER VON DER BASISKLASSE FILTERREADER ABLEITEN:
 * 
 * 		VORGEHEN:	=> einen eigenen VerschluesseltReader von der basisklasse FilterReader ableiten:		public class VerschluesseltReader extends FilterReader {
 * 					=> z.b. beim lesen eines zeichens wird die verschiebung in der unicodetabelle um eins nach hinten wieder rückgängig gemacht
 *  				=> Die METHODEN ZUM LESEN NACH EIGENEN VORSTELLUNGEN IMPLEMENTIEREN (= ENTSPRECHEND DEM VERSCHLÜSSELTWRITER), alle anderen methoden können wie von FilterReader vererbt verwendet werden 
 *  				=> entschlüsselung des einzulesenden texts wird gemacht durch überschreiben.. :    
 *  						.. der read-methode für einzelnes zeichen 			int read() {..}		 													-> siehe code	
 *  						&  der read-methode für char-arrays 				int read(char[] c, int offset, int count) { ..}	
 *  																			-> hier in 2 schritten:  1. originaldaten einlesen	&	2. dekodieren	-> siehe code
 * 	  				
 * 		EXCEPTION-HANDLING DER METHODEN V. FILTERREADER:			
 *			
 *					=> throws IOException aller methoden von FilterReader (s.s. 373) : 
 * 						-> die signatur ist quasi von der superklasse aufgezwungen, irgendwo in der read-methode der superklasse wird ...
 * 						-> ... eine bedingung mit throw new IOException geworfen...
 * 						-> ...somit muss dies im methoden-kopf solang als signatur an die näxtaufrufende methode übernommen (weitergegeben werden)...
 * 						-> ...bis man an geeigneter stelle beim methodenaufruf einen try-catch-block einbaut zum abfangen der IOException
 * 
 * 		SCHEMA:		siehe code unten
 * 
 * 
 */

package uebungen12;

import java.io.FilterReader;
// FilterReader arbeitet immer mit einem Reader-Objekt zusammen
import java.io.Reader;
import java.io.IOException; // in der FilterReaderklasse ist eine IOException implementiert, muss hier in der signatur der entsprechenden methoden übernommen werden
					

public class VerschluesseltReader extends FilterReader {
	// d. konstruktor v. VerschluesseltReader ruft lediglich den konstruktor der basisklasse FilterReader auf, FilterReader erwartet als argument ein Reader-objekt, 
	protected VerschluesseltReader(Reader in) { // FilterReader arbeitet immer mit Reader-Objekt zusammen, FilterReader entschlüsselt, Reader übernimmt lesevorgang
		super(in);								// (in weitergeben an superklassse)
	}
	
	// methode zum überschreiben der methode read() der superklasse
	public int read() throws IOException {		// throws IOException -> siehe oben
		return super.read() - 1;				// übergibt mit super. ans read() der superklasse, welches ein unicodezeichen als dezimalzahl/int zurückgibt, .. 
	}											// ..& verschiebt das übergebene zeichen mit -1 um eine position zurück
	
	// methode zum überschreiben der methode read(char[] c, int offset, int count) der superklasse;
	public int read(char[] c, int offset, int lenght) throws IOException {  // throws IOException -> siehe oben
		// 1. originaldaten einlesen:
		int result = super.read(c, offset, lenght);	// zeichen werden in das charArray c (welches man beim aufruf der methoode als parameter mitgeben muss) eingelesen ..
													// .. & in result wird die anzahl der gelesenen zeichen gespeichert		[remember: methode int read(char c,...) der superklasse gibt als int die anzahl der gelesenen zeichen zurück]
													// (befüllen des char-arrays c von (read(..) hier nicht mit for-schleife, das wird offensichtlich irgendwo in der superklasse erledigt))
		// 2. dekodieren:
		for (int i= 0; i < result; i++) {						// char-array c bearbeiten mit schleife von c[index: 0] bis c[index: anzahl gelesene zeichen = result von oben]
			c[i+offset] = (char) ( (int) c[i+offset] - 1 ); 	// jedes zeichen des char-arrays wird mit cast (int) in den zeichencode konvertiert & der zeichencode um eins reduziert..
		}														// ..& anschliessend wieder mit cast (char) in den datentyp char umgewandelt 
																// c[i+offset] weil:  index beginnend bei 0 + startzahl (offset) der ursprünglich zu bearbeitenden zeichen
		
		return result;		// gibt anzahl der gelesenen zeichen zurück [remember: methode int read(char c,...) der superklasse gibt die anzahl der gelesenen zeichen als int zurück]
	}
}
