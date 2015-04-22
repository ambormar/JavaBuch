/* TODO 14.2.2.   s.450, eigene Version stoppuhr einsatz in gui-programm !!!!!!!!!!
 * class StoppuhrTest_VersionGuiProgramm	& 	Thread_VersionFuerGuiProgramme_Stoppuhr
 * 
 * 
 * 		BESONDERES:		DEPRECATION SUPPRESS WARNING VON ECLIPSE:
 * 				
 * 			=> warnung für elemente/anweisungen von java, die nicht mehr verwendet werden sollen, wiel sie demnächst abgeschafft werden
 * 
 * 					BSP: 	Thread.stop();		-> löst eine deprecation @suppress warning von eclipse aus,
 * 												-> methode stop() von Thread soll nichtmehr verwendet werden
 *  
 */

package uebungen14;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


public class StoppuhrTest_VersionGuiProgramm extends javax.swing.JFrame {

	private Thread_VersionFuerGuiProgramme_Stoppuhr stoppuhr = new Thread_VersionFuerGuiProgramme_Stoppuhr();		
	private JButton jBtnStop;
	private JButton jBtnStart;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				StoppuhrTest_VersionGuiProgramm inst = new StoppuhrTest_VersionGuiProgramm();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public StoppuhrTest_VersionGuiProgramm() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jBtnStart = new JButton();
				getContentPane().add(jBtnStart);
				jBtnStart.setText("Start Zeit");
				jBtnStart.setBounds(12, 12, 82, 45);
				jBtnStart.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnStartActionPerformed(evt);
					}
				});
			}
			{
				jBtnStop = new JButton();
				getContentPane().add(jBtnStop);
				jBtnStop.setText("Stopp Zeit");
				jBtnStop.setBounds(106, 12, 82, 45);
				jBtnStop.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnStopActionPerformed(evt);
					}
				});
			}
			pack();
			this.setSize(218, 106);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private void jBtnStartActionPerformed(ActionEvent evt) {
		stoppuhr.start();
	}
	
	private void jBtnStopActionPerformed(ActionEvent evt) {
		//stoppuhr.stop();						// löst eine deprecation @suppress warning von eclipse aus
		stoppuhr.setStartstop(false);			// saubere art den thread zu beenden:  via setter den boolean der while-schleife der klasse Thread_VersionFuerGuiProgramme_Stoppuhr
												// ... auf false setzen und so die schleife beenden 
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
