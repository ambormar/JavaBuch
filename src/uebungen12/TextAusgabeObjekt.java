/* TODO 12.3.6.   s.437,		!!!!!!!!!!!!!
 * & TODO 13.5.   Aufgabe 6, s.437, (Kl. z. speichern der infos einer textausgabe)		
 * class TextAusgabeObjekt		& 	JMyTextPanel	&	JMyTextPanel_Aufruf_KomponenteFuerTextPerMausklick_paintComponentLernfaehig_RepaintBeiFrameveraenderungen_TextZeichner3
 * 
 * 	SIEHE ANALOG GELÖSTE:		13.2.5.   JMyPaintPanel_Aufruf_KomponenteZumHineinZeichnen_paintComponentLernfaehig_RepaintBeiFrameveraenderungen_Zeichnen4		s.413, (3. ANSATZ)  MIT REPAINT() bei frameveränderungen; mit Graphics2D
 *  
 *  					&:		13.2.5.   JMyPaintPanel											s.413, (3. ANSATZ)   JMyPaintPanel extends JPanel, PaintComponent überschrieben
 *  
 *  					&: 		13.2.5.   Zeichenobjekt											s.413, (3. ANSATZ)  (Kl. z. speichern der infos einer geom. figur) 
 *  
 * 
 * K&K:		Programm Textzeichner3:		(nutzt die Komponente JMyTextPanel & die Klasse TextAusgabeObjekt)
 * 										Gibt an beliebigen Positionen eines Panels Text in den Farben schwarz oder rot aus.
 * 										Die selbst erstellte Komponente JMyTextPanel übernimmt das zeichnen der Textzeilen. Als Behälter nutzt die Komponente eine ArrayList (=Vector?).
 * 
 *			Klasse TextAusgabeObjekt:	Sie speichert Textzeilen mit Position und Farbe. (((Die Klasse implementiert das Interface Serializable)))
 *
 *			Klasse JMyTextPanel:		Die Klasse ist von der Standardkomponente JPanel abgeleitet. Die von ihm dargestellten Textzeilen werden in einer ArrayList (Vector?)
 * 										gespeichert. Die ArrayList (Vector?) speichert die Textzeilen als Objekte der Klasse Textausgabe.
 *
 * AUFGABENSTELLUNG:	
 * 						
 * 		TextZeicher3:	- erweiterung von Textzeichner1*:
 * 						- das panel muss bei frameveränderungen den text auto-repainten können (=>abgeleitete panel-komponente nötig:	JMyTextPanel = new JPanel() )
 *			
 *			BESTEHEND AUS:	
 * 
 * 			1. class TextAusgabeObjekt						=> klasse zur speicherung der informationen (text, x-y-koordinaten, farbe) zu einem TextAusgabeObjekt 
 * 
 * 			2. class JMyTextPanel (extends JPanel)			=> von JPanel abgeleitete klasse mit:	behälter (ArrayList) für TextAusgabeObjekte	&	lernfähiger paintComponent()-methode
 * 
 * 			3. JMyTextPanel_Aufruf_KomponenteFuerTextPerMausklick_paintComponentLernfaehig_RepaintBeiFrameveraenderungen_TextZeichner3		=> von JFrame abgeleitete klasse als TextZeichenProgramm
 * 
 * 
 * 	[	*TextZeichner1:	- standardpanel, in das text an einer beliebigen position durch mausklick eingesetzt werden kann
 * 						- radio-buttons für farbe des textes (rot + schwarz)
 * 						- textfeld zur texteingabe
 * 						- zeichnen des textes mit der methode:		 drawString(Strings, float x, float y) 		der klasse Graphics2d		]
 * 
 * 
 */

package uebungen12;

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
