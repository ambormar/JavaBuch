/* TODO 14.2.1.  s.440, (extends JPanel)
 * class 	JAmpelPanel		& 		OhneEigenenThread_OhnePaintImmediately_Ampelsteuerung1
 * 
 * 
 * K&K:		Programm Ampelsteuerung1:		 
 * 
 *			Klasse JAmpelPanel:			(von der Komponente JPanel abgeleitet)
 * 										Die Klasse dient der Darstellung einer Ampel mit den vier Ampelphasen.
 * 
 * 
 */

package uebungen14;

import java.awt.Color;
import java.awt.Graphics;						
import javax.swing.JPanel;


public class JAmpelPanel extends JPanel {

	int phase = 0;									// variable f�r den switch der ampel-phasen (5 m�gliche zust�nde: rot, gelb-rot, gr�n, gelb + aus)
	Color cOben, cMitte, cUnten;					// farb-variablen f�r die 3 ampel-kreise oben, mitte, unten
	
	public JAmpelPanel() {							// standard-construktor ohne parameter
		super();								
	}
	
	// paintComponent-methode der superklasse �berschreiben, damit die �nderungen der komponente (panel) jeweils neugezeichnet werden bei frame-ver�nderungen
	public void paintComponent(Graphics g) {
		super.paintComponent(g);					// effektiver aufruf der methode der superklasse unter weitergabe des grafik-objekts g
		this.setBackground(new Color(0, 80, 0));	// hintergrund des JPanels auf dunkelgr�n setzen
		switch (phase) {							// switch-case f�r ampel zust�nde 
		case 0:										// fall: ampel aus
			cOben = Color.gray;
			cMitte = Color.gray;
			cUnten = Color.gray;
			break;
		case 1:										// fall: ampel rot
			cOben = Color.red;
			cMitte = Color.gray;
			cUnten = Color.gray;
			break;
		case 2:										// fall: ampel gelb-rot
			cOben = Color.gray;
			cMitte = Color.orange;
			cUnten = Color.gray;
			break;
		case 3:										// fall: ampel gr�n
			cOben = Color.gray;
			cMitte = Color.gray;
			cUnten = Color.green;
			break;
		case 4:										// fall: ampel gelb
			cOben = Color.gray;
			cMitte = Color.orange;
			cUnten = Color.gray;
			break;
		}
		int h = getHeight()/3 - 12;					// h�he des ampel-farb-kreis = gesamth�he durch 3, minus 4 mal abstand von 3 px
		int b = getWidth()/6;						// breite des ampel-farb-kreis = gesamtbreite des panels minus 2 mal abstand von 3 px
		g.setColor(cOben);							// 
		g.fillOval(3, 3, b, h);
		g.setColor(cMitte);
		g.fillOval(3, h + 6, b, h);
		g.setColor(cUnten);
		g.fillOval(3, 2*h + 9, b, h);
		g.setColor(Color.black);
		g.drawOval(3, 3, b, h);
		g.drawOval(3, h + 6, b, h);
		g.drawOval(3, 2*h + 9, b, h);
	}

}


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/