package uebungen09EigeneGuis;
/* TODO .9.5.1.   Eigenes GUI 2
 * class GUI_KomponentenUeberlagernMit_setVisible_TrueFalse
 * 
 * K&K:	GUI zum test von überlagerung von komponenten innerhalb des layouts
 * 		mit setVisible(false/true) werden komponenten die übereinander angeordnet sind ein-/ausgeblendet
 */


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

public class GUI_KomponentenUeberlagernMit_setVisible_TrueFalse extends javax.swing.JFrame {
	private JButton jButton1;
	private JButton jButton2;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				GUI_KomponentenUeberlagernMit_setVisible_TrueFalse inst = new GUI_KomponentenUeberlagernMit_setVisible_TrueFalse();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public GUI_KomponentenUeberlagernMit_setVisible_TrueFalse() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jButton1 = new JButton();
				getContentPane().add(jButton1);
				jButton1.setText("Button 1 führt zu Button 2 ");
				jButton1.setBounds(12, 12, 224, 38);
				jButton1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jButton1ActionPerformed(evt);
					}
				});
			}
			{
				jButton2 = new JButton();
				getContentPane().add(jButton2);
				jButton2.setText("Button 2 führt zu Button 1");
				jButton2.setBounds(38, 19, 205, 50); 
				jButton2.setVisible(false);				// button 2 am anfang unsichtbar gesetzt
				jButton2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jButton2ActionPerformed(evt);
					}
				});
			}
			pack();
			this.setSize(277, 125);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private void jButton1ActionPerformed(ActionEvent evt) {
		jButton1.setVisible(false);	          // sichtbarkeit der buttons auf klick umdrehen
		jButton2.setVisible(true);
	}
	
	private void jButton2ActionPerformed(ActionEvent evt) {
		jButton1.setVisible(true);				// sichtbarkeit der buttons auf klick umdrehen
		jButton2.setVisible(false);
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