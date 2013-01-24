import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Controller implements KeyListener {

	protected DisplayArea disp;
	protected Life engine;
	public Controller(DisplayArea disp, Life engine){
		this.disp = disp;
		this.engine = engine;
	}
	
	
	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == 32){
			engine.nextGen();
			disp.repaint();
		}
		if (e.getKeyCode() == 38){
			if (disp.y<engine.getHeight()){
				disp.y++;
			}
			disp.repaint();
		} 
		if (e.getKeyCode() == 40){
			if (disp.y>0){
				disp.y--;
			}
			disp.repaint();
		} 
		if (e.getKeyCode() == 37){
			if (disp.x<engine.getWidth()){
				disp.x++;
			}
			disp.repaint();
		} 
		if (e.getKeyCode() == 39){
			if (disp.x>0){
				disp.x--;
			}
			disp.repaint();
		} 
		if (e.getKeyCode()== 27){ //esc
			System.exit(0);
		} 
		if (e.getKeyCode() == 10){ //Enter
			disp.x=0;
			disp.y=0;
			engine.initArea();
			disp.repaint();
		} 
		if (e.getKeyCode() == 109){ //-
			if(disp.cellSize>3){
				disp.cellSize--;
				disp.repaint();
			}
		}
		if (e.getKeyCode() == 107){ //+
			disp.cellSize++;
			disp.repaint();
		}

	}
	@Override
	public void keyReleased(KeyEvent e) {

	}


}
