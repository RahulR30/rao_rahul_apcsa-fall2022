//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.ArrayList;

public class ToyStoreRunner
{
	public static void main( String args[] )
	{
		ToyStore list = new ToyStore("sorry bat sorry sorry sorry train train teddy teddy ball ball");
		System.out.println(list);
		System.out.println("Most Frequent Toy: " + list.getMostFrequentToy());
		list.sortToysByCount();
	}
}