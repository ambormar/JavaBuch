/* TODO 14.3.3.   Aufgabe 3,   s.459, extends JLabel implements Runnable
 * class 	JUhrLabel		&		Thread_JUhrLabel_Uhrzeit
 * 
 * K&K:	
 * 		Klasse JUhrLabel: 		(Musterl�sung zu Kapitel 14 Aufgabe 3)
 * 
 * 				- Die Klasse ist von der Klasse JLabel abgeleitet.					-> erstellen von JUhrLabel abgeleitet von JLabel	
 * 				- Die Klasse stellt die aktuelle Uhrzeit als Label dar.					 
 * 				- Die Uhrzeit wird durch einen eigenen Thread st�ndig aktualisiert.
 * 				
 * 				-> komponente soll Uhrzeit in std:min:sek anzeigen, jede sek die anzeige aktualisieren 
 * 					aktuelle Uhrzeit als String im format mittels:
 * 
 * 						SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
 *						String Uhrzeit = sdf.format(System.currentTimeMillis());
 * 				
 * 
 * 		Programm .._Uhrzeit: 		(Musterl�sung zu Kapitel 14 Aufgabe 3)
 * 
 * 				Das Programm verwendet die selbsterstellte klasse JUhrLabel, um eine laufende Uhr als Label in einem Frame darzustellen.
 * 				-> label in programm-frame Uhrzeit testen, durch starten eines threads der die run-methode von JUhrLabel nutzt
 * 				-> beim schliessen des frames , thread stoppen nicht vergessen
 * 
 * 
 * 
 * VORGEHEN:	BEIDE:		programm .._Uhrzeit testet klasse JUhrLabel die einen zus��tzlichen Thread bereitstellt
 * 
 * 		Klasse JUhrLabel:	
 * 
 * 			=> von JLabel abgeleitetes custom-JUhrLabel, mit m�glichkeit zu zus�tzlichen Threads durch implements Runnable
 * 	
 * 				public class JUhrLabel extends JLabel implements Runnable {..}			 
 * 
 * 			=> �berschriebener konstruktor mit labeltext aktuelle Uhrzeit als String im format	
 * 
 * 				public JUhrLabel() {											 
 *					super();
 *					SimpleDateFormat sdf = new SimpleDateFormat("HH.mm:ss");	// zeitformatierung  mit der klasse SimppleDateFormate, als Parameter das gew�nschte format 
 *					String Uhrzeit = sdf.format(System.currentTimeMillis());	// objekt sdf mit formatierter aktueller uhrzeit dem string zuweisen
 *					setText(Uhrzeit);											// string als text setzen
 *				}
 * 
 * 
 * 			=> paintComponent-methode der superklasse �berschreiben, damit die �nderungen der komponente (panel) jeweils neugezeichnet werden bei frame-ver�nderungen
 * 
 * 				public void paintComponent(Graphics g) {						
 *					super.paintComponent(g);									
 *					SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");	// NOCHMAL wie im konstruktor, damit's bei jedem repaint() wieder vorhanden ist: 	zeitformatierungs-objekt inkl. formatierung
 *					String Uhrzeit = sdf.format(System.currentTimeMillis());	// string mit aktueller uhrzeit
 *					setText(Uhrzeit);											// string als text setzen
 *				}
 * 
 * 			=> zwingende run()-methode f�r den zus�tzlichen thread
 * 
 *				@Override				// wie ein kommentar bei absichtlichem �berschreiben von methoden der superklasse. -> heute java7: ist's guter programmierstil -> evtl. ab java 8 oder 9 unumg�nglich, 
 *				public void run() {		// Auto-generated method stub (= methoden-rumpf) bei implements Runnable: f�r den zus�tzlichen thread,
 *					while (true) {												// endlos-scleife
 *						try {													// try-catch-block immer bei Threads
 *							Thread.sleep(1000);									// zus�tzlichen thread anhalten f��r 1 sek
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
 *			=> zus�tzlichen thread (vom target jLabel1) erzeugen & starten noch im:		 initGUI(), damit er l�uft ab programmstart
 *
 *				t = new Thread(jLabel1);								
 *				t.start();																		 
 *
 *			=> handler method event-handling wenn frame geschlossen wurde (WindowClosed)		[	& inkl. WindowListener() im initGUI()	]
 *
 *				private void thisWindowClosed(WindowEvent evt) {				
 *					if (t != null){												// sofern der zus�tzliche thread t vorhanden ist..
 *						t.interrupt();											// ... den Thread unterbrechen
 *					}
 *				} 
 *
 *
 * ZEITFORMAT - SIMPLEDATEFORMAT
 * 
 *				SimpleDateFormat sdf = new SimpleDateFormat("HH.mm:ss");		// zeitformatierung  mit der klasse SimppleDateFormate, als Parameter das gew�nschte format 
 *				String Uhrzeit = sdf.format(System.currentTimeMillis());		// objekt sdf mit formatierter aktueller uhrzeit dem string zuweisen 
 * 
 * ZEIT - SYSTEM.CURRENTTIMEMILLIS()
 * 
 * 				System.currentTimeMillis()										// spuckt aktuelle uhrzeit ab system aus
 * 
 */

package uebungen14Aufgaben;

import java.awt.Graphics;
import java.text.SimpleDateFormat;

import javax.swing.Icon;
import javax.swing.JLabel;

public class JUhrLabel extends JLabel implements Runnable {			// von JLabel abgeleitetes custom-JUhrLabel, mit m�glichkeit zu zus�tzlichen Threads durch Runnable

	public JUhrLabel() {											// �berschriebener konstruktor mit labeltext aktuelle Uhrzeit als String im format
		super();
		SimpleDateFormat sdf = new SimpleDateFormat("HH.mm:ss");	// zeitformatierung  mit der klasse SimppleDateFormate, als Parameter das gew�nschte format 
		String Uhrzeit = sdf.format(System.currentTimeMillis());	// objekt sdf mit formatierter aktueller uhrzeit dem string zuweisen
		setText(Uhrzeit);											// string als text setzen
	}
	
	public void paintComponent(Graphics g) {						// paintComponent-methode der superklasse �berschreiben, damit die �nderungen der komponente (panel) jeweils neugezeichnet ..
		super.paintComponent(g);									// .. werden bei frame-ver�nderungen
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");	// NOCHMAL wie im konstruktor, damit's bei jedem repaint() wieder vorhanden ist: 	zeitformatierungs-objekt inkl. formatierung
		String Uhrzeit = sdf.format(System.currentTimeMillis());	// string mit aktueller uhrzeit
		setText(Uhrzeit);											// string als text setzen
	}

	@Override				// wie ein kommentar bei absichtlichem �berschreiben von methoden der superklasse. -> heute java7: ist's guter programmierstil -> evtl. ab java 8 oder 9 unumg�nglich, 
	public void run() {		// Auto-generated method stub (= methoden-rumpf) bei implements Runnable: f�r den zus�tzlichen thread,
		while (true) {												// endlos-scleife
			try {													// try-catch-block immer bei Threads
				Thread.sleep(1000);									// zus�tzlichen thread anhalten f��r 1 sek
				repaint();											// neuzeichnen
			} catch (InterruptedException e) {						// thread-spez. exceptionhandling
				break;												// ausstieg fals fehler, damit's weiterlaufen kann
			}
		}
	}

}
