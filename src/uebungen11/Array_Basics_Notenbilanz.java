/* TODO 11.1.   s.319 
 * klasse Array_Basics_Notenbilanz
 * 
 * [11. CONTAINERKLASSEN:	- containerklassen dienen dazu andere elemente aufzunehmen
 * 							- die grundlegende containerklasse in java ist array (manchmal auch "feld" oder "reihung" renannt)		]
 * 
 * 11.1. ARRAY:			- array ist die grundlegende containerklasse in java
 * 						- dient zum speichern von PRIMITIVEN DATENTYPEN & REFERENZDATENTYPEN	
 * 						- in einem array können nur dateien gleichen datentyps gespeichert werden
 * 						- die anzahl elemente eines arrays kann nach der erzeugung nicht mehr verändert werden
 * 						- anzahl elemente:  beliebiger ausdruck mit (ergebnis) typ int ist in der rechteckigen klammer möglich 
 * 											-> array grösse kann somit auch erst während programm-laufzeit festgelegt werden 
 * 
 *
 * 		BSP:			double [] a = new double[5]								// oder: ...= new double[notenAnzahl]		oder: ...= new double[35-(2*15)]	
 * 
 * 		SCHEMA:			datentyp [] bezeichner = new datentyp[anzahlElemente]	// anzahlElemente kann auch wärend prorgrammlaufzeit ein wert zugewiesen werden
 *
 * 		DEFINITION:		double [] a			// => definition der array-variablen, vom daten-typ double, mit bezeichner a, (damit ist noch kein speicher reserviert)
 * 
 * 	 	ERZEUGUNG:		a = new double[5]	// => erzeugung des Arrays für 5 double-werte, und reservieren von deren speicherplatz...
 * 			&	
 *		SPEICHERPLATZ:			"			=>	a[0], a[1], a[2], a[3], a[4]		// REMEMBER: index 0 bis anzahl elemente -1
 * 															
 * 		EINZELNE ELEMENTE ANSPRECHEN ...:		a[0] = 2.3;							// ...über bezeichner und index des elements in klammer		
 * 
 * 		INDEX:			a[0]				= zahl in der eckigen klammer hinter dem bezeichner, bestimmt welches element des array jeweils angesprochen wird		
 * 											=> REMEMBER: index 0 bis anzahl elemente -1
 * 						
 * 		ARRAYAUSGABE:		alle elemente eines arrays aufrufen bzw. ausgeben mittels FOR-SCHLEIFE oder FOREACH-SCHLEIFE
 * 
 * 							FOR-SCHLEIFE:		bsp:		for (int i = 0; i < a.length; i++) {
 *																jLName.setText(jLName.getText() + "  " + a[i]);  // immer text abrufen & elemente anhängen..
 *															}													 // .. solange es elemente hat
 *																			
 * 							FOREACH-SCHLEIFE:	bsp:		for (double ae: a) {							
 *																jLName.setText(jLName.getText() + "  " + ae);
 *															}
 * 
 * NB:	GARBAGE-COLLECTOR:		System.gc() 	= aufruf des Garbage-collectors,   								/// ca. zeile 333, s.325: 
 * 													-> z.b. wenn array überschrieben wurde, um abgelaufene array-werte selber aktiv zu löschen
 * 														(würde java auch selber machen aber halt irgendwann, oder wenn speicherplatz knapp wird) 
 * 
 * 
 * K&K:	Programm Array_Basic_Notenbilanz (= array-version von programm 9.4. Jigloo_Events_setVisible_GUI_Notenbilanz)
 * 		berechnet aus mehreren eingegebenen Noten den Notenschnitt und gibt zusätzlich die beste & die schlechteste Note aus.
 * 
 * 		///double-array um noten zu speichern & array ausgabe in for-schleife
 * 		/// foreach-schleife alternativ (kürzer) statt for-schleife: ca. zeile 290
 * 
 * 		/// sonst, ca. zeile 333, s.325: System.gc() =aufruf des Garbage-collectors, z.bsp wenn  
 * 		/// array überschrieben wird, um abgelaufene array-werte selber aktiv zu löschen
 * 
 * 		/// sonstige code-erklärungen: siehe 	9.4. Jigloo_Events_setVisible_GUI_Notenbilanz 	aus uebungen09Aufgaben
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

public class Array_Basics_Notenbilanz extends javax.swing.JFrame {
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
	
	public DecimalFormat f;											// wieso sind ab hier die variablen public? maja fragen bei gelegenheit
	public int notenzahl, i; 
	public double notenschnitt, besteNote, schlechtesteNote, summe;
	// Array vom typ double deklarieren um noten zu speichern
	public double [] noten; 
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Array_Basics_Notenbilanz inst = new Array_Basics_Notenbilanz();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public Array_Basics_Notenbilanz() {
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
				jBtnEnde.setBounds(292, 285, 72, 23);
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
				jBtnNeu.setBounds(226, 35, 138, 23);
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
			pack();
			this.setSize(400, 365);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void anzahlUebernehmen(){
		if (!jTFNotenzahl.getText().equals("")){
			notenzahl = Integer.parseInt(jTFNotenzahl.getText());
			// anzahl der elemente für array initialisieren
			noten = new double[notenzahl];
			//////////////////////////////
							// (restliche  variabeln für nächsten schritt initialisieren:)
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
			//////////
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
	
				// array ausgabe der noten nachdem alle noten eingegeben sind
				jLNoten.setText("Noten:");
				// in der for-schlaufe: .getText() +  ein array-element nach dem anderen anhängen, soviele wie's elemente hat
				for (int y = 0; y < noten.length; y++) {
						jLNoten.setText(jLNoten.getText() + "  " + noten[y]);  
				}
				// foreach-schleife wäre alternative zur for-schleife: (s.324)
				/*for (double ae: noten) {							// ae steht für all elements
					jLNoten.setText(jLNoten.getText() + "  " + ae);
				}*/
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
		// garbage-collector aktiv auslösen, um array-werte zu löschen auf die eh nicht mehr zugegriffen wird
		System.gc(); // würde java auch selber machen aber halt irgendwann, oder wenn speicherplatz knapp wird
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