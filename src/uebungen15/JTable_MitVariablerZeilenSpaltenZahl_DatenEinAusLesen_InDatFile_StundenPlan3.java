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
 * 		K&K:	Programm Stundenplan3		(erweiterte / abge�nderte version von stundenplan2)
 * 					Das Programm speichert den eingegebenen Stundenplan beim Beenden des Programms in der Datei stundenplan3.dat.
 * 					Beim Programmstart wird gepr�ft, ob eine Stundenplandatei existiert. Ist dies der Fall, werden die Stundenplandaten in die Tabelle eingelesen.
 * 
 * 					Es k�nnen zus�tzlich eine Spalte f�r den Samstag und zus�tzliche Zeilen f�r mehr Stunden pro Tag angelegt werden.
 * 						-> die titelzeile enthalt beim start des frames spalten f�r stunden & mo - fr
 * 						-> ansonsten soll stundenplan3 mit einer leeren tabelle starten:					( -> arrayliteral f�r Datenstring-array im jTable1 leeren )
 * 						-> der anwender kann mittels button eine neue spalte f�r "samstag" erstellen		-> jBtnSamstag
 * 						-> der anwender kann mittels button beliebig viele neue zeilen erstellen			-> jBtnNeueZeile
 * 
 * 
 * 		VORGEHEN:
 * 
 */

package uebungen15;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
	private JButton jBtnNeueZeile;												// button f�r zus�tzliche zeilen in der tabelle
	private JButton jBtnSamstag;												// button um spalte f�r samstag hinzuzuf�gen
	private String dateiname = "." + File.separator + "stundenplan3.dat";		// String-variable f�r den dateinamen, f�r das .dat-file, wo die daten aus-&ein-gelesen werden
	

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
				jBtnNeueZeile.setText("Zeile hinzuf�gen");
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
				jBtnSamstag.setText("Samstag erg�nzen");
				jBtnSamstag.setPreferredSize(new java.awt.Dimension(200, 23));
				jBtnSamstag.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnSamstagActionPerformed(evt);
					}
				});
			}
			{
				jScrollPane1 = new JScrollPane();																							// n�tig damit die spalten-�berschrift �berhaupt angezeigt wird. jSctrollPane ins Frame ziehen & in der outline jTable..
				getContentPane().add(jScrollPane1, new AnchorConstraint(1, 1001, 833, 1, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL)); // .. ins JScrollPane hineinziehen (wenn nachtr�glich) sonst : JScrollPane ins Frame & dann JTable aufs JScrollPane ziehen
				jScrollPane1.setPreferredSize(new java.awt.Dimension(472, 403));
				{
					TableModel jTable1Model = 																								// GETRENNT: 	1. f�r Datenerhaltung (anzeige + bearbeiten der daten): jTableModel															
																																			// TabelModel wird als DefaultTabelModel erzeugt: 	-> kann mit Vector-, Array- und ArrayList-daten umgehen..
							new DefaultTableModel(																							// dem konstruktor werden 2 Arrays �bergeben, die dabei auch gleich erzeugt werden..
									new String[][] { },		// damit die tabelle beim programmstart keine datenzeilen enth�lt: array-literal f�r das datenstring-array leeren	// .. ein zweidim. array f�r die zeilendaten (rows)
									new String[] { "Stunde", "Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag" });					// .. ein (normaler) array f�r die spaltendaten (columns)
					jTable1 = new JTable();																									// 2. f�r optische Darstellung der daten:	JTable wird erzeugt
					jScrollPane1.setViewportView(jTable1);																					// macht glaub, dass die JScrollPane jTable1 vollst�ndig aufnimmt/umfasst, auch wenn JScrollPane kleiner/woanders w�re als jTable1
					jTable1.setModel(jTable1Model);																							// das TableModel wird an die Tabelle (jTabel1) �bergeben
				}
			}
			pack();
			this.setSize(488, 523);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	// WindowListener handler method f�r auslesen der daten aus dem JTableModel der tabelle (jTable) in ein .dat-file	(remember: jTable ist nur f�r optik; daten ein- & auslesen �ber's JTableModel)
	private void thisWindowClosed(WindowEvent evt) {
		
	}

	// button-handler-method zum hinzuf�gen von zeilen in der tabelle (inkl. eintrag der stunde in der ersten zelle)
	private void jBtnNeueZeileActionPerformed(ActionEvent evt) {		
		int neueZeilenZahl = jTable1.getModel().getRowCount() + 1;			// ermitteln des stunden-eintrags in der ersten zelle: via jTable model erfragen, zeilenzahl erfragen + 1 mehr f�r n�chste zeile
		DefaultTableModel model = (DefaultTableModel) jTable1.getModel();	// TableModel via jTable1.getModel() hat keine methode addRow(..), DefaultTableModel schon -> desshalb das model von jTable1 typcasten + einem lokalen variabel-objekt model vom typ DefaultTableModel zuweisen
		model.addRow(new String[]{ String.valueOf(neueZeilenZahl) });		// dem DefaultTableModel-objekt model mit addRow(..) eine zeile hinzuf�gen & als tabelleneintr�ge ein neu erzeugtes String-array inkl. dem element stunden-eintrag in der ersten spalte
	}

	// button-handler-method zum hinzuf�gen einer spalte samstag in der tabelle
	private void jBtnSamstagActionPerformed(ActionEvent evt) {						
		((DefaultTableModel) jTable1.getModel()).addColumn(new String("Samstag"));	// via jTable1 das lokale TableModel erfragen & typcasten in einer einzigen anweisung & addColumn mit einem neuen string-eintrag samstag (als zus�tzlicher spalten-titel) 
		jBtnSamstag.setEnabled(false);												// button deaktivieren (damit man ihn nur einmal hinzuf�gen kann)
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