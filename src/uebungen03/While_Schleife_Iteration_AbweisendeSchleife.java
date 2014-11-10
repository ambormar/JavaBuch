package uebungen03;

/* TODO .3.3.1.   s.118
 * class While_Schleife_Iteration_AbweisendeSchleife
 * 
 * WHILE-SCHLEIFE ist KOPFGESTEUERTE / =ABWEISENDE SCHLEIFE weil die bedingung am kopf kommt
 * 
 * 	while (bedingung){		// es ist möglich, dass die anweisung nie abgearbeitet (wenn bedingung nicht erfüllt ist)
	   anweisung;
	}
	
 * STRUKTOGRAMM  s.118
 * 
 * [  NB:
 * 			3.1.	sequenz		anweisungsfolge				anweisungen			s.103
 * 			3.2.	selektion	auswahlstruktur				if-else				s.107		verschachtelte if-else, switch-case, (sprunganweisungen)
 * 			3.3.	iteration	wiederholungsstruktur		while-schleife		s.118		do-schleife, for-schleife				]
 */

public class While_Schleife_Iteration_AbweisendeSchleife{
   public static void main(String[] args){
   	int zahl = 1;
	while (zahl <= 100){			// solange die zahl <= 100 ist wird schleife durchgeführt
		System.out.println(zahl);
		zahl++;
	}
   }
}