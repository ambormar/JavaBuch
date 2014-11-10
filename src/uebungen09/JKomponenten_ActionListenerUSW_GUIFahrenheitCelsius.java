/* TODO .9.3.1 - 9.3.13.   ab s.265
 * class JKomponenten_ActionListenerUSW_GUIFahrenheitCelsius
 * 
 * BSPe 9.3.1 - 9.3.13 GENAU:		siehe auch code unten 
 * 
 * JIGLOO GENERIERTES FRAME: 	- mischtechnik vorschaufenster & quelltext & outline(=seitenfenster)/GUIProperties
 * 
 * [ SWING-TUTORIAL:		beispielanwendungen zu allen Swing-komponenten:		siehe:	http://docs.oracle.com/javase/tutorial/		]
 * 
 * 9.3.1 KOMPONENTENPALETTE:	siehe: 	9.3.1    Jigloo_Basics_KomponentenPalette_AllgemeinesHandling	s.266
 * 
 * 9.3.2 STANDARD-KOMPONENTEN IN FRAME EINBAUEN: 	- layout auf absolute
 * 													- komponenten hinzufügen (1 klick in palette, 1 klick in grünen rahmen)
 * 													- dialogfenster ausfüllen 
 * 													- grösse & position mit drag&drop
 * 
 * 						- genau siehe:	 9.3.2  Jigloo_Basics_KomponentenPalette_AllgemeinesHandling	s.267
 * 
 * 9.3.3 LAYOUT FESTLEGEN:		- im seitenfenster/outline: 	click auf JFrame -> Layout -> absolute
 * 		(s.268) 				- im code (im initGUI): 		getContentPane().setLayout(null); 
 * 							[	- z.b. border-layout nicht: 	weil ausrichtung nach N,S,W,O & Center 	]
 * 							[	- auch möglich:					über layout in der komponentenpalette 	]
 * 
 * 9.3.4 KOMPONENTEN:	- j-komponenten wie variabeln der klasse deklarieren, Bsp:		private JLabel jLFahrenheit;	oben
 * 						- j-komponenten werden im initGUI() eingefügt, Bsp: 			{ jLFahrenheit = new JLabel(); ... }
 * 						- nach namen-schema:								typ: JButton ->	name: jBEnde ->	text: Ende
 * 
 * 9.3.5 LABEL:			- code-schema: 		siehe unten im initGUI()	
 * 					
 * 9.3.6 TEXTFIELD:		- code-schema: 		siehe unten im initGUI()	
 * 						- Editierbarkeit:	evtl. textfeld (für ergebnisanzeige) auf nicht editierbar setzen 
 *											-> am einfachsten über properties im outline-menue mit:		editable -	false
 *
 * 9.3.7 BUTTON:		- code-schema: 		siehe unten im initGUI()
 * 
 * 9.3.7b LOOK & FEEL:	= anderes aussehen fürs GUI  (s.277):
 * 								-> re-klick auf komponente in der vorschau-ansicht > set look & feel > versch. looks auswählen
 * 						- umstellen der L&F-voreinstellungen:	Menü > Window > Preferences > Jigloo GUI Builder > Look & Feel	
 * 
 * 9.3.8 + 9.3.13 EREIGNISSBEHANDLUNG / EVENT-HANDLING:
 * 
 * 		ALLGEMEIN:		- ACHTUNG bei mehrfach-erstellung von events spinnt Jigloo:  
 * 							-> fenster/klasse zu-auf		oder: -> nach jeder event-vergabe im richtigen moment (?) zwischenspeichern
 * 	
 * 		AktionListener():	= für alle arten von actions, bsp: klick auf button			
 * 		
 * 							- Jigloo: komponente markieren > (outline) event > ActionListener > actionPerformed > handler method	(inline wäre andere code-darstellung)
 * 							-> erstellt: 1. jBtnName.addActionListener(..) im initGUI():		// unverändert lassen		
 * 										 2. methode jBtnNameActionPerformed(..){..} unten: 		// zur implementierung eigener anweisungen 
 * 											! tipp: eigene anweisungen aus der autogenerierten methode auslagern	bsp: jBtnUmrechnenActionPerformed(..){ umrechnen() }    
 * 										
 * 							- code genau siehe unten (im initGUI & bei den methoden der klasse)
 * 	
 * 		KeyListener():		= für alle Tasteneingaben, z.b.: entertaste 
 * 
 * 							- Jigloo: komponente markieren > (outline) event > KeyListener > keyPressed (**) > handler method	
 * 								[**: keyPressed = bei tastendrücken / keyReleased = bei tastenloslassen / keyTyped = nur bei unicode-zeichen-tasten ]
 * 							
 * 							-> erstellt: 1. jTFName.addKeyListener(..) im initGUI()..:			// unverändert lassen		
 * 										 2. methode jTFNameKeyPressed(KeyEvent evt){	 		// methode zur implementierung eigener anweisungen 
 * 												if ( evt.getKeyCode() == KeyEvent.VK_ENTER){	// => diese zeile selber schreiben, hier: falls Entertaste gedrückt wird 
 * 													umrechnen()									// sonstige eigene anweisungen auslagern	
 * 												}
 * 
 * 							- code genau siehe unten (im initGUI & bei den methoden der klasse)
 * 
 * 		9.3.9 EIGENE ANWEISUNGEN: 	-> anweisungen aus der autogenerierten methode auslagern	
 * 					(s.282)												bsp: jBtnUmrechnenActionPerformed(..){ umrechnen() } 	
 * 									-> einfachste anweisungen in der autogenerierten methode belassen	
 * 																		bsp: jBtnEndedActionPerformed(..){ System.exit(0) } 
 * 
 * WEITERE NÜTZLICHE METHODEN / ANWEISUNGEN / KLASSEN:
 * 
 * 		- getText()		Bsp:	wert = Double.parseDouble(jTFFahrenheit.getText())		// 9.3.10 werte aus textfeldern übernehmen
 * 
 * 		- String.valueOf(wert)		Bsp:	jTFCelsius(setText(String.valueOf(wert))	// 9.3.11 werte in textfelder einfügen		
 * 
 * 		- System.exit(0)	Bsp:	jBtnEndedActionPerformed(..){ System.exit(0)}		// 9.3.11 programm beenden & fenster schliessen
 * 							-> (0) steht für fehlerloses beenden eines programms	
 * 							-> kann man auch mit try-catch an unterschiedlichen stellen ins programm einbauen mit unterschiedlichem fehlercode ((1) usw.), für fehlerfindung
 * 
 * 		- DecimalFormat f = new DecimalFormat("#0.00");		// 9.3.12 zahlenausgabe mit formatierung
 * 		  jTFCelsius.setText(f.format(wert));	
 * 							
 * 			-> objekt d.Kl. Decimalformat mit Formatstring als argument (# = ziffer oder nix, 0= ziffer oder null, hier= beliebig lange zahl mit 2 nachkommastellen)
 * 
 * 			-> siehe genau:  unten 	oder 	9.3.12	class DecimalFormat_FormatierteZahlausgabe	ab s.286

 * 		
 * 		- requestFocus() 	// 9.3.13	methode um den fokus zu setzen, z.b. ins textfeld, 		bsp: jTFCelsius.requestFocus()
 * 
 * 		- selectAll()  		// 9.3.13	methode um alles anzuwählen , z.b. in einem textfeld,	bsp: jTFCelsius.selectAll()
 * 					
 * 		- setEditable()		// 9.3.6	methode um z.b. textfeld nicht editierbar zu setzen,	bsp: jTFCelsius.setEditable(false);
 *											-> auch über properties im outline-menue mit:		editable -	false
 *   
 * K&K:		programmfenster erstellen zur umrechnung von Fahrenheit in celsius mit textfeld eingabe
 * 			& buttons zur berechnung & anzeige in textfeld
 */

