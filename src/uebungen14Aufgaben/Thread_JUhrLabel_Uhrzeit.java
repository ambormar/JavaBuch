/* TODO 14.3.3.   Aufgabe 3,   s.459, verwendet JUhrLabel
 * class 	JUhrLabel		&		Thread_JUhrLabel_Uhrzeit
 * 
 * K&K:	
 * 		Klasse JUhrLabel: 		(Musterlösung zu Kapitel 14 Aufgabe 3)
 * 
 * 				- Die Klasse ist von der Klasse JLabel abgeleitet.					-> erstellen von JUhrLabel abgeleitet von JLabel	
 * 				- Die Klasse stellt die aktuelle Uhrzeit als Label dar.					 
 * 				- Die Uhrzeit wird durch einen eigenen Thread ständig aktualisiert.
 * 				
 * 				-> komponente soll Uhrzeit in std:min:sek anzeigen, jede sek die anzeige aktualisieren 
 * 					aktuelle Uhrzeit als String im format mittels:
 * 
 * 						SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
 *						String Uhrzeit = sdf.format(System.currentTimeMillis());
 * 				
 * 
 * 		Programm .._Uhrzeit: 		(Musterlösung zu Kapitel 14 Aufgabe 3)
 * 
 * 				Das Programm verwendet die selbsterstellte klasse JUhrLabel, um eine laufende Uhr als Label in einem Frame darzustellen.
 * 				-> label in programm-frame Uhrzeit testen, durch starten eines threads der die run-methode von JUhrLabel nutzt
 * 				-> beim schliessen des frames , thread stoppen nicht vergessen
 * 
 * 
 * 
 * VORGEHEN:	BEIDE:		programm .._Uhrzeit testet klasse JUhrLabel die einen zusöätzlichen Thread bereitstellt
 * 
 * 		Klasse JUhrLabel:	
 * 
 * 			=> von JLabel abgeleitetes custom-JUhrLabel, mit möglichkeit zu zusätzlichen Threads durch implements Runnable
 * 	
 * 				public class JUhrLabel extends JLabel implements Runnable {..}			 
 * 
 * 			=> überschriebener konstruktor mit labeltext aktuelle Uhrzeit als String im format	
 * 
 * 				public JUhrLabel() {											 
 *					super();
 *					SimpleDateFormat sdf = new SimpleDateFormat("HH.mm:ss");	// zeitformatierung  mit der klasse SimppleDateFormate, als Parameter das gewünschte format 
 *					String Uhrzeit = sdf.format(System.currentTimeMillis());	// objekt sdf mit formatierter aktueller uhrzeit dem string zuweisen
 *					setText(Uhrzeit);											// string als text setzen
 *				}
 * 
 * 
 * 			=> paintComponent-methode der superklasse überschreiben, damit die änderungen der komponente (panel) jeweils neugezeichnet werden bei frame-veränderungen
 * 
 * 				public void paintComponent(Graphics g) {						
 *					super.paintComponent(g);									
 *					SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");	// NOCHMAL wie im konstruktor, damit's bei jedem repaint() wieder vorhanden ist: 	zeitformatierungs-objekt inkl. formatierung
 *					String Uhrzeit = sdf.format(System.currentTimeMillis());	// string mit aktueller uhrzeit
 *					setText(Uhrzeit);											// string als text setzen
 *				}
 * 
 * 			=> zwingende run()-methode für den zusätzlichen thread
 * 
 *				@Override				// wie ein kommentar bei absichtlichem überschreiben von methoden der superklasse. -> heute java7: ist's guter programmierstil -> evtl. ab java 8 oder 9 unumgänglich, 
 *				public void run() {		// Auto-generated method stub (= methoden-rumpf) bei implements Runnable: für den zusätzlichen thread,
 *					while (true) {												// endlos-scleife
 *						try {													// try-catch-block immer bei Threads
 *							Thread.sleep(1000);									// zusätzlichen thread anhalten füür 1 sek
 *							repaint();											// neuzeichnen
 *						} catch (InterruptedException e) {						// thread-spez. exceptionhandling
 *							break;												// ausstieg fals fehler, damit's weiterlaufen kann
 *						}
 *					}
 *				}  
 * 
 * 	VORGEHEN:		
 * 		Programm .._Uhrzeit:
 * 
 * 			=> Test-Frame zur anzeige von JUhrLabel:		
 * 
 * 			=> Fields:		private JUhrLabel jLabel1;							// jLabel1 vom typ JUhrLabel (selbstabgeleitete komponente von JLabel)  
 *							private Thread t;									// thread initialisieren bei den eigenschaften, erzeugung ist im initGUI()
 *
 *
 *			=> erzeugen des selbstabgeleiteten JLabels vom typ JUhrLabel im initGUI()
 *				
 *				jLabel1 = new JUhrLabel();		
 *
 *			=> zusätzlichen thread (vom target jLabel1) erzeugen & starten noch im:		 initGUI(), damit er läuft ab programmstart
 *
 *				t = new Thread(jLabel1);								
 *				t.start();																		 
 *
 *			=> handler method event-handling wenn frame geschlossen wurde (WindowClosed)		[	& inkl. WindowListener() im initGUI()	]
 *
 *				private void thisWindowClosed(WindowEvent evt) {				
 *					if (t != null){												// sofern der zusätzliche thread t vorhanden ist..
 *						t.interrupt();											// ... den Thread unterbrechen
 *					}
 *				} 
 *
 *
 * ZEITFORMAT - SIMPLEDATEFORMAT
 * 
 *				SimpleDateFormat sdf = new SimpleDateFormat("HH.mm:ss");		// zeitformatierung  mit der klasse SimppleDateFormate, als Parameter das gewünschte format 
 *				String Uhrzeit = sdf.format(System.currentTimeMillis());		// objekt sdf mit formatierter aktueller uhrzeit dem string zuweisen 
 *
 * 
 * ZEIT - SYSTEM.CURRENTTIMEMILLIS()
 * 
 * 				System.currentTimeMillis()										// spuckt aktuelle uhrzeit ab system aus
 * 
 * 		PAINTCOMPONENT MIT REPAINT() & SYSTEM.CURRENTTIMEMILLIS(..) ANSTELLE EINES ZUSÄTZLICHEN THREADS :
 * 
 * 			SIEHE:		 14.3.4.   Aufgabe 4,   	JUhrzeitPanel		&		Thread_JUhrzeitPanel_OhneExtraThread_Uhrzeit2		s.460, 
 *
 * 						-> Unter benutzung von repaint() + System.currentTimeMillis(..) in der überschriebenen paintComponent()-methode, ..
 * 							.. wird die paintComponent()-methode so oft aufgerufen, dass man keinen zusätzlichen thread braucht um eine laufande uhr zu erhalten
 * 
 * 			
 * 
 * 
 */


