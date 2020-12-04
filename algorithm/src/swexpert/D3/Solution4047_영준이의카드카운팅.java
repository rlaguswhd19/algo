package swexpert.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution4047_영준이의카드카운팅 {
	static int[] ans;
	static boolean[][] cards;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			String s = br.readLine();
			StringBuilder sb;
			cards = new boolean[4][14];
			ans = new int[4];
			boolean isOk = true;

			for (int i = 0; i < s.length(); i += 3) {
				char al = s.charAt(i);
				int sdhc = 0;

				switch (al) {
				case 'S':
					sdhc = 0;
					break;
				case 'D':
					sdhc = 1;
					break;
				case 'H':
					sdhc = 2;
					break;
				case 'C':
					sdhc = 3;
					break;
				}

				sb = new StringBuilder();
				sb.append(s.charAt(i + 1));
				sb.append(s.charAt(i + 2));

				int num = Integer.parseInt(sb.toString());

				if (cards[sdhc][num]) {
					isOk = false;
					break;
				} else {
					ans[sdhc]++;
					cards[sdhc][num] = true;
				}
			}

			if (!isOk) {
				System.out.println("#" + tc + " " + "ERROR");
			} else {
				System.out.print("#" + tc);
				for (int i = 0; i < 4; i++) {
					System.out.print(" " + (13 - ans[i]));
				}
				System.out.println();
			}
		}
	}
}
