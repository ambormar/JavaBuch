/* TODO 13.4.3.   s.429, !!!!!!!!!!!!!!!!!!!!!!!!!!!! MouseListener / MouseAdapter - code erg�nzungen im initGUI noch kommentieren!!!
 * class MausKoordinatenAnzeigen_MouseListener_MouseMotionListener_Fuer_JMyPaintPanel_KomponenteZumHineinZeichnen_Zeichnen5b		&	JMyPaintPanel	&	Zeichenobjekt
 * 
 * 		ERWEITERUNG VON:	13.3.2.	  JColorChooser_FarbauswahlDialog_JColorPanel_Fuer_JMyPaintPanel_KomponenteZumHineinZeichnen_Zeichnen5	s.423, (3. ANSATZ)  MIT REPAINT() bei framever�nderungen; mit Graphics2D
 * 
 * 	  	SIEHE AUCH:	 		13.4.0.-13.4.2.   MouseEreignisse_Basics_Klassen_Methoden														s.425,
 *  
 *  
 * K&K:		Programm Zeichnen5b (erweiterung von Zeichnen5) 
 * 			
 * 					[	Zeichnen5 (Unter Verwendung von Graphics2D statt Graphics & JColorChooser) 
 * 						Dem Anwender steht ein Panel, auf das er verschiedene geometrische Figuren zeichnen kann, zur Verf�gung. 
 * 						Position und Gr��e der Figuren k�nnen frei bestimmt werden.
 * 						Die Zeichnungen bleiben beim Neuzeichnen z.B. nach Verschieben des Fensters dauerhaft erhalten.	]
 * 
 * 			die mouse-zeiger-koordinaten innerhalb der zeichenfl�che werden zur unterst�tzung der koordinaten-wahl, f�r das zeichnen der figuren, 
 * 			in einem zus�tzlichen label angezeigt.  
 * 						
 * 
 * KLASSEN MouseListener, MouseMotionListener, MouseEvent:
 * 
 * 		SIEHE BASICS:	 		13.4.0.-13.4.2.   MouseEreignisse_Basics_Klassen_Methoden	 s.425,
 * 		
 * 
 * METHODEN mouseEntered(), mouseExited(), mouseMoved(), getX(), getY()
 * 
 * 		SIEHE BASICS:	 		13.4.0.-13.4.2.   MouseEreignisse_Basics_Klassen_Methoden	 s.425,
 * 
 * 
 * IMPORTE:		import java.awt.event.MouseAdapter;						// guck macht jigloo z.b. automatisch beim erstellen von methoden der klasse MouseListener
 *				import java.awt.event.MouseEvent;			
 *				import java.awt.event.MouseMotionAdapter;
 * 
 * 
 * VORGEHEN:	1. programm JColorChooser_.._Zeichnen5 als ausgangsbasis		!!!!!!!!!!!!!!!!!!!!!!!!!!!! MouseListener / MouseAdapter - code erg�nzungen im initGUI noch kommentieren!!!
 * 
 * 				2. jLabelMausposition erstellen, zur anzeige der Mauszeiger-koordinaten, wenn mauszeiger innerhalb von jPanelzeichenflaeche
 * 						-> zu beginn auf:		jLMausPosition.setVisible(false);	setzen							// soll nur sichtbar sein wenn mauszeiger �ber dem panel ist
 * 
 * 				3. jLabelMausposition sichtbar machen wenn mauszeiger jPanelzeichenflaeche betritt mittels:
 * 					-> mousEntered()-handler-methode der Klasse MouseListener	& 	anweisung darin:	jLMausPosition.setVisible(true);
 * 						=> erstellen der methode mit Jigloo:		
 * 							jPanelzeichenflaeche anklicken > gui properties > events > eventname > MouseListener > mouseEntered() > handler method
 * 						=> oder Quelcode direkt:
 * 							Komponentenname & anh�ngen MethodenName & parameter MouseEvent evt. 
 * 					
 * 					CODE:	private void jPanelZeichenflaecheMouseEntered(MouseEvent evt) {												// jigloo-autogenerierte mouseEntered(..)-handler-methode der klasse MouseListener f�r anweisungen bei eintritt des mauszeiger in die komponente jPanelZeichenflaeche
 *								jLMausPosition.setVisible(true);																		// jLMausPosition (= koordinaten-anzeige) sichtbar setzen (bei eintritt des mauszeigers ins panel)
 *							}
 * 
 * 				4. jLabelMausposition unsichtbar machen wenn mauszeiger jPanelZeichenflaeche verl�sst mittels:
 * 					-> mousExited()-handler-methode der Klasse MouseListener	& 	anweisung darin:	jLMausPosition.setVisible(false);
 * 						=> analog 3. 
 * 					
 * 					CODE:	private void jPanelZeichenflaecheMouseExited(MouseEvent evt) {												// jigloo-autogenerierte mouseExited(..)-handler-methode der klasse MouseListener f�r anweisungen bei verlassen des mauszeigers aus der komponente jPanelZeichenflaeche
 *								jLMausPosition.setVisible(false);																		// jLMausPosition (= koordinaten-anzeige) unsichtbar setzen (bei austritt des mauszeigers aus dem panel)
 *							}	
 *							
 *				5. vorzu aktualisierte x,y - koordinaten anzeigen, solange mauszeiger �ber der jPanelZeichenflaeche ist mittels:
 *					-> mousMoved()-handler-methode der Klasse MouseMotionListener zur erfassung der mausbewegung und erzeugung eines entsprechenden MouseEvents 	
 * 						=> analog 3.
 *					-> & darin mit den methoden [der Klasse MouseEvent]:  evt.getX() / evt.getY() 			x-y-koordinaten des ereignisses ermitteln + im label anzeigen	
 *			
 *					CODE:	private void jPanelZeichenflaecheMouseMoved(MouseEvent evt) {												// jigloo-autogenerierte mouseMoved(..)-handler-methode der klasse MouseMotionListener f�r anweisungen bei bewegen des mauszeigers (ohne tastendr�cken) �ber der komponente jPanelZeichenflaeche
 *								jLMausPosition.setText("x: " + evt.getX() +																// mittels methode getX() des MouseEvent evt, vorzu die aktuelle koordinate x der mausposition im label anzeigen,  
 *										"   y: " + evt.getY()); 																		// mittels methode getY() des MouseEvent evt, vorzu die aktuelle koordinate y der mausposition im label anzeigen,
 *							}
 *
 * 
 */