package uebungen14Aufgaben;
import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


public class Thread_JUhrLabel_Uhrzeit extends javax.swing.JFrame {

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.jgoodies.looks.plastic.Plastic3DLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private JUhrLabel jLabel1;										// jLabel1 vom typ JUhrLabel (selbstabgeleitete komponente von JLabel)  
	private Thread t;												// thread initialisieren bei den eigenschaften, erzeugung ist im initGUI()
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Thread_JUhrLabel_Uhrzeit inst = new Thread_JUhrLabel_Uhrzeit();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public Thread_JUhrLabel_Uhrzeit() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			AnchorLayout thisLayout = new AnchorLayout();
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.addWindowListener(new WindowAdapter() {			// eventhandling für wenn das frame geschlossen wurde
				public void windowClosed(WindowEvent evt) {
					thisWindowClosed(evt);
				}
			});
			{
				jLabel1 = new JUhrLabel();							// erzeugen des selbstabgeleiteten JLabels vom typ JUhrLabel
				getContentPane().add(jLabel1, new AnchorConstraint(303, 802, 631, 318, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jLabel1.setPreferredSize(new java.awt.Dimension(60, 20));
			}
			pack();
			this.setSize(100, 70);
			t = new Thread(jLabel1);								// zusätzlichen thread (vom target jLabel1) erzeugen noch im initGUI(), damit er ready ist bei programmstart
			t.start();												// zusätzliichen thread starten auch gleich mit programmstart
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private void thisWindowClosed(WindowEvent evt) {				// handler method event-handling wenn farme geschlossen wurde (WindowClosed)
		if (t != null){												// sofern der zusätzliche thread t vorhanden ist..
			t.interrupt();											// ... den Thread unterbrechen
		}
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