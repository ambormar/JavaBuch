/* TODO 14.3.   Aufgabe 1,   s.459, MIT zusätzlichem THREAD, (extends JPanel implements Runnable) (=> JAmpelPanel2 im Buch)
 * class 	JAmpelPanel_5		&		Threads_ZweiAmpelnGleichzeitigAutomatik_ZweiAmpelSteuerung
 * 
 * K&K:	
 * 		Klasse JAmpelPanel_5: 		(Musterlösung zu Kapitel 14 Aufgabe 1)
 * 				Die Klasse dient der Darstellung einer Ampel mit den vier Ampelphasen.
 * 				- NEU: Die klasse soll einen konstruktor besitzen, dem die dauer der einzelnen Ampelphasen übergeben wird. der konstruktor soll diese werte in einem array ablegen
 * 				- wieder mit einer überschriebenen methode paintComponent() um die componente neu zeichnen zu können bei frameveränderungen
 * 				- wieder mit einer methode setPhase(), um von aussen die phasen zu setzen
 * 				- NEU: die komponente selbst soll hier auch eine run()-methode für Threads bereitstellen
 * 
 * VORGEHEN:		
 * 
 * 		JAmpelPanel_5:		
 *
 * 			=> von der Komponente JPanel abgeleitet, um sie in der aufrufenden klasse Ampelsteuerung4 anstelle eines standard-jpanels einzusetzen
 * 			
 * 			=> Die Klasse dient der Darstellung einer Ampel mit den vier Ampelphasen.
 *
 *			=> die klasse impelmentiert Runnable zur bereitstellung von zusätzlichen Threads
 *			
 *					public class JAmpelPanel_5 extends JPanel implements Runnable {	// von JPanel abgeleitete JAmpelPanel-komponente, implementiert Runnabel = stellt weitere Threads bereit,  ..
 *																					// .. run()-methode von Runnabel muss zwangsläufig ünerschrieben werden
 *																					 
 * 			=> fields: 		int phase = 0;												// variable für die ampel-phasen für den switch (5 mögliche zustände: rot, gelb-rot, grün, gelb + aus)
 *							Color cOben, cMitte, cUnten;								// farb-variablen für die 3 ampel-kreise oben, mitte, unten
 *							int[] phasendauer = {3000, 1000, 3000, 1000};				// NEU: array für die phasendauer der verschiedenen ampelphasen inkl. werte
 *							private boolean automatik = false;							// NEU: booleanvariable für bedingung automatik-modus oder nicht 
 *						
 *			=> NEU: zusätzlicher konstruktor, dem die phasendauer der einzelnen Ampelphasen als parameter übergeben wird & der diese in einem array ablegt
 *			
 *							public JAmpelPanel_5(int rot, int rotgelb, int gruen, int gelb) {	
 *								super();
 *								phasendauer[0] = rot;									// array-variablen für die die phasendauer von rot..
 *								phasendauer[1] = rotgelb;								// ..usw
 *								phasendauer[2] = gruen;
 *								phasendauer[3] = gelb;
 *							}							
 * 			=> paintComponent-methode der superklasse überschreiben, damit die änderungen der komponente (panel) jeweils neugezeichnet werden bei frame-veränderungen
 * 
 *						public void paintComponent(Graphics g) {
 *							super.paintComponent(g);					// effektiver aufruf der methode der superklasse unter weitergabe des grafik-objekts g
 *							..
 *							switch (phase) {							// switch-case für ampel zustände 
 *							case 0:										// fall: ampel aus
 *								cOben = Color.gray;
 *								cMitte = Color.gray;
 *								cUnten = Color.gray;
 *								break;
 *							case 1:	..									// fall: ampel rot
 *							case 2:	..									// fall: ampel gelb-rot
 *							case 3:	..									// fall: ampel grün
 *							case 4:	..									// fall: ampel gelb
 *							}
 *							..											// zeichenen der ampel-lampen
 *							g.setColor(cOben);							// zuerst aktuelle farbe der obersten lampe setzen, je nach case 
 *							g.fillOval(3, 3, b, h);						// .. dann oberste lampe zeichnen
 *							..											// .. usw. für 2. & 3. lampe
 *						}	
 *
 *			=> methode als schnittstelle nach aussen, um die ampel in die jeweilige phase versetzen zu können
 *								
 *						public void setPhase(int i) {					// parameter i, um den zustand der phase beim aufruf übergeben zu können		
 *							phase = i;									// phase auf i setzen
 *							repaint();									// neuzeichnen der komponente
 *						}							
 *
 *			=> NEU: run() für zusätzlichen Thread (zwingende folge von implements Runnable) diesmal im JAmpelPanel + nicht wie in anderen beispielen im aufrufenden (frame-)programm 
 *			
 *						@Override																													// siehe 12.4.2.  AtOverride  eigene bemerkung:  => wie ein kommentar bei absichtlichem überschreiben von methoden der superklasse. -> heute java7: ist's guter programmierstil -> evtl. ab java 8 oder 9 unumgänglich, 
 *						public void run() {									// Auto-generated method stub (= methoden-rumpf) bei implements Runnable: für den zusätzlichen thread, der die ampel parallel laufen lässt
 *																			// checkbox automatik blockiert nicht & durch das einzelne durchlaufen jeder phase in der while-schleife reagiert auch die checkbox automatik fehlerfrei direkt (es muss nicht zuerst ein ganzer durchlauf durch die phasen abgearbeitet werden) bei abwahl der automatik
 *							int i = 1;										// lokale variable für's handling der array-werte vom array phasendauer & auch der Phasen von setPhase()
 *								while (automatik) {							// schleife um - neu - eine ampelphase nach der anderen durchlaufen zu lassen, in der Thread-methode run():
 *									try {
 *										setPhase(i);						// via methode setPhase(..), phase auf i (=> 1 bis 4) setzen, repaint() wird in setPhase() erledigt
 *										Thread.sleep(phasendauer[i-1]);		// thread unterbrechen (für array-wert von phasendauer[0 bis 3] milisekunden)
 *										i++;								// i erhöhen für nächste setPhase() & nächsten array-wert der phasendauer[]
 *										if (i > 4) {						// wenn i grösser als 4: sind alle phasen & phasendauer durchlaufen..
 *											i = 1;							// drum i wieder auf anfang = 1
 *										}
 *									} catch (InterruptedException e) {																				// Thread-speziefische exception: sobald threads im spiel sind (es reicht schon die methode sleep() von thread
 *										e.printStackTrace();
 *									}
 *								}
 *						} 
 *
 *
 */

