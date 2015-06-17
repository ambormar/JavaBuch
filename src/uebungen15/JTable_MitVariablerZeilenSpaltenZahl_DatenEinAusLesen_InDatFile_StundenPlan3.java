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
 * 		VORGEHEN:	!!!!!!! NOCH MACHEN ALLES !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * 
 */

package uebungen15;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
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
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.SwingUtilities;


public class JTable_MitVariablerZeilenSpaltenZahl_DatenEinAusLesen_InDatFile_StundenPlan3 extends javax.swing.JFrame {
	private JScrollPane jScrollPane1;
	private JTable jTable1;
	private JButton jBtnNeueZeile;												// button f�r zus�tzliche zeilen in der tabelle
	private JButton jBtnSamstag;												// button um spalte f�r samstag hinzuzuf�gen
	private JButton jBtnOhneSamstag;											// button um spalte f�r samstag zu entfernen
	private JButton jBtnZeileLoeschen;										 	// button um letzte zeile der tabelle zu entfernen
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
			this.addWindowListener(new WindowAdapter() {																				// WindowListener f�r wenn frame geschlossen wird, um tabellendaten in .dat-file auszulesen
				public void windowClosed(WindowEvent evt) {
					thisWindowClosed(evt);
				}
			});
			{
				jBtnNeueZeile = new JButton();										// button um zeile hinzuzuf�gen
				getContentPane().add(jBtnNeueZeile, new AnchorConstraint(858, 954, 903, 532, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jBtnNeueZeile.setText("Zeile hinzuf�gen");
				jBtnNeueZeile.setPreferredSize(new java.awt.Dimension(195, 23));
				jBtnNeueZeile.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnNeueZeileActionPerformed(evt);
					}
				});
			}
			{
				jBtnZeileLoeschen = new JButton();									// button um letzte zeile zu l�schen 
				getContentPane().add(jBtnZeileLoeschen, new AnchorConstraint(930, 954, 978, 532, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jBtnZeileLoeschen.setText("Letzet Zeile L�schen");
				jBtnZeileLoeschen.setPreferredSize(new java.awt.Dimension(195, 23));
				jBtnZeileLoeschen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnZeileLoeschenActionPerformed(evt);
					}
				});
			}
			{
				jBtnSamstag = new JButton();										// button um spalte samstag hinzuzuf�gen
				getContentPane().add(jBtnSamstag, new AnchorConstraint(854, 469, 908, 56, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jBtnSamstag.setText("Mit Samstag");
				jBtnSamstag.setPreferredSize(new java.awt.Dimension(195, 23));
				jBtnSamstag.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnSamstagActionPerformed(evt);
					}
				});
			}
			{
				jBtnOhneSamstag = new JButton();									// button um spalte samstag zu l�schen
				getContentPane().add(jBtnOhneSamstag, new AnchorConstraint(930, 469, 978, 56, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jBtnOhneSamstag.setText("Ohne Samstag");
				jBtnOhneSamstag.setEnabled(false);
				jBtnOhneSamstag.setPreferredSize(new java.awt.Dimension(195, 23));
				jBtnOhneSamstag.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnOhneSamstagActionPerformed(evt);
					}
				});
			}
			
			{
				jScrollPane1 = new JScrollPane();																						// n�tig damit die spalten-�berschrift �berhaupt angezeigt wird. jSctrollPane ins Frame ziehen & in der outline jTable..
				getContentPane().add(jScrollPane1, new AnchorConstraint(1, 1001, 833, 1, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL)); // .. ins JScrollPane hineinziehen (wenn nachtr�glich) sonst : JScrollPane ins Frame & dann JTable aufs JScrollPane ziehen
				jScrollPane1.setPreferredSize(new java.awt.Dimension(472, 403));
				{
					TableModel jTable1Model = 																							// GETRENNT: 	1. f�r Datenerhaltung (anzeige + bearbeiten der daten): jTableModel															
																																		// TabelModel wird als DefaultTabelModel erzeugt: 	-> kann mit Vector-, Array- und ArrayList-daten umgehen..
							new DefaultTableModel(																						// dem konstruktor werden 2 Arrays �bergeben, die dabei auch gleich erzeugt werden..
									new String[][] { },		// damit die tabelle beim programmstart keine datenzeilen enth�lt: array-literal f�r das datenstring-array leeren	// .. ein zweidim. array f�r die zeilendaten (rows)
									new String[] { "Stunde", "Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag" });				// .. ein (normaler) array f�r die spaltendaten (columns)
					jTable1 = new JTable();																								// 2. f�r optische Darstellung der daten:	JTable wird erzeugt
					jScrollPane1.setViewportView(jTable1);																				// macht glaub, dass die JScrollPane jTable1 vollst�ndig aufnimmt/umfasst, auch wenn JScrollPane kleiner/woanders w�re als jTable1
					jTable1.setModel(jTable1Model);																						// das TableModel wird an die Tabelle (jTabel1) �bergeben
				}
			}
			{
				BufferedReader in = null;																								// inputstream-objekt mit null initialisieren
				File datei = new File(dateiname);																						// vergleichsfile erzeugen mit namen dateiname
				if (!datei.exists()) {																									// wenn kein file mit namen dateiname vorliegt..
					datei.createNewFile();																								// .. eine solche erzeugen
				} else {																												// falls es schon eine datei mit dateinamen hat: ..(einlesen)
					try {
						String eintrag;																									// lokale String-variable f�r die eintr�ge
						in = new BufferedReader(new FileReader(dateiname));																// eingabestream "in":  BufferedReader-objekt unter mitgabe & erzeugen von FileReader-objekt mit dem argument dateiname 		
						eintrag = in.readLine();								// der lokalen String-variablen eintrag den jeweiligen wert der aktuellen zeile (im file) zuweisen
						int zeilen = Integer.parseInt(eintrag);					// lokale variable f�r die (variable) anzahl zeilen (die neu vor den eigentlichen daten im .dat-file gespeichert ist
						eintrag = in.readLine();								// der lokalen String-variablen eintrag den jeweiligen wert der aktuellen zeile (im file) zuweisen	
						int spalten = Integer.parseInt(eintrag);				// lokale variable f�r die (variable) anzahl spalten (die neu vor den eigentlichen daten im .dat-file gespeichert ist
						DefaultTableModel model = new DefaultTableModel();		// neues DefaultTabelModel-objekt ..
						model = (DefaultTableModel) jTable1.getModel();			// .. mit zuweisen des (zu DefaultTableModel) getypcastete TableModels von jTable1 (typcast n�tig, weil nur DefaultTableModel ein addColumn(..) mit Titel-String-�bergabe hat & TableModel nicht, glaub)  
						if (spalten == 7) {										// wenn 7 spalten (spalten-titel: stunden + mo-sa)
							model.addColumn(new String("Samstag"));				// spalte hinzuf�gen via DefaultTableModel-objekt 
							jBtnSamstag.setEnabled(false);						// button samstag deaktivieren
							jBtnOhneSamstag.setEnabled(true);					// button Ohne samstag aktivieren
						}
						for (int i = 0; i < zeilen; i++) {						// schleife: alle zeilen durchgehen (ab index 0, titelzeile wird vom TableModel ignoriert), auf's TableModel zugreifen via jTable1.getModel(), da nur jTable1 bei den globalen eigenschaften des frames erstellt ist, variable mit eingelesenem zeilen-wert f�r anzahl zeilen
							model.addRow(new String[] { String.valueOf(i + 1) });	// .. alle zeilen hinzuf�gen mit jeweils einem String-array (pro zeile) und dem jeweiligen (i + 1) stunden-eintrag in der ersten zelle
							for (int j = 1; j < spalten; j++){					// schleife: alle spalten durchgehen (ab index 1, um absichtlich die erste spalte zu ignorieren), variable mit eingelesenem spalten-wert f�r anzahl spalten
								eintrag = in.readLine();						// der lokalen String-variablen eintrag den jeweiligen wert der aktuellen zeile (im file) zuweisen..
								jTable1.getModel().setValueAt(eintrag, i, j);	// via jTable1 auf's TableModel zugreifen + mit setValueAt(i,j) jeden eintrag (wert) in die jeweilige zelle schreiben
							}
						}
					} catch (Exception e) {																								// falls es fehler gibt beim file einlesen / file erzeugen
						e.printStackTrace();
					} finally {																											// finally => auf jeden fall (auch wenn oben fehler aufgetreten sind wird stream geschlossen)
						if (in != null)	{																								// wenn in NICHT null ist, also wirklich ein bufferedWriter-objekt erzeugt wurde (wenn in null w�re, ist close() �berfl�ssig!!)
							try {
								in.close();																								// schliessen des streams mit close() auch bei fehlern/ evtl. gebufferte eintr�ge werden fertig ausgeschrieben
							} catch (IOException e) {																					// zus�tzlich wird auf fehler beim schliessen selber (des streams) reagiert
								e.printStackTrace();
							}
						}
					}
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
		BufferedWriter out = null;																											// BufferedWriter-Objekt out wird erzeugen und  mit null initialisieren
		try {
			out = new BufferedWriter(new FileWriter(dateiname));																			// remember: mit FileWriter wird anscheinend (?) real auf dem datentr�ger eine datei mit dateiname erzeugt
			out.write(String.valueOf(jTable1.getModel().getRowCount()));			// anzahl zeilen ausschreiben ins .dat-file, als erste zeile der daten 
			out.newLine();															// zeilenumbruch im .dat-file 
			out.write(String.valueOf(jTable1.getModel().getColumnCount()));			// anzahl spalten ausschreiben als zweite zeile der daten im .dat-file 
			out.newLine();															// zeilenumbruch im .dat-file
			for (int i= 0; i < jTable1.getModel().getRowCount();	i++) {																	// schleife: alle zeilen durchgehen (ab index 0, titelzeile wird vom TableModel ignoriert), auf's TableModel zugreifen via jTable1.getModel(), da nur jTable1 bei den globalen eigenschaften des frames erstellt ist, .getRowCount() f�r anzahl zeilen
				for (int j = 1; j < jTable1.getModel().getColumnCount(); j++ ) {															// schleife: alle spalten durchgehen (ab index 1, um absichtlich die erste spalte zu ignorieren), .getColumnCount() f�r anzahl spalten
					if (jTable1.getModel().getValueAt(i, j) != null) {																		// wenn der betreffende zellenwert nicht null ist ..
						out.write(jTable1.getModel().getValueAt(i, j).toString());															// ..ausschreiben der objekte mit zugriff aufs TableModel & mit .getValueAt(i,j) auf die zellenwerte, werte ..
					} else {																												// ..sind immer von typ Object, darum toString() um in eine textdatei zu speichern (jede von Object abgeleitete klasse besitzt toString())
						out.write("");																										// .. sonst leeren string ausschreiben
					} 
					out.newLine();																											// .. + nach jedem wert einen zeilenumbruch schreiben
				}
			}
		} catch (Exception e) {																												// falls es fehler gibt beim file ausschreiben / file erzeugen
			e.printStackTrace();																										
		} finally {																															// finally => auf jeden fall (auch wenn oben fehler aufgetreten sind wird stream geschlossen)
			if (out != null) {																												// wenn out NICHT null ist, also wirklich ein bufferedWriter-objekt erzeugt wurde (wenn out null w�re, ist close() �berfl�ssig!!)
				try {
					out.close();																											// schliessen des streams mit close() auch bei fehlern/ evtl. gebufferte eintr�ge werden fertig ausgeschrieben
				} catch (IOException e){																									// zus�tzlich wird auf fehler beim schliessen selber (des streams) reagiert
					e.printStackTrace();	
				}
			}
		}
	}


	// button-handler-method zum hinzuf�gen von zeilen in der tabelle (inkl. eintrag der stunde in der ersten zelle)
	private void jBtnNeueZeileActionPerformed(ActionEvent evt) {		
		int neueZeilenZahl = jTable1.getModel().getRowCount() + 1;			// variable f�r stunden-eintrag in der ersten zelle: via jTable model erfragen, zeilenzahl erfragen + 1 mehr f�r stundeneintrag der n�chsten zeile
		DefaultTableModel model = (DefaultTableModel) jTable1.getModel();	// TableModel via jTable1.getModel() hat keine methode addRow(..), DefaultTableModel schon -> desshalb das model von jTable1 typcasten + einem lokalen variabel-objekt model vom typ DefaultTableModel zuweisen
		model.addRow(new String[]{ String.valueOf(neueZeilenZahl) });		// dem DefaultTableModel-objekt model mit addRow(..) eine zeile hinzuf�gen & als tabelleneintr�ge ein neu erzeugtes String-array inkl. dem element stunden-eintrag in der ersten spalte
	}

	// button-handler-method zum entfernen der letzten zeile in der tabelle 
	private void jBtnZeileLoeschenActionPerformed(ActionEvent evt) {				
		int letzteZeile = jTable1.getModel().getRowCount() - 1;				// variable f�r index der letzten (zu l�schenden) zeile, .getRowCount()-1, weil titelzeile mitgez�hlt wird bei rowCount & man sonst eine zu l�schen versucht dies noch gar nicht gibt
		((DefaultTableModel)jTable1.getModel()).removeRow(letzteZeile);		// zeile entfernen mit removeRow(index) von DefaultTableModel 
	}
	
	// button-handler-method zum hinzuf�gen einer spalte samstag in der tabelle		A C H T U N G: hat einen bug zusammen mit der methode OhneSamstag	-> siehe oben SPALTE ENTFERNEN / HINZUF�GEN: MIT BUG
	private void jBtnSamstagActionPerformed(ActionEvent evt) {
		((DefaultTableModel) jTable1.getModel()).addColumn(new String("Samstag"));		// methode addColumn(..) mit String-mitgabe gibt's nur bei DafaultTableModel, desshalb der typecast
		jBtnOhneSamstag.setEnabled(true);												// HIER WEITER !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		jBtnSamstag.setEnabled(false);
	}
	
	// button-handler-method zum entfernen der spalte samstag in der tabelle
	private void jBtnOhneSamstagActionPerformed(ActionEvent evt) {
		jTable1.getColumnModel().removeColumn(jTable1.getColumnModel().getColumn(6));
		jBtnSamstag.setEnabled(true);
		jBtnOhneSamstag.setEnabled(false);
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