/* TODO 12.3.1.   s.364, (OUT) Daten aus programm in Datei ausschreiben  
 * 
 * class Out_FileWriter_BufferedWriter_KontaktlisteMitSpeichern		(CODE	==	12.3.2.   In_FileReader_BufferedReader_KontaktlisteMitSpeichern)
 * 
 * 			IN:		SIEHE:	12.3.2.   In_FileReader_BufferedReader_KontaktlisteMitSpeichern		s.368, (IN) Daten aus datei ins program einlesen  (zurück ins programm/dialogfenster einlesen) 
 * 
 *		ACHTUNG:	IN - OUT immer aus perspektive des PROGGRAMMS verwenden:
 *
 * 				OUT:	= WRITE OUT 	= DATEN AUS PROGRAMM AUS-LESEN
 *	 			IN:		= READ IN		= DATEN INS PROGRAMM SCHREIBEN 	!!!!!!!!
 *
 *				ALLGEMEINE BEGRIFFS-VERWIRRUNG:		- daten in datei schreiben / aus datei auslesen etc.	==>> IGNORIEREN !!!!!!!!!!!!!!!!!!!!!
 *				
 * 
 * 	!!! HIER WEITERMACHEN !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * 
 * 
 * 
 * Daten aus dialogfenster auslesen mit BufferedWriter, Filewriter siehe methode jBtnEnde....()
 * 		// mit BufferedWriter/FileWriter werden textdaten vor dem schliessen eines dialogfensters in eine datei 
 * 		// ausgelesen, die im selben projektordner gespeichert wird (datei dort mit normalem editor einsehbar)
 *		// mit der methode write() von Bufferedwriter werden die strings zeilenweise in die datei geschrieben
 * 
 * Daten aus datei in s dialogfenster einlesen mit BufferedReader, FileReader siehe ende methode initGUI()
 * 		// File datei mit dateinamen wird im programm erzeugt und verglichen, ob die die datei (hier kontakte.dat)
 * 		// ...real im dateisystem existiert, wenn nein, wird sie mit datei.createNewFile() erzeugt, wenn ja..
 *		// wird ein Eingabestream erzeugt (analog zum oben beschriebenen ausgabestrom) und in einer while-schleife..
 *		// ..mit .addElement() zeile für zeile der listbox angefügt bis keine zeile mehr in der datei vorhanden ist
 * 
 * PROGRAMM:	erweiterung von:	11.3.   	JScrollListBox_substring_ohneArrayList_Kontaktliste_MitBearbeiten		Aufgabe 7, s.347
 * 									[	Die Kontakdaten Name, Vorname, Telefonnummer und Email-Adresse können in Textfeldern eingegeben 
 * 										und von dort in eine Listbox übernommen werden. Markierte Einträge können aus der Listbox gelöscht werden. 
 * 										Ein markierter Eintrag kann zum Bearbeiten aus der Listbox zurück in die Textfelder übertragen werden.	]
 * 
 * 									LISTBOX SIEHE:		11.2.2.   Listbox_ArrayList_Basics_Notenbilanz		s.335 uf		
 *									SCROLL-LISTBOX:	 	11.2.3.   ScrollListbox_JScrollPane_SelectionMode_ArrayList_Notenbilanz		s.340 uf (JScrollPane => scrollbalken)		
 * 
 * 
 * 				Erweiterung in diesem programm ist:
 * 				(out) Beim Beenden des Programms werden die Kontaktdaten der Listbox in eine datei ausgelesen / = in einer datei gespeichert. 
 * 				(in) Beim Programmstart werden die Daten aus der Datei in die Listbox eingelesen.
 */

package uebungen12;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

// analog BufferedWriter
import java.io.BufferedReader;
//BufferedWriter übernimmt das Puffern (bei vielen schreibvorgänegn) & reicht die daten an Filewriter weiter
import java.io.BufferedWriter;
// analog FileWriter
import java.io.FileReader;
// Writer, weil zeichenorientierte streams (textdaten) & File(Writer) weil wir in eine datei schreiben
import java.io.FileWriter;
import java.io.File; 		// hier nötig für File.separator bei der dateinamen stringvariabeln
import java.io.IOException; //	 brauchts für catchblock IOException

