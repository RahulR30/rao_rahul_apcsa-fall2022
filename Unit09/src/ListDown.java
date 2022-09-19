//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

import java.util.List;
import java.util.ArrayList;

public class ListDown
{
	private static List<Integer> Array;
	//go() will return true if all numbers in numArray
	//are in decreasing order [31,12,6,2,1]
	public ListDown(){

	}
	public ListDown(List<Integer> numArray){
		setArray(numArray);
	}
	public void setArray(List<Integer> numArray){
		Array = numArray;
	}
	public static boolean go(List<Integer> numArray)
	{
		Array = numArray;
		for(int i = 0; i < numArray.size(); i++){
			if (i != 0){
				if(numArray.get(i) > numArray.get(i - 1)){
					return false;
				}
			}
		}
		return true;
	}
	public String toString(){
		return go(Array) + "";
	}
}