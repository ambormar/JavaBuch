package uebungen04;

/* TODO .4.2.2.(eigntl. 8.1.2)   s.228
 *
 *	AUTOVERVOLLST�NDIGUNG:		- Eingabe code bsp.: 	String a = "Text";
 *														a.c...	=> und eclipse blendet automatisch alle methoden von String die mit c.. anfangen ein
 *														
 *								- mit doppelklick einen der erg�nzungs-vorschl�ge aus 1. fenster ausw�hlen ..
 *									
 *									im 1.Fenster nach SCHEMA:	charAt		(int index)				char	-	String
 *																	|			|						|			|			
 *															methodenname	parameterliste		r�ckgabetyp		klasse (der methode)
 *
 *								- ..ODER:  einfachklick auf die verschiedenen vorschl�ge  [wie zb.: charAt(..), codePointAt(..), compareTo(..)]
 *									=> f�r genauere beschreibung in 2. fenster
 *								 		
 */
public class Eclipse_Autovervollstaendigung_MethodenVonKlassen {
	public static void main(String[] args){
		String a = "text";
		a.charAt(2);
	}
}
