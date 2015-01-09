/* TODO 12.4.2.   s.382, 	
 * class ImageComponent (extends JComponent) & ImageIO_Klasse_Basics_Bildbetrachter
 * 
 * 	KLASSE ImageIO:		IMPORT:		 	javax.imageio.*;		= imageio, paket zum vereinheitlichten lesen + schreiben von Grafiken
 * 
 * 					 	METHODEN: 		ImageIO.read();			=> um Bilder (der formate .gif, .jpg, .tif) aus dateien, datenquellen oder URLs zu lesen,	
 * 																=> erzeugt Objekt 		der Klasse:		Image		 	
 * 																							oder:		BufferedImage (von Image abgeleitete klasse)
 * 																   (jede grafik wird als objekt der klasse Image oder BufferedImage erzeugt)
 *  
 * 										
 * 										ImageIO.getReaderFormatNames();		=> um weitere Bildformate (plattform-abhängig) abzufragen
 * 										ImageIO.getReaderMIMETypes();		=> um weitere Bildformate (plattform-abhängig) abzufragen		
 *
 * 
 * 	VORGEHEN:	1. 	class ImageComponent, von der abstrakten klasse JComponent abgeleitet, zur darstellung einer bilddatei
 * 
 * 				2. 	anwendung class ImageIO_Klasse_Basics_Bildbetrachter:
 * 
 * 						- Über einen Dateiauswahldialog kann eine Bilddatei (jpg, gif oder png) geladen werden. 
 *  					
 * 						- ImageComponent (das bild) wird in JScrollPane eingebettet damit bei bedarf skrollbalken eingeblendet werden.
 * 							-> JScrollPane kann Objekte aufnehmen, die von JComponent abgeleitet sind
 * 
 * 			 			- 
 * 
 * 
 * PROGRAMM:	 
 * 
 */

package uebungen12;

import java.awt.Dimension;				//
import java.awt.Graphics;				//
import java.awt.image.BufferedImage;	// 

import javax.swing.JComponent;			// 

public class ImageComponent extends JComponent {	// ImageComponent abgeleitet von der abstrakten klasse JComponent 
	
	private BufferedImage image;		// attribut vom typ BufferedImage
	
	public ImageComponent() {			// konstruktor.. 
		super();						// ... ruft nur den konstruktor der basisklasse auf
	}
	
	public void setImage(BufferedImage img) {									// setImage übernimmt als argument ein BufferedImage, damit lässt sich ein neues bild zuordnen
		this.image = img;														// übergebenes bild img wird dem attribut image dieser klasse zugeordnet
		setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));	// setter um die grösse des neuen bildes anzupassen, mit parameter objekt Dimension, mit parameter für breite + höhe hat 
		repaint();																// aufruf zum neuzeichnen der Komponente, damit das bild sichtbar wird
		invalidate();															// schliesslich ungültig erklären der komponente, damit beim nächsten neuzeichnen der ganze bereich neu gezeichnet wird 
	}
												// @Override = wie kommentar bei absichtlichem überschreiben von methoden der superklasse. kompiler nimmts zur kenntnis,...
	@Override																					// ...evtl. ab java 8 oder 9 unumgänglich, heute java7: ist's guter programmierstil
	protected void paintComponent(Graphics g){	// 
		if (image != null){
			g.drawImage(image, 0, 0, this);
		}
	}

}
