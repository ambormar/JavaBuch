/* TODO 13.2.5.   s.413, (3. ANSATZ)  MIT REPAINT() bei framever�nderungen; mit Graphics2D
 * class JMyPaintPanel_Aufruf_KomponenteZumHineinZeichnen_paintComponentLernfaehig_RepaintBeiFrameveraenderungen_Zeichnen4	&	JMyPaintPanel	&	Zeichenobjekt
 * 
 * 		VERGLEICHE:			13.2.4.   Graphics2D_JPanel_Komponente_ZumHineinZeichnen_Zeichnen3							s.413, oben (2. ANSATZ) mit Graphics2D; OHNE REPAINT() bei framever�nderungen
 * 
 * 		SIEHE BASICS:		13.2.4.	  Graphics2D_API_Klasse_Methoden_Basics												s.410
 * 
 * 		VERGLEICHE:	 		13.2.1.   JPanel_Komponente_ZumHineinZeichnen_RadioGroup_getGraphics_Zeichnen2				s.403, (2. ANSATZ) OHNE REPAINT() bei framever�nderungen
 *  		
 * 	[[[	VERGL. AUCH:			13.1.2.   JPanel_Komponente_MitVer�ndertemAussehen_JMyPanelZeichnen1	&	JMyPanel 		s.400+(398), (= 1. ANSATZ) INKL. REPAINT() bei framever�nderungen	]]]
 * 
 * 
 * K&K:		Programm Zeichnen4 (erweiterung von Zeichnen3) 
 * 			(Unter Verwendung von Graphics2D statt Graphics)
 * 						
 * 			Dem Anwender steht ein Panel, auf das er verschiedene geometrische Figuren zeichnen kann, zur Verf�gung. 
 * 			Position und Gr��e der Figuren k�nnen frei bestimmt werden.
 * 			Die Zeichnungen bleiben beim Neuzeichnen z.B. nach Verschieben des Fensters dauerhaft erhalten.
 * 
 * 
 * PROGRAMM MIT STANDARDKOMPONENTE (hier Panel) MIT LERNF�HIGER PAINT() / PAINTCOMPONENT-METHODE, 
 * 												ZUM HINEINZEICHNEN VON ZEICHENOBJEKTEN - MIT REPAINT() BEI FRAMEVER�NDERUNGEN (INKL. DER GEZEICHENETEN OBJEKTE), (3.ANSATZ):
 * 
 * 		BESTEHEND AUS:	
 * 
 * 			1. class Zeichenobjekt							=> klasse zur speicherung der informationen zu einer geometrischen figur
 * 
 * 			2. class JMyPaintPanel (extends JPanel)			=> von JPanel abgeleitete klasse mit:	beh�lter (ArrayList) f�r geometrische figuren	&	lernf�higer paintComponent()-methode
 * 
 * 			3. JMyPaintPanel_RepaintBeiFrameveraenderungen_Komponente_ZumHineinZeichnen_Zeichnen4			=> von JFrame abgeleitete klasse als zeichenproramm
 * 
 * 
 * 1. ZEICHENOBJEKT
 * 
 * 		K&K:		Klasse Zeichenobjekt: Die Klasse beschreibt zu zeichnende Objekte so, dass sie in einer ArrayList gespeichert werden k�nnen.
 * 
 * 		VORGEHEN:	1. klasse ZeichenObjekt mit den Eigenschaften der zu zeichnenden figuren:	- typ der figur (rechteck, oval, kreis oder linie)
 * 																								- gef�llte figur oder nur umrandung (checkbox jCheckBgefuellt)
 * 																								- koordinaten der figur als x,y, h�he, breite 
 * 																								- zeichenfarbe	&	lnienbreite
 * 				[	2. fakultativ:	konstruktor um die werte der acht eigenschaften des zeichenobjekts zu initialisieren	]
 * 
 * 					3. konstruktor um die werte der acht eigenschaften des zeichenobjekts zu �bergeben:		public ZeichenObjekt(char t, boolean f, int x, int y, int v, int w, Color c, float lb) {..}
 * 					
 * 					4. getter und setter f�r jede der 8 eigenschaften des zeichenobjekts
 * 
 * 
 * 2. JMYPAINTPANEL (EXTENDS JPANEL)
 * 		
 * 		K&K:		Klasse JMyPaintPanel. Die Klasse ist von der Standardkomponente JPanel abgeleitet. Sie dient der Demonstration des Zeichnens in eine Komponente.
 * 		
 * 		VORGHEN:	1. Klasse f�r die Zeichenfl�che: 	JMyPaintPanel extends JPanel erstellen im Eclipse Dialog (inkl. autogenerierung der superclass-konstruktoren) mittels:		
 * 											- New > Class > Name: 			JMyPaintPanel 	
 * 															Superclass:		javax.swing.JPanel	
 * 															anh�ckeln:		Construktors from superclass	
 * 						(man k�nnte JMyPaintPanel auch �ber:	New > Other > GUI-forms > swing > JPanel	erstellen, dann lassen sich aber die konstruktoren der superklasse nicht auto-generieren)
 * 					
 * 					2. ArrayList (inkl. Objektdatentyp) zur aufnahme der zeichenobjekte:	- deklarieren (oben, als attribut der klasse):				private ArrayList<ZeichenObjekt> figuren;
 * 																							- & erzeugen des ArrayList-objekts in jedem konstruktor:	figuren = new ArrayList<ZeichenObjekt>();
 * 					
 * 					3. methode zur �bergabe des zeichenobjekts als schnittstelle zwischen dem Zeichenprogramm (Zeichnen4) und der Zeichenfl�che (JMyPaintPanel):
 * 
 * 						public void addZeichObjekt(char t, boolean f, int x, int y, int v, int w, Color c, float lb) {
 *							figuren.add(new ZeichenObjekt(t,f,x,y,v,w,c,lb));		// erstellen eines neuen Zeichenobjekts (unter �bergabe aller werte) und ablegen im in der ArrayList
 *						}
 *
 *					4. �berschreiben von paintComponent(..) der superklasse:	
 *						=> damit sie "lernf�hig" ist & darauf gezeichnete elemente (hier: zeichenobjekte) beim repaint() mitgezeichnet werden
 *						=> nur in PAINT() ODER PAINTCOMPONENT() hinterlegte anweisungen, werden beim REPAINT() einer komponente (hier: panel) mitgezeichnet, 
 *						
 *						KERNCODE:
 *																  															
 *						public void paintComponent(Graphics g) {					// �berschreiben der paintComponent(..)-Methode der superklasse (JPanel), um ein ZeichenObjekt nach dem anderen aus dem beh�lter (=ArrayList) zu nemen und zu zeichnen
 *							super.paintComponent(g);								// aufruf der methode paintComponent(..) der superklasse unter �bergabe des graphic-objekts g 
 *							Graphics2D g2d = (Graphics2D) g;						// graphics2D-kontext-objekt g2d erstellen zurch zuweisen des gecasteten graphics-objekt g
 *							for (int i= 0; i < figuren.size(); i++) {				// for-schleife f�r alle im 'beh�lter' arraylist figuren gespeicherten zeichenobjekte (eins nach dem anderen)
 *								ZeichenObjekt zo = figuren.get(i);					// lokale instanz erstellen des jeweiligen elements aus arraylist figuren
 *								g2d.setColor(zo.getCol());							// graphic2d-objekt g2d auf zeichenfarbe des jeweiligen zeichenobjekts setzen
 *								BasicStroke stil = new BasicStroke(zo.getLbreite(), BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);	// objekt f�r linienstil mit parametern: breite, linienende, kreuzungspunkte
 *								g2d.setStroke(stil);													// linienart auf linienstil stil setzen
 *								switch (zo.getTyp()) {													// switch-case mit typ (der jeweilige geometrische figur) aus der jeweiligen zeichenobjekt-instanz
 *								case 'R':																// im fall variable R f�r rechteck..
 *									Rectangle2D.Float rechteck = new Rectangle2D.Float(zo.getX1(), zo.getY1(), zo.getX2(), zo.getY2());	// rechteck-objekt erzeugen mit x,y,breite, h�he (des jeweiligen zeichenobjekts)
 *									if (zo.isGefuellt()) {												// wenn checkbox angehakt
 *										g2d.fill(rechteck);												// objekt rechteck ausgef�llt ins objekt g2d malen
 *									} else {															// sonst
 *										g2d.draw(rechteck);												// objekt rechteck leer ins objekt g2d zeichnen
 *									}
 *									break;
 *								case 'K':																// alles analog rechteck:
 *									...
 *								case 'O':																// alles analog rechteck:
 *									...
 *								case 'L':																// alles analog rechteck, aber nur die ungef�llte version weil linie:
 *									...
 *								}
 *							}
 *						}
 *  
 * 					5. (fakultativ) methode zum l�schen des jeweils zuletztgezeichneten zeichenobjekts als schnittstelle zwischen dem Zeichenprogramm (Zeichnen4) und der zeichenfl�che (JMyPaintPanel)
 *						
 *						public void loescheLetztesZeichenObjekt(){
 *							figuren.remove(figuren.size()-1);						// das jeweils lezte element der arraylist figuren l�schen
 *						}
 * 
 * 
 * 3. ZEICHENPROGRAMM - JMyPaintPanel_RepaintBeiFrameveraenderungen_Komponente_ZumHineinZeichnen_Zeichnen4
 * 
 * 		K&K:		Programm Zeichnen4 (erweiterung von Zeichnen3) (Unter Verwendung von Graphics2D statt Graphics)
 * 					Dem Anwender steht ein Panel, auf das er verschiedene geometrische Figuren zeichnen kann, zur Verf�gung. Position und Gr��e der Figuren k�nnen frei bestimmt werden.
 * 					Die Zeichnungen bleiben beim Neuzeichnen z.B. nach Verschieben des Fensters dauerhaft erhalten.
 * 
 * 		VORGEHEN: 	1. frame mit Panel worauf das gezeichnete dargestellt wird:	
 * 
 *							jPanelZeichenflaeche = new JMyPaintPanel();							// zeichenfl�che aus der selbsterstellten/abgeleiteten komponente JMyPaintPanel
 * 
 * 					2. 4 positions-textfelder zur eingabe jeweils ben�tigten parameterwerte f�r die zeichenmethoden (x, y, h�he, breite)
 * 							-> werden nach programmlogik ein-/ausgeblendet & benannt
 * 
 * 					3. 3 buttons:	[=> wichtig alle vor buttongroup erstellen]
 * 									- zeichnen			=> um via addZeichenObjekt(..) (von JMyPaintPanel) zeichenobjekte zu erstellen	&	in arraylist figuren zu speichern
 * 														=> & mit repaint()> via paintComponent(..) (von JMyPaintPanel) neu zu zeichnen
 * 									- zeichnung l�schen	=> um via loescheLetztesZeichenObjekt()	(von JMyPaintPanel), das letzte zeichenobjekt aus arraylist figuren zu l�schen
 * 														=> & mit repaint()> via paintComponent(..) (von JMyPaintPanel) neu zu zeichnen	
 * 									- ende				=> beenden des programms 
 * 
 * 					4. 1 checkbox zum anh�ckeln ob formen gef�llt werden oder nicht						=> siehe CHECKBOX unten
 * 
 * 					5. 4 radiobuttons zum w�hlen der gew�nschten form (rechteck, kreis, oval, linie)	=> siehe RADIOBUTTONS unten		// wichtig: zuerst erstellen
 * 							-> inklusive event-methoden
 * 
 * 					6. ButtonGroup (= RadioGroup) um die radiobuttons einander zuzuordnen				=> siehe BUTTONGROUP unten		// wichtig: nacher erstellen
 * 																										=> siehe ZUORDNUNG DER RADIOBUTTONS ZUR RADIOGROUP unten
 * 
 * 					7. allgemeing�ltige Methode zum beschriften/anpassen der textfelder je nach radiobutton-auswahl (rechteck, kreis, oval oder linie!!)
 * 
 * 							=> CODE siehe:		private void setzeBeschriftungen(){..}
 * 
 *					8. die action-listener-methoden der radiobuttons 		-> rufen die methode setzeBeschriftung() auf (f�r die beschriftung)..
 *																			-> ..und steuern die sichtbarkeit der jeweils erw�nschten komponenten (checkbox & y2)
 * 								& -> char-variablen figur speichert den jeweilige anfangsbuchstaben der aktuellen geometrischen figur (L, O, R oder K) 
 * 										-> .. f�r switch-case der methode addZeichObjekt(..) (klasse JMyPaintPanel)
 * 
 * 							=> CODE siehe: 		jRBtnReckteck..(..)		&	jRBtnLinie..(..)	&	jRBtnOval..(..)		&		jRBtnKreis..(..)		]]]
 * 				
 * 					9. methode zum erstellen & indirekt zeichen der geometrischen figuren jBtnZeichnen..(..):
 * 
 * 							=> auslesen der parameterwerte der textfelder in x1, x2, y1, y2
 * 							=> aufruf von addZeichenObjekt(..) (der klasse JMyPaintPanel) zur �bergabe der eigenschaften des zu zeichnenden zeichenobjekts an das panel
 *								-> wobei die 8 eigenschaften aus den text- & optionsfeldern entnommen werden, die strichst�rke direkt+unver�nderlich, die farbe als eigenschaft des frames
 * 			
 * 									jPanelZeichenflaeche.addZeichObjekt(figur, jCheckBgefuellt.isSelected(), x1, y1, x2, y2, farbe, 1.0f);
 * 
 * 							=> methode repaint f�r das zeichen-panel, 
 * 								-> damit wird paintComponent(..) von JMyPaintPanel ausgel�st	&	und somit das �bergebene zeichenobjekt auch unmittelbar dargestellt:
 * 
 *									jPanelZeichenflaeche.repaint()
 *
 *					10. methode um JMyPaintPanel neu, minus das zuletzt hinzugef�gte zeichenobjekt, zu zeichnen:
 *
 *							private void jBtnLoeschenActionPerformed(ActionEvent evt) {													
 *								jPanelZeichenflaeche.loescheLetztesZeichenObjekt(); 	// aufruf der methode um das letzte zeichenobjekt aus der arrralist figuren (im JMyPaintPanel) zu l�schen 								
 *								jPanelZeichenflaeche.repaint();								// xy.repaint() : panel neu zeichnen (inkl. verbleibende zeichenobjekte der arraylist figuren) 
 *							}																
 *
 * 
 *[[ JCHECKBOX:		
 * 
 * 			=> h�ckchen box
 * 			=> gut zur abfrage von wahrheitswert (true - false)
 * 
 * 			=> METHODE:		- isSelected()			=> um zu r�fen ob h�ckchen gesetzt ist (true - false)
 * 
 * 
 *	RADIOBUTTONS:
 *
 *			=> WICHTIG:		ZUERST die versch. RadioButtons erstellen, 	DANN die ButtonGroup (hier: BtnGrpFigure), 	DANN zuordnung der RadioButtons zur ButtonGroup
 *								-> sonst hat's eine meise und erstellt irgendwelche lustigen getters 
 *			=> normal mit Jigloo reinziehen
 *			
 *			=> METHODEN:		- setSelected()		=> um schaltfl�che auf angew�hlt zu setzen, (auch via properties)
 *								- isSelected()		=> um zu r�fen ob schaltfl�che ausgew�hlt ist (true - false)
 *
 *
 * 	BUTTONGROUP / RADIOGROUP:
 * 	
 * 			=> n�tig f�r zusammenspiel von mehreren RadioButtons, von denen nur einer aufs mal ausgew�hlt werden kann
 * 			=> egal wo reinziehen in den frame		-> wird NICHT dargestellt im GUI / initGUI()  
 * 													-> erscheint im outline unter non-visulal components  (nicht wie die anderen komponenten unter frame)
 * 			=> autoerzeugung der variablen oben durch jigloo  (hier: BtnGrpFigure)  
 * 			=> autoerzeugung der zugeh�rigen getter-methode durch jigloo 	-> getter-methoden-name setzt sich zusammen aus get + vergebenem variabel-namen
 * 					  
 * 
 * 			=> CODE:		
 * 
 * 				private ButtonGroup BtnGrpFigur;			// auto-erzeugte variable von jigloo, 
 * 
 *				public ButtonGroup getBtnGrpFigur() {		// Jigloo-erzeugt, methode liefert referenz auf die ButtonGroup
 *					if(BtnGrpFigur == null) {				// pr�ft ob bereits objekt erzeugt wurde..
 *						BtnGrpFigur = new ButtonGroup();	// .. wenn nicht, wird konstruktor aufgerufen (objekt erzeugt) ..
 *					}
 *					return BtnGrpFigur;						// .. und die referenz auf das objekt zur�ckgeliefert
 *				} 
 *
 *	ZUORDNUNG DER RADIOBUTTONS ZUR RADIOGROUP:
 *
 *			=> RadioGroup sorgt daf�r, dass nur ein RadioButton auf's mal ausgew�hlt sein kann
 *			=> jedem RadioButton in den properties unter eigenschaft buttonGroup die RadioGroup (hier: BtnGrpFigure) zuordnen 
 * 				
 * 			=> CODE:   		getBtnGrpFigure().add(jRBtnReckteck);		// bsp erg�nzung  im initGUI() um jRBtnRechteck der ButtonGroup BtnGrpFigur zuzuordnen
 * 																		// via getter-methode verschaft sich der frame zugriff auf die readiogroup (BtnGrpFigure)		]]]
 */

