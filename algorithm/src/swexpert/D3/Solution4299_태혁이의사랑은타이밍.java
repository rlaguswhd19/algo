package swexpert.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.StringTokenizer;

public class Solution4299_태혁이의사랑은타이밍 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		int[] minute = new int[3];
		minute[0] = 60 * 24;
		minute[1] = 60;
		minute[2] = 1;

		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			boolean isOk = false;
			int ans = 0;

			for (int i = 0; i < 3; i++) {
				int num = Integer.parseInt(st.nextToken());

				if (num - 11 >= 0) {

					if (num - 11 > 0) {
						isOk = true;
					}

					ans += (num - 11) * minute[i];

				} else {
					if (isOk) {
						ans += (num - 11) * minute[i];
					} else {
						ans = -1;
						break;
					}
				}
			}

			System.out.println("#" + tc + " " + ans);
		}
	}
}
