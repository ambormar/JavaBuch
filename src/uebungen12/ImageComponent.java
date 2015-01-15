/* TODO 12.4.2.   s.382,
 * class ImageComponent (extends JComponent) & ImageIO_Klasse_Basics_Bildbetrachter
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
 * 					CODE & IMPORTS & KOMMENTS:			siehe code unten, class ImageComponent
 * 
 * 
 * 				2. 	programm (anwendung) class ImageIO_Klasse_Basics_Bildbetrachter:
 * 
 * 						- �ber einen Dateiauswahldialog (filechooser) kann eine Bilddatei (jpg, gif oder png) geladen werden. 
 *  					
 * 						- klasse ImageComponent (das bild), als objektinstanz erzeugt, wird in JScrollPane eingebettet damit bei bedarf skrollbalken eingeblendet werden k�nnen.
 * 							-> JScrollPane kann Objekte aufnehmen, die von JComponent abgeleitet sind
 * 
 * 					CODE & IMPORTS & KOMMENTS:			12.4.2.   ImageIO_Klasse_Basics_JFilechooser_Bildbetrachter		s.382, 	
 *  
 * 
 * BESONDERES:	-@Override (�ber methode)		=> ist wie ein kommentar bei absichtlichem �berschreiben von methoden der superklasse. 
 *												-> heute java7: ist's guter programmierstil, kompiler nimmts zur kenntnis, evtl. ab java 8 oder 9 unumg�nglich..
 * 
 * 				- setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
 * 
 * 												-> eine komponente auf eine bevorzugte gr�sse 
 * 										
 * 
 * PROGRAMM:	Klasse ImageComponent:							Von JComponent abgeleitete Klasse zur Darstellung einer Bilddatei.
 * 
 * 				Programm ImageIO_Klasse_Basics_Bildbetrachter:	�ber einen Dateiauswahldialog kann eine Bilddatei (jpg, gif oder png) geladen werden. 
 * 																Das Bild wird in einem Scrollpane dargestellt.
 */

package uebungen12;

import java.awt.Dimension;				// import klasse dimension f�r das objekt im image-setter, klasse dimension zur ermittlung der gr�sse der bilddateien 
import java.awt.Graphics;				// import von klasse Grapics, besitzt viele methoden zum zeichnen auf unterschiedlichsten ger�ten
import java.awt.image.BufferedImage;	// guck auch themenspez. import

import javax.swing.JComponent;			// remember: hatte ich vergessen oder nicht gewusst: die superklasse muss auch importiert werden

			// remember: hatte ich vergessen: die superklasse wird auch importiert

public class ImageComponent extends JComponent {	// ImageComponent abgeleitet von der abstracten klasse JComponent 
	
	private BufferedImage image;		// attribut vom typ BufferedImage (f�r die class ImageComponent)
	
	public ImageComponent() {			// konstruktor.. 
		super();						// ... ruft nur den konstruktor der basisklasse (JComponent) auf
	}
	
	// setter-methode um bild zu setzen
	public void setImage(BufferedImage img) {									// setImage �bernimmt als argument ein BufferedImage, damit l�sst sich ein neues bild zuordnen
		this.image = img;														// �bergebenes bild img wird dem attribut image dieser klasse zugeordnet
		setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));	// setter um die gr�sse des neuen bildes anzupassen, mit parameter objekt Dimension, mit parameter f�r breite + h�he  
																				// nb. da setPrefferedSize auf die bildgr�sse gesetzt wird, wird das bild die ganze komponente ausf�llen
		repaint();		// methode repaint() der klasse awt.Component:			=> aufruf zum neuzeichnen der Komponente, damit das bild sichtbar wird: sie ruft glaub automatisch die.. 
						// .. paint-methode dieser componente auf	-> hier also .paintComponent(...) glaub auch mit autom. �bergeben des graphics-objekts als patrameter des aufrufs
		invalidate();	// methode invlidate() der klasse awt.Container:		=> schliesslich ung�ltig erkl�ren der komponente, damit beim n�chsten neuzeichnen der ganze bereich neu gezeichnet wird 
	}
	
	
				// @Override = ist wie ein kommentar bei absichtlichem �berschreiben von methoden der superklasse. kompiler nimmts zur kenntnis, evtl. ab java 8 oder 9 unumg�nglich..
	@Override																															// ..heute java7: ist's guter programmierstil
				// �berschreiben von paintComponent(..) (urspr. methode der abstracten klasse JComponent -> jetzt methode der klasse ImageComponent ) 
	protected void paintComponent(Graphics g){	// die methode paintComponent(..) ist f�r das zeichnen der komponente (ImageComponent) zust�ndig. ihr wird ein objekt der klasse Graphics..
												// ..�bergeben. klasse Grapics besitzt viele methoden zum zeichnen auf unterschiedlichsten ger�ten
												// wird glaub von repaint() oben automatisch aufgerufen
		if (image != null){						// falls die komponente ein bild enth�lt..
			g.drawImage(image, 0, 0, this);		// .. wird mit der methode drawImage(..) (der klasse grapics) das bild (image)  links oben (x=0 , y=0) in die komponente (this),  gezeichnet
		}										
	}

}
