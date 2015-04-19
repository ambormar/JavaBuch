/* TODO 12.3.6.   s.437, implements Serializable
 * & TODO 13.5.   Aufgabe 6, s.437, (Kl. z. speichern der infos einer textausgabe)		
 * class	TextAusgabeObjekt	&	IO_ObjektInputStream_ArrayListSpeichern_ObjektOutputStream_Serializable_JMyTextPanel_Aufruf_TextZeichner4	& 	JMyTextPanel
 * 
 *  	F�R SERIALIZABLE SIEHE: 	12.3.6.  	Serializable_Interface_SerialisierungVonObjekten_KlasseImplementsSerializable		eigene bemerkung
 *  
 *  
 *  	F�R ZUSAMMENHANG ZWISCHEN DEN 3 KLASSEN:
 *  
 *  		SIEHE:	13.5.   Aufgabe 5, s.437, MIT REPAINT() bei framever�nderungen; mit Graphics2D 
 * 						class JMyTextPanel_Aufruf_KomponenteFuerTextPerMausklick_paintComponentLernfaehig_RepaintBeiFrameveraenderungen_TextZeichner3	& 	JMyTextPanel	&	TextAusgabeObjekt
 *  
 * 			ODER DAS ANALOG GEL�STE:	13.2.5.   JMyPaintPanel_Aufruf_KomponenteZumHineinZeichnen_paintComponentLernfaehig_RepaintBeiFrameveraenderungen_Zeichnen4		s.413, (3. ANSATZ)  MIT REPAINT() bei framever�nderungen; mit Graphics2D
 *  
 *  						 	 &:		13.2.5.   JMyPaintPanel											s.413, (3. ANSATZ)   JMyPaintPanel extends JPanel, PaintComponent �berschrieben
 *  
 *  						 	 &: 	13.2.5.   Zeichenobjekt											s.413, (3. ANSATZ)  (Kl. z. speichern der infos einer geom. figur) 
 *  
 *  	F�R INPUTSTREAM - OUTPUTSTREAM SIEHE:		Kapitel 12, verschiedenste: zb.: 	Basics, FileReader/Writer etc. 		
 * 
 * 
 * K&K:		Programm Textzeichner4:		[erweiterung von textzeichner3:
 * 											(nutzt die Komponente JMyTextPanel & die Klasse TextAusgabeObjekt)
 * 											Gibt an beliebigen Positionen eines Panels Text in den Farben schwarz oder rot aus.
 * 											Die selbst erstellte Komponente JMyTextPanel �bernimmt das zeichnen der Textzeilen. Als Beh�lter nutzt die Komponente eine ArrayList (=Vector?).
 * 
 * 										Textzeichner4 speichert die gezeichneten Texte in einer Datei. Es gen�gt ein Schreib- bzw. Lesevorgang f�r den gesamten Vector. 
 * 
 *			Klasse TextAusgabeObjekt:	Sie speichert Textzeilen mit Position und Farbe. 
 *										F�r Version 4: Die Klasse implementiert das Interface Serializable.
 *
 *			Klasse JMyTextPanel:		Die Klasse ist von der Standardkomponente JPanel abgeleitet. Die von ihm dargestellten Textzeilen werden in einer ArrayList (Vector?)
 * 										gespeichert. Die ArrayList (Vector?) speichert die Textzeilen als Objekte der Klasse Textausgabe.
 * 										F�r Version 4: die klasse erh�lt zus�tzlich je eine getter- & setter-methode um auf die arraylist (bzw. ihre elemente) zugreifen zu k�nnen
 *
 *
 * AUFGABENSTELLUNG:	
 * 						
 * 		TextZeicher4:	- erweiterung von Textzeichner3*:
 * 						- speichert beim schliessen des fensters (jBtnEnde) die gezeichneten Texte in einer Datei (textAusgabeObjekte.dat).
 * 						- Mittels Serializable gen�gt ein Schreib- bzw. Lesevorgang f�r den gesamten Vector (ArrayList). 
 * 						  -> Die ArrayList-objekte werden zu einem String flachgeklopft.
 * 						- die flachgeklopften arraylist-objekte lassen sich dann leicht mit ObjectOutputStream + ObjectInputStream in ein dat.-file ein- & auslesen
 *			
 *
 *		ERWEITERUNGEN (DER 3 KLASSEN) ZUM SPEICHERN DER TEXTAUSGABEOBJEKTE / ARRAYLIST IN EINEM DAT.-FILE :	
 * 
 * 			1. class TextAusgabeObjekt					=> klasse implementiert Interface Serializable damit von den Objekten/instanzen der klasse eine flachgeklopfte string-version ..
 * 															erzeugt werden kann, die sich als ein einziges String-Objekt besser in daten-files(z.b.: .txt .dat) auslesen /einlesen l�sst
 * 
 * 					public class TextAusgabeObjekt implements Serializable {..}
 * 
 * 
 * 			2. class JMyTextPanel (extends JPanel)		=> erh�lt einen getter & einen setter um auf die ArayList(-elemente) zuzugreifen:
 * 
 *					public ArrayList<TextAusgabeObjekt> getArrayList() {							// normaler getter f�r texte (getTexte(..)) hier aber umbenannt in setArrrayList(..), 
 *						return texte;																// .. -> kommt aufs selbe raus
 *					}
 *	
 *					public void setArrayList(ArrayList<TextAusgabeObjekt> al) {						// normaler setter f�r texte (setTexte(..)) hier aber umbenannt in getArrrayList(..), 
 *						texte = al;																	// .. -> kommt aufs selbe raus
 *					}
 * 
 * 
 * 			3. IO_ObjektInputStream_ArrayListSpeichern_ObjektOutputStream_Serializable_JMyTextPanel_Aufruf_TextZeichner4		
 * 
 * 				=> zus�tzliche importe:		
 * 						java.io.File;	java.io.FileInputStream;	java.io.ObjectInputStream;		java.io.ObjectOutputStream;		java.io.Serializable;java.util.ArrayList;	
 * 				
 * 				=> zus�tzliche variablen oben:
 *						private String dateiname = "." + File.separator + "textAusgabeObjekte.dat"; 	// dateiname mit pfad als string; schr�g: das .dat-file wird nicht wie die anderen ..
 *																										// ..im package-explorer von eclipse angezeigt (in dokumenten schon), hat evtl. was mit serializable zu tun
 *						private ArrayList<TextAusgabeObjekt> meineTexte;								// ArrayList zur zwischen-speicherung der TextAusgabeObkjekte beim einlesen aus dem textAusgabeObjekte.dat-file, siehe ende initGUI() 
 *
 *				=> einlesen der TextAusgabeObjekte aus dem TextAusgabeObjekte.dat-file ins programm, ende initGUI():
 *				
 *	 					{	
 *							File datei = new File(dateiname);											// vergleichsfile erzeugen mit namen + pfad (dateiname) vom zu vergleichenden file
 *							if (!datei.exists()){														// wenn file mit dateiname nicht existiert..
 *								meineTexte = null;														// .. arrayList	meineTexte auf null setzen
 *							} else {																	// ..sonst:
 *								meineTexte = readArrayList();											// ..meineTexte = methodenaufruf readArrayList() von unten in dieser klasse
 *							}
 *							if (meineTexte != null) {													// wenn arraylist meinetexte texte beinhalten
 *								jPanelTextflaeche.setArrayList(meineTexte);								// ArrayList von jPanelTextflaeche (=JMyTextPanel) via methode setArrayList() (auch von JMyTextPanel) meineTexte �bergeben
 *							}
 *							datei.delete();																// vergleichs-file l�schen
 *						}
 *
 *				=> zus�tzlicher jBtnEnde mit event-methode zum speichern der vorhandenen TextAusgabeObjekte ins TextAusgabeObjekte.dat-file		&	zum schliessen des fensters
 *
 *						private void jBtnEndeActionPerformed(ActionEvent evt) {									
 *							ArrayList<TextAusgabeObjekt> liste = new ArrayList<TextAusgabeObjekt>();	// lokale ArrayList liste vom typ TextAusgabeObjekt erzeugen
 *							liste = jPanelTextflaeche.getArrayList();									// via methode getArrayList() die vorhandenen textAusgabeObjekte aus ArrayList von jPanelTextflaeche (=JMyTextPanel) in lokale arraylist liste speichern
 *							writeArrayList(liste);														// methode writeArrayList unter �bergabe von list aufrufen (um dort das TextAusgabeObjekte.dat-file mit den TextAusgabeObjekten zu erzeugen + zu speichern)
 *							System.exit(0);																// programm beenden + fenster schliessen 
 *						} 
 *						
 *				=> zus�tzliche methode readArrayList() zum effektiven einlesen der TextAusgabeObjekte aus dem dat.-file mittels ObjectInputStream
 *				
 *						private ArrayList<TextAusgabeObjekt> readArrayList() {								 	
 *							ArrayList<TextAusgabeObjekt> liste = new ArrayList<TextAusgabeObjekt>();		 	// lokale ArrayList liste vom typ TextAusgabeObjekt erzeugen
 *							try {
 *								ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dateiname));	// ObjectInputstream ois erzeugen unter mitgabe von neuem fileInputstream unter mitgabe von dateiname (inkl.pfad)
 *								liste = (ArrayList<TextAusgabeObjekt>)ois.readObject();							// ArrayList liste mit den objekten der datei bef�llen, dazu methode ois.readObject() typgecastet benutzen 
 *								ois.close();																	// ObjectOutputStream schliessen
 *							} catch (Exception e) {
 *								JOptionPane.showMessageDialog(null, "Fehler beim Lesen aus Datei!");			// fehlermeldung 
 *								liste = null;																	// liste auf null falls fehler
 *							}
 *							return liste;																		// arraylist liste zur�ckgeben
 *						}
 *
 *				=> zus�tzliche methode writeArrayList() zum effektiven auslesen der TextAusgabeObjekte ins TextAusgabeObjekte.dat-file mittels ObjectOutputStream
 *
 *						private void writeArrayList(ArrayList<TextAusgabeObjekt> liste){						
 *							try {
 *								ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dateiname, true));		// ObjectOutputStream oos erzeugen unter mitgabe von neuem fileInputstream unter mitgabe von dateiname (inkl.pfad) 
 *								oos.writeObject(liste);																		// arraylist liste aussschreiben mittels methode writeObject() der klasse OOS 
 *								oos.flush();																				// sp�hlen: schreiben der daten aus dem zwischenspeicher des oos erzwingen
 *								oos.close();																				// oos schliessen
 *							} catch (Exception e) {
 *								JOptionPane.showMessageDialog(null, "Fehler beim schreiben in Datei!");						
 *								e.printStackTrace();
 *							}
 *						}
 *
 *
 *
 * [[[	VORAUSSETZUNG:	
 * 						
 * 		*TextZeicher3:	- erweiterung von Textzeichner1**:
 * 						- das panel muss bei framever�nderungen den text auto-repainten k�nnen (=>abgeleitete panel-komponente n�tig:	JMyTextPanel = new JPanel() )
 *			
 *			BESTEHEND AUS:	
 * 
 * 			1. class TextAusgabeObjekt						=> klasse zur speicherung der informationen (text, x-y-koordinaten, farbe) zu einem TextAusgabeObjekt 
 * 
 * 			2. class JMyTextPanel (extends JPanel)			=> von JPanel abgeleitete klasse mit:	beh�lter (ArrayList) f�r TextAusgabeObjekte	&	lernf�higer paintComponent()-methode
 * 
 * 			3. JMyTextPanel_Aufruf_KomponenteFuerTextPerMausklick_paintComponentLernfaehig_RepaintBeiFrameveraenderungen_TextZeichner3		=> von JFrame abgeleitete klasse als TextZeichenProgramm
 * 
 * 
 * 	[	**TextZeichner1:	- standardpanel, in das text an einer beliebigen position durch mausklick eingesetzt werden kann
 * 							- radio-buttons f�r farbe des textes (rot + schwarz)
 * 							- textfeld zur texteingabe
 * 							- zeichnen des textes mit der methode:		 drawString(Strings, float x, float y) 		der klasse Graphics2d		]
 * ]]]
 * 
 */

package uebungen12;

import java.awt.Color;
import java.io.Serializable;		// themenspez. import

//klasse (zur ausgabe eines TextObjekts) implementiert Interface Serializable damit von den Objekten/instanzen der klasse eine flachgeklopfte/serialisierte string-version erzeugt werden..
	//.. kann, die sich als ein einziges String-Objekt besser in daten-files(z.b.: .txt .dat) auslesen /einlesen l�sst
public class TextAusgabeObjekt implements Serializable {
	
																															// attribute des TextAusgabeObjekts
	private int x, y;																										// f�r x- & y-koordinaten des mauszeigers beim klicken (= wo das objekt gezeichnet wird im panel)
	private String text;																									// f�r text der geschrieben wird im panel
	private Color farbe;																									// f�r aktuelle zeichenfarbe mit der gezeichnet wird
	
	public TextAusgabeObjekt(int posX, int posY, String t, Color f  ) {														// konstruktor um die werte der vier eigenschaften des TextAusgabeObjekts zu �bergeben
		x = posX;					
		y = posY;
		text = t;
		farbe = f;
	}
	
																															// getter f�r jede eigenschaft des TextAusgabeObjekts
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public String getText() {
		return text;
	}

	public Color getColor() {
		return farbe;
	}

}
