package uebungen03;

/* TODO .3.3.4.   s.122 
 * class Continue_Sprunganweisung_inSchleifenSpringen
 * 
 * CONTINUE 	= NUR in ausnahmefällen; kann fast immer durch if-anweisungen ersetzt werden
 *
 * continue;	= unterbricht aktuellen schleifendurchlauf von while-, do- oder for-schleifen und 
 * 					springt zur wiederholungsbedingung (=Klammer) der unmittelbar umgebenden schleife
 * 
 * programm gibt per for-schleife 1 - 10 aus, beim zählerstand von i=5 wird vor der zahlenausgabe mit continue gesprungen, zur bedingungsklammer 
 * der schleife, welche mit dem zählerstand i=6 fortgesetzt wird. zahl 5 wird also nicht ausgegeben.
 */

public class Continue_Sprunganweisung_inSchleifenSpringen{
   public static void main(String[] args){
	   for(int i=1; i<=10; i++){
		   if(i==5){
			   continue;	// sprunganweisung zur bedingungsklammer der for-schleife -> 5 wird nicht ausgegeben
		   } 
		   System.out.println(i);
	   }
   }
}