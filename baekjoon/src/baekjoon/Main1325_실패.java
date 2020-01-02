package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class Main1325_실패 {
	static int[][] arr;
	static boolean[] visit;
	static int n, m, sum, max;
	static ArrayList<point> ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		ans = new ArrayList<>();
		arr = new int[n + 1][n + 1];
		max = 0;
		
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[b][a] = 1;
		}
		
		for (int i = 1; i < n+1; i++) {
			visit = new boolean[n + 1];
			sum = 0;
			dfs(i);
			ans.add(new point(i, sum));
			max = Math.max(sum, max);
		}
		for (int i = 0; i < ans.size(); i++) {
			point p = ans.get(i);
			if(p.sum == max) {
				System.out.println(p.num);
			}else {
				break;
			}
		}
	}
	static void dfs(int i) {
		visit[i] = true;
		for (int j = 1; j < n+1; j++) {
			if(arr[i][j] == 1 && !visit[j]) {
				sum++;
				dfs(j);
			}
		}
	}
	static class point{
		int num, sum;

		public point(int num, int sum) {
			super();
			this.num = num;
			this.sum = sum;
		}

		@Override
		public String toString() {
			return "point [num=" + num + ", sum=" + sum + "]";
		}
		
	}
}