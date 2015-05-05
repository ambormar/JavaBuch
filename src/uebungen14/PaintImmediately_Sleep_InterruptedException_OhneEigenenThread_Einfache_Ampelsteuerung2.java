/* TODO 14.2.1.   s.440, (verwendet JAmpelPanel)  
 * class 	PaintImmediately_Sleep_InterruptedException_OhneEigenenThread_Einfache_Ampelsteuerung2		&	JAmpelPanel	
 * 
 * 		SIEHE BASICS:			14.2.2.a.		Threads_Klasse_Basics_Methoden_Konstruktoren_Eigenschaften_2ArtenDerThreadErstellung		s.447
 * 
 * 		VERGLEICHE AUCH:		14.2.2.d.		Thread_ImplementsRunnable_Run_Ampelsteuerung3	& 	JAmpelPanel	_3							s.451		
 * 
 * 
 * 	K&K:	Klasse JAmpelPanel:			(von der Komponente JPanel abgeleitet)
 * 										Die Klasse dient der Darstellung einer Ampel mit den vier Ampelphasen.
 * 
 * 
 * 			Programm Ampelsteuerung2:	(ohne eigenen Thread, aber mit paintImmediately(), sleep() und InterruptedException )
 * 
 * 										Das Programm nutzt die Klasse JAmpelPanel. Die Ampel kann manuell in die vier Ampelphasen geschaltet und ausgeschaltet werden.
 * 										Die Phasenwechsel werden im Automatikbetrieb -  mit hilfe von paintImmediately() der klasse jComponent - sichtbar, aber die Automatik 
 * 										versetzt die Ampelsteuerung in eine Endlosschleife, die aus der Entwicklungsumgebung nur noch über den Stop-Button der Console-
 * 										View gestoppt werden kann. 	 
 * 
 * 	METHODEN (besondere):	
 * 				
 * 		void sleep(long m)					der Klasse Thread		-> erzwingt eine pause in der ausführung des laufenden threads (auch des main-threads) von m millisekunden.
 * 																	-> zwingt zu InterruptedException-handling, da threads wiedersprüche auslösen können. 
 * 																			-> auch bei blosser verwendung der methode, ohne dass ein 2. thread erzeugt wurde
 * 																	-> kann zu unterbrechungen des restlichen programm-ablaufs ( z.b. initGUI()) führen 
 * 																			-> fehler beim ablauf des komponenten darstellens z.b. mit paintImmediately() lösen		(diese programm)
 * 																			-> oder besser einen zusätzlichen thread machen 
 * 																					SIEHE: 		14.2.2.		Tread_.._Ampelsteuerung3 	s.447
 * 
 * 		void paintImmediately(int x, 		der Klasse JComponent	-> methode zum sofortigen neuzeichnen der jeweiligen komponente mit vier int-werten für den betreffenden bereich
 * 			int y, int width, int height)							-> parameter-angaben: 	-> bsp: 		jPanel1.paintImmediately(0, 0, jPanel1.getWidth(), jPanel1.getHeight());
 * 
 * 
 *	EXCEPTIONS:		
 *
 *		InterruptedException				der klasse Thread		-> bei verwendung von Threads können diese sich gegenseitig unterbrechen
 *																	-> der unterbrochene thread wirft dann eine InterruptedException
 *																	-> bei einsatz von Threads, alleine durch verwendung der methode sleep(..) 
 *																		-> muss ein exception-handling für InterruptedExceptions erfolgen 
 *																				->  Throws oder try-catch-block
 * 
 * 	VORGEHEN: 	
 * 
 * 		KLASSE JAmpelPanel:		
 * 
 * 			=> von der Komponente JPanel abgeleitet, um sie in der aufrufenden klasse Ampelsteuerung2 anstelle eines standard-jpanels einzusetzen
 * 
 * 			=> Die Klasse dient der Darstellung einer Ampel mit den vier Ampelphasen.
 * 
 * 			=> fields: 		int phase = 0;					// variable für die ampel-phasen für den switch (5 mögliche zustände: rot, gelb-rot, grün, gelb + aus)
 *							Color cOben, cMitte, cUnten;	// farb-variablen für die 3 ampel-kreise oben, mitte, unten
 *							
 * 			=> paintComponent-methode der superklasse überschreiben, damit die änderungen der komponente (panel) jeweils neugezeichnet werden bei frame-veränderungen
 * 
 *						public void paintComponent(Graphics g) {
 *							super.paintComponent(g);					// effektiver aufruf der methode der superklasse unter weitergabe des grafik-objekts g
 *							..
 *							switch (phase) {							// switch-case für ampel zustände 
 *							case 0:										// fall: ampel aus
 *								cOben = Color.gray;
 *								cMitte = Color.gray;
 *								cUnten = Color.gray;
 *								break;
 *							case 1:	..									// fall: ampel rot
 *							case 2:	..									// fall: ampel gelb-rot
 *							case 3:	..									// fall: ampel grün
 *							case 4:	..									// fall: ampel gelb
 *							}
 *							..											// zeichenen der ampel-lampen
 *							g.setColor(cOben);							// zuerst aktuelle farbe der obersten lampe setzen, je nach case 
 *							g.fillOval(3, 3, b, h);						// .. dann oberste lampe zeichnen
 *							..											// .. usw. für 2. & 3. lampe
 *						}
 *									
 *			=> methode als schnittstelle nach aussen, um die ampel in die jeweilige phase versetzen zu können
 *								
 *						public void setPhase(int i) {					// parameter i, um den zustand der phase beim aufruf übergeben zu können		
 *							phase = i;									// phase auf i setzen
 *							repaint();									// neuzeichnen der komponente
 *						}  	
 *										
 *										
 *		PROGRAMM Ampelsteuerung2:		(ACHTUNG BEIM LAUFEN LASSEN: AUTOMATIK-MODUS NUR STOP-BAR MITTELS STOP-KNOPF DER KONSOLE !)
 *		
 *				-> ohne eigenen Thread, aber mit paintImmediately(), sleep() und InterruptedException 
 *	  
 *	  			=> JFrame mit JAmpelPanel (jAmpel) anstelle eines JPanels für die darstellung der Ampel
 *	  
 *	  					private JAmpelPanel jAmpel = new JAmpelPanel();
 *	  
 *	  			=> 5 radiobuttons (aus, rot, rotgelb, grün, gelb) (inkl. ButtonGroup) mit handler-methoden für handsteuerung der ampelphasen 
 *	  					-> werden für bessere ordnung innerhalb eines jPanels mit titleborder (handsteuerung) dargestellt 
 *	  
 *	  					SIEHE:		jPanel1  im  initGUI()
 *	  								
 *	  			=> checkbox jCBAutomatik mit handler method, um auf automatik-modus der ampelsteuerung zu wechseln
 *	  					
 *	  			=> fields: 		private int rotPhase = 3000;		// int-variablen für die zeiten der phasen in milisekunden (werden später der sleep-methode als parameter übergeben)
 *	  							... usw								// .. für gelbrotPhase, gruenPhase, gelbPhase
 *	  
 * 	  			=> ende initGUI():	jAmpel.setPhase(0);		// jAmpel initialisieren: aufruf schnittstellen-methode setPhase(..) der klasse JAmpelPanel unter mitgabe von int-wert 0 (=> phase : aus)
 *	   	
 *	  			=> handler methoden der 5 radaiobuttons zur handsteuerung implementieren:
 *	  				-> via schnittstellen-methode setPhase(..) von JAmpelPanel, wird private int phase (von JAmpelPanel)  auf 0-4 (5 ampelzustände) gesetzt setzen, 
 *	  				-> der repaint() wird auch gleich in setPhase() (von JAmpelPanel) erledigt
 *	  
 *			 		BSP:	private void jRBAusActionPerformed(ActionEvent evt) {		// handsteuerung: radiobutton aus: 
 *									jAmpel.setPhase(0);										// phase auf 0 (= aus) setzen
 *								}							
 *	 
 *				=> handler methode für checkbox um automatik-modus (der ampelsteuerung) ein- und auszuschalten 
 *					-> mit while-schleife in der durch die phasen geschaltet wird mit kurzen zeitunterbrechungen (für phasen-dauer) durch methode sleep(..) von klasse Thread
 *						-> führt dazu. dass der gesamt programm-ablauf (auch GUI) unterbrochen wird, 
 *						-> also muss das zeichnen der sich veränderneden komponenten sofort erzwungen werden mit paintImmediately(..) der klasse jComponent
 *				
 *						private void jCBAutomatikActionPerformed(ActionEvent evt) {
 *							if (jCBAutomatik.isSelected()){																			// wenn checkbox (automatik) angewählt ist:
 *								jRBAus.setEnabled(false);																			// alle readiobuttons (der handsteuerung) inaktiv setzen
 *								...																									
 *								jPanel1.paintImmediately(0, 0, jPanel1.getWidth(), jPanel1.getHeight());							// von JComponent weitervererbte methode zum neuzeichnen der jeweiligen komponente mit vier int-werten für den betreffenden bereich
 *								while (jCBAutomatik.isSelected()) {																	// schleife um immer wieder die 4 ampelphasen durchlaufen zu lassen
 *									try {
 *										jCBAutomatik.paintImmediately(0, 0, jCBAutomatik.getWidth(), jCBAutomatik.getHeight());		// checkbox immediately neuzeichnen 
 *										jAmpel.setPhase(1);																			// via schnittstellen-methode setPhase(..) von JAmpelPanel, phase auf 1 (= rot) setzen, repaint() wird in setPhase() erledigt
 *										jAmpel.paintImmediately(0, 0, jAmpel.getWidth(), jAmpel.getHeight());						// jAmpel immediately neuzeichnen 
 *										Thread.sleep(rotPhase);																		// thread unterbrechen (rotphasen => milisekunden)
 *										jAmpel.setPhase(2);																			// usw. für jede der 4 farb-phasen
 * 										... 
 *	 								} catch (InterruptedException e) {																// Thread-speziefische exception: sobald threads im spiel sind (es reicht schon die methode sleep() von thread
 *										e.printStackTrace();
 *									}
 *								}
 *							} else {											// wenn automatik nicht (mehr) eingeschaltet ist..
 *								jRBAus.setSelected(true);						// radiobutton aus auf angewählt setzen
 *								jRBAus.setEnabled(true);						// alle radiobuttons aktiv setzen
 *								...						// 
 *								jAmpel.setPhase(0);								// via schnittstellen-methode setPhase(..) von JAmpelPanel, phase wieder auf 0 (= aus) setzen, repaint() wird in setPhase() erledigt
 *							}
 *					
 *						}  
 * 
 *
 * 				=> PROBLEMCHEN:		Die Phasenwechsel werden im Automatikbetrieb -  mit hilfe von paintImmediately() der klasse jComponent - sichtbar, aber die Automatik 
 * 									versetzt die Ampelsteuerung in eine Endlosschleife, die aus der Entwicklungsumgebung nur noch über den Stop-Button der Console-
 * 									View gestoppt werden kann. 
 * 
 * 				=> PROBLEM-LÖSUNG: 	(=> checkbox automatik nach gebrauch wieder abwählbar machen:) 		
 * 									=> die anweisungen der while-schleife (Thread.sleep(rotPhase) etc.) müssen in einem 2. Thread ausgeführt werden
 * 										-> damit sie den restlichen programm-ablauf (initGUI()) nicht mit-unterbrechen
 * 
 * 									SIEHE:		14.2.2.d.		Thread_ImplementsRunnable_Run_Ampelsteuerung3			s.451
 * 
 * 
 */

