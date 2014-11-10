/* TODO 11.2.1.   s.335
 * class ArrayList_Angewandt_Notenbilanz_IstBesteLoesung
 * 
 * ARRAYLIST BASICS SIEHE:			11.2.1.   	ArrayList_Basics_Methoden_Konstruktoren	 	s.333 uf
 * 
 * [VERGL. MIT KOMPLIZIERTEREM:		11.1.   	Array_Basics_Notenbilanz					s.319 		]
 * 
 * PROGRAMM:	notenbilanz mit ArrayList gelöst
 * 
 * 				grundsätzlich einfacher/besser abänderbar als mit array
 * 				es können beliebig viele elemente hinzugefügt, gelöscht oder abgeändert werden
 * 
 * K&K:			Programm Notenbilanz berechnet aus mehreren eingegebenen Noten den Notenschnitt und gibt zusätzlich die beste, die
 *	 			schlechteste Note aus. Die Noten werden in einem JLabel gesammelt. Einzelne Noten können auch nachträglich bearbeitet werden.
 */

package uebungen11;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;



public class ArrayList_Angewandt_Notenbilanz_IstBesteLoesung extends javax.swing.JFrame {
	private JLabel jLNote;
	private JButton jBtnNoteUebernehmen;
	private JLabel jLNotenschnitt;
	private JLabel jLSchlechtesteNote;
	private JButton jBtnLoeschen;
	private JButton jBtnNeuenWertspeichern;
	private JTextField jTFNeuerWert;
	private JLabel jLNeuerWert;
	private JButton jBtnNotennummer;
	private JLabel jLNotennummer;
	private JTextField jTFNotennummer;
	private JLabel jLNoten;
	private JButton jBtnEnde;
	private JButton jBtnNeu;
	private JLabel jLNotenzahl;
	private JLabel jLBesteNote;
	private JTextField jTFNote;
	// wrapperobjekt zahlen formatiert darzustellen
	private DecimalFormat fzahl; 
	// variable für notennummer, kann nicht lokal in methode deklariert werden, weil für ganzen programmablauf nötig
	private int notennummer;
	// ArrayList für notenspeicherung deklarieren
	private ArrayList<Double> noten;
	

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ArrayList_Angewandt_Notenbilanz_IstBesteLoesung inst = new ArrayList_Angewandt_Notenbilanz_IstBesteLoesung();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public ArrayList_Angewandt_Notenbilanz_IstBesteLoesung() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setPreferredSize(new java.awt.Dimension(437, 309));
			this.setTitle("Notenbilanz");
			{
				fzahl = new DecimalFormat("#0.00"); // zaheln formatiert darstellen
			}
			{
				jLNote = new JLabel();
				getContentPane().add(jLNote);
				jLNote.setText("1.Note");
				jLNote.setBounds(6, 24, 47, 14);
			}
			{
				jTFNote = new JTextField();
				getContentPane().add(jTFNote);
				jTFNote.setBounds(6, 44, 41, 21);
			}
			{
				jBtnNoteUebernehmen = new JButton();
				getContentPane().add(jBtnNoteUebernehmen);
				jBtnNoteUebernehmen.setText("Übernehmen");
				jBtnNoteUebernehmen.setBounds(73, 44, 142, 21);
				jBtnNoteUebernehmen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnNoteUebernehmenActionPerformed(evt);
					}
				});
			}
			{
				jLBesteNote = new JLabel();
				getContentPane().add(jLBesteNote);
				jLBesteNote.setBounds(6, 162, 365, 19);
			}
			{
				jLNotenschnitt = new JLabel();
				getContentPane().add(jLNotenschnitt);
				jLNotenschnitt.setBounds(6, 137, 296, 19);
			}
			{
				jLSchlechtesteNote = new JLabel();
				getContentPane().add(jLSchlechtesteNote);
				jLSchlechtesteNote.setBounds(6, 187, 365, 19);
			}
			{
				jLNotenzahl = new JLabel();
				getContentPane().add(jLNotenzahl);
				jLNotenzahl.setBounds(6, 117, 374, 14);
			}
			{
				jBtnNeu = new JButton();
				getContentPane().add(jBtnNeu);
				jBtnNeu.setText("Neue Berechnung");
				jBtnNeu.setBounds(238, 8, 140, 21);
				jBtnNeu.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnNeuActionPerformed(evt);
					}
				});
			}
			{
				jBtnEnde = new JButton();
				getContentPane().add(jBtnEnde);
				jBtnEnde.setText("Ende");
				jBtnEnde.setBounds(277, 243, 94, 21);
				jBtnEnde.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnEndeActionPerformed(evt);
					}
				});
			}
			{
				jLNoten = new JLabel();
				getContentPane().add(jLNoten);
				jLNoten.setBounds(6, 218, 382, 18);
			}
			{
				jTFNotennummer = new JTextField();
				getContentPane().add(jTFNotennummer);
				jTFNotennummer.setBounds(226, 44, 35, 21);
			}
			{
				jLNotennummer = new JLabel();
				getContentPane().add(jLNotennummer);
				jLNotennummer.setText(".Note bearbeiten");
				jLNotennummer.setBounds(267, 47, 98, 14);
			}
			{
				jBtnNotennummer = new JButton();
				getContentPane().add(jBtnNotennummer);
				jBtnNotennummer.setText("OK");
				jBtnNotennummer.setBounds(365, 44, 53, 21);
				jBtnNotennummer.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnNotennummerActionPerformed(evt);
					}
				});
			}
			{
				jLNeuerWert = new JLabel();
				getContentPane().add(jLNeuerWert);
				jLNeuerWert.setText("Note");
				jLNeuerWert.setBounds(252, 71, 50, 14);
				jLNeuerWert.setVisible(false);
			}
			{
				jTFNeuerWert = new JTextField();
				getContentPane().add(jTFNeuerWert);
				jTFNeuerWert.setBounds(252, 91, 50, 21);
				jTFNeuerWert.setVisible(false);
			}
			{
				jBtnNeuenWertspeichern = new JButton();
				getContentPane().add(jBtnNeuenWertspeichern);
				jBtnNeuenWertspeichern.setText("Speichern");
				jBtnNeuenWertspeichern.setBounds(308, 92, 110, 21);
				jBtnNeuenWertspeichern.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnNeuenWertspeichernActionPerformed(evt);
					}
				});
				jBtnNeuenWertspeichern.setVisible(false);
			}
			{
				jBtnLoeschen = new JButton();
				getContentPane().add(jBtnLoeschen);
				jBtnLoeschen.setText("Löschen");
				jBtnLoeschen.setBounds(308, 117, 109, 21);
				jBtnLoeschen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnLoeschenActionPerformed(evt);
					}
				});
				jBtnLoeschen.setVisible(false);
			}
			pack();
			this.setSize(437, 309);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// ArrayList noten initialisieren
		noten = new ArrayList<Double>();
		jTFNote.requestFocus();
		jTFNote.selectAll();
	}

	// eigene methode für berechnung der ganzen notenbilanz
	private void notenbilanzErstellen() {
		// lokale variabeln für verschiedene notenbilanzen
		double summe, besteNote, schlechtesteNote, notenschnitt;
		// mit noten.size(): anzahl elemente noten ermitteln
		jLNotenzahl.setText("Anzahl eingegebene Noten: " + noten.size());
		// variabeln initialisieren/ bzw. aktualisieren
		summe = 0;
		if (noten.size() != 0) {		// selber eingefügt damit man auch das element mit index 0 löschen kann und trotzdem keine fehlerausgabe kriegt...
			besteNote = noten.get(0);	// ...falls arraylist noten elemente beinhaltet: dann besteNote & schlechtesteNote = die note mit index = 0 
			schlechtesteNote = noten.get(0);
		} else {						// ...falls keine elemente in arraylist: besteNote / schlechtesteNote pauschal auf 0 setzen, damit ...
			besteNote = 0;				// ...im weiteren programm-verlauf die variablen überhaupt weiterbenutzt werden können (sonst gäb's fehlerausgabe,..
			schlechtesteNote = 0;		// ...immer dann, wenn man versucht das element mit index 0 auch noch zu löschen; so gibts nur bei notenbilanz...
		}								// ...eine minifehlausgabe, liesse sich noch perfektionieren)
		jLNoten.setText("Noten: ");
		// foreach-schleife für ArrayList<Double> noten (für beste/schlechteste note, und notenausgabe)
		for (double x : noten) {
			summe = summe + x;
			if (besteNote < x)
				besteNote = x;
			if (schlechtesteNote > x)
				schlechtesteNote = x;
			// (einzel-)noten ausgabe
			jLNoten.setText(jLNoten.getText() + "  " + x);
		}
		notenschnitt = summe / noten.size(); // => summe / anzahl elemente
		// restliche notenbilanzen ausgeben
		jLBesteNote.setText("Beste Note: " + besteNote);
		jLSchlechtesteNote
				.setText("Schlechteste Note: " + schlechtesteNote);
		jLNotenschnitt.setText("Notenschnitt: " + notenschnitt);
	}

	private void jBtnNoteUebernehmenActionPerformed(ActionEvent evt) {
		if (!jTFNote.getText().equals("")
				&& Double.parseDouble(jTFNote.getText()) >= 1
				&& Double.parseDouble(jTFNote.getText()) <= 6){
			// neues element Double (mit wert note) zur ArrayList addieren
			noten.add(Double.parseDouble(jTFNote.getText())); 
			// methode aufrufen bei jeder notenübernahme für neue notenbilanzberechnung
			notenbilanzErstellen();
			// label für näxte note aktualisieren, mittels methode size() anzahl elemente von noten ermitteln + 1 für nächste
			jLNote.setText((noten.size() + 1) + " .Note");
			jTFNote.setText("");
			jTFNote.requestFocus();
		} else {
			JOptionPane.showMessageDialog(null, "gültige Note eingeben!");
			jTFNote.requestFocus();
			jTFNote.selectAll();;
		}
	}

	private void jBtnNotennummerActionPerformed(ActionEvent evt) {
		try { 			// try ob gültiges zahlennformat
			// variabelwert zuweisen; ist nicht nur lokal in methode, weil auch für die folgenden methoden nötig
			notennummer = Integer.parseInt(jTFNotennummer.getText()) - 1; // -1 => weil entspricht dann dem index der jeweiligen note in der ArrayList
			// wenn notennummer vorhanden (=> index 0 - noten.size())
			if ((notennummer >= 0) && (notennummer < noten.size())){
				jLNeuerWert.setText((notennummer + 1) + ". Note"); // label auf notennummer setzen
				jLNeuerWert.setVisible(true); 
				// die 2 restl. buttons auch noch sichtbar machen
				jBtnNeuenWertspeichern.setVisible(true);
				jBtnLoeschen.setVisible(true);
				// wert der note mit notennummer xy im textfeld anzeigen
				jTFNeuerWert.setVisible(true); 
				jTFNeuerWert.setText(String.valueOf(noten.get(notennummer)));
				jTFNeuerWert.requestFocus();
				jTFNeuerWert.selectAll();
			} else { 	// sonst fehlertext
				JOptionPane.showMessageDialog(null,
						"Notennummer außerhalb des gültigen Bereichs!");
					jTFNotennummer.requestFocus();
					jTFNotennummer.selectAll();
			}
		} catch (Exception e) {	// zahlenformat-fehler abfangen und fehlertext ausgeben
			JOptionPane.showMessageDialog(null, "ungültiges Zahlenformat!");			
			jTFNotennummer.requestFocus();
			jTFNotennummer.selectAll();
		}
	
	}

	private void jBtnNeuenWertspeichernActionPerformed(ActionEvent evt) {
		try { 					// try: (= falls gültiges zahlenformat)
			if (!jTFNeuerWert.getText().equals("")	// wieder kontrolle ob gültige note
					&& Double.parseDouble(jTFNeuerWert.getText()) >= 1
					&& Double.parseDouble(jTFNeuerWert.getText()) <= 6){
				// wert des elements (mit index = notennummer) setzen 
				noten.set(notennummer, Double.parseDouble(jTFNeuerWert.getText()));
				// neuer wert -> neue notenbilanz berechnen, mit methode notenbilanzErstellen()
				notenbilanzErstellen();
				// und alle komponenten von NeuerWert wieder ausblenden
				jLNeuerWert.setVisible(false);
				jTFNeuerWert.setVisible(false);
				jBtnNeuenWertspeichern.setVisible(false);
				jBtnLoeschen.setVisible(false);
				// focus 
				jTFNotennummer.requestFocus();
				jTFNotennummer.selectAll();
			} else {
				JOptionPane.showMessageDialog(null, "gültige Note eingeben!"); 
				jTFNeuerWert.setText(String.valueOf(noten.get(notennummer)));
				jTFNeuerWert.requestFocus();
				jTFNeuerWert.selectAll();;
			}
		} catch (Exception e) { // sonst fehler abfangen & felertextausgabe
			JOptionPane.showMessageDialog(null, "ungültiges Zahlenformat!");
		}
	}
	// 
	private void jBtnLoeschenActionPerformed(ActionEvent evt) {				
		try {
			// wert/element mit index notennummer löschen
			noten.remove(notennummer);
			// ein wert weniger -> notenbilanz neu berechnen
				// ACHTUNG: letzten wert der ArrayList kann man nicht löschen, 
				// dann spinnts in der methode notenbilanzErstellen,
				// weil man bei besteNote / schlechtesteNote = noten.get(0) elemente aufruft die nicht existieren:
				// lösung: siehe notenbilanzErstellen(): if-else um besteNote / schlechtesteNote = noten.get(0)
			notenbilanzErstellen();
			// alle komponenten von neuerWert wieder ausblenden
			jLNeuerWert.setVisible(false);
			jTFNeuerWert.setVisible(false);
			jBtnNeuenWertspeichern.setVisible(false);
			jBtnLoeschen.setVisible(false);
			// jLNote auch aktualisieren (immer +1 für nächste noteneingabe)
			jLNote.setText((noten.size() + 1) + " .Note");
			// focus
			jTFNote.requestFocus();
			jTFNote.selectAll();

		} catch (Exception e) {
		    JOptionPane.showMessageDialog(null, "Fehler bei der Angabe der Notennummer!");
		}
	}

	private void jBtnNeuActionPerformed(ActionEvent evt) {
		// von ArrayList alle elemente löschen
		noten.clear();
		// alles andere wieder auf anfangszustand setzen
		jLNote.setText((noten.size() + 1) + ".Note");
		jTFNote.setText("");
		jLNotenschnitt.setText("");
		jLBesteNote.setText("");
		jLSchlechtesteNote.setText("");
		jLNotenzahl.setText("");
		jTFNotennummer.setText("");
		jLNeuerWert.setVisible(false);
		jTFNeuerWert.setVisible(false);
		jBtnNeuenWertspeichern.setVisible(false);
		jBtnLoeschen.setVisible(false);
		jLNoten.setText("");
		jTFNote.requestFocus();
		jTFNote.selectAll();
	}

	private void jBtnEndeActionPerformed(ActionEvent evt) {
		System.exit(0);
	}
}

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
