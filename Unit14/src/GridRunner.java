//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class GridRunner
{
	public static void main( String args[] ) throws IOException
	{
		String [] vals = {"1","4","x","g","0"};
		Grid bees = new Grid(20,20,vals);
		System.out.println(bees);
		System.out.println(bees.findMax(vals));
	}
}