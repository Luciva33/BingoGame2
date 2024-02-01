package state;

import java.util.Random;

public class Ball {

	private Random rand = new Random();
	private Already al  = new Already();

	public int createBall() {
		int ball = rand.nextInt(75)+1;
		//既出は再起呼び出し
		while(al.already(ball)) {
			ball = rand.nextInt(75)+1;
		}
		return ball;
	}
	
	
}
