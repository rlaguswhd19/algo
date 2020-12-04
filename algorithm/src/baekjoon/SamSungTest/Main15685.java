package baekjoon.SamSungTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main15685 {
	static int n, d, g, ans;
	static ArrayList<Point> list;
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { 1, 0, -1, 0 };

	static int[] cx = { 0, 1, 1 };
	static int[] cy = { 1, 0, 1 };
	static int index;
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		StringTokenizer st;
		map = new int[1001][1001];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());

			list.add(new Point(x, y, d));
			dfs(x, y, 0);
			index = list.size();

		}

		for (int i = 0; i < list.size(); i++) {
			Point p = list.get(i);
			map[500+p.x][500+p.y]++;
		}
		
		for (int i = 0; i < 1001; i++) {
			for (int j = 0; j < 1001; j++) {
				if(map[i][j] != 0) {
					boolean isOk = true;
					
					for (int j2 = 0; j2 < 3; j2++) {
						int nx = i+cx[j2];
						int ny = j +cy[j2];
						if(map[nx][ny] == 0) {
							isOk = false;
							break;
						}
					}
					
					if(isOk) {
						ans++;
					}
				}
			}
		}
		
		System.out.println(ans);
	}

	static void dfs(int x, int y, int cnt) {
		if (cnt > g) {
			return;
		}

		int size = list.size();
		int target = size - 1;

		if (cnt != 0) {
			size--;
		}
		for (int i = 0; i < size - index; i++) {
			Point p = list.get(target - i);

			int dir = p.d;
			x = x + dx[dir];
			y = y + dy[dir];

			dir++;
			if (dir > 3) {
				dir = 0;
			}

			list.add(new Point(x, y, dir));
		}

		dfs(x, y, cnt + 1);
	}

	static class Point {
		int x, y, d;

		public Point(int x, int y, int d) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", d=" + d + "]";
		}
	}
}
