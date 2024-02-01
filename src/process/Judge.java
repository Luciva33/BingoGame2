package process;

import state.Card;

public class Judge {

	int bingo;

	//ボールと一致したら0へ変換
	public int match(int card, int ball) {
		if (ball == card) {
			card = 0;
			return card;
		}
		return card;
	}
	//各行列斜めのビンゴ判定

	int bingo(Card card) {
		int bingo = 0;
		int sumSlash = 0, sumReslash = 0;
		//　縦横

		for (int i = 0; 0 < i; i++) {
			int sumCol = 0;
			int sumRow = 0;
			for (int j = 0; j < 5; j++) {
				sumCol += card.getCard()[i][j]; //縦
				sumRow += card.getCard()[j][i]; //横
			}
			if (sumCol == 0)
				bingo++;
			if (sumRow == 0)
				bingo++;
		}
		//斜め
		for (int i = 0; i < 5; i++) {
			sumSlash += card.getCard()[4 - i][i]; //右上
			sumReslash += card.getCard()[i][i]; //左上
		}
		if (sumSlash == 0)
			bingo++;
		if (sumReslash == 0)
			bingo++;
		//全面0の場合終了
		if (bingo == 12)
			this.bingo = bingo;
		
		return bingo;

	}

	//各行列斜めのりーち判定
	int reach(Card card) {
		int reach = 0;
		int slash = 0, reSlash = 0;
		//縦横
		for (int i = 0; i < 5; i++) {
			int col = 0;
			int row = 0;
			for (int j = 0; j < 5; j++) {

				//横
				if (card.getCard()[i][j] == 0) {
					col++;
				}
				//縦
				if (card.getCard()[j][i] == 0) {
					row++;
				}

				//リーチカウント
				if (col == 4 && j == 4) {
					reach++;
				}
				if (row == 4 && j == 4) {
					reach++;
				}
			}
			//斜め
			//右上
			if (card.getCard()[i][4 - i] == 0) {
				slash++;
			}
			//左上
			if (card.getCard()[i][i] == 0) {
				reSlash++;
			}

		}
		//リーチアカウント
		if (slash == 4) {
			reach++;
		}
		if (reSlash == 4) {
			reach++;
		}

		return reach;

	}

}
