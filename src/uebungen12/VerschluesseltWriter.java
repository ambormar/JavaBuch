/* TODO 12.3.3.   s.370 uf,  (VerschluesseltWriter extends FilterWriter)
 * class VerschluesseltWriter extends FilterWriter
 * 
 * FILTERWRITER BASICS: 	SIEHE:		12.3.3.   FilterWriter_Basics_Methoden_Konstruktor		s.370 
 *  
 * KLASSE FILTERWRITER:	
 * 
 * 			=> ein FilterWriter abreitet immer mit einem anderen Writer-Objekt zusammen, welcher den eigentlichen schreibvorgang (z.b in eine datei) übernimmt
 * 			=> der FilterWriter bzw. (hier eigentlich) der VerschlüsseltWriter MANIPULIERT zuvor die zu schreibenden unicode-zeichen
 * 			=> der Writer ist das einzige attribut der basisklasse FilterWriter
 * 			=> der einzige Konstruktor von FilterWriter erwartet als Argument den Writer (mit dem er zusammen arbeiten soll
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
 * 		VORGEHEN:	=> einen eigenen VerschluesseltWriter von der basisklasse FilterWriter ableiten:		public class VerschluesseltWriter extends FilterWriter {
 * 					=> anstelle de übergebenen zeichens wird das um eine stelle in der unicodetabelle nach hinten versetzte zeichen geschrieben
 *  				=> die drei unten aufgezählten write-methoden sind nach eigenen vorstellungen zu implementieren
 * 					=> verschlüsselung des zu schreibenden texts ist in der write-methode für einzelnes zeichen ( .write(int c)) abzulesen...
 * 						-> ...die anderen methoden greifen auf diese zurück  	=> 	write(char [] c, offset, count) 	& 		write(String s, offset, count)
 * 					=> die methoden:	 write(char [] c)	&	write(String s) 	ohne offset und count, können wie vererbt verwendet werden
 * 	  				
 * 		EXCEPTION-HANDLING DER METHODEN V. FILTERWRITER:			
 *			
 *					=> throws IOException aller methoden von FilterWriter (s.s. 371) : 
 * 						-> die signatur ist quasi von der superklasse aufgezwungen, irgendwo in der write-methode der superklasse wird ...
 * 						-> ... eine bedingung mit throw new IOException geworfen...
 * 						-> ...somit muss dies im methoden-kopf solang als signatur an die näxtaufrufende methode übernommen (weitergegeben werden)...
 * 						-> ...bis man an geeigneter stelle beim methodenaufruf einen try-catch-block einbaut zum abfangen der IOException
 * 
 * 		SCHEMA (schnell):		genau siehe CODE unten
 * 
 * 			public class VerschluesseltWriter extends FilterWriter {	// eigene klasse VerschluesseltWriter (um zeichen zu manipulieren) erbt von FilterWriter (der eigtl. selber glaub nichts verschlüsselt)
 *		
 *				protected VerschluesseltWriter(Writer out) { 			// konstruktor von VerschlüsseltWriter gibt mit super an konstruktor von FilterWriter weiter
 *					super(out);											// FilterWriter arbeitet immer mit Writer-Objekt zusammen, FilterWriter verschlüsselt, Writer übernimmt schreibvorgang
 *				}
 * 
 *				public void write(int c) throws IOException {		// überschreiben der methode write(int c) der superklasse,	wichtigste methode,
 *					super.write(c + 1);  							// super nur hier nötig, die folgenden methoden greifen auf hier zurück
 * 				}													// schreibt anstelle des zeichens c das um eine stelle im unicode nach hinten verschobene zeichen
 *
 *	 			public void write(char[] c, int offset, int count) throws IOException{ 	// überschreibt write(char[] c, int offset, int count) der superklasse
 *					for (int i= 0; i< count; i++){ 										// ... greift aber auf write(int c) von oben zu, also ohne super.write(...)
 *						write(c [offset + i]); 											// ... genau siehe unten
 *					}						   
 *				} 
 *				
 *				public void write(char[] c) throws IOException { 	// zusätzl. meth. v. VerschluesseltWriter zum schreiben eines kompletten char-arrays:	 write(char[] c) 	(ohne int offset, int count)
 *					write(c, 0, c.length); 							// greift auf methode write(char[] c, int offset, int count) dieser klasse zu (also ohne super.)...
 *				}																
 *							
 *				public void write(String s, int offset, int count) throws IOException { // überschreibt write(String c, int offset, int count) der superklasse
 *					for (int i= 0; i < count; i++) { 								 	// ... greift aber auf write(int c) von oben zu, also ohne super.write(...)
 *						write(s.charAt(offset + i));	 								// ... genau siehe unten
 *					}
 *				}
 *	
 *				public void write(String s) throws IOException { 	// zusätzl. meth. v. VerschluesseltWriter zum schreiben eines kompletten strings:  write(String s)	ohne int offset, int count
 *					write(s, 0, s.length()); 						// greift auf methode write(String s, int offset, int count) dieser klasse zu (also ohne super.)...
 *				}													
 *			} 
 *
 */

