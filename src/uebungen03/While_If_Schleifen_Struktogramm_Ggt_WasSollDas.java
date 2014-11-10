package uebungen03;

/* TODO .3.3.5.   aufgabe 4 (3), s.123 
 * class While_If_Schleifen_Struktogramm_Ggt_WasSollDas
 * 
 * PROGRAMM nach STRUKTOGRAMM s.123 schreiben ist sinn der übung
 * 
   WasSollDass-programm ist ein PrimzahlenTeilomat oder ein ggT-omat (andere methode als euklid)
*/

import javax.swing.JOptionPane;

public class While_If_Schleifen_Struktogramm_Ggt_WasSollDas{
   public static void main(String[] args){
	int m;
	int n;
	m = Integer.parseInt(JOptionPane.showInputDialog("bitte geben sie einen wert für m ein:"));
	n = Integer.parseInt(JOptionPane.showInputDialog("bitte geben sie einen wert für n ein:"));
	while (m != n){
	   System.out.println("m: "+m+" n: " + n);		// diese zeile ist nicht im struktogramm, ergänzung für nachvollziehbarkeit auf konsole
	   if (m > n){
	   	m = m-n ;
	   } 
	   else {
		n = n-m ;
	   }
	
	} 
	JOptionPane.showMessageDialog(null, "der wert für m & n ist schlussendlich: " + m);
   }
}