package uebungen13;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.ButtonGroup;						 
import javax.swing.JButton;
import javax.swing.JCheckBox;						
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;					
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

public class JMyPaintPanel_Aufruf_KomponenteZumHineinZeichnen_paintComponentLernfaehig_RepaintBeiFrameveraenderungen_Zeichnen4 extends javax.swing.JFrame {

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
	private JButton jBtnEnde;
	private JButton jBtnZeichnen;
	private JButton jBtnLoeschen;
	private ButtonGroup BtnGrpFigure;													// mit jigloo erzeugte variable  
	private JRadioButton jRBtnReckteck;
	private JRadioButton jRBtnLinie;
	private JRadioButton jRBtnOval;
	private JRadioButton jRBtnKreis;
	private JCheckBox jCheckBgefuellt;

	private char figur = 'R';															// variable f�r anfangsbuchstaben der zu zeichnenden geom. figur ('L', 'O', 'K', 'R') f�r switch-case erkennung
	private int x1, y1, x2, y2;															// variablen f�r speicherg. der parameterwerte aus den textfeldern
	private JMyPaintPanel jPanelZeichenflaeche;			// zeichenfl�che initialsieren, aber mit dem objektdatentyp JMyPaintPanel (geerbt von JPanel)
	private Color farbe = Color.black;
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JMyPaintPanel_Aufruf_KomponenteZumHineinZeichnen_paintComponentLernfaehig_RepaintBeiFrameveraenderungen_Zeichnen4 inst = new JMyPaintPanel_Aufruf_KomponenteZumHineinZeichnen_paintComponentLernfaehig_RepaintBeiFrameveraenderungen_Zeichnen4();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public JMyPaintPanel_Aufruf_KomponenteZumHineinZeichnen_paintComponentLernfaehig_RepaintBeiFrameveraenderungen_Zeichnen4() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Zeichnen 4, Komponente zum hineinzeichnen mit autom. repaint() bei Framever�nderungen");
			getContentPane().setBackground(new java.awt.Color(236, 233, 216));
			{
				jLZeichenflaeche = new JLabel();
				getContentPane().add(jLZeichenflaeche);
				jLZeichenflaeche.setText("Zeichenfl�che");
				jLZeichenflaeche.setBounds(12, 12, 135, 16);
			}
			{
				jPanelZeichenflaeche = new JMyPaintPanel();							// zeichenfl�che aus der selbsterstellten/abgeleiteten komponente JMyPaintPanel
				getContentPane().add(jPanelZeichenflaeche);
				jPanelZeichenflaeche.setBounds(12, 40, 336, 410);
				jPanelZeichenflaeche.setBackground(new java.awt.Color(255,255,255));						// hintergrund auf weiss setzen mit gui properties
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
				getBtnGrpFigure().add(jRBtnReckteck);															// in den properties die zuordnung zur buttonGroup BtnGrpFigure einstellen 
			}																									// via getter-methode verschaft sich der frame zugriff auf die readiogroup (BtnGrpFigure)
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
				getBtnGrpFigure().add(jRBtnKreis);																// in den properties die zuordnung zur buttonGroup BtnGrpFigure einstellen 
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
				getBtnGrpFigure().add(jRBtnOval);																// in den properties die zuordnung zur buttonGroup BtnGrpFigure einstellen 
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
				getBtnGrpFigure().add(jRBtnLinie);																// in den properties die zuordnung zur buttonGroup BtnGrpFigure einstellen 
			}
			{
				jBtnZeichnen = new JButton();
				getContentPane().add(jBtnZeichnen);
				jBtnZeichnen.setText("Zeichnen");
				jBtnZeichnen.setBounds(418, 280, 202, 23);
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
				jBtnLoeschen.setBounds(418, 330, 202, 23);
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
				jBtnEnde.setBounds(418, 381, 202, 23);
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
	private ButtonGroup getBtnGrpFigure() {																		// methode liefert referenz auf die ButtonGroup
		if(BtnGrpFigure == null) {																				// pr�ft ob bereits objekt erzeugt wurde, wenn nicht ..
			BtnGrpFigure = new ButtonGroup();																	// .. wird konstruktor aufgerufen (objekt erzeugt) ..
		}
		return BtnGrpFigure;																					// .. und die referenz auf das objekt zur�ckgeliefert
	}
	
	   																											//  Methode zum beschriften/anpassen der textfelder je nach radiobutton-auswahl (rechteck, kreis, oval oder linie!!)
	private void setzeBeschriftungen(){ 			
		if (jRBtnLinie.isSelected()) {																			// wenn linie gew�hlt ist: ..
			jLPositionX1.setText("Startpunkt x:");																// .. verschiedene labels f�r die textfelder anpassen f�r parameter-werte (x1,y1,x2,y2) [y1 bleibt immer gleich]
			jLPositionX2.setText("Endpunkt x:");
			jLPositionY2.setText("      y:");
		} else {																								// wenn rechteck, oval, kreis:..
			jLPositionX1.setText("Position x:");																// ... labels anpassen auf parameter-werte (x1, y1, breite, h�he) [y1 bleibt immer gleich]				
			jLPositionX2.setText("Breite:");
			jLPositionY2.setText("H�he:");
		}
	}
	
	private void jRBtnReckteckActionPerformed(ActionEvent evt) {												// bei w�hlen des radiobuttons rechteck
		setzeBeschriftungen();																					// beschriftung der textfelder anpassen 
		jCheckBgefuellt.setVisible(true);																		// checkbox sichtbar machen weil rechteck gef�llt werden kann
		jLPositionY2.setVisible(true);																			// y2 label "wieder" sichtbar machen
		jTFPositionY2.setVisible(true); 																		// y2 TF "wieder" sichtbar machen
		figur = 'R';																							// char-variable 0 (f�r geom. Figur rechteck) f�r sp�tere verwendung im switch-case der zeichnen-methode 
	}
	
	private void jRBtnKreisActionPerformed(ActionEvent evt) {													// bei w�hlen des radiobuttons kreis
		setzeBeschriftungen();																					// beschriftung der textfelder anpassen 
		jCheckBgefuellt.setVisible(true);																		// checkbox sichtbar machen weil kreis gef�llt werden kann
		jLPositionY2.setVisible(false);																			// y2 label unsichtbar machen, weil h�he bei kreis nicht gew�hlt werden soll
		jTFPositionY2.setVisible(false); 																		// y2 TF unsichtbar machen, 					"
		figur = 'K';																							// char-variable 0 (f�r geom. Figur kreis) f�r sp�tere verwendung im switch-case der zeichnen-methode 
	}
	
	private void jRBtnOvalActionPerformed(ActionEvent evt) {													// bei w�hlen des radiobuttons oval
		setzeBeschriftungen();																					// beschriftung der textfelder anpassen 
		jCheckBgefuellt.setVisible(true);																		// checkbox sichtbar machen weil oval gef�llt werden kann
		jLPositionY2.setVisible(true);																			// y2 label "wieder" sichtbar machen
		jTFPositionY2.setVisible(true); 																		// y2 TF "wieder" sichtbar machen
		figur = 'O';																							// char-variable 0 (f�r geom. Figur oval) f�r sp�tere verwendung im switch-case der zeichnen-methode 
	}
	
	private void jRBtnLinieActionPerformed(ActionEvent evt) {													// bei w�hlen des radiobuttons Linie
		setzeBeschriftungen();																					// beschriftung der textfelder anpassen 
		jCheckBgefuellt.setVisible(false);																		// checkbox unsichtbar machen weil eine linie ja nicht gef�llt werden kann
		jLPositionY2.setVisible(true);																			// y2 label "wieder" sichtbar machen
		jTFPositionY2.setVisible(true); 																		// y2 TF "wieder" sichtbar machen
		figur = 'L';																							// char-variable L (f�r geom. Figur linie) f�r sp�tere verwendung im switch-case der zeichnen-methode 
	}
	
	// (abge�nderte) methode zum indirekten zeichnen der geometrischen figuren auf das jPanelZeichenflaeche
	private void jBtnZeichnenActionPerformed(ActionEvent evt) {
		try {
			x1 = Integer.parseInt(jTFPositionX1.getText());																							// parameterwerte aus den TextFeldern zwischenspeichern
			y1 = Integer.parseInt(jTFPositionY1.getText());																							// "
			x2 = Integer.parseInt(jTFPositionX2.getText());																							// "
			y2 = Integer.parseInt(jTFPositionY2.getText());																							// "
			// alle anweisungen zum zeichnen der zeichenobjekte fallen weg & werden durch die folgenden 2 anweisungen ersetzt:
			jPanelZeichenflaeche.addZeichObjekt(figur, jCheckBgefuellt.isSelected(), x1, y1, x2, y2, farbe, 1.0f);// methoden-aufruf zur �bergabe der eigenschaften des zu zeichnenden zeichenobjekts an das panel..
												//.. die eigenschaften werden aus den text- & optionsfeldern entnommen, die strichst�rke direkt, die farbe als eigenschaft des frames
			jPanelZeichenflaeche.repaint();		// methode repaint f�r das zeichen-panel, damit wird das �bergebene zeichenobjekt auch unmitelbar dargestellt
		} catch (Exception e){																														// fehlerausgabe f�r fehler beim zeichnen
			JOptionPane.showMessageDialog(this, "Die Eingaben sind ung�ltig");
		}
	}
	
	private void jBtnEndeActionPerformed(ActionEvent evt) {
		System.exit(0);
	}
	
	// methode um JMyPaintPanel neu, minus das zuletzt hinzugef�gte zeichenobjekt, zu zeichnen
	private void jBtnLoeschenActionPerformed(ActionEvent evt) {													
			jPanelZeichenflaeche.loescheLetztesZeichenObjekt(); 	// aufruf der methode um das letzte zeichenobjekt aus der arrralist figuren (im JMyPaintPanel) zu l�schen 								
			jPanelZeichenflaeche.repaint();																		// xy.repaint() : panel neu zeichnen (inkl. verbleibende zeichenobjekte der arraylist figuren) 
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