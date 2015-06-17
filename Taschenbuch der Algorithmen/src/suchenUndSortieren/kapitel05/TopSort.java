package suchenUndSortieren.kapitel05;


/**
 * Die Klasse TopSort dient dazu eine Reihenfolge von aufgaben zu finden, wenn die Aufgaben von 
 * einander abhängik sind.
 * 
 *
 */
public class TopSort {
	
	public void topSort(GerichteterGraph graph) {
		while (graph.getV().isEmpty() == false) {
			boolean zyklus = true;
			for (Character v : graph.getV()) {
				if (graph.kanteXv(v) == false) {
					graph.getV().remove(v);
					graph.removeKantevX(v);
					zyklus = false;
					System.out.println(v);
					break;
				}
			}
			if (zyklus == true) {
				System.out.println("Zyklische Abhängigkeit kann nicht aufgelöst werden!");
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		//gerichteten Graph mit allen Knoten und Kanten erstellen START
		char[][] werte = new char[11][4];
		werte[0][0] = 'a'; werte[0][1] = 'd'; werte[0][2] = '0'; werte[0][3] = '0';
		werte[1][0] = 'b'; werte[1][1] = '0'; werte[1][2] = '0'; werte[1][3] = '0';
		werte[2][0] = 'c'; werte[2][1] = '0'; werte[2][2] = '0'; werte[2][3] = '0';
		werte[3][0] = 'd'; werte[3][1] = '0'; werte[3][2] = '0'; werte[3][3] = '0';
		werte[4][0] = 'e'; werte[4][1] = '0'; werte[4][2] = '0'; werte[4][3] = '0';
		werte[5][0] = 'f'; werte[5][1] = '0'; werte[5][2] = '0'; werte[5][3] = '0';
		werte[6][0] = 'g'; werte[6][1] = 'c'; werte[6][2] = '0'; werte[6][3] = '0';
		werte[7][0] = 'h'; werte[7][1] = 'e'; werte[7][2] = '0'; werte[7][3] = '0';
		werte[8][0] = 'i'; werte[8][1] = '0'; werte[8][2] = '0'; werte[8][3] = '0';
		werte[9][0] = 'j'; werte[9][1] = 'a'; werte[9][2] = 'f'; werte[9][3] = 'i';
		werte[10][0] = 'k'; werte[10][1] = 'b'; werte[10][2] = '0'; werte[10][3] = '0';
		
		GerichteterGraph g = new GerichteterGraph(werte);
		
		//Graph mit allen werten implementieren ENDE
		
		TopSort test = new TopSort();
		test.topSort(g);
		
	}
}
