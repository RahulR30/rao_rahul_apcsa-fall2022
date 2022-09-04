//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;

public class TriangleFive
{
   private char letter;
   private int amount;

	public TriangleFive()
	{
	}

	public TriangleFive(char c, int amt)
	{
		setLetter(c);
		setAmount(amt);
	}

	public void setLetter(char c) {
		letter = c;
	}
	public void setAmount(int amt)
	{
		amount = amt;
	}
	public String toString()
	{
		String output="";
		char original = letter;
		for(int x = 0; x < amount; x++){
			for(int i = 0; i < amount-x; i++ ){
				for(int g = amount-i; g > 0; g--){
					output = output + letter;
				}
				output = output + " ";
				if (letter == 90){
					letter = 'A';
				}
				else{
					letter = (char) (letter +1);
				}
			}
			letter = original ;
			output = output + "\n";
		}
		return output ;
	}
}