/* TODO 15.1.1.a.   s.464, Tabelle mit konstanter Zellenzahl  		!!!!!!!!!!!!!!!!!!!!!!
 * JTable_Tabelle_MitKonstanterZellenZahl_StundenPlan
 * 		
 * 
 * 			SIEHE:			15.1.		JTable_Basic_Klasse_Komponente_FuerTabellen										s.463	
 * 
 * 			JTABELMODEL METHODEN - BASICS:
 * 				SIEHE:		15.1.1.b.   TableModel_Basics_Klasse_Methoden												s.466 
 * 
 * 			EIN-AUS-LESEN DER TABELLENDATEN:
 * 				SIEHE:		15.1.1.c.	JTable_MitKonstZellenZahl_DatenEinUndAuslesen_StundenPlan2						s.468																							!!!!!!!!!!!!!!!!!!!!!!											
 * 		
 * 			TABELLE MIT VARIABLER ZEILEN- & SPALTEN-ZAHL:
 * 				SIEHE:		15.1.2.		JTable_MitVariablerZeilenSpaltenZahl_DatenEinAusLesen_InDatFile_StundenPlan3	s.470							!!!!!!!!!!!!!!!!!!!!!!!!! 
 * 
 * 			TABELLE MIT UNTERSCHIEDLICHEN DATENTYPEN:
 * 				SIEHE:		15.1.3.		JTable_Tabelle_MitUnterschiedlichenDatenTypen_..								s.474							!!!!!!!!!!!!!!!!!!!!!!!!   
 * 
 * 
 * JTABLE / TABELLE MIT KONSTANTER ZELLENZAHL:
 * 
 * 		K&K:	Programm Stundenplan
 * 					Das Programm demonstriert die Erstellung einer Tabelle mit Spalten- und Zeilenbeschriftung.
 * 					Es wird eine Tabelle zur Erstellung eines Stundenplans erstellt.
 * 					Die Zellen sind bereits editierbar, so dass der Stundenplan ausgefüllt werden kann.
 * 
 * 	
 * 		VORGEHEN:
 * 
 * 			Programm StundenPlan:
 * 
 * 				=> JFrame erzeugen & Layout:	in diesm bsp. Borderlayout lassen		
 * 
 * 				=> JScrollPane ins Frame ziehen			W I C H T I G  
 * 					-> WICHTIG: damit die spalten-überschrift (columns) überhaupt angezeigt wird. 		-> grund unklar;	aber ScrollPane ist bei Tabellen eh meist sinnvoll
 * 					-> falls jSctrollPane nachträglich hinzugefügt wird:				-> jSctrollPane ins Frame ziehen & in der outline jTable ins JScrollPane hineinziehen
 * 
 * 				=> JTable ins JScrollPane ziehen
 * 
 * 				=> im initGUI() wird ein JTabel & TabelModel erstellt: 
 * 					-> 1. TABLEMODEL für die Datenerhaltung (= Anzeige + bearbeiten der daten) (jigloo-erzeugt)
 * 							-> es wird als new DefaultTabelModel* mit 2 STRING-ARRAYS im konstruktor erzeugt:		-> * kann mit daten umgehen die als Array, ArrayList oder Vector vorliegen	
 * 
 * 								-> 2-DIM. String-Array für die:		 ZEILEN-daten (rows)			-> im code wie gewünscht anpassen		-> schema: new String[][] { {"1"}, {"2"} }
 * 																																			-> jede Klammer in der Klammer steht für eine neue zeile
 * 								
 * 								-> 1-dim. String-Array für die:		 SPALTEN-daten (columns)		-> im code wie gewünscht anpassen 		-> new String[] { "Montag", "Dienstag" }
 * 
 * 					-> 2. JTABLE für die OPTISCHE DARSTELLUNG der daten		(auch jigloo-erzeugt)	-> inkl.:		jTable1.setModel(jTable1Model);
 * 													

 * 					
 * 
 *					{
 *						jScrollPane1 = new JScrollPane();							// nötig damit die spalten-überschrift überhaupt angezeigt wird. jSctrollPane ins Frame ziehen & in der outline jTable..
 *						getContentPane().add(jScrollPane1, BorderLayout.CENTER);	// .. ins JScrollPane hineinziehen (wenn nachträglich) sonst : JScrollPane ins Frame & dann JTable aufs JScrollPane ziehen
 *						{
 *							TableModel jTable1Model = 								// GETRENNT: 	1. für Datenerhaltung (anzeige + bearbeiten der daten): jTableModel															
 *																					// TabelModel wird als DefaultTabelModel erzeugt: 	-> kann mit Vector-, Array- und ArrayList-daten umgehen..
 *									new DefaultTableModel(							// dem konstruktor werden 2 Arrays übergeben, die dabei auch gleich erzeugt werden..			
 *											new String[][] { {"1"}, {"2"}, .. },	// .. ein zweidim. array(-literal) für die zellendaten jeder zeile (rows)
 *											new String[] { "Stunde", "Montag" });	// .. ein (normaler) array für die zellendaten (spaltentitel) (columns) der tiltelzeile 
 *							jTable1 = new JTable();									// 2. für optische Darstellung der daten:	JTable wird erzeugt
 *							jScrollPane1.setViewportView(jTable1);					// macht glaub, dass die JScrollPane jTable1 vollständig aufnimmt/umfasst, auch wenn JScrollPane kleiner/woanders wäre als jTable1
 *							jTable1.setModel(jTable1Model);							// das TableModel wird an die Tabelle (jTabel1) übergeben
 *						}
 *					}
 *						
 * 
 * 
 * 	TABLEMODEL KLASSE / METHODEN:	
 * 				
 * 				=> SIEHE:		 15.1.1.b.   	TableModel_Basics_Klasse_Methoden			s.466, 
 * 
 * 
 * 	ABSTRACTTABLEMODEL (s. 465, oben):	
 * 
 * 				=> Klasse AbstractTabelModel 	-> zur ableitung von TableNModels / Modellen, die an eigene spezielle Anforderungen angepasst sind		 
 * 		
 * 				=> SIEHE AUCH:			15.1.1.b.   TableModel_Basics_Klasse_Methoden		s.466, 
 * 
 * 
 */

