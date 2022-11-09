//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block
{
	private int xSpeed;
	private int ySpeed;

	public Ball()
	{
		super(200,200);
		xSpeed = 3;
		ySpeed = 1;
	}

	//add the other Ball constructors
	public Ball(int x, int y)
	{
		setX(x);
		setYSpeed(y);
		xSpeed = 3;
		ySpeed = 1;
	}

	public Ball(int x, int y, int width, int height)
	{
		this(x,y);
		setWidth(width);
		setHeight(height);
	}
	public Ball(int x, int y, int width, int height, Color color) {
		this(x, y);
		setWidth(width);
		setHeight(height);
		setColor(color);
	}
	public Ball(int x, int y, int width, int height, int xSpeed, int ySpeed)
	{
		this(x, y);
		setWidth(width);
		setHeight(height);
		setXSpeed(xSpeed);
		setYSpeed(ySpeed);
	}
	public Ball(int x, int y, int width, int height, Color color, int xSpeed, int ySpeed)
	{
		this(x, y);
		setWidth(width);
		setHeight(height);
		setColor(color);
		setXSpeed(xSpeed);
		setYSpeed(ySpeed);
	}
	//add the set methods
	public void setXSpeed(int xS) {
		xSpeed = xS;
	}

	public void setYSpeed(int yS) {
		ySpeed = yS;
	}


	public void moveAndDraw(Graphics window)
	{
		//draw a white ball at old ball location
		draw(window, Color.WHITE);
		setX(getX()+xSpeed);
		//setY
		setY(getY()+ySpeed);
		//draw the ball at its new location
		draw(window, getColor());
	}

	public boolean equals(Object obj)
	{
		if(obj == this) {
			return true;
		}
		return false;
	}

	//add the get methods
	public int getXSpeed() {
		return xSpeed;
	}

	public int getYSpeed() {
		return ySpeed;
	}
	public boolean didCollideLeft(Object obj) {
		return getX() <= ((Block) obj).getX() + ((Block) obj).getWidth()  + Math.abs(xSpeed) && getY() <=
				((Block) obj).getY() + ((Block) obj).getHeight() && getY() + getHeight() >= ((Block) obj).getY();
	}

	public boolean didCollideRight(Object obj) {
		return getX() + getWidth() >= ((Block) obj).getX() && getY() <=
				((Block) obj).getY() + ((Block) obj).getHeight() && getY() + getHeight() >= ((Block) obj).getY();
	}

	public boolean didCollideTop(Object obj) {
		return getX() > ((Block) obj).getX() && getX() < ((Block) obj).getX() + ((Block) obj).getWidth() && getY() <=
				((Block) obj).getY() + ((Block) obj).getHeight() && getY() > ((Block) obj).getY();
	}

	public boolean didCollideBottom(Object obj) {
		return getX() > ((Block) obj).getX() && getX() < ((Block) obj).getX() + ((Block) obj).getWidth() && getY() <
				((Block) obj).getY() + ((Block) obj).getHeight() && getY() + getHeight() >= ((Block) obj).getY();
	}

	public void onCollide() {

	}

	//add a toString() method
	public String toString() {
		return getX() + ", " + getY() + ", " + getWidth() + ", " + getHeight() + ", " + getColor() + ", " + xSpeed + ", " + ySpeed;
	}

   //add the get methods

   //add a toString() method
}