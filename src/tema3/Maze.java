//package tema3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/**
 * Clasa in care este definit labirintul si in care se face popularea sa.
 * @author Mocanu Alexandru
 *
 */
public class Maze {

	public Cell[][] labyrinth;
	Position entrance;
	int n = 0;
	int m = 0;

	public Maze(String input) {
		super();

		BufferedReader buffer;
		String line = null;
		int i = 0;
		try {
			buffer = new BufferedReader(new FileReader(new File(input)));

			line = buffer.readLine();
			String[] sizes = line.split(" ");

			n = Integer.parseInt(sizes[0]);
			m = Integer.parseInt(sizes[1]);
			labyrinth = new Cell[n][m];

			line = buffer.readLine();
			while (line != null) {
				for (int j = 0; j < line.length(); j++) {
					if (line.charAt(j) != '#') {
						if (line.charAt(j) == 'I') {
							entrance = new Position(i, j);
						}
						labyrinth[i][j] = new FreeCell(line.charAt(j));
					} else {
						labyrinth[i][j] = new WallCell();
					}
				}
				i++;
				line = buffer.readLine();
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