package uebungen13;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;			// guck macht's automatisch beim erstellen von methoden der klasse MouseListener
import java.awt.event.MouseEvent;			// guck
import java.awt.event.MouseMotionAdapter;	// guck
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.ButtonGroup;						 
import javax.swing.JButton;
import javax.swing.JCheckBox;						
import javax.swing.JColorChooser;																											// themenspez. import guck !!!
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;					
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

public class MausKoordinatenAnzeigen_MouseListener_MouseMotionListener_Fuer_JMyPaintPanel_KomponenteZumHineinZeichnen_Zeichnen5b extends javax.swing.JFrame {

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private JLabel jLZeichenflaeche;
	private JLabel jLPositionX1;
	private JLabel jLPositionY1;
	private JLabel jLPositionX2;
	private JLabel jLPositionY2;
	private JTextField jTFPositionY2;
	private JTextField jTFPositionX2;
	private JTextField jTFPositionY1;
	private JTextField jTFPositionX1;
	private JMyPaintPanel jPanelZeichenflaeche;																								// zeichenfl�che initialsieren, aber mit dem objektdatentyp JMyPaintPanel (geerbt von JPanel)
	private JPanel jColorPanel;																												// neues minipanel zur aktuellen farbwahl-anzeige 
	private JButton jBtnEnde;
	private JButton jBtnZeichnen;
	private JButton jBtnLoeschen;
	private JButton jBtnFarbwahl;																											// neuer button f�r farbwahl
	private ButtonGroup BtnGrpFigure;																										// mit jigloo erzeugte variable  
	private JRadioButton jRBtnReckteck;
	private JLabel jLMausPosition;						// neues label zur anzeige der MouseKoordinaten, solange maus im JPanelZeichenfl�che ist
	private JRadioButton jRBtnLinie;
	private JRadioButton jRBtnOval;
	private JRadioButton jRBtnKreis;
	private JCheckBox jCheckBgefuellt;

