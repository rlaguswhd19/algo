package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution3408_세가지합구하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			long  n = Long.parseLong(br.readLine());

			long a1 = n * (n + 1) / 2;

			long a2 = n * n;
			long a3 = n * (n + 1);

			System.out.println("#" + tc + " " + a1 + " " + a2 + " " + a3);
		}
	}
}
