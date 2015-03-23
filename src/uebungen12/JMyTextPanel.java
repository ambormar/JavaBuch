/* TODO 12.3.6.   s.437, !!!!!!!!!!!!!!!!!!	
 * & TODO 13.5.   Aufgabe 6, s.437, JMyTextPanel extends JPanel, PaintComponent �berschrieben
 * class JMyTextPanel	&	TextAusgabeObjekt	&	JMyTextPanel_Aufruf_KomponenteFuerTextPerMausklick_paintComponentLernfaehig_RepaintBeiFrameveraenderungen_TextZeichner3
 * 
 * 	SIEHE ANALOG GEL�STE:		13.2.5.   JMyPaintPanel_Aufruf_KomponenteZumHineinZeichnen_paintComponentLernfaehig_RepaintBeiFrameveraenderungen_Zeichnen4		s.413, (3. ANSATZ)  MIT REPAINT() bei framever�nderungen; mit Graphics2D
 *  
 *  					&:		13.2.5.   JMyPaintPanel											s.413, (3. ANSATZ)   JMyPaintPanel extends JPanel, PaintComponent �berschrieben
 *  
 *  					&: 		13.2.5.   Zeichenobjekt											s.413, (3. ANSATZ)  (Kl. z. speichern der infos einer geom. figur) 
 *  
 * 
 * K&K:		Programm Textzeichner3:		(nutzt die Komponente JMyTextPanel & die Klasse TextAusgabeObjekt)
 * 										Gibt an beliebigen Positionen eines Panels Text in den Farben schwarz oder rot aus.
 * 										Die selbst erstellte Komponente JMyTextPanel �bernimmt das zeichnen der Textzeilen. Als Beh�lter nutzt die Komponente eine ArrayList (=Vector?).
 * 
 *			Klasse TextAusgabeObjekt:	Sie speichert Textzeilen mit Position und Farbe. (((Die Klasse implementiert das Interface Serializable)))
 *
 *			Klasse JMyTextPanel:		Die Klasse ist von der Standardkomponente JPanel abgeleitet. Die von ihm dargestellten Textzeilen werden in einer ArrayList (Vector?)
 * 										gespeichert. Die ArrayList (Vector?) speichert die Textzeilen als Objekte der Klasse Textausgabe.
 *
 * AUFGABENSTELLUNG:	
 * 						
 * 		TextZeicher3:	- erweiterung von Textzeichner1*:
 * 						- das panel muss bei framever�nderungen den text auto-repainten k�nnen (=>abgeleitete panel-komponente n�tig:	JMyTextPanel = new JPanel() )
 *			
 *			BESTEHEND AUS:	
 * 
 * 			1. class TextAusgabeObjekt						=> klasse zur speicherung der informationen (text, x-y-koordinaten, farbe) zu einem TextAusgabeObjekt 
 * 
 * 			2. class JMyTextPanel (extends JPanel)			=> von JPanel abgeleitete klasse mit:	beh�lter (ArrayList) f�r TextAusgabeObjekte	&	lernf�higer paintComponent()-methode
 * 
 * 			3. JMyTextPanel_Aufruf_KomponenteFuerTextPerMausklick_paintComponentLernfaehig_RepaintBeiFrameveraenderungen_TextZeichner3		=> von JFrame abgeleitete klasse als TextZeichenProgramm
 * 
 * 
 * 	[	*TextZeichner1:	- standardpanel, in das text an einer beliebigen position durch mausklick eingesetzt werden kann
 * 						- radio-buttons f�r farbe des textes (rot + schwarz)
 * 						- textfeld zur texteingabe
 * 						- zeichnen des textes mit der methode:		 drawString(Strings, float x, float y) 		der klasse Graphics2d		]
 * 
 * 
 */

package uebungen12;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.util.ArrayList;

import javax.swing.JPanel;

public class JMyTextPanel extends JPanel {					
	
	private ArrayList<TextAusgabeObjekt> texte;						// (als Eigenschaft der Klasse:) ArrayList texte mit Objektdatentyp TextAusgabeObjekt => zur Aufnahme der TextAusgabeObjekte	

	// autogenerierte konstruktoren der superclass JPanel
	public JMyTextPanel() {
		super();
		texte = new ArrayList<TextAusgabeObjekt>();					// erzeugen des ArrayList-objekts in jedem konstruktor
	}

	// autogenerierte konstruktoren der superclass JPanel
	public JMyTextPanel(LayoutManager layout) {
		super(layout);
		texte = new ArrayList<TextAusgabeObjekt>();					// erzeugen des ArrayList-objekts in jedem konstruktor
	}

	// autogenerierte konstruktoren der superclass JPanel
	public JMyTextPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		texte = new ArrayList<TextAusgabeObjekt>();					// erzeugen des ArrayList-objekts in jedem konstruktor
	}

	// autogenerierte konstruktoren der superclass JPanel
	public JMyTextPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		texte = new ArrayList<TextAusgabeObjekt>();					// erzeugen des ArrayList-objekts in jedem konstruktor
	}

	// methode zur �bergabe des TextAusgabeObjekts als schnittstelle zwischen dem TextAusgabeProgramm (.._TextZeichner3) und der TextAusgabeFl�che (JMyTextPanel) 
	public void addTextAusgabeObjekt(int posX, int posY, String t, Color f) {
		texte.add(new TextAusgabeObjekt(posX, posY, t, f));			// erstellen eines neuen TextAusgabeObjekts und ablegen im in der ArrayList unter �bergabe aller werte
	}
	
	// �berschreiben der paintComponent(..)-methode der superklasse (JPanel), um ein TextAusgabeObjekt nach dem anderen aus dem beh�lter (=ArrayList) zu nemen und zu zeichnen
	public void paintComponent(Graphics g) {
		super.paintComponent(g);									// aufruf der methode paintComponent(..) der superklasse unter �bergabe des graphic-objekts g 
		Graphics2D g2d = (Graphics2D) g;							// graphics2D-kontext-objekt g2d erstellen zurch zuweisen des gecasteten graphics-objekt g
		for (int i = 0; i < texte.size(); i++) {					// for-schleife f�r alle im 'beh�lter' arraylist texte gespeicherten TextAusgabeObjekte (eins nach dem anderen)
			TextAusgabeObjekt tao = texte.get(i);					// lokale instanz erstellen des jeweiligen elements aus arraylist texte
			g2d.setColor(tao.getColor());							// graphic2d-objekt g2d auf zeichenfarbe des jeweiligen TextAusgabeObjekts setzen
			g2d.drawString(tao.getText(), tao.getX(), tao.getY());	// via grafik2d-kontext-objekt methode zum zeichnen von text mit parameter (text des tao, koordinaten x + y jeweiligen tao)
		}
	}
	
	// (MEINE EIGENE) methode zum l�schen des jeweils zuletztgezeichneten TextAusgabeObjekts als schnittstelle zwischen dem TextAusgabeProgramm (.._TextZeichner3) und der TextAusgabeFl�che (JMyTextPanel)
	public void loescheLetztesTextObjekt(){
		texte.remove(texte.size()-1);								// das jeweils lezte element der arraylist texte l�schen
	}
	
}
