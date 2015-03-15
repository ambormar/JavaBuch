/* TODO 13.4.0.-13.4.2.   s.425, 
 * class MouseEreignisse_Basics_Klassen_Methoden
 * 
 * MOUSE-EREIGNISSE:	=> haben immer einen empf�nger
 * 						=> empf�nger ist (zun�chst) die Komponente, auf der sich die Mouse beim ausl�sen des ereignisses befindet
 * 
 *		LISTENER F�R DIE JEWEILIGE KOMPONENTE ERSTELLEN:
 *
 *			-> mit JIGlOO:	Komponente anw�hlen > GUI-Properties > events > event-name 	
 *							-> entsprechenden Listener ausw�hlen 			(MouseListener, MouseMotionListener oder MouseWheelListener)
 *							-> methode f�r zustand der mouse ausw�hlen		(bsp: mousePressed(..) oder mouseReleased(..) etc. 
 *							-> ausw�hlen ob inline oder handler method 		(=> also ob methode f�r die eigenen anweisungen direkt im Listener oder ausgelagert erstellt wird)
 * 
 * 			-> Quellcode (von jigloo erzeugt):	
 * 
 * 				f�r die Komponente		-> wird eine methode addListener aufgerufen ..  												bsp: 	jPanelZeichenflaeche.addMouseListener
 * 										-> .., die erstellt einen Adapter..																bsp: 	new MouseAdapter
 * 										-> .., der f�r das gew�nschte ereignis eine methode inkl. ereignis-objekt erstellt..			bsp: 	public void mouseEntered(MouseEvent evt)
 * 										-> .., in der an die komponenten-speziefische handler ereignis-methode weitergegeben wird		bsp: 	jPanelZeichenflaecheMouseEntered(evt)
 * 										-> .., in welcher die anweisungen zur reaktion auf das ereignis untergebracht sind..			bsp: 	private void jPanelZeichenflaecheMouseEntered(MouseEvent evt) {anweisungen;}
 * 
 *				CODE-BSP:	initGUI():
 *				
 *							{
 *								jPanelZeichenflaeche = ..;																				
 *								...														
 *								jPanelZeichenflaeche.addMouseListener(new MouseAdapter() {		// MouseListener mit MouseAdapter f�r die komponente 
 *									public void mouseEntered(MouseEvent evt) {					// gew�nschte ereignis-methode mit ereignis-objekt als parameter
 *										jPanelZeichenflaecheMouseEntered(evt);					// wietergabe an die komponenten-speziefischen (ausgelagerten) handler methode
 *									}
 *								});
 * 							}
 * 
 * 							handler method (ausgelagerte methode):
 * 
 *							private void jPanelZeichenflaecheMouseEntered(MouseEvent evt) {		// jigloo-autogenerierte mouseEntered(..)-handler-methode der klasse MouseListener zur ereignis-behandlung bei eintritt des mauszeiger in die komponente jPanelZeichenflaeche
 *								anweisung;														// beliebige anweisung als reaktion auf eintritt des maus-zeigers in die jPanelZeichenflaeche
 *								evt.methode();													// aufruf von methoden, die auskunft �ber das ereignis selbst geben via das objekt evt der klasse MouseEvent 
 *							}  
 *
 * 
 * 
 * 		3 VERSCHIEDENE MOUSE-LISTENER:
 * 
 * 			LISTENER									BESCHREIBUNG
 * 
 * 			1. MouseListener								f�r bet�tigung der maustasten	&	betreten / verlassen des maus-zeigers
 * 
 * 			2. MouseMotionListener							f�r Mausbewegungen mit + ohne maustasten-bet�tigung
 * 
 * 			3. MouseWheelListener							f�r bewegungen des maus-rades
 * 
 * 
 * 		1. MOUSELISTENER - METHODEN:	
 * 
 * 			METHODE										BESCHREIBUNG
 *  
 * 			void mousePressed(MouseEvent evt)			wird beim dr�cken der maus-taste aufgerufen.
 * 
 * 			void mouseReleased(MouseEvent evt)			wird BEIM loslassen der maus-taste aufgerufen.
 * 
 * 			void mouseClicked(MouseEvent evt)			wird NACH dem loslassen der maus-taste aufgerufen.
 * 
 * 			void mouseEntered(MouseEvent evt) 			wird aufgerufen, wenn der maus-zeiger die betreffende komponente betritt.
 * 
 * 			void mouseExited(MouseEvent evt)			wird aufgerufen, wenn der maus-zeiger die betreffende komponente verl�sst.
 * 
 * 		
 * 		2. MOUSEMOTIONLISTENER - METHODEN:		
 * 
 * 			METHODE										BESCHREIBUNG
 * 
 *			void mouseMoved(MouseEvent evt)				wird aufgerufen, wenn der maus-zeiger ohne tasten-bet�tigung bewegt wurde.
 *
 *			void mouseDragged(MouseEvent evt)			wird aufgerufen, wenn der maus-zeiger mit gedr�ckter maus-taste bewegt wurde.
 * 
 * 
 * 		3. MOUSEWHEELLISTENER - METHODE:  
 * 
 * 			METHODE										BESCHREIBUNG
 * 
 * 			void mouseWheelMoved(MouseWheelEvent evt)	wird aufgerufen, wenn das maus-rad bewegt wurde.
 * 
 * 
 * 		MOUSEEVENT - METHODEN (zur auskunft �ber die ereignisse):
 * 
 * 					=> MouseListener & MouseMotionListener erstellen MouseEvents wenn ein Maus-ereigniss erfasst wird
 *  				=> MouseEvent evt ist ein objekt, dass vom Listener erstellt wird, um ein ereignis n�her zu beschreiben
 *  				=> die methoden von MouseEvent dienen zur auskunft �ber die eingetretenen ereignisse selbst
 *  
 * 			METHODE										BESCHREIBUNG
 * 			
 * 			int getButton()								gibt zur�ck auf welchen button sich das ereignis bezieht.
 * 			
 * 			Point getPoint()							liefert Objekt der klasse Point, mit den Koordinaten der maus-position, bezogen auf die ausl�sende komponente, zur�ck.
 * 
 * 			Point getLocationOnScreen()					liefert objekt der klasse Point, mit den koordinaten der maus-position, bezogen auf den bildschirm, zur�ck.
 * 
 * 			int getX()									liefert die x-koordinate der maus-position, bezogen auf die ausl�sende komponente, zur�ck.
 * 
 * 			int getXOnScreen()							liefert die x-koordinate der maus-position, bezogen auf den bildschirm, zur�ck.					
 * 
 * 			int getY()									liefert die y-koordinate der maus-position, bezogen auf die ausl�sende komponente, zur�ck.
 * 
 * 			int getYOnScreen()							liefert die y-koordinate der maus-position, bezogen auf den bildschirm, zur�ck.					
 * 
 * 			int getClickCount()							liefert die anzahl der hintereinander ausgef�hrten maus-clicks zur�ck.
 * 
 * 			boolean isAltDown()							
 * 			boolean isShiftDown()						liefert als wahrheitswert zur�ck, ob die jeweilige steuer-taste beim bet�tigen der maus-taste gedr�ckt war.
 *			boolean isControlDown()
 * 
 *			boolean isMetaDown()						liefert true, wenn die rechte maus-taste gedr�ckt wurde.
 * 
 * 
 * 		MOUSEWHEELEVENT - (zus�tzliche) METHODEN:
 * 
 * 					=> MouseWheelEvent sind evtl. etwas schwieriger zu handhaben als MouseEvents
 * 						-> denn sie beziehen sich oft:		-> nicht auf die komponente, auf der sich der maus-zeiger befindet w�hrend der mausrad-bet�tigung..
 * 															-> .. sondern auf die scrollbalken der komponente	 
 * 															-> .. oder auf die scrollbalken einer �bergeordneten komponente 
 * 
 * 					=> MouseWheelEvent ist von MouseEvent abgeleitet & hat folgende zus�tzlichen methoden:
 *  
 * 			METHODE										BESCHREIBUNG
 * 
 * 			int getScrollAmount()						liefert die anzahl der einheiten, um die gescrollt werdn soll, zur�ck.
 * 
 * 			int getScrollType()							liefert zur�ck, wie gescrollt werden soll (seitenweise oder in kleinen schritten).
 * 
 * 			int getWheelrotation()						liefert zur�ck, um wieviel klicks das rad gedreht wurde.
 * 
 * 
 */

package uebungen13;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class MouseEreignisse_Basics_Klassen_Methoden {

}
