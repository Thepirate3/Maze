//package tema3;
/**
 * Clasa ce descrie celula libera,si mai precis celula pe unde eroul poate trece.
 * @author Mocanu Alexandru
 *
 */
public class FreeCell extends Cell{

		int numberOfVisits=0;
		public FreeCell(char c) {
			super.data = c;
		}
}
