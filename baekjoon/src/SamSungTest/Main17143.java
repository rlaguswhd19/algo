package SamSungTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main17143 {
	static int r, c, m, ans;
	static int[][] map;
	static Shark[] slist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		slist = new Shark[m + 1];
		map = new int[r][c];

		for (int i = 1; i < m + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()); // r
			int y = Integer.parseInt(st.nextToken()); // c
			int s = Integer.parseInt(st.nextToken()); // 속력
			int d = Integer.parseInt(st.nextToken()); // 방향
			int z = Integer.parseInt(st.nextToken()); // 크기
			slist[i] = new Shark(s, d, z);
			map[x - 1][y - 1] = i;
		}

		for (int a = 0; a < c; a++) {
			fishing(a);
			move();
		}

		System.out.println(ans);
	}

	static void move() {
		int[][] temp = new int[r][c];

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				int num = map[i][j];
				if (num == 0) {
					continue;
				}

				Shark shark = slist[num];

				int dir = shark.d;
				int speed = shark.s;
				int nx = i;
				int ny = j;
				
				if (dir == 1 || dir == 2) {
					if (dir == 1) {
						speed -= i;
						
						if(speed > 0) { // 끝까지 갔는데 남았으면 바꾸기
							dir = 2;
						}
						
					} else {
						speed -= r - 1 - i;
						
						if(speed > 0) { 
							dir = 1;
						}
					}

					while (speed > 0) {
						// 한줄씩 이동
						speed -= r - 1;

						if (speed <= 0) {
							break;
						}
						// 방향 전환
						if (dir == 1) {
							dir = 2;
						} else {
							dir = 1;
						}

					}

					if (dir == 1) {
						nx = 0 - speed;
					} else {
						nx = r - 1 + speed;
					}
				} else {
					if (dir == 3) {
						speed -= c - 1 - j;
						
						if(speed > 0) {
							dir = 4;
						}
					} else {
						speed -= j;
						
						if(speed > 0) {
							dir = 3;
						}
					}
					
					while (speed > 0) {
						speed -= c - 1;

						if (speed <= 0) {
							break;
						}

						if (dir == 3) {
							dir = 4;
						} else {
							dir = 3;
						}
					}

					if (dir == 3) {
						ny = c - 1 + speed;
					} else {
						ny = 0 - speed;
					}
				}

				// 방향 변경
				shark.d = dir;
				// 위치 변경
				if (temp[nx][ny] != 0) {
					Shark s1 = slist[temp[nx][ny]]; // 원래 있던놈
					Shark s2 = slist[num]; // 새로 온놈

					int big = 0;
					if (s1.z > s2.z) {
						big = temp[nx][ny];
					} else {
						big = num;
					}

					temp[nx][ny] = big;
				} else {
					temp[nx][ny] = num;
				}
				
			}
		}

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				map[i][j] = temp[i][j];
			}
		}
	}

	static void fishing(int j) {
		// 상어 잡기
		for (int i = 0; i < r; i++) {
			if (map[i][j] != 0) {
				ans += slist[map[i][j]].z;
				map[i][j] = 0;
				return;
			}
		}
	}

	static class Shark {
		int s, d, z;

		public Shark(int s, int d, int z) {
			super();
			this.s = s;
			this.d = d;
			this.z = z;
		}

		@Override
		public String toString() {
			return "Shark [s=" + s + ", d=" + d + ", z=" + z + "]";
		}
	}
}