	private char figur = 'R';																												// variable f�r anfangsbuchstaben der zu zeichnenden geom. figur ('L', 'O', 'K', 'R') f�r switch-case erkennung
	private int x1, y1, x2, y2;																												// variablen f�r speicherg. der parameterwerte aus den textfeldern
	private Color farbe = Color.black;
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MausKoordinatenAnzeigen_MouseListener_MouseMotionListener_Fuer_JMyPaintPanel_KomponenteZumHineinZeichnen_Zeichnen5b inst = new MausKoordinatenAnzeigen_MouseListener_MouseMotionListener_Fuer_JMyPaintPanel_KomponenteZumHineinZeichnen_Zeichnen5b();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public MausKoordinatenAnzeigen_MouseListener_MouseMotionListener_Fuer_JMyPaintPanel_KomponenteZumHineinZeichnen_Zeichnen5b() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Zeichnen 3");
			getContentPane().setBackground(new java.awt.Color(236, 233, 216));
			{
				jLZeichenflaeche = new JLabel();
				getContentPane().add(jLZeichenflaeche);
				jLZeichenflaeche.setText("Zeichenfl�che");
				jLZeichenflaeche.setBounds(12, 12, 135, 16);
			}
			{
				jPanelZeichenflaeche = new JMyPaintPanel();																					// zeichenfl�che aus der selbsterstellten/abgeleiteten komponente JMyPaintPanel
				getContentPane().add(jPanelZeichenflaeche);
				jPanelZeichenflaeche.setBounds(12, 40, 336, 410);
				jPanelZeichenflaeche.setBackground(new java.awt.Color(255,255,255));														// hintergrund auf weiss setzen mit gui properties
				// mouse-Ereignis-behandlung
				jPanelZeichenflaeche.addMouseMotionListener(new MouseMotionAdapter() {	// MouseMotionListener mit MouseMotionAdapter f�r die komponente 
					public void mouseMoved(MouseEvent evt) {							// gew�nschte ereignis-methode mit ereignis-objekt als parameter
						jPanelZeichenflaecheMouseMoved(evt);							// weitergabe an die komponenten-speziefischen (ausgelagerten) handler methode inkl ereignis-objekt
					}
				});
				jPanelZeichenflaeche.addMouseListener(new MouseAdapter() {				// weitere mouse-ereignis-behandlungen mit 2 verschiedenen ereignis-methoden..
					public void mouseExited(MouseEvent evt) {							// gew�nschte ereignis-methode mit ereignis-objekt als parameter
						jPanelZeichenflaecheMouseExited(evt);							// weitergabe an die komponenten-speziefischen (ausgelagerten) handler methode inkl ereignis-objekt
					}
					public void mouseEntered(MouseEvent evt) {							// dito
						jPanelZeichenflaecheMouseEntered(evt);							// dito
					}
				});
			}
			{
				jColorPanel = new JPanel();																									// neues panel als kleines farbauswahl-anzeige panel, hinter dem farbwahl-button, dessen hintergrundfarbe ..
				getContentPane().add(jColorPanel);																							// .. in der ereignisbehandlung auf die aktuelle zeichenfarbe gesetzt wird
				jColorPanel.setBounds(595, 256, 25, 23);
			}
			{
				jLPositionX1 = new JLabel();
				getContentPane().add(jLPositionX1);
				jLPositionX1.setText("Position x:");
				jLPositionX1.setBounds(375, 12, 65, 16);
			}
			{
				jTFPositionX1 = new JTextField();
				getContentPane().add(jTFPositionX1);
				jTFPositionX1.setBounds(440, 9, 64, 23);
				jTFPositionX1.setText("0");
			}
			{
				jLPositionY1 = new JLabel();
				getContentPane().add(jLPositionY1);
				jLPositionY1.setText("y:");
				jLPositionY1.setBounds(566, 12, 24, 16);
			}
			{
				jTFPositionY1 = new JTextField();
				getContentPane().add(jTFPositionY1);
				jTFPositionY1.setBounds(590, 9, 64, 23);
				jTFPositionY1.setText("0");
			}
			{
				jLPositionX2 = new JLabel();
				getContentPane().add(jLPositionX2);
				jLPositionX2.setText("Breite:");
				jLPositionX2.setBounds(375, 51, 65, 16);
			}
			{
				jTFPositionX2 = new JTextField();
				getContentPane().add(jTFPositionX2);
				jTFPositionX2.setBounds(440, 48, 64, 23);
				jTFPositionX2.setText("0");
			}
			{
				jLPositionY2 = new JLabel();
				getContentPane().add(jLPositionY2);
				jLPositionY2.setText("H�he:");
				jLPositionY2.setBounds(543, 51, 47, 16);
			}
			{
				jTFPositionY2 = new JTextField();
				getContentPane().add(jTFPositionY2);
				jTFPositionY2.setBounds(590, 48, 64, 23);
				jTFPositionY2.setText("0");
			}
			{
				jCheckBgefuellt = new JCheckBox();
				getContentPane().add(jCheckBgefuellt);
				jCheckBgefuellt.setText("gef�llt");
				jCheckBgefuellt.setBounds(543, 108, 99, 20);
			}
			{
				jRBtnReckteck = new JRadioButton();
				getContentPane().add(jRBtnReckteck);
				jRBtnReckteck.setText("Rechteck");
				jRBtnReckteck.setBounds(418, 108, 99, 20);
				jRBtnReckteck.setSelected(true);
				jRBtnReckteck.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jRBtnReckteckActionPerformed(evt);
					}
				});
				getBtnGrpFigure().add(jRBtnReckteck);																						// in den properties die zuordnung zur buttonGroup BtnGrpFigure einstellen 
			}																																// via getter-methode verschaft sich der frame zugriff auf die readiogroup (BtnGrpFigure)
			{
				jRBtnKreis = new JRadioButton();
				getContentPane().add(jRBtnKreis);
				jRBtnKreis.setText("Kreis");
				jRBtnKreis.setBounds(418, 142, 86, 23);
				jRBtnKreis.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jRBtnKreisActionPerformed(evt);
					}
				});
				getBtnGrpFigure().add(jRBtnKreis);																							// in den properties die zuordnung zur buttonGroup BtnGrpFigure einstellen 
			}
			{
				jRBtnOval = new JRadioButton();
				getContentPane().add(jRBtnOval);
				jRBtnOval.setText("Oval");
				jRBtnOval.setBounds(418, 182, 86, 23);
				jRBtnOval.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jRBtnOvalActionPerformed(evt);
					}
				});
				getBtnGrpFigure().add(jRBtnOval);																							// in den properties die zuordnung zur buttonGroup BtnGrpFigure einstellen 
			}
			{
				jRBtnLinie = new JRadioButton();
				getContentPane().add(jRBtnLinie);
				jRBtnLinie.setText("Linie");
				jRBtnLinie.setBounds(418, 221, 86, 23);
				jRBtnLinie.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jRBtnLinieActionPerformed(evt);
					}
				});
				getBtnGrpFigure().add(jRBtnLinie);																							// in den properties die zuordnung zur buttonGroup BtnGrpFigure einstellen 
			}
			{
				jBtnFarbwahl = new JButton();																								// neuer button f�r farbwahl
				getContentPane().add(jBtnFarbwahl);
				jBtnFarbwahl.setText("Zeichenfarbe w�hlen");
				jBtnFarbwahl.setBounds(418, 256, 161, 23);
				jBtnFarbwahl.addActionListener(new ActionListener() {																		// inkl. event-handling
					public void actionPerformed(ActionEvent evt) {
						jBtnFarbwahlActionPerformed(evt);
					}
				});
			}
			{
				jBtnZeichnen = new JButton();
				getContentPane().add(jBtnZeichnen);
				jBtnZeichnen.setText("Zeichnen");
				jBtnZeichnen.setBounds(418, 294, 202, 23);
				jBtnZeichnen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnZeichnenActionPerformed(evt);
					}
				});
			}
			{
				jBtnLoeschen = new JButton();
				getContentPane().add(jBtnLoeschen);
				jBtnLoeschen.setText("Letzte Zeichnung l�schen");
				jBtnLoeschen.setBounds(418, 333, 202, 23);
				jBtnLoeschen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnLoeschenActionPerformed(evt);
					}
				});
			}
			{													
				jLMausPosition = new JLabel();					// neues label zur anzeige der MouseKoordinaten, solange maus im JPanelZeichenfl�che ist								
				getContentPane().add(jLMausPosition);
				jLMausPosition.setText("...");					// test-text, eigtl. �berfl�ssig
				jLMausPosition.setVisible(false);				// label (= mauskoordinaten) sollen nur sichtbar sein, wenn sich der maus-zeiger innerhalb von jPanelZeichenfl�che befindet
				jLMausPosition.setBounds(418, 412, 202, 26);
			}
			{
				jBtnEnde = new JButton();
				getContentPane().add(jBtnEnde);
				jBtnEnde.setText("Ende");
				jBtnEnde.setBounds(418, 372, 202, 23);
				jBtnEnde.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnEndeActionPerformed(evt);
					}
				});
			}
			pack();
			setSize(700, 500);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

																																			// getter-methode f�r ButtonGroup;  Jigloo-erzeugt; entsprechende variable wird oben auch autoerzeugt
	private ButtonGroup getBtnGrpFigure() {																									// methode liefert referenz auf die ButtonGroup
		if(BtnGrpFigure == null) {																											// pr�ft ob bereits objekt erzeugt wurde, wenn nicht ..
			BtnGrpFigure = new ButtonGroup();																								// .. wird konstruktor aufgerufen (objekt erzeugt) ..
		}
		return BtnGrpFigure;																												// .. und die referenz auf das objekt zur�ckgeliefert
	}
	
	   																																		//  Methode zum beschriften/anpassen der textfelder je nach radiobutton-auswahl (rechteck, kreis, oval oder linie!!)
	private void setzeBeschriftungen(){ 			
		if (jRBtnLinie.isSelected()) {																										// wenn linie gew�hlt ist: ..
			jLPositionX1.setText("Startpunkt x:");																							// .. verschiedene labels f�r die textfelder anpassen f�r parameter-werte (x1,y1,x2,y2) [y1 bleibt immer gleich]
			jLPositionX2.setText("Endpunkt x:");
			jLPositionY2.setText("      y:");
		} else {																															// wenn rechteck, oval, kreis:..
			jLPositionX1.setText("Position x:");																							// ... labels anpassen auf parameter-werte (x1, y1, breite, h�he) [y1 bleibt immer gleich]				
			jLPositionX2.setText("Breite:");
			jLPositionY2.setText("H�he:");
		}
	}
	
	private void jRBtnReckteckActionPerformed(ActionEvent evt) {																			// bei w�hlen des radiobuttons rechteck
		setzeBeschriftungen();																												// beschriftung der textfelder anpassen 
		jCheckBgefuellt.setVisible(true);																									// checkbox sichtbar machen weil rechteck gef�llt werden kann
		jLPositionY2.setVisible(true);																										// y2 label "wieder" sichtbar machen
		jTFPositionY2.setVisible(true); 																									// y2 TF "wieder" sichtbar machen
		figur = 'R';																														// char-variable 0 (f�r geom. Figur rechteck) f�r sp�tere verwendung im switch-case der zeichnen-methode 
	}
	
	private void jRBtnKreisActionPerformed(ActionEvent evt) {																				// bei w�hlen des radiobuttons kreis
		setzeBeschriftungen();																												// beschriftung der textfelder anpassen 
		jCheckBgefuellt.setVisible(true);																									// checkbox sichtbar machen weil kreis gef�llt werden kann
		jLPositionY2.setVisible(false);																										// y2 label unsichtbar machen, weil h�he bei kreis nicht gew�hlt werden soll
		jTFPositionY2.setVisible(false); 																									// y2 TF unsichtbar machen, 					"
		figur = 'K';																														// char-variable 0 (f�r geom. Figur kreis) f�r sp�tere verwendung im switch-case der zeichnen-methode 
	}
	
	private void jRBtnOvalActionPerformed(ActionEvent evt) {																				// bei w�hlen des radiobuttons oval
		setzeBeschriftungen();																												// beschriftung der textfelder anpassen 
		jCheckBgefuellt.setVisible(true);																									// checkbox sichtbar machen weil oval gef�llt werden kann
		jLPositionY2.setVisible(true);																										// y2 label "wieder" sichtbar machen
		jTFPositionY2.setVisible(true); 																									// y2 TF "wieder" sichtbar machen
		figur = 'O';																														// char-variable 0 (f�r geom. Figur oval) f�r sp�tere verwendung im switch-case der zeichnen-methode 
	}
	
	private void jRBtnLinieActionPerformed(ActionEvent evt) {																				// bei w�hlen des radiobuttons Linie
		setzeBeschriftungen();																												// beschriftung der textfelder anpassen 
		jCheckBgefuellt.setVisible(false);																									// checkbox unsichtbar machen weil eine linie ja nicht gef�llt werden kann
		jLPositionY2.setVisible(true);																										// y2 label "wieder" sichtbar machen
		jTFPositionY2.setVisible(true); 																									// y2 TF "wieder" sichtbar machen
		figur = 'L';																														// char-variable L (f�r geom. Figur linie) f�r sp�tere verwendung im switch-case der zeichnen-methode 
	}
	
																																			// methode um den Farbauswahl-Dialog JColorCooser aufzurufen & und so die zeichenfarbe zu setzen
	private void jBtnFarbwahlActionPerformed(ActionEvent evt) {
																																			// klassen-methode showDialog (..) von JColorCooser, aufruf �ber den Klassennamen, ohne erzeugte instanz der klasse..
		farbe = JColorChooser.showDialog(null, "W�hle neue zeichenfarbe", Color.black);														// .. mit parameter: eltern-komponente oder null, titel-text f�r dialogfenster, anfangsfarbe 
		jColorPanel.setBackground(farbe);																									// vom zus�tzlichen kleinen farbauswahl-panel wird die intergrundfarbe auf die aktuelle zeichenfarbe gesetzt + diese so im frame angezeigt						
	}
	
																																			// (abge�nderte) methode zum indirekten zeichnen der geometrischen figuren auf das jPanelZeichenflaeche
	private void jBtnZeichnenActionPerformed(ActionEvent evt) {
		try {
			x1 = Integer.parseInt(jTFPositionX1.getText());																					// parameterwerte aus den TextFeldern zwischenspeichern
			y1 = Integer.parseInt(jTFPositionY1.getText());																					// "
			x2 = Integer.parseInt(jTFPositionX2.getText());																					// "
			y2 = Integer.parseInt(jTFPositionY2.getText());																					// "
																																			// alle anweisungen zum zeichnen der zeichenobjekte fallen weg & werden durch die folgenden 2 anweisungen ersetzt:
			jPanelZeichenflaeche.addZeichObjekt(figur, jCheckBgefuellt.isSelected(), x1, y1, x2, y2, farbe, 1.0f);							// methoden-aufruf zur �bergabe der eigenschaften des zu zeichnenden zeichenobjekts an das panel..
																																			//.. die eigenschaften werden aus den text- & optionsfeldern entnommen, die strichst�rke direkt, die farbe als eigenschaft des frames
			jPanelZeichenflaeche.repaint();																									// methode repaint f�r das zeichen-panel, damit wird das �bergebene zeichenobjekt auch unmitelbar dargestellt
		} catch (Exception e){																												// fehlerausgabe f�r fehler beim zeichnen
			JOptionPane.showMessageDialog(this, "Die Eingaben sind ung�ltig");
		}
	}
	
	private void jBtnEndeActionPerformed(ActionEvent evt) {
		System.exit(0);
	}
	
																																			// methode um JMyPaintPanel neu, minus das zuletzt hinzugef�gte zeichenobjekt, zu zeichnen
	private void jBtnLoeschenActionPerformed(ActionEvent evt) {													
			jPanelZeichenflaeche.loescheLetztesZeichenObjekt(); 																			// aufruf der methode um das letzte zeichenobjekt aus der arrralist figuren (im JMyPaintPanel) zu l�schen 								
			jPanelZeichenflaeche.repaint();																									// xy.repaint() : panel neu zeichnen (inkl. verbleibende zeichenobjekte der arraylist figuren) 
	}

	// jigloo-autogenerierte mouseEntered(..)-handler-methode der klasse MouseListener f�r anweisungen bei eintritt des mauszeiger in die komponente jPanelZeichenflaeche
	private void jPanelZeichenflaecheMouseEntered(MouseEvent evt) {	
		jLMausPosition.setVisible(true);							// jLMausPosition (= koordinaten-anzeige) sichtbar setzen (bei eintritt des mauszeigers ins panel)
	}
	
	// jigloo-autogenerierte mouseExited(..)-handler-methode der klasse MouseListener f�r anweisungen bei verlassen des mauszeigers aus der komponente jPanelZeichenflaeche
	private void jPanelZeichenflaecheMouseExited(MouseEvent evt) {	
		jLMausPosition.setVisible(false);							// jLMausPosition (= koordinaten-anzeige) unsichtbar setzen (bei austritt des mauszeigers aus dem panel)
	}
	
	// jigloo-autogenerierte mouseMoved(..)-handler-methode der klasse MouseMotionListener f�r anweisungen bei bewegen des mauszeigers (ohne tastendr�cken) �ber der komponente jPanelZeichenflaeche
	private void jPanelZeichenflaecheMouseMoved(MouseEvent evt) {
		jLMausPosition.setText("x: " + evt.getX() +		// mittels methode getX() des MouseEvent evt, vorzu die aktuelle koordinate x der mausposition im label anzeigen,  
								"   y: " + evt.getY()); // mittels methode getY() des MouseEvent evt, vorzu die aktuelle koordinate y der mausposition im label anzeigen,
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