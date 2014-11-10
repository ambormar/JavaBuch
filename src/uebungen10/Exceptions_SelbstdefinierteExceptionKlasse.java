/* TODO 10.3.3.   s.315
 * Klasse Exceptions_SelbstdefinierteExceptionKlasse & Exceptions_SelbstdefinierteExceptionKlasse_werfen
 * 
[ UNTERSCHEIDE:	
 * 		Benutzerdefinierte Exceptions (10.3.2.)			= selberwerfen von bestehenden Exception-klassen unter parameter-mitgabe von eigenem fehlertext 
 * 		Selbstdefinierte Exception-Klassen (10.3.3.)	= Exception-klassen selber schreiben, durch erweitern einer existierenden Exception-klasse	]
 * 
 * 10.3.3 SELBSTDEFINIERTE EXCEPTION-KLASSEN:	= Exception-klassen selber schreiben, durch ableiten/erben  von einer existierenden Exception-klasse
 * 
 * 												=> dabei immer 2 konstruktoren definieren, einen mit & einen ohne (string-)parameter
 * 
 * 		SCHEMA & BSP: 	siehe Code unten
 * 
 * 		AUFRUF:		siehe	10.3.3	Exceptions_SelbstdefinierteExceptionKlasse_werfen		
 * 
 * K&K:		try { if (bedingung xy) throw new SelbstBenannteExeption("spezifischer fehlertext") 
 * 			} catch(SelbstBenannteExceptions e) { jLabel.setText(e.getMessage()) } 
 * 			man kann also auch ganze exception-klassen selber schreiben
 */

package uebungen10;

// selbstbenannte selbstverfasste exceptionklasse extends IrgendeineException

public class Exceptions_SelbstdefinierteExceptionKlasse extends NumberFormatException {
	// standard  für exceptionklassen: ein konstruktor ohne parameter, einer mit string als parameter:
	// konstruktor ohne parameter
	public Exceptions_SelbstdefinierteExceptionKlasse (){
		super();
	}
	// konstruktor mit String als parameter
	public Exceptions_SelbstdefinierteExceptionKlasse (String s){ // String später abrufbar mit: getMessage()
		super(s);
	}
}
