package uebungen03;

/* TODO .3.3.5.   Aufgabe 5, s.123 
 * class While_Schleife_Struktogramm_GgtEuklidMa
 * 
 * PROGRAMM nach STRUKTOGRAMM s.124 schreiben ist sinn der übung
 *  
   struktogram von euklids algorithmus zur berechnung des ggts in programm umschreiben
*/

import javax.swing.JOptionPane;

public class While_Schleife_Struktogramm_GgtEuklidMa{
   public static void main(String[] args){
	int m, n, r;
	m = Integer.parseInt(JOptionPane.showInputDialog("gib einen wert für m ein"));
	n = Integer.parseInt(JOptionPane.showInputDialog("gib einen wert für n ein"));
	r = m % n;
	while (r>0){
	   System.out.println("m: "+m+" n: "+n+" r: "+r);
	   m = n;
	   n = r;
	   r = m % n;
	}
	JOptionPane.showMessageDialog(null, "der GGT ist: " +n);
   }
}