package baekjoon.DFS;

import java.util.Scanner;

public class Main6593_dfs {
	static char[][][] arr;
	static boolean[][][] visit;
	static int ans, L, R, C;
	static int[] a = { 1, 0, 0, -1, 0, 0 };
	static int[] b = { 0, 1, 0, 0, -1, 0 };
	static int[] c = { 0, 0, 1, 0, 0, -1 };
	static point start, end;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			L = sc.nextInt();
			R = sc.nextInt();
			C = sc.nextInt();
			ans = Integer.MAX_VALUE;

			if (L == 0 && R == 0 && C == 0) {
				break;
			}

			arr = new char[L][R][C];
			visit = new boolean[L][R][C];
			sc.nextLine();

			for (int i = 0; i < L; i++) {
				for (int j = 0; j <= R; j++) {
					String s = sc.nextLine();
					if (s.equals("")) {
						break;
					} else {
						for (int k = 0; k < s.length(); k++) {
							arr[i][j][k] = s.charAt(k);
							if (s.charAt(k) == 'S') {
								start = new point(i, j, k);
							} else if (s.charAt(k) == 'E') {
								end = new point(i, j, k);
							}
						}
					}
				}
			}
			
			System.out.println(start);
			System.out.println(end);

			dfs(start.L, start.R, start.C, 0);
			if (ans == Integer.MAX_VALUE) {
				System.out.println("Trapped!");
			} else {
				System.out.println("Escaped in" + ans + " minute(s).");
			}
			System.out.println(ans);
			print(L, R, C);
		}
	}

	static void print(int L, int R, int C) {
		for (int i = 0; i < L; i++) {
			for (int j = 0; j < R; j++) {
				for (int j2 = 0; j2 < C; j2++) {
					System.out.print(visit[i][j][j2]);
				}
				System.out.println();
			}System.out.println();
		}
	}

	static void dfs(int nowL, int nowR, int nowC, int x) {
		System.out.println(nowL + " " + nowR + " " + nowC);
		if (end.L == nowL && end.R == nowR && end.C == nowC) {
			System.out.println("끝");
			ans = Math.min(ans, x);
			return;
		}
		
		visit[nowL][nowR][nowC] = true;

		for (int i = 0; i < 6; i++) {
			if (nowL + a[i] >= 0 && nowL + a[i] < L && nowR + b[i] >= 0 && nowR + b[i] < R && nowC + c[i] >= 0
					&& nowC + c[i] < C) {
				if (!visit[nowL + a[i]][nowR + b[i]][nowC + c[i]] && (arr[nowL + a[i]][nowR + b[i]][nowC + c[i]] == '.'
						|| arr[nowL + a[i]][nowR + b[i]][nowC + c[i]] == 'E')) {
					dfs(nowL + a[i], nowR + b[i], nowC + c[i], x + 1);
				}
			}
		}
		
		visit[nowL][nowR][nowC] = false;
	}

	static class point {
		int L, R, C;

		public point(int l, int r, int c) {
			super();
			L = l;
			R = r;
			C = c;
		}

		@Override
		public String toString() {
			return "point [L=" + L + ", R=" + R + ", C=" + C + "]";
		}
	}
}
