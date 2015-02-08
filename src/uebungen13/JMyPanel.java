/* TODO 13.1.2.   s.398+(400), (JMyPanel extends JPanel)
 * class JMyPanel & 	JPanel_Komponente_MitVerändertemAussehen_JMyPanelZeichnen1
 * 
 * 		SIEHE:			13.1.2.  JPanel_Komponente_MitVerändertemAussehen_JMyPanelZeichnen1									s.400+(398),	(1.ANSATZ, TEIL)
 * 
 * 		SIEHE AUCH:	 	13.1.1.   Graphics_Klasse_Basics_Paint_Repaint_Invalidate_Canvas_InKoponentenZeichnen2Ansaetze			s.396,	
 * 
 * 		SIEHE AUCH:		13.2.1.   JPanel_Komponente_ZumHineinZeichnen_RadioGroup_getGraphics_Zeichnen2							s.403,	 (2. ANSATZ)
 * 									
 * 
 * JPANEL (OD. AUCH JFRAME) ALS KOMPONENTE MIT VERÄNDERTEM AUSSEHEN ERSTELLEN:		(= 1. ANSATZ, TEIL)
 * 
 * 	VORGEHEN:	
 * 
 * 		KURZ:	1. klasse JMyPanel als erweiterung von JPanel erstellen und in der methode paintComponent(..) die grafischen ergänzungen/abänderungen vornehmen, 
 * 																																			die die standardkomponente (Jpanel) nicht hätte.
 * 				2. anwender-klasse JMyPanel_Zeichnen erstellen, mit JPanel als Jgloo-GUI_Standard-element. 
 * 					=> dann allerdings den namen des konstruktors von JPanel() ersetzen durch JMyPanel().
 * 					=> JPanel der superklasse wird so ganz normal angezeigt		
 * 						&	 zusätzlich werden alle änderungen die in der methode paintComponent(Graphics g) von JMyPanel vorgenommen werden auch angezeigt
 * 					-> AUSSERDEM: die Jigloo funktionen zum abändern des JPanels bleiben erhalten 
 * 						-> diese änderungen über die Jigloo-hilfe werden im quellcode der anwenderklasse sichtbar			=> siehe initGUI() 
 * 
 * 
 * 		VORGEHEN KLASSE JMyPANE:
 * 
 * 			1. klasse JMyPanel extends JPanel erstellen + in der methode paintComponent() die grafischen ergänzungen/abänderungen vornehmen, die die standardkomponente nicht hätte
 * 
 * 				a. klasse JMyPanel ganz normal erstellen mit File > new Class > dialogfenster öffnet sich:
 * 
 * 																				-> unter superclass: 			javax.swing.JPanel 	(statt java.lang.Objekt)	einsetzen
 * 																				-> unter name:					JMyPanel (z.b.)
 * 																			[	-> constructors der superclass: könnte man auch autogenerieren (hier sind sie nicht nötig) ]
 *				
 * 				b. paintComponent(Graphics g) von JMyPanel mit den gewünschten änderungen überschreiben:
 * 
 *					=> paintComponent(..) ist zuständig für zeichenoperationen(änderungen), die die komponente selst betreffen
 * 						[ remember:  paint() -methode muss die komponente zeichnen können
 *										-> bei swing-komponenten (z.b. frame, Panel) ruft paint() automatisch paintComponent() +  paintBorder() + paintChildren() auf	] 
 * 						-> paintComponent(Graphics g) liefert kein ergebnis zurück	& 	erwartet eine graphics-komponente 
 * 				
 * 				KERN-CODE:		public class JMyPanel extends JPanel {
 * 
 *									public void paintComponent(Graphics g) {							// überschreiben der Methode paintComponent(..)der superklasse JPanel
 *									super.paintComponent(g);											// paintComponent-methode des vorgängers aufrufen..
 *									g.setColor(Color.red);												// zeichenfarbe einstellen mit der anweisung setColor(..) der klasse Graphics, die argument Color (klasse Color importier) erwartet
 *									g.drawLine(10, 10, this.getWidth() - 10, this.getHeight() -10);		// linie zeichnen (x, y, breite, höhe)
 * 								}
 * 
 * 
 * 
 * 		VORGEHEN KLASSE (ANWENDUNG) JPanel_Komponente_MitVerändertemAussehen_JMyPanelZeichnen1:
 * 
 * 			 2. anwender-klasse als neuen Frame JMyPanel_Zeichnen erstellen, mit JPanel-komponente  als Jgloo-GUI_Standard-element im initGUI()
 *  
 *  			a. frame erstellen (ganz normal mit File > new > other > GUI forms > swing jFrame) JPanel-Komponente reinziehen
 *  			
 * 				b. bezeichner JPanel() ersetzen durch JMyPanel()
 * 					-> bei den attributten der klasse	&	im initGUI() 
 * 
 * 					=> JPanel der superklasse wird so ganz normal angezeigt		
 * 						&	 zusätzlich werden alle änderungen die in der methode paintComponent(Graphics g) von JMyPanel vorgenommen wurden auch angezeigt
 * 
 * 					-> AUSSERDEM: bleiben die Jigloo funktionen zum abändern des JPanels erhalten 
 * 						-> diese änderungen über die propertieis von Jigloo werden im quellcode der anwenderklasse sichtbar			=> siehe initGUI() 
 * 							(z.b. backgroundcolor etc.)
 * 	
 * 		  	KERN-CODE:
 * 
 * 				private JMyPanel jPanel1;												// oben, attribut-typ JPanel durch JMyPanel ersetzen
 * 		
 * 		 		private void initGUI() {
 *					try {
 *						..
 *						{
 *							jPanel1 = new JMyPanel();									// konstruktor JPanel() durch JMyPanel ersetzen
 *							getContentPane().add(jPanel1);
 *							jPanel1.setBounds(12, 12, 360, 204);
 *							jPanel1.setBackground(new java.awt.Color(64,128,128));		// z.b. hintergrundfarbe weiterhin über die properties veränderbar
 *						}
 * 
 * 
 * K&K:		Klasse JMyPanel 
 * 			Die Klasse ist von der Standardkomponente JPanel abgeleitet. 
 * 			Sie demonstriert das Verändern einer Standardkomponente durch das Einzeichnen einer diagonalen Linie.
 * 
 * 			Programm JMyPanel_Zeichnen1
 * 			Verwendet die von JPanel abgeleitete Klasse JMyPaintPanel.
 * 
 */

