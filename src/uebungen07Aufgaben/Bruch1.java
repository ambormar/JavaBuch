/* TODO .7.4.   Aufgabe 3, s.221 
 * Klasse Bruch1 & Methoden_ObjekteAlsParameter_AddiereSubtrahiereBrueche_Bruch1Test
 * 
 * erzeugen von objekten in methoden und objekte als parameterübergabe von methoden
 */

package uebungen07Aufgaben;

public class Bruch1 {

	private int zaehler;
	private int nenner;

	Bruch1() {
		setZaehler(0);
		setNenner(1);
	}

	Bruch1(int z) {
		setZaehler(z);
		setNenner(1);
	}

	Bruch1(int z, int n) {
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

	boolean equals(Bruch1 x) {
		Bruch1 a = new Bruch1(this.zaehler, this.nenner);	// lokale brucherzeugung mit werten vom erstgenannten bruch beim aufruf (z.b. a.equals(b))
		Bruch1 b = new Bruch1(x.zaehler, x.nenner);			// lokale brucherzeugung mit werten des in klammern übergebenen bruchs beim obigen aufruf (b) 
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
	 
	// (aufg 3) methode erzeugt ein objekt Bruch aus summe von aufrufendem und mitgegebenem Bruch	(testaufruf z.b.: 	a.equals(b))
	public Bruch1 addiereBruch(Bruch1 x){ 	// der datentyp ist Bruch !!!!!
		int z = this.zaehler * x.nenner + x.zaehler * this.nenner;			
		int n = this.nenner * x.nenner;
		Bruch1 summe = new Bruch1(z, n);
		return summe;	// objekt mit datentyp Bruch wird zurück gegeben
	}
	
	// (aufg 3) methode erzeugt ein objekt Bruch aus differenz von aufrufendem und mitgegebenem Bruch	(testaufruf z.b.:	 a.equals(b))
	public Bruch1 subtrahiereBruch(Bruch1 x){	// der datentyp ist Bruch !!!!!
		int z = this.zaehler * x.nenner - x.zaehler * this.nenner;
		int n = this.nenner * x.nenner;
		Bruch1 differenz = new Bruch1(z, n);
		return differenz;	// objekt mit datentyp Bruch wird zurück gegeben
	}
}
