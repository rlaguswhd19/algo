package swexpert.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution3750_Digitsum {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			String s = br.readLine();

			StringBuilder sb = new StringBuilder(s);
			while (sb.length() > 1) {

				int ans = 0;

				for (int i = 0; i < sb.length(); i++) {
					ans += sb.charAt(i) - '0';
				}
				sb = new StringBuilder("" + ans);
			}

			System.out.println("#" + tc + " " + sb.toString());
		}
	}
}
