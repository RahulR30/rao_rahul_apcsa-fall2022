//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

import java.util.ArrayList;
import java.util.Arrays;

public class OddToEvenRunner
{
	public static void main( String args[] )
	{
		ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(7,7,7,11,2,7,7,11,11,2));
		ListOddToEven test = new ListOddToEven(numbers);
		System.out.println(test);
	}
}