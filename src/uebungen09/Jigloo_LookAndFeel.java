/* TODO .9.3.7b   s.277
 * Jigloo_LookAndFeel
 * 
 * SIEHE:		in 9.3.1 - 9.3.13.   JKomponenten_ActionListenerUSW_GUIFahrenheitCelsius		ab s.265:		=>	9.3.7b LOOK & FEEL
 * 						
 * 
 * 9.3.7b LOOK & FEEL:	= anderes aussehen fürs GUI  (s.277):
 * 								-> re-klick auf komponente in der vorschau-ansicht > set look & feel > versch. looks auswählen
 * 						- umstellen der L&F-voreinstellungen:	Menü > Window > Preferences > Jigloo GUI Builder > Look & Feel	
 * 
 * 
 * IMPORT:	ist glaub der der im code drin ist hier: javax.swing.UIManager
 * 
 * CODE: 	
 * 			{
				// Set Look & Feel
				try {
					javax.swing.UIManager
							.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
 * 
 */

package uebungen09;

public class Jigloo_LookAndFeel {

}
