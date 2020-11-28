package nhngodo;

import java.util.ArrayList;

public class Solution2 {
	static int ans, plus, minus;
	static boolean[] visit;
	static char[] arr;
	static ArrayList<Integer> list;
	static int[] result;

	public static void main(String[] args) {
		int[] broken = { 6, 7, 8 };
		int page = 5457;
		System.out.println(solution(page, broken));
	}

	static int solution(int page, int[] broken) {
		visit = new boolean[10];
		arr = Integer.toString(page).toCharArray();
		result = new int[Integer.toString(page).length() + 1];

		for (int i = 0; i < broken.length; i++) {
			visit[broken[i]] = true;
		}

		int now = 100;
		ans = Math.abs(page - now);

		dfs(0, page);

		return ans;
	}

	static void dfs(int i, int page) {

		StringBuilder sb = new StringBuilder();
		for (int j = 0; j < i; j++) {
			sb.append(result[j]);
		}

		if (sb.length() != 0) {
			int num = Integer.parseInt(sb.toString());
			int abs = Math.abs(page - num) + i;
			ans = Math.min(ans, abs);
		}

		if (i == result.length) {
			return;
		}

		for (int j = 0; j < 10; j++) {
			if (visit[j]) {
				continue;
			}
			result[i] = j;
			dfs(i + 1, page);
		}
	}

	static boolean isRange(int num) {
		if (num >= 0 && num < 10) {
			return true;
		} else {
			return false;
		}
	}
}
