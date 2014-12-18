/* TODO 12.4.1.   s.378, 	
 * class Bilder_In_Labels_Und_Buttons
 *  
 *  WEITERMACHEN MIT CODE, BUCH & KOMMENTAREN:
 *  
 *  stichworte bis jetzt vorgehen:
 *  
 *  	- frame machen (remember: package explorer > re-klick ordner > new > other > 
 *  		(neues fenster) > gui forms > swing > jFrame > (neues fenster) klassen namen geben
 *  		-> frame NICHT unter layout auf absolute (wie bis anhin jeweils) stellen, Sondern auf standardeinstellung BORDER belassen 
 *  
 *  	- gui_images ordner innerhalb von src (source) (ordner der .java dateien) im package explorer erstellen 
 *  		-> somit ist der gleiche gui_images ordner auch vorhanden im bin (binary) (ordner der .class dateien) der naviagtor ansicht 
 *  
 * 		- .jpg oder .giff bilddatei kopieren in einen dieser gui_images ordner (sollte automatisch auch im jeweiligen anderen src oder bin angezeigt werden
 * 			-> die bilddatei muss sowohl innerhalb des src als auch des bin gespeichert (also an 2 orten der entwicklungsumgebung) sein: 	
 * 				damit das bild sowohl in der jigloo-vorschau als auch im gestarteten programm angezeigt wird 
 * 			(-> NB in anderen fällen sind die bilder glaub schon korrekt abgespeichert: 	-> in einem image-ordner auf gleicher ebene wie src (also wie bis anhin gemacht))
 * 
 * 		- label in den frame ziehen & den empfohlenen namen übernehmen
 * 			=> in den properties des labels bei Icon klicken & via Öffnendialog die oben gespeicherte bilddatei wählen
 * 
 * 
 * 
 */

package uebungen12;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

public class Bilder_In_Labels_Und_Buttons extends javax.swing.JFrame {
	private JLabel jLabel1;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Bilder_In_Labels_Und_Buttons inst = new Bilder_In_Labels_Und_Buttons();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public Bilder_In_Labels_Und_Buttons() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1, BorderLayout.CENTER);
				jLabel1.setText("jLabel1");
				jLabel1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("gui_images/gardaseeoel.jpg")));
				jLabel1.setPreferredSize(new java.awt.Dimension(279, 662));
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
