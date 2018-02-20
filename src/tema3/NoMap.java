//package tema3;

import java.util.ArrayList;
import java.util.List;
/**
 * Clasa ce cuprinde rezolvarea primului task si anume parcurgerea labirintului fara harta.
 * @author Mocanu Alexandru
 *
 */
public class NoMap {

	public static List<Position> searchExit(Maze labyrinth)
			throws HeroOutOfGroundException, CannotMoveIntoWallsException {

		Cell[][] aux = labyrinth.labyrinth;
		List<Position> trace = new ArrayList<Position>();
		Position c = new Position(labyrinth.entrance.i, labyrinth.entrance.j);
		Position auxiliar = null;
		trace.add(new Position(c.i, c.j));
		aux[c.i][c.j].data = 'N';

		while (aux[c.i][c.j].data != 'O') {

			if (trace.size() >= 2) {
				if (trace.get(trace.size() - 2).i - c.i == 1) {
					aux[c.i][c.j].data = 'N';
				}
				if (trace.get(trace.size() - 2).j - c.j == -1) {
					aux[c.i][c.j].data = 'E';
				}
				if (trace.get(trace.size() - 2).i - c.i == -1) {
					aux[c.i][c.j].data = 'S';
				}
				if (trace.get(trace.size() - 2).j - c.j == 1) {
					aux[c.i][c.j].data = 'W';
				}
			}
			((FreeCell) aux[c.i][c.j]).numberOfVisits += 1;
			List<Content> list = new ArrayList<Content>();
			if (c.i + 1 < labyrinth.n && (aux[c.i + 1][c.j] instanceof FreeCell)) {
				list.add(new Content(aux[c.i + 1][c.j], c.i + 1, c.j));
			}
			if (c.i - 1 >= 0 && (aux[c.i - 1][c.j] instanceof FreeCell)) {
				list.add(new Content(aux[c.i - 1][c.j], c.i - 1, c.j));
			}
			if (c.j + 1 < labyrinth.m && (aux[c.i][c.j + 1] instanceof FreeCell)) {
				list.add(new Content(aux[c.i][c.j + 1], c.i, c.j + 1));
			}
			if (c.j - 1 >= 0 && (aux[c.i][c.j - 1] instanceof FreeCell)) {
				list.add(new Content(aux[c.i][c.j - 1], c.i, c.j - 1));
			}

			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).position.i > labyrinth.n - 1 || list.get(i).position.j > labyrinth.m - 1
						|| list.get(i).position.i < 0 || list.get(i).position.j < 0) {
					throw new HeroOutOfGroundException();
				}
				if (!(aux[list.get(i).position.i][list.get(i).position.j] instanceof FreeCell)) {
					throw new CannotMoveIntoWallsException();
				}
			}
			auxiliar = check(list, aux[c.i][c.j].data, c);

			if (trace.size() == 1) {
				trace.add(new Position(auxiliar.i, auxiliar.j));

			} else {

				trace.add(new Position(auxiliar.i, auxiliar.j));

			}

			c = auxiliar;
		}

		return trace;

	}

	private static Position check(List<Content> aux, char direction, Position current) {
		int numberMin = 0;
		CellComparator comparator = new CellComparator();
		List<Content> available = new ArrayList<Content>();

		Content minCell = aux.get(0);
		available.add(aux.get(0));
		if (minCell.cell.data == 'O') {
			return minCell.position;
		}
		for (int i = 1; i < aux.size(); i++) {
			if (comparator.compare(aux.get(i).cell) == 1) {
				return aux.get(i).position;
			} else {

				if (comparator.compare(minCell.cell, aux.get(i).cell) > 0) {
					minCell = aux.get(i);
					available.clear();
					available.add(aux.get(i));
				} else if (comparator.compare(minCell.cell, aux.get(i).cell) == 0) {
					numberMin++;
					available.add(aux.get(i));
				}
			}
		}

		switch (direction) {
		case 'N':
			if (numberMin == 0) {
				return minCell.position;
			} else {
				for (Content entry : available) {
					if (entry.position.i == current.i && entry.position.j == current.j + 1) {

						return entry.position;
					}
				}
				for (Content entry : available) {
					if (entry.position.i == current.i - 1 && entry.position.j == current.j) {

						return entry.position;
					}
				}
				for (Content entry : available) {
					if (entry.position.i == current.i && entry.position.j == current.j - 1) {

						return entry.position;
					}
				}
				for (Content entry : available) {
					if (entry.position.i == current.i + 1 && entry.position.j == current.j) {

						return entry.position;
					}
				}
			}
			break;
		case 'E':
			if (numberMin == 0) {
				return minCell.position;
			} else {
				for (Content entry : available) {
					if (entry.position.i == current.i + 1 && entry.position.j == current.j) {

						return entry.position;
					}
				}
				for (Content entry : available) {
					if (entry.position.i == current.i && entry.position.j == current.j + 1) {

						return entry.position;
					}
				}
				for (Content entry : available) {
					if (entry.position.i == current.i - 1 && entry.position.j == current.j) {

						return entry.position;
					}
				}
				for (Content entry : available) {
					if (entry.position.i == current.i && entry.position.j == current.j - 1) {

						return entry.position;
					}
				}
			}
			break;
		case 'S':
			if (numberMin == 0) {
				return minCell.position;
			} else {
				for (Content entry : available) {
					if (entry.position.i == current.i && entry.position.j == current.j - 1) {

						return entry.position;
					}
				}
				for (Content entry : available) {
					if (entry.position.i == current.i + 1 && entry.position.j == current.j) {

						return entry.position;
					}
				}
				for (Content entry : available) {
					if (entry.position.i == current.i && entry.position.j == current.j + 1) {

						return entry.position;
					}
				}
				for (Content entry : available) {
					if (entry.position.i == current.i - 1 && entry.position.j == current.j) {

						return entry.position;
					}
				}
			}
			break;
		case 'W':
			if (numberMin == 0) {
				return minCell.position;
			} else {
				for (Content entry : available) {
					if (entry.position.i == current.i - 1 && entry.position.j == current.j) {

						return entry.position;
					}
				}
				for (Content entry : available) {
					if (entry.position.i == current.i && entry.position.j == current.j - 1) {

						return entry.position;
					}
				}
				for (Content entry : available) {
					if (entry.position.i == current.i + 1 && entry.position.j == current.j) {

						return entry.position;
					}
				}
				for (Content entry : available) {
					if (entry.position.i == current.i && entry.position.j == current.j + 1) {

						return entry.position;
					}
				}
			}

			break;
		default:
			break;
		}
		return new Position(0, 0);
	}
}
