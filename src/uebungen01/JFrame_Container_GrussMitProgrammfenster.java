package uebungen01;

/* TODO .1.4,   Aufgabe 5, s.57
 * class JFrame_Container_GrussMitProgrammfenster
 * 
 * JFrame Programmfenster erstellen und mit Jlabels, Icons und Text befüllen. 
 * dabei font, hintergrund und vordergrund-farben bestimmen
 * 
*/

import java.awt.*;		// oberflächenklasse (bsp: frame, button
import javax.swing.*;	// oberflächenklasse mit J (bsp: JFrame, JButton)

// klasse 	
public class JFrame_Container_GrussMitProgrammfenster extends JFrame {
	// konstruktor
	public JFrame_Container_GrussMitProgrammfenster() { 
	   super("Juuhuu");				// anscheinend kann man bei JFrame mit super(string) die überschrift bestimmen (text im rahmen neben icon)

	   Icon icon = new ImageIcon("images/java-logo.jpg"); 	// N.B. ImageIcon ist unterklasse von klasse Icon 
	   JLabel label1 = new JLabel("Viel Erfolg beim", JLabel.CENTER);	// objekte label 1-3 vom typ JLabel erzeugen
	   JLabel label2 = new JLabel("Programmieren mit Java!", JLabel.CENTER);
	   JLabel label3 = new JLabel(icon);
	   Font schrift = new Font("sans-serif", Font.BOLD, 24);	// objekt schrift von typ Font erzeugen
	   label1.setFont(schrift);						// objekte.methoden() für schrift & vordergrund
	   label1.setForeground(Color.red);
	   label2.setFont(schrift);
	   label2.setForeground(Color.red);
	   Container c = getContentPane();  /* Objekt vom typ Container mittels methode getContentPane() der Klasse Container erzeugen; 
	   										wieso hier nicht: Container c = new Container?:
	    									Methode getContentPane() von Klasse JFrame gibt JFramespezifische Containerobjekt zurück */
	   c.setLayout(new FlowLayout());	// objekt.methoden für Layout
	   c.setBackground(Color.orange);
	   c.add(label1);					// dem container-objekt die labels 1-3 mittels methode add() hinzufügen
	   c.add(label2);
	   c.add(label3);
	   /* der klasse JFrame_Container_GrussMitProgrammfenster mit den jeweiligen methoden der Superklasse JFrame
	   	die Grösse-, sichtbarkeit und schliessoptionen zuweisen*/
	   setDefaultCloseOperation(EXIT_ON_CLOSE); // nicht c.setDefaultblabla.. weil bezieht sich auf s ganze teil, also das JFrame
	   setSize(320,250);						// nicht c.setSize() weil bezieht sich auf s ganze teil, also das JFrame
	   setVisible(true);						// nicht c.setVisible() weil bezieht sich auf s ganze teil, also das JFrame
   }
	
	// main methode für programmstart zur (hier) einmaligen erzeugung des objekts mittels konstruktort
	public static void main(String[] args) {		
	   new JFrame_Container_GrussMitProgrammfenster();		// aufruf des konstruktors ohne zuweisg von namen für NUR einmaligen durchlauf,... 
	   														// ...instanzierung ohne weiterverwendung
	}
}