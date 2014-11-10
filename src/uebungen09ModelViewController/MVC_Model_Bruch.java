package uebungen09ModelViewController;
/* TODO .9.5.2.   MVC, Model, eigenes bsp
 * class MVC_Model_Bruch & MVC_ViewFrame & MVC_Controller 
 * 
 * (Noch überarbeiten, zum laufen bringen, hier oben kommentieren/erklären wie MVC funktioniert, maja?)
 * SIEHE AUCH PAPER:	s.301	
 */



public class MVC_Model_Bruch {
	private int zaehler;
	private int nenner;

	public MVC_Model_Bruch(){
		zaehler = 0;
		nenner = 1;
	}
	
	public MVC_Model_Bruch(int z, int n){
		zaehler = z;
		nenner = n;
	}
	public int getZaehler() {
		return zaehler;
	}

	public void setZaehler(int zaehler) {
		this.zaehler = zaehler;
	}

	public int getNenner() {
		return nenner;
	}

	public void setNenner(int nenner) {
		this.nenner = nenner;
	}
	
	void kuerzen(){
		int z, n, r; 
		z = zaehler;
		n = nenner;
		r = z % n;
		while (r > 0){
			z = n;
			n = r;
			r = z % n;
		}
		zaehler = zaehler / n; 	
		nenner /= n;			
	}
}
