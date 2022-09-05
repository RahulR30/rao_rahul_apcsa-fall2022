//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

public class RayOddToEven
{
	int[] array;
	public RayOddToEven(){

	}
	public RayOddToEven(int[] arr){
		setArr(arr);
	}
	public int go() {
		int difference = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] % 2 == 1){
				for(int j = i; j < array.length; j++){
					if(array[j] % 2 == 1){
						difference += 1;
					}
					else{
						return difference;
					}
				}
			}
		}
		if(difference > array.length || difference == 0){
			return -1;
		}
		return difference;
	}
	public void setArr(int[] arr){
		array = arr;
	}
	public String toString(){
		return go() + "";
	}
}