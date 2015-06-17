package suchenUndSortieren.kapitel09;

import java.util.ArrayList;

import suchenUndSortieren.kapitel09.Graph.Knoten;

/**
 *Ein Zusammenhangskomponent ist ein Bereich in einem Graphen indem jeder Knoten in diesem Bereich von jedem anderen Knoten
 *in dem Berreich erreichbar ist. Ein solcher Bereich ist zum Beispiel ein Zyklus, oder einfach nur ein Knoten.
 *Kanten die nicht in einer Zusammenhangskompentne liegen verbinden zwei Zusammenhangskomponenten.
 *
 *Dieses Prinzip kann zum Beispiel in der Topologie verwendet werden.
 */
public class Zusammenhangskomponenten {
	/*ArrayList<Character> stapel = new ArrayList<Character>();*/ // neuen Stapel anglegen, um aus ihm später namen der Zyklen-Knoten auszulesen
	private int zaehler = 1;	//für das finden der Nummern
	
	
	/**
	 * Die Methode "zusammenhangskomponenten" findet auch Zyklen und bennent diese, wie auch schon "zyklenfinden".
	 * Jedoch ist "zusammenhangskomponenten" erweitert um die möglichkeit Zusammenhangskomponenten zu finden und somit einen
	 * Quotientengraph zu erstellen, welcher natürlich keine Zyklen enthält.
	 * 
	 * Die auskommentierten Zeilen (/*) sind, wenn man einen gefundenen Zyklus mit namen ausgeben möchte.
	 * 
	 * @param graph		welcher Graph durchsucht werden soll
	 * @param startKnoten	an welchem Knoten die suche beginnen soll.
	 */
	public void zusammenhangskomponenten(Graph graph, char startKnoten) {				
		Knoten k = graph.Knoten.get(startKnoten);
		if (k.zustand.equals("in Bearbeitung")) { 	//wenn Knoten schon augerufen jedoch noch nicht abgeschlossen ist
			/*System.out.print("Zyklus gefunden: ");							// gibt den Zyklus...
			for (int i = stapel.indexOf(startKnoten); i < stapel.size(); i++) {	
				System.out.print(stapel.get(i) + "-->");						// ...mit des Knotens...
			}
			System.out.println(startKnoten);*/									// ...Namen aus
		} else if (k.zustand.equals("noch nicht begonnen")) { // wenn Knoten noch nicht berührt wurde
			k.zustand = "in Bearbeitung";		// Knoten dem stapel hinzufügen
			/*stapel.add(startKnoten);*/
			k.tiefensuchnnummer = zaehler;
			k.komponentennummer = zaehler;
			zaehler++;
			for (char c : k.nachbern) {			// zyklensuche rekursive aufrufen um nachbern des Knotens abzusuchen
				if (!graph.Knoten.get(c).zustand.equals("abgeschlossen")) {
					zusammenhangskomponenten(graph, c);
					if (k.komponentennummer > graph.Knoten.get(c).komponentennummer) {	// Komponentenummer bestimmen
						k.komponentennummer = graph.Knoten.get(c).komponentennummer;
					}
				}
			}
			k.zustand = "abgeschlossen";
			/*stapel.remove((Character)startKnoten);*/	// Knotem vom Stapel entfernen
			if (k.tiefensuchnnummer == k.komponentennummer) {
				System.out.println("Komponente gefunden! Knoten mit der Komponentennummer '" + k.komponentennummer + "' liegen in der selben Komponente.");
			}
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
		
		Zusammenhangskomponenten test = new Zusammenhangskomponenten();
		
		test.zusammenhangskomponenten(g, 'a');		
	}
}
