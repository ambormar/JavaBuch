/* TODO .6.2.3.   s.186  
 * class Bruch5 & Methoden_UeberladenVonMethoden_Bruch5
 * 
 * METHODEN ÜBERLADEN =		- mehrere gleichnamige methoden in einer klasse
 * 							- nützlich wenn mehrere methoden für ähnliche funktion gebraucht werden
 * 
 * 							- unterscheidung beim aufruf durch parameterliste
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
 * 							- oder unterscheidung beim aufruf durch typ
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

public class Bruch5 {
	int zaehler;
	int nenner;
	// erste überladene methode
	void setze(int n){	// nur ein argument wird übergeben
		zaehler = 1; // z ohne argumentübergabe
		nenner = n;
	}
	// zweite überladene methode
	void setze(int z, int n){ // zwei argumente werden übergeben
		zaehler = z;
		nenner = n;
	}
	void ausgeben(String s){							
		System.out.println(s + zaehler+"/"+nenner);
	}
}
