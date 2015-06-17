package suchenUndSortieren.kapitel06;

/**
 * Die Klasse "NaivesStringMatching" durchsucht den Text t auf das Wort w durch vergleichen der einzelnen Buchstaben genauso wie die Klasse "NaivesSuchenPosition1".
 * Jedoch ist die Klasse "NaivesStringMatching" erweitert um die eigenschaft alle Positionen im Text t nach Wort w abzusuchen,
 * und nicht nur Position1.
 *  
 */
public class NaivesStringMatching {
	
	public void naivesStringMatching(char[] t, char[] w) {
		int pos = 0; //bestimmt wo im Text grade durchsucht werden soll
		while (pos <= (t.length - 1) - (w.length - 1) ) {	// suche an allen Positionen im Text
			//eigentliches suchen des Wortes im Text START
			int i = w.length - 1;
			while (i >= 0 && w[i] == t[pos + i]) {
				i--;
			}
			if (i == -1) {
				System.out.println("Das Wort kommt im Text an Position" + pos + " vor." );
			}		
			//eigentliches suchen des Wortes im Text ENDE
			pos++;
		}
	}
	
	public static void main(String[] args) {
		NaivesStringMatching test = new NaivesStringMatching();
		
		// zu durchsuchender Text t (such die nadel im heu.)
		char[] t = {'s', 'u', 'c', 'h', ' ', 'd', 'i', 'e', ' ', 'n', 'a', 'd', 'e', 'l', ' ', 'i', 'm', ' ', 'h', 'e', 'u', '.'};
		// zu suchendes Wort w
		char[] w = {'n', 'a', 'd', 'e', 'l'};
	
		test.naivesStringMatching(t, w);
	}
}
