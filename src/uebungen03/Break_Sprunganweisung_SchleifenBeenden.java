package uebungen03;

/* TODO .3.3.4.   s.121
 * class Break_Sprunganweisung_SchleifenBeenden
 * 
 * BREAK 	= sprunganweisungen nur in ausnahmef�llen, NUR gut um zb. tief verschachtelte if-anweisungen zu vermeiden
 *		 	= kann fast immer durch if-anweisungen ersetzt werden
 *		 	= nur in switsch-case ist es standardm�ssig zu verwenden
 * 
 * break; 	: beendet while-, do-, for-, oder switch-anweisungen die die break-anweisung unmittelbar umgibt
 * 		  	: programm wird mit der n�chsten anweisung nach der abgebrochenen schleife fortgesetzt 
 * 
 * programm pr�ft ob eingegebene zahl gr�sser als 10, falls ja wird die schleife mit der break-anweisung verlassen
 * 
 * [  NB:
 * 			3.1.	sequenz		anweisungsfolge				anweisungen			s.103
 * 			3.2.	selektion	auswahlstruktur				if-else				s.107		verschachtelte if-else, switch-case, (sprunganweisungen)
 * 			3.3.	iteration	wiederholungsstruktur		while-schleife		s.118		do-schleife, for-schleife				]
 */

import javax.swing.JOptionPane;

public class Break_Sprunganweisung_SchleifenBeenden{
   public static void main(String[] args){
	String eingabe;
	int x;
	while (true) { 			// eigentlich endlosschleife, kein regul�rer ausstieg, desshalb break als einziger m�glicher ausstieg;
	   eingabe = JOptionPane.showInputDialog("Geben Sie eine zahl ein: ");
	   x = Integer.parseInt(eingabe);
	   if (x > 10) {
	      break; 			// break beendet umgebende switch-, while-, do-, for-anweisungen...
	   } 					// ... programm wird mit der ersten anweisung hinter while-schleife (hier!) fortgesetzt
	   else{
	      System.out.println(x);
	   }
	}
   }
}