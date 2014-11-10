/* TODO 11.1.2.   s.328	
 * class ArrayDreieckig (ist eigentlich nur eine version von Array2dim_UnterArraysVerschiedenLang)
 *
 * 2-DIMENSIONALES ARRAY, (UNTER-)ARRAYS VERSCHIEDEN LANG & DREIECKIG:
 * 
 *  	- array schrittweise aufbauen und (unter-)arrays mit unterschiedlich vielen elementen - elementanzahl von klein nach gross - erzeugen
 * 		- (ist eigentlich nur eine version von 2-dimensionalen arrays mit verschieden langen unterarrays) 
 *  	
 *  	(- müsste glaub für mehrdiemensionale dreieckige arrays genauso gehen: schrittweise aufbauen & elemenanzahl von klein nach gross)
 *  
 *  	SCHEMA:		int [][] dreieck = new int [3][];		// array-deklaration mit initialisierung für 3 arrays im array
 *					dreieck[0] = new int[1];				// für jede unterebene(2.array) unterschiedlich viele elemente initialisieren...
 *					dreieck[1] = new int[2];				// 													... elemenanzahl von klein nach gross
 *					dreieck[2] = new int[3];
 *
 *		BSP: 		siehe code unten
 *
 *		AUFRUF DER EINZELNEN ELEMENTE:		dreieck [x][y] = ...		// in for-schleife werte zuordnen oder aufrufen natürlich
 *
 *											bzw. siehe auch code unten
 *  
 * K&K:		array wird bei der deklaration mit (hier) 3 unterebenen initialisiert
 * 			anschliessend werden für jede unterebene  n elemente initialisiert
 */

package uebungen11;

public class ArrayDreieckig {

	public static void main(String args[]){
			// array-deklaration mit initialisierung für 3 arrays im array
			int [][] dreieck = new int [3][];
			dreieck[0] = new int[1];
			dreieck[1] = new int[2];
			dreieck[2] = new int[3];

			for (int x = 0; x < dreieck.length; x++){
				System.out.print('\n');							// zeilenumbruch nach jeder zeile (1.arrayebene)
				for(int y = 0; y < dreieck[x].length; y++){
					dreieck[x][y] = (int) (Math.random()* 10); // = je element eine zufallszahl von 0-9
					System.out.print(dreieck[x][y] + "  ");
				}
			}
	}
}
