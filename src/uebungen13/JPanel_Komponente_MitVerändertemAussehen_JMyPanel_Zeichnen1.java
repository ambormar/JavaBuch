/* TODO 13.1.2.   s.398+(400),
 * class JPanel_Komponente_MitVerändertemAussehen_JMyPanelZeichnen1		&	JMyPanel  	
 * 
 * 	
 * 
 * 
 * 
 * K&K:		Klasse JMyPanel 
 * 			Die Klasse ist von der Standardkomponente JPanel abgeleitet. 
 * 			Sie demonstriert das Verändern einer Standardkomponente durch das Einzeichnen einer diagonalen Linie.
 */

package uebungen13;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;



public class JPanel_Komponente_MitVerändertemAussehen_JMyPanel_Zeichnen1 extends javax.swing.JFrame {
	private JMyPanel jPanel1;
	private JButton jBtnEnde;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JPanel_Komponente_MitVerändertemAussehen_JMyPanel_Zeichnen1 inst = new JPanel_Komponente_MitVerändertemAussehen_JMyPanel_Zeichnen1();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public JPanel_Komponente_MitVerändertemAussehen_JMyPanel_Zeichnen1() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jPanel1 = new JMyPanel();
				getContentPane().add(jPanel1);
				jPanel1.setBounds(12, 12, 360, 204);
				jPanel1.setBackground(new java.awt.Color(64,128,128));
				jPanel1.setFont(new java.awt.Font("Serif",3,72));
			}
			{
				jBtnEnde = new JButton();
				getContentPane().add(jBtnEnde);
				jBtnEnde.setText("Ende");
				jBtnEnde.setBounds(126, 228, 138, 23);
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