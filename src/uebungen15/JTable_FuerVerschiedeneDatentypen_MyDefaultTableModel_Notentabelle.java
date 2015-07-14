/* TODO 15.1.3.   s.474, verwendet MyDefaultTableModel, Tabelle m. unterschiedlichen Datentypen,	!!!!!!!!!!!!
 * class	JTable_FuerVerschiedenenDatentypen_MydefaultTableModel_Notentabelle		& 		MyDefaultTabelModel
 * 
 * 
 * !!!!!!!!!!!!!!!! ALLES NOCH MACHEN, AUCH ALLE SUCHBEGRIFFE (implements TableModelListener, ListSelectionListener ) !!!!!!!!!!!!!!!!!!!!!!!!!!!
 * 
 * 		K&K: 	Programm Notentabelle
 *			 	Das Programm speichert in einer Tabelle Noten mit Gewichtung und Beschreibung, f�r die unterschiedliche Datentypen verwendet werden.
 * 				Es verwendet die Klasse MyDefaultTableModel, um aus den Notendaten die Durchschnittsnote zu berechnen.
 */

package uebungen15;
import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.SwingUtilities;

// implementieren der interfaces TableModelListener & ListSelectionListener in der kopfzeile, um berechnungen + ausgabe der tabellendaten bei jeder ver�nderung und je nach angew�hltem..
// .. bereich anpassen zu k�nnen (unter verwendung der entsprechenden methoden aus MyDefaultTableModel nat�rlich)
public class JTable_FuerVerschiedeneDatentypen_MyDefaultTableModel_Notentabelle extends javax.swing.JFrame implements TableModelListener, ListSelectionListener {
	
	// alle komponenten noch machen !!!!!!!!!!!!!!!!
	
