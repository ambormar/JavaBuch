package uebungen03;

/* TODO .3.2.1.   s.107 (105)
 * class If_Anweisung_ZweiseitigeAuswahlstruktur_Selektion1
 *
 * 		if (bedingung/ausdruck = true) {
 * 			anweisungA;
 * 		} else {
 * 			anweisungB;
 * 		}
 * 
 * [  NB:
 * 			3.1.	sequenz		anweisungsfolge				anweisungen			s.103
 * 			3.2.	selektion	auswahlstruktur				if-else				s.107		verschachtelte if-else, switch-case, (sprunganweisungen)
 * 			3.3.	iteration	wiederholungsstruktur		while-schleife		s.118		do-schleife, for-schleife				]
*/

import javax.swing.JOptionPane;

public class If_Anweisung_ZweiseitigeAuswahlstruktur_Selektion1{
   public static void main(String[] args){
	double alter;
	String eingabe;
	eingabe = JOptionPane.showInputDialog("geben sie ihr alter ein: ");
	alter = Double.parseDouble(eingabe);
	if (alter < 18) {
	   JOptionPane.showMessageDialog( null, "sorry, noch nicht volljährig!"); 
	}
	else {
	   JOptionPane.showMessageDialog( null, "glückwunsch, sie sind volljährig!");
	}
   }
}