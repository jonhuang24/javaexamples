import zen.core.Zen;

public class Ball {
	
	int x;
	int y;
	int dx;
	int dy;
	
	public Ball() {
		x = 250;
		y = 250;
		dx = Zen.getRandomNumber(-10, 10);
		dy = Zen.getRandomNumber(15, 17);
	}
	
	public void draw() {
		Zen.setColor("light green");
		Zen.fillOval(x - 10, y - 10, 20, 20);
	}

	public void move() {
		x = x + dx;
		y = y + dy;
		
		if (x > 490) {
			x = 490;
			dx = -dx;
		}
		if (x < 10) {
			x = 10;
			dx = -dx;
		}
	}
	
	public boolean playerWins() {
		if (y < 10) {
			return true;
		}
		
		return false;
	}
	
	public boolean compWins() {
		
		if (y > 490) {
			return true;
		}
		
		return false;
	}
}
