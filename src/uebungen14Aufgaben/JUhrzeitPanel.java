/* TODO 14.3.4.   Aufgabe 4,   s.460, (extends JPanel) ohne 2. Thread, dafür repaint() & System.currenTime.. im paintComponent()
 * class 	JUhrzeitPanel		&		Thread_JUhrzeitPanel_OhneExtraThread_Uhrzeit2
 * 
 * K&K:		Klasse JUhrzeitPanel:		(Musterlösung zu Kapitel 14 Aufgabe 4)
 * 				Die Klasse ist von der Klasse JPanel abgeleitet. Die Klasse stellt die aktuelle Uhrzeit in einem Panel dar.
 * 				Die Uhrzeit wird ohne zusätzlichen Thread ständig aktualisiert. 
 * 					-> Unter benutzung von repaint() + System.currentTimeMillis(..) wird die paintComponent()-methode so oft aufgerufen, ..
 * 						..dass man keinen zusätzlichen thread braucht um eine laufande uhr zu erhalten
 * 
 * 
 * 
 * 			Programm Uhrzeit2:			(Musterlösung zu Kapitel 14 Aufgabe 4)
 * 				Das Programm verwendet die selbsterstellte klasse JUhrzeitPanel, um eine laufende Uhr als Panel in einem Frame darzustellen. 
 * 
 * VORGEHEN:	Klasse JUhrzeitPanel:	
 * 	
 * 					=> OHNE implementieren des Interface Runnable 		-> also OHNE 2. Thread
 * 
 * 					=> nur paintComponent() überschreiben, u.a. mit uhrzeit als formatiertem string mit der aktuellenn uhrzeit aus System.currentTimeMillis(..) 	& 	repaint():
 * 						
 * 						public void paintComponent(Graphics g) {													// NUR überschreiben von paintComponent() 
 * 							..
 * 							SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");								// zeitformatierung  mit der klasse SimppleDateFormate, als Parameter das gewünschte format
 *							String uhrzeit = sdf.format(System.currentTimeMillis());								// objekt sdf mit formatierter aktueller uhrzeit dem string zuweisen  // Holt die aktuelle Uhrzeit in die Variable uhrzeit
 *							..
 *							g.drawString(uhrzeit, 0, (int) this.getSize().getHeight());								// string ausgeben, parameter: string uhrzeit, x-koord 0, y-koord gesamthöhe des panels 
 *							repaint();																				// WICHTIGST ohne repaint() läuft die uhr nicht, weil sie sich zwar ohne zusätzlichen thread erneuert, aber repaint() braucht
 *						}
 *
 *				Programm Uhrzeit2:	
 *
 *					=> einsetzen des JUhrzeitPanels anstelle des standard JPanels
 * 
 * 						jPanel1 = new JUhrzeitPanel();
 * 
 * 
 * 
 * 	PAINTCOMPONENT MIT REPAINT() & SYSTEM.CURRENTTIMEMILLIS(..) ANSTELLE EINES ZUSÄTZLICHEN THREADS :
 *
 * 						-> Unter benutzung von repaint() + System.currentTimeMillis(..) in der überschriebenen paintComponent()-methode, ..
 * 							.. wird die paintComponent()-methode so oft aufgerufen, dass man keinen zusätzlichen thread braucht um eine laufande uhr zu erhalten
 * 
 * 				
 */

package uebungen14Aufgaben;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.text.SimpleDateFormat;

import javax.swing.JPanel;

public class JUhrzeitPanel extends JPanel {														// OHNE implementieren des Interface Runnable

	public JUhrzeitPanel() {
		super();
		
	}

	public void paintComponent(Graphics g) {													// NUR überschreiben von paintComponent() 
		super.paintComponent(g);
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");								// zeitformatierung  mit der klasse SimppleDateFormate, als Parameter das gewünschte format
		String uhrzeit = sdf.format(System.currentTimeMillis());								// objekt sdf mit formatierter aktueller uhrzeit dem string zuweisen  // Holt die aktuelle Uhrzeit in die Variable uhrzeit
		this.setBackground(Color.white);														// hintergrund-farbe vom panel nur verstellt, damit man sieht, dass font (fast) so gross ist wie das panel
		Font oldFont = g.getFont();																// aktuelle schrift ermitteln und in oldFont speichern
		Font font = new Font(oldFont.getFontName(), Font.PLAIN, (int) this.getSize().getHeight() );	// neue schrift bestimmen mit parameter schrifttyp, schriftschnitt + schriftgrösse (= max. höhe des panels) // setzt die Schriftgröße auf die Höhe des Panels
		g.setFont(font);																		// neue schrift setzen für g
		g.drawString(uhrzeit, 0, (int) this.getSize().getHeight());								// string ausgeben, parameter: string uhrzeit, x-koord 0, y-koord gesamthöhe des panels 
		repaint();																				// WICHTIGST ohne repaint() läuft die uhr nicht, weil sie sich zwar ohne zusätzlichen thread erneuert, aber repaint() braucht
	}
	
	
}

