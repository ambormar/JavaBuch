/* TODO .9,1.1.   s.248
 * class Swing_API_Java
 * 
 * 		SIEHE AUCH:		9.1.1.   JFC_JavaFoundationClasses		s.247 
 * 						9.1.2.   AWT_abstract_window_toolkit	s.252
 * 
 * JAVA-SWING-API:
 * 
 * 			das java swing API ist umfangreich & besteht aus 18 öffentlichen paketen, von denne meist nur wenige benötigt werden.
 * 
 * 			für viele anwendungen reicht es, nur 1-2 pakete eizubinden:		1. javax.swing		
 * 																			2. javax.swing.event
 * 
 * 			bei der verwendung von Jigloo werden die erforderlichen komponenten aus den java swing paketen automatisch eingebunden 
 * 
 * 
 * 		18 PAKETE DES SWING-APIs:
 * 				
 * 			javax.accessebility			javax.swing.plaf				javax.swing.text
 * 			javax.swing					javax.swing.plaf.basic			javax.swing.text.html
 * 			javax.swing.border			javax.swing.plaf.metal			javax.swing.text.html.parser
 * 			javax.swing.colorchooser	javax.swing.plaf.multi			javax.swing.text.rtf
 * 			javax.swing event			javax.swing.plaf.synth			javax.swing.tree
 * 			javax.swing.filechooser		javax.swing.table				javax.swing.undo
 * 
 * 
 * 		BSPe:		import javax.swing.JButton;					jigloo-komponenten
 *					import javax.swing.JLabel;						"
 *					import javax.swing.JTextField;					"
 *					import javax.swing.WindowConstants;			Jigloo fensterschliess konstanten
 *					import javax.swing.SwingUtilities;			jigloo GUI-threads						SwingUtilities.invokeLater(new Runnable() {..}										
 * 
 * 
 * 	WIKI:	SWING (JAVA):
 * 
 * 			Bei Swing handelt es sich um eine Programmierschnittstelle (API) und Grafikbibliothek zum Programmieren von grafischen Benutzeroberflächen. 
 * 			Swing wurde von Sun Microsystems für die Programmiersprache Java entwickelt. Seit Java-Version 1.2 (1998) ist es Bestandteil der Java-Runtime. 
 * 			Swing gehört zu den Java Foundation Classes (JFC), die eine Sammlung von Bibliotheken zur Programmierung von grafischen Benutzerschnittstellen bereitstellen. 
 * 			Zu diesen Bibliotheken gehören Java 2D, die Java Accessibility API (JAAPI), das Drag & Drop-API und das Abstract Window Toolkit (AWT). 
 * 			Swing baut auf dem älteren AWT auf und ist mit den anderen APIs verwoben. 
 * 
 * 		Zusammenhang Swing & AWT siehe gafik:		http://upload.wikimedia.org/wikipedia/commons/1/1f/AWTSwingClassHierarchy.png
 * 
 * 
 * 		Multithreading
 *
 *			Swing ist nicht thread-sicher, es kann also zu unerwarteten Wechselwirkungen zwischen verschiedenen Threads kommen, wenn nicht sorgfältig programmiert wird.
 *			Stattdessen sind die Swing-Komponenten so implementiert, dass ihre Methoden stets in einem sogenannten Event Dispatch Thread des AWT ausgeführt werden müssen, 
 *			der die gesamte Ereignisverarbeitung grafisch-interaktiver Java-Anwendungen durchführt.Um dies zu vereinfachen, stellt die Hilfsklasse 
 *			SWINGUTILITIES zwei Methoden bereit, die aus anderen Threads heraus aufgerufen werden können und ein ausführbares Objekt vom Typ Runnable als Parameter nehmen.
 *
 *   			- invokeLater:		reiht das ausführbare Objekt in die Ereigniswarteschlange von AWT ein und kehrt noch vor dessen Ausführung in den aufrufenden Code zurück. 
 *   								Der aufrufende Thread wird also nicht blockiert.
 *   								
 *   			- invokeAndWait:	reiht das ausführbare Objekt in die Ereigniswarteschlange von AWT ein und wartet, bis es abgearbeitet wurde. 
 *   								Der aufrufende Thread wird also blockiert.
 *
 *			Außerhalb des JRE stellte Sun eine SwingWorker genannte Basisklasse zur Verfügung, die zwei zu überladende Methoden anbietet: 
 *			Eine, die in einem eigenen Thread aufgerufen wird und eine längerdauernde Operation ausführen kann und eine weitere, 
 *			die nach dieser Operation im Event Dispatch Thread ausgeführt wird und Swing-Komponenten manipulieren darf. 
 *			Seit Java 1.6 ist sie als javax.swing.SwingWorker im JRE enthalten
 * 
 */

package uebungen09;

import javax.swing.SwingUtilities;

public class Swing_API_Java {

}
