/* TODO 12.3.6.  eigene bemerkung
 * & TODO 13.5.  eigene bemerkung, (wegen Aufgabe 6, s.437 & mjs erklärung) 	
 * Serializable_Interface_SerialisierungVonObjekten_KlasseImplementsSerializable
 * 
 * 	SIEHE ANGEW.:	12.3.6.   TextAusgabeObjekt implements Serializable																		s.437, (eigtl. buchDVD uebg.13, class Textausgabe)
 * 			&:		12.3.6.   IO_ObjektInputStream_ArrayListSpeichern_ObjektOutputStream_Serializable_JMyTextPanel_Aufruf_TextZeichner4		s.437, (eigtl. buchDVD uebg.13, class TextZeichner4)
 * 							
 * 	SERIALIZABLE BASICS:	
 * 
 * 		=> ist ein INTERFACE, 	=> Klasse implements Serializable		-> BSP: 		public class TextAusgabeObjekt implements Serializable {....}
 * 
 * 								=> BESONDERES:	-> obwohl serializable ein Interface ist gibts keine obligatorischen methoden zum implementieren
 * 
 * 		=> IMPORT:		java.io.Serializable;
 * 
 * 		=> ZWECK:		-> ein kompletes Objekt (Instanz von Klasse) wird flachgeklopft zu einem String
 * 						-> so kann man ein Objekt speichern	als String		-> und einfach mittels ObjectInputStream / ObjectOutputStream in (.txt- / .dat-) Files  ein- & auslesen  
 * 	
 * 
 * 	ARRAYLIST SERIALISIEREN / IN DATEI SPEICHERN:
 * 
 * 		VARIANTE 1:		ArrayList nur mit Integers:
 * 					
 * 				=> oben/variablen:  	ArrayList<Integer> arrayListName = new ArrayList<Integer>()			// es braucht glaub keine custom-klasse: class Integer implements Serializable {..}
 * 																											// .., standard-klasse Integer kann das auch so, glaub
 * 				=> dann:				String objektFlachgeklopft	= arrayListName.serialize()
 * 
 * 										-> dieser String enthält dann die flachgeklopfte ArrayList<Integer>  mit allen Integers (Standard-objekten) drin
 * 
 * 										-> ist als String in .txt- oder .dat-file ein- & auslesbar mittels FileInputStream / FileOutputStream
 * 
 * 
 * 		VARIANTE 2:		ArrayList mit Custom-Klassen:
 * 				
 * 				=> zusätzliche Custom-Klasse:		private class EigeneObjektKlasse implements Serializable {..}
 * 	
 * 				=> in der aufrufenden Klasse oben/variablen:  				ArrayList<EigeneObjektKlasse> arrayListName = new ArrayList<EigeneObjektKlasse>()				
 * 																	
 * 				=> dann (gleich wie Var.1):									String objektFlachgeklopft	= arrayListName.serialize()
 * 
 * 																			-> dieser String enthält dann die flachgeklopfte ArrayList<EigeneObjektKlasse>  mit allen Instanz-objekten drin
 * 
 * 																			-> ist als String in .txt- oder .dat-file ein- & auslesbar mittels FileInputStream / FileOutputStream 
 * 																														// evtl. auch nur mit ObjectInputStream / ObjectOutputStream mögl. ?????
 * 
 * 
 * 		VARIANTE 3:		
 * 
 * 			SIEHE:		12.3.6.   IO_ObjektInputStream_ArrayListSpeichern_ObjektOutputStream_Serializable_JMyTextPanel_Aufruf_TextZeichner4		s.437, (eigtl. buchDVD uebg.13, class Textausgabe)
 * 				&:		12.3.6.   TextAusgabeObjekt implements Serializable																		s.437, 
 * 
 */				

package uebungen12;

import java.io.Serializable;

public class Serializable_Interface_SerialisierungVonObjekten_KlasseImplementsSerializable {

}
