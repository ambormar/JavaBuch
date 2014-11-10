/* TODO 11.2.4.   s.343 
 * class ArrayList_ElementeMitVerschiedenenDatentypen_Vector_Artikelliste 		& 		KLASSE Artikel	!!!!!!!!!!!!!!!!
 * 
 * ACHTUNG: ZUR VERSTÄNDTLICHKEIT:		hier wird auf die selber verfasste Klasse Artikel zurückgegriffen;	!!!!!!!!!!
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
 *				public class Artikelliste extends javax.swing.JFrame {			// KLASSE ARTIKELLISTE, IN DER VECTOR VERWENDET WIRD
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

public class Artikel {

	private String artikelnummer;
	private String artikelbezeichnung;
	private double stueckpreis;

	public Artikel(String nr, String bez, double sp) {
		artikelnummer = nr;
		artikelbezeichnung = bez;
		stueckpreis = sp;
	}
	
	public String getArtikelnummer() {
		return artikelnummer;
	}

	public String getArtikelbezeichnung() {
		return artikelbezeichnung;
	}
	
	public double getStueckpreis() {
		return stueckpreis;
	}

	public void setArtikelnummer(String nr) {
		artikelnummer = nr;
	}

	public void setArtikelbezeichnung(String bez) {
		artikelbezeichnung = bez;
	}

	public void setStueckpreis(double sp) {
		stueckpreis = sp;
	}
	

}