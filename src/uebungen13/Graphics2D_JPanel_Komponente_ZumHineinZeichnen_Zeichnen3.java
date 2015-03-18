/* TODO 13.2.4.   s.413, oben (2. ANSATZ) mit Graphics2D; OHNE REPAINT() bei framever�nderungen 
 * class Graphics2D_JPanel_Komponente_ZumHineinZeichnen_Zeichnen3			
 * 
 * 		SIEHE BASICS:		13.2.4.   Graphics2D_API_Klasse_Methoden_Basics												s.410
 * 
 * 		VERGLEICHE:	 		13.2.1.   JPanel_Komponente_ZumHineinZeichnen_RadioGroup_getGraphics_Zeichnen2				s.403, (2. ANSATZ) OHNE REPAINT() bei framever�nderungen
 *  		
 * 	[[[	SIEHE AUCH:			13.1.2.   JPanel_Komponente_MitVer�ndertemAussehen_JMyPanelZeichnen1	&	JMyPanel 		s.400+(398), (= 1. ANSATZ) INKL. REPAINT() bei framever�nderungen	]]]
 * 
 * 
 * JPANEL (OD. AUCH JFRAME) ALS STANDARD-KOMPONENTE ZUM HINEINZEICHNEN:		(= 2. ANSATZ)
 * 
 * 			=> JPanel/JFrame mit M�glichkeit f�r den anwender zum interaktiv hineinzeichnen
 * 		
 * 			=> MIT repaint() als button		= um die vorhandenen zeichnungen zu entfernen
 * 											= achtung: repaint() f�r jPanel nicht in der selben methode wo gezeichnet wird, sondern extra methode oder von ausserhalb 
 * 
 * 			=> OHNE repaint() f�rs frame	= wenn man den Frame verzieht / bewegt, verschwindet das gezeichnete
 * 
 * 
 * 		K&K:	 	Programm Zeichnen3 (variante von Zeichnen2)
 * 					Unter Verwendung von Graphics2D statt Graphics	
 * 					Dem Anwender steht ein Panel, auf das er verschiedene geometrische Figuren zeichnen kann, zur Verf�gung. 
 * 					Position und Gr��e der Figuren k�nnen frei bestimmt werden.
 * 					Bei ver�ndern des frames durch den anwender verschwindet die zeichnung, weil der zeichnen-teil in dieser version nicht ge-repaintet werden kann
 * 
 * 
 * 	VORGEHEN: [[[	1. frame mit JPanel, worauf das gezeichnete dargestellt wird
 * 
 * 					2. 4 positions-textfelder zur eingabe jeweils ben�tigten parameterwerte f�r die zeichenmethoden (x, y, h�he, breite)
 * 							-> werden nach programmlogik ein-/ausgeblendet & benannt
 * 
 * 					3. 3 buttons:	[=> wichtig alle vor buttongroup erstellen]
 * 									- zeichnen			=> zum ausl�sen des effektiven zeichenvorganges f�r die jeweiligen werte & auswahlen (checkbox + radiobuttons)
 * 									- zeichnung l�schen	=> actionlistener-methode mit:		jPanelZeichenflaeche.repaint()
 * 															-> repaint() muss hier ausserhalb der zeichnen-methode benutzt werden 
 * 															-> repaint() funktioniert nur um das panel zu l�schen, nicht f�r neuzeichnen bei frame-ver�derungen 			
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
 * 										-> .. f�r switch-case der methode jBtnZeichnen..(..) 
 * 
 * 							=> CODE siehe: 		jRBtnReckteck..(..)		&	jRBtnLinie..(..)	&	jRBtnOval..(..)		&		jRBtnKreis..(..)		]]]
 * 		
 * 	GRAPHICS2D:		
 * 					9. methode zu zeichen der geometrischen figuren jBtnZeichnen:
 * 
 * 							=> auslesen der parameterwerte der textfelder in x1, x2, y1, y2
 * 							=> switch-case unter verwendung der, in char-variabel figur gespeicherten buchstaben (aus den action-listener-methoden der radiobuttons) 
 * 							=> pr�fen des checkbox-status bei den 2-dim figuren, ob gef�llt oder ungef�llt zeichnen 	
 * 									-> bsp:		if (jCheckBox.isSelected)
 *							=> zeichenen der figuren	=> unter verwendung eines Graphics2D-objekts zum darauf/damit zeichnen durch:	getGraphics() &	Type-cast auf Graphics2D:
 *							
 * 															BSP:	 	Graphics2D g2 = (Graphics2D) jPanelZeichenflaeche.getGraphics();
 * 
 *														=> form-objekt (Rectangle2D.Float, Ellipse2D.Float etc.) aus dem package JAVA.AWT.GEOM erzeugen mit x,y,breite, h�he
 *														
 *															BSP:		Rectangle2D.Float rechteck = new Rectangle2D.Float(x1, y1, x2, y2);
 *															
 * 														=> fill() oder draw() via Graphics2D-objekt aufrufen & form-objekt als parameter mitgeben
 * 
 * 															BSP:		g2d.fill(rechteck); 	
 * 
 * 														=> farbverl�ufe:		 mit Klasse GradientPaint & setPaint()
 * 														=> linienstil:			 mit Klasse BasicStrocke & setStroke()
 * 
 * 														=> BASICS SIEHE :		13.2.4.   Graphics2D_API_Klasse_Methoden_Basics		s.410
 * 
 * 		=> KERNCODE:	
 * 
 * 			import java.awt.BasicStroke;			
 *			import java.awt.GradientPaint;			 
 *			import java.awt.Graphics2D;				 
 *			import java.awt.geom.Rectangle2D;													// dito f�r kreis & oval & linie
 *
 *			private Graphics2D g2d;																// als attribut der klasse: variable f�r 2d grafik-objekt 
 *
 *			private void jBtnZeichnen..(..) {
 *				try {
 *					x1 = Integer.parseInt(jTFPositionX1.getText());								// alle parameterwerte x1,y1,x2,y2 aus den TextFeldern zwischenspeichern
 *					..
 *					g2d = (Graphics2D) jPanelZeichenflaeche.getGraphics();						// verwendung des Graphics2D-objekts durch:	getGraphics() & Type-cast auf Graphics2D
 *					g2d.setColor(Color.red);																	// zeichenfarbe des g2d-objekts auf rot setzen
 *					BasicStroke stil = new BasicStroke(30.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);	// objekt f�r linienstil mit parametern: breite, linienende, kreuzungspunkte
 *					g2d.setStroke(stil);																		// linienart auf linienstil stil setzen
 *					GradientPaint fuellung = new GradientPaint(0, 0, Color.red, 100, 100, Color.yellow, true);	// objekt f�r farbverlauf mit parametern: anfangs-punkt, dessen farbe, endpunk, dessen farbe, wiederholungs-boolean
 *					g2d.setPaint(fuellung);																		// farbart auf farbverlauf (objekt fuellung) setzen
 *					switch (figur) {																			// switch-case f�r die jeweilige geometrische figur die zu zeichnen ist
 *					case 'R':																	// im fall variable R f�r rechteck..
 *						Rectangle2D.Float rechteck = new Rectangle2D.Float(x1, y1, x2, y2);		// rechteck-objekt erzeugen mit x,y,breite, h�he
 *						if (jCheckBgefuellt.isSelected()){										// wenn checkbox angehakt
 *							g2d.fill(rechteck);													// objekt rechteck ausgef�llt ins objekt g2d malen
 *						} else {																// sonst
 *							g2d.draw(rechteck);													// objekt rechteck leer ins objekt g2d zeichnen
 *						}
 *						break;
 *					case 'K':																	// alles analog rechteck:
 *						..
 *					case 'O':																	// alles analog rechteck:
 *						..
 *					case 'L':																	// analog rechteck aber nur die ungef�llte version weil linie
 *						..
 *				} catch (..){
 *			}
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

import java.awt.BasicStroke;			// guck themenspez. imp.
import java.awt.Color;
import java.awt.GradientPaint;			// guck 
import java.awt.Graphics2D;				// guck 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;		// guck 

import javax.swing.ButtonGroup;						// guck 
import javax.swing.JButton;
import javax.swing.JCheckBox;						// guck
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;					// guck
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


public class Graphics2D_JPanel_Komponente_ZumHineinZeichnen_Zeichnen3 extends javax.swing.JFrame {

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
	private JRadioButton jRBtnReckteck;
	private JButton jBtnEnde;
	private JButton jBtnZeichnen;
	private ButtonGroup BtnGrpFigure;			// mit jigloo erzeugte variable  
	private JRadioButton jRBtnLinie;
	private JRadioButton jRBtnOval;
	private JRadioButton jRBtnKreis;
	private JCheckBox jCheckBgefuellt;
	private JTextField jTFPositionY2;
	private JLabel jLPositionY2;
	private JTextField jTFPositionX2;
	private JLabel jLPositionX2;
	private JTextField jTFPositionY1;
	private JLabel jLPositionY1;
	private JTextField jTFPositionX1;
	private JPanel jPanelZeichenflaeche;
	private char figur = 'R';					// variable f�r anfangsbuchstaben der zu zeichnenden geom. figur ('L', 'O', 'K', 'R') f�r switch-case erkennung
	private int x1, y1, x2, y2;					// variablen f�r speicherg. der parameterwerte aus den textfeldern
	private JButton jBtnLoeschen;
	private Graphics2D g2d;						// variable f�r 2d grafik-objekt 
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Graphics2D_JPanel_Komponente_ZumHineinZeichnen_Zeichnen3 inst = new Graphics2D_JPanel_Komponente_ZumHineinZeichnen_Zeichnen3();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public Graphics2D_JPanel_Komponente_ZumHineinZeichnen_Zeichnen3() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Zeichnen 3, Komponente zum hineinzeichnen mit Graphics2d");
			getContentPane().setBackground(new java.awt.Color(236, 233, 216));
			{
				jLZeichenflaeche = new JLabel();
				getContentPane().add(jLZeichenflaeche);
				jLZeichenflaeche.setText("Zeichenfl�che");
				jLZeichenflaeche.setBounds(12, 12, 135, 16);
			}
			{
				jPanelZeichenflaeche = new JPanel();
				getContentPane().add(jPanelZeichenflaeche);
				jPanelZeichenflaeche.setBounds(12, 40, 336, 410);
				jPanelZeichenflaeche.setBackground(new java.awt.Color(255,255,255));			// hintergrund auf weiss setzen mit gui properties
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
				getBtnGrpFigure().add(jRBtnReckteck);			// in den properties die zuordnung zur buttonGroup BtnGrpFigure einstellen 
			}													// via getter-methode verschaft sich der frame zugriff auf die readiogroup (BtnGrpFigure)
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
				getBtnGrpFigure().add(jRBtnKreis);				// in den properties die zuordnung zur buttonGroup BtnGrpFigure einstellen 
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
				getBtnGrpFigure().add(jRBtnOval);				// in den properties die zuordnung zur buttonGroup BtnGrpFigure einstellen 
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
				getBtnGrpFigure().add(jRBtnLinie);				// in den properties die zuordnung zur buttonGroup BtnGrpFigure einstellen 
			}
			{
				jBtnZeichnen = new JButton();
				getContentPane().add(jBtnZeichnen);
				jBtnZeichnen.setText("Zeichnen");
				jBtnZeichnen.setBounds(418, 280, 125, 23);
				jBtnZeichnen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnZeichnenActionPerformed(evt);
					}
				});
			}
			{
				jBtnLoeschen = new JButton();
				getContentPane().add(jBtnLoeschen);
				jBtnLoeschen.setText("Zeichnung l�schen");
				jBtnLoeschen.setBounds(418, 330, 125, 23);
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
				jBtnEnde.setBounds(418, 381, 125, 23);
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
	private ButtonGroup getBtnGrpFigure() {		// methode liefert referenz auf die ButtonGroup
		if(BtnGrpFigure == null) {				// pr�ft ob bereits objekt erzeugt wurde, wenn nicht ..
			BtnGrpFigure = new ButtonGroup();	// .. wird konstruktor aufgerufen (objekt erzeugt) ..
		}
		return BtnGrpFigure;					// .. und die referenz auf das objekt zur�ckgeliefert
	}
	
	   //  Methode zum beschriften/anpassen der textfelder je nach radiobutton-auswahl (rechteck, kreis, oval oder linie!!)
	private void setzeBeschriftungen(){ 			
		if (jRBtnLinie.isSelected()) {				// wenn linie gew�hlt ist: ..
			jLPositionX1.setText("Startpunkt x:");	// .. verschiedene labels f�r die textfelder anpassen f�r parameter-werte (x1,y1,x2,y2) [y1 bleibt immer gleich]
			jLPositionX2.setText("Endpunkt x:");
			jLPositionY2.setText("      y:");
		} else {									// wenn rechteck, oval, kreis:..
			jLPositionX1.setText("Position x:");	// ... labels anpassen auf parameter-werte (x1, y1, breite, h�he) [y1 bleibt immer gleich]				
			jLPositionX2.setText("Breite:");
			jLPositionY2.setText("H�he:");
		}
	}
	
	private void jRBtnReckteckActionPerformed(ActionEvent evt) {	// bei w�hlen des radiobuttons rechteck
		setzeBeschriftungen();						// beschriftung der textfelder anpassen 
		jCheckBgefuellt.setVisible(true);			// checkbox sichtbar machen weil rechteck gef�llt werden kann
		jLPositionY2.setVisible(true);				// y2 label "wieder" sichtbar machen
		jTFPositionY2.setVisible(true); 			// y2 TF "wieder" sichtbar machen
		figur = 'R';								// char-variable 0 (f�r geom. Figur rechteck) f�r sp�tere verwendung im switch-case der zeichnen-methode 
	}
	
	private void jRBtnKreisActionPerformed(ActionEvent evt) {	// bei w�hlen des radiobuttons kreis
		setzeBeschriftungen();						// beschriftung der textfelder anpassen 
		jCheckBgefuellt.setVisible(true);			// checkbox sichtbar machen weil kreis gef�llt werden kann
		jLPositionY2.setVisible(false);				// y2 label unsichtbar machen, weil h�he bei kreis nicht gew�hlt werden soll
		jTFPositionY2.setVisible(false); 			// y2 TF unsichtbar machen, 					"
		figur = 'K';								// char-variable 0 (f�r geom. Figur kreis) f�r sp�tere verwendung im switch-case der zeichnen-methode 
	}
	
	private void jRBtnOvalActionPerformed(ActionEvent evt) {	// bei w�hlen des radiobuttons oval
		setzeBeschriftungen();						// beschriftung der textfelder anpassen 
		jCheckBgefuellt.setVisible(true);			// checkbox sichtbar machen weil oval gef�llt werden kann
		jLPositionY2.setVisible(true);				// y2 label "wieder" sichtbar machen
		jTFPositionY2.setVisible(true); 			// y2 TF "wieder" sichtbar machen
		figur = 'O';								// char-variable 0 (f�r geom. Figur oval) f�r sp�tere verwendung im switch-case der zeichnen-methode 
	}
	
	private void jRBtnLinieActionPerformed(ActionEvent evt) {	// bei w�hlen des radiobuttons Linie
		setzeBeschriftungen();						// beschriftung der textfelder anpassen 
		jCheckBgefuellt.setVisible(false);			// checkbox unsichtbar machen weil eine linie ja nicht gef�llt werden kann
		jLPositionY2.setVisible(true);				// y2 label "wieder" sichtbar machen
		jTFPositionY2.setVisible(true); 			// y2 TF "wieder" sichtbar machen
		figur = 'L';								// char-variable L (f�r geom. Figur linie) f�r sp�tere verwendung im switch-case der zeichnen-methode 
	}
	

	private void jBtnZeichnenActionPerformed(ActionEvent evt) {
		try {
			x1 = Integer.parseInt(jTFPositionX1.getText());		// parameterwerte aus den TextFeldern zwischenspeichern
			y1 = Integer.parseInt(jTFPositionY1.getText());		// "
			x2 = Integer.parseInt(jTFPositionX2.getText());		// "
			y2 = Integer.parseInt(jTFPositionY2.getText());		// "
			g2d = (Graphics2D) jPanelZeichenflaeche.getGraphics();	// verwendung des Graphics2D-objekts durch:	getGraphics()	&	Type-cast auf Graphics2D
			g2d.setColor(Color.red);							// zeichenfarbe des g2d-objekts auf rot setzen
			BasicStroke stil = new BasicStroke(30.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);	// objekt f�r linienstil mit parametern: breite, linienende, kreuzungspunkte
			g2d.setStroke(stil);								// linienart auf linienstil stil setzen
			GradientPaint fuellung = new GradientPaint(0, 0, Color.red, 100, 100, Color.yellow, true);	// objekt f�r farbverlauf mit parametern: anfangs-punkt, dessen farbe, endpunk, dessen farbe, wiederholungs-boolean
			g2d.setPaint(fuellung);								// farbart auf farbverlauf (objekt fuellung) setzen
			switch (figur) {									// switch-case f�r die jeweilige geometrische figur die zu zeichnen ist
			case 'R':																// im fall variable R f�r rechteck..
				Rectangle2D.Float rechteck = new Rectangle2D.Float(x1, y1, x2, y2);	// rechteck-objekt erzeugen mit x,y,breite, h�he
				if (jCheckBgefuellt.isSelected()){									// wenn checkbox angehakt
					g2d.fill(rechteck);												// objekt rechteck ausgef�llt ins objekt g2d malen
				} else {															// sonst
					g2d.draw(rechteck);												// objekt rechteck leer ins objekt g2d zeichnen
				}
				break;
			case 'K':																// alles analog rechteck:
				Ellipse2D.Float kreis = new Ellipse2D.Float(x1, y1, x2, x2);		
				if (jCheckBgefuellt.isSelected()){
					g2d.fill(kreis);												// x2, x2, weil h�he + breite gleich bei kreis
				} else {
					g2d.draw(kreis);
				}
				break;
			case 'O':																// alles analog rechteck:
				Ellipse2D.Float oval = new Ellipse2D.Float(x1, y1, x2, y2);
				if (jCheckBgefuellt.isSelected()) {
					g2d.fill(oval);
				} else {
					g2d.draw(oval);
				}
				break;
			case 'L':																// analog rechteck aber nur die ungef�llte version weil linie
				Line2D.Float linie = new Line2D.Float(x1, y1, x2, y2);
				g2d.draw(linie);
				break;
			}
		} catch (Exception e){														// fehlerausgabe f�r fehler beim zeichnen
			JOptionPane.showMessageDialog(this, "Die Eingaben sind ung�ltig");
		}
	}
	
	private void jBtnEndeActionPerformed(ActionEvent evt) {
		System.exit(0);
	}
	
	private void jBtnLoeschenActionPerformed(ActionEvent evt) {
		jPanelZeichenflaeche.repaint();							// panel leeer neu zeichnen
	}

}
