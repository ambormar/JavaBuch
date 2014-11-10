package uebungen02;

/* TODO .2.4.3.   s.93 (eigtl. 9.4., s.295)
 * class ModuloOperator_AnwendungsBsp
 * 
 * MODULO OPERATOR ANWENDUNGS-BSP siehe:	9.4.  	Klasse Jigloo_Events_GUI_AlteZaehlweise,	Aufgabe 2, s.295, 	ca. zeile 130
 * 									&:		2.4.3.	Arithmetische_Operatoren					s.93
 * 
 * 
 * BSP (9.4.): 
 * 
 * 	private void umrechnen() {
		int stueck, gros, schock, dutzend;
		stueck = Integer.parseInt(jTFStueckzahl.getText());
		
		// MODULO OPERATOR Musteranwendung
				// alle nachkommastellen werden abgeschnitten da integer > also stueck(zahl) durch einheit teilen
		gros = stueck / 144; 				// stueck durch einheit (144 sind ein gros) 
		stueck = stueck % 144; 				// immer wieder rest ermitteln und stueck zuweisen
		schock = stueck / 60; 				// rest-stueck durch schock (60)
		stueck = stueck % 60;				// immer wieder rest ermitteln und stueck zuweisen
		dutzend = stueck / 12;				// rest-stueck durch dutzend (12)
		stueck = stueck % 12;				// immer wieder rest ermitteln und stueck zuweisen
		
		jLGros.setText(gros + " Gros");
		jLSchock.setText(schock + " Schock");
		jLDutzend.setText(dutzend + " Dutzend");
		jLStueck.setText(stueck + " Stück");
		
		jTFStueckzahl.requestFocus();
		jTFStueckzahl.selectAll();
	}
 */
public class ModuloOperator_AnwendungsBsp {

}
