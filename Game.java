import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;
public class Game extends Canvas implements Runnable, KeyListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static int WIDTH = 720, HEIGHT = 480;
	public static Player player;
	public static Player player1;
	public static Hitbox hitbox;
	public static Hitbox hitbox1;
	public World world;
	public int fps = 0;
	public Game()
	{
		this.addKeyListener(this);
		player = new Player(WIDTH-50, 190);
		player1 = new Player(32, 190);
		hitbox = new Hitbox(WIDTH-50, player.y);
		hitbox1 = new Hitbox(32+16, player1.y);
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		world = new World();
	}	
	public void tick()
	{
		hitbox.tick();
		player.tick();
		player1.tick();
		world.tick();
	}
	public void render()
	{
		BufferStrategy bs = this.getBufferStrategy();
		
		if(bs == null)
		{
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		player.render(g);
		player1.render(g);
		hitbox.render(g, WIDTH-50, player.y);
		hitbox1.render(g, 32+16, player1.y);
		world.render(g);
		g.setFont(new Font("Arial", Font.PLAIN, 20)); 
		g.drawString("Player 1: " + player.points + "  Player 2: " + player1.points, WIDTH/2-100, HEIGHT/2-200);
		g.drawString("FPS: " + fps, WIDTH/2-200, HEIGHT/2-200);
		bs.show();
	}
	public static void main(String[] args)
	{
		Game game = new Game();
		JFrame frame = new JFrame();
		
		frame.add(game);
		frame.setTitle("Pong By Yuni!");
		frame.pack();
		frame.setLocationRelativeTo(null);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
		
		new Thread(game).start();
		
	}
	
	@Override
	public void run()
	{
		int frames = 0;
		double timer = System.currentTimeMillis();
		while(true)
		{
			tick();
			render();
			try
			{
				frames++;
				if(System.currentTimeMillis() - timer >= 1000)
				{
					fps = frames;
					frames = 0;
					timer+=1000;
				}
				Thread.sleep(1000/120);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
	}
	@Override
	public void keyTyped(KeyEvent e) 
	{
		
	}
	@Override
	public void keyPressed(KeyEvent e) 
	{
		if(e.getKeyCode() == KeyEvent.VK_UP)
		{
			player.up = true;
			hitbox.up = true;
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			player.down = true;
			hitbox.down = true;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_W)
		{
			player1.up = true;
			hitbox1.up = true;
		}
		else if(e.getKeyCode() == KeyEvent.VK_S)
		{
			player1.down = true;
			hitbox1.down = true;
		}
	}
	@Override
	public void keyReleased(KeyEvent e) 
	{
		if(e.getKeyCode() == KeyEvent.VK_UP)
		{
			player.up = false;
			hitbox.up = false;
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			player.down = false;
			hitbox.down = false;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_W)
		{
			player1.up = false;
			hitbox1.up = false;
		}
		else if(e.getKeyCode() == KeyEvent.VK_S)
		{
			player1.down = false;
			hitbox1.down = false;
		}
	}
}
