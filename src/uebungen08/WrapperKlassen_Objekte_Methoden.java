/* TODO .8.3. (8.3.1 / 8.3.2)   ab s.238
 * Klasse WrapperKlassen_Objekte_Methoden
 * 
 * WRAPPERKLASSEN:	- für jeden der 8 primitiven Datentypen existiert eine Wrapperklasse (Hüllenklasse)
 * 						
 * 					- W.Kl. speichern den jeweiligen wert des datentyps & stellen Methoden für zugriff und umgang mit den objeketn/werten zur verfügung
 * 
 * 					- Wrapperklasse beginnt mit Grossebuchstaben, datentyp mit kleinen
 * 
 * TABELLE:				PRIMITIVER DATENTYP:		WRAPPERKLASSE:		
 * 						--------------------		-------------------
 * 						boolean						BOOLEAN
 * 						char						Char	
 * 						byte						Byte
 * 						short						Short
 * 						int							Integer
 * 						long						Long
 * 						float						Float
 * 						double						Double
 *  					
 * 8.3.1: 	ERZEUGEN VON WRAPPER-OBJEKTEN:	- Basistypen werden mit wrapper-objekten umhüllt ...
 * (s.239 & unten)									..damit dann die verschiedenen Methoden auf die Wrapper-Objekte bzw. deren werte angewandt werden können
 *						
 *			- 1. Alle der obigen Wrapperklassen ausser Character haben je 2 KONSTRUKTOREN MIT PARAMETERLISTE (WERT oder STRING)
 *												 	
 *				Bspe:	Integer i = new Integer(14)								// konstruktor mit parameterliste für wert direkt
 *												
 *				(bzw:)	Integer i = new Integer("14")							// konstruktor mit parameterliste für string
 *						
 *						Character ch = new Character('y')						// für Character nur diesen einen konstruktor
 *
 *						Boolean boo = new Boolean(true) oder ("true")			// Boolean: true oder flase
 *
 *
 *			- 2. ERZEUGUNG mit valueOf(wert als string) für Boolean, Byte, Short, Integer, Float & Double: 		// valueOf() ist jeweils klassenmethode 
 *					
 *				KlassenMethoden:		static Wrappertyp valueOf(String str)  
 *
 *				Bsp: 	Integer.valueOf("14")              						// erzeugt auch objekt Integer mit wert 14
 *
 *						Boolean.valueOf("true")
 *
 *
 *			- 3. ERZEUGUNG mit valueOf(zahlencode als string, zahlenbasis) für die ganzzahligen Datentypen:
 *
 *				Klassenmethode:		static Wrappertyp valueOf(String str, int basis)	// wobei basis für das zahlsystem steht (hexadezimal => 16 etc.)
 *
 *				Bsp:	Integer.valueOf("3F", 16)								// 16 => steht für hexadezimal 		=> 	"3F" (hexzahl)= 63 (dezimal)
 *
 *
 * 8.3.2: RÜCKGABE DER WERTE AN BASISTYPEN:	= mit stadard-wrapper-methoden, um werte wieder von wrapper-objekten an basisdatentypen zurückzugeben
 * (s.240 & unten)
 * 											=> WRAPPER-METHODEN: 	boolean booleanValue(), char charValue(), byte byteValue(), short shortValue()
 * 																	int intValue(), long longValue(), float floatValue(), double doubleValue(),  		
 * 
 * 			[ BSP WERT UMHÜLLEN:		Integer i = new Integer("33"); 	// zuerst wie oben basisdatentyp-wert 33 mit wrapper-objekt i umhüllen	]
 *				
 *			BSP RÜCKGABE DES WERTS:		int j = i.intValue();  			// dann wert des objekts i wieder an basisdatentyp variable j zurückgeben
 * 
 * 
 * 8.3.2: RÜCKGABE (ALS STRING) DER WERTE VON INTEGER & LONG IN ANDERE ZAHLSYSTEME:		
 * (s.241 & unten)		
 * 								= klassen-methoden von Integer & Long liefern die werte der als argumente übergebenen Wrapperklassen (Long 
 *									& Integer) als String in dualer(basis 2), oktaler (basis 8) und hexadezimaler(basis 16) schreibweise zurück
 *
 *								=> KLASSEN-METHODEN:		- static String toBynaryString(Wrappertyp w)		
 *									(INTEGER & LONG)		- static String toOctalString(Wrappertyp w)
 *															- static String toHexString(Wrappertyp w)
 *											
 *									BSP: 	wenn:	Integer k = new Integer("195"); 		
 *											dann:	String l = Integer.toHexString(k);	// Aufruf: Klassenname.toHexString(Wrapperobjekt)
 *
 * 8.3.2: STRING IN ZAHLWERT UMWANDELN MIT PARSE:	
 * (s.241 & unten)
 * 								= WRAPPER-KLASSEN-METHODEN: 	static int parseInt(String str) 	& ebenso für byte, short, long, float, double
 * 									
 * 									BSP:	Integer.parseInt(eingabe)					// aufruf über klassenname 
 *									
 * 8.3.2: MIN_VALUE & MAX_VALUE UM WERTEBEREICH DER NUMMERISCHEN WRAPPERKLASSEN ABZUFRAGEN:
 * (s.241 & unten) 			
 * 								= alle nummerischen Wrapper-klassen  byte, short, int, long, float, double:
 * 									-> besitzen die Konstanten MIN_VALUE, MAX_VALUE, um den jeweiligen wertebereich abzufragen
 * 											
 * 								= KONSTANTEN DER NUMMERISCHEN WRAPPER-KLASSEN:		- static final wrappertyp MIN_VALUE		 
 * 																					- static final wrappertyp MAX_VALUE
 * 									
 * 									BSP:	int r = Integer.MIN_VALUE;				// speichert kleinsten wert des integer-wertebereichs in r		
 *																					// aufruf der konstante über den klassennamen
 *											
 * 8.3.2: NEGATIVE_INFINITY & POSITIVE_INFINITY & NaN (Not a Number) VON FLOAT & DOUBLE:		
 * (s.242 & unten)				
 * 								= Konstanten von Float & Double, um positiv-unendliche, negativ-unendliche und undefinierte werte abzufragen
 * 
 * 										NaN (Not a Number): 	bei Kommazahl-division 0.0/0.0 		=> 	ergebnis undefiniert
 *										POSITIVE_INFINITY: 		positive zahl durch 0.0 dividiert	=>	ergebnis infinity
 *										NEGATIVE_INFINITY: 		negative  zahl durch 0.0 dividiert 	=>	ergebnis -infinity	
 *										
 *								=> praktisch nützlich ZB: um fehler auszuschliessen:
 *										-> unübersichtlich grosse zahl-ergebnisse einer berechnung mit positiv-unendlicher konstante vergleichen etc.
 *		
 *								BSP: 	double t = Float.POSITIVE_INFINITY;			// t dann mit anderen werten vergleichen, oder so?
 */

