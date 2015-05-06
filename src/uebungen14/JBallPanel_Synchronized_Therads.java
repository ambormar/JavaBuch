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
 *									der letzet parameter this (siehe BSP) verweist auf ein image-observer-objekt welches den aufbereitungvorgang von bildern überwacht.
 *									es ist ein nachfolger von component. da in diesem fall auch das panel worin das image gezeichnet wird ein nachfolger von component ist 
 *									kann man mit this das panel als ImageObsberver angeben. ebenso kann man this für die abfragen der bildgrössen mit getWitdh() & getHeight() angeben. 
 *									dort wären z.b. auch fixe werte (in pixel) möglich
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

public class JBallPanel_Synchronized_Therads extends JPanel implements Runnable {	// implements Runnable damit man einen weiteren Thread erzeugen kann [run() überschreiben zwangsläufig]
	
	public int x = 0;										// attribut x public wahrscheinlich weil klassen der thread-synchronisation darauf zugreifen müssen um den zustand zu prüfen ?????????
	private Image img;										// variable für das zu ladeende bild ball.jpg
	private boolean vor = true;								// boolescher wert für die aktuelle bewegungsrichtung des ball-bildes
	
	public JBallPanel_Synchronized_Therads() {				// konstruktor des konstruktors der klasse JBallPanel_Synchronized_Therads
		super();
		setBackground(Color.white);							// hintergrundfarbe des panels via superklasse auf weiss setzen ( entspricht der hintergrundfarbe des ball.jpg bildes)
		img = Toolkit.getDefaultToolkit().getImage(			// bild aus der datei (= mit url) in die Image-variable img einlesen, unter verwendung der methode getImage(url) & ..
				"." + File.separator + "images" + File.separator + "Ball.jpg"); 	// .. getDefaultToolkit() der komponente Toolkit
	}

	public synchronized void paintComponent(Graphics g) {	// überschreiben von paintComponent(..) damit auf dem panel das bild gezeichnet werden kann
		super.paintComponent(g);							// aufruf der superclss methode paintComponent unter mitgabe des graphic-objekts g
		g.drawImage(img, x, 								// via methode drawImage von Graphics-objekt g: bild zeichnen mit parameter: image-variable, koordinaten-position x (= variable x von ..
					getHeight()/2 - img.getHeight(this)/2,  // .. oben), position y (halbe panel-höhe minus halbe bild-höhe), breite des bildes, höhe des bildes, 
					img.getWidth(this), img.getHeight(this), this);	// der letzet parameter this verweist auf ein image-observer-objekt welches den aufbereitungvorgang von bildern überwacht..
	}														// ..(es ist ein nachfolger von component). da auch das panel ein nachfolger von component ist kann man mit this das panel als ..
															// ..ImageObsberver angeben. ebenso kann man this für die abfragen der bildgrössen mit getWitdh() & getHeight() angeben. dort..
															// .. wären auch fixe werte möglich
	
	
	@Override												// in java 7 noch freiwillige überschreib-deklaration
	public void run() {										// zwangsläufiges überschreiben der methode run() (bei implementieren von Runnable) auf die der Thread zurückgreifen wird: ..
															// .. sorgt dafür dass die paintComponent-methode für die zeichenvorgänge ständig neue positionskoordinaten erhält ..
															// .. (bewegung nur für die x-koordinate vorgesehen, y-koordinate wird nicht bearbeitet)
		while (true) {										// enlosschleife
			synchronized (this) {							// synchronized kommentieren !!!!!!!!!!!!!!!
				if (x > getWidth() - img.getWidth(this)) {	// wenn x (li oben horizontal koordinate des bildes) grösser als panelbreite - bildbreite (=> li rand des panelsvcwird erreicht)..
					vor = false;							// .. wird der boolsche wert auf false, bzw. auf rückwärtsbewegen umgestellt
				} else if (x <= 0) {						// sonst wenn x kleiner gleich 0 ist ..
					vor = true;								// .. wird der boolsche wert auf true, bzw. auf vorwärtsbewegen umgestellt
				}
				if (vor) {									// wenn vorwärtsbewegung ..
					x += 2;									// wird x um 2 px erhöht
				} else {									// sonst
					x -= 2;									// wird x um 2 px verkleinert
				}
			}
			repaint();										// sobald das jeweils neue x bekannt ist kann das bild ge-repainted werden (via paintComponent wo das x für drawImage(..) verwendet wird)
			try {											// therad-speziefische anweisungen immer innerhalb von try-catch
				Thread.sleep(20);							// Thread schlafen legen hier für 20 milisekunden, je nach wert ergeben sich flüssige bewegungsabläufe => ausprobieren 
			} catch (InterruptedException e) {				// Thread-spez. exception-handlicng
				break;										// bei fehler von sleep einfach raus aus dem block und weiter in der endlos schleife ????????????????????????????????????????
			}												// .. warum hier ein break und z.b. in den beispielen mit ampelsteuerung nicht?		(bis jetzt keine def. antwort)
		}
		
	}

}
