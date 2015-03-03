package uebungen13;

/*
 * Programm Zeichnen3 (Unter Verwendung von Graphics2D statt Graphics)
 * Dem Anwender steht ein Panel, auf das er verschiedene geometrische
 * Figuren zeichnen kann, zur Verfügung. Position und Größe der Figuren
 * können frei bestimmt werden.
 * 
 * Hans-Peter Habelitz
 * 2011-12-26
 */

import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

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
public class Zeichnen3 extends javax.swing.JFrame {
	private JLabel jLZeichenflaeche;
	private JPanel jPanelZeichenflaeche;
	private JLabel jLPositionx1;
	private JLabel jLPositiony1;
	private JLabel jLPositionx2;
	private JTextField jTFPositionx2;
	private JLabel jLPositiony2;
	private JButton jBtnEnde;
	private JButton jBtnZeichnen;
	private JCheckBox jCheckBgefuellt;
	private JRadioButton jRBtnLinie;
	private JRadioButton jRBtnOval;
	private JTextField jTFPositiony2;
	private JTextField jTFPositiony1;
	private JTextField jTFPositionx1;
	private JRadioButton jRBtnKreis;
	private JRadioButton jRBtnRechteck;
	private ButtonGroup jBtnGrpFigur;
	private char figur = 'K';
	private int x1, y1, x2, y2;
	private Graphics2D g2d;

