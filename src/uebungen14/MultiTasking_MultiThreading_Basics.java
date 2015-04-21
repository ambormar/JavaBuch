/* TODO 14.1.1. (+14.1.2.)   s.438/439 
 * MultiTasking_MultiThreading_Basics
 * 
 * 	
 * 	PROZESSE = TASKS:		=> verschiedene anwendungen / programme, die auch echt gleichzeitig abgearbeitet werden k�nnen, z.b. mit mehrprozessor-systemen (dualcore / quadcore) 
 * 							=> jeder prozess / task besitzt einen eigenen speicherbereich 
 * 							=> f�r die verwaltung von prozessen / tasks ist das betriebssystem / computersystem zust�ndig 
 * 
 * 
 * 	THREADS:				=> sind unterschiedliche, geschlossene Programm-abl�ufe innerhalb eines prozesses / tasks.  
 * 							=> mehrere threads teilen sich EINEN speicherbereich
 * 							=> thereads werden durch das anwenderprogramm verwaltet
 * 							=> threads unterteilen prozesse und werden nur fiktiv gleichzeitig abgearbeitet 
 * 								-> tats�chlich wird vom anwenderprogramm schnell zwischen verschiedenen threads hin- + her- gewechselt
 * 							=> ein anwendungsprogramm besteht immer aus mindestens einem thread
 * 								-> dieser wird durch die MAIN-methode gestartet
 * 								-> weitere threads lassen sich innerhalb des anwenderprogramms zus�tzlich erzeugen
 * 			
 * 		MUSTER-BSP. F�R THREADS:		=> programmierung zeitlicher abl�ufe (ampelsteuerung)
 * 											-> in abl�ufe, die sich in bestimmtem rythmus wiederholen + automatisch sind ..
 *											-> .. situations-abh�ngig eingreifen & z.b. den rythmus �ndern
 *											
 *										SIEHE:  	14.2.1		Threads_Ampelsteuerung_Einfach		s.440
 * 
 * 
 *	MULTI-TASKING:			=> sequentielle oder echt gleichzeitige (bei mehrprozessor-systemen) abarbeitung von prozessen / tasks (programmen) 
 *  (MULTI-PROZESSING)		=> wird vom betriebssystem verwaltet
 *  							-> beim quasi gleichzeitigen (sequentiellen) ablauf mehrerer prozesse muss das betriebssystem die einzelnen prozesse immer wieder anhalten und starten
 * 
 * 
 * 	MULTITHREADING:			=> fiktiv gleichzeitiges abarbeiten (hin + herswitchen) von unterschiedlichen geschlossenen programm-handlungs-str�ngen
 * 							=> wird vom anwenderprogramm gesteuert
 * 
 * 
 */

package uebungen14;

public class MultiTasking_MultiThreading_Basics {

}
