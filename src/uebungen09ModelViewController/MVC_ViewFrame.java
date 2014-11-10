package uebungen09ModelViewController;
/* TODO .9.5.2.   MVC, View, eigenes bsp
 * class MVC_Model_Bruch & MVC_ViewFrame & MVC_Controller
 * 
 * (Noch überarbeiten, zum laufen bringen, hier oben kommentieren/erklären wie MVC funktioniert, maja?)
 * SIEHE AUCH PAPER:	s.301	
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


public class MVC_ViewFrame extends javax.swing.JFrame {
	// ViewFrame muss mit Conrtroller komunizieren können:
	private MVC_Controller controller; // variabel erzeugen für die controller-zuweisung unten
	
	public void setController(MVC_Controller controller) {
		this.controller = controller;
	}

	private JLabel jLZaehler;
	private JTextField jTFBruchAusgabe;
	private JButton jBtnGekuerztAusgeben;
	private JTextField jTFNenner;
	private JLabel jLNenner;
	private JTextField jTFZaehler;

	/*	main methode wird in den controller verschoben, um aus dem controller das programm zu starten:
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {  
			public void run() {
				ViewFrame inst = new ViewFrame();    
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}*/
	
	public MVC_ViewFrame() { 
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Bruch gekürzt ausgeben");
			{
				jLZaehler = new JLabel();
				getContentPane().add(jLZaehler);
				jLZaehler.setText("Zähler");
				jLZaehler.setBounds(25, 26, 90, 16);
			}
			{
				jTFZaehler = new JTextField();
				getContentPane().add(jTFZaehler);
				jTFZaehler.setBounds(25, 48, 90, 23);
				jTFZaehler.addKeyListener(new KeyAdapter() {
					public void keyPressed(KeyEvent evt) {
						jTFZaehlerKeyPressed(evt);
					}
				});
			}
			{
				jLNenner = new JLabel();
				getContentPane().add(jLNenner);
				jLNenner.setText("Nenner");
				jLNenner.setBounds(140, 26, 90, 16);
			}
			{
				jTFNenner = new JTextField();
				getContentPane().add(jTFNenner);
				jTFNenner.setBounds(140, 48, 90, 23);
				jTFNenner.addKeyListener(new KeyAdapter() {
					public void keyPressed(KeyEvent evt) {
						jTFNennerKeyPressed(evt);
					}
				});
			}
			{
				jBtnGekuerztAusgeben = new JButton();
				getContentPane().add(jBtnGekuerztAusgeben);
				jBtnGekuerztAusgeben.setText("gekürzt ausgeben");
				jBtnGekuerztAusgeben.setBounds(25, 95, 205, 23);
				jBtnGekuerztAusgeben.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnGekuerztAusgebenActionPerformed(evt);
					}
				});
			}
			{
				jTFBruchAusgabe = new JTextField();
				getContentPane().add(jTFBruchAusgabe);
				jTFBruchAusgabe.setText("Bitte Eingaben machen");
				jTFBruchAusgabe.setBounds(25, 145, 205, 23);
				jTFBruchAusgabe.setEditable(false);
			}
			pack();
			this.setSize(281, 254);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private void jBtnGekuerztAusgebenActionPerformed(ActionEvent evt) {
		
		jTFZaehler.requestFocus();
		jTFZaehler.selectAll();
	}
	
	private void jTFZaehlerKeyPressed(KeyEvent evt) {
		if (evt.getKeyCode() == KeyEvent.VK_ENTER){
			jTFZaehler.requestFocus();
			jTFZaehler.selectAll();
		}
	}
	
	private void jTFNennerKeyPressed(KeyEvent evt) {
		if (evt.getKeyCode() == KeyEvent.VK_ENTER){

		}
		jTFZaehler.requestFocus();
		jTFZaehler.selectAll();
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