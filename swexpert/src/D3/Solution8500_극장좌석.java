package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution8500_극장좌석 {
	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());
			ans = n;

			StringTokenizer st = new StringTokenizer(br.readLine());
			int max = 0;
			while (st.hasMoreTokens()) {
				int num = Integer.parseInt(st.nextToken());
				ans += num;
				max = Math.max(max, num);
			}
			
			ans += max;
			
			System.out.println("#" + tc + " " + ans);
		}
	}
}