package uebungen12;

import java.io.FilterWriter;
// FilterWriter arbeitet immer mit Writer-Objekt zusammen
import java.io.Writer;
import java.io.IOException; // in der FilterWriterklasse ist eine IOException implementiert, muss hier in der signatur der entsprechenden methoden übernommen werden
					

public class VerschluesseltWriter extends FilterWriter {
	// d. konstruktor v. VerschluesseltWriter ruft lediglich den konstruktor der basisklasse FilterWriter auf, FilterWriter erwartet als argument ein Writer-objekt, 
	protected VerschluesseltWriter(Writer out) { // FilterWriter arbeitet immer mit Writer-Objekt zusammen, FilterWriter verschlüsselt, Writer übernimmt schreibvorgang
		super(out);						
	}
	
	// methode zum überschreiben von write mit einem zeichen (dezimale schreibweise), wichtigste methode, die folgenden greifen darauf zurück
	public void write(int c) throws IOException {// überschreiben der methode write(int c) der superklasse, throws IOException siehe oben
		super.write(c + 1);  // super nur hier nötig, die folgenden methoden greifen auf hier zurück
	}					// schreibt anstelle des zeichens c das um eine stelle im unicode nach hinten verschobene zeichen
	
	// methode zum überschreiben von write(char[] c, int offset, int count) 
	// überschreibt zwar selbige methode der superklasse greift aber auf write(int c) von oben zu, also ohne super.write(...), verschlüsselung findet in methode oben statt
	public void write(char[] c, int offset, int count) throws IOException{ // schreibt count(anz) zeichen des char[]-arrays c, ab (start)index offset in den stream
		for (int i= 0; i< count; i++){ // for-schleife: ACHTUNG: i < count (=> i < anzahl zeichen) NICHT: i< c.lenght
			write(c [offset + i]); // methode write(int c) von oben wird aufgerufen und das zeichen c[ab offset plus i] als parameter übergeben
		}						   // maaannnn eee....
	}

	public void write(char[] c) throws IOException { // zusätzliche methode zum schreiben eines kompletten char-arrays:	 write(char[] c) 	(ohne int offset, int count)
		write(c, 0, c.length); // greift auf methode write(char[] c, int offset, int count) dieser klasse zu (also ohne super.)...
	}						// ... unter mitgabe der parameter c[], offset 0, count = c.length
	
	// methode zum überschreiben von write(String c, int offset, int count)
	// überschreibt zwar selbige methode der superklasse greift aber auf write(int c) von oben zu, als ohne super.write(...), verschlüsselung findet in methode oben statt
	public void write(String s, int offset, int count) throws IOException { // schreibt count zeichen des strings s ab index offset in den stream
		for (int i= 0; i < count; i++) {  // for-schleife: ACHTUNG: i < count (=> i < anzahl zeichen) NICHT: i< s.lenght
			write(s.charAt(offset + i)); // methode write(int c) von oben wird aufgerufen und das zeichen vom String s an der stelle charAt[ab offset plus i] als parameter übergeben
		}
	}
	
	public void write(String s) throws IOException { // zusätzliche methode zum schreiben zum schreiben eines kompletten strings:  write(String s)	ohne int offset, int count
		write(s, 0, s.length()); // greift auf methode write(String s, int offset, int count) dieser klasse zu (also ohne super.)...
	}							// ... unter mitgabe der parameter s, offset 0, count = s.length()
}
