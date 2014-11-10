package uebungen03;

/* TODO .3.2.2.   aufgabe 1, s.112
 * class If_Anweisung_ZahlentestMa
 * 
   übungsaufgaben zu if-anweisungen
   prüfen ob eine zahl (typ double) negativ oder positiv und resultat-ausgabe in ausgabefenster  
*/

import javax.swing.JOptionPane;

public class If_Anweisung_ZahlentestMa{
   public static void main(String[] args){
	String eingabe;
	double testZahl;
	int ausgabeZahl;
	eingabe = JOptionPane.showInputDialog("Bitte geben Sie eine ganze positive oder negative Zahl ein: ");
	testZahl = Double.parseDouble(eingabe);
	ausgabeZahl = (int) testZahl;
	if (testZahl >= 0){
	   JOptionPane.showMessageDialog(null,"der eingegeben Wert: " +ausgabeZahl + " ist positiv!");
	}else{
	   JOptionPane.showMessageDialog(null,"der eingegeben Wert: " +ausgabeZahl + " ist negativ!");
	}
   }
}