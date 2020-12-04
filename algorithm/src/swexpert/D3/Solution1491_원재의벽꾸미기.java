package swexpert.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1491_원재의벽꾸미기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());

			int al = (int) Math.pow(n, 0.5);
			int bl = 0;
			long ans = Long.MAX_VALUE;

			for (int i = 1; i <= al; i++) {
				bl = n / i;

				for (int j = 1; j <= bl; j++) {
					long temp = 0;

					temp = a * Math.abs(i - j) + b * (n - i * j);

					if (ans > temp) {
						ans = temp;
					}
				}

			}

			System.out.println("#" + tc + " " + ans);
		}
	}
}
