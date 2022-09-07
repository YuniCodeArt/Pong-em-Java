import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bloquinhos extends Rectangle
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Bloquinhos(int x, int y)
	{
		super(x, y, 16, 4);
	}
	
	public void render(Graphics g)
	{
		g.setColor(Color.white);
		g.fillRect(x, y, width, height);
		g.setColor(Color.black);
		g.drawRect(x, y, width, height);
	}
}
