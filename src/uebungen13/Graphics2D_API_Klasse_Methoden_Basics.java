/* TODO 13.2.4.   s.410,	 
 * Graphics2D_API_Klasse_Methoden_Basics
 * 
 * 		SIEHE ANGEWANDT:		13.2.4.   Graphics2D_JPanel_Komponente_ZumHineinZeichnen_Zeichnen3			s.413, oben
 * 
 * Graphics2D - JAVA 2D-API, BASICS:	=  Graphics2D ist subklasse von Graphics
 * 						
 * 		=> Graphics2D erm�glicht:		-> zeichnen beliebig geformter objekte			[vrgl. 	Graphics: 	-> beschr�nkte anzahl formen
 *										-> unterschiedliche strichst�rken						 			-> nur eine strichst�rke
 *										-> beeinflussung der kreuzungspunkte								-> nicht
 *										-> unterschiedliche linien-enden									-> nur eine art linien-enden
 *										-> verwendung von f�llmustern										-> keine, nur uni-farben	
 *									
 *		
 *		=> Graphics2D-objekt gibt's f�r methode:	 paint()	& 	paintComponent()
 *			
 * 	AUFRUF:	zur verwendung des Graphics2D-objekts durch:	getGraphics()	&	Type-cast auf Graphics2D
 * 
 * 				BSP:	 Graphics2D g2 = (Graphics2D) jPanelZeichenflaeche.getGraphics();
 * 
 * 	METHODEN V. GRAPHICS2D:		=> es gibt nur noch zwei grunds�tzliche methoden:			draw	&	fill
 * 								=> die �bergebenen parameterwerte (shape s) entscheiden jetzt �ber die geometrischen formen
 * 									-> die objekte der geom. formen bauen auf, auf dem:		Interface shape						
 * 														..& sind definiert im package:		java.awt.geom 
 * 
 * 		=>	METHODEN:							BESCHREIBUNG:
 * 		
 * 			void draw (Shape s)					zeichnet die umrisse der form s
 * 			void fill (Shape s)					zeichnet die form s ausgef�llt
 * 
 * 
 * 		JAVA.AWT.GEOM - WICHTIGE KLASSEN GEOM. FORMEN [die als parameter-wert/"Shape s" benutzt werden] :
 * 			
 * 			KLASSE:								BESCHREIBUNG:		
 * 			
 * 			Ellipse2D.Float						Ellipse, definiert durch li, obere ecke des umschliessenden rechtecks, breite und h�he
 * 			GeneralPath.Float					Polygon, definiert durch die St�tzpunkte		
 * 			Line2D.Float						linie, definiert durch anfangs- + endpunkte
 * 			Rectangle2D.Float					rechteck, definiert durch linke, obere ecke, breite + h�he
 * 			RoundRectangle2D.Float				abgerundetes rechteck, def. durch linke, obere ecke, breite + h�he
 * 			
 * 			=> all diese Klassen existieren auch als Klassen mit Double-genauigkeit (-> im Namen float durch double ersetzen)
 * 
 * 
 * 		METHODEN (V. GRAPHICS2D) F. LINIEN-STIL & F�LL-MUSTER:
 * 
 * 			METHODEN: 							BESCHREIBUNG:	
 * 
 * 			void setColor(Color c)				setzt zeichenfarbe auf farbwert c
 * 			void setStroke(BasicStroke bs)*		setzt linienart auf den linien-stil bs						*  erwartet objekt der klasse BasicStroke als parameterwert
 * 			void setPaint(Color c)				setzt das f�llmuster auf die farbe c
 * 			void setPaint(GradientPaint gp)**	setzt das f�llmuster auf das gradienten-f�llmuster gp		** erwartet objekt der klasse GradientPaint als parameterwert
 * 
 * 
 * 		* KLASSE BASICSTROKE:		=> beschreibt linienstil
 * 									=> wichtigste stil-elemente:	- linienst�rke:		with 	, typ float
 * 																	- linieneden:		CAP  	, typ int
 * 																	- kreuzungspunkte	JOIN 	, typ int	  
 * 			
 * 			KONSTANTEN VON BASICSTROKE F�R END- & SCHNITTPUNKTE:
 * 			
 * 			KONSTANTE:							BEDEUTUNG
 * 
 * 
 * 
 */

package uebungen13;

public class Graphics2D_API_Klasse_Methoden_Basics {

}
