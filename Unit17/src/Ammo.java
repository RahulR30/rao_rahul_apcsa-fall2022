//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class Ammo extends MovingThing
{
	private int speed;

	public Ammo()
	{
		this(0,0,5,5,10);
	}

	public Ammo(int x, int y)
	{
		this(x, y, 5, 5, 10);
	}

	public Ammo(int x, int y, int w, int h, int s)
	{
		setX(x);
		setY(y);
		setSpeed(s);
		setWidth(w);
		setHeight(h);
	}

	public void setSpeed(int s)
	{
		speed=s;
	}

	public int getSpeed()
	{
		return speed;
	}

	public void draw( Graphics window )
	{
		window.setColor(Color.GREEN);
		window.fillRect(getX(), getY(), 10, 10);
		//add code to draw the ammo
	}
	
	
	public void move( String direction )
	{
		switch (direction) {
			case "UP" -> setY(getY() - getSpeed());
			case "DOWN" -> setY(getY() + getSpeed());
			case "LEFT" -> setX(getX() - getSpeed());
			case "RIGHT" -> setX(getX() + getSpeed());
		}

		//add code to draw the ammo
	}

	public String toString()
	{
		return ""+super.toString()+getSpeed();
	}
}
