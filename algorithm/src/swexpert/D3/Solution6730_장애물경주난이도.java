package swexpert.D3;

import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Solution6730_장애물경주난이도 {
	static int up, down;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());
			up = 0;
			down = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());

			int before = Integer.parseInt(st.nextToken());
			while (st.hasMoreTokens()) {
				int num = Integer.parseInt(st.nextToken());

				if (num > before) {
					up = Math.max(up, num - before);
				} else {
					down = Math.max(down, before - num);
				}

				before = num;
			}

			System.out.println("#" + tc + " " + up + " " + down);
		}
	}
}
