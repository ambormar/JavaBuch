/* TODO 12.5.   Aufgabe 1, s.392
 * class Out_DateiSpeichern_MitDateiErweiterung_MitFileChooserSpeichern_Messreihe1
 * 
 * 	VERGLEICHE AUCH:	12.3.1.   Out_FileWriter_BufferedWriter_KontaktlisteMitSpeichern		s.364, (OUT) Daten aus programm in Datei ausschreiben  
 *  		
 * 
 * VORGEHEN: 	1. Jframe mit textfield für messwert-eingabe, 					
 * 
 * 				2. messwert übernehmen-button,							=> KERN-CODE siehe:				jBtnUbernehmen..(..)
 * 
 *				3. jList (jListModel) für messreihe,					=> KERN-CODE siehe:				jScrollPane1 im initGUI() 	inkl. jList & jListModel verschachtelt
 *				
 *				4. messwerte speichern in .mwd-datei (im projekt-ordner), mittels JFileChooser & dateiendung kontrollieren / anhängen beim speichern im fc.showSaveDialog
 * 
 *																		=> KERN-CODE siehe:				jBtnSpeichern..(..) 
 *
 *																				 
 *	NEU: 	- JFileChooser um Datei zu Speichern (fc.showSaveDialog(..)):	code ¦
 *																				 V
 *	NEU:	- Datei-Endung kontrollieren / ergänzen vor dem speichern:		code ¦
 *																				 V
 *
 *			private void jBtnSpeichernActionPerformed(ActionEvent evt) {		// JFILECHOOSER mit "file speichern"-dialog / showSaveDialog
 *				JFileChooser fc = new JFileChooser();						 					// FileChooser erzeugen
 *				fc.setFileSelectionMode(JFileChooser.FILES_ONLY);								// nur Files akzeptieren (keine ordner) => datei soll ja nacher gespeichert werden
 *				fc.setFileFilter(new FileNameExtensionFilter("Messwertdateien *.mwd", "mwd"));	// mögliche datei-erweiterungen auf .mwd beschränken
 *				fc.setCurrentDirectory(new File("." + File.separator + File.separator));		// plattformunabhängiger rel. pfad für eins rauf i.d.hierarchie, (".\\") wär für windows auch korrekt
 *				int state = fc.showSaveDialog(null);											// fc-speicher-dialog öffnen + gleichzeitig status auf "speichern, jaa" setzen
 *				if (state == JFileChooser.APPROVE_OPTION){										// wenn der status "speichern, jaa" ist
 *																				// DATEI-ENDUNG kontrollieren & ergänzen mit substring + concat
 *					String selFile = fc.getSelectedFile().getAbsolutePath();					// lokaler stringvariable selFile, den absoluten pfad, der im fc ausgewählten Datei, zuweisen
 *					int index = selFile.indexOf(".");											// index speichern von "." im string, falls einer vorkommt (=> datei-endung oder nicht)
 *					if (index >= 0){															// falls (index >= 0)	=> falls (es einen punkt hat im namen)
 *						dateiname = selFile.substring(0, index).concat(".mwd");					// String dateiname = selFile abgeschnitten (anfang, bis 1 vor indexangabe) verknüpfen mit .endung
 *					} else {																	// sonst
 *						dateiname = selFile.concat(".mwd");										// String dateiname = selFile (ganz) verknüpfen mit .endung
 *					}													
 *					try {																		
 *						BufferedWriter out = new BufferedWriter(new FileWriter(dateiname));		// BufferedWriter-objekt out mit neu erzeugtem FileWriter-objekt mit argument dateinam (& pfad) der Zieldatei 
 *						for (int i = 0; i < jListMesswerteModel.getSize(); i++){				// zeilenweise die einträge des listmodels mit der write()-methode in die datei schreiben, .getSize() für zeilenanzahl
 *							out.write(jListMesswerteModel.get(i).toString());					// .get(i) liefert eintrag mit index i als objekt, .toString() weil write() einen String erwartet
 *							out.newLine();														// .. und nach jedem zeileneintrag ein zeilenvorschub
 *						}
 *						out.close();															// schliessen des streams mit close(), abgekürzte variante
 *					} catch (Exception e) {
 *						JOptionPane.showMessageDialog(this, "Fehler beim Speichern");			// (anscheinend egal: ob null oder this als erstes argument )
 *					} 
 *				}
 *			}
 *
 * 
 * K&K:		Programm Messreihe1
 * 			Programm zum Speichern von Messwerten (Kommazahlen) in einer Datei. Der Dateiname kann über einen Dialog festgelegt werden.
 */

package uebungen12Aufgaben;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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


public class Out_DateiSpeichern_MitDateiErweiterung_MitFileChooserSpeichern_Messreihe1 extends javax.swing.JFrame {
	private JLabel jLabel1;
	private JButton jBtnUbernehmen;
	private JLabel jLabel2;
	private JButton jBtnSpeichern;
	private JScrollPane jScrollPane1;
	private JList jListMesswerte;
	private JTextField jTFMesswert;
	private DefaultListModel jListMesswerteModel;			// selber deklariert anstelle von ComboBoxModel
	private String dateiname;

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
				Out_DateiSpeichern_MitDateiErweiterung_MitFileChooserSpeichern_Messreihe1 inst = new Out_DateiSpeichern_MitDateiErweiterung_MitFileChooserSpeichern_Messreihe1();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public Out_DateiSpeichern_MitDateiErweiterung_MitFileChooserSpeichern_Messreihe1() {
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
			pack();
			this.setSize(400, 312);
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
				Double.parseDouble(jTFMesswert.getText());				// billiger trick um texteingaben zu verhindern: unsauber programmiert (sauber wäre methodenanfang stringmethode zum aussortieren)
				jListMesswerteModel.addElement(jTFMesswert.getText());	// das JListModel um elemente hinzuzufügen; JList wäre für darstellung/optik
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
				out.close();															// schliessen des outputstreams mit close(), abgekürzte variante
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Fehler beim Speichern");			// (anscheinend egal: ob null oder this als erstes argument )
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