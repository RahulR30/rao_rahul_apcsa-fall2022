//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date - 
//Class -
//Lab  -

import static java.lang.System.*;
import java.util.Scanner;

public class StringRunner
{
	public static void main ( String[] args )
	{
		Scanner keyboard = new Scanner(in);
		System.out.print("Enter a word :: ");
		String s = keyboard.nextLine();

		StringOddOrEven test = new StringOddOrEven(s);
		test.setString(s);
		test.isEven();
		System.out.println(test.toString());

	}
}