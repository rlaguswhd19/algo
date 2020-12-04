package test.T2020_2.nhngodo;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution5 {
	public static void main(String[] args) {
		int[] votes = { 1 };
		System.out.println(solution(votes));
	}

	static int solution(int[] votes) {
		int vote, ans;
		ans = 0;
		if(votes.length == 1) {
			return 0;
		}
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});

		for (int i = 1; i < votes.length; i++) {
			pq.add(votes[i]);
		}

		int me = votes[0];

		while (true) {
			System.out.println(pq);
			vote = pq.poll();
			if (me > vote) {
				break;
			}

			pq.add(vote - 1);
			me++;
			ans++;
		}

		return ans;
	}
}
