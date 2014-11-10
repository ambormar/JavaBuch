package uebungen01;

/* TODO .1.1.4,   s.23
 * class Klasse_AufbauAb_Struktogramm_Zahlraten
 * 
 * Bsp für aufbau einer klasse & implementieren (realisieren v. code) folgend einem nassischneidermann-struktogramm bzw. pap (programmablaufplan).
 * 
 * design-technisch wichtige anmerkung zum aufbau von programmen: 	siehe ca. zeile 62
 * 																  	sauberen aufbau von diesem programm evtl. mal noch machen
 * 
 * Generelles schema nach häsli:
 * 		- Imports
 * 		- class mit:	- Variabeln
 * 						- konstruktor (spezielle methode)
 * 						- methoden
 */

// import	(libraries bzw. Java-Klassen importieren)
import javax.swing.JOptionPane; 	// klasse für meldefelder 
import java.util.Random;			// klasse um zufallszahl zu ermitteln

// klasse
public class Klasse_AufbauAb_Struktogramm_Zahlraten {
	
	// variablen 	(private variabeln der klasse)
	private int zufallszahl;	
	private int ratezahl;
	
	// konstruktor: - jede klasse hat einen konstruktor
	//				- konstruktor macht bei aufruf eine instanz der klasse (aufruf z.b. in der main-methode)
	//				- konstruktor ist einzige methode mit grossbuchstaben & heisst gleich wie die klasse
	//				- konstruktor macht instanz von ganzer klasse & erwünschten variablen wird ein wert zugewiesen (alle anderen variablen haben zufallswerte)
	public Klasse_AufbauAb_Struktogramm_Zahlraten() {	
		ratezahl = -1;		// ratezahl auf einen nicht relevanten wert setzen
		zufallszahl = 0;	// zufallszahl auf einen nich trelevanten wert setzen
	}
	
	// methoden: 			bestimmen, was mit der instanz einer klasse gemacht werden kann
	// getter & setter: 	lesen und setzen der private variabeln der klasse
	public int getZufallszahl() {	// getter mit datentyp um wert zu erfragen 
		return zufallszahl;			// return variabelname: gibt wert zurück
	}

	public void setZufallszahl(int zz) {	// setter void und mit parameter (datentyp & verfallender variabelname (zz)) um wert zu setzen
		zufallszahl = zz;					// (obige) variabel = typ und (verfallender)variabelwert aus parameter
	}

	public int getRatezahl() {
		return ratezahl;
	}

	public void setRatezahl(int rz) {
		ratezahl = rz;
	}

	// main methode für programm-start, programm kann mehrere klassen haben, mindestens eine davon muss main-methode haben um programm zu starten 
	public static void main(String[] args) {
		
		// konstruktor-aufruf & erstellen einer neuen Instanz der Klasse ..._Zahlraten
		Klasse_AufbauAb_Struktogramm_Zahlraten spiel; 			// instanzvariabel spiel des typs Zahlraten deklarieren (wie z.b. String xy;)
		spiel = new Klasse_AufbauAb_Struktogramm_Zahlraten();	// neue Instanz der Klasse Zahlraten erstellen & der Variabel spiel (mit typ Zahlraten) zuweisen 
																	// kurzform wäre:	Konstruktor instanzvariabel = new Konstruktor()
		
		/* kurzer design-technischer einschub zum aufbau von programmen:
		 * eigentlich würde man die meisten programmabläufe, wie variablen und schleifen etc. ausserhalb der main-methode in den klassen unterbringen,
		 * bei schleifen u.ä. in form von methoden. und diese methoden dann in der main-methode nur noch aufrufen als instanz.methode() [hier: spiel.methode()].
		 * also könnte hier fast das gesammte folgende programm besser ausgelagert werden in die klasse selber.
		 * allerdings gibt's dazu keine fixen regeln, solagnge es funktioniert.
		 */
		
		boolean geraten = false;	// variabel typ boolean erzeugen & auf wert false setzen
		int versuchszaehler = 0; 	// variabel typ int erzeugen & auf wert 0 setzen (variabel zählt die anzahl versuche) 
		
		JOptionPane.showMessageDialog(null, "Erraten sie eine ganze Zahl zwischen 1 und 100!"); // message-fenster aufpoppen lassen (import!!)
		Random randomGenerator = new Random();	//  neue Instanz der Klasse Random erstellen & der Variabel randomGenerator (mit typ Random) zuweisen 
												
		spiel.setZufallszahl(randomGenerator.nextInt(101)); // via setter(parameter)von spiel zufallszahl setzen
															// methode nextInt() der Klasse Random ist eine Instanzmethode und keine Klassen-methode..
															// ... desshalb muss man zuerst eine Instanz der Klasse erstellen und kann dann erst die methode
															// ... anwenden. alternativ die Klasse Math: [ spiel.setZufallszahl((int) Math.random()*100+1); ]
															// ... mit der klassenmethode:  public static(!!) double random() ,die man mit: Klasse.Methode() 
															// ... alleine aufrufen kann, ohne zuerst ein instanz der Klasse zu erzeugen
		while(!geraten) {		// solange klammerinhalt true ist läuft die schleife (geraten ist oben absichtlich auf false damit !false = true und damit while-schleife laufen kann)
								// solange !geraten: ausführen: absichtlich semantisch gelöst, damit's mit unserer sprache übereinstimmt (man könnts auch genausogut umgekehrt lösen und die variable nichtgeraten taufen)
			
			spiel.setRatezahl(Integer.parseInt(JOptionPane.showInputDialog("Bitte geben sie eine Zahl ein!"))); // ratezahl via messagefeld & setter eingeben
			versuchszaehler++; 	//	anzahl versuche um eins erhöhen mittels inkrement
			
			// verschachtelte if-schleifen für: zahl zu klein, zahl zu gross, zahl erraten
			if (spiel.getRatezahl() < spiel.getZufallszahl()) {					// falls (mit getter abgerufene ratezahl < als mit getter abgerufene zufallszahl)..
				JOptionPane.showMessageDialog(null, "Ihre Zahl ist zu klein!");	// ... messageausgabe: zahl zu klein
			} else {
				if (spiel.getRatezahl() > spiel.getZufallszahl()){					// falls (mit getter abgerufene ratezahl > als mit getter abgerufene zufallszahl)..
					JOptionPane.showMessageDialog(null, "Ihre Zahl ist  zu gross");	// ... messageausgabe: zahl zu gross
				}else{					// sonst: zahl erraten
					geraten = true; 	// geraten auf true setzen um schleifendurchlauf abzubrechen (->  while (!true){}  while (false) {} -> schleife stoppt
					JOptionPane.showMessageDialog(null, "glückwunsch sie haben die Zahl mit " + versuchszaehler + " Versuchen erraten!");
				}						// message ausgabe inklusive angabe der anzahl versuche (versuchszaehler)
			}
		}
	}
	
}
