/* TODO 11.2.3.   s.340 uf (JScrollPane => scrollbalken)		
 * & TODO 11.2.4,   s.342 uf (selectionMode => markierte einträge)
 * 
 * class ScrollListbox_JScrollPane_SelectionMode_ArrayList_Notenbilanz
 *
 * 
 * PROGRAMM:	 notenbilanz mit SCROLLBALKEN in Listbox & MARKIERBAREN EINTRÄGEN (& ArrayList ) gelöst 
 * 
 * 
 * 11.2.3 SCROLLBALKEN erzeugen mit der KLASSE JSCROLLPANE: 	
 * 
 * 		VORGEHEN [= eine schon vorhandene ListBox (JList & ListModel) im nachhinein mit scrollbalken versehen]:
 * 
 * 		1. zusätzlich JScrollPane in den JPanel/container ziehen 		
 * 			=> jigloo menueleiste > container > JScrollPane anklicken 	& 	irgendwo im angewählten (grün umrandeten) JPanel-bereich ablegen
 * 
 * 		2. in der Outline (= menu rechts):		
 * 			=> jList (hier jListNoten) ins JScrollPane (hier jScrollPane1) hineinziehen, sodass jList ein unterpunkt vom jScrollPane ist
 * 			[ACHTUNG:	am einfachsten in der Outline, weil JSccrollPane eigentlich ein container(grüne umrandung) ist & s sonst spinnt]
 * 
 * 		3. im code: 	=> position/grösse (.setBounds(226, 146, 183, 86)) von JList kopieren & bei JScrollPane einfügen (-> deckungsgleich)
 * 						 -> wenn man will, dass die darstellung von grösse/position von der listbox beibehalten wird
 * 						 	[Jlist mit scrollbalken funktioniert auch ohne dass die position/grösse deckungsgleich ist, glaub wegen .setViewportView(..)]
 * 
 *		3. verknüpfung JScrollPane & JList macht's automatisch mit: 	=> jScrollPane1.setViewportView(jListNoten)  
 *
 *
 * 11.2.4 MARKIERTE EINTRÄGE mit SELECTIONMODE:
 * 
 * 		VORGEHEN:
 * 	
 *  	1. SelectionMode in den Properties (outline) von JList festlegen		=> bestimmt markierungsmöglichkeiten in der ListBox	 
 *  																			=> hier auf SINGLE_SELECTION (= nur einfach-auswahl)
 *  
 *		2. Programmlogik anpassen:		TF- & L- Notennummer löschen, werden überflüssig 
 *		   Programmlogik anpassen:  	BtnNotennummer: 	- text ändern
 *
 *	  	3. INDEX EINES zu beabeitenden ELEMENTS ERMITTELN:		
 *			=> neu über den angewählten eintrag in der Listbox mit: 	=> .getSelectedIndex() der OPTISCHEN klasse JLIST 
 *																												[NICHT der verwaltenden klasse JListModel]
 *		   	=> hier:	in BtnNotennummer- methode:						=> notennummer = jListNoten.getSelectedIndex()
 *
 *
 * K&K:	Programm Notenbilanz berechnet aus mehreren eingegebenen Noten den Notenschnitt und gibt zusätzlich die beste, die
 * 		schlechteste Note aus. Die Noten werden in einer JList mit Rollbalken, die bei Bedarf eingeblendet werden, gesammelt. 
 * 		Die Noten werden in einer JList gesammelt. Einzelne Noten können auch nachträglich bearbeitet werden.
 * 
 * 		ACHTUNG, wenn der letzte wert von ArrayList gelöscht wird, gibts nur noch einen minifehler bei der ausgabe der methode notenbilanzErstellen()
 */

package uebungen11;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;	// import wird wie immer auch davon automatisch eingefügt
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;// automatischer import beim anpassen vom selectionMode
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

public class ScrollListbox_JScrollPane_SelectionMode_ArrayList_Notenbilanz extends javax.swing.JFrame {
	private JLabel jLNote;
	private JButton jBtnNoteUebernehmen;
	private JLabel jLNotenschnitt;
	private JLabel jLSchlechtesteNote;
	private JScrollPane jScrollPane1;
	private JButton jBtnLoeschen;
	private JButton jBtnNeuenWertspeichern;
	private JTextField jTFNeuerWert;
	private JLabel jLNeuerWert;
	private JButton jBtnNotennummer;

