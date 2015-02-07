/* TODO 13.2.1   s.403,	 (2. ANSATZ)
 * class 	JPanel_StandardKomponente_ZumHineinZeichnen_Zeichnen2
 * 
 * 		SIEHE AUCH:		13.1.2.   JPanel_Komponente_MitVerändertemAussehen_JMyPanelZeichnen1	&	JMyPanel 		s.400+(398), 	(= 1. ANSATZ)
 * 
 * 		SIEHE AUCH:	 	13.1.1.   Graphics_Klasse_Basics_Paint_Repaint_Invalidate_Canvas_InKoponentenZeichnen2Ansaetze			s.396,		
 * 
 * 
 * JPANEL (OD. AUCH JFRAME) ALS STANDARD-KOMPONENTE ZUM HINEINZEICHNEN:		(= 2. ANSATZ)
 * 
 * 			=> JPanel/JFrame mit Möglichkeit für den anwender zum interaktiv hineinzeichnen
 * 
 * 		KURZ:	
 * 
 * 		VORGEHEN:
 * 
 * 	
 * 
 * 		KERN-CODE:
 * 
 * 
 * 
 *		RADIOBUTTONS:
 *
 *			=> WICHTIG:		ZUERST die versch. RadioButtons erstellen, 	DANN die ButtonGroup (hier: BtnGrpFigure), 	DANN zuordnung der RadioButtons zur ButtonGroup
 *								-> sonst hat's eine meise und erstellt irgendwelche lustigen getters 
 *			=> normal mit Jigloo reinziehen
 *
 * 
 * 		BUTTONGROUP:
 * 	
 * 			=> nötig für zusammenspiel von mehreren RadioButtons, von denen nur einer aufs mal ausgewählt werden kann
 * 			=> egal wo reinziehen in den frame		-> wird NICHT dargestellt im GUI / initGUI()  
 * 													-> erscheint im outline unter non-visulal components  (nicht wie die anderen komponenten unter frame)
 * 			=> autoerzeugung der variablen oben durch jigloo  (hier: BtnGrpFigure)  
 * 			=> autoerzeugung der zugehörigen getter-methode durch jigloo 	-> getter-methoden-name setzt sich zusammen aus get + vergebenem variabel-namen
 * 					  
 * 
 * 			=> CODE:		
 * 
 * 				private ButtonGroup BtnGrpFigur;			// auto-erzeugte variable von jigloo, 
 * 
 *				public ButtonGroup getBtnGrpFigur() {		// Jigloo-erzeugt, methode liefert referenz auf die ButtonGroup
 *					if(BtnGrpFigur == null) {				// prüft ob bereits objekt erzeugt wurde..
 *						BtnGrpFigur = new ButtonGroup();	// .. wenn nicht, wird konstruktor aufgerufen (objekt erzeugt) ..
 *					}
 *					return BtnGrpFigur;						// .. und die referenz auf das objekt zurückgeliefert
 *				} 
 *
 *		ZUORDNUNG DER RADIOBUTTONS ZUR RADIOGROUP:
 *
 *			=> RadioGroup sorgt dafür, dass nur ein RadioButton auf's mal ausgewählt sein kann
 *			=> jedem RadioButton in den properties unter eigenschaft buttonGroup die RadioGroup (hier: BtnGrpFigure) zuordnen 
 * 				
 * 			=> CODE:   		getBtnGrpFigure().add(jRBtnReckteck);		// bsp ergänzung  im initGUI() um jRBtnRechteck der ButtonGroup BtnGrpFigur zuzuordnen
 * 
 * 
 * 
 * 	VORGEHEN:		
 * 
 */

package uebungen13;

import javax.swing.ButtonGroup;			// guck themenspez. imp.

import javax.swing.JCheckBox;			// guck
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;		// guck
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


