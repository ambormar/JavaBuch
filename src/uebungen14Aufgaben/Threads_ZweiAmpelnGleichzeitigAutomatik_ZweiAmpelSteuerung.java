/* TODO 14.3.   Aufgabe 2,   s.459, verwendet JAmpelPanel_5
 * class 	Threads_ZweiAmpelnGleichzeitigAutomatik_ZweiAmpelSteuerung		&		JAmpelPanel_5	
 * 
 * K&K:		Programm .._ZweiAmpelSteuerung:		 (Musterlösung zu Kapitel 14 Aufgabe 2)
 * 			Das Programm nutzt die Klasse JAmpelPanel_5. Zwei Ampeln wechseln ihre Phasen mit unterschiedlicher Phasendauer.
 * 			Da 2 Instanzen des JAmpelPanel_5 als jeweilige zusätzliche Threads laufengelassen werden müssen sie nicht synchronized werden.
 * 
 * 					- zweiampelsteuerung stellt 2 objekte der klasse JAmpelPanel nebeneinender dar
 * 					- jede ampel soll andere phasenzeiten verwenden
 * 					- mit start sollen beide ampeln anfangen zu laufen in ihren jeweiligen phasen
 * 					- mit stop sollen sie anhalten
 * 			
 * 
 * VOORGEHEN:		
 *	
 *		Programm .._ZweiAmpelSteuerung:
 * 
 *			=> Das Programm nutzt die Klasse JAmpelPanel_5. Zwei Ampeln wechseln ihre Phasen mit unterschiedlicher Phasendauer.
 * 					
 * 			=> Da 2 Instanzen des JAmpelPanel_5 als jeweilige zusätzliche Threads laufengelassen werden müssen sie nicht synchronized werden
 * 				-> nur wenn auf variabeln etc. von 2 Threads aus dem selben instanzobjekt zugegriffen wird braucht's synchronized				SIEHE: SYNCHRONIZED unten
 * 
 * 			=> 	private JAmpelPanel_5 jPanel1;							// 1. instanz des abgeleiteten JAmpelPanels_5
				private JAmpelPanel_5 jPanel2;							// 2. instanz des abgeleiteten JAmpelPanels_5
				private JButton jBtnStart;
				private JButton jBtnEnde;
				private JButton jBtnStop;
				
			=>	HIER WEITER !!!!!!!!!!!!!!!!!!!!!!!
			
			
			
			
 * 
 * THREAD-FUNKTIONEN STOPPEN VIA BOOLEAN VARIABELN TRUE / FALSE:
 * 
 * 		!!!!!!! VIELLEICHT NOCH SCHREIBEN ABER VEILLLEICHT AUCH NICHT !!!!!!!!!!!!!!!!!!¨
 * 
 * 
 * 
 * 
 * 
 * SYNCHRONIZED:		=> Da 2 Instanzen des JAmpelPanel_5 als jeweilige zusätzliche Threads laufengelassen werden müssen sie nicht synchronized werden
 * 							-> nur wenn auf variabeln etc. von 2 Threads aus dem selben instanzobjekt zugegriffen wird braucht's synchronized	
 * 
 * 
 *								private JAmpelPanel_5 jPanel1;
 *								private JAmpelPanel_5 jPanel2; 
 *	
 *	 							private void jBtnStartActionPerformed(ActionEvent evt) {
 *									Thread ampel1 = new Thread(jPanel1);
 *									jPanel1.automatik = true;
 *									ampel1.start();
 *									Thread ampel2 = new Thread(jPanel2);
 *									jPanel2.automatik = true;
 *									ampel2.start();
 *								}
 */

package uebungen14Aufgaben;
import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


