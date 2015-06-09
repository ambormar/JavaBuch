/* TODO 15.1.1.b.   s.466, !!!!!!!!!!!!!!
 * TableModel_Basics_Klasse_Methoden
 * 
 * 			ZUSAMMENSPIEL TABLEMODEL & JTABLE:			SIEHE:		15.1.  	 	JTable_Basic_Klasse_Komponente_FuerTabellen							s.463,
 * 
 * 																	15.1.1.a.   JTable_Tabelle_MitKonstanterZellenZahl_StundenPlan					s.464, 
 * 	
 * 
 * 			METHODEN ANGEWANDT:							SIEHE:		15.1.1.c.	JTable_MitKonstZellenZahl_DatenEinUndAuslesen_StundenPlan2			s.468																			!!!!!!!!!!!!!
 * 
 * 
 * 
 * 	KLASSE TABLEMODEL:
 * 
 * 				=> import:		javax.swing.table.TableModel
 * 
 * 				=> beschreibt methoden, die von der JTable-komponente f�r die anzeige + �nderung der daten genutzt werden
 * 
 * 				=> nicht alle diese methoden werden von interface AbstractTableModel implementiert **, (von welchem eigene TableModels bei bedarf abgeleitet werden k�nnen)
 * 
 * 				=> grunds�tzlich k�nnen ALLE TYPEN DIE VON OBJECT werden in einer tabelle gespeichert werden 
 * 
 * 				=> f�r die primitiven datentypen muss man ihre entsprechung als WRAPPERKLASSE verwenden
 * 		
 * 				=> wenn die methode getColumnClass(..) nicht �berschrieben ist		-> geht die table-Komponente davon aus dass es sich um STRINGS handelt & formatiert entsprechend 
 * 																												-> desshalb werden alle daten standardm�ssig linksb�ndig dargestellt
 * 					-> getColumnClass(..) um der Table-Komponente die DATENTYPEN EINER SPALTE mitzuteilen
 * 					
 * 
 * 
 * 		METHODEN** - DIE JEDES TABLEMODEL ZUR VERF�GUNG STELLEN MUSS:
 * 
 * 				int getColumnCount()									gibt aktuelle anzahl spalten zur�ck
 * 
 * 				int getRowCount()										gibt aktuelle anzahl zeilen zur�ck		
 * 
 * 				Object getValueAt(int r, int c)							liefert aktuellen wert der zelle an der position zeile r, spalte c zur�ck
 * 
 * 
 * 
 * 		METHODEN - WEITERE WICHTIGE:
 * 			
 * 				String getColumnName(int c)								liefert den namen der spalte c
 * 
 * 				Class getColumnClass(int c)								liefert das Class-object der klasse, zu der alle objekte der spalte c geh�ren
 * 
 * 				boolean isCellEditable(int r, int c)				 	gibt zur�ck ob die zelle (an position zeile r, spalte c) editiert werden kann 
 * 
 * 				void setValueAt(Object value, int r, int c)				�berschreibt den wert in der zelle (zeile r, spalte c) mit value
 * 
 * 				void fireTableDateChanged()								informiert alle TableListener, dass sich tabellen-daten ge�ndert haben
 * 		
 * 
 */

package uebungen15;

public class TableModel_Basics_Klasse_Methoden {

}
