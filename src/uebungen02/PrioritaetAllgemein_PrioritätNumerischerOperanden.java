package uebungen02;


/* TODO .2.4.4,   s.95
 * class PrioritaetAllgemein_PrioritätNumerischerOperanden
 * 
 * 	> PRIORITÄT QUER ÜBER ALLES, ALLGEMEINE REGELN:
 * 		je kleiner die priorität-zahl, desto früher wird's abgearbeitet (= desto höher die priorität)
 * 		
 * 		bsp abarbeitung: ! vorzeichen (prio 1) vor multiplikation (prio 2) vor addition (prio 3) vor == (prio 6) && (prio 10) vor = (prio 13)
 * 		
 * 		PRIORITÄTZAHLEN aller operanden siehe: 	- VergleichsOperatoren_beiNummerischenwerten_beiFliesskommazahlen	s.91
 * 												- Arithmetische_Operatoren				s.93
 * 												- Logische_Operatoren_Not_Or_Xor_Und	s.97
 * 												- ZuweisungsOperatoren_op				s.99
 * 
 * 	> prioritäten von numerischen operanden werden mit klammern geregelt wie in der mathe 
 * 
 * VORSICHT:
 * System.out.print gibt zusammengehängte zeichen (concatenation) getrennt nach +zeichen aus, das kann zu fehlern führen
*/

public class PrioritaetAllgemein_PrioritätNumerischerOperanden{
    public static void main(String[] args){
	int a= 2;
	int b= 3;
	int c= 5;
	System.out.println("a+b*c(falsch) = " + a + b * c ); // wird als string(text) + a als string + (b*c) als string ausgegeben 
	System.out.println("a+b*c(richtig) = " + (a+b*c) );
	System.out.println("(a+b)*c = " + (a+b)*c );
    }
}