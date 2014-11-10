/* TODO 11.2.2.   s.335 uf		
 * class Listbox_ArrayList_Basics_Notenbilanz
 * 	
 * 		SIEHE's:	ARRAYLIST BASICS:						11.2.1.   ArrayList_Basics_Methoden_Konstruktoren					s.333 uf
 * 					ARRAYLIST ANGEWANDT:					11.2.1.   ArrayList_Angewandt_Notenbilanz_IstBesteLoesung			s.335
 *  
 * 					METHODEN v. KL. (DEFAULT-)LISTMODEL:	11.2.2.   ListBox_Methoden_DerKlasse_DefaultListModel_ListModel		s.338 
 * 
 * 
 * 	PROGRAMM NOTENBILANZ GELÖST MIT: 	ARRAYLIST:		=> ArrayList entfällt NICHT, speichert die werte, wird benutzt wie gehabt
 * 											&
 * 										LISTBOX:		=> ListBox stellt die werte "nur" dar (anstelle vorher jLNoten in ArrayList_Angewandt_Notenbilanz_IstBesteLoesung)
 * 														=> besteht aus JList & ListModel
 * 
 * 		LISTBOX:	bestehend aus:
 * 	
 * 					JLIST:		 	= 1. komponente einer ListBox, zuständig für darstellung/optik der Liste				=> (hier: jListNoten)
 * 						&
 * 					LISTMODEL: 		= 2. komponente einer ListBox, zuständig für aufnahme/verwaltung der Listeinträge		=> (hier: jListNotenModel)
 * 
 * 
 * 		BASICALLY: 		1.	überall wo Elemente von ArrayList (noten.irgendmethode()) verändert werden
 * 							-> wird analog auch das ListModel (hier: jListNotenModel) ergänzt/angepasst
 * 
 * 						2.	ArrayList wird weiterhin zur speicherung/berechnung der werte gebraucht
 * 
 * 						3.	die ListBox ist nur zur ansicht der werte 		=> für Listbox taugen Strings, es sind keine Wrapperobjekte wie Double etc. nötig 
 * 							(DefaultListmodel kann nicht nur strings, sondern beliebige objekte gleichen typs verwalten, 
 * 								-> sollen andere klassen als strings in JList dargestellt werden, sind evtl. grössere anpassungen, als hier erforderlich)
 * 
 * 
 * 	LISTBOX ERSTELLEN, VORGEHEN:					SIEHE AUCH: 	initGUI(): 		ca. ab zeile 290
 * 
 * 		JLIST:		1. erstellen mit:	jigloo menueleiste > componenten > JList 
 * 										-> anklicken, in grüne frame-umrandung ziehen, klicken, formular erscheint 
 * 										=> form: namen geben:		JList1 		==> (hier:)   JListNoten
 * 
 * 					2. autogenerierte JList codezeilen abändern wie folgt:				// SIEHE AUCH: initGUI(): CA. ZEILE: 280
 * 					
 * 						-> auto generiertes:	DefaultComboBoxModel(new String[] { "Item One", "Item Two" });
 * 												= ist nur für auswahlliste mit fertigen einträgen geeignet, nicht für einträge, die während der laufzeit ändern 
 *				
 *				 		=> ersetzen durch: 		DefaultListModel()  (mit leerer Parameter-liste !!!)
 *				
 *		LISTMODEL:	3.  ListModel für's ganze frame / klasse, oben deklarieren:					// = für erleichterten zugriff
 *
 *						=> private DefaultListModel jListNotenModel; 		=> nachträglich von hand oben bei den variablen deklarieren
 *											& 	
 *						=> jListNotenModel = new DefaultListModel();		=> unten im initGUI() nur noch initialisieren 
 *
 *						=> import (falls von hand nötig):					=> javax.swing.DefaultListModel
 *
 *		WEITERES:	4.  ÜBERALL wo Elemente von ArrayList (noten.irgendMethode()) verändert werden:
 * 						-> wird analog auch das ListModel (hier: jListNotenModel.analogeMethode()) ergänzt/angepasst
 * 						-> ACHTUNG:	die elemente für die ListModel-anpassungen können jeweils als string eingegeben werden (keine wrapper-objekte nötig)
 * 
 * 						-> VERWENDE:	die jeweils analogen methoden der klassen:		ArrayList	&	DefaultListModel
 * 
 * 						-> GENAU:	CODE DURCHGEHEN 	-> als beispiel, um andere fälle analog zu lösen
 * 
 * 							BSP:	noten.add(Double.parseDouble(jTFNote.getText()));		// wenn ein element (*) zur arraylist hinzugefügt wird... (* NB: als wrapperobjekt))
 * 								=>	jListNotenModel.addElement(jTFNote.getText());			// ...wird dasselbe element (*) zu ListModel hinzugefügt	(* NB: als string)
 *
 *							BSP:	noten.set(notennummer, Double.parseDouble(jTFNeuerWert.getText()));		// wird ein element in arraylist an stelle index ersetzt...
 *								=>	jListNotenModel.setElementAt(jTFNeuerWert.getText(), notennummer);		// .. wird es auch im ListModel an stelle index ersetzt
 *								
 *							BSP:	noten.remove(notennummer);								// wird ein element (mit index xy) aus arraylist gelöscht...
 *								=>	jListNotenModel.remove(notennummer);					// .. wird es auch (mit index xy) aus ListModel gelöscht
 *
 *
 *						=> METHODEN v. KL. (DEFAULT-)LISTMODEL:		11.2.2.   	ListBox_Methoden_DerKlasse_DefaultListModel_ListModel		s.338 
 *
 *						=> METHODEN ARRAYLIST:						11.2.1.   	ArrayList_Basics_Methoden_Konstruktoren						s.333 uf
 * 
 * 	K&K: Programm Notenbilanz berechnet aus mehreren eingegebenen Noten den Notenschnitt und gibt zusätzlich die beste, die
 * 		 schlechteste Note aus. Die Noten werden in einer JList gesammelt. Einzelne Noten können auch nachträglich bearbeitet werden.
 * 
 * 		 ACHTUNG, wenn der letzte wert von ArrayList gelöscht wird, gibts nur noch einen minifehler bei der ausgabe der methode notenbilanzErstellen()
 */

