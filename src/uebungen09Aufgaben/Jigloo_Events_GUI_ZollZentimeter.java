package uebungen09Aufgaben;
/* TODO .9.4.   Aufgabe 1, s.295 
 * Klasse Jigloo_Events_GUI_ZollZentimeter
 * 
 * KeyListener, ActionListener, frame layout absolute mit buttons, labels, textfelder
 * sonstiges: requestFocus(), selectAll(), System.exit(0), setTitle(), getKeyCode(), DecimalFormat("#0.00")  
 * 
 * K&K:	Programm Zoll_Zentimeter zur Umrechnung einer Längenangabe
 */



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

public class Jigloo_Events_GUI_ZollZentimeter extends javax.swing.JFrame {
	private JLabel jLZoll;
	private JLabel jLZentimeter;
	private JButton jBtnUmrechnen;
	private JButton jBtnEnde;
	private JTextField jTFZoll;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Jigloo_Events_GUI_ZollZentimeter inst = new Jigloo_Events_GUI_ZollZentimeter();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public Jigloo_Events_GUI_ZollZentimeter() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Umrechnung von Zoll in Zentimeter");
			getContentPane().setLayout(null);							// layout auf absolute
			{
				jLZoll = new JLabel();
				getContentPane().add(jLZoll);
				jLZoll.setText("Zoll");
				jLZoll.setBounds(64, 21, 100, 16);
			}
			{
				jTFZoll = new JTextField();
				getContentPane().add(jTFZoll);
				jTFZoll.setBounds(64, 43, 100, 24);
				jTFZoll.addKeyListener(new KeyAdapter() {
					public void keyPressed(KeyEvent evt) {
						jTFZollKeyPressed(evt);
					}
				});
			}
			{
				jLZentimeter = new JLabel();
				getContentPane().add(jLZentimeter);
				jLZentimeter.setBounds(220, 43, 100, 24);
				jLZentimeter.setText("0 cm");
			}
			{
				jBtnUmrechnen = new JButton();
				getContentPane().add(jBtnUmrechnen);
				jBtnUmrechnen.setText("Umrechnen");
				jBtnUmrechnen.setBounds(64, 95, 100, 23);
				jBtnUmrechnen.addActionListener(new ActionListener() { 
					public void actionPerformed(ActionEvent evt) {
						jBtnUmrechnenActionPerformed(evt);
					}
				});
			}
			{
				jBtnEnde = new JButton();
				getContentPane().add(jBtnEnde);
				jBtnEnde.setText("Ende");
				jBtnEnde.setBounds(220, 95, 100, 23);
				jBtnEnde.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnEndeActionPerformed(evt);
					}
				});
			}
			pack();    
			this.setSize(400, 191);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
		
	}
	
	private void umrechnen() {
		double zoll, cm;
		zoll = Double.parseDouble(jTFZoll.getText());
		cm = zoll * 2.54;
		DecimalFormat f = new DecimalFormat("#0.00");
		jLZentimeter.setText(f.format(cm) + " cm");
		jTFZoll.requestFocus();
		jTFZoll.selectAll();	
	}
	
	private void jBtnUmrechnenActionPerformed(ActionEvent evt) {
		umrechnen();
	}
	
	private void jTFZollKeyPressed(KeyEvent evt) {
		if (evt.getKeyCode() == KeyEvent.VK_ENTER){
			umrechnen();
		}
	}
	
	private void jBtnEndeActionPerformed(ActionEvent evt) {
		System.exit(0);	// programm korrekt beenden
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