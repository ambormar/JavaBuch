/* TODO .9.1,b.   s.256 
 * class InitGui_InitialisierungsMethode_initSonstwas
 * 
 * Init():													= im gegensatz/vergleich zu InitGui(), InitSonstwas()...
 * (noch überarbeiten, maja?)
 * 															-> wird anstelle der main-methode gebraucht	bei java-applets
 * 
 * 															- siehe auch 9.1c. Init_BeiJavaApplets_AnstelleVonMain (noch überarbeiten)
 * 
 * 
 * InitGUI(), InitSONSTWAS(),  INITIALISIERUNGS-METHODEN:	= Initialisierungs-Methode irgendeiner klasse 
 * 
 * 															-> beinhaltet grundlegende eigenschaften einer klasse für deren programmstart
 * 
 * 															- siehe auch:	9.1.	class Jigloo_Basics_CodeGenerieren_JFrame 	s.256

 * 			BSP: 	= initGUI() von JFrame (Jigloo) wird hier in der erbenden klasse überschrieben:
 * 					= initGUI() initialisiert die grafische benutzeroberfläche
 * 
 * 				public class Beispiel extends javax.swing.JFrame {
 * 
 * 					public static void main(String[] args) {				// main
 *						SwingUtilities.invokeLater(new Runnable() {			// invokeLater(): start am ende des programm-ablaufs
 *	  						public void run() {								// new Runnable(): konstruktor um neuen thread zu starten 
 *		  						Beispiel inst = new Beispiel();				// konstruktor dieser klasse aufrufen
 *								...											
 *							}
 *						});	
 *					}
 *
 *					public Beispiel() {			// konstruktor dieser klasse (subklasse)
 *						super();				// zugriff auf methoden der superklasse (hier: JFrame)
 *						initGUI();				// zugriff auf initGUI()-methode dieser klasse (überschreibt initGUI() der superklasse)
 *					} 
 * 
 * 					private void initGUI() {	// initialisierungs-methode fürs GUI (überschreibt initGUI() der superklasse)
 *						try {					// ...definiert alle grundlegenden eigenschaften vom GUI  
 *							...					// ...beinhaltet alle komponenten (buttons, textfields etc.)
 *						} catch (Exception e) {..}		// error handling
 *					}
 *				)
 */
package uebungen09;

public class InitGui_InitialisierungsMethode_initSonstwas {

}
