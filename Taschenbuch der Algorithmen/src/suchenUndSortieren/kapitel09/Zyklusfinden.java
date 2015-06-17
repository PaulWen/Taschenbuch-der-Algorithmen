package suchenUndSortieren.kapitel09;

import java.util.ArrayList;

import suchenUndSortieren.kapitel09.Graph.Knoten;

/**
 * Die Klasse "Zyklenfinden" ist eine verbesserung der Klasse "Zyklensuche", indem "zyklenscuhe" die erkannten Zyklen auch ausgibt.
 * 
 * Die Zyklensuche dient zum suchen nach Zyklen/endlosschleifen, welche zum Beispiel bei Programmen, welche von bestimmten Programmen 
 * abhängen entstehen, wenn die Pogramme gegenseitig auf einander warten und keines fortfahren kann.
 *
 *Beim Suchen geht der Zyklensuchen Algorithmus ehnlich dem "Tiefensuche1" Algrorithmus vor, (welcher auch schon Zyklen erkennen konnte)
 *indem er unteranderm auch rekursion benutzt.
 *
 *Leider werden mit dem Algorithmus Zyklensuche nicht alle Zyklen erkannt, so kann es vor kommen, dass nur 2 Zyklen von 4
 *in einem Graph gefunden werden. Jedoch kann man sich sicher sein, dass wenn nur ein Zyklus im Graph vorhanden ist der 100% gefunden wird.
 *Man kann also sagen, dass sich der Algorithmus mehr dafür eignet zu fragen ob ein Zyklus vorkommt, jedoch nicht wieviele Zyklen vorkommen.
 **/
public class Zyklusfinden {
	/**
	 * Die Methode "zyklenfinden" sucht  nach zyklen/ endloschleifen in einem Graphen und gibt diese aus.
	 * Dabei kann in dem zudurchsuchenden Graphen jeder Knoten für ein Programm stehen, und jeder Nachber des Knotens
	 * stellt ein Prorgramm dar auf das der Knoten/Programm warten muss.
	 * Natürlich kann ein Knoten und seine Nachbbern auch für alles andere stehen, indem man ein Zyklus suchen möchte.
	 * 
	 * @param graph		welcher Graph durchsucht werden soll
	 * @param startKnoten	an welchem Knoten die suche beginnen soll.
	 */
	public void zyklenfinden(Graph graph, char startKnoten, ArrayList<Character> stapel) {				
		Knoten k = graph.Knoten.get(startKnoten);
		if (k.zustand.equals("in Bearbeitung")) { 	//wenn Knoten schon augerufen jedoch noch nicht abgeschlossen ist
			System.out.print("Zyklus gefunden: ");							// gibt den Zyklus...
			for (int i = stapel.indexOf(startKnoten); i < stapel.size(); i++) {	
				System.out.print(stapel.get(i) + "-->");						// ...mit des Knotens...
			}
			System.out.println(startKnoten);									// ...Namen aus
		} else if (k.zustand.equals("noch nicht begonnen")) { // wenn Knoten noch nicht berührt wurde
			k.zustand = "in Bearbeitung";		// Knoten dem stapel hinzufügen
			stapel.add(startKnoten);
			for (char c : k.nachbern) {			// zyklensuche rekursive aufrufen um nachbern des Knotens abzusuchen
				zyklenfinden(graph, c, stapel);
			}
			k.zustand = "abgeschlossen";
			stapel.remove((Character)startKnoten);	// Knotem vom Stapel entfernen
		}
	}
	
	public static void main(String[] args) {
		//gerichteten Graph mit allen Knoten und Kanten erstellen START
		char[][] werte = new char[5][5];
		werte[0][0] = 'a'; werte[0][1] = 'b'; werte[0][2] = 'c'; werte[0][3] = '0'; werte[0][4] = '0';
		werte[1][0] = 'b'; werte[1][1] = 'd'; werte[1][2] = '0'; werte[1][3] = '0'; werte[1][4] = '0';
		werte[2][0] = 'c'; werte[2][1] = 'd'; werte[2][2] = '0'; werte[2][3] = '0'; werte[2][4] = '0';
		werte[3][0] = 'd'; werte[3][1] = 'e'; werte[3][2] = '0'; werte[3][3] = '0'; werte[3][4] = '0';
		werte[4][0] = 'e'; werte[4][1] = 'b'; werte[4][2] = '0'; werte[4][3] = '0'; werte[4][4] = '0';
		
		Graph g = new Graph(werte);
		
		//Graph mit allen werten implementieren ENDE
		
		Zyklusfinden test = new Zyklusfinden();
		
		ArrayList<Character> stapel = new ArrayList<Character>(); // neuen Stapel anglegen, um aus ihm später namen der Zyklen-Knoten auszulesen
		test.zyklenfinden(g, 'a', stapel);		
	}
}
