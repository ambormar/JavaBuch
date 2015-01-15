/* TODO .9.3.(eigtl. 12.4.2.)   s.385,  Eigenes Bsp.		!!!!!!!!!!!!!!	
 * class Jigloo_AnchorLayout_Basics_BspButton 
 * 
 * SIEHE BSP ANGEWANDT:	12.4.2.   ImageIO_Klasse_Basics_JFilechooser_Bildbetrachter		s.382 	 
 * 
 * Stichworte:
 * 	- AnchorLayout
 * 	- AnchorConstraints	(absolute, relative, none)
 * 	- setPreferedSize(..)
 * 
 * 	JFRAME mit ANCHORLAYOUT:		
 * 
 * 		- Jigloo-ansicht > Menue-leiste > Layout > AnchorLayout anklicken > im angew�hlten JFrame erneut klicken
 * 
 * 			Code dazu im initGUI():					AnchorLayout thisLayout = new AnchorLayout();
													getContentPane().setLayout(thisLayout);
 * 
 * 
 * 	ANCHORCONSTRAINTS (ANKER-RAND-BEDINGUNGEN) F�R DIE JEWEILIGE KOMPONENTE:	 HIER AM BSP. BUTTON:
 * 
 * 		= angaben wie sich die r�nder einer komponente zu den r�ndern des containers verhalten sollen
 * 
 * 		- Jigloo-ansicht > JButton machen + anw�hlen > schwarzen pfeil klicken > auswahlfenster: f�r den jeweiligen rand (oben, re, unten, li) AnchorConstraints w�hlen
 * 							
 * 			=> 3 M�GLICHKEITEN:		1. gerader anker:	= AnchorConstraint.ANCHOR_ABS 	(= zahlenangabe als absolutwerte in pixel)
 * 									2. anker, schr�g:	= AnchorConstraint.ANCHOR_REL 	(= zahlenangabe relativ zur gr�sse des containers)
 * 									3. durchgestrichen:	= AnchorConstraint.ANCHOR_NONE 	(= keine verankerung		&	li, obere ecke 0,0		&	keine werte n�tig: werden mit .setPreferedSize() eh �berschrieben)
 * 								
 * 			- CODE-BSP: 	jButton = new JButton();
							getContentPane().add(jButton, new AnchorConstraint(109, 151, 130, 135, 				// parameter:	abst�nde nach top, right, bottom, left
																				AnchorConstraint.ANCHOR_NONE,	// verankerungsart f�r top		: keine
																				AnchorConstraint.ANCHOR_NONE, 	// verankerungsart f�r right	: keine
																				AnchorConstraint.ANCHOR_ABS, 	// verankerungsart f�r bottom	: absolut in px
																				AnchorConstraint.ANCHOR_REL));	// verankerungsart f�r left		: relativ zu container
 * 								
 * 			- ANCHOR_REL:	 BERECHNUNG IN PX:		=> ausdehnung container in px 	* 	relativ-angabe (zal)	:	1000 
 * 																							 ______________________________________
 * 					 								=> abst�nde beziehen jeweils sich auf:	|		A top		A					|
 * 																							|left	�_________	�					|
 * 																							|<------|_________|	� bottom			|
 * 																							|<-----------------						|
 * 																							|			  right						|
 * 																							|______________________________________ |
 * 
 * 			- ANCHOR_ABS:	
 *
 *		- PreferedSize setzen in den properties (od. code):			jBtnOeffnen.setPreferredSize(new java.awt.Dimension(107, 20) 
 *
 * 		- ANCHORLAYOUT SIEHE AUCH: 		9.3.(eigtl. 12.4.2.)   Jigloo_AnchorLayout_Basics_BspButton	s.385, 	
 * 
 * 		- CODE & KOMMENTS SIEHE:	initGUI()	JBtnOeffnen		&		event-methode jBtnOeffnen..(..) * 
 */

package uebungen12;
import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;
import javax.swing.JButton;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


public class Jigloo_AnchorLayout_Basics_BspButton extends javax.swing.JFrame {
	private JButton jButton1;
	private JButton jButton2;
	private JButton jButton3;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Jigloo_AnchorLayout_Basics_BspButton inst = new Jigloo_AnchorLayout_Basics_BspButton();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public Jigloo_AnchorLayout_Basics_BspButton() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			AnchorLayout thisLayout = new AnchorLayout();
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jButton3 = new JButton();
				getContentPane().add(jButton3, new AnchorConstraint(109, 151, 130, 135, AnchorConstraint.ANCHOR_ABS, AnchorConstraint.ANCHOR_ABS, AnchorConstraint.ANCHOR_ABS, AnchorConstraint.ANCHOR_ABS));
				jButton3.setText("jButton3");
				jButton3.setPreferredSize(new java.awt.Dimension(98, 23));
			}
			{
				jButton2 = new JButton();
				getContentPane().add(jButton2, new AnchorConstraint(196, 417, 291, 162, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jButton2.setText("jButton2");
				jButton2.setPreferredSize(new java.awt.Dimension(98, 25));
			}
			{
				jButton1 = new JButton();
				getContentPane().add(jButton1, new AnchorConstraint(104, 186, 135, 79, AnchorConstraint.ANCHOR_NONE, AnchorConstraint.ANCHOR_NONE, AnchorConstraint.ANCHOR_NONE, AnchorConstraint.ANCHOR_NONE));
				jButton1.setText("jButton1");
				jButton1.setPreferredSize(new java.awt.Dimension(98, 26));
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
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