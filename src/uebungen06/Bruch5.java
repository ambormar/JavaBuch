/* TODO .6.2.3.   s.186  
 * class Bruch5 & Methoden_UeberladenVonMethoden_Bruch5
 * 
 * METHODEN �BERLADEN =		- mehrere gleichnamige methoden in einer klasse
 * 							- n�tzlich wenn mehrere methoden f�r �hnliche funktion gebraucht werden
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
 * 									-> bei letzterem aufruf w�re wegen implizieter typumwandlung (5.0) & (5) zul�ssig
 * 									-> Aber: wegen Overload-Resolution w�rde das passendere gew�hlt (5.0)
 * 
 * 
 * 	OVERLOAD-RESOLUTION:	1. passt keine methode:					ist der aufruf fehlerhaft
 * 							2. passen mehrere methoden:				wird die gew�hlt, die am besten passt
 * 							3. passen mehrere methoden gleich gut	ist aufruf nicht eindeutig und wird nicht ausgef�hrt
 * 
 * 
 * �berladen von methoden
 * 2 gleichnamige methoden unterscheiden sich nur durch die Parameter (anzahl, typ)
 * bruch5 wird auf 2 verschiedene werte gesetzt/initialisiert
 * aufrufende klasse: UeberladenVonMethoden_Bruch5
 */

package uebungen06;

public class Bruch5 {
	int zaehler;
	int nenner;
	// erste �berladene methode
	void setze(int n){	// nur ein argument wird �bergeben
		zaehler = 1; // z ohne argument�bergabe
		nenner = n;
	}
	// zweite �berladene methode
	void setze(int z, int n){ // zwei argumente werden �bergeben
		zaehler = z;
		nenner = n;
	}
	void ausgeben(String s){							
		System.out.println(s + zaehler+"/"+nenner);
	}
}
