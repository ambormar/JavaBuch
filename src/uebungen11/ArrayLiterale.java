/* TODO 11.1.1.   s.326
 * class ArrayLiterale
 * 
 * ARRAY-LITERALE:		= werte des arrays werden bei der deklaration/initialisierung in geschweifter klammer als kommaseparierte liste mitgegeben
 * 
 * 							=> gr�ssenangabe des arrays in eckigen klammern ist nicht n�tig, anzahl werte entsprechend der klammer
 * 							=> auch beliebigee ausdr�cke sind m�glich, sofern sie einen array-typ gerechten wert ergeben (math.pi)
 * 
 *  					(= arrays initialisieren wie variablen primitiver datentypen)
 *  
 *  		BSP:		double[] bsp = new double[] { 1.0, 2.5, Math.PI, 5.8 };
 */

package uebungen11;

public class ArrayLiterale {
	
	public static void main(String[] args) {
		// array-literale: variabelwerte mitgeben bei deklaration, 
		// 				   gr�ssenangabe entsprechend anzahl werte, auch ausdr�cke (bsp. Pi) m�glich die die einen (hier: double-)wert ergeben 
		double[] bsp = new double[] { 1.0, 2.5, Math.PI, 5.8};
		
		for (double ae: bsp) {				// konsolen-ausgabe mittels foreach-schleife
			System.out.print(ae + "  ");
		}
	}
}
