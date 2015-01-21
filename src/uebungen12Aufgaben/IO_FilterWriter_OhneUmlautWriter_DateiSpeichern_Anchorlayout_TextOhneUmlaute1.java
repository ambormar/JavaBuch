/* TODO 12.5.   Aufgabe 3, s.394, (OUT - Textverschlüsselung)
 * class  IO_FilterWriter_OhneUmlautWriter_DateiSpeichern_Anchorlayout_TextOhneUmlaute1	& class OhneUmlauteWriter
 * 
 * 	SIEHE:		12.3.5.   IO_VerschluesseltWriter_VerschluesseltReader_Textverschluesselung			s.374, (Textverschlüsselung) (ZeichenOrientierte Datenstreams)	
 * 
 * 
 * VORGEHEN:	1. Frame mit anchorlayout, 									=> siehe initGUI()
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
 * 					CODE:
 * 
 *  				dateiname wird als attribut des frames oben schon mal mit namen deklariert, 
 *  					-> wäre hier eigentlich noch nicht nötig, aber hat er wahrscheinlich als vorarbeit die erweiterung in aufg. 4 (datei laden ) gemacht
 *  
 *  				private String dateiname = "." + File.separator + "textohneumlaut.txt";	
 *  
 *					private void jBtnSpeichernActionPerformed(ActionEvent evt) {					
 *						JFileChooser fc = new JFileChooser();
 *						fc.setFileSelectionMode(JFileChooser.FILES_ONLY);							// nur files auswählbar
 *						fc.setFileFilter(new FileNameExtensionFilter("Textdateien *.txt", "txt"));	// mögliche dateiendungen festlegen
 *						fc.setCurrentDirectory(new File("."));										// ausgangs-datei
 *						int state = fc.showSaveDialog(null);										// dialog öffnen und status beim klicken von speichern
 *						if (state == JFileChooser.APPROVE_OPTION) {									// wenn status: "speichern, jaa"
 *							String selFile = fc.getSelectedFile().getAbsolutePath();				// lokaler string für absoluten namen der im fc ausgewählten  datei
 *							int index = selFile.indexOf(".");										// lokaler index für allfälligen punkt (=beginn der datei-endung) im dateinamen
 *							if (index >= 0) {														// wenn punkt vorhanden ist
 *								dateiname = selFile.substring(0, index).concat(".txt");				// dateiname aus: substring bis vor punkt, zusammengehängen mit .txt-endung
 *							} else {																// sonst
 *								dateiname = selFile.concat(".txt");									// ganzer name (des ausgewählten files) zusammenhängen mit .txt-endung
 *							}
 *							OhneUmlauteWriter out = null;											// OhneUmlautWriter-objekt (anstelle von BufferedWriter) out initialisieren auf null
 *							try {
 *								out = new OhneUmlauteWriter(new FileWriter(dateiname));				// outputstream-file erzeugen mit parameter dateiname
 *								out.write(jTextPane1.getText());									// ausschreiben string im TextPane 
 *							} catch (Exception e) {
 *								JOptionPane.showMessageDialog(this, "Fehler beim Speichern");		// fehlerbehandl. für fehler beim speichern
 *							} finally {		
 *								if (out != null) {													// ganze fehlerbehandlung falls fehler beim schliessen selber entsteht
 *									try {
 *										out.close();
 *									} catch (IOException e) {
 *										e.printStackTrace();
 *									}
 *								}
 *							}
 *						}
 *					}
 *
 *
 * K&K: Programm TextohneUmlaute1. 
 * 		Das Programm demonstriert das Ersetzen der Umlaute durch die Nutzung des OhneUmlautWriters. 
 * 		Der Text, der in ein TextPane eingegeben wird, kann in einer Datei ohne die Umlaute gespeichert werden. 
 * 
 */

package uebungen12Aufgaben;

import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
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

public class IO_FilterWriter_OhneUmlautWriter_DateiSpeichern_Anchorlayout_TextOhneUmlaute1 extends javax.swing.JFrame {

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
																				// .. als vorarbeit die erweiterung in aufg. 4 (datei laden ) gemacht

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				IO_FilterWriter_OhneUmlautWriter_DateiSpeichern_Anchorlayout_TextOhneUmlaute1 inst = new IO_FilterWriter_OhneUmlautWriter_DateiSpeichern_Anchorlayout_TextOhneUmlaute1();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public IO_FilterWriter_OhneUmlautWriter_DateiSpeichern_Anchorlayout_TextOhneUmlaute1() {
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
			{
				jBtnSpeichern = new JButton();
				getContentPane().add(jBtnSpeichern, new AnchorConstraint(822, 714, 925, 300,// anordnung sponti im jigloo
														AnchorConstraint.ANCHOR_REL, 		// alle constraints auf relativ setzen , damit textpane & button relativ wachsenbeim verziehen
														AnchorConstraint.ANCHOR_REL, 
														AnchorConstraint.ANCHOR_REL, 
														AnchorConstraint.ANCHOR_REL));
				jBtnSpeichern.setText("Speichern");
				jBtnSpeichern.setPreferredSize(new java.awt.Dimension(159, 27));			// prefferedSize machts auch selber, anhand vom sponti reinziehen
				jBtnSpeichern.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnSpeichernActionPerformed(evt);
					}
				});
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
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
