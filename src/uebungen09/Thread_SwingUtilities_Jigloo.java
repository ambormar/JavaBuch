/* TODO .9.1,d.   s.257 
 * class Thread_SwingUtilities_Jigloo
 * 
 * THREAD (mit SwingUtilities parallelen Th. starten) SIEHE:		 Jigloo_Basics_CodeGenerieren_JFrame extends javax.swing.JFrame		s.256/257
 * 
 * 
 * CODE AUSZUG GROB:		public static void main(String[] args) {			// Main
 *								SwingUtilities.invokeLater(new Runnable() {		// neuer lauffähiger Thread ohne normale sequenz der ereignisbehandlung..
 *	  								public void run() {							// .. zu stören, wird erst am ende der ereignisbehndlung gestartet
 *		  								Klassenname inst = new Klassenname();	// konstruktor dieser (this) klasse aufrufen
 *										...										// inst.setvisible() & inst.setLocationRelativeTo
 *									}
 *								});	
 *							}
 *
 */
package uebungen09;

public class Thread_SwingUtilities_Jigloo {

}
