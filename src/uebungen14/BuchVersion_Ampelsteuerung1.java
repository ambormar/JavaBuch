/* TODO 14.2.1.   s.440, ohne 2. thread, ohne paintImmediately()
 * class BuchVersion_Ampelsteuerung1	&	BuchVersion_JAmpelPanel1
 * 
 * 
 * ZUR VERANSCHAULICHUNG: 		programm funktioniert nicht fehlerfrei weil paintImmediately oder ein 2. thread fehlen
 * 
 * 		FUNKTIONSFÄHIG SIEHE:		14.2.1.  PaintImmediately_Sleep_InterruptedException_OhneEigenenThread_Einfache_Ampelsteuerung2		&	JAmpelPanel			s.440,	
 *			
 *		BZW MIT 2.THREAD:			14.2.2.		Tread_.._Ampelsteuerung3 																&	JAmpelPanel			s.447
 *
 *
 * Programm Ampelsteuerung_1 (ohne eigenen Thread und ohne paintImmediately)
 * Das Programm nutzt die Klasse JAmpelPanel. Die Ampel kann manuell
 * in die vier Ampelphasen geschaltet und ausgeschaltet werden.
 * Die Phasenwechsel der Ampel werden nicht sichtbar.
 * Die Automatik versetzt die Ampelsteuerung in eine Endlosschleife, die
 * aus der Entwicklungsumgebung nur noch über den Stop-Button der Console-
 * View gestoppt werden kann.
 * 
 */

package uebungen14;

