/* TODO 15.1.3.   s.474, (extends DefaultTableModel) Tabelle m. unterschiedlichen Datentypen,			???		???		???
 * class MyDefaultTabelModel	& 	JTable_TabelleMitVerschiedenenDatentypen_.._Notentabelle
 *
 * !!!!!!!!!!!!!!!! ALLES NOCH MACHEN, AUCH ALLE SUCHBEGRIFFE (implements TableModelListener, ListSelectionListener ) !!!!!!!!!!!!!!!!!!!!!!!!!!!
 *
 * 		K&K:	Klasse MyDefaultTableModel (von der Klasse DefaultTableModel abgeleitet)
 * 				Die Klasse ist die Basis f�r eine Tabelle, die unterschiedliche Datentypen aufnehmen soll.
 */

package uebungen15;

import javax.swing.table.DefaultTableModel;

public class MyDefaultTabelModel extends DefaultTableModel {	// eigenes MyDefaultTableModel von DefaultTableModel ableiten, welches dann unterschiedliche Datentypen unterst�tzen kann ..
																// .. -> siehe �berschriebene methode getColumnClass
	
	public MyDefaultTabelModel() {								// default-construktor der klasse DefaultTableModel
		super();
	}

	public MyDefaultTabelModel(Object[][] d, Object[] n) {		// custom-konstruktor der klasse DefaultTableModel, parameter: 				???
		super(d, n);
	}

	// W I C H T I G:	�berschreiben der methode getColumnClass() von DefaultTableModel: die zugeh�rige table kann kann damit ermitteln, dass in spalte 0: Strings stehen, in spalte 1: Integers & spalte 2: Doubles
	public Class getColumnClass(int column) {				
		if (column == 0) 			// wenn spalte 0:
			return String.class;	// .. die klasse string zur�ckgeben 																		???
		else if (column == 1)		// wenn spalte 1:
			return Integer.class;	// .. die klasse Integer zur�ckgeben 																		???
		else 						// wenn spalte 2:
			return Double.class;	// .. die klasse Double zur�ckgeben 																		???
	}
	
	// ALLE FOLGENDEN METHODEN: 	erm�glichen dem custom-Model, den gesamtnotenschnitt aus den einzelnoten zu berechnen 
									//	=> methoden die den notenschnitt f�r die gesamte tabelle, aber auch �ber einen markierten teilbereich der tabelle berechnen k�nnen
									//		-> mit den entsprechenden Listenern im programm-frame (.._Notentabelle) erfolgt die berechnung & ausgabe dann bei jeder ver�nderung der Tabellendaten
									
	// getter mit return: gewichtung*note f�r die zeile int row
	public double getNoteGewichtet (int row) {
		int gewichtung = ((Integer)getValueAt(row, 1)).intValue();	// gewichtung = wert aus zeile int row, spalte 1	//einfacher w�re : int gewichtung = (int) getValueAt(row, 1);
		double note = ((Double)getValueAt(row, 2)).doubleValue();	// note = wert aus zeile int row, spalte 1			//dito ^
		return gewichtung * note;									// ..
	}	
		
	// getter mit return: gewichtung f�r die zeile int row
	public int getGewichtung(int row) {								
		int gewichtung = ((Integer) getValueAt(row, 1)).intValue();	// gewichtung = wert aus zeile int row, spalte 1	//einfacher w�re : int gewichtung = (int) getValueAt(row, 1);
		return gewichtung;
	}
	
	// getter mit return: gewichtung*note f�r alle angew�hlten (glaub ?) zeilen zusammengez�hlt (int[] rows)					???????????? f�r alle in der tabelle angew�hlten zeilen oder f�r alle zeilen??
	public double getNotenGewichtet(int[] rows) {
		double gesamt = 0;
		for (int i = 0; i < rows.length; i++) {		// f�r jede zeile ..
			gesamt += getNoteGewichtet(rows[i]);	// .. return-wert von methode getNoteGewichtet(..) dazu z�hlen
		}
		return gesamt;								// geamt-wert der noten * gewichtung aller zeilen
	}
	
	// getter mit return: gewichtungen f�r alle angew�hlten (glaub ?) zeilen zusammengez�hlt (int[] rows)						???????????? f�r alle in der tabelle angew�hlten zeilen oder f�r alle zeilen??
	public int getGewichtung(int[] rows) {
		int gewichtung = 0;
		for (int i = 0; i < rows.length; i++){		// f�r jede zeile ..
			gewichtung += getGewichtung(rows[i]);	// .. return-wert von methode getGewichtung(..) dazu z�hlen
		}
		return gewichtung;
	}
	
	// getter mit return: gewichtung*note f�r alle in der tabelle vorhandenen zeilen zusammengez�hlt ()							(????????????? ^)			
	public double getNotenGewichtet() {
		int max = getRowCount();					// variable f�r anzahl aller zeilen der tabelle
		double gesamt = 0;
		for (int i = 0; i < max; i++) {				// f�r jede zeile ..
			gesamt += getNoteGewichtet(i);			// .. return-wert von methode getNoteGewichtet(..) dazu z�hlen				
		}
		return gesamt;
	}
	
	// getter mit return: gewichtung f�r alle in der tabelle vorhandenen zeilen zusammengez�hlt ()								(????????????? ^)
	public int getGewichtung() {
		int max = getRowCount();					// variable f�r anzahl aller zeilen der tabelle
		int gewichtung = 0;							// autor implementiert hier double-wert; meinereiner ist �berzeugt, dass int-wert logischer w�re
		for (int i = 0; i < max; i++) {				// f�r jede zeile ..
			gewichtung += getGewichtung(i);			// .. return-wert von methode getgewichtung(..) dazu z�hlen	
		}
		return gewichtung;
	}
}


































