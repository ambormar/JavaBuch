/* TODO .9.2.1 - 9.2.11.   ab s.261
 * Klasse Jigloo_Basic_MethodenKlassenKonstruktoren_JFrame
 * 
 * JIGLOO BENUTZUNG BASICS SIEHE AUCH: 	9.1.					Jigloo_Basics_CodeGenerieren_JFrame						s.256 
 *										9.3. (9.3.1 & 9.3.2.)   Jigloo_Basics_KomponentenPalette_AllgemeinesHandling	s.266
 *   
 * METHODEN, KLASSEN & KONSTRUKTOREN:		siehe quellcode unten f�r genau
 * 
 * METHODEN & KONSTRUKTOREN DER KLASSEN JFRAME, COMPONENT, DIMENSION, POINT, WINDOW, INSETS (und wo sie im Jigloo-GUI verwendet werden):	 
 * 
 * 		[	=> die hierarchie der erbenden & vererbenden Klassen im zusammenhang mit GUI sind ziemlich verstrickt:
 * 				-> desshalb methoden (ohne die genaue Klasse zu kennen) etsprechend ihrer funktionen suchen (Bsp. setSize(), setLocation() etc.)
 * 				-> viele dieser methoden sind f�r verschiedene klassen g�ltig  -> 	Bsp. setSize(..) 	]
 * 
 * 		METHODEN,KONSTRUKTOREN,KLASSEN:	 |	VERWENDG. hier im:  |  KOMMENTAR:
 * 
 * 		pack()								initGUI()			// s.259 setzt frame minimal klein aber gross genug, dass alle komponenten platz haben 
 * 						
 * 			[9.2.1	JFrame, Dimension, Point :]
 * 
 * 		JFrame()							Main				// konstruktor ohne parameter
 * 		JFrame(String tiltle)				Main				// konstruktor mit �bergabe von titel in klammer
 *  	void setTitle(String title);		Konstruktor			// setter-methode um titel in fensterrahmen nachtr�glich zu setzen (Klasse JFrame)
 *  	String getTitle()					? irgend wo ben�tigt// getter-methode gibt kopfleisten-text zur�ck (Klasse JFrame)
 * 		Dimension(int width, int height)	initGUI()			// objekt der klasse dimension f�r h�he, breite
 *  	Point(int x, int y)					(w�re glaub im) Main// konstruktor der Klasse Java.awt.Point um koordinatenpunkt-objekt zu erzeugen
 * 
 * 			[9.2.2. gr�ssen von komponenten abfragen / festlegen, : ]
 * 
 *  	void setSize(int width, int height)	initGUI()			// gr�sse f�r Komponente mit h�he, breite setzen 
 *  	void setSize(Dimension dim)			initGUI()			// gr�sse f�r Komp. mit objekt dim anstelle von height, width setzen
 *  	Dimension getSize()					? irgend wo ben�tigt// gr�sse von Komp. abfragen
 *  
 * 			[9.2.3. Position einer komponente abfragen / festlegen : ]
 *  
 * 		void setLocationRelativeTo(null)   	Main				// Komp. eingemittet platzieren 	
 *  	void setLocation(int x, int y)		Main				// Komp. mittels x-y-achsen platzieren
 *  	void setLocation(Point p)			Main				// Kopm. mittels objekt Point der Klasse java.awt.point platzieren
 *  	Point getLocation()					? irgend wo ben�tigt// Bildschirmposition von Komp. abfragen (Ursprung oben links: x, y)	
 *  
 * 			[9.2.4. Insets, randelemente eines fensters: ]
 * 
 * 		Insets(int top, li, bot, re)		nicht direkt verwendbar// java.awt.insets f�r breite der randelemente; Insets ver�ndern wie, setInsets() gibt's nicht??
 *  	Insets getInsets()					initGUI()			// Insets abfragen [randelemente(Top, re, bo, li)]
 *  
 * 			[9.2.5. ver�nderbarkeit der gr�sse eines fensters: ]
 * 
 * 		void setResizable(boolean b)		Main				// fenstergr�sse f�r annwender un-/ver�nderbar machen mit true & false					
 * 		void isResizable()					initGUI()			// abfragen ob frame-gr�sse ver�nderbar ist (true / false)
 * 
 * 			[9.2.6. sichtbarkeit von komponenten: ]
 *  
 *  	void setVisible(boolean b)			Main				// Komp. sichtbar setzen mit true oder false
 *  	void isVisible()					initGUI()			// sichtbarkeit der Komp. abfragen
 *  
 * 			[9.2.7. l�schen eines fensters: ]
 * 
 * 		void dispose()						Main 				// fenster aus speicher l�schen 
 *  	
 * 			[9.2.8. schhliessreaktionen des fensters festlegen: ]
 * 
 * 		void setDefaultCloseOperations(int op)	 initGUI()		// schliessreaktionen bei clicken von x:
 * 			[	->	(int op =) DISPOSE_ON_CLOSE, HIDE_ON_CLOSE, DO_NOTHING_ON_CLOSE, EXIT_ON_CLOSE	]
 * 
 * 			[9.2.9. cursoraussehen festlegen: ]
 * 
 * 		void setCursor(new Cursor(Cursor.HAND_CURSOR))		initGUI()	// cursor-aussehen festlegen
 * 			[	CROSSHAIR_CURSOR, DEFAULT_CURSOR, MOVE_CURSOR, TEXT_CURSOR, WAIT_CURSOR		]	
 * 
 * 			[9.2.10. container eines frames ermitteln : 		
 * 				-> JFrame beinhaltet ein JPanel (Container) wo dann die einzelnen Komponenten (JLabels etc.) reinkommen ]
 * 
 * 		Container getContentPane()			initGUI()			// container einer Komponente ermitteln (z.b.vom JFrame) 
 *  
 * 			[9.2.10. Komponente zu einem container hinzuf�gen : ]
 * 
 * 		frame.getContentPain().add(component)	initGUI()		// dem ermittelten container eine beliebige komponente hinzuf�gen		
 * 		frame.add(component)					initGUI()		// dem container eine komponente hinzuf�gen (neue version) ohne explizite containerermittlung
 * 
 * 
 * K&K: 	bsp f�r anwendung verschiedener methoden von unterschiedlichen klassen 
 * 			die bei Jigloo/GUI/JFrames benutzt werden k�nnen
 */

