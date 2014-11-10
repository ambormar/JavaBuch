package uebungen09Aufgaben;
/* TODO .9.4.   Aufgabe 5, s.298  
 * Klasse Jigloo_Events_GUI_Osterdatum
 * 
 *  	///	KeyListener, ActionListener, frame layout absolute mit buttons, labels, textfelder
 * 		///	sonstiges: requestFocus(), selectAll(), System.exit(0), setTitle(), getKeyCode(), setEditabel(false), ..
 *  
 * K&K:	Programm berechnet aus der eingegebenen Jahreszahl (nach 1583) das zugehörige Osterdatum.
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

public class Jigloo_Events_GUI_Osterdatum extends javax.swing.JFrame {
	private JLabel jLJahreszahl;
	private JButton jBtnBerechnen;
	private JTextField jTFJahreszahl;
	private JLabel jLDatum;
	private JButton jBtnEnde;
	private JLabel jLDatumOstersonntag;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Jigloo_Events_GUI_Osterdatum inst = new Jigloo_Events_GUI_Osterdatum();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public Jigloo_Events_GUI_Osterdatum() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Osterdatum");
			{
				jLJahreszahl = new JLabel();
				getContentPane().add(jLJahreszahl);
				jLJahreszahl.setText("Jahr");
				jLJahreszahl.setBounds(20, 19, 61, 16);
			}
			{
				jTFJahreszahl = new JTextField();
				getContentPane().add(jTFJahreszahl);
				jTFJahreszahl.setBounds(20, 39, 61, 23);
				jTFJahreszahl.addKeyListener(new KeyAdapter() {
					public void keyPressed(KeyEvent evt) {
						jTFJahreszahlKeyPressed(evt);
					}
				});
			}
			{
				jBtnBerechnen = new JButton();
				getContentPane().add(jBtnBerechnen);
				jBtnBerechnen.setText("Datum für Ostersonntag berechnen");
				jBtnBerechnen.setBounds(101, 39, 242, 23);
				jBtnBerechnen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnBerechnenActionPerformed(evt);
					}
				});
			}
			{
				jLDatumOstersonntag = new JLabel();
				getContentPane().add(jLDatumOstersonntag);
				jLDatumOstersonntag.setText("Datum vom Ostersonntag:");
				jLDatumOstersonntag.setBounds(20, 85, 148, 16);
			}
			{
				jLDatum = new JLabel();
				getContentPane().add(jLDatum);
				jLDatum.setText("Berechnung nur für Jahreszahl > 1583");
				jLDatum.setBounds(20, 107, 232, 16);
			}
			{
				jBtnEnde = new JButton();
				getContentPane().add(jBtnEnde);
				jBtnEnde.setText("Ende");
				jBtnEnde.setBounds(270, 104, 73, 23);
				jBtnEnde.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnEndeActionPerformed(evt);
					}
				});
			}
			pack();
			this.setSize(387, 206);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private void berechnen() {
		int y = Integer.parseInt(jTFJahreszahl.getText());
		if (y > 1583){
			int g = y % 19; 
			int c = y / 100;
			int h = (c - c/4 - (8 * c + 13) / 25 + 19 * g + 15) % 30;
			int i = h - (h/28) * (1- (29/(h + 1)) * ((21 -g)/11));
			int j = (y + y/4 + i + 2 - c + c/4) % 7;
			int l = i - j;
			int m = 3 + (l + 40)/44;
			int d = l + 28 - 31*(m/4);
			jLDatum.setText(d + "." + m + "." + y);
		} else {
			jLDatum.setText("Berechnung nur für Jahreszahl > 1583");
		}
		jTFJahreszahl.requestFocus();
		jTFJahreszahl.selectAll();
	}
	
	private void jBtnBerechnenActionPerformed(ActionEvent evt) {
		berechnen();
	}
	
	private void jTFJahreszahlKeyPressed(KeyEvent evt) {
		if (evt.getKeyCode() == KeyEvent.VK_ENTER){
			berechnen();
		}
	}
	
	private void jBtnEndeActionPerformed(ActionEvent evt) {
		System.exit(0);
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