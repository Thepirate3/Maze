//package tema3;

import java.util.Comparator;
/**
 * Clasa ce implementeaza un comparator , obiectele de comparat fiind celulele dupa 
 * numarul de treceri prin celula respectiva.
 * @author Mocanu Alexandru
 *
 */
public class CellComparator implements Comparator<FreeCell> {

	public int compare(FreeCell o1) {
		if (o1.data == 'O') {
			return 1;
		}
		return 0;
	}

	@Override
	public int compare(FreeCell o1, FreeCell o2) {
		if (o1.numberOfVisits > o2.numberOfVisits) {
			return 1;
		}
		if (o1.numberOfVisits < o2.numberOfVisits) {
			return -1;
		}
		return 0;
	}

}
