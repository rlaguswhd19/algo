package baekjoon.SamSungTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main17406 {
	static int n, m, k, sx, sy, next, ex, ey, ans;
	static int[][] map;
	static int[][] copy;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static RCS[] rcs;
	static RCS[] list;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		ans = Integer.MAX_VALUE;
		rcs = new RCS[k];
		list = new RCS[k];
		visit = new boolean[k];
		copy = new int[n + 1][m + 1];
		map = new int[n + 1][m + 1];
		
		for (int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < m + 1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());

			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());

			rcs[i] = new RCS(r, c, s);
		}
		per(0);

		System.out.println(ans);
	}

	static void per(int index) {
		if (index == k) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= m; j++) {
					int num = map[i][j];
					copy[i][j] = num;
				}
			}
			
			for (int i = 0; i < k; i++) {
				RCS a = list[i];
				turn(a.r, a.c, a.s);
			}
			
			for (int i = 1; i < n + 1; i++) {
				int sum = 0;
				for (int j = 1; j < m + 1; j++) {
					sum += copy[i][j];
				}

				ans = Math.min(ans, sum);
			}
			
			return;
		}

		for (int i = 0; i < k; i++) {
			if (visit[i]) {
				continue;
			}

			list[index] = rcs[i];
			visit[i] = true;
			per(index + 1);
			visit[i] = false;
		}
	}

	static void turn(int r, int c, int s) {
		int index = 0;

		for (int i = 0; i < s; i++) {
			sx = r - s + index;
			sy = c - s + index;
			next = copy[sx][sy];
			ex = r + s - index;
			ey = c + s - index;

			int x = sx;
			int y = sy;

			dfs(x, y, 0);

			index++;
		}
	}

	static void dfs(int x, int y, int dir) {
		switch (dir) {
		case 0:
			if (x == sx && y == ey) {
				dfs(x, y, dir + 1);
				return;
			}
			break;
		case 1:
			if (x == ex && y == ey) {
				dfs(x, y, dir + 1);
				return;
			}
			break;
		case 2:
			if (y == sy && x == ex) {
				dfs(x, y, dir + 1);
				return;
			}
			break;
		case 3:
			if (x == sx && y == sy) {
				return;
			}
			break;
		}
		// 다음꺼
		int nx = x + dx[dir];
		int ny = y + dy[dir];

		// 다음것을 임시 저장
		int temp = copy[nx][ny];

		// 전꺼를 넣어줌
		copy[nx][ny] = next;

		// 다음것을 넣어줌
		next = temp;

		dfs(nx, ny, dir);
	}

	static class RCS {
		int r, c, s;

		public RCS(int r, int c, int s) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
		}

		@Override
		public String toString() {
			return "RCS [r=" + r + ", c=" + c + ", s=" + s + "]";
		}
	}
}
