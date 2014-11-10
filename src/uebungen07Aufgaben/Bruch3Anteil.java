/* TODO .7.4.   Aufgabe 5, s.223, 
 * Klasse Bruch3 & Bruch3Anteil & ObjektdatentypAlsKlassenvariable_Bruch3AnteilTest
 * 
 * erweiterung von superklasse Bruch3: subklasse Bruch3Anteil hat konstruktor, der solange brüche erzeugen kann, 
 * bis ein gesamtanteil (hier klassenvariable: verteilt) von 1 (1/1tel) überschritten wird. dann fehlermeldung.
 * objekt (verteilt) als klassenvariable zur zustandsspeicherung des gesamtanteils bruch der verteilt ist.
 * objekte als parameter übergeben für bruch-addition/-subtraktion.
 * jeweilige brüche als string ausgebenund umrechnen auf einen (rest)anteil (vermögens)betrag  
 */

package uebungen07Aufgaben;

public class Bruch3Anteil extends Bruch3 {	// extends Klasse nicht vergessen!!, scho no wichtig
	// variabeln
	//statische klassenvariable mit objektdatentyp bruch
	public static Bruch3 verteilt = new Bruch3(0); 	// attribut verteilt überwacht wieviel vom gesamten(1/1) verteilt ist

	// konstruktoren: 
	// einer ohne parameter 
	Bruch3Anteil() {	// konstruktor ohne parameter setzt den wert des bruchs via superklasse auf 0 (zaehler: 0, nenner: 1)
		super();	
	}
	
	// einer mit zaehler & nenner als parameter 
	Bruch3Anteil(int z, int n) {
		super(z, n);
		verteilt = verteilt.addiereBruch(this); // klassenvariable, zu welcher der hier erzeugte bruch addiert wird
		if (getVerteilt() > 1){					// durch methode getVerteilt() wird wert (als double) von verteilt mit 1 verglichen
			System.out.println("Fehler, es wurde zu viel verteilt!"); // klassenvariable grösser als 1 > fehlerausgabe
		}
	}

	public double getVerteilt() {		// methode gibt wert des bruchs verteilt als double(dezimalwert) zurück
		return (double) verteilt.getZaehler()/verteilt.getNenner();	 
	}

	public Bruch3 getRest(){			// methode gibt wert des noch nicht verteilten anteils als Bruch zurück
		Bruch3 gesamt = new Bruch3(1, 1);			// lokales objekt bruch total mit wert 1 erzeugen
		return gesamt.subtrahiereBruch(verteilt);	// bruch verteilt von bruch gesamt abziehen = noch nicht verteilter anteil v. bruch
	}

}
