package uebungen03;

/* TODO .3.3.5.   aufgabe 8, s.125 
 * class While_If_Struktogramm_Collatzfolge2Ma
 * 
 * struktogramm (l�sung s.503) und progr�mmchen zur erweiterten collatzreihe (aus aufgabe 7) erstellen.
 * 
   Nach der Eingabe einer Startzahl (ganze Zahl) wird die zugeh�rige Collatzfolge bis zur ersten 1 ausgegeben.
   collatzfolge: 	- startzahl x
   					- gerade zahlen: 	x => x/2
   					- ungerade zahlen:	x => 3x + 1 
   erweiterung: die l�nge der zahlenfolge in anzahl Zahlen (inkl startzahl, exkl. erste 1) und die gr�sste Zahl der Folge auch ausgeben 
 */

import javax.swing.JOptionPane;

public class While_If_Struktogramm_Collatzfolge2Ma {
	public static void main(String[] args) {
		int n; 						// zahl des aktuellen stands der zahlenfolge 
		String eingabe;				
		int anzahlZahlen = 1;		// anzahl der zahlen bis folge beendet (begonnen mit startzahl : 1, bis exklusive die erste 1 der folge
		eingabe = JOptionPane.showInputDialog("Geben Sie eine Startzahl ein: ");
		n = Integer.parseInt(eingabe);
		int maximumZahl = n;		// h�chste zahl der folge 
		System.out.println(n);		// ausgabe startzahl in der console
		while (n != 1) {
			if (n % 2 == 0) {
				n = n / 2;
			} else {
				n = 3 * n + 1;
			}
			System.out.println(n);	// zahl spucken
			anzahlZahlen++;			// z�hler updaten
			if (n > maximumZahl) {	// n mit maximumzahl vergleichen
				maximumZahl = n;
			}
		}
		anzahlZahlen--;
		JOptionPane.showMessageDialog(null,
				"Die L�nge der Collatzfolge betr�gt " + anzahlZahlen
						+ " Zahlen." + '\n'
						+ "Die gr�sste Zahl der Folge ist: " + maximumZahl);
	}
}