/* TODO 12.4.2.   s.382, ("Images IN")
 * class ImageIO_Klasse_Basics_JFilechooser_Bildbetrachter	&	ImageComponent (extends JComponent)  
 * 
 * 	KLASSE ImageIO:		IMPORT:		 	javax.imageio.*;		= imageio, paket zum vereinheitlichten lesen + schreiben von Grafiken
 * 
 * 					 	METHODEN: 		ImageIO.read();			=> um Bilder (der formate .gif, .jpg, .tif) aus dateien, datenquellen oder URLs zu lesen,	
 * 																=> erzeugt Objekt der Klasse:		BufferedImage 	(von Image abgeleitete klasse)		 	
 * 																								
 * 													merke: 		=> JEDE GRAFIK wird als objekt der klasse Image oder BufferedImage erzeugt, -> ImageIO.read() erzeugt BufferedImage-objekt 
 * 																 
 * 
 * 										ImageIO.getReaderFormatNames();		=> um weitere Bildformate (plattform-abh�ngig) abzufragen
 * 										ImageIO.getReaderMIMETypes();		=> um weitere Bildformate (plattform-abh�ngig) abzufragen		
 *
 * 
 * 	VORGEHEN:	1. 	class ImageComponent, von der abstrakten klasse JComponent abgeleitet, zur darstellung einer bilddatei
 * 						-> diese komponente ist als nachkomme von JComponent geeignet in einem JScrollPane-beh�lter untergebracht zu werden
 * 
 * 					CODE & IMPORTS & KOMMENTS:			siehe code class ImageComponent
 * 
 * 
 * 				2. 	programm (anwendung) class ImageIO_Klasse_Basics_JFilechooser_Bildbetrachter:
 * 
 * 						a. JFRAME mit ANCHORLAYOUT machen (inkl. frame-titel):
 * 							 Jigloo-ansicht > Menue-leiste > Layout > AnchorLayout anklicken > im angew�hlten JFrame erneut klicken
 * 
 * 
 * 						b. JBUTTON "Bilddatei oeffnen" machen im ANCHORLAYOUT (+ button EventHandling, wie immer) :
 * 
 * 							- Jigloo-ansicht > JButton machen + anw�hlen > schwarzen pfeil klicken > auswahlfenster: f�r den jeweiligen rand (oben, re, unten, li) AnchorConstraints w�hlen
 * 							
 * 								=> 3 m�glichkeiten:		1. gerader anker:	= AnchorConstraint.ANCHOR_ABS (= absoluter abstand zum jeweiligen rand in px)
 * 														2. anker, schr�g:	= AnchorConstraint.ANCHOR_REL (= relativer abstand zum jeweiligen rand)
 * 														3. durchgestrichen:	= AnchorConstraint.ANCHOR_NONE (= li, obere ecke 0,0,	+	keine werte n�tig: *)
 * 								
 * 								[ hier: 	werte top & left: 20 px als ANCHOR_ABS defnieren	&	werte bottom & right als ANCHOR_NONE  -> px egal *]		// * werden mit PreferedSize eh �berschrieben
 * 								
 *							- PreferedSize setzen in den properties (od. code):			jBtnOeffnen.setPreferredSize(new java.awt.Dimension(107, 20) 
 *
 * 							- ANCHORLAYOUT SIEHE AUCH: 		9.3.(eigtl. 12.4.2.)   Jigloo_AnchorLayout_Basics_BspButton	s.385, 	
 * 
 * 							- CODE & KOMMENTS SIEHE:	initGUI()	JBtnOeffnen		&		event-methode jBtnOeffnen..(..)
 * 
 * 
 * 						c. KLASSE IMAGECOMPONENT (das bild), als objektinstanz erzeugt, wird IN JSCROLLPANE EINGEBETTET damit bei bedarf skrollbalken eingeblendet werden k�nnen.
 * 							-> JScrollPane kann Objekte aufnehmen, die von JComponent abgeleitet sind 
 * 								
 * 							- JScrollpane machen (wie bisher) & AnchorConstraints w�hlen (hier alle auf absolut, px: 60, 20, 20, 20)
 * 								-> damit die abst�nde zum frame rand unabh�ngig von der bildgr�sse immer gleich gross bleiben
 * 
 * 							- PreferedSize setzen in den properties (od. code):				jScrollPane1.setPreferredSize(new java.awt.Dimension(200, 200));
 * 								-> ausgangsgr�sse von Scrollpane, die nach dem laden des bildes auf die bildgr�sse korrigiert wird
 * 
 * 							- Autoscrolls auf true setzen in den Properties (od. code):		jScrollPane1.setAutoscrolls(true);
 * 
 * 							- startbild ("bewblau") in (hier: images von) projektordner  kopieren
 * 
 * 							- CODE:		im initGUI():
 * 
 *  						{
 *								jScrollPane1 = new JScrollPane();
 *								getContentPane().add(jScrollPane1, new AnchorConstraint(60, 20, 20, 20, AnchorConstraint.ANCHOR_ABS, AnchorConstraint.ANCHOR_ABS, AnchorConstraint.ANCHOR_ABS, AnchorConstraint.ANCHOR_ABS));
 *								jScrollPane1.setAutoscrolls(true);								// autoscrolls auf true, glaub damit sich die scrollbars vorzu anpassen (weissnit sicher)
 *								jScrollPane1.setPreferredSize(new java.awt.Dimension(200, 200));// bevorzugte ausgangsgr�sse des frames,  wird �berschrieben bei button-click in der methode jBtnOeffnen..(..) 
 *								{
 *									bild = new ImageComponent();								// objektinstanz bild der klasse ImageComponent wird erzeugt...
 *									a = ImageIO.read(new File("." + File.separator + "images" + File.separator + "bewblau.jpg"));// ins BufferedImage a, wird mit ImageIO.read(..), mit parameter.. 
 *																								// ..new file, das bild bewblau.jpg geladen mit dem pfad ab aktuellem  "." verzeichnis, also projektordner
 *									bild.setImage(a);											// a wird dem setter der objektinstanz bild mitgeben (damit das startbild gezeichnet wird)
 *									jScrollPane1.setViewportView(bild);							// ViewportView (= quasi monitor) von jScrollPane1 auf bild (= gr�sse von ImageComponent) setzen
 *									jScrollPane1.setSize(a.getWidth() + 2, a.getHeight() + 2);	// jScrollPane1 an die bildgr�sse anpassen, (+ 2 jeweils: glaub wegen jeder rand je ein px mehr)
 *								}
 *							}
 *							pack();
 *							setSize(240, 260);			// gr�sse beim ersten �ffnen des frames, wird �berschrieben bei button-click in der methode jBtnOeffnen..(..) 
 *							this.setSize(a.getWidth() + 59, a.getHeight() + 121);		// frame-gr�sse anpassen auf gr�sse des erst-angezeigten bildes WICHTIG, sonst zeigts bild zu klein..
 *																						// .. (zahlen �ndern/ausprobieren bis bild ganz dargestellt & scrollbars nur eingeblendet werden beim frame verziehen)
 * 
 * 
 * 						d. �ber Dateiauswahldialog (FILECHOOSER) IN DER EVENT-METHODE eine BILDDATEI (jpg, gif oder png) LADEN, via ImageComponent bild 
 *  						
 *  						- lokales erzeugen eines FileChoosers innerhalb der event-methode
 *  							
 *  						- bei schliessen des fc-dialogs durch cklicken des "file �ffnen"-buttons: 
 *  							-> laden der bilddatei (via ImageComponent bild) & anpassen der gr�ssen von frame, scrollbalken, etc. auf die jeweilige bildgr�sse
 *									
 *							- CODE:					
 *												
 *							private void jBtnOeffnenActionPerformed(ActionEvent evt) {			// event-methode zum laden einer beliebigen bilddatei �ber einen FileChooser 
 *								JFileChooser fc = new JFileChooser();							// lokales JFileChooser-objekt mit namen fc erzeugen 
 *								fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);	// FileselectionMode wird so gesetzt, dass Dateien + Ordner angezeigt werden
 *								fc.setFileFilter(new FileNameExtensionFilter("*.jpg", "*.tif", "*.png", "jpg", "tif", "png")); // FileFilter mit FilenameExtensionFilter und ..
 *																								// .. einer kommaseperierten liste filtert die m�glichen namenserweiterungen der anzuzeigenden dateien im dialogframe
 *								fc.setCurrentDirectory(new File("."));							// als ausgangsordner, f�r fc-dialog beim �ffnen, wird der aktuelle Pfad (currentDir..) als relative (".") Pfadangabe gesetzt => Projektordner  
 *								int state = fc.showOpenDialog(null);							// fc-Dialog �ffnen & gleichzeitig status speichern, wie der fc-Dialog geschlossen wurde
 *								if (state == JFileChooser.APPROVE_OPTION){						// wenn der fc-dialog mit dem status "(File) �ffnen" (=> .APPROVE_OPTION) geschlossen wird ...
 *									String selFile = fc.getSelectedFile().getAbsolutePath();	// .. wird der gew�hlte dateiname mit absoluter pfadangabe in die variable selFile �bernommen
 *									try {														
 *										BufferedImage a = ImageIO.read(new File(selFile));		// ImageIO.read(..) liest neuerzeugtes File mit pfad von selFile in das BuferedImage a 
 *										bild.setImage(a);										// a wird dem setter der oben bereits erzeugten objektinstanz bild mitgeben (damit das startbild gezeichnet wird)
 *										jScrollPane1.setSize(a.getWidth() + 2, a.getHeight() + 2);	// gr�ssenanpassung f�r den jScrollPane mit breite + h�he von Bufferedimage a, jeweils + 2 (glaub damit scroll nicht eingeblendet werden)
 *										jScrollPane1.setViewportView(bild);						// ViewportView (= quasi monitor) von jScrollPane1 auf bild (= gr�sse von ImageComponent) setzen
 *										this.setSize(a.getWidth() + 59, a.getHeight() + 121);	// den frame selber (this) auf die gr�sse von BufferedImage a anpassen ...
 *																								// ...das bild sollte so eigentlich vollst�ndig im frame dargestellt & scrollbalken nur eingeblendet werden, ..
 *																								// ...wenn man das frame �ndert..!! (zahlen �ndern bis bild ganz dargestellt, scrollbars nur eingeblendet werden beim frame verziehen)
 *									} catch (Exception e){
 *									JOptionPane.showMessageDialog(null, "Fehler beim �ffnen der Datei");
 *									}
 *								}	
 *							} 
 * 
 * 
 * BESONDERES:	- @Override (�ber methode)		=> ist wie ein kommentar bei absichtlichem �berschreiben von methoden der superklasse. 
 *												-> heute java7: ist's guter programmierstil, kompiler nimmts zur kenntnis, evtl. ab java 8 oder 9 unumg�nglich..
 * 
 * 
 *   			- setPreferredSize(new java.awt.Dimension(width, height)): 
 *
 *					=> um komponenten, cotainern, frames auf eine gr�sse zu setzen, die gerade ausreicht, die jeweiligen inhalts-elemente komplett darzustellen
 *					=> oder auch um elemente im initGUI() auf eine anfangsgr�sse zu setzen, wenn sich die gr�sse sp�ter �ndert, weil beinhaltete komponenten unterschiedlich gross sind		
 *				
 *					-> im zusammenhang mit AnchorLayout relevant, weil da evtl. die gr�ssen von Frames & komponenten im programmverlauf oder anwendung eher ge�ndert werden
 *
 *					- setzen in den properties (od. code):			jBtnOeffnen.setPreferredSize(new java.awt.Dimension(107, 20) 
 * 
 * 
 * 
 * K&K:		Klasse ImageComponent:							Von JComponent abgeleitete Klasse zur Darstellung einer Bilddatei.
 * 
 * 			Programm ImageIO_Klasse_Basics_Bildbetrachter:	�ber einen Dateiauswahldialog kann eine Bilddatei (jpg, gif oder png) geladen werden. 
 * 															Das Bild wird in einem Scrollpane dargestellt.
 */

