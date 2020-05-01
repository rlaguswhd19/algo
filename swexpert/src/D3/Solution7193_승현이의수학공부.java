package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution7193_승현이의수학공부 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			long ans = 0;
			int n = Integer.parseInt(st.nextToken());
			String s = st.nextToken();
			int size = s.length() - 1;
			for (int i = 0; i < s.length(); i++) {
				int num = s.charAt(i) - '0';

				ans += num;
			}
			ans %= n - 1;

			System.out.println("#" + tc + " " + ans);
		}
	}
}
