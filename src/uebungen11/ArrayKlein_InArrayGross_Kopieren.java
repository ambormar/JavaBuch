/* TODO 11.1.5,   s.332, Eigenes Bsp.
 * class ArrayKlein_InArrayGross_Kopieren
 * 
 * SIEHE AUCH:		11.1.5.	ArrayGross_InArrayKlein_Kopieren	s.332, Eigenes Bsp.
 *  
 * 
 * 11.1.5.	KLEINES ARRAY IN GROSSES ARRAY KOPIEREN (UNFLEXIBLE ARRAYGRÖSSE):		
 * 	
 * 		VORGEHEN:	- wenn ein array erweitert werden muss, weil weitere werte dazukommen:
 * 	
 *  				1. 	=>	zusätzliches array erzeugen mit der richtigen anzahl elemente
 *  
 *  						int[] arrayKlein = new int[]{2, 11, 6, 9, 7, 4};
							int[] arrayGross = new int[12];
 *  
 *  				2. 	=>	kleineres in grösseres array kopieren mittels for-schleife (auch versetzt reinkopieren ist möglich) 
 *  		
							for(int x = 0; x < arrayGross.length; x++){
								if (x < arrayKlein.length){
									arrayGross[x] = arrayKlein[x]; 			
									//	arrayGross[x + 3] = arrayKlein[x];			// = variante versetzt reinkopieren:	
								} 
							}		  
 *  
 *  				3.	=>	dem alten arraybezeichner ausserdem noch den neuen arraybezeichner zuweisen (=>	arrayKlein = arrayGross)
							-> somit verweist der ursprüngliche array-bezeichner nun AUCH auf das neu erzeugte array
								-> die BEIDEN bezeichner arrayGross & arrayKlein verweisen somit auf das neuere arrayGross & seine elemente
							
							arrayKlein = arrayGross			
							
 *  				4.	=>	garbage-collector aktivieren um speicherplatz von ursprünglichem kleinem array, der ohne bezeichner bleibt zu löschen
 * 
 * 							System.gc();
 * 
 * 			BSPE:	genau siehe code unten
 * 
 * 
 * K&K:	array mit weniger elementen in array mit mehr elementen kopieren
 * 		& den neuen arraynamen dem alten arraynamen zuweisen, damit man via alten namen auf den erweiterten array zugreifen kann
 */

package uebungen11;

public class ArrayKlein_InArrayGross_Kopieren {

	public static void main(String[] args) {
		int[] arrayKlein = new int[]{2, 11, 6, 9, 7, 4};
		int[] arrayGross = new int[12];
		
		for(int aKe: arrayKlein){			// ausgabe arrayKlein
			System.out.print(aKe + "\t");
		}
		System.out.println("");

		for(int aGe: arrayGross){			// ausgabe arrayGross
			System.out.print(aGe + "\t");
		}
		System.out.println("");
		
		// arrayKlein in arrayGross überschreiben mit for-schleif 			(mit foreach-schleife??? wie machen? keine ahnung!!!)
		for(int x = 0; x < arrayGross.length; x++){
			if (x < arrayKlein.length){
				//arrayGross[x] = arrayKlein[x];   			// normal: arrayKlein in arrayGross kopieren
				// version: versetzt überschreiben (siehe console)
				arrayGross[x + 3] = arrayKlein[x];			// ab 3.em element von arrayGross: arrayKlein reinkopieren
			}
			System.out.print(arrayGross[x] + "\t");
		}
		System.out.println(""); 
		
		// arrayKlein ausserdem noch den Bezeichner vom neuen grossen array (arrayGross) zuweisen,
		// somit verweist der ursprüngliche array-bezeichner nun auch auf das grosse array
		arrayKlein = arrayGross;
		System.out.print("ausgabe über den alten bezeichner arrayKlein: " + "\t");
		for(int aKe: arrayKlein){			// ausgabe vom "neuen" arrayKlein
			System.out.print(aKe + "\t");
		}
		System.out.println("");
		
		System.gc(); 	// garbage-collector aktivieren um speicherplatz von ursprünglichem kleinem array, der ohne bezeichner bleibt zu löschen
		
	}
}
