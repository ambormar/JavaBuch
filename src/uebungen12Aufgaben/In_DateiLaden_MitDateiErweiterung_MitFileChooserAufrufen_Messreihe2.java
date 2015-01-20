/* TODO 12.5.   Aufgabe 2, s.393 (Aufg. 1 erweitert)
 * class In_DateiLaden_MitDateiErweiterung_MitFileChooserAufrufen_Messreihe2
 * 
 * 	VERGLEICHE AUCH:	12.3.1.   In_FileReader_BufferedReader_KontaktlisteMitSpeichern		s.368, (IN) Daten aus datei ins program einlesen  (zurück ins programm/dialogfenster einlesen) 
 *  		[	&  :	12.3.1.   Out_FileWriter_BufferedWriter_KontaktlisteMitSpeichern		s.364, (OUT) Daten aus programm in Datei ausschreiben 		]
 * 
 * 
 * [[[NB VORGEHEN Aufg.1: 	1. Jframe mit textfield für messwert-eingabe, 					
 * 
 * 							2. messwert übernehmen-button,							=> KERN-CODE siehe:				jBtnUbernehmen..(..)
 * 
 *							3. jList (jListModel) für messreihe,					=> KERN-CODE siehe:				jScrollPane1 im initGUI() 	inkl. jList & jListModel verschachtelt
 *				
 *							4. messwerte speichern in .mwd-datei (im projekt-ordner), mittels JFileChooser & dateiendung kontrollieren / anhängen beim speichern im fc.showSaveDialog
 * 
 *																				=> KERN-CODE siehe:				jBtnSpeichern..(..) 		
 *
 *		NEU Aufg.1: 	- JFileChooser um Datei zu Speichern (fc.showSaveDialog(..)):		=> CODE siehe:				jBtnSpeichern..(..) 
 *																						
 *		NEU Aufg.1:		- Datei-Endung kontrollieren / ergänzen vor dem speichern:			=> CODE siehe:				jBtnSpeichern..(..)					]]]
 *																												
 *
 *	VORGEHEN Aufg. 2:		5. messwerte laden-button (aus datei im Projektordner mit endung .mwd
 *
 *
 *		private void jBtnOeffnenActionPerformed(ActionEvent evt) {						// methode um messwerte via filechooser aus .mwd datei (im projektordner) ins jListModel laden 
 *			JFileChooser fc = new JFileChooser();										// neuer filechooser
 *			fc.setFileSelectionMode(JFileChooser.FILES_ONLY);							// nur Files akzeptieren (keine ordner) => datei soll ja nacher geladen werden
 *			fc.setFileFilter(new FileNameExtensionFilter("Messwertdateien *mwd", "mwd"));// mögliche datei-erweiterungen auf .mwd beschränken
 *			fc.setCurrentDirectory(new File("." + File.separator + File.separator));	// plattformunabhängiger rel. pfad für eins rauf i.d.hierarchie, (".\\") wär für windows auch korrekt
 *			int state = fc.showOpenDialog(null);										// fc-speicher-dialog öffnen + gleichzeitig status auf "file öffnen, jaa" setzen
 *			if (state == JFileChooser.APPROVE_OPTION){									// wenn satus "file öffnen, jaa" ist
 *				dateiname = fc.getSelectedFile().getAbsolutePath();						// dem String dateiname, den absoluten pfad, der im fc ausgewählten Datei, zuweisen 
 *				// File datei = new File(dateiname);						// Fehler vom Heini: brauchts hier NICHT!! 	brauchts nur im: In_FileReader_BufferedReader_KontaktlisteMitSpeichern
 *				String messwerteZeile;				 									// lokale stringvariable für die einzelenen adresszeilen
 *				try {
 *					BufferedReader in = new BufferedReader(new FileReader(dateiname));	// BufferedReader-objekt out mit neu erzeugtem FileReader-objekt mit argument dateinam (& pfad) der Zieldatei 
 *					jListMesswerteModel.clear();							// WICHTIG: jListModel von einträgen clearen, sonst lassen sich einträge mehrfach ins selbe frame laden
 *					while ((messwerteZeile = in.readLine()) != null){					// mit while-schleife, solange mit methode .readLine() zeilen einlesen, bis keine zeile mehr vorhanden (=null) 
 *						jListMesswerteModel.addElement(messwerteZeile);					// jeden, in messwertezeile zwischengespeicherten eintrag mit .addElement() in listbox übertragen 
 *					}
 *					in.close();															// schliessen des inputstreams mit close(), abgekürzte variante
 *				} catch (Exception e){
 *					JOptionPane.showMessageDialog(this, "Fehler beim Laden");			// (guck this statt null als erstes argument von JOption...) geht auch
 *				}
 *			}
 *		}
 *
 *
 *	BESONDERES:		deutsche formatierung mit komma als trennzeichen statt punkt:		
 *																					-> (achtung gespeicherte .mwd-dateien von messreihe 1 von aufgabe 1 sind dann nicht mehr kompatibel )
 *					import java.text.NumberFormat;
 *					import java.util.Locale;
 *					
 *					private NumberFormat nf;														// attribut-deklaration
 *
 *					nf = NumberFormat.getInstance(Locale.GERMAN);   								// im initGUI() nach pack(..)
 *
 * 					jListMesswerteModel.addElement(nf.format(nf.parse(jTFMesswert.getText())));		// im jBtnUebernehmen...(..)
 * 
 * 
 * 
 * K&K:		Aufg. 1: Programm Messreihe1. 	
 * 						Programm zum Speichern von Messwerten (Kommazahlen) in einer Datei. Der Dateiname kann über einen Dialog festgelegt werden.
 * 			Aufg. 2: Programm-erweiterung Messreihe 2. 			
 * 						Die Messwerte können aus der Datei wieder in die ListBox geladen werden.
 * 
 */

