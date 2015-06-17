package suchenUndSortieren.kapitel02;

public class SortierenDurchVertauschen {

	/**
	 * Methode um eine Liste "liste" aufsteigend zu sortieren.
	 * 
	 * @param liste	zu sortierende Liste
	 */
	public void sortierenDurchVertauschen(int[] liste) {
		for (int i1 = 1; i1 < liste.length; i1++) {
			int i2 = i1;
			
			while (i2 >= 1 && liste[i2] < liste[i2 - 1]) {	// liste[i2] > liste[i2 - 1], um absteigend zu sortieren
				int hand = liste[i2];
				liste[i2] = liste[i2 - 1];
				liste[i2 - 1] = hand;
				i2--;
			}
		}
	}
	
	public static void main(String[] args) {
		SortierenDurchVertauschen test = new SortierenDurchVertauschen();

		int[] liste = { 9, 7, 4, 1, 8, 2, 3 };
		test.sortierenDurchVertauschen(liste);
		System.out.print("Liste sortiert: ");
		for (int i : liste) {
			System.out.print(i + ", ");
		}
	}
}
