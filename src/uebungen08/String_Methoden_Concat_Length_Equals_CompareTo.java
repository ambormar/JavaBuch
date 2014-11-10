/* TODO .8.1.2. (8.1.3.)   ab s.227 (230)
 * Klasse String_Methoden_Concat_Length_Equals_CompareTo
 *
 * KLASSE STRING:	- String f�r Zeichenketten mit wenig ver�nderung. (STRINGBUFFER: besser f�r zeichenketten mit viel ver�nderung).
 * 					  Bei jeder ver�nderung werden string-objekte neu im speicher angelegt. 	=> 		viel ab�nderung = performance-verlust.
 * 					
 * 					- String-Schnittstellen siehe JavaDocs_Eclipse 4.2.2. (-String anklicken - javadocs-reiter �ffnen - browseransicht re seitlich)
 * 
 * 					- new-Operator wird implizit verwendet => datentyp sehr einfach verwendbar	
 * 
 * 						Bsp: 	String a = "zeichenkette";		Nicht n�tig:	String a = new String("text");
 * 
 * STRING-METHODEN BSPe:	- a.concat(b)			zeichenkette a wird um zeichenkette b verl�ngert 
 * 																	(urspr�ngliches a gel�scht, neues a an neuem speicherplatz erstellt)
 * 	(genau siehe unten)		- a.lenght() 			gibt anzahl zeichen der zeichenkette a aus
 * 							- a.equals(b)			vergleicht zeichenkette a auf absolute gleichheit des objekt-werts mit zeichenkette b
 * 							- a.compareTo(b)		vergleicht wieviele unicodezeichen der parameter-String vor oder nach dem objekt-String steht 
 * 																	(0 => gleiches zeichen; 2 => 2 zeichen nachher; -2 => 2 zeichen vorher) 
 */

package uebungen08;

public class String_Methoden_Concat_Length_Equals_CompareTo {

	public static void main(String[] args) {
		// 
		String a = "das ist ";
		String b = "eine Zeichenkette!";
		
		// 8.1.2 public String concat(String str),		verkn�pfung string mit string
		a = a.concat(b);	// zeichenkette a wird um zeichenkette b verl�ngert und die verkettung der variablen a zugewiesen
							// N.B. ohne a= zuweisung w�rde die stringverkettung zwar lokal erzeugt aber auch wieder gel�scht
		System.out.println(a + " (string a concat string b)"); 	// a gibt so den ganzen satz aus
		
		// 8.1.3 public int lenght(),	ermitteln von stringl�nge 
		System.out.println(a.length() + " (length von string a)");// gibt anzahl zeichen einer zeichenkette (eines stringobjekts) in integer aus
		
		// 8.1.3 public boolean equals(object anObject),	 auf absolute gleichheit des objekt-werts
		String c = "hallo";
		String d = "hallo";
		System.out.println(c.equals(d) + " (hallo equals hallo)");
		
		String e = "hallo";
		String f = "Hallo ";
		System.out.println(e.equals(f) + " (hallo equals Hallo)");
		
		// 8.1.3 public int compareTo(String anotherString), 	lexikalischer vergleich vor oder nach entsprechend unicodezeichen
		String g = "a";
		String h = "c";
		String i = "a";
		System.out.println(g.compareTo(h) + " (a compareTo c)"); // es wird verglichen wieviele unicodezeichen der parameter-String  
		System.out.println(h.compareTo(g) + " (c compareTo a)"); // vor oder nach dem objekt-String steht
		System.out.println(g.compareTo(i) + " (a compareTo a)");
	}
}
