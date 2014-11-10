/* TODO 12.1.2.   s.354-355
 * class File_JFileChooser_MitJigloo
 * 
 * 	MIT JIGLOO ERZEUGEN:	
 * 			
 * 		JFileChooser kann auch als komponente eines frames mit Jigloo automatisch erzeugt werden:  (hier: ohne weitere funktionen)
 * 
 * 		> Jigloo > more Components > JFileChooser einfach ins frame reinziehen
 *
 *	AUTO-GENETRIERTER CODE: 	siehe code ca zeile 50	
 *
 */

package uebungen12;

import javax.swing.JFileChooser;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

public class File_JFileChooser_MitJigloo extends javax.swing.JFrame {
	// wie andere komponenten auch:
	private JFileChooser jFileChooser1;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				File_JFileChooser_MitJigloo inst = new File_JFileChooser_MitJigloo();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public File_JFileChooser_MitJigloo() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			// genau gleich wie bei anderen komponenten: nur die rohe komponente ohne aktion
			{
				jFileChooser1 = new JFileChooser();
				getContentPane().add(jFileChooser1);
				jFileChooser1.setBounds(33, 27, 470, 326);
			}
			pack();
			this.setSize(686, 403);
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