package suchenUndSortieren.kapitel07;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import suchenUndSortieren.kapitel07.Tiefensuche1Graph.Knoten;

/**
 * Die Breitensuche durchsucht wie die Tiefensuche einen Graphen. Jedoch geht die Breitensuche nicht wie die Tiefensuche 
 * direkt sehr tief in den Graphen und entfent sich so wohlm�glich von dem Ziel, sondern sucht ebene f�r ebene ab.
 * Dies ist besonders brauchbar, wenn man wei� das sich das Ziel nahe dem Start befindet.
 */
public class Breitensuche {
	
	public void breitensuche(Tiefensuche1Graph graph, char startKnoten, char zielKnoten) {
		Queue<Knoten> warteschlange = new ArrayBlockingQueue<Knoten>(graph.knoten.size()); // Wartescchlange erstellen
		warteschlange.offer(graph.knoten.get(startKnoten));		// der Warteschlange den Startkonoten hinzuf�gen

		while (warteschlange.isEmpty() == false) {				// solange nicht alle Knoten aus derWarteschlange abgesucht wurden
			Knoten knoten = warteschlange.poll();				// nehme den fordersten Knoten aus der Warteschlange
			if (knoten.zustand.equals("unentdeckt")) {			// wenn der noch nicht gefunden wurde dann...
				if (knoten.name == zielKnoten) {				// ... �berpr�fe ob es das Ziel ist
					System.out.println("Ziel gefunden!");
					break;
				}
				knoten.zustand = "entdeckt";					// ansonsten mackiere den Knoten als gefunden
				for (char c : knoten.nachbern) {				// und f�ge alle nachbers Knoten von ihm der Warteschlange hinzu
					warteschlange.offer(graph.knoten.get(c));
				}
			}
		}
	}
	
	public static void main(String[] args) {
		//Graph/Labyrinth mit allen Knoten und deren nachbers Knoten erstellen START
		char[][] werte = new char[8][5];
		werte[0][0] = 'a'; werte[0][1] = 'c'; werte[0][2] = '0'; werte[0][3] = '0'; werte[0][4] = '0';
		werte[1][0] = 'b'; werte[1][1] = 'c'; werte[1][2] = '0'; werte[1][3] = '0'; werte[1][4] = '0';
		werte[2][0] = 'c'; werte[2][1] = 'a'; werte[2][2] = 'b'; werte[2][3] = 'd'; werte[2][4] = 'e';
		werte[3][0] = 'd'; werte[3][1] = 'c'; werte[3][2] = '0'; werte[3][3] = '0'; werte[3][4] = '0';
		werte[4][0] = 'e'; werte[4][1] = 'f'; werte[4][2] = 'g'; werte[4][3] = '0'; werte[4][4] = '0';
		werte[5][0] = 'f'; werte[5][1] = 'e'; werte[5][2] = '0'; werte[5][3] = '0'; werte[5][4] = '0';
		werte[6][0] = 'g'; werte[6][1] = 'e'; werte[6][2] = 'h'; werte[6][3] = '0'; werte[6][4] = '0';
		werte[7][0] = 'h'; werte[7][1] = 'g'; werte[7][2] = '0'; werte[7][3] = '0'; werte[7][4] = '0';
		
		Tiefensuche1Graph g = new Tiefensuche1Graph(werte);
		//Graph/Labyrinth mit allen Knoten und deren nachbers Knoten erstellen ENDE
		
		Breitensuche test = new Breitensuche();
		test.breitensuche(g, 'a', 'f');				
		
	}

}
