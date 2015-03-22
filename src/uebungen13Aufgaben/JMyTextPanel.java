/* TODO 13.5.   Aufgabe 5, s.437, (extends JPanel) !!!!!!!!!!!!
 * class JMyTextPanel	&	TextAusgabeObjekt	&
 * 
 * 
 */

package uebungen13Aufgaben;

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

	// methode zur übergabe des TextAusgabeObjekts als schnittstelle zwischen dem TextAusgabeProgramm (.._TextZeichner3) und der TextAusgabeFläche (JMyTextPanel) 
	public void addTextAusgabeObjekt(int posX, int posY, String t, Color f) {
		texte.add(new TextAusgabeObjekt(posX, posY, t, f));			// erstellen eines neuen TextAusgabeObjekts und ablegen im in der ArrayList unter übergabe aller werte
	}
	
	// überschreiben der paintComponent(..)-methode der superklasse (JPanel), um ein TextAusgabeObjekt nach dem anderen aus dem behälter (=ArrayList) zu nemen und zu zeichnen
	public void paintComponent(Graphics g) {
		super.paintComponent(g);									// aufruf der methode paintComponent(..) der superklasse unter übergabe des graphic-objekts g 
		Graphics2D g2d = (Graphics2D) g;							// graphics2D-kontext-objekt g2d erstellen zurch zuweisen des gecasteten graphics-objekt g
		for (int i = 0; i < texte.size(); i++) {					// for-schleife für alle im 'behälter' arraylist texte gespeicherten TextAusgabeObjekte (eins nach dem anderen)
			TextAusgabeObjekt tao = texte.get(i);					// lokale instanz erstellen des jeweiligen elements aus arraylist texte
			g2d.setColor(tao.getColor());							// graphic2d-objekt g2d auf zeichenfarbe des jeweiligen TextAusgabeObjekts setzen
			g2d.drawString(tao.getText(), tao.getX(), tao.getY());	// via grafik2d-kontext-objekt methode zum zeichnen von text mit parameter (text des tao, koordinaten x + y jeweiligen tao)
		}
	}
	
	// (MEINE EIGENE) methode zum löschen des jeweils zuletztgezeichneten TextAusgabeObjekts als schnittstelle zwischen dem TextAusgabeProgramm (.._TextZeichner3) und der TextAusgabeFläche (JMyTextPanel)
	public void loescheLetztesTextObjekt(){
		texte.remove(texte.size()-1);								// das jeweils lezte element der arraylist texte löschen
	}
	
}
