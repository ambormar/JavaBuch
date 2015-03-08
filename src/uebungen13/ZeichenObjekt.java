/* TODO 13.2.5.   s.413, (3. ANSATZ)  (Kl. z. speichern der infos einer geom. figur) 
 * class	Zeichenobjekt	&	JMyPaintPanel	&	JMyPaintPanel_KomponenteZumHineinZeichnen_paintComponentLernfaehig_RepaintBeiFrameveraenderungen_Zeichnen4	
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
 * 		VORGEHEN:	1. klasse ZeichenObjekt mit den Eigenschaften der zu zeichnenden figuren:	- typ der figur (rechteck, oval, kreis oder linie)
 * 																								- gefüllte figur oder nur umrandung (checkbox jCheckBgefuellt)
 * 																								- koordinaten der figur als x,y, höhe, breite 
 * 																								- zeichenfarbe	&	lnienbreite
 * 				[	2. fakultativ:	konstruktor um die werte der acht eigenschaften des zeichenobjekts zu initialisieren	]
 * 
 * 					3. konstruktor um die werte der acht eigenschaften des zeichenobjekts zu übergeben:		public ZeichenObjekt(char t, boolean f, int x, int y, int v, int w, Color c, float lb) {..}
 * 					
 * 					4. getter und setter für jede der 8 eigenschaften des zeichenobjekts
 * 
 * 
 * 2. JMYPAINTPANEL (EXTENDS JPANEL)
 * 		
 * 		K&K:		Klasse JMyPaintPanel. Die Klasse ist von der Standardkomponente JPanel abgeleitet. Sie dient der Demonstration des Zeichnens in eine Komponente.
 * 		
 * 		VORGHEN:	SIEHE:	JMyPaintPanel
 * 
 * 
 * 3. ZEICHENPROGRAMM - JMyPaintPanel_KomponenteZumHineinZeichnen_paintComponentLernfaehig_RepaintBeiFrameveraenderungen_Zeichnen4
 * 
 * 		K&K:		Programm Zeichnen4 (erweiterung von Zeichnen3) (Unter Verwendung von Graphics2D statt Graphics)
 * 					Dem Anwender steht ein Panel, auf das er verschiedene geometrische Figuren zeichnen kann, zur Verfügung. Position und Größe der Figuren können frei bestimmt werden.
 * 					Die Zeichnungen bleiben beim Neuzeichnen z.B. nach Verschieben des Fensters dauerhaft erhalten.
 * 
 * 		VORGEHEN: 	SIEHE: 	JMyPaintPanel_KomponenteZumHineinZeichnen_paintComponentLernfaehig_RepaintBeiFrameveraenderungen_Zeichnen4													
 *
 */

package uebungen13;

import java.awt.Color;

public class ZeichenObjekt {		// klasse zur beschreibung einer geometrischen figur
	
	// attribute der zu zeichnenden geometrischen figur
	private char typ;					// für typ der figur (rechteck, oval, kreis oder linie
	private boolean gefuellt;			// gefüllte figur oder nur umrandung (checkbox jCheckBgefuellt)
	private int x1, y1, x2, y2;			// für koordinaten, höhe, breite der figur
	private Color col;					// zeichenfarbe
	private float lbreite;				// lnienbreite
	
	// defaultkonstruktor (zum initialisieren der werte, aber eigentlich überflüssig, falls er nicht aufgerufen wird)
	public ZeichenObjekt(){
		typ = 'L';
		gefuellt = false;
		x1 = 0;
		y1 = 0;
		x2 = 0;
		y2 = 0;
		col = Color.gray;
		lbreite = 1.0f;
	}
	
	// konstruktor um die werte der acht eigenschaften des zeichenobjekts zu übergeben
	public ZeichenObjekt(char t, boolean f, int x, int y, int v, int w, Color c, float lb) {
		typ = t;
		gefuellt = f;
		x1 = x;
		y1 = y;
		x2 = v;
		y2 = w;
		col = c;
		lbreite = lb;
	}
	
	// getter & setter für jede eigenschaft des zeichenobjekts
	public char getTyp() {
		return typ;
	}

	public void setTyp(char t) {
		typ = t;
	}

	public boolean isGefuellt() {
		return gefuellt;
	}

	public void setGefuellt(boolean f) {
		gefuellt = f;
	}

	public int getX1() {
		return x1;
	}

	public void setX1(int x) {
		x1 = x;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y) {
		y1 = y;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x) {
		x2 = x;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y) {
		y2 = y;
	}

	public Color getCol() {
		return col;
	}

	public void setCol(Color c) {
		col = c;
	}

	public float getLbreite() {
		return lbreite;
	}

	public void setLbreite(float lb) {
		lbreite = lb;
	}
}
