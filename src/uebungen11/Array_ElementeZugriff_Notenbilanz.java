/* TODO 11.1.3.   s.328 
 * klasse Array_ElementeZugriff_Notenbilanz (programm-erweiterung von	11.1.	Array_Basic_Notenbilanz		s.319)
 * 
 *  
 * ZUGRIFF AUF ARRAY-ELEMENTE:		-> eigtl. besser siehe: 		11.1.   Array_Basics_Notenbilanz		s.319	
 * 
 * 		SCHEMA:		WENN:	public double [] noten = new double[notenanzahl];
 * 
 * 					DANN:	noten[index] = ...;		// bsp:		noten[0] = 6; 	...werte zuweisen über array-bezeichner und index des elements in klammer
 * 																					=> REMEMBER: index 0 bis anzahl elemente -1
 * 
 * 							- anstelle der werte können natürlich auch variablen stehen		// bsp: 	noten[notennummer]= Double.parseDouble(jTFNeuerWert.getText());
 *
 *
 * 		SONST NIX NEUES AUSSER PROGRAMM-ABLAUF-LOGIK:
 * 
 * 					LOGIK: 	siehe  	jBtnNotennummerActionPerformed(...)						ca. zeile	335
 * 								&	jBtnNeuerWertSpeichernActionPerformed(...)				ca. zeile	360
 * 
 * 							- für jeweilige array-elemente:		werte zuweisen / abrufen
 * 							- textfelder/labels/buttons ein-& ausblenden nach programm-logik, wenn werte korrekt & vollständig eingegeben wurden (try-catch zum prüfen)
 * 							- jeweilige neuberechnungen anhand der neuen array-elemente, wie notenschnitt, beste, schlechteste note etc.
 * 
 * 
 * K&K: Programm Array_ElementeZugriff_Notenbilanz (= Erweiterung von programm 11.1. Array_Basic_Notenbilanz 
 * 														& =array-version von 9.4. Jigloo_Events_setVisible_GUI_Notenbilanz )
 * 		berechnet aus mehreren eingegebenen Noten den Notenschnitt und gibt zusätzlich die beste & die schlechteste Note aus.
 * 		zusätzlich lassen sich einzelne notenwerte (array-elemente) überschreiben und notenausgabe, notenschnitt, beste note etc. werden angepasst.
 * 
 * 		/// double-array
 * 		/// foreach-schleife
 * 
 * 		/// sonstiges
 * 
 * 		/// sonstige code-erklärungen: siehe Array_Basic_Notenbilanz (uebungen11Aufgaben) oder Events_setVisible_GUI_Notenbilanz aus uebungen09Aufgaben
 * Programm Notenbilanz berechnet aus mehreren eingegebenen Noten den Notenschnitt und gibt zusätzlich die beste, die schlechteste Note aus.
 */

package uebungen11;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

public class Array_ElementeZugriff_Notenbilanz extends javax.swing.JFrame {
	private JLabel jLAnzNot;
	private JTextField jTFNotenzahl;
	private JButton jBtnAnzahlUebernehmen;
	private JLabel jLNotenschnitt;
	private JLabel jLSchlechtesteNote;
	private JButton jBtnNeu;
	private JLabel jLBesteNote;
	private JLabel jLNotenzahl;
	private JTextField jTFNote;
	private JButton jBtnNoteUebernehmen;
	private JLabel jLNote;
	private JButton jBtnEnde;
	private JLabel jLNoten;
	
