package suchenUndSortieren.kapitel07;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * Die Klasse "Graph" stellt einen Graph dar, welcher alle Knoten und deren nachbarsknoten kennt.
 * Die Knoten werden in der HaschMap "Knoten" gespeichert, welche nur Objekte von Knoten entält.
 * Die Objekte wiederum haben eine ArrayList "nachbern", welche die namen der nachbasknoten des bestimmten Knoten 
 * enthält.
 */
public class Tiefensuche2Graph {
	public HashMap<Character, Knoten> knoten = new HashMap<Character, Knoten>(); // alle Knoten werden hier gespeichert
	
	public Tiefensuche2Graph(char[][] werte) {
		// alle Knotennamen werden aus dem Array "werte" gelesen und es wird ein Knoten Object erstellt, welches 
		// in "Knoten" abgespeichert wird.
		for (int i = 0; i < werte.length; i++) {
			knoten.put(werte[i][0], new Knoten(werte[i][0], werte[i][1], werte[i][2]));
		}
	}
	
	/**
	 * Die Klasse "Knoten" wird benutz um Objekte (Knoten) zu esrtellen, welche eine ArrayListe "nachbern"
	 * enthalten, welche alle namen der nachbarknoten entält. 
	 * Zudem haben sie einen Zustand ("entdeckt" oder "unentdeckt").
	 *
	 */
	public class Knoten {
		ArrayList<Character> nachbern = new ArrayList<Character>();
		boolean entdeckt = false;
		char name = ' ';
		int anzahlBesuchterNachbarKnoten = 0;
		
		public Knoten(char name, char nachber1, char nachber2) {
			this.name = name;
			if (nachber1 != '0') {
				nachbern.add(nachber1);
			}
			if (nachber2 != '0') {
				nachbern.add(nachber2);
			}
		}
		
	}
}
