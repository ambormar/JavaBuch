/* TODO 13.2.5.   s.413, (3. ANSATZ)   JMyPaintPanel extends JPanel
 * class JMyPaintPanel	&	JPanel_RepaintBeiFrameveraenderungen_Komponente_ZumHineinZeichnen_Zeichnen4	&	Zeichenobjekt
 * 
 * 	VORGHEN:	1. Klasse für die Zeichenfläche: JMyPaintPanel extends JPanel erstellen im Eclipse Dialog (inkl. autogenerierung der superclass-konstruktoren) mittels:		
 * 						- New > Class > Name: 			JMyPaintPanel 	
 * 										Superclass:		javax.swing.JPanel	
 * 										anhäckeln:		Construktors from superclass	
 * 					(man könnte JMyPaintPanel auch über:	New > Other > GUI-forms > swing > JPanel	erstellen, dann lassen sich aber die konstruktoren der superklasse nicht auto-generieren)
 * 
 * 				2. ArrayList (inkl. Objektdatentyp) zur aufnahme der zeichenobjekte:	- deklarieren (oben, als attribut der klasse):				private ArrayList<ZeichenObjekt> figuren;
 * 																						- & erzeugen des ArrayList-objekts in jedem konstruktor:	figuren = new ArrayList<ZeichenObjekt>();
 * 
 * 				3. methode zur übergabe des zeichenobjekts als schnittstelle zwischen dem Zeichenprogramm (Zeichnen4) und der Zeichenfläche (JMyPaintPanel):
 * 
 * 					public void addZeichObjekt(char t, boolean f, int x, int y, int v, int w, Color c, float lb) {
 *						figuren.add(new ZeichenObjekt(t,f,x,y,v,w,c,lb));		// erstellen eines neuen Zeichenobjekts (unter übergabe aller werte) und ablegen im in der ArrayList
 *					}
 *
 *				4. überschreiben der paintCompnent(..)-Methode:		- ausführen der geerbten anweisungen 
 *																	- ein ZeichenObjekt nach dem anderen soll aus dem behälter (ArrayList) genommen & gezeichnet werden
 * 
 * 
 * 
 * K&K:		Klasse JMyPaintPanel
 * 			Die Klasse ist von der Standardkomponente JPanel abgeleitet. Sie dient der Demonstration des Zeichnens in eine Komponente.
 * 
 * 
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

	public JMyPaintPanel() {									// autogenerierte konstruktoren der superclass JPanel
		super();
		figuren = new ArrayList<ZeichenObjekt>();				// erzeugen des ArrayList-objekts in jedem konstruktor
	}

	public JMyPaintPanel(LayoutManager arg0) {					// autogenerierte konstruktoren der superclass JPanel
		super(arg0);
		figuren = new ArrayList<ZeichenObjekt>();				// erzeugen des ArrayList-objekts in jedem konstruktor
	}

	public JMyPaintPanel(boolean arg0) {						// autogenerierte konstruktoren der superclass JPanel
		super(arg0);
		figuren = new ArrayList<ZeichenObjekt>();				// erzeugen des ArrayList-objekts in jedem konstruktor
	}

	public JMyPaintPanel(LayoutManager arg0, boolean arg1) {	// autogenerierte konstruktoren der superclass JPanel
		super(arg0, arg1);
		figuren = new ArrayList<ZeichenObjekt>();				// erzeugen des ArrayList-objekts in jedem konstruktor
	}
	
	// methode zur übergabe des zeichenobjekts als schnittstelle zwischen dem Zeichenprogramm (Zeichnen4) und der Zeichenfläche (JMyPaintPanel) 
	public void addZeichObjekt(char t, boolean f, int x, int y, int v, int w, Color c, float lb) {
		figuren.add(new ZeichenObjekt(t,f,x,y,v,w,c,lb));		// erstellen eines neuen Zeichenobjekts und ablegen im in der ArrayList unter übergabe aller werte
	}
	
	// methode zum löschen der zeichenobjekte als schnittstelle zwischen dem Zeichenprogramm (Zeichnen4) und der zeichenfläche (JMyPaintPanel)
	public void loescheLetztesZeichenObjekt(){
		figuren.remove(figuren.size()-1);										// leztes element der arraylist figuren löschen
	}
	
	// überschreiben der paintComponent(..)-methode der superklasse (JPanel), um ein ZeichenObjekt nach dem anderen aus dem behälter (=ArrayList) zunemen und zu zeichnen
	public void paintComponent(Graphics g) {
		super.paintComponent(g);								// aufruf der methode paintComponent(..) der superklasse unter übergabe des graphic-objekts g 
		Graphics2D g2d = (Graphics2D) g;						// graphics2D-kontext-objekt g2d erstellen zurch zuweisen des gecasteten graphics-objekt g
		for (int i= 0; i < figuren.size(); i++) {				// für alle im arraylist figuren gespeicherten zeichenobjekte
			ZeichenObjekt zo = figuren.get(i);
			g2d.setColor(zo.getCol());
			BasicStroke stil = new BasicStroke(zo.getLbreite(), BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);
			g2d.setStroke(stil);
			switch (zo.getTyp()) {								// switch typ der zeichenobjekt-instanz
			case 'R':	
				Rectangle2D.Float rechteck = new Rectangle2D.Float(zo.getX1(), zo.getY1(), zo.getX2(), zo.getY2());
				if (zo.isGefuellt()) {
					g2d.fill(rechteck);
				} else {
					g2d.draw(rechteck);
				}
				break;
			case 'K':
				Ellipse2D.Float kreis = new Ellipse2D.Float(zo.getX1(), zo.getY1(), zo.getX2(), zo.getX2());
				if (zo.isGefuellt()) {
					g2d.fill(kreis);
				} else {
					g2d.draw(kreis);
				}
				break;
			case 'O':
				Ellipse2D.Float oval = new Ellipse2D.Float(zo.getX1(), zo.getY1(), zo.getX2(), zo.getY2());
				if (zo.isGefuellt()) {
					g2d.fill(oval);
				} else {
					g2d.draw(oval);
				}
				break;
			case 'L':
				Line2D.Float linie = new Line2D.Float(zo.getX1(), zo.getY1(), zo.getX2(), zo.getY2());
				g2d.draw(linie);
				break;
			}
		}
	}

}
