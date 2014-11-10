/* TODO .7.3.   s.214
 * SuperKlasse_Kreis & SubKlasse_KreisSegment & Vererbung_Konstruktoren_SubKlasse_Superklasse_KreisSegmentTest
 * 
 * �BERSCHRIEBENE METHODEN: siehe (unten) SUBKLASSE			(evtl. noch bearbeiten)
 * 
 * 
 *  
 * VERERBUNG:	- subklasse (kreissegment) erbt attribute & methoden von superklasse (kreis)
 * 				
 * 				- SCHEMA:	public class subklasse extends superklasse {}		BSP:	public class KreisSegment extends Kreis {}
 * 
 * 
 * TESTKLASSE: 	AUFUF:	=> nach erzeugung eines objekts der subklasse sind..
 * 							-> ..zugriffe auf methode der superklasse via objektname der subklasse (aus testprogramm) m�glich
 * 
 * 				BSP:	public class KreisSegmentTest {								
 * 							Kreissegment segment = new KreisSegment(2, 180); // objekt erzeugen mit custom-konstruktor superkl. via customkonstr. subkl. unter mitgabe von radius & winkel
 * 							segment.setRadius(3); 		// aufruf der methode der superklasse (die via custom-konstr, der superkl. radius setzt) 
 * 							segment.getFlaeche();		// aufruf der �berschriebenen methode in der subklasse (via gleichnamige methode der superklasse fl�che zu�ckgibt)
 * 							segment.winkel				// aufruf der variablen der subklasse
 * 						}
 * 							
 * SUBKLASSE	- Klasse die Attribute erbt	 (Kreissegment)	von superkl.								s. SubKlasse_KreisSegment	s.213
 * 
 * 				- wenn es Custom-Konstruktoren in der superklasse hat	-> m�ssen alle konstruktoren (inkl. default) der subklasse angepasst werden 
 * 					mit SUPER um �bergabewerte weiterzuleiten 
 * 
 * 				BSP: 	public class KreisSegment extends Kreis {
 * 							private double winkel; 				// ( attr. nur subkl. )
 * 
 * 							KreisSegment() {					// default konstruktor erg�nzen
 * 								super();						// super(): ruft explizit default-konstruktor d. superklasse auf
 * 								winkel = 90�;					// ( attr. init. )
 * 							}
 * 							KreisSegment(double r, double w) {	// custom konstruktor erg�nzen
 * 								super(r);						// super(param): ruft explizit custom-konstruktor d. superklasse auf
 * 								this.winkel = w;				// ( attr. init. ) 
 * 							}
 * 							double getFlaeche(){				// �BERSCHRIEBENE METHODE
 * 								return super.getFlaeche() * winkel / 360�;		// super: ruft gleichnamige methode der superklasse auf
 * 							}
 * 						} 
 * 
 * SUPERKLASSE: - Klasse die attribute vererbt (kreis) an subkl.											s. SuperKlasse_Kreis	s.213
 * 				
 * 				- in der superklasse bleibt alles unver�ndert
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
 * konstruktor der subklasse l�sst sich nur dann mit parameter aufrufen, wenn mittels super() im konstruktor auf superklasse verwiesen wird 
 * bzw. man kann werte �bergeben von subklassen an superklassen indem man neue konstruktoren schreibt 
 * und via super(parameter) weiterleitet
 */

package uebungen07;

public class Methoden_UeberschriebeneMethoden {

}
