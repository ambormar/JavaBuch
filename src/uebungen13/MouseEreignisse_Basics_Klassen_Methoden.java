/* TODO 13.4.0.-13.4.2.   s.425, 
 * class MouseEreignisse_Basics_Klassen_Methoden
 * 
 * MOUSE-EREIGNISSE:	=> haben immer einen empfänger
 * 						=> empfänger ist (zunächst) die Komponente, auf der sich die Mouse beim auslösen des ereignisses befindet
 * 
 *		LISTENER FÜR DIE JEWEILIGE KOMPONENTE ERSTELLEN:
 *
 *			-> mit JIGlOO:	Komponente anwählen > GUI-Properties > events > event-name 	
 *							-> entsprechenden Listener auswählen 			(MouseListener, MouseMotionListener oder MouseWheelListener)
 *							-> methode für zustand der mouse auswählen		(bsp: mousePressed(..) oder mouseReleased(..) etc. 
 *							-> auswählen ob inline oder handler method 		(=> also ob methode für die eigenen anweisungen direkt im Listener oder ausgelagert erstellt wird)
 * 
 * 			-> Quellcode (von jigloo erzeugt):	
 * 
 * 				für die Komponente		-> wird eine methode addListener aufgerufen ..  												bsp: 	jPanelZeichenflaeche.addMouseListener
 * 										-> .., die erstellt einen Adapter..																bsp: 	new MouseAdapter
 * 										-> .., der für das gewünschte ereignis eine methode inkl. ereignis-objekt erstellt..			bsp: 	public void mouseEntered(MouseEvent evt)
 * 										-> .., in der an die komponenten-speziefische handler ereignis-methode weitergegeben wird		bsp: 	jPanelZeichenflaecheMouseEntered(evt)
 * 										-> .., in welcher die anweisungen zur reaktion auf das ereignis untergebracht sind..			bsp: 	private void jPanelZeichenflaecheMouseEntered(MouseEvent evt) {anweisungen;}
 * 
 *				CODE-BSP:	initGUI():
 *				
 *							{
 *								jPanelZeichenflaeche = ..;																				
 *								...														
 *								jPanelZeichenflaeche.addMouseListener(new MouseAdapter() {		// MouseListener mit MouseAdapter für die komponente 
 *									public void mouseEntered(MouseEvent evt) {					// gewünschte ereignis-methode mit ereignis-objekt als parameter
 *										jPanelZeichenflaecheMouseEntered(evt);					// wietergabe an die komponenten-speziefischen (ausgelagerten) handler methode
 *									}
 *								});
 * 							}
 * 
 * 							handler method (ausgelagerte methode):
 * 
 *							private void jPanelZeichenflaecheMouseEntered(MouseEvent evt) {		// jigloo-autogenerierte mouseEntered(..)-handler-methode der klasse MouseListener zur ereignis-behandlung bei eintritt des mauszeiger in die komponente jPanelZeichenflaeche
 *								anweisung;														// beliebige anweisung als reaktion auf eintritt des maus-zeigers in die jPanelZeichenflaeche
 *								evt.methode();													// aufruf von methoden, die auskunft über das ereignis selbst geben via das objekt evt der klasse MouseEvent 
 *							}  
 *
 * 
 * 
 * 		3 VERSCHIEDENE MOUSE-LISTENER:
 * 
 * 			LISTENER									BESCHREIBUNG
 * 
 * 			1. MouseListener								für betätigung der maustasten	&	betreten / verlassen des maus-zeigers
 * 
 * 			2. MouseMotionListener							für Mausbewegungen mit + ohne maustasten-betätigung
 * 
 * 			3. MouseWheelListener							für bewegungen des maus-rades
 * 
 * 
 * 		1. MOUSELISTENER - METHODEN:	
 * 
 * 			METHODE										BESCHREIBUNG
 *  
 * 			void mousePressed(MouseEvent evt)			wird beim drücken der maus-taste aufgerufen.
 * 
 * 			void mouseReleased(MouseEvent evt)			wird BEIM loslassen der maus-taste aufgerufen.
 * 
 * 			void mouseClicked(MouseEvent evt)			wird NACH dem loslassen der maus-taste aufgerufen.
 * 
 * 			void mouseEntered(MouseEvent evt) 			wird aufgerufen, wenn der maus-zeiger die betreffende komponente betritt.
 * 
 * 			void mouseExited(MouseEvent evt)			wird aufgerufen, wenn der maus-zeiger die betreffende komponente verlässt.
 * 
 * 		
 * 		2. MOUSEMOTIONLISTENER - METHODEN:		
 * 
 * 			METHODE										BESCHREIBUNG
 * 
 *			void mouseMoved(MouseEvent evt)				wird aufgerufen, wenn der maus-zeiger ohne tasten-betätigung bewegt wurde.
 *
 *			void mouseDragged(MouseEvent evt)			wird aufgerufen, wenn der maus-zeiger mit gedrückter maus-taste bewegt wurde.
 * 
 * 
 * 		3. MOUSEWHEELLISTENER - METHODE:  
 * 
 * 			METHODE										BESCHREIBUNG
 * 
 * 			void mouseWheelMoved(MouseWheelEvent evt)	wird aufgerufen, wenn das maus-rad bewegt wurde.
 * 
 * 
 * 		MOUSEEVENT - METHODEN (zur auskunft über die ereignisse):
 * 
 * 					=> MouseListener & MouseMotionListener erstellen MouseEvents wenn ein Maus-ereigniss erfasst wird
 *  				=> MouseEvent evt ist ein objekt, dass vom Listener erstellt wird, um ein ereignis näher zu beschreiben
 *  				=> die methoden von MouseEvent dienen zur auskunft über die eingetretenen ereignisse selbst
 *  
 * 			METHODE										BESCHREIBUNG
 * 			
 * 			int getButton()								gibt zurück auf welchen button sich das ereignis bezieht.
 * 			
 * 			Point getPoint()							liefert Objekt der klasse Point, mit den Koordinaten der maus-position, bezogen auf die auslösende komponente, zurück.
 * 
 * 			Point getLocationOnScreen()					liefert objekt der klasse Point, mit den koordinaten der maus-position, bezogen auf den bildschirm, zurück.
 * 
 * 			int getX()									liefert die x-koordinate der maus-position, bezogen auf die auslösende komponente, zurück.
 * 
 * 			int getXOnScreen()							liefert die x-koordinate der maus-position, bezogen auf den bildschirm, zurück.					
 * 
 * 			int getY()									liefert die y-koordinate der maus-position, bezogen auf die auslösende komponente, zurück.
 * 
 * 			int getYOnScreen()							liefert die y-koordinate der maus-position, bezogen auf den bildschirm, zurück.					
 * 
 * 			int getClickCount()							liefert die anzahl der hintereinander ausgeführten maus-clicks zurück.
 * 
 * 			boolean isAltDown()							
 * 			boolean isShiftDown()						liefert als wahrheitswert zurück, ob die jeweilige steuer-taste beim betätigen der maus-taste gedrückt war.
 *			boolean isControlDown()
 * 
 *			boolean isMetaDown()						liefert true, wenn die rechte maus-taste gedrückt wurde.
 * 
 * 
 * 		MOUSEWHEELEVENT - (zusätzliche) METHODEN:
 * 
 * 					=> MouseWheelEvent sind evtl. etwas schwieriger zu handhaben als MouseEvents
 * 						-> denn sie beziehen sich oft:		-> nicht auf die komponente, auf der sich der maus-zeiger befindet während der mausrad-betätigung..
 * 															-> .. sondern auf die scrollbalken der komponente	 
 * 															-> .. oder auf die scrollbalken einer übergeordneten komponente 
 * 
 * 					=> MouseWheelEvent ist von MouseEvent abgeleitet & hat folgende zusätzlichen methoden:
 *  
 * 			METHODE										BESCHREIBUNG
 * 
 * 			int getScrollAmount()						liefert die anzahl der einheiten, um die gescrollt werdn soll, zurück.
 * 
 * 			int getScrollType()							liefert zurück, wie gescrollt werden soll (seitenweise oder in kleinen schritten).
 * 
 * 			int getWheelrotation()						liefert zurück, um wieviel klicks das rad gedreht wurde.
 * 
 * 
 */

package uebungen13;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class MouseEreignisse_Basics_Klassen_Methoden {

}
