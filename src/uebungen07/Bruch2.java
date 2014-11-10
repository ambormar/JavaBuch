/* TODO .7.1.2.   s.204
 * Bruch2 & KlassenMethoden_Static_StatischeAttribute_Bruch2
 * 
 * KLASSEN-METHODEN:	- ..(= statische methoden) gehören zur Klasse 
 * 
 * 						- ..sind nötig wenn objekte einer klasse eine methode teilen sollen, bsp:	-> static int getAnzahlBrueche() {return ..}
 * 
 * 						- ..existieren pro namen nur einmal in der klasse, existieren unahbhängig von den objekten/instanzen
 * 
 * 						- modifier static  		siehe 7.1.1.	s.202
 * 
 * 			BEACHTE:	bei verwendung statischer methoden:		- zugriff nur auf KLASSENVARIABELN
 * 																
 * 																- aufruf nur von KLASSENMETHODEN
 * 																	
 * 																- THIS nicht verwendbar weil es kein zugeordnetes objekt geben kann
 * 																
 * 
 * 				BSP:	class Bruch {																				class Bruch
 * 							int zaehler;						// instanzvariabeln									anzahlBrueche
 * 							int nenner;																				getAnzahlBrueche()
 * 							static int anzahlBrueche = 0;		// klassenvariable											|								
 * 							static int getAnzahlBrueche() {		// KLASSEN-METHODE										
 * 								return anzahlBrueche;			// returns int klassenvariabel					Bruch a				Bruch b
 * 						}																					zaehler, nenner		zaehler, nenner
 * 																											anzahlBrueche++		anzahlBrueche++
 * 
 * 
 * 			Aufruf: 	- ..über die Klasse: 	BSP:	Bruch.getAnzahlBrueche()			// klasse.klassenmethode
 * 						
 * 						=> VERWENDUNG VOR erzeugen einer instanz der klasse MÖGLICH
 * 
 *  WICHTIGES BSP:		- MAIN-METODE ist auch static:		=> unabhängigkeit von objekten wichtig für programm-start ..
															(-> .. weil noch keine objekte erzeugt worden sein können)
 * 
 * Bruch2 hier mit statischer methode getAnzahlBrueche() (zum aufruf von anzahlBrueche)
 * in KlassenMethoden_Static_StatischeAttribute_Bruch2 wir diese statische methode aufgerufen: Klassenname.methodenname()
 */
package uebungen07;

public class Bruch2{
	int zaehler;
	int nenner;
	// statische variable die zur Klasse Bruch gehört & von ausserhalb auch so aufgerufen wird
	static int anzahlBrueche = 0; 
	// konstruktor
	Bruch2(int z, int n){
		zaehler = z;
		nenner = n;
		anzahlBrueche++;
	}
	// methode extra zur ausgabe der brüche mit system.out.println
	void bruchAusgeben(){
		System.out.println(zaehler + "/" + nenner);
	}
	// statische (getter-)methode für rückgabe der aktuellen anzahl brüche
	static int getAnzahlBrueche(){
		return anzahlBrueche;
	}
}
