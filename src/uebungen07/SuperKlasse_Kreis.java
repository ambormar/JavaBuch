/* TODO .7.3.   s.213
 * SuperKlasse_Kreis & SubKlasse_KreisSegment & Vererbung_Konstruktoren_SubKlasse_Superklasse_KreisSegmentTest
 * 
 *  
 * VERERBUNG:	- subklasse (kreissegment) erbt attribute & methoden von superklasse (kreis)
 * 				
 * 				- SCHEMA:	public class subklasse extends superklasse {}		BSP:	public class KreisSegment extends Kreis {}
 * 
 * 
 * TESTKLASSE: 	AUFUF:	=> nach erzeugung eines objekts der subklasse sind..
 * 							-> ..zugriffe auf methode der superklasse via objektname der subklasse (aus testprogramm) möglich
 * 
 * 				BSP:	public class KreisSegmentTest {								
 * 							Kreissegment segment = new KreisSegment(2, 180); // objekt erzeugen mit custom-konstruktor superkl. via customkonstr. subkl. unter mitgabe von radius & winkel
 * 							segment.setRadius(3); 		// aufruf der methode der superklasse (die via custom-konstr, der superkl. radius setzt) 
 * 							segment.getFlaeche();		// aufruf der überschriebenen methode in der subklasse (via gleichnamige methode der superklasse fläche zuückgibt)
 * 							segment.winkel				// aufruf der variablen der subklasse
 * 						}
 * 							
 * SUBKLASSE	- Klasse die Attribute erbt	 (Kreissegment)	von superkl.								s. SubKlasse_KreisSegment	s.213
 * 
 * 				- wenn es Custom-Konstruktoren in der superklasse hat	-> müssen alle konstruktoren (inkl. default) der subklasse angepasst werden 
 * 					mit SUPER um übergabewerte weiterzuleiten 
 * 
 * 				BSP: 	public class KreisSegment extends Kreis {
 * 							private double winkel; 				// ( attr. nur subkl. )
 * 
 * 							KreisSegment() {					// default konstruktor ergänzen
 * 								super();						// super(): ruft explizit default-konstruktor d. superklasse auf
 * 								winkel = 90°;					// ( attr. init. )
 * 							}
 * 							KreisSegment(double r, double w) {	// custom konstruktor ergänzen
 * 								super(r);						// super(param): ruft explizit custom-konstruktor d. superklasse auf
 * 								this.winkel = w;				// ( attr. init. ) 
 * 							}
 * 							double getFlaeche(){				// ÜBERSCHRIEBENE METHODE
 * 								return super.getFlaeche() * winkel / 360°;		// super: ruft gleichnamige methode der superklasse auf
 * 							}
 * 						} 
 * 
 * SUPERKLASSE: - Klasse die attribute vererbt (kreis) an subkl.											s. SuperKlasse_Kreis	s.213
 * 				
 * 				- in der superklasse bleibt alles unverändert
 * 				
 * 				BSP: 	public class Kreis {
 * 							private double radius;	
 * 		
 * 							Kreis() { 						// default-konstr.
 * 								radius = 1;
 * 							}
 * 							Kreis(int r) { 					// custom-konstr.
 * 								radius = r;
 * 							}
 * 							double getRadius()				// methoden
 * 								{return radius;}
 * 
 *							double getFlaeche()						
 *								{return Math.PI * radius * radius;}  
 * 						}
 *  
 * 																
 * konstruktor der subklasse lässt sich nur dann mit parameter aufrufen, wenn mittels super() im konstruktor auf superklasse verwiesen wird 
 * bzw. man kann werte übergeben von subklassen an superklassen indem man neue konstruktoren schreibt 
 * und via super(parameter) weiterleitet
 */
package uebungen07;

public class SuperKlasse_Kreis {
	// variabeln
	private double radius;
	
	// konstruktoren:
	SuperKlasse_Kreis() {		// wenn der parameterlose defaultkonstruktor nicht mehr verfügbar ist, weil ein custom konstruktor definiert..
		setRadius(1);			// ..wurde, braucht es auch einen parameterlosen konstruktor der die attribute initialisiert
	}
	SuperKlasse_Kreis(double r){
		setRadius(r);
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double r) {
		this.radius = r;
	}
	public double getFlaeche(){
		return Math.PI * Math.pow(radius, 2);	// Math.pow(radius, 2)	entspricht:  radius * radius
	}
	public double getUmfang(){
		return 2 * Math.PI * radius;
	}
	public void radiusVergroessernUm(double vr) {
		radius += vr;
	}
	
}

