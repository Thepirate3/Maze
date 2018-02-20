//package tema3;
/**
 * Exceptie ce ne asigura ca eroul nostru nu paraseste harta.
 * @author Mocanu Alexandru
 *
 */
public class HeroOutOfGroundException extends Exception {

	private static final long serialVersionUID = 1L;

	public HeroOutOfGroundException() {
	}

	public HeroOutOfGroundException(String message) {
		super(message);
	}

}
