package uebungen02;

/* TODO .2.4.1.   s.90
 * class Cast_Operator_Typumwandlung
 * 
 * explizite (= erzwungene) Typumwandlung durch voransetzen in Klammern des zu erzwingenden typs auf der rechten seite der zuweisung
 */ 
import javax.swing.JOptionPane;


public class Cast_Operator_Typumwandlung {

	public static void main(String[] args) {
		double x = 3.89;
		int y;
		y = (int) x; 	// x wird gecastet,  als typ umgewandelt in int... 
						// ...nachkommastellen werden bei typerzwingung in int abgeschnitten, y wird so der wert 3 zugewiesen, 
		
		JOptionPane.showMessageDialog(null, "double x = " + x + '\n' +
					"int y (erzwungener, gecasteter, abgeschnittener wert von x) = " + y);
 
	}

}
