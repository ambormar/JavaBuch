/* TODO 12.2.3.   s.361 uf
 * class IO_ZeichenOrientierte_DatenStreams_Reader_Writer_Klassen_Methoden
 * 
 * 			BASICS SIEHE:							12.2.1.   	In_Out_Basics_javaIO_SystemInOutErr			s.357 java.io
 * 
 * 			BYTEORIENTIERTE DATEN-STREAMS SIEHE:	12.2.2.		IO_ByteOrientierte_DatenStreams_InputStream_OutputStream_Klassen_Methoden	S.358 UF
 * 
 * 
 * 12.2.3.	ZEICHEN-ORIENTIERTE DATENSTRÖME - READER & WRITER :			=> package java.io 
 * 
 * 				=> ZeichenOrientierte DatenStreams lesen & schreiben Unicode-Zeichen vom typ char 		=> char: datengrösse: 2 byte (= 16 bit)
 * 
 * 				=> ZeichenOrientierte EingabeStröme sind immer von der Klasse:			=> Reader bzw. davon abgeleiteten Klassen
 * 
 * 				=> ZeichenOrientierte AusgabeStröme sind immer von der Klasse:			=> Writer bzw. davon abgeleiteten Klassen
 * 	
 * 
 * 		VERERBUNGS-HIERARCHIE DER KLASSEN (READER / WRITER & ABGELEITETE KLASSEN):
 * 
 * 			basis-klassen:			READER								WRITER
 * 									|									|
 * 			abgeleitete klassen:	|__ BufferedReader					|__	BufferedWriter
 * 									|	|__ LineNumberReader			|
 * 									|									|
 * 									|__	CharArrayReader					|__	CharArrayWriter
 * 									|__	FilterReader					|__	FilterWriter
 * 									|	|__	PushbackReader				|
 * 									|									|
 * 									|__	ImputStreamReader				|__	InputStreamWriter
 * 									|	|__ FileReader					|	|__ FileWriter
 * 									|									|
 * 									|__	PipedReader						|__	PipedWriter
 * 									|__	StringReader					|__ StringWriter
 * 																		|__	PrintWriter
 * 
 * 
 * 		KLASSEN & IHRE SPEZIALISIERUNGEN (READER / WRITER & ABGELEITETE KLASSEN) :
 * 		
 * 			KLASSEN:										BESCHREIBUNG:
 * 			
 * 			READER				WRITER				SUPERKLASSE aller zeichenorientierten datenströme.
 * 			BufferedReader		BufferedWriter		verwendet einen Puffer für die lese- / schreib-operationen.
 * 			LineNumberReader	x					er führt einen zähler für die zeilen mit. der zähler kann abgefragt & gesetzt werden.
 * 			CharArrayReader		CharArrayWriter		kann aus CharArrays lesen / in CharArrays schreiben.
 * 			FilterReader		FilterWriter		arbeitet mit einem anderen reader zusammen & kann gelesene / zu schreibende daten filtern bzw. bearbeiten
 * 			PushbackReader		x					kann gelesen daten für weitere lesevorgänge in den Stream zurückgeben
 * 			ImputStreamReader	InputStreamWriter	ermöglicht byte-orientierte & zeichen-orientierte Streams zu koppeln.
 * 													so können daten aus byte-orientierten Streams in zeichen-orientierte Streams & umgekehrt übertragen werden.
 * 			FileReader			FileWriter			liest aus / schreibt in eine datei.
 * 			PipedReader			PipedWriter			hat methoden um daten-streams zwischen threads (unabhängige programme) auszutauschen.
 * 			StringReader		StringWriter		ermöglicht auf einen String, wie auf einen Stream zuzugreifen. 
 * 													schreibt zeichen in bzw. liest zeichen aus einem String.
 * 			x					PrintWriter			hat methoden um primitive daten-typen im textformat auszugeben.
 * 	
 *	
 *		METHODEN VON READER (SUPERKLASSE) :
 *
 *				=> die methoden lösen im fehlerfall Exceptions vom typ:		=> java.io.IOException	aus
 *																			=> die Exceptions müssen entsprechend abgefangen od. weitergereicht werden
 *				=> beim einlesen v. daten mit einem InputStream wird solange blockiert bis	 	-> ..daten im eingebestrom zur verfügung stehen
 *																								-> ..oder das ende des eingabestroms erreicht wird 
 *			
 *			METHODE:						BESCHREIBUNG:
 *			
 *			int read()						liest das näxte zeichen aus dem eingabe-strom & gibt den wert vom daten-typ in zurück.
 *											der wert kann (später?!) mit hilfe der code-tabelle in das entsprechende zeichen umgesetzt werden
 *			int read(char[] c)				liest max. soviele zeichen, wie das char-array c aufnehemn kann. die tats. anzahl gelesener zeichen wird zurückgeliefert.
 *											wird -1 zurückgeliefert deute das darauf hin, dass das Stream-ende erreicht ist & keine zeichen gelesen wurden.
 *			*abstract int read (char[]c,	liest maximal count zeichen aus dem eingabe-strom & speichert sie ab dem index offset im char-array.
 *					int offset, int count)	
 *			*abstract void close()			schliesst den eingabe-strom.		(*abstract:	=> abgeleitete klassen müssen diese methode implementieren)
 *
 *
 *		
 *		METHODEN VON WRITER (SUPERKLASSE) :
 *
 *				=> schreibvorgänge v. daten mit einem gepufferten stream werden erst ausgeführt:	-> .. wenn der puffer vollständig gefüllt ist
 *					(= optimierung der schreibvorgänge & verschnellerung des programm-ablaufs)		-> .. oder der stream geschlossen wird
 *											
 *				=> flush()		=> um schreibvorgänge zu erzwingen			(evtl. auf kosten der optimierung & programmgeschwindigkeit)  
 *			
 *			METHODE:										BESCHREIBUNG:
 *			
 *			void write(int c)								schreibt die 16 niederwertigen bits von c (= 1 unicode-zeichen / 2 bytes) in den ausgabestrom. 
 *			void write(char[] c)							schreibt die zeichen aus dem array in den ausgabestrom.
 *			*abstract void write(char[]c, 					schreibt, ab dem zeichen an position offset, count zeichen aus dem array c in den ausgabe-strom
 *								int offset, int count)		
 *			void write(String s)							schreibt die zeichenfolge des Strings s in den ausgabestrom.
 *			void write(String s, int offset, int count)		schreibt ab der position offset count zeichen aus dem String s in den ausgabe-strom
 *			*abstract void flush()							erzwingt das sofortige schreiben der in puffern befindlichen zeichen in den ausgabe-strom.
 *			*abstract void close()							erzwingt das sofortige schreiben der in puffern befindlichen zeichen in den ausgabe-strom 
 *															& schliesst den ausgabe-strom
 *															
 *															(*abstract:	=> abgeleitete klassen müssen diese methode implementieren)
 *
 */

package uebungen12;

public class IO_ZeichenOrientierte_DatenStreams_Reader_Writer_Klassen_Methoden {

}
