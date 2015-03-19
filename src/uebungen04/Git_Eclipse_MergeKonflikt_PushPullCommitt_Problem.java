/* TODO .4.2.1.   eigene bemerkung
 * Git_Eclipse_MergeKonflikt_PushPullCommitt_Problem
 * 
 * 		 		GITHUB - SYNCHRONISIERTES JAVAPROJEKT ERSTELLEN SIEHE: 		4.2.1.   Eclipse_GitHub_JavaProjekt_SynchronisiertErstellen		eigene bemerkung 
 * 
 * 				Git & SVN IM VERGLEICH	-	SIEHE AUCH:						4.2.1.   GIT_SVN_Repositorys_ImVergleich						eigene bemerkung 
 * 
 * 
 * GIT / ECLIPSE - MERGEKONFLIKT, PULL-PUSH-PROBLEME:
 * 
 * 		MERGE-KONFLIKT:		=> 2 versionen einer klasse kommen in einen konflikt, das system weiss nicht mehr welche version den richtigen code beinhaltet 
 * 							=> es kann z.b. noch commitet werden, aber nicht mehr gepusht 	-> fehlermeldung beim letzten fenster nach dem pushen:
 * 																								roter fehlerpunkt, 		mit text ca.: 	Head master reject, non fast forward (oder so)
 * 		
 * 
 * 		MÖGLICHE VORGEHENSWEISE (leider nur grob, da nicht simulierbar ohne ghetto):			!!!!!!	OHNE 100% GEWÄHR	!!!!! , 	
 * 
 * 			=> ACHTUNG: zuerst immer das backup (auf dem eigenen kompi) des projekt-ordners aktualisieren		!!!!!
 * 
 * 			=> projekt-ordner im package-explorer re-click > team > Synchronize Workspace
 * 
 *  		=> in der Workspace-Synchronize-ansicht:		
 *  
 *  					=> text links oben (z.b.):				->  (1) incomming  + (10) outgoing changes		(=> die alle nicht mehr gepullt / gepusht wurden) 
 * 
 * 								-> menue li oben:  -> das pull-icon drücken zuerst		->  immer wenn es offene incomming changes hat, sonst kann man nicht pushen 
 * 
 * 						=> mergekonflikt:	wenn ein file einen rot markierten doppelpfeil hat		& 		(jene) andere files nicht gepusht werden können
 * 
 * 								-> re-klick auf das fehler-file > (team?) > merge-tool
 * 
 * 								-> panel mit 2 versionen der klasse öffnet		-> links: die neueste version	&	rechts: die ältere version
 * 
 * 								-> linke code-seite anpassen, wie gewünscht		(re bleibt der ältere code)		(evtl. die code-anpasshilfe in der mitte, mit dem roten strich & viereck nutzen)
 * 
 * 								-> dann das angepasste fehler-file speichern mit:		re-click auf file > speichern (??)
 * 
 * 								-> dann auf's angepasste fehler-file im normalen package-explorer: 		re-cklick > team > add to index
 * 
 *  							-> dann auf's angepasste fehler-file im normalen package-explorer: 		re-cklick > team > commit + push
 *						
 * 
 * 			
 * 				
 */

package uebungen04;

public class Git_Eclipse_MergeKonflikt_PushPullCommitt_Problem {

}
