package baekjoon.SamSungTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main19236 {
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int ans = 0;
	static boolean[] eat = new boolean[17];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] map = new int[4][4];
		Fish[] list = new Fish[17];
		StringTokenizer st;
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				int num = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				list[num] = new Fish(i, j, d - 1);
				map[i][j] = num;
			}
		}

		// 물고기는 빈칸과 물고기가 있는 칸 이동 vs 상어가 있거나 경계를 넘는칸 이동 불가능

		int num = map[0][0]; // 물고기 넘버
		int shark = num;

		dfs(map, list, num, num);

		System.out.println(ans);
	}

	static void dfs(int[][] map, Fish[] list, int shark, int sum) {
		ans = Math.max(sum, ans);

		// 물고기의 이동
		for (int i = 1; i < 17; i++) {
			if (eat[i] || i == shark) { // 상어에게 먹히거나 상어인 경우를 제외함
				continue;
			}

			Fish f = list[i];
			int d = f.d;
			int nx = 0;
			int ny = 0;

			while (true) {
				nx = f.x + dx[d];
				ny = f.y + dy[d];

				if (isOk(nx, ny) && map[nx][ny] != shark) { // 아니면 물고기 이동
					int other = map[nx][ny];
					map[nx][ny] = i;
					map[f.x][f.y] = other;

					if (other != 0) { // 빈공간이 아니면
						list[other].x = f.x;
						list[other].y = f.y;
					}

					list[i].d = d;
					list[i].x = nx;
					list[i].y = ny;
					break;

				} else {
					d++;
					if (d == 8) {
						d = 0;
					}
				}
			}
		}

		// 상어가 움직인다.
		Fish s = list[shark];
		int nx = 0;
		int ny = 0;
		int d = s.d;
		int cnt = 1;
		
		while (true) {
			nx = s.x + (dx[d] * cnt);
			ny = s.y + (dy[d] * cnt);

			if (isOk(nx, ny)) { // 범위 안이면
				if (map[nx][ny] != 0) { // 물고기가 있으면
					
					int[][] temp = new int[4][4];
					Fish[] temp_list = new Fish[17];
					
					for (int i = 0; i < 4; i++) {
						for (int j = 0; j < 4; j++) {
							int num = map[i][j];
							temp[i][j] = num;
						}
					}
					
					for (int i = 1; i < temp_list.length; i++) {
						Fish f = list[i];
						temp_list[i] = new Fish(f.x, f.y, f.d);
					}
					
					temp[s.x][s.y] = 0; // 상어가 있던 자리를 빈칸으로 한다.
					int fish = temp[nx][ny];

					eat[shark] = true;
					dfs(temp, temp_list, fish, sum + fish);
					eat[shark] = false;
				}
			} else {
				break;
			}

			cnt++;
		}
	}

	static boolean isOk(int nx, int ny) {
		if (nx >= 0 && ny >= 0 && nx < 4 && ny < 4) {
			return true;
		} else {
			return false;
		}
	}

	static class Fish {
		int x, y, d;

		public Fish(int x, int y, int d) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
		}

		@Override
		public String toString() {
			return "Fish [x=" + x + ", y=" + y + ", d=" + d + "]";
		}
	}
}
