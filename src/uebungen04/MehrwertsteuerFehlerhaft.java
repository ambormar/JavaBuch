package uebungen04;

/* TODO .4.3.1.   s.150
 * class MehrwertsteuerFehlerhaft & Fehlersuche_OhneDebugger_MehrwertsteuerZusaetzlAusgabebefehle
 * 
 * class MehrwertsteuerFehlerhaft ist fehlerhaftes programm zu berechnung der mehrwertsteuer. 
 * 
 * zur anschaueung wie logische fehler mit zusätzlichen ausgabebefehlen gefunden werden können.
 * [mwstsatz (ca. zeile 24) ist int statt double]
 * 			
 * 			=> Fehlersuche und lösung siehe class Fehlersuche_OhneDebugger_MehrwertsteuerZusaetzlAusgabebefehle
 * 
*/

import javax.swing.JOptionPane;


public class MehrwertsteuerFehlerhaft {

	public static void main(String[] args) {
		double betrag;					// double
		int mwstsatz = 19;				// int = versteckte fehlerquelle, muss nacher mit double rechnen -> Datentyp verwurstlungen
		double mwst;					// double
		
		betrag = Integer.parseInt(JOptionPane
				.showInputDialog("Geben Sie einen Rechnungsbetrag in € ein: "));
		mwst = mwstsatz / 100 * betrag;    					// (double) mwstsatz wäre korrekt
		JOptionPane.showMessageDialog(null, "Mehrwertsteuer: " + mwst + " €");
	}	
}
