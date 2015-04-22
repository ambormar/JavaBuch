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
 * THREAD BASICS:		=> ein Tread ist ein programmteil, der parallel zum �brigen programm abl�uft			
 * 						=> ein miniproramm innerhalb eines programms:			-> es muss lauff�hig sein, gestartet & beendet werden k�nnen
 * 						=> ein programmteil wir durch methode RUN() lauff�hig	-> auch in der main-methode wird ein lauff�higer programmteil  => THREAD erstellt
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
 *	2 M�GLICHKEITEN ZUR ERSTELLUNG VON THREADS:		
 *					
 *		1. ABLEITEN EINER EIGENEN KLASSE VON DER KLASSE THREAD						2. OBJEKT DER ALLGEMEINEN KLASSE THREAD WIRD ERZEUGT, 
 *																						DEREN RUN()-METHODE VERWEISTAUF EINE RUN()-METHODE, DIE IN EINER ANDEREN KOMPONENTE IMPLEMENTIERT IST
 *
 *			=> nur m�glich f�r klassen, die nicht bereits abgeleitet wurden				=> f�r klassen die bereits von einer anderen klasse abgeleitet wurden
 *				-> also nicht z.b. bei von gui-komponenten abgeleiteteten klassen			-> bsp.:	von gui-komponenten abgeleiteteten klassen 
 *			=> haupts�chlich f�r konsolen-programme
 * 
 *	 		____________________________________											____________________________________________________________
 *	 		|									|											|															|
 *	 		|	EigenKlasse extends Thread		|											|	EigenKlasse extends andereKlasse implements Runnable	|							
 *	 		|									|											|															|
 *	 		|		run()						|											| --->	run()												|
 *	 		|___________________________________|											|_�_________________________________________________________|
 *	 																						  �
 *	 					&																	  �				&
 *	 		____________________________________											__�__________________________________
 *	 		|  									|											| � 								|
 *	 		|	Anwendung						|											| � Anwendung						|
 *	 		|	________________________		|											| �	________________________		|
 *	 		|	|	new EigeneKlasse	|		|											| �	|	new Thread			|		|
 *	 		|	|						|		|											| �	|						|		|
 *	 		|	|	run()				|		|											| --|---run()				|		|
 *	 		|	|_______________________|		|											|	|_______________________|		|
 *	 		|___________________________________|											|___________________________________|
 *	  	
 *
 *			=> zum ableiten einer eigenen klasse thread muss man run() �berschreiben 
 *
 *					BSP: 	Stoppuhr extends Thread {
 *								public void run {
 *									�berschreiben
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
 * 								static int MAX_PRIORITY						maximal m�gliche priorit�t
 * 								static int MIN_PRIORITY						minimal m�gliche priorit�t
 * 								static int NORM_PRIORITY					standard-priorit�t
 * 
 * 
 * 	EINIGE KONSTRUKTOREN: 		KONSTRUKTOR:								BESCHREIBUNG:
 * 
 * 								public Thread()								erzeugt einen Thread ohne spez. gruppenzugeh�rigkeit & ohne externe zielangabe f�r eine run()-methode.
 * 																			er erh�lt einen automatisch vergebenen namen
 * 								public Thread(Runnable target)				erzeugt einen Thread, der die run-methode von target ausf�hrt. 
 * 																			der name wird automatisch vergeben.
 * 								public Thread(ThreadGroup group,			erzeugt einen Thread der zur Gruppe ThreadGroup geh�rt. er f�hrt die run()-methode target aus & heisst name
 *  									Runnable tagret, String name)
 * 
 * 
 * 	WICHTIGE METHODEN:			METHODE:									BESCHREIBUNG:
 * 
 * 								String getName()							liefert den namen des Threads.
 * 								static setName(String name)					setzt den namen des Threads auf name.
 * 								static Thread currentThread()				liefert eine referenz auf den laufenden Thread.
 * 								boolean isInterrupted()						liefert zur�ck, ob der Thread unterbrochen ist.
 * 								void getPriority()							liefert die priorit�t eine Threads.
 * 								void setPriority(int p)						setzt die priorit�t eines Threads auf den wert p.
 * 								void join()									wartet bis der Thread, dessen join()-methode aufgerufen wurde, beendet ist.
 * 								void run()									ruft die run()-methode des im konstruktor angegebenen externen runnabel-Objekts auf.
 * 																			wurde keines �bergeben, f�hrt sie nichts aus (ausser sie wird �berschrieben).
 * 								void yield()								erzwingt eine pause, damit andere Threads gelegenheit zur ausf�hrung erhalten
 * 																			(kann je nach betriebssystem erforderlich sein).
 * 								void sleep(long m)							erzwingt eine pause in der ausf�hrung des Threads von m millisekunden
 * 
 * 
 * 
 */

package uebungen14;

import javax.swing.SwingUtilities;

public class Threads_Klasse_Basics_Methoden_Konstruktoren_Eigenschaften_2ArtenDerThreadErstellung {

}
