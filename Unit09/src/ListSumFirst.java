//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

import java.util.List;
import java.util.ArrayList;

public class ListSumFirst
{
	private static List<Integer> Array;
	public ListSumFirst() {
		Array.add(0);
	}
	public ListSumFirst(List<Integer> ray){
		setArray(ray);
	}
	public void setArray(List<Integer> ray){
		Array = ray;
	}
	public static int go(List<Integer> ray)
	{
		int sum = 0;
		int firstNum = Array.get(0);
		for(int x = 1; x < Array.size(); x++){
			if(Array.get(x) > firstNum){
				sum += Array.get(x);
			}
		}
		if (sum == 0){
			return -1;
	}
		else{
			return sum;
		}
	}
	public String toString(){
		return go(Array) + "";
	}
}