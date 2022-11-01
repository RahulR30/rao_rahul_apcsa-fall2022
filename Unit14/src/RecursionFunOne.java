//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;

public class RecursionFunOne
{
	static int count = 0;
	public static int countOddDigits(int num)
	{
		if (num == 0) {
			return (int) count;
		}
		if (num % 2 == 1) {
			count = count + 1;
			countOddDigits(num / 10);
		}
		else{
			countOddDigits(num / 10);
		}
		return count;
	}
}