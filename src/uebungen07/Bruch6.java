/* TODO .7.3.2.   s.216
 * Bruch6 & Equals_ObjekteVergleichen_Boolean_TestBruch6
 * 
 * methode EQUALS:	- um den wert zweier Objekte zu vergleichen.. 
 * 
 * 					- schnittstelle f�r equals-methode immer:		=> liefert boolean wert zur�ck 
 * 																	=> & erwartet als parameter ein objekt derselben klasse (wie f�r welche sie geschrieben wird)
 * 							
 * 					- .. also NICHT: die bezeichner der beiden objekte, ob diese auf dasselbe Objket zeigen: 	Bsp. NICHT: 	Bruch  =>   a==b
 * 						-> SONDERN: im falls eines Bruches ist gleichheit: 	gleiche zahler & nenner nach dem k�rzen
 * 				
 * 					- vordefinierte objekte wie z.b. String haben EQUALS h�ufig als vordefinierte vergleichsmethoden 
 * 						-> bei String korrekt: 
													String a = "text";
													String b = "text";
													if (a.equals(b)) {..}
							
 * 
 * METHODE 	boolean equals(Bruch br)  F�R WERTE-VERGLEICH IN DER KLASSE BRUCH schreiben:
 * 
 *  KLASSE BRUCH:																			AUFRUF TESTKLASSE:
 * 
	public boolean equals(Bruch br){														Bruch a = new Bruch(2, 4);
		Bruch a = new Bruch(this.zaehler, this.nenner);										Bruch b = new Bruch(3, 6);
		Bruch b = new Bruch(br.zaehler, br.nenner);											System.out.println(a.equals(b));
		a.kuerzen();
		b.kuerzen();
		if ((a.getZaehler() == b.getZaehler()) && (a.getNenner() == b.getNenner())){
			return true;
		} else {
			return false;
		}
	}
	
 * kurz&knapp: methode equals um bei aufruf den wert zweier br�che (unabh�ngig von ihren bezeichnern , zu vergleichen.
 * in der methode werden die 2 Br�che als lokale objekte erzeugt, mit ggT gek�rzt 
 * und jeweils ihre z�hler und nenner verglichen.
 * vergleich zweier objekte mit a.equals(b) und returnwert boolean true oder false
 */
package uebungen07;

public class Bruch6 {
	private int zaehler;
	private int nenner;
	
	Bruch6() {
		setZaehler(0);
		setNenner(1);
	}

	Bruch6(int z, int n) {
		setZaehler(z);
		setNenner(n);
	}
	
	public int getZaehler() {
		return zaehler;
	}

	public void setZaehler(int z) {
		this.zaehler = z;
	}

	public int getNenner() {
		return nenner;
	}

	public void setNenner(int n) {
		this.nenner = n;
	}
	
	public boolean equals(Bruch6 br){
		Bruch6 a = new Bruch6(this.zaehler, this.nenner);
		Bruch6 b = new Bruch6(br.zaehler, br.nenner);
		a.kuerzen();
		b.kuerzen();
		if ((a.getZaehler() == b.getZaehler()) && (a.getNenner() == b.getNenner())){
			return true;
		} else {
			return false;
		}
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

}
