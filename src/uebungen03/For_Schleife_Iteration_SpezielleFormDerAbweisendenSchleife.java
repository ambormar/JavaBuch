package uebungen03;

/* TODO .3.3.3,   s.120 
 * class For_Schleife_Iteration_SpezielleFormDerAbweisendenSchleife
 * 
 * 	FOR-SCHLEIFE: 	= spezielle form der abweisenden schleife (while)
 * 					= (hauptunterschied zu while:) wird gebraucht, wenn bei eintritt in die schlaufe die anzahl wiederholungen schon feststeht
 * 
 * 		SCHEMA:		for (init; bedingung; update) {		// deklaration d. zählvariabel, bedingung & update des zählers in der kopfzeile zusammengefasst...
 *	   					anweisung;						// ...die für die erhöhung gebrauchte zahl (bsp int i) ist nur innerhalb der for-schleife verwendbar 
 *					} 
 *
 *		BSP:		siehe code
 *
 *		GESCHACHTELTE FOR-SCHLEIFE:		SIEHE:	11.1.2.   ArrayZweidimensional_forSchleife		s.326
 * 
 * [ NB:
 * 			3.1.	sequenz		anweisungsfolge				anweisungen			s.103
 * 			3.2.	selektion	auswahlstruktur				if-else				s.107		verschachtelte if-else, switch-case, (sprunganweisungen)
 * 			3.3.	iteration	wiederholungsstruktur		while-schleife		s.118		do-schleife, for-schleife				]
 * 
 * 
 * 		FOREACH-SCHLEIFE:	SIEHE & VERGLEICHE: 	11.1.   ForEachSchleife_ArrayAusgabe	s.324 
 * 
 */

public class For_Schleife_Iteration_SpezielleFormDerAbweisendenSchleife{
   public static void main(String[] args){
	for (int i = 1; i <= 100; i++) { 		// i ist nicht ausserhalb der schleife verwendbar...  
	   System.out.println(i);				// ...(vergleiche mit while-schleife int zahl, welche oben als variabel deklariert wird)
	} 
   }
}