	private JScrollPane jScrollPane1;
	private JLabel jLPruefungsart;
	private JTextField jTFPruefungsart;
	private JButton jBtnNeu;
	private JLabel jLNotenschnitt;
	private JTextField jTFNote;
	private JLabel jLNote;
	private JTextField jTFGewichtung;
	private JLabel jLGewichtung;
	private JTable jTableNoten;
	private DecimalFormat df;

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
				jBtnNeu = new JButton();
				getContentPane().add(jBtnNeu, new AnchorConstraint(856, 907, 930, 483, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jBtnNeu.setText("In Tabelle �bernehmen");
				jBtnNeu.setPreferredSize(new java.awt.Dimension(163, 23));
				jBtnNeu.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnNeuActionPerformed(evt);
					}
				});
			}
			{
				jLNotenschnitt = new JLabel();
				getContentPane().add(jLNotenschnitt, new AnchorConstraint(573, 970, 625, 657, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jLNotenschnitt.setText("Notenschnitt:");
				jLNotenschnitt.setPreferredSize(new java.awt.Dimension(120, 16));
			}
			{
				jTFNote = new JTextField();
				getContentPane().add(jTFNote, new AnchorConstraint(856, 410, 930, 233, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jTFNote.setPreferredSize(new java.awt.Dimension(68, 23));
			}
			{
				jLNote = new JLabel();
				getContentPane().add(jLNote, new AnchorConstraint(866, 157, 918, 32, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jLNote.setText("Note:");
				jLNote.setPreferredSize(new java.awt.Dimension(48, 16));
			}
			{
				jTFGewichtung = new JTextField();
				getContentPane().add(jTFGewichtung, new AnchorConstraint(709, 410, 782, 233, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jTFGewichtung.setPreferredSize(new java.awt.Dimension(68, 23));
			}
			{
				jLGewichtung = new JLabel();
				getContentPane().add(jLGewichtung, new AnchorConstraint(718, 217, 770, 32, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jLGewichtung.setText("Gewichtung:");
				jLGewichtung.setPreferredSize(new java.awt.Dimension(71, 16));
			}
			{
				jTFPruefungsart = new JTextField();
				getContentPane().add(jTFPruefungsart, new AnchorConstraint(564, 579, 638, 233, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jTFPruefungsart.setPreferredSize(new java.awt.Dimension(133, 23));
			}
			{
				jLPruefungsart = new JLabel();
				getContentPane().add(jLPruefungsart, new AnchorConstraint(573, 201, 625, 32, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jLPruefungsart.setText("Note f�r:");
				jLPruefungsart.setPreferredSize(new java.awt.Dimension(65, 16));
			}
			{
				jScrollPane1 = new JScrollPane();										// neues jScrollPane welches dann das jTabel inkl TableModel beinhaltet
				getContentPane().add(jScrollPane1, new AnchorConstraint(1, 1001, 500, 1, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jScrollPane1.setPreferredSize(new java.awt.Dimension(384, 169));		// gr�sse nur f�r's scrollpane setzen, dann passt sich die tabelle, die davon umgeben wird, automatisch an
				{
					MyDefaultTabelModel jTableNotenModel = 								// initialisieren des abgeleiteten MydefaultTableModel mit datensatz (der 1. zeile) & spaltennamen (= titelleiste der tabelle):
							new MyDefaultTabelModel(new Object[][] { { "Klassenarbeit", new Integer(1), new Double(1.0) }},		// .. 2-dim. array(-literal) f�r die zellen-objekte jeder zeile, hier mit: zellen-objekten der ersten zeile, sonst keine weiteren literale, also alle anderen zellen der weiteren zeilen sind leer
													new String[] { "Pr�fungsart", "Gewichtung", "Note" });						// .. (normaler) array f�r die zellendaten (spaltentitel) (columns) der titelzeile
																																// NB: die reihenfolge von 2dim. array / array ist unabh�ngig vom konstruktor, der konstruktor verlangt hier als parameter zuerst alle zellendaten, dann die titelleisten-zellendaten
					jTableNoten = new JTable();											
					jScrollPane1.setViewportView(jTableNoten);
					jTableNoten.setModel(jTableNotenModel);								// TableModel vom typ MyDefaultTableModel f�r das jTable setzen
					jTableNotenModel.addTableModelListener(this);						// TableModelListener f�r das TableModel registrieren: voraussetzung, um auf �nderungen der tabelledaten zu reagieren
					jTableNoten.getSelectionModel().addListSelectionListener(this);		// ListSelectionListener f�r die Tabelle (jTable) selbst registrieren:	voraussetzung um auf das markieren von tabellenZeilen zu reagieren
				}
			}
			pack();
			setSize(400, 350);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	// methode zum hinzuf�gen einer neuen note
	private void jBtnNeuActionPerformed(ActionEvent evt) {
		try {																				// try-catch warscheinlich: f�r den fall, dass die zeile nicht hinzugef�gt werden k�nnte
			String text = jTFPruefungsart.getText();										
			int gewichtung = Integer.parseInt(jTFGewichtung.getText());						
			double note = Double.parseDouble(jTFNote.getText());							
			MyDefaultTabelModel model = (MyDefaultTabelModel)jTableNoten.getModel();		// lokales objekt f�r das model der tabelle (getypcastet zuweisen)
			model.addRow(new Object[] {text, new Integer(gewichtung), new Double(note)});	// via lokales model eine zeile hinzuf�gen mit parammeter object, welches per array-literal die daten �bergibt
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override	// zwangsl�ufiges �berschreiben der methode tableChanged(..) vom oben implementierten interface TableModelListener
				// methode als reaktion auf daten-�nderungen: nutzt die im MydefaultTableModel implementierten methoden zur berechung der durchschnitts-note �ber die gesamte tabelle
	public void tableChanged(TableModelEvent e) {
		MyDefaultTabelModel model = (MyDefaultTabelModel)jTableNoten.getModel();	// lokales objekt f�r das model der tabelle (getypcastet zuweisen)
		double schnitt = model.getNotenGewichtet() / model.getGewichtung();			// schnitt aus getter via model f�r Noten*gewichtung gesamt aller zeilen, geteilt durch: getter via model f�r gewichtung gesamt aller zeilen von MyDefaultTableModel 
		jLNotenschnitt.setText("Notenschnitt: " + df.format(schnitt));				// formatierte ausgabe von schnitt im label mitttels DecimalFormat-objekt df
		//jLSelectedNotenschnitt.setText("");
	}
	
	@Override	// zwangsl�ufiges �berschreiben der methode valueChanged(..) vom oben implementierten interface ListSelectionListener
	public void valueChanged(ListSelectionEvent e) {
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