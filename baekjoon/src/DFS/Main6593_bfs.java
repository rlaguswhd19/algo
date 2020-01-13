package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main6593_bfs {
	static char[][][] arr;
	static boolean[][][] visit;
	static int ans, L, R, C;
	static int[] a = { 1, 0, 0, -1, 0, 0 };
	static int[] b = { 0, 1, 0, 0, -1, 0 };
	static int[] c = { 0, 0, 1, 0, 0, -1 };
	static point start, end;
	static Queue<point> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				L = Integer.parseInt(st.nextToken());
				R = Integer.parseInt(st.nextToken());
				C = Integer.parseInt(st.nextToken());
			}

			if (L == 0 && R == 0 && C == 0) {
				break;
			}

			arr = new char[L][R][C];
			visit = new boolean[L][R][C];
			q = new LinkedList<>();
			ans = 0;
			for (int i = 0; i < L; i++) {
				for (int j = 0; j <= R; j++) {
					String s = br.readLine();
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
			q.add(new point(start.L, start.R, start.C));

			bfs(0);

			if (ans == 0) {
				System.out.println("Trapped!");
			} else {
				System.out.println("Escaped in " + ans + " minute(s).");
			}
		}
	}

	static void print(int L, int R, int C) {
		for (int i = 0; i < L; i++) {
			for (int j = 0; j < R; j++) {
				for (int j2 = 0; j2 < C; j2++) {
					System.out.print(arr[i][j][j2]);
				}
				System.out.println();
			}
			System.out.println();
		}
	}

	static void bfs(int x) {
		int size = q.size();
		if (size == 0) {
			return;
		}

		for (int j = 0; j < size; j++) {
			point p = q.poll();
			for (int i = 0; i < 6; i++) {
				if (p.L + a[i] >= 0 && p.L + a[i] < L && p.R + b[i] >= 0 && p.R + b[i] < R && p.C + c[i] >= 0
						&& p.C + c[i] < C) {
					if (!visit[p.L + a[i]][p.R + b[i]][p.C + c[i]] && (arr[p.L + a[i]][p.R + b[i]][p.C + c[i]] == '.'
							|| arr[p.L + a[i]][p.R + b[i]][p.C + c[i]] == 'E')) {

						if (arr[p.L + a[i]][p.R + b[i]][p.C + c[i]] == 'E') {
							ans = x+1;
							return;
						}

						q.add(new point(p.L + a[i], p.R + b[i], p.C + c[i]));
						visit[p.L + a[i]][p.R + b[i]][p.C + c[i]] = true;
					}
				}
			}
		}

		bfs(x + 1);
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
