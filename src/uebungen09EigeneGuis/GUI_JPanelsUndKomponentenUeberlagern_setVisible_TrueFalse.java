package uebungen09EigeneGuis;
/* TODO .9.5.1.   Eigenes GUI 1
 * class GUI_JPanelsUndKomponentenUeberlagern_setVisible_TrueFalse
 * 
 * K&K:	GUI zum test von überlagerung von panels innerhalb des layouts
 * 		mit setVisible(false/true) werden panels die übereinander angeordnet sind ein-/ausgeblendet
 * 		und gleichzeitig die jeweiligen komponenten die in den panels platziert sind
 */



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

public class GUI_JPanelsUndKomponentenUeberlagern_setVisible_TrueFalse extends javax.swing.JFrame {
	private JPanel jPanel1;
	private JButton jButton1;
	private JTextField jTextField2;
	private JLabel jLabel2;
	private JTextField jTextField1;
	private JLabel jLabel1;
	private JButton jButton2;
	private JPanel jPanel2;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				GUI_JPanelsUndKomponentenUeberlagern_setVisible_TrueFalse inst = new GUI_JPanelsUndKomponentenUeberlagern_setVisible_TrueFalse();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public GUI_JPanelsUndKomponentenUeberlagern_setVisible_TrueFalse() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1);
				jPanel1.setBounds(0, 0, 328, 222);
				jPanel1.setLayout(null);
				{
					jButton1 = new JButton();
					jPanel1.add(jButton1);
					jButton1.setText("button 1 > panel 2");
					jButton1.setBounds(117, 89, 153, 23);
					jButton1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jButton1ActionPerformed(evt);
						}
					});
				}
				{
					jLabel1 = new JLabel();
					jPanel1.add(jLabel1);
					jLabel1.setText("label 1");
					jLabel1.setBounds(117, 118, 153, 21);
				}
				{
					jTextField1 = new JTextField();
					jPanel1.add(jTextField1);
					jTextField1.setText("textfeld 1");
					jTextField1.setBounds(117, 145, 153, 23);
				}
			}
			{
				jPanel2 = new JPanel();
				getContentPane().add(jPanel2);
				jPanel2.setBounds(60, 44, 324, 217);
				jPanel2.setLayout(null);
				jPanel2.setVisible(false);
				{
					jButton2 = new JButton();
					jPanel2.add(jButton2);
					jButton2.setText("button 2 > panel 1");
					jButton2.setBounds(38, 31, 152, 23);
					jButton2.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jButton2ActionPerformed(evt);
						}
					});
				}
				{
					jLabel2 = new JLabel();
					jPanel2.add(jLabel2);
					jLabel2.setText("label 2");
					jLabel2.setBounds(40, 59, 150, 16);
				}
				{
					jTextField2 = new JTextField();
					jPanel2.add(jTextField2);
					jTextField2.setText("textfeld 2");
					jTextField2.setBounds(40, 80, 150, 23);
				}
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private void jButton1ActionPerformed(ActionEvent evt) {
		jPanel1.setVisible(false);
		jPanel2.setVisible(true);
	}
	
	private void jButton2ActionPerformed(ActionEvent evt) {
		jPanel1.setVisible(true);
		jPanel2.setVisible(false);
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