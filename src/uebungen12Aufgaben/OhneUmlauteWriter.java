/* TODO 12.5.   Aufgabe 3, s.394, (OUT - OhneUmlauteWriter extends FilterWriter)
 * class OhneUmlauteWriter & class  IO_FilterWriter_OhneUmlautWriter_DateiSpeichern_Anchorlayout_TextOhneUmlaute1
 * 
 * 	SIEHE: 		12.3.3.   VerschluesseltWriter extends FilterWriter		s.370 uf, (OUT) (VerschluesseltWriter extends FilterWriter) 
 *  
 * 
 * VORGEHEN:	klasse filterwriter erweitern durch die class OhneUmlauteWriter
 * 
 * 				- �berschreiben der methode write(int c) der superklasse,
 * 					dabei mit switch-case die auszuschreibenden zeichen so manipulieren wie man will, (hier die Umlaute �, �, � + f durch ae, oe und ue + ph ersetzen.)
 * 
 * 			---->		- write(int c)
 * 			|
 * 			|	- 2 andere methoden der class OhneUmlauteWriter �berschreiben 2 weiter methoden der superklasse filterwriter
 * 			|		dabei greiffen sie aber auf die manipulierte methode writ(int c) ihrer eigenen klasse zu
 * 			|
 * 			|___		- write(char[] c, int offset, int count)
 * 			---->
 * 			|			- write(String s, int offset, int count)
 * 			|		
 * 			|	- 2 weitere methoden greifen jeweils wieder auf die �berschriebenen methoden der eigenen klasse zu
 * 			|
 * 			|			- write(char[] c)
 * 			|___
 * 						- write(String s)
 * 
 * K&K:	Klasse OhneUmlautWriter. 
 * 		Die von der Klasse FilterWriter abgeleitete Klasse soll beim Schreiben die Umlaute �, �, � + f durch ae, oe und ue + ph ersetzen.
 * 
 */

package uebungen12Aufgaben;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

public class OhneUmlauteWriter extends FilterWriter {
	
	// d. konstruktor v. VerschluesseltWriter ruft lediglich den konstruktor der basisklasse FilterWriter auf, FilterWriter erwartet als argument ein Writer-objekt, 
	protected OhneUmlauteWriter(Writer out) {	// FilterWriter arbeitet immer mit Writer-Objekt zusammen, FilterWriter verschl�sselt, Writer �bernimmt schreibvorgang
		super(out);
	}
	
	// methode zum �berschreiben von write mit einem zeichen (dezimale schreibweise), wichtigste methode, die folgenden greifen darauf zur�ck
	public void write (int c) throws IOException {	// �berschreiben der methode write(int c) der superklasse, throws IOException siehe oben
		switch ((char) c){				// char casten (aufzwingen) damit man im switch direkt die zeichen schreiben kann + nicht m�hsam die deziamale schreibweise benutzen muss
			case '�':					// schreibt anstelle der zeichen �, �, �, f, �, �, �, �, F die zeichen ae, oe, ue, ph, AE, OE, UE, PH
				super.write('a');		// super.write(..); ist nur in dieser methode n�tig, die folgenden methoden greifen auf hier zur�ck
				super.write('e');
				break;
			case '�':
				super.write('o');
				super.write('e');
				break;
			case '�':
				super.write('u');
				super.write('e');
				break;
			case '�':
				super.write('A');
				super.write('E');
				break;
			case '�':
				super.write('O');
				super.write('E');
				break;
			case '�':
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
				super.write(c);		// super nur in dieser methode n�tig, die folgenden methoden greifen auf hier zur�ck
		}
	}
	
	// methode zum �berschreiben von write(char[] c, int offset, int count) 
	// �berschreibt zwar selbige methode der superklasse greift aber auf write(int c) von oben zu, also ohne super.write(...), verschl�sselung findet in methode oben statt
	public void write(char[] c, int offset, int count) throws IOException{ // schreibt count(anz) zeichen des char[]-arrays c, ab (start)index offset in den stream
		for (int i= 0; i< count; i++){ // for-schleife: ACHTUNG: i < count (=> i < anzahl zeichen) NICHT: i< c.lenght
			write(c [offset + i]); // methode write(int c) von oben wird aufgerufen und das zeichen c[ab offset plus i] als parameter �bergeben
		}						   // maaannnn eee....
	}
	
	// zus�tzliche methode zum schreiben eines kompletten char-arrays:	 write(char[] c) 	(ohne int offset, int count)
	public void write(char[] c) throws IOException { 
		write(c, 0, c.length); // greift auf methode write(char[] c, int offset, int count) dieser klasse zu (also ohne super.)...
	}						// ... unter mitgabe der parameter c[], offset 0, count = c.length
	
	// methode zum �berschreiben von write(String c, int offset, int count)
	// �berschreibt zwar selbige methode der superklasse greift aber auf write(int c) von oben zu, als ohne super.write(...), verschl�sselung findet in methode oben statt
	public void write(String s, int offset, int count) throws IOException { // schreibt count zeichen des strings s ab index offset in den stream
		for (int i= 0; i < count; i++) {  // for-schleife: ACHTUNG: i < count (=> i < anzahl zeichen) NICHT: i< s.lenght
			write(s.charAt(offset + i)); // methode write(int c) von oben wird aufgerufen und das zeichen vom String s an der stelle charAt[ab offset plus i] als parameter �bergeben
		}
	}
	
	// zus�tzliche methode zum schreiben zum schreiben eines kompletten strings:  write(String s)	ohne int offset, int count
	public void write(String s) throws IOException { 
		write(s, 0, s.length()); // greift auf methode write(String s, int offset, int count) dieser klasse zu (also ohne super.)...
	}							// ... unter mitgabe der parameter s, offset 0, count = s.length()
}
