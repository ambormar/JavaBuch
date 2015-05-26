/* TODO 14.2.2.c.   s.450, eigene Version stoppuhr für gui-programm  
 * class Thread_GuiVersion_MitStop_Stoppuhr	&	StoppuhrTest_GuiVersion_MitStop
 * 
 * 		SIEHE:													14.2.2.b.   Thread_Stoppuhr		&	StoppuhrTest						s.450, 1. Art Thread zu erstellen (=> extends Thread) 
 * 
 * 		SIEHE (2 MÖGLICHKEITEN ZUR ERSTELLUNG VON THREADS):		14.2.2.a.   Threads_Klasse_Basics_Methoden_Konstruktoren_Eigenschaften_2ArtenDerThreadErstellung	s.447, 2 Arten Threads zu erstellen 
 *
 * 		VERGLEICHE AUCH:										14.2.2.d.	Thread_ImplementsRunnable_Run_Ampelsteuerung3	& 	JAmpelPanel	_3						s.451, 2.Art mit implements Runnable
 *
 * 	K&K:	Thread_GuiVersion_MitStop_Stoppuhr: 	
 * 				[ Erweitert Klasse Thread_Stoppuhr (von der Klasse Thread abgeleitet):
 * 					Die Klasse zeigt exemplarisch die Erstellung eines eigenen Threads.
 * 					Der Thread als Stoppuhr misst die zeit die ab Thread-start vergeht und gibt jede (ca.) sekunde die vergangenen sekunden auf der konsole aus. ]
 * 
 * 				mit der erweiterung der klasse soll der thread (gezielt) gestartet und gestoppt werden können (stopp nicht mehr mit der konsolen-stop-taste).
 * 
 * 			StoppuhrTest_GuiVersion_MitStop:
 * 				[ Ändert Programm StoppuhrTest: 
 * 					zum Testen der von Thread abgeleiteten Klasse Stoppuhr.
 * 					der Stoppuhr-Thread lässt sich in jedes Programm einbauen.	(auch GUI-programme: dann aber aus der entwicklungs-umgebung starten & mit consolen-stopp beenden) ]
 * 
 * 				obiger Thread wird hier jetzt aus einem GUI-programm (mit Frame) aufgerufen.
 * 				Der zusätzliche Thread (Thread_GuiVersion_MitStop_Stoppuhr) kann mittels Start- & Stop- Button gestartet/ gestoppt werden.
 * 
 * 
 *	VORGEHEN:	
 *
 *		Klasse Thread_GuiVersion_MitStop_Stoppuhr (extends Thread):
 *		
 *				=> ableiten der eigenen Klasse Thread_GuiVersion_MitStop_Stoppuhr von der klasse Thread
 *
 *				=> variable um die while-schleife von true auf false setzen zu können => voraussetzung um die schleife auf saubere art zu beenden (da ThreadXy.stop() nicht möglich ist):
 *						boolean startstop = true;											 
 *
 *				=> überschreiben der methode run()		=> aber neu mit beendbarer while-schleife (durch variable startstop)		
 *
 *						CODE: 	public void run(){																																
 *									..
 *										while (startstop) {							// ist jetzt keine endlosschleife mehr, lässt sich via die methode setStartstop von true auf false setzen, un somit schleife beenden
 *											..																										
 *										}
 *								}
 *								
 *				=> und setter für die variable startstop (boolean-wert als parameterübergabe)
 *				
 *						CODE:	public void setStartstop(boolean startstop) {					 
 *									this.startstop = startstop;										// variable auf übergabe-wert setzen
 *								}
 *			
 *
 *		TestProgramm StoppuhrTest_GuiVersion_MitStop:
 *
 *				=> einbau der 1. art thread-erstellung (= einer eigenen von Thread abgeleitetetn klasse) in ein GUI-Frame, ist aber villeicht nur aus der Entwicklungsumgebung (eclipse) start-bar (weiss nicht sicher)
 *						
 *						public class StoppuhrTest_GuiVersion_MitStop extends javax.swing.JFrame {..}
 *
 *	 			=> verwenden des eigenen Threads durch erzeugen NEU: AUSSERHALB der main-methode mit Konstruktor-aufruf (manchmal verlangt eclipse hier: static, weiss nicht wieso?!)
 *	 			
 *						private Thread_GuiVersion_MitStop_Stoppuhr stoppuhr = new Thread_GuiVersion_MitStop_Stoppuhr();	
 *	
 *				=> frame mit start- & stop- buttons inkl. handler methods:
 *				
 *				=> button zum starten der zeitstoppung (ausgeführt im zusätzlichen Thread):
 *				
 *						private void jBtnStartActionPerformed(ActionEvent evt) {
 *							stoppuhr.start();						// ganz normal: start() der Klasse Thread benutzen für das stoppuhr-objekt der selber von Thread abgeleiteteten klasse Thread_VersionFuerGuiProgramme_Stoppuhr
 *						}
 *					
 *				=> button zum stoppen der zeitstoppung (ausgeführt im zusätzlichen Thread)
 *				
 *						private void jBtnStopActionPerformed(ActionEvent evt) {
 *							//NICHT: stoppuhr.stop();				// löst eine deprecation @suppress warning von eclipse aus
 *							stoppuhr.setStartstop(false);			// saubere art den thread zu beenden:  via setter den boolean der while-schleife der klasse Thread_VersionFuerGuiProgramme_Stoppuhr
 *																	// ... auf false setzen und so die schleife beenden 
 *						}
 *
 *
 * 	BESONDERES:		
 * 
 * 		DEPRECATION @SUPPRESS WARNING VON ECLIPSE:
 * 				
 * 				=> warnung für elemente/anweisungen von java, die nicht mehr verwendet werden sollen, wiel sie demnächst abgeschafft werden
 * 
 * 							BSP: 	Thread.stop();		-> löst eine deprecation @suppress warning von eclipse aus,
 * 														-> methode stop() von Thread soll nichtmehr verwendet werden
 * 
 * 
 *  	WHILE-SCHLEIFE SAUBER BEENDEN / ENDLOS-WHILE-SCHLEIFE VERHINDERN:
 *  
 *		   		=> while-schleife mit boolean variable als bedingung 
 *					-> variable nach belieben auf true oder false setzen
 *					-> evtl. mittels zusätzlichem setter für die variable, um von aussen drauf zugreifen zu können
 *					
 *							bsp: 	private boolean startstop;
 *							
 *							&:		while (startstop){..}
 *							
 *							&:		public void setStartstop(boolean startstop) {						
 *										this.startstop = startstop;										
 *									}
 *  
 *  
 *  	THREAD SAUBER UNTERBRECHEN MIT INTERRUPT(), EGAL IN WELCHEM STATUS DER THREAD GERADE IST (sleep() etc.) & SPÄTESTENS BEI FRAME-SCHLIESSEN MITTELS WINDOWLISTENER:
 *  
 *  			=> Thread beenden innerhalb eines programms:		t.interrupt()			=> um Thread-objekt t anzuhalten (Thread t = new Thread(..))
 *  																						=> ist wie t.stop() was es aber für thread nicht gibt (bzw. nicht erlaubt ist)
 * 		
 * 				=> PROBLEM:		Falls der Thread z.b. mittels eines Buttons mit event-handling gestoppt werden soll & dann der button nicht betätigt wird, das frame aber geschlossen:
 * 								-> ein gestarteter zusätzlicher thread der nicht angehalten wurde, läuft beim schliessen eines frames einfach weiter
 * 								-> siehe console: roter stop-knopf der leuchtet weiter,  also läuft das programm im hintergrund noch
 * 
 * 				=> LÖSUNG:		thread anhalten mittels EventHandling / WindowListener beim schliessen des frames
 * 
 * 								=> im JIGLOO:					Frame selber anwählen > Outline > Events > WindowListener > windowClosed > auf handler method 
 * 
 * 								=> in der handler method: 		t.interrupt();							// um Thread-objekt t anzuhalten
 * 	
 * 				=> BSP:
 * 
 *					 	private void initGUI() {
 *							try {
 *								..
 *								this.addWindowListener(new WindowAdapter() {		// neuer WindowListener fürs frame..
 *									public void windowClosed(WindowEvent evt) {		// .. mit handler methode für EventHandling bei windowClosed (wenn fenster geschlossen)
 *										thisWindowClosed(evt);
 *									}
 *								});
 *			 			
 *			  			
 *						private void thisWindowClosed(WindowEvent evt) {			// event handler method für wenn das frame geschlossen wurde ohne dass zuvor der Thread angehalten ist.
 *							t.interrupt();											// thread sicher anhalten (nach fensterschliessen) (falls er nicht schon vorher	angehalten wurde)	
 *						}
 *						
 *						
 *						SIEHE:		14.2.4.   Threads_Synchronized_Interrupt_Bewegungsablauf_BallAnimation		s.454, (verwendet JBallPanel_..) 
 *						
 *						
 *  
 *  	THREAD SAUBER STOPPEN MITTELS WHILE-SCHLEIFE im run() & BOOLEAN VARIABEL, NACH ABARBEITEN ALLER ANWEISUNGEN DER SCHLEIFE:
 *  
 *  			=> es gibt keine erlaubte methode stop() für Threads:	-> eine einfache möglichkeit Threads sauber zu stoppen ist:
 *  
 *		   		=> im run() eine while-schleife mit boolean variable als bedingung einbauen
 *					-> variable nach belieben auf true oder false setzen
 *					-> evtl. mittels zusätzlichem setter für die variable, um von aussen drauf zugreifen zu können
 *					
 *			BSP 1: diese klasse:		
 *
 *					EigeneThread extends Thread: 	
 *					
 *							Bsp:		private boolean startstop = true;				// anfangswert auf true dann kann man den Thread einfach starten mit ThreadXY.start()
 *							
 *							&:			run(){											// überschreiben
 *							
 *											while (startstop){
 *											..
 *											..											// beliebige anweisungen
 *											}
 *										}
 *							
 *							&:			public void setStartstop(boolean startstop) {					
 *											this.startstop = startstop;										
 *										}
 *									
 *									
 *					TestKlasse: 		[ EigenerThread threadObjekt = new EigenerThread(); ]
 *
 *										threadObjekt.setStartstop(false);				// so wird while-schleife beendet und ..
 *																						// .. => run() und somit auch der Thread kann nach abarbeiten aller anweisungen beendet werden
 *							
 *
 * 			BSP 2:		SIEHE:		14.3.   	JAmpelPanel_5	&	Threads_ZweiAmpelnGleichzeitigAutomatik_ZweiAmpelSteuerung			Aufgabe 1+2,   s.459,
 *  			
 *					
 *					class JAmpelPanel_5 extends JPanel implements Runnable: 		(14.3.	Aufgabe 1)
 *					
 *							Bsp:		public boolean automatik = false;				// anfangswert auf false, so dann kann man die Thread-Anweisungen blockieren

 *							&:			public void run(){								// überschreiben
 *											..
 *											while (automatik){							// Thread-anweisungen sind nur zugänglich wenn automatik = true gesetzt ist
 *												..
 *												Thread.sleep(..);						// beliebige anweisungen mit Thread-funktionen
 *											}
 *										}
 *							
 *						[auch mögl.:	public void setAutomatik(boolean automatik) {	// alternativ mit setter für die boolean-variable				
 *											this.automatik = automatik;										
 *										}																											]
 *									
 *
 *					Programm .._ZweiAmpelSteuerung: 			(14.3.	Aufgabe2)
 *	
 *
 *										private void jBtnStart..(..) { 				// start-button zum erzeugen und starten des Threads 
 *											Thread ampel1 = new Thread(jPanel1);	// erzeugen des Threads mit parameter jAmpel1 (= target 1. ObjektInstanz von JAmpelPanel_5)
 *											jPanel1.automatik = true;				// zugriff auf public automatik von jAmpel1, voraussetzung um die ampel nacher im stop einfach wieder abzustellen
 *											ampel1.start();							// thread starten
 *										}
 *								
 *										private void jBtnStop..(..) {				// stop-button nur um die thread-funktionen zu stoppen via boolean variabel der whil-schleife im run() von JAmpelPanel
 *											jPanel1.automatik = false;				// einfachste möglichkeit um die ampel zu unterbrechen, ohne den Thread ausserhalb der beiden start-stop methoden erzeugen zu müssen
 *											..
 *										}
 *  
 *  
 */

