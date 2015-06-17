package suchenUndSortieren.kapitel10;

import java.util.ArrayList;

/**
 * Die Klasse "Graph" stellt einen Graph dar, welcher alle Knoten und deren nachbarsknoten kennt.
 * Die Knoten werden in der HaschMap "Knoten" gespeichert, welche nur Objekte von Knoten entält.
 * Die Objekte wiederum haben eine ArrayList "nachbern", welche die namen der nachbasknoten des bestimmten Knoten 
 * enthält.
 */
public class Graph {
	ArrayList<Knoten> Knoten = new ArrayList<Knoten>(); // alle Knoten werden hier gespeichert
	
	public Graph(char[][] werte) {
		// alle Knotennamen werden aus dem Array "werte" gelesen und es wird ein Knoten Object erstellt, welches 
		// in "Knoten" abgespeichert wird.
		for (int i = 0; i < werte.length; i++) {
			Knoten.add(new Knoten(werte[i][0], werte[i][1], werte[i][2], werte[i][3], werte[i][4]));
		}
	}
	
	/**
	 * Die Klasse "Knoten" wird benutz um Objekte (Knoten) zu esrtellen, welche eine ArrayListe "nachbern"
	 * enthälten, welche alle namen der nachbarknoten entält. 
	 * Zudem hatt jeder Knoten eine "relevanz", welche angibt wie wichtig die Seite ist.
	 *
	 */
	public class Knoten {
		ArrayList<Character> nachbern = new ArrayList<Character>();
		double relevanz = 1.0;
		char name = ' ';
		
		public Knoten(char name, char nachber1, char nachber2, char nachber3, char nachber4) {
			this.name = name;
			relevanz = 1.0;
			if (nachber1 != '0') {
				nachbern.add(nachber1);
			}
			if (nachber2 != '0') {
				nachbern.add(nachber2);
			}
			if (nachber3 != '0') {
				nachbern.add(nachber3);
			}
			if (nachber4 != '0') {
				nachbern.add(nachber4);
			}
		}
		
	}
}
