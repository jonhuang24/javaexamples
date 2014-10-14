import zen.core.Zen;

public class Pong {
	public static void main(String[] args) {

		// Create window
		Zen.create(500,500);

		// Create objects for the Ball, player Paddle, and computer Paddle
		Ball b = new Ball();
		Paddle p = new Paddle();
		Paddle comp = new Paddle(250, 40, 1);

		// Pause flag
		boolean pause = false;

		// Keep track of how many wins for each side
		int playerScore = 0;
		int compScore = 0;

		while(true){

			// pause screen
			if(pause) {
				
				Zen.setBackground("purple");
				
				Zen.setColor("white");
				Zen.drawText("PAUSED", 200, 250);
				Zen.drawText("Press 'p' to continue", 160, 350);
				
				if(Zen.isKeyPressed("p")) {
					pause = false;
					Zen.sleep(100);
				}

			}
			
			else {	
				if(Zen.isKeyPressed("n")) {
					
					//move code into reset function?
					b = new Ball();
					p = new Paddle();
					comp = new Paddle(250, 40, 2);
					playerScore = 0;
					compScore = 0;
				}
				
				if(Zen.isKeyPressed("p")) {
					pause = true;
					Zen.sleep(100);
				}
				
				Zen.setBackground("Black");

				b.move();
				b.draw();

				if(b.playerWins()) {
					//DESTRUCTORS??
					b = new Ball();
					p = new Paddle();
					comp = new Paddle(250, 40, 2);

					playerScore++;
				}
				else if (b.compWins()) {
					b = new Ball();
					p = new Paddle();
					comp = new Paddle(250, 40, 2);

					compScore++;
				}
				
				Zen.setColor("yellow");
				Zen.drawText("Player: " + playerScore, 10, 245);
				Zen.drawText("Comp: " + compScore, 410, 245);
				
				
				Zen.setColor("gray");
				Zen.drawText("p = pause", 200, 225);
				Zen.drawText("n = new game", 185, 250);

				p.move();
				p.draw();

				if(p.isTouching(b)) {
					b.dy = - b.dy;
					b.dx = Zen.getRandomNumber(-5, 5);
				}


				comp.draw();
				comp.follow(b);

				if(comp.isTouching(b)) {
					b.dy = - b.dy;
					b.dx = Zen.getRandomNumber(-5, 5);
				}
			}
			
			Zen.buffer(33);
		}
	}
}
