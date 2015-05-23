/* TODO 14.2.4.   s.454, (extends JPanel implements	Runnable) !!!!!!!!!!!!!
 * class	JBallPanel_Synchronized_Therads		& 	Threads_Synchronized_Interrupt_Bewegungsablauf_BallAnimation
 * 		
 * 			SIEHE:			14.2.3.   		Synchronisation_VonThreads_Problematik_Begriff_Synchronized_Modifier		s.453,
 * 
 * 			!!!!! HIER WEITER ALLES KOMMENTIEREN	!!!!!!!!!!!!!!!!!!
 * 
 * 
 * 	K&K:	KLASSE JBallPanel_..:	 
 * 
			 * Klasse JBallPanel (von der Klasse JPanel abgeleitet)
			 * Die Klasse stellt einen Ball zur Demonstartion von
			 * Bewegungsabl�ufen dar. Der Ball wird aus einer Bilddatei
			 * eingebunden.
 * 
 * 			PROGRAMM .._BallAnimation:		
 * 
 *			 * Programm Ballanimation (verwendet die Komponente JBallPanel)
 *			 * Das Programm demonstriert die Erstellung von
			 * Bewegungsabl�ufen. Der Ball als JBallPanel eingebunden.
			 * eingebunden.
 * 
 * 	VORGEHEN:
 * 		
 * 		KLASSE JBallPanel_..:
 * 
 * 		PROGRAMM .._BallAnimation:		inklusive eigene kleine fehlerbehebung der buchversion 
 * 		
 * 
 * 	WINDOWLISTENER - FRAME-EVENT-HANDLING:		 siehe unten:		=> THREAD SAUBER UNTERBRECHEN MIT INTERRUPT()
 * 
 * 
 *  THREAD SAUBER UNTERBRECHEN MIT INTERRUPT(), EGAL IN WELCHEM STATUS DER THREAD GERADE IST (sleep() etc.) & SP�TESTENS BEIM FRAME-SCHLIESSEN MITTELS WINDOWLISTENER:
 * 
 *  		=> Thread beenden innerhalb eines programms:		t.interrupt()			=> um Thread-objekt t anzuhalten (Thread t = new Thread(..))
 *  																					=> ist wie t.stop() was es aber f�r thread nicht gibt (bzw. nicht erlaubt ist)
 * 		
 * 			=> PROBLEM:		Falls der Thread z.b. mittels eines Buttons mit event-handling gestoppt werden soll & dann der button nicht bet�tigt wird, das frame aber geschlossen:
 * 							-> ein gestarteter zus�tzlicher thread der nicht angehalten wurde, l�uft beim schliessen eines frames einfach weiter
 * 							-> siehe console: roter stop-knopf der leuchtet weiter,  also l�uft das programm im hintergrund noch
 * 
 * 			=> L�SUNG:		thread anhalten mittels EventHandling beim schliessen des frames
 * 
 * 							=> im JIGLOO:					Frame selber anw�hlen > Outline > Events > WindowListener > windowClosed > auf handler method 
 * 
 * 							=> in der handler method: 		t.interrupt();							// um Thread-objekt t anzuhalten
 * 	
 * 			=> BSP:
 * 
 *			 	private void initGUI() {
 *					try {
 *						..
 *						this.addWindowListener(new WindowAdapter() {		// neuer WindowListener f�rs frame..
 *							public void windowClosed(WindowEvent evt) {		// .. mit handler methode f�r EventHandling bei windowClosed (wenn fenster geschlossen)
 *								thisWindowClosed(evt);
 *							}
 *						});
 *	 			
 *	  			
 *				private void thisWindowClosed(WindowEvent evt) {			// event handler method f�r wenn das frame geschlossen wurde ohne dass zuvor der Thread angehalten ist.
 *					t.interrupt();											// thread sicher anhalten (nach fensterschliessen) (falls er nicht schon vorher	angehalten wurde)	
 *				}		
 * 
 * 
 * 
 * 	SYNCHRONIZED MODIFIER: 
 * 
 * 		=> der modifier synchronized ist eine massname von java gegen probleme bei parallel ablaufenden Anweisungsfolgen bei Threads
 * 
 * 		=> mit synchronized kann man sicherstellen, dass die dadurch gesch�tzten bereiche, zu einem zeitpunkt nur von einem Thread ausgef�hrt werden.
 * 		   		-> dies gilt aber nur, wenn sie f�r das gleiche objekt / instanz (hier der klasse JBallPanel_.. ) aufgerufen werden.
 * 				-> der erste thread, der den zugriff erh�lt, setzt eine sperre, der allf�llige zweite thread muss warten bis die sperre wieder aufgehoben ist
 * 
 * 				=> es m�ssen alle bereiche mit synchronized gesch�tzt werden die nicht zeitgleich von verschiedenen threads bearbeitet werden d�rfen (hier am bsp. variable x)
 * 
 * 					-> BSP hier:	=> 2 bereiche in denen auf die gleiche variable x zugegriffen wird:
 * 
 * 										[ NB:	Attribut-deklaration:		public int x;							=> warum nicht private; evtl. spezieller umgang wegen synchronized ???????????? ]
 * 
 * 
 * 										1. f�r die gesammte paintComponent-methode()						=> geh�rt zum normalen (ersten) programm-ablaufs-thread 
 * 
 *											 	public synchronized void paintComponent(Graphics g) {			// synchronized f�r ganze methode 
 *													..						
 *													g.drawImage(img, x, ..);									// auf variable x soll nur von einem thread auf's mal zugegriffen werden
 *												}
 * 
 * 
 * 										2. in der metode run() vor einem einfachen anweisungsblock			=> run() wird ja von zus�tzlichen (zweiten) thread verwendet
 * 
 * 												SCHEMA:  synchronized (this) {..}							=> wenn der modifier nicht im kopf einer methode benutzt wird
 * 
 *												public void run() {												// methode run() auf die der zus�tzliche Thread zur�ckgreift
 *													while (..) {									
 *														synchronized (this) {									// synchronized (this)  -> nur f�r den anweisungs-block wo x bearbeitet wird		
 *															if (x > getWidth() - img.getWidth(this)) {			// .. (this) => f�r das instanz-objekt dieser klasse 							
 *																..							
 *															}
 *														}														// synchronized fertig 
 *														..														// die folgenden abweisungen bearbeiten x nicht, m�ssen also nicht synchronized werden
 *													}
 *												} 
 * 
 *  
 * 	INTERRUPTEDEXCEPTION MIT BREAK; :	noch schreiben				
 * 											
 *  
 *  ANIMATION - ENDLOS-WHILE-SCHLEIFE:	noch schreiben
 *  
 *  
 * 
 * 	BESONDERES: 
 * 
 * 		TOOLKIT - KOMPONENTE:		public abstract class Toolkit		java.awt.Toolkit
 *		(IMAGE VON DATEI LADEN)		extends Object
 *										
 *									This class is the abstract superclass of all actual implementations of the Abstract Window Toolkit. 
 *									Subclasses of the Toolkit class are used to bind the various components to particular native toolkit implementations. 
 *
 * 
 * 				METHODEN:			getDefaultToolkit()				der Komponente Toolkit
 * 									getImage(url) 					der Komponente Toolkit		
 * 
 * 				BSP:				img = Toolkit.getDefaultToolkit().getImage(						// bild aus der datei (= mit url) in die Image-variable img einlesen, unter  ..
 *												"." + File.separator + "ball.jpg"); 				// .. verwendung der methode getImage(url) der komponente Toolkit
 *
 *
 *
 *		IMAGE-OBSERVER:				public Interface ImageObserver		java.awt.image		
 *		(OBSERVER)					nachfolger von component
 *		(drawImage())				
 *									An asynchronous update interface for receiving notifications about Image information as the Image is constructed.
 *
 *									der letzet parameter this (siehe BSP) verweist auf ein image-observer-objekt welches den aufbereitungvorgang von bildern �berwacht.
 *									es ist ein nachfolger von component. da in diesem fall auch das panel worin das image gezeichnet wird ein nachfolger von component ist 
 *									kann man mit this das panel als ImageObsberver angeben. ebenso kann man this f�r die abfragen der bildgr�ssen mit getWitdh() & getHeight() angeben. 
 *									dort w�ren z.b. auch fixe werte (in pixel) m�glich
 *
 *				METHODE:			boolean java.awt.Graphics.		drawImage(Image img, int x, int y, int width, int height, ImageObserver observer)
 *
 *				BSP:				g.drawImage(img, x, getHeight()/2 - img.getHeight(this)/2, img.getWidth(this), img.getHeight(this), this);	
 * 
 */

