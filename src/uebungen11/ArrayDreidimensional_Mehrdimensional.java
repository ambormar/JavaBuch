/* TODO 11.1.2.   s.327,
 * class ArrayDreidimensional_Mehrdimensional
 * 
 * DREIDIMENSIONALES ARRAY:		= so wie 2-dimensionale arrays, k�nnen arrays mit beliebig vielen dimensionen erzeugt werden
 * 								= bei selbigem verfahren entstehen arrays, die auf einer betrachteten ebene immer gleichviele elemente besitzen
 * 
 * 								= 2-dim arrays sind rechteckig, 3-dim arrays quaderf�rmig (im buch steht: usw. (was das auch immer heissen soll ????))		
 * 		
 * 
 * 				3-DIM BSP:		int [][][] tische = new int [2][3][6]; 					// 3-dimensionaler array f�r z.b. 2 Tische � 3 w�rfel � 6 zahlen
 *		
 *	ZUGRIFF AUF ELEMENTE:		3-fach-verschachtelte for-schleife f�r zugriff auf elemente:
 *	
 *								for (int x = 0; x < tische.length; x++){			
 *									for (int y = 0; y < tische[x].length; y++){			
 *										for (int z = 0; z < tische[x][y].length; z++){	
 *											System.out.print( tische[x][y][z] + "  ");
 *										}
 *									}
 *								}
 * 
 * [ MEHRDIMENSIONALE ARRAYS:		int [][][][] casinos = new int [2][2][3][6];	// 4-dim array f�r z.b. 2 casinos � 2 Tische � 3 w�rfel � 6 zahlen
 * 	 (beliebig erweiterbar)	
 * 									=> hab aber grad keine lust auf 4-fach-verschachtelte for-schleife !!!	]
 */

package uebungen11;

public class ArrayDreidimensional_Mehrdimensional {

	public static void main(String[] args) {
		// 3-dim array			
		int [][][] tische = new int [2][3][6]; 					// 3-dimensionaler array f�r 2 Tische � 3 w�rfel � 6 zahlen
		// zugriff auf alle elemente
		for (int x = 0; x < tische.length; x++){				// array-zugriff mittels 3 verschachtelter for-schleifen 
			System.out.println();											// zeilenumbruch nach tisch
			for (int y = 0; y < tische[x].length; y++){			// tische[x].length => l�nge von jeweiligen unter-arrays tische[0], tische[1] 
				System.out.print("\t");										// extra-abst�nde zw. w�rfeln
				for (int z = 0; z < tische[x][y].length; z++){	// tische[x][y].length => l�nge von jeweiligen unter-arrays tische[0][0], tische[0][1] usw.
					tische[x][y][z] = (int) (Math.random()*6+1); // (int) aufzwingen, (math.random => 0.0 -0.9) * (w�rfelzahlen) + 1 ( eins aufrunden, weil int rundet immer auf n�chst kleiner ab)
					System.out.print( tische[x][y][z] + "  ");
				}
			}
		}
	}
}