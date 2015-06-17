package suchenUndSortieren.kapitel03;

/** 
 * "Quicksort" ist wehsendlich schneller als
 * "SortierenDurchEinfügen/-Vertauschen". Auch ist es in etwa 4 mal schneller
 * als "Mergesort".
 * 
 * In Java ist die Methode schon Implementiert. Man findet sie unter den Namen
 * "Array.sort"
 */
public class Quicksort {

	/**
	 * Die Methode tauscht im Array "liste" das Element "element1" mit Element "element2".
	 * @param liste
	 * @param element1	gibt die Stelle im Array an vom Element1. das getauscht werden soll
	 * @param element2	gibt die Stelle im Array an vom Element2. das getauscht werden soll
	 */
	public void tausche (int[] liste, int element1, int element2) {
		int hand = liste[element1];
		liste[element1] = liste[element2];
		liste[element2] = hand;	
	}
	
	/**
	 * Die Methode sortiert den Array "liste" von Segment "listeL" bis zu Segment "listeR"
	 * @param liste
	 * @param listeL
	 * @param listeR
	 */
	public void quickSort (int[] liste, int listeL, int listeR) {
		if (listeL < listeR) {
			int pivot = liste[listeL]; // 1. Element als Pivotelement
			int iL = listeL;		// darf nicht +1, da das erste Element das Pivotelement ist
			int iR = listeR + 1;
			
			//Sortieren
			do {
				while(liste[++iL] < pivot && iL < listeR) {}	// "while(liste[++iL] > pivot && iL < listeR) {}" um absteigend
				while(liste[--iR] > pivot && iR > listeL) {}	// "while(liste[--iR] < pivot && iR > listeL) {}" zusortieren
				
				if (iL < iR) {
					tausche(liste, iL, iR);
				} 
			} while(iL < iR);
			
			tausche(liste, iR, listeL);
			
			quickSort(liste, listeL, iR - 1);
			quickSort(liste, iR + 1, listeR);
		}
	}
	
	public static void main(String[] args) {
		Quicksort test = new Quicksort();
		
		int[] liste = { 300, 9, 200, 7, 4, 1, 8, 2, 3, 100, 200, 0, 1, -1 };
		test.quickSort(liste, 0, liste.length - 1);
		System.out.print("Liste sortiert: ");
		for (int i : liste) {
			System.out.print(i + ", ");
		}
	}

}
