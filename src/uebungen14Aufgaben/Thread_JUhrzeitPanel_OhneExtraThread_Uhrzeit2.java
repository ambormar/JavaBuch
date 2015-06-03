/* TODO 14.3.4.   Aufgabe 4,   s.460, verwendet JUhrzeitPanel (ohne zusätzlichen Thread)
 * class 	JUhrzeitPanel		&		Thread_JUhrzeitPanel_OhneExtraThread_Uhrzeit2
 * 
 * K&K:		Klasse JUhrzeitPanel:		(Musterlösung zu Kapitel 14 Aufgabe 4)
 * 				Die Klasse ist von der Klasse JPanel abgeleitet. Die Klasse stellt die aktuelle Uhrzeit in einem Panel dar.
 * 				Die Uhrzeit wird ohne zusätzlichen Thread ständig aktualisiert. 
 * 					-> Unter benutzung von repaint() + System.currentTimeMillis(..) wird die paintComponent()-methode so oft aufgerufen, ..
 * 						..dass man keinen zusätzlichen thread braucht um eine laufande uhr zu erhalten
 * 
 * 
 * 
 * 			Programm Uhrzeit2:			(Musterlösung zu Kapitel 14 Aufgabe 4)
 * 				Das Programm verwendet die selbsterstellte klasse JUhrzeitPanel, um eine laufende Uhr als Panel in einem Frame darzustellen. 
 * 
 * VORGEHEN:	Klasse JUhrzeitPanel:	
 * 	
 * 					=> OHNE implementieren des Interface Runnable 		-> also OHNE 2. Thread
 * 
 * 					=> nur paintComponent() überschreiben, u.a. mit uhrzeit als formatiertem string mit der aktuellenn uhrzeit aus System.currentTimeMillis(..) 	& 	repaint():
 * 						
 * 						public void paintComponent(Graphics g) {													// NUR überschreiben von paintComponent() 
 * 							..
 * 							SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");								// zeitformatierung  mit der klasse SimppleDateFormate, als Parameter das gewünschte format
 *							String uhrzeit = sdf.format(System.currentTimeMillis());								// objekt sdf mit formatierter aktueller uhrzeit dem string zuweisen  // Holt die aktuelle Uhrzeit in die Variable uhrzeit
 *							..
 *							g.drawString(uhrzeit, 0, (int) this.getSize().getHeight());								// string ausgeben, parameter: string uhrzeit, x-koord 0, y-koord gesamthöhe des panels 
 *							repaint();																				// WICHTIGST ohne repaint() läuft die uhr nicht, weil sie sich zwar ohne zusätzlichen thread erneuert, aber repaint() braucht
 *						}
 *
 *				Programm Uhrzeit2:	
 *
 *					=> einsetzen des JUhrzeitPanels anstelle des standard JPanels
 * 
 * 						jPanel1 = new JUhrzeitPanel();
 * 
 * 
 * 
 * 	PAINTCOMPONENT MIT REPAINT() & SYSTEM.CURRENTTIMEMILLIS(..) ANSTELLE EINES ZUSÄTZLICHEN THREADS :
 *
 * 						-> Unter benutzung von repaint() + System.currentTimeMillis(..) in der überschriebenen paintComponent()-methode, ..
 * 							.. wird die paintComponent()-methode so oft aufgerufen, dass man keinen zusätzlichen thread braucht um eine laufande uhr zu erhalten
 * 
 * 				
 */


package uebungen14Aufgaben;
import javax.swing.JPanel;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;



public class Thread_JUhrzeitPanel_OhneExtraThread_Uhrzeit2 extends javax.swing.JFrame {
	
	private JUhrzeitPanel jPanel1;											// jPanel1 vom typ JUhrzeitPanel (selbstabgeleitete komponente von JPanel)  							

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Thread_JUhrzeitPanel_OhneExtraThread_Uhrzeit2 inst = new Thread_JUhrzeitPanel_OhneExtraThread_Uhrzeit2();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public Thread_JUhrzeitPanel_OhneExtraThread_Uhrzeit2() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jPanel1 = new JUhrzeitPanel();								// erzeugen des selbstabgeleiteten JPanels vom typ JUhrzeitPanel
				getContentPane().add(jPanel1);
				jPanel1.setBounds(10, 12, 108, 27);
			}
			pack();
			this.setSize(300, 400);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
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