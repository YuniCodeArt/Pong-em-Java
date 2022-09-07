import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class Player extends Rectangle2D.Double
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int spd = 4;
	public int points = 0;
	public boolean up = false, down = false;
	public Player(int x, int y)
	{
		super(x, y, 16, 100);
	}
	
	public void tick()
	{
		if(up && World.isFree(x, y-spd, 16, 100))
		{
			y-=spd;
		}
		else if(down && World.isFree(x, y+spd, 16, 100))
		{
			y+=spd;
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
