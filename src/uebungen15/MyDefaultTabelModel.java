/* TODO 15.1.3.   s.474, (extends DefaultTableModel) Tabelle m. unterschiedlichen Datentypen,			???		???		???
 * class MyDefaultTabelModel	& 	JTable_TabelleMitVerschiedenenDatentypen_.._Notentabelle
 *
 * !!!!!!!!!!!!!!!! ALLES NOCH MACHEN, AUCH ALLE SUCHBEGRIFFE (implements TableModelListener, ListSelectionListener ) !!!!!!!!!!!!!!!!!!!!!!!!!!!
 *
 * 		K&K:	Klasse MyDefaultTableModel (von der Klasse DefaultTableModel abgeleitet)
 * 				Die Klasse ist die Basis für eine Tabelle, die unterschiedliche Datentypen aufnehmen soll.
 */

package uebungen15;

import javax.swing.table.DefaultTableModel;

public class MyDefaultTabelModel extends DefaultTableModel {	// eigenes MyDefaultTableModel von DefaultTableModel ableiten, welches dann unterschiedliche Datentypen unterstützen kann ..
																// .. -> siehe überschriebene methode getColumnClass
	
	public MyDefaultTabelModel() {								// default-construktor der klasse DefaultTableModel
		super();
	}

	public MyDefaultTabelModel(Object[][] d, Object[] n) {		// custom-konstruktor der klasse DefaultTableModel, parameter: 				???
		super(d, n);
	}

	// W I C H T I G:	überschreiben der methode getColumnClass() von DefaultTableModel: die zugehörige table kann kann damit ermitteln, dass in spalte 0: Strings stehen, in spalte 1: Integers & spalte 2: Doubles
	public Class getColumnClass(int column) {				
		if (column == 0) 			// wenn spalte 0:
			return String.class;	// .. die klasse string zurückgeben 																		???
		else if (column == 1)		// wenn spalte 1:
			return Integer.class;	// .. die klasse Integer zurückgeben 																		???
		else 						// wenn spalte 2:
			return Double.class;	// .. die klasse Double zurückgeben 																		???
	}
	
	// ALLE FOLGENDEN METHODEN: 	ermöglichen dem custom-Model, den gesamtnotenschnitt aus den einzelnoten zu berechnen 
									//	=> methoden die den notenschnitt für die gesamte tabelle, aber auch über einen markierten teilbereich der tabelle berechnen können
									//		-> mit den entsprechenden Listenern im programm-frame (.._Notentabelle) erfolgt die berechnung & ausgabe dann bei jeder veränderung der Tabellendaten
									
	// getter mit return: gewichtung*note für die zeile int row
	public double getNoteGewichtet (int row) {
		int gewichtung = ((Integer)getValueAt(row, 1)).intValue();	// gewichtung = wert aus zeile int row, spalte 1	//einfacher wäre : int gewichtung = (int) getValueAt(row, 1);
		double note = ((Double)getValueAt(row, 2)).doubleValue();	// note = wert aus zeile int row, spalte 1			//dito ^
		return gewichtung * note;									// ..
	}	
		
	// getter mit return: gewichtung für die zeile int row
	public int getGewichtung(int row) {								
		int gewichtung = ((Integer) getValueAt(row, 1)).intValue();	// gewichtung = wert aus zeile int row, spalte 1	//einfacher wäre : int gewichtung = (int) getValueAt(row, 1);
		return gewichtung;
	}
	
	// getter mit return: gewichtung*note für alle angewählten (glaub ?) zeilen zusammengezählt (int[] rows)					???????????? für alle in der tabelle angewählten zeilen oder für alle zeilen??
	public double getNotenGewichtet(int[] rows) {
		double gesamt = 0;
		for (int i = 0; i < rows.length; i++) {		// für jede zeile ..
			gesamt += getNoteGewichtet(rows[i]);	// .. return-wert von methode getNoteGewichtet(..) dazu zählen
		}
		return gesamt;								// geamt-wert der noten * gewichtung aller zeilen
	}
	
	// getter mit return: gewichtungen für alle angewählten (glaub ?) zeilen zusammengezählt (int[] rows)						???????????? für alle in der tabelle angewählten zeilen oder für alle zeilen??
	public int getGewichtung(int[] rows) {
		int gewichtung = 0;
		for (int i = 0; i < rows.length; i++){		// für jede zeile ..
			gewichtung += getGewichtung(rows[i]);	// .. return-wert von methode getGewichtung(..) dazu zählen
		}
		return gewichtung;
	}
	
	// getter mit return: gewichtung*note für alle in der tabelle vorhandenen zeilen zusammengezählt ()							(????????????? ^)			
	public double getNotenGewichtet() {
		int max = getRowCount();					// variable für anzahl aller zeilen der tabelle
		double gesamt = 0;
		for (int i = 0; i < max; i++) {				// für jede zeile ..
			gesamt += getNoteGewichtet(i);			// .. return-wert von methode getNoteGewichtet(..) dazu zählen				
		}
		return gesamt;
	}
	
	// getter mit return: gewichtung für alle in der tabelle vorhandenen zeilen zusammengezählt ()								(????????????? ^)
	public int getGewichtung() {
		int max = getRowCount();					// variable für anzahl aller zeilen der tabelle
		int gewichtung = 0;							// autor implementiert hier double-wert; meinereiner ist überzeugt, dass int-wert logischer wäre
		for (int i = 0; i < max; i++) {				// für jede zeile ..
			gewichtung += getGewichtung(i);			// .. return-wert von methode getgewichtung(..) dazu zählen	
		}
		return gewichtung;
	}
}


































