/* TODO 15.1.2.   s.470, Tabelle m. variabler Zeilen- & Spalten-zahl, Daten ein-auslesen in .dat-File 		!!!!!!!!!!!!!!!!!!!!!!
 * JTable_MitVariablerZeilenSpaltenZahl_DatenEinAusLesen_InDatFile_StundenPlan3
 * 		
 * 
 * 			SIEHE:			15.1.		JTable_Basic_Klasse_Komponente_FuerTabellen					s.463	
 * 
 * 			TABELLE MIT KONSTANTER ZELLEN-ZAHL (JTable):
 * 				SIEHE:		15.1.1.a.	JTable_Tabelle_MitKonstanterZellenZahl_StundenPlan			s.463																
 * 		
 * 			JTABELMODEL METHODEN - BASICS:
 * 				SIEHE:		15.1.1.b.   TableModel_Basics_Klasse_Methoden							s.466
 * 
 * 			TABELLE MIT KONSTANTER ZELLEN-ZAHL & EIN-AUS-LESEN DER TABELLENDATEN:
 * 				SIEHE:		15.1.1.c.	JTable_MitKonstZellenZahl_DatenEinUndAuslesen_StundenPlan2	s.468
 * 
 * 			TABELLE MIT UNTERSCHIEDLICHEN DATENTYPEN:
 * 				SIEHE:		15.1.3.		JTable_Tabelle_MitUnterschiedlichenDatenTypen_..			s.474							!!!!!!!!!!!!!!!!!!!!!!!!   
 * 
 * 
 * 	JTABLE / TABELLE MIT VARIABLER ZEILEN- & SPALTEN-ZAHL:
 * 
 * 		K&K:	Programm Stundenplan3		(erweiterte / abgeänderte version von stundenplan2)
 * 					Das Programm speichert den eingegebenen Stundenplan beim Beenden des Programms in der Datei stundenplan3.dat.
 * 					Beim Programmstart wird geprüft, ob eine Stundenplandatei existiert. Ist dies der Fall, werden die Stundenplandaten in die Tabelle eingelesen.
 * 
 * 					Es können zusätzlich eine Spalte für den Samstag und zusätzliche Zeilen für mehr Stunden pro Tag angelegt werden.
 * 						-> die titelzeile enthalt beim start des frames spalten für stunden & mo - fr
 * 						-> ansonsten soll stundenplan3 mit einer leeren tabelle starten:					( -> arrayliteral für Datenstring-array im jTable1 leeren )
 * 						-> der anwender kann mittels button eine neue spalte für "samstag" erstellen		-> jBtnSamstag
 * 						-> der anwender kann mittels button beliebig viele neue zeilen erstellen			-> jBtnNeueZeile
 * 
 * 
 * 		VORGEHEN:
 * 
 */

package uebungen15;
import java.io.File;
import javax.swing.JButton;

import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.SwingUtilities;


public class JTable_MitVariablerZeilenSpaltenZahl_DatenEinAusLesen_InDatFile_StundenPlan3 extends javax.swing.JFrame {
	private JScrollPane jScrollPane1;
	private JTable jTable1;
	private String dateiname = "." + File.separator + "stundenplan3.dat";		// String-variable für den dateinamen, für das .dat-file, wo die daten aus-&ein-gelesen werden
	private JButton jBtnNeueZeile;
	private JButton jBtnSamstag;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JTable_MitVariablerZeilenSpaltenZahl_DatenEinAusLesen_InDatFile_StundenPlan3 inst = new JTable_MitVariablerZeilenSpaltenZahl_DatenEinAusLesen_InDatFile_StundenPlan3();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public JTable_MitVariablerZeilenSpaltenZahl_DatenEinAusLesen_InDatFile_StundenPlan3() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			AnchorLayout thisLayout = new AnchorLayout();
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			setTitle("Stundenplan 3");
			this.addWindowListener(new WindowAdapter() {
				public void windowClosed(WindowEvent evt) {
					thisWindowClosed(evt);
				}
			});
			{
				jBtnNeueZeile = new JButton();
				getContentPane().add(jBtnNeueZeile, new AnchorConstraint(886, 958, 964, 530, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jBtnNeueZeile.setText("Zeile hinzufügen");
				jBtnNeueZeile.setPreferredSize(new java.awt.Dimension(202, 23));
				jBtnNeueZeile.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnNeueZeileActionPerformed(evt);
					}
				});
			}
			{
				jBtnSamstag = new JButton();
				getContentPane().add(jBtnSamstag, new AnchorConstraint(886, 460, 964, 37, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jBtnSamstag.setText("Samstag ergänzen");
				jBtnSamstag.setPreferredSize(new java.awt.Dimension(200, 23));
				jBtnSamstag.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnSamstagActionPerformed(evt);
					}
				});
			}
			{
				jScrollPane1 = new JScrollPane();
				getContentPane().add(jScrollPane1, new AnchorConstraint(1, 1001, 839, 1, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jScrollPane1.setPreferredSize(new java.awt.Dimension(472, 248));
				{
					TableModel jTable1Model = 
							new DefaultTableModel(
									new String[][] { },							// damit die tabelle beim programmstart keine datenzeilen enthält: array-literal für das datenstring-array leeren	
									new String[] { "Stunde", "Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag" });	// .. ein (normaler) array für die spaltendaten (columns)
					jTable1 = new JTable();
					jScrollPane1.setViewportView(jTable1);
					jTable1.setModel(jTable1Model);
					jTable1.setPreferredSize(new java.awt.Dimension(206, 32));
				}
			}
			pack();
			this.setSize(488, 335);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private void thisWindowClosed(WindowEvent evt) {

	}
	
	private void jBtnSamstagActionPerformed(ActionEvent evt) {

	}
	
	private void jBtnNeueZeileActionPerformed(ActionEvent evt) {

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