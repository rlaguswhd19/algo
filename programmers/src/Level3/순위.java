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

//			// 이긴애보다 높은 애들을 활용
//			for (int num : up[win]) {
//				// 이긴애들에게 지금 진애들을 넣어준다.
//				down[num].add(lose);
//
//				// 진애는 이긴애보다 높은애들을 넣어준다.
//				up[lose].add(num);
//			}
//
//			// 진애보다 낮은 애들을 활용
//			for (int num : down[lose]) {
//				// 이긴애보다 낮은애들로 넣어준
//				down[win].add(num);
//
//				// 진애보다 낮은애들은 이긴애로 넣어준다.
//				up[num].add(win);
//			}
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
