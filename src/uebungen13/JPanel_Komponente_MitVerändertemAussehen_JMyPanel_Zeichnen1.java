/* TODO 13.1.2.   s.400+(398), (JMyPanel anstelle JPanel) (1. ANSATZ) INKL. REPAINT() bei Frameveränderungen
 * class JPanel_Komponente_MitVerändertemAussehen_JMyPanelZeichnen1		&	JMyPanel  	
 * 
 * 		SIEHE:			13.1.2.  	JMyPanel				s.398+(400),	(1. ANSATZ, TEIL)
 * 
 * 		SIEHE AUCH:	 	13.1.1.   	Graphics_Klasse_Basics_Paint_Repaint_Invalidate_Canvas_InKoponentenZeichnen2Ansaetze			s.396,	
 * 
 * 		SIEHE AUCH:		13.2.1.		JPanel_Komponente_ZumHineinZeichnen_RadioGroup_getGraphics_Zeichnen2		s.403, (= 2. ANSATZ) OHNE REPAINT() bei frameveränderungen
 * 									
 * 
 * JPANEL (OD. AUCH JFRAME) ALS KOMPONENTE MIT VERÄNDERTEM AUSSEHEN ERSTELLEN:		(= 1. ANSATZ)
 * 
 * 	VORGEHEN:	
 * 
 * 		KURZ:	1. klasse JMyPanel als erweiterung von JPanel erstellen und in der methode paintComponent(..) die grafischen ergänzungen/abänderungen vornehmen, 
 * 																																			die die standardkomponente (Jpanel) nicht hätte.
 * 				2. anwender-klasse JMyPanel_Zeichnen erstellen, mit JPanel als Jgloo-GUI_Standard-element. 
 * 					=> dann allerdings den namen des konstruktors von JPanel() ersetzen durch JMyPanel().
 * 					=> JPanel der superklasse wird so ganz normal angezeigt		
 * 						&	 zusätzlich werden alle änderungen die in der methode paintComponent(Graphics g) von JMyPanel vorgenommen werden auch angezeigt
 * 					-> AUSSERDEM: die Jigloo funktionen zum abändern des JPanels bleiben erhalten 
 * 						-> diese änderungen über die Jigloo-hilfe werden im quellcode der anwenderklasse sichtbar			=> siehe initGUI() 
 * 
 * 
 * 		VORGEHEN KLASSE JMyPANE:
 * 
 * 			1. klasse JMyPanel extends JPanel erstellen + in der methode paintComponent() die grafischen ergänzungen/abänderungen vornehmen, die die standardkomponente nicht hätte
 * 
 * 				a. klasse JMyPanel ganz normal erstellen mit File > new Class > dialogfenster öffnet sich:
 * 
 * 																				-> unter superclass: 			javax.swing.JPanel 	(statt java.lang.Objekt)	einsetzen
 * 																				-> unter name:					JMyPanel (z.b.)
 * 																			[	-> constructors der superclass: könnte man auch autogenerieren (hier sind sie nicht nötig) ]
 *				
 * 				b. paintComponent(Graphics g) von JMyPanel mit den gewünschten änderungen überschreiben:
 * 
 *					=> paintComponent(..) ist zuständig für zeichenoperationen(änderungen), die die komponente selst betreffen
 * 						[ remember:  paint() -methode muss die komponente zeichnen können
 *										-> bei swing-komponenten (z.b. frame, Panel) ruft paint() automatisch paintComponent() +  paintBorder() + paintChildren() auf	] 
 * 						-> paintComponent(Graphics g) liefert kein ergebnis zurück	& 	erwartet eine graphics-komponente 
 * 				
 * 				KERN-CODE:		public class JMyPanel extends JPanel {
 * 
 *									public void paintComponent(Graphics g) {							// überschreiben der Methode paintComponent(..)der superklasse JPanel
 *									super.paintComponent(g);											// paintComponent-methode des vorgängers aufrufen..
 *									g.setColor(Color.red);												// zeichenfarbe einstellen mit der anweisung setColor(..) der klasse Graphics, die argument Color (klasse Color importier) erwartet
 *									g.drawLine(10, 10, this.getWidth() - 10, this.getHeight() -10);		// linie zeichnen (x, y, breite, höhe)
 * 								}
 * 
 * 
 * 
 * 		VORGEHEN KLASSE (ANWENDUNG) JPanel_Komponente_MitVerändertemAussehen_JMyPanelZeichnen1:
 * 
 * 			 2. anwender-klasse als neuen Frame JMyPanel_Zeichnen erstellen, mit JPanel-komponente  als Jgloo-GUI_Standard-element im initGUI()
 *  
 *  			a. frame erstellen (ganz normal mit File > new > other > GUI forms > swing jFrame) JPanel-Komponente reinziehen
 *  			
 * 				b. bezeichner JPanel() ersetzen durch JMyPanel()
 * 					-> bei den attributten der klasse	&	im initGUI() 
 * 
 * 					=> JPanel der superklasse wird so ganz normal angezeigt		
 * 						&	 zusätzlich werden alle änderungen die in der methode paintComponent(Graphics g) von JMyPanel vorgenommen wurden auch angezeigt
 * 
 * 					-> AUSSERDEM: bleiben die Jigloo funktionen zum abändern des JPanels erhalten 
 * 						-> diese änderungen über die propertieis von Jigloo werden im quellcode der anwenderklasse sichtbar			=> siehe initGUI() 
 * 							(z.b. backgroundcolor etc.)
 * 	
 * 		  	KERN-CODE:
 * 
 * 				private JMyPanel jPanel1;												// oben, attribut-typ JPanel durch JMyPanel ersetzen
 * 		
 * 		 		private void initGUI() {
 *					try {
 *						..
 *						{
 *							jPanel1 = new JMyPanel();									// konstruktor JPanel() durch JMyPanel ersetzen
 *							getContentPane().add(jPanel1);
 *							jPanel1.setBounds(12, 12, 360, 204);
 *							jPanel1.setBackground(new java.awt.Color(64,128,128));		// z.b. hintergrundfarbe weiterhin über die properties veränderbar
 *						}
 * 
 * 
 * K&K:		Klasse JMyPanel 
 * 			Die Klasse ist von der Standardkomponente JPanel abgeleitet. 
 * 			Sie demonstriert das Verändern einer Standardkomponente durch das Einzeichnen einer diagonalen Linie.
 * 
 * 			Programm JMyPanel_Zeichnen1
 * 			Verwendet die von JPanel abgeleitete Klasse JMyPaintPanel.
 * 
 */