package uebungen09;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Window;

public class Jigloo_Basic_MethodenKlassenKonstruktoren_JFrame extends javax.swing.JFrame {
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Jigloo_Basic_MethodenKlassenKonstruktoren_JFrame inst = new Jigloo_Basic_MethodenKlassenKonstruktoren_JFrame(""); // 9.2.1a konstruktor mit titel-string als parameter�bergabe
				inst.setLocationRelativeTo(null);	// 9.2.3 hier w�re genauso m�gl. setLocation(300, 100) oder setLocation(Point p)
				inst.setVisible(true);				// 9.2.6 setVisible(boolean b)
				/* inst.setResizable(false); */		// 9.2.5. fenstergr�sse f�r anwender unver�nderbar machen
				/* inst.dispose(); */				// 9.2.7. fenster gleich wieder (aus speicher) l�schen
			}
		});
	}
	
	public Jigloo_Basic_MethodenKlassenKonstruktoren_JFrame(String title) { // 9.2.1a �bergabe von titel in klammer
		super(title);
		initGUI();
		this.setTitle("Hallo Fenster");		 // 9.2.1a setter-methode um titel in fensterrahmen nachtr�glich zu setzen
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(DISPOSE_ON_CLOSE); // 9.2.8 setDefaultCloseOperation(int op) alternativ: HIDE_ON_CLOSE etc.
			pack();									// s.259 methode setzt frame minimal klein aber gross genug, dass alle komponenten platz haben
			Dimension dim = new Dimension(600, 400); // 9.2.1b objekt der klasse dimension f�r h�he, breite (k�nnte auch ganz oben stehen)
			setSize(dim);							// 9.2.2 setSize() & 9.2.1b objekt dim anstelle von height, width einsetzen
			// 9.2.4 getInsets(top, li, bot, re) Insets abfragen und auf konsole ausgeben. Insets ver�ndern wie, setInsets() gibt's nicht??  
			System.out.println("die insets (leisten)-groessen sind: " + this.getInsets());
			// 9.2.5 setResizable(boolean b) & isResizable() : setzen oder abfragen dass/ob frame-gr�sse ver�nderbar ist (true / false)
			System.out.println("ist framegr�sse ver�nderbar: " + this.isResizable());
			// 9.2.9 version buch veraltet, neu: setCursor(new Cursor(Cursor.IRGEND_CURSOR)) von klasse component
			this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
}
