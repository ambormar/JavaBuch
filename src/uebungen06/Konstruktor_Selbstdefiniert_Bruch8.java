/* TODO .6.4.   s.191
 * klasse Bruch8 & Konstruktor_Selbstdefiniert_Bruch8
 * 
 * KONSTRUKTOR SELBSTDEFINIERT:		- selbstdefinierter konstruktor anstelle von (vom compiler) automatisch erzeugtem default-konstruktor f�r eine klasse		
 * 										- default-(standard) konstruktor entspricht einem konstruktor mit leerer paramaetrliste und leerem rumpf 
 * 											BSP:  Bruch(){}
 * 
 * 									- AUCH der selbstdefinierete Konstruktor heisst Default-Konstruktor solange er leere parameterliste hat
 * 
 * 									- konstruktoren sind wie spezielle methoden mit selbstdefinierten ausgangswerten 
 * 										=> um objekte in einen definierten anfangszustand zu versetzen
 * 
 * 									- name des konstruktors exakt wie klassenname, ohne void oder typangaben
 * 										- public kann vornedranstehen (standard wenn man nix schreibt w�re auch: public)
 * 
 * 									- k. wird automatisch mit new-operator aufgerufen
 * 
 * 						BSP:		public bruch() {		// hier leere parameterliste
 * 										zaehler = 0;
 * 										nenner = 1;			// sinnvoller anfangszustand f�r den bruch (0/1 = 0; 0/0 w�re error)
 * 									}
 * 
 * 					AUFRUF:			- erfolgt aus der starterklasse (Main)
 * 
 * 						BSP:		Bruch b = new Bruch();		// Referenzdatentyp bezeichner = new Konstruktor();
 * 									
 * anstelle vom automatisch erzeugten default konstruktor:
 * selbst definierter konstruktor wird gemacht um die werte eines objekts 
 * auf einen def. anfangszustand zu setzen
 */

package uebungen06;

public class Konstruktor_Selbstdefiniert_Bruch8 {

	public static void main(String[] args) {
		// konstruktoraufruf immer gleich: egal ob nur klasse oder auch konstruktor existieren
		Bruch8 b = new Bruch8();
		b.ausgeben();
	}

}