package uebungen11;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

// import javax.swing.DefaultComboBoxModel; 		überflüssig, weil ersetzt mit DefaultListModel
import javax.swing.DefaultListModel;		// import machen, falls es ihn nicht selber macht
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;



public class Listbox_ArrayList_Basics_Notenbilanz extends javax.swing.JFrame {
	private JLabel jLNote;
	private JButton jBtnNoteUebernehmen;
	private JLabel jLNotenschnitt;
	private JLabel jLSchlechtesteNote;
	private JList jListNoten2;
	private JButton jBtnLoeschen;
	private JButton jBtnNeuenWertspeichern;
	private JTextField jTFNeuerWert;
	private JLabel jLNeuerWert;
	private JButton jBtnNotennummer;
	private JLabel jLNotennummer;
	private JTextField jTFNotennummer;
// 2 kompnenten einer ListBox: JList & ListModel:
	// JList zuständig für Darstellung & optische erscheinung
	private JList jListNoten;	// wird automatisch von jigloo für's ganze frame deklariert
	
	// ListModel ist verantwortlich für die aufnahme & verwaltung der Listeneinträge
		// statt als lokale variablen für's ganze frame deklarieren:
	private DefaultListModel jListNotenModel; // muss extra von hand hier oben deklariert werden (für's ganze frame)
		
	private JLabel jLNoten;		// wird automatisch von jigloo für's ganze frame deklariert
	private JButton jBtnEnde;
	private JButton jBtnNeu;
	private JLabel jLNotenzahl;
	private JLabel jLBesteNote;
	private JTextField jTFNote;
	