	public DecimalFormat f;
	private JButton jBtnNeuerWertSpeichern;
	private JTextField jTFNeuerWert;
	private JLabel jLNeuerWert;
	private JButton jBtnNotennummer;
	private JLabel jLNotennummer;
	private JTextField jTFNotennummer;
	public int notenzahl, i, notennummer; 
	public double notenschnitt, besteNote, schlechtesteNote, summe;
	// Array vom typ double deklarieren um noten zu speichern
	public double [] noten; 
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Array_ElementeZugriff_Notenbilanz inst = new Array_ElementeZugriff_Notenbilanz();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public Array_ElementeZugriff_Notenbilanz() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Notenbilanz");
			{
				f = new DecimalFormat("#0.00"); // (decimalformat initialisieren)
			}
			{
				jLAnzNot = new JLabel();
				getContentPane().add(jLAnzNot);
				jLAnzNot.setText("Anzahl Noten");
				jLAnzNot.setBounds(12, 12, 88, 16);
			}
			{
				jTFNotenzahl = new JTextField();
				getContentPane().add(jTFNotenzahl);
				jTFNotenzahl.setBounds(12, 35, 44, 23);
				jTFNotenzahl.addKeyListener(new KeyAdapter() {
					public void keyPressed(KeyEvent evt) {
						jTFNotenzahlKeyPressed(evt);
					}
				});
			}
			{
				jBtnAnzahlUebernehmen = new JButton();
				getContentPane().add(jBtnAnzahlUebernehmen);
				jBtnAnzahlUebernehmen.setText("Übernehmen");
				jBtnAnzahlUebernehmen.setBounds(72, 35, 130, 23);
				jBtnAnzahlUebernehmen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnAnzahlUebernehmenActionPerformed(evt);
					}
				});
			}
			{
				jBtnEnde = new JButton();
				getContentPane().add(jBtnEnde);
				jBtnEnde.setText("Ende");
				jBtnEnde.setBounds(343, 281, 72, 23);
				jBtnEnde.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnEndeActionPerformed(evt);
					}
				});
			}
			{
				jLNote = new JLabel();
				getContentPane().add(jLNote);
				jLNote.setText("1. Note");
				jLNote.setBounds(12, 74, 50, 16);
				jLNote.setVisible(false);
			}
			{
				jBtnNoteUebernehmen = new JButton();
				getContentPane().add(jBtnNoteUebernehmen);
				jBtnNoteUebernehmen.setText("Übernehmen");
				jBtnNoteUebernehmen.setBounds(74, 99, 128, 23);
				jBtnNoteUebernehmen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnNoteUebernehmenActionPerformed(evt);
					}
				});
				jBtnNoteUebernehmen.setVisible(false);
			}
			{
				jTFNote = new JTextField();
				getContentPane().add(jTFNote);
				jTFNote.setBounds(12, 99, 44, 23);
				jTFNote.setVisible(false);
			}
			{
				jLNotenzahl = new JLabel();
				getContentPane().add(jLNotenzahl);
				jLNotenzahl.setBounds(12, 139, 190, 16);
			}
			{
				jLNotenschnitt = new JLabel();
				getContentPane().add(jLNotenschnitt);
				jLNotenschnitt.setBounds(12, 166, 190, 16);
			}
			{
				jLBesteNote = new JLabel();
				getContentPane().add(jLBesteNote);
				jLBesteNote.setBounds(12, 194, 190, 16);
			}
			{
				jLSchlechtesteNote = new JLabel();
				getContentPane().add(jLSchlechtesteNote);
				jLSchlechtesteNote.setBounds(12, 223, 190, 16);
			}
			{
				jBtnNeu = new JButton();
				getContentPane().add(jBtnNeu);
				jBtnNeu.setText("Neu Berechnen");
				jBtnNeu.setBounds(277, 35, 138, 23);
				jBtnNeu.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnNeuActionPerformed(evt);
					}
				});
				jBtnNeu.setVisible(false);
			}
			{
				jLNoten = new JLabel();
				getContentPane().add(jLNoten);
				jLNoten.setBounds(12, 253, 352, 16);
			}
			{
				jTFNotennummer = new JTextField();
				getContentPane().add(jTFNotennummer);
				jTFNotennummer.setBounds(218, 99, 37, 23);
				jTFNotennummer.setVisible(false);
			}
			{
				jLNotennummer = new JLabel();
				getContentPane().add(jLNotennummer);
				jLNotennummer.setText(". Note bearbeiten");
				jLNotennummer.setBounds(261, 102, 103, 16);
				jLNotennummer.setVisible(false);
			}
			{
				jBtnNotennummer = new JButton();
				getContentPane().add(jBtnNotennummer);
				jBtnNotennummer.setText("ok");
				jBtnNotennummer.setBounds(367, 99, 48, 23);
				jBtnNotennummer.setVisible(false);
				jBtnNotennummer.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnNotennummerActionPerformed(evt);
					}
				});
			}
			{
				jLNeuerWert = new JLabel();
				getContentPane().add(jLNeuerWert);
				jLNeuerWert.setText(". Note");
				jLNeuerWert.setBounds(255, 139, 54, 16);
				jLNeuerWert.setVisible(false);
			}
			{
				jTFNeuerWert = new JTextField();
				getContentPane().add(jTFNeuerWert);
				jTFNeuerWert.setBounds(255, 163, 46, 23);
				jTFNeuerWert.setVisible(false);
			}
			{
				jBtnNeuerWertSpeichern = new JButton();
				getContentPane().add(jBtnNeuerWertSpeichern);
				jBtnNeuerWertSpeichern.setText("Speichern");
				jBtnNeuerWertSpeichern.setBounds(313, 163, 102, 23);
				jBtnNeuerWertSpeichern.setVisible(false);
				jBtnNeuerWertSpeichern.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnNeuerWertSpeichernActionPerformed(evt);
					}
				});
			}
			pack();
			this.setSize(450, 365);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void anzahlUebernehmen(){
		if (!jTFNotenzahl.getText().equals("")){
			notenzahl = Integer.parseInt(jTFNotenzahl.getText());
			noten = new double[notenzahl];
			i = 1;
			summe = 0;
			notenschnitt = 0;
			besteNote = 1; 						// (schlechteste (ch) note eingeben zum vergleich)
			schlechtesteNote = 6;				// (beste (ch) note eingeben zum vergleich)
							// (die nachfolgenden komponenten sichtbar machen)
			jLNote.setVisible(true);
			jTFNote.setVisible(true);
			jBtnNoteUebernehmen.setVisible(true);
			jBtnAnzahlUebernehmen.setVisible(false);
			jTFNotenzahl.setEditable(false);
			jTFNote.requestFocus();
		} else {
			JOptionPane.showMessageDialog(null, "Bitte Anzahl Noten eingeben!");
			jTFNote.setText("");
			jTFNote.requestFocus();
		}

	}
	
	private void jBtnAnzahlUebernehmenActionPerformed(ActionEvent evt) {
		anzahlUebernehmen();
	}
	
	private void jTFNotenzahlKeyPressed(KeyEvent evt) {
		if (evt.getKeyCode() == KeyEvent.VK_ENTER){
			anzahlUebernehmen();
		}
	}
	
	private void jBtnNoteUebernehmenActionPerformed(ActionEvent evt) {
		if (!jTFNote.getText().equals("") 
				&& Double.parseDouble(jTFNote.getText()) >= 1 
				&& Double.parseDouble(jTFNote.getText())<= 6){
			
						// jede Note bei der Übernahme im Array abspeichern
			noten[i-1]= Double.parseDouble(jTFNote.getText()); // i-1 weil array-index[] mit 0 anfängt
			
			summe = summe + Double.parseDouble(jTFNote.getText());
			notenschnitt = summe / i;
			jLNotenzahl.setText("Anzahl eingegebene Noten: " + i);
			jLNotenschnitt.setText("Notenschnitt: " + f.format(notenschnitt));
						// (beste note nur überschreiben, wenn bessere dazukommt)
			if (Double.parseDouble(jTFNote.getText()) >= besteNote){ 	
				besteNote = Double.parseDouble(jTFNote.getText());
				jLBesteNote.setText("beste Note: " + Double.toString(besteNote));
			}
						// (schlechteste note nur überschreiben, wenn schlechtere dazukommt)
			if (Double.parseDouble(jTFNote.getText()) <= schlechtesteNote){ 	
				schlechtesteNote = Double.parseDouble(jTFNote.getText());
				jLSchlechtesteNote.setText("schlechteste Note: " + Double.toString(schlechtesteNote));
			}
			if (i == notenzahl){
				jBtnNoteUebernehmen.setVisible(false);
				jBtnNeu.setVisible(true);
				jLNotennummer.setVisible(true);
				jTFNotennummer.setVisible(true);
				jBtnNotennummer.setVisible(true);
				jTFNotennummer.requestFocus();
				jTFNotennummer.selectAll();
						// array ausgabe der noten nachdem alle noten eingegeben sind
				jLNoten.setText("Noten:");
				for (int y = 0; y < noten.length; y++) {
						jLNoten.setText(jLNoten.getText() + "  " + noten[y]);  
				}
	
			} else {
				i++;
				jLNote.setText(i + ". Note");
				jTFNote.setText("");
				jTFNote.requestFocus();
			}
			
		} else {
			JOptionPane.showMessageDialog(null, "Bitte Note von 1-6 eingeben!");
		}
	}

	private void jBtnNotennummerActionPerformed(ActionEvent evt) {
		try { // try ob gültige zahleneingabe
			notennummer = Integer.parseInt(jTFNotennummer.getText())-1; // -1 weil zb. erste note = index[0] // notennummer extra zuoberst neu deklariert	
			if (notennummer >= 0 && notennummer < notenzahl){ // wenn vorhandene note gewählt wird...
				jLNeuerWert.setText((notennummer+1) + ". Note");		// notennummer ins label
				jTFNeuerWert.setText(String.valueOf(noten[notennummer])); // notenwert ins textfenter
				
				jLNeuerWert.setVisible(true);
				jTFNeuerWert.setVisible(true);
				jBtnNeuerWertSpeichern.setVisible(true);
				
				jTFNeuerWert.requestFocus();
				jTFNeuerWert.selectAll();
			} else {  // sonst korrektur-aufforderungs-fenster
				JOptionPane.showMessageDialog(null, "Notennummer ausserhalb des gültigen Bereichs");
				jTFNotennummer.requestFocus();
				jTFNotennummer.selectAll();
			}
		} catch (Exception e){ // fehler ausgeben für ungültiges zahlenformat
			JOptionPane.showMessageDialog(null, "Ungültiges Zahlenformat");
			jTFNotennummer.requestFocus();
			jTFNotennummer.selectAll();
		}
		
	}
	
	private void jBtnNeuerWertSpeichernActionPerformed(ActionEvent evt) {	// eigentlichen neuen array-wert anzupassen ist einfach  mit noten[index]...
		try { // try (falls (noten)-zahleingeben korrekt)							// .. rest der umfangreichen methode ist um notenschnitt etc, anzupassen
			if (Double.parseDouble(jTFNeuerWert.getText()) < 1 	
					|| Double.parseDouble(jTFNeuerWert.getText())> 6) {
				throw new Exception();		// zusätzliche exception falls notenzahl ungültig
			}
			// eigentlichen neuen array-wert anzupassen ist einfach  mit noten[index]
			noten[notennummer]= Double.parseDouble(jTFNeuerWert.getText()); // abzuändernde note wird auf neuen wert gesetzt
			summe = 0;						// summe neu initialisieren
			besteNote = noten[0];			// array index auf 0 setzen > werte werden unten vom ersten wert an von neuem verglichen 
			schlechtesteNote = noten [0];	// array index auf 0 setzen > werte werden unten vom ersten wert an von neuem verglichen 
			jLNoten.setText("Noten: ");		// brauchts wegen .getText() / .setText() in der gleich folgenden schleife
			for (double x: noten){			// foreach-schleife für noten[]
				summe = summe + x;			// alle werte des abgeänderten arrays werden summiert
				if (besteNote < x) besteNote = x;				// beste/schlechteste wird überschrieben, wenn in der schleife ein besserer/schlechterer wert verglichen wird
				if (schlechtesteNote > x) schlechtesteNote = x;	// ch noten beste = 6!!!!
				jLNoten.setText(jLNoten.getText() + "  " + x);	// neu ausgeben mit schleife
			}
			/* alternativ mit for-schleife statt mit foreach-schleife:
			for (int x = 0; x < noten.length; x++){
				summe = summe + noten[x];
				if (besteNote < noten[x]) besteNote = noten[x];				
				if (schlechtesteNote > noten[x]) schlechtesteNote = noten[x];
				jLNoten.setText(jLNoten.getText() + "  " + noten[x]);

			}*/
			notenschnitt = summe / notenzahl;		// neuer notenschnitt
			// alles neu ausgeben:
			jLNotenschnitt.setText("Notenschnitt: " + f.format(notenschnitt)); // formatierten nottenschnitt ausgeben
			jLBesteNote.setText("beste Note: " + besteNote);
			jLSchlechtesteNote.setText("schlechteste Note: " + schlechtesteNote);
			// focus auf textfeld notennummer zurück
			jTFNotennummer.requestFocus();
			jTFNotennummer.selectAll();
		} catch (Exception e) { // falls irgendwelche Fehleingaben
			JOptionPane.showMessageDialog(null, "Gültige Notenzahl eingeben"); // ziemlich allgemeiner fehlertext
			jTFNeuerWert.requestFocus();
			jTFNeuerWert.selectAll();
		}
	}
	
	private void jBtnNeuActionPerformed(ActionEvent evt) {
		i = 1;
		jLNote.setText(i + ". Note");
		summe = 0;
		notenschnitt = 0;
		besteNote = 1;
		schlechtesteNote = 6;
		jBtnAnzahlUebernehmen.setVisible(true);
		jTFNotenzahl.setEditable(true);
		jTFNotenzahl.setText("");
		jTFNotenzahl.requestFocus();
		jLNote.setVisible(false);
		jTFNote.setVisible(false);
		jTFNote.setText("");
		jBtnNoteUebernehmen.setVisible(false);
		jLNotenzahl.setText("");
		jLNotenschnitt.setText("");
		jLBesteNote.setText("");
		jLSchlechtesteNote.setText("");
		jLNoten.setText("");
		jBtnNeu.setVisible(false);
		jLNotennummer.setVisible(false);
		jTFNotennummer.setVisible(false);
		jTFNotennummer.setText("");
		jBtnNotennummer.setVisible(false);
		jLNeuerWert.setVisible(false);
		jTFNeuerWert.setVisible(false);
		jBtnNeuerWertSpeichern.setVisible(false);
		
		// garbage-collector aktiv auslösen
		System.gc(); 
	}
	private void jBtnEndeActionPerformed(ActionEvent evt) {
		System.exit(0);
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