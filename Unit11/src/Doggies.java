//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Arrays;

public class Doggies
{
	private Dog[] pups;

	public Doggies(int size)
	{
		//point pups at a new array of Dog
		pups = new Dog[size];
		
	}
	
	public void set(int spot, int age, String name)
	{
		pups[spot] = new Dog(age, name);
		//put a new Dog in the array at spot 
		//make sure spot is in bounds		
	}

	public String getNameOfOldest()
	{
		Dog max = pups[0];
		for(int i = 0; i < pups.length - 1; i++){
			if(pups[i].getAge() < pups[i+1].getAge()){
				max = pups[i+1];
			}
		}
		return max.getName();
	}

	public String getNameOfYoungest()
	{
		Dog min = pups[0];
		for(int i = 0; i < pups.length - 1; i++){
			if(pups[i].getAge() > pups[i+1].getAge()){
				min = pups[i+1];
			}
		}
		return min.getName();
	}

	public String toString()
	{
		return ""+Arrays.toString(pups);
	}
}