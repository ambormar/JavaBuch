/* TODO 12.3.5.   s.374, (ZeichenOrientierte Datenstreams)		!!!!!!!!!!!!!!!!!!!
 * class IO_VerschluesseltWriter_VerschluesseltReader_Textverschluesselung 
 * 
 * SIEHE AUCH:		FILTERWRITER BASICS:		12.3.3.   FilterWriter_Basics_Methoden_Konstruktor		s.370
 * 					VERSCHLUESSELTWRITER		12.3.3.   VerschluesseltWriter extends FilterWriter		s.370 
 * 					FILTERREADER BASICS:		12.3.4.   FilterReader_Basics_Methoden_Konstruktor		s.372 
 * 					VERSCHLUESSELTREADER:		12.3.4.   VerschluesseltReader extends FilterReader		s.373 
 * 
 * 	HIER WEITER MACHEN, s.274: frame für textverschlüsselung machen, orientieren an Jigloo_Events_Gui...., kommentare schreiben
 * 
 */

package uebungen12;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


public class IO_VerschluesseltWriter_VerschluesseltReader_Textverschluesselung extends javax.swing.JFrame {

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				IO_VerschluesseltWriter_VerschluesseltReader_Textverschluesselung inst = new IO_VerschluesseltWriter_VerschluesseltReader_Textverschluesselung();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public IO_VerschluesseltWriter_VerschluesseltReader_Textverschluesselung() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Textverschlüsselung");
			getContentPane().setLayout(null);			// hahaa layout auf absolute setzen nit vergessen
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
