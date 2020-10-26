package Level3;

import java.util.HashSet;

public class 순위 {
	public static void main(String[] args) {
		int n = 5;
		int[][] results = { { 4, 3 }, { 4, 2 }, { 3, 2 }, { 1, 2 }, { 2, 5 } };
		System.out.println(solution(n, results));
	}

	static int solution(int n, int[][] results) {
		HashSet<Integer>[] down = new HashSet[n + 1];
		HashSet<Integer>[] up = new HashSet[n + 1];

		for (int i = 1; i < n + 1; i++) {
			down[i] = new HashSet<>();
			up[i] = new HashSet<>();
		}

		for (int i = 0; i < results.length; i++) {
			int win = results[i][0];
			int lose = results[i][1];

			down[win].add(lose);
			up[lose].add(win);
		}

		for (int i = 1; i < n + 1; i++) {
			for(int u : up[i]) {
				for(int d : down[i]) {
					down[u].add(d);
				}
			}
			
			for(int d : down[i]) {
				for(int u : up[i]) { 
					up[d].add(u);
				}
			}
		}

		int ans = 0;

		for (int i = 1; i < n + 1; i++) {
			int sum = down[i].size() + up[i].size();

			if (sum == n - 1) {
				ans++;
			}
		}

		return ans;
	}
}
