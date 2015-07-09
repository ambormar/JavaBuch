/* TODO 15.1.3.   s.474, verwendet MyDefaultTableModel, Tabelle m. unterschiedlichen Datentypen,	!!!!!!!!!!!!
 * class	JTable_FuerVerschiedenenDatentypen_MydefaultTableModel_Notentabelle		& 		MyDefaultTabelModel
 * 
 * 
 * !!!!!!!!!!!!!!!! ALLES NOCH MACHEN, AUCH ALLE SUCHBEGRIFFE (implements TableModelListener, ListSelectionListener ) !!!!!!!!!!!!!!!!!!!!!!!!!!!
 * 
 * 		K&K: 	Programm Notentabelle
 *			 	Das Programm speichert in einer Tabelle Noten mit Gewichtung und Beschreibung, für die unterschiedliche Datentypen verwendet werden.
 * 				Es verwendet die Klasse MyDefaultTableModel, um aus den Notendaten die Durchschnittsnote zu berechnen.
 */

package uebungen15;
import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.SwingUtilities;

// implements TableModelListener & ListSelectionListener noch kommentieren !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
public class JTable_FuerVerschiedeneDatentypen_MyDefaultTableModel_Notentabelle extends javax.swing.JFrame implements TableModelListener, ListSelectionListener {
	
	// alle komponenten noch machen !!!!!!!!!!!!!!!!
	
	private JScrollPane jScrollPane1;
	private JTable jTableNoten;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JTable_FuerVerschiedeneDatentypen_MyDefaultTableModel_Notentabelle inst = new JTable_FuerVerschiedeneDatentypen_MyDefaultTableModel_Notentabelle();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public JTable_FuerVerschiedeneDatentypen_MyDefaultTableModel_Notentabelle() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			AnchorLayout thisLayout = new AnchorLayout();
			getContentPane().setLayout(thisLayout);
			setTitle("Notentabelle");
			{
				jScrollPane1 = new JScrollPane();
				getContentPane().add(jScrollPane1, new AnchorConstraint(1, 1001, 500, 1, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jScrollPane1.setPreferredSize(new java.awt.Dimension(384, 169));
				{
					MyDefaultTabelModel jTableNotenModel = 
							new MyDefaultTabelModel(new Object[][] { { "Klassenarbeit", new Integer(1), new Double(1.0) }},		// steht für die zellen-objekte, hier: die zellen-objekte der ersten zeile
													new String[] { "Prüfungsart", "Gewichtung", "Note" });						// steht für die titelzeile
					jTableNoten = new JTable();
					jScrollPane1.setViewportView(jTableNoten);
					jTableNoten.setModel(jTableNotenModel);
					// die beiden Listener zu den jeweiligen Models hinzufügen
					jTableNotenModel.addTableModelListener(this);						// noch kommentieren
					jTableNoten.getSelectionModel().addListSelectionListener(this);		// noch kommentieren
				}
			}
			pack();
			setSize(400, 350);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

	@Override	// zwangsläufiges überschreiben der methode valueChanged(..) vom oben implementierten interface ListSelectionListener
	public void valueChanged(ListSelectionEvent e) {
		// Auto-generated method stub
	}

	@Override	// zwangsläufiges überschreiben der methode tableChanged(..) vom oben implementierten interface TableModelListener
	public void tableChanged(TableModelEvent e) {
		// Auto-generated method stub
		
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