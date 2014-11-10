/* TODO .7.4.   Aufgabe 1, s.219
 * Klasse Konto & GetterSetter_Private_Konstruktoren_KontoTest
 */

package uebungen07Aufgaben;

public class GetterSetter_Private_Konstruktoren_KontoTest {

	public static void main(String[] args) {
		Konto k = new Konto("0000000001", 1000.00);
		k.ausgeben();
		k.einzahlen(500.00);
		k.ausgeben();
		k.auszahlen(750.50);
		k.ausgeben();
	}

}
