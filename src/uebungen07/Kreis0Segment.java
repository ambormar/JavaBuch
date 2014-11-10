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
 * 							-> ..zugriffe auf methode der superklasse via objektname der subklasse (aus testprogramm) m�glich		
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
 * 							private double winkel;			// zus�tzl. attribut nur von subklasse (hier ohne konstruktoren und �berschriebene methoden)
 * 						} 

 * kurz&knapp: programm zum test der vererbten Attribute & methoden der klasse Kreissegment
 */

package uebungen07;

// sub-klasse Kreissegment erweitert (erbt von) super-klasse/basis-klasse Kreis
public class Kreis0Segment extends Kreis0 {
	// zus�tzliche variable f�r Kreissegment zu den vererbten von Kreis
	double winkel;
	
	// HIER stark vereinfacht, es FEHLEN: Konstruktoren f�r Kreis0Segment & �berschriebene Methoden f�r Umfang und Fl�che des Segments
	// AUSF�HRLICH siehe: 	7.3 SubKlasse_KreisSegment		s.213
}
