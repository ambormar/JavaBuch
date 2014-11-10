package uebungen09Aufgaben;
/* TODO .9.4.   Aufgabe 3, s.296 
 * Klasse Jigloo_Events_GUI_Einkauf
 * 
 * 		///KeyListener, ActionListener, frame layout absolute, mit buttons, labels, textfelder
 * 		///sonstiges: requestFocus(), selectAll(), System.exit(0), setTitle(), getKeyCode() 
 *  
 * K&K:	Programm Einkauf zur Berechnung eines Endpreises aus Stückzahl, Einzelpreis und Rabattsatz.
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

public class Jigloo_Events_GUI_Einkauf extends javax.swing.JFrame {
	/**
	 * 
	 */
	private JLabel jLStueckzahl;
	private JLabel jLStueckpreis;
	private JLabel jLRabatt;
	private JButton jBtnEnde;
	private JLabel jLEinkaufspreis;
	private JButton jBtnBerechnen;
	private JTextField jTFRabatt;
	private JTextField jTFStueckpreis;
	private JTextField jTFStueckzahl;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Jigloo_Events_GUI_Einkauf inst = new Jigloo_Events_GUI_Einkauf();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public Jigloo_Events_GUI_Einkauf() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Einkaufspreis");
			getContentPane().setLayout(null);
			{
				jLStueckzahl = new JLabel();
				getContentPane().add(jLStueckzahl);
				jLStueckzahl.setText("Stückzahl");
				jLStueckzahl.setBounds(19, 12, 77, 16);
			}
			{
				jLStueckpreis = new JLabel();
				getContentPane().add(jLStueckpreis);
				jLStueckpreis.setText("Stückpreis");
				jLStueckpreis.setBounds(108, 12, 77, 16);
			}
			{
				jLRabatt = new JLabel();
				getContentPane().add(jLRabatt);
				jLRabatt.setText("Rabatt (%)");
				jLRabatt.setBounds(197, 12, 77, 16);
			}
			{
				jTFStueckzahl = new JTextField();
				getContentPane().add(jTFStueckzahl);
				jTFStueckzahl.setBounds(19, 34, 77, 23);
				jTFStueckzahl.addKeyListener(new KeyAdapter() {
					public void keyPressed(KeyEvent evt) {
						jTFStueckzahlKeyPressed(evt);
					}
				});
			}
			{
				jTFStueckpreis = new JTextField();
				getContentPane().add(jTFStueckpreis);
				jTFStueckpreis.setBounds(108, 34, 77, 23);
				jTFStueckpreis.addKeyListener(new KeyAdapter() {
					public void keyPressed(KeyEvent evt) {
						jTFStueckpreisKeyPressed(evt);
					}
				});
			}
			{
				jTFRabatt = new JTextField();
				getContentPane().add(jTFRabatt);
				jTFRabatt.setBounds(197, 34, 77, 23);
				jTFRabatt.addKeyListener(new KeyAdapter() {
					public void keyPressed(KeyEvent evt) {
						jTFRabattKeyPressed(evt);
					}
				});
			}
			{
				jBtnBerechnen = new JButton();
				getContentPane().add(jBtnBerechnen);
				jBtnBerechnen.setText("Berechnen");
				jBtnBerechnen.setBounds(294, 34, 91, 23);
				jBtnBerechnen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnBerechnenActionPerformed(evt);
					}
				});
			}
			{
				jLEinkaufspreis = new JLabel();
				getContentPane().add(jLEinkaufspreis);
				jLEinkaufspreis.setText("Bitte Daten eingeben!");
				jLEinkaufspreis.setBounds(19, 89, 201, 16);
			}
			{
				jBtnEnde = new JButton();
				getContentPane().add(jBtnEnde);
				jBtnEnde.setText("Ende");
				jBtnEnde.setBounds(294, 86, 91, 23);
				jBtnEnde.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnEndeActionPerformed(evt);
					}
				});
			}
			pack();
			this.setSize(427, 180);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

	private void berechnen() {
		if (jTFStueckzahl.getText().equals("") || jTFStueckpreis.getText().equals("") ||	// try-catch wäre hübscher für...
				jTFRabatt.getText().equals("")) {											// ...fehlermeldung !! aber egal
			jLEinkaufspreis.setText("Die Eingaben sind unvollständig!");
		} else {
			int stueck;
			double preis, rabatt, rabattsatz, bruttopreis, einkaufspreis;
			stueck = Integer.parseInt(jTFStueckzahl.getText());
			preis = Double.parseDouble(jTFStueckpreis.getText());
			rabattsatz = Double.parseDouble(jTFRabatt.getText());

			bruttopreis = stueck * preis;
			rabatt = bruttopreis * (rabattsatz / 100);
			einkaufspreis = bruttopreis - rabatt;

			DecimalFormat f = new DecimalFormat("#0.00");
			jLEinkaufspreis.setText(f.format(einkaufspreis) + " €");
		}
		jTFStueckzahl.requestFocus();
		jTFStueckzahl.selectAll();
	}

	private void jTFStueckzahlKeyPressed(KeyEvent evt) {
		if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
			jTFStueckpreis.requestFocus();
			jTFStueckpreis.selectAll();
		}
	}

	private void jTFStueckpreisKeyPressed(KeyEvent evt) {
		if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
			jTFRabatt.requestFocus();
			jTFRabatt.selectAll();
		}
	}

	private void jTFRabattKeyPressed(KeyEvent evt) {
		if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
			berechnen();
		}
	}

	private void jBtnBerechnenActionPerformed(ActionEvent evt) {
		berechnen();
	}

	private void jBtnEndeActionPerformed(ActionEvent evt) {
		System.exit(0);
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
