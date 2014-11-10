/* TODO .7.3.2.   s.216
 * Bruch6 & Equals_ObjekteVergleichen_Boolean_TestBruch6
 * 
 * methode EQUALS:	- um den wert zweier Objekte zu vergleichen.. 
 * 
 * 					- schnittstelle für equals-methode immer:		=> liefert boolean wert zurück 
 * 																	=> & erwartet als parameter ein objekt derselben klasse (wie für welche sie geschrieben wird)
 * 							
 * 					- .. also NICHT: die bezeichner der beiden objekte, ob diese auf dasselbe Objket zeigen: 	Bsp. NICHT: 	Bruch  =>   a==b
 * 						-> SONDERN: im falls eines Bruches ist gleichheit: 	gleiche zähler & nenner nach dem kürzen
 * 				
 * 					- vordefinierte objekte wie z.b. String haben EQUALS häufig als vordefinierte vergleichsmethoden 
 * 						-> bei String korrekt: 
													String a = "text";
													String b = "text";
													if (a.equals(b)) {..}
							
 * 
 * METHODE 	boolean equals(Bruch br)  FÜR WERTE-VERGLEICH IN DER KLASSE BRUCH schreiben:
 * 
 *  KLASSE BRUCH:																			AUFRUF TESTKLASSE:
 * 
	public boolean equals(Bruch br){														Bruch a = new Bruch(2, 4);
		Bruch a = new Bruch(this.zaehler, this.nenner);										Bruch b = new Bruch(3, 6);
		Bruch b = new Bruch(br.zaehler, br.nenner);											System.out.println(a.equals(b));
		a.kuerzen();
		b.kuerzen();
		if ((a.getZaehler() == b.getZaehler()) && (a.getNenner() == b.getNenner())){
			return true;
		} else {
			return false;
		}
	}
	
 * kurz&knapp: methode equals um bei aufruf den wert zweier brüche (unabhängig von ihren bezeichnern , zu vergleichen.
 * in der methode werden die 2 Brüche als lokale objekte erzeugt, mit ggT gekürzt 
 * und jeweils ihre zähler und nenner verglichen.
 * vergleich zweier objekte mit a.equals(b) und returnwert boolean true oder false
 */

package uebungen07;

public class Equals_ObjekteVergleichen_Boolean_TestBruch6 {

	public static void main(String[] args) {
		Bruch6 a = new Bruch6(2, 4);
		Bruch6 b = new Bruch6(3, 6);
		System.out.println(a.equals(b));
	}

}
