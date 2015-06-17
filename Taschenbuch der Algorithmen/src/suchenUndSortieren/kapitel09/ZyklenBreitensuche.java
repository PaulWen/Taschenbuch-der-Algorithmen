package suchenUndSortieren.kapitel09;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import suchenUndSortieren.kapitel09.Graph.Knoten;
/**
 * Wenn man nun jedoch nur abfragen möchte ob ein bestimmter Knoten in einem Zyklus steht, kann man dies mit der
 * Breitensuche sehr leicht und schnell feststellen.
 *
 */
public class ZyklenBreitensuche {
		
	public void zyklenBreitensuche(Graph graph, char suchKnoten) {
		Queue<Knoten> warteschlange = new ArrayBlockingQueue<Knoten>(graph.Knoten.size()); // Wartescchlange erstellen
		warteschlange.offer(graph.Knoten.get(suchKnoten));		// der Warteschlange den Startkonoten hinzufügen
		
		while (warteschlange.isEmpty() == false) {				// solange nicht alle Knoten aus derWarteschlange abgesucht wurden
			Knoten knoten = warteschlange.poll();				// nehme den fordersten Knoten aus der Warteschlange
			if (knoten.name == suchKnoten || knoten.zustand.equals("noch nicht begonnen")) {	// wenn der Knoten der "suchKnoten" ist oder der Knoten noch nie aufgerufen wurde dann...
				if (knoten.name == suchKnoten && knoten.zustand.equals("entdeckt")) {			// ... überprüfe ob es "suchKnoten" ist
					System.out.println("Knoten " + knoten.name + " ist in einem Zyklus.");	
					break;																		// wenn es "suchKnoten" ist wird dieser ausgegeben und suche wird beendet
				}
				knoten.zustand = "entdeckt";					// ansonsten mackiere den Knoten als gefunden
				for (char c : knoten.nachbern) {				// und füge alle nachbers Knoten von ihm der Warteschlange hinzu
					warteschlange.offer(graph.Knoten.get(c));
				}
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
		
		ZyklenBreitensuche test = new ZyklenBreitensuche();
		test.zyklenBreitensuche(g, 'a');		
	}
}
	
	

