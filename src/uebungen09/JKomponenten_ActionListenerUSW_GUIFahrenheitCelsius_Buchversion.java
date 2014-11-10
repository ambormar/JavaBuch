package uebungen09;
/* TODO .9.3.1 - 9.3.13.   ab s.265 Buchversion
 * JKomponenten_ActionListenerUSW_GUIFahrenheitCelsius_Buchversion
 * 
 * BUCHVERSION OHNE KOMMENTARE:		alle kommentare siehe:		9.3.1  JKomponenten_ActionListenerUSW_GUIFahrenheitCelsius  s.265
 * 
 * Programm Fahrenheit_Celsius zur Umrechnung einer Temperatur
 * von Grad Fahrenheit in Grad Celsius. darstellung mit GUI 
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

public class JKomponenten_ActionListenerUSW_GUIFahrenheitCelsius_Buchversion extends javax.swing.JFrame {

	{
		// Set Look & Feel
		try {
			javax.swing.UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private JLabel jLFahrenheit;
	private JTextField jTFFahrenheit;
	private JLabel jLCelsius;
	private JTextField jTFCelsius;
	private JButton jBtnEnde;
	private JButton jBtnUmrechnen;

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JKomponenten_ActionListenerUSW_GUIFahrenheitCelsius_Buchversion inst = new JKomponenten_ActionListenerUSW_GUIFahrenheitCelsius_Buchversion();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public JKomponenten_ActionListenerUSW_GUIFahrenheitCelsius_Buchversion() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			getContentPane().setLayout(null);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Umrechnung Fahrenheit in Celsius");
			{
				jLFahrenheit = new JLabel();
				getContentPane().add(jLFahrenheit);
				jLFahrenheit.setText("Grad Fahrenheit");
				jLFahrenheit.setBounds(12, 12, 182, 14);
			}
			{
				jTFFahrenheit = new JTextField();
				getContentPane().add(jTFFahrenheit);
				jTFFahrenheit.setBounds(12, 32, 182, 20);
				jTFFahrenheit.addKeyListener(new KeyAdapter() {
					public void keyPressed(KeyEvent evt) {
						jTFFahrenheitKeyPressed(evt);
					}
				});
			}
			{
				jLCelsius = new JLabel();
				getContentPane().add(jLCelsius);
				jLCelsius.setText("Grad Celsius");
				jLCelsius.setBounds(12, 65, 187, 14);
			}
			{
				jTFCelsius = new JTextField();
				getContentPane().add(jTFCelsius);
				jTFCelsius.setBounds(12, 85, 187, 21);
				jTFCelsius.setEditable(false);
			}
			{
				jBtnUmrechnen = new JButton();
				getContentPane().add(jBtnUmrechnen);
				jBtnUmrechnen.setText("Umrechnen");
				jBtnUmrechnen.setBounds(233, 32, 107, 21);
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
				jBtnEnde.setBounds(233, 85, 107, 21);
				jBtnEnde.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnEndeActionPerformed(evt);
					}
				});
			}
			pack();
			this.setSize(367, 152);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

	private void jBtnUmrechnenActionPerformed(ActionEvent evt) {
		umrechnen();
	}

	private void jBtnEndeActionPerformed(ActionEvent evt) {
		System.exit(0);
	}

	private void jTFFahrenheitKeyPressed(KeyEvent evt) {
		if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
			umrechnen();
		}
	}

	private void umrechnen() {
		double tf, tc;
		tf = Double.parseDouble(jTFFahrenheit.getText());
		tc = (tf - 32) * 5 / 9;
		DecimalFormat f = new DecimalFormat("#0.00");
		jTFCelsius.setText(f.format(tc));
		jTFFahrenheit.requestFocus();
		jTFFahrenheit.selectAll();
	}
}
/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing
 * GUI Builder, which is free for non-commercial use. If Jigloo is being
 * used commercially (ie, by a corporation, company or business for any
 * purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo
 * implies acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT
 * BEEN PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
 * LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
 */