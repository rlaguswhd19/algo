package swexpert.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution9229_한빈이와SpotMart {
	static int n, m;
	static int[] arr;
	static int[] pick;
	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		StringTokenizer st;
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			ans = 0;
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			pick = new int[2];
			arr = new int[n];

			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			com(0, 0);
			System.out.println("#" + tc + " " + (ans == 0 ? -1 : ans));
		}
	}

	static void com(int target, int cnt) {
		if (cnt == 2) {
			int sum = 0;
			for (int i = 0; i < pick.length; i++) {
				sum += pick[i];
			}
			if (sum <= m) {
				ans = Math.max(ans, sum);
			}
			return;
		} else if (target == n) {
			return;
		} else {
			pick[cnt] = arr[target];
			com(target + 1, cnt + 1);
			com(target + 1, cnt);
		}
	}
}
