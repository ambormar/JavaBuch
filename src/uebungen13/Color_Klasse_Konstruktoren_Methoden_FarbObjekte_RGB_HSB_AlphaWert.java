/* TODO 13.3.1.   s.420, ???
 * class Color_Klasse_Konstruktoren_Methoden_FarbObjekte_RGB_HSB_AlphaWert
 * 
 * DIE KLASSE COLOR:	
 * 		
 * 			=> IMPORT:		java.awt.Color
 * 
 * 			=> RGB-model:	-> Klasse definiert farbe �ber rot, gr�, blau
 * 							-> r,g & b -anteile je von 0 -255
 * 
 * 			=> HSB-model:	-> klasse definiert farbe �ber hue (grundton), saturation (s�ttigung), brightness (helligkeit) 	
 * 							-> h,s, & b -anteile 0 - 255 oder 0 - 100%  ???????????????????????????????????????????????????????????????????????????????? (irgend noch abkl�ren)
 * 
 * 			=> hat Methoden um RGB in HSB (und umgekehrt) umzurechenen
 * 
 * 			=> ALPHAWERTE:	-> f�r Transparenz, von 0 - 255, 0 = gr�sste transparenz
 * 	
 * 
 *	13 FARB-OBJEKTE VON COLOR F�R DIE GRUNDFARBEN:		
 * 
 * 			public final static Color white		, lightgray, gray, darkgray, black, red, pink, orange, yellow, green, magenta, cyan, blue 
 * 
 * 	
 * 	KONSTRUKTOREN (WICHTIGE) VON COLOR: 
 * 
 * 			=> farbobjekt k�nnen �ber verschiedene konstruktoren erzeugt werden
 * 			=> alle diese konstruktoren erwarten RGB-werte
 * 			=> die RGB-werte kann man in unterschiedlichen formaten + teils mit zusatzangaben wie ALPHAWERTEN (transparenz) angeben
 * 
 * 			KONSTRUKTOR													BESCHREIBUNG
 * 			
 * 			public Color (int rgb)*										die RGB-werte liegen in einem Integer. blauwerte im niederwertigsten (= re geschrieben), 
 * 																		gr�nwerte im zweiten und rotwerte im dritten byte. (rgb je 0 - 255)
 * 																		das vierte byte (ganz li geschriebene) wird ignoriert (ist f�r alpha-werte, alpha = 255  => nicht transparent)
 * 
 * 																		*SIEHE:		13.3.1.  BinaerZahl_Umrechnen_inDezimal_BSPintRGB		eigene bemerkung (+ s.421)  
 * 
 *  		public Color (int rgba, boolean hasalpha)					wie oben; wenn hasalpha = true, wird das vierte byte als alphawert interpretiert 
 *  
 *  		public Color (int r, int g, int b)							rgb farb-anteil je in einem eigenen integer (alpha fix auf 255 = nicht-transparent)
 *  
 *  		public Color (int r, int g, int b, int alpha)				rgb je als integer. alpha zus�tzlich als vierter integer.
 *  
 *  		public Color (float r, float g, float b)					rgb je als dezimal-zahl von 0.0 - 1.0 (float). interne umrechnung in werte 0 - 255 (bin�r)
 *  
 *  		public Color (float r, float g, float b, float alpha)		rgb & alpha-wert je als dezimal-zahl von 0.0 - 1.0 (float). interne umrechnung in werte 0 - 255 (bin�r)
 *  
 *  
 *  METHODEN (WICHTIGE) VON COLOR:
 *  	
 *  		public static int HSBtoRGB (float h, float s, float b)		liefert int RGB-farb-wert zur�ck, der dem HSB-wert mit grundton h, s�ttigung s, helligkeit b entspricht
 *  
 *  		public static float[] RGBtoHSB (int r, int g, int b,		rechnet die RB-werte in die entsprechenden HSB-werte um.  
 *  										float[] hsbvals		)		liefert referenz auf ein float-array mit den ergebnis-werten zur�ck.
 *  
 *  		public Color brighter()										liefert ein etwas helleres farb-objekt zur�ck
 *  
 *  		public Color darker()										liefert ein etwas dunkleres farb-objekt zur�ck
 *  
 *  		public int getAlpha()										liefert den alpha-wert als integer zur�ck
 *  
 *  		public int getBlue()										liefert den blau-anteil als integer zur�ck
 *  
 *  		public int getGreen()										liefert den gr�n-anteil als integer zur�ck
 *  
 *  		public int getRed()											liefert den rot-anteil als integer zur�ck
 *  
 *  
 * 
 */

package uebungen13;

public class Color_Klasse_Konstruktoren_Methoden_FarbObjekte_RGB_HSB_AlphaWert {

}
