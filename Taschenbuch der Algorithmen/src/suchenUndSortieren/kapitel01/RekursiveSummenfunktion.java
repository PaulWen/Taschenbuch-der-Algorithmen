package suchenUndSortieren.kapitel01;

/**
 * 
 * Die Klasse demonstriert, wie man die Rekursion benutzen kann. Rukursion
 * bedeutet, dass sich eine Klasse immer wieder selbst aufruft. Dies kann z.B.
 * verwendet werden um die Summenfunktion zu errechen.
 * 
 */
public class RekursiveSummenfunktion {

	public int summenfunktion(int n) {
		n--;
		int ergebniss = 0;
		if (n != 0) {
			ergebniss = (n + summenfunktion(n)); // Methode ruft sich selbst auf: "Rekursion"
		}
		return ergebniss;
	}

	public static void main(String[] args) {
		RekursiveSummenfunktion test = new RekursiveSummenfunktion();
		
		System.out.println(test.summenfunktion(5));
	}

}
