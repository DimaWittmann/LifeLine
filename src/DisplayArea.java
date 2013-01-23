
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JComponent;



public class DisplayArea extends JComponent 
						implements KeyListener{

	protected Life engine;
	protected int cellSize;
	
	public DisplayArea(Life engine){
		
		this.engine = engine;
		this.setBorder(BorderFactory.createRaisedBevelBorder());
		this.setPreferredSize(new Dimension(300,300));
		this.setMaximumSize(Toolkit.getDefaultToolkit().getScreenSize());
		
		cellSize =20;
		
		
	}
	
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.clearRect(0, 0, getWidth(), getWidth());
		
		int height = engine.area.length;
	/*	if(height * cellSize >= this.getHeight()){
			height = (int) Math.floor(this.getHeight()/cellSize);
		}*/
		
		int width = engine.area[0].length;
	/*	if(width * cellSize >= this.getWidth()){
			width = (int)Math.floor( this.getWidth()/cellSize);
		}*/
		
		for (int i=0;i<=width;i++){
			g.drawLine(i*cellSize, 0, i*cellSize, height*cellSize);
		}
		for (int i=0;i<=height;i++){
			g.drawLine(0, i*cellSize, width*cellSize, i*cellSize);
		}
		
		for (int i=0;i<height;i++){
			for (int j=0;j<width;j++){
				if (engine.getArea()[i][j]){
					painLiveCell(i, j, g);
				}
					
			}
		}
	}
	
	public void painLiveCell(int x, int y,Graphics g){
		g.fillRect((int)(x*cellSize+2),(int) (y*cellSize+2),
				(int) (cellSize-3), (int)(cellSize-3));
	}





	@Override
	public void keyTyped(KeyEvent e) {

		if (e.getKeyChar() == ' '){
			engine.nextGen();
			paintComponent(getGraphics());
		}
		if (e.getKeyChar() == 'w'){
			engine.setY(engine.getY()+1);
			paintComponent(getGraphics());
		} 
		if (e.getKeyChar() == 's'){

			engine.setY(engine.getY()-1);
			paintComponent(getGraphics());
		} 
		if (e.getKeyChar() == 'd'){
			engine.setX(engine.getX()+1);
			paintComponent(getGraphics());
		} 
		if (e.getKeyChar() == 'a'){
			engine.setX(engine.getX()-1);
			paintComponent(getGraphics());
		} 
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}
	@Override
	public void keyReleased(KeyEvent e) {}

}
