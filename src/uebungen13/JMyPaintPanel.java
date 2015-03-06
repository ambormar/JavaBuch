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

import java.awt.Color;
import java.awt.Graphics;			// guck
import java.awt.Graphics2D;
import java.awt.LayoutManager;		// themenspez. import
import java.util.ArrayList;			// guck

import javax.swing.JPanel;

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
	
	// überschreiben der paintComponent(..)-methode der superklasse, um ein ZeichenObjekt nach dem anderen aus dem behälter (=ArrayList) zunemen und zu zeichnen
	public void paintComponent(Graphics g) {
		super.paintComponent(g);								// aufruf der methode paintComponent(..) der superklasse unter übergabe des 
		Graphics2D g2D = (Graphics2D) g;						// hier weiter !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		
		
	}

}
