package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution6959_이상한나라의덧셈게임 {
	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			StringBuilder sb = new StringBuilder(br.readLine());
			ans = 0;

			dfs(sb);
			
			System.out.println("#" + tc + " " + (ans % 2 == 1 ? "A" : "B"));
		}
	}

	static void dfs(StringBuilder sb) {
		if (sb.length() == 1) {
			return;
		}

		int a = sb.charAt(0) - '0';
		int b = sb.charAt(1) - '0';

		sb.replace(0, 2, Integer.toString(a + b));
		ans++;

		dfs(sb);
	}
}
