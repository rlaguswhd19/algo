package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution5688_세제곱근을찾아라 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			long n = Long.parseLong(br.readLine());
			long x = (long) Math.ceil(Math.pow(n, (double) 1 / 3));

			if (x * x * x == n) {
				System.out.println("#" + tc + " " + x);
			} else {
				System.out.println("#" + tc + " " + -1);
			}
		}
	}
}
