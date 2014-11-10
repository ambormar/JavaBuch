/* TODO 11.1.   s.324 
 * class ForEachSchleife_ArrayAusgabe
 * 
 * 
 * FOREACH-SCHLEIFE:	= anstelle von For-schleife, schneller & einfacher zu schreiben 
 * 						
 * 						=> foreach-schleife ist kein vollwertiger ersatz für for-schleife:
 * 							-> mit ae: hat man nur lesenden, keinen schreibenden zugriff (nur kopie von array)
 * 							-> reihenfolge des aufrufs ist unveränderbar & es können keine elemente übersprungen werden
 * 
 * 			(	wenn z.b. array:				public double [] zahlen = new double[5]		)				
 * 
 * 				BSP:							for (double ae: zahlen) {									// ae: 		= all elements
 *													jLName.setText(jLName.getText() + "  " + ae);			// immer text abrufen & elemente ae anhängen
 *												} 
 *
 *				SCHEMA:							for (datentyp ae: arrayBezeichner) {System.out.println(ae)}		// for (nicht etwa foreach !!!)															
 *
 *
 * 				FOR-SCHLEIFE IM VERGLEICH:		for (int i = 0; i < zahlen.length; i++) {
 *													jLName.setText(jLName.getText() + "  " + zahlen[i]);  	// immer text abrufen & elemente anhängen..
 *												}										 			 		// .. solange es elemente hat
 *																			
 * 				SIEHE & VERGLEICHE: 			3.3.3,   For_Schleife_Iteration_SpezielleFormDerAbweisendenSchleife		s.120  
 * 
 * 
 *  			VERSCHACHTELTE FOREACH-SCHL.:	11.1.2.   ArrayZweidimensional_foreachSchleife		s.327																			]
 * 
 * 
 * K&K:		bsp. für foreach-schleife anstelle von for-schleife: zeile ca.160
 * 				/// bsp:	(für array: public int [] zahlen = new int[5]) 
 * 				///	foreach-schleife:		for (int ae: zahlen){ ...ae) } 		
 * 				///	anstatt for-schleife:	for (int i= 0; i< zahlen.length; i++) { ...zahlen[i] }
 * 
 * 			Programm ForEachSchleife_ArrayAusgabe
 * 			erfragt die anzahl elemente eines arrays, speichert für jedes element den einzugebenden wert und gibt dann alle werte im label aus
 */

package uebungen11;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

public class ForEachSchleife_ArrayAusgabe extends javax.swing.JFrame {
	private JLabel jLZahlEingeben;
	private JLabel jLAnzahlZahlen;
	private JLabel jLZahlenAusgeben;
	private JButton jBtnZahlUebernehmen;
	private JButton jBtnAnzahlUebernehmen;
	private JTextField jTFZahl;
	private JTextField jTFAnzahlZahlen;
	
	public int anzahlZahlen, i; 
	// Array vom typ int deklarieren um zahlen zu speichern
	public int [] zahlen; 

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ForEachSchleife_ArrayAusgabe inst = new ForEachSchleife_ArrayAusgabe();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public ForEachSchleife_ArrayAusgabe() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jLZahlEingeben = new JLabel();
				getContentPane().add(jLZahlEingeben);
				jLZahlEingeben.setBounds(18, 92, 154, 16);
			}
			{
				jLAnzahlZahlen = new JLabel();
				getContentPane().add(jLAnzahlZahlen);
				jLAnzahlZahlen.setText("Anzahl Zahlen eingeben:");
				jLAnzahlZahlen.setBounds(18, 19, 154, 16);
			}
			{
				jTFAnzahlZahlen = new JTextField();
				getContentPane().add(jTFAnzahlZahlen);
				jTFAnzahlZahlen.setBounds(18, 43, 154, 23);
			}
			{
				jTFZahl = new JTextField();
				getContentPane().add(jTFZahl);
				jTFZahl.setBounds(18, 114, 154, 23);
				jTFZahl.setEditable(false);
			}
			{
				jBtnAnzahlUebernehmen = new JButton();
				getContentPane().add(jBtnAnzahlUebernehmen);
				jBtnAnzahlUebernehmen.setText("Anzahl Zahlen übernehmen");
				jBtnAnzahlUebernehmen.setBounds(203, 43, 197, 23);
				jBtnAnzahlUebernehmen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnAnzahlUebernehmenActionPerformed(evt);
					}
				});
			}
			{
				jBtnZahlUebernehmen = new JButton();
				getContentPane().add(jBtnZahlUebernehmen);
				jBtnZahlUebernehmen.setText("Zahl übernehmen");
				jBtnZahlUebernehmen.setBounds(203, 114, 197, 23);
				jBtnZahlUebernehmen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnZahlUebernehmenActionPerformed(evt);
					}
				});
			}
			{
				jLZahlenAusgeben = new JLabel();
				getContentPane().add(jLZahlenAusgeben);
				jLZahlenAusgeben.setText("Zahlen:");
				jLZahlenAusgeben.setBounds(18, 170, 382, 16);
			}
			pack();
			this.setSize(485, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void jBtnAnzahlUebernehmenActionPerformed(ActionEvent evt) {
		anzahlZahlen = Integer.parseInt(jTFAnzahlZahlen.getText());
		// (mit anzahlZahlen) anzahl der elemente für array initialisieren
		zahlen = new int[anzahlZahlen];
		//////////////////////////////
						// (restliche  variabeln für nächsten schritt initialisieren:)
		i = 1;
		jLZahlEingeben.setText("1. Zahl eingeben:");
		jTFZahl.setEditable(true);
		jTFZahl.requestFocus();
		jTFAnzahlZahlen.setEditable(false);
		jBtnAnzahlUebernehmen.setVisible(false);
	}
	
	private void jBtnZahlUebernehmenActionPerformed(ActionEvent evt) {
		if (!jTFZahl.getText().equals("")){
			// jede Note bei der Übernahme im Array abspeichern
			zahlen[i-1]= Integer.parseInt(jTFZahl.getText()); // i-1 weil array-index[] mit 0 anfängt
			//////////
			if (i == anzahlZahlen){ // wenn alle zahlen eingegeben sind
				jBtnZahlUebernehmen.setVisible(false);
				jTFZahl.setEditable(false);
				
				// array ausgabe der zahlen nachdem alle zahlen eingegeben sind:
				// foreach-schleife alternative zur for-schleife: (s.324)
				for (int ae: zahlen) {							// ae steht für all elements
					jLZahlenAusgeben.setText(jLZahlenAusgeben.getText() + "   " + ae);
				}
				// in der for-schlaufe: .getText() +  ein array-element nach dem anderen anhängen, soviele wie's elemente hat
				/* for (int y = 0; y < zahlen.length; y++) {
						jLZahlenAusgeben.setText(jLZahlenAusgeben.getText() + "  " + zahlen[y]);  
				} */
				
			} else { // wenn noch nicht alle zahlen eingegeben sind
				i++;
				jLZahlEingeben.setText(i + ". Zahl eingeben:");
				jTFZahl.setText("");
				jTFZahl.requestFocus();
			}
			
		} else {
			JOptionPane.showMessageDialog(null, "Bitte ganze Zahl eingeben");
			jTFZahl.requestFocus();
		}
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