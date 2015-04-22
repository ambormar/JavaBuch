/* TODO 14.2.1.  s.440, (extends JPanel)
 * class 	JAmpelPanel		& 		PaintImmediately_Sleep_InterruptedException_OhneEigenenThread_Einfache_Ampelsteuerung2
 * 
 * 
 * 	VORGEHEN: 	
 * 
 * 		KLASSE JAmpelPanel:		=> von der Komponente JPanel abgeleitet, um sie in der aufrufenden klasse Ampelsteuerung2 anstelle eines standard-jpanels einzusetzen
 * 								=> Die Klasse dient der Darstellung einer Ampel mit den vier Ampelphasen.
 * 
 * 								=> fields: 		int phase = 0;					// variable für die ampel-phasen für den switch (5 mögliche zustände: rot, gelb-rot, grün, gelb + aus)
												Color cOben, cMitte, cUnten;	// farb-variablen für die 3 ampel-kreise oben, mitte, unten
 * 							
 * 								=> paintComponent-methode der superklasse überschreiben, damit die änderungen der komponente (panel) jeweils neugezeichnet werden bei frame-veränderungen
 * 
										public void paintComponent(Graphics g) {
											super.paintComponent(g);					// effektiver aufruf der methode der superklasse unter weitergabe des grafik-objekts g
											..
											switch (phase) {							// switch-case für ampel zustände 
											case 0:										// fall: ampel aus
												cOben = Color.gray;
												cMitte = Color.gray;
												cUnten = Color.gray;
												break;
											case 1:	..									// fall: ampel rot
											case 2:	..									// fall: ampel gelb-rot
											case 3:	..									// fall: ampel grün
											case 4:	..									// fall: ampel gelb
											}
											..											// zeichenen der ampel-lampen
											g.setColor(cOben);							// zuerst aktuelle farbe der obersten lampe setzen, je nach case 
											g.fillOval(3, 3, b, h);						// .. dann oberste lampe zeichnen
											..											// .. usw. für 2. & 3. lampe
										}
									
								=> methode als schnittstelle nach aussen, um die ampel in die jeweilige phase versetzen zu können
								
										public void setPhase(int i) {					// parameter i, um den zustand der phase beim aufruf übergeben zu können		
											phase = i;									// phase auf i setzen
											repaint();									// neuzeichnen der komponente
										}
 */

package uebungen14;

import java.awt.Color;
import java.awt.Graphics;						
import javax.swing.JPanel;


public class JAmpelPanel extends JPanel {

	int phase = 0;									// variable für die ampel-phasen für den switch (5 mögliche zustände: rot, gelb-rot, grün, gelb + aus)
	Color cOben, cMitte, cUnten;					// farb-variablen für die 3 ampel-kreise oben, mitte, unten
	
	public JAmpelPanel() {							// standard-construktor ohne parameter
		super();								
	}
	
	// paintComponent-methode der superklasse überschreiben, damit die änderungen der komponente (panel) jeweils neugezeichnet werden bei frame-veränderungen
	public void paintComponent(Graphics g) {
		super.paintComponent(g);					// effektiver aufruf der methode der superklasse unter weitergabe des grafik-objekts g
		this.setBackground(new Color(0, 80, 0));	// hintergrund des JPanels auf dunkelgrün setzen
		switch (phase) {							// switch-case für ampel zustände 
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
		case 3:										// fall: ampel grün
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
		int h = getHeight()/3 - 12;					// höhe des ampel-farb-kreis = gesamthöhe durch 3, minus 4 mal abstand von 3 px
		int b = getWidth()-6;						// breite des ampel-farb-kreis = gesamtbreite des panels minus 2 mal abstand von 3 px
		g.setColor(cOben);							// jeweilige farbe von cOben (je nach case) für grafikobjket setzen
		g.fillOval(3, 3, b, h);						// oberen kreis pinseln
		g.setColor(cMitte);							// .. dasselbe für mittleren kreis
		g.fillOval(3, getHeight()/3 + 6, b, h);
		g.setColor(cUnten);							// .. + für den unteren
		g.fillOval(3, 2*getHeight()/3 + 9, b, h);				
		g.setColor(Color.black);					// farbe auf schwarz
		g.drawOval(3, 3, b, h);						// + umranden der kreise
		g.drawOval(3, getHeight()/3 + 6, b, h);				
		g.drawOval(3, 2*getHeight()/3 + 9, b, h);
	}
	
	// methode als schnittstelle nach aussen, um die ampel in die jeweilige phase versetzen zu können
	public void setPhase(int i) {					// parameter i, um den zustand der phase beim aufruf übergeben zu können		
		phase = i;									// phase auf i setzen
		repaint();									// neuzeichnen der komponente
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