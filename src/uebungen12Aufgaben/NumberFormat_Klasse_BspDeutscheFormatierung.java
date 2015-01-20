/* TODO 12.5.  -> eigene bemerkung
 * NumberFormat_Klasse_BspDeutscheFormatierung
 * 
 * 		SIEHE ANGEWANDT: 		12.5.	In_DateiSpeichern_MitDateiErweiterung_MitFileChooserAufrufen_Messreihe2		Aufgabe 2, s.393 (Aufg. 1 erweitert)
 * 
 *	NUMBERFORMAT: 	BSP: 	deutsche formatierung mit komma als trennzeichen statt punkt:	
 *
 *					- der NumberFormat variablen nf wird der wert Locale.German zugewiesen:	
 *																					 
 *					import java.text.NumberFormat;
 *					import java.util.Locale;
 *					
 *					private NumberFormat nf;														// attribut-deklaration
 *
 *					nf = NumberFormat.getInstance(Locale.GERMAN);   								// im initGUI() nach pack(..)	//der NumberFormat variablen nf wird der wert Locale.German zugewiesen
 *
 * 					jListMesswerteModel.addElement(nf.format(nf.parse(jTFMesswert.getText())));		// im jBtnUebernehmen...(..) * 	// der string wird formatiert der methode addElement(..) mitgegeben
 */
 

package uebungen12Aufgaben;

public class NumberFormat_Klasse_BspDeutscheFormatierung {

}
