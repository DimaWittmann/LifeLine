import java.awt.Dimension;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.logging.Level;
import javax.swing.JFrame;


public class LifeLine extends JFrame{
	
	
	
	
	public static void main (String [] arg) throws IOException{
		
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
