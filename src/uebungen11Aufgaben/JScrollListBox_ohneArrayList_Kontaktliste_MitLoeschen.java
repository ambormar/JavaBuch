/* TODO 11.3.   Aufgabe 6, s.346
 * class JScrollListBox_ohneArrayList_Kontaktliste_MitLoeschen
 * 
 * fürs löschen von angewählten einträgen der scrolllistbox:
 * 		die ListBox setzt sich zusammen aus:
 * 		- JList (hier jListKontakte), zuständig für darstellung/optik der Liste						=> für's anwählen der einträge		
 * 		- & ListModel (hier jListKontakteModel), zuständig für aufnahme/verwaltung der Listeinträge	=> für's löschen der angewählten einträge
 * 		 
 * 
 * bestimmen wie die einträge der scrolllistbox anwählbar sind:
 * 		markierungsmöglichkeiten in der ListBox auf: nur ein eintrag anwählbar
 *		in properties (outline) von jListKontakte (selectionmode) verstellen
 * 
 * // LISTBOX grundsätzlich siehe class Notenbilanz_Listbox_ArrayList und ähnliche, uebungen11
 * 
 * Programm:	Die Kontakdaten Name, Vorname, Telefonnummer und Email-Adresse können in Textfeldern eingegeben 
 * 				und von dort in eine Listbox übernommen werden. Markierte Einträge können aus der Listbox gelöscht werden.
 * 
 * 				Einträge werden nur in der listbox gespeichert, angewählt & gelöscht. sie sind nicht z.b. in arraylist o.ä. gespeichert
 */

package uebungen11Aufgaben;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;	// import macht's glaub automatisch
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;			// import macht's glaub automatisch
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;	// import macht's glaub automatisch
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

