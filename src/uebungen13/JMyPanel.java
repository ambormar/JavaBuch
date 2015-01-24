/* TODO 13.1.2.   s.398,
 * class JMyPanel & 	JPanel_Komponente_MitVer�ndertemAussehen_JMyPanelZeichnen1
 * 
 * 	
 * 
 * 
 * 
 * K&K:		Klasse JMyPanel 
 * 			Die Klasse ist von der Standardkomponente JPanel abgeleitet. 
 * 			Sie demonstriert das Ver�ndern einer Standardkomponente durch das Einzeichnen einer diagonalen Linie.
 */

package uebungen13;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class JMyPanel extends JPanel {
	
	public void paintComponent(Graphics g) {	// �berschreiben der Methode paintComponent(..)der superklasse JPanel
		super.paintComponent(g);				// paintComponent-methode des vorg�ngers aufrufen..
		g.setColor(Color.black);			// zeichenfarbe einstellen mit der anweisung setColor(..) der klasse Graphics, die argument Color (klasse Color importier) erwartet
		g.fillOval(30, 30 , this.getWidth() -60, this.getHeight()-60 );// methode zum linien zeichnen von Graphics mit parameter (x,y, breite, h�he)
		g.setColor(Color.WHITE);
		g.drawString("Hello", 100, 125);
		
		
		
		// sorry v�llig irrelevant nur aus freude am rumdoofen
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
	}

}
