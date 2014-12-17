/* TODO 12.3.5.   s.374, (ZeichenOrientierte Datenstreams)		!!!!!!!!!!!!!!!!!!!
 * class IO_VerschluesseltWriter_VerschluesseltReader_Textverschluesselung 
 * 
 * SIEHE AUCH:		FILTERWRITER BASICS:		12.3.3.   FilterWriter_Basics_Methoden_Konstruktor		s.370
 * 					VERSCHLUESSELTWRITER		12.3.3.   VerschluesseltWriter extends FilterWriter		s.370 
 * 					FILTERREADER BASICS:		12.3.4.   FilterReader_Basics_Methoden_Konstruktor		s.372 
 * 					VERSCHLUESSELTREADER:		12.3.4.   VerschluesseltReader extends FilterReader		s.373 
 * 
 * 	IM CODE kommentare fertig & DANN HIER WEITER MACHEN, s.374: frame für textverschlüsselung machen & kommentare schreiben !!!!!
 * 
 * 12.3.5. TEXTDATEIEN VERSCHLÜSSELN & ENTSCHLÜSSELN
 * 
 * TEXTVERSCHLÜSSELUNG VORGEHEN: EVTL.
 * 
 * JTEXTPANE:
 * 
 * IMPORTE:
 * 
 * KERN-CODE: 
 * 
 * 
 * PROGRAMM:	Das Programm nutzt die selbstgeschriebenen Klassen VerschluesseltWriter und VerschluesseltReader (erweiterungen von FilterWriter & FilterReader)
 * 				zur verschlüsselten Speicherung von Text. 
 * 
 * 				GUi, bestehend aus Frame mit JTextPane (anstelle von JTextField) zum aus-schreiben / ein-lesen am stück (statt zeilen-weise, wie bei JTextFiled) 
 * 				& 3 Buttons:
 * 				1. speichern 				=> verschlüsselt aus-schreiben von text, aus jTextPane in verschluesselt.txt datei, mittels:	 			VerschluesseltWriter out
 * 				2. verschlüsselt öffnen 	=> ein-lesen des verschluesselten texts, aus verschluesselt.txt ins jTextPane, mittels:		 				BufferedReader in
 * 				3. unverschlüsselt öffnen	=> entschlüsseltes ein-lesen des verschluesselten texts, aus verschluesselt.txt ins jTextPane, mittels:		VerschluesseltReader in
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
	// stringvariable dateiname für datei, in der die textdaten beim schliessen  gespeichert werden
		// String dateiname wird initialisiert mit dem relativen pfad zum aktuellen verzeichnis (aus dem auch das programm gestartet wird)
		// "relativer pfad" besteht aus: "." für aktuelles verzeichnis + platformunabhängiges trennzeichen (File.separator) + dateiname.txt
	private String dateiname = "." + File.separator + "verschluesselt.txt";		// verschluesselt.txt ins .gitignore ums nicht committen zu müssen (packageexplorer > datei > re-klick > ignorieren)
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
			this.setTitle("Textverschlüsselung");
			getContentPane().setLayout(null);			// hahaa layout auf absolute setzen nit vergessen
			{
				jLEingabe = new JLabel();
				getContentPane().add(jLEingabe);
				jLEingabe.setText("Eingabe");
				jLEingabe.setBounds(12, 12, 81, 16);
			}
			{
				jScrollPane1 = new JScrollPane();      // achtung: scrollbalken funktionieren jeweils nur korrekt, wenn man text MIT abständen ins jTextPane eingibt, ich lööl 
				getContentPane().add(jScrollPane1);
				jScrollPane1.setBounds(12, 34, 360, 103);
				{	
					jTextPane = new JTextPane();	// jTextPane (siehe componenten) kann mehrzeiligen text als eingabe aufnehmen & somit wie ein einfacher texteditorverwendet werden;
													// .. vergleiche: bei JTextField muss zeilenweise ausgeschrieben werden, bei jTextPane wie bei einfachem texteditor am stück     
					jScrollPane1.setViewportView(jTextPane);  		// verknüpfung setViewportView(..) machts automatisch
					// jTextPane.setBounds(12, 34, 360, 103);	 	// positionierung löschen: funktioniert genauso ohne, jTextPane füllt einfach das JScrollPane aus
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
				jBtnVerschluesselt.setText("verschlüsselt öffnen");
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
				jBtnUnverschluesselt.setText("unverschlüsselt öffnen");
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
	
	// methode zum verschlüsselten speichern des textes aus jTextPane in datei mit namen verschluesselt.txt (dateiname mit pfad: siehe auch private variabeln oben)
	private void jBtnSpeichernActionPerformed(ActionEvent evt) {
		VerschluesseltWriter out = null;	// erzeugen eines VerschluesseltWriter.objekts out (ausserhalb von try-catch, damit in ganzer methode brauchbar)
		try {
			out = new VerschluesseltWriter (new FileWriter(dateiname)); // eingabestream für out mit :  VerschluesseltWriter-objekt unter mitgabe & erzeugen von FileWriter-objekt mit dem argument dateiname
																		// .. FileWriter erzeugt real die datei mit dateiname (= verschluesselt.txt inkl. pfad)
			out.write(jTextPane.getText());								// aus-schreiben mit der methode write(String str) von VerschluesseltWriter (= extra dort kreierte methode zum aus-schreiben ganzer strings) 
		} catch (Exception e){
			JOptionPane.showMessageDialog(null, "Fehler beim Speichern!");
		} finally {					// finally => auf jeden fall (auch wenn oben fehler aufgetreten muss stream geschlossen werden)
			if (out != null) {		// falls ausgabestream out nicht gleich null...
				try {				// ... unter verwendung der sichderheitsmechanismen try-catch
					out.close();	// ...stream und damit auch die datei mit .close() schliessen; OHNE OUT.CLOSE() funktionierts nicht !!!
				} catch (IOException e){	// zusätzlich wird auf fehler beim schliessen selber (des streams) reagiert
					e.printStackTrace();
				}
			}
		}
	}
	
	// methode zum anzeigen des verschlüsselten textes aus der datei verschluesselt.txt (in die oben der text aus jTextPane verschlüsselt eingelesen wurde)
	private void jBtnVerschluesseltActionPerformed(ActionEvent evt) {
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(dateiname));
			int c;										// zur aufnahme der einzelnen gelesenen unicodezeichen in dezimalschreibweise (entsprechend der read(int c) methode von BufferedReader
			StringBuffer zeile = new StringBuffer();	// zur aufnahme der Zeichenfolge wird ein StringBuffer definiert/erzeugt.. (warum zusätzlicher StringBuffer?: glaub weil alle einzelnen zeichen zusammenhängen will in eine zeile, geeignetstes objekt: ein stringbuffer?!)
			while ((c = in.read()) >= 0) {				// ..& in der schleife zeichen für zeichen eingelesen, solange die read-methode c >= 0 liefert, also ein dezimal geschriebenes unicodezeichen, bei streamende liefert die read-methode -1 ..
				zeile.append((char) c);					// ..& die einzelnen zeichen werden ans Stringbufferobjekt angehängt mit der methode: append(char c) von StringBuffer, dezimal geschriebene int c zeichen werden dabei zu char gecastet
			}
			jTextPane.setText(zeile.toString());	// JTextPane kann mit setText() einen String übernehmen, toString()-methode von StringBuffer macht StringBuffer-objekt zeile zu einem String
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Fehler beim Lesen!");
		} finally {
			if (in != null){
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	// methode zum anzeigen & entschlüsseln des textes aus der datei verschluesselt.txt (in die oben der text aus jTextPane verschlüsselt eingelesen wurde)
										// einziger unterschied zur oben (jBtnVerschluesseltA..): VerschluesseltReader (wird zur entschlüsselung benutzt) statt BufferedReader
	private void jBtnUnverschluesseltActionPerformed(ActionEvent evt) {
		VerschluesseltReader in = null;	
		try {
			in = new VerschluesseltReader(new FileReader(dateiname));
			int c;
			StringBuffer zeile = new StringBuffer();
			while((c = in.read()) >= 0 ){
				zeile.append((char) c);
			}
			jTextPane.setText(zeile.toString());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Fehler beim Lesen!");
		} finally {
			if (in != null){
				try {
					in.close();
				} catch (IOException e) {
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
