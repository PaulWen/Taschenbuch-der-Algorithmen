package suchenUndSortieren.kapitel06;

import java.util.HashMap;

/**
 * Die Klasse "BoyerMooreHorspoolAlg" durchsucht den Text t auf das Wort w durch vergleichen der einzelnen Buchstaben.
 * Mit der Erweiterung zur Klasse "NaivesStringMatching" das hier nicht jede Buchstabe im text mit dem Wort verglichen wird, sonder,
 * alle unötigen Positionen in t übersprungen werden.
 *  
 */
public class BoyerMooreHorspoolAlg {

	/**
	 * Die Methode "erstelleD" wird verwendet um eine HashMap "D" mit den zum Wort "w" passenden Werte
	 * für jeden Buchstaben zu erstellen.
	 * (D wird benötigt um später beim durchsuchen eines Textes zu wissen, welche Positionen wie weit übersprungen werden können.)
	 * 
	 * @param D
	 * @param w
	 * @return HashMap D
	 */
	public HashMap<Character, Integer> initialisiereDw (HashMap<Character, Integer> D, char[] w) {
		//für alle Zeichen wird erstmal angenommen das sie in Wort w nicht vorkommen
		for (Character key : D.keySet()) {
			if (w.length - 1 > 0) { // wenn das Wort aus mehr als nur einem Zeichen besteht.
				D.put(key, w.length - 1);
			} else { // wenn das Wort aus nur einem Zeichen besteht.
				D.put(key, 1);
			}
		}
		
		//alle zeichen die in w vorkommen werden in D neue Werte zugewiesen
		for (int i = 0; i < w.length - 1; i++) {
			if (w.length - 1 > 0) { // wenn das Wort aus mehr als nur einem Zeichen besteht.
				D.put(w[i], (w.length - 1) - i);
			} else { // wenn das Wort aus nur einem Zeichen besteht.
				D.put(w[i], 1);
			}
		}
		return D;
	}
	
	public void boyerMooreHorspoolAlg(char[] t, char[] w) {
		//HashMap D erstellen START
		HashMap<Character, Integer> D = new HashMap<Character, Integer>();
		D.put('a', 0);
		D.put('b', 0);
		D.put('c', 0);
		D.put('d', 0);
		D.put('e', 0);
		D.put('f', 0);
		D.put('g', 0);
		D.put('h', 0);
		D.put('i', 0);
		D.put('j', 0);
		D.put('k', 0);
		D.put('l', 0);
		D.put('m', 0);
		D.put('n', 0);
		D.put('o', 0);
		D.put('p', 0);
		D.put('q', 0);
		D.put('r', 0);
		D.put('s', 0);
		D.put('t', 0);
		D.put('u', 0);
		D.put('v', 0);
		D.put('w', 0);
		D.put('x', 0);
		D.put('y', 0);
		D.put('z', 0);
		D.put('ä', 0);
		D.put('ö', 0);
		D.put('ü', 0);
		D.put('ß', 0);
		D.put(',', 0);
		D.put('.', 0);
		D.put('?', 0);
		D.put('!', 0);
		D.put(' ', 0);
		D.put('"', 0);
		D.put(':', 0);
		D.put('1', 0);
		D.put('2', 0);
		D.put('3', 0);
		D.put('4', 0);
		D.put('5', 0);
		D.put('6', 0);
		D.put('7', 0);
		D.put('8', 0);
		D.put('9', 0);
		D.put('0', 0);
		
		initialisiereDw(D, w);
		//HashMap D erstellen ENDE
		
		//Boyer-Moore-Horspool-Algorithmus
		int pos = 0; //bestimmt wo im Text grade durchsucht werden soll
		while (pos <= (t.length - 1) - (w.length - 1)) {	// suche an allen Positionen im Text
			//eigentliches suchen des Wortes im Text START
			int i = w.length - 1;
			while (i >= 0 && w[i] == t[pos + i]) {
				i--;
			}
			if (i == -1) {
				System.out.println("Das Wort kommt im Text an Position" + pos + " vor." );
			}		
			//eigentliches suchen des Wortes im Text ENDE
			pos = pos + D.get(t[pos + w.length - 1]);
		}
	}
	
	public static void main(String[] args) {
		BoyerMooreHorspoolAlg test = new BoyerMooreHorspoolAlg();
		
		// zu durchsuchender Text t (such die nadel im heu.)
		char[] t = {'s', 'u', 'c', 'h', ' ', 'd', 'i', 'e', ' ', 'n', 'a', 'd', 'e', 'l', ' ', 'i', 'm', ' ', 'h', 'e', 'u', '.'};
		// zu suchendes Wort w
		char[] w = {'n', 'a', 'd', 'e', 'l'};
	
		test.boyerMooreHorspoolAlg(t, w);
	}

}
