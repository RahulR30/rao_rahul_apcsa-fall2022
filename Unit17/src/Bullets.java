//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bullets
{
	private List<Ammo> ammo;

	public Bullets()
	{
		ammo = new ArrayList<Ammo>(20);
	}

	public void add(Ammo al)
	{
		ammo.add(al);
	}

	//post - draw each Ammo
	public void drawEmAll( Graphics window )
	{

		for(Ammo a : ammo){
			a.draw(window);
		}

	}

	public void moveEmAll()
	{
		if (ammo.size()>0)
		{
			for (Ammo value : ammo) {
				value.move("UP");
			}
		}
	}

	public void cleanEmUp()
	{
		for (int i=0; i<ammo.size(); i++)
		{
			if (ammo.get(i).getX()<=ammo.get(i).getSpeed())
			{
				ammo.remove(i);
				i--;
			}
		}
	}
	public void clear()
	{
		ammo=new ArrayList<Ammo>();
	}
	public List<Ammo> getList()
	{
		return ammo;
	}

	public String toString()
	{
		return ""+ Arrays.toString(ammo.toArray());
	}

}
