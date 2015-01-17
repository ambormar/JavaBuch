/* TODO 12.4.3.   s.390, ("Sound IN", AudioInputStream)
 * class SoundPlayer_AudioSystem_Klasse_Clip_Interface_SoundSampled_Package
 * 
 * PACKAGE: 	JAVAX.SOUND.SAMPLED:
 * 
 * 	KLASSE AUDIOSYSTEM:					import javax.sound.sampled.AudioSystem
 * 
 * 			METHODEN:					static Clip getClip()			liefert clip, für wiedergabe von audiofile od. audio-stream. 
 * 																		dieser clip muss geöffnet werden mit open(AudioFormat) oder open(AudiInputStream) 
 * 										static AudioInputStream
 * 				 						getAudioInputStream(File file)	liefert AudioInputStream-objekt von der mitgegebenen datei, datei muss auf eine gültige audio-datei zeigen
 * 
 * 
 * 
 * 	INTERFACE CLIP:						import javax.sound.sampled.Clip	
 * 
 * 			METHODEN:					void open(AudioInputStream)		öffnet einen clip mit seinem format und audio-daten im übergebenen audio input stream
 * 										
 * 			(M. z. Sound abspielen:)	void start()					spielt die datei einmal ab
 * 										void loop(int anzahl)			spielt die datei in einer schleife int anzahl male ab
 * 										void stop()						stoppt einen gestarteten abspielvorgang
 * 
 * 			KONSTANTE:					static int LOOP_CONTINUOUSLY  	übergibt man die konstante der methode loop(..) wird der sound in schleife gespielt, bis mit stop() angehalten,
 * 																		oder der Thread (in dem die schleife gestartet wurde) beendet wird
 * 														
 * 				
 * 	AUDIO-DATEI-FORMATE:	 die von der (glaub:) klasse AUDIOSYSTEM unterstützt werden:
 * 
 * 			NUR UNKOMPRIMIERT:				AU,		AUFF,		WAV
 * 			KOMPR. & UNKOMPR.:				MIDI TYPE 0,	MIDI TYPE 1,	RMF	
 *
 * 
 * VORGEHEN:	- programm-Frame mit 4 buttons + event-methoden
 * 
 * 				- attribut audioClip der klasse Clip fürs frame:			
 * 
 * 						private Clip audioClip;		// objekt audioClip des Interfaces Clip als attribut des Programm-Frames dklarieren
 * 		
 * 				1. BUTTON ÖFFNEN:		zum auswählen & öffnen der sounddatei mit einem FILECHOOSER:
 * 
 * 						private void jBtnOeffnenActionPerformed(ActionEvent evt) {
 *							JFileChooser fc = new JFileChooser();							// jFilechooser-objekt lokal erzeugen
 *							fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);	// dateien und ordner werden angezeigt im fc-dialog
 *							fc.setFileFilter(new FileNameExtensionFilter("*.wav", "wav"));	// namenserweiterungen der files, die angezeigt werden
 *							fc.setCurrentDirectory(new File("C:\\Windows\\Media\\"));		// ausgangs-ordner für fc-dialog frame: hier: nicht projektordner sondern: Media
 *							int state = fc.showOpenDialog(null);							// fc-dialog öffnen & gleichzeitig status beim schliessen speichern
 *							if (state == JFileChooser.APPROVE_OPTION){						// falls fc-dialog beenden wird mit "file öffnen" (= aprove_option)
 *								jBtnEinmal.setEnabled(false);								// btn aktivieren
 *								jBtnSchleife.setEnabled(false);								// btn aktvieren
 *								try{
 *									audioClip = AudioSystem.getClip();						// Clip-objekt audioClip initialisieren mit der KlassenMethode: AudioSystem.getClip() => liefert ein objekt vom typ Clip zurück 
 *									AudioInputStream ais = AudioSystem.getAudioInputStream(fc.getSelectedFile());	// AudioInputStream-objekt ais erzeugen mit der KlassenMethode AudioSystem.getAudioInputStream(..), ..
 *																													//.. mit der im fc-dialog ausgewählten datei als parameter 
 *									audioClip.open(ais);					// öffnet den Clip audioClip mit seinen audio-daten / + format im übergebenen AudioInputStream ais
 *									jBtnEinmal.setEnabled(true);			// einmalBtn aktivieren
 *									jBtnSchleife.setEnabled(true);			// loopBtn aktivieren
 *									jBtnStop.setEnabled(false);				// stopBtn (sicherheitshalber??!) nochmal deaktivieren
 *								} catch (Exception e) {
 *									JOptionPane.showMessageDialog(null, "Fehler beim öffenen der Datei!");
 *								}
 *							}
 *						}
 *					  
 * 				2. BUTTON EINMAL:		zum einmal abspielen der sounddatei:
 * 
 * 						private void jBtnEinmalActionPerformed(ActionEvent evt) {
 *								audioClip.start();								// Clip starten
 *						}
 * 	
 * 				3. BUTTON SCHLEIFE:		zum in schleife abspielen der sounddatei:
 * 
 *						private void jBtnSchleifeActionPerformed(ActionEvent evt) {
 *							jBtnStop.setEnabled(true);						// stop button aktivieren
 *							audioClip.loop(Clip.LOOP_CONTINUOUSLY);			// mit methode loop(parameter: Konstante LOOP_CONTINUOUSLY von Clip) den Clip als endlosschleife abspielen
 *						}
 *					  
 * 				4. BUTTON STOP:			zum abspielen stoppen:
 * 
 *						private void jBtnStopActionPerformed(ActionEvent evt) {
 *							audioClip.stop();								// Clip stoppen
 *							jBtnStop.setEnabled(false);						// stop button wieder deaktivieren
 *						} 
 * 
 * 
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

public class SoundPlayer_AudioSystem_Klasse_Clip_Interface_SoundSampled_Package extends javax.swing.JFrame {
	
	private Clip audioClip;						// objekt audioClip des Interfaces Clip als attribut des Programm-Frames dklarieren
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
				SoundPlayer_AudioSystem_Klasse_Clip_Interface_SoundSampled_Package inst = new SoundPlayer_AudioSystem_Klasse_Clip_Interface_SoundSampled_Package();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public SoundPlayer_AudioSystem_Klasse_Clip_Interface_SoundSampled_Package() {
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
				audioClip = AudioSystem.getClip();	// Clip-objekt audioClip initialisieren mit der KlassenMethode: AudioSystem.getClip() => liefert ein objekt vom typ Clip zurück 
				AudioInputStream ais = AudioSystem.getAudioInputStream(fc.getSelectedFile());	// AudioInputStream-objekt ais erzeugen mit der KlassenMethode AudioSystem.getAudioInputStream(..), ..
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
		audioClip.start();								// Clip starten
	}
	
	private void jBtnSchleifeActionPerformed(ActionEvent evt) {
		jBtnStop.setEnabled(true);						// stop button aktivieren
		audioClip.loop(Clip.LOOP_CONTINUOUSLY);			// mit methode loop(parameter: Konstante LOOP_CONTINUOUSLY von Clip) den Clip als endlosschleife abspielen
	}
	
	private void jBtnStopActionPerformed(ActionEvent evt) {
		audioClip.stop();								// Clip stoppen
		jBtnStop.setEnabled(false);						// stop button wieder deaktivieren
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
