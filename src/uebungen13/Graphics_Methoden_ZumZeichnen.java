/* TODO 13.1.2.   s.401,
 * Graphics_Methoden_ZumZeichnen
 * 
 * 			SIEHE AUCH:		13.1.1   	Graphics_Klasse_Basics_Paint_Repaint_Invalidate_Canvas_InKoponentenZeichnen2Ansaetze			s.396,	
 * 
 * 
 * 	KLASSE GRAPHICS:		DEVICE-KONTEXT - UNIVERSELLES AUSGABE-GERÄT FÜR GRAFIK + SCHRIFT
 * 
 * 							-> die klasse Graphics ist ein sogenanter Device-Kontext, ein Ausgabe-gerät für grafik + schrift
 * 			
 * 							-> liefert METHODEN zur realisierung von:		- Linien-elementen
 *																			- Füll-elementen für flächen
 *																			- Text-elementen 		-> inklusive verwaltung von Zeichenfarbe + Schriftart
 *
 *
 *	METHODEN (ZUM ZEICHNEN) VON GRAPHICS G:				= überblick über die wichtigsten zeichenmethoden der klasse Graphics 
 *														
 *														-> positionsangaben x, y beschreiben grundsätzlich linke obere ecke
 *															-> bei runden / abgerundeten objekten die li, obere ecke des umschreibenden rechtecks des objekts
 *
 *														**  mit hilfe des clipping-bereichs kann man zeichenbereich einschränken, objekte werden dann nur im aktuellen clipping-bereich sichtbar.
 *
 *
 *		METHODE:																				BESCHREIBUNG:
 *
 *		void clearRect(int x, int y, int width, int height)										füllt den angegebenen bereich mit der eingestellten hintergrundfarbe
 *
 *		void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle) 		zeichnet einen bogen der angegebenen position und grösse
 *
 *		void drawLine(int x1, int y1, int x2, int y2)  											zeichnet eine line von x1, y1 nach x2, y2
 *
 *		void drawOval(int x, int y, int width, int height) 										zeichnet ein oval an der poition x,y mit den angegebenen abmessungen
 *
 *		void drawPolygon(int[] xPoints, int[] yPoints, int nPoints)  							zeichnet einen polygon
 *
 *		void drawPolyline(int[] xPoints, int[] yPoints, int nPoints) 							zeichnet einen linienzug mit den als arrays angegebenen stüztpunkten
 *
 *		void drawRect(int x, int y, int width, int height)  									zeichnet rechteck mit der angegebenen pos und grösse
 *
 *		void drawRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight)  	zeichnet ein rechteck mit abgerundeten ecken, die rundungen entsprechend arcwitdh, archeight
 *
 *		void drawString(String str, int x, int y) 												zeichnet text mit der aktuellen zeichenfarbe und schriftart an der pos x,y
 *
 *		void fillArc(int x, int y, int width, int height, int startAngle, int arcAngle) 		ist wie drawArc mit der aktuellen zeichenfarbe ausgefüllt
 *
 *		void fillOval(int x, int y, int width, int height)  									wie drawOval, mit der akt zeichenfarbe gefüllt
 *
 *		void fillPolygon(int[] xPoints, int[] yPoints, int nPoints) 							wie drawPolygon , mit der akt. zeichenfarbe gefüllt
 *
 *		void fillRect(int x, int y, int width, int height)  									wie drawRect, mit der akt. zeichenfarbe gefüllt
 *
 *		void fillRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) 	wie drawRoundRect, mit der akt zeichenfarbe gefüllt
 *
 *		Rectangle getClipBounds()  																liefert den aktuellen clipping-bereich zurück	**	(=> einschränken des zeichenbereichs)
 *
 *		void setClip(int x, int y, int width, int height)  										setzt den neuen clipping-bereich	** 
 *
 *		Color getColor()																		gibt die akt. zeichenfarbe zurück	
 *
 *		void setColor(Color c)																	setzt die akt. zeichenfarbe
 *
 *		Font getFont()																			liefert die akt. schriftart
 *
 *		void setFont(Font font)																	setzt die akt. schrift-art
 *
 */

package uebungen13;

public class Graphics_Methoden_ZumZeichnen {

}
