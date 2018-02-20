//package tema3;
/**
 * Clasa ce descrie continutul unei celule si pozitionarea sa pe harta.
 * @author Mocanu Alexandru
 *
 */
public class Content {

	FreeCell cell;
	Position position;

	public Content(Cell cell, int i, int j) {
		super();
		this.cell = (FreeCell) cell;
		this.position = new Position(i, j);
	}

}
