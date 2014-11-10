/* TODO .6.2.3.   s.186  
 * class Bruch5 & Methoden_UeberladenVonMethoden_Bruch5
 * 
 * METHODEN ÜBERLADEN =		- mehrere gleichnamige methoden in einer klasse
 * 							- nützlich wenn mehrere methoden für ähnliche funktion gebraucht werden
 * 							- NICHT ERLAUBT: überladen nur durch unterschiedliche ergebniss-typen(s.191):	NICHT:	void setze(){} &  int setze(){}
 * 									=> braucht dann unterscheidg in den parametern:  						SCHON:	void setze(){} &  int setze(PARAM.){}
 * 
 * 							- unterscheidung beim aufruf durch parameter-liste
 * 								
 * 									void setze(int n){					aufruf:	xy.setze(3);
										zaehler = 1; 				
										nenner = n;					
									}							
							
									void setze(int z, int n){			aufruf: xy.setze(3, 5);
										zaehler = z;
										nenner = n;
									}
 * 							
 * 							- oder unterscheidung beim aufruf durch parameter-typ
 * 												
 * 									void erweitern (int a){..}			aufruf: xy.erweitern( 5 );		
 *
 * 									void erweitern (double a){..}		aufruf: xy.erweitern( 5.0 );
 * 	
 * 									-> bei letzterem aufruf wäre wegen implizieter typumwandlung (5.0) & (5) zulässig
 * 									-> Aber: wegen Overload-Resolution würde das passendere gewählt (5.0)
 * 
 * 
 * 	OVERLOAD-RESOLUTION:	1. passt keine methode:					ist der aufruf fehlerhaft
 * 							2. passen mehrere methoden:				wird die gewählt, die am besten passt
 * 							3. passen mehrere methoden gleich gut	ist aufruf nicht eindeutig und wird nicht ausgeführt
 * 
 * 
 * Überladen von methoden
 * 2 gleichnamige methoden unterscheiden sich nur durch die Parameter (anzahl, typ)
 * bruch5 wird auf 2 verschiedene werte gesetzt/initialisiert
 * aufrufende klasse: UeberladenVonMethoden_Bruch5
 */

package uebungen06;

public class Methoden_UeberladenVonMethoden_Bruch5 {

	public static void main(String[] args) {
		Bruch5 b = new Bruch5();
		// aufruf der ersten überladenen methode
		b.setze(4);			
		b.ausgeben('\n'+"die erste überladene Methode setzt Bruch auf: ");
		// aufruf der zweiten überladenen methode
		b.setze(2, 3);		
		b.ausgeben('\n'+"die zweite überladene Methode setzt Bruch auf: ");
	}
}
