/* 13.5.   Aufgabe 5, s.437		!!!!!!!!!!!!!
 * class TextAusgabeObjekt		& 	JMyTextPanel	&	JMyTextPanel_Aufruf_KomponenteFuerTextPerMausklick_paintComponentLernfaehig_RepaintBeiFrameveraenderungen_TextZeichner3
 * 
 */

package uebungen13Aufgaben;

import java.awt.Color;

public class TextAusgabeObjekt {		// klasse zur beschreibung einer geometrischen figur
	
	// attribute des TextAusgabeObjekts
	private int x, y;			// für x- & y-koordinaten des mauszeigers beim klicken (= wo das objekt gezeichnet wird im panel)
	private String text;		// für text der geschrieben wird im panel
	private Color farbe;		// für aktuelle zeichenfarbe mit der gezeichnet wird
	
	// konstruktor um die werte der vier eigenschaften des TextAusgabeObjekts zu übergeben
	public TextAusgabeObjekt(int posX, int posY, String t, Color f  ) {
		x = posX;					
		y = posY;
		text = t;
		farbe = f;
	}
	
	// getter für jede eigenschaft des TextAusgabeObjekts
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public String getText() {
		return text;
	}

	public Color getColor() {
		return farbe;
	}

}
