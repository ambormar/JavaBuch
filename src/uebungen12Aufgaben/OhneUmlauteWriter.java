/* TODO 12.5.   Aufgabe 3, s.394, (OUT - OhneUmlauteWriter extends FilterWriter)
 * class OhneUmlauteWriter & class  IO_FilterWriter_OhneUmlautWriter_DateiSpeichern_Anchorlayout_TextOhneUmlaute1
 * 
 * 	SIEHE: 		12.3.3.   VerschluesseltWriter extends FilterWriter		s.370 uf, (OUT) (VerschluesseltWriter extends FilterWriter) 
 *  
 * 
 * VORGEHEN:	klasse filterwriter erweitern durch die class OhneUmlauteWriter
 * 
 * 				- überschreiben der methode write(int c) der superklasse,
 * 					dabei mit switch-case die auszuschreibenden zeichen so manipulieren wie man will, (hier die Umlaute ä, ö, ü + f durch ae, oe und ue + ph ersetzen.)
 * 
 * 			---->		- write(int c)
 * 			|
 * 			|	- 2 andere methoden der class OhneUmlauteWriter überschreiben 2 weiter methoden der superklasse filterwriter
 * 			|		dabei greiffen sie aber auf die manipulierte methode writ(int c) ihrer eigenen klasse zu
 * 			|
 * 			|___		- write(char[] c, int offset, int count)
 * 			---->
 * 			|			- write(String s, int offset, int count)
 * 			|		
 * 			|	- 2 weitere methoden greifen jeweils wieder auf die überschriebenen methoden der eigenen klasse zu
 * 			|
 * 			|			- write(char[] c)
 * 			|___
 * 						- write(String s)
 * 
 * K&K:	Klasse OhneUmlautWriter. 
 * 		Die von der Klasse FilterWriter abgeleitete Klasse soll beim Schreiben die Umlaute ä, ö, ü + f durch ae, oe und ue + ph ersetzen.
 * 
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
		switch ((char) c){				// char casten (aufzwingen) damit man im switch direkt die zeichen schreiben kann + nicht mühsam die deziamale schreibweise benutzen muss
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
	
	// zusätzliche methode zum schreiben eines kompletten char-arrays:	 write(char[] c) 	(ohne int offset, int count)
	public void write(char[] c) throws IOException { 
		write(c, 0, c.length); // greift auf methode write(char[] c, int offset, int count) dieser klasse zu (also ohne super.)...
	}						// ... unter mitgabe der parameter c[], offset 0, count = c.length
	
	// methode zum überschreiben von write(String c, int offset, int count)
	// überschreibt zwar selbige methode der superklasse greift aber auf write(int c) von oben zu, als ohne super.write(...), verschlüsselung findet in methode oben statt
	public void write(String s, int offset, int count) throws IOException { // schreibt count zeichen des strings s ab index offset in den stream
		for (int i= 0; i < count; i++) {  // for-schleife: ACHTUNG: i < count (=> i < anzahl zeichen) NICHT: i< s.lenght
			write(s.charAt(offset + i)); // methode write(int c) von oben wird aufgerufen und das zeichen vom String s an der stelle charAt[ab offset plus i] als parameter übergeben
		}
	}
	
	// zusätzliche methode zum schreiben zum schreiben eines kompletten strings:  write(String s)	ohne int offset, int count
	public void write(String s) throws IOException { 
		write(s, 0, s.length()); // greift auf methode write(String s, int offset, int count) dieser klasse zu (also ohne super.)...
	}							// ... unter mitgabe der parameter s, offset 0, count = s.length()
}
