/* TODO 13.5.   Aufgabe 2, s.435, (extends JZielPanel)	
 * class JZielPanel		& 	JMyButton		&		JMyButton_JZielPanel_KomponentenMitVeraendertemAussehen_TestFrame				 		
 * 
 * 		SIEHE:			13.5.   	JMyButton															Aufgabe 1, s.435, (extends JButton)
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

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class JZielPanel extends JPanel {

	public void paintComponent(Graphics g) {										// überschreiben der Methode paintComponent(..)der superklasse JButton
		super.paintComponent(g);													// paintComponent-methode des vorgängers aufrufen..
		g.setColor(Color.red);
		g.drawLine(this.getWidth()/2, 0, this.getWidth()/2, this.getHeight());		//	[	fadenkreuz: vertikal-linie
		g.drawLine(0, this.getHeight()/2, this.getWidth(), this.getHeight()/2);		// 		fadenkreuz: horizontallinie
		int xMitte = this.getWidth()/2;												// 		x mitte 
		int yMitte = this.getHeight()/2;											//		y mitte
		int r1;																		// 		radius kleinster kreis
		if (this.getWidth() < this.getHeight()) {									//		wenn breite kleiner als höhe..
			r1 = (this.getWidth() - 10) / 6;										// 		radius kleinster kreis von breite ableiten
		} else {																	// 		sonst..
			r1 = (this.getHeight() - 10) / 6;										// 		radius kleinster kreis von höhe ableiten
		}		
		g.drawOval(xMitte - r1, yMitte - r1, 2 * r1, 2 * r1);						// 		kleinster kreis zeichnen: 2 * r gross
		g.drawOval(xMitte - 2 * r1, yMitte - 2 * r1, 4 * r1, 4 * r1);				// 		mittlerer kreis zeichnen: 4 * r gross
		g.drawOval(xMitte - 3 * r1, yMitte - 3 * r1, 6 * r1, 6 * r1);				// 		grösster kreis zeichnen: 6 * r gross	]
	}
	
}
