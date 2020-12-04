package swexpert.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution6913_동철이의프로그래밍대회 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			ArrayList<Integer> ans = new ArrayList<>();
			int max = 0;
			for (int i = 0; i < n; i++) {
				int cnt = 0;
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++) {
					int num = Integer.parseInt(st.nextToken());
					if (num == 1) {
						cnt++;
					}
				}

				if (max < cnt) {
					max = cnt;
					ans = new ArrayList<>();
					ans.add(i);
				} else if (max == cnt) {
					ans.add(i);
				}
			}

			System.out.println("#" + tc + " " + ans.size() + " " + max);
		}
	}
}