package uebungen14;


public class Thread_GuiVersion_MitStop_Stoppuhr extends Thread {																				// ableiten einer eigenen Klasse von Thread	

	boolean startstop = true;											// variable um die while-schleife von true auf false setzen zu können => saubere art die schleife zu beenden (da ThreadXy.stop() nicht möglich ist)
	
																																					// überschreiben der methode run()
	public void run(){																																// methode run() wird hier so überschrieben, dass der Thread als stoppuhr, die sekunden, die seit seinem start vergangen sind, an der console ausgibt
		
		long zeit;																																	// variable für die vergangene zeit (seit start des threads)
		long startzeit = System.currentTimeMillis() / 1000;																							// variable für startzeit
			while (startstop) {											// ist jetzt keine endlosschleife mehr, lässt sich via die methode setStartstop von true auf false setzen, un somit schleife beenden
				try {
					Thread.sleep(1000);																												// thread unterbrechen jede sekunde
				} catch (InterruptedException e) {																									// thread spezifisches exception-handling
					break;																															// unterbruch falls InterruptedException
				}																																
				zeit = System.currentTimeMillis() / 1000 - startzeit;																				// vergangene zeit berechnen 
				System.out.println(zeit);																											// vergangene zeit ausgeben
			}
		
	}
	
	public void setStartstop(boolean startstop) {						// setter für die variable startstop (boolean-wert als parameterübergabe)
		this.startstop = startstop;										// variable auf übergabe-wert setzen
	}
}
