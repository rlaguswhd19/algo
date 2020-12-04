package swexpert.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution2805_농작물수확하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());

			int[][] map = new int[n][n];

			int ans = 0;
			int idx = n / 2;
			int plus = 0;
			for (int i = 0; i < n; i++) {
				String s = br.readLine();
				for (int j = 0; j < n; j++) {
					map[i][j] = s.charAt(j) - '0';
					if (j <= idx + plus && j >= idx - plus) {
						ans += map[i][j];
					}
				}

				if (i < n / 2) {
					plus++;
				} else {
					plus--;
				}
			}

			System.out.println("#" + tc + " " + ans);
		}
	}
}
