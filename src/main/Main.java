package main;

import process.BingoSys;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("+--  ビンゴゲーム Start !---+");
		System.out.println("※ Help: Can you quit? ");
		System.out.println("       \"exit\"");
		System.out.println();
		new BingoSys().play();
		System.out.println("+--- ビンゴゲーム END !---+");
		
	}

}
