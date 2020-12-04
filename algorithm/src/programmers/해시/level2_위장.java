package programmers.해시;

import java.util.HashMap;

public class level2_위장 {
	static HashMap<String, Integer> map;
	static int size, sum;
	static String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
	public static void main(String[] args) {
		map = new HashMap<>();
		for (int i = 0; i < clothes.length; i++) {
			if(map.get(clothes[i][1]) == null ) {
				map.put(clothes[i][1], 1);
			}else {
				map.put(clothes[i][1], map.get(clothes[i][1])+1);
			}
		}
		sum = 1;
		for(int i : map.values()) {
			sum *= i+1;
		}
		sum-=1;
		System.out.println(sum);
	}
}
