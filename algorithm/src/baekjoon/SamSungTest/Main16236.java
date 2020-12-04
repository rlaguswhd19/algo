package baekjoon.SamSungTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main16236 {
	static int[][] map;
	static int n, cnt, shark, sx, sy, ans;
	static Queue<Point> q;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static boolean[][] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		shark = 2;
		cnt = 0;
		ans = 0;
		StringTokenizer st;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					sx = i;
					sy = j;
				}
			}
		}
		loop: while (true) {
			q = new LinkedList<>();
			visit = new boolean[n][n];
			q.add(new Point(sx, sy));
			visit[sx][sy] = true;
			ArrayList<Point> list = new ArrayList<>();
			int count = 0;

			bfs: while (!q.isEmpty()) {
				int size = q.size();

				for (int i = 0; i < size; i++) {
					Point p = q.poll();

					for (int j = 0; j < 4; j++) {
						int nx = p.x + dx[j];
						int ny = p.y + dy[j];

						if (!isRange(nx, ny)) {
							continue;
						}
						
						if(visit[nx][ny]) {
							continue;
						}
						
						int fish = map[nx][ny];
						
						if(fish == 0) {
							q.add(new Point(nx, ny));
							visit[nx][ny] = true;
						}else {
							if(fish < shark) {
								list.add(new Point(nx, ny));
								visit[nx][ny] = true;
							}else if(fish == shark){
								q.add(new Point(nx, ny));
								visit[nx][ny] = true;
							}else {
								visit[nx][ny] = true;
							}
						}
					}
				}
				count++;

				// 물고기들을 발견하면 그만
				if (list.size() > 0) {
					break bfs;
				}

			}

			if (list.size() > 1) { // 물고기가 여러마리야
				Point eat = new Point(n, n);

				for (int i = 0; i < list.size(); i++) {
					Point p = list.get(i);
					if (eat.x > p.x) {
						eat = p;
					}else if(eat.x == p.x) {
						if(eat.y > p.y) {
							eat = p;
						}
					}
				}
				
				cnt++;

				if (cnt == shark) {
					shark++;
					cnt = 0;
				}
				
				map[eat.x][eat.y] = 9;
				map[sx][sy] = 0;
				sx = eat.x;
				sy = eat.y;
				
				ans += count;
			} else if (list.size() == 1) { // 물고기가 하나야
				Point fish = list.get(0);

				// 샤크 키우기
				cnt++;

				if (cnt == shark) {
					shark++;
					cnt = 0;
				}

				// 상어 움직임
				map[fish.x][fish.y] = 9;
				map[sx][sy] = 0;
				sx = fish.x;
				sy = fish.y;

				// 움직인 시간 더하기
				ans += count;
			} else { // 물고기가 없으면 끝
				System.out.println(ans);
				break loop;
			}
		}
	}

	static boolean isRange(int nx, int ny) {
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