package uebungen15;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.SwingUtilities;


public class JTable_Tabelle_MitKonstanterZellenZahl_StundenPlan extends javax.swing.JFrame {
	private JTable jTable1;
	private JScrollPane jScrollPane1;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JTable_Tabelle_MitKonstanterZellenZahl_StundenPlan inst = new JTable_Tabelle_MitKonstanterZellenZahl_StundenPlan();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public JTable_Tabelle_MitKonstanterZellenZahl_StundenPlan() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			BorderLayout thisLayout = new BorderLayout();				// ACHTUNG borderlayout hier (nicht anchor & nicht absolute) für Tabelle (weiss nicht ob immer besser ????
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jScrollPane1 = new JScrollPane();						// nötig damit die spalten-überschrift überhaupt angezeigt wird. jSctrollPane ins Frame ziehen & in der outline jTable..
				getContentPane().add(jScrollPane1, BorderLayout.CENTER);// .. ins JScrollPane hineinziehen (wenn nachträglich) sonst : JScrollPane ins Frame & dann JTable aufs JScrollPane ziehen
				{
					TableModel jTable1Model = 							// GETRENNT: 	1. für Datenerhaltung (anzeige + bearbeiten der daten): jTableModel															
																		// TabelModel wird als DefaultTabelModel erzeugt: 	-> kann mit Vector-, Array- und ArrayList-daten umgehen..
							new DefaultTableModel(						// dem konstruktor werden 2 Arrays übergeben, die dabei auch gleich erzeugt werden..			
									new String[][] { {"1"}, {"2"}, {"3"}, {"4"}, {"5"}, {"6"}, {"7"}, {"8"}, {"9"}, {"10"} },		// .. ein zweidim. array(-literal) für die zellendaten jeder zeile (rows)
									new String[] { "Stunden", "Dienstag", "Mittwoch", "Donnerstag", "Freitag" });					// .. ein (normaler) array für die zellendaten (spaltentitel) (columns) der tiltelzeile 
					jTable1 = new JTable();								// 2. für optische Darstellung der daten:	JTable wird erzeugt
					jScrollPane1.setViewportView(jTable1);				// macht glaub, dass die JScrollPane jTable1 vollständig aufnimmt/umfasst, auch wenn JScrollPane kleiner/woanders wäre als jTable1
					jTable1.setModel(jTable1Model);						// das TableModel wird an die Tabelle (jTabel1) übergeben
				}
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
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