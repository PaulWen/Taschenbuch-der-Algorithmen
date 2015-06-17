package rechnenVerschl�sselnCodieren.kapitel12;

/**
 * Mit diesem Algorithmus ist es m�glich den gr��enten gemeinsamen Teiler von zwei Zahlen ("a" und "b") zufinden.
 * (man kann nur nach einem ganzen gemeinsamen Teiler zweier Positiven Zahlen suchen)
 * 
 * Jedoch hat der "LangsamEuklid" einen Nachteil! Wenn man den Gemeinsamenteiler einer kleinen und einer gro�en Zahl finden
 * m�chte wird es sehr lange dauern, da anfangs die gro�e Zahl sehr oft minus die kleine Zahl gerechnet werden muss.
 *(Daher gibt es noch "Euklid".)
 */
public class LangsamEuklid {

	public int langsamEuklid(int a, int b) {
		while (a != b) {
			if (a > b) {
				a = a - b;
			}
			if (b > a) {
				b = b - a;
			}
		}
		return a;
	}
	
	public static void main(String[] args) {
		LangsamEuklid test = new LangsamEuklid();
		
		System.out.println(test.langsamEuklid(1, 5));

	}

}
