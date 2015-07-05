/* TODO 15.1.2.   s.470, Tabelle m. variabler Zeilen- & Spalten-zahl, Daten ein-auslesen in .dat-File 		!!!!!!!!!!!!!!!!!!!!!!
 * JTable_MitVariablerZeilenSpaltenZahl_DatenEinAusLesen_InDatFile_StundenPlan3
 * 		
 * 
 * 			SIEHE:			15.1.		JTable_Basic_Klasse_Komponente_FuerTabellen							s.463	
 * 
 * 			TABELLE MIT KONSTANTER ZELLEN-ZAHL (JTable):
 * 				SIEHE:		15.1.1.a.	JTable_Tabelle_MitKonstanterZellenZahl_StundenPlan					s.463																
 * 		
 * 			JTABELMODEL METHODEN - BASICS:
 * 				SIEHE:		15.1.1.b.   TableModel_Basics_Klasse_Methoden									s.466
 * 
 * 			TABELLE MIT KONSTANTER ZELLEN-ZAHL & EIN-AUS-LESEN DER TABELLENDATEN:
 * 				SIEHE:		15.1.1.c.	JTable_MitKonstZellenZahl_DatenEinUndAuslesen_StundenPlan2			s.468
 * 
 * 			TABELLE MIT UNTERSCHIEDLICHEN DATENTYPEN:
 * 				SIEHE:		15.1.3.		JTable_Tabelle_MitUnterschiedlichenDatenTypen_..					s.474							!!!!!!!!!!!!!!!!!!!!!!!!   
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
 * 						-> ansonsten soll stundenplan3 mit einer leeren tabelle starten:									-> arrayliteral für Datenstring-array im jTable1 leeren 
 * 						-> der anwender kann mittels buttons eine neue spalte für "samstag" erstellen bzw. entfernen		-> jBtnSamstag
 * 						-> der anwender kann mittels buttons beliebig viele neue zeilen erstellen bzw. entferenn			-> jBtnNeueZeile
 * 
 * 
 * 		VORGEHEN:
 * 
 * 			Programm Stundenplan3: 			[erweiterung von Programm StundenPlan2 VORGEHEN SIEHE in klammern UNTEN]
 * 
 * 				=> Fileds:	String-variable für den dateinamen, für das .dat-file, wo die daten aus-&ein-gelesen werden
 * 
 *						private String dateiname = "." + File.separator + "stundenplan.dat";
 * 
 * 				=> initGUI():	WindowListener (mit handler method) für wenn frame geschlossen wird, um tabellendaten in .dat-file auszulesen		
 * 
 * 						this.addWindowListener(new WindowAdapter() {..});	
 * 
 * 
 * 				=> JTable & TableModel innerhalb JScrollPane im initGUI() machen: 	
 * 
 * 					-> JScrollPane ins Frame ziehen			W I C H T I G  
 * 						-> WICHTIG: damit die spalten-überschrift (columns) überhaupt angezeigt wird. 		-> grund unklar;	aber ScrollPane ist bei Tabellen eh meist sinnvoll
 * 					-> JTable ins JScrollPane ziehen
 * 						(-> falls jSctrollPane nachträglich hinzugefügt wird:								-> jSctrollPane ins Frame ziehen & in der outline jTable ins JScrollPane hineinziehen)
 * 							
 * 						1. TABLEMODEL für die Datenerhaltung (= Anzeige + bearbeiten der daten) (jigloo-erzeugt)
 * 							-> es wird als new DefaultTabelModel* mit 2 STRING-ARRAYS im konstruktor erzeugt:		-> * kann mit daten umgehen die als Array, ArrayList oder Vector vorliegen	
 * 
 * 								-> 2-DIM. String-Array für die:		 ZEILEN-daten (rows)		-> hier : damit die tabelle beim programmstart keine datenzeilen enthält: array-literal für das datenstring-array leeren																								
 * 																																		-> sonst: schema: new String[][] { {"1"}, {"2"} }	
 * 																																		-> jede Klammer in der Klammer steht für eine neue zeile
 * 								-> 1-dim. String-Array für die:		 SPALTEN-daten (columns)	-> im code wie gewünscht anpassen 		-> new String[] { "Stunde", "Montag", .. }
 * 
 * 						2. JTABLE für die OPTISCHE DARSTELLUNG der daten		(auch jigloo-erzeugt)	-> inkl.:		jTable1.setModel(jTable1Model);
 * 													
 *					{
 *						jScrollPane1 = new JScrollPane();																						// nötig damit die spalten-überschrift überhaupt angezeigt wird. jSctrollPane ins Frame ziehen & in der outline jTable..
 *						getContentPane().add(jScrollPane1, new AnchorConstraint(1, 1001, 833, 1, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL)); // .. ins JScrollPane hineinziehen (wenn nachträglich) sonst : JScrollPane ins Frame & dann JTable aufs JScrollPane ziehen
 *						jScrollPane1.setPreferredSize(new java.awt.Dimension(472, 403));
 *						{
 *							TableModel jTable1Model = 																							// GETRENNT: 	1. für Datenerhaltung (anzeige + bearbeiten der daten): jTableModel															
 *																																				// TabelModel wird als DefaultTabelModel erzeugt: 	-> kann mit Vector-, Array- und ArrayList-daten umgehen..
 *									new DefaultTableModel(																						// dem konstruktor werden 2 Arrays übergeben, die dabei auch gleich erzeugt werden..
 *											new String[][] { },																		// damit die tabelle beim programmstart keine datenzeilen enthält: array-literal für das datenstring-array leeren	// .. ein zweidim. array für die zeilendaten (rows)
 *											new String[] { "Stunde", "Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag" });				// .. ein (normaler) array für die spaltendaten (columns)
 *							jTable1 = new JTable();																								// 2. für optische Darstellung der daten:	JTable wird erzeugt
 *							jScrollPane1.setViewportView(jTable1);																				// macht glaub, dass die JScrollPane jTable1 vollständig aufnimmt/umfasst, auch wenn JScrollPane kleiner/woanders wäre als jTable1
 *							jTable1.setModel(jTable1Model);																						// das TableModel wird an die Tabelle (jTabel1) übergeben
 *						}
 *					}
 * 
 * 	
 * 				=> ende initGUI():	inputstream zum laden von stundenplan-daten aus einem allfällig vorhandnenen .dat-file
 * 
 * 					[-> remember: jTable ist nur für optik; daten ein- & auslesen über's JTableModel]
 * 					-> input-stream erzeugen alles wie gehabt
 * 					-> die ersten 2 zeilen des .dat-files werden hier benutzt um die zahl der aktuellen zeilen & spalten zu speichern
 * 						-> diese mittels in.readLine() in eine jeweilige variable zeilen / spalten einlesen
 * 					-> lokales DefaultTabelModel-objekt mit namen model erzeugen		-> um ihm das (zu DefaultTableModel) getypcastete TableModel von jTable1 zuzuweisen 
 * 							(typcast nötig, weil nur DefaultTableModel ein addColumn(..) mit Titel-String-übergabe hat & TableModel nicht, glaub)
 * 					-> für falls die tabelle (laut .dat-file) 7 spalten (also eine spalte für samstag) hat: 	-> spalte hinzufügen via DefaultTableModel-objekt: 	model.addColumn(new String("Samstag"));
 * 					-> daten für TableModel einlesen , welches für den datenerhalt (anzeige + bearbeiten der daten zuständig ist)
 * 						-> ACHTUNG: zugriff aber via jTable1 (eigtl. für optik zuständig), da nur dieses global (fileds) erstellt wurde, mit:	-> jTable1.getModel()
 * 					-> verschachtelte schleife um alle zellen durchzugehen mit:		 i < zeilen		& 		j < spalten
 * 						-> durchgehen der schleife für die zeilen mit index i = 0 beginnen, da die titelzeile von system selber ignoriert wird
 * 						-> durchgehen der schleife für die spalten mit index j = 1 beginnen, falls man die vorderste spalte ignorieren will beim ein-/auslesen
 * 					-> im schleifenteil für die zeilen:		-> alle zeilen hinzufügen mit jeweils einem String-array (pro zeile) und dem jeweiligen (i + 1) stunden-eintrag in der ersten zelle
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
 *								String eintrag;																									// lokale String-variable für die zeilenweisen einträge im .dat-file
 *								in = new BufferedReader(new FileReader(dateiname));																// eingabestream "in":  BufferedReader-objekt unter mitgabe & erzeugen von FileReader-objekt mit dem argument dateiname 		
 *								eintrag = in.readLine();								// der lokalen String-variablen eintrag den jeweiligen wert der aktuellen zeile (im file) zuweisen
 *								int zeilen = Integer.parseInt(eintrag);					// lokale variable für die (variable) anzahl zeilen (die neu vor den eigentlichen daten im .dat-file gespeichert ist
 *								eintrag = in.readLine();								// der lokalen String-variablen eintrag den jeweiligen wert der aktuellen zeile (im file) zuweisen	
 *								int spalten = Integer.parseInt(eintrag);				// lokale variable für die (variable) anzahl spalten (die neu vor den eigentlichen daten im .dat-file gespeichert ist
 *								DefaultTableModel model = new DefaultTableModel();		// neues DefaultTabelModel-objekt mit namen model..
 *								model = (DefaultTableModel) jTable1.getModel();			// .. mit zuweisen des (zu DefaultTableModel) getypcastete TableModels von jTable1 (typcast nötig, weil nur DefaultTableModel ein addColumn(..) mit Titel-String-übergabe hat & TableModel nicht, glaub)  
 *								if (spalten == 7) {										// wenn 7 spalten (spalten-titel: stunden + mo-sa)
 *									model.addColumn(new String("Samstag"));				// spalte hinzufügen via DefaultTableModel-objekt 
 *									jBtnSamstag.setEnabled(false);						// button samstag deaktivieren
 *									jBtnOhneSamstag.setEnabled(true);					// button Ohne samstag aktivieren
 *								}
 *								for (int i = 0; i < zeilen; i++) {						// schleife: alle zeilen durchgehen (ab index 0, titelzeile wird vom TableModel ignoriert), auf's TableModel zugreifen via jTable1.getModel(), da nur jTable1 bei den globalen eigenschaften des frames erstellt ist, variable mit eingelesenem zeilen-wert für anzahl zeilen
 *									model.addRow(new String[] { String.valueOf(i + 1) });	// .. alle zeilen hinzufügen mit jeweils einem String-array (pro zeile) und dem jeweiligen (i + 1) stunden-eintrag in der ersten zelle
 *									for (int j = 1; j < spalten; j++){					// schleife: alle spalten durchgehen (ab index 1, um absichtlich die erste spalte zu ignorieren), variable mit eingelesenem spalten-wert für anzahl spalten
 *										eintrag = in.readLine();						// der lokalen String-variablen eintrag den jeweiligen wert der aktuellen zeile (im file) zuweisen..
 *										jTable1.getModel().setValueAt(eintrag, i, j);	// via jTable1 auf's TableModel zugreifen + mit setValueAt(i,j) jeden eintrag (wert) in die jeweilige zelle schreiben
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
 *					-> anzahl zeilen / spalten ausschreiben ins .dat-file, als erste 2 zeilen der daten (mit jeweils einem zeilenumbruch danach)
 * 					-> daten für TableModel auslesen , welches für den datenerhalt (anzeige + bearbeiten der daten zuständig ist)
 * 						-> ACHTUNG: zugriff via jTable1 (eigtl. für optik zuständig), da nur dieses global (fileds) erstellt wurde, mit:	-> jTable1.getModel()
 * 					-> verschachtelte schleife um alle zellen durchzugehen mit:		 jTable1.getModel().getRowCount()		& 		jTable1.getModel().getColumnCount()
 * 						-> durchgehen der schleife für die zeilen mit index i = 0 beginnen, da die titelzeile von system selber ignoriert wird
 * 						-> durchgehen der schleife für die spalten mit index j = 1 beginnen, falls man wie hier, die vorderste spalte ignorieren will beim ein-/auslesen
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
							out.write(String.valueOf(jTable1.getModel().getRowCount()));			// anzahl zeilen ausschreiben ins .dat-file, als erste zeile der daten 
							out.newLine();															// zeilenumbruch im .dat-file 
							out.write(String.valueOf(jTable1.getModel().getColumnCount()));			// anzahl spalten ausschreiben als zweite zeile der daten im .dat-file 
							out.newLine();	 														// zeilenumbruch im .dat-file
 *							for (int i= 0; i < jTable1.getModel().getRowCount();	i++) {																// schleife: alle zeilen durchgehen (ab index 0, titelzeile wird vom TableModel ignoriert), auf's TableModel zugreifen via jTable1.getModel(), da nur jTable1 bei den globalen eigenschaften des frames erstellt ist, .getRowCount() für anzahl zeilen
 *								for (int j = 1; j < jTable1.getModel().getColumnCount(); j++ ) {														// schleife: alle spalten durchgehen (ab index 1, um absichtlich die erste spalte zu ignorieren), .getColumnCount() für anzahl spalten
 *									if (jTable1.getModel().getValueAt(i, j) != null) {																	// wenn der betreffende zellenwert nicht null ist ..
 *										out.write(jTable1.getModel().getValueAt(i, j).toString());														// ..ausschreiben der objekte mit zugriff aufs TableModel & mit .getValueAt(i,j) auf die zellenwerte, werte ..
 *									} else {																											// ..sind immer von typ Object, darum toString() um in eine textdatei zu speichern (jede von Object abgeleitete klasse besitzt toString())
 *										out.write("");																									// .. sonst leeren string ausschreiben
 *									} 
 *									out.newLine();																										// .. + nach jedem wert einen zeilenumbruch schreiben
 *								}
 *							}
 *						} catch (Exception e) {																											// falls es fehler gibt beim file ausschreiben / file erzeugen
 *							..																										
 *						} finally {																														// finally => auf jeden fall (auch wenn oben fehler aufgetreten sind wird stream geschlossen)
 *							..
 *						}
 *					}  
 * 
 *  			=> ZEILEN HINZUFÜGEN:	button-handler-method zum hinzufügen von zeilen in der tabelle (inkl. eintrag der stunde in der ersten zelle)
 *  
 *  				-> zeile hinzufügen mit methode addRow(..) von DefaulttabelModel		-> hierfür das TableModel von jTable auf DefaultTabelModel typcasten 
 *  				-> als tabelleneinträge ein neu erzeugtes String-array inkl. dem element stunden-eintrag für die erste spalte mitgeben
 *  
 *					private void jBtnNeueZeileActionPerformed(ActionEvent evt) {		
 *						int neueZeilenZahl = jTable1.getModel().getRowCount() + 1;			// variable für stunden-eintrag in der ersten zelle: via jTable model erfragen, zeilenzahl erfragen + 1 mehr für stundeneintrag der nächsten zeile
 *						DefaultTableModel model = (DefaultTableModel) jTable1.getModel();	// TableModel via jTable1.getModel() hat keine methode addRow(..), DefaultTableModel schon -> desshalb das model von jTable1 typcasten + einem lokalen variabel-objekt model vom typ DefaultTableModel zuweisen
 *						model.addRow(new String[]{ String.valueOf(neueZeilenZahl) });		// dem DefaultTableModel-objekt model mit addRow(..) eine zeile hinzufügen & als tabelleneinträge ein neu erzeugtes String-array inkl. dem element stunden-eintrag in der ersten spalte
 *					}
 *				
 *				=> ZEILEN ENTFERNEN:	button-handler-method zum entfernen der letzten zeile in der tabelle 
 *				
 *					-> zeile entfernen mit removeRow(index) von DefaultTableModel 
 *				
 *					private void jBtnZeileLoeschenActionPerformed(ActionEvent evt) {				
 *						int letzteZeile = jTable1.getModel().getRowCount() - 1;				// variable für index der letzten (zu löschenden) zeile, .getRowCount()-1, weil titelzeile mitgezählt wird bei rowCount & man sonst eine zu löschen versucht dies noch gar nicht gibt
 *						((DefaultTableModel)jTable1.getModel()).removeRow(letzteZeile);		// zeile entfernen mit removeRow(index) von DefaultTableModel 
 *					}
 *					
 *				=> SPALTE HINZUFÜGEN:	button-handler-method zum hinzufügen einer spalte samstag in der tabelle
 *				
 *					-> methode addColumn(..) mit String-mitgabe gibt's nur bei DafaultTableModel, desshalb TableModel von jTable1 typecasten 
 *						
 *					private void jBtnSamstagActionPerformed(ActionEvent evt) {
 *						((DefaultTableModel) jTable1.getModel()).addColumn(new String("Samstag"));	// methode addColumn(..) mit String-mitgabe gibt's nur bei DafaultTableModel, desshalb der typecast
 *						jBtnOhneSamstag.setEnabled(true);											// button zum samstag entfernen aktivieren
 *						jBtnSamstag.setEnabled(false);												// button zum samstag hinzufügen deaktivieren
 *					}
 *					
 *				=> SPALTE ENTFERNEN:	button-handler-method zum entfernen der spalte samstag in der tabelle
 *				
 *					-> spalte entfernen mit:	methode .removeColumn(..) gibt's nur via .getColumnModel(..) von TableColumnModel ->
 *					-> A C H T U N G:	 		auch die anzahl spalten von DefaultTableModel muss mit .setColumnCount(..) angepasst werden um einen BUG mit spalte samstag zu verhindern: 
 *												-> der BUG wäre:	man löscht die spalte samstag & beim wieder-erzeugen, existiert sie dann doppelt / mehfach, eben weil sie im DefaultTableModel /TableModel(?) nie entfernt wurde
 *				
 *					private void jBtnOhneSamstagActionPerformed(ActionEvent evt) {
 *						jTable1.getColumnModel().removeColumn(jTable1.getColumnModel().getColumn(jTable1.getModel().getColumnCount()-1));	// methode .removeColumn(..) gibt's nur via .getColumnModel(..) von TableColumnModel -> ..
 *						((DefaultTableModel)jTable1.getModel()).setColumnCount(jTable1.getModel().getColumnCount()-1); // ..  WICHTIG: -> auch die anzahl spalten von DefaultTableModel muss angepasst werden um bug mit spalte samstag zu verhindern: 
 *						jBtnSamstag.setEnabled(true);													// button zum samstag hinzufügen aktivieren
 *						jBtnOhneSamstag.setEnabled(false);												// button zum samstag entfernen  deaktivieren
 *					}
 * 
 * 
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
	private JButton jBtnNeueZeile;												// button für zusätzliche zeilen in der tabelle
	private JButton jBtnSamstag;												// button um spalte für samstag hinzuzufügen
	private JButton jBtnOhneSamstag;											// button um spalte für samstag zu entfernen
	private JButton jBtnZeileLoeschen;										 	// button um letzte zeile der tabelle zu entfernen
	private String dateiname = "." + File.separator + "stundenplan3.dat";		// String-variable für den dateinamen, für das .dat-file, wo die daten aus-&ein-gelesen werden
	

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
			this.addWindowListener(new WindowAdapter() {																				// WindowListener für wenn frame geschlossen wird, um tabellendaten in .dat-file auszulesen
				public void windowClosed(WindowEvent evt) {
					thisWindowClosed(evt);
				}
			});
			{
				jBtnNeueZeile = new JButton();										// button um zeile hinzuzufügen
				getContentPane().add(jBtnNeueZeile, new AnchorConstraint(858, 954, 903, 532, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jBtnNeueZeile.setText("Zeile hinzufügen");
				jBtnNeueZeile.setPreferredSize(new java.awt.Dimension(195, 23));
				jBtnNeueZeile.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnNeueZeileActionPerformed(evt);
					}
				});
			}
			{
				jBtnZeileLoeschen = new JButton();									// button um letzte zeile zu löschen 
				getContentPane().add(jBtnZeileLoeschen, new AnchorConstraint(930, 954, 978, 532, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jBtnZeileLoeschen.setText("Letzet Zeile Löschen");
				jBtnZeileLoeschen.setPreferredSize(new java.awt.Dimension(195, 23));
				jBtnZeileLoeschen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnZeileLoeschenActionPerformed(evt);
					}
				});
			}
			{
				jBtnSamstag = new JButton();										// button um spalte samstag hinzuzufügen
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
				jBtnOhneSamstag = new JButton();									// button um spalte samstag zu löschen
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
				jScrollPane1 = new JScrollPane();																						// nötig damit die spalten-überschrift überhaupt angezeigt wird. jSctrollPane ins Frame ziehen & in der outline jTable..
				getContentPane().add(jScrollPane1, new AnchorConstraint(1, 1001, 833, 1, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL)); // .. ins JScrollPane hineinziehen (wenn nachträglich) sonst : JScrollPane ins Frame & dann JTable aufs JScrollPane ziehen
				jScrollPane1.setPreferredSize(new java.awt.Dimension(472, 403));
				{
					TableModel jTable1Model = 																							// GETRENNT: 	1. für Datenerhaltung (anzeige + bearbeiten der daten): jTableModel															
																																		// TabelModel wird als DefaultTabelModel erzeugt: 	-> kann mit Vector-, Array- und ArrayList-daten umgehen..
							new DefaultTableModel(																						// dem konstruktor werden 2 Arrays übergeben, die dabei auch gleich erzeugt werden..
									new String[][] { },		// damit die tabelle beim programmstart keine datenzeilen enthält: array-literal für das datenstring-array leeren	// .. ein zweidim. array für die zeilendaten (rows)
									new String[] { "Stunde", "Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag" });				// .. ein (normaler) array für die spaltendaten (columns)
					jTable1 = new JTable();																								// 2. für optische Darstellung der daten:	JTable wird erzeugt
					jScrollPane1.setViewportView(jTable1);																				// macht glaub, dass die JScrollPane jTable1 vollständig aufnimmt/umfasst, auch wenn JScrollPane kleiner/woanders wäre als jTable1
					jTable1.setModel(jTable1Model);																						// das TableModel wird an die Tabelle (jTabel1) übergeben
				}
			}
			{	// einlesen der daten aus dem .dat-file ins's JTableModel der tabelle (jTable) beim öffnen des frames  	(remember: jTable ist nur für optik; daten ein- & auslesen über's JTableModel) 
				BufferedReader in = null;																								// inputstream-objekt mit null initialisieren
				File datei = new File(dateiname);																						// vergleichsfile erzeugen mit namen dateiname
				if (!datei.exists()) {																									// wenn kein file mit namen dateiname vorliegt..
					datei.createNewFile();																								// .. eine solche erzeugen
				} else {																												// falls es schon eine datei mit dateinamen hat: ..(einlesen)
					try {
						String eintrag;																									// lokale String-variable für die zeilenweisen einträge im .dat-file
						in = new BufferedReader(new FileReader(dateiname));																// eingabestream "in":  BufferedReader-objekt unter mitgabe & erzeugen von FileReader-objekt mit dem argument dateiname 		
						eintrag = in.readLine();								// der lokalen String-variablen eintrag den jeweiligen wert der aktuellen zeile (im file) zuweisen
						int zeilen = Integer.parseInt(eintrag);					// lokale variable für die (variable) anzahl zeilen (die neu vor den eigentlichen daten im .dat-file gespeichert ist
						eintrag = in.readLine();								// der lokalen String-variablen eintrag den jeweiligen wert der aktuellen zeile (im file) zuweisen	
						int spalten = Integer.parseInt(eintrag);				// lokale variable für die (variable) anzahl spalten (die neu vor den eigentlichen daten im .dat-file gespeichert ist
						DefaultTableModel model = new DefaultTableModel();		// neues DefaultTabelModel-objekt mit namen model..
						model = (DefaultTableModel) jTable1.getModel();			// .. mit zuweisen des (zu DefaultTableModel) getypcastete TableModels von jTable1 (typcast nötig, weil nur DefaultTableModel ein addColumn(..) mit Titel-String-übergabe hat & TableModel nicht, glaub)  
						if (spalten == 7) {										// wenn 7 spalten (spalten-titel: stunden + mo-sa)
							model.addColumn(new String("Samstag"));				// spalte hinzufügen via DefaultTableModel-objekt 
							jBtnSamstag.setEnabled(false);						// button samstag deaktivieren
							jBtnOhneSamstag.setEnabled(true);					// button Ohne samstag aktivieren
						}
						for (int i = 0; i < zeilen; i++) {						// schleife: alle zeilen durchgehen (ab index 0, titelzeile wird vom TableModel ignoriert), auf's TableModel zugreifen via jTable1.getModel(), da nur jTable1 bei den globalen eigenschaften des frames erstellt ist, variable mit eingelesenem zeilen-wert für anzahl zeilen
							model.addRow(new String[] { String.valueOf(i + 1) });	// .. alle zeilen hinzufügen mit jeweils einem String-array (pro zeile) und dem jeweiligen (i + 1) stunden-eintrag in der ersten zelle
							for (int j = 1; j < spalten; j++){					// schleife: alle spalten durchgehen (ab index 1, um absichtlich die erste spalte zu ignorieren), variable mit eingelesenem spalten-wert für anzahl spalten
								eintrag = in.readLine();						// der lokalen String-variablen eintrag den jeweiligen wert der aktuellen zeile (im file) zuweisen..
								jTable1.getModel().setValueAt(eintrag, i, j);	// via jTable1 auf's TableModel zugreifen + mit setValueAt(i,j) jeden eintrag (wert) in die jeweilige zelle schreiben
							}
						}
					} catch (Exception e) {																								// falls es fehler gibt beim file einlesen / file erzeugen
						e.printStackTrace();
					} finally {																											// finally => auf jeden fall (auch wenn oben fehler aufgetreten sind wird stream geschlossen)
						if (in != null)	{																								// wenn in NICHT null ist, also wirklich ein bufferedWriter-objekt erzeugt wurde (wenn in null wäre, ist close() überflüssig!!)
							try {
								in.close();																								// schliessen des streams mit close() auch bei fehlern/ evtl. gebufferte einträge werden fertig ausgeschrieben
							} catch (IOException e) {																					// zusätzlich wird auf fehler beim schliessen selber (des streams) reagiert
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
	
	// WindowListener handler method für auslesen der daten aus dem JTableModel der tabelle (jTable) in ein .dat-file	(remember: jTable ist nur für optik; daten ein- & auslesen über's JTableModel)
	private void thisWindowClosed(WindowEvent evt) {
		BufferedWriter out = null;																											// BufferedWriter-Objekt out wird erzeugen und  mit null initialisieren
		try {
			out = new BufferedWriter(new FileWriter(dateiname));																			// remember: mit FileWriter wird anscheinend (?) real auf dem datenträger eine datei mit dateiname erzeugt
			out.write(String.valueOf(jTable1.getModel().getRowCount()));			// anzahl zeilen ausschreiben ins .dat-file, als erste zeile der daten 
			out.newLine();															// zeilenumbruch im .dat-file 
			out.write(String.valueOf(jTable1.getModel().getColumnCount()));			// anzahl spalten ausschreiben als zweite zeile der daten im .dat-file 
			out.newLine();															// zeilenumbruch im .dat-file
			for (int i= 0; i < jTable1.getModel().getRowCount();	i++) {																	// schleife: alle zeilen durchgehen (ab index 0, titelzeile wird vom TableModel ignoriert), auf's TableModel zugreifen via jTable1.getModel(), da nur jTable1 bei den globalen eigenschaften des frames erstellt ist, .getRowCount() für anzahl zeilen
				for (int j = 1; j < jTable1.getModel().getColumnCount(); j++ ) {															// schleife: alle spalten durchgehen (ab index 1, um absichtlich die erste spalte zu ignorieren), .getColumnCount() für anzahl spalten
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
			if (out != null) {																												// wenn out NICHT null ist, also wirklich ein bufferedWriter-objekt erzeugt wurde (wenn out null wäre, ist close() überflüssig!!)
				try {
					out.close();																											// schliessen des streams mit close() auch bei fehlern/ evtl. gebufferte einträge werden fertig ausgeschrieben
				} catch (IOException e){																									// zusätzlich wird auf fehler beim schliessen selber (des streams) reagiert
					e.printStackTrace();	
				}
			}
		}
	}

	// button-handler-method zum hinzufügen von zeilen in der tabelle (inkl. eintrag der stunde in der ersten zelle)
	private void jBtnNeueZeileActionPerformed(ActionEvent evt) {		
		int neueZeilenZahl = jTable1.getModel().getRowCount() + 1;			// variable für stunden-eintrag in der ersten zelle: via jTable model erfragen, zeilenzahl erfragen + 1 mehr für stundeneintrag der nächsten zeile
		DefaultTableModel model = (DefaultTableModel) jTable1.getModel();	// TableModel via jTable1.getModel() hat keine methode addRow(..), DefaultTableModel schon -> desshalb das model von jTable1 typcasten + einem lokalen variabel-objekt model vom typ DefaultTableModel zuweisen
		model.addRow(new String[]{ String.valueOf(neueZeilenZahl) });		// dem DefaultTableModel-objekt model mit addRow(..) eine zeile hinzufügen & als tabelleneinträge ein neu erzeugtes String-array inkl. dem element stunden-eintrag in der ersten spalte
	}

	// button-handler-method zum entfernen der letzten zeile in der tabelle 
	private void jBtnZeileLoeschenActionPerformed(ActionEvent evt) {				
		int letzteZeile = jTable1.getModel().getRowCount() - 1;				// variable für index der letzten (zu löschenden) zeile, .getRowCount()-1, weil titelzeile mitgezählt wird bei rowCount & man sonst eine zu löschen versucht dies noch gar nicht gibt
		((DefaultTableModel)jTable1.getModel()).removeRow(letzteZeile);		// zeile entfernen mit removeRow(index) von DefaultTableModel 
	}
	
	// button-handler-method zum hinzufügen einer spalte samstag in der tabelle		
	private void jBtnSamstagActionPerformed(ActionEvent evt) {
		((DefaultTableModel) jTable1.getModel()).addColumn(new String("Samstag"));	// methode addColumn(..) mit String-mitgabe gibt's nur bei DafaultTableModel, desshalb der typecast
		jBtnOhneSamstag.setEnabled(true);											// button zum samstag entfernen aktivieren
		jBtnSamstag.setEnabled(false);												// button zum samstag hinzufügen deaktivieren
	}
	
	// button-handler-method zum entfernen der spalte samstag in der tabelle		A C H T U N G	B U G	V E R H I N D E R N 
	private void jBtnOhneSamstagActionPerformed(ActionEvent evt) {
		jTable1.getColumnModel().removeColumn(jTable1.getColumnModel().getColumn(jTable1.getModel().getColumnCount()-1));	// methode .removeColumn(..) gibt's nur via .getColumnModel(..) von TableColumnModel -> ..
		((DefaultTableModel)jTable1.getModel()).setColumnCount(jTable1.getModel().getColumnCount()-1); // ..  WICHTIG: -> auch die anzahl spalten von DefaultTableModel muss angepasst werden um BUG  mit spalte samstag zu verhindern: 
		jBtnSamstag.setEnabled(true);													// button zum samstag hinzufügen aktivieren
		jBtnOhneSamstag.setEnabled(false);												// button zum samstag entfernen  deaktivieren
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