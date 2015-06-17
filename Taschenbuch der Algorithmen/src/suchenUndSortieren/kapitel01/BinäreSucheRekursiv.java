package suchenUndSortieren.kapitel01;


public class BinäreSucheRekursiv {

	/**
	 * Die Methode "BinäreSucheRekursiv" gibt die Position von "schluessel" in
	 * Liste "liste", zwischen "links" und "rechts" aus.
	 * 
	 * @param liste 		der Array der durchsuchtwerden soll
	 * @param schluessel	wo nach im Array gesucht werden soll
	 * @param anfang		ab wo im Array angefangen werden soll zu suchen
	 * @param ende			ab wo im Array aufgehoert werden soll zu suchen
	 */
	public int binäreSucheRekursive(int[] liste, int schluessel, int links,
			int rechts) {
		int mitte = 0;
		if (links <= rechts) {
			mitte = (links + rechts) / 2;
			if (liste[mitte] == schluessel) {
				return mitte;
			} else if (liste[mitte] > schluessel) {
				return binäreSucheRekursive(liste, 9, links, rechts - 1);
			} else if (liste[mitte] < schluessel) {
				return binäreSucheRekursive(liste, 9, links + 1, rechts);
			}
		}
		
		return -1; // wenn der Schlüssel in der Liste nicht vorkommt

	}

	public static void main(String[] args) {
		BinäreSucheRekursiv test = new BinäreSucheRekursiv();
		
		int[] regal = { 1, 3, 6, 7, 9, 10, 55, 64, 86, 97, 159 };
		System.out.println(test.binäreSucheRekursive(regal, 9, 0, regal.length + 1));
	}

}
