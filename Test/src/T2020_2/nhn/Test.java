package T2020_2.nhn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Test {
	static int n;
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		solution();
	}

	static void solution() {
		boolean[][] visit = new boolean[n][n];
		Queue<Point> q = new LinkedList<>();
		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, 1, 0, -1 };
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visit[i][j] && map[i][j] == 1) {
					q.add(new Point(i, j));
					visit[i][j] = true;
					int cnt = 0;
					
					while (!q.isEmpty()) {
						Point p = q.poll();

						for (int k = 0; k < 4; k++) {
							int nx = p.x + dx[k];
							int ny = p.y + dy[k];
							
							if(!isOk(nx, ny)) {
								continue;
							}
							
							if(!visit[nx][ny] && map[nx][ny]==1) {
								visit[nx][ny] = true;
								q.add(new Point(nx, ny));
							}
						}
						
						cnt++;
					}
					list.add(cnt);
				}
			}
		}
		
		Collections.sort(list);
		
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			if(i == list.size() - 1) {
				System.out.print(list.get(i));
			}else {
				System.out.print(list.get(i)+" ");
			}
		}
	}

	static boolean isOk(int nx, int ny) {
		if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
			return true;
		} else {
			return false;
		}
	}

	static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}
	}
}
