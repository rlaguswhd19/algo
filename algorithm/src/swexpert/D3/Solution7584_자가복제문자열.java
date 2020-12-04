package swexpert.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution7584_자가복제문자열 {
	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			long k = Long.parseLong(br.readLine()) - 1;
			ans = 0;
			while (k > 0) {
				if (k % 2 == 0) {
					if (k % 4 == 0) {
						ans = 0;
						break;
					} else {
						ans = 1;
						break;
					}
				} else {
					k = (k - 1) / 2;
				}
			}

			System.out.println("#" + tc + " " + ans);
		}
	}
}
