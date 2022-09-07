import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class Bolinha extends Rectangle2D.Double
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public double spd = 2;
	public double diry = 1;
	public double dirx = 1;
	
	public Bolinha(int x, int y)
	{
		super(x, y, 16, 16);
		
	}
	
	
	public void tick()
	{
		if(!World.ColisionPlayer(Game.hitbox, x, y))
		{
			if(diry == 1 && dirx == 1)
			{
				diry = 1;
				dirx = -1;
				spd+=0.1;
			}
			else
			{
				diry = -1;
				dirx = -1;
				spd+=0.1;
			}
		}
		
		if(!World.ColisionPlayer(Game.hitbox1, x, y))
		{
			if(diry == -1 && dirx == -1)
			{
				diry = -1;
				dirx = 1;
				spd+=0.1;
			}
			else if(!(diry == -1 && dirx == -1))
			{
				diry = 1;
				dirx = 1;
				spd+=0.1;
			}
		}
		
		if(!World.isFree(x, y, 16, 16))
		{
			if(y <= 2)
			{
				diry = 1;
			}
			else if(y >= 462)
			{
				diry = -1;
			}
			
		}
		x+=spd*dirx;
		y+=spd*diry;
		if(x <= 0)
		{
			Game.player.points += 1;
			spd = 2;
			y = 190+42;
			x = 350; 
		}
		if(x >= 720)
		{
			Game.player1.points += 1;
			spd = 2;
			y = 190+42;
			x = 350; 
		}
	}
	
	public void render(Graphics g)
	{
		Rectangle2D rect = new Rectangle2D.Double(x, y, width, height);
		g.setColor(Color.white);
		Graphics2D g2 = (Graphics2D) g;
		g2.fill(rect); 
	}
}