package uebungen14;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;

import javax.swing.JPanel;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class JBallPanel_Synchronized_Therads extends JPanel implements Runnable {	// implements Runnable damit man einen weiteren Thread erzeugen kann [run() �berschreiben zwangsl�ufig]
	
	public int x = 0;										// attribut x public wahrscheinlich weil klassen der thread-synchronisation darauf zugreifen m�ssen um den zustand zu pr�fen ?????????
	private Image img;										// variable f�r das zu ladeende bild ball.jpg
	private boolean vor = true;								// boolescher wert f�r die aktuelle bewegungsrichtung des ball-bildes
	
	public JBallPanel_Synchronized_Therads() {				// konstruktor des konstruktors der klasse JBallPanel_Synchronized_Therads
		super();
		setBackground(Color.white);							// hintergrundfarbe des panels via superklasse auf weiss setzen ( entspricht der hintergrundfarbe des ball.jpg bildes)
		img = Toolkit.getDefaultToolkit().getImage(			// bild aus der datei (= mit url) in die Image-variable img einlesen, unter verwendung der methode getImage(url) & ..
				"." + File.separator + "images" + File.separator + "Ball.jpg"); 	// .. getDefaultToolkit() der komponente Toolkit
	}

	public synchronized void paintComponent(Graphics g) {	// �berschreiben von paintComponent(..) damit auf dem panel das bild gezeichnet werden kann, synchronized f�r ganze methode
		super.paintComponent(g);							// aufruf der superclss methode paintComponent unter mitgabe des graphic-objekts g
		g.drawImage(img, x, 								// via methode drawImage von Graphics-objekt g: bild zeichnen mit parameter: image-variable, koordinaten-position x (= variable x von ..
					getHeight()/2 - img.getHeight(this)/2,  // .. oben), position y (halbe panel-h�he minus halbe bild-h�he), breite des bildes, h�he des bildes, 
					img.getWidth(this), img.getHeight(this), this);	// der letzet parameter this verweist auf ein image-observer-objekt welches den aufbereitungvorgang von bildern �berwacht..
	}														// ..(es ist ein nachfolger von component). da auch das panel ein nachfolger von component ist kann man mit this das panel als ..
															// ..ImageObsberver angeben. ebenso kann man this f�r die abfragen der bildgr�ssen mit getWitdh() & getHeight() angeben. dort..
															// .. w�ren auch fixe werte m�glich
	
	
	@Override												// in java 7 noch freiwillige �berschreib-deklaration
	public void run() {										// zwangsl�ufiges �berschreiben der methode run() (bei implementieren von Runnable) auf die der Thread zur�ckgreifen wird: ..
															// .. sorgt daf�r dass die paintComponent-methode f�r die zeichenvorg�nge st�ndig neue positionskoordinaten erh�lt ..
															// .. (bewegung nur f�r die x-koordinate vorgesehen, y-koordinate wird nicht bearbeitet)
		while (true) {										// enlosschleife
			synchronized (this) {							// synchronized (this) nur f�r den anweisungs-block wo x bearbeitet wird,	(this) => f�r das instanz-objekt dieser klasse 
				if (x > getWidth() - img.getWidth(this)) {	// wenn x (li oben horizontal koordinate des bildes) gr�sser als panelbreite - bildbreite (=> li rand des panelsvcwird erreicht)..
					vor = false;							// .. wird der boolsche wert auf false, bzw. auf r�ckw�rtsbewegen umgestellt
				} else if (x <= 0) {						// sonst wenn x kleiner gleich 0 ist ..
					vor = true;								// .. wird der boolsche wert auf true, bzw. auf vorw�rtsbewegen umgestellt
				}
				if (vor) {									// wenn vorw�rtsbewegung ..
					x += 2;									// wird x um 2 px erh�ht
				} else {									// sonst
					x -= 2;									// wird x um 2 px verkleinert
				}
			}												// synchronized fertig 
			repaint();										// sobald das jeweils neue x bekannt ist kann das bild ge-repainted werden (via paintComponent wo das x f�r drawImage(..) verwendet wird)
			try {											// therad-speziefische anweisungen immer innerhalb von try-catch
				Thread.sleep(20);							// Thread schlafen legen hier f�r 20 milisekunden, je nach wert ergeben sich fl�ssige bewegungsabl�ufe => ausprobieren 
			} catch (InterruptedException e) {				// Thread-spez. exception-handlicng
				break;										// break ist wichtig (sonst funktioniert's nicht sauber) !! bei fehler von sleep einfach raus aus dem block und weiter in der endlos schleife ?!!
			}												// .. warum hier ein break und z.b. in den beispielen mit ampelsteuerung nicht?		(bis jetzt keine def. antwort)
		}
		
	}

}
