/* TODO .7.2.2.   s.207
 * Bruch4 & Private_Datenkapselung_Bruch4
 * 
 * siehe auch 7.2.3. s.210	Private_Public_Default_Protect_Modifiers
 * 
 * 	PRIVATE:						- zugriff auf attribute & methoden nur aus klasse (wo's drinsteht) 
 * 									
 * 										=> lesender & schreibender zugriff auf private methoden & private attribute von ausserhalb ..
 * 										-> .. NUR UND AUSSCHLIESSLICH: über public methoden der klasse		&	 Getter und Setter
 * 
 * 								[NB:	-> .. NICHT: über z.b. Objektbezeichner von erzeugten instanzen:	NICHT bsp.:  System.out.println(a.zaehler);
 * 																											-> a ist nur der bezeichner des objekts 	]
 *  
 * 	PUBLIC:							- zugriff auf attribute & methoden von überall 
 * 
 * 	DEFAULT (ohne modifier): 		
 * 	=> paket-sichtbarkeit:			- zugriff auf attribute & methoden für alle klassen aus demselben paket 
 * 
 * 	PROTECTED:	
 * 	=> paket-sichtbarkeit erweitert:- zugriff auf attribute & methoden für alle klassen aus demselben paket  & AUCH für Unterklassen aus anderen paketen
 * 
 *
 *
 * zugriff auf private-variabeln & private methoden von ausserhalb der klasse nur via public methoden
 * modifier: private, public, default und protected siehe 7.2.3. s.210
 */

package uebungen07;

public class Bruch4 {
	private int zaehler;	// private zaehler & nenner
	private int nenner;
	
	Bruch4(int z, int n){
		zaehler = z;
		nenner = n;
	}
	
	String bruchtoString(){
		return zaehler + "/" + nenner;
	}  
}
