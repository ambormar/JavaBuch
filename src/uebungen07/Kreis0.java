/* TODO .7.3.   s.211
 * Kreis0 & Kreis0Segment & Vererbung_StarkReduziert_Kreis0SegmentTest
 * 
 * VERERBUNG SEHR STARK REDUZIERT =>	 genau siehe:	  	Vererbung_Konstruktoren_SubKlasse_Superklasse_KreisSegmentTest		s.213
 * 
 * 
 * VERERBUNG:	- subklasse (kreissegment) erbt attribute & methoden von superklasse (kreis)
 * 				
 * 				- SCHEMA:	public class subklasse extends superklasse {}		BSP:	public class KreisSegment extends Kreis {}
 * 
 * TESTKLASSE:	BSP:	public class KreisSegmentTest {
 * 							Kreissegment segment = new KreisSegment();
 * 							segment.getRadius(); 						
 * 						}
 * 						=> nach erzeugung eines objekts der subklasse sind..
 * 							-> ..zugriffe auf methode der superklasse via objektname der subklasse (aus testprogramm) möglich		
 * 
 * SUPERKLASSE: - Klasse die attribute vererbt (kreis)												s. SuperKlasse_Kreis	s.213
 * 				
 * 				BSP: 	public class Kreis {
 * 							private double radius;			// variable
 * 							Kreis() 						// konstr.
 * 								{radius = 1;}
 * 							double getRadius()				// methode
 * 								{return radius;}
 * 						}
 * 
 * SUBKLASSE	- Klasse die Attribute erbt	 (Kreissegmentt)										s. SubKlasse_KreisSegment	s.213
 * 
 * 				BSP: 	public class KreisSegment extends Kreis {
 * 							private double winkel;			// zusätzl. attribut nur von subklasse (hier ohne konstruktoren und überschriebene methoden)
 * 						} 

 * kurz&knapp: programm zum test der vererbten Attribute & methoden der klasse Kreissegment
 */

package uebungen07;

public class Kreis0 {
	// variabeln
	private double radius;
	
	// konstruktoren:
	Kreis0() {			// wenn der parameterlose defaultkonstruktor nicht mehr verfügbar ist, weil ein eigener konstruktor definiert 
		setRadius(0);	// wurde, braucht es einen parameterlosen konstruktor der die attribute initialisiert
	}
	Kreis0(double r){
		setRadius(r);
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double r) {
		this.radius = r;
	}
	public double getFlaeche(){
		return Math.PI * radius * radius;
	}
	public double getUmfang(){
		return 2 * Math.PI * radius;
	}
	public void radiusVergroessernUm(double vr) {
		radius += vr;
	}
	
}
