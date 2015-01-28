/* TODO 13.1.1   s.396,	
 * Graphics_Klasse_Basics_Paint_Repaint_Invalidate_Canvas_InKoponentenZeichnen2Ansaetze
 * 
 * 13.1. IN KOMPONENTEN ZEICHNEN
 * 
 * 13.1.1. GRUNDLAGEN DER GRAFIK-AUSGABE
 * 
 * 	LEERE KOMPONENTEN UM DRAUF ZU ZEICHNEN:
 * 
 * 		->	grafischen benutzeroberflächen stellen einer anwendung ein oder mehrere ausgabefenster zur verfügung.
 * 		  	diese prorammfenster müssen letztendlich immer durch das betriebssystem  auf dem bildschirm dargestellt werden.
 * 
 * 		->	der programmierer braucht eine komponente um darauf zu zeichenen. 
 * 		 	grundsätzlich kann man auf jeder sichtbaren komponente zeichnen, meistens aber wird dafür eine leere komponente gebraucht:
 * 
 * 		ZWEI LEERE CONTAINER-ARTEN:		=> als zeichenflächen 
 * 
 * 										-> die grundsätzliche vorgehensweise zur handhabung von FRAME + PANEL oder CANVAS ist gleich
 * 
 * 			1.  FRAME & PANEL (SWING-KOMPONENTEN):			
 * 				
 * 				=> PAINT-METHODE:	-> RUFT SELBST 3 METHODEN AUF (anders als bei CANVAS) :
 * 					
 * 										1. paintComponent()
 * 
 * 											- HIER: NORMALE ZEICHENOPERATIONEN UNTERBRINGEN, welche nur die Komponente selbst betreffen 
 * 
 *  									2. paintBorder()
 *  
 *  									3. paintChildren()
 * 				
 * 
 * 			2.  CANVAS (AWT-KOMPONENTE):		
 * 
 * 				=> PAINT-METHODE:	-> KANN ÜBERSCHRIEBEN WERDEN, ohne dass sich was an ihrer funktionalität ändert 
 * 
 * 
 * 
 * 	KLASSE GRAPHICS:	DEVICE-KONTEXT - UNIVERSELLES AUSGABE-GERÄT FÜR GRAFIK + SCHRIFT
 * 
 * 		-> die klasse Graphics ist ein sogenanter Device-Kontext, ein Ausgabe-gerät für grafik + schrift
 * 			
 * 		-> liefert METHODEN zur realisierung von:		- Linien-elementen
 *														- Füll-elementen für flächen
 *														- Text-elementen 		-> inklusive verwaltung von Zeichenfarbe + Schriftart
 *					
 *									
 *
 *	METHODE PAINT():	=> jede sichtbare Komponente einer grafischen Oberfläche besitzt eine methode paint() 
 *
 *		-> übernimmt das eigentliche zeichnen,
 *		-> wird immer aufgerufen wenn eine komponente dargestellt werden muss
 *		-> aufruf sehr oft nötig, immer wenn Komponente irgendwie verändert / erneuert wird
 *														
 * 		=> das BETRIEBSSYSTEM erteilt bei aktualisierungen einer komponente nur den auftrag zum zeichnen
 * 			-> das zeichnen selbst übernimmt die jeweilige paint-methode der betroffenen komponente
 * 
 * 
 * 
 * 	METHODE REPAINT():	=> zum aktiven NEUZEICHNEN einer komponente seitens des programmierers repaint() aufrufen, NICHT paint().
 * 
 * 		-> repaint() löst dann direkt oder indirekt paint() aus
 * 		-> bei AWT-komponenten ist eine update-methode zwischen geschaltet [repaint() -> update() -> paint()] 
 * 		
 * 		MEHRERE VERSIONEN VON REPAINT:
 * 
 * 		- repaint() 							-> sofortiges neuzeichnen
 * 		- repaint( milisekunden)				-> neuzeichnen nach x milisekunden
 * 		- repaint( bereich )					-> neuzeichnen eines bestimmten bereichs (
 * 													-> führt teilweise zu inkonsistenzen zwischen neugezeichnetem + nicht-neugez. bereich 	=>  invalidate() 
 * 
 * 
 * 
 * 	METHODE INVALIDATE():	=> komponente ungültig erklären 
 * 							-> sicherstellen dass der gesamte bereich der komponente b. näxten mal neugezeichnet wird
 * 
 * 
 *  2 ANSÄTZE ZUM ZEICHNEN IN EINE STANDARD-KOMPNENTE:
 *  
 *  		1. PANEL-KOMPONENTE MIT VERÄNDERTEM AUSSEHEN:
 *  			-> komponente, die sich ein wenig vom aussehen der standard-komponente unterscheidet
 * 
 * 				SIEHE: 		13.1.2		PanelKomponente_MitVerändertemAussehen			s.398
 * 
 * 			2. ZEICHNEN IN EINE STANDARD-KOPMONENTE: 
 * 				-> standard-komponente verwenden, deren aussehen sich während der laufzeit aber immer wieder verändern lässt.
 * 
 * 				SIEHE:		13.2		StandardKopmonenten_ZumHineinZeichnen			s.403
 * 
 * 
 */

package uebungen13;

public class Graphics_Klasse_Basics_Paint_Repaint_Invalidate_Canvas_InKoponentenZeichnen2Ansaetze {

}
