//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.*;

public class ToyStore {
	private ArrayList<Toy> toyList;

	public ToyStore(){
		toyList = new ArrayList<Toy>();
	}
	public ToyStore(String s) {
		loadToys(s);
	}

	public void loadToys(String toys) {
		toyList = new ArrayList<Toy>();
		ArrayList<String> ts = new ArrayList<>(Arrays.asList(toys.split(" ")));
		for (int i = 0; i < ts.size(); i++) {
			String name = ts.get(i);
			Toy t = getThatToy(name);
			if(t == null) {
				toyList.add(new Toy(1, name));
			}
			else{
				t.setCount(t.getCount() + 1);
			}
		}
	}

	public Toy getThatToy(String nm) {
		for (Toy x : toyList) {
			if (x.getName().equals(nm)) {
				return x;
			}
		}
		return null;
	}

	public String getMostFrequentToy() {
		String name = "";
		double max = Integer.MIN_VALUE;
		for (Toy x : toyList) {
			if (max < x.getCount()) {
				max = x.getCount();
				name = x.getName();
			}
		}
		return name;
	}
  
  	public void sortToysByCount()
	{
		Collections.sort(toyList);
		for (Toy obj : toyList) {
			System.out.println(obj.getName());
		}
	}
  	  
	public String toString()
	{
	   return toyList.toString();
	}
}