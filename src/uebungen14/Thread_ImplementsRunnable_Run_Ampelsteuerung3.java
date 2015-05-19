/* TODO 14.2.2.d.   s.451, 2. Art Thread zu erstellen f�r GUI-klassen (verwendet JAmpelPanel_3)   
 * class 	Thread_ImplementsRunnable_Run_Ampelsteuerung3		&	JAmpelPanel_3
 * 
 * 		SIEHE BASICS:			14.2.2.a.   Threads_Bsics_Methoden_Konstruktoren_Eigenschaften_2MethodenderDerThreadErstellung									s.447
 * 
 * 		VERGLEICHE AUCH:		14.2.1.   PaintImmediately_Sleep_InterruptedException_OhneEigenenThread_Einfache_Ampelsteuerung2		&	JAmpelPanel			s.440, (verwendet JAmpelPanel) 
 * 
 * 		&:						14.2.2.b.		class StoppuhrTest	&	Thread_Stoppuhr																			s.450, 1. Art mit extends Thread
 * 
 * 	K&K:	Klasse JAmpelPanel_3:		(von der Komponente JPanel abgeleitet) 			(( ist ausser dem namen identisch mit der klasse JAmpelPanel von PaintImmediately_.._Ampelsteuerung2 ))
 * 										Die Klasse dient der Darstellung einer Ampel mit den vier Ampelphasen.
 * 
 * 
 * 			Programm Ampelsteuerung3:	(mit eigenem Thread) abge�nderte version von PaintImmediately_.._Ampelsteuerung2
 * 
 * 										[ Ampelsteuerung2: 	Das Programm nutzt die Klasse JAmpelPanel. Die Ampel kann manuell in die vier Ampelphasen geschaltet und ausgeschaltet werden.
 * 															Die Phasenwechsel werden im Automatikbetrieb -  mit hilfe von paintImmediately() der klasse jComponent - sichtbar, aber die Automatik 
 * 															versetzt die Ampelsteuerung in eine Endlosschleife, die aus der Entwicklungsumgebung nur noch �ber den Stop-Button der Console-
 * 															View gestoppt werden kann. 	] 
 * 
 * 										Das Programm nutzt die Klasse JAmpelPanel_3. Die Ampel kann manuell in die vier Ampelphasen geschaltet und ausgeschaltet werden.
 * 										Der Automatikmodus funktioniert (mittels zus�tzlichem thread), aber das Beenden der Automatik erfolgt offensichtlich nicht ganz korrekt. 
 * 										Es werden noch die Ampelphasen bis zur Gelbphase weiter durchlaufen. Erst danach endet der Schleifendurchlauf. 
 * 
 * 
 * 	ZWEITE ART DER ERSTELLUNG VON THREADS:		MIT IMPEMENTS RUNNABLE	&	�BERSCHREIBEN DER RUN()-METHODE:	(
 * 
 *			OBJEKT DER ALLGEMEINEN KLASSE THREAD WIRD ERZEUGT, DEREN RUN()-METHODE
 *			VERWEISTAUF EINE RUN()-METHODE, DIE WOANDERS (IN EINER ANDEREN KOMPONENTE ??) IMPLEMENTIERT IST
 *		 
 *			=> f�r klassen die bereits von einer anderen klasse abgeleitet wurden
 *				-> bsp.:	von gui-komponenten abgeleiteteten klassen 
 *		
 *				 ___________________________________________________________
 *				|															|
 *				|	EigenKlasse extends andereKlasse implements Runnable	|							
 *				|															|
 *				| --->	run()			-> �berschreiben (@override)		|
 *				|_�_________________________________________________________|
 *				  �
 *				  �				&
 *				 _�_________________________________________________________
 *				| � 														|
 *				| � Anwendung (kann auch in der obigen/gleichen Klasse sein)|
 *				| �	 ___________________________							|
 *				| �	|	Thread t = new Thread	|							|
 *				| �	|							|							|
 *				| --|---run()					|							|
 *				|	|___________________________|							|
 *				|___________________________________________________________|
 *	  	
 *				SIEHE AUCH:		14.2.2.a.	Threads_Basics_Methoden_Konstruktoren_Eigenschaften_2MethodenderDerThreadErstellung		s.447
 * 
 * 
 * 	METHODEN (besondere):	
 * 				
 * 		void sleep(long m)					der Klasse Thread		-> erzwingt eine pause in der ausf�hrung des laufenden threads (auch des main-threads) von m millisekunden.
 * 																	-> zwingt zu InterruptedException-handling, da threads wiederspr�che ausl�sen k�nnen. 
 * 																			((-> auch bei blosser verwendung der methode, ohne dass ein 2. thread erzeugt wurde))
 * 																	[ -> kann zu unterbrechungen des restlichen programm-ablaufs ( z.b. initGUI()) f�hren 
 * 																			-> fehler beim ablauf des komponenten darstellens z.b. mit paintImmediately() l�sen		(diese programm)
 * 																			-> oder besser einen zus�tzlichen thread machen, wie in dieser klasse]
 * 
 *	EXCEPTIONS:		
 *
 *		InterruptedException				der klasse Thread		-> bei verwendung von Threads k�nnen diese sich gegenseitig unterbrechen
 *																	-> der unterbrochene thread wirft dann eine InterruptedException
 *																	-> bei einsatz von Threads, alleine durch verwendung der methode sleep(..) 
 *																		-> muss ein exception-handling f�r InterruptedExceptions erfolgen 
 *																				->  Throws oder try-catch-block
 * 
 * 	VORGEHEN: 	
 * 
 * 		KLASSE JAmpelPanel_3:		
 * 
 * 			=> von der Komponente JPanel abgeleitet, um sie in der aufrufenden klasse Ampelsteuerung2 anstelle eines standard-jpanels einzusetzen
 * 
 * 			=> Die Klasse dient der Darstellung einer Ampel mit den vier Ampelphasen.
 * 
 * 			=> fields: 		int phase = 0;					// variable f�r die ampel-phasen f�r den switch (5 m�gliche zust�nde: rot, gelb-rot, gr�n, gelb + aus)
 *							Color cOben, cMitte, cUnten;	// farb-variablen f�r die 3 ampel-kreise oben, mitte, unten
 *							
 * 			=> paintComponent-methode der superklasse �berschreiben, damit die �nderungen der komponente (panel) jeweils neugezeichnet werden bei frame-ver�nderungen
 * 
 *						public void paintComponent(Graphics g) {
 *							super.paintComponent(g);					// effektiver aufruf der methode der superklasse unter weitergabe des grafik-objekts g
 *							..
 *							switch (phase) {							// switch-case f�r ampel zust�nde 
 *							case 0:										// fall: ampel aus
 *								cOben = Color.gray;
 *								cMitte = Color.gray;
 *								cUnten = Color.gray;
 *								break;
 *							case 1:	..									// fall: ampel rot
 *							case 2:	..									// fall: ampel gelb-rot
 *							case 3:	..									// fall: ampel gr�n
 *							case 4:	..									// fall: ampel gelb
 *							}
 *							..											// zeichenen der ampel-lampen
 *							g.setColor(cOben);							// zuerst aktuelle farbe der obersten lampe setzen, je nach case 
 *							g.fillOval(3, 3, b, h);						// .. dann oberste lampe zeichnen
 *							..											// .. usw. f�r 2. & 3. lampe
 *						}
 *									
 *			=> methode als schnittstelle nach aussen, um die ampel in die jeweilige phase versetzen zu k�nnen
 *								
 *						public void setPhase(int i) {					// parameter i, um den zustand der phase beim aufruf �bergeben zu k�nnen		
 *							phase = i;									// phase auf i setzen
 *							repaint();									// neuzeichnen der komponente
 *						}  	
 *											
 * 	VORGEHEN: 	
 * 
 *		PROGRAMM Ampelsteuerung3:		(ACHTUNG: bei ausschalten der automatik werden die ampelphasen noch bis zur 4. phase abgearbeitet: perfektes abbrechen der phasen: siehe 4.2.2. .._Ampelsteuerung4 s.353)
 *		
 *				THREAD-SPEZIEFISCHE HAUPT-VORGEHENSWEISE VORWEG K&K :
 *
 *					=> 	Klasse extends JFrame implements Runnable {..}			Runnable von Thread f�r die klasse implementieren 
 *
 *					=> 	@Override												Run()-methode von Thread �berschreiben inkl. den n�tigen anweisungen f�r den neuen Thread
 *						   public void run() {
 *							Anweisungen f�r den neuen Threads;
 *						} 	
 *
 *					=> 	Thread t = new Thread(this, "Automatik");				Thread-objekt f�r neuen thread dort erstelen wo er beginnen soll & starten
 *						t.start();											
 *
 *
 *				-> mit zus�tzlichem Thread durch implementieren von Runnable f�r diese klasse (erfordert �berschreiben der run()-methode)
 *	  
 *						public class Thread_Ampelsteuerung3 extends JFrame implements Runnable {	// Programm-frame implementiert Runnabel, damit es eine run()-methode f�r einen Thread bereitstellen kann
 *
 *				-> �berschreiben der run()-methode f�r den zus�tzlichen threads (eclipse-fehlermeldung wenn kein run() erstellt wird, weil implements Runnable dies zwangsl�ufig erfordert)  
 *					-> methoden-rumpf (method stub) erstellt sich bei der fehlerbehebung von eclipse (mit quickfix) von selbst 
 *					-> while-schleife um immer wieder die 4 ampelphasen durchlaufen zu lassen wird neu in die Thread-methode run() verlegt, (um es parallel/unabh�ngig zum programm-gui-thread laufen zu lassen)
 * 						-> durch die phasen geschaltet wird mit kurzen zeitunterbrechungen (f�r phasen-dauer) durch methode sleep(..) von klasse Thread
 *							[ -> das zeichnen der sich ver�nderneden komponenten muss nicht mehr sofort erzwungen werden mit paintImmediately(..) der klasse jComponent, weil der programm-gui-thread wieder richtig funktioniert + nicht durch sleep() mitunterbrochen wird ]
 * 						-> achtung:bei ausschalten der checkbox automatik l�uft die phase noch bis zum ende durch: perfektes abbrechen der phase: siehe 4.2.2. .._Ampelsteuerung4 s.353
 * 					
 *						@Override										// siehe 12.4.2.  AtOverride  eigene bemerkung:  => wie ein kommentar bei absichtlichem �berschreiben von methoden der superklasse. -> heute java7: ist's guter programmierstil -> evtl. ab java 8 oder 9 unumg�nglich, 
 *						public void run() {								// Auto-generated method stub (= methoden-rumpf) bei implements Runnable: f�r den zus�tzlichen thread, der die ampel parallel laufen l�sst, checkbox automatik blockiert jetzt  ..
 *																		// ..nicht mehr, aber achtung:bei ausschalten der automatik l�uft die phase noch bis zum ende durch: perfektes abbrechen der phase: siehe 4.2.2. .._Ampelsteuerung4 s.353
 *							while (jCBAutomatik.isSelected()) {			// schleife um immer wieder die 4 ampelphasen durchlaufen zu lassen, neu in der Thread-methode run():
 *								try {
 *									..									// alle jAmpel & jAmpelcheckbox immediately neuzeichnen braucht's mit dem zus�tzlichen thread nicht mehr, da durch sleep() keine unterbrechungsfehler mehr im GUI passieren
 *									jAmpel.setPhase(1);																							// via schnittstellen-methode setPhase(..) von JAmpelPanel, phase auf 1 (= rot) setzen, repaint() wird in setPhase() erledigt
 *									Thread.sleep(rotPhase);																						// thread unterbrechen (rotphasen => milisekunden)
 *									..																											// obere 2 anweisungen wiederholen f�r jede der 4 phasen
 *								} catch (InterruptedException e) {																				// Thread-speziefische exception: sobald threads im spiel sind (es reicht schon die methode sleep() von thread
 *									e.printStackTrace();
 *								}
 *							}
 *							
 *						} 							 
 *
 *
 *	  			=> JFrame mit JAmpelPanel_3 (jAmpel) anstelle eines standard-JPanels f�r die darstellung der Ampel
 *	  
 *	  					private JAmpelPanel_3 jAmpel = new JAmpelPanel_3();
 *	  
 *	  			=> 5 radiobuttons (aus, rot, rotgelb, gr�n, gelb) (inkl. ButtonGroup) mit handler-methoden f�r handsteuerung der ampelphasen 
 *	  					-> werden f�r bessere ordnung innerhalb eines jPanels mit titleborder (handsteuerung) dargestellt 
 *	  
 *	  					SIEHE:		jPanel1  im  initGUI()
 *	  								
 *	  			=> checkbox jCBAutomatik mit handler method, um auf automatik-modus der ampelsteuerung zu wechseln
 *	  					
 *	  			=> fields: 		private int rotPhase = 3000;		// int-variablen f�r die zeiten der phasen in milisekunden (werden sp�ter der sleep-methode als parameter �bergeben)
 *	  							... usw								// .. f�r gelbrotPhase, gruenPhase, gelbPhase
 *	  
 * 	  			=> ende initGUI():	jAmpel.setPhase(0);		// jAmpel initialisieren: aufruf schnittstellen-methode setPhase(..) der klasse JAmpelPanel_3 unter mitgabe von int-wert 0 (=> phase : aus)
 *	   	
 *	  			=> handler methoden der 5 radaiobuttons zur handsteuerung implementieren:
 *	  				-> via schnittstellen-methode setPhase(..) von JAmpelPanel, wird private int phase (von JAmpelPanel_3)  auf 0-4 (5 ampelzust�nde) gesetzt setzen, 
 *	  				-> der repaint() wird auch gleich in setPhase() (von JAmpelPanel_3) erledigt
 *	  
 *			 		BSP:	private void jRBAusActionPerformed(ActionEvent evt) {													// handsteuerung: radiobutton aus: 
 *									jAmpel.setPhase(0);																				// phase auf 0 (= aus) setzen
 *								}							
 *	 
 *				=> handler methode f�r checkbox um automatik-modus (der ampelsteuerung) ein- und auszuschalten 
 *					-> bei klicken des eveent-handlings wird das neue Thread-objekt erzeugt mit parameter this (= runnable target => verweist auf run()-methode in der selben klasse).. 
 *																											.. & name des Threads ("automatik")
 *					-> thread wird gestartet �ber thread-objekt t + methode start() der Klasse Thread
 *						
 *				
 *						private void jCBAutomatikActionPerformed(ActionEvent evt) {
 *							if (jCBAutomatik.isSelected()){																			// wenn checkbox (automatik) angew�hlt ist:
 *								jRBAus.setEnabled(false);																			// alle readiobuttons (der handsteuerung) inaktiv setzen
 *								...																									// .. dito alle
 *								Thread t = new Thread(this, "Automatik");		// bei klicken des eveent-handlings wird das neue Thread-objekt erzeugt mit parameter this (= runnable target => verweist auf run()-methode in der selben klasse) & name des Threads ("automatik")
 *								t.start();										// thread wird gestartet �ber thread-objekt + methode start() der Klasse Thread
 *							} else {																								// wenn automatik nicht (mehr) eingeschaltet ist..
 *								jRBAus.setSelected(true);																			// radiobutton Aus auf angew�hlt setzen
 *								jRBAus.setEnabled(true);																			// radiobuttons aktiv setzen ..
 *								...																									// .. dito f�r alle radiobuttons
 *								jAmpel.setPhase(0);																					// via schnittstellen-methode setPhase(..) von JAmpelPanel, phase wieder auf 0 (= aus) setzen, repaint() wird in setPhase() erledigt
 *							}
 *					
 *						}  
 * 
 *
 * 				=> REST-PROBLEMCHEN:	-> bei ausschalten der automatik werden die ampelphasen noch bis zur 4. phase abgearbeitet.
 * 										-> perfektes abbrechen der phasen: 		SIEHE:	 	4.2.2.e. 	Thread_ImplementsRunnable_Run_Perfekte_Ampelsteuerung4	&	JAmpelPanel_4	s.353 	
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

public class Thread_ImplementsRunnable_Run_Ampelsteuerung3 extends JFrame implements Runnable {	// Programm-frame implementiert Runnabel, damit es eine run()-methode f�r einen Thread bereitstellen kann
	
	private JAmpelPanel_3 jAmpel;																								// jPanel mit name jAmpel aber typ JPanel durch JAmpelPanel_3 (selbstabgeleitete komponente von JPanel) ersetzen 
	private JPanel jPanel1;																										// zus�tzliches panel wo die radio-buttons drin sind (gui vereinfachung) 
	private JRadioButton jRBGruen;
	private ButtonGroup BtnGrpFigur;
	private JRadioButton jRBAus;
	private JRadioButton jRBGelb;
	private JRadioButton jRBRotGelb;
	private JRadioButton jRBRot;
	private JCheckBox jCBAutomatik;
	private int rotPhase = 3000;																								// int-variablen f�r die zeiten der phasen in milisekunden (werden sp�ter der sleep-methode als parameter �bergeben)
	private int rotgelbPhase = 1000;																							// int-variablen f�r die zeiten der phasen in milisekunden (werden sp�ter der sleep-methode als parameter �bergeben)
	private int gruenPhase = 3000;																								// int-variablen f�r die zeiten der phasen in milisekunden (werden sp�ter der sleep-methode als parameter �bergeben)
	private int gelbPhase = 1000;																								// int-variablen f�r die zeiten der phasen in milisekunden (werden sp�ter der sleep-methode als parameter �bergeben)
	
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
				Thread_ImplementsRunnable_Run_Ampelsteuerung3 inst = new Thread_ImplementsRunnable_Run_Ampelsteuerung3();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	
	public Thread_ImplementsRunnable_Run_Ampelsteuerung3() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			AnchorLayout thisLayout = new AnchorLayout();
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Einfache Ampelsteuerung 1, JAmpelPanel gesteuert �ber RadioButtons / Checkbox");
			{
				jCBAutomatik = new JCheckBox();																					// checkbox um auf automatik-modus der ampelsteuerung zu wechseln
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
				jPanel1 = new JPanel();																							// jPanel (zur gui-zusammenfassung aller radio-buttons (= die gesamte handsteuerung der ampel)
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
					jRBGruen.setText("Gr�n");
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
				jAmpel = new JAmpelPanel_3();																					// jPanel mit name jAmpel aber typ JPanel durch JAmpelPanel_3 (selbstabgeleitete komponente von JPanel) ersetzen
				getContentPane().add(jAmpel, new AnchorConstraint(73, 326, 924, 66, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jAmpel.setPreferredSize(new java.awt.Dimension(100, 308));
			}
			pack();
			this.setSize(400, 400);
			jAmpel.setPhase(0);																									// jAmpel initialisieren: aufruf schnittstellen-methode setPhase(..) der klasse JAmpelPanel unter mitgabe von int-wert 0 (=> phase : aus)
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private ButtonGroup getBtnGrpFigur() {																						// buttongroup f�r zusammenspiel der radiobuttons
		if(BtnGrpFigur == null) {
			BtnGrpFigur = new ButtonGroup();
		}
		return BtnGrpFigur;
	}
	
	private void jRBAusActionPerformed(ActionEvent evt) {																		// handsteuerung: radiobutton aus: 
		jAmpel.setPhase(0);																										// via schnittstellen-methode setPhase(..) von JAmpelPanel, phase auf 0 (= aus) setzen, repaint() wird in setPhase() erledigt
	}
	
	private void jRBRotActionPerformed(ActionEvent evt) {																		// handsteuerung: radiobutton rot: 
		jAmpel.setPhase(1);																										// via schnittstellen-methode setPhase(..) von JAmpelPanel, phase auf 1 (= rot) setzen, repaint() wird in setPhase() erledigt
	}
	
	private void jRBRotGelbActionPerformed(ActionEvent evt){																	// handsteuerung: radiobutton rotgelb: 
		jAmpel.setPhase(2);																										// via schnittstellen-methode setPhase(..) von JAmpelPanel, phase auf 2 (= rotgelb) setzen, repaint() wird in setPhase() erledigt
	}
	
	private void jRBGruenActionPerformed(ActionEvent evt) {																		// handsteuerung: radiobutton gr�n: 
		jAmpel.setPhase(3);																										// via schnittstellen-methode setPhase(..) von JAmpelPanel, phase auf 3 (= gr�n) setzen, repaint() wird in setPhase() erledigt
	}
	
	private void jRBGelbActionPerformed(ActionEvent evt) { 																		// handsteuerung: radiobutton gelb: 
		jAmpel.setPhase(4);																										// via schnittstellen-methode setPhase(..) von JAmpelPanel, phase auf 4 (= gelb) setzen, repaint() wird in setPhase() erledigt
	}
	
																																// handler methode f�r checkbox um automatik-modus (der ampelsteuerung) ein- und auszuschalten 
	private void jCBAutomatikActionPerformed(ActionEvent evt) {
		if (jCBAutomatik.isSelected()){																							// wenn checkbox (automatik) angew�hlt ist:
			jRBAus.setEnabled(false);																							// alle readiobuttons (der handsteuerung) inaktiv setzen
			jRBRot.setEnabled(false);						
			jRBRotGelb.setEnabled(false);
			jRBGruen.setEnabled(false);
			jRBGelb.setEnabled(false);
			Thread t = new Thread(this, "Automatik");	// bei klicken des eveent-handlings wird das neue Thread-objekt erzeugt mit parameter this (= runnable target => verweist auf run()-methode in der selben klasse) & name des Threads ("automatik")
			t.start();									// thread wird gestartet �ber thread-objekt + methode start() der Klasse Thread
		} else {																												// wenn automatik nicht (mehr) eingeschaltet ist..
			jRBAus.setSelected(true);																							// radiobutton aus auf angew�hlt setzen
			jRBAus.setEnabled(true);																							// alle radiobuttons aktiv setzen
			jRBRot.setEnabled(true);																							// dito
			jRBRotGelb.setEnabled(true);																						// dito
			jRBGruen.setEnabled(true);																							// dito
			jRBGelb.setEnabled(true);																							// dito
			jAmpel.setPhase(0);																									// via schnittstellen-methode setPhase(..) von JAmpelPanel, phase wieder auf 0 (= aus) setzen, repaint() wird in setPhase() erledigt
		}

	}


	@Override				// siehe 12.4.2.  AtOverride  eigene bemerkung:  => wie ein kommentar bei absichtlichem �berschreiben von methoden der superklasse. -> heute java7: ist's guter programmierstil -> evtl. ab java 8 oder 9 unumg�nglich, 
	public void run() {		// Auto-generated method stub (= methoden-rumpf) bei implements Runnable: f�r den zus�tzlichen thread, der die ampel parallel laufen l�sst, checkbox automatik blockiert jetzt  ..
							// ..nicht mehr, aber achtung:bei ausschalten der automatik l�uft die phase noch bis zum ende durch: perfektes abbrechen der phase: siehe 4.2.2. .._Ampelsteuerung4 s.353
		while (jCBAutomatik.isSelected()) {			// schleife um immer wieder die 4 ampelphasen durchlaufen zu lassen, neu in der Thread-methode run():
			try {
				//..								// alle jAmpel & jAmpelcheckbox immediately neuzeichnen braucht's mit dem zus�tzlichen thread nicht mehr, da durch sleep() keine unterbrechungsfehler mehr im GUI passieren
				jAmpel.setPhase(1);																							// via schnittstellen-methode setPhase(..) von JAmpelPanel, phase auf 1 (= rot) setzen, repaint() wird in setPhase() erledigt
				Thread.sleep(rotPhase);																						// thread unterbrechen (rotphasen => milisekunden)
				jAmpel.setPhase(2);																							// via schnittstellen-methode setPhase(..) von JAmpelPanel, phase auf 2 (= rotgelb) setzen, repaint() wird in setPhase() erledigt
				Thread.sleep(rotgelbPhase);																					// thread unterbrechen (rotgelbphasen => milisekunden)
				jAmpel.setPhase(3);																							// via schnittstellen-methode setPhase(..) von JAmpelPanel, phase auf 3 (= gr�n) setzen, repaint() wird in setPhase() erledigt
				Thread.sleep(gruenPhase);																					// thread unterbrechen (gruenphasen => milisekunden)
				jAmpel.setPhase(4);																							// via schnittstellen-methode setPhase(..) von JAmpelPanel, phase auf 4 (= gelb) setzen, repaint() wird in setPhase() erledigt
				Thread.sleep(gelbPhase);																					// thread unterbrechen (gelbphasen => milisekunden)
			} catch (InterruptedException e) {																				// Thread-speziefische exception: sobald threads im spiel sind (es reicht schon die methode sleep() von thread
				e.printStackTrace();
			}
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