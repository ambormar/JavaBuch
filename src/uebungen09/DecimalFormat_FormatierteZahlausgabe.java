/* TODO .9.3.l2    ab s.286
 * class DecimalFormat_FormatierteZahlausgabe
 * 
 * DEZIMALFORMAT:	= f�r zahlenausgabe mit formatierung
 * 							
 * 			-> objekt d.Kl. Decimalformat mit Formatangabe-string als argument ()
 * 		
 * BSP: 	DecimalFormat f = new DecimalFormat("#0.00");	// # = ziffer od. nix, 0= ziffer od. null => bsp hier: beliebig lange zahl mit 2 nachkommastellen)
 * 			jTFCelsius.setText(f.format(wert));				// methode format() liefert zahlwert (objekt f) im gew�nschten format als text zur�ck
 * 
 * FORMATIERUNGSSYMBOLE F�R DECIMALFORMAT:
 * 
 * 		ZEICHEN		BEDEUTUNG
 * 		
 * 		0			ziffer oder 0 (wird ausgegeben)
 * 		#			beliebig lange ziffer fall belegt, sonst leer
 * 		.			dezimal-trennzeichen (unabh�ngig von l�ndereinstellungen)
 * 		,			zur gruppierung von ziffern z.b. in 3er gruppen als tausendertrennzeichen
 * 		;			trennzeichen f�r unterschiedliche formatierung von pos. und neg. zahlen ->  li form. pos. zahlen ; re form. neg. zahlen
 * 		%			zahl wird mit 100 multipliziert & als prozentwert ausgegeben
 * 		%%			die Zahl wird als promille ausgegeben
 * 		\u00A4		f�r � zeichen 
 * 
 * 		genauer siehe s.286 uf
 */

package uebungen09;

public class DecimalFormat_FormatierteZahlausgabe {

}
