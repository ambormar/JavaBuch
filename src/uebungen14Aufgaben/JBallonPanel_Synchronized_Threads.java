/* TODO 14.3.5.   Aufgabe 5 + 6,   s.460/461, (extends JPanel) analog JBallPanel
 * class 	JBallonPanel_Synchronized_Threads		&		Threads_Synchronized_Interrupt_MouseEvent_SpielAnimation_BallonFangen
 * 
 * 		VERGLEICHE:		14.2.4.   JBallPanel_Synchronized_Therads		& 	Threads_Synchronized_Interrupt_Bewegungsablauf_BallAnimation		s.454, 
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
 * 				- JBallonPanel startet die run()-Methode als thread
 * 				- schafft es der anwender, den an zufälligen positionen gezeichneten ballon anzuklicken, wird ein treffer im label hochgezählt
 * 					& für einen kleinen augenblick ein explodierender ballon angezeigt
 * 				- über die button neu / stop kann ein neues spile angefangen oder das spiel gestoppt werden, die labeltexte werden entsprechend angepasst
 * 				- nach schliessen des frames wird der zusätzliche thread gestoppt, damit die console nicht weiterläuft
 * 
 * 
 * 	VORGEHEN:
 * 		
 * 		KLASSE JBallONPanel:
 * 
 * 			-> Die Klasse dient der Darstellung eines ballonfang-spiels innerhalb des jPanels.
 * 			-> die positions-koordinate x,y des ballons & der array-index für's bild,müssen synchronisiert werden, da sie in 2 verschiedenen Threads verwendet wird (+ konflikte entstehen könnten) 
 * 
 * 			=> KLASSE JBallonPanel von der Komponente JPanel abgeleitet, um sie im aufrufenden programm .._BallonFangen anstelle eines standard-jpanels einsetzen zu können
 * 
 * 			=> Klasse mit implements Runnable erweitern, um dann im run() einen zusätzlichen Thread anlegen zu können
 * 				
 * 					BSP:	public class JBallonPanel extends JPanel implements Runnable {..			// implementieren von Runnable zwingt zum überschreiben von run() (der klasse Runnable)
 * 
 * 			=> fields: 		private int bildNr = 0;											// variable für den array-index des anzuzeigenden bildes  (hier auf index 0 => ball.jpg )
 *							private Image[] img;											// Image array deklarieren für die bilder
 *							private int x, y;												// x, y - koordinaten für die bild-anzeige im panel (in der Komponente
 *							private int anzeigedauer = 1000;								// dauer in millisek während der, der ballon angezeigt wird bevor er an einem neuen ort angezeigt wird
 *							private int ballonZaehler = 0;									// variable zum zählen wie oft der ballon neu angezeigt wurde
 * 
 * 
 * 			=> konstruktor überschreiben:													
 * 				[NB:  wieso diese anweisungen im konstruktor?: 	-> anweisungen müssen ja irgendwo / in einer methode stehen, hier halt im konstruktor]
 * 				-> hintergrundfarbe des panels auf hintergrundfarbe des einzulesenden ball-bildes abstimmen
 * 				-> image array img mit 2 elemnten erzeugen
 * 				-> ball-bilder aus der datei in die array-elemente img[0] /[1] einlesen, unter verwendung von .getImage der komponente toolkit			=> siehe unten: BESONDERES TOOLKIT
 * 				-> x y vorläufig auf ausserhalb des panelbereichs initialisieren
 *
 *					public JBallonPanel() {
 *						super();
 *						img = new Image[2];															// image array für 2 bilder erzeugen
 *						setBackground(Color.WHITE);													// hintergrundfarbe des panels via superklasse auf weiss setzen ( entspricht der hintergrundfarbe des ball.jpg bildes)
 *						img[0] = Toolkit.getDefaultToolkit().getImage(								// bild ball.jpg aus der datei (= mit url) in die Image-array-variable img[0]  einlesen, unter verwendung der methode  ..
 *								"." + File.separator + "images" + File.separator + "Ball.jpg");		// .. getImage(url) & getDefaultToolkit() der komponente Toolkit
 *						img[1] = Toolkit.getDefaultToolkit().getImage(								// bild ball2.jpg aus der datei (= mit url) in die Image-array-variable img[1]  einlesen, unter verwendung der methode  ..
 *								"." + File.separator + "images" + File.separator + "Ball2.jpg");	// .. getImage(url) & getDefaultToolkit() der komponente Toolkit
 *						..
 *						x = -100;																	// position x koordinate initialisieren mit deutlich ausserhalb des sichtbaren bereichs
 *						y = -100;																	// position y koordinate initialisieren mit deutlich ausserhalb des sichtbaren bereichs
 *					} 
 *							
 * 			=> paintComponent-methode der superklasse überschreiben, damit die änderungen der komponente (panel) jeweils neugezeichnet werden bei frame-veränderungen
 * 				-> synchronized für ganze methode  					-> um das verwenden der variablen x, y und bildNr zu synchronisieren, die auch im zusätzlichen thread verwendet wird  [siehe run()]
 * 				-> zeichnen des bildes mit drawImage von Graphics	-> koordinate x, y verändert sich & bildNr kann sich verändern
 * 				[NB: -> der letzte parameter this verweist auf ein image-observer-objekt			-> siehe kommentar  & unten BESONDERES: IMAGE-OBSERVER]
 * 				-> bildNr jeweils gleich wieder auf 0 (ball.jpg) setzen, denn wenn ball2.jpg eingeblendet wird soll das nur für einen kurzen moment sein
 * 
 *					public synchronized void paintComponent(Graphics g) {						// überschreiben von paintComponent(..) damit auf dem panel das bild gezeichnet werden kann, synchronized für ganze methode wegen bearbeieten von x, y & bildNr
 *						super.paintComponent(g);												// aufruf der superclass methode paintComponent unter mitgabe des graphic-objekts g
 *						g.drawImage(img[bildNr], x, y, 											// via methode drawImage von Graphics-objekt g: bild zeichnen mit parameter: image-variable, koordinaten-position x, y,..
 *								img[bildNr].getWidth(this), img[bildNr].getHeight(this), this);	// .. breite des bildes, höhe des bildes, der letzte parameter für image-observer-objekt ist this , verweist also auf diese komponente selbst
 *						bildNr = 0; 															// bildNr jeweils gleich wieder auf ball.jpg setzen, denn wenn ball2.jpg eingeblendet wird soll das nur für einen kurzen moment sein
 *					}
 *	 
 *
 * 			=> zwangsläufiges überschreiben der run()-methode von Runnable für die anweisungen des zusätzlichen Threads
 * 				-> sorgt dafür, dass paintCompoonent für die zeichenvorgänge ständig neue x, y -positionskoordinaten  erhält 
 * 				-> unter verwendung von synchronized nur für den anweisungsblock, wo die variablen x, y & bildNr bearbeitet werden, welche in 2 verschiedenen Threads verwendet wird
 * 				-> mit endlos while-schleife mit ..:							
 * 					1. .. synchronisiertem anweisungs-block wo x, y & bildNr bearbeitet werden 		-> x und y zufallszahlen innerhalb des panels mittels random zuweisen
 * 																									-> ballonzaehler kontinuierlich vergrössern 
 * 					2. .. repaint() sobald das jeweils neue x, y bekannt ist						-> damit das bild jeweils ge-repainted werden kann (ruft ja  paintComponent() auf)
 * 					3. .. Thread.sleep(anzeigedauer)	in try- block								-> steuert die geschwindigkeit der ballon-anzeige
 * 					&  .. break; 			in catch-block											-> WICHTIGST: ausstieg aus exception-handlinng bei fehler (z.b.: laufzeitfehler?) 
 * 
 *					@Override															// in java 7 noch freiwillige überschreib-deklaration
 *					public void run() {													// zwangsläufiges überschreiben der methode run() (bei implementieren von Runnable) auf die der Thread zurückgreifen wird
 *						while (true) {													// endlos-schleife mit option auf abbrechen des laufenden vorgangs (+ wiederstarten) durch setzen der bedingung 
 *							synchronized (this) {										// ganzer block synchronized weil x, y- koordinaten & bildNr (index vom array img) werden an 2 orten bearbeitet vom gleichen thread-objekt 
 *								Random rand = new Random();								// randomobjekt für zufallszahlen
 *								x = rand.nextInt(this.getWidth() - img[0].getWidth(this));	// für x eine zufallszahl ab 0 bis panelbreite minus bildbreite, jeweils mit imageObserver this
 *								y = rand.nextInt(this.getHeight() - img[0].getHeight(this));// für y eine zufallszahl ab 0 bis panelhöhe minus bildhöhe, jeweils mit imageObserver this
 *								ballonZaehler++;										// je durchlauf der ballonanzeige den zaehler eins erhöhen
 *								anzeigedauer = rand.nextInt(1500) + 500;				// anzeigedauer nach zufallszahl auf zwischen 0.5 und 2 sek setzen
 *							}
 *							repaint();													// sobald die jeweils neuen x, y bekannt sind kann das bild ge-repainted werden (via paintComponent)
 *							try {														// therad-speziefische anweisungen immer innerhalb von try-catch
 *								Thread.sleep(anzeigedauer);								// Thread schlafen legen für anzeigedauer millisek
 *							} catch (InterruptedException e) {							// Thread-spez. exception-handlicng
 *								break;													// break ist WICHTIG (sonst funktioniert's nicht sauber) !! bei fehler von sleep einfach raus aus dem block und weiter in der endlos schleife ?!!
 *							}
 *						}
 *					} 
 *					
 *			=> alle nötigen getter und settter für zugriff auf die variablen vom programm .._BallonFangen aus:
 *				
 *					-> siehe code unten
 *
 *
 *
 * 	VORGEHEN FORTSETZUNG:
 * 			
 * 		PROGRAMM .._BallonFangen:	
 * 
 *			=> .._BallonFangen extends JFrame 
 *
 *			=> Fields:		private JBallonPanel jPanel1;										// JPanel ersetzen durch custom-klasse JBallonPanel mit name jPanel1
 *							private JLabel jLTreffer;											// label um die erzielten treffer anzuzeiegn
 *							private Thread t;													// Thread instanz t deklarieren
 *							private int treffer = 0;											// variable für die erreichten treffer
 *							...
 *							
 *	  		=> JBallonPanel (jPanel1) anstelle eines standard-JPanels für die darstellung des BallonFang-spiels  	(im JFrame mit ankerlayout)
 *
 * 							jPanel1 = new JBallonPanel();
 * 
 *	  		=> JButton Neu mit handler-methode zum starten des Threads (= starten des spiels)
 *				-> inklusive eigene kleine fehlerbehebung der buchversion:				if (t == null) {..}			-> vom zusätzlichen thread soll sich nur EINE INSTANZ erzeugen lassen
 *				-> Thread-objekt erzeugen mit parameter Runnable Target (jPanel1)		t = new Thread(jPanel1);	-> (=> konstruktor erzeugt einen Thread, der die run-methode von target ausführt)					
 *				-> & starten des Threads												t.start();	
 *	  		
 *				 	private void jBtnNeuActionPerformed(ActionEvent evt) {			// handler method jBtn Neu um neues spieli zu starten
 *						if (t == null){												// verhindern, dass der zusätzliche thread mehrfach erzeugt (wird und das tempo des spielis spinnt)
 *							t = new Thread(jPanel1);								// thread-objekt erzeugen mit parameter Runnable Target (jPanel1) (=> konstruktor erzeugt einen Thread, der die run-methode von target ausführt)
 *							t.start();												// .. thread starten & somit spiel starten	
 *							jPanel1.resetBallonZaehler();							// beim neu starten des spiels ballonzähler reseten
 *							treffer = 0;											// beim neu starten des spiels treffer auf 0 setzen
 *							jLTreffer.setText("Treffer: " + treffer + " von " + jPanel1.getBallonZaehler() + " Ballons");		// trefferlabel text erneuern
 *						}
 *						
 *					} 
 *
 *
 *			=> JButton Stop mit handler-methode zum stoppen des Threads (= stoppen des spiels)
 *				-> thread anhalten mit											t.interrupt();		-> stop() gibt's nicht bzw. ist nicht erlaubt
 *				-> inklusive eigene kleine fehlerbehebung der buchversion:		t = null;			-> EINZIGE INSTANZ vom zusätzlichen thread bei stop auf null setzen (= löschen), sodass .. 
 *																										.. man mit dem startbutton immer nur wieder EINE INSTANZ vom zusätzlichen thread erzeugen
 *					private void jBtnStoppActionPerformed(ActionEvent evt) {											// handler method jBtn Stop um spieli zu stoppen
 *						jLTreffer.setText("Treffer: " + treffer + " von " + jPanel1.getBallonZaehler() + " Ballons");	// labeltext aktualisieren
 *						t.interrupt();																					// laufenden thread t unterbrechen
 *						t = null;																						// fehlerbehebung (buchversion) EINZIGE INSTANZ vom zusätzlichen thread auf null setzen (= löschen), .. 
 *					} 																									// .. sodass man mit dem Neu-button immer nur wieder EINE INSTANZ vom zusätzlichen thread erzeugt
 * 
 *			=> eventhandling & handler method für wenn das frame geschlossen wurde ohne dass zuvor der Thread angehalten ist. sonst läuft der thread einfach weiter (siehe console roter knopf) 
 *				-> neuen WindowListener fürs frame erzeugen im initGUI() 
 *	 						
 *					this.addWindowListener(new WindowAdapter() {		// neuer WindowListener fürs frame..
 *						public void windowClosed(WindowEvent evt) {		// .. mit handler methode für EventHandling bei windowClosed (wenn fenster geschlossen)
 *							thisWindowClosed(evt);
 *						}
 *					});
 *					
 *				-> handler method mit stoppen des threads	
 *					
 *					private void thisWindowClosed(WindowEvent evt) {			
 *						t.interrupt();									// thread anhalten (nach fensterschliessen) falls er nicht schon vorher	angehalten wurde
 *						t = null;										// wäre nicht mal unbedingt nötig
 *					}
 *
 *
 *			=> handler method für wenn maus gedrückt wird, bestimmen ob maus über dem ballon-bild gedrückt wurde oder nicht
 *				-> bedingung: maus-x-y-koordinate (evt.getX(),..) vergleichen mit x-y-koordinaten die das bild aktuell abdeckt	
 *				-> wenn bedingung erfüllt: 		-> treffer-variable um eins erhöhen 
 *												-> label-text aktualisieren
 *												-> bild für einen repaint() lang auf ball2.jpg setzen
 *												-> repainten (via paintComponent von jPanel1)
 *
 *				 	private void jPanel1MousePressed(MouseEvent evt) {										// event-handling für wenn maus gedrückt wird, bestimmen ob maus über dem bild gedrückt wurde oder nicht 
 *						if ((evt.getX() >= jPanel1.getBallonX()) 											// falls: maus-x-koordinate (evt.getX()) innerhalb der x-koordinaten die das bild abdeckt.. 
 *								&& (evt.getX() <= jPanel1.getBallonX() + jPanel1.getBallonSizeX())	 
 *								&& (evt.getY() >= jPanel1.getBallonY())
 *								&& (evt.getY() <= jPanel1.getBallonY() + jPanel1.getBallonSizeY())) {		// ..und maus-y-koordinate (evt.getY()) innerhalb der y-koordinaten die das bild abdeckt sind
 *							treffer++;																						// treffer-variable um eins erhöhen
 *							jLTreffer.setText("Treffer: " + treffer + " von " + jPanel1.getBallonZaehler() + " Ballons");	// label-text aktualisieren
 *							jPanel1.setBildNr(1);																			// bild für einen repaint() lang auf ball2.jpg setzen
 *							jPanel1.repaint();																				// panel repainten
 *						}
 *					}
 *
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
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JBallonPanel_Synchronized_Threads extends JPanel implements Runnable{			// implements Runnable damit man einen weiteren Thread erzeugen kann [run() überschreiben zwangsläufig]
	
	private int bildNr = 0;												// variable für den array-index des anzuzeigenden bildes  (hier auf index 0 => ball.jpg )
	private Image[] img;												// Image array deklarieren für die bilder
	private int x, y;													// x, y - koordinaten für die bild-anzeige im panel (in der Komponente
	private int anzeigedauer = 1000;									// dauer in millisek während der, der ballon angezeigt wird bevor er an einem neuen ort angezeigt wird
	private int ballonZaehler = 0;										// variable zum zählen wie oft der ballon neu angezeigt wurde
	
	public JBallonPanel_Synchronized_Threads() {												// konstruktor überschreiben
		super();
		img = new Image[2];												// image array für 2 bilder erzeugen
		setBackground(Color.WHITE);										// hintergrundfarbe des panels via superklasse auf weiss setzen ( entspricht der hintergrundfarbe des ball.jpg bildes)
		img[0] = Toolkit.getDefaultToolkit().getImage(					// bild ball.jpg aus der datei (= mit url) in die Image-array-variable img[0]  einlesen, unter verwendung der methode  ..
				"." + File.separator + "images" + File.separator + "Ball.jpg");		// .. getImage(url) & getDefaultToolkit() der komponente Toolkit
		img[1] = Toolkit.getDefaultToolkit().getImage(					// bild ball2.jpg aus der datei (= mit url) in die Image-array-variable img[1]  einlesen, unter verwendung der methode  ..
				"." + File.separator + "images" + File.separator + "Ball2.jpg");	// .. getImage(url) & getDefaultToolkit() der komponente Toolkit
		// Random rand = new Random();									// code leiche vom buchautor, breaucht's glaub gar nicht 
		x = -100;														// position x koordinate initialisieren mit deutlich ausserhalb des sichtbaren bereichs
		y = -100;														// position y koordinate initialisieren mit deutlich ausserhalb des sichtbaren bereichs
	}
	
	public synchronized void paintComponent(Graphics g) {				// überschreiben von paintComponent(..) damit auf dem panel das bild gezeichnet werden kann, synchronized für ganze methode wegen bearbeieten von x, y & bildNr
		super.paintComponent(g);										// aufruf der superclass methode paintComponent unter mitgabe des graphic-objekts g
		g.drawImage(img[bildNr], x, y, 									// via methode drawImage von Graphics-objekt g: bild zeichnen mit parameter: image-variable, koordinaten-position x, y,..
				img[bildNr].getWidth(this), img[bildNr].getHeight(this), this);// .. breite des bildes, höhe des bildes, der letzte parameter für image-observer-objekt ist this , verweist also auf diese komponente selbst
		bildNr = 0; 													// bildNr jeweils gleich wieder auf ball.jpg setzen, denn wenn ball2.jpg eingeblendet wird soll das nur für einen kurzen moment sein
	}

	@Override															// in java 7 noch freiwillige überschreib-deklaration
	public void run() {													// zwangsläufiges überschreiben der methode run() (bei implementieren von Runnable) auf die der Thread zurückgreifen wird
		while (true) {													// endlos-schleife mit option auf abbrechen des laufenden vorgangs (+ wiederstarten) durch setzen der bedingung 
			synchronized (this) {										// ganzer block synchronized weil x, y- koordinaten & bildNr (index vom array img) werden an 2 orten bearbeitet vom gleichen thread-objekt 
				Random rand = new Random();								// randomobjekt für zufallszahlen
				x = rand.nextInt(this.getWidth() - img[0].getWidth(this));	// für x eine zufallszahl ab 0 bis panelbreite minus bildbreite, jeweils mit imageObserver this
				y = rand.nextInt(this.getHeight() - img[0].getHeight(this));// für y eine zufallszahl ab 0 bis panelhöhe minus bildhöhe, jeweils mit imageObserver this
				ballonZaehler++;										// je durchlauf der ballonanzeige den zaehler eins erhöhen
				anzeigedauer = rand.nextInt(1500) + 500;				// anzeigedauer nach zufallszahl auf zwischen 0.5 und 2 sek setzen
			}
			repaint();													// sobald die jeweils neuen x, y bekannt sind kann das bild ge-repainted werden (via paintComponent)
			try {														// therad-speziefische anweisungen immer innerhalb von try-catch
				Thread.sleep(anzeigedauer);								// Thread schlafen legen für anzeigedauer millisek
			} catch (InterruptedException e) {							// Thread-spez. exception-handlicng
				break;													// break ist WICHTIG (sonst funktioniert's nicht sauber) !! bei fehler von sleep einfach raus aus dem block und weiter in der endlos schleife ?!!
			}
		}
	}

	public int getBallonZaehler() {									// getter um anzahl ballbewegungen zu erfragen
		return ballonZaehler;
	}

	public void resetBallonZaehler() {								// setter um ballonzaehler auf null zu setzen
		ballonZaehler = 0;
	}
	
	public int getBallonX() {										// getter für x koord der aktuellen ballonposition
		return x;
	}

	public int getBallonY() {										// getter für y koord der aktuellen ballonposition
		return y;
	}

	public int getBallonSizeX() {									// getter für breite des bildes img[0]
		return img[0].getWidth(this);								// rückgabe breite des bildes durch methode getWidth(..) mit parameter imageobserver (= diese komponente)
	}
	
	public int getBallonSizeY() {									// getter für höhe des bildes img[0] 
		return img[0].getHeight(this);								// rückgabe höhe des bildes durch methode getHeight(..) mit parameter imageobserver (= diese komponente)
	}

	public void setBildNr(int nr) {									// setter um bild-array-index auf 1 also ball2.jpg zu stellen
		if ((nr < 0) || (nr > 1)) {									// sicherheitsmechanixnutz (biitz kompliziert): dass man keine falsche bildNr eingeben kann
			bildNr = 0;												// wenn man falsche bild nr eingeben würde wird auf 0 also ball.jpg gesetzt
		} else {
			bildNr = nr;											// für die eigentl. funktion des setters: bild auf 0 oder 1 (also ball.jpg oder ball2.jpg)
		}
	}

    public void setAnzeigedauer(int d) {							// lustiger setter um die anzeigedauer der ballone zu verstellen, der aber leider nirgends benutzt wird
	if (d < 0) {													// kontrollmechanixnutz: wenn anzeigedauer unter 0..
	    anzeigedauer = 2000;										// .. wird sie auf 2000 milisek gesetzt
	} else
	    anzeigedauer = d;											// sonst auf den übergabewert
    }
	
	
}
