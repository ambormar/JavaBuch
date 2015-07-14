/* TODO 15.1.1.c.   s.468, Tabelle m. konst. Zellenzahl, Daten ein- & auslesen in .dat-File 		!!!!!!!!!!!!!!!!!!!!!!
 * JTable_MitKonstZellenZahl_DatenEinUndAuslesen_StundenPlan2
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
 * 			TABELLE MIT VARIABLER ZEILEN- & SPALTEN-ZAHL:
 * 				SIEHE:		15.1.2.		JTable_Tabelle_MitVariablerZeilenUndSpaltenZahl_..			s.470							!!!!!!!!!!!!!!!!!!!!!!!!! 
 * 
 * 			TABELLE MIT UNTERSCHIEDLICHEN DATENTYPEN:
 * 				SIEHE:		15.1.3.		JTable_Tabelle_MitUnterschiedlichenDatenTypen_..			s.474							!!!!!!!!!!!!!!!!!!!!!!!!   
 * 
 * 
 * JTABLE / TABELLE MIT KONSTANTER ZELLENZAHL:
 * 
 * 		K&K:	Programm Stundenplan2	(erweiterung von Programm Stundenplan
 * 															Das Programm demonstriert die Erstellung einer Tabelle mit Spalten- und Zeilenbeschriftung. Es wird eine Tabelle zur Erstellung 
 * 															eines Stundenplans erstellt. Die Zellen sind bereits editierbar, so dass der Stundenplan ausgefüllt werden kann.)
 * 
 * 					Das Programm speichert den eingegebenen Stundenplan beim Beenden des Programms in der Datei stundenplan.dat.
 * 					Beim Programmstart wird geprüft, ob eine Stundenplandatei existiert. Ist dies der Fall, werden die Stundenplandaten in die Tabelle eingelesen.
 * 
 * 
 * 		VORGEHEN:
 * 
 * 			Programm Stundenplan2: 			[erweiterung von Programm StundenPlan VORGEHEN SIEHE in klammern UNTEN]
 * 
 * 				=> Fileds:	String-variable für den dateinamen, für das .dat-file, wo die daten aus-&ein-gelesen werden
 * 
 *						private String dateiname = "." + File.separator + "stundenplan.dat";
 * 
 * 				=> initGUI():	WindowListener (mit handler method) für wenn frame geschlossen wird, um tabellendaten in .dat-file auszulesen		
 * 
 * 						this.addWindowListener(new WindowAdapter() {..});		
 * 
 * 				=> ende initGUI():	inputstream zum laden von stundenplan-daten aus einem allfällig vorhandnenen .dat-file
 * 
 * 					[-> remember: jTable ist nur für optik; daten ein- & auslesen über's JTableModel]
 * 					-> input-stream erzeugen alles wie gehabt
 * 					-> daten für TableModel einlesen , welches für den datenerhalt (anzeige + bearbeiten der daten zuständig ist)
 * 						-> ACHTUNG: zugriff aber via jTable1 (eigtl. für optik zuständig), da nur dieses global (fileds) erstellt wurde, mit:	-> jTable1.getModel()
 * 					-> verschachtelte schleife um alle zellen durchzugehen mit:		 jTable1.getModel().getRowCount()		& 		jTable1.getModel().getColumnCount()
 * 						-> durchgehen der schleife für die zeilen mit index 0 beginnen, da die titelzeile von system selber ignoriert wird
 * 						-> durchgehen der schleife für die spalten mit index 1 beginnen, falls man die vorderste spalte ignorieren will beim ein-/auslesen
 * 					-> der lokalen String-variablen eintrag den jeweiligen wert der aktuellen zeile (im file) zuweisen:			eintrag = in.readLine();									 
 * 					-> mit setValueAt(i,j) jeden eintrag (wert) in die jeweilige zelle schreiben:			jTable1.getModel().setValueAt(eintrag, i, j);				
 * 					-> fehlerbehandlung & stream schliessen wie gehabt
 * 
 *					{
 *						BufferedReader in = null;																								// inputstream-objekt mit null initialisieren
 *						File datei = new File(dateiname);																						// vergleichsfile erzeugen mit namen dateiname
 *						if (!datei.exists()) {																									// wenn kein file mit namen dateiname vorliegt..
 *							datei.createNewFile();																								// .. eine solche erzeugen
 *						} else {																												// falls es schon eine datei mit dateinamen hat: ..(einlesen)
 *							try {																	
 *								String eintrag;														// lokale String-variable für die einträge
 *								in = new BufferedReader(new FileReader(dateiname));					// eingabestream "in":  BufferedReader-objekt unter mitgabe & erzeugen von FileReader-objekt mit dem argument dateiname 
 *								for (int i = 0; i < jTable1.getModel().getRowCount(); i++) {		// schleife: alle zeilen durchgehen (ab index 0, titelzeile wird vom TableModel ignoriert), auf's TableModel zugreifen via jTable1.getModel(), da nur jTable1 bei den globalen eigenschaften des frames erstellt ist, .getRowCount() für anzahl zeilen
 *									for (int j = 1; j < jTable1.getModel().getColumnCount(); j++) {	// schleife: alle spalten durchgehen (ab index 1, um absichtlich die erste spalte zu ignorieren), .getColumnCount() für anzahl spalten
 *										eintrag = in.readLine();									// der lokalen String-variablen eintrag den jeweiligen wert der aktuellen zeile (im file) zuweisen
 *										jTable1.getModel().setValueAt(eintrag, i, j);				// via jTable1 auf's TableModel zugreifenun + mit setValueAt(i,j) jeden eintrag (wert) in die jeweilige zelle schreiben
 *									}
 *								}
 *							} catch (Exception e) {																								// falls es fehler gibt beim file einlesen / file erzeugen
 *								..
 *							} finally {																											// finally => auf jeden fall (auch wenn oben fehler aufgetreten sind wird stream geschlossen)
 *								..
 *							}
 *						}
 *					} 
 * 
 * 				=> WindowListener-handler-method mit outputstream, um daten aus dem JTableModel der tabelle (jTable) in ein .dat-file auszulesen
 * 	
 * 					[-> remember: jTable ist nur für optik; daten ein- & auslesen über's JTableModel]
 *					-> output-stream erzeugen alles wie gehabt
 * 					-> daten für TableModel auslesen , welches für den datenerhalt (anzeige + bearbeiten der daten zuständig ist)
 * 						-> ACHTUNG: zugriff via jTable1 (eigtl. für optik zuständig), da nur dieses global (fileds) erstellt wurde, mit:	-> jTable1.getModel()
 * 					-> verschachtelte schleife um alle zellen durchzugehen mit:		 jTable1.getModel().getRowCount()		& 		jTable1.getModel().getColumnCount()
 * 						-> durchgehen der schleife für die zeilen mit index 0 beginnen, da die titelzeile von system selber ignoriert wird
 * 						-> durchgehen der schleife für die spalten mit index 1 beginnen, falls man die vorderste spalte ignorieren will beim ein-/auslesen
 * 					-> wenn der jeweilige zellenwert nicht null ist: 															-> if (jTable1.getModel().getValueAt(i, j) != null)
 * 						-> ausschreiben des objekts mit zugriff aufs TableModel & mit .getValueAt(i,j) auf die zellenwerte, 	-> out.write(jTable1.getModel().getValueAt(i, j).toString());
 *							-> A C H T U N G : werte sind immer von typ Object, darum toString() um in eine textdatei zu speichern (jede von Object abgeleitete klasse besitzt toString())
 *						-> oder falls der zellenwert leer ist:	einen leeren string ausschreiben								-> } else {out.write("");}
 *						-> + nach jedem wert einen zeilenumbruch schreiben														-> out.newLine();					
 * 					-> fehlerbehandlung & stream schliessen wie gehabt
 *	
 *	
 *					private void thisWindowClosed(WindowEvent evt) {
 *						BufferedWriter out = null;																										// BufferedWriter-Objekt out wird erzeugen und  mit null initialisieren
 *						try {
 *							out = new BufferedWriter(new FileWriter(dateiname));																		// remember: mit FileWriter wird anscheinend (?) real auf dem datenträger eine datei mit dateiname erzeugt
 *							for (int i= 0; i < jTable1.getModel().getRowCount();	i++) {			// schleife: alle zeilen durchgehen (ab index 0, titelzeile wird vom TableModel ignoriert), auf's TableModel zugreifen via jTable1.getModel(), da nur jTable1 bei den globalen eigenschaften des frames erstellt ist, .getRowCount() für anzahl zeilen
 *								for (int j = 1; j < jTable1.getModel().getColumnCount(); j++ ) {	// schleife: alle spalten durchgehen (ab index 1, um absichtlich die erste spalte zu ignorieren), .getColumnCount() für anzahl spalten
 *									if (jTable1.getModel().getValueAt(i, j) != null) {				// wenn der betreffende zellenwert nicht null ist ..
 *										out.write(jTable1.getModel().getValueAt(i, j).toString());	// ..ausschreiben der objekte mit zugriff aufs TableModel & mit .getValueAt(i,j) auf die zellenwerte, werte ..
 *									} else {														// ..sind immer von typ Object, darum toString() um in eine textdatei zu speichern (jede von Object abgeleitete klasse besitzt toString())
 *										out.write("");												// .. sonst leeren string ausschreiben
 *									} 
 *									out.newLine();													// .. + nach jedem wert einen zeilenumbruch schreiben
 *								}
 *							}
 *						} catch (Exception e) {																											// falls es fehler gibt beim file ausschreiben / file erzeugen
 *							..																										
 *						} finally {																														// finally => auf jeden fall (auch wenn oben fehler aufgetreten sind wird stream geschlossen)
 *							..
 *						}
 *					}  
 * 
 * 
 * 		[[[	Programm StundenPlan:					(15.1.1.a.   JTable_Tabelle_MitKonstanterZellenZahl_StundenPlan		s.464)
 * 
 * 				=> JFrame erzeugen & Layout:	Borderlayout lassen		-> NICHT auf anchor oder absolute umstellen (weiss nicht ob das wirklich wichtig ist oder ob's anders auch geht) ?????	
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
 *											new String[] { "Stunde", "Montag" });	// .. ein (normaler) array für die zellendaten (spaltentitel) (columns) der titelzeile
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
 * 		]]]
 */

