/* TODO 12.3.1.   s.364, (OUT) Daten aus programm in Datei ausschreiben  
 * class Out_FileWriter_BufferedWriter_KontaktlisteMitSpeichern		(CODE	==	12.3.2.   In_FileReader_BufferedReader_KontaktlisteMitSpeichern)
 * 
 *	CODE VON Out_FileWrite.. & In_FileReader.. IST IDENTISCH (inkl. in & out), DIE KOMMENTARE OBEN SIND ABER JEWEILS NUR F�R OUT oder IN 	!!!!!!!!!!!!!!!!
 * 
 * 				IN:		SIEHE:	12.3.2.   In_FileReader_BufferedReader_KontaktlisteMitSpeichern		s.368, (IN) Daten aus datei ins program einlesen  (zur�ck ins programm/dialogfenster einlesen) 
 * 
 *				ACHTUNG:	IN - OUT immer aus perspektive des PROGGRAMMS verwenden:
 * 							OUT:	= WRITE OUT 	= DATEN AUS PROGRAMM AUS-LESEN
 *	 						IN:		= READ IN		= DATEN INS PROGRAMM SCHREIBEN 	!!!!!!!!
 *							ALLGEMEINE BEGRIFFS-VERWIRRUNG:		- daten in datei schreiben / aus datei auslesen etc.	==>> IGNORIEREN !!!!!!!!!!!!!!!!!!!!!
 *
 *	12.3.1.	WRITE OUT - DATEN AUS PROGRAMM AUS-SCHREIBEN (IN EINE DATEI)
 *
 * 	OUT ZU BEACHTEN VORWEG:		- speichern von daten auf datentr�ger ist fehler-anf�llig		=>  Exception-handling grunds�tzlich wichtig		[datentr�ger k�nnen voll, schreibgesch�tzt oder fehlerhaft sein]
 * 								- hier: speichern von textdaten			=> zeichen-orientierte Streams -> writer:	=> FileWriter		(import: java.io.FileWriter)
 * 								- da vermutlich viel text/eintr�ge	 	=> viel schreibvorg�nge 	-> puffern:		=> BufferedWriter 	(import: java.io.BufferedWriter)
 * 								
 * 	IMPORT:			java.io.FileWriter		& 	java.io.BufferedWriter
 * 
 * 	OUT VORGEHEN:	=> Daten aus dialogfenster ausschreiben mit BufferedWriter / Filewriter in der  methode jBtnEnde....()
 * 					 > eine datei wird in den projektordner (hier JavaBuch) gespeichert 		((datei ist dort mit dem normalen dokumenten-explorer einsehbar))
 * 					 > mit BufferedWriter/FileWriter werden textdaten mit dem schliessen des dialogfensters in die datei ausgeschrieben, 
 *					 > mit der methode write() von Bufferedwriter werden die strings zeilenweise in die datei geschrieben	
 *				
 *	OUT (KERN-CODE): 
 * 
 * 		DATEINAME ERZEUGEN MIT PFAD ZUM PROJEKTORDNER (schema):
 * 
 * 			public class Out_FileWriter...{											// stringvariable dateinamen als variable des frames:..
 * 				...																	// ...f�r datei, in der die kontaktdaten beim schliessen gespeichert werden (siehe methode jBtnEndeA..() )
 * 				private String dateiname = "." + File.separator + "kontakte.dat";	// ...initialisieren mit dem relativen pfad zum aktuellen verzeichnis (aus dem auch das programm gestartet wird)
 *				...																	// "relativer pfad" besteht aus: "." (=aktuelles verzeichnis) + File.separator (= plattformunabh�ngiges trennzeichen) + dateiname.dat
 *																					// [NB statt "." -> "./dokumente/" & ein dokumentordner in JavaBuch, dann kann man auch im Package explorer die dateien sehen	]
 * 																					
 * 		WRITE OUT DER DATEN & ERZEUGEN DER DATEI (schema):
 *				...															
 *				private void jBtnEndeActionPerformed(ActionEvent evt) {				// vor beenden des programms wird datei erzeugt in der die vorhandenen daten gespeichert werden. [existenz der datei kontakte.dat: siehe projektordner (JavaBuch) im explorer!!!] 
 *					BufferedWriter out = null;										// ein BufferedWriter-Objekt mit dem namen out wird erzeugt und vorerst mit null initialisiert, initialisierung mit null bei objektdatentypen (bei basisdatentypen w�r s: 0 oder false etc.)
 *					try {															// ...das BufferedWriter-objekt wird ausserhalb des try-blocks erzeugt, weil s in finally auch gebraucht wird
 *																					// mit FileWriter wird anscheinend (?) real auf dem datentr�ger die datei mit dateiname erzeugt:
 *						out = new BufferedWriter(new FileWriter(dateiname));		// BufferedWriter-objekt initialisieren & dem konstruktor ein FileWriter-objekt �bergeben, das gleichzeitig erzeugt wird & dem wiederum als argument der name der Zieldatei �bergeben
 *						for (int i = 0; i < jListKontakteModel.getSize(); i++) { 	// for-schleife um zeilenweise die eintr�ge des listmodels mit der write()-methode in die datei zu schreiben,  
 *							out.write(jListKontakteModel.get(i).toString()); 		// .get(i) liefert eintrag mit index i als objekt, .toString() weil write() einen String erwartet
 *							out.newLine(); 											// .. und nach jedem zeileneintrag ein zeilenvorschub
 *						}
 *					} catch (Exception e) {						// Exception-handling wichtig wegen anf�lligem speichern von daten auf datentr�ger
 *						e.printStackTrace();																						// consolen-fehler-text f�r allf�lliges e		
 *					} finally { 								// finally => auf jeden fall (auch wenn oben fehler aufgetreten sind soll stream geschlossen werden, desshalb wird close() ins finally ausgelagert)
 *						if (out != null){ 						// falls out nicht null ist, also wirklich ein bufferedWriter-objekt erzeugt wurde..
 *							try { 
 *								out.close();					// ...schliessen des streams mit close() [auch bei obigen fehlern], evtl. gebufferte eintr�ge werden fertig ausgeschrieben [close() beinhaltet flush()]
 *							} catch (IOException e){ 			// ...oder zus�tzliches Exceptionhandlicng wenn beim schliessen selber (des streams) ein fehler auftritt
 *								e.printStackTrace();
 *							}
 *						}
 *					}
 *					System.exit(0); 							// programm beenden
 *				}
 * 
 * 
 * PROGRAMM:	Erweiterung in diesem programm ist:
 * 					(out) Beim Beenden des Programms werden die Kontaktdaten der Listbox in eine datei ausgeschrieben / = in einer datei gespeichert. 
 * 					(in) Beim Programmstart werden die Daten aus der Datei in die Listbox eingelesen. 
 * 
 * 				erweiterung von:	11.3.   	JScrollListBox_substring_ohneArrayList_Kontaktliste_MitBearbeiten		Aufgabe 7, s.347
 * 									[	Die Kontakdaten Name, Vorname, Telefonnummer und Email-Adresse k�nnen in Textfeldern eingegeben 
 * 										und von dort in eine Listbox �bernommen werden. Markierte Eintr�ge k�nnen aus der Listbox gel�scht werden. 
 * 										Ein markierter Eintrag kann zum Bearbeiten aus der Listbox zur�ck in die Textfelder �bertragen werden.	]
 * 
 * 									LISTBOX SIEHE:		11.2.2.   Listbox_ArrayList_Basics_Notenbilanz		s.335 uf		
 *									SCROLL-LISTBOX:	 	11.2.3.   ScrollListbox_JScrollPane_SelectionMode_ArrayList_Notenbilanz		s.340 uf (JScrollPane => scrollbalken)		
 * 				
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
//BufferedWriter �bernimmt das Puffern (bei vielen schreibvorg�negn) & reicht die daten an Filewriter weiter
import java.io.BufferedWriter;
// analog FileWriter
import java.io.FileReader;
// Writer, weil zeichenorientierte streams (textdaten) & File(Writer) weil wir in eine datei schreiben
import java.io.FileWriter;
import java.io.File; 		// hier n�tig f�r File.separator bei der dateinamen stringvariabeln
import java.io.IOException; //	 brauchts f�r catchblock IOException

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
	// stringvariable dateinamen f�r datei, in der die kontaktdaten beim schliessen  gespeichert werden
	// String dateiname wird initialisiert mit dem relativen pfad zum aktuellen verzeichnis (aus dem auch das programm gestartet wird)
	// "relativer pfad" besteht aus: "." f�r aktuelles verzeichnis + platformunabh�ngiges trennzeichen (File.separator) + dateiname.dat
	private String dateiname = "." + File.separator + "kontakte.dat";
		// statt "." -> "./dokumente/" & ein dokumentordner in JavaBuch, dann kann man auch im Package explorer die dateien sehen

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
				jBtnUebernehmen.setText("�bernehmen >>");
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
								// LISTBOX grunds�tzlich siehe class Notenbilanz_Listbox_ArrayList
					
								// ListModel von DefaultComboboxModel (= jigloo autogeneriert) auf DefaultListModel() �ndern
					jListKontakteModel = new DefaultListModel();
					jListKontakte = new JList();
					jScrollPane1.setViewportView(jListKontakte);
					jListKontakte.setModel(jListKontakteModel);
					jListKontakte.setBounds(14, 149, 612, 42);
								// markierungsm�glichkeiten in der ListBox auf: nur ein eintrag anw�hlbar
								// in properties (outline) von jListKontakte (selectionmode) verstellen
					jListKontakte.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				}
			}
			{
				jBtnLoeschen = new JButton();
				getContentPane().add(jBtnLoeschen);
				jBtnLoeschen.setText("markierten Eintrag l�schen");
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
			// am ende von initGUI() weil hier schon ListBox mit Listmodel erzeugt ist und die eintr�ge zeilenweise eingetragen werden k�nnen
			{	// File datei mit argument dateiname wird in der methode (!!!) erzeugt, damit man es nachher mit den... 
				// ...Files im dateisystem vergleichen kann. das bedeutet nicht, dass diese datei im dateisystem real erzeugt wird!!!!
				File datei = new File(dateiname); // ist eine art vergleichsfile innerhalb der methode!!!
				BufferedReader in = null; 	// Buffererreader-objekt in (weil ins Prog. EINgelesen wird) wird ausserhalb vom try-catch-block erzeugt weil er so �berall verwendet werden kann
				if (!datei.exists()) {	// falls das File datei mit dateiname im Dateisystem nicht existiert...
					datei.createNewFile();	// ... wird ein neues File mit dateiname im dateisystem real (!!) erzeugt
				} else { 				// sonst, wenn File mit dateiname (kontaktdatendatei) im dateisystem schon existiert hat:
					String adresszeile; // lokale stringvariable f�r die einzelenen adresszeilen
					try { 				// standard um fehler abzufangen
						// eingabestream f�r "in" mit :  BufferedReader-objekt unter mitgabe & erzeugen von FileReader-objekt ...
						// ... mit dem argument dateiname (alles analog BufferedWriter out, methode BtnEnde..())
						in = new BufferedReader(new FileReader(dateiname)); 
						// da anzahl eintr�ge der datei nicht bekannt: statt for-schleife mit while-schleife, solange mit methode.. 
						while ((adresszeile = in.readLine()) != null) { //...  .readLine() zeilen einlesen, bis keine zeile mehr vorhanden (=null)
							jListKontakteModel.addElement(adresszeile); // jeden, in adresszeile zwischengespeicherten eintrag.. 
						}			// .. mit .addElement() in listbox �bertragen 
					} catch (Exception e) {
						e.printStackTrace();
					} finally {				// auf jeden fall:
						if (in != null) {   // falls eingabestream in nicht gleich null...
							try {			// ... unter verwendung der sichderheitsmechanismen try-catch
								in.close();		// ...stream und damit auch die datei mit .close() schliessen
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
			JOptionPane.showMessageDialog(null, "Bitte vollst�ndige Angaben machen");
			jTFNachname.requestFocus();
		} else {
						// das JListModel um elemente hinzuzuf�gen; JList w�re f�r darstellung/optik
			jListKontakteModel.addElement(jTFNachname.getText() + ";" + jTFVorname.getText() + ";" +
					jTFTelefon.getText() + ";" + jTFEMail.getText() + ";");
						// textfelder leeren
			jTFNachname.setText("");
			jTFVorname.setText("");
			jTFTelefon.setText("");
			jTFEMail.setText("");
						// focus f�r n�chste eingabe
			jTFNachname.requestFocus();
		}
	}
	// button: l�schen des markierten eintrags
	private void jBtnLoeschenActionPerformed(ActionEvent evt) {
		try { 
						// lokale variabel f�r index von angew�hltem eintrag, (obwohl der eintrag eigentlich nicht...
						// ...in einem von mir erstellten array gespeichert ist, aber scheint zu gehen.)
						// abfragen des index mit .getSelectedIndex() von jList ("darstellende" klasse der Listbox) 
			int index = jListKontakte.getSelectedIndex();
			jListKontakteModel.remove(index);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Kein Eintrag angew�hlt");
		}
	}
	// angew�hlte zeile zur�ck in textfelder �berschreiben (& aus liste l�schen)
	private void jBtnbearbeitenActionPerformed(ActionEvent evt) {
		try { 
						// lokale variabel f�r index von angew�hltem eintrag in der liste
						// abfragen des index mit .getSelectedIndex() von jList ("darstellende" klasse der Listbox) 
			int index = jListKontakte.getSelectedIndex();
						// element an der stelle index auslesen & einer lokalen stringvariabeln zuweisen
						// wichtig: (string) aufzwingen, weil jListKontakteModel.getElementAt() liefert objekt zur�ck..
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
						// ins textfeld �bbertragene zeile aus liste l�schen
			jListKontakteModel.remove(index);
						// focus
			jTFNachname.requestFocus();
			jTFNachname.selectAll();	
			
		} catch (Exception e) {		// falls nix angew�hlt w�re:
			JOptionPane.showMessageDialog(null, "Kein Eintrag angew�hlt");
		}
	}
	
	// vor beenden des programms wird eine datei erzeugt in der die vorhandenen daten gespeichert werden.
	// existenz der datei kontakte.dat im projektordner �berpr�fen!!! (explorer > dokumente > java > progr. > JavaUebungen12 > kontakte.dat)
	private void jBtnEndeActionPerformed(ActionEvent evt) {
		// ein BufferedWriter-Objekt mit dem namen out wird erzeugt und vorerst mit null initialisiert
		// das BufferedWriter-objekt wird ausserhalb des try-blocks erzeugt, weil s in finally auch gebraucht wird
		BufferedWriter out = null; // initialisierung mit null bei objektdatentypen (bei basisdatentypen w�r s: 0 oder false etc.)
		try { 
			// BufferedWriter-objekt out wird initialisiert, dabei wird dem konstruktor ein FileWriter-objekt...
			// ..�bergeben, das gleichzeitig erzeugt wird, dem konstruktor des FileWriter wird wiederum als argument..
			// ..der name der Zieldatei �bergeben
			out = new BufferedWriter(new FileWriter(dateiname)); // mit FileWriter wird anscheinend (?) real auf dem datentr�ger eine datei mit dateiname erzeugt
			// for-schleife um zeilenweise die eintr�ge des listmodels mit der write()-methode in die datei zu schreiben
			for (int i = 0; i < jListKontakteModel.getSize(); i++) { // .getSize() f�r zeilenanzahl
				out.write(jListKontakteModel.get(i).toString()); // .get(i) liefert eintrag mit index i als objekt, .toString() weil write() einen String erwartet
				out.newLine(); // .. und nach jedem zeileneintrag ein zeilenvorschub
			}
		} catch (Exception e) {	// falls es fehler gibt beim file ausschreiben / file erzeugen
			e.printStackTrace();
		} finally { // finally => auf jeden fall (auch wenn oben fehler aufgetreten sind wird stream geschlossen)
			if (out != null){ // wenn out NICHT null ist, also wirklich ein bufferedWriter-objekt erzeugt wurde (wenn out null w�re, ist close() �berfl�ssig!!)
				try { 
					out.close();	// schliessen des streams mit close() auch bei fehlern/ evtl. gebufferte eintr�ge werden fertig ausgeschrieben
				} catch (IOException e){ // zus�tzlich wird auf fehler beim schliessen selber (des streams) reagiert
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