public class Threads_ZweiAmpelnGleichzeitigAutomatik_ZweiAmpelSteuerung extends javax.swing.JFrame {

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	private JAmpelPanel_5 jPanel1;							// 1. instanz des abgeleiteten JAmpelPanels_5
	private JAmpelPanel_5 jPanel2;							// 2. instanz des abgeleiteten JAmpelPanels_5
	private JButton jBtnStart;
	private JButton jBtnEnde;
	private JButton jBtnStop;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Threads_ZweiAmpelnGleichzeitigAutomatik_ZweiAmpelSteuerung inst = new Threads_ZweiAmpelnGleichzeitigAutomatik_ZweiAmpelSteuerung();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public Threads_ZweiAmpelnGleichzeitigAutomatik_ZweiAmpelSteuerung() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			AnchorLayout thisLayout = new AnchorLayout();
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("ZweiAmpelSteuerung");
			{
				jBtnEnde = new JButton();
				getContentPane().add(jBtnEnde, new AnchorConstraint(798, 891, 871, 644, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jBtnEnde.setText("Ende");
				jBtnEnde.setPreferredSize(new java.awt.Dimension(88, 23));
				jBtnEnde.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnEndeActionPerformed(evt);
					}
				});
			}
			{
				jBtnStop = new JButton();
				getContentPane().add(jBtnStop, new AnchorConstraint(303, 891, 376, 644, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jBtnStop.setText("Stop");
				jBtnStop.setPreferredSize(new java.awt.Dimension(88, 23));
				jBtnStop.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnStopActionPerformed(evt);
					}
				});
			}
			{
				jBtnStart = new JButton();
				getContentPane().add(jBtnStart, new AnchorConstraint(115, 891, 188, 644, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jBtnStart.setText("Start");
				jBtnStart.setPreferredSize(new java.awt.Dimension(88, 23));
				jBtnStart.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnStartActionPerformed(evt);
					}
				});
			}
			{
				jPanel2 = new JAmpelPanel_5(3000, 800, 3000, 800);			// instanzieren mittels Konstruktor mit Parameter für die Phasendauer-wert
				getContentPane().add(jPanel2, new AnchorConstraint(74, 563, 925, 324, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jPanel2.setPreferredSize(new java.awt.Dimension(85, 268));
			}
			{
				jPanel1 = new JAmpelPanel_5(4000, 1000, 4000, 1000);		// instanzieren mittels Konstruktor mit Parameter für die Phasendauer-wert
				getContentPane().add(jPanel1, new AnchorConstraint(74, 276, 925, 35, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jPanel1.setPreferredSize(new java.awt.Dimension(86, 268));
			}
			pack();
			this.setSize(372, 354);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}							
	
	// start-button zum erzeugen und starten der 2 parallelen Threads -> Da 2 Instanzen des JAmpelPanel_5 als jeweilige zusätzliche Threads laufengelassen werden müssen sie nicht synchronized ..
																		//.. werden -> nur wenn auf variabeln etc. von 2 Threads aus dem selben instanzobjekt zugegriffen wird braucht's synchronized
	private void jBtnStartActionPerformed(ActionEvent evt) { 
		Thread ampel1 = new Thread(jPanel1);				// erzeugen des 1. zusätzlichen Threads mit parameter jPanel1 (= target 1. ObjektInstanz von JAmpelPanel_5)
		jPanel1.automatik = true;							// zugriff auf public automatik von jPanel1, voraussetzung um die ampel nacher im stop einfach wieder abzustellen
		ampel1.start();										// thread starten
		Thread ampel2 = new Thread(jPanel2);				// erzeugen des 2. zusätzlichen Threads mit parameter jPanel2 (= target 2. ObjektInstanz von JAmpelPanel_5)
		jPanel2.automatik = true;							// zugriff auf public automatik von jPanel2, voraussetzung um die ampel nacher im stop einfach wieder abzustellen
		ampel2.start();										// thread starten
	}
	
	private void jBtnStopActionPerformed(ActionEvent evt) {
		jPanel1.automatik = false;							// einfachste möglichkeit um die ampel zu unterbrechen, ohne den Thread ausserhalb der beiden start-stop methoden erzeugen zu müssen
		jPanel2.automatik = false;							// einfachste möglichkeit um die ampel zu unterbrechen, ohne den Thread ausserhalb der beiden start-stop methoden erzeugen zu müssen
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