//� A+ Computer Science  -  www.apluscompsci.com
//Name - 
//Date -
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;


/*
 * Input a line of values from external file maze.dat.
 * Read the shape of the maze (i.e. the row and column dimensions).
 * Read the values (1==passable path, 0 = blocked path).
 * Create the maze as a 2-D array.
 * Recursive call the maze solver (checkForExitPath).
 * Start on the left side, if find a path to the right side then a path exists.
 * The path must be comprised of adjacent 1's (above, below, left, right) but not diagonal.
 */


public class MazeRunner
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner(new File("/Users/rahulrao/Downloads/rao_rahul_apcsa-fall2022/Projects/rao_rahul_apcsa-fall2022/Unit14/src/maze.dat"));
		while(file.hasNext())
		{
			int size = file.nextInt();
			file.nextLine();
			Maze test = new Maze(size, file.nextLine());
			test.checkForExitPath(0,0);
			out.println(test);
		}
	}
}