package DFS;

import java.util.Scanner;

public class Main2250 {
	static node[] arr;
	static int index = 1;
	static int[] levelMin;
	static int[] levelMax;
	static int MaxLevel = 0;
	static int answidth, anslevel;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		levelMin = new int[n + 1];
		levelMax = new int[n + 1];
		int root = 0;
		answidth = 0;
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
		for (int i = 1; i <= MaxLevel; i++) {
			int width = levelMax[i] - levelMin[i] + 1;
			if(answidth < width) {
				answidth = width;
				anslevel = i;
			}
		}
		System.out.println(anslevel+" "+answidth);
	}

	static void dfs(int root, int level) {
		node node = arr[root];

		MaxLevel = Math.max(level, MaxLevel);

		if (node.l != -1) {
			dfs(node.l, level + 1);
		}
		
		levelMin[level] = Math.min((levelMin[level]), index);
		
		levelMax[level] = index++;
		
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
