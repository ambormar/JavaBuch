/* TODO 14.3.5.   Aufgabe 5 + 6,   s.460/461, (extends JFrame, verwendet JBallonPanel) analog _..BallAnimation
 * class 	.._Ballonfangen		&	JBallonPanel
 * 
 * 
 * 
 * 
 */		

package uebungen14Aufgaben;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


public class Ballonfangen extends javax.swing.JFrame {
	
	private JBallonPanel jPanel1;
	private JLabel jLTreffer;
	private JButton jBtnStopp;
	private JButton jBtnNeu;
	private Thread t;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Ballonfangen inst = new Ballonfangen();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public Ballonfangen() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			AnchorLayout thisLayout = new AnchorLayout();
			getContentPane().setLayout(thisLayout);
			this.setTitle("Ballonfangen");
			{
				jBtnStopp = new JButton();
				getContentPane().add(jBtnStopp, new AnchorConstraint(891, 651, 934, 471, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jBtnStopp.setText("Stopp");
				jBtnStopp.setPreferredSize(new java.awt.Dimension(141, 22));
				jBtnStopp.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnStoppActionPerformed(evt);
					}
				});
			}
			{
				jBtnNeu = new JButton();
				getContentPane().add(jBtnNeu, new AnchorConstraint(893, 935, 936, 740, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jBtnNeu.setText("Neues Spiel");
				jBtnNeu.setPreferredSize(new java.awt.Dimension(153, 22));
				jBtnNeu.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnNeuActionPerformed(evt);
					}
				});
			}
			{
				jLTreffer = new JLabel();
				getContentPane().add(jLTreffer, new AnchorConstraint(848, 348, 893, 26, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jLTreffer.setPreferredSize(new java.awt.Dimension(253, 23));
				jLTreffer.setText("Treffer: 0 von 0 Versuchen");
				jLTreffer.setBackground(new java.awt.Color(255,255,255));
				jLTreffer.setOpaque(true);
				jLTreffer.setForeground(new java.awt.Color(255,0,0));
			}
			{
				jPanel1 = new JBallonPanel();
				getContentPane().add(jPanel1, new AnchorConstraint(22, 987, 817, 13, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jPanel1.setPreferredSize(new java.awt.Dimension(764, 406));
			}
			pack();
			this.setSize(800, 550);
			t = new Thread(jPanel1);								// zusätzlichen thread von anfang an erzeugen.. 
		    t.start();												// .. + starten, womit auch das spiel, mit fensteröffnen schon beginnt
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private void jBtnNeuActionPerformed(ActionEvent evt) {
		if (t == null){												// verhindern, dass der zusätzliche thread mehrfach erzeugt (wird und das tempo des spielis spinnt)
			t = new Thread(jPanel1);								// zusätzlichen thread t via run()-methode von JBallonPanel erzeugen + ..
			t.start();												// .. thread starten & somit spiel starten	
			jPanel1.resetBallonZaehler();							// beim neu starten des spiels ballonzähler reseten
		}
		
	}
	
	private void jBtnStoppActionPerformed(ActionEvent evt) {
		t.interrupt();											// laufenden thread t unterbrechen
		
		t = null;
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