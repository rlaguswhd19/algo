package baekjoon.DFS;

import java.util.Scanner;

public class Main2250_2 {
	static node[] arr;
	static int point = 1;
	static int[] levelMin;
	static int[] levelMax;
	static int Max = 0;
	static int answ, ansl;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		levelMin = new int[n + 1];
		levelMax = new int[n + 1];
		int root = 0;
		answ = 0;
		arr = new node[n + 1];

		for (int i = 0; i < n; i++) {
			int num = sc.nextInt();
			int l = sc.nextInt();
			int r = sc.nextInt();
			arr[num] = new node(-1, num, r, l);
		}
		for (int i = 1; i <= n; i++) {
			levelMin[i] = n;

			node node = arr[i];
			if (node.r != -1) {
				arr[node.r].parent = node.num;
			}
			if (node.l != -1) {
				arr[node.l].parent = node.num;
			}
		}
		for (int i = 1; i <= n; i++) {
			if (arr[i].parent == -1) {
				root = i;
				break;
			}
		}
		dfs(root, 1);
		for (int i = 1; i <= Max; i++) {
			int width = levelMax[i] - levelMin[i] + 1;
			if (width > answ) {
				answ = width;
				ansl = i;
			}
		}
		System.out.println(ansl + " " + answ);
	}

	static void dfs(int root, int level) {
		node node = arr[root];

		Max = Math.max(level, Max);

		if (node.l != -1) {
			dfs(node.l, level + 1);
		}

		levelMin[level] = Math.min(point, levelMin[level]);

		levelMax[level] = point++;

		if (node.r != -1) {
			dfs(node.r, level + 1);
		}
	}

	static class node {
		int parent, num, r, l;

		public node(int parent, int num, int r, int l) {
			super();
			this.parent = parent;
			this.num = num;
			this.r = r;
			this.l = l;
		}

		@Override
		public String toString() {
			return "node [parent=" + parent + ", num=" + num + ", r=" + r + ", l=" + l + "]";
		}

	}
}
