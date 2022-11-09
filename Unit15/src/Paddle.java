//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends Block
{
   //instance variables
   private int speed;

   public Paddle()
   {
		super(10,10);
        speed =5;
   }


   //add the other Paddle constructors
   public Paddle(int x, int y) {
      setPos(x, y);
      setWidth(10);
      setHeight(10);
      speed = 5;
   }

   public Paddle(int x, int y, int s) {
      super(x, y);
      speed = s;
   }

   public Paddle(int x, int y, int width, int height, int s) {
      super(x, y, width, height);
      speed =s;
   }

   public Paddle(int x, int y, int width, int height, Color color, int s) {
      super(x, y, width, height, color);
      speed = s;
   }


   public void moveUpAndDraw(Graphics window)
   {
      draw(window, Color.WHITE);
      setY(getY()+speed);

      draw(window, getColor());
   }

   public void moveDownAndDraw(Graphics window)
   {
      draw(window, Color.WHITE);
      setY(getY()-speed);

      draw(window, getColor());
   }

   //add get methods
   public int getSpeed() {
      return speed;
   }

   //add a toString() method
   public String toString() {
      return getX() + ", " + getY() + ", " + getWidth() + ", " + getHeight() + ", " + getColor() + ", " + getSpeed();
   }
}