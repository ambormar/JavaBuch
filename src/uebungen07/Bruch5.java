/* TODO .7.2.3.   s.208
 * Bruch5 & GetterSetter_Bruch5
 * 
 * GETTER & SETTER -METHODEN:	- Zugriff (lesend & schreibend) von aussen auf Atributte die mit private gesch�tzt sind mit setter & getter-methoden
 * 
 * 								- setter werden dann in den konstruktoren aufgerufen um den attributen die werte zuzuweisen
 * 
 * 								- auto-generierte getter&setter:	=> klasse markieren (re.klick)  ODER  menue	 ODER  attribut (re.klick) ...
 * 																				->... source - generate getters&setters
 * 
 * GETTER:			- lesender zugriff von aussen auf private-attribut
 * 
 * 					- methode gibt den wert des attributs zur�ck
 * 
 * 			BSP: 									[ wenn:  private int zaehler; ]																				
 * 						 
 * 							public int getZaehler(){			// typ getAttributname() {return attribut}
 * 								return zaehler;					
 * 							}
 * 
 * 
 * 	  		AUFRUF:			b.getZaehler()		=>		aufrufbar aus einem beliebigen ausdruck (des testprogramms) wo der returnwert stehen kann	
 * 
 * 							getZaehler()  		=>		aufrufbar aus einem ausdruck des konstruktors derselben klasse wo der returnwert stehen kann
 * 						
 * 
 * SETTER:			- schreibender zugriff von aussen auf private-attribut
 * 
 * 					- methode weist dem private-attribut einen wert von aussen zu
 * 
 *   
 * 			BSP:									[ wenn:  private int zaehler; ]:				 
 * 
 * 							public void setZaehler(int z){		// void setAttributname(parametertyp bezeichner) {attribut = bezeichner}
 * 								zaehler = z;
 * 							}
 * 	
 * 
 * 	  		AUFRUF:			b.setZaehler(7)		=>		aufrufbar aus testprogramms untermitgabe eines wertes (vom richtigen typ)
 * 			
 * 							setZaehler(7)  		=>		aufrufbar aus konstruktor derselben klasse unter mitgabe eines wertes (vom richtigen typ)


 * VORTEILE V. PRIVATE  &  GETTER/SETTER:	1. innerhalb des setters k�nnen eingegebene werte nach bedarf auf zul�ssigkeit gepr�ft werden
 * (s. 209)										
 * 											2. fehlersuche wird vereinfacht 	=> setter gute position um kontrollausgaben zu setzen
 * 
 *  										3. interne andere strukturen verwenden, als sie nach aussen hin sichtbar erscheinen.
 *  
 *  										4. interne optimierungen werden erleichtert 	(bsp: bruch ungek�rzt verwenden, aber gek�rzt ausgeben)
 * 
 * kurz&knapp: wenn attribute private gesetzt sind brauchts getter&setter methoden f�r zugriff (lesend od. schreibend) von ausserhalb
 * getter & setter mit eclipse �ber anw�hlen - re-klick - quickfix, oder anw�hlen - re-klick - source - generate getter/setter
 */

package uebungen07;

public class Bruch5 {
	// private -> getter & setter zwingend f�r zugriff auf attribute/methoden
	private int zaehler;
	private int nenner;
	
	// weil ein eigener konstruktor definiert wurde .. 
	// ..braucht es einen parameterloser (= default) konstruktor der die attribute initialisiert
	Bruch5(){
		setZaehler(0);	// werte werden bei konstruktor-aufruf via methoden auf 0/1 (Bruch = 0) initialisiert
		setNenner(1);
	}
	
	Bruch5(int z, int n){
		setZaehler(z);	// werte werden bei konstruktor-aufruf auch �ber die methoden gesetzt 
		setNenner(n);
	}
	
	//getter & setter mit eclipse �ber anw�hlen - re-klick - quickfix, 
	// oder anw�hlen - re-klick - source - generate getter/setter
	public int getZaehler(){
		return zaehler;
	}
	
	public void setZaehler(int zaehler){
		this.zaehler = zaehler;	
	}


	public int getNenner() {
		return nenner;
	}

	public void setNenner(int nenner) {
		// bsp. zul�ssigkeit eines werts wird schon im setter gepr�ft
		if (nenner != 0){
			this.nenner = nenner;
		} else {
			System.out.println("Wert 0 ist f�r Nenner nicht zul�ssig");
		}
	} 
}