public class Out_FileWriter_BufferedWriter_KontaktlisteMitSpeichern extends javax.swing.JFrame {
	private JLabel jLNachname;
	private JLabel jLVorname;
	private JTextField jTFNachname;
	private JTextField jTFVorname;
	private JButton jBtnbearbeiten;
	private JButton jBtnLoeschen;
	private JScrollPane jScrollPane1;
	private JLabel jLEMail;
	private JLabel jLKontaktListe;
	private JButton jBtnEnde;
	private JList jListKontakte;
	private JButton jBtnUebernehmen;
	private JTextField jTFEMail;
	private JTextField jTFTelefon;
	private JLabel jLTelefon;
	private DefaultListModel jListKontakteModel;
	// stringvariable dateinamen für datei, in der die kontaktdaten beim schliessen  gespeichert werden
	// String dateiname wird initialisiert mit dem relativen pfad zum aktuellen verzeichnis (aus dem auch das programm gestartet wird)
	// "relativer pfad" besteht aus: "." für aktuelles verzeichnis + platformunabhängiges trennzeichen (File.separator) + dateiname.dat
	private String dateiname = "." + File.separator + "kontakte.dat";
		// statt "." -> "./dokumente/" & ein dokumentordner im Javauebungen12, dann kann man auch im Package explorer die dateien sehen

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Out_FileWriter_BufferedWriter_KontaktlisteMitSpeichern inst = new Out_FileWriter_BufferedWriter_KontaktlisteMitSpeichern();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public Out_FileWriter_BufferedWriter_KontaktlisteMitSpeichern() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jLNachname = new JLabel();
				getContentPane().add(jLNachname);
				jLNachname.setText("Nachname");
				jLNachname.setBounds(12, 12, 93, 16);
			}
			{
				jLVorname = new JLabel();
				getContentPane().add(jLVorname);
				jLVorname.setText("Vorname");
				jLVorname.setBounds(182, 12, 93, 16);
			}
			{
				jLTelefon = new JLabel();
				getContentPane().add(jLTelefon);
				jLTelefon.setText("Telefon");
				jLTelefon.setBounds(352, 12, 93, 16);
			}
			{
				jTFNachname = new JTextField();
				getContentPane().add(jTFNachname);
				jTFNachname.setBounds(12, 34, 158, 23);
			}
			{
				jTFVorname = new JTextField();
				getContentPane().add(jTFVorname);
				jTFVorname.setBounds(182, 34, 158, 23);
			}
			{
				jTFTelefon = new JTextField();
				getContentPane().add(jTFTelefon);
				jTFTelefon.setBounds(352, 34, 275, 23);
			}
			{
				jLEMail = new JLabel();
				getContentPane().add(jLEMail);
				jLEMail.setText("EMail");
				jLEMail.setBounds(12, 67, 93, 16);
			}
			{
				jTFEMail = new JTextField();
				getContentPane().add(jTFEMail);
				jTFEMail.setBounds(12, 88, 328, 23);
			}
			{
				jBtnUebernehmen = new JButton();
				getContentPane().add(jBtnUebernehmen);
				jBtnUebernehmen.setText("Übernehmen >>");
				jBtnUebernehmen.setBounds(352, 88, 184, 23);
				jBtnUebernehmen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnUebernehmenActionPerformed(evt);
					}
				});
			}
			{
				jLKontaktListe = new JLabel();
				getContentPane().add(jLKontaktListe);
				jLKontaktListe.setText("Kontaktliste");
				jLKontaktListe.setBounds(12, 125, 93, 16);
			}
			{
				jBtnEnde = new JButton();
				getContentPane().add(jBtnEnde);
				jBtnEnde.setText("Ende");
				jBtnEnde.setBounds(517, 211, 111, 23);
				jBtnEnde.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnEndeActionPerformed(evt);
					}
				});
			}
			{	// 
				jScrollPane1 = new JScrollPane();
				getContentPane().add(jScrollPane1);
				jScrollPane1.setBounds(14, 149, 612, 42);
				{				// JList muss im JScrollPane drin sein (in der Outline eins ins andere ziehen)
								// LISTBOX grundsätzlich siehe class Notenbilanz_Listbox_ArrayList
					
								// ListModel von DefaultComboboxModel (= jigloo autogeneriert) auf DefaultListModel() ändern
					jListKontakteModel = new DefaultListModel();
					jListKontakte = new JList();
					jScrollPane1.setViewportView(jListKontakte);
					jListKontakte.setModel(jListKontakteModel);
					jListKontakte.setBounds(14, 149, 612, 42);
								// markierungsmöglichkeiten in der ListBox auf: nur ein eintrag anwählbar
								// in properties (outline) von jListKontakte (selectionmode) verstellen
					jListKontakte.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				}
			}
			{
				jBtnLoeschen = new JButton();
				getContentPane().add(jBtnLoeschen);
				jBtnLoeschen.setText("markierten Eintrag löschen");
				jBtnLoeschen.setBounds(12, 211, 229, 23);
				jBtnLoeschen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnLoeschenActionPerformed(evt);
					}
				});
			}
			{
				jBtnbearbeiten = new JButton();
				getContentPane().add(jBtnbearbeiten);
				jBtnbearbeiten.setText("markierten Eintrag bearbeiten");
				jBtnbearbeiten.setBounds(261, 211, 239, 23);
				jBtnbearbeiten.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnbearbeitenActionPerformed(evt);
					}
				});
			}
			// (importe: java.io.File java.io.BufferedReader java.io.FileReader nicht vergessen)
			// Daten in programm einlesen mit BufferedReader & FileReader (IN)
			// am ende von initGUI() weil hier schon ListBox mit Listmodel erzeugt ist und die einträge zeilenweise eingetragen werden können
			{	// File datei mit argument dateiname wird in der methode (!!!) erzeugt, damit man es nachher mit den... 
				// ...Files im dateisystem vergleichen kann. das bedeutet nicht, dass diese datei im dateisystem real erzeugt wird!!!!
				File datei = new File(dateiname); // ist eine art vergleichsfile innerhalb der methode!!!
				BufferedReader in = null; 	// Buffererreader-objekt in (weil ins Prog. EINgelesen wird) wird ausserhalb vom try-catch-block erzeugt weil er so überall verwendet werden kann
				if (!datei.exists()) {	// falls das File datei mit dateiname im Dateisystem nicht existiert...
					datei.createNewFile();	// ... wird ein neues File mit dateiname im dateisystem real (!!) erzeugt
				} else { 				// sonst, wenn File mit dateiname (kontaktdatendatei) im dateisystem schon existiert hat:
					String adresszeile; // lokale stringvariable für die einzelenen adresszeilen
					try { 				// standard um fehler abzufangen
						// eingabestream für "in" mit :  BufferedReader-objekt unter mitgabe & erzeugen von FileReader-objekt ...
						// ... mit dem argument dateiname (alles analog BufferedWriter out, methode BtnEnde..())
						in = new BufferedReader(new FileReader(dateiname)); 
						// da anzahl einträge der datei nicht bekannt: statt for-schleife mit while-schleife, solange mit methode.. 
						while ((adresszeile = in.readLine()) != null) { //...  .readLine() zeilen einlesen, bis keine zeile mehr vorhanden (=null)
							jListKontakteModel.addElement(adresszeile); // jeden, in adresszeile zwischengespeicherten eintrag.. 
						}			// .. mit .addElement() in listbox übertragen 
					} catch (Exception e) {
						e.printStackTrace();
					} finally {				// auf jeden fall:
						if (in != null) {   // falls eingabestream in nicht gleich null...
							try {			// ... unter verwendung der sichderheitsmechanismen try-catch
								in.close();		// ...steram und damit auch die datei mit .close() schliessen
							} catch (IOException e){
								e.printStackTrace();
							}
						}
					}
				}
			} 
			pack();
			this.setSize(655, 291);
		} catch (Exception e) {
		    			//add your error handling code here
			e.printStackTrace();
		}
	}
	
	private void jBtnUebernehmenActionPerformed(ActionEvent evt) {
						// wenn leere felder: fehlertext ausgeben
		if (jTFNachname.getText().isEmpty() || jTFVorname.getText().isEmpty()
				|| jTFTelefon.getText().isEmpty() || jTFEMail.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Bitte vollständige Angaben machen");
			jTFNachname.requestFocus();
		} else {
						// das JListModel um elemente hinzuzufügen; JList wäre für darstellung/optik
			jListKontakteModel.addElement(jTFNachname.getText() + ";" + jTFVorname.getText() + ";" +
					jTFTelefon.getText() + ";" + jTFEMail.getText() + ";");
						// textfelder leeren
			jTFNachname.setText("");
			jTFVorname.setText("");
			jTFTelefon.setText("");
			jTFEMail.setText("");
						// focus für nächste eingabe
			jTFNachname.requestFocus();
		}
	}
	// button: löschen des markierten eintrags
	private void jBtnLoeschenActionPerformed(ActionEvent evt) {
		try { 
						// lokale variabel für index von angewähltem eintrag, (obwohl der eintrag eigentlich nicht...
						// ...in einem von mir erstellten array gespeichert ist, aber scheint zu gehen.)
						// abfragen des index mit .getSelectedIndex() von jList ("darstellende" klasse der Listbox) 
			int index = jListKontakte.getSelectedIndex();
			jListKontakteModel.remove(index);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Kein Eintrag angewählt");
		}
	}
	// angewählte zeile zurück in textfelder überschreiben (& aus liste löschen)
	private void jBtnbearbeitenActionPerformed(ActionEvent evt) {
		try { 
						// lokale variabel für index von angewähltem eintrag in der liste
						// abfragen des index mit .getSelectedIndex() von jList ("darstellende" klasse der Listbox) 
			int index = jListKontakte.getSelectedIndex();
						// element an der stelle index auslesen & einer lokalen stringvariabeln zuweisen
						// wichtig: (string) aufzwingen, weil jListKontakteModel.getElementAt() liefert objekt zurück..
						// ...sonst fehler weil dem String nicht ein objekt zugewiesen werden kann
			String zeile = (String) jListKontakteModel.getElementAt(index);
						// mit methode substring(indexanfang, indexende) einen teil vom string auslesen
			jTFNachname.setText(zeile.substring(0, zeile.indexOf(";")));
						// zeile = rest-substring der zeile, +1: damit ";" nicht mitausgelesen wird
			zeile = zeile.substring(zeile.indexOf(";") + 1, zeile.length());
			jTFVorname.setText(zeile.substring(0, zeile.indexOf(";")));
			zeile = zeile.substring(zeile.indexOf(";") + 1, zeile.length());
			jTFTelefon.setText(zeile.substring(0, zeile.indexOf(";")));
			zeile = zeile.substring(zeile.indexOf(";") + 1, zeile.length());
			jTFEMail.setText(zeile.substring(0, zeile.indexOf(";")));
						// ins textfeld übbertragene zeile aus liste löschen
			jListKontakteModel.remove(index);
						// focus
			jTFNachname.requestFocus();
			jTFNachname.selectAll();	
			
		} catch (Exception e) {		// falls nix angewählt wäre:
			JOptionPane.showMessageDialog(null, "Kein Eintrag angewählt");
		}
	}
	
	// vor beenden des programms wird eine datei erzeugt in der die vorhandenen daten gespeichert werden.
	// existenz der datei kontakte.dat im projektordner überprüfen!!! (explorer > dokumente > java > progr. > JavaUebungen12 > kontakte.dat)
	private void jBtnEndeActionPerformed(ActionEvent evt) {
		// ein BufferedWriter-Objekt mit dem namen out wird erzeugt und vorerst mit null initialisiert
		// das BufferedWriter-objekt wird ausserhalb des try-blocks erzeugt, weil s in finally auch gebraucht wird
		BufferedWriter out = null; // initialisierung mit null bei objektdatentypen (bei basisdatentypen wär s: 0 oder false etc.)
		try { 
			// BufferedWriter-objekt out wird initialisiert, dabei wird dem konstruktor ein FileWriter-objekt...
			// ..übergeben, das gleichzeitig erzeugt wird, dem konstruktor des FileWriter wird wiederum als argument..
			// ..der name der Zieldatei übergeben
			out = new BufferedWriter(new FileWriter(dateiname));
			// for-schleife um zeilenweise die einträge des listmodels mit der write()-methode in die datei zu schreiben
			for (int i = 0; i < jListKontakteModel.getSize(); i++) { // .getSize() für zeilenanzahl
				out.write(jListKontakteModel.get(i).toString()); // .get(i) liefert eintrag mit index i als objekt, .toString() weil write() einen String erwartet
				out.newLine(); // .. und nach jedem zeileneintrag ein zeilenvorschub
			}
		} catch (Exception e) {	// falls fehler beim file ausschreiben / file erzesugen
			e.printStackTrace();
		} finally { // finally => auf jeden fall (auch wenn oben fehler aufgetreten sind wird stream geschlossen)
			if (out != null){ // wenn out nicht null ist, also wirklich ein bufferedWriter-objekt erzeugt wurde
				try { 
					out.close();	// schliessen des streams mit close() auch bei fehlern/ evtl. gebufferte einträge werden fertig ausgeschrieben
				} catch (IOException e){ // zusätzlich wird auf fehler beim schliessen selber (des streams) reagiert
					e.printStackTrace();
				}
			}
		}
		System.exit(0); // programm beenden
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