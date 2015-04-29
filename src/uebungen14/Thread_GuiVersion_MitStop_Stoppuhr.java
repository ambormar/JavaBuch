/* TODO 14.2.2.   s.450, eigene Version stoppuhr für gui-programm  
 * class Thread_GuiVersion_MitStop_Stoppuhr	&	StoppuhrTest_GuiVersion_MitStop
 * 
 * 		SIEHE:													14.2.2.   Thread_Stoppuhr	&	StoppuhrTest			s.450, 1. Art Thread zu erstellen (=> extends Thread) 
 * 
 * 		SIEHE (2 MÖGLICHKEITEN ZUR ERSTELLUNG VON THREADS):		14.2.2.   Threads_Klasse_Basics_Methoden_Konstruktoren_Eigenschaften_2ArtenDerThreadErstellung			s.447, 2 Arten Threads zu erstellen 
 *
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
 *  	THREAD SAUBER STOPPEN MITTELS WHILE-SCHLEIFE im run() & BOOLEAN VARIABEL:
 *  
 *  			=> es gibt keine erlaubte methode stop() für Threads:	-> eine einfache möglichkeit Threads sauber zu stoppen ist:
 *  
 *		   		=> im run() eine while-schleife mit boolean variable als bedingung einbauen
 *					-> variable nach belieben auf true oder false setzen
 *					-> evtl. mittels zusätzlichem setter für die variable, um von aussen drauf zugreifen zu können
 *					
 *					EigeneThread extends Thread: 	
 *					
 *							Bsp:		private boolean startstop = true;				// anfangswert auf true dann kann man den Thread einfach starten mit ThreadXY.start()
 *							
 *							&:			run(){											// überschreiben
 *							
 *											while (startstop){
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
