/* TODO 10.4.   Aufgabe 1, s.316
 * Klasse NumberFormatException_TryCatch_GUIFahrenheitCelsius
 * 
 * HAUPTTHEMAs:		NumberFormatException, Try-Catch  
 * 
 * K&K:	programmfenster erstellen zur umrechnung von Fahrenheit in celsius (entsprechend programm ..._GUIFahrenheitCelsius kapitel 9)
 * 		aber ergänzen mit: bei fehleingaben wirft's NumberFormatException und fehlertext ausgabe im Textfeld Celsius
 */

package uebungen10Aufgaben;

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

public class NumberFormatException_TryCatch_GUIFahrenheitCelsius extends javax.swing.JFrame {

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
				NumberFormatException_TryCatch_GUIFahrenheitCelsius inst = new NumberFormatException_TryCatch_GUIFahrenheitCelsius();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public NumberFormatException_TryCatch_GUIFahrenheitCelsius() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Umrechnung Grad Fahrenheit in Celsius");
			{
				jLFahrenheit = new JLabel();
				getContentPane().add(jLFahrenheit);
				jLFahrenheit.setText("Grad Fahrenheit");
				jLFahrenheit.setBounds(35, 22, 111, 16);
			}
			{
				jTFFahrenheit = new JTextField();
				getContentPane().add(jTFFahrenheit);
				jTFFahrenheit.setBounds(36, 44, 162, 23);
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
				jLCelsius.setBounds(35, 91, 111, 16);
			}
			{
				jTFCelsius = new JTextField();
				getContentPane().add(jTFCelsius);
				jTFCelsius.setBounds(35, 113, 226, 23);
				jTFCelsius.setEditable(false);
			}
			{
				jBtnUmrechnen = new JButton();
				getContentPane().add(jBtnUmrechnen);
				jBtnUmrechnen.setText("Umrechnen");
				jBtnUmrechnen.setBounds(259, 44, 113, 23);
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
				jBtnEnde.setBounds(310, 113, 62, 23);
				jBtnEnde.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnEndeActionPerformed(evt);
					}
				});
			}
			pack();
			this.setSize(427, 209);
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
		try {
			tf = Double.parseDouble(jTFFahrenheit.getText());
			tc = (tf - 32) * 5 / 9;
			DecimalFormat f = new DecimalFormat("#0.00");
			jTFCelsius.setText(f.format(tc));
		// Zahlenformat-fehler abfangen
		} catch (NumberFormatException e){							
			jTFCelsius.setText("Bitte gültige Fahrenheittemp. eingeben");
		}
		jTFFahrenheit.requestFocus();
		jTFFahrenheit.selectAll();
	}
}
/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
