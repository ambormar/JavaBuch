/* TODO .6.4.2.   s.194
 * Bruch10 & Konstruktoren_VerketteteKonstruktoren_Bruch10
 *  
 * 		[NB		Konstruktor ohne Parameter:		- siehe Konstruktor_Selbstdefiniert_Bruch8		s.191
 *  				(= default-konstruktor)
 * 
 *				Konstruktoren mit Parameter:	- siehe Konstruktor_MitParametern_CustomKonstruktor_Bruch9	s.193
 * 					(= custom-konstruktoren)																		 ]
 * 
 * 
 * KURZ: 	verkettung der konstruktoren: designated (haupt-) konstruktor mit allgemeineren kontrollstrukturen,
 * 			aufgerufen durch (unter-) konstruktoren mit speziefischeren programmabl�ufen.
 * 			aufruf mithilfe des selbstverweises this()
 * 
 * VERKETTETE KONSTRUKTOREN: 	- man kann konstruktoren verketten um allgemeing�ltige abl�ufe nur einmal zu programmieren:
 * 
 * 				1. Hauptkonstruktor auch: (DESIGNATED KONSTRUKTOR) der alle allgemeing�ltigen abl�ufe beinhaltet (muss mind. indirekt aufgerufen werden)
 * 
 * 				2. in weiteren speziefiechen konstruktoren :		-> wird zuerst der hauptkonstruktor aufgerufen..
 * 																	-> dann werden weitere abl�ufe hinzugef�gt
 * 
 * 																	- aufruf eines konstruktors aus einem anderen konstruktors:
 * 																		=> mit selbstverweis: this()
 * 																			-> this(..) muss als erste anweisung im konstruktorrumpf stehen
 * 																			-> dann evtl. weitere anweisungen, die nur f�r diesen konstr. g�ltig sind
 * 
 * 			BSP SCHEMATISCH:		class Bruch() {					// klasse
 * 										int zaehler, nenner;		// 
 * 										
 * 										Bruch(int z, int n) {		// hauptkonstruktor mit 
 * 											anweisungen; 			// allgemeine abl�ufe (z.b.:  0 als nenner ausschliessen; ggt ermitteln; etc.)  
 * 											zaehler = zaehler/ggt;	// inizialisieren von zaehler & nenner der klasse mit gek�rztem wert
 * 											nenner = nenner/ggt;
 * 										}
 * 										
 * 										Bruch() {			// allgemeiner konstruktor ohne parameter zur initialisierung des Bruchs mit 0/1...
 * 											this(0, 1)		// ...durch aufrufen des hauptkonstruktors mittels this(0,1)
 * 										}
 * 					
 * 										Bruch(int n) {		// weiterer konstruktor mit einem parameter zur init. des Bruchs mit ganzzahligem wert n/1...
 * 											this(n, 1)		// ...durch aufrufen des hauptkonstruktors mittels this(n,1)
 * 										}
 * 
 */

package uebungen06;

import javax.swing.JOptionPane;

// definition der klasse Bruch mit verketteten Konstruktoren
public class Bruch10 {
	int zaehler;
	int nenner;

	Bruch10(int z, int n) {		// designated (= haupt-) konstruktor
		int hz, hn, r;
		if (n == 0) { 			// Bedingung um nenner == 0 auszuschliessen
			JOptionPane.showMessageDialog(null, "Die Eingabe f�hrt zu: Fehler! Der Nenner darf nicht 0 sein!");
		} else { 				// Bedingung-schleife zum k�rzen des Bruchs mit ggT
			hz = z; 			// hz (= ggTzaehler )
			hn = n; 			// hn (= ggTzaehler )
			r = hz % hn; 		// r (= rest)
			while (r != 0) {
				hz = hn;		// euklid-formel zum ermitteln des ggT
				hn = r;
				r = hz % hn;
			} 					// in hn steht jetzt der ggT
			zaehler = z / hn; 	// z k�rzen mit ggT = gek�rzter zaehler
			nenner = n / hn; 	// n k�rzen mit ggT = gek�rzter nenner
			this.ausgeben();
		}
	}
	// Konstruktor f�r "aufruf" des (designated)konstruktors unter mitgabe von 2 Parametern
	Bruch10(){
		this(0, 1);		// verketteter konstruktor-aufruf mit this() immer als erste anweisung	
						// danach weitere Kontrollstrukturen m�glich
	}
	// Konstruktor f�r "aufruf" des (haupt-)konstruktors unter mitgabe von 1 Parameter
	Bruch10(int x){
		this(x, 1);
	} 
	
	void ausgeben(){
		JOptionPane.showMessageDialog(null, "Die Eingabe f�hrt gek�rzt zum Bruch: " + zaehler + "/" + nenner);
	}
}
