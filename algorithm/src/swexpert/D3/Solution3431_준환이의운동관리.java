package swexpert.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution3431_준환이의운동관리 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int l = Integer.parseInt(st.nextToken());
			int u = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());

			int ans = 0;

			if (l <= x && x <= u) {
				ans = 0;
			} else if (u < x) {
				ans = -1;
			} else {
				ans = l - x;
			}

			System.out.println("#" + tc + " " + ans);
		}
	}
}
