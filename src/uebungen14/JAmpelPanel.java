/* TODO 14.2.1.   s.440, (extends JPanel) !!!!!!!!!!!!
 * class 	JAmpelPanel		& 		PaintImmediately_Sleep_InterruptedException_OhneEigenenThread_Einfache_Ampelsteuerung2
 * 
 * 		SIEHE BASICS:			14.2.2.		Threads_Bsics_Methoden_Konstruktoren_Eigenschaften_2MethodenderDerThreadErstellung		s.447
 * 
 * 		VERGLEICHE AUCH:		14.2.2.		Thread_.._Ampelsteuerung3 	s.447		!!!!!!!!!!!
 * 
 * 
 * 	K&K:	Klasse JAmpelPanel:			(von der Komponente JPanel abgeleitet)
 * 										Die Klasse dient der Darstellung einer Ampel mit den vier Ampelphasen.
 * 
 * 
 * 			Programm Ampelsteuerung2:	(ohne eigenen Thread, aber mit paintImmediately(), sleep() und InterruptedException )
 * 
 * 										Das Programm nutzt die Klasse JAmpelPanel. Die Ampel kann manuell in die vier Ampelphasen geschaltet und ausgeschaltet werden.
 * 										Die Phasenwechsel werden im Automatikbetrieb -  mit hilfe von paintImmediately() der klasse jComponent - sichtbar, aber die Automatik 
 * 										versetzt die Ampelsteuerung in eine Endlosschleife, die aus der Entwicklungsumgebung nur noch �ber den Stop-Button der Console-
 * 										View gestoppt werden kann. 	 
 * 
 * 	METHODEN (besondere):	
 * 				
 * 		void sleep(long m)					der Klasse Thread		-> erzwingt eine pause in der ausf�hrung des laufenden threads (auch des main-threads) von m millisekunden.
 * 																	-> zwingt zu InterruptedException-handling, da threads wiederspr�che ausl�sen k�nnen. 
 * 																			-> auch bei blosser verwendung der methode, ohne dass ein 2. thread erzeugt wurde
 * 																	-> kann zu unterbrechungen des restlichen programm-ablaufs ( z.b. initGUI()) f�hren 
 * 																			-> fehler beim ablauf des komponenten darstellens z.b. mit paintImmediately() l�sen		(diese programm)
 * 																			-> oder besser einen zus�tzlichen thread machen 
 * 																					SIEHE: 		14.2.2.		Tread_.._Ampelsteuerung3 	s.447
 * 
 * 		void paintImmediately(int x, 		der Klasse JComponent	-> methode zum sofortigen neuzeichnen der jeweiligen komponente mit vier int-werten f�r den betreffenden bereich
 * 			int y, int width, int height)							-> parameter-angaben: 	-> bsp: 		jPanel1.paintImmediately(0, 0, jPanel1.getWidth(), jPanel1.getHeight());
 * 
 * 
 *	EXCEPTIONS:		
 *
 *		InterruptedException				der klasse Thread		-> bei verwendung von Threads k�nnen diese sich gegenseitig unterbrechen
 *																	-> der unterbrochene thread wirft dann eine InterruptedException
 *																	-> bei einsatz von Threads, alleine durch verwendung der methode sleep(..) 
 *																		-> muss ein exception-handling f�r InterruptedExceptions erfolgen 
 *																				->  Throws oder try-catch-block
 * 
 * 	VORGEHEN: 	
 * 
 * 		KLASSE JAmpelPanel:		
 * 
 * 			=> von der Komponente JPanel abgeleitet, um sie in der aufrufenden klasse Ampelsteuerung2 anstelle eines standard-jpanels einzusetzen
 * 
 * 			=> Die Klasse dient der Darstellung einer Ampel mit den vier Ampelphasen.
 * 
 * 			=> fields: 		int phase = 0;					// variable f�r die ampel-phasen f�r den switch (5 m�gliche zust�nde: rot, gelb-rot, gr�n, gelb + aus)
 *							Color cOben, cMitte, cUnten;	// farb-variablen f�r die 3 ampel-kreise oben, mitte, unten
 *							
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
 *										
 *		PROGRAMM Ampelsteuerung2:	
 *		
 *				-> ohne eigenen Thread, aber mit paintImmediately(), sleep() und InterruptedException 
 *	  
 *	  			=> JFrame mit JAmpelPanel (jAmpel) anstelle eines JPanels f�r die darstellung der Ampel
 *	  
 *	  					private JAmpelPanel jAmpel = new JAmpelPanel();
 *	  
 *	  			=> 5 radiobuttons (aus, rot, rotgelb, gr�n, gelb) (inkl. ButtonGroup) mit handler-methoden f�r handsteuerung der ampelphasen 
 *	  					-> werden f�r bessere ordnung innerhalb eines jPanels mit titleborder (handsteuerung) dargestellt 
 *	  
 *	  					SIEHE:		jPanel1  im  initGUI()
 *	  								
 *	  			=> checkbox jCBAutomatik mit handler method, um auf automatik-modus der ampelsteuerung zu wechseln
 *	  					
 *	  			=> fields: 		private int rotPhase = 3000;		// int-variablen f�r die zeiten der phasen in milisekunden (werden sp�ter der sleep-methode als parameter �bergeben)
 *	  							... usw								// .. f�r gelbrotPhase, gruenPhase, gelbPhase
 *	  
 * 	  			=> ende initGUI():	jAmpel.setPhase(0);		// jAmpel initialisieren: aufruf schnittstellen-methode setPhase(..) der klasse JAmpelPanel unter mitgabe von int-wert 0 (=> phase : aus)
 *	   	
 *	  			=> handler methoden der 5 radaiobuttons zur handsteuerung implementieren:
 *	  				-> via schnittstellen-methode setPhase(..) von JAmpelPanel, wird private int phase (von JAmpelPanel)  auf 0-4 (5 ampelzust�nde) gesetzt setzen, 
 *	  				-> der repaint() wird auch gleich in setPhase() (von JAmpelPanel) erledigt
 *	  
 *			 		BSP:	private void jRBAusActionPerformed(ActionEvent evt) {		// handsteuerung: radiobutton aus: 
 *									jAmpel.setPhase(0);										// phase auf 0 (= aus) setzen
 *								}							
 *	 
 *				=> handler methode f�r checkbox um automatik-modus (der ampelsteuerung) ein- und auszuschalten 
 *					-> mit while-schleife in der durch die phasen geschaltet wird mit kurzen zeitunterbrechungen (f�r phasen-dauer) durch methode sleep(..) von klasse Thread
 *						-> f�hrt dazu. dass der gesamt programm-ablauf (auch GUI) unterbrochen wird, 
 *						-> also muss das zeichnen der sich ver�nderneden komponenten sofort erzwungen werden mit paintImmediately(..) der klasse jComponent
 *				
 *						private void jCBAutomatikActionPerformed(ActionEvent evt) {
 *							if (jCBAutomatik.isSelected()){																			// wenn checkbox (automatik) angew�hlt ist:
 *								jRBAus.setEnabled(false);																			// alle readiobuttons (der handsteuerung) inaktiv setzen
 *								...																									
 *								jPanel1.paintImmediately(0, 0, jPanel1.getWidth(), jPanel1.getHeight());							// von JComponent weitervererbte methode zum neuzeichnen der jeweiligen komponente mit vier int-werten f�r den betreffenden bereich
 *								while (jCBAutomatik.isSelected()) {																	// schleife um immer wieder die 4 ampelphasen durchlaufen zu lassen
 *									try {
 *										jCBAutomatik.paintImmediately(0, 0, jCBAutomatik.getWidth(), jCBAutomatik.getHeight());		// checkbox immediately neuzeichnen 
 *										jAmpel.setPhase(1);																			// via schnittstellen-methode setPhase(..) von JAmpelPanel, phase auf 1 (= rot) setzen, repaint() wird in setPhase() erledigt
 *										jAmpel.paintImmediately(0, 0, jAmpel.getWidth(), jAmpel.getHeight());						// jAmpel immediately neuzeichnen 
 *										Thread.sleep(rotPhase);																		// thread unterbrechen (rotphasen => milisekunden)
 *										jAmpel.setPhase(2);																			// usw. f�r jede der 4 farb-phasen
 * 										... 
 *	 								} catch (InterruptedException e) {																// Thread-speziefische exception: sobald threads im spiel sind (es reicht schon die methode sleep() von thread
 *										e.printStackTrace();
 *									}
 *								}
 *							} else {											// wenn automatik nicht (mehr) eingeschaltet ist..
 *								jRBAus.setSelected(true);						// radiobutton aus auf angew�hlt setzen
 *								jRBAus.setEnabled(true);						// alle radiobuttons aktiv setzen
 *								...						// 
 *								jAmpel.setPhase(0);								// via schnittstellen-methode setPhase(..) von JAmpelPanel, phase wieder auf 0 (= aus) setzen, repaint() wird in setPhase() erledigt
 *							}
 *					
 *						}  
 * 
 *
 * 				=> PROBLEMCHEN:		Die Phasenwechsel werden im Automatikbetrieb -  mit hilfe von paintImmediately() der klasse jComponent - sichtbar, aber die Automatik 
 * 									versetzt die Ampelsteuerung in eine Endlosschleife, die aus der Entwicklungsumgebung nur noch �ber den Stop-Button der Console-
 * 									View gestoppt werden kann. 
 * 
 * 				=> PROBLEM-L�SUNG: 	(=> checkbox automatik nach gebrauch wieder abw�hlbar machen:) 		
 * 									=> die anweisungen der while-schleife (Thread.sleep(rotPhase) etc.) m�ssen in einem 2. Thread ausgef�hrt werden
 * 										-> damit sie den restlichen programm-ablauf (initGUI()) nicht mit-unterbrechen
 * 
 * 
 */

