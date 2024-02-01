package state;

import java.util.ArrayList;

public class Already {
	
	ArrayList<Integer>list = new ArrayList<Integer>();
	boolean flg;
	
	//既出の数字か判断する
	public boolean already(int num) {
		//カラの場合
		if(list.isEmpty()) {       //リストの中があるか調べる
			list.add(new Integer(num));
			flg = false;
		}else if(list.contains(num)) {
			//既出
			flg = true;
		}else {
			//未出
			flg = false;
			list.add(new Integer(num));
		}
		return flg;
	}
	
}
