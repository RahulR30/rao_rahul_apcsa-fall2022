//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;

public class Toy implements Comparable
{
	private String name;
	private int count;

	public Toy()
	{
		String name = "";
		int count = 0;
	}

	public Toy( String nm )
	{
		name = nm;
	}
	public Toy(int j, String k){
		count=j;
		name=k;
	}

	public int getCount()
	{
		return count;
	}
	
	public void setCount( int cnt )
	{
		count = cnt;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName( String nm )
	{
		name = nm;
	}

	public String toString()
	{
	   return name + " " + count;
	}

	@Override
	public int compareTo(Object o) {
		int comparecount=((Toy)o).getCount();
		return comparecount-this.count;
	}
}