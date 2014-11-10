package uebungen04;

/*	TODO .4.3.1.   s.150
 * class Fehlersuche_OhneDebugger_MehrwertsteuerZusaetzlAusgabebefehle & MehrwertsteuerFehlerhaft
 * 
 * Fehlersuche von logischen fehlern	s.150	durch zusätzliche ausgabebefehle (konsole) von zählerständen / variabelwerten fehler leichter erkennen 
 * 
 * 	fehlerhaftes programm zur berechnung der Mehrwertsteuer.
 *  zusätzliche Ausgabebefehle & zerlegen der berechnungsformel in zwischenschritte
 *  helfen bei der eingrenzung der fehlerhaften operation
*/

import javax.swing.JOptionPane;

public class Fehlersuche_OhneDebugger_MehrwertsteuerZusaetzlAusgabebefehle {

	public static void main(String[] args) {
		double betrag;			// double
		int mwstsatz = 19;		// int = versteckte fehlerquelle, führt bei der impliziten Typumwndlung von int zu double zu rundungsfehler
		double mwst;			// double
		
		betrag = Integer.parseInt(JOptionPane
				.showInputDialog("Geben Sie einen Rechnungsbetrag in € ein: "));
		
		//zusätzliche Ausgabebefehle zur erleichterten fehlererkennung
		// man sieht jetzt in der konsolenangabe genau, ab welchem schritt die ausgabe fehlerhaft wird (ab schritt 1)
		System.out.println("Betrag: " + betrag);
		System.out.println("Schritt 1: " + mwstsatz / 100);	// rundungsfehler bei der impliziten Typumwndlung von int zu double (19/100= 0.19 => 0)
		System.out.println("Schritt 2: " + mwstsatz / 100 * betrag);	
		
		mwst = mwstsatz / 100 * betrag;    		// mwst = (double) mwstsatz / 100 * betrag;	wäre korrekt	
		JOptionPane.showMessageDialog(null,"Betrag: " + mwst + " €");
	}	
}
