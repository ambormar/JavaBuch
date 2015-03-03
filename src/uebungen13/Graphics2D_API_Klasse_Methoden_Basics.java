/* TODO 13.2.4.   s.410,	 
 * Graphics2D_API_Klasse_Methoden_Basics
 * 
 * 		SIEHE ANGEWANDT:		13.2.4.   Graphics2D_JPanel_Komponente_ZumHineinZeichnen_Zeichnen3			s.413, oben	(2. ANSATZ)  mit Graphics2D;  OHNE REPAINT() bei frameveränderungen
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
 * 			BSP+:	 	Graphics2D g2 = (Graphics2D) jPanelZeichenflaeche.getGraphics();					// BSP+ = Zusammenhängende BSPe
 * 
 * 
 * 	METHODEN V. GRAPHICS2D:		=> es gibt nur noch zwei grundsätzliche methoden:			draw	&	fill
 * 								=> die übergebenen parameterwerte (shape s) entscheiden jetzt über die geometrischen formen
 * 									-> die objekte der geom. formen bauen auf, auf dem:		Interface shape						
 * 														..& sind definiert im package:		java.awt.geom 
 * 
 * 			METHODEN:							BESCHREIBUNG:
 * 		
 * 			void draw (Shape s)					zeichnet die umrisse der form s
 * 			void fill (Shape s)					zeichnet die form s ausgefüllt
 * 
 * 			BSP+:		g2d.fill(rechteck);																	// g2d => siehe oben;	rechteck => siehe unten
 * 
 * 
 * 	JAVA.AWT.GEOM - WICHTIGE KLASSEN GEOM. FORMEN [die als parameter-wert/"Shape s" benutzt werden] :
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
 * 			BSP+:		Rectangle2D.Float rechteck = new Rectangle2D.Float(x1,y1,x2,y2);					// 
 * 
 * 
 * 	METHODEN (V. GRAPHICS2D) F. LINIEN-STIL & FÜLL-MUSTER:
 * 
 * 			METHODEN: 							BESCHREIBUNG:	
 * 
 * 			void setColor(Color c)				setzt zeichenfarbe auf farbwert c
 * 			void setStroke(BasicStroke bs)*		setzt linienart auf den linien-stil bs						*  erwartet objekt der klasse BasicStroke als parameterwert
 * 			void setPaint(Color c)				setzt das füllmuster auf die farbe c						   
 * 			void setPaint(GradientPaint gp)**	setzt das füllmuster auf das gradienten-füllmuster gp		** erwartet objekt der klasse GradientPaint (oder d. klasse color) als parameterwert
 * 
 * 			BSP+:		g2d.setColor(Color.red);
 * 
 * 
 * 		* KLASSE BASICSTROKE:		=> beschreibt linienstil
 * 									=> konstruktor erwartet folgende stil-elemente als parameterwerte:					// siehe bsp+ unten
 * 																	- linienstärke:		width 	, typ float
 * 																	- linieneden:		CAP  	, typ int
 * 																	- kreuzungspunkte:	JOIN 	, typ int	  
 * 			
 * 			KONSTANTEN VON BASICSTROKE FÜR END- & SCHNITTPUNKTE:
 * 			
 * 			KONSTANTE:							BEDEUTUNG
 * 
 * 			CAP_BUTT							keine endpunkte
 * 			CAP_ROUND							runde endpunkte
 * 			CAP_SQUARE							quadratische endpunkte
 * 			JOIN-MITER							die äusseren kanten werden bis zum schnittpunkt verlängert
 * 			JOIN_ROUND							die äusseren kanten werden abgerundet
 * 			JOIN_BEVEL							die äusseren ecken werden abgerundet (abgeschrägt)
 *
 * 			BSP+:		BasicStroke stil = new BasicStroke(30.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);		// stil-elemente als parameterwerte
 *						g2d.setStroke(stil);
 *
 *		** KLASSE GRADIENTPAINT:	=> für Farbverlauf
 *									=> konstruktor erwartet folgende die parameterwerte:
 *																	- koordinaten von 2 punkten	(punkte können ausserhalb d. zu färbenden fläche liegen)
 *																	- pro punkt eine farbe
 *																	- true / false ob farbwechsel wiederholt wird (falls fläche grösser ist)
 *
 *			BSP+:		GradientPaint fuellung = new GradientPaint(0,0,Color.yellow,100,100,Color.red, true);
 *						g2d.setPaint(fuellung);
 *
 */

package uebungen13;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.geom.Rectangle2D;

public class Graphics2D_API_Klasse_Methoden_Basics {

}
