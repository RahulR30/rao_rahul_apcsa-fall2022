//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

public class Ship extends MovingThing
{
	private int speed;
	private Image image;

	public Ship() {
		this(10,10,10,10,10);
	}

	public Ship(int x, int y) {
		this(x, y, 50, 50, 10);
		try
		{
			//URL url = getClass().getResource("src/ship.jpg");
			image = ImageIO.read(new File("/Users/rahulrao/Downloads/Programming/Projects/rao_rahul_apcsa-fall2022/Unit17/src/ship.jpg"));
		}
		catch(Exception e)
		{
			System.out.print("No ship image found");
		}
	}

	public Ship(int x, int y, int s) {
		this(x, y, 50, 50, s);
		speed=s;
		try
		{
			//URL url = getClass().getResource("src/ship.jpg");
			image = ImageIO.read(new File("/Users/rahulrao/Downloads/Programming/Projects/rao_rahul_apcsa-fall2022/Unit17/src/ship.jpg"));
		}
		catch(Exception e)
		{
			System.out.print("No ship image found");
		}
	}

	public Ship(int x, int y, int w, int h, int s) {
		super(x, y, w, h);
		speed=s;
		try {
			image = ImageIO.read(new File("/Users/rahulrao/Downloads/Programming/Projects/rao_rahul_apcsa-fall2022/Unit17/src/ship.jpg"));
		}
		catch(Exception ignored) {

		}
	}

	public void setSpeed(int s) {
		speed = s;
	}

	public int getSpeed() {
		return speed;
	}

	public void move(String direction) {
		switch (direction) {
			case "UP" -> setY(getY() - getSpeed());
			case "DOWN" -> setY(getY() + getSpeed());
			case "RIGHT" -> setX(getX() + getSpeed());
			case "LEFT" -> setX(getX() - getSpeed());
		}

	}

	public void draw( Graphics window ) {
		window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
	}

	public String toString() {
		return super.toString() +" "+ getSpeed();
	}
}
