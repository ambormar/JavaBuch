/* TODO 12.3.5.   s.374, (Textverschl�sselung) (ZeichenOrientierte Datenstreams)	
 * class IO_VerschluesseltWriter_VerschluesseltReader_Textverschluesselung		nutzt	VerchluesseltWriter & VerschluesseltReader
 * 
 * SIEHE AUCH:		FILTERWRITER BASICS:		12.3.3.   FilterWriter_Basics_Methoden_Konstruktor		s.370
 * 					VERSCHLUESSELTWRITER		12.3.3.   VerschluesseltWriter extends FilterWriter		s.370 
 * 					FILTERREADER BASICS:		12.3.4.   FilterReader_Basics_Methoden_Konstruktor		s.372 
 * 					VERSCHLUESSELTREADER:		12.3.4.   VerschluesseltReader extends FilterReader		s.373 
 *  
 * 12.3.5. TEXTDATEIEN VERSCHL�SSELN & ENTSCHL�SSELN
 * 
 * 	VORGEHEN: 
 * 
 * 		=> Das Programm nutzt die selbstgeschriebenen Klassen (dieses packages) VerschluesseltWriter und VerschluesseltReader (erweiterungen von FilterWriter & FilterReader)
 * 			zum verschl�sselten Speicherern & verschl�sselten bzw. unverschl�sselten �ffnen von Text.
 * 	 
 * 		=> GUi, bestehend aus Frame mit JTextPane (anstelle von JTextField) zum aus-schreiben / ein-lesen am st�ck (statt zeilen-weise, wie bei JTextFiled) 
 * 			& 3 Buttons:
 * 
 * 			1. verschl�sselt speichern 	=> verschl�sselt aus-schreiben von text, aus jTextPane in verschluesselt.txt datei, mittels:	 		out = new VerschluesseltWriter (new FileWriter(dateiname)
 * 			2. verschl�sselt �ffnen 	=> ein-lesen des verschluesselten texts, aus verschluesselt.txt ins jTextPane, mittels:		 			in = new BufferedReader (new FileReader(dateiname))
 * 			3. unverschl�sselt �ffnen	=> entschl�sseltes ein-lesen des verschluesselten texts, aus verschluesselt.txt ins jTextPane, mittels:	in = new VerschluesseltReader (new FileReader(dateiname))
 *
 * 		=> die effektife verschl�sselung / entschl�sselung der TEXTZEICHEN wird in den klassen VerschluesseltWriter & VerschluesseltReader gemacht.
 * 			-> VerschluesseltWriter & VerschluesseltReader werden hier zum AUSSCHREIBEN & EINLESEN anstelle von BufferedWriter & BufferedReader eingesetzt.
 * 			-> auch VerschluesseltWriter & VerschluesseltReader ben�tigen (wie BufferedWriter & BufferedReader) als ARGUMENT einen Writer / Reader, hier: FileWriter & FileReader
 *
 *		=> beachte: 	StringBuffer-objekt zeile in den 2 methoden zum einlesen (in) des textes ins programm		// glaub:  w�re wie String zeile, aber nochmal gebuffert, zur aufnahme der zeichenfolge 
 *
 *
 * 	JTEXTPANE:		=> aus Jigloo (componenten) kann mehrzeiligen text als eingabe aufnehmen & somit wie ein einfacher texteditorverwendet werden;
 *						-> vergleiche: bei JTextField muss zeilenweise ausgeschrieben werden, bei jTextPane wie bei einfachem texteditor am st�ck 
 *					-> siehe initGUI() unter JScrollPane, ca zeile 111
 * 
 * 
 * 	IMPORTE (THEMENSPEZIFISCH):		java.io.BufferedReader;		import java.io.File;	java.io.FileReader;		java.io.FileWriter;		java.io.IOException;	
 * 
 * 									VerschluesseltWriter  & VerschluesseltReader	->  NICHT, sind ja Klassen desselben packages
 * 
 * 	KERN-CODE: 		
 * 
 * 		DATEINAME MIT PFAD ZUM PROJEKTORDNER:		private String dateiname = "." + File.separator + "verschluesselt.txt";		// siehe private-variabeln der klasse, ca zeile 74
 * 
 * 		VERSCHL�SSELT SPEICHERN:					siehe	jBtnSpeichern...(ActionEvent evt) {..}								// ca. zeile 158
 *
 *		VERSCHL�SSELT �FFNEN: 						siehe	jBtnVerschluesselt...(ActionEvent evt) {..}							// ca. zeile 178
 *
 *		UNVERSCHL�SSELT �FFNEN: 					siehe	jBtnUnverschluesselt...(ActionEvent evt) {..}						// ca. zeile 203
 * 
 * 
 * 	PROGRAMM:	Das Programm nutzt die selbstgeschriebenen Klassen (dieses packages) VerschluesseltWriter und VerschluesseltReader (erweiterungen von FilterWriter & FilterReader)
 * 				zur verschl�sselten Speicherung von Text.
 * 	 			GUi, bestehend aus Frame mit JTextPane & 3 Buttons: 
 * 				1. verschl�sselt speichern des texts aus JTextPane, 2. verschl�sselt �ffnen & 3. unverschl�sselt �ffnen
 * 
 */

