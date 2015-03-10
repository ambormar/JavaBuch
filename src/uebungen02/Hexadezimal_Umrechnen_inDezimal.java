package uebungen02;

/* TODO .2.3.6.b,   s.78, auch s.77
 * class Hexadezimal_Umrechnen_inDezimal
 * 
 * 		(UNICODEZEICHEN UMRECHNEN SIEHE: 	2.3.6.		Char_Hexadezimal_Zahlencode_Unicode_Variablen2 	   		s.78, auch s.77)
 * 														
 * 						VERGLEICHE AUCH: 	13.3.1.   	BinaerZahl_Umrechnen_inDezimal_BSPintRGB				s.421, 
 * 
 * 
 * 	HEXADEZIMALZAHL IN DEZIMALZAHL UMRECHNEN:
 * 
 *  am BSP 3F:							0 1 2 3 4 5 6 7 8 9 a(10) b(11) c(12) d(13) e(14) f(15)   		// => ist die hex-zählweise in dezimal 
 * 										
 * 										formel: 	letzte stelle von Hexzahl (003F)	-> F(15)* 16 hoch0 	=> 15 *  1	=  15 
 * 													+ vorletzte stelle					-> 3    * 16 hoch1 	=>  3 *	16	=  48
 * 													+ drittletzte stelle 				-> 0 	* 16 hoch2 	=>  0 *256	=   0
 * 													+ viertletzte stelle etc.			-> 0 	* 16 hoch3 	=>  0*4096	=   0							
 * 																														-----
 * 													hexzahl 00c4										=> dezimalzahl	=  63
 */

public class Hexadezimal_Umrechnen_inDezimal {

}
