package uebungen02;


/* TODO .2.4.1.   s.89
 * class Wertzuweisung_ImpliziteTypumwandlung
 * 
 * explizite (= erzwungene) Typumwandlung durch voransetzen in Klammern des zu erzwingenden typs auf der rechten seite der zuweisung
 */
import javax.swing.JOptionPane;


public class Wertzuweisung_ImpliziteTypumwandlung {

	public static void main(String[] args) throws NumberFormatException{
		byte byteZahl;
		int intZahl;
		float floatZahl;
		double doubleZahl;
		
		// mögliche wertzuweisungen:	speicherplatz links > wert rechts
		byteZahl = 100;
		intZahl = byteZahl;
		floatZahl = intZahl;
		floatZahl = 23.345f;
		doubleZahl = floatZahl;
		
		JOptionPane.showMessageDialog(null, "mögliche zuweisungen:" + '\n' +
										"byteZahl = " + byteZahl + '\n' +
										"intZahl = " + intZahl + '\n' +
										"floatZahl = " + floatZahl + '\n' +
										"doubleZahl = " + doubleZahl);
		
		// nur wegen cast operatoren mögliche wertzuweisungen:	wenn speicherplatz links < wert rechts
		byteZahl = (byte) intZahl;
		floatZahl = (float) doubleZahl;
		
		JOptionPane.showMessageDialog(null, "nur wegen cast operatoren mögliche wertzuweisungen:" + '\n' +
										"byteZahl = " + byteZahl + '\n' +
										"floatZahl = " + floatZahl);	
		}

}
