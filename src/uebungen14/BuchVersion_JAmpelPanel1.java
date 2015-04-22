/* TODO 14.2.1,   s.440, ohne 2. thread, ohne paintImmediately()
 * class BuchVersion_JAmpelPanel1	&	BuchVersion_Ampelsteuerung1
 * 
 * ZUR VERANSCHAULICHUNG: 		programm funktioniert nicht fehlerfrei weil paintImmediately oder ein 2. thread fehlen
 * 
 * 		FUNKTIONSFÄHIG SIEHE:		14.2.1.  PaintImmediately_Sleep_InterruptedException_OhneEigenenThread_Einfache_Ampelsteuerung2		&	JAmpelPanel			s.440,	
 *			
 *		BZW MIT 2.THREAD:			14.2.2.		Tread_.._Ampelsteuerung3 																&	JAmpelPanel			s.447	
 * 
 * Klasse JAmpelPanel (von der Komponente JPanel abgeleitet)
 * Die Klasse dient der Darstellung einer Ampel mit den vier
 * Ampelphasen.  
 * 
 */

package uebungen14;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class BuchVersion_JAmpelPanel1 extends JPanel {
	int phase = 0;
	Color coben, cmitte, cunten;

	BuchVersion_JAmpelPanel1() {
		super();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(new Color(0, 80, 0));
		switch (phase) {
		case 0:
			coben = Color.gray;
			cmitte = Color.gray;
			cunten = Color.gray;
			break;
		case 1:
			coben = Color.red;
			cmitte = Color.gray;
			cunten = Color.gray;
			break;
		case 2:
			coben = Color.red;
			cmitte = Color.orange;
			cunten = Color.gray;
			break;
		case 3:
			coben = Color.gray;
			cmitte = Color.gray;
			cunten = Color.green;
			break;
		case 4:
			coben = Color.gray;
			cmitte = Color.orange;
			cunten = Color.gray;
			break;
		}
		int h = getHeight() / 3 - 12;
		int b = getWidth() - 6;
		g.setColor(coben);
		g.fillOval(3, 3, b, h);
		g.setColor(cmitte);
		g.fillOval(3, getHeight() / 3 + 6, b, h);
		g.setColor(cunten);
		g.fillOval(3, 2 * getHeight() / 3 + 9, b, h);
		g.setColor(Color.black);
		g.drawOval(3, 3, b, h);
		g.drawOval(3, getHeight() / 3 + 6, b, h);
		g.drawOval(3, 2 * getHeight() / 3 + 9, b, h);
	}

	public void setPhase(int i) {
		phase = i;
		repaint();
	}

}
