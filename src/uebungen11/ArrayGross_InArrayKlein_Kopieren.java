/* TODO 11.1.5.   s.332, Eigenes Bsp.
 * class ArrayGross_InArrayKlein_Kopieren
 * 
 * SIEHE AUCH:		11.1.5.	ArrayKlein_InArrayGross_Kopieren	s.332, Eigenes Bsp.

 * 
 * 11.1.5.	GROSSES ARRAY IN KLEINES ARRAY KOPIEREN (UNFLEXIBLE ARRAYGR�SSE):		
 * 	
 * 		VORGEHEN:	- wenn ein array verkleinert werden muss, weil elemente ohne werte (oder z.b. wert = 0) gel�scht werden sollen:
 * 	
 *  				1. 	=>	voraussetzung: array mit �berfl�ssigen elementen, (hier: alle mit wert 0)
 *  
							int[] arrayGross = new int[]{ 0, 0, 0, 2, 11, 6, 9, 7, 4, 0, 0, 0 };
 *  
 *  				2.  =>  gr�sse des zuk�nftigen kleineren arrays ermitteln
 *  						-> for-schleife durch aktuelles array und alle elemente z�hlen, deren werte nicht = 0 sind
 *  
 *  						int arrayKleinGr�sse = 0;						// noch nicht bekannte arraygr�sse von arrayKlein initialisieren
		
							for (int x =0; x < arrayGross.length; x++){		// for-schleife durch arrayGross um array-gr�sse von arrayKlein zu ermitteln		
								if(arrayGross[x] != 0){						// f�r jedes element von arrayGross, dass !=0 ist ...
									arrayKleinGr�sse++;						// ... arrayKlein bzw. arrayKleingroesse um eins erh�hen
								}											
							}
							
					3.	=> 	kleineres array erzeugen mit der jetzt bekannten gr�sse 
					
							int[] arrayKlein = new int[arrayKleinGr�sse];
 *  
 *  				4. 	=>	gr�sseres in kleineres array kopieren mittels for-schleife & unerw�nschte elemente nicht mitkopieren 
 *  		
							int y= 0;										// hilfs-variable um versatz der nicht zu kopierenden elemente zu korrigieren
							for(int x=0; x < arrayGross.length; x++){
								if (arrayGross[x] != 0){
									arrayKlein[x-y] = arrayGross[x];		// ...[x-y] ->	y = anzahl durchl�ufe ohne zu kopierenden wert -> von x abziehen    
									System.out.print(arrayKlein[x-y] + "\t");					
								} else { 
									y++;									// hilfsvariable erh�hen f�r jeden durchlauf von arrayGross mit elementwert 0
								}
							}		  
 *   *  
 *  				5.	=>	dem alten arraybezeichner ausserdem noch den neuen arraybezeichner zuweisen (=>	arrayGross = arrayKlein)
							-> somit verweist der urspr�ngliche array-bezeichner nun AUCH auf das neu erzeugte array
								-> die BEIDEN bezeichner arrayKlein & arrayGross verweisen somit auf das neuere arrayKlein & seine elemente
							
							arrayKlein = arrayGross			
							
 *  				6.	=>	garbage-collector aktivieren um speicherplatz von urspr�nglichem grossem array, der ohne bezeichner bleibt, zu l�schen
 * 
 * 							System.gc();
 * 
 * 			BSPE:	genau siehe code unten
 * 
 * 
 * K&K:	array mit mehr  elementen in array mit weniger elementen kopieren
 * 		& den neuen arraynamen dem alten arraynamen zuweisen, damit man via alten namen auf den verkleinerten array zugreifen kann
 */
package uebungen11;

public class ArrayGross_InArrayKlein_Kopieren {
	

	public static void main(String[] args) {
		
		// vorraussetzung grosses array mittels arrayliterale
		int[] arrayGross = new int[]{ 0, 0, 0, 2, 11, 6, 9, 7, 4, 0, 0, 0 };

		for(int aGe: arrayGross){			// ausgabe arrayGross
			System.out.print(aGe + "\t");
		}
		System.out.println("");
		
		int arrayKleinGr�sse = 0;						// noch nicht bekannte arraygr�sse von arrayKlein initialisieren
		
		for (int x =0; x < arrayGross.length; x++){		// for-schleife durch arrayGross um array-gr�sse von arrayKlein zu ermitteln		
			if(arrayGross[x] != 0){						// f�r jedes element von arrayGross, dass !=0 ist ...
				arrayKleinGr�sse++;						// ... arrayKlein bzw. arrayKleingroesse um eins erh�hen
			}											
		}
		int[] arrayKlein = new int[arrayKleinGr�sse];	// kleineres array erzeugen mit der jetzt bekannten gr�sse
		
		// arrayGross in arrayKlein kopieren mittels for-schleife, ausser allen elementen die =0 sind
		int y= 0;										// hilfs-variable um versatz der nicht zu kopierenden elemente zu korrigieren
		for(int x=0; x < arrayGross.length; x++){
			if (arrayGross[x] != 0){
				arrayKlein[x-y] = arrayGross[x];		// ...[x-y] ->	y = anzahl durchl�ufe ohne zu kopierenden wert -> von x abziehen    
				System.out.print(arrayKlein[x-y] + "\t");			// arrayKlein[x-y] gleichzeitig ausgeben
			} else { 
				y++;									// hilfsvariable erh�hen f�r jeden durchlauf von arrayGross mit elementwert 0
			}
		}
		System.out.println("");
		
		// dem alten arraybezeichner ausserdem noch den neuen arraybezeichner zuweisen (=>	arrayGross = arrayKlein)
		arrayGross = arrayKlein;
		System.out.print("ausgabe �ber den alten bezeichner arrayGross: " + "\t");
		for (int aGe: arrayGross){
			System.out.print(aGe + "\t");				// ausgabe des neuen arrayKlein �ber den alten bezeichner arrayGross
		}
		
		System.gc();	// garbage-collector aktivieren um speicherplatz von urspr�nglichem grossem array, der ohne bezeichner bleibt, zu l�schen
		
	}
}
