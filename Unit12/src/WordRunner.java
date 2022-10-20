//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.io.File; 
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Arrays;
import static java.lang.System.*;

public class WordRunner
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner(new File("/Users/rahulrao/Downloads/Projects/rao_rahul_apcsa-fall2022/Unit12/src/words.dat"));

		int size = file.nextInt();
		file.nextLine();
		ArrayList<Word> Array =new ArrayList<Word>();
		for(int i = 0; i < size; i++){
			Array.add(new Word(file.nextLine()));
		}
		Collections.sort(Array);

		for(int i = 0; i < size; i++){
			System.out.println(Array.get(i));
		}

	}
}