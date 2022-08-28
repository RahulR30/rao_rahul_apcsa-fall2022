//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;

public class Perfect
{
   private int number;
	//add constructors
	public Perfect() {
		number = 0;
	}
	public Perfect(int num) {
		setNumber(num);
	}
	//add a set method
	public void setNumber(int num){
		number = num;
	}
	public boolean isPerfect()
	{
		int sum = 0;
		int i = 0;
		do {
			i++;
			if (number % i == 0){
				sum += i;
			}


		} while( i < number-1);
		return number == sum;
	}

	public String toString()
	{
		if(isPerfect()){
			return number + " is perfect.";
		}
		else{
			return number + " is not perfect";
		}
	}
	//add a toString	
	
}