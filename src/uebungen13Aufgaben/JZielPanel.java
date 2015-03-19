/* TODO 13.5.   Aufgabe 2, s.435, (extends JZielPanel)		!!! 
 * class JZielPanel 		&		!!!!!
 * 
 * 
 * 
 */

package uebungen13Aufgaben;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class JZielPanel extends JPanel {

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawRect(0, 0, this.getWidth()-2, this.getHeight()-2);
		g.drawLine(this.getWidth()/2, 0, this.getWidth()/2, this.getHeight());
		g.drawLine(0, this.getHeight()/2, this.getWidth(), this.getHeight()/2);
		g.drawOval(5, 5, this.getWidth()-10, this.getHeight()-10);
		g.drawOval(this.getWidth()/6, this.getHeight()/6, this.getWidth()/3*2, this.getHeight()/3*2);
		g.drawOval(this.getWidth()/6*2, this.getHeight()/6*2, this.getWidth()/3, this.getHeight()/3);
	}
}
