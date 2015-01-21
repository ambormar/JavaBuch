/* TODO 12.5.   Aufgabe 4, s.394, (In - normal) & (OUT - Textverschlüsselung)
 * class  IO_DateiLadenZeichenweise_BufferedReader_DateiSpeichern_OhneUmlauteWriter_Anchorlayout_TextOhneUmlaute2	(& class OhneUmlauteWriter)
 * 
 * 	VERGLEICHE:		12.5.   In_DateiLaden_MitDateiErweiterung_MitFileChooserAufrufen_Messreihe2					Aufgabe 2, s.393 (Aufg. 1 erweitert)
 * 						=>	jBtnOeffnen..(..)
 * 
 * 	SIEHE AUCH:		12.5.   IO_FilterWriter_OhneUmlautWriter_DateiSpeichern_Anchorlayout_TextOhneUmlaute1		Aufgabe 3, s.394, (OUT - Textverschlüsselung)
 *   		&:		12.5.   OhneUmlauteWriter																	Aufgabe 3, s.394, (OUT - OhneUmlauteWriter extends FilterWriter)
 *  
 * 
 * 	VORGEHEN Aufg. 4: (erweiterung von aufgabe 3)
 * 
 * 		- Button "Dateie öffnen" mit  methode um .txt-datei via filechooser zu öffnen + vorhandenen text ins JTextPane des Frames einzulesen
 *
 *			NEU !!! und speziell beim einlesen: 
 *	
 *			=> der text muss zeichenweise eingelesen werden weil jTextPane nicht zeilenweise abgefüllt werden kann (wie z.b. jListModel)
 *				->so wird jedes zeichen einzeln eingelesen und die zeilenumrüche werden auch mit eingelesen: siehe ab: BufferedReader in 
 *		
 *			CODE:
 *				
 *			private void jBtnOeffnenActionPerformed(ActionEvent evt) {
 *				JFileChooser fc = new JFileChooser();							// ab hier: JFileChooser wie immer
 *				fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
 *				fc.setFileFilter(new FileNameExtensionFilter("Textdateien *txt", "txt"));
 *				fc.setCurrentDirectory(new File("."));
 *				int state = fc.showOpenDialog(null);
 *				if (state == JFileChooser.APPROVE_OPTION) {		
 *					String selFile = fc.getSelectedFile().getAbsolutePath();	// ab hier: dati-endung kontrollieren / ergänzen wie normal
 *					int index = selFile.indexOf(".");
 *					if (index >= 0){
 *						dateiname = selFile.substring(0, index).concat(".txt");
 *					} else {
 *						dateiname = selFile.concat(".txt");
 *					}											
 *					// NEU: zeichenweise einlesen, damit im JTextPane die umbrüche auch dargestellt werden..(im jListModel z.b. ist zeileweise einlesen möglich)		
 *					BufferedReader in = null;
 *					StringBuffer zeile = new StringBuffer();				// StringBuffer zwischenspeicher-zeile 
 *					int c;													// lokale variable c, für unicode-zeichen in dezimaler schreibweise 
 *					try {
 *						in = new BufferedReader(new FileReader(dateiname));	// erzeugen von inputstream für new File mit dateiname (pfad + name)
 *						while ((c = in.read()) >= 0) {						// solange ein unicodezeichen im inputstream gelesen wird [erst bei ((c = in.read() == -1) hats keine zeichen mehr]
 *							zeile.append((char) c);							// werden der stringbuffer-zeile die gecasteten c's angehängt (inklusive den zeilen-umbrüchen !!!)
 *						}
 *							jTextPane1.setText(zeile.toString());				// dann wird zeile, zu string umgewandelt und in JTextPane als text gesetzt
 *					} catch (Exception e){
 *						JOptionPane.showMessageDialog(this, "Fehler beim Laden");
 *					} finally {												// auf jeden fall
 *						if (in != null) {									// sofern stream vorhanden
 *							try {
 *								in.close();									// stream schliessen
 *							} catch (IOException e) {
 *								e.printStackTrace();				
 *							}
 *						}
 *					}
 *				}
 *			}
 * 
 * [[[ VORGEHEN Aufg. 3:	
 * 
 * 				1. Frame mit anchorlayout, 									=> siehe initGUI()
 * 
 * 				2. jScrollpane, darin eingebettet ein jTextPane; 			=> siehe initGUI()
 * 																				-> jscroll-anchorconstraints alle auf relativ 
 * 
 * 				3. jButton zum speichern der datei im projektordner			=> siehe auch initGUI()
 * 																				-> button-anchorconstraints alle auf relativ 
 * 														 
 *					- mit FileChooser-dialog zum speichern der datei
 *					- inklusive kontrolle/ergänzen der datei-endung
 *					- mit ausschreien vom text aus dem jTextPane in die datei.txt..
 *					- ...dabei wird entsprechend der class OhneUmlauteWriter der text verändert ausgeschrieben (umlaute und f's werden abgeändert)
 * 
 *  				dateiname wird als attribut des frames oben schon mal mit namen deklariert, 
 *  					-> wäre hier eigentlich noch nicht nötig, aber hat er wahrscheinlich als vorarbeit die erweiterung in aufg. 4 (datei laden ) gemacht
 *  
 *  				private String dateiname = "." + File.separator + "textohneumlaut.txt";	
 *  
 *					CODE SIEHE:	 jBtnSpeichern..(.) 															]]]		
 *
 *
 * K&K: [Programm TextohneUmlaute1. AUFGABE 3
 * 			Das Programm demonstriert das Ersetzen der Umlaute durch die Nutzung des OhneUmlautWriters. 
 * 			Der Text, der in ein TextPane eingegeben wird, kann in einer Datei ohne die Umlaute gespeichert werden. ]
 * 
 * 		Programm TextohneUmlaute2  AUFGABE 4
 *			wurde so erweitert, dass der Text, aus dem die Umlaute entfernt werden sollen aus einer Textdatei geladen werden kann.
 *
 */

