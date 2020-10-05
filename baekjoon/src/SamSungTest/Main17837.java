package SamSungTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main17837 {
	static int[] dx = { 0, 0, 0, -1, 1 };
	static int[] dy = { 0, 1, -1, 0, 0 };
	static int[][] map;
	static int n, k;
	static LinkedList<Integer>[][] group;
	static Point[] plist;
	static boolean end = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		map = new int[n + 1][n + 1];

		group = new LinkedList[n + 1][n + 1];
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				group[i][j] = new LinkedList<>();
			}
		}

		plist = new Point[k + 1];

		for (int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 1; j < n + 1; j++) { // 0 은 흰 1은 빨 2는 파
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i <= k; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());

			plist[i] = new Point(dir, x, y);
			group[x][y].add(i);
		}

		int cnt = 0;

		loop: while (cnt <= 1000) {
			for (int i = 1; i < k + 1; i++) {
				int idx = i;
				Point p = plist[i];
				int dir = p.dir;

				int nx = p.x + dx[dir];
				int ny = p.y + dy[dir];
				
				if (!isOk(nx, ny)) {
					blue(p, idx);
				} else {
					if (map[nx][ny] == 0) {
						white(p, idx);
					} else if (map[nx][ny] == 1) {
						red(p, idx);
					} else {
						blue(p, idx);
					}
				}
				
				if (end) {
					cnt++;
					break loop;
				}
			}

			cnt++;
		}

		System.out.println(cnt == 1001 ? -1 : cnt);
	}

	static void blue(Point p, int idx) {
//		방향을 바꿔준다.
		int dir = p.dir;

		if (dir == 1) {
			dir = 2;
		} else if (dir == 2) {
			dir = 1;
		} else if (dir == 3) {
			dir = 4;
		} else {
			dir = 3;
		}

		int nx = p.x + dx[dir];
		int ny = p.y + dy[dir];

		p.dir = dir;

		if (isOk(nx, ny)) { // 막혀있으면 방향 바꾼채로 가만히
			if (map[nx][ny] == 0) {
				white(p, idx);
			} else if (map[nx][ny] == 1) {
				red(p, idx);
			}
		}
	}

	static void red(Point p, int idx) {
		int nx = p.x + dx[p.dir];
		int ny = p.y + dy[p.dir];

		LinkedList<Integer> now = group[p.x][p.y]; // 현재 그룹
		LinkedList<Integer> next = group[nx][ny]; // 다음 그룹

		int move = 0;

		// 그룹 찾기
		for (int i = 0; i < now.size(); i++) {
			int num = now.get(i);

			if (num == idx) {
				move = i;
				break;
			}
		}

		int size = now.size();
		for (int i = size - 1; i >= move; i--) {
			int index = now.get(i);

			plist[index].x = nx;
			plist[index].y = ny;

			// 뒤에서 부터 추가
			next.add(index);

			// 뒤에서 부터 삭제
			now.remove(i);
		}

		if (next.size() >= 4) {
			end = true;
		}
	}

	static void white(Point p, int idx) {
		int nx = p.x + dx[p.dir];
		int ny = p.y + dy[p.dir];

		LinkedList<Integer> now = group[p.x][p.y]; // 현재 그룹
		LinkedList<Integer> next = group[nx][ny]; // 다음 그룹

		int move = 0;

		// 그룹 찾기
		for (int i = 0; i < now.size(); i++) {
			int num = now.get(i);

			if (num == idx) {
				move = i;
				break;
			}
		}

		while (now.size() > move) {
			int index = now.get(move);

			// 이동
			plist[index].x = nx;
			plist[index].y = ny;

			// 그룹 추가
			next.add(index);

			// 그룹 지우기
			now.remove(move);
		}

		if (next.size() >= 4) {
			end = true;
		}
	}

	static boolean isOk(int nx, int ny) {
		if (nx >= 1 && ny >= 1 && nx < n + 1 && ny < n + 1) {
			return true;
		} else {
			return false;
		}
	}

	static class Point {
		int dir, x, y;

		public Point(int dir, int x, int y) {
			super();
			this.dir = dir;
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Point [dir=" + dir + ", x=" + x + ", y=" + y + "]";
		}
	}
}
