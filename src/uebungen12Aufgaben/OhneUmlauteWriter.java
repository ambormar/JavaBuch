/* TODO 12.5.   Aufgabe 2, s.394, (OUT - OhneUmlauteWriter extends FilterWriter)
 * class OhneUmlauteWriter 
 */

package uebungen12Aufgaben;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

public class OhneUmlauteWriter extends FilterWriter {
	
	// d. konstruktor v. VerschluesseltWriter ruft lediglich den konstruktor der basisklasse FilterWriter auf, FilterWriter erwartet als argument ein Writer-objekt, 
	protected OhneUmlauteWriter(Writer out) {	// FilterWriter arbeitet immer mit Writer-Objekt zusammen, FilterWriter verschlüsselt, Writer übernimmt schreibvorgang
		super(out);
	}
	
	// methode zum überschreiben von write mit einem zeichen (dezimale schreibweise), wichtigste methode, die folgenden greifen darauf zurück
	public void write (int c) throws IOException {	// überschreiben der methode write(int c) der superklasse, throws IOException siehe oben
		switch ((char) c){
			case 'ä':					// schreibt anstelle der zeichen ä, ö, ü, f, Ä, Ö, Ü, Ü, F die zeichen ae, oe, ue, ph, AE, OE, UE, PH
				super.write('a');		// super.write(..); ist nur in dieser methode nötig, die folgenden methoden greifen auf hier zurück
				super.write('e');
				break;
			case 'ö':
				super.write('o');
				super.write('e');
				break;
			case 'ü':
				super.write('u');
				super.write('e');
				break;
			case 'Ä':
				super.write('A');
				super.write('E');
				break;
			case 'Ö':
				super.write('O');
				super.write('E');
				break;
			case 'Ü':
				super.write('U');
				super.write('E');
				break;
			case 'f':
				super.write('p');
				super.write('h');
				break;
			case 'F':
				super.write('P');
				super.write('H');
				break;
			default:
				super.write(c);		// super nur in dieser methode nötig, die folgenden methoden greifen auf hier zurück
		}
	}
	
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
