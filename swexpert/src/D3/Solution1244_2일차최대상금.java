package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1244_2일차최대상금 {
	static int num, ans, cnt;
	static String s;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			s = st.nextToken();
			num = Integer.parseInt(st.nextToken());
			ans = 0;

			dfs(0, 0);

			System.out.println("#" + tc + " " + ans);
		}
	}

	static void dfs(int cnt, int idx) {
		if (idx == num) {
			ans = Math.max(ans, Integer.parseInt(s));
			return;
		}

		for (int i = idx; i < s.length(); i++) {
			for (int j = i + 1; j < s.length(); j++) {
				if (s.charAt(i) <= s.charAt(j)) {
					swap(i, j);
					dfs(cnt + 1, i);
					swap(j, i);
				}
			}
		}
	}

	static void swap(int i, int j) {
		StringBuilder sb = new StringBuilder(s);
		char A = s.charAt(i);
		char B = s.charAt(j);

		sb.setCharAt(i, B);
		sb.setCharAt(j, A);

		s = sb.toString();
	}
}