	private JList jListNoten;	
	private DefaultListModel jListNotenModel; 
		
	private JLabel jLNoten;		
	private JButton jBtnEnde;
	private JButton jBtnNeu;
	private JLabel jLNotenzahl;
	private JLabel jLBesteNote;
	private JTextField jTFNote;
	
	private DecimalFormat fzahl; 
	private int notennummer;
	private ArrayList<Double> noten;
	

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ScrollListbox_JScrollPane_SelectionMode_ArrayList_Notenbilanz inst = new ScrollListbox_JScrollPane_SelectionMode_ArrayList_Notenbilanz();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public ScrollListbox_JScrollPane_SelectionMode_ArrayList_Notenbilanz() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setPreferredSize(new java.awt.Dimension(437, 309));
			this.setTitle("Notenbilanz");
			{
				fzahl = new DecimalFormat("#0.00"); 
			}
			{
				jLNote = new JLabel();
				getContentPane().add(jLNote);
				jLNote.setText("1.Note");
				jLNote.setBounds(6, 24, 47, 14);
			}
			{
				jTFNote = new JTextField();
				getContentPane().add(jTFNote);
				jTFNote.setBounds(6, 44, 41, 21);
			}
			{
				jBtnNoteUebernehmen = new JButton();
				getContentPane().add(jBtnNoteUebernehmen);
				jBtnNoteUebernehmen.setText("Übernehmen");
				jBtnNoteUebernehmen.setBounds(51, 44, 142, 21);
				jBtnNoteUebernehmen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnNoteUebernehmenActionPerformed(evt);
					}
				});
			}
			{
				jLBesteNote = new JLabel();
				getContentPane().add(jLBesteNote);
				jLBesteNote.setBounds(6, 162, 365, 19);
			}
			{
				jLNotenschnitt = new JLabel();
				getContentPane().add(jLNotenschnitt);
				jLNotenschnitt.setBounds(6, 137, 296, 19);
			}
			{
				jLSchlechtesteNote = new JLabel();
				getContentPane().add(jLSchlechtesteNote);
				jLSchlechtesteNote.setBounds(6, 187, 365, 19);
			}
			{
				jLNotenzahl = new JLabel();
				getContentPane().add(jLNotenzahl);
				jLNotenzahl.setBounds(6, 117, 374, 14);
			}
			{
				jBtnNeu = new JButton();
				getContentPane().add(jBtnNeu);
				jBtnNeu.setText("Neue Berechnung");
				jBtnNeu.setBounds(238, 8, 140, 21);
				jBtnNeu.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnNeuActionPerformed(evt);
					}
				});
			}
			{
				jBtnEnde = new JButton();
				getContentPane().add(jBtnEnde);
				jBtnEnde.setText("Ende");
				jBtnEnde.setBounds(277, 243, 94, 21);
				jBtnEnde.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnEndeActionPerformed(evt);
					}
				});
			}
			{
				jLNoten = new JLabel();
				getContentPane().add(jLNoten);
				jLNoten.setText("Noten:");	
				jLNoten.setBounds(226, 124, 59, 18);
			}  
		/*	{	// überflüssig: neu mit anwählen von einträgen in ListBox gelöst 
				jTFNotennummer = new JTextField();
				getContentPane().add(jTFNotennummer);
				jTFNotennummer.setBounds(226, 44, 35, 21);
			}
			{		// überflüssig: neu mit anwählen von einträgen in ListBox gelöst 
				jLNotennummer = new JLabel();
				getContentPane().add(jLNotennummer);
				jLNotennummer.setText(".Note bearbeiten");
				jLNotennummer.setBounds(267, 47, 98, 14);
			} */
			{
				jBtnNotennummer = new JButton();
				getContentPane().add(jBtnNotennummer);
				// Btn text ändern, dass es sich auf den markierten eintrag der ListBox bezieht
				jBtnNotennummer.setText("markierte Note bearbeiten");
				jBtnNotennummer.setBounds(204, 44, 214, 21);
				jBtnNotennummer.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnNotennummerActionPerformed(evt);
					}
				});
			}
			{
				jLNeuerWert = new JLabel();
				getContentPane().add(jLNeuerWert);
				jLNeuerWert.setText("Note");
				jLNeuerWert.setBounds(252, 71, 50, 14);
				jLNeuerWert.setVisible(false);
			}
			{
				jTFNeuerWert = new JTextField();
				getContentPane().add(jTFNeuerWert);
				jTFNeuerWert.setBounds(252, 91, 50, 21);
				jTFNeuerWert.setVisible(false);
			}
			{
				jBtnNeuenWertspeichern = new JButton();
				getContentPane().add(jBtnNeuenWertspeichern);
				jBtnNeuenWertspeichern.setText("Speichern");
				jBtnNeuenWertspeichern.setBounds(308, 92, 110, 21);
				jBtnNeuenWertspeichern.setVisible(false);
				jBtnNeuenWertspeichern.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnNeuenWertspeichernActionPerformed(evt);
					}
				});
			}
			{
				jBtnLoeschen = new JButton();
				getContentPane().add(jBtnLoeschen);
				jBtnLoeschen.setText("Löschen");
				jBtnLoeschen.setBounds(308, 117, 109, 21);
				jBtnLoeschen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnLoeschenActionPerformed(evt);
					}
				});
				jBtnLoeschen.setVisible(false);
			}
			{
				jScrollPane1 = new JScrollPane();
				getContentPane().add(getJScrollPane1());
				jScrollPane1.setBounds(226, 146, 183, 86);
				{	// JList muss im JScrollPane drin sein (in der Outline eins ins andere ziehen)
					// LISTBOX grundsätzlich siehe class Listbox_ArrayList_Basics_Notenbilanz
					jListNotenModel = new DefaultListModel();
					jListNoten = new JList();				 
					jScrollPane1.setViewportView(jListNoten); // verknüpfung wird auch auto generiert
					jListNoten.setModel(jListNotenModel); 	
					jListNoten.setBounds(226, 146, 183, 86);
					// markierungsmöglichkeiten in der ListBox auf: nur ein eintrag anwählbar
					// in properties (outline) von jListNoten verstellen
					jListNoten.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				}	
			}
			pack();
			this.setSize(437, 309);
		} catch (Exception e) {
			e.printStackTrace();
		}
		noten = new ArrayList<Double>();
		jTFNote.requestFocus();
		jTFNote.selectAll();
	}

	private void notenbilanzErstellen() {
		double summe, besteNote, schlechtesteNote, notenschnitt;
		jLNotenzahl.setText("Anzahl eingegebene Noten: " + noten.size()); 
		summe = 0;
		if (noten.size() != 0) {				// (korriegierte version von ArrayList_Angewandt_Notenbilanz_.. übernommen)...
			besteNote = noten.get(0);			// ...hat nix zu tun mit den anpassungen an die ListBox...
			schlechtesteNote = noten.get(0);
		} else {						
			besteNote = 0;				
			schlechtesteNote = 0;				// ...(bis hier)
		}
		for (double x: noten) {
			summe = summe + x;
			if ( besteNote < x) 
				besteNote = x;
			if ( schlechtesteNote > x) 
				schlechtesteNote = x;
		}
		notenschnitt = summe / noten.size(); 
		jLBesteNote.setText("Beste Note: " + besteNote);
		jLSchlechtesteNote.setText("Schlechteste Note: " + schlechtesteNote);
		jLNotenschnitt.setText("Notenschnitt: " + notenschnitt);
	}

	private void jBtnNoteUebernehmenActionPerformed(ActionEvent evt) {
		try { // zusätzliches try/catch für allgemeine eingabefehler
			if (!jTFNote.getText().equals("")
				&& Double.parseDouble(jTFNote.getText()) >= 1
				&& Double.parseDouble(jTFNote.getText()) <= 6){
				noten.add(Double.parseDouble(jTFNote.getText()));
				jListNotenModel.addElement(jTFNote.getText());
				notenbilanzErstellen();
				jLNote.setText((noten.size() + 1) + " .Note");
				jTFNote.setText("");
				jTFNote.requestFocus();
			} else {
				JOptionPane.showMessageDialog(null, "gültige Note eingeben!");
				jTFNote.requestFocus();
				jTFNote.selectAll();;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ungültiges Zahlenformat!");
			jTFNote.requestFocus();
			jTFNote.selectAll();
		}
	}

	private void jBtnNotennummerActionPerformed(ActionEvent evt) {
		// Notennummer(index) ermitteln neu über den angewählten eintrag in der Listbox...
		// .. mit methode .getSelectedIndex() der optischen klasse JList (!!!NICHT der verwaltenden klasse JListModel, mit der man z.b. einträge hinzufügt) 
		notennummer = jListNoten.getSelectedIndex(); 						// war mal: 	notennummer = Integer.parseInt(jTFNotennummer.getText()) - 1;
		if ((notennummer >= 0) && (notennummer < noten.size())) {
			jLNeuerWert.setText((notennummer + 1) + ". Note"); 
			jLNeuerWert.setVisible(true); 
			jTFNeuerWert.setText(String.valueOf(noten.get(notennummer)));
			jTFNeuerWert.setVisible(true); 
			jBtnNeuenWertspeichern.setVisible(true);
			jBtnLoeschen.setVisible(true);
			jTFNeuerWert.requestFocus();
			jTFNeuerWert.selectAll();
		} else {
			JOptionPane.showMessageDialog(null, "keine Note markiert!");
		}
	}

	private void jBtnNeuenWertspeichernActionPerformed(ActionEvent evt) {
		try { 
			// wenn eingabefeld nicht leer und note zwischen 1-6
			if (!jTFNeuerWert.getText().equals("")
					&& Double.parseDouble(jTFNeuerWert.getText()) >= 1
					&& Double.parseDouble(jTFNeuerWert.getText()) <= 6) {
				noten.set(notennummer, Double.parseDouble(jTFNeuerWert.getText()));
				jListNotenModel.setElementAt(jTFNeuerWert.getText(), notennummer);
				notenbilanzErstellen();
				jLNeuerWert.setVisible(false);
				jTFNeuerWert.setVisible(false);
				jBtnNeuenWertspeichern.setVisible(false);
				jBtnLoeschen.setVisible(false);
				jTFNote.requestFocus();
				jTFNote.selectAll();
			} else { 	
				JOptionPane.showMessageDialog(null, "gültige Note eingeben!");
				jTFNeuerWert.requestFocus();
				jTFNeuerWert.selectAll();
			}
		} catch (Exception e) { 
			JOptionPane.showMessageDialog(null, "ungültiges Zahlenformat!");
			jTFNeuerWert.requestFocus();
			jTFNeuerWert.selectAll();
		}
	}
	// 
	private void jBtnLoeschenActionPerformed(ActionEvent evt) {				
		try {
			noten.remove(notennummer);
			jListNotenModel.remove(notennummer);
			notenbilanzErstellen();
			jLNeuerWert.setVisible(false);
			jTFNeuerWert.setVisible(false);
			jBtnNeuenWertspeichern.setVisible(false);
			jBtnLoeschen.setVisible(false);
			jLNote.setText((noten.size() + 1) + " .Note");
			jTFNote.requestFocus();
			jTFNote.selectAll();
		} catch (Exception e) {
		    JOptionPane.showMessageDialog(null, "Fehler beim löschen!");
		}
	}

	private void jBtnNeuActionPerformed(ActionEvent evt) {
		noten.clear();
		jListNotenModel.clear();
		jLNote.setText((noten.size() + 1) + ".Note");
		jTFNote.setText("");
		jLNotenschnitt.setText("");
		jLBesteNote.setText("");
		jLSchlechtesteNote.setText("");
		jLNotenzahl.setText("");
		jLNeuerWert.setVisible(false);
		jTFNeuerWert.setVisible(false);
		jBtnNeuenWertspeichern.setVisible(false);
		jBtnLoeschen.setVisible(false);
		jTFNote.requestFocus();
		jTFNote.selectAll();
	}

	private void jBtnEndeActionPerformed(ActionEvent evt) {
		System.exit(0);
	}
	
	// selbstgenerierte methode von jigloo beim einfügen von JList in JScrollPane
	// wird beim einbinden in den container gebraucht siehe zeile 232: 
	// getContentPane().add(getJScrollPane1());   wird hier mit getter-methode eingefügt statt direkt JScrollPane1
	public JScrollPane getJScrollPane1() {
		return jScrollPane1;
	}
}

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
