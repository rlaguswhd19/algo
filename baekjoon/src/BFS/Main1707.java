package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1707 {
	static int v, e;
	static ArrayList<Integer>[] arr;
	static int[] color;
	static Queue<Integer> q;
	static boolean isOk;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			isOk = true;

			color = new int[v + 1];
			arr = new ArrayList[v + 1];

			for (int i = 1; i < v + 1; i++) {
				arr[i] = new ArrayList<>();
			}

			for (int i = 0; i < e; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				arr[a].add(b);
				arr[b].add(a);
			}

			for (int i = 1; i < v + 1; i++) {
				if (color[i] == 0) {
					bfs(i);
				}
			}
			if (isOk) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}

	static void bfs(int start) {
		q = new LinkedList<>();

		q.add(start);
		color[start] = 1;
		int c = 1;

		while (!q.isEmpty()) {
			if (c > 0) {
				c -= 2;
			} else {
				c += 2;
			}

			int size = q.size();
			for (int i = 0; i < size; i++) {
				int num = q.poll();
				for (int j = 0; j < arr[num].size(); j++) {
					int next = arr[num].get(j);
					if (color[next] == 0) {
						q.add(next);
						color[next] = c;
					} else {
						if (color[next] != c) {
							isOk = false;
							return;
						}
					}
				}
			}
		}
	}
}
