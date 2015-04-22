/* TODO 14.2.2.   s.447, 2 Arten Threads zu erstellen  !!!!!!
 * class Threads_Klasse_Basics_Methoden_Konstruktoren_Eigenschaften_2ArtenDerThreadErstellung
 * 
 * 		SIEHE AUCH BASICS:		14.1.1. (+14.1.2.)   MultiTasking_MultiThreading_Basics		s.438/439 
 * 
 * 		SIEHE ANGEWANDT:		14.2.2.		Thread_.._Ampelsteuerung3		s.452 (ab 447)		!!!!!!!!!! klassenname evtl. noch anpassen
 * 
 * 					&:			14.2.2.		Stoppuhr						s.448				!!!!!!!!!! klassenname evtl. noch anpassen
 * 
 * 
 * THREAD BASICS:		=> ein Tread ist ein programmteil, der parallel zum übrigen programm abläuft			
 * 						=> ein miniproramm innerhalb eines programms:			-> es muss lauffähig sein, gestartet & beendet werden können
 * 						=> ein programmteil wir durch methode RUN() lauffähig	-> auch in der main-methode wird ein lauffähiger programmteil  => THREAD erstellt
 * 							
 * 								BSP: 	main()-methode:		
 * 
 * 											public static void main(String[] args) {
 *												...																						// SwingUtilities.invokeLater(new Runnable() {
 *													public void run() {
 *														Klassenname inst = new Klassenname();
 *														...
 *													}
 *												...																						// });
 *											}
 * 		
 * 		
 *	2 MÖGLICHKEITEN ZUR ERSTELLUNG VON THREADS:		
 *					
 *		1. ABLEITEN EINER EIGENEN KLASSE VON DER KLASSE THREAD						2. OBJEKT DER ALLGEMEINEN KLASSE THREAD WIRD ERZEUGT, 
 *																						DEREN RUN()-METHODE VERWEISTAUF EINE RUN()-METHODE, DIE IN EINER ANDEREN KOMPONENTE IMPLEMENTIERT IST
 *
 *			=> nur möglich für klassen, die nicht bereits abgeleitet wurden				=> für klassen die bereits von einer anderen klasse abgeleitet wurden
 *				-> also nicht z.b. bei von gui-komponenten abgeleiteteten klassen			-> bsp.:	von gui-komponenten abgeleiteteten klassen 
 *			=> hauptsächlich für konsolen-programme
 * 
 *	 		____________________________________											____________________________________________________________
 *	 		|									|											|															|
 *	 		|	EigenKlasse extends Thread		|											|	EigenKlasse extends andereKlasse implements Runnable	|							
 *	 		|									|											|															|
 *	 		|		run()						|											| --->	run()												|
 *	 		|___________________________________|											|_¦_________________________________________________________|
 *	 																						  ¦
 *	 					&																	  ¦				&
 *	 		____________________________________											__¦__________________________________
 *	 		|  									|											| ¦ 								|
 *	 		|	Anwendung						|											| ¦ Anwendung						|
 *	 		|	________________________		|											| ¦	________________________		|
 *	 		|	|	new EigeneKlasse	|		|											| ¦	|	new Thread			|		|
 *	 		|	|						|		|											| ¦	|						|		|
 *	 		|	|	run()				|		|											| --|---run()				|		|
 *	 		|	|_______________________|		|											|	|_______________________|		|
 *	 		|___________________________________|											|___________________________________|
 *	  	
 *
 *			=> zum ableiten einer eigenen klasse thread muss man run() überschreiben 
 *
 *					BSP: 	Stoppuhr extends Thread {
 *								public void run {
 *									überschreiben
 *								}
 *							}
 *								
 *			=> verwenden eines eigenen Threads durch erzeugen mit Konstruktor-aufruf
 *				& starten mit methode start
 *	
 *					BSP: 	Stoppuhr stoppuhr = new Stoppuhr();
 *							stoppuhr.start();
 *			
 *
 * 			BSP SIEHE:		14.2.2.		Stoppuhr	s.448									BSP SIEHE:		14.2.2.	Thread_.._Ampelsteuerung3		s.452 (ab 447)		!!!!!!!!!!
 * 
 *  
 *   
 * 	PACKAGE:			=>	java.lang.Thread
 * 
 * 
 * 	EIGENSCHAFTEN:				EIGENSCHAFT:								BESCHREIBUNG:
 * 
 * 								static int MAX_PRIORITY						maximal mögliche priorität
 * 								static int MIN_PRIORITY						minimal mögliche priorität
 * 								static int NORM_PRIORITY					standard-priorität
 * 
 * 
 * 	EINIGE KONSTRUKTOREN: 		KONSTRUKTOR:								BESCHREIBUNG:
 * 
 * 								public Thread()								erzeugt einen Thread ohne spez. gruppenzugehörigkeit & ohne externe zielangabe für eine run()-methode.
 * 																			er erhält einen automatisch vergebenen namen
 * 								public Thread(Runnable target)				erzeugt einen Thread, der die run-methode von target ausführt. 
 * 																			der name wird automatisch vergeben.
 * 								public Thread(ThreadGroup group,			erzeugt einen Thread der zur Gruppe ThreadGroup gehört. er führt die run()-methode target aus & heisst name
 *  									Runnable tagret, String name)
 * 
 * 
 * 	WICHTIGE METHODEN:			METHODE:									BESCHREIBUNG:
 * 
 * 								String getName()							liefert den namen des Threads.
 * 								static setName(String name)					setzt den namen des Threads auf name.
 * 								static Thread currentThread()				liefert eine referenz auf den laufenden Thread.
 * 								boolean isInterrupted()						liefert zurück, ob der Thread unterbrochen ist.
 * 								void getPriority()							liefert die priorität eine Threads.
 * 								void setPriority(int p)						setzt die priorität eines Threads auf den wert p.
 * 								void join()									wartet bis der Thread, dessen join()-methode aufgerufen wurde, beendet ist.
 * 								void run()									ruft die run()-methode des im konstruktor angegebenen externen runnabel-Objekts auf.
 * 																			wurde keines übergeben, führt sie nichts aus (ausser sie wird überschrieben).
 * 								void yield()								erzwingt eine pause, damit andere Threads gelegenheit zur ausführung erhalten
 * 																			(kann je nach betriebssystem erforderlich sein).
 * 								void sleep(long m)							erzwingt eine pause in der ausführung des Threads von m millisekunden
 * 
 * 
 * 
 */

package uebungen14;

import javax.swing.SwingUtilities;

public class Threads_Klasse_Basics_Methoden_Konstruktoren_Eigenschaften_2ArtenDerThreadErstellung {

}
