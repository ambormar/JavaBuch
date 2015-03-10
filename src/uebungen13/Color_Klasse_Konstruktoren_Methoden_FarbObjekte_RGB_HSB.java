/* TODO 13.3.1.   s.420, ???
 * class Color_Klasse_Konstruktoren_Methoden_FarbObjekte_RGB_HSB
 * 
 * DIE KLASSE COLOR:	
 * 		
 * 			=> IMPORT:		java.awt.Color
 * 
 * 			=> RGB-model:	-> Klasse definiert farbe über rot, grü, blau
 * 							-> r,g & b -anteile je von 0 -255
 * 
 * 			=> HSB-model:	-> klasse definiert farbe über hue (grundton), saturation (sättigung), brightness (helligkeit) 	
 * 							-> h,s, & b -anteile 0 - 255 oder 0 - 100  ???????????????????????????????????????????????????????????????????????????????? (irgend noch abklären)
 * 
 * 			=> hat Methoden um RGB in HSB (und umgekehrt) umzurechenen
 * 
 * 			=> ALPHAWERTE:	-> für Transparenz, von 0 - 255, 0 = grösste transparenz
 * 	
 * 
 *	13 FARB-OBJEKTE VON COLOR FÜR DIE GRUNDFARBEN:		
 * 
 * 			public final static Color white		, lightgray, gray, darkgray, black, red, pink, orange, yellow, green, magenta, cyan, blue 
 * 
 * 	
 * 	WICHTIGSTE KONSTRUKTOREN VON COLOR: 
 * 
 * 			=> farbobjekt können über verschiedene konstruktoren erzeugt werden
 * 			=> alle konstruktoren erwarten RGB-werte
 * 			=> die RGB-werte kann man in unterschiedlichen formaten + teils mit zusatzangaben wie ALPHAWERTEN angeben
 * 
 * 			KONSTRUKTOR									BESCHREIBUNG
 * 			
 * 			public Color(int rgb)*						die RGB-werte liegen in einem Integer. blauwerte im niederwertigsten (= re geschrieben), 
 * 														grünwerte im zweiten und rotwerte im dritten byte. (rgb je 0 - 255)
 * 														das vierte byte (ganz li geschriebene) wird ignoriert (ist für alpha-werte, alpha = 255, nicht transparent)
 * 
 * 														*SIEHE:		13.3.1.  BinaerZahl_Umrechnen_inDezimal_BSPintRGB		eigene bemerkung (+ s.421)  
 *  
 * 
 */

package uebungen13;

public class Color_Klasse_Konstruktoren_Methoden_FarbObjekte_RGB_HSB {

}
