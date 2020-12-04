package swexpert.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution8888_시험 {
	static int[][] map;
	static int[] score;
	static int[] ans;
	static User[] users;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());

			map = new int[n + 1][t + 1];
			score = new int[t + 1]; // 문제의 점수
			ans = new int[n + 1]; // 맞힌갯수
			users = new User[n + 1];

			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine());

				for (int j = 1; j <= t; j++) {
					int num = Integer.parseInt(st.nextToken());

					map[i][j] = num;

					if (num == 0) { // 문제에 대한 점수를 올리고
						score[j]++;
					} else { // 몇개를 풀었는지 점수를 올린다.
						ans[i]++;
					}
				}
			}

			for (int i = 1; i <= n; i++) { // 참가자
				int sum = 0;
				for (int j = 1; j <= t; j++) { // 문제
					if (map[i][j] == 1) {
						sum += score[j];
					}
				}

				users[i] = new User(i, sum); // 자신의 번호와 점수
			}

			Arrays.sort(users, new Comparator<User>() {

				@Override
				public int compare(User u1, User u2) {
					if (u1 == null || u2 == null) {
						return 1;
					}

					if (u1.score < u2.score) {
						return -1;
					} else if (u1.score > u2.score) {
						return 1;
					} else { // 같은경우
						if (ans[u1.index] < ans[u2.index]) {
							return -1;
						} else if (ans[u1.index] > ans[u2.index]) {
							return 1;
						} else {
							if (u1.index < u2.index) {
								return -1;
							} else {
								return 1;
							}
						}
					}
				}
			});

			System.out.println(Arrays.toString(users));

			for (int i = 1; i <= n; i++) {
				// 자신보다 많은 점수
				int a = n - i;

				// 자신과 같은문제 획득 더많은 문제를 푼 참가자의 수
				int b = 0;
				
				int c = 0;
				
				for (int j = i + 1; j <= n; j++) {
					if (users[i].score == users[j].score) {
						if(ans[users[i].index] < ans[users[j].index]) {
							
						}
					} else {
						break;
					}
				}
			}
		}
	}

	static class User {
		int index, score;

		public User(int index, int score) {
			super();
			this.index = index;
			this.score = score;
		}

		@Override
		public String toString() {
			return "User [index=" + index + ", score=" + score + "]";
		}
	}
}
