/* TODO 13.5.   Aufgabe 3, s.436,
 * class JPanel_KomponenteFuerTextPerMausklick_RadioGroup_Graphics2d_TextZeichner1
 * 
 * 	SIEHE ANALOG GELÖSTES:		13.2.1.   JPanel_Komponente_ZumHineinZeichnen_RadioGroup_getGraphics_Zeichnen2			s.403, (2. ANSATZ) OHNE REPAINT() bei frameveränderungen  
 * 
 * 
 * K&K:		Programm Textzeichner1
 * 			Gibt an beliebigen Positionen eines Panels Text in den Farben schwarz oder rot aus.
 * 
 * AUFGABENSTELLUNG:	- standardpanel, in das text an einer beliebigen position durch mausklick eingesetzt werden kann
 * 						- radio-buttons für farbe des textes (rot + schwarz)
 * 						- textfeld zur texteingabe
 * 						- das panel muss nicht bei frameveränderungen den text auto-repainten können (=> keine abgeleitete panel-komponente nötig, im stil JMyTextPanel = new JPanel() )
 * 						- zeichnen des textes mit der methode:		 drawString(Strings, float x, float y) 		der klasse Graphics2d
 * 
 * 
 */

package uebungen13Aufgaben;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

public class JPanel_KomponenteFuerTextPerMausklick_RadioGroup_Graphics2d_TextZeichner1 extends javax.swing.JFrame {

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	private JPanel jPanelTextflaeche;
	private ButtonGroup BtnGrpFarbe;		// buttonGroup (nicht sichbar)
	private JRadioButton jRBRot;
	private JRadioButton jRBSchwarz;
	private JTextField jTFTexteingabe;
	private JLabel jLTexteingabe;
	private Graphics2D g2d;					// grafik2d-kontext-objekt

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JPanel_KomponenteFuerTextPerMausklick_RadioGroup_Graphics2d_TextZeichner1 inst = new JPanel_KomponenteFuerTextPerMausklick_RadioGroup_Graphics2d_TextZeichner1();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public JPanel_KomponenteFuerTextPerMausklick_RadioGroup_Graphics2d_TextZeichner1() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			pack();
			this.setSize(600, 400);
			this.setTitle("TextZeichner 1, JPanel für Texteinfügen per Mausklick");
			getContentPane().setLayout(null);
			{
				jPanelTextflaeche = new JPanel();
				getContentPane().add(jPanelTextflaeche);
				jPanelTextflaeche.setBackground(Color.white);
				jPanelTextflaeche.setBounds(12, 12, 354, 338);
				jPanelTextflaeche.addMouseListener(new MouseAdapter() {		// Mouse-Event-handling
					public void mouseClicked(MouseEvent evt) {				// wenn maustasten-klick
						jPanelTextflaecheMouseClicked(evt);					// ausgelagerte handler-method für komponente JPanelTextflaeche
					}
				});
			}
			{
				jLTexteingabe = new JLabel();
				getContentPane().add(jLTexteingabe);
				jLTexteingabe.setText("Texteingabe:");
				jLTexteingabe.setBounds(384, 12, 126, 14);
			}
			{
				jTFTexteingabe = new JTextField();
				getContentPane().add(jTFTexteingabe);
				jTFTexteingabe.setBounds(384, 37, 183, 20);
			}
			{
				jRBSchwarz = new JRadioButton();
				getContentPane().add(jRBSchwarz);
				jRBSchwarz.setText("schwarz");
				jRBSchwarz.setSelected(true);
				jRBSchwarz.setBounds(400, 109, 103, 23);
				getBtnGrpFarbe().add(jRBSchwarz);							// methode um RadioButton schwarz zu ButtonGroup BtnGrpFarbe hinzuzufügen
			}
			{
				jRBRot = new JRadioButton();
				getContentPane().add(jRBRot);
				jRBRot.setText("rot");
				jRBRot.setBounds(400, 135, 98, 27);
				getBtnGrpFarbe().add(jRBRot);								// methode um RadioButton rot zu ButtonGroup BtnGrpFarbe hinzuzufügen
			}
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private ButtonGroup getBtnGrpFarbe() {									// methode für ButtonGroup BtnGrpFarbe, jigloo-auto-generiert
		if(BtnGrpFarbe == null) {
			BtnGrpFarbe = new ButtonGroup();
		}
		return BtnGrpFarbe;
	}
	
	private void jPanelTextflaecheMouseClicked(MouseEvent evt) {			// handler method für ereignis-behandlung bei maus-klick innerhalb jPanelTextflaeche
		String text = jTFTexteingabe.getText();								
		Color farbe;														
		int x = evt.getX();													// variable für koordinate x bei mausklick, via ereignis-objekt evt. x abfragen
		int y = evt.getY();													// dito für y
		if (jRBSchwarz.isSelected()) {										// wenn radiobutton schwarz angewählt ist..
			farbe = Color.black;											// farbe auf schwarz
		} else {															// sonst..
			farbe = Color.red;												// farbe auf rot
		}
		g2d = (Graphics2D) jPanelTextflaeche.getGraphics();					// grafik2d-kontext-objekt die typ-gecastete grafik-umgebung für die komponente zuweisen  
		g2d.setColor(farbe);												// grafik2d-kontext-objekt  auf oben gewählte farbe setzen
		g2d.drawString(text, x, y);											// via grafik2d-kontext-objekt methode zum zeichnen von text mit parameter (string, koordinaten x + y)
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