public class JScrollListBox_ohneArrayList_Kontaktliste_MitLoeschen extends javax.swing.JFrame {
	private JLabel jLNachname;
	private JLabel jLVorname;
	private JTextField jTFNachname;
	private JTextField jTFVorname;
	private JButton jBtnLoeschen;
	private JScrollPane jScrollPane1;
	private JLabel jLEMail;
	private JLabel jLKontaktListe;
	private JButton jBtnEnde;
	private JList jListKontakte;
	private JButton jBtnUebernehmen;
	private JTextField jTFEMail;
	private JTextField jTFTelefon;
	private JLabel jLTelefon;
	// WICHTIG: ListModel fürs ganze frame deklarieren um nacher zugriff von jeder methode aus zu haben
	private DefaultListModel jListKontakteModel;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JScrollListBox_ohneArrayList_Kontaktliste_MitLoeschen inst = new JScrollListBox_ohneArrayList_Kontaktliste_MitLoeschen();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public JScrollListBox_ohneArrayList_Kontaktliste_MitLoeschen() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jLNachname = new JLabel();
				getContentPane().add(jLNachname);
				jLNachname.setText("Nachname");
				jLNachname.setBounds(12, 12, 93, 16);
			}
			{
				jLVorname = new JLabel();
				getContentPane().add(jLVorname);
				jLVorname.setText("Vorname");
				jLVorname.setBounds(182, 12, 93, 16);
			}
			{
				jLTelefon = new JLabel();
				getContentPane().add(jLTelefon);
				jLTelefon.setText("Telefon");
				jLTelefon.setBounds(352, 12, 93, 16);
			}
			{
				jTFNachname = new JTextField();
				getContentPane().add(jTFNachname);
				jTFNachname.setBounds(12, 34, 158, 23);
			}
			{
				jTFVorname = new JTextField();
				getContentPane().add(jTFVorname);
				jTFVorname.setBounds(182, 34, 158, 23);
			}
			{
				jTFTelefon = new JTextField();
				getContentPane().add(jTFTelefon);
				jTFTelefon.setBounds(352, 34, 275, 23);
			}
			{
				jLEMail = new JLabel();
				getContentPane().add(jLEMail);
				jLEMail.setText("EMail");
				jLEMail.setBounds(12, 67, 93, 16);
			}
			{
				jTFEMail = new JTextField();
				getContentPane().add(jTFEMail);
				jTFEMail.setBounds(12, 88, 328, 23);
			}
			{
				jBtnUebernehmen = new JButton();
				getContentPane().add(jBtnUebernehmen);
				jBtnUebernehmen.setText("Übernehmen >>");
				jBtnUebernehmen.setBounds(352, 88, 184, 23);
				jBtnUebernehmen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnUebernehmenActionPerformed(evt);
					}
				});
			}
			{
				jLKontaktListe = new JLabel();
				getContentPane().add(jLKontaktListe);
				jLKontaktListe.setText("Kontaktliste");
				jLKontaktListe.setBounds(12, 125, 93, 16);
			}
			{
				jBtnEnde = new JButton();
				getContentPane().add(jBtnEnde);
				jBtnEnde.setText("Ende");
				jBtnEnde.setBounds(482, 211, 146, 23);
				jBtnEnde.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnEndeActionPerformed(evt);
					}
				});
			}
			{	// 
				jScrollPane1 = new JScrollPane();
				getContentPane().add(jScrollPane1);
				jScrollPane1.setBounds(14, 149, 612, 42);
				{	// JList muss im JScrollPane drin sein (in der Outline eins ins andere ziehen)
					// LISTBOX grundsätzlich siehe class Notenbilanz_Listbox_ArrayList
					
					// ListModel von DefaultComboboxModel (= jigloo autogeneriert) auf DefaultListModel() ändern
					jListKontakteModel = new DefaultListModel();
					jListKontakte = new JList();
					jScrollPane1.setViewportView(jListKontakte);
					jListKontakte.setModel(jListKontakteModel);
					jListKontakte.setBounds(14, 149, 612, 42);
					// markierungsmöglichkeiten in der ListBox auf: nur ein eintrag anwählbar
					// in properties (outline) von jListKontakte (selectionmode) verstellen
					jListKontakte.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				}
			}
			{
				jBtnLoeschen = new JButton();
				getContentPane().add(jBtnLoeschen);
				jBtnLoeschen.setText("markierten Eintrag löschen");
				jBtnLoeschen.setBounds(12, 211, 328, 23);
				jBtnLoeschen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnLoeschenActionPerformed(evt);
					}
				});
			}
			pack();
			this.setSize(655, 291);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private void jBtnUebernehmenActionPerformed(ActionEvent evt) {
		// wenn leere felder: fehlertext ausgeben
		if (jTFNachname.getText().isEmpty() || jTFVorname.getText().isEmpty()
				|| jTFTelefon.getText().isEmpty() || jTFEMail.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Bitte vollständige Angaben machen");
			jTFNachname.requestFocus();
			jTFNachname.selectAll();
		} else {
			// das JListModel um elemente hinzuzufügen; JList wäre für darstellung/optik
			jListKontakteModel.addElement(jTFNachname.getText() + ";" + jTFVorname.getText() + ";" +
					jTFTelefon.getText() + ";" + jTFEMail.getText() + ";");
			// textfelder leeren
			jTFNachname.setText("");
			jTFVorname.setText("");
			jTFTelefon.setText("");
			jTFEMail.setText("");
			// focus für nächste eingabe
			jTFNachname.requestFocus();
		}
	}
	// button: löschen des markierten eintrags
	private void jBtnLoeschenActionPerformed(ActionEvent evt) {
		try { 
			// lokale variabel für index von angewähltem eintrag
			// abfragen des index mit .getSelectedIndex() von jList ("darstellende" klasse der Listbox) 
			int index = jListKontakte.getSelectedIndex();
			// löschen des elements mit: remove(int index) von jListModel ("verwaltende klasse der Listbox)
			jListKontakteModel.remove(index);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Kein Eintrag angewählt");
		}
	}
	
	private void jBtnEndeActionPerformed(ActionEvent evt) {
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