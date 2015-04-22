/* TODO 14.2.2.   s.450, 1. Art Thread zu erstellen (extends Thread) !!!!!!!!!!!
 * class Thread_Stoppuhr	&	StoppuhrTest
 * 
 * 
 * 
 */ 

package uebungen14;

public class Thread_Stoppuhr extends Thread {
	
	// überschreiben der methode run()
	public void run(){					// methode run() wird hier so überschrieben, dass der Thread als stoppuhr, die sekunden, die seit seinem start vergangen sind, an der console ausgibt
		long zeit;
		long startzeit = System.currentTimeMillis() / 1000;
			while (true) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					break;
				}
				zeit = System.currentTimeMillis() / 1000 - startzeit;
				System.out.println(zeit);
			}
		
	}

}
