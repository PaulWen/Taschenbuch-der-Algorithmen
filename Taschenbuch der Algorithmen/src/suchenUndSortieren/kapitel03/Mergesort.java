package suchenUndSortieren.kapitel03;

/** 
 * "Mergesort" ist wehsendlich schneller als
 * "SortierenDurchEinfügen/-Vertauschen".
 * 
 * In Java ist die Methode schon Implementiert. Man findet sie unter den Namen
 * "Collections.sort"
 */
public class Mergesort {

	/**
	 * Die Methode "mischen" mischt zwei nach der größe sortierte Stapel von "al/bl" bis "ar/br" in einen nach der größe Sortiertem Stapel.
	 * 
	 * @param a		Erster gemischter Stapel
	 * @param al
	 * @param ar
	 * @param b		Zweiter gemischter Stapel
	 * @param bl
	 * @param br
	 */
	public int[] mischen (int[] a, int al, int ar,
						  int[] b, int bl, int br) {
		int[] ausgabe = new int[ar - al + br - bl + 2];
		int iA = al, iB = bl;
		
		for (int k = 0; k <= ar - al + br - bl + 1; k++) {
			if (iA > ar) { // a abgearbeitet
				ausgabe[k] = b[iB++];
				continue;
			}  
			if (iB > br) { // b abgearbeitet
				ausgabe[k] = a[iA++];
				continue;
			}
			ausgabe[k] = (a[iA] < b[iB]) ? a[iA++] : b[iB++];	//	"ausgabe[k] = (a[iA] < b[iB]) ? a[iA++] : b[iB++];" um absteigend zu sortieren
		}
		return ausgabe;
	}
	
	/**
	 * Sortiert den Array "liste" von "listeL" bis "listeR"
	 * @param liste
	 * @param listeL
	 * @param listeR
	 */
	public void mergeSort (int[] liste, int listeL, int listeR) {
		if (listeR > listeL && listeR != 1) {
			int m = (listeR + listeL) / 2;
			//Rekursives Sortieren der Haelften
			mergeSort(liste, listeL, m);
			mergeSort(liste, m + 1, listeR);
			//Mischen
			int[] gemischt = mischen(liste, listeL, m, liste, m + 1, listeR);
			//Zurückspeiern
			for (int i = 0; i < listeR - listeL + 1; i++) {
				liste[listeL + i] = gemischt[i];
			}
		}
	}
	
	public static void main(String[] args) {
		Mergesort test = new Mergesort();
		
		int[] liste = { 9, 7, 4, 1, 8, 2, 3, 100, 200, 0 };
		test.mergeSort(liste, 0, liste.length - 1);
		System.out.print("Liste sortiert: ");
		for (int i : liste) {
			System.out.print(i + ", ");
		}
	}

}