	private DecimalFormat fzahl; 
	private int notennummer;
	private ArrayList<Double> noten;
	

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Listbox_ArrayList_Basics_Notenbilanz inst = new Listbox_ArrayList_Basics_Notenbilanz();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public Listbox_ArrayList_Basics_Notenbilanz() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setPreferredSize(new java.awt.Dimension(437, 384));
			this.setTitle("Notenbilanz");
			{
				fzahl = new DecimalFormat("#0.00"); // zahlen formatiert darstellen
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
				// label hier nur noch zur anschrift, nicht mehr zur ausgabe der noten...
				jLNoten.setText("Noten:");			
				jLNoten.setBounds(226, 124, 59, 18);	// ...ist jetzt über der ListBox platziert
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
				jBtnNeuenWertspeichern.setVisible(false);
				jBtnNeuenWertspeichern.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnNeuenWertspeichernActionPerformed(evt);
					}
				});
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
			{	// LISTBOX jigloo-autogeneriert & dann abgeändert wie folgt:
				
				// das auto generierte DefaultComboBoxModel(new String[] { "Item One", "Item Two" });
				// ist nur für auswahlliste mit fertigen einträgen geeignet, nicht für einträge, die  
				// während der laufzeit ändern -> ersetzen mit: DefaultListModel()  (& mit leerer Parameter-liste)
				
				// ListModel ausserdem für erleichterten zugriff: statt als lokale variablen besser 
				// oben für's ganze frame deklarieren 
				jListNotenModel = new DefaultListModel();// listModel = 2.komponente einer ListBox, ist verantwortlich für für die aufnahme & verwaltung der Listeneinträge	
				jListNoten = new JList();				 // jList = 1. komponente einer ListBox,  zuständig für Darstellung & optische erscheinung
				getContentPane().add(jListNoten);		// jList dem Panel/container hinzufügen
				jListNoten.setModel(jListNotenModel); 	// model für jList setzen
				jListNoten.setBounds(226, 146, 183, 86);
			}
			pack();
			this.setSize(437, 384);
		} catch (Exception e) {
			e.printStackTrace();
		}
		noten = new ArrayList<Double>();
		jTFNote.requestFocus();
		jTFNote.selectAll();
	}

	private void notenbilanzErstellen() {
		double summe, besteNote, schlechtesteNote, notenschnitt;
		jLNotenzahl.setText("Anzahl eingegebene Noten: " + noten.size()); 
		summe = 0;
		if (noten.size() != 0) {				// (korriegierte version von ArrayList_Angewandt_Notenbilanz_.. übernommen)...
			besteNote = noten.get(0);			// ...hat nix zu tun mit den anpassungen an die ListBox...
			schlechtesteNote = noten.get(0);
		} else {						
			besteNote = 0;				
			schlechtesteNote = 0;				// ...(bis hier)
		}								
		// jLNoten.setText("Noten: ");	überflüssig weil ListBox
		for (double x: noten) {
			summe = summe + x;
			if ( besteNote < x) 
				besteNote = x;
			if ( schlechtesteNote > x) 
				schlechtesteNote = x;
			// jLNoten.setText(jLNoten.getText() + "  "  + x);	überflüssig weil ListBox
		}
		notenschnitt = summe / noten.size(); 
		jLBesteNote.setText("Beste Note: " + besteNote);
		jLSchlechtesteNote.setText("Schlechteste Note: " + schlechtesteNote);
		jLNotenschnitt.setText("Notenschnitt: " + notenschnitt);
	}

	private void jBtnNoteUebernehmenActionPerformed(ActionEvent evt) {
		if (!jTFNote.getText().equals("")
				&& Double.parseDouble(jTFNote.getText()) >= 1
				&& Double.parseDouble(jTFNote.getText()) <= 6){
			// weiterhin ArrayList hinzufügen (ListBox ist nur für ansicht der Noten) 
				// immer wo noten.irgend() verändert wird -> auch ListModel analog ergänzen
			noten.add(Double.parseDouble(jTFNote.getText()));
			// element zu ListModel(=> ListBox) hinzufügen (zur ansicht)
			jListNotenModel.addElement(jTFNote.getText());
			notenbilanzErstellen();
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
		try { 			
			notennummer = Integer.parseInt(jTFNotennummer.getText()) - 1; // -1 => weil entspricht dann dem index der jeweiligen note in der ArrayList
			if ((notennummer >= 0) && (notennummer < noten.size())){
				jLNeuerWert.setText((notennummer + 1) + ". Note"); 
				jLNeuerWert.setVisible(true); 
				jBtnNeuenWertspeichern.setVisible(true);
				jBtnLoeschen.setVisible(true);
				jTFNeuerWert.setVisible(true); 
				jTFNeuerWert.setText(String.valueOf(noten.get(notennummer)));
				jTFNeuerWert.requestFocus();
				jTFNeuerWert.selectAll();
			} else { 	
				JOptionPane.showMessageDialog(null,
						"Notennummer außerhalb des gültigen Bereichs!");
					jTFNotennummer.requestFocus();
					jTFNotennummer.selectAll();
			}
		} catch (Exception e) {	
			JOptionPane.showMessageDialog(null, "ungültiges Zahlenformat!");			
			jTFNotennummer.requestFocus();
			jTFNotennummer.selectAll();
		}
	
	}

	private void jBtnNeuenWertspeichernActionPerformed(ActionEvent evt) {
		try { 					
			// immer wo noten.irgend() verändert wird -> auch ListModel analog ergänzen
			noten.set(notennummer, Double.parseDouble(jTFNeuerWert.getText()));
			// in ListModel(ListBox) element an stelle index durch mitgegebenes element ersetzen
			jListNotenModel.setElementAt(jTFNeuerWert.getText(), notennummer);
			notenbilanzErstellen();
			jLNeuerWert.setVisible(false);
		    jTFNeuerWert.setVisible(false);
		    jBtnNeuenWertspeichern.setVisible(false);
		    jBtnLoeschen.setVisible(false);
		    jTFNotennummer.requestFocus();
		    jTFNotennummer.selectAll();
		} catch (Exception e) { 
			JOptionPane.showMessageDialog(null, "ungültiges Zahlenformat!");
		}
	}
	// 
	private void jBtnLoeschenActionPerformed(ActionEvent evt) {				
		try {
			// immer wo noten.irgend() verändert wird -> auch ListModel analog ergänzen
			noten.remove(notennummer);
			// aus ListModel(Listbox) element an der stelle index löschen
			jListNotenModel.remove(notennummer);
			notenbilanzErstellen();
			jLNeuerWert.setVisible(false);
			jTFNeuerWert.setVisible(false);
			jBtnNeuenWertspeichern.setVisible(false);
			jBtnLoeschen.setVisible(false);
			jLNote.setText((noten.size() + 1) + " .Note");
			jTFNote.requestFocus();
			jTFNote.selectAll();
		} catch (Exception e) {
		    JOptionPane.showMessageDialog(null, "ungültiges Zahlenformat!");
		}
	}

	private void jBtnNeuActionPerformed(ActionEvent evt) {
		// immer wo noten.irgend() verändert wird -> auch ListModel analog ergänzen
		noten.clear();
		// aus ListModel(Listbox) alle elemente löschen
		jListNotenModel.clear();
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
		// jLNoten.setText("");		überflüssig weil ListBox
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
