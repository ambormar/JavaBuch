/* TODO 11.1.2.   s.326
 * class ArrayZweidimensional_forSchleife
 * 
 * ZWEIDIMENSIONALES ARRAY:		= (mittels) array dessen elemente arrays sind
 * 									=> erste eckigen klammer = anzahl unter-arrays
 * 									=> zweite eckige klammer = anzahl elemente der unter-arrays
 * 
 * 						BSP:	double [][] wuerfel = new double [3][6]								// zweidimensionaler array für 3 würfel a 6 zahlen
 * 
 * 		ZUGRIFF AUF ELEMENTE:	GESCHACHTELTE FOR-SCHLEIFE:			for (int i = 0; i < wuerfel.length; i++){
 * 																		for (int j = 0; j < wuerfel[i].length; j++){ 
 * 																			System.out.println( wuerfel[i][j] );			
 * 																		}
 * 																	}		
 * 														
 * 								VERGL. GESCHACHT. FOREACH-SCHL.:	for (double[] wue: wuerfel){				// wue:			= für würfel nr 1-3
 * 																		for (double zahlen: wue){				// zahlen 		= für gewürfelten zahlen
 * 																			System.out.println( zahlen );		
 * 																		}
 * 
 * 	[	ELEMENTE IM ARBEITSSPEICHER:		BSP:	int [][] n = new int[2][3]	-> SPEICHER:	n[0][0]	n[0][1]	n[0][2]	n[1][0]	n[1][1]	n[1][2]		]
 * 
 */

package uebungen11;

import java.util.Random;

public class ArrayZweidimensional_forSchleife {

	public static void main(String[] args) {
		// 2-dim array			
		int [][] wuerfel = new int [3][6]; 					// zweidimensionaler array für 3 würfel a 6 zahlen
		// zugriff auf alle elemente
		for (int x = 0; x < wuerfel.length; x++){			// array-zugriff mittels verschachtelter for-schleife
			for (int y = 0; y < wuerfel[x].length; y++){	// wuerfel[x].length => länge von jeweiligen unter-array wuerfel[0], wuerfel[1] oder wuerfel[2]
				wuerfel[x][y] = (int) (Math.random()*6+1); 	// (int) aufzwingen, (math.random => 0.0 -0.9) * (würfelzahlen) + 1 ( eins aufrunden, weil int rundet immer auf nächst kleiner ab)
				System.out.print( wuerfel[x][y] + "  ");
			}
		}
		System.out.println();								// console auf neue zeile
		
		// zugriff/ausgabe alternativ mit foreach-schleife
		for (int[] wue: wuerfel){							// wue:			= für würfel nr 1-3
			for (int zahlen: wue){							// zahlen: 		= für gewürfelten zahlen
				zahlen = (int) (Math.random()*6+1);
				System.out.print(zahlen + "  ");
			}
		}
		
	}

}
