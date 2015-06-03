/* TODO 14.3.4.   Aufgabe 4,   s.460, (extends JPanel) ohne 2. Thread, daf�r repaint() & System.currenTime.. im paintComponent()
 * class 	JUhrzeitPanel		&		Thread_JUhrzeitPanel_OhneExtraThread_Uhrzeit2
 * 
 * K&K:		Klasse JUhrzeitPanel:		(Musterl�sung zu Kapitel 14 Aufgabe 4)
 * 				Die Klasse ist von der Klasse JPanel abgeleitet. Die Klasse stellt die aktuelle Uhrzeit in einem Panel dar.
 * 				Die Uhrzeit wird ohne zus�tzlichen Thread st�ndig aktualisiert. 
 * 					-> Unter benutzung von repaint() + System.currentTimeMillis(..) wird die paintComponent()-methode so oft aufgerufen, ..
 * 						..dass man keinen zus�tzlichen thread braucht um eine laufande uhr zu erhalten
 * 
 * 
 * 
 * 			Programm Uhrzeit2:			(Musterl�sung zu Kapitel 14 Aufgabe 4)
 * 				Das Programm verwendet die selbsterstellte klasse JUhrzeitPanel, um eine laufende Uhr als Panel in einem Frame darzustellen. 
 * 
 * VORGEHEN:	Klasse JUhrzeitPanel:	
 * 	
 * 					=> OHNE implementieren des Interface Runnable 		-> also OHNE 2. Thread
 * 
 * 					=> nur paintComponent() �berschreiben, u.a. mit uhrzeit als formatiertem string mit der aktuellenn uhrzeit aus System.currentTimeMillis(..) 	& 	repaint():
 * 						
 * 						public void paintComponent(Graphics g) {													// NUR �berschreiben von paintComponent() 
 * 							..
 * 							SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");								// zeitformatierung  mit der klasse SimppleDateFormate, als Parameter das gew�nschte format
 *							String uhrzeit = sdf.format(System.currentTimeMillis());								// objekt sdf mit formatierter aktueller uhrzeit dem string zuweisen  // Holt die aktuelle Uhrzeit in die Variable uhrzeit
 *							..
 *							g.drawString(uhrzeit, 0, (int) this.getSize().getHeight());								// string ausgeben, parameter: string uhrzeit, x-koord 0, y-koord gesamth�he des panels 
 *							repaint();																				// WICHTIGST ohne repaint() l�uft die uhr nicht, weil sie sich zwar ohne zus�tzlichen thread erneuert, aber repaint() braucht
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
 * 	PAINTCOMPONENT MIT REPAINT() & SYSTEM.CURRENTTIMEMILLIS(..) ANSTELLE EINES ZUS�TZLICHEN THREADS :
 *
 * 						-> Unter benutzung von repaint() + System.currentTimeMillis(..) in der �berschriebenen paintComponent()-methode, ..
 * 							.. wird die paintComponent()-methode so oft aufgerufen, dass man keinen zus�tzlichen thread braucht um eine laufande uhr zu erhalten
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

	public void paintComponent(Graphics g) {													// NUR �berschreiben von paintComponent() 
		super.paintComponent(g);
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");								// zeitformatierung  mit der klasse SimppleDateFormate, als Parameter das gew�nschte format
		String uhrzeit = sdf.format(System.currentTimeMillis());								// objekt sdf mit formatierter aktueller uhrzeit dem string zuweisen  // Holt die aktuelle Uhrzeit in die Variable uhrzeit
		this.setBackground(Color.white);														// hintergrund-farbe vom panel nur verstellt, damit man sieht, dass font (fast) so gross ist wie das panel
		Font oldFont = g.getFont();																// aktuelle schrift ermitteln und in oldFont speichern
		Font font = new Font(oldFont.getFontName(), Font.PLAIN, (int) this.getSize().getHeight() );	// neue schrift bestimmen mit parameter schrifttyp, schriftschnitt + schriftgr�sse (= max. h�he des panels) // setzt die Schriftgr��e auf die H�he des Panels
		g.setFont(font);																		// neue schrift setzen f�r g
		g.drawString(uhrzeit, 0, (int) this.getSize().getHeight());								// string ausgeben, parameter: string uhrzeit, x-koord 0, y-koord gesamth�he des panels 
		repaint();																				// WICHTIGST ohne repaint() l�uft die uhr nicht, weil sie sich zwar ohne zus�tzlichen thread erneuert, aber repaint() braucht
	}
	
	
}

