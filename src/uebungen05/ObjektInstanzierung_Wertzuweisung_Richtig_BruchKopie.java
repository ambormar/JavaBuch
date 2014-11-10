/* TODO .5.2.2.   s.174
 * class Instanzierung_WertzuweisungBeiObjekten_Richtig_BruchKopie & Instanzierung_WertzuweisungBeiObjekten_Falsch_BruchKopie
 * 
 * Echte Kopie des Objekts Bruch: eine neue instanz des objekts wird erzeugt 
 * und die werte der variablen/elemente werden echt (von a.zaehler auf b.zaehler) kopiert
 * 
 * FALSCHE Wertzuweisung bei Instanzen:	 	Bruch a = new Bruch(); 
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
 *											b.nenner = a.nenner;
 */


package uebungen05;


public class ObjektInstanzierung_Wertzuweisung_Richtig_BruchKopie {

	public static void main(String[] args) {
		Klasse_Bruch a = new Klasse_Bruch(); // a als Bruch definieren
		a.zaehler = 3; // dem Bruch den Wert 3/4 zuweisen
		a.nenner = 4; // 
		System.out.println("Bruch a = " + a.zaehler + "/" + a.nenner);
		Klasse_Bruch b = new Klasse_Bruch(); // b als zweiten bruch definieren
		b.zaehler = a.zaehler; // b den wert von a zuweisen
		b.nenner = a.nenner;
		System.out.println("Bruch b kopiert = " + b.zaehler + "/" + b.nenner);
		System.out.println("Bruch a nachher = " + a.zaehler + "/" + a.nenner);
		if (a == b){
			System.out.println("a == b ist true.");
		} else {
			System.out.println("a == b ist false, weil es verschiedene instanzen von Bruch sind.");	
		}
	}
}