	{
		// Set Look & Feel
		try {
			javax.swing.UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Zeichnen3 inst = new Zeichnen3();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public Zeichnen3() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			AnchorLayout thisLayout = new AnchorLayout();
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Zeichnen3");
			getContentPane().setBackground(new java.awt.Color(236, 233, 216));
			{
				jRBtnLinie = new JRadioButton();
				getContentPane().add(
						getJBtnEnde(),
						new AnchorConstraint(756, 756, 819, 616,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL));
				getContentPane().add(
						getJBtnZeichnen(),
						new AnchorConstraint(530, 831, 591, 616,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL));
				getContentPane().add(
						getJCheckBgefuellt(),
						new AnchorConstraint(224, 971, 287, 804,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL));
				getContentPane().add(
						jRBtnLinie,
						new AnchorConstraint(414, 765, 477, 616,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL));
				jRBtnLinie.setText("Linie");
				jRBtnLinie.setPreferredSize(new java.awt.Dimension(80, 23));
				jRBtnLinie.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jRBtnLinieActionPerformed(evt);
					}
				});
				getBtnGrpFigur().add(jRBtnLinie);
			}
			{
				jRBtnOval = new JRadioButton();
				getContentPane().add(
						jRBtnOval,
						new AnchorConstraint(351, 765, 414, 616,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL));
				jRBtnOval.setText("Oval");
				jRBtnOval.setPreferredSize(new java.awt.Dimension(80, 23));
				jRBtnOval.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jRBtnOvalActionPerformed(evt);
					}
				});
				getBtnGrpFigur().add(jRBtnOval);
			}
			{
				jRBtnKreis = new JRadioButton();
				getContentPane().add(
						jRBtnKreis,
						new AnchorConstraint(287, 765, 351, 616,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL));
				jRBtnKreis.setText("Kreis");
				jRBtnKreis.setPreferredSize(new java.awt.Dimension(80, 23));
				jRBtnKreis.setBackground(new java.awt.Color(236, 233, 216));
				jRBtnKreis.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jRBtnKreisActionPerformed(evt);
					}
				});
				getBtnGrpFigur().add(jRBtnKreis);
			}
			{
				jRBtnRechteck = new JRadioButton();
				getContentPane().add(
						jRBtnRechteck,
						new AnchorConstraint(224, 765, 287, 616,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL));
				jRBtnRechteck.setText("Rechteck");
				jRBtnRechteck.setPreferredSize(new java.awt.Dimension(80, 23));
				jRBtnRechteck.setBackground(new java.awt.Color(236, 233, 216));
				jRBtnRechteck.setSelected(true);
				jRBtnRechteck.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jRBtnRechteckActionPerformed(evt);
					}
				});
				getBtnGrpFigur().add(jRBtnRechteck);
			}
			{
				jTFPositiony2 = new JTextField();
				getContentPane().add(
						jTFPositiony2,
						new AnchorConstraint(106, 971, 161, 878,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL));
				jTFPositiony2.setText("0");
				jTFPositiony2.setPreferredSize(new java.awt.Dimension(50, 20));
			}
			{
				jLPositiony2 = new JLabel();
				getContentPane().add(
						jLPositiony2,
						new AnchorConstraint(114, 871, 150, 804,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL));
				jLPositiony2.setText("Höhe:");
				jLPositiony2.setPreferredSize(new java.awt.Dimension(36, 13));
				jLPositiony2.setHorizontalTextPosition(SwingConstants.LEADING);
				jLPositiony2.setHorizontalAlignment(SwingConstants.RIGHT);
			}
			{
				jTFPositionx2 = new JTextField();
				getContentPane().add(
						jTFPositionx2,
						new AnchorConstraint(106, 774, 161, 681,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL));
				jTFPositionx2.setText("0");
				jTFPositionx2.setPreferredSize(new java.awt.Dimension(50, 20));
			}
			{
				jLPositionx2 = new JLabel();
				getContentPane().add(
						jLPositionx2,
						new AnchorConstraint(114, 674, 150, 553,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL));
				jLPositionx2.setText("Breite:");
				jLPositionx2.setPreferredSize(new java.awt.Dimension(65, 13));
				jLPositionx2.setHorizontalTextPosition(SwingConstants.LEADING);
				jLPositionx2.setHorizontalAlignment(SwingConstants.RIGHT);
			}
			{
				jTFPositiony1 = new JTextField();
				getContentPane().add(
						jTFPositiony1,
						new AnchorConstraint(12, 971, 67, 878,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL));
				jTFPositiony1.setText("0");
				jTFPositiony1.setPreferredSize(new java.awt.Dimension(50, 20));
			}
			{
				jLPositiony1 = new JLabel();
				getContentPane().add(
						jLPositiony1,
						new AnchorConstraint(17, 871, 61, 843,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL));
				jLPositiony1.setText("y:");
				jLPositiony1.setPreferredSize(new java.awt.Dimension(15, 16));
				jLPositiony1.setHorizontalTextPosition(SwingConstants.LEADING);
				jLPositiony1.setHorizontalAlignment(SwingConstants.RIGHT);
			}
			{
				jTFPositionx1 = new JTextField();
				getContentPane().add(
						jTFPositionx1,
						new AnchorConstraint(12, 776, 67, 683,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL));
				jTFPositionx1.setText("0");
				jTFPositionx1.setPreferredSize(new java.awt.Dimension(50, 20));
			}
			{
				jLPositionx1 = new JLabel();
				getContentPane().add(
						jLPositionx1,
						new AnchorConstraint(17, 676, 61, 546,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL));
				jLPositionx1.setText("Position x:");
				jLPositionx1.setPreferredSize(new java.awt.Dimension(70, 16));
				jLPositionx1.setHorizontalTextPosition(SwingConstants.LEADING);
				jLPositionx1.setHorizontalAlignment(SwingConstants.RIGHT);
			}
			{
				jPanelZeichenflaeche = new JPanel();
				getContentPane().add(
						jPanelZeichenflaeche,
						new AnchorConstraint(97, 546, 979, 13,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL));
				jPanelZeichenflaeche.setPreferredSize(new java.awt.Dimension(
						287, 320));
				jPanelZeichenflaeche.setBackground(new java.awt.Color(255, 255,
						255));
			}
			{
				jLZeichenflaeche = new JLabel();
				getContentPane().add(
						jLZeichenflaeche,
						new AnchorConstraint(23, 182, 67, 13,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL,
								AnchorConstraint.ANCHOR_REL));
				jLZeichenflaeche.setText("Zeichenfläche");
				jLZeichenflaeche
						.setPreferredSize(new java.awt.Dimension(91, 16));
			}
			pack();
			this.setSize(547, 397);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

	private ButtonGroup getBtnGrpFigur() {
		if (jBtnGrpFigur == null) {
			jBtnGrpFigur = new ButtonGroup();
		}
		return jBtnGrpFigur;
	}

	private JCheckBox getJCheckBgefuellt() {
		if (jCheckBgefuellt == null) {
			jCheckBgefuellt = new JCheckBox();
			jCheckBgefuellt.setText("gefüllt");
			jCheckBgefuellt.setPreferredSize(new java.awt.Dimension(90, 23));
		}
		return jCheckBgefuellt;
	}

	private JButton getJBtnZeichnen() {
		if (jBtnZeichnen == null) {
			jBtnZeichnen = new JButton();
			jBtnZeichnen.setText("Zeichnen");
			jBtnZeichnen.setPreferredSize(new java.awt.Dimension(114, 22));
			jBtnZeichnen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jBtnZeichnenActionPerformed(evt);
				}
			});
		}
		return jBtnZeichnen;
	}

	private JButton getJBtnEnde() {
		if (jBtnEnde == null) {
			jBtnEnde = new JButton();
			jBtnEnde.setText("Ende");
			jBtnEnde.setPreferredSize(new java.awt.Dimension(75, 23));
			jBtnEnde.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jBtnEndeActionPerformed(evt);
				}
			});
		}
		return jBtnEnde;
	}

	private void jBtnEndeActionPerformed(ActionEvent evt) {
		System.exit(0);
	}

	private void setzeBeschriftungen() {
		if (jRBtnLinie.isSelected()) {
			jLPositionx1.setText("Startpunkt x:");
			jLPositionx2.setText("Endpunkt x:");
			jLPositiony2.setText("y:");
		} else {
			jLPositionx1.setText("Position x:");
			jLPositionx2.setText("Breite:");
			jLPositiony2.setText("Höhe:");
		}
	}

	private void jRBtnRechteckActionPerformed(ActionEvent evt) {
		setzeBeschriftungen();
		jCheckBgefuellt.setVisible(true);
		jLPositiony2.setVisible(true);
		jTFPositiony2.setVisible(true);
		figur = 'R';
	}

	private void jRBtnKreisActionPerformed(ActionEvent evt) {
		setzeBeschriftungen();
		jCheckBgefuellt.setVisible(true);
		jLPositiony2.setVisible(false);
		jTFPositiony2.setVisible(false);
		figur = 'K';
	}

	private void jRBtnOvalActionPerformed(ActionEvent evt) {
		setzeBeschriftungen();
		jCheckBgefuellt.setVisible(true);
		jLPositiony2.setVisible(true);
		jTFPositiony2.setVisible(true);
		figur = 'O';
	}

	private void jRBtnLinieActionPerformed(ActionEvent evt) {
		setzeBeschriftungen();
		jCheckBgefuellt.setVisible(false);
		jLPositiony2.setVisible(true);
		jTFPositiony2.setVisible(true);
		figur = 'L';
	}

	private void jBtnZeichnenActionPerformed(ActionEvent evt) {
		try {
			x1 = Integer.parseInt(jTFPositionx1.getText());
			y1 = Integer.parseInt(jTFPositiony1.getText());
			x2 = Integer.parseInt(jTFPositionx2.getText());
			y2 = Integer.parseInt(jTFPositiony2.getText());
			g2d = (Graphics2D) jPanelZeichenflaeche.getGraphics();
			g2d.setColor(Color.red);
			BasicStroke stil = new BasicStroke(30.0f, BasicStroke.CAP_ROUND,
					BasicStroke.JOIN_BEVEL);
			g2d.setStroke(stil);
			GradientPaint fuellung = new GradientPaint(0, 0, Color.yellow, 100,
					100, Color.red, true);
			g2d.setPaint(fuellung);
			switch (figur) {
			case 'R':
				Rectangle2D.Float rechteck = new Rectangle2D.Float(x1, y1, x2,
						y2);
				if (jCheckBgefuellt.isSelected()) {
					g2d.fill(rechteck);
				} else {
					g2d.draw(rechteck);
				}
				break;
			case 'K':
				Ellipse2D.Float oval = new Ellipse2D.Float(x1, y1, x2, x2);
				if (jCheckBgefuellt.isSelected()) {
					g2d.fill(oval);
				} else {
					g2d.draw(oval);
				}
				break;
			case 'O':
				Ellipse2D.Float kreis = new Ellipse2D.Float(x1, y1, x2, y2);
				if (jCheckBgefuellt.isSelected()) {
					g2d.fill(kreis);
				} else {
					g2d.draw(kreis);
				}
				break;
			case 'L':
				Line2D.Float linie = new Line2D.Float(x1, y1, x2, y2);
				g2d.draw(linie);
				break;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Die Eingaben sind ungültig.");
		}
	}

}