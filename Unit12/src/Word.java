//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;

public class Word implements Comparable<Word>
{
	private String word;

	public Word( String s )
	{
		word = s;
	}

	public int compareTo( Word rhs )
	{
		if(word.length()>rhs.toString().length())
			return 1;
		else if(word.length()<rhs.toString().length())
			return -1;
		else{
			if(word.compareTo(rhs.toString())>0)
				return 1;
			else if(word.compareTo(rhs.toString())<0)
				return -1;
			return 0;

		}
	}

	public String toString()
	{
		return word;
	}
}