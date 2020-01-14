package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main5719_5 {
	static int[][] arr;
	static int start, end, n;
	static boolean[] visit;
	static ArrayList<load> ans;
	static int result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			n = sc.nextInt();
			visit = new boolean[n];
			ans = new ArrayList<>();
			result = Integer.MAX_VALUE;
			
			int m = sc.nextInt();
			if (n == 0 && m == 0) {
				break;
			}

			arr = new int[n][n];
			start = sc.nextInt();
			end = sc.nextInt();

			for (int i = 0; i < m; i++) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				int p = sc.nextInt();
				arr[u][v] = p;
			}
			ArrayList<Integer> list = new ArrayList<>();
			list.add(0);
			dfs(start, 0, list);
			
			Collections.sort(ans, new Comparator<load>() {
				@Override
				public int compare(load l1, load l2) {
					if (l1.sum > l2.sum) {
						return 1;
					} else {
						return -1;
					}
				}
			});
			
			int min = ans.get(0).sum;
			for (int i = 0; i < ans.size(); i++) {
				load load = ans.get(i);
				if(min == load.sum) {
					for (int j = 0; j < load.v.size()-1; j++) {
						arr[load.v.get(j)][load.v.get(j+1)] = 0;
					}
				}else {
					break;
				}
			}
			ans = new ArrayList<>();
			dfs2(start, 0);
			if(result == Integer.MAX_VALUE) {
				System.out.println(-1);
			}else {
				System.out.println(result);
			}
		}
	}

	static void dfs(int now, int sum, ArrayList<Integer> list) {
		visit[now] = true;
		if (now == end) {
			ArrayList<Integer> temp = new ArrayList<>();
			for (int i = 0; i < list.size(); i++) {
				temp.add(list.get(i));
			}
			ans.add(new load(sum, temp));
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!visit[i] && arr[now][i] != 0) {
				list.add(i);
				dfs(i, sum + arr[now][i], list);
				list.remove(list.size() - 1);
				visit[i] = false;
			}
		}
	}
	static void dfs2(int now, int sum) {
		if(result != Integer.MAX_VALUE) {
			return;
		}
		visit[now] = true;
		if (now == end) {
			result = Math.min(result, sum);
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!visit[i] && arr[now][i] != 0) {
				dfs2(i, sum + arr[now][i]);
				visit[i] = false;
			}
		}
	}
	static class load {
		int sum;
		ArrayList<Integer> v;

		public load(int sum, ArrayList<Integer> v) {
			super();
			this.sum = sum;
			this.v = v;
		}

		@Override
		public String toString() {
			return "load [sum=" + sum + ", v=" + v + "]";
		}
	}
}
