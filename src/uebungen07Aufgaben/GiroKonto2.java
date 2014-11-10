/* TODO .7.4.   Aufgabe 2, s.219
 * Klasse Konto2 & GiroKonto2 & Vererbung_GiroKonto2Test
 *
 * vererbung, konstruktoren, getter & settermethoden, 
 * mit super() im konstruktor der subklasse den zu erbenden konstruktor der superklasse aufrufen
 */

package uebungen07Aufgaben;

public class GiroKonto2 extends Konto2 {
	private double limit; 	// gibt an welche kreditlimite bei auszahlen() zur verfügung steht
	
	// default-konstruktor
	public GiroKonto2(){  //default-konstruktor ohne parameter
		super(); // im konstruktor der subklasse den zu erbenden konstruktor der superklasse aufrufen
	}
	// konstruktor mit parametern
	public GiroKonto2(String knr, double kst, double li){
		super(knr, kst);
		setLimit(li);
	}
	// methode auszahlen() überschreiben, dass nur abgehoben wird wenn kreditlimit nicht überschritten
	public void auszahlen(double abhebung){
		if ((super.getKontostand() - abhebung) >= getLimit() * (-1)){ 	// wenn kontostand + limit >= abhebung wird abgehoben via superklasse 
			super.auszahlen(abhebung);										// oder auch (super.getKontostand() + getLimit() >= abhebung)
		} else {
			System.out.println("Fehler: Kreditlimit \u00FCberschritten");
		}
	}
	
	public double getLimit() {
		return limit;
	}

	public void setLimit(double li) {
		limit = li;
	}
}
