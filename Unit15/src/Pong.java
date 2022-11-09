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

public class Pong extends Canvas implements KeyListener, Runnable
{
	private Ball ball;
	private Paddle leftPaddle;
	private Paddle rightPaddle;
	private boolean[] keys;
	private BufferedImage back;
	private int leftScore;
	private int rightScore;
	private boolean allCollide = false;


	public Pong()
	{
		//set up all variables related to the game
		ball = new Ball(400, 300, 20, 20, Color.BLUE, 2, 2);
		leftPaddle = new Paddle(20, 200, 20, 80, Color.ORANGE, 5);
		rightPaddle = new Paddle(750, 200, 20, 80, Color.ORANGE, 5);


		keys = new boolean[4];

    
    	setBackground(Color.WHITE);
		setVisible(true);
		
		new Thread(this).start();
		addKeyListener(this);		//starts the key thread to log key strokes
	}
	
   public void update(Graphics window){
	   paint(window);
   }

   public void paint(Graphics window)
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


		ball.moveAndDraw(graphToBack);
		leftPaddle.draw(graphToBack);
		rightPaddle.draw(graphToBack);


		//see if ball hits left wall or right wall
	   boolean yCollide = false;
	   if(!(ball.getX()<=780))
	   {
		   ball.setXSpeed(0);
		   ball.setYSpeed(0);
		   if(!allCollide) {
			   leftScore++;
		   }
		   yCollide = true;

		   ball.draw(graphToBack, Color.WHITE);
		   ball.setX(((int)(Math.random()*50)+400));
		   ball.setY(((int)(Math.random()*50)+300));
		   int i = (int)(Math.random()*2);
		   if(i==0) {
			   ball.setXSpeed(2);
			   ball.setYSpeed(1);
		   }
		   else {
			   ball.setXSpeed(-2);
			   ball.setYSpeed(1);
		   }
	   }

	   if(!(ball.getX()>=10))
	   {
		   ball.setXSpeed(0);
		   ball.setYSpeed(0);
		   if(!allCollide) {
			   rightScore++;
		   }
		   yCollide = true;

		   ball.draw(graphToBack, Color.WHITE);
		   ball.setX(((int)(Math.random()*50)+400));
		   ball.setY(((int)(Math.random()*50)+300));
		   int i = (int)(Math.random()*2);
		   if(i==0) {
			   ball.setXSpeed(2);
			   ball.setYSpeed(1);
		   }
		   else {
			   ball.setXSpeed(-2);
			   ball.setYSpeed(1);
		   }
	   }


	   if(ball.getY() <= 0 || ball.getY()+ball.getHeight() >= 600) {
		   yCollide = true;
	   }


	   //see if the ball hits the top or bottom wall
	   if(ball.getY() <= 0 && ball.getYSpeed() < 0) {
		   ball.setYSpeed(-1*ball.getYSpeed());
	   }
	   else if(ball.getY()+ball.getHeight() >= 600 && ball.getYSpeed() > 0) {
		   ball.setYSpeed(-1*ball.getYSpeed());
	   }

	   //see if the ball hits the left paddle
	   if(ball.didCollideLeft(leftPaddle)) {
		   ball.setXSpeed(-1*ball.getXSpeed());
		   yCollide = true;
	   }

	   if(ball.didCollideTop(leftPaddle)) {
		   ball.setYSpeed(-1*ball.getYSpeed());
		   yCollide = true;
	   }

	   if(ball.didCollideBottom(leftPaddle)) {
		   ball.setYSpeed(-1*ball.getYSpeed());
		   yCollide = true;
	   }


	   //see if the ball hits the right paddle
	   if(ball.didCollideRight(rightPaddle)) {
		   ball.setXSpeed(-1*ball.getXSpeed());
		   yCollide = true;
	   }

	   if(ball.didCollideTop(rightPaddle)) {
		   ball.setYSpeed(-1*ball.getYSpeed());
		   yCollide = true;
	   }

	   if(ball.didCollideBottom(rightPaddle)) {
		   ball.setYSpeed(-1*ball.getYSpeed());
		   yCollide = true;
	   }

	   if(yCollide) {
		   allCollide = true;
	   }
	   else {
		   allCollide = false;
	   }

	   if(allCollide) {
		   ball.onCollide();
	   }

	   //see if the paddles need to be moved
	   if(keys[0])
	   {
		   //left paddle up
		   leftPaddle.moveUpAndDraw(graphToBack);
	   }
	   if(keys[1])
	   {
		   //left paddle down
		   leftPaddle.moveDownAndDraw(graphToBack);

	   }
	   if(keys[2])
	   {
		   rightPaddle.moveUpAndDraw(graphToBack);
	   }
	   if(keys[3])
	   {
		   rightPaddle.moveDownAndDraw(graphToBack);
	   }

	   twoDGraph.drawImage(back, null, 0, 0);
	   twoDGraph.setColor(Color.RED);
	   twoDGraph.drawString(String.format("Left Score: %d", leftScore), 400, 550);
	   twoDGraph.drawString(String.format("Right Score: %d", rightScore), 400, 560);
   }

	public void keyPressed(KeyEvent e)
	{
		switch (toUpperCase(e.getKeyChar())) {
			case 'W' -> keys[0] = true;
			case 'Z' -> keys[1] = true;
			case 'I' -> keys[2] = true;
			case 'M' -> keys[3] = true;
		}
	}

	public void keyReleased(KeyEvent e)
	{
		switch (toUpperCase(e.getKeyChar())) {
			case 'W' -> keys[0] = false;
			case 'Z' -> keys[1] = false;
			case 'I' -> keys[2] = false;
			case 'M' -> keys[3] = false;
		}
	}

	public void keyTyped(KeyEvent e){}

	public void run()
	{
		try
		{
			while(true)
			{
				Thread.sleep(8);
				repaint();
			}
		}catch(Exception ignored)
		{
		}
	}
}