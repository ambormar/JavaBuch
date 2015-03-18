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
 *			1. SCHRIFT-ART		-> sind system-abängig 														(auf jedem kompi stehen andere schriften zur verfügung)
 *								-> viele anwendungen bringen eigen schriften mit 							(,die bei der software-installation mit installiert werden)
 *								-> fehlende schrift-arten 	-> wreden mit einer vorhandenen standard-schrift des systems ersetzt
 *
 *								-> um in einer anwendung unterschiedliche schriftarten anzubieten:		Font-Dialog anbieten, der die auf dem system vorhandenen schriften ermitelt:
 *
 *									=> FontCooser / JMyFontChooser / Farbauswahldialog										(-> siehe: 	13.4.5.		JMyFontChooser 		s.435)
 *
 *									=> methode:	String [] getAvailableFontFamilyNames()	(Klasse GraphicsEnvironment)		-> liefert StringArray mit den vorhandenen schriften zurück
 *										
 *			2. SCHRIFT-STIL	(normal, fett, kursiv)		-> mittels Konstanten der Klasse Font:		Font.PLAIN, Font.ITALIC, Font.BOLD
 *
 *			3. SCHRIFT-GRAD (grösse)					-> als int-wert
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
 *			String [] getAvailableFontFamilyNames()		(Klasse GraphicsEnvironment)			liefert StringArray mit den auf dem system vorhandenen schriften zurück
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
 */

package uebungen13;

public class Font_Klasse_Basics_Methoden_Konstruktoren_Konstanten {

}
