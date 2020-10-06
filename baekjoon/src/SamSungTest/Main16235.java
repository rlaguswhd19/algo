package SamSungTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main16235 {
	static int[][] A;
	static int[][] map;
	static int[][] cmap;
	static LinkedList<Integer>[][] group;
	static int n, m, k;
	static int[] dx = { 1, 0, -1, 0, 1, -1, 1, -1 };
	static int[] dy = { 0, 1, 0, -1, 1, -1, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		A = new int[n + 1][n + 1]; // 공급 양분
		map = new int[n + 1][n + 1]; // 현재 양분
		group = new LinkedList[n + 1][n + 1]; // 나무 그룹
		cmap = new int[n + 1][n + 1]; // 번식 갯수

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				group[i][j] = new LinkedList<>();
			}
		}

		for (int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 1; j < n + 1; j++) {
				int num = Integer.parseInt(st.nextToken());
				A[i][j] = num;
				map[i][j] = 5;
			}
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int age = Integer.parseInt(st.nextToken());
			group[x][y].add(age);
		}

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				Collections.sort(group[i][j]);
			}
		}

		for (int z = 0; z < k; z++) {

			// 봄 여름
			for (int i = 1; i < n + 1; i++) {
				for (int j = 1; j < n + 1; j++) {
					LinkedList<Integer> tlist = group[i][j];

					ArrayList<Integer> death = new ArrayList<>();

					int cnt = 0;
					int size = tlist.size();
					for (int k = 0; k < size; k++) {
						int age = tlist.poll();

						if (map[i][j] - age >= 0) {
							map[i][j] -= age;
							tlist.add(age + 1);

							if ((age + 1) % 5 == 0) {
								cnt++;
							}

						} else {
							death.add(age);
						}
					}

					cmap[i][j] = cnt;

					for (int k = 0; k < death.size(); k++) {
						map[i][j] += death.get(k) / 2;
					}
				}
			}

			// 가을 겨울
			for (int i = 1; i < n + 1; i++) {
				for (int j = 1; j < n + 1; j++) {

					// 가을
					int cnt = cmap[i][j];

					for (int k = 0; k < 8; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];

						if (!isOk(nx, ny)) {
							continue;
						}

						for (int l = 0; l < cnt; l++) {
							group[nx][ny].addFirst(1);
						}
					}

					// 겨울
					map[i][j] += A[i][j];
				}
			}
		}

		int ans = 0;
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				ans += group[i][j].size();
			}
		}

		System.out.println(ans);
	}

	static boolean isOk(int nx, int ny) {
		if (nx >= 1 && ny >= 1 && nx < n + 1 && ny < n + 1) {
			return true;
		} else {
			return false;
		}
	}
}