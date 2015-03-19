/* TODO 13.5.   Aufgabe 1, s.435, (extends JButton)
 * class JMyButton 		& 		JMyButton_JZielPanel_KomponentenMitVeraendertemAussehen_TestFrame		& 		JZielPanel 
 * 
 *  	SIEHE:			13.5.   	JZielPanel															Aufgabe 2, s.435, (extends JZielPanel)		 
 *  
 *  	SIEHE:			13.5.   	JMyButton_JZielPanel_KomponentenMitVeraendertemAussehen_TestFrame	Aufgabe 1 & 2, s.435, (extends JFrame) JMyButton statt JButton & JZielPanel statt JPanel 		
 * 
 * 		VERGLEICHE:		13.1.2.   	JMyPanel															s.398+(400), (JMyPanel extends JPanel)
 * 
 * 		VERGLEICHE:		13.1.2.   	JPanel_Komponente_MitVerändertemAussehen_JMyPanelZeichnen1			s.400+(398), (JMyPanel anstelle JPanel) 
 *  
 * 
 * K&K:		Klasse JMyButton
 * 			Die Klasse ist von der Standardkomponente JButton abgeleitet. Sie besitzt als Erweiterung eine grüne Linie als zusätzlichen Rahmen.
 * 
 * K&K:		Programm JMyButton_JZielPanel_KomponentenMitVeraendertemAussehen_TestFrame. 
 * 			Verwendet die Komponenten JZielPanel und JMyButton.
 * 
 * K&K:	 	Klasse JZielPanel
 *	 		Die Klasse ist von der Standardkomponente JPanel abgeleitet. Auf das Panel ist eine Zielscheibe eingezeichnet.
 * 
 * VORGEHEN:	JMyButton	&
 * 				JZielPanel:			ANALOG:		13.1.2.   	JMyPanel		s.398+(400), (JMyPanel extends JPanel)
 * 
 * 				TestFrame:			ANALOG:		13.1.2.   	JPanel_Komponente_MitVerändertemAussehen_JMyPanelZeichnen1		s.400+(398), (JMyPanel anstelle JPanel) 
 * 												=> VORGEHEN KLASSE (ANWENDUNG)
 * 
 */

package uebungen13Aufgaben;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;

public class JMyButton extends JButton {
	
	public void paintComponent(Graphics g){									// überschreiben der Methode paintComponent(..)der superklasse JButton
		super.paintComponent(g);											// paintComponent-methode des vorgängers aufrufen..
		g.setColor(Color.red); 												// zeichenfarbe auf rot setzen	
		g.drawRect(3, 3, this.getWidth()-7 , this.getHeight()-7);			// rechteck-umrandung zeichnen (x, y, breite, höhe)
	}

}
