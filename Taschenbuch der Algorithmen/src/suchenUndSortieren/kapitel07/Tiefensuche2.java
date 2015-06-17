package suchenUndSortieren.kapitel07;

import java.util.Stack;

import suchenUndSortieren.kapitel07.Tiefensuche2Graph.Knoten;


/**
 *Dies ist eine weitere Methode für die Tiefensuche, mit dem unterschied, dass hier keine
 *Rekursion verwendet wird, sondern ein Stapel.
 *
 */
public class Tiefensuche2 {

	public void tiefensuche2(Tiefensuche2Graph graph, char startKnoten, char zielKnoten) {
		Stack<Knoten> stapel = new Stack<Knoten>(); //der Stapel
		stapel.push(graph.knoten.get(startKnoten)); //der erste Knoten wird dem Stapel übergeben
		
		//solange der Stapel nicht leer ist und noch nicht das der Ziel Knoten gefunden wurde
		while (!stapel.empty() && !(stapel.peek().name == zielKnoten)) {
			
			//wenn der Knoten noch nicht endeckt wurde
			if (!stapel.peek().entdeckt) {
				stapel.peek().entdeckt = true; //den Zustand des Knoten Updaten
			} else {	// wenn der Knoten bereits entdeckt wurde
				stapel.pop(); // den Knoten entfernen
			}

			
			
			//solange der Stapel nicht leer ist und es nicht noch mehr Benachbarte Kreutzungen gibt als bisher überprüft wurden
			while (!stapel.empty() && !(stapel.peek().anzahlBesuchterNachbarKnoten < stapel.peek().nachbern.size())) {
				stapel.pop(); // Knoten entfernen
			}
			//wenn es noch mehr Benachbarte Kreutzungen gibt als bisher überprüft wurden	
			if (stapel.peek().anzahlBesuchterNachbarKnoten < stapel.peek().nachbern.size()) {
				stapel.peek().anzahlBesuchterNachbarKnoten++; //die Anzahl Besuchter Nachbarn erhöhen
				stapel.push(graph.knoten.get(stapel.peek().nachbern.get(stapel.peek().anzahlBesuchterNachbarKnoten - 1)));	//den NachbarKnoten aufrufen und zum Stapel hinzufügen
				stapel.peek().anzahlBesuchterNachbarKnoten = 0; // den Zähler zurücksetzen (!!!NUR FÜR BWINF WICHTIG!!!)
			}
		}
		//prüfen ob es der gesuchte Knoten ist
		if (stapel.peek().name == zielKnoten) {
			//Ziel gefunden und das Programm abbrechen
			System.out.println("Ziel gefunden!");
			return;
		} else { // wenn es nicht der gesuchte Knoten ist 
			//Ziel nicht gefunden und das Programm abbrechen
			System.out.println("Ziel Nicht Gefunden!");
			return;
		}
	}
	
	
	
	public static void main(String[] args) {
		//Graph/Labyrinth mit allen Knoten und deren nachbers Knoten erstellen START
		char[][] werte = new char[11][3];
		werte[0][0] = 'a'; werte[0][1] = 'b'; werte[0][2] = 'c';
		werte[1][0] = 'b'; werte[1][1] = '0'; werte[1][2] = '0';
		werte[2][0] = 'c'; werte[2][1] = 'f'; werte[2][2] = 'd';
		werte[3][0] = 'd'; werte[3][1] = 'e'; werte[3][2] = '0';
		werte[4][0] = 'e'; werte[4][1] = 'g'; werte[4][2] = 'h';
		werte[5][0] = 'f'; werte[5][1] = 'i'; werte[5][2] = '0';
		werte[6][0] = 'g'; werte[6][1] = '0'; werte[6][2] = '0';
		werte[7][0] = 'h'; werte[7][1] = '0'; werte[7][2] = '0';
		werte[8][0] = 'i'; werte[8][1] = 'j'; werte[8][2] = 'k';
		werte[9][0] = 'j'; werte[9][1] = '0'; werte[9][2] = '0';
		werte[10][0] = 'k'; werte[10][1] = '0'; werte[10][2] = '0';
		
		Tiefensuche2Graph g = new Tiefensuche2Graph(werte);
		//Graph/Labyrinth mit allen Knoten und deren nachbers Knoten erstellen ENDE
		
		new Tiefensuche2().tiefensuche2(g, 'a', 'k');
	}
}
