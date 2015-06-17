package suchenUndSortieren.kapitel09;

import suchenUndSortieren.kapitel09.Graph.Knoten;

/**
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
public class Zyklensuche {

	/**
	 * Die Methode "zyklensuche" sucht nach zyklen/ endloschleifen in einem Graphen. Dabei kann in dem zudurchsuchenden
	 * Graphen jeder Knoten für ein Programm stehen, und jeder nachber des Knotens stellt ein Prorgramm dar auf das der Knoten/Programm
	 * warten muss.
	 * Natürlich kann ein Knoten und seine Nachbbern auch für alles andere stehen, indem man ein Zyklus suchen möchte.
	 * 
	 * @param graph		welcher Graph durchsucht werden soll
	 * @param startKnoten	an welchem Knoten die suche beginnen soll.
	 */
	public void zyklensuche(Graph graph, char startKnoten) {
		Knoten k = graph.Knoten.get(startKnoten);
		if (k.zustand.equals("in Bearbeitung")) { 	//wenn Knoten schon augerufen jedoch noch nicht abgeschlossen ist
			System.out.println("Zyklus gefunden!");
		} else if (k.zustand.equals("noch nicht begonnen")) { // wenn Knoten noch nicht berührt wurde
			k.zustand = "in Bearbeitung";
			for (char c : k.nachbern) {			// zyklensuche rekursive aufrufen um nachbern des Knotens abzusuchen
				zyklensuche(graph, c);
			}
			k.zustand = "abgeschlossen";
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
		
		Zyklensuche test = new Zyklensuche();
		test.zyklensuche(g, 'a');		
	}
}
