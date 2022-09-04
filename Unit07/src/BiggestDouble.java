//(c) A+ Computer Science
// www.apluscompsci.com
//Name -  

import java.util.Arrays;

import static java.lang.System.*;

public class BiggestDouble
{
	private double one,two,three,four;

	public BiggestDouble()
	{
		this(0,0,0,0);
	}

	public BiggestDouble(double a, double b, double c, double d)
	{
		setDoubles(a, b, c, d);
	}

	public void setDoubles(double a, double b, double c, double d)
	{
		one = a;
		two = b;
		three = c;
		four = d;
	}

	public double getBiggest()
	{
		double[] Array = new double[4];
		double largest = 0;
		Array[0] = one;
		Array[1] = two;
		Array[2] = three;
		Array[3] = four;
		for (double v : Array) {
			if (v > largest)
				largest = v;
		}
		return largest;
	}

	public String toString()
	{
	   return one + " " + two + " " + three + " " + four;
	}
}