/* TODO .6.5.   Aufgabe 2 (3), s.196 (197)		
 * & Aufgabe 3, s.197
 * 
 * klasse Rechteck1 & Methoden_Konstruktoren_GetterSetter_TestRechteck1,
 */
package uebungen06Aufgaben;

import javax.swing.JOptionPane;

public class Methoden_Konstruktoren_GetterSetter_TestRechteck1 {

	public static void main(String[] args) {
		// attribute
		String eingabe, einheit;
		double laenge, breite;
		eingabe = JOptionPane
				.showInputDialog("Bitte geben sie die Rechtecklänge ein: ");
		laenge = Double.parseDouble(eingabe);
		eingabe = JOptionPane
				.showInputDialog("Bitte geben sie die Rechteckbreite ein: ");
		breite = Double.parseDouble(eingabe);
		einheit = JOptionPane
				.showInputDialog("Bitte geben sie eine Masseinheit ein: ");

		// aufruf des custom Konstruktors
		Rechteck1 r = new Rechteck1(laenge, breite);
		
		// anweisungen mit u.a. aufrufe der instanzmethoden von Objekt/Instanz(r)
		JOptionPane.showMessageDialog(null,"Lange Seite des Rechtecks: " + r.getLangeSeite()
				+ einheit);
		JOptionPane.showMessageDialog(null,"Kurze Seite des Rechtecks: " + r.getKurzeSeite()
				+ einheit);
		JOptionPane.showMessageDialog(null,"Diagonale des Rechtecks: " + r.getDiagonale()
				+ einheit);
		JOptionPane.showMessageDialog(null,"Fläche des Rechtecks: " + r.getFlaeche() + einheit
				+ '\u00B2');
		JOptionPane.showMessageDialog(null,"Umfang des Rechtecks: " + r.getUmfang() + einheit);
		
		// Aufgabe 3: zusätzlicher Instanzmethodenaufruf
		r.laengeAusgeben();
	}
}
