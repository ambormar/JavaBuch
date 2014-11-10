package uebungen09Aufgaben;
/* TODO .9.4.   Aufgabe 6, s.299 
 * klasse Jigloo_Events_setVisible_GUI_Notenbilanz
 * 
 * 		///setVisible(false/true): ein/ausblenden von komponenten je nach gebrauch, setEditable(false/true) un/bearbeitbar machen von komponenten
 * 		///KeyListener, ActionListener, frame layout absolute mit buttons, labels, textfelder
 * 		///sonstiges: requestFocus(), selectAll(), System.exit(0), setTitle(), getKeyCode()
 *  
 * K&K:	Programm Notenbilanz berechnet aus mehreren eingegebenen Noten den Notenschnitt 
 * 		und gibt zusätzlich die beste, die schlechteste Note aus.
 */



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

public class Jigloo_Events_setVisible_GUI_Notenbilanz extends javax.swing.JFrame {
	private JLabel jLAnzNot;
	private JTextField jTFNotenzahl;
	private JButton jBtnAnzahlUebernehmen;
	private JLabel jLNotenschnitt;
	private JLabel jLSchlechtesteNote;
	private JButton jBtnNeu;
	private JLabel jLBesteNote;
	private JLabel jLNotenzahl;
	private JTextField jTFNote;
	private JButton jBtnNoteUebernehmen;
	private JLabel jLNote;
	private JButton jBtnEnde;
	