package uebungen14Aufgaben;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.LayoutManager;

import javax.swing.JPanel;

public class JAmpelPanel_5 extends JPanel implements Runnable {	// von JPanel abgeleitete JAmpelPanel-komponente, implementiert Runnabel = stellt weitere Threads bereit, run()-methode von ..
																// .. Runnabel muss zwangsläufig ünerschrieben werden
	private int phase = 0;																										// variable für die ampel-phasen für den switch (5 mögliche zustände: rot, gelb-rot, grün, gelb + aus)
	private int[] phasendauer = {3000, 1000, 3000, 1000};		// array für die phasendauer der verschiedenen ampelphasen inkl. werte
	private Color cOben, cMitte, cUnten;																						// farb-variablen für die 3 ampel-kreise oben, mitte, unten
	public boolean automatik = false;							// neu booleanvariable für bedingung automatik-modus oder nicht
	
	public JAmpelPanel_5() {																									// normaler konstruktor ohne parameter
		super();
	}

	// zusätzlicher konstruktor, dem die phasendauer der einzelnen Ampelphasen als parameter übergeben wird & der diese in einem array ablegt
	public JAmpelPanel_5(int rot, int rotgelb, int gruen, int gelb) {	
		super();
		phasendauer[0] = rot;									// array-variablen für die die phasendauer von rot..
		phasendauer[1] = rotgelb;								// ..usw
		phasendauer[2] = gruen;
		phasendauer[3] = gelb;
	}
	
