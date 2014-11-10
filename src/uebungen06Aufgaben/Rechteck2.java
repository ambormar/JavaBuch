/* TODO .6.5.   Aufgabe 4, s.198
 * klasse Rechteck2 & Methoden_Konstruktoren_GetterSetter_TestRechteck2
 * 
 * class Rechteck1 (aufg 2/3) um folgende methoden erweitern:
 * -void laengeVergroessern(double l)	-void breiteVergroessern(double b) -void laengeVerkleinern(double l)	-void breiteVerkleinern(double b)
 * - testen sie die methoden indem sie die eingegebenen werte vor der ausgabe vergrössern bzw. verkleinern
 * 
 */

package uebungen06Aufgaben;

public class Rechteck2 {
	double laenge, breite;

	Rechteck2() { // default-konstruktor: attribute mit 0 initialisieren
		laenge = 0;
		breite = 0;
	}

	// custom konstruktor mit 2 parametern: attribute mit parameterwerten initialisieren
	Rechteck2(double l, double b) {
		laenge = l;
		breite = b;
	}

	void setLaenge(double l) {
		laenge = l;
	}

	void setBreite(double b) {
		breite = b;
	}

	void setSeiten(double l, double b) {
		laenge = l;
		breite = b;
	}

	double getLaenge() {
		return laenge;
	}

	double getBreite() {
		return breite;
	}

	double getLangeSeite() {
		if (laenge > breite)
			return laenge;
		else
			return breite;
	}

	double getKurzeSeite() {
		if (laenge < breite)
			return laenge;
		else
			return breite;
	}

	double getDiagonale() {
		return Math.sqrt(laenge * laenge + breite * breite);
	}

	double getFlaeche() {
		return laenge * breite;
	}

	double getUmfang() {
		return 2 * laenge + 2 * breite;
	}

	// instanzmethoden um werte zu vergrössern / verkleinern
	
	void laengeVergroessern(double lvg) {
		laenge += lvg;
	}


	void breiteVergroessern(double bvg) {
		breite += bvg;
	}
	
	void laengeVerkleinern(double lvk) {
		laenge -= lvk;
	}
	
	void breiteVerkleinern(double bvk) {
		breite -= bvk;
	}
}
