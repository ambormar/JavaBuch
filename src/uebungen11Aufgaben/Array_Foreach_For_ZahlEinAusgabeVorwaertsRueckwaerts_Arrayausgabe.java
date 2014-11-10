/* TODO 11.3.   Aufgabe 1, s.344
 * class Array_Foreach_For_ZahlEinAusgabeVorwaertsRueckwaerts_Arrayausgabe
 * 
 * Es können beliebig viele Zahlenwerte eingegeben werden. Die Zahlen werden anschließend in einem JLabel 
 * in der Reihenfolge, in der sie eingegeben wurden und in einem zweiten JLabel in umgekehrter
 * Reihenfolge ausgegeben.
 */

package uebungen11Aufgaben;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

public class Array_Foreach_For_ZahlEinAusgabeVorwaertsRueckwaerts_Arrayausgabe extends javax.swing.JFrame {
	private JLabel jLabel1;
	private JButton jBtnEingabeAnzahl;
	private JButton jBtnNeu;
	private JLabel jLAusgaberueckwaerts;
	private JLabel jLAusgabevorwaerts;
	private JButton jBtnEingabeZahl;
	private JTextField jTFZahl;
	private JLabel jLZahl;
	private JTextField jTFAnzahl;
	// variabeln für anzahl zahlen, und nr. n von aktueller jLZahl (zu bearbeitender zahl)
	private int anzahl, n;
	// array deklarieren
	private int[] zahlen;
	

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Array_Foreach_For_ZahlEinAusgabeVorwaertsRueckwaerts_Arrayausgabe inst = new Array_Foreach_For_ZahlEinAusgabeVorwaertsRueckwaerts_Arrayausgabe();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public Array_Foreach_For_ZahlEinAusgabeVorwaertsRueckwaerts_Arrayausgabe() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Arrayausgabe");
			getContentPane().setLayout(null);
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("Wieviele Zahlen sollen eingegeben werden?");
				jLabel1.setBounds(12, 12, 260, 16);
			}
			{
				jTFAnzahl = new JTextField();
				getContentPane().add(jTFAnzahl);
				jTFAnzahl.setBounds(279, 9, 62, 23);
			}
			{
				jBtnEingabeAnzahl = new JButton();
				getContentPane().add(jBtnEingabeAnzahl);
				jBtnEingabeAnzahl.setText("ok");
				jBtnEingabeAnzahl.setBounds(364, 9, 63, 23);
				jBtnEingabeAnzahl.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnEingabeAnzahlActionPerformed(evt);
					}
				});
			}
			{
				jLZahl = new JLabel();
				getContentPane().add(jLZahl);
				jLZahl.setText("Zahl");
				jLZahl.setBounds(12, 48, 62, 16);
				jLZahl.setVisible(false);
			}
			{
				jTFZahl = new JTextField();
				getContentPane().add(jTFZahl);
				jTFZahl.setBounds(12, 70, 62, 23);
				jTFZahl.setVisible(false);
			}
			{
				jBtnEingabeZahl = new JButton();
				getContentPane().add(jBtnEingabeZahl);
				jBtnEingabeZahl.setText("ok");
				jBtnEingabeZahl.setBounds(92, 70, 58, 23);
				jBtnEingabeZahl.setVisible(false);
				jBtnEingabeZahl.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnEingabeZahlActionPerformed(evt);
					}
				});
				
			}
			{
				jBtnNeu = new JButton();
				getContentPane().add(jBtnNeu);
				jBtnNeu.setText("Neue Eingabe");
				jBtnNeu.setBounds(220, 70, 159, 23);
				jBtnNeu.setVisible(false);
				jBtnNeu.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnNeuActionPerformed(evt);
					}
				});
				
			}
			{
				jLAusgabevorwaerts = new JLabel();
				getContentPane().add(jLAusgabevorwaerts);
				jLAusgabevorwaerts.setBounds(12, 111, 415, 16);
			}
			{
				jLAusgaberueckwaerts = new JLabel();
				getContentPane().add(jLAusgaberueckwaerts);
				jLAusgaberueckwaerts.setBounds(12, 144, 415, 16);
			}
			pack();
			this.setSize(467, 223);
			// variable für nr. jLZahl mit 0 initialisieren
			n = 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void jBtnEingabeAnzahlActionPerformed(ActionEvent evt) {
		try {
			// anzahl die eingabe der anzahl zahlen zuweisen
			anzahl = Integer.parseInt(jTFAnzahl.getText());
			// fehlerausgabe, wenn 0 oder kleiner für anzahl zahlen eingegeben wird
			if (anzahl <= 0) throw new NumberFormatException();
			// array mit anzahl Zahlen/elementen initialisieren
			zahlen = new int[anzahl];
			jLabel1.setVisible(false);
			jTFAnzahl.setVisible(false);
			jBtnEingabeAnzahl.setVisible(false);
			// variabel für nr. von jLZahl (= aktuell einzugebender zahl)
			n++;	// oben auf 0 gesetzt, also eins erhöhen für erste einzugebende zahl
			jLZahl.setText(n + ". Zahl"); // Labelausgabe der aktuell einzulesenden zahl
			jLZahl.setVisible(true);
			jTFZahl.setVisible(true);
			jBtnEingabeZahl.setVisible(true);
			jTFZahl.requestFocus();
		} catch (NumberFormatException nfe){
			JOptionPane.showMessageDialog(null, "Gültige Anzahl eingeben!");
			jTFAnzahl.requestFocus();
			jTFAnzahl.selectAll();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,  "Falsches Zahlenfornmat");
			jTFAnzahl.requestFocus();
			jTFAnzahl.selectAll();
		}
	}
	
	private void jBtnEingabeZahlActionPerformed(ActionEvent evt) {
		if (n <= anzahl){ // wenn n-te zahl <= anzahl der einzugebenden zahlen
			try {	
				zahlen[n-1] = Integer.parseInt(jTFZahl.getText()); // zahl speichern
				n++; // zu bearbeitende zahl eins höher setzen mit jeder eingabe
				jLZahl.setText(n + ". Zahl"); // label der näxt einzugebenden zahl ausgeben
				jTFZahl.setText("");
				jTFZahl.requestFocus();
			} catch (Exception e) { 
				JOptionPane.showMessageDialog(null, "Falsches Zahlenformat");
				jTFZahl.requestFocus();
				jTFZahl.selectAll();
			}
		} 
		// 2. if wird erst aktiv wenn die bedingungen dafür im ersten if erfüllt werden, desshalb: if if & nicht: if else
		if (n > anzahl) {	// wenn n-te zahl > anzahl der zu bearbeitenden zahlen
			jLAusgabevorwaerts.setText("Ausgabe vorwärts: ");
			jLAusgaberueckwaerts.setText("Ausgabe rückwärts: ");
			// foreach-schleife für vorwärts-ausgabe
			for (int ae: zahlen){
				jLAusgabevorwaerts.setText(jLAusgabevorwaerts.getText() + "  " + ae);
			}
			// for-schleife für rückwärts-ausgabe
			// n-2: weil n schon auf näxte einzugebende zahl erhöht war & zusätzlich -1 weil erste zahl im index 0
			for (int x = n - 2 ; x >= 0; x--){
				jLAusgaberueckwaerts.setText(jLAusgaberueckwaerts.getText() + "  " + zahlen[x]);
			}
			jLZahl.setText("");
			jTFZahl.setVisible(false);
			jBtnEingabeZahl.setVisible(false);
			jBtnNeu.setVisible(true);
		}
	}
	
	private void jBtnNeuActionPerformed(ActionEvent evt) {
		// alle aktuell sichtbaren komponenten ausblenden
		jLAusgabevorwaerts.setText("");
		jLAusgaberueckwaerts.setText("");
		jBtnNeu.setVisible(false);
		// die 3 komponenten zur eingabe der anzahl zahlen einblenden
		jLabel1.setVisible(true);
		jTFAnzahl.setVisible(true);
		jTFAnzahl.setText("");
		jTFAnzahl.requestFocus();
		jBtnEingabeAnzahl.setVisible(true);
		// aktuell zu bearbeitende zahl wieder auf 0
		n = 0;
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