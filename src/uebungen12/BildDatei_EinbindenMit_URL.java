/* TODO 12.4.1.   s.380,   eigenes beispiel 
 * class BildDatei_EinbindenMit_URL
 * 
 * KOMMENTARE SIEHE:	12.4.1.   BildDateien_In_Labels_Und_Buttons		s.378, 	
 * 						=> VORGEHEN	 allgemein   
 * 						=> KLASSE javax.swing.ImageIcon:
 * 									=> bilder mit URL und import-anweisung aus Internet, Intranet & von lokalen Datenträgern laden:
 * 
 * 											bsp:	import java.net.URL
 * 													jLabel1.setIcon(new ImageIcon(new URL("http://www.....")));
 * 
 * 									=> einbinden von bilddatei aus lokalem datenträger c:\ hab ich nicht hingekriegt, bei allfälligem bedarf -> maja fragen
 * 										-> ist aber eh bitz bullshit, weil dann mach ich die bild-dateien doch besser gleich in den images-ordner
 *  
 *  
 * NACHTEILE:	1. bei der einbindung mit URL werden die bilder NICHT in der Jigloo-Vorschau angezeigt
 * 				2. anscheinend kann man bei der einbindung mit URL die anwendung nicht mehr in ein .jar-file packen & als applet einsetzen (s.380)
 * 					(-> keine genaueren infos zur zeit dazu ??!!)
 * 
 */

package uebungen12;
import java.awt.BorderLayout;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import java.net.URL;			// guck themenspezifischer import
import javax.swing.ImageIcon;
import javax.swing.JLabel;



public class BildDatei_EinbindenMit_URL extends javax.swing.JFrame {
	private JLabel jLabel1;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				BildDatei_EinbindenMit_URL inst = new BildDatei_EinbindenMit_URL();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public BildDatei_EinbindenMit_URL() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1, BorderLayout.CENTER);
				jLabel1.setText("jLabel1");
				// anweisung zum laden der bilddatei: methode .setIcon(..), methode verlangt objekt der klasse ImageIcon & diese wiederum ein objekt der klasse URL..
				// ..welchem man eine url-adresse zu einer bilddatei im netz mitgibt
				jLabel1.setIcon(new ImageIcon(new URL("http://upload.wikimedia.org/wikipedia/de/thumb/5/5d/Steevies_Demobild.jpg/320px-Steevies_Demobild.jpg")));
			}
			pack();
			setSize(320, 213);	// die grösse des frames sollte der bildgrösse entsprechen (remember: siehe eigenschaften > ausmasse in px)
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