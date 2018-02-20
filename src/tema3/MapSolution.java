//package tema3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * Clasa ce contina metoda ce implementeaza rezolvarea labirintului avand harta la dispozitie.
 * @author Mocanu Alexandru
 *
 */
public class MapSolution {

	public static List<Position> searchExit(Maze maze) {

		Cell[][] aux = maze.labyrinth;
		Position c = maze.entrance;
		List<Position> trace = new ArrayList<Position>();
		List<Integer> adjiacent = new ArrayList<Integer>();
		int counter = 0;
		int index = 0;

		trace.add(maze.entrance);
		adjiacent.add(0);
		while (counter < maze.m * maze.n) {
			counter++;
			if (c.j + 1 < maze.m && (aux[c.i][c.j + 1] instanceof FreeCell)) {

				if (((FreeCell) aux[c.i][c.j + 1]).numberOfVisits == 0) {
					trace.add(new Position(c.i, c.j + 1));
					adjiacent.add(index);
					((FreeCell) aux[c.i][c.j + 1]).numberOfVisits++;
					if (aux[c.i][c.j + 1].data == 'O') {
						break;
					}
				}
			}
			if (c.i - 1 >= 0 && (aux[c.i - 1][c.j] instanceof FreeCell)) {
				if (((FreeCell) aux[c.i - 1][c.j]).numberOfVisits == 0) {
					trace.add(new Position(c.i - 1, c.j));
					adjiacent.add(index);
					((FreeCell) aux[c.i - 1][c.j]).numberOfVisits++;
					if (aux[c.i - 1][c.j].data == 'O') {
						break;
					}
				}
			}
			if (c.j - 1 >= 0 && (aux[c.i][c.j - 1] instanceof FreeCell)) {
				if (((FreeCell) aux[c.i][c.j - 1]).numberOfVisits == 0) {
					trace.add(new Position(c.i, c.j - 1));
					adjiacent.add(index);
					((FreeCell) aux[c.i][c.j - 1]).numberOfVisits++;
					if (aux[c.i][c.j - 1].data == 'O') {
						break;
					}
				}
			}
			if (c.i + 1 < maze.n && (aux[c.i + 1][c.j] instanceof FreeCell)) {
				if (((FreeCell) aux[c.i + 1][c.j]).numberOfVisits == 0) {
					trace.add(new Position(c.i + 1, c.j));
					adjiacent.add(index);
					((FreeCell) aux[c.i + 1][c.j]).numberOfVisits++;
					if (aux[c.i + 1][c.j].data == 'O') {
						break;
					}
				}
			}

			((FreeCell) aux[c.i][c.j]).numberOfVisits++;
			index++;
			c = trace.get(index);
		}

		List<Position> auxiliar = new ArrayList<Position>();
		auxiliar.add(trace.get(trace.size() - 1));
		index = trace.size() - 1;
		while (aux[c.i][c.j].data != 'I') {
			c = trace.get(adjiacent.get(index));
			auxiliar.add(c);
			index = trace.indexOf(c);

		}
		Collections.reverse(auxiliar);
		return auxiliar;
	}
}
