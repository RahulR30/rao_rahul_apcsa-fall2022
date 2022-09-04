//(c) A+ Computer Science
// www.apluscompsci.com
//Name -  

import java.util.Arrays;

import static java.lang.System.*;

public class Triples
{
   private int number;

	public Triples()
	{
		this(0);
	}

	public Triples(int num)
	{
		setNum(num);

	}

	public void setNum(int num)
	{
		number = num;
	}
	
	private int greatestCommonFactor(int a, int b, int c)
	{
		int max = Math.min(a,Math.min(b,c));
		for(int i = max; i >= 0; i--){
			if((a % i == 0) && (b % i == 0) && (c % i == 0)){
				max = i;
				break;
			}
		}
		return max ;
	}
	public String toString()
	{
		int[] CValues = new int[1];
		String output="";
		boolean isThere = false;
		for(int a = 1; a <= number; a++){
			for(int b = 1; b <= number; b++){
				for(int c = 1; c <= number; c++){
					if(Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2) && greatestCommonFactor(a, b, c) <= 1 ){
						for (int cValue : CValues) {
							if (cValue == c) {
								isThere = true;
								break;
							}
						}
						if(!isThere){
							System.out.println(a + " " + b + " " + c);
							CValues = Arrays.copyOf(CValues, CValues.length + 1);
							CValues[CValues.length - 1] = c;
						}
						isThere = false;
					}
				}
			}
		}
		return output+"\n";
	}
}