public class JPanel_StandardKomponente_ZumHineinZeichnen_Zeichnen2 extends javax.swing.JFrame {

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private JLabel jLZeichenflaeche;
	private JLabel jLPositionX1;
	private JRadioButton jRBtnReckteck;
	private ButtonGroup BtnGrpFigure;			// auto-erzeugte variable von jigloo, 
	private JRadioButton jRBtnLinie;
	private JRadioButton jRBtnOval;
	private JRadioButton jRBtnKreis;
	private JRadioButton jRBtnRechteck;
	private JCheckBox jCheckBgefuellt;
	private JTextField jTFPositionY2;
	private JLabel jLPositionY2;
	private JTextField jTFPositionX2;
	private JLabel jLPositionX2;
	private JTextField jTFPositionY1;
	private JLabel jLPositionY1;
	private JTextField jTFPositionX1;
	private JPanel jPanelZeichenflaeche;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JPanel_StandardKomponente_ZumHineinZeichnen_Zeichnen2 inst = new JPanel_StandardKomponente_ZumHineinZeichnen_Zeichnen2();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public JPanel_StandardKomponente_ZumHineinZeichnen_Zeichnen2() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Zeichnen 2");
			{
				jLZeichenflaeche = new JLabel();
				getContentPane().add(jLZeichenflaeche);
				jLZeichenflaeche.setText("Zeichenfläche");
				jLZeichenflaeche.setBounds(12, 12, 135, 16);
			}
			{
				jPanelZeichenflaeche = new JPanel();
				getContentPane().add(jPanelZeichenflaeche);
				jPanelZeichenflaeche.setBounds(12, 40, 336, 410);
				jPanelZeichenflaeche.setBackground(new java.awt.Color(255,255,255));			// hintergrund auf weiss setzen mit gui properties
			}
			{
				jLPositionX1 = new JLabel();
				getContentPane().add(jLPositionX1);
				jLPositionX1.setText("Position x:");
				jLPositionX1.setBounds(375, 12, 65, 16);
			}
			{
				jTFPositionX1 = new JTextField();
				getContentPane().add(jTFPositionX1);
				jTFPositionX1.setBounds(440, 9, 64, 23);
			}
			{
				jLPositionY1 = new JLabel();
				getContentPane().add(jLPositionY1);
				jLPositionY1.setText("y:");
				jLPositionY1.setBounds(566, 12, 24, 16);
			}
			{
				jTFPositionY1 = new JTextField();
				getContentPane().add(jTFPositionY1);
				jTFPositionY1.setBounds(590, 9, 64, 23);
			}
			{
				jLPositionX2 = new JLabel();
				getContentPane().add(jLPositionX2);
				jLPositionX2.setText("Breite:");
				jLPositionX2.setBounds(396, 51, 44, 16);
			}
			{
				jTFPositionX2 = new JTextField();
				getContentPane().add(jTFPositionX2);
				jTFPositionX2.setBounds(440, 48, 64, 23);
			}
			{
				jLPositionY2 = new JLabel();
				getContentPane().add(jLPositionY2);
				jLPositionY2.setText("Höhe:");
				jLPositionY2.setBounds(543, 51, 47, 16);
			}
			{
				jTFPositionY2 = new JTextField();
				getContentPane().add(jTFPositionY2);
				jTFPositionY2.setBounds(590, 48, 64, 23);
			}
			{
				jCheckBgefuellt = new JCheckBox();
				getContentPane().add(jCheckBgefuellt);
				jCheckBgefuellt.setText("gefüllt");
				jCheckBgefuellt.setBounds(543, 108, 99, 20);
			}
			{
				jRBtnReckteck = new JRadioButton();
				getContentPane().add(jRBtnReckteck);
				jRBtnReckteck.setText("Rechteck");
				jRBtnReckteck.setBounds(418, 108, 99, 20);
				getBtnGrpFigure().add(jRBtnReckteck);			// in den properties die zuordnung zur buttonGroup BtnGrpFigure einstellen 
			}
			{
				jRBtnKreis = new JRadioButton();
				getContentPane().add(jRBtnKreis);
				jRBtnKreis.setText("Kreis");
				jRBtnKreis.setBounds(418, 142, 86, 23);
				getBtnGrpFigure().add(jRBtnKreis);				// in den properties die zuordnung zur buttonGroup BtnGrpFigure einstellen 
			}
			{
				jRBtnOval = new JRadioButton();
				getContentPane().add(jRBtnOval);
				jRBtnOval.setText("Oval");
				jRBtnOval.setBounds(418, 182, 86, 23);
				getBtnGrpFigure().add(jRBtnOval);				// in den properties die zuordnung zur buttonGroup BtnGrpFigure einstellen 
			}
			{
				jRBtnLinie = new JRadioButton();
				getContentPane().add(jRBtnLinie);
				jRBtnLinie.setText("Linie");
				jRBtnLinie.setBounds(418, 221, 86, 23);
				getBtnGrpFigure().add(jRBtnLinie);				// in den properties die zuordnung zur buttonGroup BtnGrpFigure einstellen 
			}

			pack();
			this.setSize(700, 500);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	// getter-methode für ButtonGroup;  Jigloo-erzeugt; entsprechende variable wird oben auch autoerzeugt
	private ButtonGroup getBtnGrpFigure() {		// methode liefert referenz auf die ButtonGroup
		if(BtnGrpFigure == null) {				// prüft ob bereits objekt erzeugt wurde..
			BtnGrpFigure = new ButtonGroup();	// .. wenn nicht, wird konstruktor aufgerufen (objekt erzeugt) ..
		}
		return BtnGrpFigure;					// .. und die referenz auf das objekt zurückgeliefert
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
