/* TODO 11.3.   Aufgabe 4, s.345
 * class ArrayList_WerteEingebenAbaendernLoeschenAuswerten_Messreihe
 * 
 * Programm Messreihe_ArrayList. Es kann eine Messreihe beliebiger Größe eingegeben und ausgewertet
 * werden. Die Messwerte werden in eine ArrayList eingelesen. Einzelne Messwerte können auch noch 
 * nachträglich bearbeitet oder gelöscht werden.
 */

package uebungen11Aufgaben;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// NICHT vergessen zu importieren
import java.util.ArrayList;	

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


public class ArrayList_WerteEingebenAbaendernLoeschenAuswerten_Messreihe extends javax.swing.JFrame {
	private JLabel jLMesswert;
	private JButton jBtnSpeichern;
	private JTextField jTFWert;
	private JLabel jLWert;
	private JButton jBtnBearbeiten;
	private JLabel jLEingabe;
	private JTextField jTFIndexEingabe;
	private JLabel jLMesswerte;
	private JButton jBtnLoeschen;
	private JLabel jLMinimum;
	private JLabel jLMittelwert;
	private JLabel jLMaximum;
	private JButton jBtnAuswerten;
	private JButton jBtnEingabeMesswert;
	private JTextField jTFMesswert;
	// variabeln für anzahl & index der werte
	private int anzahl, index;
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
				ArrayList_WerteEingebenAbaendernLoeschenAuswerten_Messreihe inst = new ArrayList_WerteEingebenAbaendernLoeschenAuswerten_Messreihe();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public ArrayList_WerteEingebenAbaendernLoeschenAuswerten_Messreihe() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Messreihe");
			{
				jLMesswert = new JLabel();
				getContentPane().add(jLMesswert);
				jLMesswert.setText("1. Messwert:");
				jLMesswert.setBounds(7, 17, 91, 14);
			}
			{
				jTFMesswert = new JTextField();
				getContentPane().add(jTFMesswert);
				jTFMesswert.setBounds(7, 35, 83, 21);
			}
			{
				jBtnEingabeMesswert = new JButton();
				getContentPane().add(jBtnEingabeMesswert);
				jBtnEingabeMesswert.setText("OK");
				jBtnEingabeMesswert.setBounds(115, 35, 72, 21);
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
				jLMesswerte.setBounds(7, 64, 450, 14);
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
			{
				jBtnLoeschen = new JButton();
				getContentPane().add(jBtnLoeschen);
				jBtnLoeschen.setText("löschen");
				jBtnLoeschen.setBounds(232, 168, 96, 23);
				jBtnLoeschen.setVisible(false);
				jBtnLoeschen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnLoeschenActionPerformed(evt);
					}
				});
			}
			pack();
			this.setSize(477, 320); 
			messwerte = new ArrayList<Double>();// ArrayList initialisieren
			anzahl = 0;							// anzahl initialisieren
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/* Eingabe-Anzahl der Werte brauchts mit ArrayList nicht mehr
	   initialisierung von ArrayList & anzahl sind ins initGUI() verschoben
	   
	private void jBtnEingabeAnzahlActionPerformed(ActionEvent evt) {
		try {
			Inhalt der gelöschten methode siehe array_arrayausgabe
	}*/
	
	// eingabe der einzelnen messwerte 
	private void jBtnEingabeMesswertActionPerformed(ActionEvent evt) {
		try {
			// jeweiligen messwert zu ArrayList hinzufügen
			messwerte.add(Double.parseDouble(jTFMesswert.getText()));
			anzahl++; 		// anzahl für näxten messwert eins höher setzen (& für näxtes if unten)
			jLMesswert.setText((anzahl + 1) + ". Messwert"); //  label für näxte messwert-eingabe anpassen
			// focus
			jTFMesswert.requestFocus();
			jTFMesswert.setText("");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ungültiges Zahlenformat");
			jTFMesswert.requestFocus();
			jTFMesswert.selectAll();
		}
		// foreach-schleife um ArrayList-werte auszugeben
		jLMesswerte.setText("Messwerte: ");
		for (Double ae: messwerte) { // für ArrayList Double gross schreiben
			jLMesswerte.setText(jLMesswerte.getText() + "  " + ae);
		}
		jTFIndexEingabe.setVisible(true); // die 3 komp. zur "index"-eingabe einblenden
		jLEingabe.setVisible(true);
		jBtnBearbeiten.setVisible(true);
		jBtnAuswerten.setVisible(true);	  // Btn zur auswertung einblenden
	}
	
	// eingabe von "index" für messwert, der bearbeitet werden soll
	private void jBtnBearbeitenActionPerformed(ActionEvent evt) {
		try { 												// try, wenn gültige zahleneingabe
			index = Integer.parseInt(jTFIndexEingabe.getText()) ; // eingegebene messwertnummer speichern
			index--; 									// -> index wie immer eins kleiner als die messwertnummer-eingabe
			if ((index >= 0) && (index < messwerte.size())){ // wenn index im ArrayList vorhanden
				// variabel messwert init. & den wert des gefragten ArrayList-elements zuweisen
				messwert = messwerte.get(index); 			
				jTFWert.setText(String.valueOf(messwert)); 	// messwert in jTFWert ausgeben
				jTFWert.setVisible(true); 					// 3 komp. zur wert-eingabe-speicherung einblenden
				jLWert.setVisible(true);
				jBtnLoeschen.setVisible(true);
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
			jTFIndexEingabe.requestFocus();
			jTFIndexEingabe.selectAll();
		}
		 
	}
	// in ArrayList speichern vom abgeänderten wert (der oben anhand vom index ausgewählt wurde) + neuausgabe im jLMesswerte
	private void jBtnSpeichernActionPerformed(ActionEvent evt) {
		try {				// try, wenn gültige zahleneingabe
			messwert = Double.parseDouble(jTFWert.getText());  // zusätzliche variabel wäre nicht unbedingt nötig gewesen, aber hey
			// .set(): element von ArrayList ERSETZEN !!!
			messwerte.set(index, messwert);	
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
	
	// das zu bearbeitende element löschen
	private void jBtnLoeschenActionPerformed(ActionEvent evt) {
		// löschen von element mit index index (oben bei bearbeiten schon eingegeben)
		messwerte.remove(index); 
		// zum label anpassen eins weniger, weil wird ja eins gelöscht wird
		anzahl--; 
		jLMesswert.setText((anzahl + 1) + ". Messwert"); // anzahl + 1, weil oben auch schon so gehandhabt (könnt man glaub simpler, lösen aber hey)
		// & nochmal foreach-schleife zur erneuerung der vollständigen messwerte-ausgabe im label
		jLMesswerte.setText("Messwerte:");
		for (Double ae: messwerte) {
			jLMesswerte.setText(jLMesswerte.getText() + "  " + ae);
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