/* TODO 12.1.2.   s.354
 * class File_JFileChooser_PopupDialog_Verzeichnisinhalt
 * 
 * PROGRAMM:	Es wird der Inhalt eines Ordners getrennt nach Verzeichnissen und Dateien in zwei Listen angezeigt.
 * 				Das jeweils anzuzeigende Verzeichnis kann mit Hilfe eines Dialogs (JFileChooser)ausgew�hlt werden. 
 *  
 * JFILECHOOSER:	= Dialog-Frame mit den betriebssystemtypischen komponenten zum navigieren, zur steuerung der ansicht, zum editieren des
 * 					  ausgew�hlten dateinamens & zur filterung der dateianzeige
 * 
 * JFILECHOOSER ALS POPUP-DIALOG:	 	genau siehe methode jBtnAuswaehlenActionPerformed(..)	ca. zeile 235 
 * 
 * 		SCHEMA:
 * 			import javax.swing.JFileChooser;									// remember
 * 
 * 			private void jBtnAuswaehlenActionPerformed(ActionEvent evt) {
 *				JFileChooser fc = new JFileChooser();							// neue instanz fc von JFileChooser erzeugen
 *				fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 		// dateiauswahlmodus f�r fc w�hlen (verzeichnisse , dateien oder beides kann ausgew�hlt werden)
 *				int state = fc.showOpenDialog(null);   							// anzeigen des dialogs durch fc.showOpenDialog(null) & gleichzeitig mit int state: speichern des status (beim schliessen v. dialog)
 *				if (state == JFileChooser.APPROVE_OPTION){ 						// wenn dialog mit �ffnen/speichern geschlossen wird (also status der r�ckgabekonstante APPROVE_OPTION von JFileChooser entspricht)
 *					File selFile = fc.getSelectedFile(); 						// mit .getSelectedFile() wird das ausgew�hlte File von fc einem lokalen Fileobjekt (selFile) zugewiesen
 *					jTFVerzeichnis.setText(selFile.getPath()); 					// mit getPath() den ganzen Pfad des Files & ausgeben
 *				}
 *			}
 *
 * JFILECHOOSER BASICS:
 * 
 * 		1.	ist der dialog einmal ge�ffnet bleibt er solange offen bis eine der schaltfl�chen �FFNEN oder ABBRECHEN geklickt werden
 * 
 * 		2.	erzeugen mit konstruktoraufruf:										JFileChooser fc = new JFileChooser();
 * 			anzeigen durch methoden:											showOpenDialog(..)		oder		showSaveDialog(..)
 * 			anzeigen des dialogs & gleichz. speichern d. schliess-status:		int state = fc.showOpenDialog(null);
 * 
 * 		3.	VORDEFINERTE R�CKGABE-KONSTANTEN:			JFileChooser.APPROVE_OPTION				=>	�ffnen/speichern bet�tigt
 * 			[der methode showOpenDialog(..)] 			JFileChooser.CANCEL_OPTION				=>	abbrechen bet�tigt
 * 														JFileChooser.ERROR_OPTION				=>	dialog wurde mit fehler beendet		
 * 
 * 		4.	KONSTANTEN f�r setFileSelectionMode():		JFileChooser.DIRECTORIES_ONLY			=>	nur verzeichnisse anzeigen
 * 														JFileChooser.FILES_AND_DIRECTORIES		=>	verzeichnisse & dateien anzeigen
 * 														JFileChooser.FILES_ONLY					=>	nur dateien anzeigen
 * 		
 * 		5.	weitere methoden von JFileChooser:			getSelectedFile()						=> 	gibt ausgew�hltes file zur�ck
 * 														setFileSelectionMode(int mode)			=>	bestimmt datei-auswahl-modus		
 * 
 * 
 * JFILECHOOSER ALS JIGLOO-KOMPONENTE: 
 * 
 * 					mit jigloo erzeugen:	> Jigloo > more Components > JFileChooser einfach ins frame reinziehen
 * 
 * 					SIEHE AUCH:	 	12.1.2.   	File_JFileChooser_MitJigloo			s.354-355
 * 
 * 
 * METHODEN / KONSTRUKTOREN DER KLASSE FILE: 			genauer siehe methode  jBtnAnzeigenA...(...), 
 * 
 * 					SIEHE AUCH:		 12.1.1.   File_Methoden_Konstruktoren_Bsp_SortierenVon_Verzeichnisinhalt		s.351
 * 
 * 
 * JFILECHOOSER F�R BILDBETRACHTER / IMAGEIO:	
 * 
 * 					SIEHE AUCH:		 12.4.2.   ImageIO_Klasse_Basics_JFilechooser_Bildbetrachter			s.382, 	
 *  
 *  
 */