package uebungen13;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class JMyPanel extends JPanel {
	
	public void paintComponent(Graphics g) {	// überschreiben der Methode paintComponent(..)der superklasse JPanel
		super.paintComponent(g);				// paintComponent-methode des vorgängers aufrufen..
		g.setColor(Color.red);					// zeichenfarbe einstellen mit der anweisung setColor(..) der klasse Graphics, die argument Color (klasse Color importier) erwartet
		g.drawLine(10, 10, this.getWidth() - 10, this.getHeight() -10);	// linie zeichnen (x, y, breite, höhe)
		
		// IGNORIEREN, NUR GRAFIK!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		//ab hier ignorieren nicht so lern-relevant, nur rumgedooft aus freude an "grafik"
		g.setColor(Color.WHITE);
		g.drawString("Hello", 100, 125);
		g.setColor(Color.black);
		g.fillOval(30, 30 , this.getWidth() -60, this.getHeight()-60 );// methode zum gefüllten oval zeichnen von Graphics mit parameter (x,y, breite, höhe)
		g.setColor(Color.WHITE);
		g.drawString("Hello", 100, 125);
		g.setColor(Color.DARK_GRAY);
		g.drawOval(45, 45 , this.getWidth() -90, this.getHeight()-90 );
		g.drawOval(46, 46 , this.getWidth() -92, this.getHeight()-92 );
		g.drawOval(47, 47 , this.getWidth() -94, this.getHeight()-94 );
		g.setColor(Color.GRAY);
		g.drawOval(50, 50 , this.getWidth() -100, this.getHeight()-100 );
		g.drawOval(51, 51 , this.getWidth() -102, this.getHeight()-102 );
		g.drawOval(52, 52 , this.getWidth() -104, this.getHeight()-104 );
		g.setColor(Color.LIGHT_GRAY);
		g.drawOval(55, 55 , this.getWidth() -110, this.getHeight()-110 );
		g.drawOval(56, 56 , this.getWidth() -112, this.getHeight()-112 );
		g.drawOval(57, 57 , this.getWidth() -114, this.getHeight()-114 ); 
		// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	}

}
