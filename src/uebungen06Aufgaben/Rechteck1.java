/* TODO .6.5.   Aufgabe 2 (3&7), s.196 (197)		
 * & Aufgabe 3, s.197	& aufgabe 7, s.199 (GetterSetter_Konstruktoren_Methoden_FlaechengleicherKreis)
 * 
 * klasse Rechteck1 & Methoden_Konstruktoren_GetterSetter_TestRechteck1
 */

package uebungen06Aufgaben;

import javax.swing.JOptionPane;

public class Rechteck1 {
	double laenge, breite;

	Rechteck1() { // konstruktor: attribute mit 0 initialisieren
		laenge = 0;
		breite = 0;
	}

	// custom konstruktor mit 2 parametern: attribute mit parameterwerten initialisieren
	Rechteck1(double l, double b) {
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
	
	// Aufgabe 3 Zusatz: testen ob lokale variable laenge oder Attribut (der klasse) laenge ausgegeben wird
	void laengeAusgeben() {
		double laenge = 5.4;
		JOptionPane.showMessageDialog(null,"Länge (lokale variabel): " + laenge);			// ausgabe der lokalen variabel laenge
		JOptionPane.showMessageDialog(null,"Länge (attribut der klasse): " + this.laenge);	// ausgabe des attributs der klasse laenge
	}

}
