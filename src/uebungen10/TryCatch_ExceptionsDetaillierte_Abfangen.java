/* TODO 10.2.1. (10.2.2)   s.307 (309)
 * Klasse TryCatch_ExceptionsDetaillierte_Abfangen
 * 
 * 10.2. ALLGEMEINES FEHLER-HANDLING, MIT TRY-CATCH & EXCEPTION E: 		siehe 	TryCatch_ExceptionsAllgemeine_Abfangen		s.305 
 * 	
 * 10.2.1 DETAILLIERTES FEHLER-HANDLING:	- 2 VORGEHENSWEISEN (erstere ist glaub nicht so hübsch):
 * 
 * 	[1. MEHRERE TRY-CATCH-BLÖCKE:		=> Try-catch-block für jede anweisung, wo fehler auftreten könnten
 * 										-> Vorteil: schnelleres genaueres lokalisieren des fehlers	-> nachteil: code wird unübersichtlich	]
 * 
 * 	2. EIN TRY & MEHRERE CATCH-BLÖCKE DARAUF FOLGEN LASSEN:		
 * 
 * 					= jeder catch-block reagiert auf spezielle art von EXCEPTION (bsp. NumberFormatException, Exception etc.)
 * 					-> exception-typen werden sortiert 					-> von speziell (zuerst) nach allgemein (zuletzt)
 * 					-> beliebig viele catch-blöcke möglich 				(es gibt eine vielzahl von spezialisierten exceptions)
 * 					-> allgemeiner catch-block (Exception e) zuletzt	(weil pro fehler nur ein catch-block ausgeführt wird)
 * 					-> finally ganz am schluss für aufräumarbeiten		(wird immer ausgeführt, unabhängig ob exception aufgetreten ist oder nicht)
 * 						-> anweisungen die auf jeden fall ausgeführt werden sollen, aus dem try-block in den finally-block verschieben
 * 
 * 		SCHEMA:		try {
 * 						...													// zu überwachende anweisungen
 * 					}
 * 					catch (NumberFormatexception e) {						// ZUERST: Reaktion auf spezialisierte Exceptions
 * 						jLEinkaufspreis.setText("Falsches Zahlenformat");	// spezifischere fehler-text-ausgabe
 * 						...		
 * 						[ e.printStackTrace();								// für konsolenausgabe: fehlerbeschreibung & Links auf fehler  ]	
 * 					}
 * 					catch (Exception e) {									// DANN: reaktion auf alle anderen Exceptions 
 * 						jLEinkaufspreis.setText("Fehler bei der Eingabe!");	// allgemeinere fehler-text-ausgabe
 * 						... 
 * 						[ jLEinkaufspreis.setText(e.getMessage());			// alt.: fehler (in engl) direkt ausgeben ]
 *					}
 * 					finally {												// ZUM SCHLUSS: anweisungen die auf jeden fall ausgeführt werden sollen
 * 						jTFStueckzahl.setText("");							// z.b. aufräumarbeiten (nicht soo gutes beispiel aber: eingabefelder auf leer setzen)
 * 						...
 * 					}
 * 
 * 					GENAUER:	siehe unten
 * 
 * 
 * 	NÜTZLICHE MÖGLICHKEITEN INNERHALB DER CATCH-BLÖCKE:
 * 
 * 			- e.printStackTrace(); 		// 10.2.2 FEHLERAUSGABE AU KONSOLE:		=> zuoberst:	art der exception	&	fehler-ursache 
 * 																				=> BLAUE ZEILEN	 => sind LINKS, die ZU DEN FEHLER-ZEILEN führen!) 
 * 
 * 			- e.getMessage(); 			// 10.2.1 alternativ: um fehler (in engl) direkt auszugeben, bsp:		jLEinkaufspreis.setText(e.getMessage()); 
 * 											 
 * 
 * 	10.2.2 KLASSEN-HIERARCHIE DER EXCEPTIONS:		- genau siehe s.309
 * 			
 *			- Exceptions (Errors) unterbrechen normalen programm-ablauf:	-> ursprünglich vorgesehene abfolge von anweisungen wird nicht eingehalten
 * 			- alle Exceptions stammen von der (super)klasse Throwable ab
 * 			- weitere fehlerklasse: Error 
 * 				-> für schwerwiegendere fehler, die normal in java nicht mit catch abgefangen werden, weil meist das programm sowieso nicht weiterläuft 
 * 
 * 			HIERARCHIE-BILD:			Throwable
 * 											|
 * 								Error		-		Exception
 * 														|
 * 											IOException	-	Usw	
 * 												|
 * 						FileNotFoundException	-	Etc
 * 
 * 
 * K&K:	detaillierte fehler abfangen in der methode berechnen: mit try catch (Exception e)
 * 		zuerst spezifischere exceptions (wie NumberFormatException) abfangen, dann allgemeinere (exception),
 * 		zum schluss mit finally{} anweisungen die auf jeden fall ausgeführt werden sollen (bsp. aufräumarbeiten)
 * 		& e.printStackTrace(): in der consolenfehlerbeschreibung sind die blauen unterstrichenen  passagen links zu den fehler-zeilen
 */

package uebungen10;
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

public class TryCatch_ExceptionsDetaillierte_Abfangen extends javax.swing.JFrame {
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
				TryCatch_ExceptionsDetaillierte_Abfangen inst = new TryCatch_ExceptionsDetaillierte_Abfangen();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public TryCatch_ExceptionsDetaillierte_Abfangen() {
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
		int stueck;
		double preis, rabatt, rabattsatz, bruttopreis, einkaufspreis;
		// try: zu überwachende anweisung
		try {
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
		// exceptiontypen sortieren von speziell nach allgemein
		// zuerst Reaktion auf speziellere NumberFormat-exception
		catch (NumberFormatException e) {
			jLEinkaufspreis.setText("Falsches Zahlenformat");
			// 10.2.2 fehlerausgabe auf der console, fehler : zeilen in blau sind links zu den fehlerzeilen!!!
			e.printStackTrace(); 
		}
		// dann reaktion auf allgemeine Exception
		catch (Exception e) {
			jLEinkaufspreis.setText("Fehler bei der Eingabe!");
			//jLEinkaufspreis.setText(e.getMessage()); // alternativ mit getmessage() fehler (in engl) ausgeben: message wäre hier: For input string: ""
			e.printStackTrace(); 
		}
		// finally: zum schluss anweisungen die auf jeden fall ausgeführt werden sollen
		finally {
			// z.b. aufräumarbeiten (nicht soo gutes beispiel aber: eingabefelder auf leer setzen)
			jTFStueckzahl.setText("");
			jTFStueckpreis.setText("");
			jTFRabatt.setText("");
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
