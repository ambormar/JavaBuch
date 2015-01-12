/* TODO 12.4.2.   s.382, 	
 * class ImageIO_Klasse_Basics_Bildbetrachter & ImageComponent (extends JComponent)  
 * 
 * 	KLASSE ImageIO:		IMPORT:		 	javax.imageio.*;		= imageio, paket zum vereinheitlichten lesen + schreiben von Grafiken
 * 
 * 					 	METHODEN: 		ImageIO.read();			=> um Bilder (der formate .gif, .jpg, .tif) aus dateien, datenquellen oder URLs zu lesen,	
 * 																=> erzeugt Objekt der Klasse:		BufferedImage 	(von Image abgeleitete klasse)		 	
 * 																								
 * 													merke: 		=> JEDE GRAFIK wird als objekt der klasse Image oder BufferedImage erzeugt, -> ImageIO.read() erzeugt BufferedImage-objekt 
 * 																 
 * 
 * 										ImageIO.getReaderFormatNames();		=> um weitere Bildformate (plattform-abhängig) abzufragen
 * 										ImageIO.getReaderMIMETypes();		=> um weitere Bildformate (plattform-abhängig) abzufragen		
 *
 * 
 * 	VORGEHEN:	1. 	class ImageComponent, von der abstrakten klasse JComponent abgeleitet, zur darstellung einer bilddatei
 * 						-> diese komponente ist als nachkomme von JComponent geeignet in einem JScrollPane-behälter untergebracht zu werden
 * 
 * 					CODE & IMPORTS & KOMMENTS:			siehe code class ImageComponent
 * 
 * 
 * 				2. 	programm (anwendung) class ImageIO_Klasse_Basics_Bildbetrachter:
 * 
 * 						- JFrame mit Anchorlayout machen (inkl. frame-titel):
 * 							 Jigloo-ansicht > Menue-leiste > Layout > AnchorLayout anklicken > im angewählten JFrame erneut klicken
 * 
 * 						- JButton "Bilddatei oeffnen" (+ EventHandling, wie immer) machen im AnchorLayout
 * :
 * 							Jigloo-ansicht > JButton machen + anwählen > schwarzen pfeil klicken > auswahlfenster: für den jeweiligen rand (oben, re, unten, li) AnchorConstraints wählen
 * 							
 * 								=> 3 möglichkeiten:		1. gerader anker:	= AnchorConstraint.ANCHOR_ABS (= absoluter abstand zum jeweiligen rand in px)
 * 														2. anker, schräg:	= AnchorConstraint.ANCHOR_REL (= relativer abstand zum jeweiligen rand)
 * 														3. durchgestrichen:	= AnchorConstraint.ANCHOR_NONE (= li, obere ecke 0,0,	+	keine werte nötig: *)
 * 								
 * 								[ hier: 	werte top & left: 20 px als ANCHOR_ABS defnieren	&	werte bottom & right als ANCHOR_NONE  -> egal *]
 * 								
 * 								*:	.. weil sie mit .setPreferredSize(new java.awt.Dimension(107, 20) eh überschrieben werden
 * 
 * 							SIEHE AUCH: 	.9.3.(eigtl. 12.4.2.)   Jigloo_AnchorLayout_Basics_BspButton	s.385, 	
 * 							¨
 * 
 * 				!!!!!!!!!!!!!!! heir weiter !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * 								
 * 
 * 						- Über einen Dateiauswahldialog (filechooser) kann eine Bilddatei (jpg, gif oder png) geladen werden. 
 *  					
 * 						- klasse ImageComponent (das bild), als objektinstanz erzeugt, wird in JScrollPane eingebettet damit bei bedarf skrollbalken eingeblendet werden können.
 * 							-> JScrollPane kann Objekte aufnehmen, die von JComponent abgeleitet sind
 * 
 * 					CODE & IMPORTS & KOMMENTS:			siehe code class ImageIO_Klasse_Basics_Bildbetrachter
 * 
 * 
 * 
 * BESONDERES:	@Override (über methode)		=> ist wie ein kommentar bei absichtlichem überschreiben von methoden der superklasse. 
 *												-> heute java7: ist's guter programmierstil, kompiler nimmts zur kenntnis, evtl. ab java 8 oder 9 unumgänglich..
 * 
 * 
 * 
 * PROGRAMM:	Klasse ImageComponent:							Von JComponent abgeleitete Klasse zur Darstellung einer Bilddatei.
 * 
 * 				Programm ImageIO_Klasse_Basics_Bildbetrachter:	Über einen Dateiauswahldialog kann eine Bilddatei (jpg, gif oder png) geladen werden. 
 * 																Das Bild wird in einem Scrollpane dargestellt.
 */

package uebungen12;

import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;
import javax.swing.JButton;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

public class ImageIO_Klasse_Basics_Bildbetrachter extends javax.swing.JFrame {
	private JButton jBtnOeffnen;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ImageIO_Klasse_Basics_Bildbetrachter inst = new ImageIO_Klasse_Basics_Bildbetrachter();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public ImageIO_Klasse_Basics_Bildbetrachter() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			AnchorLayout thisLayout = new AnchorLayout();
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Bildbetrachter");
			{
				jBtnOeffnen = new JButton();
				getContentPane().add(jBtnOeffnen, new AnchorConstraint(20, 300, 100, 20, AnchorConstraint.ANCHOR_ABS, AnchorConstraint.ANCHOR_NONE, AnchorConstraint.ANCHOR_NONE, AnchorConstraint.ANCHOR_ABS));
				jBtnOeffnen.setText("Bilddatei öffnen");
				jBtnOeffnen.setPreferredSize(new java.awt.Dimension(107, 20));
			}
			pack();
			setSize(400, 300);
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