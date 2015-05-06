/* TODO 14.2.4.   s.454, (extends JPanel implements	Runnable) ?????????????? !!!!!!!!!!!!!
 * class JBallPanel_Synchronized_Therads & 		_..BallAnimation
 * 		
 * 			SIEHE:
 * 
 * 	K&K:
 * 
 * 	BESONDERES: 
 * 
 * 		TOOLKIT - KOMPONENTE:		public abstract class Toolkit		java.awt.Toolkit
 *									extends Object
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
 *		IMAGE-OBSERVER:				public Interface ImageObserver		java.awt.image		
 *		(OBSERVER)					nachfolger von component
 *									
 *									An asynchronous update interface for receiving notifications about Image information as the Image is constructed.
 *
 *									der letzet parameter this (siehe BSP) verweist auf ein image-observer-objekt welches den aufbereitungvorgang von bildern �berwacht.
 *									es ist ein nachfolger von component. da in diesem fall auch das panel worin das image gezeichnet wird ein nachfolger von component ist 
 *									kann man mit this das panel als ImageObsberver angeben. ebenso kann man this f�r die abfragen der bildgr�ssen mit getWitdh() & getHeight() angeben. 
 *									dort w�ren z.b. auch fixe werte (in pixel) m�glich
 *
 *				METHODE:			boolean java.awt.Graphics.drawImage(Image img, int x, int y, int width, int height, ImageObserver observer)
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

	public synchronized void paintComponent(Graphics g) {	// �berschreiben von paintComponent(..) damit auf dem panel das bild gezeichnet werden kann
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
			synchronized (this) {							// synchronized kommentieren !!!!!!!!!!!!!!!
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
			}
			repaint();										// sobald das jeweils neue x bekannt ist kann das bild ge-repainted werden (via paintComponent wo das x f�r drawImage(..) verwendet wird)
			try {											// therad-speziefische anweisungen immer innerhalb von try-catch
				Thread.sleep(20);							// Thread schlafen legen hier f�r 20 milisekunden, je nach wert ergeben sich fl�ssige bewegungsabl�ufe => ausprobieren 
			} catch (InterruptedException e) {				// Thread-spez. exception-handlicng
				break;										// bei fehler von sleep einfach raus aus dem block und weiter in der endlos schleife ????????????????????????????????????????
			}												// .. warum hier ein break und z.b. in den beispielen mit ampelsteuerung nicht?		(bis jetzt keine def. antwort)
		}
		
	}

}
