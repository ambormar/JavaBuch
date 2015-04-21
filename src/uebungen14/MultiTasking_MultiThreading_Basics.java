/* TODO 14.1.1. (+14.1.2.)   s.438/439 
 * MultiTasking_MultiThreading_Basics
 * 
 * 	
 * 	PROZESSE = TASKS:		=> verschiedene anwendungen / programme, die auch echt gleichzeitig abgearbeitet werden können, z.b. mit mehrprozessor-systemen (dualcore / quadcore) 
 * 							=> jeder prozess / task besitzt einen eigenen speicherbereich 
 * 							=> für die verwaltung von prozessen / tasks ist das betriebssystem / computersystem zuständig 
 * 
 * 
 * 	THREADS:				=> sind unterschiedliche, geschlossene Programm-abläufe innerhalb eines prozesses / tasks.  
 * 							=> mehrere threads teilen sich EINEN speicherbereich
 * 							=> thereads werden durch das anwenderprogramm verwaltet
 * 							=> threads unterteilen prozesse und werden nur fiktiv gleichzeitig abgearbeitet 
 * 								-> tatsächlich wird vom anwenderprogramm schnell zwischen verschiedenen threads hin- + her- gewechselt
 * 							=> ein anwendungsprogramm besteht immer aus mindestens einem thread
 * 								-> dieser wird durch die MAIN-methode gestartet
 * 								-> weitere threads lassen sich innerhalb des anwenderprogramms zusätzlich erzeugen
 * 			
 * 		MUSTER-BSP. FÜR THREADS:		=> programmierung zeitlicher abläufe (ampelsteuerung)
 * 											-> in abläufe, die sich in bestimmtem rythmus wiederholen + automatisch sind ..
 *											-> .. situations-abhängig eingreifen & z.b. den rythmus ändern
 *											
 *										SIEHE:  	14.2.1		Threads_Ampelsteuerung_Einfach		s.440
 * 
 * 
 *	MULTI-TASKING:			=> sequentielle oder echt gleichzeitige (bei mehrprozessor-systemen) abarbeitung von prozessen / tasks (programmen) 
 *  (MULTI-PROZESSING)		=> wird vom betriebssystem verwaltet
 *  							-> beim quasi gleichzeitigen (sequentiellen) ablauf mehrerer prozesse muss das betriebssystem die einzelnen prozesse immer wieder anhalten und starten
 * 
 * 
 * 	MULTITHREADING:			=> fiktiv gleichzeitiges abarbeiten (hin + herswitchen) von unterschiedlichen geschlossenen programm-handlungs-strängen
 * 							=> wird vom anwenderprogramm gesteuert
 * 
 * 
 */

package uebungen14;

public class MultiTasking_MultiThreading_Basics {

}