	public void paintComponent(Graphics g) {																					// paintComponent-methode der superklasse überschreiben, damit die änderungen der komponente (panel) jeweils neugezeichnet werden bei frame-veränderungen
		super.paintComponent(g);																								// effektiver aufruf der methode der superklasse unter weitergabe des grafik-objekts g
		this.setBackground(new Color(0, 80, 0));																				// hintergrund des JPanels auf dunkelgrün setzen
		switch (phase) {																										// switch-case für ampel zustände 
		case 0:																													// fall: ampel aus
			cOben = Color.gray;
			cMitte = Color.gray;
			cUnten = Color.gray;
			break;
		case 1:																													// fall: ampel rot
			cOben = Color.red;
			cMitte = Color.gray;
			cUnten = Color.gray;
			break;
		case 2:																													// fall: ampel gelb-rot
			cOben = Color.gray;
			cMitte = Color.orange;
			cUnten = Color.gray;
			break;
		case 3:																													// fall: ampel grün
			cOben = Color.gray;
			cMitte = Color.gray;
			cUnten = Color.green;
			break;
		case 4:																													// fall: ampel gelb
			cOben = Color.gray;
			cMitte = Color.orange;
			cUnten = Color.gray;
			break;
		}
		int h = getHeight()/3 - 12;																								// höhe des ampel-farb-kreis = gesamthöhe durch 3, minus 4 mal abstand von 3 px
		int b = getWidth()-6;																									// breite des ampel-farb-kreis = gesamtbreite des panels minus 2 mal abstand von 3 px
		g.setColor(cOben);																										// jeweilige farbe von cOben (je nach case) für grafikobjket setzen
		g.fillOval(3, 3, b, h);																									// oberen kreis pinseln
		g.setColor(cMitte);																										// .. dasselbe für mittleren kreis
		g.fillOval(3, getHeight()/3 + 6, b, h);
		g.setColor(cUnten);																										// .. + für den unteren
		g.fillOval(3, 2*getHeight()/3 + 9, b, h);				
		g.setColor(Color.black);																								// farbe auf schwarz
		g.drawOval(3, 3, b, h);																									// + umranden der kreise
		g.drawOval(3, getHeight()/3 + 6, b, h);				
		g.drawOval(3, 2*getHeight()/3 + 9, b, h);
	}
																																// methode als schnittstelle nach aussen, um die ampel in die jeweilige phase versetzen zu können
	public void setPhase(int i) {																								// parameter i, um den zustand der phase beim aufruf übergeben zu können		
		phase = i;																												// phase auf i setzen
		repaint();																												// neuzeichnen der komponente
	}
	
	// run() diesmal im JAmpelPanel + nicht wie in anderen bsp. im aufrufenden programm 
	@Override																													// siehe 12.4.2.  AtOverride  eigene bemerkung:  => wie ein kommentar bei absichtlichem überschreiben von methoden der superklasse. -> heute java7: ist's guter programmierstil -> evtl. ab java 8 oder 9 unumgänglich, 
	public void run() {									// Auto-generated method stub (= methoden-rumpf) bei implements Runnable: für den zusätzlichen thread, der die ampel parallel laufen lässt
														// checkbox automatik blockiert nicht & durch das einzelne durchlaufen jeder phase in der while-schleife reagiert auch die checkbox automatik fehlerfrei direkt (es muss nicht zuerst ein ganzer durchlauf durch die phasen abgearbeitet werden) bei abwahl der automatik
		int i = 1;										// lokale variable für's handling der array-werte vom array phasendauer & auch der Phasen von setPhase()
			while (automatik) {							// schleife um - neu - eine ampelphase nach der anderen durchlaufen zu lassen, in der Thread-methode run():
				try {
					setPhase(i);						// via methode setPhase(..), phase auf i (=> 1 bis 4) setzen, repaint() wird in setPhase() erledigt
					Thread.sleep(phasendauer[i-1]);		// thread unterbrechen (für array-wert von phasendauer[0 bis 3] milisekunden)
					i++;								// i erhöhen für nächste setPhase() & nächsten array-wert der phasendauer[]
					if (i > 4) {						// wenn i grösser als 4: sind alle phasen & phasendauer durchlaufen..
						i = 1;							// drum i wieder auf anfang = 1
					}
				} catch (InterruptedException e) {																				// Thread-speziefische exception: sobald threads im spiel sind (es reicht schon die methode sleep() von thread
					e.printStackTrace();
				}
			}
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