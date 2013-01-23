import java.util.Random;


public class Life {
	
	protected boolean[][] area;
	protected int height;
	protected int width;
	
	protected int x;
	protected int y;
	
	public boolean[][] getArea() {
		return area;
	}

	public void setArea(boolean[][] area) {
		this.area = area;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		if (x < width && x>0){
			this.x = x;
		}
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		if (y < height && y>0){
			this.y = y;
		}
	}

	public Life(int height, int width){
		area = new boolean [height+2][width+2];
		this.height = height;
		this.width = width;
		x = 0;
		y = 0;
		initArea();
	}
	
	public void initArea(){
		Random r = new Random();
		for(int i=1; i<=height; i++){
			for(int j=1; j<=width; j++){
				area[i][j] = r.nextBoolean();
			}
		}

	}

	
	
	
		//TODO огранізувати зібльшення області
	public boolean [][] expand( ){
		boolean lflag = false;
		boolean rflag = false;
		boolean hflag = false;
		boolean bflag = false;
		boolean [][]tmpArea =null;
		int tmpHeight = height;
		int tmpWidth = width;

		int tmpX = 0;
		int tmpY = 0;
		
		for(boolean cell: area[1]){
			if (!lflag){
				lflag = lflag || cell;
			}else{
				break;
			}
		}
		for(boolean cell: area[width]){ 
			if(!rflag){
				rflag = rflag || cell; 
			}else{
				break;
			}
		}
		for(int i=0; i<=width && !hflag; i++){
			hflag = hflag || area[i][1];
		}
		for(int i=0; i<=width && !bflag; i++){
			bflag = bflag || area[i][height];
		}

		if (lflag){
			tmpWidth++;
			tmpX++;
		}
		if (rflag){
			tmpWidth++;
		}
		if (hflag){
			tmpHeight++;
			tmpY++;
		}
		if (bflag){
			tmpHeight++;
		}
		
		tmpArea = new boolean [tmpHeight+2][tmpWidth+2];
		
		for(int i = 1; i<=height; i++){
			for(int j = 1; j<=width; j++){
				tmpArea[i+tmpX][j+tmpY]=area[i][j];
			}
		}
		
		x += tmpX;
		y += tmpY;

		width = tmpWidth;
		height = tmpHeight;
		return tmpArea;
	}
	
	
	public void nextGen(){
		//розширили площу
		boolean [][]tmpArea = expand();
		area = new boolean [height+2][width+2];
		//зберегли в основни масив розширену площу
		for(int i=0; i<=height+1; i++){
			for(int j=0; j<=width+1; j++){
				area[i][j] = tmpArea[i][j];
			}
		}
		//аналіз сусідів кожної клітинки
		for(int i=1; i<=height; i++){
			for(int j=1; j<=width; j++){
				
				int neighborhood=neighborhood(area, i,j);

				if ((neighborhood <2 || neighborhood>3) && tmpArea[i][j]){
					kill(tmpArea, i,j);
					
				}else
				if (neighborhood == 3 && !tmpArea[i][j]){
					engender(tmpArea, i,j);
				}
			}
		}
		

		area = tmpArea;
	}
	
	protected void engender(boolean[][] tmpArea, int x, int y){
		if(!tmpArea[x][y]){
			tmpArea[x][y] = true;
		}
	}
	
	protected void kill(boolean[][] tmpArea, int x, int y){
		if(tmpArea[x][y]){
			tmpArea[x][y] = false;
		}
	}
	
	protected int neighborhood(boolean[][] tmpArea, int x, int y){
		int neighborhood = 0;
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				if (tmpArea[x+i-1][y+j-1] ){
					neighborhood++;
				}
			}
		}
		if (tmpArea[x][y] ){
			neighborhood--;
		}
		
		return neighborhood;
	}
	

	public String toString(){
		String result = "";
		for(int i=0; i<=height+1; i++){
			for(int j=0; j<=width+1; j++){
				if (area[i][j]){
					result+=1 ;
				}else{
					result+=0; 	
				}
			}
			result+='\n'; 
		}
		
		return result;
		
	}
}
