//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumFirstRunner
{
	public static void main( String args[] )
	{
		ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(250,19,17,15,13,11,10,9,6,3,2,1,0));
		ListSumFirst test = new ListSumFirst(numbers);
		System.out.println(test);

	}
}