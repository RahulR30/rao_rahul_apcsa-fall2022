//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.*;
import java.io.*; 

public class MatrixCount1
{
    private static int[][] m = {{ 1, 2, 3, 4, 5},
    										{ 6, 7, 8, 9, 0},
    										{ 6, 7, 1, 2, 5},
    										{ 6, 7, 8, 9, 0},
    										{ 5, 4, 3, 2, 1}};

    public static int count( int val  )
    {
		int count=0;
		int occurs=0;
		for (int[] ints : m) {
			for (int col = 0; col < m.length; col++) {
				System.out.print(" " + ints[col] + " ");
				if (ints[col] == val)
					count++;
			}
			System.out.println();
		}
		return count;
    }
}
