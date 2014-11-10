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

public class Bruch3 {

	private int zaehler;
	private int nenner;

	Bruch3() {
		setZaehler(0);
		setNenner(1);
	}

	Bruch3(int z) {
		setZaehler(z);
		setNenner(1);
	}

	Bruch3(int z, int n) {
		setZaehler(z);
		setNenner(n);
	}

	public int getZaehler() {
		return zaehler;
	}

	public int getNenner() {
		return nenner;
	}
	
	public void setZaehler(int z) {
		zaehler = z;
	}

	public void setNenner(int n) {
		nenner = n;
	}
	
	public void ausgeben(){ 		
		System.out.println(zaehler + "/" + nenner);
	}

	public String bruchString() {
		return zaehler + "/" + nenner;
	}

	void kuerzen() {
		int m, n, r; // lokale Variablen
		m = zaehler;
		n = nenner;
		r = m % n;
		while (r > 0) {
			m = n;
			n = r;
			r = m % n;
		}
		zaehler /= n; // in n steht jetzt der ggT
		nenner /= n;
	}

	void gekuerztAusgeben() {
		kuerzen();
		ausgeben();
	}

	boolean equals(Bruch3 x) {
		Bruch3 a = new Bruch3(this.zaehler, this.nenner);
		Bruch3 b = new Bruch3(x.zaehler, x.nenner);
		a.kuerzen();
		b.kuerzen();
		if ((a.zaehler == b.zaehler) && (a.nenner == b.nenner)) {
			return true;
		} else {
			return false;
		}
	}

	// (aufg 3+5) methode mit rückgabe des dezimalwerts als double
	public double dezimalwert(){
		return (double) zaehler/nenner;
	}
	 
	// (aufg 3+5) methode erzeugt ein objekt Bruch aus summe von aufrufendem und mitgegebenem Bruch
	public Bruch3 addiereBruch(Bruch3 x){ 	// der datentyp ist Bruch !!!!!
		int z = zaehler * x.nenner + x.zaehler * nenner;
		int n = nenner * x.nenner;
		Bruch3 summe = new Bruch3(z, n);
		return summe;	// objekt mit datentyp Bruch wird zurück gegeben
	}
	
	// (aufg 3+5) methode erzeugt ein objekt Bruch aus differenz von aufrufendem und mitgegebenem Bruch
	public Bruch3 subtrahiereBruch(Bruch3 x){	// der datentyp ist Bruch !!!!!
		int z = zaehler * x.nenner - x.zaehler * nenner;
		int n = nenner * x.nenner;
		Bruch3 differenz = new Bruch3(z, n);
		return differenz;	// objekt mit datentyp Bruch wird zurück gegeben
	}
}
