/* TODO .6.1.2.   s.177 
 * class Bruch1 & Methoden_Aufruf_Instanzmethoden_Bruch1 
 * 
 * METHODE s.176:			void ausgeben(){				// methodenkopf schema:		rückgabetyp methodenname(parametertyp parameter1)
 * 								System.out.println("..")	// methodenrumpf: 			anweisungen;
 * 							} 
 * 
 * 							- methode kann nur von (bzw. innerhalb) einem programm (main) aufgerufen werden
 * 
 * INSTANZMETHODE s. 177:		= methode einer instanz der klasse	
 * (nicht verwechseln mit		-> aufruf einer instanzmethode richtet sich immer an ein bestimmtes objekt einer klasse:	
 * 	klassenmethode)				
 * 								Aufruf:		b.ausgeben()	// objektbezeichner.methodenname(evtl. parametertyp & parameter)	
 * 
 * 								aufruf immer in 3 schritten:
 * 								1. aufrufendes programm wird unterbrochen
 * 								2. methodenrumpf wird ausgeführt
 *  							3. aufrufendes programm wird mit anweisung nach aufruf fortgesetzt
 * 
 * aufruf von methoden / instanzmethode
 * Methoden_Aufruf_Instanzmethoden_Bruch1 erstellt instanz von Bruch01 und gibt sie aus
 */

package uebungen06;

public class Bruch1 {
		int zaehler;
		int nenner;
		// instanz-methode:
		void ausgeben(){							// kopf der methode
			System.out.println(zaehler+"/"+nenner); // Rumpf der methode
		}
}
