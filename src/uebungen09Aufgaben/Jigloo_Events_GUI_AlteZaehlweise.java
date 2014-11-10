package uebungen09Aufgaben;
/* TODO .9.4.   Aufgabe 2, s.295 
 * Klasse Jigloo_Events_GUI_AlteZaehlweise
 * 
 * 		///	KeyListener, ActionListener, frame layout absolute, mit buttons, labels, textfelder
 * 		///	sonstiges: requestFocus(), selectAll(), System.exit(0), setTitle(), getKeyCode() 
 * 		///	NB:	MODULO OPERATOR Musteranwendung siehe: ca zeile 130 
 * 
 * K&K:	Programm AlteZaehlweise zur Umrechnung einer Mengenangabe in die alten Mengenangaben Dutzend, Schock und Gros.
 * 		(dutzend = 12 stück, schock = 60 stück, gros = 144 stück)
 * 		tipp: mit int umsetzen; mit modulo (%, rest) & ganzzahldivision ist ergebnis am einfachsten zu ermitteln
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

public class Jigloo_Events_GUI_AlteZaehlweise extends javax.swing.JFrame {
	private JLabel jLStueckzahl;
	private JTextField jTFStueckzahl;
	private JButton jBtnUmrechnen;
	private JLabel jLSchock;
	private JButton jBtnEnde;
	private JLabel jLStueck;
	private JLabel jLDutzend;
	private JLabel jLGros;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Jigloo_Events_GUI_AlteZaehlweise inst = new Jigloo_Events_GUI_AlteZaehlweise();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public Jigloo_Events_GUI_AlteZaehlweise() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("alte Zählweise");
			getContentPane().setLayout(null);			// layout absolute
			{
				jLStueckzahl = new JLabel();
				getContentPane().add(jLStueckzahl);
				jLStueckzahl.setText("Gebe Stückzahl an:");
				jLStueckzahl.setBounds(17, 18, 119, 16);
			}
			{
				jTFStueckzahl = new JTextField();
				getContentPane().add(jTFStueckzahl);
				jTFStueckzahl.setBounds(17, 40, 119, 23);
				jTFStueckzahl.addKeyListener(new KeyAdapter() {
					public void keyPressed(KeyEvent evt) {
						jTFStueckzahlKeyPressed(evt);
					}
				});
			}
			{
				jBtnUmrechnen = new JButton();
				getContentPane().add(jBtnUmrechnen);
				jBtnUmrechnen.setText("In alte Zählmasse umrechnen");
				jBtnUmrechnen.setBounds(152, 40, 217, 23);
				jBtnUmrechnen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnUmrechnenActionPerformed(evt);
					}
				});
			}
			{
				jLGros = new JLabel();
				getContentPane().add(jLGros);
				jLGros.setText("Gros");
				jLGros.setBounds(17, 86, 119, 16);
			}
			{
				jLSchock = new JLabel();
				getContentPane().add(jLSchock);
				jLSchock.setText("Schock");
				jLSchock.setBounds(17, 112, 119, 16);
			}
			{
				jLDutzend = new JLabel();
				getContentPane().add(jLDutzend);
				jLDutzend.setText("Dutzend");
				jLDutzend.setBounds(17, 139, 119, 16);
			}
			{
				jLStueck = new JLabel();
				getContentPane().add(jLStueck);
				jLStueck.setText("Stück");
				jLStueck.setBounds(17, 166, 119, 16);
			}
			{
				jBtnEnde = new JButton();
				getContentPane().add(jBtnEnde);
				jBtnEnde.setText("Ende");
				jBtnEnde.setBounds(220, 163, 82, 23);
				jBtnEnde.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnEndeActionPerformed(evt);
					}
				});
			}
			pack();
			this.setSize(400, 255);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private void umrechnen() {
		int stueck, gros, schock, dutzend;
		stueck = Integer.parseInt(jTFStueckzahl.getText());
		// MODULO OPERATOR Musteranwendung
		// alle nachkommastellen werden abgeschnitten da integer > also stueck(zahl) durch einheit teilen
		gros = stueck / 144; 	// stueck durch einheit (144 sind ein gros) 
		stueck = stueck % 144; 	// immer wieder rest ermitteln und stueck zuweisen
		schock = stueck / 60; 	// rest-stueck durch schock (60)
		stueck = stueck % 60;	// immer wieder rest ermitteln und stueck zuweisen
		dutzend = stueck / 12;	// rest-stueck durch dutzend (12)
		stueck = stueck % 12;	// immer wieder rest ermitteln und stueck zuweisen
		
		jLGros.setText(gros + " Gros");
		jLSchock.setText(schock + " Schock");
		jLDutzend.setText(dutzend + " Dutzend");
		jLStueck.setText(stueck + " Stück");
		
		jTFStueckzahl.requestFocus();
		jTFStueckzahl.selectAll();
	}
	
	private void jBtnUmrechnenActionPerformed(ActionEvent evt) {
		umrechnen();
	}
	
	private void jTFStueckzahlKeyPressed(KeyEvent evt) {
		if(evt.getKeyCode() == KeyEvent.VK_ENTER){
			umrechnen();
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