/* TODO 11.1.1.   s.326
 * class ArrayLiterale
 * 
 * ARRAY-LITERALE:		= werte des arrays werden bei der deklaration/initialisierung in geschweifter klammer als kommaseparierte liste mitgegeben
 * 
 * 							=> grössenangabe des arrays in eckigen klammern ist nicht nötig, anzahl werte entsprechend der klammer
 * 							=> auch beliebigee ausdrücke sind möglich, sofern sie einen array-typ gerechten wert ergeben (math.pi)
 * 
 *  					(= arrays initialisieren wie variablen primitiver datentypen)
 *  
 *  		BSP:		double[] bsp = new double[] { 1.0, 2.5, Math.PI, 5.8 };
 */

package uebungen11;

public class ArrayLiterale {
	
	public static void main(String[] args) {
		// array-literale: variabelwerte mitgeben bei deklaration, 
		// 				   grössenangabe entsprechend anzahl werte, auch ausdrücke (bsp. Pi) möglich die die einen (hier: double-)wert ergeben 
		double[] bsp = new double[] { 1.0, 2.5, Math.PI, 5.8};
		
		for (double ae: bsp) {				// konsolen-ausgabe mittels foreach-schleife
			System.out.print(ae + "  ");
		}
	}
}