package uebungen09;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

public class JKomponenten_ActionListenerUSW_GUIFahrenheitCelsius extends javax.swing.JFrame {

	{	// 9.3.7b, s.277
		// Set Look & Feel: > re-klick auf komponente in der vorschau > set look & feel > versch. looks
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

			// 9.3.4 alle j-komponenten als eigenschaften der klasse (wie variabeln)
	private JLabel jLFahrenheit;
	private JTextField jTFFahrenheit;
	private JLabel jLCelsius;
	private JTextField jTFCelsius;
	private JButton jBtnEnde;
	private JButton jBtnUmrechnen;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JKomponenten_ActionListenerUSW_GUIFahrenheitCelsius inst = new JKomponenten_ActionListenerUSW_GUIFahrenheitCelsius();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public JKomponenten_ActionListenerUSW_GUIFahrenheitCelsius() {
		super();
		initGUI();
	}
	
	// 9.3.4 alle GUI-elemente werden in initGUI() eingefügt
	private void initGUI() { 
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
					// 9.3.3 layout festlegen, (null) ist absolute-standard-layout
			getContentPane().setLayout(null);
					// 9.3.5 label
			{					// klammern nicht erforderlich, aber für übersichtlichkeit
				jLFahrenheit = new JLabel();
				getContentPane().add(jLFahrenheit);// containerErmitteln().addiere(komponente)
				jLFahrenheit.setText("Grad Fahrenheit");
				jLFahrenheit.setBounds(35, 22, 111, 16);// (x-/y-koordinaten oben li & unten re)
			}
					// 9.3.6 textfield
			{
				jTFFahrenheit = new JTextField();
				getContentPane().add(jTFFahrenheit);
				jTFFahrenheit.setBounds(36, 44, 162, 23);
					// 9.3.13 s.290, mit entertaste eingabe ins textfeld bestätigen
				jTFFahrenheit.addKeyListener(new KeyAdapter() {	//analog ActionListener siehe unten
					public void keyPressed(KeyEvent evt) {
						jTFFahrenheitKeyPressed(evt);
					}
				});
			}
			{
				jLCelsius = new JLabel();
				getContentPane().add(jLCelsius);
				jLCelsius.setText("Grad Celsius");
				jLCelsius.setBounds(35, 91, 111, 16);
			}
			{
				jTFCelsius = new JTextField();
				getContentPane().add(jTFCelsius);
				jTFCelsius.setBounds(35, 113, 162, 23);
				jTFCelsius.setEditable(false);	// 9.3.6 textfeld auf nicht editierbar setzen (für ergebnisanzeige)..
			}									// ...am einfachsten über properties im outline-menue: editable false
					// 9.3.7 buttons
			{
				jBtnUmrechnen = new JButton();
				getContentPane().add(jBtnUmrechnen); // ermittleContainer().addiere(komponente) 
				jBtnUmrechnen.setText("Umrechnen");
				jBtnUmrechnen.setBounds(233, 44, 113, 23);
					// 9.3.8 ereignisbehandlung: addActionListener(); 
					// Jigloo: komponente markieren > (outline) event > ActionListener > actionPerformed > handler method
				jBtnUmrechnen.addActionListener(new ActionListener() { // addActionListener = methode von button; mit neuem objekt ActionListener als Parameter
					public void actionPerformed(ActionEvent evt) { // methode vom ActionListener registriert event evt
						jBtnUmrechnenActionPerformed(evt); // methode für diese (this.) klasse zum selbst implementieren unter weitergabe des events evt
					}
				});		// runde klammer beendet addActionListener-methode
			}
			{
				jBtnEnde = new JButton();
				getContentPane().add(jBtnEnde);
				jBtnEnde.setText("Ende");
				jBtnEnde.setBounds(233, 113, 112, 23);
					//9.3.8
				jBtnEnde.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnEndeActionPerformed(evt);
					}
				});
			}
			pack();
			this.setSize(400, 209);
			this.setTitle("Umrechnung Grad Fahrenheit in Celsius");
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
		// 9.3.8 ereignisbehandlung: Jigloo generierte ActionPerformed() methode; siehe 9.3.8 oben
	private void jBtnUmrechnenActionPerformed(ActionEvent evt) { // methode vom actionlistener zur implementierung eigener anweisungen
		umrechnen(); 											// auslagern von selbest implementierten anweisungen besser
		
		/*System.out.println("jBtnUmrechnen.actionPerformed, event="+evt); */		// bsp. für ausgabe von getätigtem event:
	}
		
	private void jBtnEndeActionPerformed(ActionEvent evt) {
		// 9.3.11 (am schluss) programm beenden
		System.exit(0);	// s.285 System.exit(0): um Programm regulär ohne Fehler zu beenden
						// System.exit(zahl): an unterschiedlichen stellen für Programm-
						// abbruch im fehlerfall > identifikation der fehlerstelle  	
	}					// maja fragen wie genau die fahlerzahl ausgabe???
	
	private void jTFFahrenheitKeyPressed(KeyEvent evt) {
		if ( evt.getKeyCode() == KeyEvent.VK_ENTER){			// z.B: if (evt.getKeyCode() == ...) {anweisung x;}
			umrechnen();										// eigene ausgelagerte methode aufrufen
		}
	}

	private void umrechnen() { // eigene methode weil an 2 orten benötigt: für button & für textfeld + enter 
			// 9.3.9 programmierung der umrechnung, (anweisungen hier ausführen egal wie der event)
		double tf, tc;										// tempfahrenheit & tempcelsius, variabeln nur innerhalb der methode nötig
		tf = Double.parseDouble(jTFFahrenheit.getText());	// 9.3.10 wert aus textfeld übernehmen
		tc = (tf-32) * 5/9; 								// formel zur berechnung c in f
			// 9.3.11 wert in textfield übertragen
		//jTFCelsius.setText(String.valueOf(tc));    wird ersetzt durch ausgabe mit formatangabe 9.3.12
			// 9.3.12 zahlenausgabe mit formatierung (anstelle von 9.3.11)
		DecimalFormat f = new DecimalFormat("#0.00"); 	// objekt d.Kl. Decimalformat mit Formatstring als argument (# = ziffer oder nix, 0= ziffer oder null, hier= beliebig lange zahl mit 2 nachkommastellen)
		jTFCelsius.setText(f.format(tc));				// methode format() liefert zahlwert via (objekt f) im gewünschten format als text zurück
			// 9.3.13 requestFocus() & selectAll() damit nach umrechnung textfeld F. direkt wieder fokusiert & angewählt ist
		jTFFahrenheit.requestFocus(); 
		jTFFahrenheit.selectAll();	
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
