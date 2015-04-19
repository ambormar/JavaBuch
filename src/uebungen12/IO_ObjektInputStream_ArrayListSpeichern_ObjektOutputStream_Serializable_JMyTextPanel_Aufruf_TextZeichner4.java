/* TODO 12.3.6.   s.437, 	ArrayList / Objekte in Datei ein-& auslesen
 * & TODO 13.5.   Aufgabe 6, s.437, MIT REPAINT() bei frameveränderungen; mit Graphics2D  
 * class	IO_ObjektInputStream_ArrayListSpeichern_ObjektOutputStream_Serializable_JMyTextPanel_Aufruf_TextZeichner4	& 	JMyTextPanel	&	TextAusgabeObjekt
 * 
 *  	FÜR SERIALIZABLE SIEHE: 	12.3.6.  	Serializable_Interface_SerialisierungVonObjekten_KlasseImplementsSerializable		eigene bemerkung
 *  
 *  
 *  	FÜR ZUSAMMENHANG ZWISCHEN DEN 3 KLASSEN:
 *  
 *  		SIEHE:	13.5.   Aufgabe 5, s.437, MIT REPAINT() bei frameveränderungen; mit Graphics2D 
 * 						class JMyTextPanel_Aufruf_KomponenteFuerTextPerMausklick_paintComponentLernfaehig_RepaintBeiFrameveraenderungen_TextZeichner3	& 	JMyTextPanel	&	TextAusgabeObjekt
 *  
 * 			ODER DAS ANALOG GELÖSTE:	13.2.5.   JMyPaintPanel_Aufruf_KomponenteZumHineinZeichnen_paintComponentLernfaehig_RepaintBeiFrameveraenderungen_Zeichnen4		s.413, (3. ANSATZ)  MIT REPAINT() bei frameveränderungen; mit Graphics2D
 *  
 *  						 	 &:		13.2.5.   JMyPaintPanel											s.413, (3. ANSATZ)   JMyPaintPanel extends JPanel, PaintComponent überschrieben
 *  
 *  						 	 &: 	13.2.5.   Zeichenobjekt											s.413, (3. ANSATZ)  (Kl. z. speichern der infos einer geom. figur) 
 *  
 *  	FÜR INPUTSTREAM - OUTPUTSTREAM SIEHE:		Kapitel 12, verschiedenste: zb.: 	Basics, FileReader/Writer etc. 		
 * 
 * 
 * K&K:		Programm Textzeichner4:		[erweiterung von textzeichner3:
 * 											(nutzt die Komponente JMyTextPanel & die Klasse TextAusgabeObjekt)
 * 											Gibt an beliebigen Positionen eines Panels Text in den Farben schwarz oder rot aus.
 * 											Die selbst erstellte Komponente JMyTextPanel übernimmt das zeichnen der Textzeilen. Als Behälter nutzt die Komponente eine ArrayList (=Vector?).
 * 
 * 										Textzeichner4 speichert die gezeichneten Texte in einer Datei. Es genügt ein Schreib- bzw. Lesevorgang für den gesamten Vector. 
 * 
 *			Klasse TextAusgabeObjekt:	Sie speichert Textzeilen mit Position und Farbe. 
 *										Für Version 4: Die Klasse implementiert das Interface Serializable.
 *
 *			Klasse JMyTextPanel:		Die Klasse ist von der Standardkomponente JPanel abgeleitet. Die von ihm dargestellten Textzeilen werden in einer ArrayList (Vector?)
 * 										gespeichert. Die ArrayList (Vector?) speichert die Textzeilen als Objekte der Klasse Textausgabe.
 * 										Für Version 4: die klasse erhält zusätzlich je eine getter- & setter-methode um auf die arraylist (bzw. ihre elemente) zugreifen zu können
 *
 *
 * AUFGABENSTELLUNG:	
 * 						
 * 		TextZeicher4:	- erweiterung von Textzeichner3*:
 * 						- speichert beim schliessen des fensters (jBtnEnde) die gezeichneten Texte in einer Datei (textAusgabeObjekte.dat).
 * 						- Mittels Serializable genügt ein Schreib- bzw. Lesevorgang für den gesamten Vector (ArrayList). 
 * 						  -> Die ArrayList-objekte werden zu einem String flachgeklopft.
 * 						- die flachgeklopften arraylist-objekte lassen sich dann leicht mit ObjectOutputStream + ObjectInputStream in ein dat.-file ein- & auslesen
 *			
 *
 *		ERWEITERUNGEN (DER 3 KLASSEN) ZUM SPEICHERN DER TEXTAUSGABEOBJEKTE / ARRAYLIST IN EINEM DAT.-FILE :	
 * 
 * 			1. class TextAusgabeObjekt					=> klasse implementiert Interface Serializable damit von den Objekten/instanzen der klasse eine flachgeklopfte string-version ..
 * 															erzeugt werden kann, die sich als ein einziges String-Objekt besser in daten-files(z.b.: .txt .dat) auslesen /einlesen lässt
 * 
 * 					public class TextAusgabeObjekt implements Serializable {..}
 * 
 * 
 * 			2. class JMyTextPanel (extends JPanel)		=> erhält einen getter & einen setter um auf die ArayList(-elemente) zuzugreifen:
 * 
 *					public ArrayList<TextAusgabeObjekt> getArrayList() {							// normaler getter für texte (getTexte(..)) hier aber umbenannt in setArrrayList(..), 
 *						return texte;																// .. -> kommt aufs selbe raus
 *					}
 *	
 *					public void setArrayList(ArrayList<TextAusgabeObjekt> al) {						// normaler setter für texte (setTexte(..)) hier aber umbenannt in getArrrayList(..), 
 *						texte = al;																	// .. -> kommt aufs selbe raus
 *					}
 * 
 * 
 * 			3. IO_ObjektInputStream_ArrayListSpeichern_ObjektOutputStream_Serializable_JMyTextPanel_Aufruf_TextZeichner4		
 * 
 * 				=> zusätzliche importe:		
 * 						java.io.File;	java.io.FileInputStream;	java.io.ObjectInputStream;		java.io.ObjectOutputStream;		java.io.Serializable;java.util.ArrayList;	
 * 				
 * 				=> zusätzliche variablen oben:
 *						private String dateiname = "." + File.separator + "textAusgabeObjekte.dat"; 	// dateiname mit pfad als string; schräg: das .dat-file wird nicht wie die anderen ..
 *																										// ..im package-explorer von eclipse angezeigt (in dokumenten schon), hat evtl. was mit serializable zu tun
 *						private ArrayList<TextAusgabeObjekt> meineTexte;								// ArrayList zur zwischen-speicherung der TextAusgabeObkjekte beim einlesen aus dem textAusgabeObjekte.dat-file, siehe ende initGUI() 
 *
 *				=> einlesen der TextAusgabeObjekte aus dem TextAusgabeObjekte.dat-file ins programm, ende initGUI():
 *				
 *	 					{	
 *							File datei = new File(dateiname);											// vergleichsfile erzeugen mit namen + pfad (dateiname) vom zu vergleichenden file
 *							if (!datei.exists()){														// wenn file mit dateiname nicht existiert..
 *								meineTexte = null;														// .. arrayList	meineTexte auf null setzen
 *							} else {																	// ..sonst:
 *								meineTexte = readArrayList();											// ..meineTexte = methodenaufruf readArrayList() von unten in dieser klasse
 *							}
 *							if (meineTexte != null) {													// wenn arraylist meinetexte texte beinhalten
 *								jPanelTextflaeche.setArrayList(meineTexte);								// ArrayList von jPanelTextflaeche (=JMyTextPanel) via methode setArrayList() (auch von JMyTextPanel) meineTexte übergeben
 *							}
 *							datei.delete();																// vergleichs-file löschen
 *						}
 *
 *				=> zusätzlicher jBtnEnde mit event-methode zum speichern der vorhandenen TextAusgabeObjekte ins TextAusgabeObjekte.dat-file		&	zum schliessen des fensters
 *
 *						private void jBtnEndeActionPerformed(ActionEvent evt) {									
 *							ArrayList<TextAusgabeObjekt> liste = new ArrayList<TextAusgabeObjekt>();	// lokale ArrayList liste vom typ TextAusgabeObjekt erzeugen
 *							liste = jPanelTextflaeche.getArrayList();									// via methode getArrayList() die vorhandenen textAusgabeObjekte aus ArrayList von jPanelTextflaeche (=JMyTextPanel) in lokale arraylist liste speichern
 *							writeArrayList(liste);														// methode writeArrayList unter übergabe von list aufrufen (um dort das TextAusgabeObjekte.dat-file mit den TextAusgabeObjekten zu erzeugen + zu speichern)
 *							System.exit(0);																// programm beenden + fenster schliessen 
 *						} 
 *						
 *				=> zusätzliche methode readArrayList() zum effektiven einlesen der TextAusgabeObjekte aus dem dat.-file mittels ObjectInputStream
 *				
 *						private ArrayList<TextAusgabeObjekt> readArrayList() {								 	
 *							ArrayList<TextAusgabeObjekt> liste = new ArrayList<TextAusgabeObjekt>();		 	// lokale ArrayList liste vom typ TextAusgabeObjekt erzeugen
 *							try {
 *								ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dateiname));	// ObjectInputstream ois erzeugen unter mitgabe von neuem fileInputstream unter mitgabe von dateiname (inkl.pfad)
 *								liste = (ArrayList<TextAusgabeObjekt>)ois.readObject();							// ArrayList liste mit den objekten der datei befüllen, dazu methode ois.readObject() typgecastet benutzen 
 *								ois.close();																	// ObjectOutputStream schliessen
 *							} catch (Exception e) {
 *								JOptionPane.showMessageDialog(null, "Fehler beim Lesen aus Datei!");			// fehlermeldung 
 *								liste = null;																	// liste auf null falls fehler
 *							}
 *							return liste;																		// arraylist liste zurückgeben
 *						}
 *
 *				=> zusätzliche methode writeArrayList() zum effektiven auslesen der TextAusgabeObjekte ins TextAusgabeObjekte.dat-file mittels ObjectOutputStream
 *
 *						private void writeArrayList(ArrayList<TextAusgabeObjekt> liste){						
 *							try {
 *								ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dateiname, true));		// ObjectOutputStream oos erzeugen unter mitgabe von neuem fileInputstream unter mitgabe von dateiname (inkl.pfad) 
 *								oos.writeObject(liste);																		// arraylist liste aussschreiben mittels methode writeObject() der klasse OOS 
 *								oos.flush();																				// spühlen: schreiben der daten aus dem zwischenspeicher des oos erzwingen
 *								oos.close();																				// oos schliessen
 *							} catch (Exception e) {
 *								JOptionPane.showMessageDialog(null, "Fehler beim schreiben in Datei!");						
 *								e.printStackTrace();
 *							}
 *						}
 *
 *
 *
 * [[[	VORAUSSETZUNG:	
 * 						
 * 		*TextZeicher3:	- erweiterung von Textzeichner1**:
 * 						- das panel muss bei frameveränderungen den text auto-repainten können (=>abgeleitete panel-komponente nötig:	JMyTextPanel = new JPanel() )
 *			
 *			BESTEHEND AUS:	
 * 
 * 			1. class TextAusgabeObjekt						=> klasse zur speicherung der informationen (text, x-y-koordinaten, farbe) zu einem TextAusgabeObjekt 
 * 
 * 			2. class JMyTextPanel (extends JPanel)			=> von JPanel abgeleitete klasse mit:	behälter (ArrayList) für TextAusgabeObjekte	&	lernfähiger paintComponent()-methode
 * 
 * 			3. JMyTextPanel_Aufruf_KomponenteFuerTextPerMausklick_paintComponentLernfaehig_RepaintBeiFrameveraenderungen_TextZeichner3		=> von JFrame abgeleitete klasse als TextZeichenProgramm
 * 
 * 
 * 	[	**TextZeichner1:	- standardpanel, in das text an einer beliebigen position durch mausklick eingesetzt werden kann
 * 							- radio-buttons für farbe des textes (rot + schwarz)
 * 							- textfeld zur texteingabe
 * 							- zeichnen des textes mit der methode:		 drawString(Strings, float x, float y) 		der klasse Graphics2d		]
 * ]]]
 * 
 */

