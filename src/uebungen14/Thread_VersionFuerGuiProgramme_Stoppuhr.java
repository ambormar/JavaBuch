/* TODO 14.2.2.   s.450, eigene Version stoppuhr für gui-programm  
 * class Thread_VersionFuerGuiProgramme_Stoppuhr
 * 
 * 		SIEHE:		14.2.2.   	Thread_Stoppuhr	&	StoppuhrTest			s.450, 1. Art Thread zu erstellen (=> extends Thread) 
 * 
 * 	K&K:	
 */

package uebungen14;

public class Thread_VersionFuerGuiProgramme_Stoppuhr extends Thread {	// ableiten einer eigenen Klasse von Thread	

	boolean startstop = true;
	
	// überschreiben der methode run()
	public void run(){					// methode run() wird hier so überschrieben, dass der Thread als stoppuhr, die sekunden, die seit seinem start vergangen sind, an der console ausgibt
		
		long zeit;
		long startzeit = System.currentTimeMillis() / 1000;
			while (startstop) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					break;
				}
				zeit = System.currentTimeMillis() / 1000 - startzeit;
				System.out.println(zeit);
			}
		
	}
	
	public void setStartstop(boolean startstop) {
		this.startstop = startstop;
	}
}
