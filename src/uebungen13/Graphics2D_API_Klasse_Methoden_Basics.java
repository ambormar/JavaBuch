/* TODO 13.2.4.   s.410,	 
 * Graphics2D_API_Klasse_Methoden_Basics
 * 
 * 		SIEHE ANGEWANDT:		13.2.4.   Graphics2D_JPanel_Komponente_ZumHineinZeichnen_Zeichnen3			s.413, oben
 * 
 * Graphics2D - JAVA 2D-API, BASICS:	=  Graphics2D ist subklasse von Graphics
 * 						
 * 		=> Graphics2D ermöglicht:		-> zeichnen beliebig geformter objekte			[vrgl. 	Graphics: 	-> beschränkte anzahl formen
 *										-> unterschiedliche strichstärken						 			-> nur eine strichstärke
 *										-> beeinflussung der kreuzungspunkte								-> nicht
 *										-> unterschiedliche linien-enden									-> nur eine art linien-enden
 *										-> verwendung von füllmustern										-> keine, nur uni-farben	
 *									
 *		
 *		=> Graphics2D-objekt gibt's für methode:	 paint()	& 	paintComponent()
 *			
 * 	AUFRUF:	zur verwendung des Graphics2D-objekts durch:	getGraphics()	&	Type-cast auf Graphics2D
 * 
 * 				BSP:	 Graphics2D g2 = (Graphics2D) jPanelZeichenflaeche.getGraphics();
 * 
 * 	METHODEN V. GRAPHICS2D:		=> es gibt nur noch zwei grundsätzliche methoden:			draw	&	fill
 * 								=> die übergebenen parameterwerte (shape s) entscheiden jetzt über die geometrischen formen
 * 									-> die objekte der geom. formen bauen auf, auf dem:		Interface shape						
 * 														..& sind definiert im package:		java.awt.geom 
 * 
 * 		=>	METHODEN:							BESCHREIBUNG:
 * 		
 * 			void draw (Shape s)					zeichnet die umrisse der form s
 * 			void fill (Shape s)					zeichnet die form s ausgefüllt
 * 
 * 
 * 		JAVA.AWT.GEOM - WICHTIGE KLASSEN GEOM. FORMEN [die als parameter-wert/"Shape s" benutzt werden] :
 * 			
 * 			KLASSE:								BESCHREIBUNG:		
 * 			
 * 			Ellipse2D.Float						Ellipse, definiert durch li, obere ecke des umschliessenden rechtecks, breite und höhe
 * 			GeneralPath.Float					Polygon, definiert durch die Stützpunkte		
 * 			Line2D.Float						linie, definiert durch anfangs- + endpunkte
 * 			Rectangle2D.Float					rechteck, definiert durch linke, obere ecke, breite + höhe
 * 			RoundRectangle2D.Float				abgerundetes rechteck, def. durch linke, obere ecke, breite + höhe
 * 			
 * 			=> all diese Klassen existieren auch als Klassen mit Double-genauigkeit (-> im Namen float durch double ersetzen)
 * 
 * 
 * 		METHODEN (V. GRAPHICS2D) F. LINIEN-STIL & FÜLL-MUSTER:
 * 
 * 			METHODEN: 							BESCHREIBUNG:	
 * 
 * 			void setColor(Color c)				setzt zeichenfarbe auf farbwert c
 * 			void setStroke(BasicStroke bs)*		setzt linienart auf den linien-stil bs						*  erwartet objekt der klasse BasicStroke als parameterwert
 * 			void setPaint(Color c)				setzt das füllmuster auf die farbe c
 * 			void setPaint(GradientPaint gp)**	setzt das füllmuster auf das gradienten-füllmuster gp		** erwartet objekt der klasse GradientPaint als parameterwert
 * 
 * 
 * 		* KLASSE BASICSTROKE:		=> beschreibt linienstil
 * 									=> wichtigste stil-elemente:	- linienstärke:		with 	, typ float
 * 																	- linieneden:		CAP  	, typ int
 * 																	- kreuzungspunkte	JOIN 	, typ int	  
 * 			
 * 			KONSTANTEN VON BASICSTROKE FÜR END- & SCHNITTPUNKTE:
 * 			
 * 			KONSTANTE:							BEDEUTUNG
 * 
 * 
 * 
 */

package uebungen13;

public class Graphics2D_API_Klasse_Methoden_Basics {

}
