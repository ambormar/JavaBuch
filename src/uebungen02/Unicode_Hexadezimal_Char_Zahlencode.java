package uebungen02;

/* TODO .2.3.6.a,   s.78, auch s.77
 * class Unicode_Hexadezimal_Char_Zahlencode
 * 
 * SIEHE AUCH:		 Char_Hexadezimal_Zahlencode_Unicode_Variablen2 	.2.3.6,   s.78, auch s.77
 * 
 * unicode-tabelle siehe auch lesezeichen oder http://www.utf8-zeichentabelle.de/
 * 
 * char (zeichen) wertzuweisungen auf 4 verschiedene arten am beispiel Ä
 * 		
 *		1. ab taste: 					zeichen ab taste innerhalb '', 					also hier: 'Ä'
 *		2. unicode schreibweise: 		\ + u + unicode/codeposition innerhalb ''		also hier: '\u00c4' 	codeposition siehe unicode-tabelle lesezeichen
 * 		3. hexadezimale schreibweise:	0x + unicode/codeposition 			 			also hier: 0x00c4		codeposition siehe unicode-tabelle lesezeichen
 * 		4. zahlencode schreibweise:		von hex-zahl ins dezimalsystem umrechnen..   	also hier: 196
 * 										..wie folgt:
 * 
 * 										0 1 2 3 4 5 6 7 8 9 a(10) b(11) c(12) d(13) e(14) f(15)   ist die hex-zählweise in dezimal 
 * 										
 * 										formel: 	letzte stelle vom unicode (Ä: 00c4)	-> 4 	* 16 hoch0 	=>  4 *  1	=   4
 * 													+ vorletzte stelle					-> c(12)* 16 hoch1 	=> 12 *	16	= 192
 * 													+ drittletzte stelle 				-> 0 	* 16 hoch2 	=>  0 *256	=   0
 * 													+ viertletzte stelle etc.			-> 0 	* 16 hoch3 	=>  0*4096	=   0							
 * 																														-----
 * 													hexzahl 00c4										=> dezimalzahl	= 196
 */
public class Unicode_Hexadezimal_Char_Zahlencode {

}
