
public class Location {
private int x;
private int y;
public Location(int x, int y){
	this.x=x;
	this.y=y;
}
public int getX(){
	return x;
}
public int getY(){
	return y;
}
public Location convertToGrid() {
	// TODO Auto-generated method stub
	int nx= (x-BlokusBoard.HORIZONTAL_BUFFER)/Block.SIZE;
	int ny= (y-BlokusBoard.VERTICAL_BUFFER)/Block.SIZE;
	
	return new Location (nx,ny);
}
public Location toScreen() {
	// TODO Auto-generated method stub
	int nx = (BlokusBoard.HORIZONTAL_BUFFER) + x*Block.SIZE;
	int ny = (BlokusBoard.VERTICAL_BUFFER) + y*Block.SIZE;
	return new Location(nx,ny);
}
}
