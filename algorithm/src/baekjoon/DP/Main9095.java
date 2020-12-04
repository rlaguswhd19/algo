package baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main9095 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		int[] ans = new int[11];
		ans[0] = 1;
		ans[1] = 1;

		for (int i = 2; i < ans.length; i++) {
			for (int j = 1; j <= 3; j++) {

				if (i - j < 0) {
					continue;
				}

				ans[i] += ans[i - j];
			}
		}
		
		for (int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());

			System.out.println(ans[n]);
		}
	}
}
