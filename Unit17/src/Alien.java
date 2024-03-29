//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

public class Alien extends MovingThing
{
	private int speed;
	private Image image;

	public Alien()
	{
		this(0,0,30,30,2);
	}

	public Alien(int x, int y)
	{
		this(x, y, 30, 30, 2);
	}

	public Alien(int x, int y, int s)
	{
		this(x, y, 30, 30, s);
	}

	public Alien(int x, int y, int w, int h, int s)
	{
		super(x, y, w,h);
		speed=s;
		try
		{
			image = ImageIO.read(new File("/Users/rahulrao/Downloads/Programming/Projects/rao_rahul_apcsa-fall2022/Unit17/src/alien.JPG"));
		}
		catch(Exception e)
		{
			//feel free to do something here
		}
	}

	public void setSpeed(int s)
	{
		speed = s;
	   //add code
	}

	public int getSpeed()
	{
	   return speed;
	}

   public void move(String direction)
	{
		switch (direction) {
			case "UP" -> setY(getY() - getSpeed());
			case "DOWN" -> setY(getY() + getSpeed());
			case "RIGHT" -> setX(getX() + getSpeed());
			case "LEFT" -> setX(getX() - getSpeed());
		}
	   //add code here
	}

	public void draw( Graphics window )
	{
   	window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
	}

	public String toString()
	{
		return super.toString() +" "+ getSpeed();
	}
}
