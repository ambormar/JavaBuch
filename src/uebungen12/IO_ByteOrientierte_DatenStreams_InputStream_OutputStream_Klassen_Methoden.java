/* TODO 12.2.2.   s.358 uf
 * class IO_ByteOrientierte_DatenStreams_InputStream_OutputStream_Klassen_Methoden
 * 
 * 			BASICS SIEHE:								12.2.1.   	In_Out_Basics_javaIO_SystemInOutErr			s.357 java.io
 * 
 * 			ZEICHEN-ORIENTIERTE DATEN-STREAMS SIEHE:	12.2.3.		IO_ZeichenOrientierte_DatenStreams_Reader_Writer_Klassen_Methoden	S.361 UF
 * 
 * 
 * 12.2.2 BYTEORIENTIERTE DATENSTR�ME - INPUTSTREAM & OTPUTSTREAM :			=> package java.io 
 * 
 * 				=> ByteOrientierte EingabeStr�me sind immer von der Klasse:			=> InputStream bzw. davon abgeleiteten Klassen
 * 
 * 				=> ByteOrientierte AusgabeStr�me sind immer von der Klasse:			=> OutputStream bzw. davon abgeleiteten Klassen
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
 * 			INPUTSTREAM				OUTPUTSTREAM				SUPERKLASSE aller byteorientierten datenstr�me.
 * 			ByteArrayInputStream 	ByteArrayOutputStream		liest aus / schreibt in Byte-Arrays.
 * 			FileInputStream			FileOutputStream			liest aus / schreibt in Dateien.
 * 			FilterInputStream		FilterOutputStream			kann daten beim ein-/auslesen bearbeiten. verschl�sselt / entschl�sselt daten beim ein-/auslesen.
 * 			BufferedInputStream		BufferedOutputStream		verf�gt �ber einen lesepuffer / schreibpuffer.
 * 			DataInputStream 		DataOutputStream			besitzt methoden zum lesen /ausgeben von standard-typen (int, double, etc...)
 * 						PushbackInputStream						erm�glicht, bereits gelesene daten, zum erneuten lesen wieder in den Eigabe-Stream zur�ckzugeben
 *			x						PrintStream					besitzt methoden zur zeileorientierten ausgabe der standard-typen (print(), println())
 *			ObjectInputStream 		ObjectOutputStream			hat methoden zum lesen / ausgeben von objekten. (ist das pendant zu DataInputStream / DataOutputStream f. d. primitiven datentypen)
 *			PipedInputStream		PipedOutputStream			hat methoden f�r den datenaustausch zwischen threads (voneinander unabh�ngige programme)
 *			SequenceInputStream		x							kann mehrere eingebestr�me zu einem Stream zusammenfassen. wird das ende eines eingabestroms erreicht, wird automatisch aus dem n�xten eingabestrom gelesen.
 *
 *	
 *		METHODEN VON INPUTSTREAM (SUPERKLASSE) :
 *
 *				=> die methoden l�sen im fehlerfall Exceptions vom typ:		=> java.io.IOException	aus
 *																			=> die Exceptions m�ssen entsprechend abgefangen od. weitergereicht werden
 *				=> beim einlesen v. daten mit einem InputStream wird solange blockiert bis	 	-> ..daten im eingebestrom zur verf�gung stehen
 *																								-> ..oder das ende des eingabestroms erreicht wird
 *			
 *			METHODE:					BESCHREIBUNG:
 *			
 *			int available()				liefert die anzahl bytes zur�ck, die ohne blockieren gelesen werden k�nnen
 *			*abstract int read()		liest das n�xte byte aus dem stream. zur�ckgelieferter wert liegt zwischen 0 und 255. 
 *										gibt's kein byte mehr, weil ende des streams erreicht ist, wird -1 zur�ckgeliefert. 
 *										(* modifier abstract:	=> abgeleitete klassen m�ssen diese methode implementieren)
 *			int read(byte[] b)			f�llt das byte-array b mit den gelesenen bytes. es wird bis zu b.lenght gelesen. 
 *										die anzahl der gelesenen bytes wird zur�ckgeliefert. gibt's keine bytes mehr, am streamende, wird -1 geliefert.
 *			int read(byte[]b, int 		f�llt das byte-array b, ab der position offset mit bis zu count gelesenen bytes. 
 *					offset, int count)	stehen keine bytes mehr zum lesen zur verf�gung, weil das stream-ende erreicht ist, wird -1 zur�ckgeliefert
 *			void close()				schliesst den eingabe-strom.
 *
 *		
 *		METHODEN VON OUTPUTSTREAM (SUPERKLASSE) :
 *
 *				=> schreibvorg�nge v. daten mit einem gepufferten stream werden erst ausgef�hrt:	-> .. wenn der puffer vollst�ndig gef�llt ist
 *					(= optimierung der schreibvorg�nge & verschnellerung des programm-ablaufs)		-> .. oder der stream geschlossen wird
 *											
 *				=> flush()		=> um schreibvorg�nge zu erzwingen			(evtl. auf kosten der optimierung & programmgeschwindigkeit) 				

 *			
 *			METHODE:										BESCHREIBUNG:
 *			
 *			*abstract void write(int b)						schreibt die acht niederwertigen bits von b (= 1 byte) in den ausgabestrom. 
 *															(* modifier abstract:	=> abgeleitete klassen m�ssen diese methode implementieren)
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
