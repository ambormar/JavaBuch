/* TODO 14.3.1.   Aufgabe 1,   s.459, MIT zus�tzlichem THREAD, (extends JPanel implements Runnable) (=> JAmpelPanel2 im Buch)
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
 * 
 * 		Programm .._ZweiAmpelSteuerung:		 (Musterl�sung zu Kapitel 14 Aufgabe 2)
 * 			Das Programm nutzt die Klasse JAmpelPanel_5. Zwei Ampeln wechseln ihre Phasen mit unterschiedlicher Phasendauer.
 * 			Da 2 Instanzen des JAmpelPanel_5 als jeweilige zus�tzliche Threads laufengelassen werden m�ssen sie nicht synchronized werden.
 * 
 * 					- zweiampelsteuerung stellt 2 objekte der klasse JAmpelPanel nebeneinander dar
 * 					- jede ampel soll andere phasenzeiten verwenden
 * 					- mit start sollen beide ampeln anfangen zu laufen in ihren jeweiligen phasen
 * 					- mit stop sollen sie anhalten *
 *
 *
 * 
 * 	VORGEHEN:
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
 * 	VORGEHEN:		
 * 
 *		Programm .._ZweiAmpelSteuerung:
 * 
 *			=> Das Programm nutzt die Klasse JAmpelPanel_5. Zwei Ampeln wechseln ihre Phasen mit unterschiedlicher Phasendauer.
 * 					
 * 			=> Da 2 Instanzen des JAmpelPanel_5 als jeweilige zus�tzliche Threads laufengelassen werden m�ssen sie nicht synchronized werden
 * 				-> nur wenn auf variabeln etc. von 2 Threads aus dem selben instanzobjekt zugegriffen wird braucht's synchronized				SIEHE: SYNCHRONIZED unten
 * 
 * 			=> zweiampelsteuerung stellt 2 objekte der klasse JAmpelPanel nebeneinander dar
 * 
 * 				Fields:		private JAmpelPanel_5 jAmpel1;							// 1. instanz des abgeleiteten JAmpelPanels_5
 *							private JAmpelPanel_5 jAmpel2;							// 2. instanz des abgeleiteten JAmpelPanels_5
 *							...
 *				
 *			=>	jede ampel verwendet unterschiedliche phasenzeiten, durch verwenden des konstruktors mit parameterwerten (von JAmpelPanel_5) beim erzeugen im initGUI()
 *				
 *				jAmpel2 = new JAmpelPanel_5(3000, 800, 3000, 800);			// instanzieren mittels Konstruktor mit Parameter f�r die Phasendauer-wert
 *				jAmpel1 = new JAmpelPanel_5(4000, 1000, 4000, 1000);		// instanzieren mittels Konstruktor mit anderen Parametern f�r die Phasendauer-wert
 *
 *			
 *			=> 	start-button zum erzeugen und starten der 2 parallelen Threads -> Da 2 Instanzen des JAmpelPanel_5 als jeweilige zus�tzliche Threads laufengelassen werden m�ssen sie nicht synchronized ..
 *																		//.. werden -> nur wenn auf variabeln etc. von 2 Threads aus dem selben instanzobjekt zugegriffen wird braucht's synchronized
 *				private void jBtnStartActionPerformed(ActionEvent evt) { 
 *					Thread t1 = new Thread(jAmpel1);				// erzeugen des 1. zus�tzlichen Threads mit parameter jAmpel1 (= target 1. ObjektInstanz von JAmpelPanel_5)
 *					jAmpel1.automatik = true;						// zugriff auf public automatik von jAmpel1, voraussetzung um die ampel nacher im stop einfach wieder abzustellen
 *					t1.start();										// thread starten
 *					Thread t2 = new Thread(jAmpel2);				// erzeugen des 2. zus�tzlichen Threads mit parameter jAmpel2 (= target 2. ObjektInstanz von JAmpelPanel_5)
 *					jAmpel2.automatik = true;						// zugriff auf public automatik von jAmpel2, voraussetzung um die ampel nacher im stop einfach wieder abzustellen
 *					t2.start();										// thread starten
 *				}
 *			
 *
 *			=> 	stop-button nur um die thread-funktionen zu stoppen via boolean variabel der whil-schleife im run() von JAmpelPanel
 *				-> alternativ zu/evtl. einfacher als:  	den konstruktor ausserhalb der methoden zu erzeugen & dann die Threads mit .interrupt() zu stoppen
 *
 *				private void jBtnStopActionPerformed(ActionEvent evt) {
 *					jAmpel1.automatik = false;							// einfachste m�glichkeit um die ampel zu unterbrechen, ohne den Thread ausserhalb der beiden start-stop methoden erzeugen zu m�ssen
 *					jAmpel2.automatik = false;							// einfachste m�glichkeit um die ampel zu unterbrechen, ohne den Thread ausserhalb der beiden start-stop methoden erzeugen zu m�ssen
 *				}
 * 
 * 
 * 
 * 	THREAD-ANWEISUNGEN SAUBER STOPPEN MITTELS WHILE-SCHLEIFE im run() & BOOLEAN VARIABEL, NACH ABARBEITEN ALLER ANWEISUNGEN DER SCHLEIFE:
 *  
 *  			=> es gibt die methode interrupt() f�r Threads:	-> eine andere einfache m�glichkeit Thread-funktionen sauber zu stoppen ist:
 *  
 *		   		=> im run() eine while-schleife mit boolean variable als bedingung einbauen
 *					-> variable nach belieben auf true oder false setzen
 *					-> evtl. mittels zus�tzlichem setter f�r die variable, um von aussen drauf zugreifen zu k�nnen
 *					
 *					class JAmpelPanel_5 extends JPanel implements Runnable: 		(14.3.	Aufgabe 1)
 *					
 *							Bsp:		public boolean automatik = false;				// anfangswert auf false, so dann kann man die Thread-Anweisungen blockieren

 *							&:			public void run(){								// �berschreiben
 *											..
 *											while (automatik){							// Thread-anweisungen sind nur zug�nglich wenn automatik = true gesetzt ist
 *												..
 *												Thread.sleep(..);						// beliebige anweisungen mit Thread-funktionen
 *											}
 *										}
 *							
 *						[auch m�gl.:	public void setAutomatik(boolean automatik) {	// alternativ mit setter f�r die boolean-variable				
 *											this.automatik = automatik;										
 *										}																											]
 *									
 *
 *					programm .._ZweiAmpelSteuerung: 			(14.3.	Aufgabe2)
 *	
 *
 *										private void jBtnStart..(..) { 				// start-button zum erzeugen und starten des Threads 
 *											Thread ampel1 = new Thread(jPanel1);	// erzeugen des Threads mit parameter jAmpel1 (= target 1. ObjektInstanz von JAmpelPanel_5)
 *											jPanel1.automatik = true;				// zugriff auf public automatik von jAmpel1, voraussetzung um die ampel nacher im stop einfach wieder abzustellen
 *											ampel1.start();							// thread starten
 *										}
 *								
 *										private void jBtnStop..(..) {				// stop-button nur um die thread-funktionen zu stoppen via boolean variabel der whil-schleife im run() von JAmpelPanel
 *											jPanel1.automatik = false;				// einfachste m�glichkeit um die ampel zu unterbrechen, ohne den Thread ausserhalb der beiden start-stop methoden erzeugen zu m�ssen
 *											..
 *										}
 * 
 * 
 * 
 * SYNCHRONIZED:		=> Da 2 Instanzen des JAmpelPanel_5 als jeweilige zus�tzliche Threads laufengelassen werden m�ssen sie nicht synchronized werden
 * 							-> nur wenn auf variabeln etc. von 2 Threads aus dem selben instanzobjekt zugegriffen wird braucht's synchronized	
 * 
 * 
 *								private JAmpelPanel_5 jPanel1;
 *								private JAmpelPanel_5 jPanel2; 
 *	
 *	 							private void jBtnStartActionPerformed(ActionEvent evt) {
 *									Thread ampel1 = new Thread(jPanel1);
 *									jPanel1.automatik = true;
 *									ampel1.start();
 *									Thread ampel2 = new Thread(jPanel2);
 *									jPanel2.automatik = true;
 *									ampel2.start();
 *								}
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