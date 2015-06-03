/* TODO 13.4.5.   s.434, 
 * class Font_Klasse_Basics_Methoden_Konstruktoren_Konstanten
 * 
 * 			SIEHE AUCH: 	13.4.5.		JMyFontChooser 		s.435,
 * 							
 * 							=> AUFRUF VON FONTCHOOSER SIEHE:		13.5.	FontChooser_JMyFontChooser_??_Textzeichner2		Aufgabe 4, s.436	
 * 
 * KLASSE FONT:
 * 
 * 		3 HAUPTMERKMALE ZUR BESCHREIBUNG VON SCHRIFT:
 * 
 *			1. SCHRIFT-ART		-> sind system-ab�ngig 														(auf jedem kompi stehen andere schriften zur verf�gung)
 *								-> viele anwendungen bringen eigen schriften mit 							(,die bei der software-installation mit installiert werden)
 *								-> fehlende schrift-arten 	-> wreden mit einer vorhandenen standard-schrift des systems ersetzt
 *
 *								-> um in einer anwendung unterschiedliche schriftarten anzubieten:		Font-Dialog anbieten, der die auf dem system vorhandenen schriften ermitelt:
 *
 *									=> FontCooser / JMyFontChooser / Farbauswahldialog										(-> siehe: 	13.4.5.		JMyFontChooser 		s.435)
 *
 *									=> methode:	String [] getAvailableFontFamilyNames()	(Klasse GraphicsEnvironment)		-> liefert StringArray mit den vorhandenen schriften zur�ck
 *										
 *			2. SCHRIFT-STIL	(normal, fett, kursiv)		-> mittels Konstanten der Klasse Font:		Font.PLAIN, Font.ITALIC, Font.BOLD
 *
 *			3. SCHRIFT-GRAD (gr�sse)					-> als int-wert
 * 			
 * 
 * 		KONSTRUKTOR:	Font(String name, int style, int size)				=> zur erstellung eines objekts der klasse Font
 * 
 * 
 * 		METHODEN:	(siehe auch 13.1.2.   Graphics_Methoden_ZumZeichnen	s.401)				BESCHREIBUNG:
 * 
 * 			void drawString(String str, int x, int y) 	(Klasse Graphics)						zeichnet text mit der aktuellen zeichenfarbe und schriftart an der pos x,y
 * 		
 * 			Font getFont()								(?Klasse Graphics?)						liefert die akt. schriftart
 *
 *			void setFont(Font font)						(?Klasse Graphics?)						setzt die akt. schrift-art
 *
 *			String [] getAvailableFontFamilyNames()		(Klasse GraphicsEnvironment)			liefert StringArray mit den auf dem system vorhandenen schriften zur�ck
 *
 *
 *		KONSTANTEN VON FONT:					BESCHREIBUNG:
 *
 *			Font.PLAIN							schrift-stil: normal
 *
 *			Font.ITALIC							schrift-stil: kursiv	
 *
 *			Font.BOLD							schrift-stil: fett		
 *
 *
 *	[[	NB:	BSP AUS VORHANDENER SCHRIFT, SCHRIFT IN DER GESAMTGR�SSE EINES PANELS ZU MACHEN
 *
 *			Font oldFont = g.getFont();																	// aktuelle schrift ermitteln und in oldFont speichern
 *			Font font = new Font(oldFont.getFontName(), Font.PLAIN, (int) this.getSize().getHeight() );	// neue schrift bestimmen mit parameter schrifttyp, schriftschnitt + schriftgr�sse (= max. h�he des panels) // setzt die Schriftgr��e auf die H�he des Panels
 *			g.setFont(font);																			// neue schrift setzen f�r g														
 * 
 * 
 * 				SIEHE: 		14.3.4.  JUhrzeitPanel		 Aufgabe 4,   s.460, 		]]
 * 	
 */

package uebungen13;

import java.awt.Font;

public class Font_Klasse_Basics_Methoden_Konstruktoren_Konstanten {

}
