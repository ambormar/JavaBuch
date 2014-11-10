package uebungen03;

/* TODO .3.4.1.   s.126 
 * Programm Variabeln_Gueltigkeitsbereich_Summation 
 * 
 * SCOPE (engl.)/ = G�ltigkeitsbereich einer variablen  = Variabel gilt ab dem BLOCK (= {} !), wo sie deklariert wird bis ende block 
 * 				 			Namenskonflikt-l�sung		= innerhalbdes G�ltigkeitsbereichs darf es keine weitere variabel mit demselben namen geben
 * 														(= bei anderen prog.-sprachen m�glich; zugriff dann immer nur auf die zuletzt-definierte m�gl.)
 * 							lebensdauer	v. Variabeln	= zeitintervall, in dem die variabel zur Laufzeit des Programms existiert
 * 														= variabel aus einer schleife wird w�hernd programm evtl. mehrmals erzeugt & zerst�rt
 * 
 * Programm berechnet summe der ersten 100 quadratzahlen
*/
import javax.swing.JOptionPane;

public class Variabeln_Gueltigkeitsbereich_Summation{
										// ausserhalb der main-methode keine (g�ltige) variabel vorhanden
   public static void main(String[] args){
	int n = 100;						// int n g�ltig in ganzer main-methode
	int summe = 0;						// int summe g�ltig in ganzer main-methode
	int z = 0;							// int z g�ltig in ganzer main-methode
	while (z<n){		
	   int quadrat = z * z;				// int quadrat nur g�ltig in while-schleife
	   z++;
	   summe += quadrat;				// n.b. => summe = summe + quadrat (zuweisungsoperator op)
	   System.out.println("quadratzahlen: "+quadrat);	// quadrat kann also nur innerhalb der while-schleife ausgegeben werden
	}
	JOptionPane.showMessageDialog(null,"Summation der ersten 100 quadratzahlen: "+ summe);
   }
}