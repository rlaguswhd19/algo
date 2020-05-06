package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution6718_희성이의원근법 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			int d = Integer.parseInt(br.readLine());
			int ans = 0;

			if (d < 100) {
				ans = 0;
			} else if (100 <= d && d < 1000) {
				ans = 1;
			} else if (1000 <= d && d < 10000) {
				ans = 2;
			} else if (10000 <= d && d < 100000) {
				ans = 3;
			} else if (100000 <= d && d < 1000000) {
				ans = 4;
			} else {
				ans = 5;
			}
			
			System.out.println("#" + tc + " " + ans);
		}

	}
}
