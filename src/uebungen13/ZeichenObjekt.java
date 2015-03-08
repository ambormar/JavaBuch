/* TODO 13.2.5.   s.413, (3. ANSATZ)  (Kl. z. speichern der infos einer geom. figur) 
 * class	Zeichenobjekt	&	JMyPaintPanel	&	JMyPaintPanel_RepaintBeiFrameveraenderungen_Komponente_ZumHineinZeichnen_Zeichnen4	
 * 
 * K&K:		Klasse Zeichenobjekt
 * 			Die Klasse beschreibt zu zeichnende Objekte so, dass sie in einer ArrayList gespeichert werden können.
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
