package uebungen09ModelViewController;
/* TODO .9.5.2.   MVC, Controller, eigenes bsp
 * class MVC_Model_Bruch & MVC_ViewFrame & MVC_Controller
 * 
 * (Noch �berarbeiten, zum laufen bringen, hier oben kommentieren/erkl�ren wie MVC funktioniert, maja?)
 * SIEHE AUCH PAPER:	s.301	
 */



import javax.swing.SwingUtilities;

public class MVC_Controller {
	private MVC_Model_Bruch bruch;			// variable f�r sp�tere instanzierung der klasse Bruch 
	private MVC_ViewFrame viewFrame;	// variable f�r sp�tere instanzierung der klasse ViewFrame
	
	public static void main(String args[]){			// starter methode...
		MVC_Controller controller = new MVC_Controller(); 	// ...muss zuerst eine instanz der eigenen klasse (controller)/ von sich selber erstellen
		
	}
	
	public MVC_Controller(){			// konstruktor zur instanzierung der klasse
		bruch = new MVC_Model_Bruch();		// objektinstanz der klasse Bruch desselben packages
		
		SwingUtilities.invokeLater(new Runnable() {  // objektinstanz der Klasse ViewFrame in einem 2. thread erstellen
			public void run() {
				viewFrame = new MVC_ViewFrame(); 		// �bergabe des controllers (also von sich selbst) an das neu erzeugte viewFrame
				viewFrame.setLocationRelativeTo(null);
				viewFrame.setVisible(true);
			}
		});
		viewFrame.setController(this);
		
	}
}
