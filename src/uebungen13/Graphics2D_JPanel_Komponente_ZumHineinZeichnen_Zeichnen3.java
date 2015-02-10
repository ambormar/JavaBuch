/* TODO 13.2.4.   s.413, oben (2. ANSATZ)
 * class Graphics2D_JPanel_Komponente_ZumHineinZeichnen_Zeichnen3			s.413, 
 * 
 * 		SIEHE BASICS:		13.2.4.   Graphics2D_API_Klasse_Methoden_Basics												s.410
 * 
 * 		SIEHE AUCH:	 		13.2.1.   JPanel_Komponente_ZumHineinZeichnen_RadioGroup_getGraphics_Zeichnen2				s.403,	 (2. ANSATZ)
 *  		
 * 	[[[	SIEHE AUCH:			13.1.2.   JPanel_Komponente_MitVer�ndertemAussehen_JMyPanelZeichnen1	&	JMyPanel 		s.400+(398), 	(= 1. ANSATZ)	]]]
 * 
 * 
 * JPANEL (OD. AUCH JFRAME) ALS STANDARD-KOMPONENTE ZUM HINEINZEICHNEN:		(= 2. ANSATZ)
 * 
 * 			=> JPanel/JFrame mit Anchorlayout mit M�glichkeit f�r den anwender zum interaktiv hineinzeichnen
 * 		
 * 			=> MIT repaint() als button		= um die vorhandenen zeichnungen zu entfernen
 * 											= achtung: repaint() f�r jPanel nicht in der selben methode wo gezeichnet wird, sondern extra methode oder von ausserhalb 
 * 
 * 			=> OHNE repaint() f�rs frame	= wenn man den Frame verzieht / bewegt, verschwindet das gezeichnete
 * 
 * 
 * 		K&K:	 	Programm Zeichnen3 		
 * 					Unter Verwendung von Graphics2D statt Graphics	& 	mit AnchorLayout
 * 					Dem Anwender steht ein Panel, auf das er verschiedene geometrische Figuren zeichnen kann, zur Verf�gung. 
 * 					Position und Gr��e der Figuren k�nnen frei bestimmt werden.
 * 					Bei ver�ndern des frames durch den anwender verschwindet die zeichnung, weil der zeichnen-teil in dieser version nicht ge-repaintet werden kann
 * 
 * 		VORGEHEN:	1. frame mit JPanel, worauf das gezeichnete dargestellt wird
 * 
 * 					2. 4 positions-textfelder zur eingabe jeweils ben�tigten parameterwerte f�r die zeichenmethoden (x, y, h�he, breite)
 * 							-> werden nach programmlogik ein-/ausgeblendet & benannt
 * 
 * 					3. 3 buttons:	[=> wichtig alle vor buttongroup erstellen]
 * 									- zeichnen			=> zum ausl�sen des effektiven zeichenvorganges f�r die jeweiligen werte & auswahlen (checkbox + radiobuttons)
 * 									- zeichnung l�schen	=> actionlistener-methode mit:		jPanelZeichenflaeche.repaint()
 * 															-> repaint() muss hier ausserhalb der zeichnen-methode benutzt werden 
 * 															-> repaint() funktioniert nur um das panel zu l�schen, nicht f�r neuzeichnen bei frame-ver�derungen 			
 * 									- ende				=> beenden des programms 
 * 
 * 					4. 1 checkbox zum anh�ckeln ob formen gef�llt werden oder nicht						=> siehe CHECKBOX unten
 * 
 * 					5. 4 radiobuttons zum w�hlen der gew�nschten form (rechteck, kreis, oval, linie)	=> siehe RADIOBUTTONS unten		// wichtig: zuerst erstellen
 * 							-> inklusive event-methoden
 * 
 * 					6. ButtonGroup (= RadioGroup) um die radiobuttons einander zuzuordnen				=> siehe BUTTONGROUP unten		// wichtig: nacher erstellen
 * 																										=> siehe ZUORDNUNG DER RADIOBUTTONS ZUR RADIOGROUP unten
 * 
 * 					7. allgemeing�ltige Methode zum beschriften/anpassen der textfelder je nach radiobutton-auswahl (rechteck, kreis, oval oder linie!!)
 * 
 * 							=> CODE siehe:		private void setzeBeschriftungen(){..}
 * 
 *					8. die action-listener-methoden der radiobuttons 		-> rufen die methode setzeBeschriftung() auf (f�r die beschriftung)..
 *																			-> ..und steuern die sichtbarkeit der jeweils erw�nschten komponenten (checkbox & y2)
 * 								& -> char-variablen figur speichert den jeweilige anfangsbuchstaben der aktuellen geometrischen figur (L, O, R oder K) 
 * 										-> .. f�r switch-case der methode jBtnZeichnen..(..) 
 * 
 * 							=> CODE siehe: 		jRBtnReckteck..(..)		&	jRBtnLinie..(..)	&	jRBtnOval..(..)		&		jRBtnKreis..(..)
 * 		
 * 					9. methode zu zeichen der geometrischen figuren jBtnZeichnen:
 * 
 * 							=> auslesen der parameterwerte der textfelder in x1, x2, y1, y2
 * 							=> switch-case unter verwendung der, in char-variabel figur gespeicherten buchstaben (aus den action-listener-methoden der radiobuttons) 
 * 							=> pr�fen des checkbox-status bei den 2-dim figuren, ob gef�llt oder ungef�llt zeichnen 	
 * 									-> bsp:		if (jCheckBox.isSelected)
 * 							=> zeichenen der figuren	=> referenz auf Graphics mit .getGraphics() 	= zugriffs-methode aller komponenten (nachfahren der kalsse Component)
 * 														=> zeichenmethoden & die n�tigen parameterwerte		
 * 									-> bsp: 	jPanelZeichenflaeche.getGraphics.fillRect(x1, y1, x2. y2)
 * 	
 * 							=> CODE siehe:		private void jBtnZeichnen..(..)
 * 
 * 
 * 	JCHECKBOX:		
 * 
 * 			=> h�ckchen box
 * 			=> gut zur abfrage von wahrheitswert (true - false)
 * 
 * 			=> METHODE:		- isSelected()			=> um zu r�fen ob h�ckchen gesetzt ist (true - false)
 * 
 * 
 *	RADIOBUTTONS:
 *
 *			=> WICHTIG:		ZUERST die versch. RadioButtons erstellen, 	DANN die ButtonGroup (hier: BtnGrpFigure), 	DANN zuordnung der RadioButtons zur ButtonGroup
 *								-> sonst hat's eine meise und erstellt irgendwelche lustigen getters 
 *			=> normal mit Jigloo reinziehen
 *			
 *			=> METHODEN:		- setSelected()		=> um schaltfl�che auf angew�hlt zu setzen, (auch via properties)
 *								- isSelected()		=> um zu r�fen ob schaltfl�che ausgew�hlt ist (true - false)
 *
 *
 * 	BUTTONGROUP / RADIOGROUP:
 * 	
 * 			=> n�tig f�r zusammenspiel von mehreren RadioButtons, von denen nur einer aufs mal ausgew�hlt werden kann
 * 			=> egal wo reinziehen in den frame		-> wird NICHT dargestellt im GUI / initGUI()  
 * 													-> erscheint im outline unter non-visulal components  (nicht wie die anderen komponenten unter frame)
 * 			=> autoerzeugung der variablen oben durch jigloo  (hier: BtnGrpFigure)  
 * 			=> autoerzeugung der zugeh�rigen getter-methode durch jigloo 	-> getter-methoden-name setzt sich zusammen aus get + vergebenem variabel-namen
 * 					  
 * 
 * 			=> CODE:		
 * 
 * 				private ButtonGroup BtnGrpFigur;			// auto-erzeugte variable von jigloo, 
 * 
 *				public ButtonGroup getBtnGrpFigur() {		// Jigloo-erzeugt, methode liefert referenz auf die ButtonGroup
 *					if(BtnGrpFigur == null) {				// pr�ft ob bereits objekt erzeugt wurde..
 *						BtnGrpFigur = new ButtonGroup();	// .. wenn nicht, wird konstruktor aufgerufen (objekt erzeugt) ..
 *					}
 *					return BtnGrpFigur;						// .. und die referenz auf das objekt zur�ckgeliefert
 *				} 
 *
 *	ZUORDNUNG DER RADIOBUTTONS ZUR RADIOGROUP:
 *
 *			=> RadioGroup sorgt daf�r, dass nur ein RadioButton auf's mal ausgew�hlt sein kann
 *			=> jedem RadioButton in den properties unter eigenschaft buttonGroup die RadioGroup (hier: BtnGrpFigure) zuordnen 
 * 				
 * 			=> CODE:   		getBtnGrpFigure().add(jRBtnReckteck);		// bsp erg�nzung  im initGUI() um jRBtnRechteck der ButtonGroup BtnGrpFigur zuzuordnen
 * 																		// via getter-methode verschaft sich der frame zugriff auf die readiogroup (BtnGrpFigure)
 * 
 * 	METHODE GETGRAPHICS():		=> komponenten stammen von der klasse Component ab
 * 								=> mit getGraphics() erm�glicht so die klasse component so f�r alle komponenten zugriff auf Graphics 
 * 
 * 								=> bsp:		JPanelXY.getGraphics.drawLine(x1,y1,x2,y2)
 * 			
 * 
 */

package uebungen13;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

public class Graphics2D_JPanel_Komponente_ZumHineinZeichnen_Zeichnen3 extends javax.swing.JFrame {

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Graphics2D_JPanel_Komponente_ZumHineinZeichnen_Zeichnen3 inst = new Graphics2D_JPanel_Komponente_ZumHineinZeichnen_Zeichnen3();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public Graphics2D_JPanel_Komponente_ZumHineinZeichnen_Zeichnen3() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			pack();
			setSize(400, 300);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
