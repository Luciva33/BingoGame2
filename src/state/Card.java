package state;

import java.util.Random;

public class Card {
	private Random rand = new Random();
	private int[][] card = new int[5][5];
	private String[][] debugCard = new String[5][5];

	//カード作成

	public Card() {
		int fix = 1;
		Already al = new Already();

		for (int i = 0; i < 5; i++) {
			re: for (int j = 0; j < 5; j++) {
				int num = rand.nextInt(15) + fix;
				//既出は再起呼び出し
				if (al.already(num)) {
					--j;
					continue re;
				} else {
					card[i][j] = num;
					//数値を文字列に変換
					debugCard[i][j] = Integer.valueOf(num).toString();
				}
				if (i == 2 && j == 2) {
					card[i][j] = 0;
					debugCard[2][2] = "0";
				}
			}
			fix += 15;
		}
	}

	//カード出力　0は(■)で表示

	public void printCard() {
		System.out.println("+________________________+");
		for(int i = 0; i < 5; i++ ) {
			System.out.print("|");
			for(int j = 0; j < 5; j++ ) {
				if(getCard()[i][j] == 0){
					System.out.print("(■)|");
				}else if(getCard()[i][j] < 10){
					//一桁
					System.out.print("  " + getCard()[i][j] +" |");
				}else {
					//二桁
					System.out.print(" " + getCard()[i][j] + " |");
				}
				//改行
				if (j == 4)
					System.out.println();
			}
		}
		System.out.println("+________________________+");
	}

	//Debug用のプリント  ()付きで数字を表示
	
	public void printDebug() {
		System.out.println("+________________________+");
		for(int i = 0; i < 5; i++) {
			System.out.print("|");
			for(int j = 0; j < 5; j++) {
				//フォーマット合わせ
				if(getCard()[i][j] == 0) {
					String now = debugCard[i][j];
					if(Integer.parseInt(now) < 10) {
						//一桁
						System.out.print("(" + now + ")|" );
					}else {
						//二桁
						System.out.print("(" + now + ")|" );
					}
				}else if (getCard()[i][j] < 10) {
					System.out.print(" 　" + getCard()[i][j] + " |" );
				
				}else {
					System.out.print(" " + getCard()[i][j] + "　|");
				}
				
				// 改行
				if (j == 4)
					System.out.println();
				
			}
		}
		System.out.println("+________________________+");
	}
	
	public int[][]getCard(){
		return this.card;
	}
	
	public void setCard(int num , int x , int y) {
		this.card[x][y] = num;
		
	}
	
}
