/* TODO 11.1.2.   s.327
 * class ArrayZweidimensional_foreachSchleife
 * 
 * ZWEIDIMENSIONALES ARRAY:		= (mittels) array dessen elemente arrays sind
 * 									=> erste eckigen klammer = anzahl unter-arrays
 * 									=> zweite eckige klammer = anzahl elemente der unter-arrays
 * 
 * 						BSP:	double [][] wuerfel = new double [3][6]								// zweidimensionaler array für 3 würfel a 6 zahlen
 * 
 * 														
 * 		ZUGRIFF AUF ELEMENTE:	GESCHACHTELTE FOREACH-SCHL.:		for (double[] wue: wuerfel){				// wue:			= für würfel nr 1-3
 * 																		for (double zahlen: wue){				// zahlen: 		= für gewürfelten zahlen
 * 																			System.out.println( zahlen );		
 * 																		}
 * 																	
  * 							VERGL. GESCH. FOR-SCHLEIFE:			for (int i = 0; i < wuerfel.length; i++){
 * 																		for (int j = 0; j < wuerfel[i].length; j++){ 
 * 																			System.out.println( wuerfel[i][j] );			
 * 																		}
 * 																	}
 * 
 * 	[	ELEMENTE IM ARBEITSSPEICHER:		BSP:	int [][] n = new int[2][3]	-> SPEICHER:	n[0][0]	n[0][1]	n[0][2]	n[1][0]	n[1][1]	n[1][2]		]
 * 
 * 											 
 * 
 * 
 * K&K:		version foreach-schleife im vergleich mit for-schleife
 *			[for-schleife wird ausserdem quadratisch ausgegeben: also 3 zeilen (= würfelebene/1.arrayebene), 6 zahlen je zeile (2.arrayebene)] ??? hä?
 */

package uebungen11;

public class ArrayZweidimensional_foreachSchleife {

	public static void main(String[] args) {
		// 2-dim array			
		int [][] wuerfel = new int [3][6]; 					// zweidimensionaler array für 3 würfel a 6 zahlen
		
		// array-zugriff mittels verschachtelter foreach-schleife vergleiche mit for-schleife unten 
		for (int[] wue: wuerfel){							// beachte: [] nach int, wue: für ersten array der würfel
			for (int zahlen: wue){							// (elemente vom 2.array) zahlen: (vom ersten array) wue 
				zahlen = (int) (Math.random()*6+1);			// (die elemente) zahlen = ....
				System.out.print( zahlen + "  ");			// ausgeben( (elemente)zahlen + ...)
			}
		}

		System.out.println('\n');
		
		// normale for-schleife nur zum vergleich (ausserdem ausgabe auf drei zeilen 6 zahlen entsprechend 3 wuerfel a 6 zahlen)
		for (int x = 0; x < wuerfel.length; x++){
			System.out.print("\n");							// zeilenumbruch pro würfel(arrayebene 1) a 6 zahlen (arrayebene 2)
			for (int y = 0; y < wuerfel[x].length; y++){	
				wuerfel[x][y] = (int) (Math.random()*6+1); 	
				System.out.print(wuerfel[x][y] + "  ");
			}
		}
	}
}
