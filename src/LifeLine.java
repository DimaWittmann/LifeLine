import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import javax.swing.JFrame;


public class LifeLine extends JFrame{
	GraphicsDevice device;
	public LifeLine(){
		super("The Game Of Life -_-");
	/*	 GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		 device = env.getDefaultScreenDevice();
		 device.setFullScreenWindow(this);*/
	}
	
	
	public static void main (String [] arg) throws IOException, InterruptedException{
		
		LifeLine game = new LifeLine();
		Life engine = new Life(10,10);
		
		DisplayArea disp = new DisplayArea(engine);
		
		game.setDefaultCloseOperation(EXIT_ON_CLOSE);
		game.add(disp);
		game.pack();
		game.setVisible(true);
		game.addKeyListener(disp);
		
		
		
	}
}
