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
 * 			aufgerufen durch (unter-) konstruktoren mit speziefischeren programmabläufen.
 * 			aufruf mithilfe des selbstverweises this()
 * 
 * VERKETTETE KONSTRUKTOREN: 	- man kann konstruktoren verketten um allgemeingültige abläufe nur einmal zu programmieren:
 * 
 * 				1. Hauptkonstruktor auch: (DESIGNATED KONSTRUKTOR) der alle allgemeingültigen abläufe beinhaltet (muss mind. indirekt aufgerufen werden)
 * 
 * 				2. in weiteren speziefiechen konstruktoren :		-> wird zuerst der hauptkonstruktor aufgerufen..
 * 																	-> dann werden weitere abläufe hinzugefügt
 * 
 * 																	- aufruf eines konstruktors aus einem anderen konstruktors:
 * 																		=> mit selbstverweis: this()
 * 																			-> this(..) muss als erste anweisung im konstruktorrumpf stehen
 * 																			-> dann evtl. weitere anweisungen, die nur für diesen konstr. gültig sind
 * 
 * 			BSP SCHEMATISCH:		class Bruch() {					// klasse
 * 										int zaehler, nenner;		// 
 * 										
 * 										Bruch(int z, int n) {		// hauptkonstruktor mit 
 * 											anweisungen; 			// allgemeine abläufe (z.b.:  0 als nenner ausschliessen; ggt ermitteln; etc.)  
 * 											zaehler = zaehler/ggt;	// inizialisieren von zaehler & nenner der klasse mit gekürztem wert
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

public class Konstruktoren_VerketteteKonstruktoren_Bruch10 {

	public static void main(String[] args) {
		Bruch10 b = new Bruch10();
		Bruch10 a = new Bruch10(4,6);
		Bruch10 c = new Bruch10(5);
		Bruch10 d = new Bruch10(7,0);
	}
}
