package DFS;

import java.util.Scanner;

public class Main9466 {
	static int[] arr;
	static boolean[] visit;
	static boolean[] cycle;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			ans = 0;
			int n = sc.nextInt();
			arr = new int[n + 1];
			visit = new boolean[n + 1];
			cycle = new boolean[n + 1];

			for (int i = 1; i < n + 1; i++) {
				arr[i] = sc.nextInt();
			}

			for (int i = 1; i < n + 1; i++) {
				dfs(i);
			}
			System.out.println(n - ans);
		}
	}

	static void dfs(int i) {
		if (visit[i]) {
			return;
		}

		visit[i] = true;

		if (!visit[arr[i]]) {
			dfs(arr[i]);
		} else {
			if (!cycle[arr[i]]) {
				ans++;
				for (int next = arr[i]; next != i; next = arr[next]) {
					ans++;
				}
			}
		}
		cycle[i] = true;
	}
}
