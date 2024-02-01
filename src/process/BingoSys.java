package process;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import state.Ball;
import state.Card;

public class BingoSys {

	private Card card = new Card();
	private Ball ball = new Ball();
	private Judge judge = new Judge();
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private String in;

	public void play() {
	
		//カード表示
		System.out.println("+________________________+\"");
		System.out.println("| BINGO : " + judge.bingo(card) + " | REACH : " + judge.reach(card) + "  |");
		card.printCard();
		
		// card.printDebug(); // Debug用
		
		try {
			while(judge.bingo < 12){
				// ボール出力
				int num = ball.createBall();
				System.out.println("        Ball : " + num);
				
				System.out.println("ENTER >");
				in = br.readLine();
				
				//途中終了
				if("exit".equals(in))
					break;
				//カードの値とぼーうの値を判断
				
				for(int i = 0; i < 5; i++) {
					for(int j =0; j < 5; j++) {
						//ボールの値とカードの値が一致したら0をセット
						card.setCard(judge.match(card.getCard()[i][j], num),i ,j);
					}
				}	
				
				//　現在のビンゴ、リーチ表示
				System.out.println("+________________________+");
				System.out.println
				("| BINGO : " + judge.bingo(card) + " | REACH : " + judge.reach(card) + " |");
				// カード表示
				card.printCard();
				//card.printDebug(); // Debug用
				}
			}catch(Exception e) {
				System.out.println("error" + e);
		}
			
	}

}
