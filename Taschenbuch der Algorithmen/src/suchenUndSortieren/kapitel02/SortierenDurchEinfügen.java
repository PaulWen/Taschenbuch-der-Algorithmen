package suchenUndSortieren.kapitel02;

public class SortierenDurchEinfügen {

	/**
	 * Methode um eine Liste "liste" aufsteigend zu sortieren.
	 * 
	 * @param liste	zu sortierende Liste
	 */
	public void sortierenDurchEinfügen(int[] liste) {
		for (int i1 = 1; i1 < liste.length; i1++) {
			int hand = liste[i1];
			int i2 = i1 - 1;
			while (i2 >= 0 && hand < liste[i2] ) {	// hand > liste[i2], um absteigend zu sortieren
				liste[i2 + 1] = liste[i2];
				i2--;
			}
			liste[i2 + 1] = hand;
		}
	}
	
	public static void main(String[] args) {
		SortierenDurchEinfügen test = new SortierenDurchEinfügen();

		int[] liste = { 9, 7, 4, 1, 8, 2, 3 };
		test.sortierenDurchEinfügen(liste);
		System.out.print("Liste sortiert: ");
		for (int i : liste) {
			System.out.print(i + ", ");
		}
	}
}