import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

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
public class BuchVersion_Ampelsteuerung1 extends javax.swing.JFrame {
	private BuchVersion_JAmpelPanel1 jAmpel;
	private JPanel jPanel1;
	private JRadioButton jRBtnGelb;
	private JRadioButton jRBtnAus;
	private JCheckBox jCBAutomatik;
	private JRadioButton jRBtnRotGelb;
	private JRadioButton jRBtnGruen;
	private JRadioButton jRBtnRot;
	private ButtonGroup btnGrp1;
	private int rotPhase = 3000;
	private int rotgelbPhase = 500;
	private int gruenPhase = 3000;
	private int gelbPhase = 500;

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				BuchVersion_Ampelsteuerung1 inst = new BuchVersion_Ampelsteuerung1();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public BuchVersion_Ampelsteuerung1() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			AnchorLayout thisLayout = new AnchorLayout();
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Ampelsteuerung");
			{
				jPanel1 = new JPanel();
				getContentPane().add(
						getJCBAutomatik(),
						new AnchorConstraint(738, 884, 825, 567,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL));
				getContentPane().add(
						jPanel1,
						new AnchorConstraint(43, 937, 712, 500,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL));
				jPanel1.setPreferredSize(new java.awt.Dimension(116, 178));
				jPanel1.setBorder(BorderFactory
						.createTitledBorder("Handsteuerung"));
				{
					jRBtnRot = new JRadioButton();
					jPanel1.add(jRBtnRot);
					jRBtnRot.setText("Rot");
					jRBtnRot.setPreferredSize(new java.awt.Dimension(82, 23));
					getBtnGrp1().add(jRBtnRot);
					jRBtnRot.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jRBtnRotActionPerformed(evt);
						}
					});
				}
				{
					jRBtnGruen = new JRadioButton();
					jPanel1.add(getJRBtnRotGelb());
					jPanel1.add(jRBtnGruen);
					jPanel1.add(getJRBtnGelb());
					jPanel1.add(getJRBtnAus());
					jRBtnGruen.setText("Grün");
					jRBtnGruen.setPreferredSize(new java.awt.Dimension(80, 23));
					getBtnGrp1().add(jRBtnGruen);
					jRBtnGruen.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jRBtnGruenActionPerformed(evt);
						}
					});
				}
			}
			{
				jAmpel = new BuchVersion_JAmpelPanel1();
				getContentPane().add(
						jAmpel,
						new AnchorConstraint(43, 304, 960, 24,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL));
				jAmpel.setPreferredSize(new java.awt.Dimension(75, 244));
			}
			pack();
			this.setSize(273, 300);
			jAmpel.setPhase(0);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

	private ButtonGroup getBtnGrp1() {
		if (btnGrp1 == null) {
			btnGrp1 = new ButtonGroup();
		}
		return btnGrp1;
	}

	private JRadioButton getJRBtnRotGelb() {
		if (jRBtnRotGelb == null) {
			jRBtnRotGelb = new JRadioButton();
			jRBtnRotGelb.setText("Rot/Gelb");
			getBtnGrp1().add(jRBtnRotGelb);
			jRBtnRotGelb.setPreferredSize(new java.awt.Dimension(81, 23));
			jRBtnRotGelb.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jRBtnRotGelbActionPerformed(evt);
				}
			});
		}
		return jRBtnRotGelb;
	}

	private JRadioButton getJRBtnGelb() {
		if (jRBtnGelb == null) {
			jRBtnGelb = new JRadioButton();
			jRBtnGelb.setText("Gelb");
			jRBtnGelb.setPreferredSize(new java.awt.Dimension(79, 23));
			getBtnGrp1().add(jRBtnGelb);
			jRBtnGelb.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jRBtnGelbActionPerformed(evt);
				}
			});
		}
		return jRBtnGelb;
	}

	private JCheckBox getJCBAutomatik() {
		if (jCBAutomatik == null) {
			jCBAutomatik = new JCheckBox();
			jCBAutomatik.setText("Automatik");
			jCBAutomatik.setPreferredSize(new java.awt.Dimension(84, 23));
			jCBAutomatik.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jCBAutomatikActionPerformed(evt);
				}
			});
		}
		return jCBAutomatik;
	}

	private JRadioButton getJRBtnAus() {
		if (jRBtnAus == null) {
			jRBtnAus = new JRadioButton();
			jRBtnAus.setText("Aus");
			jRBtnAus.setPreferredSize(new java.awt.Dimension(79, 23));
			jRBtnAus.setSelected(true);
			getBtnGrp1().add(jRBtnAus);
			jRBtnAus.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jRBtnAusActionPerformed(evt);
				}
			});
		}
		return jRBtnAus;
	}

	private void jRBtnAusActionPerformed(ActionEvent evt) {
		jAmpel.setPhase(0);
	}

	private void jRBtnRotActionPerformed(ActionEvent evt) {
		jAmpel.setPhase(1);
	}

	private void jRBtnRotGelbActionPerformed(ActionEvent evt) {
		jAmpel.setPhase(2);
	}

	private void jRBtnGruenActionPerformed(ActionEvent evt) {
		jAmpel.setPhase(3);
	}

	private void jRBtnGelbActionPerformed(ActionEvent evt) {
		jAmpel.setPhase(4);
	}

	private void jCBAutomatikActionPerformed(ActionEvent evt) {
		if (jCBAutomatik.isSelected()) {
			jRBtnRot.setEnabled(false);
			jRBtnRotGelb.setEnabled(false);
			jRBtnGruen.setEnabled(false);
			jRBtnGelb.setEnabled(false);
			jRBtnAus.setEnabled(false);
			while (jCBAutomatik.isSelected()) {
				try {
					jCBAutomatik.repaint();
					jAmpel.setPhase(1);
					Thread.sleep(rotPhase);
					jAmpel.setPhase(2);
					Thread.sleep(rotgelbPhase);
					jAmpel.setPhase(3);
					Thread.sleep(gruenPhase);
					jAmpel.setPhase(4);
					Thread.sleep(gelbPhase);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} else {
			jRBtnAus.setSelected(true);
			jRBtnRot.setEnabled(true);
			jRBtnRotGelb.setEnabled(true);
			jRBtnGruen.setEnabled(true);
			jRBtnGelb.setEnabled(true);
			jRBtnAus.setEnabled(true);
			jAmpel.setPhase(0);
		}
	}

}