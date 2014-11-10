/* TODO 10.4.   Aufgabe 2 & 3 & 4, s.316
 * class Exceptions_SelbstdefinierteExceptions_UhrzeitFrame & Selbstdefinierte_UhrzeitFormat_Exception
 * 
 * HAUPTTHEMA:	- Exceptions allgemein, selbstdefinierte Exception-klassen, Try-catch-finally 
 * 
 * K&K:	Programm Uhrzeit zur Eingabe und Anzeige einer Uhrzeit.
 * 		allgemeine exceptions werfen fehler bei allgemein falschen eingaben 
 * 		selbstdefinierte exceptionklasse wirft fehler bei falschen stunden- & minuten-eingaben
 */

package uebungen10Aufgaben2u3u4;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

public class Exceptions_SelbstdefinierteExceptions_UhrzeitFrame extends javax.swing.JFrame {
	private JLabel jLStunden;
	private JLabel jLMinuten;
	private JTextField jTFStunden;
	private JButton jBtnEnde;
	private JLabel jLUhrzeit;
	private JButton jBtnUebernehmen;
	private JTextField jTFMinuten;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Exceptions_SelbstdefinierteExceptions_UhrzeitFrame inst = new Exceptions_SelbstdefinierteExceptions_UhrzeitFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public Exceptions_SelbstdefinierteExceptions_UhrzeitFrame() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jLStunden = new JLabel();
				getContentPane().add(jLStunden);
				jLStunden.setText("Stunden");
				jLStunden.setBounds(17, 22, 71, 16);
			}
			{
				jLMinuten = new JLabel();
				getContentPane().add(jLMinuten);
				jLMinuten.setText("Minuten");
				jLMinuten.setBounds(110, 22, 71, 16);
			}
			{
				jTFStunden = new JTextField();
				getContentPane().add(jTFStunden);
				jTFStunden.setBounds(17, 45, 71, 23);
				jTFStunden.addKeyListener(new KeyAdapter() {
					public void keyPressed(KeyEvent evt) {
						jTFStundenKeyPressed(evt);
					}
				});
			}
			{
				jTFMinuten = new JTextField();
				getContentPane().add(jTFMinuten);
				jTFMinuten.setBounds(110, 45, 71, 23);
				jTFMinuten.addKeyListener(new KeyAdapter() {
					public void keyPressed(KeyEvent evt) {
						jTFMinutenKeyPressed(evt);
					}
				});
			}
			{
				jBtnUebernehmen = new JButton();
				getContentPane().add(jBtnUebernehmen);
				jBtnUebernehmen.setText("Übernehmen");
				jBtnUebernehmen.setBounds(206, 45, 123, 23);
				jBtnUebernehmen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnUebernehmenActionPerformed(evt);
					}
				});
			}
			{
				jLUhrzeit = new JLabel();
				getContentPane().add(jLUhrzeit);
				jLUhrzeit.setText("Bitte Uhrzeit eingeben!");
				jLUhrzeit.setBounds(17, 94, 312, 16);
			}
			{
				jBtnEnde = new JButton();
				getContentPane().add(jBtnEnde);
				jBtnEnde.setText("Ende");
				jBtnEnde.setBounds(206, 130, 123, 23);
				jBtnEnde.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnEndeActionPerformed(evt);
					}
				});
			}
			pack();
			this.setSize(375, 219);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private void uebernehmen(){
		int std, min;
		try {
			std = Integer.parseInt(jTFStunden.getText());
			min = Integer.parseInt(jTFMinuten.getText());
			// selbstverfasste UhrzeitFormatExceptions aus selbstverfasster klasse im selben package
			if (std > 23 || std < 0) throw new Selbstdefinierte_UhrzeitFormat_Exception("Nur Stundenwerte von 0 bis 23 eingeben"); // fehlertext hier mitgeben nicht in der klasse oder so
			if (min > 59 || min < 0) throw new Selbstdefinierte_UhrzeitFormat_Exception("Nur Minutenwerte von 0 bis 59 eingeben");
			jLUhrzeit.setText("Ihre Uhrzeit ist " + std + ":" + min + " Uhr!");
		// spezialisiertere Exceptions zuerst (UhrzeitFormatfehler)
		} catch (Selbstdefinierte_UhrzeitFormat_Exception ufe){
			jLUhrzeit.setText(ufe.getMessage()); // getMessage() = String von oben
		// dann numberformatexception für allgemeine formatfehler; erkennt selber wenn textfelder leer oder doubles oder buchstaben eingegeben wurden
		} catch (NumberFormatException nfe){
			jLUhrzeit.setText("Bitte gültige Zahlenwerte eingeben");  
		} finally {													
			jTFStunden.requestFocus();
			jTFStunden.selectAll();
		}
	}
	
	private void jBtnUebernehmenActionPerformed(ActionEvent evt) {
		uebernehmen();
		
	}
	
	private void jTFStundenKeyPressed(KeyEvent evt) {
		if(evt.getKeyCode() == KeyEvent.VK_ENTER){
			jTFMinuten.requestFocus();				
			jTFMinuten.selectAll();
		}
	}
	
	private void jTFMinutenKeyPressed(KeyEvent evt) {
		if(evt.getKeyCode() == KeyEvent.VK_ENTER){
			uebernehmen();
		}
	}
	
	private void jBtnEndeActionPerformed(ActionEvent evt) {
		System.exit(0);
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
}
