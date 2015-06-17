package suchenUndSortieren.kapitel01;

/**
 * 
 * Die Bin�re Suche kann eine bereits nach Werte sortierte Liste auf einen
 * bestimmten Wert durchsuchen.
 * 
 */
public class Bin�reSuche {

	/**
	 * Die Methode "Bin�reSucheRekursiv" gibt die Position von "schluessel" in
	 * Liste "liste", zwischen "links" und "rechts" aus.
	 * 
	 * @param liste 		der Array der durchsuchtwerden soll
	 * @param schluessel	wo nach im Array gesucht werden soll
	 * @param anfang		ab wo im Array angefangen werden soll zu suchen
	 * @param ende			ab wo im Array aufgehoert werden soll zu suchen
	 */
	public int bin�reSuche(int[] liste, int schluessel, int links, int rechts) {
		int mitte = 0;
		while (links <= rechts) {
			mitte = (links + rechts) / 2;
			if (liste[mitte] == schluessel) {
				return mitte;
			} else if (liste[mitte] > schluessel) {
				rechts = mitte - 1;
			} else if (liste[mitte] < schluessel) {
				links = mitte + 1;
			}
		}
		
		return -1; // wenn der Schl�ssel in der Liste nicht vorkommt

	}

	public static void main(String[] args) {
		Bin�reSuche test = new Bin�reSuche();

		int[] regal = { 1, 3, 6, 7, 9, 10, 55, 64, 86, 97, 159 };
		System.out.println(test.bin�reSuche(regal, 9, 0, regal.length + 1));
	}

}
