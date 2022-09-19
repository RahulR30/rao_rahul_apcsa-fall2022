//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

import java.util.ArrayList;
import java.util.List;

public class ListOddToEven
{
	private static List<Integer> Array;
	private static int firstOdd = 0;
	private static int lastEven = 0;
	private static int oddCounter = 0;
	public ListOddToEven(){
		Array.add(0);
	}
	public ListOddToEven(List<Integer> ray){
		setArray(ray);
	}
	public void setArray(List<Integer> ray){
		Array = ray;
	}
	public static int go(List<Integer> ray)
	{
		for(int i = 0; i < Array.size(); i++){
			if(Array.get(i) % 2 == 1){
				firstOdd = i;
				oddCounter ++;
				break;
			}
		}
		for(int i = Array.size()-1; i > 0; i--){
			if(Array.get(i) % 2 == 0){
				lastEven = i;
				break;
			}
		}
		return lastEven - firstOdd;
	}
	public String toString(){
		if(oddCounter != 0 || go(Array) > 0 ){
			return go(Array)+ "";
		}
		else{
			return -1 + "";
		}

	}
}