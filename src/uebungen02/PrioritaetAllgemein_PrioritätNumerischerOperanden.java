package uebungen02;


/* TODO .2.4.4,   s.95
 * class PrioritaetAllgemein_Priorit�tNumerischerOperanden
 * 
 * 	> PRIORIT�T QUER �BER ALLES, ALLGEMEINE REGELN:
 * 		je kleiner die priorit�t-zahl, desto fr�her wird's abgearbeitet (= desto h�her die priorit�t)
 * 		
 * 		bsp abarbeitung: ! vorzeichen (prio 1) vor multiplikation (prio 2) vor addition (prio 3) vor == (prio 6) && (prio 10) vor = (prio 13)
 * 		
 * 		PRIORIT�TZAHLEN aller operanden siehe: 	- VergleichsOperatoren_beiNummerischenwerten_beiFliesskommazahlen	s.91
 * 												- Arithmetische_Operatoren				s.93
 * 												- Logische_Operatoren_Not_Or_Xor_Und	s.97
 * 												- ZuweisungsOperatoren_op				s.99
 * 
 * 	> priorit�ten von numerischen operanden werden mit klammern geregelt wie in der mathe 
 * 
 * VORSICHT:
 * System.out.print gibt zusammengeh�ngte zeichen (concatenation) getrennt nach +zeichen aus, das kann zu fehlern f�hren
*/

public class PrioritaetAllgemein_Priorit�tNumerischerOperanden{
    public static void main(String[] args){
	int a= 2;
	int b= 3;
	int c= 5;
	System.out.println("a+b*c(falsch) = " + a + b * c ); // wird als string(text) + a als string + (b*c) als string ausgegeben 
	System.out.println("a+b*c(richtig) = " + (a+b*c) );
	System.out.println("(a+b)*c = " + (a+b)*c );
    }
}