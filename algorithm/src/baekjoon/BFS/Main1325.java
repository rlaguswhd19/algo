package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1325 {
	static ArrayList<Integer>[] arr;
	static int n, m;
	static boolean[] visit;
	static Queue<Integer> q;
	static ArrayList<Integer> ans;
	static int max;
	static int[] distance = new int[10001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new ArrayList[n + 1];

		for (int i = 1; i < n + 1; i++) {
			arr[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
		}

		for (int i = 1; i < n + 1; i++) {
			bfs(i);
		}
		max = 0;
		for (int i = 1; i < n + 1; i++) {
			max = Math.max(max, distance[i]);
		}

		for (int i = 1; i < n + 1; i++) {
			if (distance[i] == max) {
				System.out.print(i + " ");
			}
		}
	}

	static void bfs(int start) {
		q = new LinkedList<>();
		visit = new boolean[n + 1];

		q.add(start);
		visit[start] = true;
		while (!q.isEmpty()) {
			int num = q.poll();
			for (int i = 0; i < arr[num].size(); i++) {
				int next = arr[num].get(i);

				if (!visit[next]) {
					q.add(next);
					visit[next] = true;
					distance[next]++;
				}
			}
		}
	}
}
