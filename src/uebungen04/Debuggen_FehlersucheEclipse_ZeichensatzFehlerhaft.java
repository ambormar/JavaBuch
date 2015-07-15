package uebungen04;

/* TODO .4.3.2.   s.153 (bsp:151)
 * class Debuggen_FehlersucheEclipse_ZeichensatzFehlerhaft
 * 
 * fehlerhaftes programm zur Zeichensatzausgabe. (alle unicode buchstaben zur zahl 30 bis 127 sollen ausgegeben werden)
 * mit debugger nach fehler suchen. fehler ist zahlen�berlauf weil byte zahl (geht nur bis +127)  statt int zahl. so endet die whileschleife nicht.
 * 
 * 
 * FEHLER: in der konsole ersichtlich		s.152		kein ergebnis & Rotes Terminateschalter (aktiv) rechts im menue der Konsole => endlos-schleife
 * 														=> roter Terminateschalter -> endlosschleife stoppen
 *  
 *  
 * D E B U G G E N (kurzanleitung): 		ab	s.153	(debuggen f�r dieses programm siehe quellcode)
 * 
 * - BREAKPOINTS (haltepunkte) setzen			s.153	mit Doppelklick (setzen & entfernen) auf blauen streifen am linken rand des codeeditors:
 * 														=> Aktiver Breakpoint (= Blauer runder Punkt) -> rechtsklick f�r disable / enable breakpoint
 * 														-> deaktivierter Haltepunkt (= weisser kreis)
 * 														=> breakpoint vor die zu untersuchende programmzeile setzen (hier: while)
 * 
 * - K�FER (Menu RUN) - DEBUG AS - JAVA APPL.	s.154	-> wechselfenster f�r debug-perspektive: yes (ansicht switchen ok, oben re: java <-> debug)
 * 														=> programm l�uft bis vor Breakpoint & wird eingefroren (vor ausf�hrung der anweisg. dieser zeile)
 * 
 * - VARIABEL- (Breakpoint-) FENSTER kucken		s.156	=> Variabel-Namen und ihre werte kontrollieren -> im Fenster oben rechts
 * 														 (-> sind die werte der variabeln so, wie sie zum eingefrorenen zeitpunkt des prog. sein sollen?)
 * 	
 * - DEBUG-MEN�-LEISTE (oben)					s.156	- Resume (gr�ner pfeil) = Progr. bis zum n�xten Breakpoint od. ende weiterlaufen lassen		
 * 	(programm geziehlt weiter laufen lassen) 			- Suspend (pause)		= unterbricht laufendes progr. (wie ein breakp.)
 * 																				-> gut z.b bei endlos-schleifen, ohne ganz abzubrechen
 * 														- Terminate (rot stop)	= bricht progr. ab
 * 
 * 				-STEP-BEFEHLE (selbe leiste)	s.157	- Step over (gelb pfeili re) = 'schritt f�r schritt'-ausf�hrung ab markierter zeile/anweisung
 * 				(sofern progr. unterbrochen)			- Step into (gelb pfeili li) = nur bei Methodenaufruf:  
 * 																						- 'schritt f�r schritt'-ausf�hrung ab markierter zeile/anweisung									
 * 																						- 1. schritt verzweigt in die aufgerufene methode
 * 					
 * 			- weitere befehle:	[(nur im menue run:)	- Step into selection	= springt in eine zuvor im quellcode markierte methode (siehe s. 157)]
 * 													[	- Use step filters (gelbes verzweigpfeili)	= methoden ausfiltern: buch s.157 (step witch filters)]
 * 														
 * 														- step return (weisses pfeili) 	= programmausf�hrg. innerhalb einer methode bis return 
 * 														- run to line (run menue)		= f�rt programm bis zur zuvor markierten zeile aus
 * 
 *  
*/

import javax.swing.JOptionPane;

public class Debuggen_FehlersucheEclipse_ZeichensatzFehlerhaft {	// programm spinnt beim laufen lassen: siehe konsole

	public static void main(String[] args) {
		byte zahl = 30;								// byte: versteckte fehlerquelle (geht nur von -128 bis +127)
		String zeichensatz = "";
		while(zahl < 128){							// breakpoin setzen -> debugen bis vor while -> variabelwerte oben kontrollieren, bis dahin ok ...
			zeichensatz = zeichensatz + (char) zahl;// ..=> mit Gr�npfeiltaste (= bis n�xt breakpoint): 127-mal die while-schleife ausf�hren	 
			zahl++;									// ..=> beim 128sten mal springt der wert von zahl nicht auf 128, sondern auf -128 
			System.out.println(zeichensatz);		// ..=> ist ein zahlen�berlauf und f�hrt zu endlosschleife !!!
		}											// .. -> korrektur: int zahl statt byte zahl	
		JOptionPane.showMessageDialog(null, zeichensatz);	
		
	}
}
