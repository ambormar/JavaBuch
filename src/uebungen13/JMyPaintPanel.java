/* TODO 13.2.5.   s.413, (3. ANSATZ)   JMyPaintPanel extends JPanel
 * class JMyPaintPanel	&	JPanel_RepaintBeiFrameveraenderungen_Komponente_ZumHineinZeichnen_Zeichnen4	&	Zeichenobjekt
 * 
 * 
 */

package uebungen13;

import java.awt.Dimension;

import javax.swing.WindowConstants;
import javax.swing.JFrame;

public class JMyPaintPanel extends javax.swing.JPanel {

	/**
	* Auto-generated main method to display this 
	* JPanel inside a new JFrame.
	*/
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new JMyPaintPanel());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public JMyPaintPanel() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setPreferredSize(new Dimension(400, 300));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
