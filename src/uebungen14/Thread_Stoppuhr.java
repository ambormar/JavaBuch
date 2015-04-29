/* TODO 14.2.2.   s.450, 1. Art Thread zu erstellen (=> extends Thread) 
 * class Thread_Stoppuhr	&	StoppuhrTest
 * 
 * 
 * 		SIEHE (2 M�GLICHKEITEN ZUR ERSTELLUNG VON THREADS):		14.2.2.   Threads_Klasse_Basics_Methoden_Konstruktoren_Eigenschaften_2ArtenDerThreadErstellung			s.447, 2 Arten Threads zu erstellen 
 *  
 * 
 * 	K&K:	Klasse Thread_Stoppuhr (von der Klasse Thread abgeleitet):
 * 				Die Klasse zeigt exemplarisch die Erstellung eines eigenen Threads.
 * 				Der Thread als Stoppuhr misst die zeit die ab Thread-start vergeht und gibt jede (ca.) sekunde die vergangenen sekunden auf der konsole aus.
 * 
 * 			Programm Stoppuhrtest: 
 * 				zum Testen der von Thread abgeleiteten Klasse Stoppuhr.
 * 				der Stoppuhr-Thread l�sst sich in jedes Programm einbauen.	(auch GUI-programme: dann aber aus der entwicklungs-umgebung starten & mit consolen-stopp beenden)
 * 
 * 			ACHTUNG: der Thread hat keinen stopp eingebeaut		& 	muss also mit dem Konsolen-STOP beendet werden, sonst l�ufts einfach weiter
 * 			
 * 
 * 	1. ART EINEN THREAD ZU ERSTELLEN:	ABLEITEN EINER EIGENEN KLASSE VON DER KLASSE THREAD:
 *
 *			=> nur m�glich f�r klassen, die nicht bereits abgeleitet wurden				
 *				-> also nicht z.b. bei von gui-komponenten abgeleiteteten klassen			
 *			=> haupts�chlich f�r konsolen-programme 
 *				(= programme deren ausgaben �ber die konsole gelesen werden)
 * 
 * 
 *	VORGEHEN:	
 *
 *		Klasse Thread_Stoppuhr (extends Thread):
 *		
 *				=> ableiten der eigenen Klasse Thread_Stoppuhr von der klasse Thread
 *
 *				=> �berschreiben der methode run()  		
 *
 *						CODE: 	Stoppuhr extends Thread {							// ableiten der eigenen Klasse von Thread
 *
 *									public void run {								// run() �berschreiben 
 *										anweisungen;								// gew�nschte anweisungen f�r die funktion des eigenen threads
 *									}
 *
 *								}
 *			
 *
 *		TestKlasse StoppuhrTest:
 *					
 *				=> verwenden des eigenen Threads durch erzeugen in der main-methode mit Konstruktor-aufruf
 *					&  starten mit methode start()
 *	
 *						CODE: 	public static void main(String[] args){				
 *									Stoppuhr stoppuhr = new Stoppuhr();				
 *									stoppuhr.start();
 *								}
 *
 *
 * 	METHODEN (besondere):	
 * 				
 * 		void sleep(long m)					der Klasse Thread		-> erzwingt eine pause in der ausf�hrung des laufenden threads (auch des main-threads) von m millisekunden.
 * 																	-> zwingt zu InterruptedException-handling, da threads wiederspr�che ausl�sen k�nnen. 
 * 																			-> auch bei blosser verwendung der methode, ohne dass ein 2. thread erzeugt wurde
 * 
 *	EXCEPTIONS:		
 *
 *		InterruptedException				der klasse Thread		-> bei verwendung von Threads k�nnen diese sich gegenseitig unterbrechen
 *																	-> der unterbrochene thread wirft dann eine InterruptedException
 *																	-> bei einsatz von Threads, alleine durch verwendung der methode sleep(..) 
 *																		-> muss ein exception-handling f�r InterruptedExceptions erfolgen 
 *																				->  Throws oder try-catch-block
 * 
 */ 

package uebungen14;

public class Thread_Stoppuhr extends Thread {				// ableiten der eigenen Klasse von Thread
	
	// �berschreiben der methode run()
	public void run(){										// methode run() wird hier so �berschrieben, dass der Thread als stoppuhr, die sekunden, die seit seinem start vergangen sind, an der console ausgibt
		long zeit;											// variable f�r die vergangene zeit (seit start des threads)
		long startzeit = System.currentTimeMillis() / 1000;	// variable f�r startzeit
			while (true) {									// ACHTUNG endlos-schleife		=> Programm muss �ber konsolen-stop beendet werden
				try {
					Thread.sleep(1000);						// thread unterbrechen jede sekunde
				} catch (InterruptedException e) {			// thread spezifisches exception-handling
					break;									// unterbruch falls InterruptedException
				}
				zeit = System.currentTimeMillis() / 1000 - startzeit;	// vergangene zeit berechnen 
				System.out.println(zeit);								// vergangene zeit ausgeben
			}
	}
}
