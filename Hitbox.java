import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class Hitbox extends Rectangle2D.Double
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int spd = 4;
	public boolean up = false, down = false;
	public Hitbox(double x, double y)
	{
		super(x, y, 1, 98);
	}
	public void tick()
	{
	}
	public void render(Graphics g, double x, double y)
	{
		this.x = x;
		this.y = y;
		Rectangle2D rect = new Rectangle2D.Double(x, y, width, height);
		g.setColor(Color.white);
		Graphics2D g2 = (Graphics2D) g;
		g2.fill(rect); 
	}
	
}
