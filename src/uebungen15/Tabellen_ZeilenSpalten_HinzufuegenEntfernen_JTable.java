/* TODO 15.1.2.  -> ???
 * Tabellen_ZeilenSpalten_HinzufuegenEntfernen_JTable
 * 
 * 		
 * 		
 * 			SIEHE:		15.1.2.   	JTable_MitVariablerZeilenSpaltenZahl_DatenEinAusLesen_InDatFile_StundenPlan3		s.470,
 * 
 * 						ACHTUNG:	-> beim spalten hinzuf�gen / entfernen hat's n bug, den ich noch nicht gel�st hab:
 * 													
 * 										(spalte samstag kann man sauber einmal hinzuf�gen & entfernen: wenn man dann wieder hinzuf�gt zeigts 2/mehr samstage an:
 * 											-> hat warscheinlich ein problem mit den unterschiedlichen models (TableColumnModel vs DefaultTableModel) 
 * 												-> bei removeColumn() via das TableColumnModel wird die spalte glaub nur optisch entfernt und beim wieder adden �ber's DefaultTabelModel doppelt/mehrfach angezeigt
 * 												-> leider gibt's addColumn(new String("")) nur bei DefaultTableModel	& 	removeColumn() nur bei TableColumnModel
 * 													-> addColumn(..) von TableColumnModel z.b. kann man dann wieder keinen Titel-string mitgeben & s zeigt irgendwas in den zellen an usw. 
 * 
 * 										-> PROBLEM UNGEL�ST ???
 * 											
 * 									-> hinzuf�gen / entfernen von zeilen funktioniert perfekt
 */

package uebungen15;

public class Tabellen_ZeilenSpalten_HinzufuegenEntfernen_JTable {

}
