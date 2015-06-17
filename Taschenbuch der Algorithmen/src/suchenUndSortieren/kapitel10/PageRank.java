package suchenUndSortieren.kapitel10;

import suchenUndSortieren.kapitel10.Graph;
import suchenUndSortieren.kapitel10.Graph.Knoten;

/**
 * Der Algorithmus PageRank dient zum bestimmen der Relevanz einer Seite, um die wichtigsten Seiten in einer Menge V zu finden.
 * Dabei werden Seiten als wichtig eingestuft, wenn sie auf anderen Seiten oft verlinkt sind, welche auch wiederum oft verlinkt sind.
 * (Um so öfter man durch Links etc. auf eine Seite stößt beim surfen im Internet, um so relevanter ist die Seite )
 *
 */
public class PageRank {

	/**
	 * Hier wird die Relefanz einer Seite (Knoten) berechnet.
	 * 
	 * @param graph		stellt das Internet da (Knoten = Seiten, Nachbern = Links)
	 */
	public void pageRank(Graph graph) {
		for (int i = 0; i < 12; i++) {		// solange werte sich Relevanzen noch nennenswert ändern
			System.out.println(i + ".Schritt");
			for (Knoten knoten : graph.Knoten) {	// für jede zuberwertene Seite
				System.out.println(knoten.name + ":" + knoten.relevanz);
				// bestimmung der neuen Relefanz der Seite START
				double rXalX = 0.0;		// Relevanz von XKnoten / Anzahl Links von XKnoten
				for (Knoten xknoten : graph.Knoten) {
					for (Character c : xknoten.nachbern) {
						if (c == knoten.name) {
							rXalX = rXalX + (xknoten.relevanz / (double)xknoten.nachbern.size());
						}
					}
				}
				knoten.relevanz = (4.0/5.0) * rXalX + (1.0/5.0) * (1.0/(double)graph.Knoten.size());
				// bestimmung der neuen Relefanz der Seite ENDE
			}
		}
	}
	
	public static void main(String[] args) {
		//Graph mit allen Werten implementieren START
		char[][] werte = new char[6][5];
		werte[0][0] = 'a'; werte[0][1] = 'c'; werte[0][2] = '0'; werte[0][3] = '0'; werte[0][4] = '0';
		werte[1][0] = 'b'; werte[1][1] = 'a'; werte[1][2] = '0'; werte[1][3] = '0'; werte[1][4] = '0';
		werte[2][0] = 'c'; werte[2][1] = 'b'; werte[2][2] = 'd'; werte[2][3] = 'f'; werte[2][4] = '0';
		werte[3][0] = 'd'; werte[3][1] = 'b'; werte[3][2] = '0'; werte[3][3] = '0'; werte[3][4] = '0';
		werte[4][0] = 'e'; werte[4][1] = 'b'; werte[4][2] = '0'; werte[4][3] = '0'; werte[4][4] = '0';
		werte[5][0] = 'f'; werte[5][1] = '0'; werte[5][2] = '0'; werte[5][3] = '0'; werte[5][4] = '0';
		
		Graph g = new Graph(werte);
		
		//Graph mit allen Werten implementieren ENDE
		
		PageRank test = new PageRank();
		test.pageRank(g);
		
	}
}
