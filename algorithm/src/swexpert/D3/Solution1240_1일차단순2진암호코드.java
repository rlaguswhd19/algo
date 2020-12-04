package swexpert.D3;

import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Solution1240_1일차단순2진암호코드 {
	static String[] nums = { "0001101", "0011001", "0010011", "0111101", "0100011", "0110001", "0101111", "0111011",
			"0110111", "0001011" };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			boolean isOk = true;

			for (int i = 0; i < n; i++) {
				String s = br.readLine();
				int lastIndex = -1;
				for (int j = 0; j < s.length(); j++) {
					int num = s.charAt(j) - '0';
					if (num == 1) {
						lastIndex = j;
					}
				}

				if (lastIndex == -1 || !isOk) {
					continue;
				} else {
					int[] r = new int[8];
					s = s.substring(lastIndex - 55, lastIndex + 1);

					for (int j = 0; j < 8; j++) {
						String temp = s.substring(j * 7, j * 7 + 7);
						for (int k = 0; k < nums.length; k++) {
							if (nums[k].equals(temp)) {
								r[j] = k;
								break;
							}
						}
					}

					int function = (r[0] + r[2] + r[4] + r[6]) * 3 + r[1] + r[3] + r[5] + r[7];
					if (function % 10 == 0 && function > 0) {
						isOk = false;
						int ans = 0;
						for (int j = 0; j < r.length; j++) {
							ans += r[j];
						}

						System.out.println("#" + tc + " " + ans);
					} else {
						isOk = false;
						System.out.println("#" + tc + " " + 0);
					}
				}
			}
		}
	}
}
