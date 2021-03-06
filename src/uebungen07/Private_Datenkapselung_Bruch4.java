/* TODO .7.2.2.   s.207
 * Bruch4 & Private_Datenkapselung_Bruch4
 * 
 * siehe auch 7.2.3. s.210	Private_Public_Default_Protect_Modifiers
 * 
 * 	PRIVATE:						- zugriff auf attribute & methoden nur aus klasse (wo's drinsteht) 
 * 									
 * 										=> lesender & schreibender zugriff auf private methoden & private attribute von ausserhalb ..
 * 										-> .. NUR UND AUSSCHLIESSLICH: �ber public methoden der klasse		&	 Getter und Setter
 * 
 * 								[NB:	-> .. NICHT: �ber z.b. Objektbezeichner von erzeugten instanzen:	NICHT bsp.:  System.out.println(a.zaehler);
 * 																											-> a ist nur der bezeichner des objekts 	]
 *  
 * 	PUBLIC:							- zugriff auf attribute & methoden von �berall 
 * 
 * 	DEFAULT (ohne modifier): 		
 * 	=> paket-sichtbarkeit:			- zugriff auf attribute & methoden f�r alle klassen aus demselben paket 
 * 
 * 	PROTECTED:	
 * 	=> paket-sichtbarkeit erweitert:- zugriff auf attribute & methoden f�r alle klassen aus demselben paket  & AUCH f�r Unterklassen aus anderen paketen
 * 
 *
 *
 * zugriff auf private-variabeln & private methoden von ausserhalb der klasse nur via public methoden
 * modifier: private, public, default und protected siehe 7.2.3. s.210
 */

package uebungen07;

public class Private_Datenkapselung_Bruch4 {

	public static void main(String[] args) {
		Bruch4 a = new Bruch4(1, 2);
		// korrekter zugriff auf private variablen der Klasse Bruch4 via public oder default methoden
		System.out.println("Bruch a: " + a.bruchtoString());
		
		// direkter zugriff von aussen auf die private variablen zaehler & nenner der Klasse Bruch4 hier NICHT m�glich:
		/* System.out.println(a.zaehler + "/" + a.nenner); */
	}

}
