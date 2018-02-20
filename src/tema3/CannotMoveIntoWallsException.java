//package tema3;
/**
 * Exceptie ce asigura mentinerea eroului pe o cale accesibila si neincalcarea regulilor.
 * @author Mocanu Alexandru
 *
 */
public class CannotMoveIntoWallsException extends Exception {

	private static final long serialVersionUID = 1L;

	public CannotMoveIntoWallsException() {

	}

	public CannotMoveIntoWallsException(String message) {
		super(message);
	}
}
