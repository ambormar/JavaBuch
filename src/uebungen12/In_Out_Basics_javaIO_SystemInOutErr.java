/* TODO 12.2.   s.357, (In Out) System.in/out/err
 * & TODO 12.2.1.   s.357, (In Out) java.io ein-&ausgabeströme
 * 
 * class In_Out_Basics_javaIO_SystemInOutErr
 * 
 * 12.2. EIN-AUSGABEN AUS SICHT VON JAVA:
 * 
 * 		BASICS:		- Stream (datenstrom) als grundlage für jede ein - & ausgabe
 * 					- tastatur > eingabe > programm > ausgabe > bildschirm
 * 
 * 		KLASSE SYSTEM:	java.lang.System	=> hat 3 Klassenvariabeln:		in, out & err	:	static InputStream in		// klassenvariable in vom typ InputStream
 * 																								static PrintStream out		// klassenvariable in vom typ PrintStream
 * 																								static PrintStream err		// klassenvariable in vom typ PrintStream
 * 					
 * 						1.	System.in.		=> standard-eingabestrom vom typ InputStream & dessen methoden (package java.io)	
 * 						2.	System.out.		=> standard-ausgabestrom vom typ PrintStream & dessen methoden (package java.io)	
 * 						3.	System.err		=> standard-fehlerausgabestrom vom typ PrintStream & seine methoden  (package java.io)
 * 
 * 							=> InputStream/PrintStream:	siehe:	12.2.2.   IO_ByteOrientierte_DatenStreams_InputStream_OutputStream_Klassen_Methoden		s.358
 * 
 * 12.2.1 EIN- & AUSGABESTRÖME VON JAVA.IO.:
 * 
 * 		PACKAGE JAVA.IO:	= im package java.io sind alle Klassen für die dateiverarbeitung zusammengefasst
 * 							
 * 							=> diese Klassen werden unterteilt bezüglich:	
 * 									1. dateneinheit 				=> byteorientiert Streams (1 byte)	ODER  zeichenorientiert Streams (2 byte) 
 * 									2. richtung der datenströme 	=> eingabe  ODER  ausgabe
 * 
 * 				BILD:											richtung der daten-ströme -------->
 * 						
 * 																			java.io
 * 					dateneinheit												|
 * 						|			byteorientiert:			InputStream		---------		OutputStream		(einzelne bytes)
 * 						|														|
 * 						V			zeichenorientiert:			Reader		---------			Writer			(unicode-zeichen aus 2 bytes)
 * 			
 * 						 	[tastatur/datei 	> 	eingabe-strom		>	 programm 	> 	ausgabe-strom 	> 	bildschirm/datei]
 * 
 *				ACHTUNG:	IN - OUT immer aus perspektive des PROGGRAMMS verwenden:
 *
 * 						OUT:	= WRITE OUT 	= DATEN AUS PROGRAMM AUS-LESEN
 *	 					IN:		= READ IN		= DATEN INS PROGRAMM SCHREIBEN 	!!!!!!!!
 *
 *						ALLGEMEINE BEGRIFFS-VERWIRRUNG:		- daten in datei schreiben / aus datei auslesen etc.	==>> IGNORIEREN !!!!!!!!!!!!!!!!!!!!!
 *
 *												
 * 			BYTEORIENTIERTE DATENSTRÖME (INPUTSTREAM / OUTPUTSTREAM):
 * 			
 * 				=> SIEHE:			12.2.2.   IO_ByteOrientierte_DatenStreams_InputStream_OutputStream_Klassen_Methoden		s.358
 * 
 * 			ZEICHENORIENTIERTE DATENSTRÖME (READER / WRITER):
 * 			
 * 				=> SIEHE:			12.2.3.   IO_ZeichenOrientierte_DatenStreams_Reader_Writer_Klassen_Methoden		s.361 
 * 
 */

package uebungen12;

public class In_Out_Basics_javaIO_SystemInOutErr {

}
