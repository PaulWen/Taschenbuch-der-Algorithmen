package suchenUndSortieren.kapitel07;

import suchenUndSortieren.kapitel07.Tiefensuche1Graph.Knoten;

/**
 * Die Klasse "Tiefensuche1" kann verwendet werden, um einen Knoten in einen Graphen zufinden. Dabei wird
 * so tief wie möglich gesucht (= der ganze graph wird abgesucht).
 * "Tiefensuche1" erledigt dieses suchen rukursiv. Dabei wird für jeden Knoten wenn er erreicht wird
 * rekursive die tiefensuche1 erneut gestartet.
 * 
 * Die Klasse verwendet zudem die Klasse Graph um den zudurchsuchenden Graph als eine Collection abzuspeichern.
 * 
 * Verwendung genauer erläutert:
 * Die Tiefensuche ist auf jeden Graphen anwentbar. Auch auf einen gerichteten Graphen.
 * 
 * Die Tiefensuche ermöglicht es in einem Graphen einen weg von einem Punkt zu einem anderen zu finden.
 * Dabei kann auch herausgefunden werden, das es keinen Weg von a nach b gibt.
 * Natürlich muss man nicht unbedingt nach einem Weg suchen. Wenn man lediglich wissen möchte, ob b von a aus erreibar ist
 * oder b finden möchte von a aus geht das auch.
 * Ebenso lassen sich labyrinthe erstellen, indem man die rekursive tiefensuche verwendet und zufällig die nachberzellen, welche 
 * noch nicht entdeckt wurden aufruft.
 */
public class Tiefensuche1 {

	public void tiefensuche1(Tiefensuche1Graph graph, char startKnoten, char zielKnoten) {
		Knoten a = graph.knoten.get(startKnoten);
		if (a.zustand.equals("entdeckt")) { // entweder man ist im Kreis gelaufen
			
		} else if (a.name == zielKnoten) {	// oder man hat das Ziel gefunden
			System.out.println("Ziel gefunden!");
		} else { // oder aber es muss weiter gesucht werden
			a.zustand = "entdeckt";
			for (char nachber : a.nachbern) {
				tiefensuche1(graph, nachber, zielKnoten);
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
		
		Tiefensuche1 test = new Tiefensuche1();
		test.tiefensuche1(g, 'a', 'f');		
	}

}
