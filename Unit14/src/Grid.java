//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Objects;

import static java.lang.Integer.MIN_VALUE;

public class Grid
{
   private String[][] grid;

   //load vals into the rows x cols grid randomly
	public Grid(int rows, int cols, String[] vals)
	{
		grid = new String[rows][cols];
		for(int i = 0; i<grid.length; i++) {
			for(int j = 0; j<grid[i].length; j++) {
				grid[i][j] = vals[(int)(Math.random()*vals.length)];
			}
		}
	}

	//find out which of the vals occurs the most
	public String findMax(String[] vals)
	{
		int count = 0;
		int count1 = 0;
		for(int i = 0; i<vals.length-1; i++) {
			for (String[] strings : grid) {
				for (int k = 0; k < strings.length; k++) {
					if (Objects.equals(strings[k], vals[i])) {
						count++;
					}
					if (Objects.equals(strings[k], vals[i + 1])) {
						count1++;
					}
				}
			}
			if(count > count1) {
				String temp = vals[i];
				vals[i] = vals[i+1];
				vals[i+1] = temp;
			}
		}
		return vals[vals.length-1];

	}

	//returns a count of how many times val occurs in the matrix
	private int countVals( String val )
	{
		int count = 0;
		for (String[] strings : grid) {
			for (String string : strings) {
				if (Objects.equals(string, val)) count++;
			}
		}
		return count;
	}

	//display the grid
	public String toString() {
		String output = "";
		for (String[] strings : grid) {
			for (int j = 0; j < strings.length; j++) {
				output += " " + strings[j];
				if (j == strings.length - 1) output += "\n";
			}
		}
		return output;
	}

}