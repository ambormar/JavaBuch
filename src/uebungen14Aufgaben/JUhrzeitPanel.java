/* TODO 14.3.4.   Aufgabe 4,   s.460, extends JPanel		!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * class 	JUhrzeitPanel		&		Thread_JUhrzeitPanel_.._Uhrzeit2
 * 
 * K&K:		Klasse JUhrzeitPanel:		(Musterlösung zu Kapitel 14 Aufgabe 4)
 * 				Die Klasse ist von der Klasse JPanel abgeleitet.
 * 				Die Klasse stellt die aktuelle Uhrzeit in einem Panel dar.
 * 				Die Uhrzeit wird ohne Thread ständig aktualisiert. 
 * 
 * 
 * !!!!!!!!!! HIER WEITERMACHEN KOMMENTIEREN !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * AUCH NOCH ALLE NÖTIGEN BEGRIIFFE ALS KLASSEN MACHEN
 * 
 * 
 */

package uebungen14Aufgaben;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.text.SimpleDateFormat;

import javax.swing.JPanel;

public class JUhrzeitPanel extends JPanel {

	public JUhrzeitPanel() {
		super();
		
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		String uhrzeit = sdf.format(System.currentTimeMillis());
		this.setBackground(Color.white);														// hintergrund-farbe vom panel nur verstellt, damit man siht, dass font (fast) so gross ist wie das panel
		Font oldFont = g.getFont();																// schon benutzte schrift ermitteln
		Font font = new Font(oldFont.getFontName(), Font.PLAIN, (int) this.getSize().getHeight() );	//
		g.setFont(font);
		g.drawString(uhrzeit, 0, (int) this.getSize().getHeight());								// 
		repaint();																				// WICHTIGST ohne repaint() läuft die uhr nicht, weil sie sich zwar ohne zusätzlichen thread erneuert, aber repaint() braucht
	}
	
	
}
/* Holt die aktuelle Uhrzeit in die Variable uhrzeit
Font oldFont = g.getFont();
Font font = new Font(oldFont.getFontName(), Font.PLAIN, (int) getSize()
	.getHeight());
setFont(font);
// setzt die Schriftgröße auf die Höhe des Panels
g.drawString(uhrzeit, 0, (int) getSize().getHeight());	

*
*
*
*/