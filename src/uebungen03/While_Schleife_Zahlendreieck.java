package uebungen03;

/* TODO .3.3.5.   aufgabe 1, s.122 
 * class While_Schleife_Zahlendreieck
 * 
   Zahlendreieck mit while-Schleife
   	folgende ausgabe auf konsole:
		0 
		01
		012 usw. bis 9
*/



public class While_Schleife_Zahlendreieck{
   public static void main(String[] args){
	int zahl = 0;
	String ausgabe = "";
	while (zahl < 10){
	   ausgabe = ausgabe + zahl;	// auch: ausgabe += zahl;
	   System.out.println(ausgabe);
	   zahl++;
	}
   }
}