package uebungen15;
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;	// themenspez. import
import java.awt.event.WindowEvent;		// themenspez. import
import java.io.BufferedReader;			// themenspez. import
import java.io.BufferedWriter;			// themenspez. import
import java.io.File;					// themenspez. import
import java.io.FileReader;
import java.io.FileWriter;				// themenspez. import
import java.io.IOException;				// themenspez. import

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.SwingUtilities;


public class JTable_MitKonstZellenZahl_DatenEinUndAuslesen_StundenPlan2 extends javax.swing.JFrame {
	
	private JTable jTable1;
	private JScrollPane jScrollPane1;
	private String dateiname = "." + File.separator + "stundenplan.dat";	// String-variable für den dateinamen, für das .dat-file, wo die daten aus-&ein-gelesen werden

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JTable_MitKonstZellenZahl_DatenEinUndAuslesen_StundenPlan2 inst = new JTable_MitKonstZellenZahl_DatenEinUndAuslesen_StundenPlan2();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public JTable_MitKonstZellenZahl_DatenEinUndAuslesen_StundenPlan2() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			BorderLayout thisLayout = new BorderLayout();																				// ACHTUNG borderlayout hier (nicht anchor & nicht absolute) für Tabelle (weiss nicht ob immer besser ????
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			setTitle("Stundenplan 2");
			this.addWindowListener(new WindowAdapter() {			// WindowListener für wenn frame geschlossen wird, um tabellendaten in .dat-file auszulesen
				public void windowClosed(WindowEvent evt) {
					thisWindowClosed(evt);
				}
			});
			{
				jScrollPane1 = new JScrollPane();																						// nötig damit die spalten-überschrift überhaupt angezeigt wird. jSctrollPane ins Frame ziehen & in der outline jTable..
				getContentPane().add(jScrollPane1, BorderLayout.CENTER);																// .. ins JScrollPane hineinziehen (wenn nachträglich) sonst : JScrollPane ins Frame & dann JTable aufs JScrollPane ziehen
				{
					TableModel jTable1Model = 																							// GETRENNT: 	1. für Datenerhaltung (anzeige + bearbeiten der daten): jTableModel															
																																		// TabelModel wird als DefaultTabelModel erzeugt: 	-> kann mit Vector-, Array- und ArrayList-daten umgehen..
							new DefaultTableModel(																						// dem konstruktor werden 2 Arrays übergeben, die dabei auch gleich erzeugt werden..			
									new String[][] { {"1"}, {"2"}, {"3"}, {"4"}, {"5"}, {"6"}, {"7"}, {"8"}, {"9"}, {"10"} },			// .. ein zweidim. array(-literal) für die zellendaten jeder zeile (rows)
									new String[] { "Stunden", "Dienstag", "Mittwoch", "Donnerstag", "Freitag" });						// .. ein (normaler) array für die zellendaten (spaltentitel) (columns) der titelzeile 
					jTable1 = new JTable();																								// 2. für optische Darstellung der daten:	JTable wird erzeugt
					jScrollPane1.setViewportView(jTable1);																				// macht glaub, dass die JScrollPane jTable1 vollständig aufnimmt/umfasst, auch wenn JScrollPane kleiner/woanders wäre als jTable1
					jTable1.setModel(jTable1Model);																						// das TableModel wird an die Tabelle (jTabel1) übergeben
				}
			}
			{
				BufferedReader in = null;																								// inputstream-objekt mit null initialisieren
				File datei = new File(dateiname);																						// vergleichsfile erzeugen mit namen dateiname
				if (!datei.exists()) {																									// wenn kein file mit namen dateiname vorliegt..
					datei.createNewFile();																								// .. eine solche erzeugen
				} else {																												// falls es schon eine datei mit dateinamen hat: ..(einlesen)
					try {																	
						String eintrag;														// lokale String-variable für die einträge
						in = new BufferedReader(new FileReader(dateiname));					// eingabestream "in":  BufferedReader-objekt unter mitgabe & erzeugen von FileReader-objekt mit dem argument dateiname 
						for (int i = 0; i < jTable1.getModel().getRowCount(); i++) {		// schleife: alle zeilen durchgehen (ab index 0, titelzeile wird vom TableModel ignoriert), auf's TableModel zugreifen via jTable1.getModel(), da nur jTable1 bei den globalen eigenschaften des frames erstellt ist, .getRowCount() für anzahl zeilen
							for (int j = 1; j < jTable1.getModel().getColumnCount(); j++) {	// schleife: alle spalten durchgehen (ab index 1, um absichtlich die erste spalte zu ignorieren), .getColumnCount() für anzahl spalten
								eintrag = in.readLine();									// der lokalen String-variablen eintrag den jeweiligen wert der aktuellen zeile (im file) zuweisen
								jTable1.getModel().setValueAt(eintrag, i, j);				// via jTable1 auf's TableModel zugreifenun + mit setValueAt(i,j) jeden eintrag (wert) in die jeweilige zelle schreiben
							}
						}
					} catch (Exception e) {													// falls es fehler gibt beim file einlesen / file erzeugen
						e.printStackTrace();
					} finally {																// finally => auf jeden fall (auch wenn oben fehler aufgetreten sind wird stream geschlossen)
						if (in != null)	{													// wenn in NICHT null ist, also wirklich ein bufferedWriter-objekt erzeugt wurde (wenn in null wäre, ist close() überflüssig!!)
							try {
								in.close();													// schliessen des streams mit close() auch bei fehlern/ evtl. gebufferte einträge werden fertig ausgeschrieben
							} catch (IOException e) {										// zusätzlich wird auf fehler beim schliessen selber (des streams) reagiert
								e.printStackTrace();
							}
						}
					}
				}
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	// WindowListener handler method für auslesen der daten aus dem JTableModel der tabelle (jTable) in ein .dat-file	(remember: jTable ist nur für optik; daten ein- & auslesen über's JTableModel)
	private void thisWindowClosed(WindowEvent evt) {
		BufferedWriter out = null;																										// BufferedWriter-Objekt out wird erzeugen und  mit null initialisieren
		try {
			out = new BufferedWriter(new FileWriter(dateiname));																		// remember: mit FileWriter wird anscheinend (?) real auf dem datenträger eine datei mit dateiname erzeugt
			for (int i= 0; i < jTable1.getModel().getRowCount();	i++) {			// schleife: alle zeilen durchgehen (ab index 0, titelzeile wird vom TableModel ignoriert), auf's TableModel zugreifen via jTable1.getModel(), da nur jTable1 bei den globalen eigenschaften des frames erstellt ist, .getRowCount() für anzahl zeilen
				for (int j = 1; j < jTable1.getModel().getColumnCount(); j++ ) {	// schleife: alle spalten durchgehen (ab index 1, um absichtlich die erste spalte zu ignorieren), .getColumnCount() für anzahl spalten
					if (jTable1.getModel().getValueAt(i, j) != null) {				// wenn der betreffende zellenwert nicht null ist ..
						out.write(jTable1.getModel().getValueAt(i, j).toString());	// ..ausschreiben der objekte mit zugriff aufs TableModel & mit .getValueAt(i,j) auf die zellenwerte, werte ..
					} else {														// ..sind immer von typ Object, darum toString() um in eine textdatei zu speichern (jede von Object abgeleitete klasse besitzt toString())
						out.write("");												// .. sonst leeren string ausschreiben
					} 
					out.newLine();													// .. + nach jedem wert einen zeilenumbruch schreiben
				}
			}
		} catch (Exception e) {																											// falls es fehler gibt beim file ausschreiben / file erzeugen
			e.printStackTrace();																										
		} finally {																														// finally => auf jeden fall (auch wenn oben fehler aufgetreten sind wird stream geschlossen)
			if (out != null) {																											// wenn out NICHT null ist, also wirklich ein bufferedWriter-objekt erzeugt wurde (wenn out null wäre, ist close() überflüssig!!)
				try {
					out.close();																										// schliessen des streams mit close() auch bei fehlern/ evtl. gebufferte einträge werden fertig ausgeschrieben
				} catch (IOException e){																								// zusätzlich wird auf fehler beim schliessen selber (des streams) reagiert
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