package uebungen14;

import java.awt.Color;
import java.awt.Graphics;						
import javax.swing.JPanel;


public class JAmpelPanel extends JPanel {

	int phase = 0;									// variable f�r die ampel-phasen f�r den switch (5 m�gliche zust�nde: rot, gelb-rot, gr�n, gelb + aus)
	Color cOben, cMitte, cUnten;					// farb-variablen f�r die 3 ampel-kreise oben, mitte, unten
	
	public JAmpelPanel() {							// standard-construktor ohne parameter
		super();								
	}
	
	// paintComponent-methode der superklasse �berschreiben, damit die �nderungen der komponente (panel) jeweils neugezeichnet werden bei frame-ver�nderungen
	public void paintComponent(Graphics g) {
		super.paintComponent(g);					// effektiver aufruf der methode der superklasse unter weitergabe des grafik-objekts g
		this.setBackground(new Color(0, 80, 0));	// hintergrund des JPanels auf dunkelgr�n setzen
		switch (phase) {							// switch-case f�r ampel zust�nde 
		case 0:										// fall: ampel aus
			cOben = Color.gray;
			cMitte = Color.gray;
			cUnten = Color.gray;
			break;
		case 1:										// fall: ampel rot
			cOben = Color.red;
			cMitte = Color.gray;
			cUnten = Color.gray;
			break;
		case 2:										// fall: ampel gelb-rot
			cOben = Color.gray;
			cMitte = Color.orange;
			cUnten = Color.gray;
			break;
		case 3:										// fall: ampel gr�n
			cOben = Color.gray;
			cMitte = Color.gray;
			cUnten = Color.green;
			break;
		case 4:										// fall: ampel gelb
			cOben = Color.gray;
			cMitte = Color.orange;
			cUnten = Color.gray;
			break;
		}
		int h = getHeight()/3 - 12;					// h�he des ampel-farb-kreis = gesamth�he durch 3, minus 4 mal abstand von 3 px
		int b = getWidth()-6;						// breite des ampel-farb-kreis = gesamtbreite des panels minus 2 mal abstand von 3 px
		g.setColor(cOben);							// jeweilige farbe von cOben (je nach case) f�r grafikobjket setzen
		g.fillOval(3, 3, b, h);						// oberen kreis pinseln
		g.setColor(cMitte);							// .. dasselbe f�r mittleren kreis
		g.fillOval(3, getHeight()/3 + 6, b, h);
		g.setColor(cUnten);							// .. + f�r den unteren
		g.fillOval(3, 2*getHeight()/3 + 9, b, h);				
		g.setColor(Color.black);					// farbe auf schwarz
		g.drawOval(3, 3, b, h);						// + umranden der kreise
		g.drawOval(3, getHeight()/3 + 6, b, h);				
		g.drawOval(3, 2*getHeight()/3 + 9, b, h);
	}
	
	// methode als schnittstelle nach aussen, um die ampel in die jeweilige phase versetzen zu k�nnen
	public void setPhase(int i) {					// parameter i, um den zustand der phase beim aufruf �bergeben zu k�nnen		
		phase = i;									// phase auf i setzen
		repaint();									// neuzeichnen der komponente
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