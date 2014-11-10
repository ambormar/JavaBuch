package uebungen03;

/* TODO .3.2.1.   s.110 (105)
 * class If_Verschachtelt_Vokaltest
 * 
 * 		programm zum testen auf vokal 
 * 
 * STRUKTOGRAMM von verschachtelter if-anweisung siehe s.111 
 * 
 * VERSCHACHTELTE IF-ANWEISUNG: (bei einzeiligen anweisungen kann man klammern weg lassen)
 * 
 * 		HAUPTMERKMAL:	- trifft eine bedingung zu werden die anderen gar nicht abgearbeitet
 * 
 * 		if (bedingung 1) 
 * 			anweisung 1;
 * 		else if (bedingung 2) 
 * 			anweisung 2;
 * 		else if (bedingung 3) 
 * 			anweisung 3;
 * 		else 
 * 			anweisung 4;
 * 
 * MEHRERE NICHT-VERSCHACHTELTE IF-ANWEISUNGEN (OHNE ELSE / ELSE IF): 
 * 
 * 		HAUPTMERKMAL:	- jede bedingung wird geprüft (egal ob eine zutrifft oder nicht)
 * 
 * 						- innerhalb einer methode mit return nach jedem if: trifft bedingung zu wird methode verlassen (so die anderen wiederum nicht geprüft)
 * 							siehe auch: Returns_Methode_MitErgebnissrueckgabe_MehrereReturns_Bruch7 	s.189
 * 
 * 		if (bedingung 1)		
 * 			anweisung 1;			
 * 		if (bedingung 2)			 
 * 			anweisung 2;
 * 		if (bedingung 3) 
 * 			anweisung 3;
 * 
*/

import javax.swing.JOptionPane;

public class If_Verschachtelt_Vokaltest {
   public static void main(String[] args){
	String eingabe;
	char c;
	boolean istVokal = false;
	boolean istUmlaut = false;
	eingabe = JOptionPane.showInputDialog("Geben sie einen Buchstaben ein: ");
	c = eingabe.charAt(0);				// zeichen c = erstes zeichen des strings eingabe (position 0) 
	if(c == 'a') istVokal = true;	
	else if(c == 'e') istVokal = true;
	else if(c == 'i') istVokal = true;
	else if(c == 'j') istVokal = true;
	else if(c == 'o') istVokal = true;
	else if(c == 'u') istVokal = true;
	else if(c == 'y') istVokal = true;
	else if(c == 'ä') istUmlaut = true;
	else if(c == 'ö') istUmlaut = true;	
	else if(c == 'ü') istUmlaut = true;
	else if(c == 'A') istVokal = true;	
	else if(c == 'E') istVokal = true;
	else if(c == 'I') istVokal = true;
	else if(c == 'J') istVokal = true;
	else if(c == 'O') istVokal = true;
	else if(c == 'U') istVokal = true;
	else if(c == 'Y') istVokal = true;
	else if(c == 'Ä') istUmlaut = true;
	else if(c == 'Ö') istUmlaut = true;	
	else if(c == 'Ü') istUmlaut = true;
	else { 
	   istVokal = false; 
	   istUmlaut = false;
	}
	if (istVokal == true){
	   JOptionPane.showMessageDialog(null, c + " ist ein Vokal!");
	}
	else if (istUmlaut == true){
	   JOptionPane.showMessageDialog(null, c + " ist ein Umlaut!");
	}
	else{
	   JOptionPane.showMessageDialog(null, c + " ist weder Vokal noch Umlaut!");
	}
   }
}