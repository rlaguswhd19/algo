package swexpert.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution7964_부먹왕국의차원관문 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int ans = 0;
			int[] distance = new int[n];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				distance[i] = Integer.parseInt(st.nextToken());
			}

			int cnt = 0;
			for (int i = 0; i < n; i++) {
				
				if (distance[i] == 1) {
					cnt = 0;
				} else {
					cnt++;
					
					if (cnt == d) {
						ans++;
						cnt = 0;
					}
				}
			}
			System.out.println(Arrays.toString(distance));
			System.out.println("#"+tc+" "+ans);
		}
	}
}
