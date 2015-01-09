/* TODO .9,1.2.   s.252
 * class AWT_abstract_window_toolkit
 * 
 * 		SIEHE AUCH:		9.1.1.   JFC_JavaFoundationClasses		s.247 
 * 						9.1.1.   Swing_API_Java					s.248 
 * 
 * ABSTRACT WINDOW TOOLKIT - AWT:
 * 
 * 		Das Abstract Window Toolkit (AWT) ist Bestandteil der Java Foundation Classes.
 * 		Das AWT steht als als grundlage f�r die entwicklung der grafischen oberfl�chen zur verf�gung.
 * 		Swing baut auf dem �lteren AWT auf und ist mit den anderen APIs verwoben.
 * 
 * 		[maja:	viele (die meisten, alle?) elemente die es als swing-komponenten gibt, gibt's auch als awt-komponenten:		bsp: 	button & jButton ]
 * 
 * 
 * 		COMPONENT:		Die oberste fensterklasse der hierarchie als ursprung aller AWT-klassen ist Component.
 * 						Component esitzt eine gr�sse + position & kann eine vielzahl von ereignissen senden + auf ereignisse reagieren.
 * 						Diese eigenschaften + f�higkeiten bilden die grundlage jeder komponente einer grafischen benutzeroberfl�che.
 * 
 * 		CONTAINER:		Container ist ebenfalls eine abstracte klasse. sie bildet die grundlage f�r Komponenten, die andere componenten aufnehmen sollen.
 * 						sie verf�gt �ber methoden zum hinzuf�gen, entfernen & positionieren der enthaltenen komponenten.
 * 
 * 		PANEL:			Panel ist die einfachste konkrete klasse, die als element in ein proramm eingebaut werden kann 
 * 
 * 
 * 		KLASSENHIERARCHIE DES AWT:
 * 
 * 				Component
 * 				|_______________________________________
 * 				|				|			|			|
 * 				Container		Button		Cannvas		Checkbox
 * 				|___________________________
 * 				|							|
 * 				Panel						Window
 * 				|					________|________
 * 				|					|				|
 * 				Applet				Frame			Dialog
 * 													|
 * 													|
 * 													FileDialog
 * 
 * 
 * 		BSPe F�R AWT:		import java.awt.event.ActionEvent;
 *							import java.awt.event.ActionListener;
 *							import java.awt.event.KeyAdapter;
 *							import java.awt.event.KeyEvent;
 * 	
 * 
 * 	WIKI:	ABSTRACT WINDOW TOOLKIT - AWT:
 * 
 *		Das Abstract Window Toolkit (AWT) ist Bestandteil der Java Foundation Classes (JFC) und stellt eine Standard-API zur Erzeugung und Darstellung einer plattformunabh�ngigen 
 *		grafischen Benutzerschnittstelle (GUI) f�r Java-Programme dar. AWT stellt das so genannte Heavyweight-Framework zur Darstellung von Steuerelementen dar. 
 *		Das bedeutet, dass AWT die nativen GUI-Komponenten des jeweiligen Betriebssystems zur Darstellung verwendet. Diese nativen GUI-Komponenten werden Peer (englisch f�r "Partner") genannt. 
 *		Heavyweight, also schwergewichtig, hei�en diese Komponenten, weil teilweise umfangreiche Betriebssystem-Ressourcen mit ihnen verbunden sein k�nnen.
 *		Als ernsthafte Alternativen stehen Swing f�r plattformunabh�ngige leichtgewichtige Oberfl�chen und SWT ebenfalls als plattformunabh�ngige schwergewichtige Oberfl�chen zur Verf�gung. * 
 */

package uebungen09;

public class AWT_abstract_window_toolkit {

}
