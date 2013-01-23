
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

import javax.swing.BorderFactory;
import javax.swing.JComponent;



public class DisplayArea extends JComponent 
						implements KeyListener{

	protected Life engine;
	protected int cellSize;
	
	protected int x=0;
	protected int y=0;
	
	public DisplayArea(Life engine){
		
		this.engine = engine;
		this.setBorder(BorderFactory.createRaisedBevelBorder());
		this.setPreferredSize(new Dimension(300,300));
		this.setMaximumSize(Toolkit.getDefaultToolkit().getScreenSize());
		
		cellSize =20;
		this.setDoubleBuffered(true);

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
		
		for (int i=0;i<=width-x;i++){
			g.drawLine(i*cellSize, 0, i*cellSize, (height-y)*cellSize);
		}
		for (int i=0;i<=height-y;i++){
			g.drawLine(0, i*cellSize, (width-x)*cellSize, i*cellSize);
		}
		
		for (int i=y;i<height;i++){
			for (int j=x;j<width;j++){
				if (engine.getArea()[i][j]){
					painLiveCell(i-y, j-x, g);
				}
					
			}
		}
	}
	
	public void painLiveCell(int x, int y,Graphics g){
		g.fillRect((int) (y*cellSize+2),(int)(x*cellSize+2), (int)(cellSize-3), (int) (cellSize-3));
	}





	@Override
	public void keyTyped(KeyEvent e) {

		if (e.getKeyChar() == ' '){
			engine.nextGen();
			repaint();
		}
		if (e.getKeyChar() == 'w'){
			if (y<engine.getHeight()){
				y++;
			}
			repaint();
		} 
		if (e.getKeyChar() == 's'){
			if (y>0){
				y--;
			}
			repaint();
		} 
		if (e.getKeyChar() == 'a'){
			if (x<engine.getWidth()){
				x++;
			}
			repaint();
		} 
		if (e.getKeyChar() == 'd'){
			if (x>0){
				x--;
			}
			repaint();
		} 
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}
	@Override
	public void keyReleased(KeyEvent e) {}

}
