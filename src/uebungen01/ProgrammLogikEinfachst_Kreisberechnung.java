package uebungen01;

/* TODO .1.4,   Aufgabe 2, s.54
 * class ProgrammLogikEinfachst_Kreisberechnung
 * 
 * auf konsole ausgeführt:
 * 
 * Kreisberechnung: für einen kreis mit dem radius 5 cm 
 * wird der umfang und die fläche berechnet */

public class ProgrammLogikEinfachst_Kreisberechnung {
	public static void main(String[] args) {
		double radius, umfang, inhalt;
		radius = 5.0;
		umfang = 2.0 * 3.1415926 * radius;
		inhalt = 3.1415926 * radius * radius;
		System.out.print("Umfang: ");
		System.out.println(umfang);
		System.out.print("Flaeche: ");
		System.out.println(inhalt);
	}
}