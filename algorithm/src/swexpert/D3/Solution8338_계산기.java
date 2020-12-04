package swexpert.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution8338_계산기 {
	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			ans = 0;

			for (int i = 0; i < n; i++) {
				int num = Integer.parseInt(st.nextToken());
				if (ans == 0) { // 0이 아닐때까지 더해주기
					ans += num;
				} else {
					if (ans * num < ans + num) {
						ans += num;
					} else {
						ans *= num;
					}
				}
			}

			System.out.println("#" + tc + " " + ans);
		}
	}
}
