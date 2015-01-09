/* TODO .9,1.1.   s.248
 * class Swing_API_Java
 * 
 * 		SIEHE AUCH:		9.1.1.   JFC_JavaFoundationClasses		s.247 
 * 						9.1.2.   AWT_abstract_window_toolkit	s.252
 * 
 * JAVA-SWING-API:
 * 
 * 			das java swing API ist umfangreich & besteht aus 18 �ffentlichen paketen, von denne meist nur wenige ben�tigt werden.
 * 
 * 			f�r viele anwendungen reicht es, nur 1-2 pakete eizubinden:		1. javax.swing		
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
 * 			Bei Swing handelt es sich um eine Programmierschnittstelle (API) und Grafikbibliothek zum Programmieren von grafischen Benutzeroberfl�chen. 
 * 			Swing wurde von Sun Microsystems f�r die Programmiersprache Java entwickelt. Seit Java-Version 1.2 (1998) ist es Bestandteil der Java-Runtime. 
 * 			Swing geh�rt zu den Java Foundation Classes (JFC), die eine Sammlung von Bibliotheken zur Programmierung von grafischen Benutzerschnittstellen bereitstellen. 
 * 			Zu diesen Bibliotheken geh�ren Java 2D, die Java Accessibility API (JAAPI), das Drag & Drop-API und das Abstract Window Toolkit (AWT). 
 * 			Swing baut auf dem �lteren AWT auf und ist mit den anderen APIs verwoben. 
 * 
 * 		Zusammenhang Swing & AWT siehe gafik:		http://upload.wikimedia.org/wikipedia/commons/1/1f/AWTSwingClassHierarchy.png
 * 
 * 
 * 		Multithreading
 *
 *			Swing ist nicht thread-sicher, es kann also zu unerwarteten Wechselwirkungen zwischen verschiedenen Threads kommen, wenn nicht sorgf�ltig programmiert wird.
 *			Stattdessen sind die Swing-Komponenten so implementiert, dass ihre Methoden stets in einem sogenannten Event Dispatch Thread des AWT ausgef�hrt werden m�ssen, 
 *			der die gesamte Ereignisverarbeitung grafisch-interaktiver Java-Anwendungen durchf�hrt.Um dies zu vereinfachen, stellt die Hilfsklasse 
 *			SWINGUTILITIES zwei Methoden bereit, die aus anderen Threads heraus aufgerufen werden k�nnen und ein ausf�hrbares Objekt vom Typ Runnable als Parameter nehmen.
 *
 *   			- invokeLater:		reiht das ausf�hrbare Objekt in die Ereigniswarteschlange von AWT ein und kehrt noch vor dessen Ausf�hrung in den aufrufenden Code zur�ck. 
 *   								Der aufrufende Thread wird also nicht blockiert.
 *   								
 *   			- invokeAndWait:	reiht das ausf�hrbare Objekt in die Ereigniswarteschlange von AWT ein und wartet, bis es abgearbeitet wurde. 
 *   								Der aufrufende Thread wird also blockiert.
 *
 *			Au�erhalb des JRE stellte Sun eine SwingWorker genannte Basisklasse zur Verf�gung, die zwei zu �berladende Methoden anbietet: 
 *			Eine, die in einem eigenen Thread aufgerufen wird und eine l�ngerdauernde Operation ausf�hren kann und eine weitere, 
 *			die nach dieser Operation im Event Dispatch Thread ausgef�hrt wird und Swing-Komponenten manipulieren darf. 
 *			Seit Java 1.6 ist sie als javax.swing.SwingWorker im JRE enthalten
 * 
 */

package uebungen09;

import javax.swing.SwingUtilities;

public class Swing_API_Java {

}
