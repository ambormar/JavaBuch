package uebungen03;

/*	TODO .3.3.2,   s.119
 * class Do_Schleife_Iteration_NichtAbweisendeSchleife
 * 
 * DO-SCHLEIFE ist FUSSGESTEUERTE / =NICHT-ABWEISENDE SCHLEIFE weil die bedingung am fuss kommt
 * DER HAUPTUNTERSCHIED zur while-schleife: die do-schleife wird mindestens einmal abgearbeitet
 * 
 * 	do {					// die anweisung wird mindestens einmal abgearbeitet 
	   anweisung;		
	} while (bedingung);
	
 * STRUKTOGRAMM  s.119
 * 
 * [  NB:
 * 			3.1.	sequenz		anweisungsfolge				anweisungen			s.103
 * 			3.2.	selektion	auswahlstruktur				if-else				s.107		verschachtelte if-else, switch-case, (sprunganweisungen)
 * 			3.3.	iteration	wiederholungsstruktur		while-schleife		s.118		do-schleife, for-schleife				]
 */

public class Do_Schleife_Iteration_NichtAbweisendeSchleife {
	public static void main(String[] args) {
		int zahl = 1;
		do {
			System.out.println(zahl);
			zahl++;
		} while (zahl <= 100);
	}
}