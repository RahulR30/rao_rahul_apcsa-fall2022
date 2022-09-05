//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

public class RaySumLast
{
	int[] array;
	public RaySumLast(){
		int[] array = {0};
	}
	public RaySumLast(int[] ray){
		setRay(ray);
	}
	public int sum()
	{
		if (array.length != 1){
			int sum = 0;
			int lastval = array[array.length-1];
			for(int i = 0; i < array.length - 1; i++){
				if(array[i] > lastval){
					sum += array[i];
				}
			}
			if (sum == 0){
				return -1;
			}
			return sum;
	}
		else{
			return -1;
		}
	}
	public void setRay(int[] ray){
		array = ray;
	}
	public String toString(){

		return sum() + "";
	}
}
