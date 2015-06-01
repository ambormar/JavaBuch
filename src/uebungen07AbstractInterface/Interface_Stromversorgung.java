/* TODO .7.3.3.   s.218
 * ABSTRAKTE KLASSEN & INTERFACES (eigene beispiele)
 * 
 * Abstract_Gebaude & AbgeleiteteKlasse_Disko & Interface_Stromversorgung & AbgeleiteteKlasse_Disko_TestAufruf
 * 
 * => bsp. für klasse Disko... die von abstract-klasse Gebaeude... erbt und interface Stromversorgung... implementiert
 * 
 * 
 * ABSTRAKTE KLASSE:	- abstract (schlüsselwort)		BSP:	public abstract class Gebaude {..}
 * 				
 * 						- abstrakte superklasse ist eine klasse von der man klassen ableitet		=> keine reale klasse von der man objekte erzeugt
 * 
 * 														BSP:	public class Disko extends Gebaude {..}
 * 							 
 * 						- gibt methoden & variablen vor die implementiert werden müssen beim erben..
 * 
 * 							1. ABSTRACT-METHODEN = methodenköpfe  ohne rumpf (zwingt zum übernehmen & implementieren) 
 * 
 * 												BSP:	public abstract double getQuadratmeter()	
 * 
 * 								=> POLYMORPHISMUS	= abgeleitete abstract-methoden lösen, ja nach objekt zu dem sie gehören, andere aktionen aus
 * 
 * 							2. NORMALE METHODEN mit rumpf als schnittstellen (fertig implementiert, um wie eine schnittstelle zu benutzen)
 * 								=> methoden der abstractklasse die schon implementiert sind, kann man ganz normal benutzen oder überschreiben (vererbung!)
 * 			
 * 												BSP:	public void setQuadratmeter(double quadratmeter)
 * 
 * 							3. VARIABELN:	=> variabeln können in abstracten klassen MIT oder OHNE werte definiert werden
 * 
 * 											=> sie tragen keinen bezeichner abstract
 * 
 * 						- klassen die von abstract klassen abgeleitet sind könne wiederum abstract definiert werden 
 * 
 * 							=> d.h. nur ein teil der abgeleiteten methoden werden implementiert, ein anderer teil bleibt abstract
 * 								
 * 											
 * INTERFACE:			- interface (schlüsselwort)											BSP:	public interface Stromversorgung {..}
 * 
 * 						- erzeugen mit: FILE - NEW - INTERFACE	 	nicht: FILE - NEW - CLASS (wie z.b. abstract class)
 * 
 * 						- Interfaces sind NUR beschreibungen von schnittstellen:
 * 					
 * 								=> können nur abstrakte Methoden  & Konstanten beinhalten
 *  	
 * 												BSP: 	public double getStromverbrauch(); (kein schlüsselwort abstract!)				
 * 														final double pi = Math.PI;
 * 	
 * 								=> im interface selber sind keine implementierungen möglich		
 *   
 *  					- interfaces werden von klassen implementiert 						BSP:	public class Disko implements Stromversorgung {..}
 *  
 *  							=> die klasse muss alle methoden des interfaces implementieren 	(ausser wenn sie wiederum abstract definiert wird)
 * 						
 * 						- klassen können mehrere interfaces implementieren 	ODER von abstract klasse erben UND mehrere Interfaces implementieren
 * 					
 * 								BSP: public class Disko extends Gebaeude implements Stromversorgung implements Gasversorgung {..}
 * 
 *						- objekte der von interface abgeleiteten klassen können mit OBJEKTDATENTYP der klasse ODER vom Interface erzeugt werden:
 *						
 *								=> sie können dann entweder nur auf die von interface vordefinierten methoden zugreifen: 1.
 *
 *								=> .. oder auch auf zusätzlich definierte methoden der abgeleiteten klasse: 2. 
 *
 *
 *						  		BSP:	interface Stromversorgung { methode(); }
 *	
 *										->	class Disko implements Stromversorgung { methode(); zusätzlicheMethode(); }
 *		
 *
 *						  		->OBJEKTERZEUGUNG:	1.: mit objektdatentyp Stromversorgung:			2.: mit objektdatentyp Disko:		
 *								
 *														Stromversorgung stv = new Disko();				Disko d = new Disko();
 *														stv.methode();									d.methode();
 *														// nicht: stv.zusätzlicheMethode();				d.zusätzlicheMethode();
 *
 *
 *		ANONYME OBJEKTE (OBJEKTINSTANZEN VON INTERFACE) ERZEUGEN MIT INTERFACE:				(bei unklarheiten zu anonyme objekte mj fragen)
 *
 *					- new Runnabel (vom bsp. unten) erzeugt ein neues anonymes Objekt des Interfaces Runnable.
 *						-> dieses anonyme Objekt vom typ Runnable():	-> ist wie eine objektinstanz von einer anonymen Klasse ohne namen, ..
 *																			.. welche innerhalb einer schon vorhandenen klasse erzeugt werden kann, ohne dass man extra eine neue klasse schreiben muss
 *																		
 *						-> die methode .invokelater() der klasse SwingUtilities (im bsp. hier) verlangt nach einem anonymen Runnable-objekt (um einen parallelen thread mit GUI laufen zu lassen)
 *						-> genauso können irgendwelche anonyme Objekte / objektInstanzen von irgendwelchen Interfaces erzeugt werden mit:		
 *
 *										new InterfaceName()
 *
 *						-> dabei müssen zwangsläufig die, vom jeweiligen interface erforderten, methoden implementiert werden:			
 *
 *									-> hier:	 run(){ eigene anweisungen }
 *	
 * 		 		 			BSP: 		SwingUtilities.invokeLater(new Runnable() {		// neues Runnabel-objekt
 *											public void run() {							// methoden die für das jeweilige interface implementiert werden müssen
 *												eigene anweisungen;
 *												..
 *											}
 *										});
 *
 *		
 *												
 * HAUPTUNTERSCHIEDE ABSTRACT-KLASSEN  /  INTERFACE.:
 * 
 * 						- abgeleitete klasse kann nur von EINER abstract-superklasse erben		BSP: 	Disko extends Gebaeude {}
 * 
 * 						- abgeleitete klasse kann aber mehrere Interfaces implementieren		BSP:	Disko implements Stromversorgung implements Gasversorgung {}
 * 
 * 						- abstract klasse kann schon-implemetierte methoden enthalten, interface nicht
 * 
 * 						- abstract klasse kann interface implementieren							BSP:	abstract Gebaeude implements Stromversorgung {}
 * 
 * 						- interface: unterschiedliche Objektdatentyen (interface oder klasse) zur objekterzeugung möglich (siehe INTERFACE ca. zeile 58)
 * 
 * 
 * AUFRUF/OBJEKTERZEUGUNG:	- ..über testklasse DiskoTest ganz normal wie vererbung sonst.
 * 									
 * 									public class DiskoTest {
 * 												
 * 										public static void main(String[] args) {
										Disko d = new Disko();
										d.setQuadratmeter(15);
										System.out.println("Quadratmeter: " + d.getQuadratmeter());
 * 
 */

package uebungen07AbstractInterface;

import javax.swing.SwingUtilities;

import uebungen14Aufgaben.Uhrzeit_2;

public interface Interface_Stromversorgung {
	final double pi = Math.PI;			// nur konstanten möglich, variabeln nicht
	public double getStromverbrauch();	// nur methoden-köpfe um methoden vorzugeben ohne Implementierung/rumpf
										// keine implementierte(ausprogrammierte) methoden(rümpfe) möglich
}
