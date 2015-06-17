package suchenUndSortieren.kapitel06;

/**
 * Die Klasse "NaivesSuchenPosition1" durchsucht den Text t auf das Wort w durch vergleichen der einzelnen Buchstaben.
 * Jedoch wird hier w in t nur am anfang gesucht (Position1), was diese Variante zum Text durchsuchen unnützlich macht.
 *  
 */
public class NaivesSuchenPosition1 {

	public void naivesSuchenPosition1(char[] t, char[] w) {
		int i = w.length - 1;
		
		while (i >= 0 && w[i] == t[i]) {
			i--;
		}
		if (i == -1) {
			System.out.println("Das Wort kommt an Position1 im Text vor." );
		} else {
			System.out.println("Das Wort kommt nicht an Position1 im Text vor.");
		}
	}
	
	public static void main(String[] args) {
		NaivesSuchenPosition1 test = new NaivesSuchenPosition1();
		
		// zu durchsuchender Text t (such die nadel im heu.)
		char[] t = {'s', 'u', 'c', 'h', ' ', 'd', 'i', 'e', ' ', 'n', 'a', 'd', 'e', 'l', ' ', 'i', 'm', ' ', 'h', 'e', 'u', '.'};
		// zu suchendes Wort w
		char[] w = {'n', 'a', 'd', 'e', 'l'};
	
		test.naivesSuchenPosition1(t, w);
	}

}
