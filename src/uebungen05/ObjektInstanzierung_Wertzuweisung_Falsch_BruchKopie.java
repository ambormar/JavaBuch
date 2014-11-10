/* TODO .5.2.2,   s.171 
 * class Instanzierung_WertzuweisungBeiObjekten_Falsch_BruchKopie & Instanzierung_WertzuweisungBeiObjekten_Richtig_BruchKopie
 * 
 * falsche, fehlerhafte kopie von instanz der klasse.
 * ist eigentlich nur eine kopie der bezeichner, die auf die selbe instanz/dieselben werte zeigt
 * 
 * FALSCHE Wertzuweisung bei Instanzen: 	Bruch a = new Bruch(); 
											a.zaehler = 3; 
											a.nenner = 4;
											Bruch b = a;	// ist nur erzeugung eines 2. bezeichners, der auf dasselbe Objekt im Hauptspeicher zeigt
											
											=> Folge: 		b.zaehler = 5 
															b.nenner = 8	// ÄNDERT automatisch auch die werte von a.zaehler & a.nenner !!!!!!
 * 
 * RICHTIGE Wertzuweisung bei Objekten: 	Klasse_Bruch a = new Klasse_Bruch(); 
											a.zaehler = 3; 
											a.nenner = 4; 
											
											Klasse_Bruch b = new Klasse_Bruch();  // neue instanz mit neuem bezeichner & neuem platz im hauptspeicher
											b.zaehler = a.zaehler; 
											b.nenner = a.nenner;
 */

package uebungen05;


public class ObjektInstanzierung_Wertzuweisung_Falsch_BruchKopie {

	public static void main(String[] args) {
		Klasse_Bruch a = new Klasse_Bruch(); // a als Bruch definieren
		a.zaehler = 3; // dem Bruch den wert 3/4 zuweisen
		a.nenner = 4;
		Klasse_Bruch b = a;  // b als Bruch mit dem Wert von a (falsche vorgehensweise)
		System.out.println("Bruch a = " + a.zaehler + "/" + a.nenner);
		System.out.println("Bruch b = " + b.zaehler + "/" + b.nenner);
		b.zaehler = 5;
		b.nenner = 8;
		System.out.println("Bruch a nachher = " + a.zaehler + "/" + a.nenner +
				" : a verändert sich unfreiwillig mit bzw. die bezeichner zeigen auf dasselbe Objekt");  
		System.out.println("Bruch b nachher = " + b.zaehler + "/" + b.nenner);
		// 
	}
}