	private DecimalFormat f;
	private int notenzahl, i; 
	private double notenschnitt, besteNote, schlechtesteNote, summe;
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Jigloo_Events_setVisible_GUI_Notenbilanz inst = new Jigloo_Events_setVisible_GUI_Notenbilanz();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public Jigloo_Events_setVisible_GUI_Notenbilanz() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Notenbilanz");
			{
				f = new DecimalFormat("#0.00"); // decimalformat initialisieren
			}
			{
				jLAnzNot = new JLabel();
				getContentPane().add(jLAnzNot);
				jLAnzNot.setText("Anzahl Noten");
				jLAnzNot.setBounds(12, 12, 88, 16);
			}
			{
				jTFNotenzahl = new JTextField();
				getContentPane().add(jTFNotenzahl);
				jTFNotenzahl.setBounds(12, 35, 44, 23);
				jTFNotenzahl.addKeyListener(new KeyAdapter() {
					public void keyPressed(KeyEvent evt) {
						jTFNotenzahlKeyPressed(evt);
					}
				});
			}
			{
				jBtnAnzahlUebernehmen = new JButton();
				getContentPane().add(jBtnAnzahlUebernehmen);
				jBtnAnzahlUebernehmen.setText("Übernehmen");
				jBtnAnzahlUebernehmen.setBounds(72, 35, 130, 23);
				jBtnAnzahlUebernehmen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnAnzahlUebernehmenActionPerformed(evt);
					}
				});
			}
			{
				jBtnEnde = new JButton();
				getContentPane().add(jBtnEnde);
				jBtnEnde.setText("Ende");
				jBtnEnde.setBounds(292, 220, 72, 23);
				jBtnEnde.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnEndeActionPerformed(evt);
					}
				});
			}
			{
				jLNote = new JLabel();
				getContentPane().add(jLNote);
				jLNote.setText("1. Note");
				jLNote.setBounds(12, 74, 50, 16);
				jLNote.setVisible(false);
			}
			{
				jBtnNoteUebernehmen = new JButton();
				getContentPane().add(jBtnNoteUebernehmen);
				jBtnNoteUebernehmen.setText("Übernehmen");
				jBtnNoteUebernehmen.setBounds(74, 99, 128, 23);
				jBtnNoteUebernehmen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnNoteUebernehmenActionPerformed(evt);
					}
				});
				jBtnNoteUebernehmen.setVisible(false);
			}
			{
				jTFNote = new JTextField();
				getContentPane().add(jTFNote);
				jTFNote.setBounds(12, 99, 44, 23);
				jTFNote.setVisible(false);
			}
			{
				jLNotenzahl = new JLabel();
				getContentPane().add(jLNotenzahl);
				jLNotenzahl.setBounds(12, 139, 190, 16);
			}
			{
				jLNotenschnitt = new JLabel();
				getContentPane().add(jLNotenschnitt);
				jLNotenschnitt.setBounds(12, 166, 190, 16);
			}
			{
				jLBesteNote = new JLabel();
				getContentPane().add(jLBesteNote);
				jLBesteNote.setBounds(12, 194, 190, 16);
			}
			{
				jLSchlechtesteNote = new JLabel();
				getContentPane().add(jLSchlechtesteNote);
				jLSchlechtesteNote.setBounds(12, 223, 190, 16);
			}
			{
				jBtnNeu = new JButton();
				getContentPane().add(jBtnNeu);
				jBtnNeu.setText("Neu Berechnen");
				jBtnNeu.setBounds(226, 35, 138, 23);
				jBtnNeu.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnNeuActionPerformed(evt);
					}
				});
				jBtnNeu.setVisible(false);
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private void anzahlUebernehmen(){
		if (!jTFNotenzahl.getText().equals("")){					// (try-catch-lösung wäre hübscher)
			notenzahl = Integer.parseInt(jTFNotenzahl.getText());
			// variabeln für nächsten schritt initialisieren
			i = 1;
			summe = 0;
			notenschnitt = 0;
			besteNote = 1; 			// schlechteste (ch) note eingeben zum vergleich
			schlechtesteNote = 6;	// beste (ch) note eingeben zum vergleich
			// die folgenden komponenten sichtbar machen
			jLNote.setVisible(true);
			jTFNote.setVisible(true);
			jBtnNoteUebernehmen.setVisible(true);
			jBtnAnzahlUebernehmen.setVisible(false);
			jTFNotenzahl.setEditable(false);
			jTFNote.requestFocus();
		} else {
			JOptionPane.showMessageDialog(null, "Bitte Anzahl Noten eingeben!");
			jTFNotenzahl.setText("");
			jTFNotenzahl.requestFocus();
		}

	}
	
	private void jBtnAnzahlUebernehmenActionPerformed(ActionEvent evt) {
		anzahlUebernehmen();
	}
	
	private void jTFNotenzahlKeyPressed(KeyEvent evt) {
		if (evt.getKeyCode() == KeyEvent.VK_ENTER){
			anzahlUebernehmen();
		}
	}
	
	private void jBtnNoteUebernehmenActionPerformed(ActionEvent evt) {
		if (!jTFNote.getText().equals("") 							// try-catch-lösung wäre auch hier hübscher
				&& Double.parseDouble(jTFNote.getText()) >= 1 
				&& Double.parseDouble(jTFNote.getText())<= 6){
			summe = summe + Double.parseDouble(jTFNote.getText());
			notenschnitt = summe / i;
			jLNotenzahl.setText("Anzahl eingegebene Noten: " + i);
			jLNotenschnitt.setText("Notenschnitt: " + f.format(notenschnitt));
			// beste note nur überschreiben, wenn bessere dazukommt
			if (Double.parseDouble(jTFNote.getText()) >= besteNote){ 	
				besteNote = Double.parseDouble(jTFNote.getText());
				jLBesteNote.setText("beste Note: " + Double.toString(besteNote));
			}
			// schlechteste note nur überschreiben, wenn schlechtere dazukommt
			if (Double.parseDouble(jTFNote.getText()) <= schlechtesteNote){ 	
				schlechtesteNote = Double.parseDouble(jTFNote.getText());
				jLSchlechtesteNote.setText("schlechteste Note: " + Double.toString(schlechtesteNote));
			}
			if (i == notenzahl){
				jBtnNoteUebernehmen.setVisible(false);
				jBtnNeu.setVisible(true);
			} else {
				i++;
				jLNote.setText(i + ". Note");
				jTFNote.setText("");
				jTFNote.requestFocus();
			}
			
		} else {
			JOptionPane.showMessageDialog(null, "Bitte Note von 1-6 eingeben!");
			jTFNote.setText("");
			jTFNote.requestFocus();
		}
	}
	
	private void jBtnNeuActionPerformed(ActionEvent evt) {
		i = 1;
		jLNote.setText(i + ". Note");
		summe = 0;
		notenschnitt = 0;
		besteNote = 1;
		schlechtesteNote = 6;
		jBtnAnzahlUebernehmen.setVisible(true);
		jTFNotenzahl.setEditable(true);
		jTFNotenzahl.setText("");
		jTFNotenzahl.requestFocus();
		jLNote.setVisible(false);
		jTFNote.setVisible(false);
		jTFNote.setText("");
		jBtnNoteUebernehmen.setVisible(false);
		jLNotenzahl.setText("");
		jLNotenschnitt.setText("");
		jLBesteNote.setText("");
		jLSchlechtesteNote.setText("");
		jBtnNeu.setVisible(false);
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