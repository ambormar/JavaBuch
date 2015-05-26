/* TODO 14.2.3.   s.453,
 * Synchronisation_VonThreads_Problematik_Begriff_Synchronized_Modifier
 * 
 * 		ANGEWANDT SIEHE:		14.2.4.   	JBallPanel_Synchronized_Therads		& 	Threads_Synchronized_Interrupt_Bewegungsablauf_BallAnimation		s.454,  
 * 
 * 	SYNCHRONISATION VON THREADS:	
 * 		
 * 		BEGRIFF:	=> m�glichkeiten zur vorbeugung von konflikten, die durch die gleichzeitigkeit von anweisungen beim einsatz von Threads entstehen k�nnen
 * 
 * 		PROBLEMATIK BSPe:
 * 
 * 					-> 2 oder mehr Threads bearbeiten die gleiche datei:			-> ein thread versucht in die Datei zu l�schen
 * 																					-> gleichtzeitig versucht ein anderer in die datei zu schreiben
 * 			
 * 					-> 2 threads bearbeiten zeitgleich dieselbe boolsche variable: 	-> beide gehen davon aus, dass der zustand der variable (true/false) so ist, wie sie im jeweiligen thread gesetzt wurde 
 * 
 * 		L�SUNGEN:	=> SYNCHRONISATION VON THREADS 
 * 						-> unter dem stichwort SYNCHRONISATION VON THREADS findet man bei java jede menge information 
 * 				
 * 					=> konkretes angewandtes BSP:	SIEHE:		14.2.4.   	JBallPanel_Synchronized_Therads		& 	Threads_Synchronized_Interrupt_Bewegungsablauf_BallAnimation		s.454,  
 * 
 * 
 * 	SYNCHRONIZED (THREADS), MODIFIER: 
 * 
 * 		=> der modifier synchronized ist eine massname von java gegen probleme bei parallel ablaufenden Anweisungsfolgen bei Threads
 * 
 * 		=> mit synchronized kann man sicherstellen, dass die dadurch gesch�tzten bereiche, zu einem zeitpunkt nur von einem Thread ausgef�hrt werden.
 * 		   		-> dies gilt aber nur, wenn sie f�r die gleiche objekt-instanz (hier der klasse JBallPanel_.. ) aufgerufen werden.
 * 				-> der erste thread, der den zugriff erh�lt, setzt eine sperre, der allf�llige zweite thread muss warten bis die sperre wieder aufgehoben ist
 * 
 * 				=> es m�ssen alle bereiche mit synchronized gesch�tzt werden die nicht zeitgleich von verschiedenen threads bearbeitet werden d�rfen (hier am bsp. variable x)
 * 
 * 					-> BSP hier:	=> 2 bereiche in denen auf die gleiche variable x zugegriffen wird:
 * 
 * 										[ NB:	Attribut-deklaration:		public int x;					=> warum nicht private; evtl. spezieller umgang wegen synchronized ???????????? ]
 * 
 * 
 * 										1. f�r die gesammte paintComponent-methode()						=> geh�rt zum normalen (ersten) programm-ablaufs-thread 
 * 
 *											 	public synchronized void paintComponent(Graphics g) {			// synchronized f�r ganze methode 
 *													..						
 *													g.drawImage(img, x, ..);									// auf variable x soll nur von einem thread auf's mal zugegriffen werden
 *												}
 * 
 * 
 * 										2. in der metode run() vor einem einfachen anweisungsblock			=> run() wird ja von zus�tzlichen (zweiten) thread verwendet
 * 
 * 												SCHEMA:  synchronized (this) {..}							=> wenn der modifier nicht im kopf einer methode benutzt wird
 * 
 *												public void run() {												// methode run() auf die der zus�tzliche Thread zur�ckgreift
 *													..									
 *														synchronized (this) {									// synchronized (this)  -> nur f�r den anweisungs-block wo x bearbeitet wird		
 *															if (x > getWidth() - img.getWidth(this)) {			// .. (this) => f�r das instanz-objekt dieser klasse 							
 *																..							
 *															}
 *														}														// synchronized fertig 
 *														..														// die folgenden abweisungen bearbeiten x nicht, m�ssen also nicht synchronized werden
 *													..
 *												}
 *							
 * 									=> SIEHE: 		14.2.4.   	JBallPanel_Synchronized_Therads		& 	Threads_Synchronized_Interrupt_Bewegungsablauf_BallAnimation		s.454,  
 * 
 *		=> 	METHODEN (von der Klasse Object vererbt) f�r Threads zur kommunikation + konfliktl�sung �ber sperrzust�nde, innerhalb von Anweisungsbl�cken, die mit synchronized gesch�tzt sind
 *				
 *				wait(); 				beschreibung ausstehend
 *				notify();				beschreibung ausstehend
 *				notifyAll();			beschreibung ausstehend
 * 
 * 
 * 		=>  JE EIN THREAD PRO INSTANZOBJEKT EINER KLASSE:		SYNCHRONIZED NICHT N�TIG:		
 * 
 * 				SIEHE:		14.3.   Threads_ZweiAmpelnGleichzeitigAutomatik_ZweiAmpelSteuerung			Aufgabe 2,   s.459, verwendet JAmpelPanel_5
 * 									=> SYNCHRONIZED
 * 
 * 						=> Da 2 Instanzen des JAmpelPanel_5 als jeweilige zus�tzliche Threads laufengelassen werden m�ssen sie nicht synchronized werden
 * 							-> nur wenn auf variabeln etc. von 2 Threads aus dem selben instanzobjekt zugegriffen wird braucht's synchronized	
 * 
 * 							BSP OK: 
 * 			
 *								private JAmpelPanel_5 jPanel1;
 *								private JAmpelPanel_5 jPanel2; 
 *	
 *	 							private void jBtnStartActionPerformed(ActionEvent evt) {
 *									Thread ampel1 = new Thread(jPanel1);
 *									jPanel1.automatik = true;
 *									ampel1.start();
 *									Thread ampel2 = new Thread(jPanel2);
 *									jPanel2.automatik = true;
 *									ampel2.start();
 *								}
 *
 *
 */

package uebungen14;

public class Synchronisation_VonThreads_Problematik_Begriff_Synchronized_Modifier {

}
