package suchenUndSortieren.kapitel05;

import java.util.ArrayList;

/**
 * Die Klasse "GerichteterGraph" besteht aus zwei main Listen "V" (für die Knotenpubkte) 
 * und "E" (für die Knaten).
 * Die Klasse dient im wesentlichen Knoten und Kanten zu verwalten in den Listen.
 * 
 * Das erstellen eines GerichtetenGraphens benötigt die daten des Graphens, welche im einem 
 * 2D-char-Array vorligen sollten (char[Knoten][mit welchem Knoten sie eine Kante bilden]).
 *
 **/
public class GerichteterGraph {
	//Listen erstellen und mit getter versehen (V = Knoten und E = Kanten) START
	private ArrayList<Character> V = new ArrayList<Character>();
	private ArrayList<Kante> E = new ArrayList<Kante>();
			
	public ArrayList<Character> getV() {
		return V;
	}
	//Listen erstellen und mit getter versehen (V = Knoten und E = Kanten) ENDE

	/**
	 *Der Konstruktor "GerichteterGraph(char[][] werte)" liest die in einem 2D-char-Array "werte" enthaltenen Daten des
	 *zu erstellenen Graphens aus und übertägt mit den Daten die Knoten und Kanten in die entsprechende Liste.
	 * 
	 * @param werte 	enthält die Daten über Knoten und kanten
	 */
	public GerichteterGraph(char[][] werte) {		
		//Knoten in V lesen
		for (int i = 0; i < werte.length; i++) {
			V.add(werte [i][0]);
		}
		
		//Kanten in E lesen
		for (int i = 0; i < werte.length; i++) {
			int j = 1;
			while (j < werte[0].length && werte[i][j] != '0') {
				E.add(new Kante(werte[i][0], werte[i][j]));
				j++;
			}
		}
	}
	
	/**
	 * Die Innereklasse "Kante" dient zum erstellen von Kanten. Sie wird überwiegend dafür
	 * gebraucht, die beiden Knoten die eine bestimmte Kante bilden als ein Objekt von Kante ab
	 * zuspeicher.
	 * 
	 *Dabei bildet die Variable "a" den knoten1 und Variable "b" den knoten2 (a-->b)
	 */
	public class Kante {
		char a = '0'; // knoten1
		char b = '0'; // knoten2
		public Kante(char a, char b) {
			this.a = a;
			this.b = b;
		}
	}
	
	/**
	 * Die Methode "kanteXv" dient dazu Kanten mit irgendeinem knoten1 und einen bestimmten
	 * knoten2 "knoten" in der Liste "V" zu finden.
	 * 
	 * @param knoten bildet knoten2
	 * @return boolean gibtKanteXv		ob es selch eine kante gibt (false wenn nein)
	 */
	public boolean kanteXv(Character knoten) {
		boolean gibtKanteXv = false;
		
		for (Kante k : E) {
			if (k.b == knoten) {
				gibtKanteXv = true;
				return gibtKanteXv;
			}
		}
		return gibtKanteXv;
	}
	
	/**
	 * Die Methode "removeKantevX" löscht alle Kanten aus der Liste "E", welche als
	 * knoten1 "knoten" haben.
	 * 
	 * @param knoten knoten1
	 */
	public void removeKantevX(Character knoten) {
		boolean gefunden = true;
		while (gefunden == true) {
			gefunden = false;
			for (Kante k : E) {
				if (k.a == knoten) {
					E.remove(k);
					gefunden = true;
					break;
				}
			}
		}
	}
}
