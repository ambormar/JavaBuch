package uebungen02;

/* TODO .2.4.3.   s.94
 * class InkrementDekrement_PräfixPostfix
*/

public class InkrementDekrement_PräfixPostfix {
	public static void main(String[] args) {
		int a = 5;
		System.out.println("a++ ist: " + a++); 	// a++ : postfix: variabel wird nach zugriff in-/dekrementiert
		System.out.println("anschliessend ist a: " + a);
		int b = 5;
		System.out.println("++b ist: " + ++b);	// ++b : präfix: variabel wird vor zugriff in-/dekrementiert
		System.out.println("anschliessend ist b: " + b);
	}
}