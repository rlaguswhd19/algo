package swexpert.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution8016_홀수피라미드 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		long a = 1;
		long d = 2;

		for (int tc = 1; tc <= t; tc++) {
			long n = Long.parseLong(br.readLine());

			long LN = n * (2 * a + (n - 1) * d) / 2;
			long last = a + (LN - 1) * d;

			long FN = LN - (a + (n - 1) * d) + 1;
			long first = a + (FN - 1) * d;

			System.out.println("#" + tc + " " + first + " " + last);
		}
	}
}
