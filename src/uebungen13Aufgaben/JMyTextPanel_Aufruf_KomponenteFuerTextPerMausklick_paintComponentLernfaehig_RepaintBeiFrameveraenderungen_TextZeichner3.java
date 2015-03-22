/* TODO 13.5.   Aufgabe 5, s.437, MIT REPAINT() bei framever�nderungen; mit Graphics2D  !!!!!!!!!
 * class JMyTextPanel_Aufruf_KomponenteFuerTextPerMausklick_paintComponentLernfaehig_RepaintBeiFrameveraenderungen_TextZeichner3	& 	JMyTextPanel	&	TextAusgabeObjekt
 * 
 * 
 * 	SIEHE ANALOG GEL�STES:		13.2.5.   JMyPaintPanel_KomponenteZumHineinZeichnen_paintComponentLernfaehig_RepaintBeiFrameveraenderungen_Zeichnen4	s.413, (3. ANSATZ)  MIT REPAINT() bei framever�nderungen; mit Graphics2D
 *  
 *  
 *  
 * !!!!!!!!!!!!!!!! alles �berarbeiten ab hier , kommentare stimmen nicht !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!��
 * 
 * K&K:		Programm Textzeichner1
 * 			Gibt an beliebigen Positionen eines Panels Text in den Farben schwarz oder rot aus.
 * 
 * AUFGABENSTELLUNG:	- standardpanel, in das text an einer beliebigen position durch mausklick eingesetzt werden kann
 * 						- radio-buttons f�r farbe des textes (rot + schwarz)
 * 						- textfeld zur texteingabe
 * 						- das panel muss nicht bei framever�nderungen den text auto-repainten k�nnen (=> keine abgeleitete panel-komponente n�tig, im stil JMyTextPanel = new JPanel() )
 * 						- zeichnen des textes mit der methode:		 drawString(Strings, float x, float y) 		der klasse Graphics2d
 * 
 * 
 */

package uebungen13Aufgaben;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

public class JMyTextPanel_Aufruf_KomponenteFuerTextPerMausklick_paintComponentLernfaehig_RepaintBeiFrameveraenderungen_TextZeichner3 extends javax.swing.JFrame {

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	private JMyTextPanel jPanelTextflaeche;							// zeichenfl�che initialsieren, aber mit dem objektdatentyp JMyTextPanel (geerbt von JPanel)
	private JButton jBtnLoeschen;
	private ButtonGroup BtnGrpFarbe;																									// buttonGroup (nicht sichbar)
	private JRadioButton jRBRot;
	private JRadioButton jRBSchwarz;
	private JTextField jTFTexteingabe;
	private JLabel jLTexteingabe;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JMyTextPanel_Aufruf_KomponenteFuerTextPerMausklick_paintComponentLernfaehig_RepaintBeiFrameveraenderungen_TextZeichner3 inst = new JMyTextPanel_Aufruf_KomponenteFuerTextPerMausklick_paintComponentLernfaehig_RepaintBeiFrameveraenderungen_TextZeichner3();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public JMyTextPanel_Aufruf_KomponenteFuerTextPerMausklick_paintComponentLernfaehig_RepaintBeiFrameveraenderungen_TextZeichner3() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			pack();
			this.setSize(600, 400);
			this.setTitle("TextZeichner 3, JMyTextPanel Texteinf�gen mit auto-repaint() bei Framever�nderungen");
			getContentPane().setLayout(null);
			{
				jPanelTextflaeche = new JMyTextPanel();						// zeichenfl�che aus der selbsterstellten/abgeleiteten komponente JMyTextPanel
				getContentPane().add(jPanelTextflaeche);
				jPanelTextflaeche.setBackground(Color.white);
				jPanelTextflaeche.setBounds(12, 12, 354, 338);
				jPanelTextflaeche.addMouseListener(new MouseAdapter() {																		// Mouse-Event-handling
					public void mouseClicked(MouseEvent evt) {																				// wenn maustasten-klick
						jPanelTextflaecheMouseClicked(evt);																					// ausgelagerte handler-method f�r komponente JPanelTextflaeche
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
				getBtnGrpFarbe().add(jRBSchwarz);																							// methode um RadioButton schwarz zu ButtonGroup BtnGrpFarbe hinzuzuf�gen
			}
			{
				jRBRot = new JRadioButton();
				getContentPane().add(jRBRot);
				jRBRot.setText("rot");
				jRBRot.setBounds(400, 135, 98, 27);
				getBtnGrpFarbe().add(jRBRot);																								// methode um RadioButton rot zu ButtonGroup BtnGrpFarbe hinzuzuf�gen
			}
			{
				jBtnLoeschen = new JButton();
				getContentPane().add(jBtnLoeschen);
				jBtnLoeschen.setText("Letzten Text l�schen");
				jBtnLoeschen.setBounds(384, 204, 183, 23);
				jBtnLoeschen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnLoeschenActionPerformed(evt);
					}
				});
			}
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private ButtonGroup getBtnGrpFarbe() {																									// methode f�r ButtonGroup BtnGrpFarbe, jigloo-auto-generiert
		if(BtnGrpFarbe == null) {
			BtnGrpFarbe = new ButtonGroup();
		}
		return BtnGrpFarbe;
	}
	
	// handler method f�r ereignis-behandlung bei maus-klick innerhalb jPanelTextflaeche
	private void jPanelTextflaecheMouseClicked(MouseEvent evt) {			
		int x = evt.getX();											// variable f�r koordinate x bei mausklick, via ereignis-objekt evt. x abfragen
		int y = evt.getY();											// dito f�r y
		String text = jTFTexteingabe.getText();
		Color farbe;									
		if (jRBSchwarz.isSelected()) {								// wenn radiobutton schwarz angew�hlt ist..
			farbe = Color.black;									// farbe auf schwarz
		} else {													// sonst..
			farbe = Color.red;										// farbe auf rot
		}
		// die anweisungen zum zeichnen des Textes fallen weg & werden durch die folgenden 2 anweisungen ersetzt:
		jPanelTextflaeche.addTextAusgabeObjekt(x, y, text, farbe);// methoden-aufruf zur erzeugung eines neuen TextAusgabeObjekts im JMyTextPanel unter mitgabe seiner eigenschaften (x, y, etc.)
		jPanelTextflaeche.repaint();			// methode repaint f�r das textausgabe-panel, damit wird das �bergebene TextAusgabeObjekt auch unmittelbar dargestellt
	}
	
	// methode um JMyTextPanel neu, minus das zuletzt hinzugef�gte TextAusgabeObjekt, zu zeichnen
	private void jBtnLoeschenActionPerformed(ActionEvent evt) {
		jPanelTextflaeche.loescheLetztesTextObjekt();		// aufruf der methode um das letzte TextAusgabeObjekt aus der arrralist texte (im JMyTextPanel) zu l�schen 	
		jPanelTextflaeche.repaint();						// xy.repaint() : panel neu zeichnen (inkl. verbleibende TextAusgabeObjekte der arraylist texte) 
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