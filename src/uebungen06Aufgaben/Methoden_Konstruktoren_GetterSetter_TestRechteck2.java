/* TODO .6.5.   Aufgabe 4, s.198
 * klasse Rechteck2 & Methoden_Konstruktoren_GetterSetter_TestRechteck2
 * 
 * class Rechteck1 (aufg 2/3) um folgende methoden erweitern:
 * -void laengeVergroessern(double l)	-void breiteVergroessern(double b) -void laengeVerkleinern(double l)	-void breiteVerkleinern(double b)
 * - testen sie die methoden indem sie die eingegebenen werte vor der ausgabe vergr�ssern bzw. verkleinern
 * 
 */


package uebungen06Aufgaben;

import javax.swing.JOptionPane;

public class Methoden_Konstruktoren_GetterSetter_TestRechteck2 {

	public static void main(String[] args) {
		// attribute
		String eingabe, einheit;
		double laenge, breite, vergroessern, verkleinern;
		eingabe = JOptionPane
				.showInputDialog("Bitte geben sie die Rechteckl�nge ein: ");
		laenge = Double.parseDouble(eingabe);
		eingabe = JOptionPane
				.showInputDialog("Bitte geben sie die Rechteckbreite ein: ");
		breite = Double.parseDouble(eingabe);
		einheit = JOptionPane
				.showInputDialog("Bitte geben sie eine Masseinheit ein: ");
		eingabe = JOptionPane
				.showInputDialog("Bitte geben sie Vergr�sserungszahl ein: ");
		vergroessern = Double.parseDouble(eingabe);
		eingabe = JOptionPane
				.showInputDialog("Bitte geben sie Verkleinerungszahl ein: ");
		verkleinern = Double.parseDouble(eingabe);

		// aufruf des custom Konstruktors
		Rechteck2 r = new Rechteck2(laenge, breite);
		
		// anweisungen mit u.a. aufrufe der instanzmethoden von Objekt/Instanz(r)
		System.out.println("Lange Seite des Rechtecks: " + r.getLangeSeite()
				+ einheit);
		System.out.println("Kurze Seite des Rechtecks: " + r.getKurzeSeite()
				+ einheit);
		System.out.println("Diagonale des Rechtecks: " + r.getDiagonale()
				+ einheit);
		System.out.println("Fl�che des Rechtecks: " + r.getFlaeche() + einheit
				+ '\u00B2');
		System.out.println("Umfang des Rechtecks: " + r.getUmfang() + einheit);
		
		// instanzmethoden-aufruf um werte zu vergr�ssern
		r.laengeVergroessern(vergroessern);
		r.breiteVergroessern(vergroessern);
		
		System.out.println('\n' + "Lange Seite des Rechtecks vergr�ssert: " + r.getLangeSeite()
				+ einheit);
		System.out.println("Kurze Seite des Rechtecks vergr�ssert: " + r.getKurzeSeite()
				+ einheit);
		System.out.println("Diagonale des Rechtecks vergr�ssert: " + r.getDiagonale()
				+ einheit);
		System.out.println("Fl�che des Rechtecks vergr�ssert: " + r.getFlaeche() + einheit
				+ '\u00B2');
		System.out.println("Umfang des Rechtecks vergr�ssert: " + r.getUmfang() + einheit);
		
		// instanzmethoden-aufruf um werte zu verkleinern
		r.laengeVerkleinern(verkleinern);
		r.breiteVerkleinern(verkleinern);
		
		
		System.out.println('\n' + "Lange Seite des Rechtecks verkleinert: " + r.getLangeSeite()
				+ einheit);
		System.out.println("Kurze Seite des Rechtecks verkleinert: " + r.getKurzeSeite()
				+ einheit);
		System.out.println("Diagonale des Rechtecks verkleinert: " + r.getDiagonale()
				+ einheit);
		System.out.println("Fl�che des Rechtecks verkleinert: " + r.getFlaeche() + einheit
				+ '\u00B2');
		System.out.println("Umfang des Rechtecks verkleinert: " + r.getUmfang() + einheit);
	}
}
