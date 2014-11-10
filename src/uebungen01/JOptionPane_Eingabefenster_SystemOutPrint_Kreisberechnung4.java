package uebungen01;

/* TODO .1.4,   aufgabe 6, s.59
 * class JOptionPane_Eingabefenster_SystemOutPrint_Kreisberechnung4
 
 * Der Radius f�r einen Kreis und die Einheit werden �ber ein Eingabefenster eingegeben. Anschlie�end
 * werden der Umfang und der Fl�cheninhalt berechnet und per konsole (system.out.print) ausgegeben
 */

import javax.swing.*; // import f�r JOptionPane

public class JOptionPane_Eingabefenster_SystemOutPrint_Kreisberechnung4 {	
    public static void main(String[] args) {	// ganzes priogramm in der main methode
        double radius, umfang, flaeche;			// double variabeln
        String einheit, eingabe;				// string-objekte	
        eingabe = JOptionPane.showInputDialog("Geben Sie den Kreisradius ein: "); // string f�r string-objekt eingabe via eingabefenster (JOptionPane)
        radius = Double.parseDouble(eingabe);									// string eingabe in double umwandeln und radiusobjekt zuweisen
        eingabe = JOptionPane.showInputDialog("Geben Sie die Einheit ein: ");	// neuer string f�r string-objekt eingabe via eingabefenster (JOptionPane)
        einheit = eingabe;														// string eingabe dem string einheit zuweisesn
        umfang = 2.0 * 3.1415926 * radius;				// umfang berechnen
        flaeche = 3.1415926 * radius * radius;			// fl�che berechnen
        System.out.print("Umfang: ");					// auf konsole umfang mit wert und einheit...
        System.out.print(umfang);
        System.out.println(" " + einheit);
        System.out.print("Flaeche: ");					// ... und fl�che mit wert und einheit ausgeben
        System.out.print(flaeche);
        System.out.println(" " + einheit + '\u00b2');	// '\u00b2' = unicode zeichen 00b2 = hoch2
    }
}