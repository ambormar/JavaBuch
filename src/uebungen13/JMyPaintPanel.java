/* TODO 13.2.5.   s.413, (3. ANSATZ)   JMyPaintPanel extends JPanel, PaintComponent überschrieben
 * class JMyPaintPanel	&	JMyPaintPanel_KomponenteZumHineinZeichnen_paintComponentLernfaehig_RepaintBeiFrameveraenderungen_Zeichnen4	&	Zeichenobjekt
 * 
 * 
 * K&K:		Programm Zeichnen4 (erweiterung von Zeichnen3) 
 * 			(Unter Verwendung von Graphics2D statt Graphics)
 * 						
 * 			Dem Anwender steht ein Panel, auf das er verschiedene geometrische Figuren zeichnen kann, zur Verfügung. 
 * 			Position und Größe der Figuren können frei bestimmt werden.
 * 			Die Zeichnungen bleiben beim Neuzeichnen z.B. nach Verschieben des Fensters dauerhaft erhalten.
 * 
 * 
 * PROGRAMM MIT STANDARDKOMPONENTE (hier Panel) MIT LERNFÄHIGER PAINT() / PAINTCOMPONENT-METHODE, 
 * 												ZUM HINEINZEICHNEN VON ZEICHENOBJEKTEN - MIT REPAINT() BEI FRAMEVERÄNDERUNGEN (INKL. DER GEZEICHENETEN OBJEKTE), (3.ANSATZ):
 * 
 * 		BESTEHEND AUS:	
 * 
 * 			1. class Zeichenobjekt							=> klasse zur speicherung der informationen zu einer geometrischen figur
 * 
 * 			2. class JMyPaintPanel (extends JPanel)			=> von JPanel abgeleitete klasse mit:	behälter (ArrayList) für geometrische figuren	&	lernfähiger paintComponent()-methode
 * 
 * 			3. JMyPaintPanel_KomponenteZumHineinZeichnen_paintComponentLernfaehig_RepaintBeiFrameveraenderungen_Zeichnen4			=> von JFrame abgeleitete klasse als zeichenproramm
 * 
 * 
 * 1. ZEICHENOBJEKT
 * 
 * 		K&K:		Klasse Zeichenobjekt: Die Klasse beschreibt zu zeichnende Objekte so, dass sie in einer ArrayList gespeichert werden können.
 * 
 * 		VORGEHEN:	SIEHE: class ZeichenObjekt
 * 
 * 
 * 2. JMYPAINTPANEL (EXTENDS JPANEL)
 * 		
 * 		K&K:		Klasse JMyPaintPanel. Die Klasse ist von der Standardkomponente JPanel abgeleitet. Sie dient der Demonstration des Zeichnens in eine Komponente.
 * 		
 * 		VORGHEN:	1. Klasse für die Zeichenfläche: 	JMyPaintPanel extends JPanel erstellen im Eclipse Dialog (inkl. autogenerierung der superclass-konstruktoren) mittels:		
 * 											- New > Class > Name: 			JMyPaintPanel 	
 * 															Superclass:		javax.swing.JPanel	
 * 															anhäckeln:		Construktors from superclass	
 * 						(man könnte JMyPaintPanel auch über:	New > Other > GUI-forms > swing > JPanel	erstellen, dann lassen sich aber die konstruktoren der superklasse nicht auto-generieren)
 * 					
 * 					2. ArrayList (inkl. Objektdatentyp) zur aufnahme der zeichenobjekte:	- deklarieren (oben, als attribut der klasse):				private ArrayList<ZeichenObjekt> figuren;
 * 																							- & erzeugen des ArrayList-objekts in jedem konstruktor:	figuren = new ArrayList<ZeichenObjekt>();
 * 					
 * 					3. methode zur übergabe des zeichenobjekts als schnittstelle zwischen dem Zeichenprogramm (Zeichnen4) und der Zeichenfläche (JMyPaintPanel):
 * 
 * 						public void addZeichObjekt(char t, boolean f, int x, int y, int v, int w, Color c, float lb) {
 *							figuren.add(new ZeichenObjekt(t,f,x,y,v,w,c,lb));		// erstellen eines neuen Zeichenobjekts (unter übergabe aller werte) und ablegen im in der ArrayList
 *						}
 *
 *					4. überschreiben von paintComponent(..) der superklasse:	
 *						=> damit sie "lernfähig" ist & darauf gezeichnete elemente (hier: zeichenobjekte) beim repaint() mitgezeichnet werden
 *						=> nur in PAINT() ODER PAINTCOMPONENT() hinterlegte anweisungen, werden beim REPAINT() einer komponente (hier: panel) mitgezeichnet, 
 *						
 *						KERNCODE:
 *																  															
 *						public void paintComponent(Graphics g) {					// überschreiben der paintComponent(..)-Methode der superklasse (JPanel), um ein ZeichenObjekt nach dem anderen aus dem behälter (=ArrayList) zu nemen und zu zeichnen
 *							super.paintComponent(g);								// aufruf der methode paintComponent(..) der superklasse unter übergabe des graphic-objekts g 
 *							Graphics2D g2d = (Graphics2D) g;						// graphics2D-kontext-objekt g2d erstellen zurch zuweisen des gecasteten graphics-objekt g
 *							for (int i= 0; i < figuren.size(); i++) {				// for-schleife für alle im 'behälter' arraylist figuren gespeicherten zeichenobjekte (eins nach dem anderen)
 *								ZeichenObjekt zo = figuren.get(i);					// lokale instanz erstellen des jeweiligen elements aus arraylist figuren
 *								g2d.setColor(zo.getCol());							// graphic2d-objekt g2d auf zeichenfarbe des jeweiligen zeichenobjekts setzen
 *								BasicStroke stil = new BasicStroke(zo.getLbreite(), BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);	// objekt für linienstil mit parametern: breite, linienende, kreuzungspunkte
 *								g2d.setStroke(stil);													// linienart auf linienstil stil setzen
 *								switch (zo.getTyp()) {													// switch-case mit typ (der jeweilige geometrische figur) aus der jeweiligen zeichenobjekt-instanz
 *								case 'R':																// im fall variable R für rechteck..
 *									Rectangle2D.Float rechteck = new Rectangle2D.Float(zo.getX1(), zo.getY1(), zo.getX2(), zo.getY2());	// rechteck-objekt erzeugen mit x,y,breite, höhe (des jeweiligen zeichenobjekts)
 *									if (zo.isGefuellt()) {												// wenn checkbox angehakt
 *										g2d.fill(rechteck);												// objekt rechteck ausgefüllt ins objekt g2d malen
 *									} else {															// sonst
 *										g2d.draw(rechteck);												// objekt rechteck leer ins objekt g2d zeichnen
 *									}
 *									break;
 *								case 'K':																// alles analog rechteck:
 *									...
 *								case 'O':																// alles analog rechteck:
 *									...
 *								case 'L':																// alles analog rechteck, aber nur die ungefüllte version weil linie:
 *									...
 *								}
 *							}
 *						}
 *  
 * 					5. (fakultativ) methode zum löschen des jeweils zuletztgezeichneten zeichenobjekts als schnittstelle zwischen dem Zeichenprogramm (Zeichnen4) und der zeichenfläche (JMyPaintPanel)
 *						
 *						public void loescheLetztesZeichenObjekt(){
 *							figuren.remove(figuren.size()-1);						// das jeweils lezte element der arraylist figuren löschen
 *						}
 * 
 * 
 * 3. ZEICHENPROGRAMM - JMyPaintPanel_KomponenteZumHineinZeichnen_paintComponentLernfaehig_RepaintBeiFrameveraenderungen_Zeichnen4
 * 
 * 		K&K:		Programm Zeichnen4 (erweiterung von Zeichnen3) (Unter Verwendung von Graphics2D statt Graphics)
 * 					Dem Anwender steht ein Panel, auf das er verschiedene geometrische Figuren zeichnen kann, zur Verfügung. Position und Größe der Figuren können frei bestimmt werden.
 * 					Die Zeichnungen bleiben beim Neuzeichnen z.B. nach Verschieben des Fensters dauerhaft erhalten.
 * 
 * 		VORGEHEN: 	SIEHE:	class JMyPaintPanel_KomponenteZumHineinZeichnen_paintComponentLernfaehig_RepaintBeiFrameveraenderungen_Zeichnen4																
 *
 */

