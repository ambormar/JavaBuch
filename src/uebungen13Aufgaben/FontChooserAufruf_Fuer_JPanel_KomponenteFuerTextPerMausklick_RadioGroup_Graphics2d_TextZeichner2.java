/* TODO 13.5.   Aufgabe 4, s.436, u.a. AUFRUF VON FONTCHOOSER
 * class FontChooserAufruf_Fuer_JPanel_KomponenteFuerTextPerMausklick_RadioGroup_Graphics2d_TextZeichner2		&		JMyFontChooser extends Component
 * 
 * 								JMYFONTCHOOSER:			13.4.5.   JMyFontChooser extends Component			s.435 (eigtl. buchDVD), FontChooser zum aufrufen / benutzen		aufg.4
 * 
 *							SONST ERWEITERUNG VON:		13.2.1.   JPanel_Komponente_ZumHineinZeichnen_RadioGroup_getGraphics_Zeichnen2			s.403, (2. ANSATZ) OHNE REPAINT() bei frameveränderungen  
 * 
 * 		AUFRUF: FONTCHOOSER ANALOG COLORCHOOSER:		13.3.2.   JColorChooser_FarbauswahlDialog_JColorPanel_Fuer_JMyPaintPanel_KomponenteZumHineinZeichnen_Zeichnen5		s.423, 
 * 
 * 
 * 
 * K&K:		Programm Textzeichner2 (erweiterung Textzeichner2) mit Fontauswahl-Dialog
 * 			Gibt an beliebigen Positionen eines Panels Text in den Farben schwarz oder rot aus.
 * 
 * AUFGABENSTELLUNG: 
 * 
 * 			Textzeichner 2:	- zusätzliche schaltfläche:		
 * 								-> zum aufruf des JFontChooser für auswahl der schriftart
 * 								-> JFontChooser (vorgefertigt) übernehemn von buch-dvd 		-> uebungen13 	13.4.5.   JMyFontChooser extends Component
 * 								-> methode showDialog(Component component, Font font) kann auch mit parameterwerten: null, null benutzt werden
 * 									-> anweisung  benutzen:		zum gleichzeitigen aufruf des schrift-dialogs & speichern der zurückgegebenen schrift: 
 * 												Font font = JMyFontChooser.showDialog(this, f);
 * 							- zusätzliches jLabel um darin eine schriftprobe der aktuellen schrift anzuzeigen
 * 
 * 
 * 		[	Textzeichner 1:	- standardpanel, in das text an einer beliebigen position durch mausklick eingesetzt werden kann
 * 							- radio-buttons für farbe des textes (rot + schwarz)
 * 							- textfeld zur texteingabe
 * 							- das panel muss nicht bei frameveränderungen den text auto-repainten können (=> keine abgeleitete panel-komponente nötig, im stil JMyTextPanel = new JPanel() )
 * 							- zeichnen des textes mit der methode:		 drawString(Strings, float x, float y) 		der klasse Graphics2d				]
 *
 */					

package uebungen13Aufgaben;

import java.awt.Color;
import java.awt.Font;
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
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import uebungen13.JMyFontChooser;			// import von eigener SchriftauswahlDialog-klasse unter angabe des ursprungs-packages


