/* TODO .9.3. (9.3.1 & 9.3.2.)   s.266, 267
 * class Jigloo_Basics_KomponentenPalette_AllgemeinesHandling 
 *  
 * JIGLOO BASICS SIEHE AUCH: 			9.1.				Jigloo_Basics_CodeGenerieren_JFrame						s.256
 * 										9.2.1 - 9.2.11.		Jigloo_Basic_MethodenKlassenKonstruktoren_JFrame	   	ab s.261
 * JIGLOO KOMPONENTEN / EVENTS SIEHE:	9.3.1 - 9.3.13.  	JKomponenten_ActionListenerUSW_GUIFahrenheitCelsius		ab s.265
 * 
 * BSP CODE UNTEN:		ist nur autogenerierter code von Jigloo
 * 
 * STANDARDKOMPONENTEN IN FRAME EINBAUEN MIT JIGLOO-GUI (9.3.2. s.267) :		
 * 
 * 		1.	ERZEUGEN:		re-klick auf PROJEKT(/PACKAGE)ORDNER - NEW - OTHER - GUIFORMS - SWING - JFRAME
 * 
 * 		2.	CONTAINER-LAYOUT ANPASSEN:	
 * 				
 * 				- JFrame-Layout auf ABSOLUTE setzen (im seitenfenster: click auf JFrame -> Layout -> absolute)
 * 													(oder im code(initGUI): getContentPane().setLayout(null); 
 * 
 * 		3.	KOMPONENTEN HINZUFÜGEN (in der GUIform-ansicht) BSP:
 * 		
 * 				- ein klick auf Button im reiter Components des palettenmenues zum anwählen der komponente
 * 				- zweiter klick in die grüne umrandung im frame in der ansicht (ausserhalb des frames klicken, falls grüne umrandung nicht angezeigt wird)
 * 				- dialogfenster ausfüllen (bsp: name: jBTest, text: test-button)
 * 				- komponente anwählen und position und grösse mit drag-and-drop verändern
 * 	
 * KOMPONENTEN-PALETTE (9.3.1. s.266):		= Komponenten in 6 reitern nach gruppen sortiert:
 * 
 * 			CONTAINERS:			- enthält container die weitere container aufnehmen können	-> zur anordnung & verwaltung von komponenten
 * 			COMPONENTS:			- standardkomponenten (wie schaltflächen, buttons etc.)
 * 			MORE COMPONENTS:	- weitere komponenten (spezielle passworteingabefelder, scrollbalken etc.)
 * 			MENUE:				- komponenten zum aufbau von menu-strukturen
 * 			CUSTOM:				- nur ein symbol: ausgangsbasis für selbsterstellte komponenten (benutzerdefinierte klassen)
 * 			LAYOUT:				- layout-komponenten, die die anordnung der sichhtbaren komponenten bestimmen
 *  		
 * 
 */

package uebungen09;
import javax.swing.JButton;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

public class Jigloo_Basics_KomponentenPalette_AllgemeinesHandling extends javax.swing.JFrame {
	private JButton jBTest;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Jigloo_Basics_KomponentenPalette_AllgemeinesHandling inst = new Jigloo_Basics_KomponentenPalette_AllgemeinesHandling();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public Jigloo_Basics_KomponentenPalette_AllgemeinesHandling() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jBTest = new JButton();
				getContentPane().add(jBTest);
				jBTest.setText("Test");
				jBTest.setBounds(17, 23, 108, 38);
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
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