package swexpert.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution8382_방향전환2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			int x = Math.abs(x1 - x2);
			int y = Math.abs(y1 - y2);

			int sum = 0;

			if (x == y) {
				sum = x + y;
			} else {
				int min = Math.min(x, y);
				int max = Math.max(x, y);

				int temp = max - min;

				if (temp % 2 == 0) {
					sum = min * 2 + temp * 2;
				} else {
					sum = min * 2 + temp * 2 - 1;
				}
			}

			System.out.println("#" + tc + " " + sum);
		}
	}
}
