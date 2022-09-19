//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

import java.util.ArrayList;
import java.util.Arrays;

public class DownRunner
{
	public static void main( String args[] )
	{
		ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(10,9,8,7,6,5,4,3,2,1,-99));
		ListDown test = new ListDown(numbers);
		System.out.println(test);
	}
}