package uebungen13;

import java.awt.BasicStroke;		
import java.awt.Color;
import java.awt.Graphics;			// guck
import java.awt.Graphics2D;			// guck
import java.awt.LayoutManager;		// themenspez. import
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;			// guck

import javax.swing.JPanel;			// guck


public class JMyPaintPanel extends JPanel {
	
	private ArrayList<ZeichenObjekt> figuren;					// (als Eigenschaft der Klasse:) ArrayList figuren mit Objektdatentyp ZeichenObjekt => zur Aufnahme der zeichenobjekte	

	// autogenerierte konstruktoren der superclass JPanel
	public JMyPaintPanel() {									
		super();
		figuren = new ArrayList<ZeichenObjekt>();				// erzeugen des ArrayList-objekts in jedem konstruktor
	}
	
	// autogenerierte konstruktoren der superclass JPanel
	public JMyPaintPanel(LayoutManager arg0) {					
		super(arg0);
		figuren = new ArrayList<ZeichenObjekt>();				// erzeugen des ArrayList-objekts in jedem konstruktor
	}
	
	// autogenerierte konstruktoren der superclass JPanel
	public JMyPaintPanel(boolean arg0) {						
		super(arg0);
		figuren = new ArrayList<ZeichenObjekt>();				// erzeugen des ArrayList-objekts in jedem konstruktor
	}
	
