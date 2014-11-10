/* TODO 10.3.2.   s.313
 * Klasse ExceptionsBenutzerdefiniert_throwException_getMessage
 * 
 * [ 10.3.1 INTERNE ABLÄUFE BEIM EINTREFFEN EINER EXCEPTION:	- siehe s.311	
 * 			- wenn ausgelagerte methoden, die aus einem try-block aufgerufen werden und selber aber keinen try-catch-block haben,
 * 			  exceptions auslösen, durchläuft das laufzeitsystem den aufrufweg in umgekehrter richtung, bis eine fehlerbehandlung 
 * 			  gefunden wird. 	-> BZW: es ist nicht nötig in jeder methode eine eigenes try-catch zu schreiben	]
 * 
 * [ UNTERSCHEIDE:	
 * 		Benutzerdefinierte Exceptions (10.3.2.)			= selberwerfen von bestehenden Exception-klassen unter parameter-mitgabe von eigenem fehlertext 
 * 		Selbstdefinierte Exception-Klassen (10.3.3.)	= Exception-klassen selber schreiben, durch erweitern einer existierenden Exception-klasse	]
 * 
 * 10.3.2 BENUTZERDEFINIERTE EXCEPTIONS:	= selberwerfen von XyExceptions unter parameter-mitgabe von eigenem fehlertext 
 * 											- String-mitgabe sollte laut maja bei den meisten Exception-typen funktionieren	
 * 		
 * 		BENUTZERDEFINIERTE EXCEPTION WERFEN:	
 * 
 * 							-> mit:		throw new NumberFormatException("Fehlertext")	
 * 							-> selbstgeworfene/benutzerdefinierte Exceptions MÜSSEN abgefangen werden:		siehe:	ENTWEDER - ODER
 * 							-> mit:		e.getMessage()  	-> selbstverfassten/speziefischen fehlertext via catch-block ausgeben
 * 
 * 		SELBSTGEWORFENE EXCEPTION ABFANGEN:
 * 
 * 		ENTWEDER: 			-> mit TRY-CATCH-BLOCK in derselben Methode wo sie geworfen wurde
 * 											[[-> throws Exception-liste: fakultativ, eigentlich nicht nötig, aber je nach bedürfniss möglich:
 * 								 				-> zwingt dann aber zur ZUSÄTZLICHEN implementierung von try-catch um den methoden-aufruf	]]
 * 		
 * 		ODER:				-> METHODENKOPF ergänzen mit: 	THROWS EXCEPTION-LISTE 		(= liste aller selbstgeworfenen exceptions)
 * 								= so wird fehlerbehandlung weitergegeben, try-catch muss dann beim (um den) methodenaufruf implementiert werden
 * 								ODER:	wiederum fehlerbehandlung weiterreichen (= try-catch-implementierung weiterreichen) 
 * 
 * 		TIP: 				- try-catch-block besser erst dort anwenden wo er am sinnvollsten ist:	
 * 								-> z.b. in der Methode/klasse, wo man eine texteingabe erwartet & wo man dann gut fehler ausgeben kann 
 * 
 *   SCHEMA:	private void methodenName() throws NumberFormatException, Exception {		// throws Exception-liste: hier redundant & fakultativ 
 * 					...
 * 					try{
 * 						if (bedingung xy) throw new NumberFormatException("spezifischer fehlertext");		
 * 					}
 * 					catch (NumberFormatException e){
 * 						System.out.print(e.getMessage());	// ausgeben vom spezifischen fehlertext der oben selbst erzeugten NumberFormatExceptions
 * 					}
 * 					catch (Exception e) {...}
 * 					finally {...}
 * 				}
 * 
 *   BSP:		private void berechnen() throws NumberFormatException, Exception {		// throws Exception-liste: hier redundant & fakultativ 
 * 					...
 *    				try {																			
 *						if (jTFName1.getText().equals("")) throw new NumberFormatException("Bitte Stückzahl eingeben!");
 *						if (jTFName2.getText().equals("")) throw new NumberFormatException("Bitte Stückpreis eingeben!");
 *						...
 *					}
 *					catch (NumberFormatException e) {										
 *	 					jLEinkaufspreis.setText("Falsches Zeichenformat: " + e.getMessage());	// spezifischen fehlertext ausgeben mit e.getMessage() ...
 * 					}													//..(= spezifischer fehlertext der oben selbst erzeugten NumberFormatExceptions) 
 * 					catch (Exception e) {...}
 * 					finally {...}
 * 				}
 * 
 *	VOLLSTÄNDIG: 	siehe unten
 * 
 * K&K:	im try block: if (bedingung xy) throw new NumberFormatException("spezifische fehlertext-ausgabe") 
 * 		im catch(NumberFormatException e) { jLabel.setText("allgemeiner fehlertext" + e.getMessage()* } * für ausgabe v. spezifischem fehlertext 
 */

package uebungen10;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.nio.file.FileAlreadyExistsException;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

public class ExceptionsBenutzerdefiniert_throwException_getMessage extends javax.swing.JFrame {
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
				ExceptionsBenutzerdefiniert_throwException_getMessage inst = new ExceptionsBenutzerdefiniert_throwException_getMessage();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public ExceptionsBenutzerdefiniert_throwException_getMessage() {
		super();
		initGUI();
	}

	private void initGUI(){
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
				jLEinkaufspreis.setBounds(19, 89, 275, 16);
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
							// throws Exception-liste (fakultativ) zwingt beim aufruf der methode einen try/catch-block drum zu machen
	private void berechnen() /*throws NumberFormatException, Exception*/ {
		int stueck;
		double preis, rabatt, rabattsatz, bruttopreis, einkaufspreis;
		try {
			// eigene exceptions werfen im tryblock!!!
			if (jTFStueckzahl.getText().equals("")) throw new NumberFormatException("Bitte Stückzahl eingeben!");
			if (jTFStueckpreis.getText().equals("")) throw new NumberFormatException("Bitte Stückpreis eingeben!");
			if (jTFRabatt.getText().equals("")) throw new NumberFormatException("Bitte Rabattsatz eingeben!");
			if (jTFRabatt.getText().equals("")) throw new FileAlreadyExistsException("hallo", "hallo", "hallo");
			///////////////////////////
			stueck = Integer.parseInt(jTFStueckzahl.getText());
			preis = Double.parseDouble(jTFStueckpreis.getText());
			rabattsatz = Double.parseDouble(jTFRabatt.getText());

			bruttopreis = stueck * preis;
			rabatt = bruttopreis * (rabattsatz / 100);
			einkaufspreis = bruttopreis - rabatt;

			DecimalFormat f = new DecimalFormat("#0.00");
			jLEinkaufspreis.setText(f.format(einkaufspreis) + " €");

			jTFStueckzahl.requestFocus();
			jTFStueckzahl.selectAll();
		}
		catch (NumberFormatException e) {
			// allgemeineren fehlertext spezifizieren mit e.getMessage() (= spezifischer fehlertext der oben selbst erzeugten NumberFormatExceptions) 
			jLEinkaufspreis.setText("Falsches Zeichenformat: " + e.getMessage());
			/////////////////////////////////////////////////////////////////////////
			e.printStackTrace(); 
		}
		catch (Exception e) {
			jLEinkaufspreis.setText("Fehler bei der Eingabe!");
			e.printStackTrace(); 
		}
		finally {
			// evtl. code für aufräumarbeiten
		}

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
