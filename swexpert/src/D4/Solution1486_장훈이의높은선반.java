package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1486_장훈이의높은선반 {
	static int[] arr;
	static int ans, end, n, b;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st;
			st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			arr = new int[n];
			ans = Integer.MAX_VALUE;

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 1; i <= n; i++) {
				end = i;
				com(0, 0, 0);
			}

			System.out.println("#" + tc + " " + (ans - b));
		}
	}

	static void com(int cnt, int target, int sum) {
		if (end == cnt) {
			if (sum >= b) {
				ans = Math.min(sum, ans);
			}
			return;
		} else if (target == arr.length) {
			return;
		} else {
			// 선택안했을때
			com(cnt, target + 1, sum);
			// 선택했을때
			com(cnt + 1, target + 1, sum + arr[target]);
		}
	}
}