	// autogenerierte konstruktoren der superclass JPanel
	public JMyPaintPanel(LayoutManager arg0, boolean arg1) {	
		figuren = new ArrayList<ZeichenObjekt>();				// erzeugen des ArrayList-objekts in jedem konstruktor
	}
	
	// methode zur übergabe des zeichenobjekts als schnittstelle zwischen dem Zeichenprogramm (Zeichnen4) und der Zeichenfläche (JMyPaintPanel) 
	public void addZeichObjekt(char t, boolean f, int x, int y, int v, int w, Color c, float lb) {
		figuren.add(new ZeichenObjekt(t,f,x,y,v,w,c,lb));		// erstellen eines neuen Zeichenobjekts und ablegen im in der ArrayList unter übergabe aller werte
	}
	
	// (meine eigene) methode zum löschen des jeweils zuletztgezeichneten zeichenobjekts als schnittstelle zwischen dem Zeichenprogramm (Zeichnen4) und der zeichenfläche (JMyPaintPanel)
	public void loescheLetztesZeichenObjekt(){
		figuren.remove(figuren.size()-1);						// das jeweils lezte element der arraylist figuren löschen
	}
	
	// überschreiben der paintComponent(..)-methode der superklasse (JPanel), um ein ZeichenObjekt nach dem anderen aus dem behälter (=ArrayList) zu nemen und zu zeichnen
	public void paintComponent(Graphics g) {
		super.paintComponent(g);								// aufruf der methode paintComponent(..) der superklasse unter übergabe des graphic-objekts g 
		Graphics2D g2d = (Graphics2D) g;						// graphics2D-kontext-objekt g2d erstellen zurch zuweisen des gecasteten graphics-objekt g
		for (int i= 0; i < figuren.size(); i++) {				// for-schleife für alle im 'behälter' arraylist figuren gespeicherten zeichenobjekte (eins nach dem anderen)
			ZeichenObjekt zo = figuren.get(i);					// lokale instanz erstellen des jeweiligen elements aus arraylist figuren
			g2d.setColor(zo.getCol());							// graphic2d-objekt g2d auf zeichenfarbe des jeweiligen zeichenobjekts setzen
			BasicStroke stil = new BasicStroke(zo.getLbreite(), BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);	// objekt für linienstil mit parametern: breite, linienende, kreuzungspunkte
			g2d.setStroke(stil);													// linienart auf linienstil stil setzen
			switch (zo.getTyp()) {													// switch-case mit typ (der jeweilige geometrische figur) aus der jeweiligen zeichenobjekt-instanz
			case 'R':																// im fall variable R für rechteck..
				Rectangle2D.Float rechteck = new Rectangle2D.Float(zo.getX1(), zo.getY1(), zo.getX2(), zo.getY2());	// rechteck-objekt erzeugen mit x,y,breite, höhe (des jeweiligen zeichenobjekts)
				if (zo.isGefuellt()) {												// wenn checkbox angehakt
					g2d.fill(rechteck);												// objekt rechteck ausgefüllt ins objekt g2d malen
				} else {															// sonst
					g2d.draw(rechteck);												// objekt rechteck leer ins objekt g2d zeichnen
				}
				break;
			case 'K':																// alles analog rechteck:
				Ellipse2D.Float kreis = new Ellipse2D.Float(zo.getX1(), zo.getY1(), zo.getX2(), zo.getX2());	// x2, x2, weil höhe + breite gleich bei kreis
				if (zo.isGefuellt()) {
					g2d.fill(kreis);
				} else {
					g2d.draw(kreis);
				}
				break;
			case 'O':																// alles analog rechteck:
				Ellipse2D.Float oval = new Ellipse2D.Float(zo.getX1(), zo.getY1(), zo.getX2(), zo.getY2());
				if (zo.isGefuellt()) {
					g2d.fill(oval);
				} else {
					g2d.draw(oval);
				}
				break;
			case 'L':																// alles analog rechteck, aber nur die ungefüllte version weil linie:
				Line2D.Float linie = new Line2D.Float(zo.getX1(), zo.getY1(), zo.getX2(), zo.getY2());
				g2d.draw(linie);
				break;
			}
		}
	}

}
