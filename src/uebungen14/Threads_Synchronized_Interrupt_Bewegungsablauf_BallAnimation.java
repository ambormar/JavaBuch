/* TODO 14.2.4.   s.454, (verwendet JBallPanel_..) !!!!!!!!!
 * class JBallPanel_Synchronized_Therads & 		Threads_Synchronized_Interrupt_Bewegungsablauf_BallAnimation
 * 
 * 
 * 
 * ALLE KOMMENTAR REINKOPIEREN VON JBALLPANEL !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * 
 * 
 * 			
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */

package uebungen14;
import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


public class Threads_Synchronized_Interrupt_Bewegungsablauf_BallAnimation extends javax.swing.JFrame {
	
	private JBallPanel_Synchronized_Therads jPanel1;	// JPanel ersetzen durch custom-klasse JBallPanel_.. mit name jPanel1
	private JButton jBtnStart;
	private JButton jBtnStop;
	private Thread t;									// Thread instanz t deklarieren
									
	
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Threads_Synchronized_Interrupt_Bewegungsablauf_BallAnimation inst = new Threads_Synchronized_Interrupt_Bewegungsablauf_BallAnimation();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public Threads_Synchronized_Interrupt_Bewegungsablauf_BallAnimation() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			AnchorLayout thisLayout = new AnchorLayout();
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("BallAnimation");
			this.addWindowListener(new WindowAdapter() {		// neuer WindowListener fürs frame..
				public void windowClosed(WindowEvent evt) {		// .. mit handler methode für EventHandling bei windoClosed (wenn fenster geschlossen)
					thisWindowClosed(evt);
				}
			});
			{
				jBtnStop = new JButton();
				getContentPane().add(jBtnStop, new AnchorConstraint(834, 811, 908, 610, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jBtnStop.setText("Stopp");
				jBtnStop.setPreferredSize(new java.awt.Dimension(77, 23));
				jBtnStop.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnStopActionPerformed(evt);
					}
				});
			}
			{
				jBtnStart = new JButton();
				getContentPane().add(jBtnStart, new AnchorConstraint(834, 399, 908, 204, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jBtnStart.setText("Start");
				jBtnStart.setPreferredSize(new java.awt.Dimension(75, 23));
				jBtnStart.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnStartActionPerformed(evt);
					}
				});
			}
			{
				jPanel1 = new JBallPanel_Synchronized_Therads();
				getContentPane().add(jPanel1, new AnchorConstraint(56, 951, 735, 50, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jPanel1.setPreferredSize(new java.awt.Dimension(350, 212));
			}
			pack();
			this.setSize(400, 350);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private void jBtnStartActionPerformed(ActionEvent evt) {	// handler method jBtn Start
		if (t == null) {										// fehlerbehebung (der buchversion): vom zusätzlichen thread soll sich nur EINE INSTANZ erzeugen lassen
																// ..keine weiteren instanzen (die dazu führten, dass sich der ball immer mehr verschnellert & nicht mehr stoppen lässt)
			t = new Thread(jPanel1);							// thread-objekt erzeugen mit parameter Runnable Target (jPanel1) (=> konstruktor erzeugt einen Thread, der die run-methode von target ausführt)
		}
		t.start();												// thread starten
	}
	
	private void jBtnStopActionPerformed(ActionEvent evt) {		// handler methode JBtn stopp 
		t.interrupt();											// thread anhalten (stop() gibt's nicht bzw. ist nicht erlaubt)
		t = null;												// fehlerbehebung (buchversion) EINZIGE INSTANZ vom zusätzlichen thread auf null setzen (= löschen), sodass man.. 
	}															// .. mit dem startbutton immer nur wieder EINE INSTANZ vom zusätzlichen thread erzeugen
	
	// event handler method für wenn das frame geschlossen wurde ohne dass zuvor der Thread angehalten ist. sonst läuft der thread einfach weiter (siehe console roter knopf) 
	private void thisWindowClosed(WindowEvent evt) {			
		t.interrupt();											// thread anhalten (nach fensterschliessen) falls er nicht schon vorher	angehalten wurde
		t = null;												// wäre nicht mal unbedingt nötig
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