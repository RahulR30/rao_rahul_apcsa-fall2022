//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;

public class LetterRemover
{
   private String sentence;
   private char lookFor;

	public LetterRemover(String s, char rem)
	{
		//call set
		setRemover(s, rem);
	}

	//add in second constructor
	public LetterRemover(){

	}
	
	
	public void setRemover(String s, char rem)
	{
		sentence = s;
		lookFor = rem;
	}

	public String removeLetters()
	{
		String cleaned = "";
		int i = 0;
		do{
			if(sentence.charAt(i) != lookFor){
				cleaned = cleaned.substring(0) + sentence.charAt(i);
			}
			i++;
		} while(i < sentence.length());

		return cleaned;
	}

	public String toString()
	{
		return sentence + " - letter to remove " + lookFor + "\n" + removeLetters();
	}
}