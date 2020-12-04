package baekjoon.SamSungTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14890 {
	static int n, l, num;
	static int[][] map;
	static boolean[][] visit;
	static int ans = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visit = new boolean[n][n];
		for (int i = 0; i < n; i++) { // 오른쪽
			down(0, i, map[0][i]);
		}

		visit = new boolean[n][n];
		for (int i = 0; i < n; i++) { // 아래
			right(i, 0, map[i][0]);
		}

		System.out.println(ans);
	}

	static void right(int x, int y, int num) {
		if (y == n - 1) {
			ans++;
			return;
		}

		int next = map[x][y + 1];

		if (next == num) { // 숫자가 같아
			right(x, y + 1, num);
		} else { // 숫자가 달라
			if (Math.abs(next - num) == 1) { // 1차이야?
				if (next > num) { // num보다 next가 크면

					for (int i = 0; i < l; i++) {
						if (!isRange(x, y - i)) {
							return;
						}

						if (visit[x][y - i]) { // 경사로가 설치되어있네?
							return;
						}

						if (map[x][y - i] != num) { // 경사로 설치 불가능 그럼 못가지
							return;
						}
					}

					for (int i = 0; i < l; i++) { // 경사로 설치했다.
						visit[x][y - i] = true;
					}

					right(x, y + 1, next);

				} else { // next 보다 num이 더 크면

					for (int i = 0; i < l; i++) {
						if (!isRange(x, y + 1 + i)) {
							return;
						}

						if (visit[x][y + 1 + i]) { // 경사로가 설치되어 있네?
							return;
						}

						if (map[x][y + 1 + i] != next) {
							return;
						}
					}

					for (int i = 0; i < l; i++) {
						visit[x][y + 1 + i] = true;
					}

					right(x, y + l, next);
				}
			} else { // 1넘게 차이나면 경사로 x
				return;
			}
		}
	}

	static void down(int x, int y, int num) {
		if (x == n - 1) {
			ans++;
			return;
		}

		int next = map[x + 1][y];

		if (next == num) { // 숫자가 같아
			down(x + 1, y, num);
		} else { // 숫자가 달라
			if (Math.abs(next - num) == 1) { // 1차이야?
				if (next > num) { // num보다 next가 크면

					for (int i = 0; i < l; i++) {
						if (!isRange(x - i, y)) {
							return;
						}

						if (visit[x - i][y]) { // 경사로가 설치되어있네?
							return;
						}

						if (map[x - i][y] != num) { // 경사로 설치 불가능 그럼 못가지
							return;
						}
					}

					for (int i = 0; i < l; i++) { // 경사로 설치했다.
						visit[x - i][y] = true;
					}

					down(x + 1, y, next);

				} else { // next 보다 num이 더 크면

					for (int i = 0; i < l; i++) {
						if (!isRange(x + 1 + i, y)) {
							return;
						}

						if (visit[x + 1 + i][y]) { // 경사로가 설치되어 있네?
							return;
						}

						if (map[x + 1 + i][y] != next) {
							return;
						}
					}

					for (int i = 0; i < l; i++) {
						visit[x + 1 + i][y] = true;
					}

					down(x + l, y, next);
				}
			} else { // 1넘게 차이나면 경사로 x
				return;
			}
		}
	}

	static boolean isRange(int x, int y) {
		if (x >= 0 && y >= 0 && x < n && y < n) {
			return true;
		} else {
			return false;
		}
	}
}
