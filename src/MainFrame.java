import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.Toolkit;


import javax.swing.JFrame;


public class MainFrame extends JFrame {

	protected GraphicsDevice device;
	protected Life engine;
	protected DisplayArea disp;
	protected Controller contr;
	
	public MainFrame(Dimension areaSize){
		super("The Game Of Life -_-");
	/*	 GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		 device = env.getDefaultScreenDevice();
		 device.setFullScreenWindow(this);*/
		
		engine = new Life(areaSize.height, areaSize.width);
		disp = new DisplayArea(engine);
		contr = new Controller(disp, engine);
		initGUI();
	}
	
	
	protected void initGUI(){
		
		disp.setPreferredSize(new Dimension(1024,720));
		disp.setMaximumSize(Toolkit.getDefaultToolkit().getScreenSize());

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add(disp);
		this.pack();
		this.setVisible(true);
		this.addKeyListener(contr);
	}
}
