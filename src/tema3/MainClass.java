//package tema3;

import java.io.File;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class MainClass {

	public static void main(String[] args) {

		Maze a = new Maze(args[1]);

		try {
			List<Position> trace = null;
			if (Integer.parseInt(args[0]) == 1) {
				trace = NoMap.searchExit(a);
			} else {
				trace = MapSolution.searchExit(a);
			}
			PrintWriter writer = new PrintWriter(new File(args[2]));
			writer.println(Integer.toString(trace.size()));
			for (Position p : trace) {
				writer.println(Integer.toString(p.i) + " " + Integer.toString(p.j));
			}
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeroOutOfGroundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CannotMoveIntoWallsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
