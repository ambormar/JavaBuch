package uebungen03;

/* TODO .3.3.5.   aufgabe 2, s.123
 * class Do_Schleife_Zahlendreieck
 * 
 * wie While_Schleife_Zahlendreieck aber einfach mit do-schleife, keine weiteren anpassungen nötig
 * 
 * Zahlendreieck mit do-Schleife
 * Hans-Peter Habelitz
 */

public class Do_Schleife_Zahlendreieck {

	public static void main(String[] args) {
		int zahl = 0;
		String ausgabe = "";

		do {
			ausgabe = ausgabe + zahl;
			System.out.println(ausgabe);
			zahl++;
		} while (zahl < 10);
	}

}