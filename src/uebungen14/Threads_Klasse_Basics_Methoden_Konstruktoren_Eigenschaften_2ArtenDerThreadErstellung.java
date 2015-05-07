/* TODO 14.2.2.a.   s.447, 2 Arten Threads zu erstellen  !!!!!!!!!!!
 * class Threads_Klasse_Basics_Methoden_Konstruktoren_Eigenschaften_2ArtenDerThreadErstellung
 * 
 * 		SIEHE AUCH BASICS:		14.1.1. (+14.1.2.)   MultiTasking_MultiThreading_Basics									s.438/439 
 * 
 * 					&:			14.2.3.   		Synchronisation_VonThreads_Problematik_Begriff							s.453
 * 
 * 		SIEHE ANGEWANDT:		14.2.2.d.		Thread_ImplementsRunnable_Run_Ampelsteuerung3	& 	JAmpelPanel	_3		s.451
 * 
 * 					&:			14.2.2.b.		class StoppuhrTest	&	Thread_Stoppuhr									s.450				
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
 *						=> ein erzeugter Thread existiert solange bis seine run()-methode beendet ist
 * 		
 * 
 * 		
 *	2 M�GLICHKEITEN ZUR ERSTELLUNG VON THREADS:		
 *					
 *		1. ABLEITEN EINER EIGENEN KLASSE VON DER KLASSE THREAD						2. OBJEKT DER ALLGEMEINEN KLASSE THREAD WIRD ERZEUGT, DEREN RUN()-METHODE
 *																						VERWEISTAUF EINE RUN()-METHODE, DIE WOANDERS (IN EINER ANDEREN KOMPONENTE ??) IMPLEMENTIERT IST
 *
 *			=> nur m�glich f�r klassen, die nicht bereits abgeleitet wurden				=> f�r klassen die bereits von einer anderen klasse abgeleitet wurden
 *				-> also nicht z.b. bei von gui-komponenten abgeleiteteten klassen			-> bsp.:	von gui-komponenten abgeleiteteten klassen 
 *			=> haupts�chlich f�r konsolen-programme 
 *				(= programme deren ausgaben �ber die konsole gelesen werden)
 * 
 *	 		 ___________________________________											 ___________________________________________________________
 *	 		|									|											|															|
 *	 		|	EigenKlasse extends Thread		|											|	EigenKlasse extends andereKlasse implements Runnable	|							
 *	 		|									|											|															|
 *	 		|		run()	->  �berschreiben	|											| --->	run()			-> �berschreiben (@override)		|
 *	 		|___________________________________|											|_�_________________________________________________________|
 *	 																						  �
 *	 					&																	  �				&
 *	 		 ___________________________________											 _�_________________________________________________________
 *	 		|  									|											| � 														|
 *	 		|	Anwendung	(TestKlasse)		|											| � Anwendung (kann auch in der obigen/gleichen Klasse sein)|
 *	 		|	 _______________________		|											| �	 ___________________________							|
 *	 		|	|	new EigeneKlasse	|		|											| �	|	Thread t = new Thread	|							|
 *	 		|	|						|		|											| �	|							|							|
 *	 		|	|	run()				|		|											| --|---run()					|							|
 *	 		|	|_______________________|		|											|	|___________________________|							|
 *	 		|___________________________________|											|___________________________________________________________|
 *	  	
 *
 *			=> zum ableiten einer eigenen klasse von thread muss man run() �berschreiben 		=> Runnable von Thread f�r die klasse implementieren	
 *
 *					BSP: 	Stoppuhr extends Thread {												BSP:	XyKlasse extends JFrame implements Runnable {..}
 *								public void run {						// �berschreiben
 *									gew�nschte anweisungen f�r den 2. thread			
 *								}																=> Run()-methode von Thread �berschreiben inkl. den n�tigen anweisungen f�r den neuen Thread
 *							}																	
 *																									BSP:	@Override												
 *			=> verwenden eines eigenen Threads durch erzeugen mit Konstruktor-aufruf						public void run() {
 *				&  starten mit methode start																	Anweisungen f�r den neuen Threads;
 *																											}
 *					BSP: 	Stoppuhr stoppuhr = new Stoppuhr();
 *							stoppuhr.start();													=> Thread-objekt f�r neuen thread dort erstellen wo er beginnen soll & starten
 *			
 * 						 																			BSP:	Thread t = new Thread(this, "Automatik");
 *																											t.start();
 *
 *
 * 			BSP SIEHE:   14.2.2.b.	class  StoppuhrTest   &   Thread_Stoppuhr   s.450			BSP SIEHE:   14.2.2.d.   Thread_ImplementsRunnable_Run_Ampelsteuerung3	& JAmpelPanel_3	  s.451
 *
 *
 *
 * 	PACKAGE:					=>	java.lang.Thread
 * 
 * 
 * 	EIGENSCHAFTEN VON			EIGENSCHAFT:								BESCHREIBUNG:
 * 	THREAD:
 * 								static int MAX_PRIORITY						maximal m�gliche priorit�t
 * 								static int MIN_PRIORITY						minimal m�gliche priorit�t
 * 								static int NORM_PRIORITY					standard-priorit�t
 * 
 * 
 * 	EINIGE KONSTRUKTOREN 		=> thread hat konstruktoren f�r alle denkbaren konstellationen von einem bis drei parameter 
 * 	VON THREAD:						-> der thread-konstruktor kann max. 3 parameter haben, die nicht angegebenen parameterwerte werden mit standard-werten belegt
 * 	
 * 								KONSTRUKTOR:								BESCHREIBUNG:
 * 	
 * 								public Thread()								erzeugt einen Thread ohne spez. gruppenzugeh�rigkeit & ohne externe zielangabe f�r eine run()-methode.
 * 																			er erh�lt einen automatisch vergebenen namen
 * 								public Thread(Runnable target)				erzeugt einen Thread, der die run-methode von target ausf�hrt. 
 * 																			der name wird automatisch vergeben.
 * 								public Thread(ThreadGroup group,			erzeugt einen Thread der zur Gruppe ThreadGroup geh�rt. er f�hrt die run()-methode target aus & heisst name
 *  									Runnable tagret, String name)
 * 
 * 
 * 	WICHTIGE METHODEN			METHODE:									BESCHREIBUNG:
 * 	VON THREAD:
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
 * 								start()										starten des Threads
 * 								interrupt()									anhalten des Threads (= stoppen) (stop() gibt's nicht, bzw. ist nicht erlaubt)
 * 																				-> ACHTUNG:  SIEHE:		14.2.2.c.		StoppuhrTest_GuiVersion_MitStop	& 	Thread_VersionFuerGuiProgramme_Stoppuhr		s.450,
 *  																													=> THREAD SAUBER UNTERBRECHEN MIT INTERRUPT(), EGAL IN WELCHEM STATUS DER THREAD GERADE IST (SLEEP() ETC.):
 * 
 * 
 * 	SYNCHRONISATION VON THREADS:	
 * 		
 * 		SIEHE AUCH:			14.2.3.   		Synchronisation_VonThreads_Problematik_Begriff							s.453
 * 
 * 		BEGRIFF:	=> m�glichkeiten zur vorbeugung von konflikten, die durch die gleichzeitigkeit von anweisungen beim einsatz von Threads entstehen k�nnen
 * 
 * 		PROBLEMATIK BSPe:
 * 
 * 					-> 2 oder mehr Threads bearbeiten die gleiche datei:			-> ein thread versucht in die Datei zu l�schen
 * 																					-> gleichtzeitig versucht ein anderer in die datei zu schreiben
 * 			
 * 					-> 2 threads bearbeiten zeitgleich dieselbe boolsche variable: 	-> beide gehen davon aus, dass der zustand der variable (true/false) so ist, wie sie im jeweiligen thread gesetzt wurde 
 * 
 * 		L�SUNGEN:	=> SYNCHRONISATION VON THREADS 
 * 						-> unter dem stichwort SYNCHRONISATION VON THREADS findet man bei java jede menge information 
 * 				
 * 					=> konkretes angewandtes BSP:	SIEHE:		14.2.4.		Thread_Synchronisation_..		s.454		!!!!!!!!!!!
 * 
 * 
 * 		
 * 
 * 
 */

package uebungen14;

import javax.swing.SwingUtilities;

public class Threads_Klasse_Basics_Methoden_Konstruktoren_Eigenschaften_2ArtenDerThreadErstellung {

}