package uebungen12;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;						// themenspez. import
import java.io.FileInputStream;				// themenspez. import
import java.io.FileOutputStream;			// themenspez. import
import java.io.ObjectInputStream;			// themenspez. import
import java.io.ObjectOutputStream;			// themenspez. import
import java.util.ArrayList;					// themenspez. import

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

public class IO_ObjektInputStream_ArrayListSpeichern_ObjektOutputStream_Serializable_JMyTextPanel_Aufruf_TextZeichner4 extends javax.swing.JFrame {

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	private JMyTextPanel jPanelTextflaeche;																									// zeichenfläche initialsieren, aber mit dem objektdatentyp JMyTextPanel (geerbt von JPanel)
	private JButton jBtnEnde;
	private JButton jBtnLoeschen;
	private ButtonGroup BtnGrpFarbe;																										// buttonGroup (nicht sichbar)
	private JRadioButton jRBRot;
	private JRadioButton jRBSchwarz;
	private JTextField jTFTexteingabe;
	private JLabel jLTexteingabe;
	private String dateiname = "." + File.separator + "textAusgabeObjekte.dat"; // dateiname mit pfad als string
	private ArrayList<TextAusgabeObjekt> meineTexte;							// ArrayList zur zwischen-speicherung der TextAusgabeObkjekte beim einlesen aus dem textAusgabeObjekte.dat-file, siehe ende initGUI() 

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				IO_ObjektInputStream_ArrayListSpeichern_ObjektOutputStream_Serializable_JMyTextPanel_Aufruf_TextZeichner4 inst = new IO_ObjektInputStream_ArrayListSpeichern_ObjektOutputStream_Serializable_JMyTextPanel_Aufruf_TextZeichner4();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public IO_ObjektInputStream_ArrayListSpeichern_ObjektOutputStream_Serializable_JMyTextPanel_Aufruf_TextZeichner4() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("TextZeichner 4, JMyTextPanel Texteinfügen mit auto-repaint() bei Frameveränderungen");
			getContentPane().setLayout(null);
			{
				jPanelTextflaeche = new JMyTextPanel();																						// zeichenfläche aus der selbsterstellten/abgeleiteten komponente JMyTextPanel
				getContentPane().add(jPanelTextflaeche);
				jPanelTextflaeche.setBackground(Color.white);
				jPanelTextflaeche.setBounds(12, 12, 354, 338);
				jPanelTextflaeche.addMouseListener(new MouseAdapter() {																		// Mouse-Event-handling
					public void mouseClicked(MouseEvent evt) {																				// wenn maustasten-klick
						jPanelTextflaecheMouseClicked(evt);																					// ausgelagerte handler-method für komponente JPanelTextflaeche
					}
				});
			}
			{
				jLTexteingabe = new JLabel();
				getContentPane().add(jLTexteingabe);
				jLTexteingabe.setText("Texteingabe:");
				jLTexteingabe.setBounds(384, 12, 126, 14);
			}
			{
				jTFTexteingabe = new JTextField();
				getContentPane().add(jTFTexteingabe);
				jTFTexteingabe.setBounds(384, 37, 183, 20);
			}
			{
				jRBSchwarz = new JRadioButton();
				getContentPane().add(jRBSchwarz);
				jRBSchwarz.setText("schwarz");
				jRBSchwarz.setSelected(true);
				jRBSchwarz.setBounds(400, 109, 103, 23);
				getBtnGrpFarbe().add(jRBSchwarz);																							// methode um RadioButton schwarz zu ButtonGroup BtnGrpFarbe hinzuzufügen
			}
			{
				jRBRot = new JRadioButton();
				getContentPane().add(jRBRot);
				jRBRot.setText("rot");
				jRBRot.setBounds(400, 135, 98, 27);
				getBtnGrpFarbe().add(jRBRot);																								// methode um RadioButton rot zu ButtonGroup BtnGrpFarbe hinzuzufügen
			}
			{
				jBtnLoeschen = new JButton();
				getContentPane().add(jBtnLoeschen);
				jBtnLoeschen.setText("Letzten Text löschen");
				jBtnLoeschen.setBounds(384, 204, 183, 23);
				jBtnLoeschen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnLoeschenActionPerformed(evt);
					}
				});
			}
			{
				jBtnEnde = new JButton();
				getContentPane().add(jBtnEnde);
				jBtnEnde.setText("Ende");
				jBtnEnde.setBounds(384, 274, 183, 23);
				jBtnEnde.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnEndeActionPerformed(evt);
					}
				});
			}
			{	// einlesen der TextAusgabeObjekte aus dem TextAusgabeObjekte.dat-file
				File datei = new File(dateiname);		// vergleichsfile erzeugen mit namen + pfad (dateiname) vom zu vergleichenden file
				if (!datei.exists()){					// wenn file mit dateiname nicht existiert..
					meineTexte = null;					// .. arrayList	meineTexte auf null setzen
				} else {								// ..sonst:
					meineTexte = readArrayList();		// ..meineTexte = methodenaufruf readArrayList() von unten in dieser klasse
				}
				if (meineTexte != null) {				// wenn arraylist meinetexte texte beinhalten
					jPanelTextflaeche.setArrayList(meineTexte);	// ArrayList von jPanelTextflaeche (=JMyTextPanel) via methode setArrayList() (auch von JMyTextPanel) meineTexte übergeben
				}
				datei.delete();							// vergleichs-file löschen
			}
			pack();
			this.setSize(600, 400);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

	private ButtonGroup getBtnGrpFarbe() {																									// methode für ButtonGroup BtnGrpFarbe, jigloo-auto-generiert
		if(BtnGrpFarbe == null) {
			BtnGrpFarbe = new ButtonGroup();
		}
		return BtnGrpFarbe;
	}
	
																																			// handler method für ereignis-behandlung bei maus-klick innerhalb jPanelTextflaeche
	private void jPanelTextflaecheMouseClicked(MouseEvent evt) {			
		int x = evt.getX();																													// variable für koordinate x bei mausklick, via ereignis-objekt evt. x abfragen
		int y = evt.getY();																													// dito für y
		String text = jTFTexteingabe.getText();
		Color farbe;									
		if (jRBSchwarz.isSelected()) {																										// wenn radiobutton schwarz angewählt ist..
			farbe = Color.black;																											// farbe auf schwarz
		} else {																															// sonst..
			farbe = Color.red;																												// farbe auf rot
		}
																																			// die anweisungen zum zeichnen des Textes fallen weg & werden durch die folgenden 2 anweisungen ersetzt:
		jPanelTextflaeche.addTextAusgabeObjekt(x, y, text, farbe);																			// methoden-aufruf zur erzeugung eines neuen TextAusgabeObjekts im JMyTextPanel unter mitgabe seiner eigenschaften (x, y, etc.)
		jPanelTextflaeche.repaint();																										// methode repaint für das textausgabe-panel, damit wird das übergebene TextAusgabeObjekt auch unmittelbar dargestellt
	}
	
																																			// methode um JMyTextPanel neu, minus das zuletzt hinzugefügte TextAusgabeObjekt, zu zeichnen
	private void jBtnLoeschenActionPerformed(ActionEvent evt) {
		jPanelTextflaeche.loescheLetztesTextObjekt();																						// aufruf der methode um das letzte TextAusgabeObjekt aus der arrralist texte (im JMyTextPanel) zu löschen 	
		jPanelTextflaeche.repaint();																										// xy.repaint() : panel neu zeichnen (inkl. verbleibende TextAusgabeObjekte der arraylist texte) 
	}

	// methode zum einlesen der TextAusgabeObjekte aus dem file mit dateinamen mittels ObjectInputStream
	private ArrayList<TextAusgabeObjekt> readArrayList() {								 	
		ArrayList<TextAusgabeObjekt> liste = new ArrayList<TextAusgabeObjekt>();		 	// lokale ArrayList liste vom typ TextAusgabeObjekt erzeugen
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dateiname));	// ObjectInputstream ois erzeugen unter mitgabe von neuem fileInputstream unter mitgabe von dateiname (inkl.pfad)
			liste = (ArrayList<TextAusgabeObjekt>)ois.readObject();							// ArrayList liste mit den objekten der datei befüllen, dazu methode ois.readObject() typgecastet benutzen 
			ois.close();																	// ObjectOutputStream schliessen
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Fehler beim Lesen aus Datei!");			// fehlermeldung 
			liste = null;																	// liste auf null falls fehler
		}
		return liste;																		// arraylist liste zurückgeben
	}
	
	// methode zum auslesen der TextAusgabeObjekte ins TextAusgabeObjekte.dat-file mittels ObjectOutputStream
	private void writeArrayList(ArrayList<TextAusgabeObjekt> liste){						
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dateiname, true));		// ObjectOutputStream oos erzeugen unter mitgabe von neuem fileInputstream unter mitgabe von dateiname (inkl.pfad) 
			oos.writeObject(liste);																		// arraylist liste aussschreiben mittels methode writeObject() der klasse OOS 
			oos.flush();																				// spühlen: schreiben der daten aus dem zwischenspeicher des oos erzwingen
			oos.close();																				// oos schliessen
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Fehler beim schreiben in Datei!");						
			e.printStackTrace();
		}
		
	}
	
	// handler method von jBtnEnde zum speichern der vorhandenen TextAusgabeObjekte ins TextAusgabeObjekte.dat-file		&	zum schliessen des fensters 
	private void jBtnEndeActionPerformed(ActionEvent evt) {									
		ArrayList<TextAusgabeObjekt> liste = new ArrayList<TextAusgabeObjekt>();	// lokale ArrayList liste vom typ TextAusgabeObjekt erzeugen
		liste = jPanelTextflaeche.getArrayList();									// via methode getArrayList() die vorhandenen textAusgabeObjekte aus ArrayList von jPanelTextflaeche (=JMyTextPanel) in lokale arraylist liste speichern
		writeArrayList(liste);														// methode writeArrayList unter übergabe von list aufrufen (um dort das TextAusgabeObjekte.dat-file mit den TextAusgabeObjekten zu erzeugen + zu speichern)
		System.exit(0);																// programm beenden + fenster schliessen 
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