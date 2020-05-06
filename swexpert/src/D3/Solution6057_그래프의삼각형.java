package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution6057_그래프의삼각형 {
	static int n, ans, m;
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			map = new int[n + 1][n + 1];
			ans = 0;

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				map[x][y] = 1;
				map[y][x] = 1;
			}

			for (int i = 1; i < n + 1; i++) {
				for (int j = i + 1; j < n + 1; j++) {
					if (map[i][j] == 1) {
						for (int k = j + 1; k < n + 1; k++) {
							if (map[j][k] == 1) {
								if (map[k][i] == 1) {
									ans++;
								}
							}
						}
					}
				}
			}
			
			System.out.println("#" + tc + " " + ans);
		}
	}

}