public class FontChooserAufruf_Fuer_JPanel_KomponenteFuerTextPerMausklick_RadioGroup_Graphics2d_TextZeichner2 extends javax.swing.JFrame {

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	private JPanel jPanelTextflaeche;
	private JLabel jLSchriftprobe;
	private JButton jBtnSchrift;
	private ButtonGroup BtnGrpFarbe;		// buttonGroup (nicht sichbar)
	private JRadioButton jRBRot;
	private JRadioButton jRBSchwarz;
	private JTextField jTFTexteingabe;
	private JLabel jLTexteingabe;
	private Graphics2D g2d;					// grafik2d-kontext-objekt
	private Font font;						// variable für die aktuelle schrift

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FontChooserAufruf_Fuer_JPanel_KomponenteFuerTextPerMausklick_RadioGroup_Graphics2d_TextZeichner2 inst = new FontChooserAufruf_Fuer_JPanel_KomponenteFuerTextPerMausklick_RadioGroup_Graphics2d_TextZeichner2();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public FontChooserAufruf_Fuer_JPanel_KomponenteFuerTextPerMausklick_RadioGroup_Graphics2d_TextZeichner2() {
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
				jTFTexteingabe.setText("Bitte Text eingeben");
				jTFTexteingabe.selectAll();									// text auswählen
				jTFTexteingabe.requestFocus();								// focus setzen
				jTFTexteingabe.setBounds(384, 37, 183, 20);
			}
			{
				jLSchriftprobe = new JLabel();								// jLabel um darin eine schriftprobe der aktuellen schrift / schriftwahl anzuzeigen
				getContentPane().add(jLSchriftprobe);
				jLSchriftprobe.setText("Schriftprobe");				
				jLSchriftprobe.setBounds(384, 107, 183, 59);
				jLSchriftprobe.setHorizontalAlignment(SwingConstants.CENTER); // text "schriftprobe" mittig ins label setzen
			}
			{
				jRBSchwarz = new JRadioButton();
				getContentPane().add(jRBSchwarz);
				jRBSchwarz.setText("schwarz");
				jRBSchwarz.setSelected(true);
				jRBSchwarz.setBounds(400, 173, 103, 23);
				getBtnGrpFarbe().add(jRBSchwarz);							// methode um RadioButton schwarz zu ButtonGroup BtnGrpFarbe hinzuzufügen
			}
			{
				jRBRot = new JRadioButton();
				getContentPane().add(jRBRot);
				jRBRot.setText("rot");
				jRBRot.setBounds(400, 196, 98, 27);
				getBtnGrpFarbe().add(jRBRot);								// methode um RadioButton rot zu ButtonGroup BtnGrpFarbe hinzuzufügen
			}
			{
				jBtnSchrift = new JButton();								// button für aufruf des schriftauswahldialogs, der mit ok die schrift setzt 
				getContentPane().add(jBtnSchrift);
				jBtnSchrift.setText("SchriftAuswahlDialog anzeigen");
				jBtnSchrift.setBounds(384, 73, 183, 23);
				jBtnSchrift.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnSchriftActionPerformed(evt);
					}
				});
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
		g2d = (Graphics2D) jPanelTextflaeche.getGraphics();					// grafik2d-kontext-objekt erstellen + ihm die typ-gecastete grafik-umgebung für die komponente zuweisen  
		g2d.setColor(farbe);												// grafik2d-kontext-objekt  auf oben gewählte farbe setzen
		if (font != null) {													// falls angaben zur aktuellen schrift des frames vorhanden sind (!= null)...
			g2d.setFont(font);												// schrift für das grafik2d-kontext-objekt auf aktuelle schrift des frames setzen	
		}																	
		g2d.drawString(text, x, y);											// via grafik2d-kontext-objekt methodenaufruf zum zeichnen von text mit parameter (string, koordinaten x + y)
	}
	
	private void jBtnSchriftActionPerformed(ActionEvent evt) {				// handler method für aufruf des Schriftauswahldialogs JMyFontChooser
		g2d = (Graphics2D) jPanelTextflaeche.getGraphics();					// auch für diese methode ein grafik2d-kontext-objekt erstellen + ihm die typ-gecastete grafik-umgebung für die komponente zuweisen  
		if (font == null) {													// wenn keine angaben zur aktuellen schrift (null) vorhanden sind:...
			font = g2d.getFont();											// .. aktuelle schrift auf erfragen via grafik2d-kontext-objekt
		}
		Font chosenFont = JMyFontChooser.showDialog(this, font);			// gleichzeitiges schriftaiuswahldialog aufrufen & abspeichern der, im dialog ausgewählten schrift, als chosenFont
																			// ..methode showDialog(Component component, Font font) könnte auch mit parameterwerten: null, null benutzt werden
		if (chosenFont != null) {											// falls angaben zu chosenFont vorhanden (!= null) sind..
			font = chosenFont;												// .. der schrift des Frames die chosenFont zuweisen
		}
		g2d.setFont(font);													// schrift für das grafik2d-kontext-objekt auf aktuelle schrift des frames setzen 
		jLSchriftprobe.setFont(font);										// jLabelSchriftprobe auf aktuelle schrift des frames setzen   
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