//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import static java.lang.System.*;

public class WordSortTwoRunner
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner(new File("/Users/rahulrao/Downloads/rao_rahul_apcsa-fall2022/Projects/rao_rahul_apcsa-fall2022/Unit13/src/wordsorttwo.dat"));
		int size = file.nextInt();
		file.nextLine();
		for(int i = 0; i<size; i++)
		{
			String sentence = file.nextLine();
			WordSortTwo test = new WordSortTwo(sentence);
			System.out.println(test);
		}
	}
}