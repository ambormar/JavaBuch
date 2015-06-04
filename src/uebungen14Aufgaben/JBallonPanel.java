/* TODO 14.3.5.   Aufgabe 5 + 6,   s.460/461, (extends JPanel) analog JBallPanel
 * class 	JBallonPanel		&		.._Ballonfangen
 * 
 * K&K:
 * 		Klasse JBallonPanel:		 (Musterlösung zu Kapitel 14 Aufgabe 5)
 * 			Die Klasse ist von der Klasse JPanel abgeleitet.
 * 			Die Klasse stellt einen Ball zur Demonstration von Bewegungsabläufen dar. 
 * 			Der Ballon wird aus zwei Bilddateien eingebunden. Ein Bild stellt den intakten Ballon dar. Das zweite Bild wird verwendet, um den Ballon beim Zerplatzen darzustellen.
 * 
 * 				- an klasse JBallPanel orientieren beim implementieren
 * 				- Panel soll eineen Ballon an zufälliger position des Panel zeichnen
 * 				- die komponente soll das interface Runnabel implementieren & eine run()-methode bereitstellen, die von einem thread genutzt werden kann
 * 				- run() -methode soll in einem einstellbaren zeitintervall die position des ballons nach zufallsprinzip ändern
 * 						-> zufallszahl mit:			java.util.random()					siehe:	=> ZUFALLSZAHLEN / RANDOM
 * 								
 * 
 * 		Programm Ballonfangen:		 (Musterlösung zu Kapitel 14 Aufgabe 6)
 * 			Das Programm verwendet die Komponente JBallonPanel.
 * 			Das Programm demonstriert in Form eines kleinen Spiels. 
 * 
 * 
 *  ZUFALLSZAHL / RANDOM:		java.util.random()			
 * 								
 * 			KONSTRUKTOREN:		Random() 						beim konstruktor ohne parameter wird die systemzeit zur initialisierung verwendet	(anmerkg.:	anstelle von unten: seed)
 * 
 * 								Random(long seed)				der wert von seed gibt die startbedingungen vor. werden 2 objekte mit dem gleichen seed-wert erzeugt, 
 * 																liefern sie die gleichen zufälligen zahlenfolgen
 * 
 * 			METHODEN:			int nextInt()					liefert zufallszahlen vom typ int 
 * 								int nextInt(int n)				liefert zufallszahlen vom typ int von 0 bis n-1
 * 								long nextLong()					liefert zufallszahlen vom typ long 
 * 								float nextFloat()				liefert zufallszahlen vom typ float & liefert zahlwerte zwischen >=0 und <1		(also 0,irgendwas)
 * 								double nextDouble()				liefert zufallszahlen vom typ double & liefert zahlwerte zwischen >=0 und <1	(also 0,irgendwas)
 * 
 * 
 * 
 */

package uebungen14Aufgaben;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.util.Random;

import javax.swing.JPanel;

public class JBallonPanel extends JPanel implements Runnable{			// implements Runnable damit man einen weiteren Thread erzeugen kann [run() überschreiben zwangsläufig]
	
	private Image[] img;												// Image array deklarieren für die bilder
	private int x, y;													// x, y - koordinaten für die bild-anzeige im panel (in der Komponente
	private int anzeigedauer = 750;										// dauer in millisek während der, der ballon angezeigt wird bevor er an einem neuen ort angezeigt wird
	private int ballonZaehler = 0;
	
	public JBallonPanel() {
		super();
		img = new Image[2];												// image array für 2 bilder erzeugen
		setBackground(Color.WHITE);										// hintergrundfarbe des panels via superklasse auf weiss setzen ( entspricht der hintergrundfarbe des ball.jpg bildes)
		img[0] = Toolkit.getDefaultToolkit().getImage(					// bild ball.jpg aus der datei (= mit url) in die Image-array-variable img[0]  einlesen, unter verwendung der methode  ..
				"." + File.separator + "images" + File.separator + "Ball.jpg");		// .. getImage(url) & getDefaultToolkit() der komponente Toolkit
		img[1] = Toolkit.getDefaultToolkit().getImage(					// bild ball2.jpg aus der datei (= mit url) in die Image-array-variable img[1]  einlesen, unter verwendung der methode  ..
				"." + File.separator + "images" + File.separator + "Ball2.jpg");	// .. getImage(url) & getDefaultToolkit() der komponente Toolkit
		//Random rand = new Random();										// Random-objekt erzeugen; 						????????? breaucht's glaub gar nicht ???????????????????????????????????????
		x = -100;														// position x koordinate initialisieren mit deutlich ausserhalb des sichtbaren bereichs
		y = -100;														// position y koordinate initialisieren mit deutlich ausserhalb des sichtbaren bereichs
	}
	
	public synchronized void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img[0], x, y, this);
		
	}

	@Override															// in java 7 noch freiwillige überschreib-deklaration
	public void run() {													// zwangsläufiges überschreiben der methode run() (bei implementieren von Runnable) auf die der Thread zurückgreifen wird
		while (true) {													// endlos-schleife mit option auf abbrechen des laufenden vorgangs (+ wiederstarten) durch setzen der bedingung 
			synchronized (this) {										// x, y- koordinaten werden an 2 orten bearbeitet vom gleichen thread-objekt 
				Random rand = new Random();
				x = rand.nextInt(this.getWidth() - img[0].getWidth(this));
				y = rand.nextInt(this.getHeight() - img[0].getHeight(this));
				ballonZaehler++;
			}
			repaint();
			try {
				Thread.sleep(anzeigedauer);
			} catch (InterruptedException e) {
				break;
			}
		}
		
	}

	public int getBallonZaehler() {										// getter um anzahl ballbewegungen zu erfragen
		return ballonZaehler;
	}

	public void resetBallonZaehler() {									// setter um ballonzaehler auf null zu setzen
		ballonZaehler = 0;
	}
	
	

}
