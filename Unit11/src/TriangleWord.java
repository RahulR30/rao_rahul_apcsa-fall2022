//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Scanner;
import static java.lang.System.*;

public class TriangleWord
{
	//instance variables and constructors could be present, but are not necessary
		
	public static void printTriangle(String word)
	{
		for(int i = 1; i < word.length()+1; i++){
			for(int x = 1; x < i+1; x++){
				System.out.print(word.substring(0, i));
			}
			System.out.print("\n");
		}
	}
}