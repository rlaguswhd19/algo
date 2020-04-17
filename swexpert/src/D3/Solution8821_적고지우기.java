package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution8821_적고지우기 {
	static boolean[] visit;
	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			String s = br.readLine();

			visit = new boolean[10];
			ans = 0;

			for (int i = 0; i < s.length(); i++) {
				int num = s.charAt(i) - '0';
				if (!visit[num]) {
					ans++;
					visit[num] = true;
				} else {
					ans--;
					visit[num] = false;
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
}
