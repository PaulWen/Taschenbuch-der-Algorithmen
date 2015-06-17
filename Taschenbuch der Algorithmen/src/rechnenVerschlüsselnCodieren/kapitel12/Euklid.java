package rechnenVerschlüsselnCodieren.kapitel12;

/**
 * Mit diesem Algorithmus ist es möglich den größenten gemeinsamen Teiler von zwei Zahlen ("a" und "b") zufinden.
 * Dabei ist er wehsentlich schneller als der langsame Euklid, da er größere Schritte beim substrahieren macht.
 * (man kann nur nach einem ganzen gemeinsamen Teiler zweier Positiven Zahlen suchen)
 *
 */
public class Euklid {
	
	public int euklid(int a, int b) {
		
		if (a < b) {		// wenn a kleiner b ist vertausche a und b
			int hand = a;
			a = b;
			b = hand;
		}
		
		while (b > 0 && a != b) {
			int q = a / b;		// q (=ganze Zahl/ ohne rest) bei der division a / b bestimmen
			int r = a - q * b;	// rest bei der division a / b bestimmen
			a = b;
			b = r;
		}
		
		return a;
	}
	
	public static void main(String[] args) {
		Euklid test = new Euklid();
		
		System.out.println(test.euklid(6, 6));

	}
}
