package baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main11559 {
	static char[][] arr;
	static boolean[][] visit;
	static int ans;
	static int[] a = { -1, 0, 1, 0 };
	static int[] b = { 0, 1, 0, -1 };
	static ArrayList<point> plist;
	static boolean stop;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new char[12][6];
		ans = 0;
		// down할때 쓸 리스트 만들기

		for (int i = 0; i < 12; i++) {
			String s = sc.nextLine();
			for (int j = 0; j < s.length(); j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		start();
		System.out.println(ans);
	}

	static void start() {
		// 초기화
		visit = new boolean[12][6];
		stop = false;
		// check하자구
		for (int i = 11; i >= 0; i--) {
			check(i);
		}
		if (!stop) {
			return;
		}else {
			ans++;
		}

		for (int i = 11; i >= 0; i--) {
			for (int j = 0; j < 6; j++) {
				if(arr[i][j] != '.') {
					down(i, j);
				}
			}
		}
		for (int i = 0; i < 12; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		start();
	}

	static void down(int i, int j) {
		if (i + 1 <= 11 && arr[i + 1][j] == '.') {
			char temp = arr[i][j];
			arr[i][j] = '.';
			arr[i + 1][j] = temp;
			down(i+1, j);
		}
	}

	static void check(int r) {
		boolean isOk = false;

		for (int i = 0; i < 6; i++) {
			if (arr[r][i] != '.') {
				isOk = true;
				if (!visit[r][i]) { // 안갔던거면
					plist = new ArrayList<>();
					plist.add(new point(r, i));
					dfs(r, i, arr[r][i]);

					if (plist.size() >= 4) {
						stop = true;
						System.out.println("plist 사이즈 :" +plist.size());
						for (int j = 0; j < plist.size(); j++) {
							point p = plist.get(j);
							arr[p.i][p.j] = '.';
						}
					}
				}
			}
		}
		// 한줄이 .이면 끝내기
		if (!isOk) {
			return;
		}
	}

	static void dfs(int r, int c, char first) {
		System.out.println(r + " " + c);
		visit[r][c] = true;

		for (int i = 0; i < 4; i++) {
			// 범위 안인지 체크
			if (r + a[i] >= 0 && r + a[i] < 12 && c + b[i] >= 0 && c + b[i] < 6) {
				if (!visit[r + a[i]][c + b[i]] && arr[r + a[i]][c + b[i]] == first) {
					plist.add(new point(r + a[i], c + b[i]));
					dfs(r + a[i], c + b[i], first);
				}
			}
		}
	}

	static class point {
		int i, j;

		public point(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}

		@Override
		public String toString() {
			return "point [i=" + i + ", j=" + j + "]";
		}

	}
}
