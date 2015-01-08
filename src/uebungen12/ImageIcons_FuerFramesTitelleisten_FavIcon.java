/* TODO 12.4.1.   s.382, 	!!!!!!!!!!!!!!!!!!!!!!!
 * class ImageIcons_FuerFramesTitelleisten_FavIcon
 * 
 * 	SIEHE AUCH:		12.4.1.   BildDateien_In_Labels		s.378, 	 
 * 					12.4.1.   BildDateien_In_Buttons_setIcon_setRolloverIcon_setPressedIcon		s.380 	
 *  
 *  
 * 12.4.1 BILDER (-DATEIEN) ALS IMAGE-ICONS / FAVICONS FÜR FRAMES (TITELLEISTEN):
 *  
 *  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! 	AB HIER ÜBERARBEITEN 	!!!!!!!!!!!!!!!!!!!!!!!!!
 *  
 *  VORGEHEN:		
 *  
 *  	1. frame machen (in Jigloo-ansicht, GUI-form)
 *  		-> frame LAYOUT auf standardeinstellung BORDER belassen, 	NICHT unter layout auf absolute (wie bis anhin jeweils) stellen  
 *  
 *  	2. images (hier: gui_images) ordner innerhalb von src (source) (ordner der .java-dateien) im package explorer erstellen 
 *  		-> somit ist der gleiche gui_images ordner auch vorhanden im bin (binary) (ordner der .class-dateien) in der naviagtor ansicht 
 *  
 * 		3. .jpg, .gif oder .tif- bilddateien kopieren in einen dieser gui_images ordner (sollte automatisch auch im jeweiligen anderen, src oder bin, angezeigt werden)
 * 			-> die bilddateien müssen sowohl innerhalb des src als auch des bin gespeichert (also an 2 orten der entwicklungsumgebung) sein: 	
 * 				damit das bild sowohl in der jigloo-vorschau als auch im gestarteten programm angezeigt wird 
 * 			[-> NB in anderen fällen sind die bilder glaub schon korrekt abgespeichert: 	-> in einem image-ordner auf gleicher ebene wie src (also wie bis anhin gemacht)]
 * 
 * 		4. button in den frame ziehen & den empfohlenen namen übernehmen
 * 			
 * 		5. in den properties des buttons bei Icon, pressedIcon + rolloverIcon klicken & via Öffnendialog (gui_images ordner) die gewünschten bilddatein zuordnen 
 * 			  		
 * 
 * 
 * 	KERN-CODE:		genau siehe initGUI():  jButton1 
 * 
 * 
 * 
 * 	[REMEMBER:							
 * 
 * 	KLASSE javax.swing.ImageIcon:		=> zur ausgabe von bildern in labels, buttons, panels, "favicons" (= icon der frame titelleiste)
 * 										=> bildformate: .gif .jpeg .tif
 * 
 * 
 * 		BILDER ALS LOKAL GESPEICHERTE DATEIEN LADEN :		=> kann so auch in der jigloo-vorschau gesehen werden (wenn bilddateien unterhalb src gespeichert werden)
 * 															=> man kann die anwendung auch in ein .jar-file packen & als applet einsetzen (s.380)
 *  
 * 						BSP: 	jButton1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("gui_images/HPH.JPG")));
 * 
 * 	 	BILDER MIT URL & IMPORT-ANWEISUNG AUS INTERNET, INTRANET & VON LOKALEN DATENTRÄGERN LADEN:
 * 
 * 						BSP:	import java.net.URL
 * 								jButton1.setIcon(new ImageIcon(new URL("http://www....."))); 
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
 *  ]
 * 
 */

package uebungen12;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;		// guck themen-speziefischer import (macht jigloo aber von selbst)
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;	

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

public class ImageIcons_FuerFramesTitelleisten_FavIcon extends javax.swing.JFrame {
	private JLabel jLabel1;
	private JButton jButton1;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ImageIcons_FuerFramesTitelleisten_FavIcon inst = new ImageIcons_FuerFramesTitelleisten_FavIcon();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public ImageIcons_FuerFramesTitelleisten_FavIcon() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Frame mit Bild & Button");
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1, BorderLayout.CENTER);
				jLabel1.setText("jLabel1");
							// anweisung zum laden der bilddatei: methode .setIcon(..), methode verlangt objekt der klasse ImageIcon; dieses objekt wird durch den mehrstufigen aufruf..
							// .. getClass().getClassLoader().getResource("datei+pfad als string") aus der bilddatei erzeugt [dank jigloo]
				jLabel1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("gui_images/gardaseeoel.jpg")));
							// [NB: man könnte dem konstruktor new ImageIcon() auch eifach ein bild-dateiname mit pfad übergeben, aber dann kann man die anwendung nicht mehr in ein .jar-file packen & als applet einsetzen ?!]
			}	
			{
				jButton1 = new JButton();
				getContentPane().add(jButton1, BorderLayout.NORTH);
				jButton1.setText("Ende");
							// remember: anweisung zum laden der bilddatei: methode .setIcon(..), methode verlangt objekt der klasse ImageIcon; dieses objekt wird durch den mehrstufigen aufruf..
							// .. getClass().getClassLoader().getResource("datei+pfad als string") aus der bilddatei erzeugt [dank jigloo]
							// methode setIcon() für bild von button im normalzustand
				jButton1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("gui_images/HPH3.GIF")));
							// methode setPressedIcon() für bild von button im gedrückten zustand
				jButton1.setPressedIcon(new ImageIcon(getClass().getClassLoader().getResource("gui_images/HPH2.gif")));
							// methode setRolloverIcon() für bild von button beim drüberfahren
				jButton1.setRolloverIcon(new ImageIcon(getClass().getClassLoader().getResource("gui_images/HPH.JPG")));
				jButton1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jButton1ActionPerformed(evt);
					}
				});
			}
			pack();
			this.setSize(415, 360);
		} catch (Exception e) {
		    			//add your error handling code here
			e.printStackTrace();
		}
	}
	
	private void jButton1ActionPerformed(ActionEvent evt) {
		System.out.println("jButton1.actionPerformed, event="+evt);
		//add your code for jButton1.actionPerformed
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
