/* TODO 13.4.4.   s.434,
 * class MausAlsZeichenGeraet_FreiesFigurAufziehen_MausKoordinaten_Fuer_JMyPaintPanel_KomponenteZumHineinZeichnen_Zeichnen7		&	JMyPaintPanel	&	Zeichenobjekt
 * 
 * 		ERWEITERUNG VON:	13.4.4.	  MausAlsZeichenGeraet_MausKoordinaten_MouseListener_MouseMotionListener_Fuer_JMyPaintPanel_KomponenteZumHineinZeichnen_Zeichnen6	s.431, 
 * 
 * 	  	SIEHE AUCH:	 		13.4.0.-13.4.2.   MouseEreignisse_Basics_Klassen_Methoden														s.425,
 *  
 *  
 * K&K:		Programm Zeichnen7 mit maus als Zeichenger�t (erweiterung von Zeichnen6) 
 * 			
 * 					[	Zeichnen6 (Unter Verwendung von Graphics2D statt Graphics & JColorChooser) 
 * 						Dem Anwender steht ein Panel, auf das er verschiedene geometrische Figuren zeichnen kann, zur Verf�gung. 
 * 						Position und Gr��e der Figuren k�nnen frei bestimmt werden.
 * 						Die Zeichnungen bleiben beim Neuzeichnen z.B. nach Verschieben des Fensters dauerhaft erhalten.	
 * 						die mouse-zeiger-koordinaten innerhalb der zeichenfl�che werden zur unterst�tzung der koordinaten-wahl, 
 * 						f�r das zeichnen der figuren, in einem zus�tzlichen label angezeigt. 
 * 						die maus kann auf dem panel wie ein zeichenger�t verwendet werden: man kann ein rechteck von oben li nach unten re aufziehen,
 * 						in welches die figuren nach loslassen der maustaste gezeichnet werden.										]
 * 
 * 			Mit verbesserter Funktionalit�t beim Aufziehen eines Rechtecks. Beim Aufziehen eines Rechtecks zur Vorgabe der Gr��e der zu zeichnenden
 * 			Figur muss nicht mit der linken oberen Ecke begonnen werden.
 * 
 * 
 * KLASSEN:		MouseListener, MouseMotionListener, MouseEvent:
 * 
 * 		SIEHE BASICS:	 		13.4.0.-13.4.2.   MouseEreignisse_Basics_Klassen_Methoden	 s.425,
 * 		
 * 
 * METHODEN:	mousePressed(), mouseDragged(), mouseReleased(), mouseEntered(), mouseExited(), mouseMoved(), getX(), getY():
 * 
 * 		SIEHE BASICS:	 		13.4.0.-13.4.2.   MouseEreignisse_Basics_Klassen_Methoden	 s.425,
 * 
 * 
 * IMPORTE:		import java.awt.event.MouseAdapter;						// guck macht jigloo z.b. automatisch beim erstellen von methoden der klasse MouseListener
 *				import java.awt.event.MouseEvent;			
 *				import java.awt.event.MouseMotionAdapter;
 *				
 *				=> MouseMotionListener & MouseListener werden anscheinend nicht importiert auch in javadoc landet man bei der klasse MouseAdapter	??!!
 * 
 * 
 * VORGEHEN:	1. programm MausKoordinatenAnzeigen_.._Zeichnen6 als ausgangsbasis		
 * 
 * 			[ 	2. - 10.	SIEHE UNTEN:		(aus	MausKoordinatenAnzeigen_.._Zeichnen6	�bernommen)		]
 * 
 * 				11. zus�tzliche variablen oben:		private int xStart, yStart;				// zur speicherung der jeweiligen anfangs x-y-koordinaten, da wo maustaste gedr�ckt wird
 * 
 * 				12. zus�tzliche ausgelagerte methode koordinatenBestimmen() zur bestimmung der kordinaten bzw. breite und h�he, 
 * 														-> je nachdem wo der start-/end-punkt einer figur liegt, sodass in alle richtungen gezeichnet werden kann
 * 
 *					CODE:
 *					
 *						private void koordinatenBestimmen() {
 *							if ((xEnd > xStart) && (yEnd > yStart)) {						// falls startpunkt der figur links oben:
 *								x1 = xStart;
 *								y1 = yStart;
 *								x2 = xEnd - xStart;
 *								y2 = yEnd - yStart;		
 *							} else if ((xEnd < xStart) && (yEnd > yStart)) {				// falls startpunkt der figur rechts oben:
 *								x1 = xEnd;
 *								y1 = yStart;
 *								x2 = xStart - xEnd;
 *								y2 = yEnd - yStart;	
 *							} else if ((xEnd > xStart) && (yEnd < yStart)) {				// falls startpunkt der figur links unten:
 *								x1 = xStart;
 *								y1 = yEnd;
 *								x2 = xEnd - xStart;
 *								y2 = yStart - yEnd;	
 *							} else if ((xEnd < xStart) && (yEnd < yStart)) {				// falls startpunkt der figur rechts unten:
 *								x1 = xEnd;
 *								y1 = yEnd;
 *								x2 = xStart - xEnd;
 *								y2 = yStart - yEnd;	
 *							}
 *						} 
 * 
 * 
 * 			[[[	2. - 10. �BERNOMMEN AUS .._Zeichnen6:		=> ausser kleinen anpassungen in 8., 9. + 10. 
 * 																-> auf die neue methode koordinatenBestimmen()	&	die neuen variablen xStart, yStart;
 * 														
 * 
 * 				2. jLabelMausposition erstellen, zur anzeige der Mauszeiger-koordinaten, wenn mauszeiger innerhalb von jPanelzeichenflaeche
 * 						-> zu beginn auf:		jLMausPosition.setVisible(false);	setzen												// soll nur sichtbar sein wenn mauszeiger �ber dem panel ist
 * 
 * 				3. jLabelMausposition sichtbar machen wenn mauszeiger jPanelzeichenflaeche betritt mittels:								// ausf�hrlich siehe .._Zeichnen5b
 * 
 * 					CODE:	private void jPanelZeichenflaecheMouseEntered(MouseEvent evt) {												// jigloo-autogenerierte mouseEntered(..)-handler-methode der klasse MouseListener f�r anweisungen bei eintritt des mauszeiger in die komponente jPanelZeichenflaeche
 *								jLMausPosition.setVisible(true);																		// jLMausPosition (= koordinaten-anzeige) sichtbar setzen (bei eintritt des mauszeigers ins panel)
 *							}
 * 
 * 				4. jLabelMausposition unsichtbar machen wenn mauszeiger jPanelZeichenflaeche verl�sst mittels: 							// ausf�hrlich siehe .._Zeichnen5b
 * 
 * 					CODE:	private void jPanelZeichenflaecheMouseExited(MouseEvent evt) {												// jigloo-autogenerierte mouseExited(..)-handler-methode der klasse MouseListener f�r anweisungen bei verlassen des mauszeigers aus der komponente jPanelZeichenflaeche
 *								jLMausPosition.setVisible(false);																		// jLMausPosition (= koordinaten-anzeige) unsichtbar setzen (bei austritt des mauszeigers aus dem panel)
 *							}	
 *							
 *				5. vorzu aktualisierte x,y - koordinaten anzeigen, solange mauszeiger �ber der jPanelZeichenflaeche ist mittels:		// ausf�hrlich siehe .._Zeichnen5b
 *
 *					CODE:	private void jPanelZeichenflaecheMouseMoved(MouseEvent evt) {												// jigloo-autogenerierte mouseMoved(..)-handler-methode der klasse MouseMotionListener f�r anweisungen bei bewegen des mauszeigers (ohne tastendr�cken) �ber der komponente jPanelZeichenflaeche
 *								jLMausPosition.setText("x: " + evt.getX() +																// mittels methode getX() des MouseEvent evt, vorzu die aktuelle koordinate x der mausposition im label anzeigen,  
 *										"   y: " + evt.getY()); 																		// mittels methode getY() des MouseEvent evt, vorzu die aktuelle koordinate y der mausposition im label anzeigen,
 *							}
 *
 *				6. zus�tzliche variablen oben:
 *
 *						private boolean zeichnen = false;																				// variable f�r: 	zeichnen, nur wenn vorher mouseDragged() vorher erfolgt ist 
 *						private int xEnd, yEnd;																							// variablen f�r x,y -koordinaten speziell an der stelle wo maustaste losgelasen (released) wird
 *
 *
 *				7. jPanelzeichenflaeche erh�lt 3 weitere Ereignis-methoden:	
 *					=> erstellen mit Jigloo:	bsp:	jPanelzeichenflaeche anklicken > gui properties > events > eventname > MouseListener > mousePressed() > handler method
 *										
 *					8. mousPressed()-methode der Klasse MouseListener:			=> bei maustaste dr�cken:			x-,y-koordinaten der linken oberen feststellen & in die textfelder �bernehmen
 *					9. mousDragged()-methode der Klasse MouseMotionListener:	=> bei gedr�ckter maustaste ziehen:	koordinaten der breite + h�he des aufgezogenen rechtecks bzw. des linienendpunktes feststellen & in die textfelder �bertragen,..
 *				   10. mousReleased()-methode der Klasse MouseListener.			=> bei maustaste loslassen:			wenn die maus zuvor gezogen wurde, die entsprechende figur zeichnen
 *
 *					KERN-CODE:  initGUI()-erg�nzungen - Jigloo autogeneriert:	 SCHEMA:
 *
 *						{
 *							jPanelZeichenflaeche = ..														
 *							...																		
 *							jPanelZeichenflaeche.addMouseListener(new MouseAdapter() {													// MouseListener mit MouseAdapter f�r die komponente, mit 2 verschiedenen ereignis-methoden..
 *								public void mousePressed(MouseEvent evt) {																// gew�nschte ereignis-methode mit ereignis-objekt als parameter
 *									jPanelZeichenflaecheMousePressed(evt);																// weitergabe an die komponenten-spezifischen (ausgelagerten) handler methode inkl ereignis-objekt
 *								}
 *								...
 *							});
 *						}
 *
 * 				8. 	..mousePressed() handler method: 	bei maustaste dr�cken:	x-,y-koordinaten der linken oberen feststellen & in die textfelder �bernehmen
 * 	
 * 					KERN-CODE:
 * 
 *	 					private void jPanelZeichenflaecheMousePressed(MouseEvent evt) {
 *							xStart = evt.getX();													// koordinate x bei tastendruck, mittels methode getX() des MouseEvent evt, in variable xStart speichern
 *							yStart = evt.getY();													// koordinate y bei tastendruck, mittels methode getY() des MouseEvent evt, in variable yStart speichern
 *							jTFPositionX1.setText(new Integer(xStart).toString());					// x als string ins textfeld x1 setzen 		alternativ : jTFPositionX1.setText("" + xStart);	
 *							jTFPositionY1.setText(new Integer(yStart).toString());					// y als string ins textfeld y1 setzen 		alternativ : jTFPositionY1.setText("" + yStart);
 *						}
 * 
 *				9.	..mouseDragged() handler method:	bei gedr�ckter maustaste ziehen:	koordinaten der breite + h�he des aufgezogenen rechtecks bzw. des linienendpunktes feststellen & in die textfelder �bertragen,..
 *	
 *					KERN-CODE:
 *	
 *						private void jPanelZeichenflaecheMouseDragged(MouseEvent evt) {
 *							xEnd = evt.getX();																										// vorzu koordinate x w�hrend dem draggen, mittels methode getX() des MouseEvent evt, in variable xEnd speichern		
 *							yEnd = evt.getY();																										// vorzu koordinate y w�hrend dem draggen, mittels methode getY() des MouseEvent evt, in variable yEnd speichern
 *							koordinatenBestimmen();													// aufruf der ausgelagerten methode zur bestimmung der kordinaten bzw. breite und h�he, je nachdem wo der start-/end-punkt einer figur liegt,
 *							jPanelZeichenflaeche.repaint();																							// repainten des panels damit beim aufziehen des aufzieh-rechtecks keine ausgef�llte fl�che entsteht ..
 *							Graphics2D g2d = (Graphics2D) jPanelZeichenflaeche.getGraphics();														// T	neues g2d objekt (f�r 2d grafik-kontext)
 *							g2d.setColor(Color.black);																								// |
 *							BasicStroke stil = new BasicStroke(1f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER); 									// |
 *							g2d.setStroke(stil);																									// |
 *							Rectangle2D.Float rechteck = new Rectangle2D.Float(x1, y1, x2, y2);														// v	(neues rechteck-objekt)
 *							g2d.draw(rechteck);																										// f�r gr�ssen-eindruck wird ein aufzieh-rechteck direkt gezeichnet, ohne dass es an paintComponent() �bermittelt wird  
 *							if (figur == 'L') {																										// falls figur == linie:
 *								jTFPositionX2.setText(new Integer(xEnd).toString());																// .. textfeld x2 auf auf x end koordinate setzen
 *								jTFPositionY2.setText(new Integer(yEnd).toString());																// .. textfeld y2 auf auf y end koordinate setzen
 *							} else {																												// sonst: ..
 *								jTFPositionX2.setText(new Integer(x2).toString());																	// .. textfeld x2 auf auf breite setzen
 *								jTFPositionY2.setText(new Integer(y2).toString());																	// .. textfeld y2 auf auf h�he setzen
 *							}
 *							zeichnen = true;																										// variabel f�r: zeichnen, falls mouseDragged() erfolgt ist (kurzfristig) auf true
 *						}
 *
 * 				10.	..mouseReleased() handler method:	bei maustaste loslassen:	wenn die maus zuvor gezogen wurde, die entsprechende figur zeichnen
 *	
 *					KERN-CODE:
 *	
 *						private void jPanelZeichenflaecheMouseReleased(MouseEvent evt) {
 *							if (zeichnen) {																											// falls (zeichnen == True) => wenn also mouseDragged() erfolgt ist
 *								xEnd = evt.getX();																									// koordinate x bei tasten-loslassen, mittels methode getX() des MouseEvent evt, in variable xEnd speichern
 *								yEnd = evt.getY();																									// koordinate y bei tasten-loslassen, mittels methode getY() des MouseEvent evt, in variable yEnd speichern
 *								koordinatenBestimmen();												// aufruf der ausgelagerten methode zur bestimmung der kordinaten bzw. breite und h�he, je nachdem wo der start-/end-punkt einer figur liegt,
 *								if (figur == 'L'){																									// falls figur == linie..
 *									jPanelZeichenflaeche.addZeichObjekt(figur, jCheckBgefuellt.isSelected(), xStart, yStart, xEnd, yEnd, farbe, 1.0f);	// zeichenobjekt linie via methode addZeichenObjekt des JMyPaintPanel-objekts jPanelzeichenflaeche ..
 *								} else {																											// ..  mit den parametern (figur, checkbox gef�llt/oder nicht, anfangs x y, end x y, farbe, linienbreite)
 *									jPanelZeichenflaeche.addZeichObjekt(figur, jCheckBgefuellt.isSelected(), x1, y1, x2, y2, farbe, 1.0f);	// sonst: zeichenobjekt gew�hlte figur zeichnen via methode addZeichenObjekt des JMyPaintPanel-objekts jPanelzeichenflaeche ..
 *								} 																													// ..  mit den parametern (figur, checkbox gef�llt/oder nicht, anfangs x y, breite, h�he, farbe, linienbreite) 
 *								jPanelZeichenflaeche.repaint();																						// panel repainten (=> paintComponent in JMyPaintPanel aktivieren) inklusive dem neuesten zeichenobjekt
 *								zeichnen = false;																									// mouseDragged() vorbei weil taste losgelassen => zeichnen wieder auf false
 *							}
 *						}
 *
 *				]]]	2.-10. FERTIG
 *						
 */

