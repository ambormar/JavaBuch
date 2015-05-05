/* TODO .5.2.3.   s.175, 
 * class Variabeln_LokaleV_InstanzV_KlassenV_G�ltigkeitsbereich_Lebensdauer
 * 
 * - LOKALE VARIABELN:			- sind immer in einem block (kann auch sein:  main-methode oder konstruktor)
 * 								- g�ltigkeitsbereich: 	im block in dem sie erzeugt wurden
 * 								- lebensdauer: 			bis block abgearbeitet ist, k�nnen auch mehrmals erzeugt und wieder gel�scht werden	
 * 
 * - INSTANZVARIABELN:			- g�ltigkeitbereich innerhalb der gesammten klasse, egal wo sie definiert wurden
 * 	(ATTRIBUTE / FIELDS)		- lebensdauer: attribute eines objekts existieren immer so lange wie das objekt selber existiert
 * 
 * - KLASSENVARIABELN (static):	- g�ltigkeitsbereich: 	programm / package
 * 								- lenbensdauer: 		programm-laufzeit
 * 
 * bsp. f�r lebensdauer der veriablen die nur in einem block erzeugt werden. gibt fehlermeldung aus, weil b nur innerhalb des if-blocks erzeugt 
 * und mit der schlussklammer wieder gel�scht wird.
 */

package uebungen05;


public class Variabeln_LokaleV_InstanzV_KlassenV_G�ltigkeitsbereich_Lebensdauer {

	public static void main(String[] args) {
		for (int i = 1; i < 10; i++){
			Klasse_Bruch b = new Klasse_Bruch();
			b.zaehler = 2;
			b.nenner = 3;
			System.out.println("b.nenner = " + b.nenner);
		}
		// System.out.println("b.zaehler = " + b.zaehler);   macht fehlermeldung !!
	}
}
