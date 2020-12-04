package baekjoon.Avatar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main11725 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		ArrayList<Integer>[] tree = new ArrayList[n + 1];

		for (int i = 0; i < tree.length; i++) {
			tree[i] = new ArrayList<>();
		}

		int[] parent = new int[n + 1];

		for (int i = 1; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			tree[p].add(c);
			tree[c].add(p);
		}

		Queue<Integer> q = new LinkedList<>();

		q.add(1);
		parent[1] = 1;

		while (!q.isEmpty()) {
			int now = q.poll();

			for (int next : tree[now]) {
				if (parent[next] != 0) {
					continue;
				}

				q.add(next);
				parent[next] = now;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 2; i < n + 1; i++) {
			sb.append(parent[i]+"\n");
		}
		
		System.out.println(sb.toString());
	}
}
