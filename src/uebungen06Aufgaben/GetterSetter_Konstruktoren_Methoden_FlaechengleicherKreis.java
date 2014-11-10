/* TODO .6.5.   aufgabe 7, s.199
 * GetterSetter_Konstruktoren_Methoden_FlaechengleicherKreis & Klasse Kreis1 & klasse Rechteck1
 * 
 * Es wird zu einem vorgegebenen Rechteck der Radius eines
 * Kreises mit gleichem Fl�cheninhalt berechnet.
 * ausgeben (siehe console)
 */

package uebungen06Aufgaben;

import javax.swing.JOptionPane;

public class GetterSetter_Konstruktoren_Methoden_FlaechengleicherKreis {

	public static void main(String[] args) {
		
		String eingabe;
		double reLaenge, reBreite;
		eingabe = JOptionPane.showInputDialog("Bitte Rechteck-L�nge eingeben: ");
		reLaenge = Double.parseDouble(eingabe);
		eingabe = JOptionPane.showInputDialog("Bitte Rechteck-Breite eingeben: ");
		reBreite = Double.parseDouble(eingabe);
		
		// konstruktoren
		Rechteck1 r = new Rechteck1(reLaenge, reBreite);
		// kontstruktor ohne Parameter nur zur instanzierung / initialisierung auf 0 
		Kreis1 k = new Kreis1();  
		
		// instanzmethoden
		k.setFlaeche(r.getFlaeche()); // hier speziell: setFl�che berechnet und setzt den radius anhand des mitgegebenen fl�chenwertes
									  // siehe setFlaeche in der klasse kreis; -> DESSHALB setFl�che(double f) f�r kreis1 gemacht in aufgabe 5
		// anweisungen/ausgabe
		System.out.println("Rechteck-Laenge: " + r.getLaenge());
		System.out.println("Rechteck-Breite: " + r.getBreite());
		System.out.println("Rechteck-Fl�che: " + r.getFlaeche());
		System.out.println("");
		System.out.println("Kreis-Radius: " + k.getRadius());
		System.out.println("Kreis-Fl�che: " + k.getFlaeche());
	}

}
