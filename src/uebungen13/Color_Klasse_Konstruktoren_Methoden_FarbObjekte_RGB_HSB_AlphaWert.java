/* TODO 13.3.1.   s.420, ???
 * class Color_Klasse_Konstruktoren_Methoden_FarbObjekte_RGB_HSB_AlphaWert
 * 
 * DIE KLASSE COLOR:	
 * 		
 * 			=> IMPORT:		java.awt.Color
 * 
 * 			=> RGB-model:	-> Klasse definiert farbe über rot, grü, blau
 * 							-> r,g & b -anteile je von 0 -255
 * 
 * 			=> HSB-model:	-> klasse definiert farbe über hue (grundton), saturation (sättigung), brightness (helligkeit) 	
 * 							-> h,s, & b -anteile 0 - 255 oder 0 - 100%  ???????????????????????????????????????????????????????????????????????????????? (irgend noch abklären)
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
 * 	KONSTRUKTOREN (WICHTIGE) VON COLOR: 
 * 
 * 			=> farbobjekt können über verschiedene konstruktoren erzeugt werden
 * 			=> alle diese konstruktoren erwarten RGB-werte
 * 			=> die RGB-werte kann man in unterschiedlichen formaten + teils mit zusatzangaben wie ALPHAWERTEN (transparenz) angeben
 * 
 * 			KONSTRUKTOR													BESCHREIBUNG
 * 			
 * 			public Color (int rgb)*										die RGB-werte liegen in einem Integer. blauwerte im niederwertigsten (= re geschrieben), 
 * 																		grünwerte im zweiten und rotwerte im dritten byte. (rgb je 0 - 255)
 * 																		das vierte byte (ganz li geschriebene) wird ignoriert (ist für alpha-werte, alpha = 255  => nicht transparent)
 * 
 * 																		*SIEHE:		13.3.1.  BinaerZahl_Umrechnen_inDezimal_BSPintRGB		eigene bemerkung (+ s.421)  
 * 
 *  		public Color (int rgba, boolean hasalpha)					wie oben; wenn hasalpha = true, wird das vierte byte als alphawert interpretiert 
 *  
 *  		public Color (int r, int g, int b)							rgb farb-anteil je in einem eigenen integer (alpha fix auf 255 = nicht-transparent)
 *  
 *  		public Color (int r, int g, int b, int alpha)				rgb je als integer. alpha zusätzlich als vierter integer.
 *  
 *  		public Color (float r, float g, float b)					rgb je als dezimal-zahl von 0.0 - 1.0 (float). interne umrechnung in werte 0 - 255 (binär)
 *  
 *  		public Color (float r, float g, float b, float alpha)		rgb & alpha-wert je als dezimal-zahl von 0.0 - 1.0 (float). interne umrechnung in werte 0 - 255 (binär)
 *  
 *  
 *  METHODEN (WICHTIGE) VON COLOR:
 *  	
 *  		public static int HSBtoRGB (float h, float s, float b)		liefert int RGB-farb-wert zurück, der dem HSB-wert mit grundton h, sättigung s, helligkeit b entspricht
 *  
 *  		public static float[] RGBtoHSB (int r, int g, int b,		rechnet die RB-werte in die entsprechenden HSB-werte um.  
 *  										float[] hsbvals		)		liefert referenz auf ein float-array mit den ergebnis-werten zurück.
 *  
 *  		public Color brighter()										liefert ein etwas helleres farb-objekt zurück
 *  
 *  		public Color darker()										liefert ein etwas dunkleres farb-objekt zurück
 *  
 *  		public int getAlpha()										liefert den alpha-wert als integer zurück
 *  
 *  		public int getBlue()										liefert den blau-anteil als integer zurück
 *  
 *  		public int getGreen()										liefert den grün-anteil als integer zurück
 *  
 *  		public int getRed()											liefert den rot-anteil als integer zurück
 *  
 *  
 * 
 */

package uebungen13;

public class Color_Klasse_Konstruktoren_Methoden_FarbObjekte_RGB_HSB_AlphaWert {

}
