/* TODO .9.1.3.   s.258
 * Klasse JFrame_WindowConstants_SetDefaultCloseOperation
 *
 * SIEHE AUCH:		9.1.	class Jigloo_Basics_CodeGenerieren_JFrame 	s.256
 *
 * JFRAME:	- Mögliche Konstanten zum Schliessverhalten (bei betätigung des X vom frame)
 * 
 * 			BSP:		initGUI(){
 * 							...
 * 							setDefaultCloseOperations(WindowConstants.DISPOSE_ON_CLOSE);
 * 							...
 * 						}
 * 
 * 			KONSTANTE:						BESCHREIBUNG:	
 * 
 * 			DO_NOTHING_ON_CLOSE				keine aktion, fenster schliesst nicht, erst wenn allfällig übergeordnetes fenster geschlossen wird
 * 
 *  		HIDE_ON_CLOSE					frame wird unsichtbar gemacht, bleibt im speicher & kann wieder sichtbar gemacht werden
 *  
 *  		DISPOSE_ON_CLOSE				frame wird geschlossen & aus speicher entfernt
 *  
 *  		EXIT_ON_CLOSE					schliesst frame und beendet programm mit system.exit(0)		
 * 
 */
package uebungen09;

public class JFrame_WindowConstants_SetDefaultCloseOperation {

}
