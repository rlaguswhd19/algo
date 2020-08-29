package T2020_2.ebay;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_2 {
	static int num = 8;
	static int[] cards = { 1, 4, 6 };

	public static void main(String[] args) {
		System.out.println(solution());
	}

	static int solution() {
		int ans = Integer.MAX_VALUE;
		Queue<Integer> q = new LinkedList<>();

		for (int i = cards.length - 1; i >= 0; i--) {
			if (num > cards[i]) {
				q.add(cards[i]);
			}
		}
		
		int cnt = 1;
		loop: while (!q.isEmpty()) {
			int size = q.size();
			for (int a = 0; a < size; a++) {
				int sum = q.poll();

				for (int i = 0; i < cards.length; i++) {
					if (sum + cards[i] > num) {
						continue;
					} else if (sum + cards[i] == num) {
						ans = cnt + 1;
						break loop;
					} else {
						q.add(sum + cards[i]);
					}
				}
			}
			
			cnt++;
		}

		return ans;
	}
}
