//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

public class RayDown
{
	//go() will return true if all numbers in numArray
	//are in decreasing order [31,12,6,2,1]
	int[] array;
	public RayDown(){

	}
	public RayDown(int[] arr){
		setArr(arr);
	}
	public void setArr(int[] arr){
		array = arr;
	}
	public boolean go()
	{
		int lastnum = array[0];
		for (int j : array) {
			if (!(j <= lastnum)){
				return false;
			}
		}
		return true;
	}
	public String toString(){
		return go() + "";
	}
}