package SamSungTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main17281 {
	static int n, cnt;
	static int[][] list;
	static boolean[] visit;
	static int[] player;
	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		list = new int[n + 1][10];
		ans = 0;

		StringTokenizer st;

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < 10; j++) {
				list[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visit = new boolean[10];
		visit[1] = true;
		player = new int[10];
		per(1);

		System.out.println(ans);
	}

	static void per(int index) {
		if (index == 4) {
			player[4] = 1;
			per(index + 1);
			return;
		}
		
		if(index == 10) {
			bfs();
			return;
		}

		for (int i = 2; i < 10; i++) {
			if (visit[i]) {
				continue;
			}

			player[index] = i;
			visit[i] = true;
			per(index + 1);
			visit[i] = false;
		}
	}

	static void bfs() {
		Queue<Integer> q = new LinkedList<>();

		int score = 0;
		boolean[] base = new boolean[4];
		int out = 0;
		int index = 0;
		// 이닝 만큼 게임하기 공격만
		for (int i = 1; i <= n; i++) { // 이닝

			// out 초기화
			out = 0;
			// base 초기화
			Arrays.fill(base, false);

			while (out < 3) {

				int num = list[i][player[index]];
				if (index == 8) {
					index = 0;
				} else {
					index++;
				}

				if (num == 0) { // 아웃
					out++;
				} else if (num == 1 || num == 2 || num == 3) { // 1루타
					// 주자 이동 3루수부터 3넘어가면 score++;
					for (int k = 3; k >= 1; k--) {
						if (base[k]) {
							if (k + num >= 4) {
								score++;
								// 자리를 떠난다.
								base[k] = false;
							} else {
								// 자기자리 비우고 넘어가기
								base[k] = false;
								base[k + num] = true;
							}
						}
					}

					base[num] = true;

				} else { // 홈런

					// base에 있는 애들 들어가기 ++
					for (int k = 1; k < base.length; k++) {
						if (base[k]) {
							score++;
						}
					}

					// 자기자신 들어가는것 ++;
					score++;

					// base 초기화
					Arrays.fill(base, false);
				}
			}
		}

		ans = Math.max(ans, score);
	}
}