package uebungen14;
import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;				// gui speziefisch (umrandung des jPanels)
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;			// gui speziefisch (umrandung des jPanels)
import javax.swing.border.TitledBorder;			// gui speziefisch (titel der umrandung des jPanels)

import uebungen13Aufgaben.JPanel_KomponenteFuerTextPerMausklick_RadioGroup_Graphics2d_TextZeichner1;

public class PaintImmediately_Sleep_InterruptedException_OhneEigenenThread_Einfache_Ampelsteuerung2 extends JFrame {
	
	private JAmpelPanel jAmpel;					// jPanel mit name jAmpel aber typ JPanel durch JAmpelPanel (selbstabgeleitete komponente von JPanel) ersetzen 
	private JPanel jPanel1;						// zusätzliches panel wo die radio-buttons drin sind (gui vereinfachung) 
	private JRadioButton jRBGruen;
	private ButtonGroup BtnGrpFigur;
	private JRadioButton jRBAus;
	private JRadioButton jRBGelb;
	private JRadioButton jRBRotGelb;
	private JRadioButton jRBRot;
	private JCheckBox jCBAutomatik;
	private int rotPhase = 3000;				// int-variablen für die zeiten der phasen in milisekunden (werden später der sleep-methode als parameter übergeben)
	private int rotgelbPhase = 1000;			// int-variablen für die zeiten der phasen in milisekunden (werden später der sleep-methode als parameter übergeben)
	private int gruenPhase = 3000;				// int-variablen für die zeiten der phasen in milisekunden (werden später der sleep-methode als parameter übergeben)
	private int gelbPhase = 1000;				// int-variablen für die zeiten der phasen in milisekunden (werden später der sleep-methode als parameter übergeben)
	
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
				PaintImmediately_Sleep_InterruptedException_OhneEigenenThread_Einfache_Ampelsteuerung2 inst = new PaintImmediately_Sleep_InterruptedException_OhneEigenenThread_Einfache_Ampelsteuerung2();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	
	public PaintImmediately_Sleep_InterruptedException_OhneEigenenThread_Einfache_Ampelsteuerung2() {
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
				jCBAutomatik = new JCheckBox();			// checkbox um auf automatik-modus der ampelsteuerung zu wechseln
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
				jPanel1 = new JPanel();					// jPanel (zur gui-zusammenfassung aller radio-buttons (= die gesamte handsteuerung der ampel)
				getContentPane().add(jPanel1, new AnchorConstraint(73, 829, 725, 430, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jPanel1.setPreferredSize(new java.awt.Dimension(153, 236));
				jPanel1.setBorder(BorderFactory.createTitledBorder(null, "Handsteuerung", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial",1,11))); // umrandung des jPanels
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
				jAmpel = new JAmpelPanel();		// jPanel mit name jAmpel aber typ JPanel durch JAmpelPanel (selbstabgeleitete komponente von JPanel) ersetzen
				getContentPane().add(jAmpel, new AnchorConstraint(73, 326, 924, 66, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jAmpel.setPreferredSize(new java.awt.Dimension(100, 308));
			}
			pack();
			this.setSize(400, 400);
			jAmpel.setPhase(0);		// jAmpel initialisieren: aufruf schnittstellen-methode setPhase(..) der klasse JAmpelPanel unter mitgabe von int-wert 0 (=> phase : aus)
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private ButtonGroup getBtnGrpFigur() {																	// buttongroup für zusammenspiel der radiobuttons
		if(BtnGrpFigur == null) {
			BtnGrpFigur = new ButtonGroup();
		}
		return BtnGrpFigur;
	}
	
	private void jRBAusActionPerformed(ActionEvent evt) {	// handsteuerung: radiobutton aus: 
		jAmpel.setPhase(0);									// via schnittstellen-methode setPhase(..) von JAmpelPanel, phase auf 0 (= aus) setzen, repaint() wird in setPhase() erledigt
	}
	
	private void jRBRotActionPerformed(ActionEvent evt) {	// handsteuerung: radiobutton rot: 
		jAmpel.setPhase(1);									// via schnittstellen-methode setPhase(..) von JAmpelPanel, phase auf 1 (= rot) setzen, repaint() wird in setPhase() erledigt
	}
	
	private void jRBRotGelbActionPerformed(ActionEvent evt){// handsteuerung: radiobutton rotgelb: 
		jAmpel.setPhase(2);									// via schnittstellen-methode setPhase(..) von JAmpelPanel, phase auf 2 (= rotgelb) setzen, repaint() wird in setPhase() erledigt
	}
	
	private void jRBGruenActionPerformed(ActionEvent evt) {	// handsteuerung: radiobutton grün: 
		jAmpel.setPhase(3);									// via schnittstellen-methode setPhase(..) von JAmpelPanel, phase auf 3 (= grün) setzen, repaint() wird in setPhase() erledigt
	}
	
	private void jRBGelbActionPerformed(ActionEvent evt) { 	// handsteuerung: radiobutton gelb: 
		jAmpel.setPhase(4);									// via schnittstellen-methode setPhase(..) von JAmpelPanel, phase auf 4 (= gelb) setzen, repaint() wird in setPhase() erledigt
	}
	
	// handler methode für checkbox um automatik-modus (der ampelsteuerung) ein- und auszuschalten 
	private void jCBAutomatikActionPerformed(ActionEvent evt) {
		if (jCBAutomatik.isSelected()){						// wenn checkbox (automatik) angewählt ist:
			jRBAus.setEnabled(false);						// alle readiobuttons (der handsteuerung) inaktiv setzen
			jRBRot.setEnabled(false);						
			jRBRotGelb.setEnabled(false);
			jRBGruen.setEnabled(false);
			jRBGelb.setEnabled(false);
			jPanel1.paintImmediately(0, 0, jPanel1.getWidth(), jPanel1.getHeight());	// von JComponent weitervererbte methode zum neuzeichnen der jeweiligen komponente mit vier int-werten für den betreffenden bereich
			while (jCBAutomatik.isSelected()) {				// schleife um immer wieder die 4 ampelphasen durchlaufen zu lassen
				try {
					jCBAutomatik.paintImmediately(0, 0, jCBAutomatik.getWidth(), jCBAutomatik.getHeight());		// checkbox immediately neuzeichnen 
					jAmpel.setPhase(1);																			// via schnittstellen-methode setPhase(..) von JAmpelPanel, phase auf 1 (= rot) setzen, repaint() wird in setPhase() erledigt
					jAmpel.paintImmediately(0, 0, jAmpel.getWidth(), jAmpel.getHeight());						// jAmpel immediately neuzeichnen 
					Thread.sleep(rotPhase);																		// thread unterbrechen (rotphasen => milisekunden)
					jAmpel.setPhase(2);																			// via schnittstellen-methode setPhase(..) von JAmpelPanel, phase auf 2 (= rotgelb) setzen, repaint() wird in setPhase() erledigt
					jAmpel.paintImmediately(0, 0, jAmpel.getWidth(), jAmpel.getHeight());						// jAmpel immediately neuzeichnen 
					Thread.sleep(rotgelbPhase);																	// thread unterbrechen (rotgelbphasen => milisekunden)
					jAmpel.setPhase(3);																			// via schnittstellen-methode setPhase(..) von JAmpelPanel, phase auf 3 (= grün) setzen, repaint() wird in setPhase() erledigt
					jAmpel.paintImmediately(0, 0, jAmpel.getWidth(), jAmpel.getHeight());						// jAmpel immediately neuzeichnen 
					Thread.sleep(gruenPhase);																	// thread unterbrechen (gruenphasen => milisekunden)
					jAmpel.setPhase(4);																			// via schnittstellen-methode setPhase(..) von JAmpelPanel, phase auf 4 (= gelb) setzen, repaint() wird in setPhase() erledigt
					jAmpel.paintImmediately(0, 0, jAmpel.getWidth(), jAmpel.getHeight());						// jAmpel immediately neuzeichnen 
					Thread.sleep(gelbPhase);																	// thread unterbrechen (gelbphasen => milisekunden)
				} catch (InterruptedException e) {																// Thread-speziefische exception: sobald threads im spiel sind (es reicht schon die methode sleep() von thread
					e.printStackTrace();
				}
			}
		} else {											// wenn automatik nicht (mehr) eingeschaltet ist..
			jRBAus.setSelected(true);						// radiobutton aus auf angewählt setzen
			jRBAus.setEnabled(true);						// alle radiobuttons aktiv setzen
			jRBRot.setEnabled(true);						// dito
			jRBRotGelb.setEnabled(true);					// dito
			jRBGruen.setEnabled(true);						// dito
			jRBGelb.setEnabled(true);						// dito
			jAmpel.setPhase(0);								// via schnittstellen-methode setPhase(..) von JAmpelPanel, phase wieder auf 0 (= aus) setzen, repaint() wird in setPhase() erledigt
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