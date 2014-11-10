/* TODO .7.2.3.   s.208
 * Bruch5 & GetterSetter_Bruch5
 * 
 * GETTER & SETTER -METHODEN:	- Zugriff (lesend & schreibend) von aussen auf Atributte die mit private geschützt sind mit setter & getter-methoden
 * 
 * 								- setter werden dann in den konstruktoren aufgerufen um den attributen die werte zuzuweisen
 * 
 * 								- auto-generierte getter&setter:	=> klasse markieren (re.klick)  ODER  menue	 ODER  attribut (re.klick) ...
 * 																				->... source - generate getters&setters
 * 
 * GETTER:			- lesender zugriff von aussen auf private-attribut
 * 
 * 					- methode gibt den wert des attributs zurück
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


 * VORTEILE V. PRIVATE  &  GETTER/SETTER:	1. innerhalb des setters können eingegebene werte nach bedarf auf zulässigkeit geprüft werden
 * (s. 209)										
 * 											2. fehlersuche wird vereinfacht 	=> setter gute position um kontrollausgaben zu setzen
 * 
 *  										3. interne andere strukturen verwenden, als sie nach aussen hin sichtbar erscheinen.
 *  
 *  										4. interne optimierungen werden erleichtert 	(bsp: bruch ungekürzt verwenden, aber gekürzt ausgeben)
 * 
 * kurz&knapp: wenn attribute private gesetzt sind brauchts getter&setter methoden für zugriff (lesend od. schreibend) von ausserhalb
 * getter & setter mit eclipse über anwählen - re-klick - quickfix, oder anwählen - re-klick - source - generate getter/setter
 */

package uebungen07;

import javax.swing.JOptionPane;

public class GetterSetter_Bruch5 {

	public static void main(String[] args) {
		// variabeln hier unnötig, auf einfachstem weg alles mit getter & setter gelöst, und werte werden durch Bruch5() initialisiert 
	
		// konstruktor & args
		Bruch5 b = new Bruch5();
		b.setZaehler(Integer.parseInt(JOptionPane.showInputDialog("Wert für Zähler eingeben")));
		b.setNenner(Integer.parseInt(JOptionPane.showInputDialog("Wert für Nenner eingeben")));
		System.out.println(b.getZaehler() + "/" + b.getNenner());
	}

}
