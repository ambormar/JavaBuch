package uebungen02;

/* TODO .2.4.5.   s.97
 * class Logische_Operatoren_Not_Or_Xor_Und
 * 
 * 		Logische Operatoren: 	vergleiche von wahrheitswerten 	-> 	ergebnisse: typ boolean
 * 
 * 		DIE LOGISCHEN OPERATOREN:
 * 
 * 		!		NICHT							prio 1		!true == false
 * 		&		UND vollst. auswertung			prio 7		alle werte müssen true sein sonst false
 * 		&& 		Und kurze auswertung			prio 10		alle werte true sonst false; sobald ein teilausdruck false, wird abarbeitung des Teilausdrucks abgebrochen, siehe auch 2.4.5. Und_UndUnd_LogischeOperatoren_KurzeOdVollständigeAuswertung 
 *		^		exklusives ODER	(XOR)			prio 8		entweder oder => true, sonst (wiederholt true od wiederholt false) => false
 * 		|		ODER vollständ. auswertung		prio 9		einer der Werte muss true sein, der ganze ausdruck wird abgearbeitet
 * 		||		ODER kurze auswertung			prio 11		einer der Werte muss true sein, sobald ein teilausdruck true ist, wird abarbeitung des teilausdrucks abgebrochen
 * 		
 * 
 * 		TABELLE LOGISCHE VERKNÜPFUNG 2ER WAHRHEITSWERTE:
 * 
 * 		a		b		a&b, a&&b		a^b			a|b, a||b	
 * 
 * 		true 	true	true			false		true
 * 		true	false	false			true		true
 * 		false	true	false			true		true
 * 		false	false	false			false		false
 * 
 * 							
 */
public class Logische_Operatoren_Not_Or_Xor_Und {

	public static void main(String[] args) {

	}

}
