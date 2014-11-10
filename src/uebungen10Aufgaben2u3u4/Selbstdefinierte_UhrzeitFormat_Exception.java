/* TODO 10.4.   Aufgabe 2 & 3 & 4, s.316
 * class Exceptions_SelbstdefinierteExceptions_UhrzeitFrame & Selbstdefinierte_UhrzeitFormat_Exception
 * 
 * HAUPTTHEMA:	- Exceptions allgemein, selbstdefinierte Exception-klassen, Try-catch-finally 
 * 
 * K&K:	Programm Uhrzeit zur Eingabe und Anzeige einer Uhrzeit.
 * 		allgemeine exceptions werfen fehler bei allgemein falschen eingaben 
 * 		selbstdefinierte exceptionklasse wirft fehler bei falschen stunden- & minuten-eingaben
 */

package uebungen10Aufgaben2u3u4;

// Selbstbenannte UhrzeitFormatException speziell für UhrenZahlenFormat, erweitert allgemeine Exception (hier NICHT: NumberFormatException)
	// klasse nur um exceptions zusätzliche namen zu vergeben, damit im programm dann den jeweiligen namen spezifische funktionen zugeteilt werden können
		// keine funktionen in dieser Klasse nötig
public class Selbstdefinierte_UhrzeitFormat_Exception extends Exception{
	
	// bei exceptionkonstruktorenklassen immer: ein Konstruktor ohne Parameter...
	public Selbstdefinierte_UhrzeitFormat_Exception(){
		super();
	}
	// ... und ein Konstruktor mit String als Parameter
	public Selbstdefinierte_UhrzeitFormat_Exception(String message){
		super(message);
	}
	
}
