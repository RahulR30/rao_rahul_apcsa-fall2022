//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*; 

class Rational implements Comparable<Rational>
{
	//add two instance variables
	private int numerator, denominator;

	//write two constructors
	public Rational(int numer, int denom){
		numerator = numer;
		denominator = denom;

	}
	public Rational(){
		numerator = 1;
		denominator = 1;
	}

	//write a setRational method
	public void setRational(int numer, int denom){
		setNumerator(numer);
		setDenominator(denom);
	}

	//write  a set method for numerator and denominator
	public void setNumerator(int numer){
		numerator = numer;
	}
	public void setDenominator(int denom){
		denominator = denom;
	}
	public void add(Rational  other)
	{
		this.setNumerator((this.getNumerator() * other.denominator) + (other.numerator * this.getDenominator()));
		this.setDenominator(this.getDenominator() * other.denominator );

		//num1/den1 + num2/den2 
		//new numerator = (num1 * den2 + num2 * den1)
		//new denominator = (den1 * den2)
	}

	private void reduce()
	{
		setNumerator(this.numerator/gcd(this.numerator, this.denominator));
		setDenominator(this.denominator/gcd(this.numerator, this.denominator));

	}

	private int gcd(int num1, int num2)
	{
		if (num2 == 0)
			return num1;
		return gcd(num2 ,num1 % num2);
	}

	public Object clone ()
	{
		return new Rational(getNumerator(), getDenominator());
	}


	//ACCESSORS

	//write get methods for numerator and denominator


	public int getNumerator() {
		return numerator;
	}

	public int getDenominator() {
		return denominator;
	}

	public boolean equals(Object obj)
	{
		return this.compareTo((Rational) obj) == 0;
	}

	public int compareTo(Rational other) {
		Rational num1 = new Rational(numerator, denominator);
		Rational num2 = new Rational(other.getNumerator(), other.getDenominator());
		num1.reduce();
		num2.reduce();

		if (num1.getDenominator() < num2.getDenominator()) {
			return -1;
		} else if (num1.getDenominator() == num2.getDenominator()) {
			return Integer.compare(num1.getNumerator(), num2.getNumerator());
		} else {
			return 1;
		}
	}
	public String toString ()
	{
		return this.numerator/gcd(this.numerator, this.denominator) + "/" + this.denominator/gcd(this.numerator, this.denominator) + "\n";
	}


	
	//write  toString() method
	
	
}