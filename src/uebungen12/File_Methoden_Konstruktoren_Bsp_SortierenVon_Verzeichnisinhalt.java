/* TODO 12.1.1.   s.351
 * class File_Methoden_Konstruktoren_Bsp_SortierenVon_Verzeichnisinhalt
 * 
 * KLASSE FILE BASICS:		SIEHE AUCH:		12.1.   File_Konstruktoren_Methoden_Basics		s.349 
 * 
 * PROGRAMM:	Es wird der Inhalt eines Ordners getrennt nach Verzeichnissen und Dateien in zwei Listen angezeigt.
 * 				Das jeweils anzuzeigende Verzeichnis wird in einem Textfeld eingegeben.
 * 
 * 				ACHTUNG: real funktioniert das Programm nur, wenn man im verzeichnis textfeld den vollständigen dateipfad angiebt
 * 
 * BSP.-PROG. F. METHODEN /KONSTRUKTOREN D. KL. FILE: 	kernpassage genau siehe methode  jBtnAnzeigenActionPerformed(...), ca. zeile 176
 * 
 * VERZEICHNISINHALT SORTIEREN (schema):
 * 
 * 			private File verzeichnis;										// objekt der klasse file deklarieren bei den variableln der klasse
 * 			
 * 			private void jBtnAnzeigenActionPerformed(..) {					// methode hier zum verzeichnissinhalte anzeigen / sortieren
 * 				...
 *				verzeichnis = new File(jTFVerzeichnis.getText()) ;  		// neues file erstellen mit d. namen-pfad-eingabe aus dem textfeld
 *				if (verzeichnis.exists()) {									// falls verzeichnis im dateisystem existiert:
 *					String[] inhalt = verzeichnis.list(); 					// lokales stringarray (inhalt) mit den datei-/verzeichnis-namen von file verzeichnis befüllen
 *					for (String eintrag: inhalt) { 							// foreach-schleife zum sortieren der elemente in  datei oder verzeichnis & eintragen in die jeweilige liste
 *						File f = new File (verzeichnis, eintrag);			// für jeden eintrag ein lokales File mit parametern: übergeordnetes-verzeichnis-file (mit bereits vorhandenem pfad) & dateinamen 
 *						if (f.isDirectory()) { 								// falls eintrag ein verzeichnis ist... 
 *							jListVerzeichnisseModel.addElement(eintrag); 	// ... den eintrag der verzeichniss-listbox anfügen
 *						} else {
 *							jListDateienModel.addElement(eintrag); 			// ... sonst den eintrag der dateien-listbox anfügen
 *						}
 *					}
 *				} else { 															// falls File verzeichnis nicht existiert: fehlertext
 *					JOptionPane.showMessageDialog(null, "File existiert nicht");
 *				}
 *			}
 * 
 * HIER VERWENDETE METHODEN DER KLASSE FILE: 	
 * 				.exists() 			erfragen ob fileObjekt existiert, welches zuvor mit namen in klammer des konstruktors erzeugt worden ist
 * 				.list() 			auflisten der inhalte eines verzeichnis-FileObjekts
 * 				.isDirectory() 		erfragen ob FileObjekt (übergeordneter verzeichnsname, dateiname) verzeichnis ist
 * 				.isFile()			erfragen ob FileObjekt (übergeordneter verzeichnsname, dateiname) eine datei ist	
 *
 *
 * FILE BASICS:		=> die objektinstanzen von File SIND NICHT die eigentlichen dateien/verzeichnisse in meinem dateiensystem selbst.
 * 
 * 					die objektinstanzen die man mit der Klasse File erstellt, sind nur ENTSPRECHUNGEN der realen 
 * 					dateien/verzeichnisse, mittels derer man z.b. Dateien / verzeichnisse miteinander vergleichen, 
 * 					bzw. beliebige methoden der Klasse File auf diese realen Dateien/verzeichnisse indirekt anwenden kann.
 * 															
 * ACHTUNG: 	der name des FileObjekts (hier verzeichnis) ist nur ein Variabelname, (nicht ein konkretes file auf meiner festplatte)
 * 				der name einer gesuchten Datei/verzeichnises wird dem konstruktor beim erzeugen des FileObjekts als Parameter übergeben.
 * 
 * KONSTRUKTOREN V. FILE: 	
 *  	1.	File (String path)					path => datei oder verzeichnis-name mit pfad als string					 
 * 		2.	File (String dir, String name) 		dir => übergeordnetes verzeichnis mit pfad als string;	name => datei- oder verzeichnisname/restpfad als string		
 * 		3.	File (File dir, String name)		dir => übergeordnetes verzeichnis mit pfad als File;	name => datei- oder verzeichnisname/restpfad als string	
 * 
 */

package uebungen12;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// klasse File von java.io importieren nicht vergessen, gibt sonst beim deklarieren von file fehler aus
import java.io.File;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

public class File_Methoden_Konstruktoren_Bsp_SortierenVon_Verzeichnisinhalt extends javax.swing.JFrame {
	private JLabel jLVerzeichnis;
	private JTextField jTFVerzeichnis;
	private JScrollPane jScrollPane1;
	private JScrollPane jScrollPane2;
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
				File_Methoden_Konstruktoren_Bsp_SortierenVon_Verzeichnisinhalt inst = new File_Methoden_Konstruktoren_Bsp_SortierenVon_Verzeichnisinhalt();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public File_Methoden_Konstruktoren_Bsp_SortierenVon_Verzeichnisinhalt() {
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
				jBtnAnzeigen.setBounds(12, 51, 179, 21);
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
			pack();
			setSize(400, 300);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}
	
	// methode zum anzeigen des verzeichnisinhalts bei clicken von jBtnAnzeigen
	private void jBtnAnzeigenActionPerformed(ActionEvent evt) {
		// löschen aller allfälligen vorheriger einträge in den beiden listboxen/listmodels (dateien & verzeichnisse)
		jListVerzeichnisseModel.clear();
		jListDateienModel.clear();
		if (jTFVerzeichnis.getText().isEmpty()) {	// falls keine angaben im textfeld verzeichnis...
			JOptionPane.showMessageDialog(null, "Bitte Verzeichnisname angeben"); // ... fehlertext
		} else {
			verzeichnis = new File(jTFVerzeichnis.getText()) ;  // neues file erstellen mit d. namen aus der textfeldeingabe
			if (verzeichnis.exists()) {							// falls (der file-name von) verzeichnis im dateisystem existiert:
						// lokales stringarray (inhalt) wird mittels methode .list() mit den namen der Dateien/verzeichnisse...
				String[] inhalt = verzeichnis.list(); // ... des File-objekts (verzeichnis) befüllt
						// foreach-schleife zum sortieren der elemente in  datei oder verzeichnis und eintrag in die zuständige listbox
				for (String eintrag: inhalt) { 
						// für jeden eintrag ein lokales File mit parametern übergeordnet-verzeichnisnamen & dateinamen (!!!)..
						// .. damit die methoden isFile() & isDirectory() korrekt funktionieren können
					File f = new File (verzeichnis, eintrag);	// file f enstpricht eintrag, verzeichnis entspricht dem übergeordneten verzeichnis des eintrags	
					if (f.isDirectory()) { // falls eintrag ein verzeichnis ist... 
						jListVerzeichnisseModel.addElement(eintrag); // ... den eintrag der verzeichniss-listbox anfügen
					} else {
						jListDateienModel.addElement(eintrag); // ... sonst den eintrag der dateien-listbox anfügen
					}
				}
			} else { // falls File verzeichnis nicht existiert: fehlertext
				JOptionPane.showMessageDialog(null, "File existiert nicht");
			}
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
