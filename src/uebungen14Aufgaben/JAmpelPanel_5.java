/* TODO 14.3.   Aufgabe 1,   s.459, MIT zus�tzlichem THREAD, (extends JPanel implements Runnable) (=> JAmpelPanel2 im Buch)
 * class 	JAmpelPanel_5		&		Threads_ZweiAmpelnGleichzeitigAutomatik_ZweiAmpelSteuerung
 * 
 * K&K:	
 * 		Klasse JAmpelPanel_5: 		(Musterl�sung zu Kapitel 14 Aufgabe 1)
 * 				Die Klasse dient der Darstellung einer Ampel mit den vier Ampelphasen.
 * 				- NEU: Die klasse soll einen konstruktor besitzen, dem die dauer der einzelnen Ampelphasen �bergeben wird. der konstruktor soll diese werte in einem array ablegen
 * 				- wieder mit einer �berschriebenen methode paintComponent() um die componente neu zeichnen zu k�nnen bei framever�nderungen
 * 				- wieder mit einer methode setPhase(), um von aussen die phasen zu setzen
 * 				- NEU: die komponente selbst soll hier auch eine run()-methode f�r Threads bereitstellen
 * 
 * VORGEHEN:		
 * 
 * 		JAmpelPanel_5:		
 *
 * 			=> von der Komponente JPanel abgeleitet, um sie in der aufrufenden klasse Ampelsteuerung4 anstelle eines standard-jpanels einzusetzen
 * 			
 * 			=> Die Klasse dient der Darstellung einer Ampel mit den vier Ampelphasen.
 *
 *			=> die klasse impelmentiert Runnable zur bereitstellung von zus�tzlichen Threads
 *			
 *					public class JAmpelPanel_5 extends JPanel implements Runnable {	// von JPanel abgeleitete JAmpelPanel-komponente, implementiert Runnabel = stellt weitere Threads bereit,  ..
 *																					// .. run()-methode von Runnabel muss zwangsl�ufig �nerschrieben werden
 *																					 
 * 			=> fields: 		int phase = 0;												// variable f�r die ampel-phasen f�r den switch (5 m�gliche zust�nde: rot, gelb-rot, gr�n, gelb + aus)
 *							Color cOben, cMitte, cUnten;								// farb-variablen f�r die 3 ampel-kreise oben, mitte, unten
 *							int[] phasendauer = {3000, 1000, 3000, 1000};				// NEU: array f�r die phasendauer der verschiedenen ampelphasen inkl. werte
 *							private boolean automatik = false;							// NEU: booleanvariable f�r bedingung automatik-modus oder nicht 
 *						
 *			=> NEU: zus�tzlicher konstruktor, dem die phasendauer der einzelnen Ampelphasen als parameter �bergeben wird & der diese in einem array ablegt
 *			
 *							public JAmpelPanel_5(int rot, int rotgelb, int gruen, int gelb) {	
 *								super();
 *								phasendauer[0] = rot;									// array-variablen f�r die die phasendauer von rot..
 *								phasendauer[1] = rotgelb;								// ..usw
 *								phasendauer[2] = gruen;
 *								phasendauer[3] = gelb;
 *							}							
 * 			=> paintComponent-methode der superklasse �berschreiben, damit die �nderungen der komponente (panel) jeweils neugezeichnet werden bei frame-ver�nderungen
 * 
 *						public void paintComponent(Graphics g) {
 *							super.paintComponent(g);					// effektiver aufruf der methode der superklasse unter weitergabe des grafik-objekts g
 *							..
 *							switch (phase) {							// switch-case f�r ampel zust�nde 
 *							case 0:										// fall: ampel aus
 *								cOben = Color.gray;
 *								cMitte = Color.gray;
 *								cUnten = Color.gray;
 *								break;
 *							case 1:	..									// fall: ampel rot
 *							case 2:	..									// fall: ampel gelb-rot
 *							case 3:	..									// fall: ampel gr�n
 *							case 4:	..									// fall: ampel gelb
 *							}
 *							..											// zeichenen der ampel-lampen
 *							g.setColor(cOben);							// zuerst aktuelle farbe der obersten lampe setzen, je nach case 
 *							g.fillOval(3, 3, b, h);						// .. dann oberste lampe zeichnen
 *							..											// .. usw. f�r 2. & 3. lampe
 *						}	
 *
 *			=> methode als schnittstelle nach aussen, um die ampel in die jeweilige phase versetzen zu k�nnen
 *								
 *						public void setPhase(int i) {					// parameter i, um den zustand der phase beim aufruf �bergeben zu k�nnen		
 *							phase = i;									// phase auf i setzen
 *							repaint();									// neuzeichnen der komponente
 *						}							
 *
 *			=> NEU: run() f�r zus�tzlichen Thread (zwingende folge von implements Runnable) diesmal im JAmpelPanel + nicht wie in anderen beispielen im aufrufenden (frame-)programm 
 *			
 *						@Override																													// siehe 12.4.2.  AtOverride  eigene bemerkung:  => wie ein kommentar bei absichtlichem �berschreiben von methoden der superklasse. -> heute java7: ist's guter programmierstil -> evtl. ab java 8 oder 9 unumg�nglich, 
 *						public void run() {									// Auto-generated method stub (= methoden-rumpf) bei implements Runnable: f�r den zus�tzlichen thread, der die ampel parallel laufen l�sst
 *																			// checkbox automatik blockiert nicht & durch das einzelne durchlaufen jeder phase in der while-schleife reagiert auch die checkbox automatik fehlerfrei direkt (es muss nicht zuerst ein ganzer durchlauf durch die phasen abgearbeitet werden) bei abwahl der automatik
 *							int i = 1;										// lokale variable f�r's handling der array-werte vom array phasendauer & auch der Phasen von setPhase()
 *								while (automatik) {							// schleife um - neu - eine ampelphase nach der anderen durchlaufen zu lassen, in der Thread-methode run():
 *									try {
 *										setPhase(i);						// via methode setPhase(..), phase auf i (=> 1 bis 4) setzen, repaint() wird in setPhase() erledigt
 *										Thread.sleep(phasendauer[i-1]);		// thread unterbrechen (f�r array-wert von phasendauer[0 bis 3] milisekunden)
 *										i++;								// i erh�hen f�r n�chste setPhase() & n�chsten array-wert der phasendauer[]
 *										if (i > 4) {						// wenn i gr�sser als 4: sind alle phasen & phasendauer durchlaufen..
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
																// .. Runnabel muss zwangsl�ufig �nerschrieben werden
	private int phase = 0;																										// variable f�r die ampel-phasen f�r den switch (5 m�gliche zust�nde: rot, gelb-rot, gr�n, gelb + aus)
	private int[] phasendauer = {3000, 1000, 3000, 1000};		// array f�r die phasendauer der verschiedenen ampelphasen inkl. werte
	private Color cOben, cMitte, cUnten;																						// farb-variablen f�r die 3 ampel-kreise oben, mitte, unten
	public boolean automatik = false;							// neu booleanvariable f�r bedingung automatik-modus oder nicht
	
	public JAmpelPanel_5() {																									// normaler konstruktor ohne parameter
		super();
	}

	// zus�tzlicher konstruktor, dem die phasendauer der einzelnen Ampelphasen als parameter �bergeben wird & der diese in einem array ablegt
	public JAmpelPanel_5(int rot, int rotgelb, int gruen, int gelb) {	
		super();
		phasendauer[0] = rot;									// array-variablen f�r die die phasendauer von rot..
		phasendauer[1] = rotgelb;								// ..usw
		phasendauer[2] = gruen;
		phasendauer[3] = gelb;
	}
	
	public void paintComponent(Graphics g) {																					// paintComponent-methode der superklasse �berschreiben, damit die �nderungen der komponente (panel) jeweils neugezeichnet werden bei frame-ver�nderungen
		super.paintComponent(g);																								// effektiver aufruf der methode der superklasse unter weitergabe des grafik-objekts g
		this.setBackground(new Color(0, 80, 0));																				// hintergrund des JPanels auf dunkelgr�n setzen
		switch (phase) {																										// switch-case f�r ampel zust�nde 
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
		case 3:																													// fall: ampel gr�n
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
		int h = getHeight()/3 - 12;																								// h�he des ampel-farb-kreis = gesamth�he durch 3, minus 4 mal abstand von 3 px
		int b = getWidth()-6;																									// breite des ampel-farb-kreis = gesamtbreite des panels minus 2 mal abstand von 3 px
		g.setColor(cOben);																										// jeweilige farbe von cOben (je nach case) f�r grafikobjket setzen
		g.fillOval(3, 3, b, h);																									// oberen kreis pinseln
		g.setColor(cMitte);																										// .. dasselbe f�r mittleren kreis
		g.fillOval(3, getHeight()/3 + 6, b, h);
		g.setColor(cUnten);																										// .. + f�r den unteren
		g.fillOval(3, 2*getHeight()/3 + 9, b, h);				
		g.setColor(Color.black);																								// farbe auf schwarz
		g.drawOval(3, 3, b, h);																									// + umranden der kreise
		g.drawOval(3, getHeight()/3 + 6, b, h);				
		g.drawOval(3, 2*getHeight()/3 + 9, b, h);
	}
																																// methode als schnittstelle nach aussen, um die ampel in die jeweilige phase versetzen zu k�nnen
	public void setPhase(int i) {																								// parameter i, um den zustand der phase beim aufruf �bergeben zu k�nnen		
		phase = i;																												// phase auf i setzen
		repaint();																												// neuzeichnen der komponente
	}
	
	// run() diesmal im JAmpelPanel + nicht wie in anderen bsp. im aufrufenden programm 
	@Override																													// siehe 12.4.2.  AtOverride  eigene bemerkung:  => wie ein kommentar bei absichtlichem �berschreiben von methoden der superklasse. -> heute java7: ist's guter programmierstil -> evtl. ab java 8 oder 9 unumg�nglich, 
	public void run() {									// Auto-generated method stub (= methoden-rumpf) bei implements Runnable: f�r den zus�tzlichen thread, der die ampel parallel laufen l�sst
														// checkbox automatik blockiert nicht & durch das einzelne durchlaufen jeder phase in der while-schleife reagiert auch die checkbox automatik fehlerfrei direkt (es muss nicht zuerst ein ganzer durchlauf durch die phasen abgearbeitet werden) bei abwahl der automatik
		int i = 1;										// lokale variable f�r's handling der array-werte vom array phasendauer & auch der Phasen von setPhase()
			while (automatik) {							// schleife um - neu - eine ampelphase nach der anderen durchlaufen zu lassen, in der Thread-methode run():
				try {
					setPhase(i);						// via methode setPhase(..), phase auf i (=> 1 bis 4) setzen, repaint() wird in setPhase() erledigt
					Thread.sleep(phasendauer[i-1]);		// thread unterbrechen (f�r array-wert von phasendauer[0 bis 3] milisekunden)
					i++;								// i erh�hen f�r n�chste setPhase() & n�chsten array-wert der phasendauer[]
					if (i > 4) {						// wenn i gr�sser als 4: sind alle phasen & phasendauer durchlaufen..
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