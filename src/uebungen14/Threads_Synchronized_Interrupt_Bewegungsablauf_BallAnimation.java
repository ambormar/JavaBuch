/* TODO 14.2.4.   s.454, (verwendet JBallPanel_..) 
 * class 	Threads_Synchronized_Interrupt_Bewegungsablauf_BallAnimation		&		JBallPanel_Synchronized_Therads 	 		
 * 
 * 			SIEHE:			14.2.3.   		Synchronisation_VonThreads_Problematik_Begriff_Synchronized_Modifier		s.453,
 * 
 * 
 * 	K&K:	KLASSE JBallPanel_..:	 
 * 
 * 				Klasse JBallPanel (von der Klasse JPanel abgeleitet)
 * 				Die Klasse stellt einen Ball zur Demonstration von Bewegungsabl�ufen dar. Der Ball wird aus einer Bilddatei (jpg) (w�re auch als zeichenroutine m�gl.) eingebunden. 
 * 				In einem zus�tzlichem Thread kann sich der ball kontinuierlich im panel hin-& herbewegen. am rand des panels wechselt er die flugrichtung. 
 * 				
 * 
 * 			PROGRAMM .._BallAnimation:		
 * 
 * 				Programm Ballanimation (verwendet die Komponente JBallPanel)
 * 				Das Programm demonstriert die Erstellung von Bewegungsabl�ufen. Die Ball-animation wird via JBallPanel als eigener Thread eingebunden.
 * 				Die Animation (= der zus�tzliche thread) kann mittels start & stop-button gestartet oder gestoppt werden.
 * 				Bei schliessen des fensters wird die animation auch zus�tzlich gestoppt, damit der thread nicht in der console weiterl�uft.
 * 
 * 
 * 	VORGEHEN:
 * 		
 * 		KLASSE JBallPanel_..:
 * 
 * 			-> Die Klasse dient der Darstellung einer ball-animation innerhalb des jPanels.
 * 			-> die positions-koordinate x des balles muss synchronisiert werden, da sie in 2 verschiedenen Threads verwendet wird (+ konflikte entstehen k�nnten) 
 * 
 * 			=> KLASSE JBallPanel_.. von der Komponente JPanel abgeleitet, um sie im aufrufenden programm .._BallAnimation anstelle eines standard-jpanels einsetzen zu k�nnen
 * 
 * 			=> Klasse mit implements Runnable erweitern, um dann im run() einen zus�tzlichen Thread anlegen zu k�nnen
 * 				
 * 					BSP:	public class JBallPanel_.. extends JPanel implements Runnable {..			// implementieren von Runnable zwingt zum �berschreiben von run() (der klasse Runnable)
 * 
 * 			=> fields: 		public int x = 0;												// attribut x x-koordinaten-position des balles
 *							private Image img;												// variable f�r das zu ladende bild ball.jpg
 *							private boolean vor = true;										// boolescher wert f�r die aktuelle bewegungsrichtung des ball-bildes (true steht f�r: von li nach re) 
 * 		
 * 			=> konstruktor �berschreiben:													
 * 				[NB:  wieso diese anweisungen im konstruktor?: 	-> anweisungen m�ssen ja irgendwo / in einer methode stehen, hier halt im konstruktor]
 * 				-> hintergrundfarbe des panels auf hintergrundfarbe des einzulesenden ball-bildes abstimmen
 * 				-> ball-bild aus der datei in die variable img einlesen, unter verwendung von .getImage der komponente toolkit					=> siehe unten: BESONDERES TOOLKIT
 * 
 *					public JBallPanel_..() {						
 *						super();
 *						setBackground(Color.white);									
 *						img = Toolkit.getDefaultToolkit().getImage(									// bild aus der datei (= mit url) in die Image-variable img einlesen, unter ..
 *								"." + File.separator + "images" + File.separator + "Ball.jpg"); 	// .. verwendung der methode getImage(url) & getDefaultToolkit() der komponente Toolkit
 *					}  
 *							
 * 			=> paintComponent-methode der superklasse �berschreiben, damit die �nderungen der komponente (panel) jeweils neugezeichnet werden bei frame-ver�nderungen
 * 				-> synchronized f�r ganze methode  					-> um das verwenden der variablen x zu synchronisieren, die auch im zus�tzlichen thread verwendet wird  [siehe run()]
 * 				-> zeichnen des bildes mit drawImage von Graphics	-> koordinate x ver�ndert sich, y gleichbleibend auf halber h�he des panels
 * 				[NB: -> der letzte parameter this verweist auf ein image-observer-objekt			-> siehe kommentar  & unten BESONDERES: IMAGE-OBSERVER]
 * 
 *					public synchronized void paintComponent(Graphics g) {						// �berschreiben von paintComponent(..) damit auf dem panel das bild gezeichnet werden kann, 
 *						super.paintComponent(g);												// aufruf der superclass methode paintComponent unter mitgabe des graphic-objekts g
 *						g.drawImage(img, x, 													// via methode drawImage von Graphics-objekt g: bild zeichnen mit parameter: image-variable, koordinaten-position x (= variable x von ..
 *									getHeight()/2 - img.getHeight(this)/2,  					// .. oben), position y (halbe panel-h�he minus halbe bild-h�he), breite des bildes, h�he des bildes, 
 *									img.getWidth(this), img.getHeight(this), this);				// der letzet parameter this verweist auf ein image-observer-objekt welches den aufbereitungvorgang von bildern �berwacht..
 *					}																			// ..(es ist ein nachfolger von component). da auch das panel ein nachfolger von component ist kann man mit this das panel als ..
 *																								// ..ImageObsberver angeben. ebenso kann man this f�r die abfragen der bildgr�ssen mit getWitdh() & getHeight() angeben. dort..
 *																								// .. w�ren auch fixe werte m�glich 
 *
 *
 * 			=> zwangsl�ufiges �berschreiben der run()-methode von Runnable f�r die anweisungen des zus�tzlichen Threads
 * 				-> sorgt daf�r, dass paintCompoonent f�r die zeichenvorg�nge st�ndig eine neue positionskoordinate x erh�lt 
 * 				-> unter verwendung von synchronized nur f�r den anweisungsblock, wo die variable x verwendet wird, welche in 2 verschiedenen Threads verwendet wird
 * 				-> mit endlos while-schleife mit ..:							
 * 					1. .. synchronisiertem anweisungs-block wo x bearbeitet wird 		-> pr�fung ob x den re oder li panel-rand erreicht hat
 * 																						-> boolsche variabel vor zur die steuerung der vorw�rts oder r�ckw�rts- bewegung
 * 																						-> x kontinuierlich vergr�ssern oder verkleinern (je nach variabel vor)
 * 					2. .. repaint() sobald das jeweils neue x bekannt ist				-> damit das bild jeweils ge-repainted werden kann (ruft ja  paintComponent() auf)
 * 					3. .. Thread.sleep(20)	in try- block											-> steuert die geschwindigkeit der animation 
 * 					&  .. break; 			in catch-block											-> ausstieg aus exception-handlinng bei fehler (z.b.: laufzeitfehler?) 
 * 
 *					@Override												// in java 7 noch freiwillige �berschreib-deklaration
 *					public void run() {										// zwangsl�ufiges �berschreiben der methode run() (bei implementieren von Runnable) auf die der Thread zur�ckgreifen wird: ..
 *																			// .. sorgt daf�r dass die paintComponent-methode f�r die zeichenvorg�nge st�ndig neue positionskoordinaten erh�lt ..
 *																			// .. (bewegung nur f�r die x-koordinate vorgesehen, y-koordinate wird nicht bearbeitet)
 *						while (true) {										// enlosschleife
 *							synchronized (this) {							// synchronized (this) nur f�r den anweisungs-block wo x bearbeitet wird,	(this) => f�r das instanz-objekt dieser klasse 
 *								if (x > getWidth() - img.getWidth(this)) {	// wenn x (li oben horizontal koordinate des bildes) gr�sser als panelbreite - bildbreite (=> li rand des panelsvcwird erreicht)..
 *									vor = false;							// .. wird der boolsche wert auf false, bzw. auf r�ckw�rtsbewegen umgestellt
 *								} else if (x <= 0) {						// sonst wenn x kleiner gleich 0 ist ..
 *									vor = true;								// .. wird der boolsche wert auf true, bzw. auf vorw�rtsbewegen umgestellt
 *								}
 *								if (vor) {									// wenn vorw�rtsbewegung ..
 *									x += 2;									// wird x um 2 px erh�ht
 *								} else {									// sonst
 *									x -= 2;									// wird x um 2 px verkleinert
 *								}
 *							}												// synchronized fertig 
 *							repaint();										// sobald das jeweils neue x bekannt ist kann das bild ge-repainted werden (via paintComponent wo das x f�r drawImage(..) verwendet wird)
 *							try {											// therad-speziefische anweisungen immer innerhalb von try-catch
 *								Thread.sleep(20);							// Thread schlafen legen hier f�r 20 milisekunden, je nach wert ergeben sich fl�ssige bewegungsabl�ufe => ausprobieren 
 *							} catch (InterruptedException e) {				// Thread-spez. exception-handlicng
 *								break;										// break ist wichtig (sonst funktioniert's nicht sauber) !! bei fehler von sleep einfach raus aus dem block und weiter in der endlos schleife 
 *							}												// .. damit die animation weiterlaufen kann bei kleinen fehlern (laufzeitfehler?) 
 *						}
 *					}  
 *					
 * 	VORGEHEN FORTSETZUNG:
 * 			
 * 		PROGRAMM .._BallAnimation:	
 * 
 *			=> .._BallAnimation extends JFrame 
 *
 *			=> Fields:		private JBallPanel_.. jPanel1;							// JPanel ersetzen durch custom-klasse JBallPanel_.. mit name jPanel1
 *							private JButton jBtnStart;
 *							private JButton jBtnStop;
 *							private Thread t;										// Thread instanz t deklarieren
 *							
 *	  		=> JBallPanel (jPanel1) anstelle eines standard-JPanels f�r die darstellung der Ball-animation  	(im JFrame mit ankerlayout)
 *
 * 							jPanel1 = new JBallPanel_..();
 * 
 *	  		=> JButton Start mit handler-methode zum starten des Threads (= starten der animation)
 *				-> inklusive eigene kleine fehlerbehebung der buchversion:				if (t == null) {..}			-> vom zus�tzlichen thread soll sich nur EINE INSTANZ erzeugen lassen
 *				-> Thread-objekt erzeugen mit parameter Runnable Target (jPanel1)		t = new Thread(jPanel1);	-> (=> konstruktor erzeugt einen Thread, der die run-methode von target ausf�hrt)					
 *				-> & starten des Threads												t.start();	
 *	  		
 *				 	private void jBtnStart..(..) {				// handler method jBtn Start
 *						if (t == null) {						// fehlerbehebung (der buchversion): vom zus�tzlichen thread soll sich nur EINE INSTANZ erzeugen lassen
 *																// ..keine weiteren instanzen (die dazu f�hrten, dass sich der ball immer mehr verschnellert & nicht mehr stoppen l�sst)
 *							t = new Thread(jPanel1);			// thread-objekt erzeugen mit parameter Runnable Target (jPanel1) (=> konstruktor erzeugt einen Thread, der die run-methode von target ausf�hrt)
 *						}
 *						t.start();								// thread starten
 *					}
 *
 *					
 *			=> JButton Stop mit handler-methode zum stoppen des Threads (= stoppen der animation)
 *				-> thread anhalten mit											t.interrupt();		-> stop() gibt's nicht bzw. ist nicht erlaubt
 *				-> inklusive eigene kleine fehlerbehebung der buchversion:		t = null;			-> EINZIGE INSTANZ vom zus�tzlichen thread bei stop auf null setzen (= l�schen), sodass .. 
 *																										.. man mit dem startbutton immer nur wieder EINE INSTANZ vom zus�tzlichen thread erzeugen
 *					private void jBtnStop..(..) {		
 *						t.interrupt();							// thread anhalten (stop() gibt's nicht bzw. ist nicht erlaubt)
 *						t = null;								// fehlerbehebung (buchversion) EINZIGE INSTANZ vom zus�tzlichen thread auf null setzen (= l�schen), sodass man.. 
 *					}											// .. mit dem startbutton immer nur wieder EINE INSTANZ vom zus�tzlichen thread erzeugen
 *
 * 
 *			=> eventhandling & handler method f�r wenn das frame geschlossen wurde ohne dass zuvor der Thread angehalten ist. sonst l�uft der thread einfach weiter (siehe console roter knopf) 
 *				-> neuen WindowListener f�rs frame erzeugen im initGUI() 
 *	 						
 *					this.addWindowListener(new WindowAdapter() {		// neuer WindowListener f�rs frame..
 *						public void windowClosed(WindowEvent evt) {		// .. mit handler methode f�r EventHandling bei windowClosed (wenn fenster geschlossen)
 *							thisWindowClosed(evt);
 *						}
 *					});
 *					
 *				-> handler method mit stoppen des threads	
 *					
 *					private void thisWindowClosed(WindowEvent evt) {			
 *						t.interrupt();									// thread anhalten (nach fensterschliessen) falls er nicht schon vorher	angehalten wurde
 *						t = null;										// w�re nicht mal unbedingt n�tig
 *					}
 * 		
 * 
 * 
 * 
 * 
 * 	WINDOWLISTENER - FRAME-EVENT-HANDLING:		
 * 					&
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
 *		=> 	METHODEN (von der Klasse Object vererbt) f�r Threads zur kommunikation + konfliktl�sung �ber sperrzust�nde, innerhalb von Anweisungsbl�cken, die mit synchronized gesch�tzt sind
 *				
 *				wait(); 				beschreibung ausstehend
 *				notify();				beschreibung ausstehend
 *				notifyAll();			beschreibung ausstehend
 * 
 *  
 * 	INTERRUPTEDEXCEPTION MIT BREAK; :		SIEHE:		JBallPanel_..	methode  run() am ende
 * 
 * 		=> break-anweisung im catch-block einer animation		-> ausstieg aus exception-handlinng bei fehler (z.b.: laufzeitfehler?) 
 *
 *				try {											// therad-speziefische anweisungen immer innerhalb von try-catch
 *					Thread.sleep(20);							// Thread schlafen legen hier f�r 20 milisekunden, je nach wert ergeben sich fl�ssige bewegungsabl�ufe => ausprobieren 
 *				} catch (InterruptedException e) {				// Thread-spez. exception-handlicng
 *					break;										// break ist wichtig (sonst funktioniert's nicht sauber) !! bei fehler von sleep einfach raus aus dem block und weiter in der endlos schleife 
 *				}												// .. damit die animation weiterlaufen kann bei kleinen fehlern (laufzeitfehler?) 
 * 											
 *  
 *  ANIMATION - ENDLOS-WHILE-SCHLEIFE:		SIEHE:		14.2.4.		JBallPanel_Synchronized_Therads			ganze logik in der methode run() {..}
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
import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


public class Threads_Synchronized_Interrupt_Bewegungsablauf_BallAnimation extends javax.swing.JFrame {
	
	private JBallPanel_Synchronized_Therads jPanel1;	// JPanel ersetzen durch custom-klasse JBallPanel_.. mit name jPanel1
	private JButton jBtnStart;
	private JButton jBtnStop;
	private Thread t;									// Thread instanz t deklarieren
									
	
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Threads_Synchronized_Interrupt_Bewegungsablauf_BallAnimation inst = new Threads_Synchronized_Interrupt_Bewegungsablauf_BallAnimation();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public Threads_Synchronized_Interrupt_Bewegungsablauf_BallAnimation() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			AnchorLayout thisLayout = new AnchorLayout();
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("BallAnimation");
			this.addWindowListener(new WindowAdapter() {		// neuer WindowListener f�rs frame..
				public void windowClosed(WindowEvent evt) {		// .. mit handler methode f�r EventHandling bei windoClosed (wenn fenster geschlossen)
					thisWindowClosed(evt);
				}
			});
			{
				jBtnStop = new JButton();
				getContentPane().add(jBtnStop, new AnchorConstraint(834, 811, 908, 610, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jBtnStop.setText("Stopp");
				jBtnStop.setPreferredSize(new java.awt.Dimension(77, 23));
				jBtnStop.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnStopActionPerformed(evt);
					}
				});
			}
			{
				jBtnStart = new JButton();
				getContentPane().add(jBtnStart, new AnchorConstraint(834, 399, 908, 204, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jBtnStart.setText("Start");
				jBtnStart.setPreferredSize(new java.awt.Dimension(75, 23));
				jBtnStart.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnStartActionPerformed(evt);
					}
				});
			}
			{
				jPanel1 = new JBallPanel_Synchronized_Therads();
				getContentPane().add(jPanel1, new AnchorConstraint(56, 951, 735, 50, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jPanel1.setPreferredSize(new java.awt.Dimension(350, 212));
			}
			pack();
			this.setSize(400, 350);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private void jBtnStartActionPerformed(ActionEvent evt) {	// handler method jBtn Start
		if (t == null) {										// fehlerbehebung (der buchversion): vom zus�tzlichen thread soll sich nur EINE INSTANZ erzeugen lassen
																// ..keine weiteren instanzen (die dazu f�hrten, dass sich der ball immer mehr verschnellert & nicht mehr stoppen l�sst)
			t = new Thread(jPanel1);							// thread-objekt erzeugen mit parameter Runnable Target (jPanel1) (=> konstruktor erzeugt einen Thread, der die run-methode von target ausf�hrt)
		}
		t.start();												// thread starten
	}
	
	private void jBtnStopActionPerformed(ActionEvent evt) {		// handler methode JBtn stopp 
		t.interrupt();											// thread anhalten (stop() gibt's nicht bzw. ist nicht erlaubt)
		t = null;												// fehlerbehebung (buchversion) EINZIGE INSTANZ vom zus�tzlichen thread auf null setzen (= l�schen), sodass man.. 
	}															// .. mit dem startbutton immer nur wieder EINE INSTANZ vom zus�tzlichen thread erzeugen
	
	// event handler method f�r wenn das frame geschlossen wurde ohne dass zuvor der Thread angehalten ist. sonst l�uft der thread einfach weiter (siehe console roter knopf) 
	private void thisWindowClosed(WindowEvent evt) {			
		t.interrupt();											// thread anhalten (nach fensterschliessen) falls er nicht schon vorher	angehalten wurde
		t = null;												// w�re nicht mal unbedingt n�tig
	}

}


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