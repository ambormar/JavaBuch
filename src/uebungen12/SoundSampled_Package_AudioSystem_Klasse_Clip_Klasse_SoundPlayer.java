/* TODO 12.4.3.   s.390,		!!!!!!!!!!!!!!!!!!!!!!!!!!
 * class SoundSampled_Package_AudioSystem_Klasse_Clip_Klasse_SoundPlayer
 * 
 * PACKAGE JAVAX.SOUND.SAMPLED:
 * 
 * 	KLASSE AUDIOSYSTEM:					import javax.sound.sampled.AudioSystem
 * 
 * 			METHODEN:					static getClip()				liefert clip, für wiedergabe von audiofile od. audio-stream. 
 * 																		dieser clip muss geöffnet werden mit open(AudioFormat) oder open(AudiInputStream) 
 * 
 * 				static AudioInputStream getAudioInputStream(File file)	liefert audio input stream von der mitgegebenen datei, datei muss auf eine gültige audio-datei zeigen
 * 
 * 
 * 	INTERFACE(KLASSE) CLIP:				import javax.sound.sampled.Clip
 * 
 * 			METHODEN:					void open(AudiInputStream)		öffnet einen clip mit seinem format und audio-daten im übergebenen audio input stream
 * 										
 * 			(M. z. Sound abspielen:)	void start()					spielt die datei einmal ab
 * 										void loop(int anzahl)			spielt die datei in einer schleife int anzahl male ab
 * 										void stop()						stoppt einen gestarteten abspielvorgang
 * 
 * 
 * 
 * VORGEHEN:	- programm-Frame mit 4 buttons / event-methoden
 * 
 * 				- attribut audioClip der klasse Clip fürs frame
 * 		
 * 				1. jBtnOeffnen:		zum auswählen & öffnen der sounddatei mit einem FILECHOOSER:
 * 
 * 				 !!!!!!! hier weiter !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * 
 * 				2. jBtnEinmal:		zum einmal abspielen der sounddatei:
 * 
 * 				3. jBtnSchleife:	zum in schleife abspielen der sounddatei:
 * 
 * 				4. jBtnStop:		zum abspielen stoppen:
 * 
 */

package uebungen12;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;	// guck themen-spez. import
import javax.sound.sampled.AudioSystem;			// guck themen-spez. import
import javax.sound.sampled.Clip;				// guck themen-spez. import
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;

public class SoundSampled_Package_AudioSystem_Klasse_Clip_Klasse_SoundPlayer extends javax.swing.JFrame {
	
	private Clip audioClip;						// objekt audioClip der Klasse Clip als attribut des Programm-Frames dklarieren
	private JButton jBtnOeffnen;
	private JButton jBtnStop;
	private JButton jBtnSchleife;
	private JButton jBtnEinmal;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				SoundSampled_Package_AudioSystem_Klasse_Clip_Klasse_SoundPlayer inst = new SoundSampled_Package_AudioSystem_Klasse_Clip_Klasse_SoundPlayer();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public SoundSampled_Package_AudioSystem_Klasse_Clip_Klasse_SoundPlayer() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("SoundPlayer");
			{
				jBtnOeffnen = new JButton();
				getContentPane().add(jBtnOeffnen);
				jBtnOeffnen.setText("Sounddatei öffnen");
				jBtnOeffnen.setBounds(12, 12, 222, 23);
				jBtnOeffnen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnOeffnenActionPerformed(evt);
					}
				});
			}
			{
				jBtnEinmal = new JButton();
				getContentPane().add(jBtnEinmal);
				jBtnEinmal.setText("Sound einmal abspielen");
				jBtnEinmal.setBounds(12, 83, 222, 23);
				jBtnEinmal.setEnabled(false);								// im startframe deaktivieren
				jBtnEinmal.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnEinmalActionPerformed(evt);
					}
				});
			}
			{
				jBtnSchleife = new JButton();
				getContentPane().add(jBtnSchleife);
				jBtnSchleife.setText("Sound in einer Schleife abspielen");
				jBtnSchleife.setBounds(12, 117, 222, 23);
				jBtnSchleife.setEnabled(false);								// im startframe deaktivieren
				jBtnSchleife.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnSchleifeActionPerformed(evt);
					}
				});
			}
			{
				jBtnStop = new JButton();
				getContentPane().add(jBtnStop);
				jBtnStop.setText("Stop");
				jBtnStop.setBounds(264, 117, 93, 23);
				jBtnStop.setEnabled(false);									// im startframe deaktivieren
				jBtnStop.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						jBtnStopActionPerformed(evt);
					}
				});
			}
			pack();
			this.setSize(400, 198);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private void jBtnOeffnenActionPerformed(ActionEvent evt) {
		JFileChooser fc = new JFileChooser();							// jFilechooser-objekt lokal erzeugen
		fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);	// dateien und ordner werden angezeigt im fc-dialog
		fc.setFileFilter(new FileNameExtensionFilter("*.wav", "wav"));	// namenserweiterungen der files, die angezeigt werden
		fc.setCurrentDirectory(new File("C:\\Windows\\Media\\"));		// ausgangs-ordner für fc-dialog frame: hier: nicht projektordner sondern: Media
		int state = fc.showOpenDialog(null);							// fc-dialog öffnen & gleichzeitig status beim schliessen speichern
		if (state == JFileChooser.APPROVE_OPTION){						// falls fc-dialog beenden wird mit "file öffnen" (= aprove_option)
			jBtnEinmal.setEnabled(false);								// btn aktivieren
			jBtnSchleife.setEnabled(false);								// btn aktvieren
			try{
				audioClip = AudioSystem.getClip();	// (anstelle von: Clip audioClip = new Clip()): Clip audioClip initialisieren mit: AudioSystem.getClip() => liefert ja einen Clip zurück 
				AudioInputStream ais = AudioSystem.getAudioInputStream(fc.getSelectedFile());	// AudioInputStream erzeugen mit der Klasse AudioSystem + methode .getAudioInputStream(..), ..
																								//.. mit der im fc-dialog ausgewählten datei als parameter 
				audioClip.open(ais);					// öffnet den Clip audioClip mit seinen audio-daten / + format im übergebenen AudioInputStream ais
				jBtnEinmal.setEnabled(true);			// einmalBtn aktivieren
				jBtnSchleife.setEnabled(true);			// loopBtn aktivieren
				jBtnStop.setEnabled(false);				// stopBtn (sicherheitshalber??!) nochmal deaktivieren
			} catch (Exception e){
				JOptionPane.showMessageDialog(null, "Fehler beim öffenen der Datei!");
			}
		}
				
		
		
	}
	
	private void jBtnEinmalActionPerformed(ActionEvent evt) {
		System.out.println("jBtnEinmal.actionPerformed, event="+evt);
		// add your code for jBtnEinmal.actionPerformed
	}
	
	private void jBtnSchleifeActionPerformed(ActionEvent evt) {
		System.out.println("jBtnSchleife.actionPerformed, event="+evt);
		// add your code for jBtnSchleife.actionPerformed
	}
	
	private void jBtnStopActionPerformed(ActionEvent evt) {
		System.out.println("jBtnStop.actionPerformed, event="+evt);
		// add your code for jBtnStop.actionPerformed
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
