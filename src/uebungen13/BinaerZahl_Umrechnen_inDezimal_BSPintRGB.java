/* TODO 13.3.1.  eigene bemerkung (+ s.421)  
 * class BinaerZahl_Umrechnen_inDezimal_BSPintRGB
 * 
 * 			VERGLEICHE AUCH:		2.3.6.b,   Hexadezimal_Umrechnen_inDezimal								s.78, auch s.77
 * 
 * 
 * 	BIN�R-ZAHL IN DEZIMALZAHL UMRECHNEN:
 * 
 * 			[[[	U.A. ERKL�RUNG F�R:				3.3.1.   Color_Klasse_Konstruktoren_Methoden_FarbObjekte_RGB_HSB		s.420,   
 * 
 * 					abschnitt KONSTRUKTOREN:  		public color (int rgb)		die RGB-werte liegen in einem Integer. blauwerte im niederwertigsten (= re geschrieben), 
 * 																				gr�nwerte im zweiten und rotwerte im dritten byte. (rgb je 0 - 255)
 * 																				das vierte byte (ganz li geschriebene) wird ignoriert (ist f�r alpha-werte, alpha = 255, nicht transparent)
 * 
 * 					-> hier suchen wir die integer-zahl z.b. f�r (voll-) blau																											]]]																			
 * 
 * 						
 * 
 *  	am BSP public Color (int rgb):		=> BIN�R:			aneinanderreihung von NULLEN und EINSEN (bin�r von 'zwei-haft')
 *  										=> Integer:		 	hat vier bytes a 8 bit (jedes bit ist 0 oder 1)
 *  										=> bsp int rgb:		je ein byte pro farbe	-> blau: 	niedderwertigstes, re geschrieben
 *  																					-> gr�n:	zweit-niederstes, 2.re
 *  																					-> rot:		dritt-niederstes, 3.re			
 * 																						-> alpha:	h�chstwertiges, wird in diesem konstruktor ignoriert, ganz li geschrieben
 * 											=> Formel*:			-> von der niederwertigsten zahl-stelle (re geschrieben) bis zur h�chstwertigsten zahl-stelle (li):
 * 																	=> 			0 (=nein) oder 1 (=ja) mal 2 (f�r bin�r) hoch 0 (niederwertigste zahlstelle re)  
 * 																			+	0 (=nein) oder 1 (=ja) mal 2 (f�r bin�r) hoch 1 (niederwertigste zahlstelle re)  +  etc.
 * 
 * 																	=> 		1*2^0 + 71*2^1 + 1*2^2 + 1*2^3 + 1*2^4 + 1*2^5 + 1*2^6 + 1*2^7	etc.	=  
 * 
 * 		zuordng.konstr:			alpha (4.byte) 				rot (3.byte) => nein -> NULLEN		gr�n (2.byte) => nein -> NULLEN		  blau (1.byte) => ja also alles EINSEN	(vollblau)			
 * 						transparenz (wird ignoriert)
 * 		bin�r-zahl:		1	1	1	1	1	1	1	1	 	0	0	0	0	0	0	0	0	 	0	0	0	0	0	0	0	0	 	  1     1     1     1     1     1     1     1	
 * 		
 * 																															V  		  V     V     V     V     V     V     V     V
 * 
 * 		formel*:					etc.	<-	  1*2^25													etc.	<-	  0*2^8		1*2^7+1*2^6+1*2^5+1*2^4+1*2^3+1*2^2<+1*2^1+1*2^0	
 * 
 * 																															"		  "     "     "     "     "     "     "     "
 * 						-	-	-	-	-	-	-	-		0	0	0	0	0	0	0	0	 	0	0	0	0	0	0	0	0		 128 + 64  +  32 +  16 +  8  +  4  +  2  +  1	
 *   
 * 		int (a)rgb:		[x millionen (wird ignoriert)]	+					0				+					0				+					255							   = 255 (= blau)
 * 
 * 		
 */

package uebungen13;

public class BinaerZahl_Umrechnen_inDezimal_BSPintRGB {

}