package uebungen12Aufgaben;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.sun.org.apache.xpath.internal.axes.SelfIteratorNoPredicate;


public class In_DateiLaden_MitDateiErweiterung_MitFileChooserAufrufen_Messreihe2 extends javax.swing.JFrame {
	private JLabel jLabel1;
	private JButton jBtnUbernehmen;
	private JLabel jLabel2;
	private JButton jBtnOeffnen;
	private JButton jBtnSpeichern;
	private JScrollPane jScrollPane1;
	private JList jListMesswerte;
	private JTextField jTFMesswert;
	private DefaultListModel jListMesswerteModel;			// selber deklariert anstelle von ComboBoxModel
	private String dateiname;
	private NumberFormat nf;								// kleine spielerei um zu zeigen wie Formatierung verändert wird, siehe auch ende initGUI & jBtnUebernehemen

	{
		// Set Look & Feel
		try {
			javax.swing.UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				In_DateiLaden_MitDateiErweiterung_MitFileChooserAufrufen_Messreihe2 inst = new In_DateiLaden_MitDateiErweiterung_MitFileChooserAufrufen_Messreihe2();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public In_DateiLaden_MitDateiErweiterung_MitFileChooserAufrufen_Messreihe2() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Messreihe speichern");
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("Messwert");
				jLabel1.setBounds(12, 12, 75, 16);
			}
			{
				jTFMesswert = new JTextField();
				getContentPane().add(jTFMesswert);
				jTFMesswert.setBounds(12, 34, 142, 23);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("Messreihe");
				jLabel2.setBounds(181, 12, 80, 16);
			}
			{
				jScrollPane1 = new JScrollPane();
				getContentPane().add(jScrollPane1);
				jScrollPane1.setBounds(181, 34, 183, 177);
				{
					jListMesswerteModel = new DefaultListModel();		// selber erstellt anstelle von ComboBox Model irgend
					jListMesswerte = new JList();
					jScrollPane1.setViewportView(jListMesswerte);
					jListMesswerte.setModel(jListMesswerteModel);		// selber Model gesetzt 
				}
			}
			{
				jBtnUbernehmen = new JButton();
				getContentPane().add(jBtnUbernehmen);
				jBtnUbernehmen.setText("Übernehmen >>");
				jBtnUbernehmen.setBounds(12, 83, 142, 23);
				jBtnUbernehmen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnUbernehmenActionPerformed(evt);
					}
				});
			}
			{
				jBtnSpeichern = new JButton();
				getContentPane().add(jBtnSpeichern);
				jBtnSpeichern.setText("Messreihe speichern");
				jBtnSpeichern.setBounds(181, 228, 183, 23);
				jBtnSpeichern.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnSpeichernActionPerformed(evt);
					}
				});
			}
			{
				jBtnOeffnen = new JButton();
				getContentPane().add(jBtnOeffnen);
				jBtnOeffnen.setText("Messreihe laden");
				jBtnOeffnen.setBounds(181, 262, 183, 23);
				jBtnOeffnen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnOeffnenActionPerformed(evt);
					}
				});
			}
			pack();
			this.setSize(400, 343);
			nf = NumberFormat.getInstance(Locale.GERMAN);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private void jBtnUbernehmenActionPerformed(ActionEvent evt) {	// methode um eingabe des FT in die jList zu übernehemn		
		if ( jTFMesswert.getText().isEmpty()) {						// wenn leere felder: fehlertext ausgeben// denkbar wäre auch eine String-methode die (als parametermitgabe)nur bestimmte zeichen..
			JOptionPane.showMessageDialog(this, "Messwert fehlt!");	// .. erlaubt, also z.b., dass nur zaheln eingegeben werden können (welche methode weiss ich jetzt grad nicht)
			jTFMesswert.requestFocus();
		} else {
			try {
				jListMesswerteModel.addElement(nf.format(nf.parse(jTFMesswert.getText())));	// Formatierung wird geändert mit der klasse NumberFormat (deutsche schreibweise. komma als trennzeichen etc.)
				jTFMesswert.setText("");
				jTFMesswert.requestFocus();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "ungültiges Zahlenformat!");
				jTFMesswert.selectAll();
				jTFMesswert.requestFocus();
			}
		}
	}																					
	
	private void jBtnSpeichernActionPerformed(ActionEvent evt) {		
		JFileChooser fc = new JFileChooser();						 	// JFILECHOOSER mit "file speichern"-dialog / showSaveDialog
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);								// nur Files akzeptieren (keine ordner) => datei soll ja nacher gespeichert werden
		fc.setFileFilter(new FileNameExtensionFilter("Messwertdateien *.mwd", "mwd"));	// mögliche datei-erweiterungen auf .mwd beschränken
		fc.setCurrentDirectory(new File("." + File.separator + File.separator));		// plattformunabhängiger rel. pfad für eins rauf i.d.hierarchie, (".\\") wär für windows auch korrekt
		int state = fc.showSaveDialog(null);											// fc-speicher-dialog öffnen + gleichzeitig status auf "speichern, jaa" setzen
		if (state == JFileChooser.APPROVE_OPTION){										// wenn der status "speichern, jaa" ist
																		// DATEI-ENDUNG kontrollieren & ergänzen
			String selFile = fc.getSelectedFile().getAbsolutePath();					// lokaler stringvariable selFile, den absoluten pfad, der im fc ausgewählten Datei, zuweisen
			int index = selFile.indexOf(".");											// index speichern von "." im string, falls einer vorkommt (=> datei-endung oder nicht)
			if (index >= 0){															// falls (index >= 0)	=> falls (es einen punkt hat im namen)
				dateiname = selFile.substring(0, index).concat(".mwd");					// String dateiname = selFile abgeschnitten (anfang, bis 1 vor indexangabe) verknüpfen mit .endung
			} else {																	// sonst
				dateiname = selFile.concat(".mwd");										// String dateiname = selFile (ganz) verknüpfen mit .endung
			}													
			try {																		
				BufferedWriter out = new BufferedWriter(new FileWriter(dateiname));		// BufferedWriter-objekt out mit neu erzeugtem FileWriter-objekt mit argument dateinam (& pfad) der Zieldatei 
				for (int i = 0; i < jListMesswerteModel.getSize(); i++){				// zeilenweise die einträge des listmodels mit der write()-methode in die datei schreiben, .getSize() für zeilenanzahl
					out.write(jListMesswerteModel.get(i).toString());					// .get(i) liefert eintrag mit index i als objekt, .toString() weil write() einen String erwartet
					out.newLine();														// .. und nach jedem zeileneintrag ein zeilenvorschub
				}
				out.close();															// schliessen des streams mit close(), abgekürzte variante
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Fehler beim Speichern");			// (anscheinend egal: ob null oder this als erstes argument )
			} 
		}
	}
	
	
	private void jBtnOeffnenActionPerformed(ActionEvent evt) {						// methode um messwerte via filechooser aus .mwd datei (im projektordner) ins jListModel laden 
		JFileChooser fc = new JFileChooser();										// neuer filechooser
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);							// nur Files akzeptieren (keine ordner) => datei soll ja nacher geladen werden
		fc.setFileFilter(new FileNameExtensionFilter("Messwertdateien *mwd", "mwd"));// mögliche datei-erweiterungen auf .mwd beschränken
		fc.setCurrentDirectory(new File("." + File.separator + File.separator));	// plattformunabhängiger rel. pfad für eins rauf i.d.hierarchie, (".\\") wär für windows auch korrekt
		int state = fc.showOpenDialog(null);										// fc-speicher-dialog öffnen + gleichzeitig status auf "file öffnen, jaa" setzen
		if (state == JFileChooser.APPROVE_OPTION){									// wenn satus "file öffnen, jaa" ist
			dateiname = fc.getSelectedFile().getAbsolutePath();						// dem String dateiname, den absoluten pfad, der im fc ausgewählten Datei, zuweisen 
			// File datei = new File(dateiname);						// Fehler vom Heini: brauchts hier NICHT!! 	brauchts nur im: In_FileReader_BufferedReader_KontaktlisteMitSpeichern
			String messwerteZeile;				 									// lokale stringvariable für die einzelenen adresszeilen
			try {
				BufferedReader in = new BufferedReader(new FileReader(dateiname));	// BufferedReader-objekt out mit neu erzeugtem FileReader-objekt mit argument dateinam (& pfad) der Zieldatei 
				jListMesswerteModel.clear();							// WICHTIG: jListModel von einträgen clearen, sonst lassen sich einträge mehrfach ins selbe frame laden
				while ((messwerteZeile = in.readLine()) != null){					// mit while-schleife, solange mit methode .readLine() zeilen einlesen, bis keine zeile mehr vorhanden (=null) 
					jListMesswerteModel.addElement(messwerteZeile);					// jeden, in messwertezeile zwischengespeicherten eintrag mit .addElement() in listbox übertragen 
				}
				in.close();															// schliessen des inputstreams mit close(), abgekürzte variante
			} catch (Exception e){
				JOptionPane.showMessageDialog(this, "Fehler beim Laden");			// (guck this statt null als erstes argument von JOption...) geht auch
			}
		}
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