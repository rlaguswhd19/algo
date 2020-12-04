package swexpert.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution9088_다이아몬드 {
	static int[] dia;
	static int n, k, ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			ans = 0;
			dia = new int[10001];

			for (int i = 1; i < n + 1; i++) {
				// 무게
				int num = Integer.parseInt(br.readLine());
				// 무게++;
				dia[num]++;
			}

			for (int i = 1; i <= 10000 - k; i++) {
				int sum = 0;

				for (int j = i; j <= i + k; j++) {
					sum += dia[j];
				}

				ans = Math.max(sum, ans);
			}

			System.out.println("#" + tc + " " + ans);
		}
	}
}
