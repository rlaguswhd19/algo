package D3;

import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Solution6853_직사각형과점 {
	static int[] ans;
	static int x1, x2, y1, y2;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			ans = new int[3];
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());

			int n = Integer.parseInt(br.readLine());

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				check(x, y);
			}

			System.out.print("#" + tc + " ");
			for (int i = 0; i < ans.length; i++) {
				System.out.print(ans[i] + " ");
			}
			System.out.println();
		}
	}

	static void check(int x, int y) {
		// 내부에 있을때
		if (x1 <= x && x <= x2 && y1 <= y && y <= y2) {
			if (x == x1 || x == x2 || y == y1 || y == y2) {
				ans[1]++;
			} else {
				ans[0]++;
			}
		} else { // 외부에 있을때
			ans[2]++;
		}
	}
}
