/* TODO 10.3.3.   s.315 
 * Klasse Exceptions_SelbstdefinierteExceptionKlasse & Exceptions_SelbstdefinierteExceptionKlasse_werfen
 * 
 * [ UNTERSCHEIDE:	
 * 		Benutzerdefinierte Exceptions (10.3.2.)			= selberwerfen von bestehenden Exception-klassen unter parameter-mitgabe von eigenem fehlertext 
 * 		Selbstdefinierte Exception-Klassen (10.3.3.)	= Exception-klassen selber definieren, durch erweitern einer existierenden Exception-klasse]
 * 
 * 10.3.3 SELBSTDEFINIERTE EXCEPTION-KLASSEN:	= Exception-klassen selber schreiben, durch ableiten/erben  von einer existierenden Exception-klasse
 * 
 * 												=> dabei immer 2 konstruktoren definieren, einen mit & einen ohne (string-)parameter
 * 
 * 		EXCEPTION-KLASSE: 	public class SelbstbenannteException extends NumberFormatException {		// erben von bestehender Exception-klasse
 * 		(SCHEMA)																						// standard: mit 2 konstruktoren:
 * 									public SelbstbenannteException (){									// konstruktor ohne parameter
 * 									super();
 * 								}
 * 		
 * 								public SelbstbenannteException (String s){ 								// konstruktor mit String als parameter
 * 									super(s);															// String später abrufbar mit: getMessage()
 * 								}
 * 							}
 * 
 * 		SELBSTDEFINIERTE EXCEPTION WERFEN & ABFANGEN (TRY-CATCH) IN BELIEBIGER METHODE AUS BELIEBIGER KLASSE - SCHEMA:	
 * 	
 * 							private void xyMethode() {												
 * 								...																		
 * 								try {																	// werfen im tryblock
 * 									if (bedingung xy) throw new SelbstbenannteException("speziefischer Fehlertext");
 * 									...
 * 								} catch (SelbstbenannteException e) {									// abfangen im catch-block
 * 									JOptionPane.showMessageDialog(null, e.getMessage());				// spezifischen fehlertext ausgeben
 * 									...
 * 								} catch (Exception e) {
 * 									JOptionPane.showMessageDialog("eingabefehler");						// (allgemeiner fehlertext) 
 * 									...
 * 								} finally {...}						
 * 							}
 * 
 * 		ODER: S.E. WERFEN & FEHLERBEHANDLUNG WEITERREICHEN MIT "THROWS EXCEPTION-LISTE" :			
 * 	
 * 							private void xyMethode() THROWS SelbstbenannteException, Exception {		// **
 * 								...																		
 * 								if (bedingung xy) throw new SelbstbenannteException("Fehlertext");		// hier ohne try-catch
 * 								...
 * 							} 
 * 
 * 							=> zwingt zu fehlerbehandlung (try-catch-block) beim aufruf der xyMethode()
 *
 * 							** METHODENOPF-ERGÄNZUNG: siehe auch	10.3.2.   ExceptionsBenutzerdefiniert_throwException_getMessage	s.313
 * 
 * 		BSP & GENAUER:		siehe code unten & Exceptions_SelbstdefinierteExceptionKlasse
 * 
 * 
 * K&K:		try { if (bedingung xy) throw new SelbstBenannteExeption("spezifischer fehlertext") 
 * 			} catch(SelbstBenannteExceptions e) { jLabel.setText(e.getMessage()) } 
 * 			man kann also auch ganze exception-klassen selber schreiben
 */

package uebungen10;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

public class Exceptions_SelbstdefinierteExceptionKlasse_werfen extends javax.swing.JFrame {
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
				Exceptions_SelbstdefinierteExceptionKlasse_werfen inst = new Exceptions_SelbstdefinierteExceptionKlasse_werfen();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public Exceptions_SelbstdefinierteExceptionKlasse_werfen() {
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
			e.printStackTrace();
		}
	}
							// throws Exceptionliste (fakultativ) zwingt beim aufruf der methode einen
							// try/catch-block drum zu machen
	private void berechnen() /* throws SelbstBenannteException, Exception */{
		int stueck;
		double preis, rabatt, rabattsatz, bruttopreis, einkaufspreis;
		try {
			// selbstbenannte exceptions werfen im tryblock!!! inklusive übergabe von fehlertext als string
			if (jTFStueckzahl.getText().equals("")) throw new Exceptions_SelbstdefinierteExceptionKlasse("Bitte Stückzahl eingeben!");
			if (jTFStueckpreis.getText().equals("")) throw new Exceptions_SelbstdefinierteExceptionKlasse("Bitte Stückpreis eingeben!");
			if (jTFRabatt.getText().equals("")) throw new Exceptions_SelbstdefinierteExceptionKlasse("Bitte Rabattsatz eingeben!");
			// /////////////////////////
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
		} catch (Exceptions_SelbstdefinierteExceptionKlasse e) {
			// mit e.getMessage() (= spezifischer fehlertext der oben selbst erzeugten SelbstBenannteException)
			JOptionPane.showMessageDialog(null, e.getMessage());
			// ///////////////////////////////////////////////////////////////////////
			e.printStackTrace();
		} catch (Exception e) {
			jLEinkaufspreis.setText("Fehler bei der Eingabe!");
			e.printStackTrace();
		} finally {
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
