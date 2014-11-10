/* TODO 11.3.   Aufgabe 3.5, s.345, versehentlich analog zu aufgabe 3 gelöst, ist gar keine aufgabe
 * class ArrayList_WerteEingebenAbaendernAuswerten_Messreihe_eigene
 * 
 * programm aus aufgabe 2 (array_messreihe) 1 zu 1 umbauen mit arraylist statt array. frame & funktionen genau gleich
 * 
 * Programm Messreihe_ArrayList. Es kann eine Messreihe beliebiger Größe eingegeben und ausgewertet
 * werden. Die Messwerte werden in eine ArrayList eingelesen. Einzelne Messwerte können auch noch 
 * nachträglich bearbeitet werden.
 */

package uebungen11Aufgaben;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


public class ArrayList_WerteEingebenAbaendernAuswerten_Messreihe_eigene extends javax.swing.JFrame {
	private JLabel jLAnzahl;
	private JButton jBtnEingabeAnzahl;
	private JLabel jLMesswert;
	private JButton jBtnSpeichern;
	private JTextField jTFWert;
	private JLabel jLWert;
	private JButton jBtnBearbeiten;
	private JLabel jLEingabe;
	private JTextField jTFIndexEingabe;
	private JLabel jLMesswerte;
	private JLabel jLMinimum;
	private JLabel jLMittelwert;
	private JLabel jLMaximum;
	private JButton jBtnAuswerten;
	private JButton jBtnEingabeMesswert;
	private JTextField jTFMesswert;
	private JTextField jTFAnzahl;
	// variabeln für anzahl, nummerierung & index der werte
	private int anzahl, n, index;
	// ArrayList, ACHTUNG import von java.util.ArrayList jeweils nötig, sonst fehler
	private ArrayList<Double> messwerte;
	// variabeln für berechnungen mit den werten
	private double messwert, summe, minimum, maximum, mittelwert;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ArrayList_WerteEingebenAbaendernAuswerten_Messreihe_eigene inst = new ArrayList_WerteEingebenAbaendernAuswerten_Messreihe_eigene();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public ArrayList_WerteEingebenAbaendernAuswerten_Messreihe_eigene() {
		super();
		initGUI();
		// nummerierung der messwerte auf 0 setzen 
		n = 0;
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Messreihe");
			{
				jLAnzahl = new JLabel();
				getContentPane().add(jLAnzahl);
				jLAnzahl.setText("Wie viele Messwerte sollen eingegeben werden?");
				jLAnzahl.setBounds(7, 7, 292, 14);
			}
			{
				jTFAnzahl = new JTextField();
				getContentPane().add(jTFAnzahl);
				jTFAnzahl.setBounds(293, 4, 70, 21);
			}
			{
				jBtnEingabeAnzahl = new JButton();
				getContentPane().add(jBtnEingabeAnzahl);
				jBtnEingabeAnzahl.setText("OK");
				jBtnEingabeAnzahl.setBounds(375, 4, 71, 21);
				jBtnEingabeAnzahl.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnEingabeAnzahlActionPerformed(evt);
					}
				});
			}
			{
				jLMesswert = new JLabel();
				getContentPane().add(jLMesswert);
				jLMesswert.setText("Messwert");
				jLMesswert.setBounds(7, 41, 91, 14);
				jLMesswert.setVisible(false);
			}
			{
				jTFMesswert = new JTextField();
				getContentPane().add(jTFMesswert);
				jTFMesswert.setBounds(7, 56, 83, 21);
				jTFMesswert.setVisible(false);
			}
			{
				jBtnEingabeMesswert = new JButton();
				getContentPane().add(jBtnEingabeMesswert);
				jBtnEingabeMesswert.setText("OK");
				jBtnEingabeMesswert.setBounds(116, 56, 72, 21);
				jBtnEingabeMesswert.setVisible(false);
				jBtnEingabeMesswert.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnEingabeMesswertActionPerformed(evt);
					}
				});
			}
			{
				jLMesswerte = new JLabel();
				getContentPane().add(jLMesswerte);
				jLMesswerte.setText("Messwerte:");
				jLMesswerte.setBounds(7, 93, 450, 14);
			}
			{
				jTFIndexEingabe = new JTextField();
				getContentPane().add(jTFIndexEingabe);
				jTFIndexEingabe.setBounds(7, 122, 56, 21);
				jTFIndexEingabe.setVisible(false);
			}
			{
				jLEingabe = new JLabel();
				getContentPane().add(jLEingabe);
				jLEingabe.setText(". Messwert");
				jLEingabe.setBounds(64, 125, 81, 14);
				jLEingabe.setVisible(false);
			}
			{
				jBtnBearbeiten = new JButton();
				getContentPane().add(jBtnBearbeiten);
				jBtnBearbeiten.setText("bearbeiten");
				jBtnBearbeiten.setBounds(157, 122, 126, 21);
				jBtnBearbeiten.setVisible(false);
				jBtnBearbeiten.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnBearbeitenActionPerformed(evt);
					}
				});
			}
			{
				jLWert = new JLabel();
				getContentPane().add(jLWert);
				jLWert.setText("Wert");
				jLWert.setBounds(7, 155, 51, 14);
				jLWert.setVisible(false);
			}
			{
				jTFWert = new JTextField();
				getContentPane().add(jTFWert);
				jTFWert.setBounds(7, 169, 78, 21);
				jTFWert.setVisible(false);
			}
			{
				jBtnSpeichern = new JButton();
				getContentPane().add(jBtnSpeichern);
				jBtnSpeichern.setText("speichern");
				jBtnSpeichern.setBounds(125, 169, 91, 21);
				jBtnSpeichern.setVisible(false);
				jBtnSpeichern.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnSpeichernActionPerformed(evt);
					}
				});
			}
			{
				jBtnAuswerten = new JButton();
				getContentPane().add(jBtnAuswerten);
				jBtnAuswerten.setText("Messreihe auswerten");
				jBtnAuswerten.setBounds(7, 196, 173, 21);
				jBtnAuswerten.setVisible(false);
				jBtnAuswerten.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnAuswertenActionPerformed(evt);
					}
				});
			}
			{
				jLMaximum = new JLabel();
				getContentPane().add(jLMaximum);
				jLMaximum.setText("Maximalwert");
				jLMaximum.setBounds(7, 222, 137, 14);
			}
			{
				jLMinimum = new JLabel();
				getContentPane().add(jLMinimum);
				jLMinimum.setText("Minimalwert");
				jLMinimum.setBounds(7, 242, 130, 14);
			}
			{
				jLMittelwert = new JLabel();
				getContentPane().add(jLMittelwert);
				jLMittelwert.setText("Mittelwert");
				jLMittelwert.setBounds(7, 262, 137, 14);
			}
			pack();
			this.setSize(477, 320);
			
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	// Eingabe-Anzahl der Werte
	private void jBtnEingabeAnzahlActionPerformed(ActionEvent evt) {
		try {
			
			anzahl = Integer.parseInt(jTFAnzahl.getText());	// anzahl eingabewerte übernehmen
			if (anzahl <= 0) throw new NumberFormatException();	// fehlerausgabe bei anzahleingabe 0 oder kleiner
			// WICHTIG: ArrayList initialisieren 
			messwerte = new ArrayList<Double>();
					// 3 komponenten zur anzahleingabe ausblenden
			jLAnzahl.setVisible(false);
			jTFAnzahl.setVisible(false);
			jBtnEingabeAnzahl.setVisible(false);
			n++; 	// nr n für messwert eins höher setzen, war vorher auf 0 initialisiert
			jLMesswert.setText(n + ". Messwert");	// nr für label von 1. messwert-eingabe anpassen
					// 3 komponenten zur messwert-eingabe einblenden
			jLMesswert.setVisible(true);
			jTFMesswert.setVisible(true);
			jBtnEingabeMesswert.setVisible(true);
					// focus
			jTFMesswert.requestFocus();
		} catch (NumberFormatException nfe){ // fehler text falsche anzahl
			JOptionPane.showMessageDialog(null, "Gültige Eingabe für Anzahl Werte machen");
			jTFAnzahl.requestFocus();
			jTFAnzahl.selectAll();
		} catch (Exception e) {	// sonstige fehler
			JOptionPane.showMessageDialog(null, "Ungültiges Zahlenformat");
			jTFAnzahl.requestFocus();
			jTFAnzahl.selectAll();
		}
	}
	
	// eingabe der einzelnen messwerte bis anzahl einzugebender werte erreicht ist
	private void jBtnEingabeMesswertActionPerformed(ActionEvent evt) {
		if (n <= anzahl){    // wenn n-ter messwert <= anzahl der einzugebenden messwerte
			try {
				// jeweiligen messwert zu ArrayList hinzufügen
				messwerte.add(Double.parseDouble(jTFMesswert.getText()));
				n++; 		// nr n für näxten messwert eins höher setzen (& für näxtes if unten)
				jLMesswert.setText(n + ". Messwert"); //  label für n-te messwert-eingabe anpassen
				// focus
				jTFMesswert.requestFocus();
				jTFMesswert.setText("");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Ungültiges Zahlenformat");
				jTFMesswert.requestFocus();
				jTFMesswert.selectAll();
			}
		}
		if (n > anzahl){	// wenn n für messwert > anzahl der zu bearbeitenden messwerte (n++ vom 1. if!!)
			// foreach-schleife um array-werte auszugeben
			for (double ae: messwerte) {
				jLMesswerte.setText(jLMesswerte.getText() + "  " + ae);
			}
			jLMesswert.setVisible(false); // die 3 komp. zur Messwert-eingabe ausblenden
			jTFMesswert.setVisible(false);
			jBtnEingabeMesswert.setVisible(false);
			jTFIndexEingabe.setVisible(true); // die 3 komp. zur "index"-eingabe einblenden
			jTFIndexEingabe.requestFocus();
			jLEingabe.setVisible(true);
			jBtnBearbeiten.setVisible(true);
			jBtnAuswerten.setVisible(true);
		}
	}
	
	// eingabe von "index" für messwert, der bearbeitet werden soll
	private void jBtnBearbeitenActionPerformed(ActionEvent evt) {
		try { 												// try, wenn gültige zahleneingabe
			index = Integer.parseInt(jTFIndexEingabe.getText()) ; // eingegebene messwertnummer speichern
			index--; 									// -> index wie immer eins kleiner als die messwertnummer-eingabe
			if ((index >= 0) && (index < messwerte.size())){ // wenn index im ArrayList vorhanden
				// neue variabel für messwert init. & den wert des gefragten ArrayList-elements zuweisen
				messwert = messwerte.get(index);  				// 
				jTFWert.setText(String.valueOf(messwert)); 	// messwert in jTFWert ausgeben
				jTFWert.setVisible(true); 					// 3.komp zur wert-eingabe-speicherung einblenden
				jLWert.setVisible(true);
				jBtnSpeichern.setVisible(true);
				jTFWert.requestFocus();
				jTFWert.selectAll();
			} else { 										// sonst Fehlertext
				JOptionPane.showMessageDialog(null, "Index ausserhalb der Messreihe!");
				jTFIndexEingabe.requestFocus();
				jTFIndexEingabe.selectAll();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falsches Zahlenformat!");
		}
		 
	}
	// in ArrayList speichern vom abgeänderten wert (der oben anhand vom index ausgewählt wurde) + neuausgabe im jLMesswerte
	private void jBtnSpeichernActionPerformed(ActionEvent evt) {
		try {				// try, wenn gültige zahleneingabe
			messwert = Double.parseDouble(jTFWert.getText());  // zusätzliche variabel wäre nicht unbedingt nötig aber hey
			messwerte.set(index, messwert);					// element von ArrayList ersetzen
			jLMesswerte.setText("Messwerte: ");
			for (Double ae: messwerte) {					// jLMesswerte angepasst neu ausgeben mit foreach-schleife
				jLMesswerte.setText(jLMesswerte.getText() + "  " + ae);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ungültiges Zahlenformat");
			jTFWert.requestFocus();
			jTFWert.selectAll();
		}
	}
	
	// auswerten der im ArrayList gespeicherten messwert (mittelwert, minimum, maximum) und ausgabe in labels
	private void jBtnAuswertenActionPerformed(ActionEvent evt) {
		maximum = messwerte.get(0); 
		minimum = messwerte.get(0);
		summe = 0;
		for (Double ae: messwerte) {
			if (maximum < ae) maximum = ae;
			if (minimum > ae) minimum = ae;
			summe = summe + ae;
		}
		mittelwert = summe / messwerte.size();
		jLMaximum.setText("Maximalwert: " + maximum);
		jLMinimum.setText("Minimalwert: " + minimum);
		jLMittelwert.setText("Mittelwert: " + mittelwert);
	}

}

/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/