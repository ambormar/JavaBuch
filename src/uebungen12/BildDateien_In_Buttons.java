/* TODO 12.4.1.   s.380, 	!!!!!!!!!!!!!!!!
 * class BildDateien_In_Buttons
 * 
 * 	BASICS SIEHE AUCH:		12.4.1.   BildDateien_In_Labels		s.378, 	 
 * 
 *  
 * 12.4.1 BILDER (-DATEIEN) IN BUTTONS:
 *  
 *  VORGEHEN:		siehe 
 *  
 *  	1. frame machen (in Jigloo-ansicht, GUI-form)
 *  		-> frame LAYOUT auf standardeinstellung BORDER belassen, 	NICHT unter layout auf absolute (wie bis anhin jeweils) stellen  
 *  
 *  	2. images (hier: gui_images) ordner innerhalb von src (source) (ordner der .java-dateien) im package explorer erstellen 
 *  		-> somit ist der gleiche gui_images ordner auch vorhanden im bin (binary) (ordner der .class-dateien) in der naviagtor ansicht 
 *  
 * 		3. .jpg, .gif oder .tif- bilddatei kopieren in einen dieser gui_images ordner (sollte automatisch auch im jeweiligen anderen, src oder bin, angezeigt werden)
 * 			-> die bilddatei muss sowohl innerhalb des src als auch des bin gespeichert (also an 2 orten der entwicklungsumgebung) sein: 	
 * 				damit das bild sowohl in der jigloo-vorschau als auch im gestarteten programm angezeigt wird 
 * 			[-> NB in anderen fällen sind die bilder glaub schon korrekt abgespeichert: 	-> in einem image-ordner auf gleicher ebene wie src (also wie bis anhin gemacht)]
 * 
 * 	!!!!!!!!!!!!! HIER WEITER !!!!!!!!!!!!!!!!!
 * 
 * 		4. button in den frame ziehen & den empfohlenen namen übernehmen
 * 			
 * 		5. in den properties des labels bei Icon klicken & via Öffnendialog die oben gespeicherte bilddatei wählen
 * 
 * 		NB: => so eingebundenes bild wird immer in originalgrösse angezeigt, d.h. es füllt einfach das label aus
 * 			  => verändert man die frame-grösse:	
 * 				1. frame kleiner als bild:		das bild in originalrösse wird nur teilweise angezeigt
 * 				2. frame grösser als bild:		gibts einen abstand zw. bild & framerahmen, standardmässig rechts, 
 * 					-> dort erscheint dann z.b. der labeltext..
 * 
 * 		6. labeltextanzeige ist verstellbar unter: 	jLabel1 > properties > horizontalTextPosition & verticalTextPosition
 * 			  										
 * 
 * 	KLASSE javax.swing.ImageIcon:		=> zur ausgabe von bildern in labels, buttons, panels
 * 										=> bildformate: .gif .jpeg .tif
 * 
 * 
 * 		BILDER ALS LOKAL GESPEICHERTE DATEIEN LADEN :		=> kann so auch in der jigloo-vorschau gesehen werden (wenn bilddateien unterhalb src gespeichert werden)
 * 															=> man kann die anwendung auch in ein .jar-file packen & als applet einsetzen (s.380)
 *  
 * 						BSP: 	jLabel1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("gui_images/gardaseeoel.jpg")));
 * 
 * 
 * 	 	BILDER MIT URL & IMPORT-ANWEISUNG AUS INTERNET, INTRANET & VON LOKALEN DATENTRÄGERN LADEN:
 * 
 * 						BSP:	import java.net.URL
 * 								jLabel1.setIcon(new ImageIcon(new URL("http://www....."))); 
 * 													
 * 						SIEHE:	12.4.1.   BildDatei_EinbindenMit_URL	s.380, 
 * 
 * 						=> einbinden von bilddatei aus lokalem datenträger C:\ hab ich nicht hingekriegt, bei allfälligem bedarf -> maja fragen
 * 						-> ist aber eh bitz bullshit, weil dann mach ich die bild-dateien doch besser gleich in den images-ordner  
 *  		
 * 						NACHTEILE:	1. bei der einbindung mit URL werden die bilder NICHT in der Jigloo-Vorschau angezeigt
 * 									2. anscheinend kann man bei der einbindung mit URL die anwendung nicht mehr in ein .jar-file packen & als applet einsetzen (s.380)
 * 										(-> keine genaueren infos zur zeit dazu ??!!) 
 *  
 * 				
 * 	KERN-CODE:		siehe initGUI():  jButton1 
 * 
 *
 */

package uebungen12;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;		// guck themen-speziefischer import (macht jigloo aber von selbst)
import javax.swing.JLabel;
import javax.swing.SwingConstants;	

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

public class BildDateien_In_Buttons extends javax.swing.JFrame {
	private JLabel jLabel1;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				BildDateien_In_Buttons inst = new BildDateien_In_Buttons();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public BildDateien_In_Buttons() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Frame mit Bild");
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1, BorderLayout.CENTER);
				jLabel1.setText("jLabel1");
				// anweisung zum laden der bilddatei: methode .setIcon(..), methode verlangt objekt der klasse ImageIcon; dieses objekt wird durch den mehrstufigen aufruf..
				// .. getClass().getClassLoader().getResource("datei+pfad als string") aus der bilddatei erzeugt [dank jigloo]
				jLabel1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("gui_images/gardaseeoel.jpg")));
					// [NB: man könnte dem konstruktor new ImageIcon() auch eifach ein bild-dateiname mit pfad übergeben, aber dann kann man die anwendung nicht mehr in ein .jar-file packen & als applet einsetzen ?!]
				jLabel1.setVerticalTextPosition(SwingConstants.CENTER); 	// zur positionierung des leabeltextes werden swing-konstanten
				jLabel1.setHorizontalTextPosition(SwingConstants.TRAILING);	// .. an die methoden setHori... & setVerti.. übergeben
			}	
			pack();
			setSize(500, 300);
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
