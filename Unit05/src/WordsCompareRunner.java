//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class WordsCompareRunner
{
   public static void main( String args[] )
   {
		//add test cases
        String s1 = "goofy";
        String s2 = "godfather";

        WordsCompare test = new WordsCompare(s1, s2);
        test.setWords(s1, s2);
        test.compare();
        System.out.println(test.toString());
	}
}