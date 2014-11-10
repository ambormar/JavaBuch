/* TODO .6.5.   Aufgabe 1 (5&6&7), s.196 (198)			 
 * & Aufgabe 5, s.198		& Aufgabe 6, s.198  (mit GetterSetter_Methoden_Konstruktoren_Kreis1Tabelle)
 * 							& aufgabe 7, s.199 (GetterSetter_Konstruktoren_Methoden_FlaechengleicherKreis)
 * 
 * klasse kreis1 & Konstruktoren_Methoden_GetterSetter_TestKreis1
 * 
 * aufg. 1: 2 kreiskonstruktoren : 	
 * - (der erste ohne parameterliste um kreisradius auf 0 zu setzen), 
 * - der zweite (designated) konstruktor mit einem parameter um Instanzobjekt aufrufen zu können.
 * - getter und setter methoden für radius, umfang(setter aufg 5), fläche(setter aufg. 5)
 * - aus testklasse aufrufen mit fenster-eingabe für radius, radius an konstruktor übergeben,
 * - radius, berechnete umfang und fläche mit der aufrufenden klasse auf konsole ausgeben
 * - aufg 5: klasse kreis erweitern um setUmfang(double u)& setFlaeche(double f): berechnen radius mit übergebenem umfang bzw. fläche

 */

package uebungen06Aufgaben;

public class Kreis1 {
	double radius;
	
	Kreis1(){					// default-konstruktor leere parameterliste nur um radius auf 0 zu initialisieren
		radius = 0;
	}
	
	Kreis1(double rad) {		// custom-konstruktor mit einem parameter um kreis zu instanzieren
		radius = rad;
	}
	
	double getRadius(){				// radius zurückgeben/holen
		return radius;
	}
	
	void setRadius(double r){		// radius setzen
		radius = r;
	}
	
	double getUmfang(){				// umfang zurückgeben
		return 2.0 * Math.PI * radius;
	}
	
	double getFlaeche(){			// fläche zurückgeben
		return Math.PI * radius * radius;
	}
	
	void setUmfang(double u){		// umfang setzen						Aufg. 5
		radius = u / (2 * Math.PI);	// radius berechnen anhand von u			u = 2.0 * Math.PI * radius 	=> 	radius = u / (2 * Math.PI)
	}
	
	void setFlaeche(double f) {		// flaeche setzen						Aufg. 5
		radius = Math.sqrt(f / Math.PI);	// radius berechnen anhand von f
	}
	
	//void radiusVergroessern(double rv){		variante: radiusVergrössern mit hilfe von instanzmethode
	//	radius += rv;
	//}
	
}
