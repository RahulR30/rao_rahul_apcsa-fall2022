//(c) A+ Computer Science
//www.apluscompsci.com
//Name

import static java.lang.System.*;

public class WordRunner
{
	public static void main ( String[] args )
	{
		String word = "TCEA";
		Word test = new Word(word);
		System.out.println(test.getFirstChar());
		System.out.println(test.getLastChar());
		System.out.println(test.getBackWards());
		System.out.println(word);
		//add test cases		
	}
}