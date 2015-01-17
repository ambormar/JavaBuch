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
 * 				2. 	programm (anwendung) class ImageIO_Klasse_Basics_JFilechooser_Bildbetrachter:
 * 
 * 						a. JFRAME mit ANCHORLAYOUT machen (inkl. frame-titel):
 * 							 Jigloo-ansicht > Menue-leiste > Layout > AnchorLayout anklicken > im angewählten JFrame erneut klicken
 * 
 * 
 * 						b. JBUTTON "Bilddatei oeffnen" machen im ANCHORLAYOUT (+ button EventHandling, wie immer) :
 * 
 * 							- Jigloo-ansicht > JButton machen + anwählen > schwarzen pfeil klicken > auswahlfenster: für den jeweiligen rand (oben, re, unten, li) AnchorConstraints wählen
 * 							
 * 								=> 3 möglichkeiten:		1. gerader anker:	= AnchorConstraint.ANCHOR_ABS (= absoluter abstand zum jeweiligen rand in px)
 * 														2. anker, schräg:	= AnchorConstraint.ANCHOR_REL (= relativer abstand zum jeweiligen rand)
 * 														3. durchgestrichen:	= AnchorConstraint.ANCHOR_NONE (= li, obere ecke 0,0,	+	keine werte nötig: *)
 * 								
 * 								[ hier: 	werte top & left: 20 px als ANCHOR_ABS defnieren	&	werte bottom & right als ANCHOR_NONE  -> px egal *]		// * werden mit PreferedSize eh überschrieben
 * 								
 *							- PreferedSize setzen in den properties (od. code):			jBtnOeffnen.setPreferredSize(new java.awt.Dimension(107, 20) 
 *
 * 							- ANCHORLAYOUT SIEHE AUCH: 		9.3.(eigtl. 12.4.2.)   Jigloo_AnchorLayout_Basics_BspButton	s.385, 	
 * 
 * 							- CODE & KOMMENTS SIEHE:	initGUI()	JBtnOeffnen		&		event-methode jBtnOeffnen..(..)
 * 
 * 
 * 						c. KLASSE IMAGECOMPONENT (das bild), als objektinstanz erzeugt, wird IN JSCROLLPANE EINGEBETTET damit bei bedarf skrollbalken eingeblendet werden können.
 * 							-> JScrollPane kann Objekte aufnehmen, die von JComponent abgeleitet sind 
 * 								
 * 							- JScrollpane machen (wie bisher) & AnchorConstraints wählen (hier alle auf absolut, px: 60, 20, 20, 20)
 * 								-> damit die abstände zum frame rand unabhängig von der bildgrösse immer gleich gross bleiben
 * 
 * 							- PreferedSize setzen in den properties (od. code):				jScrollPane1.setPreferredSize(new java.awt.Dimension(200, 200));
 * 								-> ausgangsgrösse von Scrollpane, die nach dem laden des bildes auf die bildgrösse korrigiert wird
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
 *								jScrollPane1.setPreferredSize(new java.awt.Dimension(200, 200));// bevorzugte ausgangsgrösse des frames,  wird überschrieben bei button-click in der methode jBtnOeffnen..(..) 
 *								{
 *									bild = new ImageComponent();								// objektinstanz bild der klasse ImageComponent wird erzeugt...
 *									a = ImageIO.read(new File("." + File.separator + "images" + File.separator + "bewblau.jpg"));// ins BufferedImage a, wird mit ImageIO.read(..), mit parameter.. 
 *																								// ..new file, das bild bewblau.jpg geladen mit dem pfad ab aktuellem  "." verzeichnis, also projektordner
 *									bild.setImage(a);											// a wird dem setter der objektinstanz bild mitgeben (damit das startbild gezeichnet wird)
 *									jScrollPane1.setViewportView(bild);							// ViewportView (= quasi monitor) von jScrollPane1 auf bild (= grösse von ImageComponent) setzen
 *									jScrollPane1.setSize(a.getWidth() + 2, a.getHeight() + 2);	// jScrollPane1 an die bildgrösse anpassen, (+ 2 jeweils: glaub wegen jeder rand je ein px mehr)
 *								}
 *							}
 *							pack();
 *							setSize(240, 260);			// grösse beim ersten öffnen des frames, wird überschrieben bei button-click in der methode jBtnOeffnen..(..) 
 *							this.setSize(a.getWidth() + 59, a.getHeight() + 121);		// frame-grösse anpassen auf grösse des erst-angezeigten bildes WICHTIG, sonst zeigts bild zu klein..
 *																						// .. (zahlen ändern/ausprobieren bis bild ganz dargestellt & scrollbars nur eingeblendet werden beim frame verziehen)
 * 
 * 
 * 						d. Über Dateiauswahldialog (FILECHOOSER) IN DER EVENT-METHODE eine BILDDATEI (jpg, gif oder png) LADEN, via ImageComponent bild 
 *  						
 *  						- lokales erzeugen eines FileChoosers innerhalb der event-methode
 *  							
 *  						- bei schliessen des fc-dialogs durch cklicken des "file öffnen"-buttons: 
 *  							-> laden der bilddatei (via ImageComponent bild) & anpassen der grössen von frame, scrollbalken, etc. auf die jeweilige bildgrösse
 *									
 *							- CODE:					
 *												
 *							private void jBtnOeffnenActionPerformed(ActionEvent evt) {			// event-methode zum laden einer beliebigen bilddatei über einen FileChooser 
 *								JFileChooser fc = new JFileChooser();							// lokales JFileChooser-objekt mit namen fc erzeugen 
 *								fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);	// FileselectionMode wird so gesetzt, dass Dateien + Ordner angezeigt werden
 *								fc.setFileFilter(new FileNameExtensionFilter("*.jpg", "*.tif", "*.png", "jpg", "tif", "png")); // FileFilter mit FilenameExtensionFilter und ..
 *																								// .. einer kommaseperierten liste filtert die möglichen namenserweiterungen der anzuzeigenden dateien im dialogframe
 *								fc.setCurrentDirectory(new File("."));							// als ausgangsordner, für fc-dialog beim öffnen, wird der aktuelle Pfad (currentDir..) als relative (".") Pfadangabe gesetzt => Projektordner  
 *								int state = fc.showOpenDialog(null);							// fc-Dialog öffnen & gleichzeitig status speichern, wie der fc-Dialog geschlossen wurde
 *								if (state == JFileChooser.APPROVE_OPTION){						// wenn der fc-dialog mit dem status "(File) öffnen" (=> .APPROVE_OPTION) geschlossen wird ...
 *									String selFile = fc.getSelectedFile().getAbsolutePath();	// .. wird der gewählte dateiname mit absoluter pfadangabe in die variable selFile übernommen
 *									try {														
 *										BufferedImage a = ImageIO.read(new File(selFile));		// ImageIO.read(..) liest neuerzeugtes File mit pfad von selFile in das BuferedImage a 
 *										bild.setImage(a);										// a wird dem setter der oben bereits erzeugten objektinstanz bild mitgeben (damit das startbild gezeichnet wird)
 *										jScrollPane1.setSize(a.getWidth() + 2, a.getHeight() + 2);	// grössenanpassung für den jScrollPane mit breite + höhe von Bufferedimage a, jeweils + 2 (glaub damit scroll nicht eingeblendet werden)
 *										jScrollPane1.setViewportView(bild);						// ViewportView (= quasi monitor) von jScrollPane1 auf bild (= grösse von ImageComponent) setzen
 *										this.setSize(a.getWidth() + 59, a.getHeight() + 121);	// den frame selber (this) auf die grösse von BufferedImage a anpassen ...
 *																								// ...das bild sollte so eigentlich vollständig im frame dargestellt & scrollbalken nur eingeblendet werden, ..
 *																								// ...wenn man das frame ändert..!! (zahlen ändern bis bild ganz dargestellt, scrollbars nur eingeblendet werden beim frame verziehen)
 *									} catch (Exception e){
 *									JOptionPane.showMessageDialog(null, "Fehler beim öffnen der Datei");
 *									}
 *								}	
 *							} 
 * 
 * 
 * BESONDERES:	- @Override (über methode)		=> ist wie ein kommentar bei absichtlichem überschreiben von methoden der superklasse. 
 *												-> heute java7: ist's guter programmierstil, kompiler nimmts zur kenntnis, evtl. ab java 8 oder 9 unumgänglich..
 * 
 * 
 *   			- setPreferredSize(new java.awt.Dimension(width, height)): 
 *
 *					=> um komponenten, cotainern, frames auf eine grösse zu setzen, die gerade ausreicht, die jeweiligen inhalts-elemente komplett darzustellen
 *					=> oder auch um elemente im initGUI() auf eine anfangsgrösse zu setzen, wenn sich die grösse später ändert, weil beinhaltete komponenten unterschiedlich gross sind		
 *				
 *					-> im zusammenhang mit AnchorLayout relevant, weil da evtl. die grössen von Frames & komponenten im programmverlauf oder anwendung eher geändert werden
 *
 *					- setzen in den properties (od. code):			jBtnOeffnen.setPreferredSize(new java.awt.Dimension(107, 20) 
 * 
 * 
 * 
 * K&K:		Klasse ImageComponent:							Von JComponent abgeleitete Klasse zur Darstellung einer Bilddatei.
 * 
 * 			Programm ImageIO_Klasse_Basics_Bildbetrachter:	Über einen Dateiauswahldialog kann eine Bilddatei (jpg, gif oder png) geladen werden. 
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
	private BufferedImage a;			// bezeichner a für objekt der Klasse BufferedImage

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
				jBtnOeffnen.setText("Bilddatei öffnen");
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
				jScrollPane1.setPreferredSize(new java.awt.Dimension(200, 200));// bevorzugte ausgangsgrösse des frames,  wird überschrieben bei button-click in der methode jBtnOeffnen..(..) 
				{
					bild = new ImageComponent();								// objektinstanz bild der klasse ImageComponent wird erzeugt...
					a = ImageIO.read(new File("." + File.separator + "images" + File.separator + "bewblau.jpg"));// ins BufferedImage a, wird mit ImageIO.read(..), mit parameter.. 
																				// ..new file, das bild bewblau.jpg geladen mit dem pfad ab aktuellem  "." verzeichnis, also projektordner
					bild.setImage(a);											// a wird dem setter der objektinstanz bild mitgeben (damit das startbild gezeichnet wird)
					jScrollPane1.setViewportView(bild);							// ViewportView (= quasi monitor) von jScrollPane1 auf bild (= grösse von ImageComponent) setzen
					jScrollPane1.setSize(a.getWidth() + 2, a.getHeight() + 2);	// jScrollPane1 an die bildgrösse anpassen, (+ 2 jeweils: glaub wegen jeder rand je ein px mehr)
				}
			}
			pack();
			setSize(240, 260);			// grösse beim ersten öffnen des frames, wird überschrieben bei button-click in der methode jBtnOeffnen..(..) 
			this.setSize(a.getWidth() + 59, a.getHeight() + 121);		// frame-grösse anpassen auf grösse des erst-angezeigten bildes WICHTIG, sonst zeigts bild zu klein..
		} catch (Exception e) {											// .. (zahlen ändern/ausprobieren bis bild ganz dargestellt & scrollbars nur eingeblendet werden beim frame verziehen)
			// add your error handling code here
			e.printStackTrace();
		}
	}
	// event-methode zum laden einer beliebigen bilddatei über einen FileChooser 
	private void jBtnOeffnenActionPerformed(ActionEvent evt) {			
		JFileChooser fc = new JFileChooser();							// lokales JFileChooser-objekt mit namen fc erzeugen 
		fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);	// FileselectionMode wird so gesetzt, dass Dateien + Ordner angezeigt werden
		fc.setFileFilter(new FileNameExtensionFilter("*.jpg", "*.tif", "*.png", "jpg", "tif", "png")); // FileFilter mit FilenameExtensionFilter und ..
									// .. einer kommaseperierten liste filtert die möglichen namenserweiterungen der anzuzeigenden dateien im dialogframe
		fc.setCurrentDirectory(new File("."));	// als ausgangsordner, für fc-dialog beim öffnen, wird der aktuelle Pfad (currentDir..) als relative (".") Pfadangabe gesetzt => Projektordner  
		int state = fc.showOpenDialog(null);							// fc-Dialog öffnen & gleichzeitig status speichern, wie der fc-Dialog geschlossen wurde
		if (state == JFileChooser.APPROVE_OPTION){						// wenn der fc-dialog mit dem status "(File) öffnen" (=> .APPROVE_OPTION) geschlossen wird ...
			String selFile = fc.getSelectedFile().getAbsolutePath();	// .. wird der gewählte dateiname mit absoluter pfadangabe in die variable selFile übernommen
			try {														
				BufferedImage a = ImageIO.read(new File(selFile));		// ImageIO.read(..) liest neuerzeugtes File mit pfad von selFile in das BuferedImage a 
				bild.setImage(a);										// a wird dem setter der oben bereits erzeugten objektinstanz bild mitgeben (damit das startbild gezeichnet wird)
				jScrollPane1.setSize(a.getWidth() + 2, a.getHeight() + 2);	// grössenanpassung für den jScrollPane mit breite + höhe von Bufferedimage a, jeweils + 2 (glaub damit scroll nicht eingeblendet werden)
				jScrollPane1.setViewportView(bild);						// ViewportView (= quasi monitor) von jScrollPane1 auf bild (= grösse von ImageComponent) setzen
				this.setSize(a.getWidth() + 59, a.getHeight() + 121);	// den frame selber (this) auf die grösse von BufferedImage a anpassen ...
																		// ...das bild sollte so eigentlich vollständig im frame dargestellt & scrollbalken nur eingeblendet werden, ..
																		// ...wenn man das frame ändert..!! (zahlen ändern bis bild ganz dargestellt, scrollbars nur eingeblendet werden beim frame verziehen)
			} catch (Exception e){
				JOptionPane.showMessageDialog(null, "Fehler beim öffnen der Datei");
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