/* TODO 11.3.   Aufgabe 7, s.347
 * class JScrollListBox_substring_ohneArrayList_Kontaktliste_MitBearbeiten
 * 
 * angew�hlte zeile aus Listbox zur�ck in textfelder �bertragen & l�schen (genau siehe code):
 * 		- mit jListKontakte.getSelectedIndex() und jListKontakteModel.getElementAt(index)
 * 		  element/objekt unter aufzwingen von string einer lokalen stringvariabeln zuweisen
 * 		- mit methode substring(indexanfang, indexende) die zeile st�ck f�r st�ck wieder zur�ck 
 * 		  in die textfelder eintragen
 * 		- und die zeile aus der liste l�schen
 * 
 * f�rs l�schen von angew�hlten eintr�gen der scrolllistbox:
 * 		die ListBox setzt sich zusammen aus:
 * 		- JList (hier jListKontakte), zust�ndig f�r darstellung/optik der Liste						=> f�r's anw�hlen der eintr�ge		
 * 		- & ListModel (hier jListKontakteModel), zust�ndig f�r aufnahme/verwaltung der Listeintr�ge	=> f�r's l�schen der angew�hlten eintr�ge
 * 
 * SUBSTRING:	methode von String:	substring(indexanfang, indexende)
 * 				SIEHE:	ca. ab zeile 250
 * 
 * LISTBOX grunds�tzlich siehe:		 class Listbox_ArrayList_Basics_Notenbilanz		und �hnliche, uebungen11
 * 
 * Programm:	Die Kontakdaten Name, Vorname, Telefonnummer und Email-Adresse k�nnen in Textfeldern eingegeben 
 * 				und von dort in eine Listbox �bernommen werden. Markierte Eintr�ge k�nnen aus der Listbox gel�scht werden. 
 * 				Ein markierter Eintrag kann zum Bearbeiten aus der Listbox zur�ck in die Textfelder �bertragen werden.
 * 
 * 
 * 				Eintr�ge werden nur in der listbox gespeichert, angew�hlt & gel�scht. sie sind nicht z.b. in arraylist o.�. gespeichert
 */

package uebungen11Aufgaben;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

public class JScrollListBox_substring_ohneArrayList_Kontaktliste_MitBearbeiten extends javax.swing.JFrame {
	private JLabel jLNachname;
	private JLabel jLVorname;
	private JTextField jTFNachname;
	private JTextField jTFVorname;
	private JButton jBtnbearbeiten;
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
	// WICHTIG: ListModel f�rs ganze frame deklarieren um nacher zugriff von jeder methode aus zu haben
	private DefaultListModel jListKontakteModel;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JScrollListBox_substring_ohneArrayList_Kontaktliste_MitBearbeiten inst = new JScrollListBox_substring_ohneArrayList_Kontaktliste_MitBearbeiten();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public JScrollListBox_substring_ohneArrayList_Kontaktliste_MitBearbeiten() {
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
				jBtnUebernehmen.setText("�bernehmen >>");
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
				jBtnEnde.setBounds(517, 211, 111, 23);
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
				{				// JList muss im JScrollPane drin sein (in der Outline eins ins andere ziehen)
								// LISTBOX grunds�tzlich siehe class Notenbilanz_Listbox_ArrayList
					
								// ListModel von DefaultComboboxModel (= jigloo autogeneriert) auf DefaultListModel() �ndern
					jListKontakteModel = new DefaultListModel();
					jListKontakte = new JList();
					jScrollPane1.setViewportView(jListKontakte);
					jListKontakte.setModel(jListKontakteModel);
					jListKontakte.setBounds(14, 149, 612, 42);
								// markierungsm�glichkeiten in der ListBox auf: nur ein eintrag anw�hlbar
								// in properties (outline) von jListKontakte (selectionmode) verstellen
					jListKontakte.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				}
			}
			{
				jBtnLoeschen = new JButton();
				getContentPane().add(jBtnLoeschen);
				jBtnLoeschen.setText("markierten Eintrag l�schen");
				jBtnLoeschen.setBounds(12, 211, 229, 23);
				jBtnLoeschen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnLoeschenActionPerformed(evt);
					}
				});
			}
			{
				jBtnbearbeiten = new JButton();
				getContentPane().add(jBtnbearbeiten);
				jBtnbearbeiten.setText("markierten Eintrag bearbeiten");
				jBtnbearbeiten.setBounds(261, 211, 239, 23);
				jBtnbearbeiten.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnbearbeitenActionPerformed(evt);
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
			JOptionPane.showMessageDialog(null, "Bitte vollst�ndige Angaben machen");
			jTFNachname.requestFocus();
		} else {
						// in JListModel die elemente hinzuzuf�gen; JList w�re nur f�r darstellung/optik
			jListKontakteModel.addElement(jTFNachname.getText() + ";" + jTFVorname.getText() + ";" +
					jTFTelefon.getText() + ";" + jTFEMail.getText() + ";");
						// textfelder leeren
			jTFNachname.setText("");
			jTFVorname.setText("");
			jTFTelefon.setText("");
			jTFEMail.setText("");
						// focus f�r n�chste eingabe
			jTFNachname.requestFocus();
		}
	}
	// button: l�schen des markierten eintrags
	private void jBtnLoeschenActionPerformed(ActionEvent evt) {
		try { 
						// lokale variabel f�r index von angew�hltem eintrag, 
						// abfragen des index mit .getSelectedIndex() von jList ("darstellende" klasse der Listbox) 
			int index = jListKontakte.getSelectedIndex();
			// l�schen des elements mit demselben index aus jListModel ("verwaltende" klasse der Listbox)
			jListKontakteModel.remove(index);	
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Kein Eintrag angew�hlt");
		}
	}
	// angew�hlte zeile zur�ck in textfelder �berschreiben (& aus liste l�schen)
	private void jBtnbearbeitenActionPerformed(ActionEvent evt) {
		try { 
			// lokale variabel f�r index von angew�hltem eintrag in der liste
					// abfragen des index mit .getSelectedIndex() von jList ("darstellende" klasse der Listbox) 
			int index = jListKontakte.getSelectedIndex();
			// element an der stelle index auslesen & einer lokalen stringvariabeln zuweisen
					// wichtig: (String) aufzwingen, weil jListKontakteModel.getElementAt() liefert objekt zur�ck..
					// ...sonst fehler weil dem String nicht ein objekt zugewiesen werden kann
			String zeile = (String) jListKontakteModel.getElementAt(index);
			// SUBSTRING:
			// mit methode substring(indexanfang, indexende) einen teil vom string auslesen
			jTFNachname.setText(zeile.substring(0, zeile.indexOf(";")));
			// zeile = rest-substring der zeile, +1: damit ";" nicht mitausgelesen wird
			zeile = zeile.substring(zeile.indexOf(";") + 1, zeile.length());
			jTFVorname.setText(zeile.substring(0, zeile.indexOf(";")));
			zeile = zeile.substring(zeile.indexOf(";") + 1, zeile.length());
			jTFTelefon.setText(zeile.substring(0, zeile.indexOf(";")));
			zeile = zeile.substring(zeile.indexOf(";") + 1, zeile.length());
			jTFEMail.setText(zeile.substring(0, zeile.indexOf(";")));
			// ins textfeld �bbertragene zeile aus liste l�schen
			jListKontakteModel.remove(index);
			// focus
			jTFNachname.requestFocus();
			jTFNachname.selectAll();	
			
		} catch (Exception e) {		// falls nix angew�hlt w�re:
			JOptionPane.showMessageDialog(null, "Kein Eintrag angew�hlt");
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