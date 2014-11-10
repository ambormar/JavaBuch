/* 	TODO .8.2.2.   s.237
 *  Klasse StringBuffer_Konstruktoren_Methoden_Beispiele
 *  
 * KL. STRINGBUFFER:	- StrinBuffer speichert zeichenketten wie String auch, 
 * 							aber stellt bei der initialisierung immer einen puffer für spätere verlängerung der zeichenkette bereit 
 * 
 * 						- STRINGBUFFER hat bei zeichenketten mit viel veränderung eine bessere performance als String
 * 					  		(weil nicht wie bei string bei jeder veränderung ein neues objekt im speicher angelegt wird)
 * 
 * 					[	- String-Schnittstellen siehe JavaDocs_Eclipse 4.2.2. 
							(=> Stringbuffer anklicken - javadocs-reiter öffnen - browseransicht re seitlich)	]
 * 
 * 						- wird mit new-Operator erzeugt (im gegensatz zu String)
 * 
 * 								Bsp: 	StringBuffer puffer = new StringBuffer();
 * 
 * 
 * 3 VERSCH. KONSTRUKTOREN:		- StringBuffer()				= hat speicherplatz für max. 16 zeichen
 * 
 * 								- StringBuffer(int capacity)	= speicherplatz für parameterzahl * zeichen 
 * 
 * 								- StringBuffer(String str)		= speicherplatz für parameterString + 16 zeichen
 * 
 * 
 * STRINGBUFFER-METHODEN:		- int length()									= liefert länge des pufferinhalts (= aktuell gespeicherte zeichenkette) 
 * (genau siehe bspe unten)		- int capacity()								= liefert puffergrösse (= max. zeichenzahl des restpuffers) zurück
 * 								- char charAt(int index)						= liefert zeichen an der position index (erste position immer: 0)
 * 								- void setCharAt(int index, char ch)			= ersetzt das zeichen an der position index durch das zeichen ch
 * 								- StringBuffer insert(int index, String str)	= fügt String str an der position index ein
 * 								- StringBuffer append(String str)				= hängt den String str ans ende (des pufferinhalts) an
 * 								- String toString()								= wandelt in ein Stringbufferobjekt in ein Stringobjekt um
 *								- StringBuffer delete(int start, int end)		= löscht zeichen ab position start bis position end
 */

package uebungen08;

public class StringBuffer_Konstruktoren_Methoden_Beispiele {

	public static void main(String[] args) {
		StringBuffer puffer = new StringBuffer();		// stringbuffer-instanz mit new erzeugen
		
		System.out.println("Puffergrösse: " + puffer.capacity());			// capacity(): 	puffergrösse
		System.out.println("Länge des Pufferinhalts: " + puffer.length());	// length(): 	länge des pufferinhalts
		System.out.println("Pufferinhalt: " + puffer);
		
		puffer.append("Drei Chinesen");										// append(str):	hängt string str ans ende an
		System.out.println("Puffergrösse: " + puffer.capacity());			
		System.out.println("Länge des Pufferinhalts: " + puffer.length());	
		System.out.println("Pufferinhalt: " + puffer);
		
		puffer.setCharAt(2, 'i');		// setCharAt(int index, char ch): zeichen ersetzen an der position index durch zeichen 'ch'
		puffer.setCharAt(9, 'i');
		puffer.setCharAt(11, 'i');
		System.out.println("Pufferinhalt: " + puffer);
		
		puffer.delete(0, puffer.length());					// delete(int start, int end): löscht zeichen ab position start bis end
		System.out.println("Pufferinhalt: " + puffer);
		System.out.println("Puffergrösse: " + puffer.capacity());			
		System.out.println("Länge des Pufferinhalts: " + puffer.length());	
		
		puffer.append("Drei Chinesen");		// pro append(str) wird der string und 16 zeichen leer angehängt
		puffer.append(" mit dem Kontrabass");	
		System.out.println("Pufferinhalt: " + puffer);		
		System.out.println("Puffergrösse: " + puffer.capacity());			
		System.out.println("Länge des Pufferinhalts:h " + puffer.length());	
	}

}
