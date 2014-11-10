package uebungen09Aufgaben;
/* TODO .9.4.   Aufgabe 4, s.296 
 * Klasse Jigloo_Events_GUI_TaschenRechner
 * 
 * 		///	KeyListener, ActionListener, frame layout absolute, mit buttons, labels, textfelder
 * 		///	sonstiges: requestFocus(), selectAll(), System.exit(0), setTitle(), getKeyCode(), setEditable(false)  
 * 
 * K&K:	Programm TaschenRechner als Mini-Taschenrechner für die vier Grundrechenarten. 
 */


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

public class Jigloo_Events_GUI_TaschenRechner extends javax.swing.JFrame {
	private JLabel jLOperand1;
	private JButton jBtnMinus;
	private JTextField jTFErgebnis;
	private JLabel jLErgebnis;
	private JButton jBtnGeteilt;
	private JButton jBtnMal;
	private JButton jBtnPlus;
	private JTextField jTFOperand2;
	private JTextField jTFOperand1;
	private JLabel jLOperand2;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Jigloo_Events_GUI_TaschenRechner inst = new Jigloo_Events_GUI_TaschenRechner();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public Jigloo_Events_GUI_TaschenRechner() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jLOperand1 = new JLabel();
				getContentPane().add(jLOperand1);
				jLOperand1.setText("Operand 1");
				jLOperand1.setBounds(12, 12, 93, 16);
			}
			{
				jLOperand2 = new JLabel();
				getContentPane().add(jLOperand2);
				jLOperand2.setText("Operand 2");
				jLOperand2.setBounds(231, 12, 93, 16);
			}
			{
				jTFOperand1 = new JTextField();
				getContentPane().add(jTFOperand1);
				jTFOperand1.setBounds(12, 34, 93, 23);
				jTFOperand1.addKeyListener(new KeyAdapter() {
					public void keyPressed(KeyEvent evt) {
						jTFOperand1KeyPressed(evt);
					}
				});
			}
			{
				jTFOperand2 = new JTextField();
				getContentPane().add(jTFOperand2);
				jTFOperand2.setBounds(231, 34, 93, 23);
			}
			{
				jBtnPlus = new JButton();
				getContentPane().add(jBtnPlus);
				jBtnPlus.setText("+");
				jBtnPlus.setBounds(117, 34, 46, 23);
				jBtnPlus.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnPlusActionPerformed(evt);
					}
				});
			}
			{
				jBtnMinus = new JButton();
				getContentPane().add(jBtnMinus);
				jBtnMinus.setText("-");
				jBtnMinus.setBounds(174, 34, 46, 23);
				jBtnMinus.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnMinusActionPerformed(evt);
					}
				});
			}
			{
				jBtnMal = new JButton();
				getContentPane().add(jBtnMal);
				jBtnMal.setText("*");
				jBtnMal.setBounds(117, 68, 46, 23);
				jBtnMal.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnMalActionPerformed(evt);
					}
				});
			}
			{
				jBtnGeteilt = new JButton();
				getContentPane().add(jBtnGeteilt);
				jBtnGeteilt.setText("/");
				jBtnGeteilt.setBounds(174, 68, 46, 23);
				jBtnGeteilt.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnGeteiltActionPerformed(evt);
					}
				});
			}
			{
				jLErgebnis = new JLabel();
				getContentPane().add(jLErgebnis);
				jLErgebnis.setText("Ergebnis");
				jLErgebnis.setBounds(12, 98, 93, 16);
			}
			{
				jTFErgebnis = new JTextField();
				getContentPane().add(jTFErgebnis);
				jTFErgebnis.setBounds(12, 120, 312, 23);
				jTFErgebnis.setEditable(false);				// anwender kann nix ins textfeld eintragen
			}
			pack();
			this.setSize(352, 209);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private void jTFOperand1KeyPressed(KeyEvent evt) {
		if (evt.getKeyCode() == KeyEvent.VK_ENTER){
			jTFOperand2.requestFocus();
			jTFOperand2.selectAll();
		}
	}
	
	private void jBtnPlusActionPerformed(ActionEvent evt) {
		double x, y, z;
		x = Double.parseDouble(jTFOperand1.getText());
		y = Double.parseDouble(jTFOperand2.getText());
		z = x + y;
		jTFErgebnis.setText(x + " + " + y + " = " + z );
		
		jTFOperand1.requestFocus();
		jTFOperand1.selectAll();
	}
	
	private void jBtnMinusActionPerformed(ActionEvent evt) {
		double x, y, z;
		x = Double.parseDouble(jTFOperand1.getText());
		y = Double.parseDouble(jTFOperand2.getText());
		z = x - y;
		jTFErgebnis.setText(x + " - " + y + " = " + z );
		
		jTFOperand1.requestFocus();
		jTFOperand1.selectAll();
	}
	
	private void jBtnMalActionPerformed(ActionEvent evt) {
		double x, y, z;
		x = Double.parseDouble(jTFOperand1.getText());
		y = Double.parseDouble(jTFOperand2.getText());
		z = x * y;
		jTFErgebnis.setText(x + " * " + y + " = " + z );
		
		jTFOperand1.requestFocus();
		jTFOperand1.selectAll();
	}
	
	private void jBtnGeteiltActionPerformed(ActionEvent evt) {
		double x, y, z;
		x = Double.parseDouble(jTFOperand1.getText());
		y = Double.parseDouble(jTFOperand2.getText());
		z = x / y;
		jTFErgebnis.setText(x + " / " + y + " = " + z );
		
		jTFOperand1.requestFocus();
		jTFOperand1.selectAll();
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