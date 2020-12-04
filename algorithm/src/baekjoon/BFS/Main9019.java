package baekjoon.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main9019 {
	static int s, e;
	static Queue<Num> q;
	static boolean[] visit;
	static String[] list = { "D", "S", "L", "R" };
	static boolean find;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int tc = 0; tc < t; tc++) {
			s = sc.nextInt();
			e = sc.nextInt();

			visit = new boolean[10000];
			find = false;

			dfs();
		}

	}

	static void dfs() {
		q = new LinkedList<>();

		q.add(new Num(s, ""));
		visit[s] = true;

		while (!q.isEmpty()) {
			Num num = q.poll();

			for (int j = 0; j < 4; j++) {
				change(list[j], num);
				if (find) {
					return;
				}
			}
		}
	}

	static void change(String s, Num num) {
		int n = num.num;
		String ans = num.ans;
		switch (s) {
		case "D":
			n *= 2;

			if (n > 9999) {
				n %= 10000;
			}
			break;
		case "S":
			if (n == 0) {
				n = 9999;
			} else {
				n -= 1;
			}
			break;
		case "L":
			n = (n % 1000) * 10 + n / 1000;
			break;
		case "R":
			n = (n % 10) * 1000 + n / 10;
			break;
		}

		if (n == e) {
			find = true;
			System.out.println(ans + s);
			return;
		}

		if (!visit[n]) {
			visit[n] = true;
			q.add(new Num(n, ans + s));
		}
	}

	static class Num {
		int num;
		String ans;

		public Num(int num, String ans) {
			super();
			this.num = num;
			this.ans = ans;
		}

		@Override
		public String toString() {
			return "Num [num=" + num + ", ans=" + ans + "]";
		}
	}
}
