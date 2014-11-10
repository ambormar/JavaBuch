/* TODO 12.3.3.   s.370 
 * class FilterWriter_Verschluesselt extends FilterWriter
 * 
 * einen eigenen Verschluesselt_FilterWriter von der basisklasse FilterWriter ableiten:
 *  	- die drei unten aufgezählten write-methoden sind nach eigenen vorstellungen zu implementieren
 * 		- verschlüsselung des zu schreibenden texts ist in der write-methode für einzelnes zeichen ( .write(int c)) abzulesen...
 * 		- ...die anderen methoden greifen auf diese zurück:  write(char [] c, offset, count) & write(String s, offset, count
 * 	  	- anstelle de übergebenen zeichens wird das um eine stelle in der unicodetabelle nach hinten versetzte zeichen geschrieben
 * 		- (die methoden write(char [] c) & write(String s) ohne offset und count können wie vererbt verwendet werden)
 *
 * (überschreibbare) wichtige Methoden von superklasse FilterWriter:
 * 	- void close()									: schliesst den Stream
 * 	- void flush()									: gepufferte daten werden geschrieben
 * 	- void write(int c)					: schreibt int c (also ein zeichen aus dem unicode in dezimaler schreibweise > s.77) in den stream 	
 * 	- void write(char[] c, int offset, int count)		: schreibt count zeichen des char[]-arrays c, ab index offset in den stream
 *  - void write(String c, int offset, int count)		: schreibt count zeichen des strings s ab index offset in den stream
 *  
 * throws IOException der methoden (s.s. 371 & 77) : 
 * 		- die signatur ist quasi von der superklasse aufgezwungen, irgendwo in der write-methode der superklasse wird ...
 * 		- ... eine bedingung mit throw new IOException geworfen...
 * 		- ...somit muss dies im methoden-kopf solang als signatur an die näxtaufrufende methode übernommen (weitergegeben werden)...
 * 		- ...bis man an geeigneter stelle beim methodenaufruf einen try-catch-block einbaut zum abfangen der exception
 */

package uebungen12;

import java.io.FilterWriter;
// FilterWriter arbeitet immer mit Writer-Objekt zusammen
import java.io.Writer;
import java.io.IOException; // in der FilterWriterklasse ist eine IOException implementiert, muss hier in der signatur der entsprechenden methoden übernommen werden
					

public class FilterWriter_Verschluesselt extends FilterWriter {
	// der einzige konstruktor der basisklasse FilterWriter erwartet als argument ein Writer-objekt, er ruft lediglich den konstruktor der basisklasse auf
	protected FilterWriter_Verschluesselt(Writer out) { // FilterWriter arbeitet immer mit Writer-Objekt zusammen, FilterWriter verschlüsselt, Writer übernimmt schreibvorgang
		super(out);						
	}
	
	// methode zum überschreiben von write mit einem zeichen (dezimale schreibweise), wichtigste methode, die folgenden greifen darauf zurück
	public void write(int c) throws IOException {// überschreiben der methode write(int c) der superklasse, throws IOException siehe oben
		super.write(c + 1);  // super nur hier nötig, die folgenden methoden greifen auf hier zurück
	}					// schreibt anstelle des zeichens c das um eine stelle im unicode nach hinten verschobene zeichen
	
	// methode zum überschreiben von write(char[] c, int offset, int count) 
	// überschreibt zwar selbige methode der superklasse greift aber auf write(int c) von oben zu, als ohne super.write(...), verschlüsselung findet in methode oben statt
	public void write(char[] c, int offset, int count) throws IOException{ // schreibt count(anz) zeichen des char[]-arrays c, ab (start)index offset in den stream
		for (int i= 0; i< count; i++){ // for-schleife: ACHTUNG: i < count (=> i < anzahl zeichen) NICHT: i< c.lenght
			write(c [offset + i]); // methode write(int c) von oben wird aufgerufen und das zeichen c[ab offset plus i] als parameter übergeben
		}						   // maaannnn eee....
	}

	public void write(char[] c) throws IOException { // methode zum überschreiben von write(char[] c) ohne int offset, int count
		write(c, 0, c.length); // greift auf methode write(char[] c, int offset, int count) dieser klasse zu (also ohne super.)...
	}						// ... unter mitgabe der parameter c[], offset 0, count = c.length
	
	// methode zum überschreiben von write(String c, int offset, int count)
	// überschreibt zwar selbige methode der superklasse greift aber auf write(int c) von oben zu, als ohne super.write(...), verschlüsselung findet in methode oben statt
	public void write(String s, int offset, int count) throws IOException { // schreibt count zeichen des strings s ab index offset in den stream
		for (int i= 0; i < count; i++) {  // for-schleife: ACHTUNG: i < count (=> i < anzahl zeichen) NICHT: i< s.lenght
			write(s.charAt(offset + i)); // methode write(int c) von oben wird aufgerufen und das zeichen vom String s an der stelle charAt[ab offset plus i] als parameter übergeben
		}
	}
	
	public void write(String s) throws IOException { // methode zum überschreiben von write(String s) ohne int offset, int count
		write(s, 0, s.length()); // greift auf methode write(String s, int offset, int count) dieser klasse zu (also ohne super.)...
	}							// ... unter mitgabe der parameter s, offset 0, count = s.length()
}
