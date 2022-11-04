//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;

public class WordSortTwo
{
	private String[] wordRay;

	public WordSortTwo(String sentence)
	{
		wordRay = sentence.split(" ");
		sort();
	}

	public void sort()
	{
		for(int i=0; i<wordRay.length-1; i++){
			int min = i;
			for(int j = i+1; j<wordRay.length; j++)
			{
				if( wordRay[j].compareTo(wordRay[min]) < 0 )
					min = j;    		//find location of smallest
			}
			if(min != i) {
				String temp = wordRay[min];
				wordRay[min] = wordRay[i];
				wordRay[i] = temp;   	//put smallest in spot i
			}
		}
	}

	public String toString()
	{
		String output="";
		for(int i = 0; i<wordRay.length; i++) {
			output += wordRay[i] + "\n";
		}
		return output+"\n\n";
	}
}