package uebungen08;

public class WrapperKlassen_Objekte_Methoden {

	public static void main(String[] args) {
		// 8.3.1 Wrapperklassen-Objkte erzeugen, die Basisdatentypen umhüllen
		Integer a = new Integer(14); 										// parameter als zahlwert
		Integer b = new Integer("15");										// parameter als string
		System.out.println(a + " " + b + " " + (a+b));
		
		// dasselbe mit boolean (von string (bzw. datentyp) wird der datentyp-wert im objekt gespeichert)
		Boolean c = new Boolean("true");
		Boolean d = new Boolean(false);
		System.out.println(c + " " + d + " " + (c == d));
		
		// und mit Charactaer
		Character e = new Character('a');
		Character f = new Character('b');
		System.out.println( e + " " + f + " " + ( e == f));
		
		// alternativ objekt erzeugen wie zuoberst aber mit klassenname.methode : 
		// static Wrappertyp valueOf(String str) 			für alle typen: int, double, char, boolean etc.
		Integer g = Integer.valueOf("12");
		System.out.println(g);
		
		// oder mit: static Wrappertyp valueOf(String str, int basis) 
		Integer h = Integer.valueOf("3F", 16); //wobei basis für zahlensystem steht: Bsp. hexadezimla (=16) & als string eine hexadez.zahl
		System.out.println(h); // hexadezimal 3F = 63 dezimal
		
		//8.3.2 RÜCKGABE DER WERTE und wieder speichern in basisdatentypen 
		// 		mit den WRAPPER-METHODEN: int intValue(), double doubleValue(), boolean booleanValue(), etc.			
		Integer i = new Integer("33"); 	// zuerst wie oben basisdatentyp-wert 33 mit wrapper-objekt i umhüllen			
		int j = i.intValue();  			// dann wert des objekts i wieder an basisdatentyp variable j zurückgeben
		System.out.println(j);
		
		// s.241 Integer & Long: die klassen methoden liefern die werte der als argumente übergebenen Wrapperklassen (Long, 
		// 						Integer) als String in dualer(basis 2), oktaler (basis 8) und hexadezimaler(basis 16) schreibweise zurück
		// Wrapper-klassen-Methode: static String toHexString(Wrapperobjekt)
		Integer k = new Integer("195"); 		
		String l = Integer.toBinaryString(k);	// Aufruf: Klassenname.toBynaryString(Wrapperobjekt)
		String m = Integer.toOctalString(k);	// 						.toOctalString(")
		String n = Integer.toHexString(k);		//						.toHexString(")
		System.out.println(l + ", " + m + ", " + n + " (alle ausgaben as string!");
		
		// s.241 Wrapper-Klassen-Methode: static int parseInt(String eingabe): umwandlung string in zahlwert umwandeln
		// 		ebenso für byte, short, long, float, double
		int o = Integer.parseInt("99");
		boolean p = Boolean.parseBoolean("true");
		System.out.println(o + " " + p);
		
		// s. 241 	static final Wrappertyp MIN_VALUE, MAX_VALUE
		// alle nummerischen Wrapper-klassen besitzen die Konstanten MIN_VALUE, MAX_VALUE, (zum aufruf der konstante über den klassennamen)
		byte q = Byte.MAX_VALUE;			// konstante zum aufruf des max werts
		int r = Integer.MIN_VALUE;
		System.out.println(q + ", " + r);
		
		// s.241	float und double besitzen zusätzlich die konstanten NaN (Not a Number) NEGATIVE_INFINITY & POSITIVE_INFINITY
		float s = Float.NaN; 				// NaN (Not a Number): 	bei Kommazahl-division 0.0/0.0 	=> 	ergebnis undefiniert
		double t = Float.POSITIVE_INFINITY;	// POSITIVE_INFINITY: 	positive zahl durch 0.0 dividiert	=>	ergebnis infinity
		double u = Double.NEGATIVE_INFINITY;// NEGATIVE_INFINITY: 	negative  zahl durch 0.0 dividiert 	=>	ergebnis -infinity	
		System.out.println(s + ", " + t + ", " + u);
	}

}
