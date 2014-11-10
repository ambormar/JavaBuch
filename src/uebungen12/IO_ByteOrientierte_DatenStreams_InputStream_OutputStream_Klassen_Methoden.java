/* TODO 12.2.2.   s.358 uf
 * class IO_ByteOrientierte_DatenStreams_InputStream_OutputStream_Klassen_Methoden
 * 
 * 			BASICS SIEHE:								12.2.1.   	In_Out_Basics_javaIO_SystemInOutErr			s.357 java.io
 * 
 * 			ZEICHEN-ORIENTIERTE DATEN-STREAMS SIEHE:	12.2.3.		IO_ZeichenOrientierte_DatenStreams_Reader_Writer_Klassen_Methoden	S.361 UF
 * 
 * 
 * 12.2.2 BYTEORIENTIERTE DATENSTRÖME - INPUTSTREAM & OTPUTSTREAM :			=> package java.io 
 * 
 * 				=> ByteOrientierte EingabeStröme sind immer von der Klasse:			=> InputStream bzw. davon abgeleiteten Klassen
 * 
 * 				=> ByteOrientierte AusgabeStröme sind immer von der Klasse:			=> OutputStream bzw. davon abgeleiteten Klassen
 * 	
 * 
 * 		VERERBUNGS-HIERARCHIE DER KLASSEN (INPUTSTREAM / OUTPUTSTREAM & ABGELEITETE KLASSEN):
 * 
 * 			basis-klassen:			INPUTSTREAM		(z.b. typ von System.in)			OUTPUTSTREAM
 * 									|													|
 * 			abgeleitete klassen:	|__ ByteArrayInputStream							|__	ByteArrayOutputStream
 * 									|__	FileInputStream									|__	FileOutputStream
 * 									|__	FilterInputStream								|__	FilterOutputStream
 * 									|	|__	BufferedInputStream							|	|__	BufferedOutputStream
 * 									|	|__	DataInputStream								|	|__	DataOutputStream
 * 									|	|__	PushbackInputStream							|	|__	PushbackInputStream	
 * 									|													|	|__	PrintStream			(z.b. typ von System.out. & System.err)
 * 									|__	ObjectInputStream								|__	ObjectOutputStream
 * 									|__	PipedInputStream								|__	PipedOutputStream
 * 									|__	SequenceInputStream
 * 		
 * 
 * 		KLASSEN & IHRE SPEZIALISIERUNGEN (INPUTSTREAM / OUTPUTSTREAM & ABGELEITETE KLASSEN) :
 * 		
 * 			KLASSEN:											BESCHREIBUNG:
 * 			
 * 			INPUTSTREAM				OUTPUTSTREAM				SUPERKLASSE aller byteorientierten datenströme.
 * 			ByteArrayInputStream 	ByteArrayOutputStream		liest aus / schreibt in Byte-Arrays.
 * 			FileInputStream			FileOutputStream			liest aus / schreibt in Dateien.
 * 			FilterInputStream		FilterOutputStream			kann daten beim ein-/auslesen bearbeiten. verschlüsselt / entschlüsselt daten beim ein-/auslesen.
 * 			BufferedInputStream		BufferedOutputStream		verfügt über einen lesepuffer / schreibpuffer.
 * 			DataInputStream 		DataOutputStream			besitzt methoden zum lesen /ausgeben von standard-typen (int, double, etc...)
 * 						PushbackInputStream						ermöglicht, bereits gelesene daten, zum erneuten lesen wieder in den Eigabe-Stream zurückzugeben
 *			x						PrintStream					besitzt methoden zur zeileorientierten ausgabe der standard-typen (print(), println())
 *			ObjectInputStream 		ObjectOutputStream			hat methoden zum lesen / ausgeben von objekten. (ist das pendant zu DataInputStream / DataOutputStream f. d. primitiven datentypen)
 *			PipedInputStream		PipedOutputStream			hat methoden für den datenaustausch zwischen threads (voneinander unabhängige programme)
 *			SequenceInputStream		x							kann mehrere eingebeströme zu einem Stream zusammenfassen. wird das ende eines eingabestroms erreicht, wird automatisch aus dem näxten eingabestrom gelesen.
 *
 *	
 *		METHODEN VON INPUTSTREAM (SUPERKLASSE) :
 *
 *				=> die methoden lösen im fehlerfall Exceptions vom typ:		=> java.io.IOException	aus
 *																			=> die Exceptions müssen entsprechend abgefangen od. weitergereicht werden
 *				=> beim einlesen v. daten mit einem InputStream wird solange blockiert bis	 	-> ..daten im eingebestrom zur verfügung stehen
 *																								-> ..oder das ende des eingabestroms erreicht wird
 *			
 *			METHODE:					BESCHREIBUNG:
 *			
 *			int available()				liefert die anzahl bytes zurück, die ohne blockieren gelesen werden können
 *			*abstract int read()		liest das näxte byte aus dem stream. zurückgelieferter wert liegt zwischen 0 und 255. 
 *										gibt's kein byte mehr, weil ende des streams erreicht ist, wird -1 zurückgeliefert. 
 *										(* modifier abstract:	=> abgeleitete klassen müssen diese methode implementieren)
 *			int read(byte[] b)			füllt das byte-array b mit den gelesenen bytes. es wird bis zu b.lenght gelesen. 
 *										die anzahl der gelesenen bytes wird zurückgeliefert. gibt's keine bytes mehr, am streamende, wird -1 geliefert.
 *			int read(byte[]b, int 		füllt das byte-array b, ab der position offset mit bis zu count gelesenen bytes. 
 *					offset, int count)	stehen keine bytes mehr zum lesen zur verfügung, weil das stream-ende erreicht ist, wird -1 zurückgeliefert
 *			void close()				schliesst den eingabe-strom.
 *
 *		
 *		METHODEN VON OUTPUTSTREAM (SUPERKLASSE) :
 *
 *				=> schreibvorgänge v. daten mit einem gepufferten stream werden erst ausgeführt:	-> .. wenn der puffer vollständig gefüllt ist
 *					(= optimierung der schreibvorgänge & verschnellerung des programm-ablaufs)		-> .. oder der stream geschlossen wird
 *											
 *				=> flush()		=> um schreibvorgänge zu erzwingen			(evtl. auf kosten der optimierung & programmgeschwindigkeit) 				

 *			
 *			METHODE:										BESCHREIBUNG:
 *			
 *			*abstract void write(int b)						schreibt die acht niederwertigen bits von b (= 1 byte) in den ausgabestrom. 
 *															(* modifier abstract:	=> abgeleitete klassen müssen diese methode implementieren)
 *			void write(byte[] b)							schreibt die bytes aus dem array in den ausgabestrom.
 *			void write(byte[]b, int offset, int count)		schreibt count bytes aus dem byte-array b, ab index offset in den ausgabestrom.
 *		!	void flush()									erzwingt das sofortige schreiben aller in puffern zwischengespeicherten daten in den ausgabe-strom.
 *			void close()									schliesst den ausgabe-strom & ruft bei FilterOutputStream-objekten zuvor die methode flush() auf.
 *															
 *															
 */

package uebungen12;

public class IO_ByteOrientierte_DatenStreams_InputStream_OutputStream_Klassen_Methoden {

}
