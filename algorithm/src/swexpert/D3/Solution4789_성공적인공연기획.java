package swexpert.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution4789_성공적인공연기획 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			String s = br.readLine();
			int ans = 0;
			int cnt = 0;

			for (int i = 0; i < s.length(); i++) {
				int num = s.charAt(i) - '0';

				if (i > cnt) {
					ans++;
					cnt += 1;
				}
				
				cnt += num;
			}

			System.out.println("#" + tc + " " + ans);
		}
	}
}