package uebungen12;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// import von io.file nit vergessen
import java.io.File;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
// File chooser einbauen auch mit: jigloo > more components > filechooser
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

public class File_JFileChooser_PopupDialog_Verzeichnisinhalt extends javax.swing.JFrame {
	private JLabel jLVerzeichnis;
	private JTextField jTFVerzeichnis;
	private JScrollPane jScrollPane1;
	private JScrollPane jScrollPane2;
	private JButton jBtnAuswaehlen;
	private JButton jBtnEnde;
	private JButton jBtnAnzeigen;
	private JList jListDateien;
	private JLabel jLDateien;
	private JList jListVerzeichnisse;
	private JLabel jLVerzeichnisliste;
	private DefaultListModel jListVerzeichnisseModel, jListDateienModel;
	// objekt der klasse file deklarieren (import von java.io.File nit vergessen)
	private File verzeichnis;	

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				File_JFileChooser_PopupDialog_Verzeichnisinhalt inst = new File_JFileChooser_PopupDialog_Verzeichnisinhalt();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public File_JFileChooser_PopupDialog_Verzeichnisinhalt() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Verzeichnisinhalt");
			{
				jLVerzeichnis = new JLabel();
				getContentPane().add(jLVerzeichnis);
				jLVerzeichnis.setText("Verzeichnis");
				jLVerzeichnis.setBounds(12, 11, 115, 14);
			}
			{
				jTFVerzeichnis = new JTextField();
				getContentPane().add(jTFVerzeichnis);
				jTFVerzeichnis.setBounds(12, 26, 368, 21);
			}
			{
				jScrollPane1 = new JScrollPane();
				getContentPane().add(jScrollPane1);
				jScrollPane1.setBounds(12, 97, 198, 134);
				{
					jListVerzeichnisseModel = new DefaultListModel();
					jListVerzeichnisse = new JList();
					jScrollPane1.setViewportView(jListVerzeichnisse);
					jListVerzeichnisse.setModel(jListVerzeichnisseModel);
					jListVerzeichnisse.setBounds(12, 78, 164, 131);
				}
			}
			{
				jLVerzeichnisliste = new JLabel();
				getContentPane().add(jLVerzeichnisliste);
				jLVerzeichnisliste.setText("Verzeichnisse");
				jLVerzeichnisliste.setBounds(12, 77, 198, 14);
			}
			{
				jLDateien = new JLabel();
				getContentPane().add(jLDateien);
				jLDateien.setText("Dateien");
				jLDateien.setBounds(222, 77, 158, 14);
			}
			{
				jScrollPane2 = new JScrollPane();
				getContentPane().add(jScrollPane2);
				jScrollPane2.setBounds(222, 98, 158, 133);
				{
					jListDateienModel = new DefaultListModel();
					jListDateien = new JList();
					jScrollPane2.setViewportView(jListDateien);
					jListDateien.setModel(jListDateienModel);
					jListDateien.setBounds(222, 98, 158, 133);
				}
			}
			{
				jBtnAnzeigen = new JButton();
				getContentPane().add(jBtnAnzeigen);
				jBtnAnzeigen.setText("Inhalt anzeigen");
				jBtnAnzeigen.setBounds(12, 51, 164, 21);
				jBtnAnzeigen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnAnzeigenActionPerformed(evt);
					}
				});
			}
			{
				jBtnEnde = new JButton();
				getContentPane().add(jBtnEnde);
				jBtnEnde.setText("Ende");
				jBtnEnde.setBounds(147, 237, 118, 21);
				jBtnEnde.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnEndeActionPerformed(evt);
					}
				});
			}
			{
				jBtnAuswaehlen = new JButton();
				getContentPane().add(jBtnAuswaehlen);
				jBtnAuswaehlen.setText("Ausw�hlen");
				jBtnAuswaehlen.setBounds(222, 50, 156, 23);
				jBtnAuswaehlen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnAuswaehlenActionPerformed(evt);
					}
				});
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}
	// bsp mit File:
	// methode zum anzeigen des verzeichnisinhalts bei clicken von jBtnAnzeigen
	private void jBtnAnzeigenActionPerformed(ActionEvent evt) {
		// l�schen aller vorheriger eintr�ge in den beiden listboxen/listmodels (dateien & verzeichnisse)
		jListVerzeichnisseModel.clear();
		jListDateienModel.clear();
		if (jTFVerzeichnis.getText().isEmpty()) {	// falls keine angaben im textfeld verzeichnis...
			JOptionPane.showMessageDialog(null, "Bitte Verzeichnisname angeben"); // ... fehlertext
		} else {
			verzeichnis = new File(jTFVerzeichnis.getText()) ;  // neues file erstellen mit d. namen aus der textfeldeingabe
			if (verzeichnis.exists()) {	// falls (der file-name von) verzeichnis im dateisystem existiert...
				// lokales stringarray (inhalt) wird mittels methode .list() mit den namen der Dateien/verzeichnisse...
				String[] inhalt = verzeichnis.list(); // ... des File-objekts (verzeichnis) bef�llt
				// foreach-schleife zum sortieren der elemente in  datei oder verzeichnis und eintrag in die zust�ndige listbox
				for (String eintrag: inhalt) { 
					// f�r jeden eintrag ein lokales File mit parametern superverzeichnisnamen & dateinamen (!!!)..
						// .. damit die methoden isFile() & isDirectory() korrekt funktionieren k�nnen
					File f = new File (verzeichnis, eintrag);	
					if (f.isDirectory()) { // falls eintrag ein verzeichnis ist...
						jListVerzeichnisseModel.addElement(eintrag); // ... den eintrag der verzeichniss-listbox anf�gen
					} else {
						jListDateienModel.addElement(eintrag); // ... sonst den eintrag der dateien-listbox anf�gen
					}
				}
			} else { // falls File verzeichnis nicht existiert: fehlertext
				JOptionPane.showMessageDialog(null, "File existiert nicht");
			}
		}
	}
	// JFileChooser popup-dialog:
	// methode f�r button ausw�hlen zur aktivierung von FileChooser
			// ACHTUNG nit vergessen: import.javax.swing.JFileChooser
	private void jBtnAuswaehlenActionPerformed(ActionEvent evt) {
		JFileChooser fc = new JFileChooser();		// neue instanz fc von JFileChooser erzeugen
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); // dateiauswahlmodus f�r fc w�hlen (verzeichnisse , dateien oder beides kann ausgew�hlt werden)
		// anzeigen des dialogs durch fc.showOpenDialog(null) & gleichzeitig mit int state: speichern des status (beim schliessen v. dialog) 
		int state = fc.showOpenDialog(null);   
		if (state == JFileChooser.APPROVE_OPTION){ // wenn dialog mit �ffnen/speichern geschlossen wird (also status der r�ckgabekonstante APPROVE_OPTION von JFileChooser entspricht)
			File selFile = fc.getSelectedFile(); // mit .getSelectedFile() wird das ausgew�hlte File von fc einem lokalen Fileobjekt zugewiesen
			jTFVerzeichnis.setText(selFile.getPath()); // mit getPath() den ganzen Pfad des Files & ausgeben
		}
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
