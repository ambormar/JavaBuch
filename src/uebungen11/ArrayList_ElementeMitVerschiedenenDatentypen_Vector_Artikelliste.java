/* TODO 11.2.4.   s.343 
 * class ArrayList_ElementeMitVerschiedenenDatentypen_Vector_Artikelliste 		& 		KLASSE Artikel	!!!!!!!!!!!!!!!!
 * 
 * ACHTUNG: 	ZUR VERSTÄNDTLICHKEIT:		hier wird auf die selber verfasste Klasse Artikel zurückgegriffen;	!!!!!!!!!!
 * 
 * PROGRAMM:	zur speicherung von verschiedenen Datentypen gleichzeitig in einer ArrayList:
 * 
 * 		 		ObjektInstanzen der klasse Artikel (selbstverfasst) werden als elemente in Arraylist() artikel gespeichert.
 * 		 		dabei wird jedem element mittels konstruktoraufruf von Klasse Artikel, mehrere datentypen als Parameter mitgegeben, krass
 * 
 * 				Programm Artikelliste demonstriert die verwendung eines Vectors zur Speicherung von Objekten. 
 * 				Es können beliebig viele Artikel-Objekte gespeichert und nacheinander in einem JLabel angezeigt werden.
 * 
 * 
 * VECTOR:		= wenn z.b. ArrayList ohne datentyp deklariert/initialisiert wird und man so später unterschiedliche datentypen speichern kann
 * 
 * 				NORMAL:		ArrayList<Double> name = new ArrayList<Double>;
 * 				VECTOR:		ArrayList name = new ArrayList();
 * 
 * KERN-CODE:	public class Artikel {				// KLASSE Artikel => objekttyp, der 3 datentypen gleichzeitig aufnehmen kann
 * 
 *					private String artikelnummer;
 *					private String artikelbezeichnung;
 *					private double stueckpreis;
 *
 *					public Artikel(String nr, String bez, double sp) {
 *						artikelnummer = nr;
 *						artikelbezeichnung = bez;
 *						stueckpreis = sp;
 *					} 
 *											
 *					& alle Getter / Setter der 3 variablen
 *				}
 *										
 *		&:		public class Artikelliste extends javax.swing.JFrame {			// KLASSE ARTIKELLISTE, IN DER VECTOR VERWENDET WIRD
 *					...
 *					private ArrayList artikel;			// normal wäre: private ArrayList<Double> artikel
 *					private int anzeigenummer;			// um idex jeweils zu bestimmen
 *					...
 *					private void initGUI() {
 *						...
 *						artikel = new ArrayList(); 		// normal wäre:  = ArrayList<Typ>(),  hier nicht weil mit verschiedenen DatenTypen gearbeitet wird
 *						anzeigenummer = 0;
 *					}
 *					....
 *					private void jBtnSpeichernActionPerformed(ActionEvent evt) {	// methode zum elemente von arraylist artikel zu erzeugen/speichern
 *						...
 *						artikel.add(new Artikel	(jTFArtikelnummer.getText(),				// statt add(object e) ...
 *												jTFArtikelbezeichnung.getText(), 			// ..add(new Artikel(nr, bez, sp))
 *												Double.parseDouble(jTFStueckpreis.getText())));
 *						...					 
 *					}
 *					private void jBtnArtikelauflistenActionPerformed(ActionEvent evt) {		// methode um die als elemente von artikel gespeicherten Instanzobjekte der Klasse Artikel auszugeben
 *						...
 *						Artikel a = (Artikel) artikel.get(anzeigenummer);					// statt: Artikel a = new Artikel(); wird hier dem bezeichner a, der den Objekttyp Artikel hat,
 *																							// das element von arraylist (artikel) zugewiesen, welches den index anzeigenummer hat
 *																							// und diesem element geichzeitig der datentyp Artikel aufgezwungen
 *						jLArtikel.setText(a.getArtikelnummer() + ";" + a.getArtikelbezeichnung() + ";" + a.getStueckpreis());
 *																							// über a wird mit gettern auf daten der Instanzen der Klasse Artikel zugegriffen 
 *					}
 *				}	
 *																			
 * 	 GENAUER / PROGRAMMLOGIK:		siehe code unten
 * 
 */

