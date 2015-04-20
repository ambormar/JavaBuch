/* TODO 14.2.1.  s.440,
 * class 	OhneZweitenThread_MitPaintImmediately_Einfache_Ampelsteuerung2		&	JAmpelPanel			
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
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import uebungen13Aufgaben.JPanel_KomponenteFuerTextPerMausklick_RadioGroup_Graphics2d_TextZeichner1;

public class OhneZweitenThread_MitPaintImmediately_Einfache_Ampelsteuerung2 extends JFrame {
	
	private JAmpelPanel jAmpel;					// jPanel mit name jAmpel aber typ JPanerl durch JAmpelPanel (selbstabgeleitete komponente von JPanel) ersetzen 
	private JPanel jPanel1;
	private JRadioButton jRBGruen;
	private ButtonGroup BtnGrpFigur;
	private JRadioButton jRBAus;
	private JRadioButton jRBGelb;
	private JRadioButton jRBRotGelb;
	private JRadioButton jRBRot;
	private JCheckBox jCBAutomatik;
	private int rotPhase = 3000;
	private int rotgelbPhase = 1000;
	private int gruenPhase = 3000;
	private int gelbPhase = 1000;
	
	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				OhneZweitenThread_MitPaintImmediately_Einfache_Ampelsteuerung2 inst = new OhneZweitenThread_MitPaintImmediately_Einfache_Ampelsteuerung2();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	
	public OhneZweitenThread_MitPaintImmediately_Einfache_Ampelsteuerung2() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			AnchorLayout thisLayout = new AnchorLayout();
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Einfache Ampelsteuerung 1, JAmpelPanel gesteuert über RadioButtons / Checkbox");
			{
				jCBAutomatik = new JCheckBox();
				getContentPane().add(jCBAutomatik, new AnchorConstraint(783, 829, 877, 430, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jCBAutomatik.setText("Automatik");
				jCBAutomatik.setPreferredSize(new java.awt.Dimension(153, 34));
				jCBAutomatik.setFont(new java.awt.Font("Arial",1,11));
				jCBAutomatik.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jCBAutomatikActionPerformed(evt);
					}
				});
			}
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1, new AnchorConstraint(73, 829, 725, 430, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jPanel1.setPreferredSize(new java.awt.Dimension(153, 236));
				jPanel1.setBorder(BorderFactory.createTitledBorder(null, "Handsteuerung", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial",1,11)));
				jPanel1.setFont(new java.awt.Font("Arial",1,11));
				{
					jRBRot = new JRadioButton();
					jPanel1.add(jRBRot);
					AnchorLayout jRBRotLayout = new AnchorLayout();
					jRBRot.setLayout(jRBRotLayout);
					jRBRot.setText("Rot");
					jRBRot.setPreferredSize(new java.awt.Dimension(125, 35));
					jRBRot.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jRBRotActionPerformed(evt);
						}
					});
					getBtnGrpFigur().add(jRBRot);
				}
				{
					jRBRotGelb = new JRadioButton();
					jPanel1.add(jRBRotGelb);
					jRBRotGelb.setText("RotGelb");
					jRBRotGelb.setPreferredSize(new java.awt.Dimension(125, 35));
					jRBRotGelb.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jRBRotGelbActionPerformed(evt);
						}
					});
					getBtnGrpFigur().add(jRBRotGelb);
				}
				{
					jRBGruen = new JRadioButton();
					jPanel1.add(jRBGruen);
					jRBGruen.setText("Grün");
					jRBGruen.setPreferredSize(new java.awt.Dimension(125, 35));
					jRBGruen.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jRBGruenActionPerformed(evt);
						}
					});
					getBtnGrpFigur().add(jRBGruen);
				}
				{
					jRBGelb = new JRadioButton();
					jPanel1.add(jRBGelb);
					jRBGelb.setText("Gelb");
					jRBGelb.setPreferredSize(new java.awt.Dimension(125, 35));
					jRBGelb.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jRBGelbActionPerformed(evt);
						}
					});
					getBtnGrpFigur().add(jRBGelb);
				}
				{
					jRBAus = new JRadioButton();
					jPanel1.add(jRBAus);
					AnchorLayout jRBRotLayout = new AnchorLayout();
					jRBAus.setLayout(jRBRotLayout);
					jRBAus.setText("Aus");
					jRBAus.setPreferredSize(new java.awt.Dimension(125, 35));
					jRBAus.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							jRBAusActionPerformed(evt);
						}
					});
					getBtnGrpFigur().add(jRBAus);
				}
			}
			{
				jAmpel = new JAmpelPanel();
				getContentPane().add(jAmpel, new AnchorConstraint(73, 326, 924, 66, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jAmpel.setPreferredSize(new java.awt.Dimension(100, 308));
			}
			pack();
			this.setSize(400, 400);
			jAmpel.setPhase(0);		// ampel initialisieren: aufruf schnittstellen-methode setPhase(..) der klasse JAmpelPanel unter mitgabe von int-wert 0 (=> phase : aus)
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private ButtonGroup getBtnGrpFigur() {
		if(BtnGrpFigur == null) {
			BtnGrpFigur = new ButtonGroup();
		}
		return BtnGrpFigur;
	}
	
	private void jRBAusActionPerformed(ActionEvent evt) {
		jAmpel.setPhase(0);
	}
	
	private void jRBRotActionPerformed(ActionEvent evt) {
		jAmpel.setPhase(1);
	}
	
	private void jRBRotGelbActionPerformed(ActionEvent evt) {
		jAmpel.setPhase(2);
	}
	
	private void jRBGruenActionPerformed(ActionEvent evt) {
		jAmpel.setPhase(3);

	}
	
	private void jRBGelbActionPerformed(ActionEvent evt) {
		jAmpel.setPhase(4);

	}
	
	private void jCBAutomatikActionPerformed(ActionEvent evt) {
		if (jCBAutomatik.isSelected()){
			jRBAus.setEnabled(false);
			jRBRot.setEnabled(false);
			jRBRotGelb.setEnabled(false);
			jRBGruen.setEnabled(false);
			jRBGelb.setEnabled(false);
			jPanel1.paintImmediately(0, 0, jPanel1.getWidth(), jPanel1.getHeight());	// von JComponent weitervererbte methode zum neuzeichnen der jeweiligen komponente mit vier int-werten für den betreffenden bereich
			while (jCBAutomatik.isSelected()) {
				try {
					jCBAutomatik.paintImmediately(0, 0, jCBAutomatik.getWidth(), jCBAutomatik.getHeight());		// checkbox immediately neuzeichnen
					jAmpel.setPhase(1);
					jAmpel.paintImmediately(0, 0, jAmpel.getWidth(), jAmpel.getHeight());
					Thread.sleep(rotPhase);
					jAmpel.setPhase(2);
					jAmpel.paintImmediately(0, 0, jAmpel.getWidth(), jAmpel.getHeight());
					Thread.sleep(rotgelbPhase);
					jAmpel.setPhase(3);
					jAmpel.paintImmediately(0, 0, jAmpel.getWidth(), jAmpel.getHeight());
					Thread.sleep(gruenPhase);
					jAmpel.setPhase(4);
					jAmpel.paintImmediately(0, 0, jAmpel.getWidth(), jAmpel.getHeight());
					Thread.sleep(gelbPhase);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} else {
			jRBAus.setSelected(true);
			jRBAus.setEnabled(true);
			jRBRot.setEnabled(true);
			jRBRotGelb.setEnabled(true);
			jRBGruen.setEnabled(true);
			jRBGelb.setEnabled(true);
			jAmpel.setPhase(0);
		}

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