/* TODO .4.2.1.   eigene bemerkung 
 * class GIT_SVN_Repositorys_ImVergleich
 * 
 * 		SIEHE AUCH:		4.2.1.   Eclipse_GitHub_Repository_Commiten			eigene bemerkung 
 * 
 * 		SIEHE AUCH:		4.2.1.   Eclipse_GitHub_JavaProjekt_SynchronisiertErstellen		eigene bemerkung
 * 
 * 
 * 	GIT & SVN	-	BEKANNTE REPOSITORYS IM VERGLEICH:
 * 
 * 		GIT:	=> Git ist das aktuellere neuere Repository-System 
 * 				=> GitHub = bekannter anbieter von git
 * 				=> Kommitten ist mit GIT auch ohne server-/Internet-verbindung möglich	-> mit dem Git-Programm auf dem eigenen kompi	
 * 																						-> späteres pushen auf's Git auf dem server aber nötig
 * 				
 * 
 * 								KOMPI / Git-Programm													SERVER / Git Internet
 * 					_________________________________________				PULL				_________________________________________
 * 					|										|		<----------------------		|										|
 * 					| alle committ-eten projekt-versionen	|									| alle ge-push-ten projekt-versionen	|
 *    				|_______________________________________|		---------------------->		|_______________________________________|
 *    																		PUSH
 * 						|							|
 * 			  CHECKOUT  |							|  COMMIT
 * 						|							|
 * 						v			ECLIPSE			v																	
 * 					_________________________________________		
 * 					|										|
 * 					| 	aktuell bearbeitete version			|
 * 					|	(meist die neueste)					|
 *    				|_______________________________________|
 *    
 *    
 * 
 * 		SVN:	=> SVN ist ein ältere Repository-System 
 * 				=> viele leute bevorzugen es, v.a. PC-User
 * 				=> Source-Forge = bekannter anbieter von SVN
 * 				=> SVN funktioniert ein bisschen einfacher, hat direktere Fehlermeldungen, weniger Konfliktmöglichkeiten (weil nur commits & updates, kein push & pull)
 * 				
 * 
 * 								KOMPI 																		SERVER 
 * 					_________________________________________				UPDATE				_________________________________________
 * 					|										|		<----------------------		|										|
 * 					| 	aktuell bearbeitete version			|									| alle ge-update-ten projekt-versionen	|
 * 					|	(meist die neueste)					|									|										|
 *    				|_______________________________________|		---------------------->		|_______________________________________|
 *    																		COMMIT
 *
 *
 *
 * 
 */

package uebungen04;

public class GIT_SVN_Repositorys_ImVergleich {

}
