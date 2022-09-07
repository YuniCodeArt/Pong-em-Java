import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

public class World
{
	public static List<Bloquinhos> blocos = new ArrayList<Bloquinhos>();
	public static Bolinha bola;
	public World()
	{
		bola = new Bolinha(350, 190+42);
		for(int xx = 0; xx < 45; xx++)
		{
			blocos.add(new Bloquinhos(xx*16, 0));
		}
		for(int xx = 0; xx < 45; xx++)
		{
			blocos.add(new Bloquinhos(xx*16, 480-4));
		}
	}

	public void tick()
	{
		bola.tick();
	}
	
	public static boolean isFree(double x, double y, int width, int height)
	{
		for(int i = 0; i < blocos.size(); i++)
		{
			Bloquinhos blocoAtual = blocos.get(i);
			if(blocoAtual.intersects(new Rectangle2D.Double(x, y, width, height)))
			{
				return false;
			}
		}
		return true;
	}
	
	public static boolean ColisionPlayer(Hitbox hb, double x, double y)
	{
		if(hb.intersects(new Rectangle2D.Double(x, y, 16, 16)))
		{
			return false;
		}
		return true;
	}
	
	public void render(Graphics g)
	{
		for(int i = 0; i < blocos.size(); i++)
		{
			blocos.get(i).render(g);
		}
		bola.render(g);
	}
	
}
