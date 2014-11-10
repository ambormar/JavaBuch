/* 	TODO .8.2.2.   s.237
 *  Klasse StringBuffer_Konstruktoren_Methoden_Beispiele
 *  
 * KL. STRINGBUFFER:	- StrinBuffer speichert zeichenketten wie String auch, 
 * 							aber stellt bei der initialisierung immer einen puffer f�r sp�tere verl�ngerung der zeichenkette bereit 
 * 
 * 						- STRINGBUFFER hat bei zeichenketten mit viel ver�nderung eine bessere performance als String
 * 					  		(weil nicht wie bei string bei jeder ver�nderung ein neues objekt im speicher angelegt wird)
 * 
 * 					[	- String-Schnittstellen siehe JavaDocs_Eclipse 4.2.2. 
							(=> Stringbuffer anklicken - javadocs-reiter �ffnen - browseransicht re seitlich)	]
 * 
 * 						- wird mit new-Operator erzeugt (im gegensatz zu String)
 * 
 * 								Bsp: 	StringBuffer puffer = new StringBuffer();
 * 
 * 
 * 3 VERSCH. KONSTRUKTOREN:		- StringBuffer()				= hat speicherplatz f�r max. 16 zeichen
 * 
 * 								- StringBuffer(int capacity)	= speicherplatz f�r parameterzahl * zeichen 
 * 
 * 								- StringBuffer(String str)		= speicherplatz f�r parameterString + 16 zeichen
 * 
 * 
 * STRINGBUFFER-METHODEN:		- int length()									= liefert l�nge des pufferinhalts (= aktuell gespeicherte zeichenkette) 
 * (genau siehe bspe unten)		- int capacity()								= liefert puffergr�sse (= max. zeichenzahl des restpuffers) zur�ck
 * 								- char charAt(int index)						= liefert zeichen an der position index (erste position immer: 0)
 * 								- void setCharAt(int index, char ch)			= ersetzt das zeichen an der position index durch das zeichen ch
 * 								- StringBuffer insert(int index, String str)	= f�gt String str an der position index ein
 * 								- StringBuffer append(String str)				= h�ngt den String str ans ende (des pufferinhalts) an
 * 								- String toString()								= wandelt in ein Stringbufferobjekt in ein Stringobjekt um
 *								- StringBuffer delete(int start, int end)		= l�scht zeichen ab position start bis position end
 */

package uebungen08;

public class StringBuffer_Konstruktoren_Methoden_Beispiele {

	public static void main(String[] args) {
		StringBuffer puffer = new StringBuffer();		// stringbuffer-instanz mit new erzeugen
		
		System.out.println("Puffergr�sse: " + puffer.capacity());			// capacity(): 	puffergr�sse
		System.out.println("L�nge des Pufferinhalts: " + puffer.length());	// length(): 	l�nge des pufferinhalts
		System.out.println("Pufferinhalt: " + puffer);
		
		puffer.append("Drei Chinesen");										// append(str):	h�ngt string str ans ende an
		System.out.println("Puffergr�sse: " + puffer.capacity());			
		System.out.println("L�nge des Pufferinhalts: " + puffer.length());	
		System.out.println("Pufferinhalt: " + puffer);
		
		puffer.setCharAt(2, 'i');		// setCharAt(int index, char ch): zeichen ersetzen an der position index durch zeichen 'ch'
		puffer.setCharAt(9, 'i');
		puffer.setCharAt(11, 'i');
		System.out.println("Pufferinhalt: " + puffer);
		
		puffer.delete(0, puffer.length());					// delete(int start, int end): l�scht zeichen ab position start bis end
		System.out.println("Pufferinhalt: " + puffer);
		System.out.println("Puffergr�sse: " + puffer.capacity());			
		System.out.println("L�nge des Pufferinhalts: " + puffer.length());	
		
		puffer.append("Drei Chinesen");		// pro append(str) wird der string und 16 zeichen leer angeh�ngt
		puffer.append(" mit dem Kontrabass");	
		System.out.println("Pufferinhalt: " + puffer);		
		System.out.println("Puffergr�sse: " + puffer.capacity());			
		System.out.println("L�nge des Pufferinhalts:h " + puffer.length());	
	}

}
