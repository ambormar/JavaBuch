/* TODO 13.4.5.   s.435 (eigtl. buchDVD), FontChooser zum aufrufen / benutzen
 * class JMyFontChooser extends Component
 * 
 * 		AUFRUF SIEHE:		13.5.	FontChooser_JMyFontChooser_??_Textzeichner2		Aufgabe 4, s.436 
 * 
 * K&K:		Klasse JMyFontChooser 
 *			fertige Klasse ist von buchDVD kopiert, zum benutzen als FontChooser. die klasse war nicht als übungsprogramm zum selber schreiben erklärt. 
 * 			Die Klasse ist von der Standardkomponente JComponent abgeleitet. Sie dient als Auswahldialog (wie JFileChooser oder JColorChooser) für Schriftart und Schriftattribute.
 * 
 * 
 * VORGEHEN:	keine angaben, weil kein übungsprogramm mit anleitung im buch. sondern nur fertige komponente zum benutzen / aufrufen
 * 
 */

package uebungen13;

import java.awt.Component;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.ListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class JMyFontChooser extends Component {
	{
		// Set Look & Feel
		try {
			javax.swing.UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static JDialog jDialog;
	private static JLabel jLSchriftart;
	private static JComboBox jComboBSchriftart;
	private static DefaultComboBoxModel jComboBSchriftartModel;
	private static JLabel jLSchriftgroesse;
	private static JLabel jLStil;
	private static JScrollPane jScrollPane1;
	private static JList jListSchriftprobe;
	private static JButton jBtnAbbrechen;
	private static JButton jBtnOK;
	private static JLabel jLSchriftprobe;
	private static JCheckBox jCBkursiv;
	private static JCheckBox jCBfett;
	private static JSpinner jSpinSchriftgroesse;
	private static SpinnerNumberModel jSpinSchriftgroesseModel;
	private static Font schrift;

	public static Font showDialog(Component comp, Font font) {
		if (font == null) {
			font = new Font("Arial", 0, 12);
		}
		schrift = font;
		JFrame frame = new JFrame();
		jDialog = new JDialog(frame, "Schriftart wählen", true);
		jDialog.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				thisWindowClosing(evt);
			}
		});

		if (font == null)
			font = new Font("Dialog", Font.BOLD, 12);

		ActionListener al = new ActionListener() {
			public void actionPerformed(ActionEvent aevt) {
				String ac = aevt.getActionCommand();
				if (ac.equals("Schriftart")) {
					jListSchriftprobe.setFont(schriftfestlegen());
				} else if (ac.equals("fett")) {
					jListSchriftprobe.setFont(schriftfestlegen());
				} else if (ac.equals("kursiv")) {
					jListSchriftprobe.setFont(schriftfestlegen());
				} else if (ac.equals("OK")) {
					schrift = schriftfestlegen();
					jDialog.setVisible(false);
				} else if (ac.equals("Abbrechen")) {
					schrift = null;
					jDialog.setVisible(false);
				}
			}
		};
		try {
			{
				jDialog.getContentPane().setLayout(null);
				jDialog.setTitle("Schriftart wählen");
				jDialog.setModal(true);
				jDialog.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent evt) {
						thisWindowClosing(evt);
					}
				});
				{
					jLSchriftart = new JLabel();
					jDialog.getContentPane().add(jLSchriftart);
					jLSchriftart.setText("Schriftart");
					jLSchriftart.setBounds(10, 11, 45, 14);
				}
				{
					GraphicsEnvironment ge = GraphicsEnvironment
							.getLocalGraphicsEnvironment();
					String[] fonts = ge.getAvailableFontFamilyNames();
					jComboBSchriftartModel = new DefaultComboBoxModel(fonts);
					jComboBSchriftart = new JComboBox();
					jComboBSchriftart.setActionCommand("Schriftart");
					jDialog.getContentPane().add(jComboBSchriftart);
					jComboBSchriftart.setModel(jComboBSchriftartModel);
					jComboBSchriftart.setBounds(10, 31, 160, 20);
					if (schrift != null) {
						jComboBSchriftartModel.setSelectedItem(schrift
								.getFontName());
					}
					jComboBSchriftart.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jComboBSchriftartActionPerformed(evt);
						}
					});
					if (schrift != null) {
						jComboBSchriftartModel.setSelectedItem(schrift
								.getFontName());
					}
				}
				{
					jLSchriftgroesse = new JLabel();
					jDialog.getContentPane().add(jLSchriftgroesse);
					jLSchriftgroesse.setText("Schriftgröße");
					jLSchriftgroesse.setBounds(187, 11, 59, 14);
				}
				{
					if (schrift != null) {
						jSpinSchriftgroesseModel = new SpinnerNumberModel(
								schrift.getSize(), 1, 120, 1);
					} else {
						jSpinSchriftgroesseModel = new SpinnerNumberModel(12,
								1, 120, 1);
					}
					if (schrift != null)
						jSpinSchriftgroesseModel.setValue(schrift.getSize());
					jSpinSchriftgroesse = new JSpinner();
					jDialog.getContentPane().add(jSpinSchriftgroesse);
					jSpinSchriftgroesse.setModel(jSpinSchriftgroesseModel);
					jSpinSchriftgroesse.setBounds(187, 31, 71, 20);
					jSpinSchriftgroesse.addChangeListener(new ChangeListener() {
						public void stateChanged(ChangeEvent evt) {
							jSpinSchriftgroesseStateChanged(evt);
						}
					});
				}
				{
					jCBfett = new JCheckBox("fett", schrift.isBold());
					jDialog.getContentPane().add(jCBfett);
					jCBfett.setText("fett");
					jCBfett.setBounds(275, 30, 43, 23);
					if (schrift != null) {
						if (schrift.isBold())
							jCBfett.setSelected(true);
						else
							jCBfett.setSelected(false);
						jCBfett.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								jCBfettActionPerformed(evt);
							}
						});

					}
				}
				{
					jCBkursiv = new JCheckBox("kursiv", schrift.isItalic());
					jDialog.getContentPane().add(jCBkursiv);
					jCBkursiv.setText("kursiv");
					jCBkursiv.setBounds(275, 55, 53, 23);
					if (schrift != null) {
						if (schrift.isItalic()) {
							jCBkursiv.setSelected(true);
						} else {
							jCBkursiv.setSelected(false);
						}
						jCBkursiv.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								jCBkursivActionPerformed(evt);
							}
						});
					}
				}
				{
					jLStil = new JLabel();
					jDialog.getContentPane().add(jLStil);
					jLStil.setText("Stil");
					jLStil.setBounds(275, 11, 14, 14);
				}
				{
					jLSchriftprobe = new JLabel();
					jDialog.getContentPane().add(jLSchriftprobe);
					jLSchriftprobe.setText("Schriftprobe");
					jLSchriftprobe.setBounds(15, 87, 59, 14);
				}
				{
					jBtnOK = new JButton();
					jDialog.getContentPane().add(jBtnOK);
					jBtnOK.setText("OK");
					jBtnOK.setBounds(55, 232, 77, 23);
					jBtnOK.addActionListener(al);
				}
				{
					jBtnAbbrechen = new JButton();
					jDialog.getContentPane().add(jBtnAbbrechen);
					jBtnAbbrechen.setText("Abbrechen");
					jBtnAbbrechen.setBounds(258, 232, 85, 23);
					jBtnAbbrechen.addActionListener(al);
				}
				{
					jScrollPane1 = new JScrollPane();
					jDialog.getContentPane().add(jScrollPane1);
					jScrollPane1.setBounds(15, 107, 362, 104);
					{
						ListModel jListSchriftprobeModel = new DefaultComboBoxModel(
								new String[] { "ABCDEFGHIJKLMNOPQRSTUVWXYZÄÖÜ",
										"abcdefghijklmnopqrstuvwxyzäöüß",
										",.;:+-*/(){}[]!§$%&/\\#~" });
						jListSchriftprobe = new JList();
						jScrollPane1.setViewportView(jListSchriftprobe);
						jListSchriftprobe.setModel(jListSchriftprobeModel);
						jListSchriftprobe.setBorder(new LineBorder(
								new java.awt.Color(0, 0, 0), 1, false));
						if (schrift != null)
							jListSchriftprobe.setFont(schrift);
					}
				}
			}
			jDialog.setSize(400, 300);
			jDialog.setLocationRelativeTo(comp);
			jDialog.setVisible(true);
			jDialog.dispose();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return schrift;
	}

	private static void jCBfettActionPerformed(ActionEvent evt) {
		schriftfestlegen();
	}

	private static void jCBkursivActionPerformed(ActionEvent evt) {
		schriftfestlegen();
	}

	private static void jSpinSchriftgroesseStateChanged(ChangeEvent evt) {
		schriftfestlegen();
	}

	private static void jComboBSchriftartActionPerformed(ActionEvent evt) {
		schriftfestlegen();
	}

	private static void thisWindowClosing(WindowEvent evt) {
		schrift = null;
	}

	public static Font showDialog(Component comp) {
		return showDialog(comp, comp.getFont());
	}

	private static Font schriftfestlegen() {
		String name = (String) jComboBSchriftart.getSelectedItem();
		int stil = (jCBfett.isSelected() ? Font.BOLD : Font.PLAIN)
				| (jCBkursiv.isSelected() ? Font.ITALIC : Font.PLAIN);
		int groesse = jSpinSchriftgroesseModel.getNumber().intValue();
		Font nf = new Font(name, stil, groesse);
		jListSchriftprobe.setFont(nf);
		return nf;
	}
}
