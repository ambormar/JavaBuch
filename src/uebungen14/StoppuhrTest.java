/* TODO 14.2.2.   s.450,
 * class StoppuhrTest	&	Thread_Stoppuhr	
 * 
 *  
 * 		SIEHE (2 MÖGLICHKEITEN ZUR ERSTELLUNG VON THREADS):		14.2.2.   Threads_Klasse_Basics_Methoden_Konstruktoren_Eigenschaften_2ArtenDerThreadErstellung			s.447, 2 Arten Threads zu erstellen 
 *  
 * 
 * 	K&K:	Klasse Thread_Stoppuhr (von der Klasse Thread abgeleitet):
 * 				Die Klasse zeigt exemplarisch die Erstellung eines eigenen Threads.
 * 				Der Thread als Stoppuhr misst die zeit die ab Thread-start vergeht und gibt jede (ca.) sekunde die vergangenen sekunden auf der konsole aus.
 * 
 * 			Programm Stoppuhrtest: 
 * 				zum Testen der von Thread abgeleiteten Klasse Stoppuhr.
 * 				der Stoppuhr-Thread lässt sich in jedes Programm einbauen.	(auch GUI-programme: dann aber aus der entwicklungs-umgebung starten & mit consolen-stopp beenden)
 * 
 * 			ACHTUNG: der Thread hat keinen stopp eingebeaut		& 	muss also mit dem Konsolen-STOP beendet werden, sonst läufts einfach weiter
 * 			
 * 
 * 	1. ART EINEN THREAD ZU ERSTELLEN:	ABLEITEN EINER EIGENEN KLASSE VON DER KLASSE THREAD:
 *
 *			=> nur möglich für klassen, die nicht bereits abgeleitet wurden				
 *				-> also nicht z.b. bei von gui-komponenten abgeleiteteten klassen			
 *			=> hauptsächlich für konsolen-programme 
 *				(= programme deren ausgaben über die konsole gelesen werden)
 * 
 * 
 *	VORGEHEN:	
 *
 *		Klasse Thread_Stoppuhr (extends Thread):
 *		
 *				=> ableiten der eigenen Klasse Thread_Stoppuhr von der klasse Thread
 *
 *				=> überschreiben der methode run()  		
 *
 *						CODE: 	Stoppuhr extends Thread {							// ableiten der eigenen Klasse von Thread
 *
 *									public void run {								// run() überschreiben 
 *										anweisungen;								// gewünschte anweisungen für die funktion des eigenen threads
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
 * 		void sleep(long m)					der Klasse Thread		-> erzwingt eine pause in der ausführung des laufenden threads (auch des main-threads) von m millisekunden.
 * 																	-> zwingt zu InterruptedException-handling, da threads wiedersprüche auslösen können. 
 * 																			-> auch bei blosser verwendung der methode, ohne dass ein 2. thread erzeugt wurde
 * 
 *	EXCEPTIONS:		
 *
 *		InterruptedException				der klasse Thread		-> bei verwendung von Threads können diese sich gegenseitig unterbrechen
 *																	-> der unterbrochene thread wirft dann eine InterruptedException
 *																	-> bei einsatz von Threads, alleine durch verwendung der methode sleep(..) 
 *																		-> muss ein exception-handling für InterruptedExceptions erfolgen 
 *																				->  Throws oder try-catch-block
 * 
 */ 

package uebungen14;



public class StoppuhrTest {

	public static void main(String[] args){					
		Thread_Stoppuhr stoppuhr = new Thread_Stoppuhr();		// verwenden des eigenen Threads durch erzeugen in der main-methode mit Konstruktor-aufruf
		stoppuhr.start();										// &  starten mit methode start()
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
