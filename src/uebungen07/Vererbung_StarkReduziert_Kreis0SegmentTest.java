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

import javax.swing.JOptionPane;

public class Vererbung_StarkReduziert_Kreis0SegmentTest {

	public static void main(String[] args) {
		// durch aufruf des konstruktors der subklasse Kreissegment wird automatisch auch die superklasse kreis angezapft
		Kreis0Segment segment = new Kreis0Segment();
		// durch aufruf des konstruktors der subklasse Kreissegment kann automatisch auf die elemente der superklasse kreis zugegriffen werden
		JOptionPane.showMessageDialog(null, "Radius des KreisSegment: " + segment.getRadius());
		segment.radiusVergroessernUm(2);
		JOptionPane.showMessageDialog(null, "neuer Radius des KreisSegment: " + segment.getRadius());
	}

}
