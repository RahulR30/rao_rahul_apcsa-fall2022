//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class OuterSpace extends Canvas implements KeyListener, Runnable
{
	private final Ship ship;
	private final AlienHorde horde;
	private final Bullets shots;
	private boolean gameOver;


	private final boolean[] keys;
	private BufferedImage back;


	public OuterSpace()
	{
		setBackground(Color.black);

		keys = new boolean[5];
		ship = new Ship(375, 520, 50, 50, 10);
		horde = new AlienHorde(25);
		shots = new Bullets();
		new Thread(this).start();
		this.addKeyListener(this);


		setVisible(true);
	}

   public void update(Graphics window)
   {
	   paint(window);
   }

	public void paint( Graphics window )
	{
		//set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D)window;

		//take a snap shop of the current screen and same it as an image
		//that is the exact same width and height as the current screen
		if(back==null)
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));

		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();

		graphToBack.setColor(Color.BLUE);
		graphToBack.drawString("StarFighter ", 25, 50 );
		graphToBack.setColor(Color.BLACK);
		graphToBack.fillRect(0,0,800,600);
		ship.draw(graphToBack);
		horde.drawEmAll(graphToBack);
		shots.drawEmAll(graphToBack);
		shots.moveEmAll();
		horde.moveEmAll();
		horde.removeDeadOnes(shots.getList());
		shots.cleanEmUp();
		// processInputs
		if (gameOver)
		{
			graphToBack.setColor(Color.WHITE);
			if (horde.getList().size()==0)
			{
				graphToBack.drawString("Congratulations! You WON!", 375, 200);
			}
			else graphToBack.drawString("Unfortunate, You LOST! Try AGAIN!", 375, 200);
		}
		if(keys[0] && ship.getX()>ship.getSpeed())
		{
			ship.move("LEFT");
		}
		if (keys[1] && ship.getX()<(800-ship.getSpeed()-ship.getWidth()))
		{
			ship.move("RIGHT");
		}
		if (keys[2] && ship.getY()>ship.getSpeed())
		{
			ship.move("UP");
		}
		if (keys[3] && ship.getY()<(600-ship.getSpeed()-ship.getHeight()-20))
		{
			ship.move("DOWN");
		}
		if (keys[4] && !gameOver)
		{
			shots.add(new Ammo((ship.getX()+ship.getWidth()/2), ship.getY()-5, 5, 5, 5));
			keys[4] = false;
		}
		// update
		for (Alien alien : horde.getList())
		{ //Collide right or collide left NEED TO ADD collide top/bottom
			if ((ship.getX() <= (alien.getX() + alien.getWidth() + Math.abs(ship.getSpeed()))
					&& ship.getX() > (alien.getX() - ship.getWidth() - Math.abs(ship.getSpeed()))
					&& ship.getX()>=(alien.getX())
					&& ship.getY()<(alien.getY()+alien.getHeight())
					&& (ship.getY()+ship.getHeight())>alien.getY())
					|| (ship.getX() < (alien.getX() + alien.getWidth() + Math.abs(ship.getSpeed()))
					&& ship.getX() >= (alien.getX() - ship.getWidth() - Math.abs(ship.getSpeed()))
					&& ship.getX()<=alien.getX()+alien.getWidth()
					&& ship.getY()<(alien.getY()+alien.getHeight())
					&& (ship.getY()+ship.getHeight())>alien.getY())
					|| alien.getY()+alien.getHeight()>=600)
			{
				horde.stopHorde();
				ship.setSpeed(0);
				shots.clear();
				gameOver=true;
			}
		}


		if (horde.getList().size()==0)
		{
			gameOver=true;
			ship.setSpeed(0);
		}

		// render

		// draw back image
		twoDGraph.drawImage(back, null, 0, 0);
	}


	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = true;
		}
		repaint();
	}

	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = false;
		}
		repaint();
	}

	public void keyTyped(KeyEvent e)
	{
      //no code needed here
	}

   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.sleep(5);
            repaint();
         }
      }
	   catch(Exception ignored)
      {
      }
  	}
}

