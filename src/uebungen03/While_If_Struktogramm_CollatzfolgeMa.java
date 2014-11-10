package uebungen03;

/* TODO .3.3.5.   aufgabe 7, s.124
 * class While_If_Struktogramm_CollatzfolgeMa
 * 
   struktogramm (lösung s.502) und progrämmchen zur collatzreihe erstellen.
   
   
   Nach der Eingabe einer Startzahl (ganze Zahl) wird die zugehörige Collatzfolge bis zur ersten 1 ausgegeben.
   
   collatzfolge: 	- startzahl x
   					- gerade zahlen: 	x => x/2
   					- ungerade zahlen:	x => 3x + 1 
   
 */

import javax.swing.JOptionPane;

public class While_If_Struktogramm_CollatzfolgeMa {
	public static void main(String[] args) {
		int n; /* startzahl */
		String eingabe;
		eingabe = JOptionPane.showInputDialog("Geben Sie eine Startzahl ein: ");
		n = Integer.parseInt(eingabe);
		System.out.println(n);
		while (n != 1) {
			if (n % 2 == 0) {
				n = n / 2;
			} else {
				n = 3 * n + 1;
			}
			System.out.println(n);
		}
	}
}