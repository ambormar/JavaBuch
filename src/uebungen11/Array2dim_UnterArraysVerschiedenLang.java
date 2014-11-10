/* TODO 11.1.2.   s.328	
 * class Array2dim_UnterArraysVerschiedenLang 	(NB: ArrayDreieckig ist eine version von Array2dim_UnterArraysVerschiedenLang)
 * 
 * 2-DIMENSIONALES ARRAY, (UNTER-)ARRAYS VERSCHIEDEN LANG:
 * 
 *  	- array schrittweise aufbauen um (unter-)arrays mit unterschiedlich vielen elementen zu erzeugen:
 *  	- ginge galub für mehrdiemensionale arrays genauso: schrittweise aufbauen
 *  
 *  	SCHEMA:		int [][] array = new int [3][];		// array-deklaration mit initialisierung für 3 arrays im array
 *					array[0] = new int[7];				// für jede unterebene(2.array) unterschiedlich viele elemente initialisieren
 *					array[1] = new int[12];
 *					array[2] = new int[5];
 *
 *		BSP: 		siehe code unten
 *
 *		AUFRUF DER EINZELNEN ELEMENTE:		array [x][y] = ...		// in for-schleife werte zuordnen oder aufrufen natürlich
 *
 *											bzw. siehe auch code unten
 *  
 * k&k:		array wird bei der deklaration mit (hier) 3 unterebenen initialisiert
 * 			anschliessend werden für jede unterebene  n elemente initialisiert
 */

package uebungen11;

public class Array2dim_UnterArraysVerschiedenLang {

	public static void main(String args[]){
			// array-deklaration mit initialisierung für 3 arrays im array
			int [][] array = new int [3][];
			array[0] = new int[7];		// für jede unterebene(2.array) werden unterschiedlich viele elemente initialisiert
			array[1] = new int[12];
			array[2] = new int[5];

			for (int x = 0; x < array.length; x++){
				System.out.print('\n');
				for(int y = 0; y < array[x].length; y++){
					array[x][y] = (int) (Math.random()* 10);
					System.out.print(array[x][y] + "  ");
				}
			}
	}
}
