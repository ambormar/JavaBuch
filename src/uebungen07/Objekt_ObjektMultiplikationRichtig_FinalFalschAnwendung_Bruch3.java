/* TODO .7.2.1.   s.205
 * Bruch3 & Objekt_ObjektMultiplikationRichtig_FinalFalschAnwendung_Bruch3 (& Modifier Final, Private)
 * 
 * 
 * 
 * MODIFIER FINAL	s. class Final 	s.205		
 * 
 * OBJEKT-MULTIPLIKATION MIT OBJEKT :  - zaehler & nenner final als versuch, um objekte bei multiplikation nicht wieder zu überschreiben
 * 
 * 									- hier bsp mit:	- final int zaehler, nenner;
 * 										-> später problem zur weiteren benutzung der methoden, weil werte fix (kuerzen() geht nicht etc.)
 * 
 * 									- also ein bsp, wie man final nicht nutzen soll
 * 										-> aber die multiplikation der objekte währe korrekt glaub (z.b. wenn man zaehler&nenner nicht final setzt)
 *
 *			final problem: LÖSUNG:	PRIVATE int zaehler, nenner;
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
 * eigtl. als schlechtes Bsp. für Modifier Final.
 * final sollte nur für sehr unveränderliche konstanten wie Pi oder so verwendet werden.
 * z.b. ist hier keine methode zum kürzen eines instanzierten Bruches möglich, weil bruchwert final gesetzt ist
 */

package uebungen07;

import javax.swing.JOptionPane;

public class Objekt_ObjektMultiplikationRichtig_FinalFalschAnwendung_Bruch3 {

	public static void main(String[] args) {
		String eingabe;
		int z, n;
		
		// eingabe-werte & instanzierung bruch3 a
		eingabe = JOptionPane.showInputDialog("Zähler von Bruch a eingeben: ");
		z = Integer.parseInt(eingabe);
		eingabe = JOptionPane.showInputDialog("Nenner von Bruch a eingeben: ");
		n = Integer.parseInt(eingabe);
		Bruch3 a = new Bruch3(z, n);
		
		// eingabe-werte & instanzierung bruch3 b
		eingabe = JOptionPane.showInputDialog("Zähler von Bruch b eingeben: ");
		z = Integer.parseInt(eingabe);
		eingabe = JOptionPane.showInputDialog("Nenner von Bruch b eingeben: ");
		n = Integer.parseInt(eingabe);
		Bruch3 b = new Bruch3(z, n);
		
		// neue instanz c von Bruch3, aufgerufen via die methode in der Bruch3 erzeugt & mittels referenzvariable returnt wird
		Bruch3 c = a.multipliziere(b); 
		
		System.out.println("Bruch a: " + a.bruchtoString());
		System.out.println("Bruch b: " + b.bruchtoString());
		System.out.println("Bruch c: " + c.bruchtoString());
		
		// wenn zaehler & nenner private gesetzt sind statt final, kann auch die methode kuerzen benutzt werden
		a.kuerzen();
		b.kuerzen();
		c.kuerzen();
		
		System.out.println("Bruch a gekürzt: " + a.bruchtoString());
		System.out.println("Bruch b gekürzt: " + b.bruchtoString());
		System.out.println("Bruch c gekürzt: " + c.bruchtoString());	
	}

}
