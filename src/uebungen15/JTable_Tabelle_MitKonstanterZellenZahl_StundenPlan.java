/* TODO 15.1.1.a   s.464, ???????????????
 * JTable_Tabelle_MitKonstanterZellenZahl_StundenPlan
 * 		
 * !!!!!!!!!!!!!!!!!		HIER WEITERMACHEN	!!!!!!!!!   ALLES KOMMENTIEREN FÜR JTABLE	&  15.1.1.b machen für einlesen & auslesen der TabelleDaten  ab s.467 im buch
 * 																							evtl. 15.1.1.c für METHODEN VON TABLEMODEL ETC.
 * 
 * 
 * 			SIEHE:		15.1.		JTable_Basic_Klasse_Komponente_FuerTabellen					s.463												
 * 		
 * 			TABELLE MIT VARIABLER ZEILEN- & SPALTEN-ZAHL:
 * 			SIEHE:		15.1.2.		JTable_Tabelle_MitVariablerZeilenUndSpaltenZahl_..			s.470												!!!!!!!!!!!!!!!!!!!!!!!!! 
 * 
 * 			TABELLE MIT UNTERSCHIEDLICHEN DATENTYPEN:
 * 			SIEHE:		15.1.3.		JTable_Tabelle_MitUnterschiedlichenDatenTypen_..			s.474												!!!!!!!!!!!!!!!!!!!!!!!!!   
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
 * 				=> JFrame erzeugen & Layout:	Borderlayout lassen		-> NICHT auf anchor oder absolute umstellen (weiss nicht ob das wirklich wichtig ist oder ob's anders auch geht) ?????	
 * 
 * 				=> JScrollPane ins Frame ziehen
 * 					-> nötig damit die spalten-überschrift (columns) überhaupt angezeigt wird. 		-> grund unklar;	aber ScrollPane ist bei Tabellen eh meist sinnvoll
 * 					-> falls jSctrollPane nachträglich hinzugefügt wird:		-> jSctrollPane ins Frame ziehen & in der outline jTable ins JScrollPane hineinziehen 
 * 					
 * 				=> JTable ins JScrollPane ziehen
 * 
 * 
 * 	TABLEMODEL:	
 * 				=> 
 * 
 * 
 * 
 * 	ABSTRACTTABLEMODEL (s. 465, oben):	
 * 
 * 				=> 
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
									new String[][] { {"1"}, {"2"}, {"3"}, {"4"}, {"5"}, {"6"}, {"7"}, {"8"}, {"9"}, {"10"} },			// .. ein zweidim. array für die zeilendaten (rows)
									new String[] { "Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag", "Samstag", "Sonntag" });	// .. ein (normaler) array für die spaltendaten (columns)
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