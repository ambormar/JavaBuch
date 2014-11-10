/* TODO .7.2.1.   s.205
 * Bruch3 & Objekt_ObjektMultiplikationRichtig_FinalFalschAnwendung_Bruch3 (& Modifier Final, Private)
 * 
 * 
 * 
 * MODIFIER FINAL	s. class Final 	s.205		
 * 
 * OBJEKT-MULTIPLIKATION MIT OBJEKT :  - zaehler & nenner final als versuch, um objekte bei multiplikation nicht wieder zu �berschreiben
 * 
 * 									- hier bsp mit:	- final int zaehler, nenner;
 * 										-> sp�ter problem zur weiteren benutzung der methoden, weil werte fix (kuerzen() geht nicht etc.)
 * 
 * 									- also ein bsp, wie man final nicht nutzen soll
 * 										-> aber die multiplikation der objekte w�hre korrekt glaub (z.b. wenn man zaehler&nenner nicht final setzt)
 *
 *			final problem: L�SUNG:	PRIVATE int zaehler, nenner;
 * 
 * 					BSP TESTAUFRUF:	Bruch a = new Bruch(z, n);
 * 									Bruch b = new Bruch(z, n);
 * 
 * 									Bruch c = a.multipliziere(b); 		// erzeugung des objekts mit new erfolgt dann in der aufgerufenen methode
 * 
 * 					BSP Methode:	Bruch multipliziere(Bruch m){ 		// referentdatentyp methodenname(Objekttyp bezeichner)
										int z = zaehler * m.zaehler;
										int n = nenner * m.nenner;
										Bruch produkt = new Bruch(z, n); // erzeugung des Objekts von Bruch() mit lokalem namen produkt in der methode
										return produkt;					// returns (objekt) produkt
	}
 * 
 * eigtl. als schlechtes Bsp. f�r Modifier Final.
 * final sollte nur f�r sehr unver�nderliche konstanten wie Pi oder so verwendet werden.
 * z.b. ist hier keine methode zum k�rzen eines instanzierten Bruches m�glich, weil bruchwert final gesetzt ist
 */
package uebungen07;

import javax.swing.JOptionPane;

public class Bruch3 {
	// L�SUNG Private statt final; AUSPROBIEREN (SIEHE WERTE KONSOLE):  und objekt-multiplikation funktioniert richtig 
	// modifier final macht den wert des bereffenden attributs pro objekt unver�nderlich
	// d.h. wertzuweisung pro neues objekt f�r jede final variable nur einmal, dann unver�nderlich
	/* final */ private int zaehler;			// mit final funktioniert z.b. methode kuerzen() nicht 
	/* final */ private int nenner;
	
	// konstruktor initialisiert die final attribute (zaehler & nenner) via parameter auf z & n
	// einmal mit werten initialisiert sind die attribute pro instanz unver�nderlich 
	Bruch3(int z, int n){
		zaehler = z;
		nenner = n;
	}

	// die methode mit r�ckgabewert hat hier den referenzdatentyp (Bruch3) als datentyp 
	// in der methode durch aufruf des konstruktors ein neuer bruch3 erstellt und mittels referenzvariavle (produkt) returnt
	Bruch3 multipliziere(Bruch3 m){ // Bruch3 ist ein referenzdatentyp wie primitive datentypen (int, double)
		int z = zaehler * m.zaehler;
		int n = nenner * m.nenner;
		Bruch3 produkt = new Bruch3(z, n); // eine weitere instanz von Bruch3() f�r ergebnis(produkt) des bruches
		return produkt;
	}

	String bruchtoString(){
		return zaehler + "/" + nenner;
	}
	
	// methode kuerzen() funktioniert wenn zaehler & nenner private sind statt final
	void kuerzen() {
		 int rest, z, n;
		 z = zaehler;
		 n = nenner;
		 rest = z % n;
		 while (rest > 0){
			 z = n;
			 n = rest;
			 rest = z % n;
			 if (n == 1){				// wenn ggt 1 ist gezielt aus der methode aussteigen mit return & vorher (mit extrakommentar) 
				 JOptionPane.showMessageDialog(null,"der bruch kann nicht gek�rzt werden, sein GGT ist: 1");
				 return;					// ausstieg aus void-methode mit return bricht methode ab, auch ohne return-wert zur�ckzugeben;
			 } 								
		 }
		 zaehler /= n;
		 nenner /= n;
	}
}
