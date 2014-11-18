package uebungen02;

/* TODO .2.3.6,   s.78, auch s.77
 * class Char_Hexadezimal_Dezimal_Zahlencode_Unicode_Variablen2
 * 
 * unicode-tabelle siehe auch lesezeichen oder http://www.utf8-zeichentabelle.de/
 * 
 * char (zeichen) wertzuweisungen auf 4 verschiedene arten am beispiel Ä
 * 		
 *		1. ab taste: 					zeichen ab taste innerhalb '', 					also hier: 'Ä'
 *		2. unicode schreibweise: 		U + unicode/codeposition innerhalb ''			also hier: '\u00c4' 	codeposition siehe unicode-tabelle lesezeichen
 * 		3. hexadezimale schreibweise:	0x + unicode/codeposition innerhalb 			also hier: 0x00c4		codeposition siehe unicode-tabelle lesezeichen
 * 		4. zahlencode/dezimale schr.: 	von hex-zahl ins dezimalsystem umrechnen..   	also hier: 196
 * 		  								..wie folgt:
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

public class Char_Hexadezimal_Dezimal_Zahlencode_Unicode_Variablen2 {
	public static void main(String[] args) {

		// Variablendeklarationen
		char x1, x2, x3, x4;
		char z1, z2, z3, z4, z5;
		

		// Ä AB TASTE, UNICODE-, HEXADEZIMAL- UND ZAHLENCODE-SCHREIBWEISE
		x1 = 'Ä';		// zeichen ab taste-schreibweise innerhalb ''
		x2 = '\u00c4';	// unicode schreibweise (als char aber mit der unicode/codeposition) 
		x3 = 0x00c4;	// hexadezimalschreibweise (reelle hexadezimalzahl)
		x4 = 196;		// zahlencode (= hex-zahl ins dezimalsystem umgerechnet siehe oben) (reelle dezimalzahl)  
		
		// Wertzuweisungen
		z1 = 'a';
		z2 = 'b';
		z3 = 'A';
		z4 = 169; // alternativ z4 = 0x00a9	 fürs copyright zeichen
		z5 = 190; // alternativ z5 = 0x00be	 fürs 3/4 zeichen
					
		// Ausgaben
		System.out.println("x1: " + x1);
		System.out.println("x2: " + x2);
		System.out.println("x3: " + x3);
		System.out.println("x4: " + x4);
		
		// ausgabe der restlichen beispiele
		System.out.println("z1: " + z1);
		System.out.println("z2: " + z2);
		System.out.println("z3: " + z3);
		System.out.println("z4: " + z4);
		System.out.println("z5: " + z5);
	}

}