package uebungen13;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;



public class JPanel_Komponente_MitVerändertemAussehen_JMyPanel_Zeichnen1 extends javax.swing.JFrame {
	private JMyPanel jPanel1;					// oben, attribut-typ JPanel durch JMyPanel ersetzen
	private JButton jBtnEnde;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JPanel_Komponente_MitVerändertemAussehen_JMyPanel_Zeichnen1 inst = new JPanel_Komponente_MitVerändertemAussehen_JMyPanel_Zeichnen1();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public JPanel_Komponente_MitVerändertemAussehen_JMyPanel_Zeichnen1() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Zeichnen 1, jMyPanel statt jPanel");
			{
				jPanel1 = new JMyPanel();								// konstruktor JPanel() durch JMyPanel ersetzen
				getContentPane().add(jPanel1);
				jPanel1.setBounds(12, 12, 360, 204);
				jPanel1.setBackground(new java.awt.Color(64,128,128));	// z.b. hintergrundfarbe weiterhin über die properties veränderbar
				jPanel1.setFont(new java.awt.Font("Serif",3,72));
			}
			{
				jBtnEnde = new JButton();
				getContentPane().add(jBtnEnde);
				jBtnEnde.setText("Ende");
				jBtnEnde.setBounds(126, 228, 138, 23);
				jBtnEnde.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnEndeActionPerformed(evt);
					}
				});
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