package uebungen02;

/* TODO .2.4.5.   s.98
 * class Und_UndUnd_LogischeOperatoren_KurzeOdVollständigeAuswertung
 * 
 * 		&& oder & verknüpfung von wahrheitswerten durch logische operatoren.
 * 		am bsp: kurze auswertung (&&) oder vollständige auswertung (&) von UND (&&, &)
 * 
 * vollständige oder unvollständige auswertung(abarbeitung) bezieht sich jeweils nur auf die (teil)ausdrücke mit true und false die abgearbeitet werden,
 * nach abbruch einer abarbeitung eines ausdrucks wird das weitere programm sonst normal abgearbeitet:
 * 
 *  	bsp also hier: 	- y false bei kurzer auswertung(&&) -> abarbeitung des ausdrucks wird abgebrochen ((++a...) wird nicht ausgeführt)...
 *  					- .. aber programm geht nacher ganz normal beim folgenden System.out.println (..) weiter
 *  
 */

public class Und_UndUnd_LogischeOperatoren_KurzeOdVollständigeAuswertung{
   public static void main(String[] args){
	int a= 1;
	Boolean y= false;
	System.out.println(y && (++a == 2)); // && (kurze auswertung) abarbeitung des ausdrucks wird nach y(=false) abgebrochen, a nicht inkrementiert 
	System.out.println("a = " + a);
	System.out.println(y & (++a == 2)); // & (vollständige auswertung) abarbeitung des ganzen ausdrucks (in klammern), a wird inkrementiert 
	System.out.println("a = " + a);
   }	
}