package uebungen12;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;			// guck themenspeziefischer import !!!
import java.io.File;					// themenspeziefischer import !!!
import java.io.FileReader;				// themenspeziefischer import !!!
import java.io.FileWriter;				// themenspeziefischer import !!!
import java.io.IOException;				// themenspeziefischer import !!!

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


public class IO_VerschluesseltWriter_VerschluesseltReader_Textverschluesselung extends javax.swing.JFrame {
	private JLabel jLEingabe;
	private JTextPane jTextPane;
	private JButton jBtnUnverschluesselt;
	private JButton jBtnVerschluesselt;
	private JButton jBtnSpeichern;
	private JScrollPane jScrollPane1;
	// stringvariable dateiname f�r datei, in der die textdaten beim schliessen  gespeichert werden
		// String dateiname wird initialisiert mit dem relativen pfad zum aktuellen verzeichnis (aus dem auch das programm gestartet wird)
		// "relativer pfad" besteht aus: "." f�r aktuelles verzeichnis + platformunabh�ngiges trennzeichen (File.separator) + dateiname.txt
	private String dateiname = "." + File.separator + "verschluesselt.txt";		// verschluesselt.txt ins .gitignore ums nicht committen zu m�ssen (packageexplorer > datei > re-klick > ignorieren)
		// statt "." -> "./dokumente/" & ein dokumentordner in JavaBuch, dann kann man auch im Package explorer die dateien sehen
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				IO_VerschluesseltWriter_VerschluesseltReader_Textverschluesselung inst = new IO_VerschluesseltWriter_VerschluesseltReader_Textverschluesselung();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public IO_VerschluesseltWriter_VerschluesseltReader_Textverschluesselung() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Textverschl�sselung");
			getContentPane().setLayout(null);			// hahaa layout auf absolute setzen nit vergessen
			{
				jLEingabe = new JLabel();
				getContentPane().add(jLEingabe);
				jLEingabe.setText("Eingabe");
				jLEingabe.setBounds(12, 12, 81, 16);
			}
			{
				jScrollPane1 = new JScrollPane();      // achtung: scrollbalken funktionieren jeweils nur korrekt, wenn man text MIT abst�nden ins jTextPane eingibt, ich l��l 
				getContentPane().add(jScrollPane1);
				jScrollPane1.setBounds(12, 34, 360, 103);
				{	
					jTextPane = new JTextPane();	// jTextPane (siehe componenten) kann mehrzeiligen text als eingabe aufnehmen & somit wie ein einfacher texteditorverwendet werden;
													// .. vergleiche: bei JTextField muss zeilenweise ausgeschrieben werden, bei jTextPane wie bei einfachem texteditor am st�ck     
					jScrollPane1.setViewportView(jTextPane);  		// verkn�pfung setViewportView(..) machts automatisch
					// jTextPane.setBounds(12, 34, 360, 103);	 	// positionierung l�schen: funktioniert genauso ohne, jTextPane f�llt einfach das JScrollPane aus
				}
			}
			{
				jBtnSpeichern = new JButton();
				getContentPane().add(jBtnSpeichern);
				jBtnSpeichern.setText("Speichern");
				jBtnSpeichern.setBounds(12, 155, 128, 23);
				jBtnSpeichern.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnSpeichernActionPerformed(evt);
					}
				});
			}
			{
				jBtnVerschluesselt = new JButton();
				getContentPane().add(jBtnVerschluesselt);
				jBtnVerschluesselt.setText("verschl�sselt �ffnen");
				jBtnVerschluesselt.setBounds(157, 155, 209, 23);
				jBtnVerschluesselt.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnVerschluesseltActionPerformed(evt);
					}
				});
			}
			{
				jBtnUnverschluesselt = new JButton();
				getContentPane().add(jBtnUnverschluesselt);
				jBtnUnverschluesselt.setText("unverschl�sselt �ffnen");
				jBtnUnverschluesselt.setBounds(157, 195, 209, 23);
				jBtnUnverschluesselt.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnUnverschluesseltActionPerformed(evt);
					}
				});
			}
			pack();
			this.setSize(400, 283);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	// methode zum verschl�sselten speichern des textes aus jTextPane in datei mit namen verschluesselt.txt (dateiname mit pfad: siehe auch private variabeln oben)
	private void jBtnSpeichernActionPerformed(ActionEvent evt) {
		VerschluesseltWriter out = null;	// deklarieren eines VerschluesseltWriter.objekts out & initialisieren mit null (ausserhalb von try-catch, damit in ganzer methode brauchbar)
		try {
			out = new VerschluesseltWriter (new FileWriter(dateiname)); // ausgabestream out mit :  VerschluesseltWriter-objekt unter mitgabe & erzeugen von FileWriter-objekt mit dem argument dateiname
																		// .. FileWriter erzeugt real die datei mit dateiname (= verschluesselt.txt inkl. pfad)
			out.write(jTextPane.getText());								// aus-schreiben mit der methode write(String str) von VerschluesseltWriter (= extra dort kreierte methode zum aus-schreiben ganzer strings) 
		} catch (Exception e){
			JOptionPane.showMessageDialog(null, "Fehler beim Speichern!");
		} finally {									// finally => auf jeden fall (auch wenn oben fehler aufgetreten muss stream geschlossen werden)
			if (out != null) {						// falls ausgabestream out nicht gleich null...
				try {								// ... unter verwendung der sichderheitsmechanismen try-catch
					out.close();					// ...stream und damit auch die datei mit .close() schliessen; OHNE OUT.CLOSE() funktionierts nicht !!!
				} catch (IOException e){			// zus�tzlich wird auf fehler beim schliessen selber (des streams) reagiert
					e.printStackTrace();
				}
			}
		}
	}
	
	// methode zum anzeigen des verschl�sselten textes aus der datei verschluesselt.txt (in die oben der text aus jTextPane verschl�sselt eingelesen wurde)
	private void jBtnVerschluesseltActionPerformed(ActionEvent evt) {
		BufferedReader in = null;		// deklarieren eines BufferedReader-objekts in & initialisieren mit null (ausserhalb von try-catch, damit in ganzer methode brauchbar)
		try {
			in = new BufferedReader(new FileReader(dateiname)); // eingabestream in mit :  Bufferedreader-objekt unter mitgabe & erzeugen von FileReader-objekt mit dem argument dateiname (=verschluesselt.txt + pfad) 
			int c;									// zur aufnahme der einzelnen gelesenen unicodezeichen in dezimalschreibweise (entsprechend der read() methode von BufferedReader
			StringBuffer zeile = new StringBuffer();// zur aufnahme der Zeichenfolge wird ein StringBuffer definiert/erzeugt.. (warum zus�tzlicher StringBuffer?: glaub weil er alle einzelnen zeichen zusammenh�ngen will in eine zeile, geeignetstes objekt: ein stringbuffer?!)
			while ((c = in.read()) >= 0) {			// ..& in der schleife zeichen f�r zeichen eingelesen, solange die read-methode c >= 0 liefert, also ein dezimal geschriebenes unicodezeichen, bei streamende liefert die read-methode -1 ..
				zeile.append((char) c);				// ..& die einzelnen zeichen werden ans Stringbufferobjekt angeh�ngt mit der methode: append(char c) von StringBuffer, dezimal geschriebene int c zeichen werden dabei zu char gecastet
			}
			jTextPane.setText(zeile.toString());	// JTextPane kann mit setText() einen String �bernehmen, toString()-methode von StringBuffer macht StringBuffer-objekt zeile zu einem String
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Fehler beim Lesen!");
		} finally {									// finally => auf jeden fall (auch wenn oben fehler aufgetreten muss stream geschlossen werden)
			if (in != null){						// falls eingabestream in nicht gleich null...
				try {								// ... unter verwendung der sichderheitsmechanismen try-catch
					in.close();						// ...stream und damit auch die datei mit .close() schliessen; OHNE IN.CLOSE() funktionierts nicht !!!
				} catch (IOException e) {			// zus�tzlich wird auf fehler beim schliessen selber (des streams) reagiert
					e.printStackTrace();
				}
			}
		}
	}
	
	// methode zum anzeigen & entschl�sseln des textes aus der datei verschluesselt.txt (in die oben der text aus jTextPane verschl�sselt eingelesen wurde)
										// einziger unterschied zur oben (jBtnVerschluesseltA..): VerschluesseltReader (wird zur entschl�sselung benutzt) statt BufferedReader
	private void jBtnUnverschluesseltActionPerformed(ActionEvent evt) {
		VerschluesseltReader in = null;			// deklarieren eines VerschluesseltReader-objekts in & initialisieren mit null (ausserhalb von try-catch, damit in ganzer methode brauchbar)
		try {
			in = new VerschluesseltReader(new FileReader(dateiname)); // eingabestream in mit :  VerschluesseltReader-objekt unter mitgabe & erzeugen von FileReader-objekt mit dem argument dateiname (=verschluesselt.txt + pfad)
			int c;									// zur aufnahme der einzelnen gelesenen unicodezeichen in dezimalschreibweise (entsprechend der, in VerschluesseltReader �berschriebenen, read() methode)
			StringBuffer zeile = new StringBuffer();// zur aufnahme der Zeichenfolge wird ein StringBuffer definiert/erzeugt.. (warum zus�tzlicher StringBuffer?: glaub weil er alle einzelnen zeichen zusammenh�ngen will in eine zeile, geeignetstes objekt: ein stringbuffer?!)
			while((c = in.read()) >= 0 ){			// ..& in der schleife zeichen f�r zeichen eingelesen, solange die read-methode c >= 0 liefert, also ein dezimal geschriebenes unicodezeichen, bei streamende liefert die read-methode -1 ..
				zeile.append((char) c);				// ..& die einzelnen zeichen werden ans Stringbufferobjekt angeh�ngt mit der methode: append(char c) von StringBuffer, dezimal geschriebene int c zeichen werden dabei zu char gecastet
			}
			jTextPane.setText(zeile.toString());	// JTextPane kann mit setText() einen String �bernehmen, toString()-methode von StringBuffer macht StringBuffer-objekt zeile zu einem String
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Fehler beim Lesen!");
		} finally {									// finally => auf jeden fall (auch wenn oben fehler aufgetreten muss stream geschlossen werden)
			if (in != null){						// falls eingabestream in nicht gleich null...
				try {								// ... unter verwendung der sichderheitsmechanismen try-catch
					in.close();						// ...stream und damit auch die datei mit .close() schliessen; OHNE IN.CLOSE() funktionierts nicht !!!
				} catch (IOException e) {			// zus�tzlich wird auf fehler beim schliessen selber (des streams) reagiert
					e.printStackTrace();
				}
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
