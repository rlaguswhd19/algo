package baekjoon.Avatar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1236 {
	static char[][] map;
	static int[][] visit;
	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int ans = 0;
		map = new char[n][m];
		visit = new int[n][m];

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < s.length(); j++) {
				map[i][j] = s.charAt(j);
			}
		}

		int c_cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 'X') {
					c_cnt++;
					break;
				}
			}
		}

		int r_cnt = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (map[j][i] == 'X') {
					r_cnt++;
					break;
				}
			}
		}

		int max = Math.max(n - c_cnt, m - r_cnt);

		System.out.println(max);
	}
}
