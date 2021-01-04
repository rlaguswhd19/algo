package test.T2020_2.fursys;

import java.util.HashMap;

public class Solution1 {
	public static void main(String[] args) {
		int[] cards = { 1, 3, 2, 2, 5, 5, 1 };
		System.out.println(solution(cards));
	}

	static int solution(int[] cards) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < cards.length; i++) {
			int key = cards[i];
			if (map.containsKey(key)) {
				map.put(key, 2);
			} else {
				map.put(key, 1);
			}
		}

		int cnt = 0;
		for (int key : map.keySet()) {
			cnt = map.get(key);
			if (cnt == 1) {
				return key;
			}
		}
		
		return 0;
	}
}
