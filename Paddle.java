import zen.core.Zen;

public class Paddle{

	int x;
	int y;
	int speed;
	
	public Paddle () {
		x = 250;
		y = 450;
		speed = 2;
	}
	
	// constructor with coordinates OVERLOAD
	public Paddle(int nx, int ny, int nspeed) {
		x = nx;
		y = ny;
		speed = nspeed;
	}
	
	public void draw() {
		Zen.setColor("white");
		Zen.fillRect(x - 50, y, 100, 10);
	}

	public void move() {
		//x = x - (x - Zen.getMouseX()) / 10;
		if (Zen.isKeyPressed("left")) {
			x = x - 10;
		}
		if (Zen.isKeyPressed("right")) {
			x = x + 10;
		}
		
	}
	
	//method for computer movement
	public void follow(Ball b) {
		
		if(this.x < b.x) {
			x += speed;
		}
		
		if (this.x > b.x) {
			x -= speed;
		}
	}
	
	
	public boolean isTouching(Ball b) {
		if (Math.abs(b.x - x) < 55 && Math.abs(b.y - y) < 20) {
			return true;
			
		}
		return false;
	}

}
