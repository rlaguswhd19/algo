package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main5567 {
	static int n, m, ans = 0;
	static boolean[] visit;
	static HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		StringTokenizer st;
		visit = new boolean[n + 1];
		int a, b;

		ArrayList<Integer> temp;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			if (map.containsKey(a)) {
				temp = map.get(a);
			} else {
				temp = new ArrayList<>();
			}

			temp.add(b);
			map.put(a, temp);

			if (map.containsKey(b)) {
				temp = map.get(b);
			} else {
				temp = new ArrayList<>();
			}

			temp.add(a);
			map.put(b, temp);
		}

		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		visit[1] = true;

		int now, next, size, cnt = 0;
		while (cnt < 2) {
			size = q.size();
			for (int t = 0; t < size; t++) {
				now = q.poll();
				// 친구가 없으면 다음
				if (!map.containsKey(now)) {
					continue;
				}

				temp = map.get(now);

				for (int i = 0; i < temp.size(); i++) {
					next = temp.get(i);

					if (visit[next]) {
						continue;
					}

					visit[next] = true;
					ans++;
					q.add(next);
				}
			}

			cnt++;

		}

		System.out.println(ans);
	}
}