package uebungen12Aufgaben;

import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;

public class IO_DateiLadenZeichenweise_BufferedReader_DateiSpeichern_OhneUmlauteWriter_Anchorlayout_TextOhneUmlaute2 extends javax.swing.JFrame {

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private JScrollPane jScrollPane1;
	private JTextPane jTextPane1;
	private JButton jBtnSpeichern;
	private String dateiname = "." + File.separator + "textohneumlaut.txt";		// dateiname schon mal mit namen deklarieren, hier eigentlich noch nicht wesentlich, aber hat er wahrscheinlich .. 
	private JButton jBtnOeffnen;
																				// .. als vorarbeit die erweiterung in aufg. 4 (datei laden ) gemacht

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				IO_DateiLadenZeichenweise_BufferedReader_DateiSpeichern_OhneUmlauteWriter_Anchorlayout_TextOhneUmlaute2 inst = new IO_DateiLadenZeichenweise_BufferedReader_DateiSpeichern_OhneUmlauteWriter_Anchorlayout_TextOhneUmlaute2();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public IO_DateiLadenZeichenweise_BufferedReader_DateiSpeichern_OhneUmlauteWriter_Anchorlayout_TextOhneUmlaute2() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			AnchorLayout thisLayout = new AnchorLayout();							// zuerst anchorlayout im layout setzen, wie gehabt
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Text ohne Umlaute");
			{
				jBtnOeffnen = new JButton();
				getContentPane().add(jBtnOeffnen, new AnchorConstraint(830, 441, 937, 53, 
														AnchorConstraint.ANCHOR_REL, 
														AnchorConstraint.ANCHOR_REL, 
														AnchorConstraint.ANCHOR_REL, 
														AnchorConstraint.ANCHOR_REL));
				jBtnOeffnen.setText("Datei öffnen");
				jBtnOeffnen.setPreferredSize(new java.awt.Dimension(149, 28));
				jBtnOeffnen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnOeffnenActionPerformed(evt);
					}
				});
			}
			{
				jBtnSpeichern = new JButton();
				getContentPane().add(jBtnSpeichern, new AnchorConstraint(833, 949, 937, 592, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jBtnSpeichern.setText("Speichern");
				jBtnSpeichern.setPreferredSize(new java.awt.Dimension(137, 27));			// prefferedSize machts auch selber, anhand vom sponti reinziehen
				jBtnSpeichern.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnSpeichernActionPerformed(evt);
					}
				});
			}
			{
				jScrollPane1 = new JScrollPane();
				getContentPane().add(jScrollPane1, new AnchorConstraint(78, 949, 772, 53, 	// jScrollPane zuerst macheninkl. anchor-constraints, dann textpane unten nur noch reinziehen
														AnchorConstraint.ANCHOR_REL, 		// alle constraints auf relativ setzen , damit textpane & button relativ wachsenbeim verziehen
														AnchorConstraint.ANCHOR_REL, 
														AnchorConstraint.ANCHOR_REL, 
														AnchorConstraint.ANCHOR_REL));
				jScrollPane1.setPreferredSize(new java.awt.Dimension(360, 189));			// prefferedSize machts auch selber, anhand vom sponti reinziehen
				{
					jTextPane1 = new JTextPane();
					jScrollPane1.setViewportView(jTextPane1);								// ViewPortView machts selber korrekt
				}
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	// methode um .txt-datei mit filechooser zu öffnen + vorhandenen text ins JTextPane des Frames einzulesen
		// NEU und speziell beim einlesen: der text muss zeichenweise eingelesen werden weil jTextPane nicht zeilenweise abgefüllt werden kann ..
		// ... (wie z.b. jListModel), so wird jedes zeichen eingelesen und die zeilenumrüche werden auch mit eingelesen: siehe ab: BufferedReder in 
	private void jBtnOeffnenActionPerformed(ActionEvent evt) {
		JFileChooser fc = new JFileChooser();							// ab hier: JFileChooser wie immer
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fc.setFileFilter(new FileNameExtensionFilter("Textdateien *txt", "txt"));
		fc.setCurrentDirectory(new File("."));
		int state = fc.showOpenDialog(null);
		if (state == JFileChooser.APPROVE_OPTION) {		
			String selFile = fc.getSelectedFile().getAbsolutePath();	// ab hier: dati-endung kontrollieren / ergänzen wie normal
			int index = selFile.indexOf(".");
			if (index >= 0){
				dateiname = selFile.substring(0, index).concat(".txt");
			} else {
				dateiname = selFile.concat(".txt");
			}											
			// NEU: zeichenweise einlesen, damit im JTextPane die umbrüche auch dargestellt werden..(im jListModel z.b. ist zeileweise einlesen möglich)		
			BufferedReader in = null;
			StringBuffer zeile = new StringBuffer();				// StringBuffer zwischenspeicher-zeile 
			int c;													// lokale variable c, für unicode-zeichen in dezimaler schreibweise 
			try {
				in = new BufferedReader(new FileReader(dateiname));	// erzeugen von inputstream für new File mit dateiname (pfad + name)
				while ((c = in.read()) >= 0) {						// solange ein unicodezeichen im inputstream gelesen wird [erst bei ((c = in.read() == -1) hats keine zeichen mehr]
					zeile.append((char) c);							// werden der stringbuffer-zeile die gecasteten c's angehängt (inklusive den zeilen-umbrüchen !!!)
				}
				jTextPane1.setText(zeile.toString());				// dann wird zeile, zu string umgewandelt und in JTextPane als text gesetzt
			} catch (Exception e){
				JOptionPane.showMessageDialog(this, "Fehler beim Laden");
			} finally {												// auf jeden fall
				if (in != null) {									// sofern stream vorhanden
					try {
						in.close();									// stream schliessen
					} catch (IOException e) {
						e.printStackTrace();				
					}
				}
			}
		}
	}
	
	// methode zum speichern des texts aus dem textpane in einer .txt-datei im projektordner; dabei wird entsprechend der class OhneUmlauteWriter der text verändert ausgeschrieben  
	private void jBtnSpeichernActionPerformed(ActionEvent evt) {					
		JFileChooser fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);							// nur files auswählbar
		fc.setFileFilter(new FileNameExtensionFilter("Textdateien *.txt", "txt"));	// mögliche dateiendungen festlegen
		fc.setCurrentDirectory(new File("."));										// ausgangs-datei
		int state = fc.showSaveDialog(null);										// dialog öffnen und status beim klicken von speichern
		if (state == JFileChooser.APPROVE_OPTION) {									// wenn status: "speichern, jaa"
			String selFile = fc.getSelectedFile().getAbsolutePath();				// lokaler string für absoluten namen der im fc ausgewählten  datei
			int index = selFile.indexOf(".");										// lokaler index für allfälligen punkt (=beginn der datei-endung) im dateinamen
			if (index >= 0) {														// wenn punkt vorhanden ist
				dateiname = selFile.substring(0, index).concat(".txt");				// dateiname aus: substring bis vor punkt, zusammengehängen mit .txt-endung
			} else {																// sonst
				dateiname = selFile.concat(".txt");									// ganzer name (des ausgewählten files) zusammenhängen mit .txt-endung
			}
			OhneUmlauteWriter out = null;											// OhneUmlautWriter-objekt (anstelle von BufferedWriter) out initialisieren auf null
			try {
				out = new OhneUmlauteWriter(new FileWriter(dateiname));				// outputstream-file erzeugen mit parameter dateiname
				out.write(jTextPane1.getText());									// ausschreiben string im TextPane 
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Fehler beim Speichern");		// fehlerbehandl. für fehler beim speichern
			} finally {		
				if (out != null) {													// ganze fehlerbehandlung falls fehler beim schliessen selber entsteht
					try {
						out.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
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
