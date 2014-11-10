/* TODO .9.1,   s.256 
 * class Jigloo_Basics_CodeGenerieren_JFrame extends javax.swing.JFrame
 * 
 * JIGLOO PLUGIN INSTALLIEREN: 		s. 249		
 * 
 * GUIs MIT JIGLOO & ECLIPSE:		selbstgenerierter code (hier JFrame) und anpassungen:
 * 
 *  										- ..im code anpassen oder 
 *  										- ..im seitenfenster (PROPERTIES, LAYOUT, EVENTS) anpassen  		 
 * 									
 * 		ERZEUGEN:		re-klick auf PROJEKT(/PACKAGE)ORDNER - NEW - OTHER - GUIFORMS - SWING - JFRAME
 * 
 * 							-> ein leerer JFrame wird von Jigloo erzeugt (sichbar, eingemittet & mit paar standardeigenschaften im initGUI() )
 * 						[	-> lizenz-code ganz ans ende des codes kopieren, damit er nicht bei jedem öffnen erzeugt wird	]
 * 
 * 		ANSICHT: 		switchen mit pfeilen zwischen code & GUI-vorschau
 * 
 * 		ÖFFNEN IN JIGLOO ANSICHT:		- re-klick auf KLASSE im PACKAGEORDNER - OPEN WITH - FORM EDITOR
 * 										
 * 		KOMPONENTEN IN FRAME EINBAUEN:		- layout auf absolute
 * 			(9.3.2. s.267)					- componenten hinzufügen (1 klick in palette, 1 klick in grünen rahmen)
 * 											- formular ausfüllen
 * 											- grösse & position mit drag&drop
 * 
 * 											- genau siehe:	 9.3.  Jigloo_Basics_KomponentenPalette_AllgemeinesHandling	s.266
 *   
 *   	PROPERTIE-ANSICHT ÖFFNEN FALLS ZU: 		-	WINDOW - SHOW VIEW - OTHER - JIGLOO - GUIProperties
 *   
 *   					= GUI-Properties besteht aus 3 spalten mit je einer bezeichner-spalte (li) & einer werte-spalte (re):		
 *   	
 *   					PROPERTIES:		- für eigenschaften des angewählten objekts, anpassungen im initGUI() 
 *   
 *   					LAYOUT:			- für layout-einstellung d. angew. objekts (z.b. layout => border)
 *   
 *   					EVENTS:			- für ereigniss/event-behandlung d. angew. objekts (z.b. maus-aktionen etc.)
 *   
 * AUTOGENERIERTER CODE:			genaue erklärungen im Bsp-code unten
 * 
 * CODE-SCHEMA:		public static void main(String[] args) {			// Main
 *						SwingUtilities.invokeLater(new Runnable() {		// neuer lauffähiger Thread ohne normale..
 *	  						public void run() {							// .. sequenz der ereignisbehandlung zu stören
 *		  						Klassenname inst = new Klassenname();	// konstruktor dieser (this) klasse aufrufen
 *								...										// inst.setvisible() & inst.setLocationRelativeTo
 *							}
 *						});	
 *					}
 *
 *					public Klassenname() {		// konstruktor dieser klasse (subklasse von JFrame)
 *						super();				// zugriff auf methoden der superklasse (hier: JFrame)
 *						initGUI();				// zugriff auf initGUI()-methode dieser klasse (überschreibt initGUI() der superklasse)
 *					} 
 * 
 * 					private void initGUI() {	// initialisierungs-methode fürs GUI (überschreibt initGUI() der superklasse)
 *						try {					// ...definiert alle grundlegenden eigenschaften vom GUI  
 *							...					// ...beinhaltet alle komponenten (wie buttons, textfields etc.)
 *						} catch (Exception e) {..}		// error handling
 *					}
 *					
 * [	JFC (java foundation classes)/Swing:	= verschiedene APIs für GUIs (= grafische benutzeroberflächen):
 * 		(siehe s.247)			18 SWING-API-PAKETE:	siehe s. 248/249		]
 * 
 * PROGRAMM: 	selbstgeneriertes JFrame durch Jigloo & Eclipse
 */

package uebungen09;

import javax.swing.SwingUtilities;			// "GUI"-methoden-package ?
import javax.swing.WindowConstants; 		// fensterkonstanten-package ?

public class Jigloo_Basics_CodeGenerieren_JFrame extends javax.swing.JFrame {	// von klasse JFrame erben
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {		// swingUtilities.: package in swing, invokeLater(): methode wird erst am ende der ereigniskette/programmablaufs gestartet
		SwingUtilities.invokeLater(new Runnable() {	// new Runnable(): konstruktor um neuen thread zu starten 
			public void run() {						// methode run(): eine methode von Runnable()
				Jigloo_Basics_CodeGenerieren_JFrame inst = new Jigloo_Basics_CodeGenerieren_JFrame();	// konstruktor dieser klasse aufrufen
				inst.setLocationRelativeTo(null);	// inst-objekt einmitten im bildschirm
				inst.setVisible(true);				// inst-objekt sichtbar setzen
			}
		});		// ungewohnte klammeranordnung weil methode run(){} innerhalb des konstruktors new Runnable() ist
	}
	
	public Jigloo_Basics_CodeGenerieren_JFrame() {	// konstruktor dieser klasse
		super();		// zugriff auf Konstruktor der Superklasse
		initGUI();		// zugriff auf initGUI()-methode dieser klasse (überschreibt initGUI() der superklasse)
	}					// initGUI() = initialisiert die grafische benutzeroberfläche
	
	private void initGUI() {		// überschreiben der methode initGUI() der superklasse
		try {						// try & catch: exception handling
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); // fensterschliessmethode
			pack();					// methode dass fenster mind so gross wie alle beinhaltetenelemente in ihrer originalgrösse
			setSize(400, 300);		// methode fenstergrösse für dieses objekt
		} catch (Exception e) {		// fehler: exception e
		    //add your error handling code here
			e.printStackTrace();	// ausgabe auf konsole des stacks-inhalts bei fehler
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
}
