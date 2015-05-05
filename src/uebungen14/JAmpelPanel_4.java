/* TODO 14.2.2.e.   s.453, (extends JPanel) 
 * class 	JAmpelPanel_4		& 		Thread_ImplementsRunnable_Run_Perfekte_Ampelsteuerung4
 * 
 * 		SIEHE BASICS:			14.2.2.a.   Threads_Bsics_Methoden_Konstruktoren_Eigenschaften_2MethodenderDerThreadErstellung									s.447
 * 		SIEHE BASICS:			14.2.2.a.   Threads_Basics_Methoden_Konstruktoren_Eigenschaften_2MethodenderDerThreadErstellung									s.447
 * 
 * 		VORGÄNGERVERSION:		14.2.2.d.	Thread_ImplementsRunnable_Run_Ampelsteuerung3	& 	JAmpelPanel	_3													s.451
 * 
 * 		VERGLEICHE AUCH:		14.2.1.   PaintImmediately_Sleep_InterruptedException_OhneEigenenThread_Einfache_Ampelsteuerung2		&	JAmpelPanel			s.440, (verwendet JAmpelPanel) 
 * 
 * 		&:						14.2.2.b.		class StoppuhrTest	&	Thread_Stoppuhr																			s.450, 1. Art mit extends Thread
 * 
 * 
 * 	K&K:	Klasse JAmpelPanel_4:		(von der Komponente JPanel abgeleitet) 			(( ist ausser dem namen identisch mit der klasse JAmpelPanel_3 ))
 * 										Die Klasse dient der Darstellung einer Ampel mit den vier Ampelphasen.
 * 
 * 
 * 			Programm Ampelsteuerung4:	(mit zusätzlichem Thread & neu perfekt funktionierender) abgeänderte version von Thread_ImplementsRunnable_Run_Ampelsteuerung3
 * 
 * 										[ Ampelsteuerung3: 	Das Programm nutzt die Klasse JAmpelPanel_3. Die Ampel kann manuell in die vier Ampelphasen geschaltet und ausgeschaltet werden.
 * 															Der Automatikmodus funktioniert (mittels zusätzlichem thread), aber das Beenden der Automatik erfolgt offensichtlich nicht ganz 
 * 															korrekt. Es werden noch die Ampelphasen bis zur Gelbphase weiter durchlaufen. Erst danach endet der Schleifendurchlauf. 	] 
 * 
 * 										Das Programm nutzt die Klasse JAmpelPanel_4. Die Ampel kann manuell in die vier Ampelphasen geschaltet und ausgeschaltet werden.
 * 										Der AUTOMATIKMODUS funktioniert und kann NEU auch unmittelbar GESTOPPT werden.   
 * 
 * 
 *  EINZIG WICHTIGE VERÄNDERUNG IN DIESER VERSION SIEHE:
 *  
 *  	KLASSE JAmpelPanel_4:		keine veränderungen
 *  		
 *  	PROGRAMM Thread_ImplementsRunnable_Run_Perfekte_Ampelsteuerung4:
 *  
 *				=> FIELDS:	dauer der 4 ampelphasen WIRD NEU in einem Array definiert zur präzieseren verwendung in der while-schleife 
 *	  							
 *  					private int [] phasendauer = {3000, 1000, 3000, 1000};
 *  
 *  			=> optimierte while-schleife in der Thread-methode run() um NEU jede einzelne der 4 ampelphasen durchlaufen zu lassen 
 * 					-> durch die phasen geschaltet wird mit kurzen zeitunterbrechungen (werte aus array phasendauer[]) durch methode sleep(..) von klasse Thread
 * 					-> NEU lässt sich durch das einzelne durchlaufen jeder phase in der while-schleife auch die checkbox automatik unmittelbar stoppen.
 * 																(es muss nicht mehr zuerst ein ganzer durchlauf durch alle phasen abgearbeitet werden bei abwahl der automatik)
 * 					
 *						@Override																													// siehe 12.4.2.  AtOverride  eigene bemerkung:  => wie ein kommentar bei absichtlichem überschreiben von methoden der superklasse. -> heute java7: ist's guter programmierstil -> evtl. ab java 8 oder 9 unumgänglich, 
 *						public void run() {									// Auto-generated method stub (= methoden-rumpf) bei implements Runnable: für den zusätzlichen thread, der die ampel parallel laufen lässt, checkbox automatik blockiert ..
 *																			// ..nicht & neu lässt sich durch das einzelne durchlaufen jeder phase in der while-schleife auch die checkbox automatik fehlerfrei bedienen (es muss nicht zuerst ein ganzer durchlauf durch die phasen abgearbeitet werden) bei abwahl der automatik
 *							int i = 1;										// lokale variable für's handling der array-werte vom array phasendauer & auch der Phasen von jAmpel.setPhase()
 *								while (jCBAutomatik.isSelected()) {			// schleife um - neu - eine ampelphase nach der anderen durchlaufen zu lassen, in der Thread-methode run():
 *									try {
 *										jAmpel.setPhase(i);					// via schnittstellen-methode setPhase(..) von JAmpelPanel, phase auf i (=> 1 bis 4) setzen, repaint() wird in setPhase() erledigt
 *										Thread.sleep(phasendauer[i-1]);		// thread unterbrechen (für array-wert von phasendauer[0 bis 3] milisekunden)
 *										i++;								// i erhöhen für nächste jAmpel.setPhase() & nächsten array-wert der phasendauer[]
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
 * [[[ 		DER REST IST IDENTISCH MIT :		14.2.2.d.		Thread_ImplementsRunnable_Run_Ampelsteuerung3	& 	JAmpelPanel	_3			s.451
 * 
 * 
 * 	ZWEITE ART DER ERSTELLUNG VON THREADS:		MIT IMPEMENTS RUNNABLE	&	ÜBERSCHREIBEN DER RUN()-METHODE:	(
 * 
 *			OBJEKT DER ALLGEMEINEN KLASSE THREAD WIRD ERZEUGT, DEREN RUN()-METHODE
 *			VERWEISTAUF EINE RUN()-METHODE, DIE WOANDERS (IN EINER ANDEREN KOMPONENTE ??) IMPLEMENTIERT IST
 *		 
 *			=> für klassen die bereits von einer anderen klasse abgeleitet wurden
 *				-> bsp.:	von gui-komponenten abgeleiteteten klassen 
 *		
 *				 ___________________________________________________________
 *				|															|
 *				|	EigenKlasse extends andereKlasse implements Runnable	|							
 *				|															|
 *				| --->	run()			-> überschreiben (@override)		|
 *				|_¦_________________________________________________________|
 *				  ¦
 *				  ¦				&
 *				 _¦_________________________________________________________
 *				| ¦ 														|
 *				| ¦ Anwendung (kann auch in der obigen/gleichen Klasse sein)|
 *				| ¦	 ___________________________							|
 *				| ¦	|	Thread t = new Thread	|							|
 *				| ¦	|							|							|
 *				| --|---run()					|							|
 *				|	|___________________________|							|
 *				|___________________________________________________________|
 *	  	
 *				SIEHE AUCH:		14.2.2.a.	Threads_Basics_Methoden_Konstruktoren_Eigenschaften_2MethodenderDerThreadErstellung		s.447
 * 
 * 
 * 	METHODEN (besondere):	
 * 				
 * 		void sleep(long m)					der Klasse Thread		-> erzwingt eine pause in der ausführung des laufenden threads (auch des main-threads) von m millisekunden.
 * 																	-> zwingt zu InterruptedException-handling, da threads wiedersprüche auslösen können. 
 * 																			((-> auch bei blosser verwendung der methode, ohne dass ein 2. thread erzeugt wurde))
 * 																	[ -> kann zu unterbrechungen des restlichen programm-ablaufs ( z.b. initGUI()) führen 
 * 																			-> fehler beim ablauf des komponenten darstellens z.b. mit paintImmediately() lösen		(diese programm)
 * 																			-> oder besser einen zusätzlichen thread machen, wie in dieser klasse]
 * 
 *	EXCEPTIONS:		
 *
 *		InterruptedException				der klasse Thread		-> bei verwendung von Threads können diese sich gegenseitig unterbrechen
 *																	-> der unterbrochene thread wirft dann eine InterruptedException
 *																	-> bei einsatz von Threads, alleine durch verwendung der methode sleep(..) 
 *																		-> muss ein exception-handling für InterruptedExceptions erfolgen 
 *																				->  Throws oder try-catch-block
 * 
 * 	VORGEHEN: 	
 * 
 * 		KLASSE JAmpelPanel_4:		
 * 
 * 			=> von der Komponente JPanel abgeleitet, um sie in der aufrufenden klasse Ampelsteuerung4 anstelle eines standard-jpanels einzusetzen
 * 
 * 			=> Die Klasse dient der Darstellung einer Ampel mit den vier Ampelphasen.
 * 
 * 			=> fields: 		int phase = 0;												// variable für die ampel-phasen für den switch (5 mögliche zustände: rot, gelb-rot, grün, gelb + aus)
 *							Color cOben, cMitte, cUnten;								// farb-variablen für die 3 ampel-kreise oben, mitte, unten
 *	  	
 *						
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
 * 	VORGEHEN: 	
 * 
 *		PROGRAMM Ampelsteuerung3:		(ACHTUNG: bei ausschalten der automatik läuft werden die ampelphasen noch bis zur 4. phase abgearbeitet: perfektes abbrechen der phasen: siehe 4.2.2. .._Ampelsteuerung4 s.353)
 *		
 *				THREAD-SPEZIEFISCHE HAUPT-VORGEHENSWEISE VORWEG K&K :
 *
 *					=> 	Klasse extends JFrame implements Runnable {..}			Runnable von Thread für die klasse implementieren 
 *
 *					=> 	@Override												Run()-methode von Thread überschreiben inkl. den nötigen anweisungen für den neuen Thread
 *						   public void run() {
 *							Anweisungen für den neuen Threads;
 *						} 	
 *
 *					=> 	Thread t = new Thread(this, "Automatik");				Thread-objekt für neuen thread dort erstelen wo er beginnen soll & starten
 *						t.start();											
 *
 *
 *				-> mit zusätzlichem Thread durch implementieren von Runnable für diese klasse (erfordert überschreiben der run()-methode)
 *	  
 *						public class Thread_Ampelsteuerung4 extends JFrame implements Runnable {	// Programm-frame implementiert Runnabel, damit es eine run()-methode für einen Thread bereitstellen kann
 *
 *				-> überschreiben der run()-methode für den zusätzlichen threads (eclipse-fehlermeldung wenn kein run() erstellt wird, weil implements Runnable dies zwangsläufig erfordert)  
 *					-> methoden-rumpf (method stub) erstellt sich bei der fehlerbehebung von eclipse (mit quickfix) von selbst 
 *					-> while-schleife in der Thread-methode run() um NEU jede einzelne der 4 ampelphasen durchlaufen zu lassen  (um es parallel/unabhängig zum programm-gui-thread laufen zu lassen)
 * 						-> durch die phasen geschaltet wird mit kurzen zeitunterbrechungen (für phasen-dauer) durch methode sleep(..) von klasse Thread
 * 						-> NEU lässt sich durch das einzelne durchlaufen jeder phase in der while-schleife auch die checkbox automatik fehlerfrei stoppen 
 * 																(es muss nicht mehr zuerst ein ganzer durchlauf durch alle phasen abgearbeitet werden) bei abwahl der automatik)
 * 					
 *						@Override																													// siehe 12.4.2.  AtOverride  eigene bemerkung:  => wie ein kommentar bei absichtlichem überschreiben von methoden der superklasse. -> heute java7: ist's guter programmierstil -> evtl. ab java 8 oder 9 unumgänglich, 
 *						public void run() {									// Auto-generated method stub (= methoden-rumpf) bei implements Runnable: für den zusätzlichen thread, der die ampel parallel laufen lässt, checkbox automatik blockiert ..
 *																			// ..nicht & neu lässt sich durch das einzelne durchlaufen jeder phase in der while-schleife auch die checkbox automatik fehlerfrei bedienen (es muss nicht zuerst ein ganzer durchlauf durch die phasen abgearbeitet werden) bei abwahl der automatik
 *							int i = 1;										// lokale variable für's handling der array-werte vom array phasendauer & auch der Phasen von jAmpel.setPhase()
 *								while (jCBAutomatik.isSelected()) {			// schleife um - neu - eine ampelphase nach der anderen durchlaufen zu lassen, in der Thread-methode run():
 *									try {
 *										jAmpel.setPhase(i);					// via schnittstellen-methode setPhase(..) von JAmpelPanel, phase auf i (=> 1 bis 4) setzen, repaint() wird in setPhase() erledigt
 *										Thread.sleep(phasendauer[i-1]);		// thread unterbrechen (für array-wert von phasendauer[0 bis 3] milisekunden)
 *										i++;								// i erhöhen für nächste jAmpel.setPhase() & nächsten array-wert der phasendauer[]
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
 *	  			=> JFrame mit JAmpelPanel_4 (jAmpel) anstelle eines standard-JPanels für die darstellung der Ampel
 *	  
 *	  					private JAmpelPanel_4 jAmpel = new JAmpelPanel_4();
 *	  
 *	  			=> 5 radiobuttons (aus, rot, rotgelb, grün, gelb) (inkl. ButtonGroup) mit handler-methoden für handsteuerung der ampelphasen 
 *	  					-> werden für bessere ordnung innerhalb eines jPanels mit titleborder (handsteuerung) dargestellt 
 *	  
 *	  					SIEHE:		jPanel1  im  initGUI()
 *	  								
 *	  			=> checkbox jCBAutomatik mit handler method, um auf automatik-modus der ampelsteuerung zu wechseln
 *	  
 *	  
 * 	  			=> ende initGUI():	jAmpel.setPhase(0);		// jAmpel initialisieren: aufruf schnittstellen-methode setPhase(..) der klasse JAmpelPanel_4 unter mitgabe von int-wert 0 (=> phase : aus)
 *	   	
 *	  			=> handler methoden der 5 radaiobuttons zur handsteuerung implementieren:
 *	  				-> via schnittstellen-methode setPhase(..) von JAmpelPanel, wird private int phase (von JAmpelPanel_4)  auf 0-4 (5 ampelzustände) gesetzt setzen, 
 *	  				-> der repaint() wird auch gleich in setPhase() (von JAmpelPanel_3) erledigt
 *	  
 *			 		BSP:	private void jRBAusActionPerformed(ActionEvent evt) {													// handsteuerung: radiobutton aus: 
 *									jAmpel.setPhase(0);																				// phase auf 0 (= aus) setzen
 *								}							
 *	 
 *				=> handler methode für checkbox um automatik-modus (der ampelsteuerung) ein- und auszuschalten 
 *					-> bei klicken des eveent-handlings wird das neue Thread-objekt erzeugt mit parameter this (= runnable target => verweist auf run()-methode in der selben klasse).. 
 *																											.. & name des Threads ("automatik")
 *					-> thread wird gestartet über thread-objekt t + methode start() der Klasse Thread
 *						
 *				
 *						private void jCBAutomatikActionPerformed(ActionEvent evt) {
 *							if (jCBAutomatik.isSelected()){																			// wenn checkbox (automatik) angewählt ist:
 *								jRBAus.setEnabled(false);																			// alle readiobuttons (der handsteuerung) inaktiv setzen
 *								...																									// .. dito alle
 *								Thread t = new Thread(this, "Automatik");		// bei klicken des eveent-handlings wird das neue Thread-objekt erzeugt mit parameter this (= runnable target => verweist auf run()-methode in der selben klasse) & name des Threads ("automatik")
 *								t.start();										// thread wird gestartet über thread-objekt + methode start() der Klasse Thread
 *							} else {																								// wenn automatik nicht (mehr) eingeschaltet ist..
 *								jRBAus.setSelected(true);																			// radiobutton Aus auf angewählt setzen
 *								jRBAus.setEnabled(true);																			// radiobuttons aktiv setzen ..
 *								...																									// .. dito für alle radiobuttons
 *								jAmpel.setPhase(0);																					// via schnittstellen-methode setPhase(..) von JAmpelPanel, phase wieder auf 0 (= aus) setzen, repaint() wird in setPhase() erledigt
 *							}
 *					
 *						}  
 * 
 * 	]]]
 */

package uebungen14;

import java.awt.Color;
import java.awt.Graphics;						
import javax.swing.JPanel;


public class JAmpelPanel_4 extends JPanel {

	int phase = 0;																												// variable für die ampel-phasen für den switch (5 mögliche zustände: rot, gelb-rot, grün, gelb + aus)
	Color cOben, cMitte, cUnten;																								// farb-variablen für die 3 ampel-kreise oben, mitte, unten
	
	public JAmpelPanel_4() {																									// standard-construktor ohne parameter
		super();								
	}
	
																																// paintComponent-methode der superklasse überschreiben, damit die änderungen der komponente (panel) jeweils neugezeichnet werden bei frame-veränderungen
	public void paintComponent(Graphics g) {
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