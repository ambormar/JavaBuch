package uebungen02;

/* TODO .2.4.2,   s.91
 * class VergleichsOperatoren_beiNummerischenwerten_beiFliesskommazahlen
 * 
 * 		vergleichsoperatoren bei nummerischen werten -> boolean (true, false) als ergebnisse
 * 
 * 		VERGLEICHSOPERATOREN: 	<		kleiner als				prio  5
 * 								<=		kleiner gleich			prio  5
 * 								>		grösser als				prio  5
 * 								>=		grösser gleich			prio  5
 * 								==		genau gleich			prio  6
 * 								!=		nicht gleich			prio  6
 * 
 * 		Fliesskommazahlenn besser vergleichen mit < oder > als mit ==, weil rundungsfehler exakte gleichheit verhindern
 */

public class VergleichsOperatoren_beiNummerischenwerten_beiFliesskommazahlen {
   public static void main(String[] args){
	double a = 2.05;
	double b = 0.05;
	System.out.println(a);
	System.out.println(b);
	System.out.println(a-b);
	boolean test;
	test = (2.05-0.05) == 2.0;
	System.out.println(test);
	System.out.println(2.05-0.05);
	System.out.println(2.0);
   }
}