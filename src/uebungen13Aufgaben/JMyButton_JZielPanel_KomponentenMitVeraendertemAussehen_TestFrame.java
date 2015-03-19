/* TODO 13.5.   Aufgabe 1+2, s.435, (extends JFrame) JMyButton statt JButton & JZielPanel statt JPanel 		
 * class JMyButton_JZielPanel_KomponentenMitVeraendertemAussehen_TestFrame		& 	JMyButton		& 		JZielPanel
 * 
 * 		SIEHE:			13.5.   	JMyButton															Aufgabe 1, s.435, (extends JButton)
 * 
 *  	SIEHE:			13.5.   	JZielPanel															Aufgabe 2, s.435, (extends JZielPanel)		 
 *   
 * 		VERGLEICHE:		13.1.2.   	JMyPanel															s.398+(400), (JMyPanel extends JPanel)
 * 
 * 		VERGLEICHE:		13.1.2.   	JPanel_Komponente_MitVerändertemAussehen_JMyPanelZeichnen1			s.400+(398), (JMyPanel anstelle JPanel) 
 *  
 * 
 * K&K:		Klasse JMyButton
 * 			Die Klasse ist von der Standardkomponente JButton abgeleitet. Sie besitzt als Erweiterung eine grüne Linie als zusätzlichen Rahmen.
 * 
 * K&K:		Programm JMyButton_JZielPanel_KomponentenMitVeraendertemAussehen_TestFrame. 
 * 			Verwendet die Komponenten JZielPanel und JMyButton.
 * 
 * K&K:	 	Klasse JZielPanel
 *	 		Die Klasse ist von der Standardkomponente JPanel abgeleitet. Auf das Panel ist eine Zielscheibe eingezeichnet.
 * 
 * VORGEHEN:	JMyButton	&
 * 				JZielPanel:			ANALOG:		13.1.2.   	JMyPanel		s.398+(400), (JMyPanel extends JPanel)
 * 
 * 				TestFrame:			ANALOG:		13.1.2.   	JPanel_Komponente_MitVerändertemAussehen_JMyPanelZeichnen1		s.400+(398), (JMyPanel anstelle JPanel) 
 * 												=> VORGEHEN KLASSE (ANWENDUNG)
 * 
 */

package uebungen13Aufgaben;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

public class JMyButton_JZielPanel_KomponentenMitVeraendertemAussehen_TestFrame extends javax.swing.JFrame {

	private JMyButton jBtnEnde;												// oben, attribut-typ JButton durch JMyButton ersetzen
	private JZielPanel jPanel1;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JMyButton_JZielPanel_KomponentenMitVeraendertemAussehen_TestFrame inst = new JMyButton_JZielPanel_KomponentenMitVeraendertemAussehen_TestFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public JMyButton_JZielPanel_KomponentenMitVeraendertemAussehen_TestFrame() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("JMyButton, JButton mit veraendertem Aussehen");
			{
				jBtnEnde = new JMyButton();									// konstruktor JButton() durch JMyButton ersetzen
				getContentPane().add(jBtnEnde);
				jBtnEnde.setText("Ende");
				jBtnEnde.setBounds(258, 209, 103, 31);
				jBtnEnde.setBackground(new java.awt.Color(165,209,209));	// z.b. hintergrundfarbe weiterhin über die properties veränderbar
				jBtnEnde.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnEndeActionPerformed(evt);
					}
				});
			}
			{
				jPanel1 = new JZielPanel();
				getContentPane().add(jPanel1);
				jPanel1.setBounds(15, 20, 220, 220);
				jPanel1.setBackground(new java.awt.Color(247,179,218));
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
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