package uebungen12;

import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.*;
import java.io.File;

import javax.imageio.*;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.*;

public class ImageIO_Klasse_Basics_JFilechooser_Bildbetrachter extends javax.swing.JFrame {
	private JButton jBtnOeffnen;
	private JScrollPane jScrollPane1;
	private ImageComponent bild;		// ImageComponent braucht kein import ist ja im selben pasket
	private BufferedImage a;			// bezeichner a f�r objekt der Klasse BufferedImage

	{
		// Set Look & Feel
		try {
			javax.swing.UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ImageIO_Klasse_Basics_JFilechooser_Bildbetrachter inst = new ImageIO_Klasse_Basics_JFilechooser_Bildbetrachter();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public ImageIO_Klasse_Basics_JFilechooser_Bildbetrachter() {
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
				jBtnOeffnen.setText("Bilddatei �ffnen");
				jBtnOeffnen.setPreferredSize(new java.awt.Dimension(107, 20));
				jBtnOeffnen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnOeffnenActionPerformed(evt);
					}
				});
			}
			{
				jScrollPane1 = new JScrollPane();
				getContentPane().add(jScrollPane1, new AnchorConstraint(60, 20, 20, 20, AnchorConstraint.ANCHOR_ABS, AnchorConstraint.ANCHOR_ABS, AnchorConstraint.ANCHOR_ABS, AnchorConstraint.ANCHOR_ABS));
				jScrollPane1.setAutoscrolls(true);								// autoscrolls auf true, glaub damit sich die scrollbars vorzu anpassen (weissnit sicher)
				jScrollPane1.setPreferredSize(new java.awt.Dimension(200, 200));// bevorzugte ausgangsgr�sse des frames,  wird �berschrieben bei button-click in der methode jBtnOeffnen..(..) 
				{
					bild = new ImageComponent();								// objektinstanz bild der klasse ImageComponent wird erzeugt...
					a = ImageIO.read(new File("." + File.separator + "images" + File.separator + "bewblau.jpg"));// ins BufferedImage a, wird mit ImageIO.read(..), mit parameter.. 
																				// ..new file, das bild bewblau.jpg geladen mit dem pfad ab aktuellem  "." verzeichnis, also projektordner
					bild.setImage(a);											// a wird dem setter der objektinstanz bild mitgeben (damit das startbild gezeichnet wird)
					jScrollPane1.setViewportView(bild);							// ViewportView (= quasi monitor) von jScrollPane1 auf bild (= gr�sse von ImageComponent) setzen
					jScrollPane1.setSize(a.getWidth() + 2, a.getHeight() + 2);	// jScrollPane1 an die bildgr�sse anpassen, (+ 2 jeweils: glaub wegen jeder rand je ein px mehr)
				}
			}
			pack();
			setSize(240, 260);			// gr�sse beim ersten �ffnen des frames, wird �berschrieben bei button-click in der methode jBtnOeffnen..(..) 
			this.setSize(a.getWidth() + 59, a.getHeight() + 121);		// frame-gr�sse anpassen auf gr�sse des erst-angezeigten bildes WICHTIG, sonst zeigts bild zu klein..
		} catch (Exception e) {											// .. (zahlen �ndern/ausprobieren bis bild ganz dargestellt & scrollbars nur eingeblendet werden beim frame verziehen)
			// add your error handling code here
			e.printStackTrace();
		}
	}
	// event-methode zum laden einer beliebigen bilddatei �ber einen FileChooser 
	private void jBtnOeffnenActionPerformed(ActionEvent evt) {			
		JFileChooser fc = new JFileChooser();							// lokales JFileChooser-objekt mit namen fc erzeugen 
		fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);	// FileselectionMode wird so gesetzt, dass Dateien + Ordner angezeigt werden
		fc.setFileFilter(new FileNameExtensionFilter("*.jpg", "*.tif", "*.png", "jpg", "tif", "png")); // FileFilter mit FilenameExtensionFilter und ..
									// .. einer kommaseperierten liste filtert die m�glichen namenserweiterungen der anzuzeigenden dateien im dialogframe
		fc.setCurrentDirectory(new File("."));	// als ausgangsordner, f�r fc-dialog beim �ffnen, wird der aktuelle Pfad (currentDir..) als relative (".") Pfadangabe gesetzt => Projektordner  
		int state = fc.showOpenDialog(null);							// fc-Dialog �ffnen & gleichzeitig status speichern, wie der fc-Dialog geschlossen wurde
		if (state == JFileChooser.APPROVE_OPTION){						// wenn der fc-dialog mit dem status "(File) �ffnen" (=> .APPROVE_OPTION) geschlossen wird ...
			String selFile = fc.getSelectedFile().getAbsolutePath();	// .. wird der gew�hlte dateiname mit absoluter pfadangabe in die variable selFile �bernommen
			try {														
				BufferedImage a = ImageIO.read(new File(selFile));		// ImageIO.read(..) liest neuerzeugtes File mit pfad von selFile in das BuferedImage a 
				bild.setImage(a);										// a wird dem setter der oben bereits erzeugten objektinstanz bild mitgeben (damit das startbild gezeichnet wird)
				jScrollPane1.setSize(a.getWidth() + 2, a.getHeight() + 2);	// gr�ssenanpassung f�r den jScrollPane mit breite + h�he von Bufferedimage a, jeweils + 2 (glaub damit scroll nicht eingeblendet werden)
				jScrollPane1.setViewportView(bild);						// ViewportView (= quasi monitor) von jScrollPane1 auf bild (= gr�sse von ImageComponent) setzen
				this.setSize(a.getWidth() + 59, a.getHeight() + 121);	// den frame selber (this) auf die gr�sse von BufferedImage a anpassen ...
																		// ...das bild sollte so eigentlich vollst�ndig im frame dargestellt & scrollbalken nur eingeblendet werden, ..
																		// ...wenn man das frame �ndert..!! (zahlen �ndern bis bild ganz dargestellt, scrollbars nur eingeblendet werden beim frame verziehen)
			} catch (Exception e){
				JOptionPane.showMessageDialog(null, "Fehler beim �ffnen der Datei");
			}
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