package uebungen11;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList; 

public class ArrayList_ElementeMitVerschiedenenDatentypen_Vector_Artikelliste extends javax.swing.JFrame {

	private JLabel jLArtikelnummer;
	private JTextField jTFArtikelnummer;
	private JLabel jLArtikelbezeichnung;
	private JTextField jTFArtikelbezeichnung;
	private JLabel jLStueckpreis;
	private JTextField jTFStueckpreis;
	private JLabel jLArtikel;
	private JLabel jLAnzahl;
	private JLabel jLgespeicherteArtikel;
	private JButton jBtnArtikelauflisten;
	private JButton jBtnSpeichern;
	private JButton jBtnEnde;
	// VECTOR = definition mal noch nachliefern
	// NICHT: ArrayList<Double> artikel, weil der Datentyp/Objekttyp "Artikel" (=Klasse Artikel desselben packages) wäre..
	// ..und beim hinzufügen der elemente mehrere Datentypen als Parameter eines Konstruktorenaufrufs mitgegeben werden
			// (NB: Datentyp "Artikel" wäre laut maja übrigens auch möglich, unterschied: weiss noch nicht
	private ArrayList artikel;  // das ding nennt sich so verwendet glaub: VECTOR ?
	private int anzeigenummer;
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ArrayList_ElementeMitVerschiedenenDatentypen_Vector_Artikelliste inst = new ArrayList_ElementeMitVerschiedenenDatentypen_Vector_Artikelliste();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public ArrayList_ElementeMitVerschiedenenDatentypen_Vector_Artikelliste() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Artikelliste mit Vector");
			{
				jLArtikelnummer = new JLabel();
				getContentPane().add(jLArtikelnummer);
				jLArtikelnummer.setText("Artikelnummer");
				jLArtikelnummer.setBounds(7, 7, 123, 14);
			}
			{
				jTFArtikelnummer = new JTextField();
				getContentPane().add(jTFArtikelnummer);
				jTFArtikelnummer.setBounds(7, 21, 140, 21);
			}
			{
				jLArtikelbezeichnung = new JLabel();
				getContentPane().add(jLArtikelbezeichnung);
				jLArtikelbezeichnung.setText("Artikelbezeichnung");
				jLArtikelbezeichnung.setBounds(169, 7, 197, 14);
			}
			{
				jTFArtikelbezeichnung = new JTextField();
				getContentPane().add(jTFArtikelbezeichnung);
				jTFArtikelbezeichnung.setBounds(169, 21, 197, 21);
			}
			{
				jLStueckpreis = new JLabel();
				getContentPane().add(jLStueckpreis);
				jLStueckpreis.setText("Stückpreis");
				jLStueckpreis.setBounds(7, 48, 140, 14);
			}
			{
				jTFStueckpreis = new JTextField();
				getContentPane().add(jTFStueckpreis);
				jTFStueckpreis.setBounds(7, 62, 140, 21);
			}
			{
				jBtnSpeichern = new JButton();
				getContentPane().add(jBtnSpeichern);
				jBtnSpeichern.setText("Speichern");
				jBtnSpeichern.setBounds(169, 62, 112, 21);
				jBtnSpeichern.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnSpeichernActionPerformed(evt);
					}
				});
			}
			{
				jLArtikel = new JLabel();
				getContentPane().add(jLArtikel);
				jLArtikel.setBounds(7, 136, 366, 14);
			}
			{
				jBtnArtikelauflisten = new JButton();
				getContentPane().add(jBtnArtikelauflisten);
				jBtnArtikelauflisten.setText("Nächsten Artikel zeigen");
				jBtnArtikelauflisten.setBounds(7, 110, 190, 21);
				jBtnArtikelauflisten.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnArtikelauflistenActionPerformed(evt);
					}
				});
			}
			{
				jLgespeicherteArtikel = new JLabel();
				getContentPane().add(jLgespeicherteArtikel);
				jLgespeicherteArtikel.setText("gespeicherte Artikel:");
				jLgespeicherteArtikel.setBounds(7, 89, 123, 14);
			}
			{
				jLAnzahl = new JLabel();
				getContentPane().add(jLAnzahl);
				jLAnzahl.setText("0");
				jLAnzahl.setBounds(142, 89, 55, 14);
			}
			{
				jBtnEnde = new JButton();
				getContentPane().add(jBtnEnde);
				jBtnEnde.setText("Ende");
				jBtnEnde.setBounds(162, 173, 67, 21);
				jBtnEnde.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnEndeActionPerformed(evt);
					}
				});
			}
			pack();
			this.setSize(400, 246);
			// ArrayList<Typ>() wäre normal! hier nicht weil später mit verschiedenen DatenTypen gearbeitet wird
			artikel = new ArrayList(); 
			anzeigenummer = 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// methode um instanzen der klasse Artikel als elemente im Arraylist artikel zu speichern
		// dabei wird jedem element (von arraylist artikel) mittels konstruktoraufruf von Klasse Artikel mehrere datentypen als Parameter mitgegeben
	private void jBtnSpeichernActionPerformed(ActionEvent evt){
		try { 
			// wenn eingabefelder nicht leer sind
			if (!jTFArtikelnummer.getText().isEmpty()
					&& !jTFArtikelbezeichnung.getText().isEmpty()
					&& !jTFStueckpreis.getText().isEmpty()){
				// Arraybezeichner.addiere(neueInstanzVon Artikel(nummer, bezeichner, stueckpreis)
					// new Artikel(nr, bez, sp) => neues InstanzObjekt der Klasse Artikel(nummer, bezeichner, stueckpreis) [Kl. Artikel aus demselbem Package]
					// entspricht perfekt der methode von ArrayList: add(object e)
					// so können in einem element von arraylist mehrere Datentypen (alle in der Parameterliste mitgegebenen) gleichzeitig gespeichert werden
				artikel.add(new Artikel(jTFArtikelnummer.getText(), 				// artikelnummer auch als string mitgeben
								jTFArtikelbezeichnung.getText(), 					// artikelbezeichner als string mitgeben
									Double.parseDouble(jTFStueckpreis.getText()))); // stückpreis in double umwandeln & so mitgeben
				jLAnzahl.setText("" + artikel.size());  // grösse von arraylist ausgeben
			
			
			} else {	// falls eins der textfelder leer: fehlertext
				JOptionPane.showMessageDialog(null, "Fehler! Eingaben unvollständig!");
			}
			
		} catch (Exception e) { // div. fehler abfangen, allgemeiner fehlertext
			JOptionPane.showMessageDialog(null, "Fehler! Eingaben prüfen!");
		}
	}
	
	// methode um die als elemente von artikel gespeicherten Instanzobjekte der Klasse Artikel durchzuzappen
	private void jBtnArtikelauflistenActionPerformed(ActionEvent evt){
		// wenn arraylist artikel nicht leer ist (.isEmpty() = methode von Arraylist, nicht etwa von string)
		if (!artikel.isEmpty()) {
			// statt: Artikel a = new Artikel(); wird hier dem bezeichner a, der den Objekttyp Artikel hat,..
				// ..das element von arraylist (artikel) zugewiesen, welches den index anzeigenummer hat..
				// ..und diesem element geichzeitig der datentyp Artikel aufgezwungen.
			Artikel a = (Artikel) artikel.get(anzeigenummer);	// (anzeigenummer wurde oben 0 gesetzt-> also erstes element von arraylist)...
			// ..ausgehend vom ersten element wird mit jedem buttonklick das näxtfolgende element in jLArtikel angezeigt 
			// (mit gettern wird auf daten der Instanzen der Klasse Artikel zugegriffen) 
			jLArtikel.setText(a.getArtikelnummer() + ";" 
							+ a.getArtikelbezeichnung() + ";"
							+ a.getStueckpreis());
			anzeigenummer++;											// mit jedem klick eine indexnummer weiter
			if (anzeigenummer > artikel.size() -1) anzeigenummer = 0;	// bei erreichen vom ende der arraylist wieder zurück an den anfang
		}
	}
	
	private void jBtnEndeActionPerformed(ActionEvent evt){
		System.exit(0);
	}
}
/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/