package uebungen13;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;																											// guck macht's automatisch beim erstellen von methoden der klasse MouseListener
import java.awt.event.MouseEvent;																											// guck
import java.awt.event.MouseMotionAdapter;																									// guck
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Float;
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

public class MausAlsZeichenGeraet_FreiesFigurAufziehen_MausKoordinaten_Fuer_JMyPaintPanel_KomponenteZumHineinZeichnen_Zeichnen7 extends javax.swing.JFrame {

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
	private JLabel jLMausPosition;																											// neues label zur anzeige der MouseKoordinaten, solange maus im JPanelZeichenfl�che ist
	private JRadioButton jRBtnLinie;
	private JRadioButton jRBtnOval;
	private JRadioButton jRBtnKreis;
	private JCheckBox jCheckBgefuellt;

	private char figur = 'R';																												// variable f�r anfangsbuchstaben der zu zeichnenden geom. figur ('L', 'O', 'K', 'R') f�r switch-case erkennung
	private int x1, y1, x2, y2;																												// variablen f�r speicherg. der parameterwerte aus den textfeldern
	private Color farbe = Color.black;
	private boolean zeichnen = false;																										// variable f�r: 	zeichnen, nur wenn vorher mouseDragged() erfolgt ist 
	private int xStart, yStart, xEnd, yEnd;				// variablen f�r x,y -koordinaten speziell an der stelle wo maustaste gedr�ckt & wo losgelassen wird
	
	
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MausAlsZeichenGeraet_FreiesFigurAufziehen_MausKoordinaten_Fuer_JMyPaintPanel_KomponenteZumHineinZeichnen_Zeichnen7 inst = new MausAlsZeichenGeraet_FreiesFigurAufziehen_MausKoordinaten_Fuer_JMyPaintPanel_KomponenteZumHineinZeichnen_Zeichnen7();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public MausAlsZeichenGeraet_FreiesFigurAufziehen_MausKoordinaten_Fuer_JMyPaintPanel_KomponenteZumHineinZeichnen_Zeichnen7() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Zeichnen 7, Komponente zum hineinzeichnen, mit Maus als Zeichenger�t (freies Figuraufziehen)");
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
				jPanelZeichenflaeche.addMouseMotionListener(new MouseMotionAdapter() {														// MouseMotionListener mit MouseMotionAdapter f�r die komponente 
					public void mouseDragged(MouseEvent evt) {																				// gew�nschte ereignis-methode mit ereignis-objekt als parameter
						jPanelZeichenflaecheMouseDragged(evt);																				// weitergabe an die komponenten-speziefischen (ausgelagerten) handler methode inkl ereignis-objekt
					}
					public void mouseMoved(MouseEvent evt) {																				// dito
						jPanelZeichenflaecheMouseMoved(evt);																				// dito
					}
				});
				jPanelZeichenflaeche.addMouseListener(new MouseAdapter() {																	// weitere mouse-ereignis-behandlungen mit 2 verschiedenen ereignis-methoden..
					public void mouseReleased(MouseEvent evt) {																				// gew�nschte ereignis-methode mit ereignis-objekt als parameter
						jPanelZeichenflaecheMouseReleased(evt);																				// weitergabe an die komponenten-speziefischen (ausgelagerten) handler methode inkl ereignis-objekt
					}
					public void mousePressed(MouseEvent evt) {																				// dito
						jPanelZeichenflaecheMousePressed(evt);																				// dito
					}
					public void mouseExited(MouseEvent evt) {																				// dito
						jPanelZeichenflaecheMouseExited(evt);																				// dito
					}
					public void mouseEntered(MouseEvent evt) {																				// dito
						jPanelZeichenflaecheMouseEntered(evt);																				// dito
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
				jLMausPosition = new JLabel();																								// neues label zur anzeige der MouseKoordinaten, solange maus im JPanelZeichenfl�che ist								
				getContentPane().add(jLMausPosition);
				jLMausPosition.setText("...");																								// test-text, eigtl. �berfl�ssig
				jLMausPosition.setVisible(false);																							// label (= mauskoordinaten) sollen nur sichtbar sein, wenn sich der maus-zeiger innerhalb von jPanelZeichenfl�che befindet
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
		jLMausPosition.setVisible(true);																									// jLMausPosition (= koordinaten-anzeige) sichtbar setzen (bei eintritt des mauszeigers ins panel)
	}
	
																																			// jigloo-autogenerierte mouseExited(..)-handler-methode der klasse MouseListener f�r anweisungen bei verlassen des mauszeigers aus der komponente jPanelZeichenflaeche
	private void jPanelZeichenflaecheMouseExited(MouseEvent evt) {	
		jLMausPosition.setVisible(false);																									// jLMausPosition (= koordinaten-anzeige) unsichtbar setzen (bei austritt des mauszeigers aus dem panel)
	}
	
																																			// jigloo-autogenerierte mouseMoved(..)-handler-methode der klasse MouseMotionListener f�r anweisungen bei bewegen des mauszeigers (ohne tastendr�cken) �ber der komponente jPanelZeichenflaeche
	private void jPanelZeichenflaecheMouseMoved(MouseEvent evt) {
		jLMausPosition.setText("x: " + evt.getX() +																							// mittels methode getX() des MouseEvent evt, vorzu die aktuelle koordinate x der mausposition im label anzeigen,  
								"   y: " + evt.getY()); 																					// mittels methode getY() des MouseEvent evt, vorzu die aktuelle koordinate y der mausposition im label anzeigen,	
	}
	
	// handler method: 	bei maustaste dr�cken:	x-,y-koordinaten der linken oberen feststellen & in die textfelder �bernehmen
	private void jPanelZeichenflaecheMousePressed(MouseEvent evt) {
		xStart = evt.getX();														// koordinate x bei tastendruck, mittels methode getX() des MouseEvent evt, in variable xStart speichern
		yStart = evt.getY();														// koordinate y bei tastendruck, mittels methode getY() des MouseEvent evt, in variable yStart speichern
		jTFPositionX1.setText(new Integer(xStart).toString());						// x als string ins textfeld x1 setzen 		alternativ : jTFPositionX1.setText("" + xStart);	
		jTFPositionY1.setText(new Integer(yStart).toString());						// y als string ins textfeld y1 setzen 		alternativ : jTFPositionY1.setText("" + yStart);
	}
	
	// handler method: bei gedr�ckter maustaste ziehen (draggen):	koordinaten der breite + h�he des aufgezogenen rechtecks bzw. des linienendpunktes feststellen & in die textfelder �bertragen,..
	private void jPanelZeichenflaecheMouseDragged(MouseEvent evt) {
		xEnd = evt.getX();																													// vorzu koordinate x w�hrend dem draggen, mittels methode getX() des MouseEvent evt, in variable xEnd speichern		
		yEnd = evt.getY();																													// vorzu koordinate y w�hrend dem draggen, mittels methode getY() des MouseEvent evt, in variable yEnd speichern
		koordinatenBestimmen();														// aufruf der ausgelagerten methode zur bestimmung der kordinaten bzw. breite und h�he, je nachdem wo der start-/end-punkt einer figur liegt,
		jPanelZeichenflaeche.repaint();																										// repainten des panels damit beim aufziehen des aufzieh-rechtecks keine ausgef�llte fl�che entsteht ..
		Graphics2D g2d = (Graphics2D) jPanelZeichenflaeche.getGraphics();																	// T	neues g2d objekt (f�r 2d grafik-kontext)
		g2d.setColor(Color.black);																											// |
		BasicStroke stil = new BasicStroke(1f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER); 												// |
		g2d.setStroke(stil);																												// |
		Rectangle2D.Float rechteck = new Rectangle2D.Float(x1, y1, x2, y2);																	// v	(neues rechteck-objekt)
		g2d.draw(rechteck);																													// f�r gr�ssen-eindruck wird ein aufzieh-rechteck direkt gezeichnet, ohne dass es an paintComponent() �bermittelt wird  
		if (figur == 'L') {																													// falls figur == linie:
			jTFPositionX2.setText(new Integer(xEnd).toString());																			// .. textfeld x2 auf auf x end koordinate setzen
			jTFPositionY2.setText(new Integer(yEnd).toString());																			// .. textfeld y2 auf auf y end koordinate setzen
		} else {																															// sonst: ..
			jTFPositionX2.setText(new Integer(x2).toString());																				// .. textfeld x2 auf auf breite setzen
			jTFPositionY2.setText(new Integer(y2).toString());																				// .. textfeld y2 auf auf h�he setzen
		}
		zeichnen = true;																													// variabel f�r: zeichnen, falls mouseDragged() erfolgt ist (kurzfristig) auf true
	}
	
	// handler method:	bei maustaste loslassen:	wenn die maus zuvor gezogen wurde, die entsprechende figur zeichnen
	private void jPanelZeichenflaecheMouseReleased(MouseEvent evt) {
		if (zeichnen) {																														// falls (zeichnen == True) => wenn also mouseDragged() erfolgt ist
			xEnd = evt.getX();																												// koordinate x bei tasten-loslassen, mittels methode getX() des MouseEvent evt, in variable xEnd speichern
			yEnd = evt.getY();																												// koordinate y bei tasten-loslassen, mittels methode getY() des MouseEvent evt, in variable yEnd speichern
			koordinatenBestimmen();													// aufruf der ausgelagerten methode zur bestimmung der kordinaten bzw. breite und h�he, je nachdem wo der start-/end-punkt einer figur liegt,
			if (figur == 'L'){																												// falls figur == linie..
				jPanelZeichenflaeche.addZeichObjekt(figur, jCheckBgefuellt.isSelected(), xStart, yStart, xEnd, yEnd, farbe, 1.0f);	// zeichenobjekt linie via methode addZeichenObjekt des JMyPaintPanel-objekts jPanelzeichenflaeche ..
			} else {																														// ..  mit den parametern (figur, checkbox gef�llt/oder nicht, anfangs x y, end x y, farbe, linienbreite)
				jPanelZeichenflaeche.addZeichObjekt(figur, jCheckBgefuellt.isSelected(), x1, y1, x2, y2, farbe, 1.0f);	// sonst: zeichenobjekt gew�hlte figur zeichnen via methode addZeichenObjekt des JMyPaintPanel-objekts jPanelzeichenflaeche ..
			} 																																// ..  mit den parametern (figur, checkbox gef�llt/oder nicht, anfangs x y, breite, h�he, farbe, linienbreite)
			jPanelZeichenflaeche.repaint();																									// panel repainten (=> paintComponent in JMyPaintPanel aktivieren) inklusive dem neuesten zeichenobjekt
			zeichnen = false;																												// mouseDragged() vorbei weil taste losgelassen => zeichnen wieder auf false
		}
	}
	
	// ausgelagerte methode zur bestimmung der kordinaten bzw. breite und h�he, je nachdem wo der start-/end-punkt einer figur liegt, sodass in alle richtungen gezeichnet werden kann
	private void koordinatenBestimmen() {
		if ((xEnd > xStart) && (yEnd > yStart)) {						// falls startpunkt der figur links oben:
			x1 = xStart;
			y1 = yStart;
			x2 = xEnd - xStart;
			y2 = yEnd - yStart;		
		} else if ((xEnd < xStart) && (yEnd > yStart)) {				// falls startpunkt der figur rechts oben:
			x1 = xEnd;
			y1 = yStart;
			x2 = xStart - xEnd;
			y2 = yEnd - yStart;	
		} else if ((xEnd > xStart) && (yEnd < yStart)) {				// falls startpunkt der figur links unten:
			x1 = xStart;
			y1 = yEnd;
			x2 = xEnd - xStart;
			y2 = yStart - yEnd;	
		} else if ((xEnd < xStart) && (yEnd < yStart)) {				// falls startpunkt der figur rechts unten:
			x1 = xEnd;
			y1 = yEnd;
			x2 = xStart - xEnd;
			y2 = yStart - yEnd;	
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