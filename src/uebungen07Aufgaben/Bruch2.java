/* TODO .7.4.   Aufgabe 4, s.223 
 * Klasse Bruch2 & Bruch2MitSeriennummer & Vererbung_ThisSuper_StaticFinal_Bruch2MitSeriennummerTest
 * 
 * Klassenvariable: 		anzahl erstellte objekte zählen mit klassenvariabel(static) 
 * Final:					und seriennummern pro objekte vergeben mit final variabeln.
 * vererbung(subklasse): 	mit this() statt super() objekterstellung auf anderen konstruktor der gleichen klasse umleiten
 */

package uebungen07Aufgaben;

public class Bruch2 {

	private int zaehler;
	private int nenner;

	Bruch2() {
		setZaehler(0);
		setNenner(1);
	}

	Bruch2(int z) {
		setZaehler(z);
		setNenner(1);
	}

	Bruch2(int z, int n) {
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

	boolean equals(Bruch2 x) {
		Bruch2 a = new Bruch2(this.zaehler, this.nenner);
		Bruch2 b = new Bruch2(x.zaehler, x.nenner);
		a.kuerzen();
		b.kuerzen();
		if ((a.zaehler == b.zaehler) && (a.nenner == b.nenner)) {
			return true;
		} else {
			return false;
		}
	}

	// (aufg 3) methode mit rückgabe des dezimalwerts als double
	public double dezimalwert(){
		return (double) zaehler/nenner;
	}
	 
	// (aufg 3) methode erzeugt ein objekt Bruch aus summe von aufrufendem und mitgegebenem Bruch
	public Bruch2 addiereBruch(Bruch2 x){ 	// der datentyp ist Bruch !!!!!
		int z = zaehler * x.nenner + x.zaehler * nenner;
		int n = nenner * x.nenner;
		Bruch2 summe = new Bruch2(z, n);
		return summe;	// objekt mit datentyp Bruch wird zurück gegeben
	}
	
	// (aufg 3) methode erzeugt ein objekt Bruch aus differenz von aufrufendem und mitgegebenem Bruch
	public Bruch2 subtrahiereBruch(Bruch2 x){	// der datentyp ist Bruch !!!!!
		int z = zaehler * x.nenner - x.zaehler * nenner;
		int n = nenner * x.nenner;
		Bruch2 differenz = new Bruch2(z, n);
		return differenz;	// objekt mit datentyp Bruch wird zurück gegeben
	}
}