/* TODO 12.4.2.  -> eigene bemerkung
 * Repaint_PaintComponent_Graphics_G
 * 
 * 		SIEHE ANGEWANDT:		12.4.2.		ImageComponent		s.384
 * 
 *					paintComponent(Graphics g):		- die methode ist f�r das zeichnen von komponenten (jComponent / ImageComponent) zust�ndig. 
 * 														-> ihr wird ein objekt der klasse Graphics �bergeben. 
 * 
 * 				   	Klasse Grapics: 				- besitzt viele methoden zum zeichnen auf unterschiedlichsten ger�ten
 *				
 *				  	repaint(): 						= zum neuzeichnen von Componenten
 *				   									- innerhalb von repaint() wird glaub die methode paintComponent(Graphics g) automatisch aufgerufen
 *				   										-> ohne dass man zwangsl�ufig einen parameter f�r Graphics g selber mitgeben muss
 *				   											-> wird innerhalb von repaint() automatisch gemacht
 *
 *
 *		SIEHE AUCH: 	13.2.1   	 JPanel_Komponente_ZumHineinZeichnen_RadioGroup_getGraphics_Zeichnen2		s.403,		(2. ANSATZ)
 * 
 * 						Achtung:		repaint() nicht in der selben methode verwenden wo gezeichnet wird, sondern in extra methode oder von ausserhalb
 *  
 */ 

package uebungen12;

public class Repaint_PaintComponent_Graphics_G {

}
