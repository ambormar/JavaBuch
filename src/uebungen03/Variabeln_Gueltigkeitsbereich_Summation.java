package uebungen03;

/* TODO .3.4.1.   s.126 
 * Programm Variabeln_Gueltigkeitsbereich_Summation 
 * 
 * SCOPE (engl.)/ = Gültigkeitsbereich einer variablen  = Variabel gilt ab dem BLOCK (= {} !), wo sie deklariert wird bis ende block 
 * 				 			Namenskonflikt-lösung		= innerhalbdes Gültigkeitsbereichs darf es keine weitere variabel mit demselben namen geben
 * 														(= bei anderen prog.-sprachen möglich; zugriff dann immer nur auf die zuletzt-definierte mögl.)
 * 							lebensdauer	v. Variabeln	= zeitintervall, in dem die variabel zur Laufzeit des Programms existiert
 * 														= variabel aus einer schleife wird wähernd programm evtl. mehrmals erzeugt & zerstört
 * 
 * Programm berechnet summe der ersten 100 quadratzahlen
*/
import javax.swing.JOptionPane;

public class Variabeln_Gueltigkeitsbereich_Summation{
										// ausserhalb der main-methode keine (gültige) variabel vorhanden
   public static void main(String[] args){
	int n = 100;						// int n gültig in ganzer main-methode
	int summe = 0;						// int summe gültig in ganzer main-methode
	int z = 0;							// int z gültig in ganzer main-methode
	while (z<n){		
	   int quadrat = z * z;				// int quadrat nur gültig in while-schleife
	   z++;
	   summe += quadrat;				// n.b. => summe = summe + quadrat (zuweisungsoperator op)
	   System.out.println("quadratzahlen: "+quadrat);	// quadrat kann also nur innerhalb der while-schleife ausgegeben werden
	}
	JOptionPane.showMessageDialog(null,"Summation der ersten 100 quadratzahlen: "+ summe);
   }
}