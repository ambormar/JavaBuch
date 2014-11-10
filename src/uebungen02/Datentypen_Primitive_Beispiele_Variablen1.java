package uebungen02;

/*	TODO .2.3.4.   s.72 
 *	class  Datentypen_Primitive_Beispiele_Variablen1
	programm zum testen der verwendung von variablen & ihre eigenheiten
	
	beachte (siehe unten) L für long ahängen & f für float anhängen
*/

public class Datentypen_Primitive_Beispiele_Variablen1 {
   public static void main (String[] args) {
	byte bZahl;
	short sZahl;
	int iZahl;
	long lZahl;
	float fZahl;
	double dZahl;
	boolean bestanden;
	char zeichen;
	bZahl = 28;
	sZahl = -18453;
	iZahl = 4356576;
	lZahl = 345236577970L;  // L muss anggegeben werden sonst automatisch int und dann zahl zu lang , weil: GANZZAHLEN WERDEN V: JAVA IMMER ALS INT INTERPRETIERT 
	fZahl = 4.37456678f;	// f muss anggegeben werden sonst automatisch double und fehlermeldung weils float erwartet; weil: Kommazahlen WERDEN V: JAVA IMMER ALS DOUBLE INTERPRETIERT 
	dZahl = 3645.564782;
	bestanden = true;
	zeichen = '%';			// bei char immer die werte (%) zwischen '' (also: '%') angeben sonst fehler
	System.out.println("bZahl = " + bZahl);
	System.out.println("sZahl = " + sZahl);
	System.out.println("iZahl = " + iZahl);
	System.out.println("lZahl = " + lZahl);
	System.out.println("fZahl = " + fZahl);
	System.out.println("dZahl = " + dZahl);
	System.out.println("bestanden = " + bestanden);
	System.out.println("zeichen = " + zeichen);
   }
}